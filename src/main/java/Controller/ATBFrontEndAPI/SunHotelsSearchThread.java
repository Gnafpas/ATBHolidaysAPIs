package Controller.ATBFrontEndAPI;

import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsCancelationPolicy;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomMealResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomTypeWithRoomsResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.SunHotelsResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.SunHotelsSearchPOST;
import Beans.ATBDBBeans.KalitaonHotel.*;
import Beans.GoogleAPIBeans.AddressComponent;
import Beans.GoogleAPIBeans.Result;
import Beans.GoogleAPIBeans.ReverseGeoCodeResponse;
import Beans.HereAPIBeans.ReverseGeocodeResponse;
import Beans.HereAPIBeans.View;
import Beans.HotelBedsAPIBeans.Availability.*;
import Beans.HotelBedsAPIBeans.Availability.Hotel;
import Beans.HotelBedsAPIBeans.Availability.Room;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.HotelDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.HotelmappingDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.MealDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.RoomtypeDAO;
import DAOs.GoogleAPIDAOs.HereAPIDAO;
import DAOs.GoogleAPIDAOs.ReverseGeoCodeAPIDAO;
import DAOs.HotelBedsAPIDAOs.AvailabilityDAOs;
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
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.*;
import static Helper.ProjectProperties.sanHotelsProviderId;

/**
 * Created by George on 20/03/2018.
 */
public class SunHotelsSearchThread  implements Runnable {

    private String childrenAges;
    private SunHotelsSearchPOST params;
    private StatelessSession session;
    private CountDownLatch latch;
    private String originalDestinationIdStrFormat;
    private String currencies;
    private ZonedDateTime checkin;
    private ZonedDateTime  checkout;
    private int originalDestinationId;
    private ProvidersSearchRequestResponse sunHotelsSearchRequestResponse = null;



    public ProvidersSearchRequestResponse getSunHotelsSearchRequestResponse() {
        return sunHotelsSearchRequestResponse;
    }

    public void setSunHotelsSearchRequestResponse(ProvidersSearchRequestResponse sunHotelsSearchRequestResponse) {
        this.sunHotelsSearchRequestResponse = sunHotelsSearchRequestResponse;
    }

    public SunHotelsSearchThread(int originalDestinationId,
                                 ZonedDateTime checkout,
                                 ZonedDateTime checkin,
                                 String currencies,
                                 String originalDestinationIdStrFormat,
                                 String childrenAges,
                                 StatelessSession session,
                                 SunHotelsSearchPOST params,
                                 CountDownLatch latch) {

        super();
        this.originalDestinationIdStrFormat = originalDestinationIdStrFormat;
        this.currencies = currencies;
        this.session = session;
        this.params = params;
        this.latch = latch;
        this.checkin=checkin;
        this.checkout=checkout;
        this.childrenAges=childrenAges;
        this.originalDestinationId=originalDestinationId;
        sunHotelsSearchRequestResponse = new ProvidersSearchRequestResponse();
    }

