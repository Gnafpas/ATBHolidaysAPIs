package Controller.ATBAPIController;

import APIJSONs.ATBAPIJSONs.Hotel.*;
import APIJSONs.ATBAPIJSONs.Hotel.Resort;
import APIJSONs.ATBAPIJSONs.Hotel.RoomType;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.*;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.RoomMealResponse;
import Beans.ATBDBBeans.KalitaonHotel.*;
import Beans.ATBDBBeans.KalitaonSystem.GsaBean;
import Beans.ATBDBBeans.KalitaonSystem.SubAgencyBean;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.*;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.GsaDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.SubAgencyDAO;
import DAOs.SunHotelsAPIDAOs.*;
import DAOs.SunHotelsAPIDAOs.Room;
import DAOs.SunHotelsAPIDAOs.RoomTypeWithRooms;
import DBConnection.SunHotelsHibernateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import static Controller.Application.errLogger;
import static Controller.Application.userlogs;
import static Helper.ProjectProperties.*;

/**
 * Created by George on 05/12/2017.
 */
@RestController
public class HotelController {

    @RequestMapping(value = "/hotel/hotelStaticContent", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public HotelStaticContentJSON hotelStaticContent(@RequestBody HotelStaticContentPOST params) {
        HotelStaticContentJSON hotelSearchJSON = new HotelStaticContentJSON();
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        hotelSearchJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
        /**
         * Hotel Id Attribute.
         */
        List<Integer> originalHotelIds = new ArrayList<>();//todo change code here when hotelbeds will be added
        Integer originalHotelId;
        if (params.getHotelIDs() != null && params.getHotelIDs().size() > 0) {//todo send only last updated hotels
            originalHotelId=HotelmappingDAO.getOriginalHotelId(params.getHotelIDs().get(0), null);
            if(originalHotelId!=null )
              originalHotelIds.add(originalHotelId);
            for (Integer hotelId : params.getHotelIDs()) {
                originalHotelId=HotelmappingDAO.getOriginalHotelId(hotelId, null);
                if(originalHotelId!=null )
                    originalHotelIds.add(originalHotelId);
            }
        }

        /**
         * Get original id from Destination table.
         */
        int originalDestinationId = 0;
        if (params.getDestinationId() != null && !params.getDestinationId().equals("")) {
            originalDestinationId = DestinationDAO.getOriginalDestinationId(params.getDestinationId());
            if (originalDestinationId == 0 && (originalHotelIds==null || originalHotelIds.size()==0)) {
                hotelSearchJSON.setSuccess(false);
                hotelSearchJSON.setErrorMessageText("Missing Destination Id");
                return hotelSearchJSON;
            }
        }

        List<HotelResponse> hotelsResponse = new ArrayList<>();
        List<RoomTypeWithRoomsResponse> roomTypesWithRoomsResponse;
        RoomTypeWithRoomsResponse roomTypeWithRoomsResponse;
        HotelResponse hotelResponse;

        /**
         * Get content from DB
         */
        int atbHotelId = 0;
        List<HotelBean> atbhotels;
        if (originalDestinationId != 0)
            atbhotels = HotelDAO.getHotelByDestId(originalDestinationId, sanHotelsProviderId);
        else {
            atbhotels = HotelDAO.getHotelByHotelIds(originalHotelIds, sanHotelsProviderId,null);
        }
        List<HotelmappingBean> hotelsmapping = HotelmappingDAO.getAllProviderHotelsMapping(sanHotelsProviderId);


        /**
         * Prepare the response data.
         */
        if (hotelsmapping != null ) {
            if (atbhotels != null) {
                for (HotelBean atbhotel : atbhotels) {
                    if (atbhotel.getHotelId() == atbhotel.getHotelId()) {
                        atbHotelId = 0;
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


                            roomTypesWithRoomsResponse = new ArrayList<>();

                            StatelessSession session = SunHotelsHibernateUtil.getSession();
                            try {
                                session.beginTransaction();
                                List<RoomBean> rooms=RoomDAO.getRoomsByHotelId(atbhotel.getHotelId(), sanHotelsProviderId,session);
                                if(rooms!=null) {
                                    for (RoomBean room : rooms) {

                                        RoomtypeBean atbRoomType = RoomtypeDAO.getRoomsTypesbyId(room.getRoomTypeId(), sanHotelsProviderId, session);
                                        if (atbRoomType != null) {
                                            boolean roomtypeExists = false;
                                            for (RoomTypeWithRoomsResponse roomtype : roomTypesWithRoomsResponse) {
                                                if (roomtype.getRoomtypeID() == atbRoomType.getId()) {
                                                    roomtypeExists = true;
                                                }
                                            }
                                            if (!roomtypeExists) {
                                                roomTypeWithRoomsResponse = new RoomTypeWithRoomsResponse();
                                                roomTypeWithRoomsResponse.setRoomtypeID(atbRoomType.getId());
                                                roomTypeWithRoomsResponse.setRoomType(atbRoomType.getRoomType());
                                                roomTypesWithRoomsResponse.add(roomTypeWithRoomsResponse);
                                            }
                                        }
                                    }
                                }
                                hotelResponse.setRoomtypes(roomTypesWithRoomsResponse);


                                List<PhotoBean> photos = PhotoDAO.getPhotosByHotelId(atbhotel.getHotelId(), sanHotelsProviderId,session);
                                List<HotelfacilityBean> hotelfacilities = HotelfacilityDAO.getFacilitiesByHotelId(atbhotel.getHotelId(), sanHotelsProviderId,session);
                                List<Photo> photosResponse = new ArrayList<>();
                                List<HotelFacility> facilitiesResponse = new ArrayList<>();
                                HotelFacility hotelFacilityResponse;
                                Photo photoResponse;
                                if(photos!=null && hotelfacilities!=null) {
                                    for (PhotoBean photo : photos) {
                                        photoResponse = new Photo();
                                        photoResponse.setCoverPhoto(photo.isCoverPhoto());
                                        photoResponse.setDescription(photo.getDescription());
                                        photoResponse.setFacilityId(photo.getFacilityId());
                                        photoResponse.setHotelId(atbHotelId);
                                        photoResponse.setId(photo.getId());
                                        photoResponse.setPhotoPath(photo.getPhotoPath());
                                        photoResponse.setPhotoUrl(photo.getPhotoUrl());
                                        photoResponse.setRoomId(photo.getRoomId());
                                        photoResponse.setTitle(photo.getTitle());
                                        photosResponse.add(photoResponse);
                                    }
                                    for (HotelfacilityBean hotelfacility : hotelfacilities) {
                                        hotelFacilityResponse = new HotelFacility();
                                        hotelFacilityResponse.setExplanation(hotelfacility.getExplanation());
                                        hotelFacilityResponse.setFacilityId(hotelfacility.getFacilityId());
                                        hotelFacilityResponse.setHotelId(atbHotelId);
                                        hotelFacilityResponse.setId(hotelfacility.getId());
                                        hotelFacilityResponse.setPrice(hotelfacility.getPrice());
                                        facilitiesResponse.add(hotelFacilityResponse);
                                    }
                                }
                                hotelResponse.setPhotos(photosResponse);
                                hotelResponse.setFacilities(facilitiesResponse);
                            }catch (HibernateException e) {
                                StringWriter errors = new StringWriter();
                                e.printStackTrace(new PrintWriter(errors));
                                errLogger.info(errors.toString());
                            }catch (ExceptionInInitializerError e) {
                                StringWriter errors = new StringWriter();
                                e.printStackTrace(new PrintWriter(errors));
                                errLogger.info(errors.toString());
                            }catch (ClientTransportException e) {
                                StringWriter errors = new StringWriter();
                                e.printStackTrace(new PrintWriter(errors));
                                errLogger.info(errors.toString());
                            }catch (CJCommunicationsException e) {
                                StringWriter errors = new StringWriter();
                                e.printStackTrace(new PrintWriter(errors));
                                errLogger.info(errors.toString());
                            }finally {
                                session.close();
                            }
                            hotelsResponse.add(hotelResponse);
                        }
                    }
                }
            }
        }
        hotelSearchJSON.setData(hotelsResponse);

        /**
         *  Set count of total hotels.
         */
        hotelSearchJSON.setTotalCount(hotelsResponse.size());


        /**
         * Send only the x hotels from the list as a response.
         */
        if (hotelsResponse != null) {
            int z = 0;
            for (Iterator<HotelResponse> iter = hotelsResponse.listIterator(); iter.hasNext(); ) {
                iter.next();
                if (params.getListStartPosition() > z)
                    iter.remove();
                if (params.getListLastPosition() < z)
                    iter.remove();
                z++;
            }
        }

        hotelSearchJSON.setData(hotelsResponse);
        userlogs.info("Request Varibles: " + " hotelID:" + params.getHotelIDs()+ ". Destination:" + originalDestinationId);
        if (hotelSearchJSON.getData()!= null) {
            userlogs.info("Response Hotels count:" + hotelSearchJSON.getData().size());
        } else
            userlogs.info("Response Hotels count:" + 0 );

        hotelSearchJSON.setSuccess(true);

        return hotelSearchJSON;
    }

