package Controller.ATBAPIController;

import APIJSONs.ATBAPIJSONs.Hotel.*;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.CancelationPolicyResponse;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.RoomMealResponse;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.RoomResponse;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.RoomTypeWithRoomsResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsCancelationPolicy;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomMealResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomTypeWithRoomsResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.SunHotelsResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.SunHotelsSearchPOST;
import Beans.ATBDBBeans.KalitaonHotel.*;
import Beans.ATBDBBeans.KalitaonSystem.GsaBean;
import Beans.ATBDBBeans.KalitaonSystem.SubAgencyBean;
import Beans.HotelBedsAPIBeans.Availability.*;
import Beans.HotelBedsAPIBeans.Book.CancelationPolicy;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.*;
import DAOs.HotelBedsAPIDAOs.AvailabilityDAOs;
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
import static Helper.ProjectProperties.hotelBedsDeafultCurrency;
import static Helper.ProjectProperties.hotelBedsProviderId;

/**
 * Created by George on 21/03/2018.
 */
public class HotelBedsSearchThread implements Runnable {

    private DestinationBean destinationBean=null;
    private HotelSearchPOST params;
    private SubAgencyBean subAgencyBean;
    private GsaBean gsaBean;
    private StatelessSession session;
    private CountDownLatch latch;
    private ProvidersSearchRequestResponse hotelBedsSearchRequestResponse = null;
    private ZonedDateTime checkin;
    private ZonedDateTime  checkout;
    private String error="";
    private String errorType="";

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public ProvidersSearchRequestResponse getHotelBedsSearchRequestResponse() {
        return hotelBedsSearchRequestResponse;
    }

    public void setHotelBedsSearchRequestResponse(ProvidersSearchRequestResponse hotelBedsSearchRequestResponse) {
        this.hotelBedsSearchRequestResponse = hotelBedsSearchRequestResponse;
    }

    public HotelBedsSearchThread(DestinationBean destinationBean,
                                 ZonedDateTime checkout,
                                 ZonedDateTime checkin,
                                 StatelessSession session,
                                 HotelSearchPOST params,
                                 CountDownLatch latch,
                                 SubAgencyBean subAgencyBean,
                                 GsaBean gsaBean){

            super();
            this.destinationBean=destinationBean;
            this.session=session;
            this.params=params;
            this.latch=latch;
            this.checkin=checkin;
            this.checkout=checkout;
            this.subAgencyBean=subAgencyBean;
            this.gsaBean=gsaBean;
            hotelBedsSearchRequestResponse=new ProvidersSearchRequestResponse();
        }

