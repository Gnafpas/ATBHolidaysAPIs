package Controller.ATBFrontEndAPI;


import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.*;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsCancelationPolicy;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomMealResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomTypeWithRoomsResponse;
import APIJSONs.ATBAPIJSONs.ViatorATBFrontEnd.Book.ViatorItem;
import APIJSONs.ATBAPIJSONs.ViatorATBFrontEnd.Book.ViatorBookPOST;
import APIJSONs.ATBAPIJSONs.ViatorATBFrontEnd.Book.ViatorTraveller;
import Beans.ATBDBBeans.KalitaonHotel.*;
import Beans.ViatorAPIBeans.Bookings.Book.*;
import Beans.ViatorAPIBeans.Bookings.Cancel.CancelAPIJSON;
import Beans.ViatorAPIBeans.Bookings.Cancel.CancelPOST;
import Beans.ViatorAPIBeans.Bookings.PastBooking.PastBookingAPIJSON;
import Beans.ViatorDBBeans.ViatorProductTourGradeLanguageServicesBean;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.*;
import DAOs.SunHotelsAPIDAOs.*;
import DAOs.ViatorAPIDAOs.BookingsAPIDAO;
import DAOs.ViatorDBDAOs.ViatorProductTourGradeLanguageServicesDAO;
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

import static Helper.ProjectProperties.*;

/**
 * Created by George on 05/12/2017.
 */
@RestController
public class FrontEndAPIServices {



    @RequestMapping(value = "/hotelBookingsController/sunHotelsBook", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public SunHotelsBookJSON hotelBook(@RequestBody SunhotelsBookPOST params){


        BookResult result=null;
        SunHotelsBookJSON  bookJSON=new SunHotelsBookJSON();

        /**
         * Dates request parameters
         */
        ZonedDateTime checkin=null;
        ZonedDateTime checkout=null;
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


        /**
         * RoomtypeId check.Used for recognize provider
         */
        int originalRoomTypeId;
        if(params.getRoomtypeId()==null){
            bookJSON.setSuccess(false);
            bookJSON.setErrorMessageText("Wrong roomtypeId");
            return bookJSON;
        }else{
            originalRoomTypeId=RoomtypeDAO.getOriginalRoomtypeId(params.getRoomtypeId());
            if(originalRoomTypeId==0){
                bookJSON.setSuccess(false);
                bookJSON.setErrorMessageText("Wrong roomtypeId");
                return bookJSON;
            }
        }


        /**
         * Adult,Children count and Names attributes.
         */
        Adult[] adults = new Adult[9];
        for(int i = 0; i < 9; i++) {
            adults[i] = new Adult();
        }

        Children[] children = new Children[9];
        for(int i = 0; i < 9; i++) {
            children[i] = new Children();
        }

        int i = 0;
        int numOfAdults=0;
        if(params.getAdults()!=null) {
            numOfAdults=params.getAdults().size();
            for (Adult adult : params.getAdults()) {
                if (i > 8)
                    break;
                adults[i].setFirst_name(adult.getFirst_name());
                adults[i].setLast_name(adult.getLast_name());
                i++;
            }
        }
        i = 0;
        int numOfChildren=0;
        if(params.getChildren()!=null) {
            numOfChildren=params.getChildren().size();
            for (Children child : params.getChildren()) {
                if (i > 8)
                    break;
                children[i].setFirst_name(child.getFirst_name());
                children[i].setLast_name(child.getLast_name());
                children[i].setAge(child.getAge());
                i++;
            }
        }


        /**
         * Book request.
         */
        try {
            GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
            GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);

            XMLGregorianCalendar xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
            XMLGregorianCalendar xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
            NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
            NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();
            result=nonStaticXMLAPISoap.bookV2(sunhotelsUsername,sunhotelspass,params.getCurrency(),"English",
                    params.getEmail(),xmlCheckin,xmlCheckout,params.getRoomId(),params.getRooms(),
                    numOfAdults,numOfChildren,params.getInfant(),"","",
                    params.getMealId(),adults[0].getFirst_name(),adults[0].getLast_name(),adults[1].getFirst_name(),adults[1].getLast_name(),
                    adults[2].getFirst_name(),adults[2].getLast_name(),adults[3].getFirst_name(),adults[3].getLast_name(),adults[4].getFirst_name(),
                    adults[4].getLast_name(),adults[5].getFirst_name(),adults[5].getLast_name(),adults[6].getFirst_name(),adults[6].getLast_name(),
                    adults[7].getFirst_name(),adults[7].getLast_name(),adults[8].getFirst_name(),adults[8].getLast_name(),children[0].getFirst_name(),
                    children[0].getLast_name(),children[0].getAge(),children[1].getFirst_name(),children[1].getLast_name(),children[1].getAge(),
                    children[2].getFirst_name(),children[2].getLast_name(),children[2].getAge(),children[3].getFirst_name(),children[3].getLast_name(),
                    children[3].getAge(),children[4].getFirst_name(),children[4].getLast_name(),children[4].getAge(),children[5].getFirst_name(),
                    children[5].getLast_name(),children[5].getAge(),children[6].getFirst_name(),children[6].getLast_name(),children[6].getAge(),
                    children[7].getFirst_name(),children[7].getLast_name(),children[7].getAge(),children[8].getFirst_name(),children[8].getLast_name(),
                    children[8].getAge(),1,"","","","","","","",
                    "",params.getCustomerCountry(),"","","");
        }catch(DatatypeConfigurationException e){}catch(NullPointerException e){}

        /**
         * Response
         */
        if(result.getError()!=null) {
            bookJSON.setErrorMessageText(result.getError().getMessage());
            bookJSON.setSuccess(false);
        }
        else{
            bookJSON.setBookResult(result.getBooking());
            bookJSON.setSuccess(true);
        }

        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        bookJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");
        return bookJSON;

    }



