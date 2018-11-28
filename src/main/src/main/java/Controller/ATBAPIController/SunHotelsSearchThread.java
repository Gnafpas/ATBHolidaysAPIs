package Controller.ATBAPIController;

import APIJSONs.ATBAPIJSONs.Hotel.HotelFacility;
import APIJSONs.ATBAPIJSONs.Hotel.HotelResponse;
import APIJSONs.ATBAPIJSONs.Hotel.HotelSearchPOST;
import APIJSONs.ATBAPIJSONs.Hotel.Photo;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.CancelationPolicyResponse;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.RoomMealResponse;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.RoomResponse;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.RoomTypeWithRoomsResponse;
import Beans.ATBDBBeans.KalitaonHotel.*;
import Beans.ATBDBBeans.KalitaonSystem.GsaBean;
import Beans.ATBDBBeans.KalitaonSystem.SubAgencyBean;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.*;
import DAOs.SunHotelsAPIDAOs.*;
import org.hibernate.StatelessSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import static Controller.Application.errLogger;
import static Controller.Application.userlogs;
import static Helper.ProjectProperties.*;

/**
 * Created by George on 20/03/2018.
 */
public class SunHotelsSearchThread implements Runnable {

    private String childrenAges;
    private SubAgencyBean subAgencyBean;
    private GsaBean gsaBean;
    private HotelSearchPOST params;
    private StatelessSession session;
    private CountDownLatch latch;
    private String originalDestinationIdStrFormat;
    private ZonedDateTime checkin;
    private ZonedDateTime  checkout;
    private int originalDestinationId;
    private ProvidersSearchRequestResponse sunHotelsSearchRequestResponse = null;
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



    public ProvidersSearchRequestResponse getSunHotelsSearchRequestResponse() {
        return sunHotelsSearchRequestResponse;
    }

    public void setSunHotelsSearchRequestResponse(ProvidersSearchRequestResponse sunHotelsSearchRequestResponse) {
        this.sunHotelsSearchRequestResponse = sunHotelsSearchRequestResponse;
    }

    public SunHotelsSearchThread(int originalDestinationId,
                                 ZonedDateTime checkout,
                                 ZonedDateTime checkin,
                                 String originalDestinationIdStrFormat,
                                 String childrenAges,
                                 StatelessSession session,
                                 HotelSearchPOST params,
                                 CountDownLatch latch,
                                 SubAgencyBean subAgencyBean,
                                 GsaBean gsaBean) {

        super();
        this.originalDestinationIdStrFormat = originalDestinationIdStrFormat;
        this.session = session;
        this.params = params;
        this.latch = latch;
        this.checkin=checkin;
        this.checkout=checkout;
        this.childrenAges=childrenAges;
        this.originalDestinationId=originalDestinationId;
        this.subAgencyBean=subAgencyBean;
        this.gsaBean=gsaBean;
        sunHotelsSearchRequestResponse = new ProvidersSearchRequestResponse();
    }

