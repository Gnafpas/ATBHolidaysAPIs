package Controller.ATBFrontEndAPI;

import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsCancelationPolicy;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomMealResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomTypeWithRoomsResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.SunHotelsResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.SunHotelsSearchPOST;
import Beans.ATBDBBeans.KalitaonHotel.*;
import Beans.TravelGateXBeans.*;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.HotelDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.HotelmappingDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.MealDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.RoomtypeDAO;
import DAOs.TravelGateXDAOs.StaticContentDAOs;
import Helper.CurrencyConverter;
import org.hibernate.StatelessSession;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import static Controller.Application.errLogger;
import static Helper.ProjectProperties.travelXGateProviderId;

/**
 * Created by George on 21/03/2018.
 */
public class TravelGateXSearchThread implements Runnable {

        private DestinationBean destinationBean=null;
        private String[] childrenAgesSplit=null;
        private SunHotelsSearchPOST params;
        private StatelessSession session;
        private CountDownLatch latch;
        private ProvidersSearchRequestResponse travelGateXSearchRequestResponse = null;
        private ZonedDateTime checkin;
        private ZonedDateTime  checkout;

        public ProvidersSearchRequestResponse getTravelGateXSearchRequestResponse() {
            return travelGateXSearchRequestResponse;
        }

        public void setTravelGateXSearchRequestResponse(ProvidersSearchRequestResponse travelGateXSearchRequestResponse) {
            this.travelGateXSearchRequestResponse = travelGateXSearchRequestResponse;
        }

        public TravelGateXSearchThread(DestinationBean destinationBean,
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
            travelGateXSearchRequestResponse=new ProvidersSearchRequestResponse();
        }