    @RequestMapping(value = "/hotelBookingsController/sunHotelsPrebook", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public SunHotelsPrebookJSON hotelPrebook(@RequestBody SunHotelsPrebookPOST params){

        PreBookResult result=null;
        SunHotelsPrebookJSON  prebookJSON=new SunHotelsPrebookJSON();

        /**
         * Dates request parameters
         */
        ZonedDateTime checkin=null;
        ZonedDateTime checkout=null;
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


        /**
        * RoomtypeId check.Used for recognize provider
        */
        int originalRoomTypeId;
        if(params.getRoomtypeId()==null){
            prebookJSON.setSuccess(false);
            prebookJSON.setErrorMessageText("Wrong roomtypeId");
            return prebookJSON;
        }else{
            originalRoomTypeId=RoomtypeDAO.getOriginalRoomtypeId(params.getRoomtypeId());
            if(originalRoomTypeId==0){
                prebookJSON.setSuccess(false);
                prebookJSON.setErrorMessageText("Wrong roomtypeId");
                return prebookJSON;
            }
        }

        /**
         * Childern Ages Attributes
         */
        String childrenAges="";
        if(params.getChildrenAges()!=null && params.getChildrenAges().size()>0) {
            childrenAges=""+params.getChildrenAges().get(0);
            for (int childrenage : params.getChildrenAges())
                childrenAges = childrenAges + "," + childrenage;
        }

        /**
         * PreBook request.
         */
        try {
            GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
            GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);

            XMLGregorianCalendar xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
            XMLGregorianCalendar xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
            NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
            NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();
            result=nonStaticXMLAPISoap.preBookV2(sunhotelsUsername,sunhotelspass,params.getCurrency(),"English",
                    xmlCheckin,xmlCheckout,params.getRooms(),params.getAdults(),params.getChildren(),
                    childrenAges,params.getInfant(),params.getMealId(),params.getCustomerCountry(),"",
                    params.getSearchPrice(),params.getRoomId(),"","",params.getBlockSuperDeal(),
                    params.getShowPriceBreakdown());
        }catch(DatatypeConfigurationException e){}catch(NullPointerException e){}


        /**
         * Response
         */
        if(result.getError()!=null) {
            prebookJSON.setErrorMessageText(result.getError().getMessage());
            prebookJSON.setSuccess(false);
        }
        else{
            prebookJSON.setCancelationPolicies(result.getCancellationPolicies());
            prebookJSON.setNotes(result.getNotes());
            prebookJSON.setPrice(result.getPrice());
            prebookJSON.setPriceBreakDown(result.getPriceBreakdown());
            prebookJSON.setRoomId(result.getRoomId());
            prebookJSON.setSuccess(true);
        }

        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        prebookJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");
        return prebookJSON;

    }