    public void run() {

        try {
            /**
             * HotelPost Id Attribute.
             */
            String strOriginalHotelId = "";
            if (params.getHotelIDs() != null && params.getHotelIDs().size() > 0) {
                strOriginalHotelId = "" + HotelmappingDAO.getOriginalHotelId(params.getHotelIDs().get(0), session);
                for (Integer hotelId : params.getHotelIDs()) {
                    strOriginalHotelId = strOriginalHotelId + "," + HotelmappingDAO.getOriginalHotelId(hotelId, session);
                }
            }
            if (!originalDestinationIdStrFormat.equals("") || !strOriginalHotelId.equals("") ) {

                long requestTimeElapsed = 0;
                SearchResult result = null;
                List<HotelResponse> hotelsResponse = new ArrayList<>();

                /**
                 * Start rating.
                 */
                String minStarRating = "" + params.getMinStarRating();
                String maxStarRating = "" + params.getMaxStarRating();
                /**
                 * Set sort by
                 */
                String sortby = "";
                if (params.getSortBy() != null && params.getSortBy().equals("Rating"))
                    sortby = "Classification";
                else if (params.getSortBy() != null && params.getSortBy().equals("Price"))
                    sortby = "Price";

                requestTimeElapsed = System.currentTimeMillis() - requestTimeElapsed;
                /**
                 * Search request.
                 */
                try {
                    GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
                    GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);
                    XMLGregorianCalendar xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
                    XMLGregorianCalendar xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
                    NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
                    NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();//todo add superdeal in the future
                    result = nonStaticXMLAPISoap.searchV2(sunhotelsUsername, sunhotelspass, "English", params.getCurrencyCode(),
                            xmlCheckin, xmlCheckout, params.getNumberOfRooms(), "", originalDestinationIdStrFormat,
                            strOriginalHotelId, "", "", params.getNumberOfAdults(),
                            params.getNumberOfChildren(), childrenAges, params.getInfant(), sortby, params.getSortOrder(),
                            "", "true", params.getMealPlans(), "",
                            "", "", "", "",
                            minStarRating, maxStarRating, "", params.getMinPrice(), params.getMaxPrice(), "",
                            "", "", "", "",
                            "", params.getCustomerCountry(), "");
                } catch (DatatypeConfigurationException e) {//todo put also star rating
                    StringWriter errors = new StringWriter();
                    e.printStackTrace(new PrintWriter(errors));
                    errLogger.info(errors.toString());
                } catch (NullPointerException e) {
                }

                requestTimeElapsed = System.currentTimeMillis() - requestTimeElapsed;

                long prepareResponseTimeElapsed = 0;
                long tempTimeElapsed = 0;
                long longestQueryTime = 0;
                long retrievePicturesTimeElapsed = 0;
                long retrieveHotelFacilitiesTimeElapsed = 0;
                long dbTransactionTimeElapsed = 0;

                /**
                 * Response
                 */
                if (result != null && result.getError() == null) {

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
                    List<RoomtypeBean> atbRoomTypes = RoomtypeDAO.getRoomsTypes(sanHotelsProviderId);
                    List<MealBean> meals = MealDAO.getMeals(sanHotelsProviderId);
                    List<HotelBean> atbhotels = null;
                    if (originalDestinationId != 0)
                        atbhotels = HotelDAO.getHotelByDestId(String.valueOf(originalDestinationId), sanHotelsProviderId);
                    List<HotelmappingBean> hotelsmapping = HotelmappingDAO.getAllProviderHotelsMapping(sanHotelsProviderId);
                    dbTransactionTimeElapsed = System.currentTimeMillis() - dbTransactionTimeElapsed;

                    /**
                     * Prepare the response data.
                     */
                    prepareResponseTimeElapsed = System.currentTimeMillis();
                    if (hotelsmapping != null && atbRoomTypes != null & meals != null) {
                        for (Hotel hotel : result.getHotels().getHotel()) {
                            if (originalDestinationId == 0)
                                atbhotels = HotelDAO.getHotelByHotelId(hotel.getHotelId(), sanHotelsProviderId, session);
                            if (atbhotels != null) {
                                for (HotelBean atbhotel : atbhotels) {
                                    if (atbhotel.getHotelId() == hotel.getHotelId()) {
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
                                            hotelResponse.setDistrict(atbhotel.getCity());
                                            hotelResponse.setHotelId(atbHotelId);
                                            hotelResponse.setLatitude(atbhotel.getLatitude());
                                            hotelResponse.setLongitude(atbhotel.getLongitude());
                                            hotelResponse.setName(atbhotel.getName());
                                            hotelResponse.setStarRating(atbhotel.getStarRating());
                                            hotelResponse.setState(atbhotel.getState());
                                            hotelResponse.setZipCode(atbhotel.getZipCode());
                                            hotelResponse.setCountryCode(atbhotel.getCountryCode());
                                            hotelResponse.setResortId(atbhotel.getResortId());
                                            hotelResponse.setProviderId(atbhotel.getProviderId());
                                            hotelResponse.setAccommodationType(atbhotel.getAccommodationId());
                                            DestinationBean dest = DestinationDAO.getDestinationBean(atbhotel.getDestinationId(), sanHotelsProviderId, session);
                                            if (dest != null)
                                                hotelResponse.setDestinationId(dest.getId());

                                            roomTypesWithRoomsResponse = new ArrayList<>();
                                            roomMealsResponse = new ArrayList<>();
                                            for (RoomTypeWithRooms roomtype : hotel.getRoomtypes().getRoomtype()) {
                                                roomsResponse = new ArrayList<>();
                                                for (Room room : roomtype.getRooms().getRoom()) {
                                                    roomResponse = new RoomResponse();
                                                    roomResponse.setRoomId(room.getId());
                                                    roomResponse.setBeds(room.getBeds());
                                                    cancelationPolicies = new ArrayList<>();
                                                    cancelationPolicy = new CancelationPolicyResponse();
                                                    cancelationPolicy.setDeadline(0);
                                                    for (PercentageCancellationPolicy policy : room.getCancellationPolicies().getCancellationPolicy()) {
                                                        cancelationPolicy.setPercentage(new BigDecimal(100));
                                                        if (policy.getDeadline() != null && cancelationPolicy.getDeadline() < policy.getDeadline())
                                                            cancelationPolicy.setDeadline(policy.getDeadline() + plusCancelationPolicyHours);
                                                        else if (policy.getDeadline() == null) {
                                                            cancelationPolicy.setDeadline(null);
                                                            cancelationPolicies.add(cancelationPolicy);
                                                            break;
                                                        }
                                                        cancelationPolicies.add(cancelationPolicy);
                                                    }
                                                    roomResponse.setCancellationPolicies(cancelationPolicies);
                                                    roomResponse.setExtrabeds(room.getExtrabeds());
                                                    for (RoomMeal roomMeal : room.getMeals().getMeal()) {
                                                        roomMealsResponse = new ArrayList<>();
                                                        for (MealBean m : meals) {
                                                            if (roomMeal.getId() == m.getId()) {
                                                                roomMealResponse = new RoomMealResponse();
                                                                MealBean meal=MealDAO.getMealByMealId(String.valueOf(m.getId()),sanHotelsProviderId,session);
                                                                if(meal!=null)
                                                                    roomMealResponse.setMealId(meal.getId());
                                                                else
                                                                    roomMealResponse.setMealId(0);
                                                                roomMealResponse.setMealName(m.getName());
                                                                for (PriceWithPaymentMethods price : roomMeal.getPrices().getPrice()) {
                                                                    if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                                                        BigDecimal gsaSale = price.getValue().add(price.getValue().multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                                        if (gsaBean.getOtlMkp() != null && !gsaBean.getOtlMkp().equals("")) {
                                                                            BigDecimal agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                                            roomMealResponse.setPrice(agentSale);
                                                                            roomMealResponse.setCurrencyCode(price.getCurrency());
                                                                        }
                                                                    }
                                                                }
                                                                roomMealsResponse.add(roomMealResponse);
                                                            }
                                                        }
                                                    }
                                                    roomResponse.setMeals(roomMealsResponse);
                                                    roomsResponse.add(roomResponse);
                                                }
                                                for (RoomtypeBean atbRoomType : atbRoomTypes) {
                                                    if (atbRoomType.getRoomtypeId().equals(String.valueOf(roomtype.getRoomtypeID()))) {
                                                        roomTypeWithRoomsResponse = new RoomTypeWithRoomsResponse();
                                                        roomtype.setRoomtypeID(atbRoomType.getId());
                                                        roomTypeWithRoomsResponse.setRoomtypeID(atbRoomType.getId());
                                                        roomTypeWithRoomsResponse.setRoomType(atbRoomType.getRoomType());
                                                        roomTypeWithRoomsResponse.setRooms(roomsResponse);
                                                        roomTypesWithRoomsResponse.add(roomTypeWithRoomsResponse);
                                                    }
                                                }
                                            }
                                            hotelResponse.setRoomtypes(roomTypesWithRoomsResponse);


                                            tempTimeElapsed = System.currentTimeMillis();
                                            List<PhotoBean> photos = PhotoDAO.getPhotosByHotelId(hotel.getHotelId(), sanHotelsProviderId, session);
                                            tempTimeElapsed = System.currentTimeMillis() - tempTimeElapsed;
                                            if (longestQueryTime < tempTimeElapsed)
                                                longestQueryTime = tempTimeElapsed;
                                            retrievePicturesTimeElapsed = retrievePicturesTimeElapsed + tempTimeElapsed;
                                            tempTimeElapsed = System.currentTimeMillis();
                                            List<HotelfacilityBean> hotelfacilities = HotelfacilityDAO.getFacilitiesByHotelId(hotel.getHotelId(), sanHotelsProviderId, session);
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
                                                    FacilityBean facility = FacilityDAO.getFacilityByFacilityId(String.valueOf(photo.getFacilityId()), sanHotelsProviderId, session);
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

                                            hotelsResponse.add(hotelResponse);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    prepareResponseTimeElapsed = System.currentTimeMillis() - prepareResponseTimeElapsed;

                } else {
                    if (result == null)
                        errLogger.info("Communication Error in hoteldetailed Search sunhotels request");
                    else if (result.getError() != null) {
                        error=result.getError().getMessage();
                        errorType=result.getError().getErrorType();
                    }
                }
                sunHotelsSearchRequestResponse.setDbTransactionTimeElapsed(dbTransactionTimeElapsed);
                sunHotelsSearchRequestResponse.setPrepareResponseTimeElapsed(prepareResponseTimeElapsed);
                sunHotelsSearchRequestResponse.setHotelsResponse(hotelsResponse);
                sunHotelsSearchRequestResponse.setRequestTimeElapsed(requestTimeElapsed);
            }
        }catch(Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            latch.countDown();
        }
    }

}