        public void run() {
            try {
                if ((destinationBean != null && destinationBean.getHotelBedsCode() != null && (destinationBean.getHotelBedsCode().equals("BRU") || destinationBean.getHotelBedsCode().equals("BER") || destinationBean.getHotelBedsCode().equals("KUL") ) ) ||
                        (params.getHotelIDs() != null && params.getHotelIDs().size()>0)) {

                    long dbTransactionTimeElapsed = 0;
                    long prepareResponseTimeElapsed = 0;
                    long requestTimeElapsed = 0;
                    List<HotelResponse> hotelsResponse = new ArrayList<>();
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
                    if (params.getChildrenAges() != null && params.getChildrenAges().size() > 0) {
                        for (int age : params.getChildrenAges()) {
                            if (age != 0) {
                                Pax pax = new Pax();
                                pax.setAge(age);
                                pax.setType("CH");
                                paxes.add(pax);
                            }
                        }
                    }
                    occupancy.setPaxes(paxes);
                    occupancies.add(occupancy);
                    availabilityPOST.setOccupancies(occupancies);
                    Filter filter = new Filter();

                    BigDecimal maxMinprice=null;
                    if(params.getMaxPrice()!=null && !params.getMaxPrice().equals("") && params.getCurrencyCode()!=null && !params.getCurrencyCode().equals(""))
                        maxMinprice= CurrencyConverter.findExchangeRateAndConvert( params.getCurrencyCode(),hotelBedsDeafultCurrency, Double.parseDouble(params.getMaxPrice()));
                    if(maxMinprice!=null)
                        filter.setMaxRate(maxMinprice.toString());
                    maxMinprice=null;
                    if(params.getMinPrice()!=null && !params.getMinPrice().equals("") && params.getCurrencyCode()!=null && !params.getCurrencyCode().equals(""))
                        maxMinprice= CurrencyConverter.findExchangeRateAndConvert( params.getCurrencyCode(),hotelBedsDeafultCurrency, Double.parseDouble(params.getMinPrice()));
                    if(maxMinprice!=null)
                        filter.setMinRate(maxMinprice.toString());
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
                    } else if (params.getHotelIDs() != null && params.getHotelIDs().size()>0 ) {
                        for(int id:params.getHotelIDs()) {
                            hs.add(id);
                        }
                    }

                    if (hs.size() > 0) {
                        hotels.setHotel(hs);
                        availabilityPOST.setHotels(hotels);

                        requestTimeElapsed = System.currentTimeMillis();
                        AvailabilityAPIJSON availabilityAPIJSON = AvailabilityDAOs.availability(availabilityPOST);
                        requestTimeElapsed = System.currentTimeMillis() - requestTimeElapsed;
                        if (availabilityAPIJSON != null && availabilityAPIJSON.getError() == null) {

                            List<RoomTypeWithRoomsResponse> roomTypesWithRoomsResponse;
                            List<RoomResponse> roomsResponse;
                            List<RoomMealResponse> roomMealsResponse;
                            RoomTypeWithRoomsResponse roomTypeWithRoomsResponse;
                            RoomResponse roomResponse;
                            List<CancelationPolicyResponse> cancelationPolicies;
                            RoomMealResponse roomMealResponse;
                            CancelationPolicyResponse cancelationPolicy;
                            HotelResponse hotelResponse;

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
                                long tempTimeElapsed = 0;
                                long longestQueryTime = 0;
                                long retrievePicturesTimeElapsed = 0;
                                long retrieveHotelFacilitiesTimeElapsed = 0;
                                if (availabilityAPIJSON.getHotels() != null && availabilityAPIJSON.getHotels().getHotels() != null) {
                                    for (Hotel hotel : availabilityAPIJSON.getHotels().getHotels()) {

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
                                                        hotelResponse = new HotelResponse();
                                                        hotelResponse.setAddress(atbhotel.getAddress());
                                                        hotelResponse.setCity(atbhotel.getCity());
                                                        hotelResponse.setCountry(atbhotel.getCountry());
                                                        hotelResponse.setDescription(atbhotel.getDescription());
                                                        if(atbhotel.getDistrict()!=null &&!atbhotel.getDistrict().equals(""))
                                                            hotelResponse.setDistrict(atbhotel.getDistrict());
                                                        else
                                                            hotelResponse.setDistrict(atbhotel.getCity());
                                                        hotelResponse.setHotelId(atbHotelId);
                                                        hotelResponse.setLatitude(atbhotel.getLatitude());
                                                        hotelResponse.setLongitude(atbhotel.getLongitude());
                                                        hotelResponse.setName(atbhotel.getName());
                                                        hotelResponse.setStarRating(atbhotel.getStarRating());
                                                        hotelResponse.setState(atbhotel.getState());
                                                        hotelResponse.setZipCode(atbhotel.getZipCode());
                                                        hotelResponse.setCountryCode(atbhotel.getCountryCode());
                                                        hotelResponse.setAccommodationType(atbhotel.getAccommodationName());
                                                        hotelResponse.setDestinationId(destinationBean.getId());
                                                        hotelResponse.setResortId(atbhotel.getResortId());
                                                        hotelResponse.setProviderId(atbhotel.getProviderId());

                                                        List<PhotoBean> photos = PhotoDAO.getPhotosByHotelId(atbhotel.getHotelId(), hotelBedsProviderId, session);
                                                        tempTimeElapsed = System.currentTimeMillis() - tempTimeElapsed;
                                                        if (longestQueryTime < tempTimeElapsed)
                                                            longestQueryTime = tempTimeElapsed;
                                                        retrievePicturesTimeElapsed = retrievePicturesTimeElapsed + tempTimeElapsed;
                                                        tempTimeElapsed = System.currentTimeMillis();
                                                        List<HotelfacilityBean> hotelfacilities = HotelfacilityDAO.getFacilitiesByHotelId(atbhotel.getHotelId(), hotelBedsProviderId, session);
                                                        tempTimeElapsed = System.currentTimeMillis() - tempTimeElapsed;
                                                        if (longestQueryTime < tempTimeElapsed)
                                                            longestQueryTime = tempTimeElapsed;
                                                        retrieveHotelFacilitiesTimeElapsed = retrieveHotelFacilitiesTimeElapsed + tempTimeElapsed;
                                                        List<Photo> photosResponse = new ArrayList<>();
                                                        List<HotelFacility> facilitiesResponse = new ArrayList<>();
                                                        HotelFacility hotelFacilityResponse;
                                                        Photo photoResponse;
                                                        if (photos != null && hotelfacilities != null) {
                                                            for (PhotoBean photo : photos) {
                                                                photoResponse = new Photo();
                                                                photoResponse.setCoverPhoto(photo.isCoverPhoto());
                                                                photoResponse.setDescription(photo.getDescription());
                                                                FacilityBean facility = FacilityDAO.getFacilityByFacilityId(String.valueOf(photo.getFacilityId()), hotelBedsProviderId, session);
                                                                if (facility != null)
                                                                    photoResponse.setFacilityId(facility.getId());
                                                                else
                                                                    photoResponse.setFacilityId(0);
                                                                photoResponse.setHotelId(atbHotelId);
                                                                photoResponse.setId(photo.getId());
                                                                photoResponse.setPhotoPath(photo.getPhotoPath());
                                                                photoResponse.setPhotoUrl(photo.getPhotoUrl());
                                                                photoResponse.setRoomTypeId(photo.getRoomTypeId());
                                                                photoResponse.setTitle(photo.getTitle());
                                                                photosResponse.add(photoResponse);
                                                            }
                                                            for (HotelfacilityBean hotelfacility : hotelfacilities) {
                                                                hotelFacilityResponse = new HotelFacility();
                                                                hotelFacilityResponse.setExplanation(hotelfacility.getExplanation());
                                                                hotelFacilityResponse.setHotelId(atbHotelId);
                                                                hotelFacilityResponse.setId(hotelfacility.getId());
                                                                hotelFacilityResponse.setPrice(hotelfacility.getPrice());
                                                                facilitiesResponse.add(hotelFacilityResponse);
                                                            }
                                                        }
                                                        hotelResponse.setPhotos(photosResponse);
                                                        hotelResponse.setFacilities(facilitiesResponse);



                                                        roomTypesWithRoomsResponse = new ArrayList<>();
                                                        for (Room room : hotel.getRooms()) {
                                                            roomsResponse = new ArrayList<>();
                                                            for (Rate rate : room.getRates()) {
                                                                roomResponse = new RoomResponse();
                                                                roomResponse.setRoomId(1);
                                                                roomResponse.setBeds(0);
                                                                roomResponse.setExtrabeds(0);


                                                                cancelationPolicies = new ArrayList<>();
                                                                if (rate.getCancellationPolicies() != null) {
                                                                    for (CancellationPolicy policy : rate.getCancellationPolicies()) {//todo ask about roomtypes codes whichare not comming all
                                                                        BigDecimal percentange = new BigDecimal((Double.parseDouble(policy.getAmount()) * 100) / Double.parseDouble(rate.getNet())).setScale(0, BigDecimal.ROUND_HALF_UP);
                                                                        cancelationPolicy = new CancelationPolicyResponse();
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
                                                                                    if (strCancelationDate[0].equals(date.getYear()) && strCancelationDate[1].equals(date.getMonth()) && strCancelationDate[2].equals(date.getDayOfMonth())) {
                                                                                        cancelationPolicy.setDeadline(0);
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
                                                                        roomMealResponse = new RoomMealResponse();
                                                                        roomMealResponse.setMealId(m.getId());
                                                                        roomMealResponse.setMealName(m.getName());
                                                                        if (rate.getNet() != null) {
                                                                            BigDecimal price=null;
                                                                            if(params.getCurrencyCode()!=null && !params.getCurrencyCode().equals(""))
                                                                                price= CurrencyConverter.findExchangeRateAndConvert(hotel.getCurrency(), params.getCurrencyCode(), Double.parseDouble(rate.getNet()));
                                                                            if(price!=null) {
                                                                                if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                                                                    BigDecimal gsaSale = price.add(price.multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                                                    if (gsaBean.getOtlMkp() != null && !gsaBean.getOtlMkp().equals("")) {
                                                                                        BigDecimal agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                                                        roomMealResponse.setPrice(agentSale);
                                                                                        roomMealResponse.setCurrencyCode(params.getCurrencyCode());
                                                                                    }
                                                                                }
                                                                            }
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

                                                            }
                                                            roomTypeWithRoomsResponse = new RoomTypeWithRoomsResponse();
                                                            RoomtypeBean roomtypeBean = RoomtypeDAO.getRoomsTypesbyId(room.getCode(), hotelBedsProviderId, session);
                                                            if (roomtypeBean != null) {
                                                                roomTypeWithRoomsResponse.setRoomtypeID(roomtypeBean.getId());
                                                                roomTypeWithRoomsResponse.setRoomType(room.getName());
                                                                roomTypeWithRoomsResponse.setRooms(roomsResponse);
                                                                roomTypesWithRoomsResponse.add(roomTypeWithRoomsResponse);
                                                            }
                                                        }
                                                        hotelResponse.setRoomtypes(roomTypesWithRoomsResponse);
                                                        if (hotelHasPrices && hotelResponse.getRoomtypes() != null && hotelResponse.getRoomtypes().size() > 0)
                                                            hotelsResponse.add(hotelResponse);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            prepareResponseTimeElapsed = System.currentTimeMillis() - prepareResponseTimeElapsed;
                        }else{
                            if (availabilityAPIJSON == null)
                                errLogger.info("Communication Error in hoteldetailed Search sunhotels request");
                            else if (availabilityAPIJSON.getError() != null) {
                                error=availabilityAPIJSON.getError().getMessage();
                                errorType=availabilityAPIJSON.getError().getCode();
                            }
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