    @RequestMapping(value = "/hotel/noPicturesSearch", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public SunHotelsSearchJSON noPicturesSearch(@RequestBody SunHotelsSearchPOST params){

        SunHotelsSearchJSON hotelSearchJSON=new SunHotelsSearchJSON();

        /**
         * Dates request parameters
         */
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

        /**
         * Hotel Id Attribute.
         */
        String strOriginalHotelId="";
        if( !params.getHotelID().equals("")) {
           if(params.getProviderId()!=0)
                strOriginalHotelId=params.getHotelID();
        }

        /**
         * Childern Ages Attributes
         */
        String childrenAges="";
        if(params.getChildrenAges()!=null && params.getChildrenAges().size()>0) {
            childrenAges=""+params.getChildrenAges().get(0);
            for (int childrenage : params.getChildrenAges())
                childrenAges = childrenAges + "," + childrenage;
        }

        /**
         * Currencies Attributes
         */
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
                    strOriginalHotelId,"","",params.getNumberOfAdults(),
                    params.getNumberOfChildren(), childrenAges,params.getInfant(),params.getSortBy(),params.getSortOrder(),
                    "", "","","",
                    "","","", "",
                    "","","",params.getMinPrice(),params.getMaxPrice(),"",
                    "","","","",
                    "", params.getCustomerCountry(),"");
        }catch(DatatypeConfigurationException e){}catch(NullPointerException e){}




