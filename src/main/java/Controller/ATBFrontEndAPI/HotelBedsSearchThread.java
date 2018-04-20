package Controller.ATBFrontEndAPI;

import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsCancelationPolicy;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomMealResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomTypeWithRoomsResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.SunHotelsResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.SunHotelsSearchPOST;
import Beans.ATBDBBeans.KalitaonHotel.*;
import Beans.HotelBedsAPIBeans.Availability.*;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.HotelDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.HotelmappingDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.MealDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.RoomtypeDAO;
import DAOs.HotelBedsAPIDAOs.AvailabilityDAOs;
import org.hibernate.StatelessSession;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.hotelBedsProviderId;
import static java.math.RoundingMode.HALF_UP;

/**
 * Created by George on 21/03/2018.
 */
public class HotelBedsSearchThread  implements Runnable {

        private DestinationBean destinationBean=null;
        private String[] childrenAgesSplit=null;
        private SunHotelsSearchPOST params;
        private StatelessSession session;
        private CountDownLatch latch;
        private ProvidersSearchRequestResponse hotelBedsSearchRequestResponse = null;
        private ZonedDateTime checkin;
        private ZonedDateTime  checkout;

        public ProvidersSearchRequestResponse getHotelBedsSearchRequestResponse() {
            return hotelBedsSearchRequestResponse;
        }

        public void setHotelBedsSearchRequestResponse(ProvidersSearchRequestResponse hotelBedsSearchRequestResponse) {
            this.hotelBedsSearchRequestResponse = hotelBedsSearchRequestResponse;
        }

        public HotelBedsSearchThread(DestinationBean destinationBean,
                                     String[] childrenAgesSplit,
                                     ZonedDateTime checkout,
                                     ZonedDateTime checkin,
                                     StatelessSession session,
                                     SunHotelsSearchPOST params,
                                     CountDownLatch latch){

            super();
            this.childrenAgesSplit=childrenAgesSplit;
            this.destinationBean=destinationBean;
            this.session=session;
            this.params=params;
            this.latch=latch;
            this.checkin=checkin;
            this.checkout=checkout;
            hotelBedsSearchRequestResponse=new ProvidersSearchRequestResponse();
        }