    @RequestMapping("/hotel/resorts")
    public ResortJSON resorts(@RequestParam(value="DestinationId", defaultValue="0") String DestinationId) {
        ResortJSON resortJSON=new ResortJSON();
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        resortJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
        List<Resort> resorts=new ArrayList<>();//todo add apikey to searchlog table
        Resort resort;
        List<ResortBean> resortbeans;
        resortbeans=ResortDAO.getResortByDestId(DestinationDAO.getOriginalDestinationId(DestinationId),sanHotelsProviderId);
        if(resortbeans!=null){
             for(ResortBean resortbean:resortbeans){
                 resort=new Resort();
                 resort.setCountryCode(resortbean.getCountryCode());
                 resort.setCountryName(resortbean.getCountryName());
                 resort.setDestinationId(Integer.parseInt(DestinationId));
                 resort.setDestinationName(resortbean.getDestinationName());
                 resort.setResortId(ResortMappingDAO.getATBResortId(resortbean.getResortId(),sanHotelsProviderId,null));
                 resort.setResortName(resortbean.getResortName());
                 resorts.add(resort);
             }
                resortJSON.setData(resorts);
                resortJSON.setSuccess(true);
                resortJSON.setTotalCount(resorts.size());
        }else{
            resortJSON.setSuccess(false);
            resortJSON.setErrorMessageText("Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
        }

        return  resortJSON;
    }

    @RequestMapping("/hotel/meals")
    public MealsJSON meals() {
        MealsJSON mealsJSON=new MealsJSON();
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        mealsJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
        List<Meal> meals=new ArrayList<>();
        Meal meal;
        List<MealBean> mealbeans;
        mealbeans=MealDAO.getMeals(sanHotelsProviderId);
        if(mealbeans!=null){
            for(MealBean mealbean:mealbeans){
                meal=new Meal();
                meal.setId(mealbean.getId());
                meal.setName(mealbean.getName());
                meals.add(meal);
            }
            mealsJSON.setData(meals);
            mealsJSON.setSuccess(true);
            mealsJSON.setTotalCount(meals.size());
        }else{
            mealsJSON.setSuccess(false);
            mealsJSON.setErrorMessageText("Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
        }

        return  mealsJSON;
    }

    @RequestMapping("/hotel/facilities")
    public FacilitiesJSON facilities() {
        FacilitiesJSON facilitiesJSON=new FacilitiesJSON();
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        facilitiesJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
        List<Facility> facilities=new ArrayList<>();
        Facility facility;
        List<FacilityBean> facilityBeans;
        facilityBeans=FacilityDAO.getFacilities(sanHotelsProviderId);
        if(facilityBeans!=null){
            for(FacilityBean facilityBean:facilityBeans){
                facility=new Facility();
                facility.setFacilityId(facilityBean.getFacilityId());
                facility.setName(facilityBean.getName());
                facilities.add(facility);
            }
            facilitiesJSON.setData(facilities);
            facilitiesJSON.setSuccess(true);
            facilitiesJSON.setTotalCount(facilities.size());
        }else{
            facilitiesJSON.setSuccess(false);
            facilitiesJSON.setErrorMessageText("Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
        }

        return  facilitiesJSON;
    }


    @RequestMapping("/hotel/roomTypes")
    public RoomTypesJSON roomTypes() {
        RoomTypesJSON roomTypesJSON=new RoomTypesJSON();
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        roomTypesJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
        List<RoomType> roomTypes=new ArrayList<>();
        RoomType roomType;
        List<RoomtypeBean> roomtypeBeans;
        roomtypeBeans=RoomtypeDAO.getRoomsTypes(sanHotelsProviderId);
        if(roomtypeBeans!=null){
            for(RoomtypeBean roomtypeBean:roomtypeBeans){
                roomType=new RoomType();
                roomType.setRoomType(roomtypeBean.getRoomType());
                roomType.setRoomtypeId(roomtypeBean.getId());
                roomType.setSharedRoom(roomtypeBean.isSharedRoom());
                roomTypes.add(roomType);
            }
            roomTypesJSON.setData(roomTypes);
            roomTypesJSON.setSuccess(true);
            roomTypesJSON.setTotalCount(roomTypes.size());
        }else{
            roomTypesJSON.setSuccess(false);
            roomTypesJSON.setErrorMessageText("Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
        }

        return  roomTypesJSON;
    }


    @RequestMapping(value = "/hotel/detailedSearch", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public HotelSearchJSON detailedSearch(@RequestBody HotelSearchPOST params,@RequestParam("apiKey") String apiKey) {


        SubAgencyBean subAgencyBean = null;
        GsaBean gsaBean;
        String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + apiKey;
        String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
        subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);
        HotelSearchJSON hotelSearchJSON = new HotelSearchJSON();
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        hotelSearchJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
        if (subAgencyBean != null) {
            long w = System.currentTimeMillis();
            /**
             * Get search from search log if exists.Prepare according to new parameters and send back.
             */
            ObjectMapper mapper = new ObjectMapper();
            ApiUsrSearchLogBean retrieveSearchLogBean = ApiUsrSearchLogDAO.getSearchLogBean(params.getSearchId());
            if (retrieveSearchLogBean != null) {
                HotelSearchJSON retrieveResponse = new HotelSearchJSON();
                try {
                    retrieveResponse = mapper.readValue(retrieveSearchLogBean.getResponse(), HotelSearchJSON.class);


                    /**
                     * Update search log.
                     */
                    if (params.getStarRatings() != null && !params.getStarRatings().equals("")) {
                        retrieveSearchLogBean.setCurrentStarRatings(params.getStarRatings());
                    }
                    if (params.getSortBy() != null && !params.getSortBy().equals("")) {
                        retrieveSearchLogBean.setCurrentSortBy(params.getSortBy());
                    }
                    if (params.getMinPrice() != null && !params.getMinPrice().equals("")) {
                        retrieveSearchLogBean.setCurrentMinPrice(params.getMinPrice());
                    }
                    if (params.getMealPlans() != null && !params.getMealPlans().equals("")) {
                        retrieveSearchLogBean.setCurrentMealPlans(params.getMealPlans());
                    }
                    if (params.getMaxPrice() != null && !params.getMaxPrice().equals("")) {
                        retrieveSearchLogBean.setCurrentMaxPrice(params.getMaxPrice());
                    }
                    if (params.getSortOrder() != null && !params.getSortOrder().equals("")) {
                        retrieveSearchLogBean.setCurrentSortOrder(params.getSortOrder());
                    }


                    ApiUsrSearchLogDAO.updateSearchLogBean(retrieveSearchLogBean);

                    /**
                     * Filters for the list.
                     */
                    boolean removeHotelForStarRating;
                    boolean removeHotelForMaxPrice;
                    boolean removeHotelForMinPrice;
                    boolean removeHotelForDistricts;
                    boolean removeHotelForMeals;
                    for (Iterator<HotelResponse> iter = retrieveResponse.getData().listIterator(); iter.hasNext(); ) {
                        HotelResponse hotel = iter.next();
                        removeHotelForStarRating = true;
                        removeHotelForMaxPrice = true;
                        removeHotelForMinPrice = true;
                        removeHotelForDistricts = true;
                        removeHotelForMeals = true;
                        if (retrieveSearchLogBean.getCurrentStarRatings() != null && !retrieveSearchLogBean.getCurrentStarRatings().equals("")) {
                            String[] split = retrieveSearchLogBean.getCurrentStarRatings().split(",");//todo fix issue with 3+,4+ ratings and space in strings
                            for (int i = 0; i < split.length; i++) {
                                if (hotel.getStarRating().equals(split[i]))
                                    removeHotelForStarRating = false;
                            }
                        } else
                            removeHotelForStarRating = false;
                        if (retrieveSearchLogBean.getCurrentDistricts() != null && !retrieveSearchLogBean.getCurrentDistricts().equals("")) {
                            String[] split = retrieveSearchLogBean.getCurrentDistricts().split(",");
                            for (int i = 0; i < split.length; i++) {
                                if (hotel.getDistrict().equals(split[i]))
                                    removeHotelForDistricts = false;
                            }
                        } else
                            removeHotelForDistricts = false;
                        if (retrieveSearchLogBean.getCurrentMealPlans() != null && !retrieveSearchLogBean.getCurrentMealPlans().equals("")) {
                            String[] split = retrieveSearchLogBean.getCurrentMealPlans().split(",");//todo fix space in strings
                            for (int i = 0; i < split.length; i++) {
                                for (RoomTypeWithRoomsResponse roomtype : hotel.getRoomtypes()) {
                                    for (RoomResponse room : roomtype.getRooms()) {
                                        for (RoomMealResponse meal : room.getMeals()) {
                                            if (meal.getMealName().equals(split[i]))
                                                removeHotelForMeals = false;
                                        }
                                    }
                                }
                            }
                        } else
                            removeHotelForMeals = false;
                        if (retrieveSearchLogBean.getCurrentMinPrice() != null && !retrieveSearchLogBean.getCurrentMinPrice().equals("")) {
                            for (RoomTypeWithRoomsResponse roomtype : hotel.getRoomtypes()) {
                                for (RoomResponse room : roomtype.getRooms()) {
                                    for (RoomMealResponse meal : room.getMeals()) {
                                        if (Double.parseDouble(meal.getPrice().toString()) > Double.parseDouble(retrieveSearchLogBean.getCurrentMinPrice())) {
                                            removeHotelForMinPrice = false;
                                        }
                                    }
                                }
                            }
                        } else
                            removeHotelForMinPrice = false;
                        if (retrieveSearchLogBean.getCurrentMaxPrice() != null && !retrieveSearchLogBean.getCurrentMaxPrice().equals("")) {
                            for (RoomTypeWithRoomsResponse roomtype : hotel.getRoomtypes()) {
                                for (RoomResponse room : roomtype.getRooms()) {
                                    for (RoomMealResponse meal : room.getMeals()) {
                                        if (Double.parseDouble(meal.getPrice().toString()) < Double.parseDouble(retrieveSearchLogBean.getCurrentMaxPrice())) {
                                            removeHotelForMaxPrice = false;
                                        }
                                    }
                                }
                            }
                        } else
                            removeHotelForMaxPrice = false;

                        if (removeHotelForMaxPrice == true || removeHotelForMinPrice == true || removeHotelForMeals == true || removeHotelForDistricts == true || removeHotelForStarRating == true)
                            iter.remove();
                    }

                    /**
                     * Sort Order By ratting
                     */
                    if (retrieveSearchLogBean.getCurrentSortBy() != null && retrieveSearchLogBean.getCurrentSortBy().equals("Rating")) {
                        if (retrieveSearchLogBean.getCurrentSortOrder() != null && retrieveSearchLogBean.getCurrentSortOrder().equals("Ascending")) {
                            Collections.sort(retrieveResponse.getData(), HotelResponse.Comparators.ratting);
                        } else if (retrieveSearchLogBean.getCurrentSortOrder() != null && retrieveSearchLogBean.getCurrentSortOrder().equals("Descending")) {
                            Collections.sort(retrieveResponse.getData(), HotelResponse.Comparators.ratting.reversed());
                        }
                    }
                    /**
                     * Sort Order By price.
                     */
                    if (retrieveSearchLogBean.getCurrentSortBy() != null && retrieveSearchLogBean.getCurrentSortBy().equals("Price")) {
                        BigDecimal hotelMinprice;
                        BigDecimal nextHotelMinprice;
                        if (retrieveSearchLogBean.getCurrentSortOrder() != null && retrieveSearchLogBean.getCurrentSortOrder().equals("Ascending")) {

                            for (int i = 0; i < retrieveResponse.getData().size(); i++) {
                                for (int z = 0; z < retrieveResponse.getData().size(); z++) {
                                    if (z != i) {
                                        if (retrieveResponse.getData().get(i).getRoomtypes() != null
                                                && retrieveResponse.getData().get(i).getRoomtypes().size() > 0
                                                && retrieveResponse.getData().get(i).getRoomtypes().get(0).getRooms() != null
                                                && retrieveResponse.getData().get(i).getRoomtypes().get(0).getRooms().size() > 0
                                                && retrieveResponse.getData().get(i).getRoomtypes().get(0).getRooms().get(0).getMeals() != null
                                                && retrieveResponse.getData().get(i).getRoomtypes().get(0).getRooms().get(0).getMeals().size() > 0
                                                && retrieveResponse.getData().get(z).getRoomtypes() != null
                                                && retrieveResponse.getData().get(z).getRoomtypes().size() > 0
                                                && retrieveResponse.getData().get(z).getRoomtypes().get(0).getRooms() != null
                                                && retrieveResponse.getData().get(z).getRoomtypes().get(0).getRooms().size() > 0
                                                && retrieveResponse.getData().get(z).getRoomtypes().get(0).getRooms().get(0).getMeals() != null
                                                && retrieveResponse.getData().get(z).getRoomtypes().get(0).getRooms().get(0).getMeals().size() > 0) {

                                            hotelMinprice = retrieveResponse.getData().get(i).getRoomtypes().get(0).getRooms().get(0).getMeals().get(0).getPrice();
                                            for (RoomTypeWithRoomsResponse roomtype : retrieveResponse.getData().get(i).getRoomtypes()) {
                                                for (RoomResponse room : roomtype.getRooms()) {
                                                    if (room.getMeals() != null && room.getMeals().size() > 0) {
                                                        for (RoomMealResponse meal : room.getMeals()) {
                                                            if (hotelMinprice.compareTo(meal.getPrice()) == 1)
                                                                hotelMinprice = meal.getPrice();
                                                        }
                                                    }
                                                }
                                            }
                                            nextHotelMinprice = retrieveResponse.getData().get(z).getRoomtypes().get(0).getRooms().get(0).getMeals().get(0).getPrice();
                                            for (RoomTypeWithRoomsResponse nextRoomtype : retrieveResponse.getData().get(z).getRoomtypes()) {
                                                for (RoomResponse nextRoom : nextRoomtype.getRooms()) {
                                                    if (nextRoom.getMeals() != null && nextRoom.getMeals().size() > 0) {
                                                        for (RoomMealResponse meal : nextRoom.getMeals()) {
                                                            if (nextHotelMinprice.compareTo(meal.getPrice()) == 1)
                                                                nextHotelMinprice = meal.getPrice();
                                                        }
                                                    }
                                                }
                                            }
                                            if (hotelMinprice.compareTo(nextHotelMinprice) == -1) {
                                                HotelResponse tmp1 = retrieveResponse.getData().get(z);
                                                HotelResponse tmp2 = retrieveResponse.getData().get(i);
                                                retrieveResponse.getData().set(z, tmp2);
                                                retrieveResponse.getData().set(i, tmp1);
                                            }
                                        }
                                    }
                                }
                            }

//                        for(int i=0;i<retrieveResponse.getResults().size();i++) {
//                            hotelMinprice = retrieveResponse.getResults().get(i).getRoom_types().get(0).getRooms().get(0).getMeals().get(0).getPrice();
//                            for (SunHotelsRoomTypeWithRoomsResponse roomtype : retrieveResponse.getResults().get(i).getRoom_types()) {
//                                for (SunHotelsRoomResponse room : roomtype.getRooms()) {
//                                    if (room.getMeals() != null && room.getMeals().size() > 0) {
//                                        for (SunHotelsRoomMealResponse meal : room.getMeals()) {
//                                            if (hotelMinprice.compareTo(meal.getPrice()) == 1) {
//                                                hotelMinprice = meal.getPrice();
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                            System.out.println("hotel id :" + retrieveResponse.getResults().get(i).getId()+" price: "+hotelMinprice);
//                        }
                        } else if (retrieveSearchLogBean.getCurrentSortOrder() != null && retrieveSearchLogBean.getCurrentSortOrder().equals("Descending")) {
                            for (int i = 0; i < retrieveResponse.getData().size(); i++) {
                                for (int z = 0; z < retrieveResponse.getData().size(); z++) {
                                    if (z != i) {
                                        if (retrieveResponse.getData().get(i).getRoomtypes() != null
                                                && retrieveResponse.getData().get(i).getRoomtypes().size() > 0
                                                && retrieveResponse.getData().get(i).getRoomtypes().get(0).getRooms() != null
                                                && retrieveResponse.getData().get(i).getRoomtypes().get(0).getRooms().size() > 0
                                                && retrieveResponse.getData().get(i).getRoomtypes().get(0).getRooms().get(0).getMeals() != null
                                                && retrieveResponse.getData().get(i).getRoomtypes().get(0).getRooms().get(0).getMeals().size() > 0
                                                && retrieveResponse.getData().get(z).getRoomtypes() != null
                                                && retrieveResponse.getData().get(z).getRoomtypes().size() > 0
                                                && retrieveResponse.getData().get(z).getRoomtypes().get(0).getRooms() != null
                                                && retrieveResponse.getData().get(z).getRoomtypes().get(0).getRooms().size() > 0
                                                && retrieveResponse.getData().get(z).getRoomtypes().get(0).getRooms().get(0).getMeals() != null
                                                && retrieveResponse.getData().get(z).getRoomtypes().get(0).getRooms().get(0).getMeals().size() > 0) {

                                            hotelMinprice = retrieveResponse.getData().get(i).getRoomtypes().get(0).getRooms().get(0).getMeals().get(0).getPrice();
                                            for (RoomTypeWithRoomsResponse roomtype : retrieveResponse.getData().get(i).getRoomtypes()) {
                                                for (RoomResponse room : roomtype.getRooms()) {
                                                    if (room.getMeals() != null && room.getMeals().size() > 0) {
                                                        for (RoomMealResponse meal : room.getMeals()) {
                                                            if (hotelMinprice.compareTo(meal.getPrice()) == 1)
                                                                hotelMinprice = meal.getPrice();
                                                        }
                                                    }
                                                }
                                            }
                                            nextHotelMinprice = retrieveResponse.getData().get(z).getRoomtypes().get(0).getRooms().get(0).getMeals().get(0).getPrice();
                                            for (RoomTypeWithRoomsResponse nextRoomtype : retrieveResponse.getData().get(z).getRoomtypes()) {
                                                for (RoomResponse nextRoom : nextRoomtype.getRooms()) {
                                                    if (nextRoom.getMeals() != null && nextRoom.getMeals().size() > 0) {
                                                        for (RoomMealResponse meal : nextRoom.getMeals()) {
                                                            if (nextHotelMinprice.compareTo(meal.getPrice()) == 1)
                                                                nextHotelMinprice = meal.getPrice();
                                                        }
                                                    }
                                                }
                                            }
                                            if (hotelMinprice.compareTo(nextHotelMinprice) == 1) {
                                                HotelResponse tmp1 = retrieveResponse.getData().get(z);
                                                HotelResponse tmp2 = retrieveResponse.getData().get(i);
                                                retrieveResponse.getData().set(z, tmp2);
                                                retrieveResponse.getData().set(i, tmp1);
                                            }
                                        }
                                    }
                                }
                            }

//                        for(int i=0;i<retrieveResponse.getResults().size();i++) {
//                            hotelMinprice = retrieveResponse.getResults().get(i).getRoom_types().get(0).getRooms().get(0).getMeals().get(0).getPrice();
//                            for (SunHotelsRoomTypeWithRoomsResponse roomtype : retrieveResponse.getResults().get(i).getRoom_types()) {
//                                for (SunHotelsRoomResponse room : roomtype.getRooms()) {
//                                    if (room.getMeals() != null && room.getMeals().size() > 0) {
//                                        for (SunHotelsRoomMealResponse meal : room.getMeals()) {
//                                            if (hotelMinprice.compareTo(meal.getPrice()) == 1)
//                                                hotelMinprice = meal.getPrice();
//                                        }
//                                    }
//                                }
//                            }
//                            System.out.println("hotel id :" + retrieveResponse.getResults().get(i).getId()+" price: "+hotelMinprice);
//                        }
                        }
                    }

                    /**
                     * Send only the x hotels from the list as a response.
                     */
                    int z = 0;
                    for (Iterator<HotelResponse> iter = retrieveResponse.getData().listIterator(); iter.hasNext(); ) {
                        iter.next();
                        if (params.getListStartPosition() > z)
                            iter.remove();
                        if (params.getListLastPosition() < z)
                            iter.remove();
                        z++;
                    }


                } catch (IOException e) {
                    StringWriter errors = new StringWriter();
                    e.printStackTrace(new PrintWriter(errors));
                    errLogger.info(errors.toString());
                    hotelSearchJSON.setErrorMessageText("Code:11.Something went wrong.Please contact at:george.nafpaktitis@atbholidays.com");
                    hotelSearchJSON.setSuccess(false);
                }

                hotelSearchJSON.setSuccess(true);
                return retrieveResponse;
            }


            /**
             * If the search is for first time continue to the code bellow.
             */


            /**
             * Dates request parameters
             */
            ZonedDateTime checkin = null;
            ZonedDateTime checkout = null;
            SearchResult result = null;
            if (!params.getCheckInDate().equals("") && !params.getCheckOutDate().equals("")) {
                String checkIndate[] = params.getCheckInDate().split("-");
                String checkOutdate[] = params.getCheckOutDate().split("-");
                if (checkIndate.length == 3 && checkOutdate.length == 3) {
                    try {
                        checkin = ZonedDateTime.of(LocalDate.of(Integer.parseInt(checkIndate[0]), Integer.parseInt(checkIndate[1]), Integer.parseInt(checkIndate[2])),
                                LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                        checkout = ZonedDateTime.of(LocalDate.of(Integer.parseInt(checkOutdate[0]), Integer.parseInt(checkOutdate[1]), Integer.parseInt(checkOutdate[2])),
                                LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                    } catch (NumberFormatException e) {
                    }
                }

            }

            /**
             * Hotel Id Attribute.
             */
            String strOriginalHotelId = "";//todo change code here when hotelbeds will be added
            if (params.getHotelIDs() != null && params.getHotelIDs().size() > 0) {
                strOriginalHotelId = "" + HotelmappingDAO.getOriginalHotelId(params.getHotelIDs().get(0), null);
                for (Integer hotelId : params.getHotelIDs()) {
                    strOriginalHotelId = strOriginalHotelId + "," + HotelmappingDAO.getOriginalHotelId(hotelId, null);
                }
            }



            /**
             * Children Ages Attributes
             */
            String childrenAges = "";
            if (params.getChildrenAges() != null && params.getChildrenAges().size() > 0) {
                for (int i=0;i< params.getChildrenAges().size();i++ ) {
                    if(i==0)
                        childrenAges = ""+params.getChildrenAges().get(i);
                    else
                        childrenAges = childrenAges + "," + params.getChildrenAges().get(i);
                }
            }


            /**
             * Get original id from Destination table.
             */
            int originalDestinationId = 0;
            String originalDestinationIdStrFormat = "";
            if (params.getDestinationId() != null && !params.getDestinationId().equals("")) {
                DestinationDAO.increaseSortOrderOfDestination(params.getDestinationId());
                originalDestinationId = DestinationDAO.getOriginalDestinationId(params.getDestinationId());
                if (originalDestinationId == 0) {
                    return hotelSearchJSON;
                } else
                    originalDestinationIdStrFormat = String.valueOf(originalDestinationId);
            }

            /**
             * Set sort by
             */
            String sortby="";
            if(params.getSortBy()!=null && params.getSortBy().equals("Rating"))
                sortby="Classification";
            else if(params.getSortBy()!=null && params.getSortBy().equals("Price"))
                sortby="Price";

            long requestTimeElapsed = 0;

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
                NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();
                result = nonStaticXMLAPISoap.searchV2(sunhotelsUsername, sunhotelspass, "English", params.getCurrencyCode(),
                        xmlCheckin, xmlCheckout, params.getNumberOfRooms(), "", originalDestinationIdStrFormat,
                        strOriginalHotelId, "", "", params.getNumberOfAdults(),
                        params.getNumberOfChildren(), childrenAges, params.getInfant(), sortby, params.getSortOrder(),
                        "", "", params.getMealPlans(), "",
                        "", "", "", "",
                        "", "", "", params.getMinPrice(), params.getMaxPrice(), "",
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
            long dbTransactionTimeElapsed = 0;

            /**
             * Response
             */
            if (result != null && result.getError() == null) {

                List<HotelResponse> hotelsResponse = new ArrayList<>();
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
                    atbhotels = HotelDAO.getHotelByDestId(originalDestinationId, sanHotelsProviderId);
                List<HotelmappingBean> hotelsmapping = HotelmappingDAO.getAllProviderHotelsMapping(sanHotelsProviderId);
                dbTransactionTimeElapsed = System.currentTimeMillis() - dbTransactionTimeElapsed;

                /**
                 * Prepare the response data.
                 */
                prepareResponseTimeElapsed = System.currentTimeMillis();
                if (hotelsmapping != null && atbRoomTypes != null & meals != null) {
                    for (Hotel hotel : result.getHotels().getHotel()) {
                        if (originalDestinationId == 0)
                            atbhotels = HotelDAO.getHotelByHotelId(hotel.getHotelId(), sanHotelsProviderId, null);
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
                                                    if (policy.getDeadline() != null && cancelationPolicy.getDeadline()<policy.getDeadline())
                                                        cancelationPolicy.setDeadline(policy.getDeadline()+plusCancelationPolicyHours);
                                                    else if (policy.getDeadline() == null){
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
                                                            roomMealResponse.setMealId(m.getId());
                                                            roomMealResponse.setMealName(m.getName());
                                                            for (PriceWithPaymentMethods price : roomMeal.getPrices().getPrice()) {
                                                                if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                                                                    gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()));
                                                                    if (gsaBean != null) {
                                                                        if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                                                            BigDecimal gsaSale = price.getValue().add(price.getValue().multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                                            if(gsaBean.getOtlMkp()!= null && !gsaBean.getOtlMkp().equals("")) {
                                                                                BigDecimal agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                                                roomMealResponse.setPrice(agentSale);
                                                                            }
                                                                        }
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
                                                if (atbRoomType.getRoomtypeId() == roomtype.getRoomtypeID()) {
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


                                        List<PhotoBean> photos = PhotoDAO.getPhotosByHotelId(hotel.getHotelId(), sanHotelsProviderId, null);
                                        List<HotelfacilityBean> hotelfacilities = HotelfacilityDAO.getFacilitiesByHotelId(hotel.getHotelId(), sanHotelsProviderId, null);
                                        List<Photo> photosResponse = new ArrayList<>();
                                        List<HotelFacility> facilitiesResponse = new ArrayList<>();
                                        HotelFacility hotelFacilityResponse;
                                        Photo photoResponse;
                                        if (photos != null && hotelfacilities != null) {
                                            for (PhotoBean photo : photos) {
                                                photoResponse = new Photo();
                                                photoResponse.setCoverPhoto(photo.isCoverPhoto());
                                                photoResponse.setDescription(photo.getDescription());
                                                photoResponse.setFacilityId(photo.getFacilityId());
                                                photoResponse.setHotelId(atbHotelId);
                                                photoResponse.setId(photo.getId());
                                                photoResponse.setPhotoPath(photo.getPhotoPath());
                                                photoResponse.setPhotoUrl(photo.getPhotoUrl());
                                                photoResponse.setRoomId(photo.getRoomId());
                                                photoResponse.setTitle(photo.getTitle());
                                                photosResponse.add(photoResponse);
                                            }
                                            for (HotelfacilityBean hotelfacility : hotelfacilities) {
                                                hotelFacilityResponse = new HotelFacility();
                                                hotelFacilityResponse.setExplanation(hotelfacility.getExplanation());
                                                hotelFacilityResponse.setFacilityId(hotelfacility.getFacilityId());
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


                hotelSearchJSON.setData(hotelsResponse);

                /**
                 * Store request response to search log.
                 */
                String reuestJsonInString = "";
                String responseJsonInString = "";
                try {
                    responseJsonInString = mapper.writeValueAsString(hotelSearchJSON);
                    reuestJsonInString = mapper.writeValueAsString(params);
                } catch (JsonProcessingException e) {

                }

                ApiUsrSearchLogBean stroreSearchLogBean = new ApiUsrSearchLogBean();
                stroreSearchLogBean.setSearchId(params.getSearchId());
                stroreSearchLogBean.setCurrentSortOrder(params.getSortBy());
                stroreSearchLogBean.setRequest(reuestJsonInString);
                stroreSearchLogBean.setResponse(responseJsonInString);
                stroreSearchLogBean.setCurrentDistricts("");//todo remove it
                stroreSearchLogBean.setCurrentMaxPrice(params.getMaxPrice());
                stroreSearchLogBean.setCurrentMealPlans(params.getMealPlans());
                stroreSearchLogBean.setCurrentMinPrice(params.getMinPrice());
                stroreSearchLogBean.setCurrentSortBy(params.getSortBy());
                stroreSearchLogBean.setCurrentStarRatings(params.getStarRatings());
                hotelSearchJSON.setSearchId(ApiUsrSearchLogDAO.addSearchLogBean(stroreSearchLogBean));

                /**
                 *  Set count of total hotels.
                 */
                hotelSearchJSON.setTotalCount(hotelsResponse.size());


                /**
                 * Send only the x hotels from the list as a response.
                 */
                if (hotelsResponse != null) {
                    int z = 0;
                    for (Iterator<HotelResponse> iter = hotelsResponse.listIterator(); iter.hasNext(); ) {
                        iter.next();
                        if (params.getListStartPosition() > z)
                            iter.remove();
                        if (params.getListLastPosition() < z)
                            iter.remove();
                        z++;
                    }
                }

                hotelSearchJSON.setData(hotelsResponse);
            }


            userlogs.info("Request Varibles: " + " hotelID:" + params.getHotelIDs() + " currencies:" + params.getCurrencyCode() +
                    " infant:" + params.getInfant() + " childrenAges:" + childrenAges + " numberOfChildren:" +
                    params.getNumberOfChildren() + " numberOfRooms:" + params.getNumberOfRooms() + " numberOfAdults:" +
                    params.getNumberOfAdults() + "checkOutDate:" + params.getCheckOutDate() + " checkInDate:" + params.getCheckInDate() +
                    " customerCountry:" + params.getCustomerCountry());

            if (hotelSearchJSON.getData() != null) {
                userlogs.info(" Db transactions time:" + dbTransactionTimeElapsed + ". Sunhotel communication and transactions time:" + requestTimeElapsed +
                        ". Processing time:" + prepareResponseTimeElapsed + " Response Hotels count:" + hotelSearchJSON.getData().size() + ". Destination:" + originalDestinationId);
            } else
                userlogs.info(" Db transactions time:" + dbTransactionTimeElapsed + ". Sunhotel communication and transactions time:" + requestTimeElapsed +
                        ". Processing time:" + prepareResponseTimeElapsed + " Response Hotels count:" + 0 + ". Destination:" + originalDestinationId);
        }else{
            hotelSearchJSON.setErrorMessageText("Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
            hotelSearchJSON.setSuccess(false);
        }
        hotelSearchJSON.setSuccess(true);
        return hotelSearchJSON;

    }
}