        if(result!=null && result.getError()==null){

            List<SunHotelsResponse> hotelsResponse=new ArrayList<>();
            List<RoomtypeBean> atbRoomTypes=RoomtypeDAO.getRoomsTypesByHotelId(sanHotelsProviderId);
            List<MealBean> meals=MealDAO.getMealsByHotelId(sanHotelsProviderId);
            for(Hotel hotel:result.getHotels().getHotel()) {
                int atbHotelId= HotelmappingDAO.getATBHotelId(hotel.getHotelId(),sanHotelsProviderId,null);
                HotelBean atbhotel= HotelDAO.getHotelByHotelId(hotel.getHotelId(),sanHotelsProviderId);
                SunHotelsResponse hotelResponse;
                List<PhotoBean> photos= PhotoDAO.getPhotosByHotelId(hotel.getHotelId(),sanHotelsProviderId);
                List<HotelfacilityBean> hotelfacilities= HotelfacilityDAO.getFacilitiesByHotelId(hotel.getHotelId(),sanHotelsProviderId);
                DestinationBean atbdestinationId;


                if(atbhotel!=null && atbHotelId!=0 && photos!=null && hotelfacilities!=null && atbRoomTypes!=null & meals!=null){
                    atbdestinationId=DestinationDAO.getDestinationBean(atbhotel.getDestinationId(),sanHotelsProviderId);
                    hotelResponse=new SunHotelsResponse();
                    if(atbdestinationId!=null)

                    hotelResponse.setAddress(atbhotel.getAddress());
                    hotelResponse.setCity(atbhotel.getCity());
                    hotelResponse.setCountry(atbhotel.getCountry());
                    hotelResponse.setDescription(atbhotel.getDescription());
                    hotelResponse.setDistrict(atbhotel.getCity());
                    hotelResponse.setId(atbHotelId);
                    hotelResponse.setLatitude(atbhotel.getLatitude());
                    hotelResponse.setLongitude(atbhotel.getLongitude());
                    hotelResponse.setName(atbhotel.getName());
                    hotelResponse.setStar_rating(atbhotel.getStarRating());
                    hotelResponse.setState(atbhotel.getState());
                    hotelResponse.setZip_code(atbhotel.getZipCode());
                    hotelResponse.setCountry_code(atbhotel.getCountryCode());



                    List<SunHotelsRoomTypeWithRoomsResponse> roomTypesWithRoomsResponse=new ArrayList<>();
                    List<SunHotelsRoomResponse> roomsResponse;
                    List<SunHotelsRoomMealResponse> roomMealsResponse=new ArrayList<>();
                    SunHotelsRoomTypeWithRoomsResponse roomTypeWithRoomsResponse;
                    SunHotelsRoomResponse roomResponse;
                    for(RoomTypeWithRooms roomtype: hotel.getRoomtypes().getRoomtype()){
                        roomsResponse=new ArrayList<>();
                        for(Room room :roomtype.getRooms().getRoom()) {
                            roomResponse=new SunHotelsRoomResponse();
                            roomResponse.setRoomId(room.getId());
                            roomResponse.setBeds(room.getBeds());
                            List<SunHotelsCancelationPolicy> cancelationPolicies=new ArrayList<>();
                            SunHotelsCancelationPolicy cancelationPolicy;
                            for(PercentageCancellationPolicy policy:room.getCancellationPolicies().getCancellationPolicy()){
                                cancelationPolicy=new SunHotelsCancelationPolicy();
                                if(policy.getDeadline()!=null)
                                    cancelationPolicy.setDeadline(policy.getDeadline());
                                cancelationPolicy.setPercentage(policy.getPercentage());
                                cancelationPolicies.add(cancelationPolicy);
                            }
                            roomResponse.setCancellationPolicies(cancelationPolicies);
                            roomResponse.setExtrabeds(room.getExtrabeds());
                            SunHotelsRoomMealResponse roomMealResponse;
                            for(RoomMeal roomMeal:room.getMeals().getMeal()) {
                                roomMealsResponse=new ArrayList<>();
                                for(MealBean m:meals){
                                    if(roomMeal.getId()==m.getId()){
                                        roomMealResponse=new SunHotelsRoomMealResponse();
                                        roomMealResponse.setMealId(m.getId());
                                        roomMealResponse.setMealName(m.getName());
                                        for(PriceWithPaymentMethods price:roomMeal.getPrices().getPrice()){
                                            roomMealResponse.setPrice(price.getValue());
                                        }
                                        roomMealsResponse.add(roomMealResponse);
                                    }
                                }
                            }
                            roomResponse.setMeals(roomMealsResponse);
                            roomsResponse.add(roomResponse);
                        }
                        for(RoomtypeBean atbRoomType:atbRoomTypes){
                            if(atbRoomType.getRoomtypeId()==roomtype.getRoomtypeID()) {
                                roomTypeWithRoomsResponse = new SunHotelsRoomTypeWithRoomsResponse();
                                roomtype.setRoomtypeID(atbRoomType.getId());
                                roomTypeWithRoomsResponse.setRoomTypeId(atbRoomType.getId());
                                roomTypeWithRoomsResponse.setRoomType(atbRoomType.getRoomType());
                                roomTypeWithRoomsResponse.setRooms(roomsResponse);
                                roomTypesWithRoomsResponse.add(roomTypeWithRoomsResponse);
                            }
                        }
                    }
                    hotelResponse.setRoom_types(roomTypesWithRoomsResponse);


                    hotelsResponse.add(hotelResponse);

                }
            }

            /**
             * Set 10 4star Hotels at the beggining of the list from cheap to expensive.
             */
            int foutStarHotelsCount=0;
            for(int i=0;i<hotelsResponse.size();i++){
                if(foutStarHotelsCount>9)
                    break;
                if(hotelsResponse.get(i).getStar_rating()!=null && hotelsResponse.get(i).getStar_rating().length()>0) {
                    if (Character.getNumericValue(hotelsResponse.get(i).getStar_rating().charAt(0)) == 4) {
                        SunHotelsResponse hotel;
                        hotel=hotelsResponse.get(i);
                        hotelsResponse.remove(i);
                        hotelsResponse.add(foutStarHotelsCount,hotel);
                        foutStarHotelsCount++;
                    }
                }
            }

            hotelSearchJSON.setResults(hotelsResponse);
        }