    public void run() {

        try {
            String strOriginalHotelId = "";
            if (!params.getHotelID().equals("")) {
                if (params.getProviderId() == sanHotelsProviderId)
                    strOriginalHotelId = params.getHotelID();
            }
            if (!originalDestinationIdStrFormat.equals("") || (!strOriginalHotelId.equals("") && params.getProviderId() == sanHotelsProviderId)) {
                long dbTransactionTimeElapsed = 0;
                long prepareResponseTimeElapsed = 0;
                long requestTimeElapsed = 0;
                SearchResult result = null;
                List<SunHotelsResponse> hotelsResponse = new ArrayList<>();
                /**
                 * Search request.
                 */
                requestTimeElapsed = System.currentTimeMillis();
                try {
                    GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
                    GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);
                    XMLGregorianCalendar xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
                    XMLGregorianCalendar xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
                    NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
                    NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();//todo add superdeals in the feature
                    result = nonStaticXMLAPISoap.searchV2(sunhotelsUsername, sunhotelspass, "English", currencies,
                            xmlCheckin, xmlCheckout, params.getNumberOfRooms(), "", originalDestinationIdStrFormat,
                            strOriginalHotelId, "", "", params.getNumberOfAdults(),
                            params.getNumberOfChildren(), childrenAges, params.getInfant(), "Price", "Ascending",
                            "", "true", "", "",
                            "", "", "", "",
                            "", "", "", params.getMinPrice(), params.getMaxPrice(), "",
                            "", "", "", "",
                            "", params.getCustomerCountry(), "");
                } catch (DatatypeConfigurationException e) {
                    StringWriter errors = new StringWriter();
                    e.printStackTrace(new PrintWriter(errors));
                    errLogger.info(errors.toString());
                } catch (NullPointerException e) {
                }
                requestTimeElapsed = System.currentTimeMillis() - requestTimeElapsed;


                /**
                 * Response
                 */
                if (result != null && result.getError() == null) {

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
                    prepareResponseTimeElapsed = System.currentTimeMillis() - prepareResponseTimeElapsed;
                    if (hotelsmapping != null && atbRoomTypes != null & meals != null) {
                        for (DAOs.SunHotelsAPIDAOs.Hotel hotel : result.getHotels().getHotel()) {
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
                                            hotelResponse = new SunHotelsResponse();
                                            hotelResponse.setAddress(atbhotel.getAddress());
                                            hotelResponse.setCity(atbhotel.getCity());
                                            hotelResponse.setCountry(atbhotel.getCountry());
                                            hotelResponse.setDescription(atbhotel.getDescription());
                                            if(atbhotel.getDistrict()!=null && !atbhotel.getDistrict().equals(""))
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
                                            hotelResponse.setProviderId(sanHotelsProviderId);


//                                            /**
//                                             * Get District from google reverse geocode
//                                             */
//                                            if(atbhotel.getLatitude()!=null && !atbhotel.getLatitude().equals("") && atbhotel.getLongitude()!=null && !atbhotel.getLongitude().equals("")) {
//                                                ReverseGeocodeResponse reverseGeocodeResponse = HereAPIDAO.getReverseGeoCode(atbhotel.getLatitude(), atbhotel.getLongitude());
//                                                if (reverseGeocodeResponse != null ) {
//                                                    if(reverseGeocodeResponse.getResponse().getView()!=null && reverseGeocodeResponse.getResponse().getView().size()>0) {
//                                                        for (View view : reverseGeocodeResponse.getResponse().getView()) {
//                                                            if(view.getResult()!=null && view.getResult().size()>0) {
//                                                                for (Beans.HereAPIBeans.Result res : view.getResult()) {
//                                                                    if(res.getLocation()!=null && res.getLocation().getAddress()!=null ){
//                                                                        hotelResponse.setDistrict(res.getLocation().getAddress().getDistrict());
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }

                                            roomTypesWithRoomsResponse = new ArrayList<>();
                                            roomMealsResponse = new ArrayList<>();
                                            for (RoomTypeWithRooms roomtype : hotel.getRoomtypes().getRoomtype()) {
                                                roomsResponse = new ArrayList<>();
                                                for (DAOs.SunHotelsAPIDAOs.Room room : roomtype.getRooms().getRoom()) {
                                                    roomResponse = new SunHotelsRoomResponse();
                                                    roomResponse.setRoomId(room.getId());
                                                    roomResponse.setBeds(room.getBeds());
                                                    cancelationPolicies = new ArrayList<>();
                                                    for (PercentageCancellationPolicy policy : room.getCancellationPolicies().getCancellationPolicy()) {
                                                        cancelationPolicy = new SunHotelsCancelationPolicy();
                                                        cancelationPolicy.setPercentage(policy.getPercentage());
                                                        if (policy.getDeadline() != null)
                                                            cancelationPolicy.setDeadline(policy.getDeadline());
                                                        cancelationPolicies.add(cancelationPolicy);
                                                    }
                                                    roomResponse.setCancellationPolicies(cancelationPolicies);
                                                    roomResponse.setExtrabeds(room.getExtrabeds());
                                                    for (RoomMeal roomMeal : room.getMeals().getMeal()) {
                                                        roomMealsResponse = new ArrayList<>();
                                                        for (MealBean m : meals) {
                                                            if (m.getMealId().equals(String.valueOf(roomMeal.getId()))) {
                                                                roomMealResponse = new SunHotelsRoomMealResponse();
                                                                roomMealResponse.setMealId(m.getId());
                                                                roomMealResponse.setMealName(m.getName());
                                                                for (PriceWithPaymentMethods price : roomMeal.getPrices().getPrice()) {
                                                                    roomMealResponse.setPrice(price.getValue());
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
                                                        roomTypeWithRoomsResponse = new SunHotelsRoomTypeWithRoomsResponse();
                                                        roomtype.setRoomtypeID(atbRoomType.getId());
                                                        roomTypeWithRoomsResponse.setRoomTypeId(atbRoomType.getId());
                                                        roomTypeWithRoomsResponse.setRoomType(atbRoomType.getRoomType().toUpperCase());
                                                        roomTypeWithRoomsResponse.setRooms(roomsResponse);
                                                        roomTypesWithRoomsResponse.add(roomTypeWithRoomsResponse);
                                                    }
                                                }
                                            }
                                            hotelResponse.setRoom_types(roomTypesWithRoomsResponse);
                                            hotelsResponse.add(hotelResponse);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    prepareResponseTimeElapsed = System.currentTimeMillis() - prepareResponseTimeElapsed;

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