        public void run() {
            try {

//               if ((destinationBean != null && destinationBean.getTravelXGateCode() != null) || (params.getHotelID() != null && !params.getHotelID().equals(""))) {
//                  destinationBean.getHotelBedsCode().equals("BRU") || destinationBean.getHotelBedsCode().equals("BER") || destinationBean.getHotelBedsCode().equals("KUL") || destinationBean.getHotelBedsCode().equals("ATH")
                    long dbTransactionTimeElapsed = 0;
                    long prepareResponseTimeElapsed = 0;
                    long requestTimeElapsed = 0;
                    List<SunHotelsResponse> hotelsResponse = new ArrayList<>();

                    List<HotelBean> hotelBeans = null;
                    List<Integer> hs = new ArrayList<>();
                    if ((destinationBean != null && destinationBean.getHotelBedsCode() != null && !destinationBean.getHotelBedsCode().equals(""))) {
                        hotelBeans = HotelDAO.getHotelByDestId(destinationBean.getHotelBedsCode(), travelXGateProviderId);
                        if (hotelBeans != null) {
                            for (HotelBean hotel : hotelBeans)
                                hs.add(hotel.getHotelId());
                        }
                    } else if (params.getHotelID() != null && !params.getHotelID().equals("") && params.getProviderId() == travelXGateProviderId)
                        hs.add(Integer.parseInt(params.getHotelID()));

                   //if (hs.size() > 0) {
                        requestTimeElapsed = System.currentTimeMillis();
                        ResponseAPIJSON searchResponse=StaticContentDAOs.search("2018-08-15","2018-08-16","\\\"23\\\"","US","{ age: 30 }","USD");
                        if (searchResponse != null && searchResponse.getData()!=null && searchResponse.getData().getHotelX() !=null && searchResponse.getData().getHotelX().getSearch()!=null && searchResponse.getData().getHotelX().getSearch().getErrors() == null) {

                            List<SunHotelsRoomTypeWithRoomsResponse> roomTypesWithRoomsResponse;
                            List<SunHotelsRoomResponse> roomsResponse;
                            List<SunHotelsRoomMealResponse> roomMealsResponse;
                            SunHotelsRoomTypeWithRoomsResponse roomTypeWithRoomsResponse;
                            SunHotelsRoomResponse roomResponse;
                            List<SunHotelsCancelationPolicy> cancelationPolicies;
                            SunHotelsRoomMealResponse roomMealResponse;
                            SunHotelsCancelationPolicy cancelationPolicy;
                            SunHotelsResponse hotelResponse=new SunHotelsResponse();

                            /**
                             * Get content from DB
                             */
                            dbTransactionTimeElapsed = System.currentTimeMillis();
                            List<RoomtypeBean> atbRoomTypes = RoomtypeDAO.getRoomsTypes(travelXGateProviderId);
                            List<MealBean> meals = MealDAO.getMeals(travelXGateProviderId);
                            List<HotelBean> atbhotels = null;
                            atbhotels = hotelBeans;
                            List<HotelmappingBean> hotelsmapping = HotelmappingDAO.getAllProviderHotelsMapping(travelXGateProviderId);
                            dbTransactionTimeElapsed = System.currentTimeMillis() - dbTransactionTimeElapsed;

                            /**
                             * Prepare the response data.
                             */
                            prepareResponseTimeElapsed = System.currentTimeMillis();
                            if (hotelsmapping != null && atbRoomTypes != null & meals != null) {
                                if (searchResponse.getData().getHotelX().getSearch().getOptions() != null) {
                                    for (Option option : searchResponse.getData().getHotelX().getSearch().getOptions()) {

                                        if (hotelBeans == null)
                                            atbhotels = HotelDAO.getHotelByHotelId(Integer.parseInt(option.getHotelCode()), travelXGateProviderId, session);
                                        if (atbhotels != null) {
                                            for (HotelBean atbhotel : atbhotels) {
                                                if (atbhotel.getHotelId() == Integer.parseInt(option.getHotelCode()  )) {
                                                    boolean hotelHasPrices = false;
                                                    int atbHotelId = 0;
                                                    for (HotelmappingBean hotelmapping : hotelsmapping) {
                                                        if (atbhotel.getHotelId() == hotelmapping.getHotelId())
                                                            atbHotelId = hotelmapping.getId();
                                                    }

                                                    if (atbHotelId != 0) {
                                                        boolean hotelOnTheList=false;
                                                        SunHotelsResponse existedHotel=null;
                                                        for(SunHotelsResponse hotel:hotelsResponse) {
                                                            if(Integer.compare(hotel.getId(),atbHotelId)==0) {
                                                                hotelOnTheList = true;
                                                                existedHotel=hotel;
                                                                break;
                                                            }
                                                        }
                                                        if (!hotelOnTheList) {
                                                            hotelResponse = new SunHotelsResponse();
                                                            hotelResponse.setAddress(atbhotel.getAddress());
                                                            hotelResponse.setCity(atbhotel.getCity());
                                                            hotelResponse.setCountry(atbhotel.getCountry());
                                                            hotelResponse.setDescription(atbhotel.getDescription());
                                                            if (atbhotel.getDistrict() != null && !atbhotel.getDistrict().equals(""))
                                                                hotelResponse.setDistrict(atbhotel.getDistrict());
                                                            else
                                                                hotelResponse.setDistrict(atbhotel.getCity());
                                                            hotelResponse.setId(atbHotelId);
                                                            hotelResponse.setLatitude(atbhotel.getLatitude());
                                                            hotelResponse.setLongitude(atbhotel.getLongitude());
                                                            hotelResponse.setName(atbhotel.getName());
                                                            hotelResponse.setStar_rating(atbhotel.getStarRating());
                                                            hotelResponse.setState(atbhotel.getState());
                                                            hotelResponse.setZip_code(atbhotel.getZipCode());
                                                            hotelResponse.setCountry_code(atbhotel.getCountryCode());
                                                            hotelResponse.setType(atbhotel.getAccommodationName());
                                                            hotelResponse.setProviderId(travelXGateProviderId);
                                                        }

                                                        roomTypesWithRoomsResponse = new ArrayList<>();
                                                        for (RoomSearchData room : option.getRooms()) {
                                                            roomsResponse = new ArrayList<>();
                                                            roomResponse = new SunHotelsRoomResponse();
                                                            roomResponse.setRoomId(1);
                                                            roomResponse.setBeds(0);
                                                            if(room.getBeds()!=null) {
                                                                for(Bed bed:room.getBeds())
                                                                 roomResponse.setBeds(roomResponse.getBeds()+bed.getCount());
                                                            }
                                                            roomResponse.setExtrabeds(0);
                                                            cancelationPolicies = new ArrayList<>();
                                                            if (option.getCancelPolicy() != null) {
                                                                if(option.getCancelPolicy().getCancelPenalties()!=null) {
                                                                    for (CancelPenalty policy : option.getCancelPolicy().getCancelPenalties()) {//todo fix cancelation policies,ask about roomtypes codes whichare not comming all,ask about currency
                                                                        BigDecimal percentange = new BigDecimal((Double.parseDouble(policy.getValue().toString()) * 100) / Double.parseDouble(room.getRoomPrice().getPrice().getNet().toString())).setScale(0, BigDecimal.ROUND_HALF_UP);
                                                                        cancelationPolicy = new SunHotelsCancelationPolicy();
                                                                        cancelationPolicy.setDeadline(policy.getHoursBefore());
                                                                        cancelationPolicy.setPercentage(percentange);
                                                                        if(cancelationPolicies.size()>0 && Integer.compare(cancelationPolicies.get(0).getDeadline(),cancelationPolicy.getDeadline())==1) {
                                                                            cancelationPolicies.clear();
                                                                            cancelationPolicies.add(cancelationPolicy);
                                                                        }else if(cancelationPolicies.size()==0)
                                                                            cancelationPolicies.add(cancelationPolicy);
                                                                    }
                                                                }else{
                                                                    cancelationPolicy = new SunHotelsCancelationPolicy();
                                                                    cancelationPolicy.setPercentage(null);
                                                                    cancelationPolicy.setDeadline(0);
                                                                    cancelationPolicies.add(cancelationPolicy);
                                                                }
                                                            }
                                                            roomResponse.setCancellationPolicies(cancelationPolicies);

                                                            roomMealsResponse = new ArrayList<>();
                                                            for (MealBean m : meals) {
                                                                if (option.getBoardCode().equals(m.getMealId())) {
                                                                    roomMealResponse = new SunHotelsRoomMealResponse();
                                                                    roomMealResponse.setMealId(m.getId());
                                                                    roomMealResponse.setMealName(m.getName());
                                                                    if (room.getRoomPrice().getPrice().getNet() != null) {
                                                                        BigDecimal price=null;
                                                                        if(params.getCurrencies()!=null && params.getCurrencies().size()>0)
                                                                            price= CurrencyConverter.findExchangeRateAndConvert(room.getRoomPrice().getPrice().getCurrency(), params.getCurrencies().get(0), Double.parseDouble(room.getRoomPrice().getPrice().getNet().toString()));
                                                                        if(price!=null)
                                                                            roomMealResponse.setPrice(price.setScale(2, BigDecimal.ROUND_HALF_UP));
                                                                        else
                                                                            roomMealResponse.setPrice(null);
                                                                    }
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
                                                            roomTypeWithRoomsResponse = new SunHotelsRoomTypeWithRoomsResponse();
                                                            RoomtypeBean roomtypeBean = RoomtypeDAO.getRoomsTypesbyId(room.getCode(), travelXGateProviderId, session);
                                                            if (roomtypeBean != null) {
                                                                roomTypeWithRoomsResponse.setRoomTypeId(roomtypeBean.getId());
                                                                roomTypeWithRoomsResponse.setRoomType(room.getDescription());
                                                                roomTypeWithRoomsResponse.setRooms(roomsResponse);
                                                                roomTypesWithRoomsResponse.add(roomTypeWithRoomsResponse);
                                                            }

                                                            break;//todo check if travelgatex adds more than one room in its stracture
                                                        }
                                                        if(hotelOnTheList && existedHotel!=null) {
                                                            existedHotel.getRoom_types().addAll(roomTypesWithRoomsResponse);
                                                        }
                                                        else {
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
                            }
                            prepareResponseTimeElapsed = System.currentTimeMillis() - prepareResponseTimeElapsed;
                        }
                   // }
                    travelGateXSearchRequestResponse.setDbTransactionTimeElapsed(dbTransactionTimeElapsed);
                    travelGateXSearchRequestResponse.setPrepareResponseTimeElapsed(prepareResponseTimeElapsed);
                    travelGateXSearchRequestResponse.setHotelsResponse(hotelsResponse);
                    travelGateXSearchRequestResponse.setRequestTimeElapsed(requestTimeElapsed);
    //            }
            }catch(Exception e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                errLogger.info(errors.toString());
            }finally {
                latch.countDown();
            }
        }

}