        return hotelSearchJSON;

    }

    @RequestMapping(value = "/booking/viatorBook", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public BookAPIJSON bookViator(@RequestBody ViatorBookPOST vBookPOST){

        BookPOST bookPOST=new BookPOST();

        bookPOST.setBooker(vBookPOST.getBooker());
        bookPOST.setCurrencyCode(vBookPOST.getCurrencyCode());
        bookPOST.setDemo(vBookPOST.isDemo());

        Item item;
        List<Item> items=new ArrayList<>();
        int distributorItemRef=0;
        if(vBookPOST.getItems()!=null)
        for(ViatorItem it:vBookPOST.getItems()){
            item=new Item();
            item.setBookingQuestionAnswers(it.getBookingQuestionAnswers());
            item.setHotelId(it.getHotelId());
            item.setPickupPoint(it.getPickupPoint());
            item.setProductCode(it.getProductCode());
            item.setSpecialRequirements(it.getSpecialRequirements());
            item.setTourGradeCode(it.getTourGradeCode());
            item.setTravelDate(it.getTravelDate());


            /**
             * Set service and language option //todo ask if viator is gonna add more languages than english in the fueature.If yes the code bellow must be changed
             */
            boolean languageOptionCodeisSet=false;
            List<ViatorProductTourGradeLanguageServicesBean> tourgradeServices=ViatorProductTourGradeLanguageServicesDAO.getLanguageServicesByProductCodeAndTourGrade(it.getProductCode(),it.getTourGradeCode());
            if(tourgradeServices!=null) {
                for (ViatorProductTourGradeLanguageServicesBean tourgradeService : tourgradeServices) {
                    if (tourgradeService.getLanguageCodeAndService().equals("en/ENGLISH_ONLY")) {
                        item.setLanguageOptionCode("en/ENGLISH_ONLY");
                        languageOptionCodeisSet=true;
                        break;
                    }
                }
            }
            if(!languageOptionCodeisSet){
                if(it.getServiceOption().equals("live"))
                    item.setLanguageOptionCode("en/SERVICE_GUIDE");
                else if(it.getServiceOption().equals("booklet"))
                    item.setLanguageOptionCode("en/SERVICE_WRITTEN");
                else if(it.getServiceOption().equals("audio"))
                    item.setLanguageOptionCode("en/SERVICE_AUDIO");
            }

            PartnerItemDetail partnerItemDetail=new PartnerItemDetail();
            distributorItemRef++;
            partnerItemDetail.setDistributorItemRef(""+distributorItemRef);
            item.setPartnerItemDetail(partnerItemDetail);

            Traveller  traveller;
            List<Traveller> travellers=new ArrayList<>();
            for(ViatorTraveller tr:it.getTravellers()){
                traveller=new Traveller();

                if (tr.getPersonType().equals("adult"))
                    traveller.setBandId(1);
                else if (tr.getPersonType().equals("child"))
                    traveller.setBandId(2);
                else if (tr.getPersonType().equals("infant"))
                    traveller.setBandId(3);
                else if (tr.getPersonType().equals("youth"))
                    traveller.setBandId(4);
                else if (tr.getPersonType().equals("senior"))
                    traveller.setBandId(5);
                traveller.setFirstname(tr.getFirstname());
                traveller.setLeadTraveller(tr.isLeadTraveller());
                traveller.setSurname(tr.getSurname());
                traveller.setTitle(tr.getTitle());
                travellers.add(traveller);
            }
            item.setTravellers(travellers);
            items.add(item);
        }

        bookPOST.setItems(items);
        bookPOST.setNewsletterSignUp(false);

        PartnerDetail partenerDetail=new PartnerDetail();
        partenerDetail.setDistributorRef(vBookPOST.getBookRef());
        bookPOST.setPartnerDetail(partenerDetail);
        return BookingsAPIDAO.book(bookPOST);
    }

    @RequestMapping(value = "/booking/viatorCancel", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public CancelAPIJSON cancelViator(@RequestBody CancelPOST cancelPOST){
        return BookingsAPIDAO.cancellation(cancelPOST);
    }

    @RequestMapping(value = "/booking/viatorPastBooking", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public PastBookingAPIJSON pastBookingiator(@RequestParam(value = "email", defaultValue = "") String email,
                                               @RequestParam(value = "itineraryId", defaultValue = "") int itineraryId){
        return BookingsAPIDAO.pastbooking(email,itineraryId);
    }

}
