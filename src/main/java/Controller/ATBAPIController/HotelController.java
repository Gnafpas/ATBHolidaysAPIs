package Controller.ATBAPIController;

import APIJSONs.ATBAPIJSONs.Hotel.*;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.*;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.RoomMealResponse;
import Beans.ATBDBBeans.KalitaonHotel.*;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.*;
import DAOs.SunHotelsAPIDAOs.*;
import DAOs.SunHotelsAPIDAOs.Room;
import DAOs.SunHotelsAPIDAOs.RoomTypeWithRooms;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static Helper.ProjectProperties.sanHotelsProviderId;
import static Helper.ProjectProperties.sunhotelsUsername;
import static Helper.ProjectProperties.sunhotelspass;

/**
 * Created by George on 05/12/2017.
 */
@RestController
public class HotelController {

    @RequestMapping(value = "/hotel/basicSearch", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public HotelSearchJSON basicSearch(@RequestBody HotelSearchPOST params){

        HotelSearchJSON hotelSearchJSON=new HotelSearchJSON();

        ZonedDateTime checkin=null;//todo notes integration, photo url hiding , keep search prebook book logs
        ZonedDateTime checkout=null;
        SearchResult result=null;
        if(!params.getCheckInDate().equals("") && !params.getCheckOutDate().equals("")) {
            String checkIndate[]=params.getCheckInDate().split("-");
            String checkOutdate[]=params.getCheckOutDate().split("-");
            if(checkIndate.length==3 && checkOutdate.length==3) {
                try {
                    checkin = ZonedDateTime.of(LocalDate.of(Integer.parseInt(checkIndate[0]), Integer.parseInt(checkIndate[1]), Integer.parseInt(checkIndate[2])),
                            LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                    checkout = ZonedDateTime.of(LocalDate.of(Integer.parseInt(checkOutdate[0]), Integer.parseInt(checkOutdate[1]), Integer.parseInt(checkOutdate[2])),
                            LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                }catch(NumberFormatException e){}
            }

        }

        String hotelIds="";
        if(params.getHotelIDs()!=null && params.getHotelIDs().size()>0 ) {
            hotelIds=""+HotelmappingDAO.getOriginalHotelId(params.getHotelIDs().get(0),null);
            for (int hotelid : params.getHotelIDs())
                hotelIds = hotelIds + "," + HotelmappingDAO.getOriginalHotelId(hotelid,null);
        }
        String childrenAges="";
        if(params.getChildrenAges()!=null && params.getChildrenAges().size()>0) {
            childrenAges=""+params.getChildrenAges().get(0);
            for (int childrenage : params.getChildrenAges())
                childrenAges = childrenAges + "," + childrenage;
        }
        String currencies="";
        if(params.getCurrencies()!=null && params.getCurrencies().size()>0) {
            currencies=""+params.getCurrencies().get(0);
            for (String currency : params.getCurrencies())
                currencies = currencies + "," + currency;
        }

        int originalDestinationId=0;
        String originalDestinationIdStrFormat="";
        if(params.getDestinationId()!=null && !params.getDestinationId().equals("")) {
            originalDestinationId = DestinationDAO.getOriginalDestinationId(params.getDestinationId());
            if (originalDestinationId==0){
                return hotelSearchJSON;
            }else
                originalDestinationIdStrFormat=String.valueOf(originalDestinationId);
        }
        try {
            GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
            GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);

            XMLGregorianCalendar xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
            XMLGregorianCalendar xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
            NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
            NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();
            result=nonStaticXMLAPISoap.searchV2(sunhotelsUsername,sunhotelspass,"English",currencies,
                    xmlCheckin,xmlCheckout, params.getNumberOfRooms(),"",originalDestinationIdStrFormat,
                    hotelIds,"","",params.getNumberOfAdults(),
                    params.getNumberOfChildren(), childrenAges,params.getInfant(),"","",
                    "", "","","",
                    "","","", "",
                    "","","","","","",
                    "","","","",
                    "", params.getCustomerCountry(),"");
        }catch(DatatypeConfigurationException e){}catch(NullPointerException e){}


        if(result!=null && result.getError()==null){

            List<HotelResponse> hotelsResponse=new ArrayList<>();
            List<RoomtypeBean> atbRoomTypes=RoomtypeDAO.getRoomsTypesByHotelId(sanHotelsProviderId);
            List<MealBean> meals=MealDAO.getMealsByHotelId(sanHotelsProviderId);
            for(Hotel hotel:result.getHotels().getHotel()) {
                int atbHotelId= HotelmappingDAO.getATBHotelId(hotel.getHotelId(),sanHotelsProviderId,null);
                HotelBean atbhotel= HotelDAO.getHotelByHotelId(hotel.getHotelId(),sanHotelsProviderId);
                List<RoomBean> atbRooms= RoomDAO.getRoomsByHotelId(hotel.getHotelId(),sanHotelsProviderId);

                HotelResponse hotelResponse;
                List<PhotoBean> photos= PhotoDAO.getPhotosByHotelId(hotel.getHotelId(),sanHotelsProviderId);
                List<HotelfacilityBean> hotelfacilities= HotelfacilityDAO.getFacilitiesByHotelId(hotel.getHotelId(),sanHotelsProviderId);
                List<Photo> photosResponse=new ArrayList<>();
                List<Facility> facilitiesResponse=new ArrayList<>();
                Facility facilityResponse;
                Photo photoResponse;
                DestinationBean atbdestinationId;


                if(atbhotel!=null && atbHotelId!=0 && photos!=null && hotelfacilities!=null && atbRooms!=null && atbRoomTypes!=null & meals!=null){
                    atbdestinationId=DestinationDAO.getDestinationBean(atbhotel.getDestinationId(),sanHotelsProviderId);
                    hotelResponse=new HotelResponse();
                    if(atbdestinationId!=null)
                    hotelResponse.setDestinationId(atbdestinationId.getId());
                    hotelResponse.setActive(atbhotel.isActive());
                    hotelResponse.setAddress(atbhotel.getAddress());
                    hotelResponse.setCity(atbhotel.getCity());
                    hotelResponse.setCountry(atbhotel.getCountry());
                    hotelResponse.setCountryCode(atbhotel.getCountryCode());
                    hotelResponse.setCurrencyId(atbhotel.getCurrencyId());
                    hotelResponse.setDescription(atbhotel.getDescription());
                    hotelResponse.setDistrict(atbhotel.getDistrict());
                    hotelResponse.setHotelId(atbHotelId);
                    hotelResponse.setLatitude(atbhotel.getLatitude());
                    hotelResponse.setLongitude(atbhotel.getLongitude());
                    hotelResponse.setMealType(atbhotel.getMealType());
                    hotelResponse.setName(atbhotel.getName());
                    hotelResponse.setStarRating(atbhotel.getStarRating());
                    hotelResponse.setState(atbhotel.getState());
                    hotelResponse.setZipCode(atbhotel.getZipCode());



                    List<RoomTypeWithRoomsResponse> roomTypesWithRoomsResponse=new ArrayList<>();
                    List<RoomResponse> roomsResponse;
                    List<RoomMealResponse> roomMealsResponse=new ArrayList<>();
                    RoomTypeWithRoomsResponse roomTypeWithRoomsResponse;
                    RoomResponse roomResponse;
                    for(RoomTypeWithRooms roomtype: hotel.getRoomtypes().getRoomtype()){
                        roomsResponse=new ArrayList<>();
                        for(Room room :roomtype.getRooms().getRoom()) {
                            for(RoomBean atbRoom:atbRooms){
                                if(atbRoom.getOriginalRoomId()==room.getId()) {
                                    roomResponse=new RoomResponse();
                                    roomResponse.setRoomId(atbRoom.getAtbRoomId());
                                    roomResponse.setBeds(room.getBeds());
                                    roomResponse.setBestBuy(room.isIsBestBuy());
                                    roomResponse.setCancellationPolicies(room.getCancellationPolicies());
                                    roomResponse.setExtrabeds(room.getExtrabeds());
                                    roomResponse.setNotes(room.getNotes());
                                    roomResponse.setSuperDeal(room.isIsSuperDeal());
                                    RoomMealResponse roomMealResponse;
                                    for(RoomMeal roomMeal:room.getMeals().getMeal()) {
                                        roomMealsResponse=new ArrayList<>();
                                        for(MealBean m:meals){
                                            if(roomMeal.getId()==m.getId()){
                                                roomMealResponse=new RoomMealResponse();
                                                roomMealResponse.setDiscount(roomMeal.getDiscount());
                                                roomMealResponse.setMealId(m.getId());
                                                roomMealResponse.setName(m.getName());
                                                roomMealResponse.setPrices(roomMeal.getPrices());
                                                roomMealsResponse.add(roomMealResponse);
                                            }
                                        }
                                    }
                                    roomResponse.setMeals(roomMealsResponse);
                                    roomsResponse.add(roomResponse);
                                }
                            }
                        }
                        for(RoomtypeBean atbRoomType:atbRoomTypes){
                            if(atbRoomType.getRoomtypeId()==roomtype.getRoomtypeID()) {
                                roomTypeWithRoomsResponse = new RoomTypeWithRoomsResponse();
                                roomtype.setRoomtypeID(atbRoomType.getId());
                                roomTypeWithRoomsResponse.setRoomtypeID(atbRoomType.getId());
                                roomTypeWithRoomsResponse.setName(atbRoomType.getRoomType());
                                roomTypeWithRoomsResponse.setRooms(roomsResponse);
                                roomTypeWithRoomsResponse.setSharedRoom(atbRoomType.isSharedRoom());
                                roomTypesWithRoomsResponse.add(roomTypeWithRoomsResponse);
                            }
                        }
                    }
                    hotelResponse.setRoomtypes(roomTypesWithRoomsResponse);



                    for(PhotoBean photo :photos){
                        photoResponse=new Photo();
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
                    for(HotelfacilityBean hotelfacility :hotelfacilities) {
                        facilityResponse=new Facility();
                        facilityResponse.setExplanation(hotelfacility.getExplanation());
                        facilityResponse.setFacilityId(hotelfacility.getFacilityId());
                        facilityResponse.setHotelId(atbHotelId);
                        facilityResponse.setId(hotelfacility.getId());
                        facilityResponse.setPrice(hotelfacility.getPrice());
                        facilitiesResponse.add(facilityResponse);
                    }
                    hotelResponse.setPhotos(photosResponse);
                    hotelResponse.setFacilities(facilitiesResponse);
                    hotelsResponse.add(hotelResponse);

                }


            }
            hotelSearchJSON.setResults(hotelsResponse);
            hotelSearchJSON.setSuccess(true);
        }else if(result!=null){
            hotelSearchJSON.setErrorMessageText(result.getError().getMessage());
            hotelSearchJSON.setSuccess(false);
        }

        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        hotelSearchJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");
        hotelSearchJSON.setTotalCount(hotelSearchJSON.getResults().size());
        return hotelSearchJSON;

    }


    @RequestMapping(value = "/hotel/detailedSearch", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public HotelSearchJSON detailedSearch(@RequestBody HotelSearchPOST params){

        HotelSearchJSON hotelSearchJSON=new HotelSearchJSON();

        ZonedDateTime checkin=null;
        ZonedDateTime checkout=null;
        SearchResult result=null;
        if(!params.getCheckInDate().equals("") && !params.getCheckOutDate().equals("")) {
            String checkIndate[]=params.getCheckInDate().split("-");
            String checkOutdate[]=params.getCheckOutDate().split("-");
            if(checkIndate.length==3 && checkOutdate.length==3) {
                try {
                    checkin = ZonedDateTime.of(LocalDate.of(Integer.parseInt(checkIndate[0]), Integer.parseInt(checkIndate[1]), Integer.parseInt(checkIndate[2])),
                            LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                    checkout = ZonedDateTime.of(LocalDate.of(Integer.parseInt(checkOutdate[0]), Integer.parseInt(checkOutdate[1]), Integer.parseInt(checkOutdate[2])),
                            LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                }catch(NumberFormatException e){}
            }

        }

        String hotelIds="";
        if(params.getHotelIDs()!=null && params.getHotelIDs().size()>0 ) {
            hotelIds=""+HotelmappingDAO.getOriginalHotelId(params.getHotelIDs().get(0),null);
            for (int hotelid : params.getHotelIDs())
                hotelIds = hotelIds + "," + HotelmappingDAO.getOriginalHotelId(hotelid,null);
        }
        String childrenAges="";
        if(params.getChildrenAges()!=null && params.getChildrenAges().size()>0) {
            childrenAges=""+params.getChildrenAges().get(0);
            for (int childrenage : params.getChildrenAges())
                childrenAges = childrenAges + "," + childrenage;
        }
        String currencies="";
        if(params.getCurrencies()!=null && params.getCurrencies().size()>0) {
            currencies=""+params.getCurrencies().get(0);
            for (String currency : params.getCurrencies())
                currencies = currencies + "," + currency;
        }

        int originalDestinationId=0;
        String originalDestinationIdStrFormat="";
        if(params.getDestinationId()!=null && !params.getDestinationId().equals("")) {
            originalDestinationId = DestinationDAO.getOriginalDestinationId(params.getDestinationId());
            if (originalDestinationId==0){
                return hotelSearchJSON;
            }else
                originalDestinationIdStrFormat=String.valueOf(originalDestinationId);
        }
        try {
            GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
            GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);

            XMLGregorianCalendar xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
            XMLGregorianCalendar xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
            NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
            NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();
            result=nonStaticXMLAPISoap.searchV2(sunhotelsUsername,sunhotelspass,"English",currencies,
                    xmlCheckin,xmlCheckout, params.getNumberOfRooms(),"",originalDestinationIdStrFormat,
                    hotelIds,"","",params.getNumberOfAdults(),
                    params.getNumberOfChildren(), childrenAges,params.getInfant(),"","",
                    "", "","","",
                    "","","", "",
                    "","","","","","",
                    "","","","",
                    "", params.getCustomerCountry(),"");
        }catch(DatatypeConfigurationException e){}catch(NullPointerException e){}


        if(result!=null && result.getError()==null){

            List<HotelResponse> hotelsResponse=new ArrayList<>();
            List<RoomtypeBean> atbRoomTypes=RoomtypeDAO.getRoomsTypesByHotelId(sanHotelsProviderId);
            List<MealBean> meals=MealDAO.getMealsByHotelId(sanHotelsProviderId);
            for(Hotel hotel:result.getHotels().getHotel()) {
                int atbHotelId= HotelmappingDAO.getATBHotelId(hotel.getHotelId(),sanHotelsProviderId,null);
                HotelBean atbhotel= HotelDAO.getHotelByHotelId(hotel.getHotelId(),sanHotelsProviderId);

                HotelResponse hotelResponse;
                List<PhotoBean> photos= PhotoDAO.getPhotosByHotelId(hotel.getHotelId(),sanHotelsProviderId);
                List<HotelfacilityBean> hotelfacilities= HotelfacilityDAO.getFacilitiesByHotelId(hotel.getHotelId(),sanHotelsProviderId);
                List<Photo> photosResponse=new ArrayList<>();
                List<Facility> facilitiesResponse=new ArrayList<>();
                Facility facilityResponse;
                Photo photoResponse;
                DestinationBean atbdestinationId;


                if(atbhotel!=null && atbHotelId!=0 && photos!=null && hotelfacilities!=null  && atbRoomTypes!=null & meals!=null){
                    atbdestinationId=DestinationDAO.getDestinationBean(atbhotel.getDestinationId(),sanHotelsProviderId);
                    hotelResponse=new HotelResponse();
                    if(atbdestinationId!=null)
                        hotelResponse.setDestinationId(atbdestinationId.getId());
                    hotelResponse.setActive(atbhotel.isActive());
                    hotelResponse.setAddress(atbhotel.getAddress());
                    hotelResponse.setCity(atbhotel.getCity());
                    hotelResponse.setCountry(atbhotel.getCountry());
                    hotelResponse.setCountryCode(atbhotel.getCountryCode());
                    hotelResponse.setCurrencyId(atbhotel.getCurrencyId());
                    hotelResponse.setDescription(atbhotel.getDescription());
                    hotelResponse.setDistrict(atbhotel.getDistrict());
                    hotelResponse.setHotelId(atbHotelId);
                    hotelResponse.setLatitude(atbhotel.getLatitude());
                    hotelResponse.setLongitude(atbhotel.getLongitude());
                    hotelResponse.setMealType(atbhotel.getMealType());
                    hotelResponse.setName(atbhotel.getName());
                    hotelResponse.setStarRating(atbhotel.getStarRating());
                    hotelResponse.setState(atbhotel.getState());
                    hotelResponse.setZipCode(atbhotel.getZipCode());



                    List<RoomTypeWithRoomsResponse> roomTypesWithRoomsResponse=new ArrayList<>();
                    List<RoomResponse> roomsResponse;
                    List<RoomMealResponse> roomMealsResponse=new ArrayList<>();
                    RoomTypeWithRoomsResponse roomTypeWithRoomsResponse;
                    RoomResponse roomResponse;
                    for(RoomTypeWithRooms roomtype: hotel.getRoomtypes().getRoomtype()){
                        roomsResponse=new ArrayList<>();
                        for(Room room :roomtype.getRooms().getRoom()) {
                            roomResponse=new RoomResponse();
                            roomResponse.setRoomId(room.getId());
                            roomResponse.setBeds(room.getBeds());
                            roomResponse.setBestBuy(room.isIsBestBuy());
                            roomResponse.setCancellationPolicies(room.getCancellationPolicies());
                            roomResponse.setExtrabeds(room.getExtrabeds());
                            roomResponse.setNotes(room.getNotes());
                            roomResponse.setSuperDeal(room.isIsSuperDeal());
                            RoomMealResponse roomMealResponse;
                            for(RoomMeal roomMeal:room.getMeals().getMeal()) {
                                roomMealsResponse=new ArrayList<>();
                                for(MealBean m:meals){
                                    if(roomMeal.getId()==m.getId()){
                                        roomMealResponse=new RoomMealResponse();
                                        roomMealResponse.setDiscount(roomMeal.getDiscount());
                                        roomMealResponse.setMealId(m.getId());
                                        roomMealResponse.setName(m.getName());
                                        roomMealResponse.setPrices(roomMeal.getPrices());
                                        roomMealsResponse.add(roomMealResponse);
                                    }
                                }
                            }
                            roomResponse.setMeals(roomMealsResponse);
                            roomsResponse.add(roomResponse);
                        }
                        for(RoomtypeBean atbRoomType:atbRoomTypes){
                            if(atbRoomType.getRoomtypeId()==roomtype.getRoomtypeID()) {
                                roomTypeWithRoomsResponse = new RoomTypeWithRoomsResponse();
                                roomtype.setRoomtypeID(atbRoomType.getId());
                                roomTypeWithRoomsResponse.setRoomtypeID(atbRoomType.getId());
                                roomTypeWithRoomsResponse.setName(atbRoomType.getRoomType());
                                roomTypeWithRoomsResponse.setRooms(roomsResponse);
                                roomTypeWithRoomsResponse.setSharedRoom(atbRoomType.isSharedRoom());
                                roomTypesWithRoomsResponse.add(roomTypeWithRoomsResponse);
                            }
                        }
                    }
                    hotelResponse.setRoomtypes(roomTypesWithRoomsResponse);



                    for(PhotoBean photo :photos){
                        photoResponse=new Photo();
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
                    for(HotelfacilityBean hotelfacility :hotelfacilities) {
                        facilityResponse=new Facility();
                        facilityResponse.setExplanation(hotelfacility.getExplanation());
                        facilityResponse.setFacilityId(hotelfacility.getFacilityId());
                        facilityResponse.setHotelId(atbHotelId);
                        facilityResponse.setId(hotelfacility.getId());
                        facilityResponse.setPrice(hotelfacility.getPrice());
                        facilitiesResponse.add(facilityResponse);
                    }
                    hotelResponse.setPhotos(photosResponse);
                    hotelResponse.setFacilities(facilitiesResponse);
                    hotelsResponse.add(hotelResponse);

                }


            }
            hotelSearchJSON.setResults(hotelsResponse);
        }else if(result!=null){
            hotelSearchJSON.setErrorMessageText(result.getError().getMessage());
            hotelSearchJSON.setSuccess(false);
        }

        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        hotelSearchJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");
        hotelSearchJSON.setTotalCount(hotelSearchJSON.getResults().size());
        return hotelSearchJSON;

    }
}