        public void run() {
            try {
                if ((destinationBean != null && destinationBean.getHotelBedsCode() != null && destinationBean.getHotelBedsCode().equals("BRU")) ||
                        (params.getHotelID() != null && !params.getHotelID().equals(""))) {

                    long dbTransactionTimeElapsed = 0;
                    long prepareResponseTimeElapsed = 0;
                    long requestTimeElapsed = 0;
                    List<SunHotelsResponse> hotelsResponse = new ArrayList<>();
                    AvailabilityPOST availabilityPOST = new AvailabilityPOST();

                    Stay stay = new Stay();
                    stay.setCheckIn(params.getCheckInDate());
                    stay.setCheckOut(params.getCheckOutDate());
                    stay.setShiftDays("1");
                    availabilityPOST.setStay(stay);
                    Occupancy occupancy = new Occupancy();
                    List<Occupancy> occupancies = new ArrayList<>();
                    occupancy.setAdults(params.getNumberOfAdults());
                    occupancy.setChildren(params.getNumberOfChildren());
                    occupancy.setRooms(params.getNumberOfRooms());
                    List<Pax> paxes = new ArrayList<>();
                    if (childrenAgesSplit != null && childrenAgesSplit.length > 0) {
                        for (String age : childrenAgesSplit) {
                            if (age != null && !age.equals("0") && !age.equals("")) {
                                Pax pax = new Pax();
                                pax.setAge(Integer.parseInt(age));
                                pax.setType("CH");
                                paxes.add(pax);
                            }
                        }
                    }
                    occupancy.setPaxes(paxes);
                    occupancies.add(occupancy);
                    availabilityPOST.setOccupancies(occupancies);
                    Filter filter = new Filter();
                    filter.setMaxRate(params.getMaxPrice());
                    filter.setMinRate(params.getMinPrice());
                    availabilityPOST.setFilter(filter);
                    List<HotelBean> hotelBeans = null;
                    HotelPost hotels = new HotelPost();
                    List<Integer> hs = new ArrayList<>();
                    if ((destinationBean != null && destinationBean.getHotelBedsCode() != null && !destinationBean.getHotelBedsCode().equals(""))) {
                        hotelBeans = HotelDAO.getHotelByDestId(destinationBean.getHotelBedsCode(), hotelBedsProviderId);
                        if (hotelBeans != null) {
                            for (HotelBean hotel : hotelBeans)
                                hs.add(hotel.getHotelId());
                        }
                    } else if (params.getHotelID() != null && !params.getHotelID().equals("") && params.getProviderId() == hotelBedsProviderId)
                        hs.add(Integer.parseInt(params.getHotelID()));

                    if (hs.size() > 0) {
                        hotels.setHotel(hs);
                        availabilityPOST.setHotels(hotels);

                        requestTimeElapsed = System.currentTimeMillis();
                        AvailabilityAPIJSON availabilityAPIJSON = AvailabilityDAOs.availability(availabilityPOST);
                        requestTimeElapsed = System.currentTimeMillis() - requestTimeElapsed;
                        if (availabilityAPIJSON != null && availabilityAPIJSON.getError() == null) {

                            List<SunHotelsRoomTypeWithRoomsResponse> roomTypesWithRoomsResponse;
                            List<SunHotelsRoomResponse> roomsResponse;
                            List<SunHotelsRoomMealResponse> roomMealsResponse;
                            SunHotelsRoomTypeWithRoomsResponse roomTypeWithRoomsResponse;
                            SunHotelsRoomResponse roomResponse;
                            List<SunHotelsCancelationPolicy> cancelationPolicies;
                            SunHotelsRoomMealResponse roomMealResponse;
                            SunHotelsCancelationPolicy cancelationPolicy;
                            SunHotelsResponse hotelResponse;

                            /**
                             * Get content from DB
                             */
                            dbTransactionTimeElapsed = System.currentTimeMillis();
                            List<RoomtypeBean> atbRoomTypes = RoomtypeDAO.getRoomsTypes(hotelBedsProviderId);
                            List<MealBean> meals = MealDAO.getMeals(hotelBedsProviderId);
                            List<HotelBean> atbhotels = null;
                            atbhotels = hotelBeans;
                            List<HotelmappingBean> hotelsmapping = HotelmappingDAO.getAllProviderHotelsMapping(hotelBedsProviderId);
                            dbTransactionTimeElapsed = System.currentTimeMillis() - dbTransactionTimeElapsed;

                            /**
                             * Prepare the response data.
                             */
                            prepareResponseTimeElapsed = System.currentTimeMillis();
                            if (hotelsmapping != null && atbRoomTypes != null & meals != null) {
                                if (availabilityAPIJSON.getHotels() != null && availabilityAPIJSON.getHotels().getHotels() != null) {
                                    for (Beans.HotelBedsAPIBeans.Availability.Hotel hotel : availabilityAPIJSON.getHotels().getHotels()) {

                                        if (hotelBeans == null)
                                            atbhotels = HotelDAO.getHotelByHotelId(hotel.getCode(), hotelBedsProviderId, session);
                                        if (atbhotels != null) {
                                            for (HotelBean atbhotel : atbhotels) {
                                                if (atbhotel.getHotelId() == hotel.getCode()) {
                                                    boolean hotelHasPrices = false;
                                                    int atbHotelId = 0;
                                                    for (HotelmappingBean hotelmapping : hotelsmapping) {
                                                        if (atbhotel.getHotelId() == hotelmapping.getHotelId())
                                                            atbHotelId = hotelmapping.getId();
                                                    }

                                                    if (atbHotelId != 0) {
                                                        hotelResponse = new SunHotelsResponse();
                                                        hotelResponse.setAddress(atbhotel.getAddress());
                                                        hotelResponse.setCity(atbhotel.getCity());
                                                        hotelResponse.setCountry(atbhotel.getCountry());
                                                        hotelResponse.setDescription(atbhotel.getDescription());
                                                        hotelResponse.setDistrict(atbhotel.getCity());
                                                        hotelResponse.setId(atbHotelId);
                                                        hotelResponse.setLatitude(atbhotel.getLatitude());
                                                        hotelResponse.setLongitude(atbhotel.getLongitude());
                                                        hotelResponse.setName(atbhotel.getName() + ".");
                                                        hotelResponse.setStar_rating(atbhotel.getStarRating());
                                                        hotelResponse.setState(atbhotel.getState());
                                                        hotelResponse.setZip_code(atbhotel.getZipCode());
                                                        hotelResponse.setCountry_code(atbhotel.getCountryCode());
                                                        hotelResponse.setType(atbhotel.getAccommodationName());
                                                        hotelResponse.setProviderId(hotelBedsProviderId);

                                                        roomTypesWithRoomsResponse = new ArrayList<>();
                                                        for (Beans.HotelBedsAPIBeans.Availability.Room room : hotel.getRooms()) {
                                                            roomsResponse = new ArrayList<>();
                                                            for (Rate rate : room.getRates()) {
                                                                roomResponse = new SunHotelsRoomResponse();
                                                                roomResponse.setRoomId(1);
                                                                roomResponse.setBeds(0);
                                                                roomResponse.setExtrabeds(0);


                                                                cancelationPolicies = new ArrayList<>();
                                                                if (rate.getCancellationPolicies() != null) {
                                                                    for (CancellationPolicy policy : rate.getCancellationPolicies()) {//todo fix cancelation policies,ask about roomtypes codes whichare not comming all,ask about currency
                                                                        BigDecimal percentange = new BigDecimal((Double.parseDouble(policy.getAmount()) * 100) / Double.parseDouble(rate.getNet())).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                                        cancelationPolicy = new SunHotelsCancelationPolicy();
                                                                        cancelationPolicy.setPercentage(percentange);

                                                                        ZonedDateTime cancelationDate = null;
                                                                        String str[] = policy.getFrom().split("T");
                                                                        if (str != null && str.length > 0) {
                                                                            String strCancelationDate[] = str[0].split("-");
                                                                            if (strCancelationDate.length == 3) {
                                                                                try {
                                                                                    cancelationDate = ZonedDateTime.of(LocalDate.of(Integer.parseInt(strCancelationDate[0]), Integer.parseInt(strCancelationDate[1]), Integer.parseInt(strCancelationDate[2])),
                                                                                            LocalTime.of(9, 30), ZoneId.of("America/New_York"));

                                                                                    ZonedDateTime date = ZonedDateTime.now(ZoneId.systemDefault());
                                                                                    System.out.println("sssd " + strCancelationDate[0] + "  " + date.getYear() + "  " + strCancelationDate[1] + "  " + date.getMonth() + "  " + strCancelationDate[2] + "  " + date.getDayOfMonth());
                                                                                    if (strCancelationDate[0].equals(date.getYear()) && strCancelationDate[1].equals(date.getMonth()) && strCancelationDate[2].equals(date.getDayOfMonth())) {
                                                                                        cancelationPolicy.setDeadline(0);
                                                                                        System.out.println("empeneeeeee ");
                                                                                    } else
                                                                                        cancelationPolicy.setDeadline((int) Duration.between(cancelationDate, checkin).getSeconds() / 60 / 60);
                                                                                    cancelationPolicies.add(cancelationPolicy);
                                                                                } catch (NumberFormatException e) {
                                                                                    e.printStackTrace();
                                                                                }
                                                                            } else {
                                                                                cancelationPolicies.add(cancelationPolicy);
                                                                            }
                                                                        } else {
                                                                            cancelationPolicies.add(cancelationPolicy);
                                                                        }
                                                                    }
                                                                }
                                                                roomResponse.setCancellationPolicies(cancelationPolicies);


                                                                roomMealsResponse = new ArrayList<>();
                                                                for (MealBean m : meals) {
                                                                    if (rate.getBoardCode().equals(m.getMealId())) {
                                                                        roomMealResponse = new SunHotelsRoomMealResponse();
                                                                        roomMealResponse.setMealId(m.getId());
                                                                        roomMealResponse.setMealName(m.getName());
                                                                        if (rate.getNet() != null)
                                                                            roomMealResponse.setPrice(new BigDecimal(Double.parseDouble(rate.getNet())).setScale(2, BigDecimal.ROUND_HALF_UP));
                                                                        if (roomMealResponse.getPrice() != null && roomMealResponse.getPrice().compareTo(new BigDecimal(0)) != 0) {
                                                                            roomMealsResponse.add(roomMealResponse);
                                                                            hotelHasPrices = true;
                                                                        }
                                                                    }
                                                                }
                                                                if (roomMealsResponse.size() > 0) {
                                                                    roomResponse.setMeals(roomMealsResponse);
                                                                    roomsResponse.add(roomResponse);
                                                                }

                                                            }
                                                            roomTypeWithRoomsResponse = new SunHotelsRoomTypeWithRoomsResponse();
                                                            RoomtypeBean roomtypeBean = RoomtypeDAO.getRoomsTypesbyId(room.getCode(), hotelBedsProviderId, session);
                                                            if (roomtypeBean != null) {
                                                                roomTypeWithRoomsResponse.setRoomTypeId(roomtypeBean.getId());
                                                                roomTypeWithRoomsResponse.setRoomType(room.getName());
                                                                roomTypeWithRoomsResponse.setRooms(roomsResponse);
                                                                roomTypesWithRoomsResponse.add(roomTypeWithRoomsResponse);
                                                            }
                                                        }
                                                        hotelResponse.setRoom_types(roomTypesWithRoomsResponse);
                                                        if (hotelHasPrices && hotelResponse.getRoom_types() != null && hotelResponse.getRoom_types().size() > 0)
                                                            hotelsResponse.add(hotelResponse);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            prepareResponseTimeElapsed = System.currentTimeMillis() - prepareResponseTimeElapsed;
                        }
                    }
                    hotelBedsSearchRequestResponse.setDbTransactionTimeElapsed(dbTransactionTimeElapsed);
                    hotelBedsSearchRequestResponse.setPrepareResponseTimeElapsed(prepareResponseTimeElapsed);
                    hotelBedsSearchRequestResponse.setHotelsResponse(hotelsResponse);
                    hotelBedsSearchRequestResponse.setRequestTimeElapsed(requestTimeElapsed);
                }
            }catch(Exception e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                errLogger.info(errors.toString());
            }finally {
                latch.countDown();
            }
        }

}
