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
import Beans.ATBDBBeans.KalitaonSystem.SubAgencyBean;
import Beans.ViatorAPIBeans.Bookings.Book.*;
import Beans.ViatorAPIBeans.Bookings.Cancel.CancelAPIJSON;
import Beans.ViatorAPIBeans.Bookings.Cancel.CancelPOST;
import Beans.ViatorAPIBeans.Bookings.PastBooking.PastBookingAPIJSON;
import Beans.ViatorDBBeans.ViatorProductTourGradeLanguageServicesBean;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.*;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.SubAgencyDAO;
import DAOs.SunHotelsAPIDAOs.*;
import DAOs.ViatorAPIDAOs.BookingsAPIDAO;
import DAOs.ViatorDBDAOs.ViatorProductTourGradeLanguageServicesDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.awt.*;
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
import java.util.List;

import static Controller.Application.errLogger;
import static Controller.Application.userlogs;
import static Helper.ProjectProperties.*;

/**
 * Created by George on 05/12/2017.
 */
@RestController
public class FrontEndAPIServices {



    @RequestMapping(value = "/hotelBookingsController/sunHotelsBook", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public SunHotelsBookJSON hotelBook(@RequestBody SunhotelsBookPOST params,@RequestParam("apiKey") String apiKey){


        BookResult result=null;
        SunHotelsBookJSON  bookJSON=new SunHotelsBookJSON();

        SubAgencyBean subAgencyBean;
        String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + apiKey;
        String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
        subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);

        if (subAgencyBean != null) {
            if (subAgencyBean.getAgentName()==null || !subAgencyBean.getAgentName().equals("Nafpas")) {
                bookJSON.setSuccess(false);
                bookJSON.setErrorType("Authentication");
                bookJSON.setErrorMessageText("Wrong API key");
                return bookJSON;
            }

            /**
             * Dates request parameters
             */
            ZonedDateTime checkin = null;
            ZonedDateTime checkout = null;
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
             * RoomtypeId check.Used for recognize provider
             */
            int originalRoomTypeId;
            if (params.getRoomtypeId() == null) {
                bookJSON.setSuccess(false);
                bookJSON.setErrorMessageText("Wrong roomtypeId");
                return bookJSON;
            } else {
                originalRoomTypeId = RoomtypeDAO.getOriginalRoomtypeId(params.getRoomtypeId());
                if (originalRoomTypeId == 0) {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorMessageText("Wrong roomtypeId");
                    return bookJSON;
                }
            }


            /**
             * Adult,Children count and Names attributes.
             */
            Adult[] adults = new Adult[9];
            for (int i = 0; i < 9; i++) {
                adults[i] = new Adult();
            }

            Children[] children = new Children[9];
            for (int i = 0; i < 9; i++) {
                children[i] = new Children();
            }

            int i = 0;
            int numOfAdults = 0;
            if (params.getAdults() != null) {
                numOfAdults = params.getAdults().size();
                for (Adult adult : params.getAdults()) {
                    if (i > 8)
                        break;
                    adults[i].setFirst_name(adult.getFirst_name());
                    adults[i].setLast_name(adult.getLast_name());
                    i++;
                }
            }
            i = 0;
            int numOfChildren = 0;
            if (params.getChildren() != null) {
                numOfChildren = params.getChildren().size();
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
                result = nonStaticXMLAPISoap.bookV2(sunhotelsUsername, sunhotelspass, params.getCurrency(), "English",
                        params.getEmail(), xmlCheckin, xmlCheckout, params.getRoomId(), params.getRooms(),
                        numOfAdults, numOfChildren, params.getInfant(), "", "",
                        params.getMealId(), adults[0].getFirst_name(), adults[0].getLast_name(), adults[1].getFirst_name(), adults[1].getLast_name(),
                        adults[2].getFirst_name(), adults[2].getLast_name(), adults[3].getFirst_name(), adults[3].getLast_name(), adults[4].getFirst_name(),
                        adults[4].getLast_name(), adults[5].getFirst_name(), adults[5].getLast_name(), adults[6].getFirst_name(), adults[6].getLast_name(),
                        adults[7].getFirst_name(), adults[7].getLast_name(), adults[8].getFirst_name(), adults[8].getLast_name(), children[0].getFirst_name(),
                        children[0].getLast_name(), children[0].getAge(), children[1].getFirst_name(), children[1].getLast_name(), children[1].getAge(),
                        children[2].getFirst_name(), children[2].getLast_name(), children[2].getAge(), children[3].getFirst_name(), children[3].getLast_name(),
                        children[3].getAge(), children[4].getFirst_name(), children[4].getLast_name(), children[4].getAge(), children[5].getFirst_name(),
                        children[5].getLast_name(), children[5].getAge(), children[6].getFirst_name(), children[6].getLast_name(), children[6].getAge(),
                        children[7].getFirst_name(), children[7].getLast_name(), children[7].getAge(), children[8].getFirst_name(), children[8].getLast_name(),
                        children[8].getAge(), 1, "", "", "", "", "", "", "",
                        "", params.getCustomerCountry(), "", "", params.getPrebookcode());
            } catch (DatatypeConfigurationException e) {
            } catch (NullPointerException e) {
            }

            /**
             * Response
             */
            if (result.getError() != null) {
                bookJSON.setErrorMessageText(result.getError().getMessage());
                bookJSON.setSuccess(false);
                bookJSON.setErrorType(result.getError().getErrorType());
            } else {
                bookJSON.setBookResult(result.getBooking());
                bookJSON.setSuccess(true);
            }
        }else {
            bookJSON.setSuccess(false);
            bookJSON.setErrorType("Authentication");
            bookJSON.setErrorMessageText("Wrong API key");
            return bookJSON;
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
            for (int i=1;i<params.getChildrenAges().size();i++)
                childrenAges = childrenAges + "," + params.getChildrenAges().get(i);
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
            prebookJSON.setPreBookCode(result.getPreBookCode());
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

//        long w=System.currentTimeMillis();
//        /**
//         * Get search from search log if exists.Prepare according to new parameters and send back.
//         */
//        ObjectMapper mapper = new ObjectMapper();
//        SearchLogBean  retrieveSearchLogBean=SearchLogDAO.getSearchLogBean(params.getSearchId());
//        if(retrieveSearchLogBean!=null) {
//            SunHotelsSearchJSON retrieveResponse=new SunHotelsSearchJSON();
//            try {
//                retrieveResponse = mapper.readValue(retrieveSearchLogBean.getResponse(),SunHotelsSearchJSON.class);
//
//
//                boolean filtersChanged=false;
//                /**
//                 * Update search log.
//                 */
//                if(params.getStarRatings()!=null && !params.getStarRatings().equals("")) {
//                    retrieveSearchLogBean.setCurrentStarRatings(params.getStarRatings());
//                    filtersChanged=true;
//                }
//                if(params.getSortBy()!=null && !params.getSortBy().equals("")) {
//                    retrieveSearchLogBean.setCurrentSortBy(params.getSortBy());
//                    filtersChanged=true;
//                }
//                if(params.getMinPrice()!=null && !params.getMinPrice().equals("")) {
//                    retrieveSearchLogBean.setCurrentMinPrice(params.getMinPrice());
//                    filtersChanged=true;
//                }
//                if(params.getMealPlans()!=null && !params.getMealPlans().equals("")) {
//                    retrieveSearchLogBean.setCurrentMealPlans(params.getMealPlans());
//                    filtersChanged=true;
//                }
//                if(params.getMaxPrice()!=null && !params.getMaxPrice().equals("")) {
//                    retrieveSearchLogBean.setCurrentMaxPrice(params.getMaxPrice());
//                    filtersChanged=true;
//                }
//                if(params.getDistricts()!=null && !params.getDistricts().equals("")) {
//                    retrieveSearchLogBean.setCurrentDistricts(params.getDistricts());
//                    filtersChanged=true;
//                }
//                if(params.getSortOrder()!=null && !params.getSortOrder().equals("")) {
//                    retrieveSearchLogBean.setCurrentSortOrder(params.getSortOrder());
//                    filtersChanged=true;
//                }
//
//                /**
//                 * If filters changed set pointer to the top of the list.If not set pointer to the next x hotels of the list.Pointer is the field DisplayedHotels in DB
//                 */
//                if(filtersChanged)
//                    retrieveSearchLogBean.setCurrentDisplayedHotels(countOfDisplayedHotels);
//                else
//                    retrieveSearchLogBean.setCurrentDisplayedHotels(retrieveSearchLogBean.getCurrentDisplayedHotels()+countOfDisplayedHotels);
//
//                SearchLogDAO.updateSearchLogBean(retrieveSearchLogBean);
//
//                /**
//                 * Filters for the list.
//                 */
//                boolean removeHotelForStarRating;
//                boolean removeHotelForMaxPrice;
//                boolean removeHotelForMinPrice;
//                boolean removeHotelForDistricts;
//                boolean removeHotelForMeals;
//                for (Iterator<SunHotelsResponse> iter = retrieveResponse.getResults().listIterator(); iter.hasNext(); ) {
//                    SunHotelsResponse hotel = iter.next();
//                    removeHotelForStarRating=true;
//                    removeHotelForMaxPrice=true;
//                    removeHotelForMinPrice=true;
//                    removeHotelForDistricts=true;
//                    removeHotelForMeals=true;
//                    if(retrieveSearchLogBean.getCurrentStarRatings()!=null && !retrieveSearchLogBean.getCurrentStarRatings().equals("")) {
//                        String[] split = retrieveSearchLogBean.getCurrentStarRatings().split(",");//todo fix issue with 3+,4+ ratings and space in strings
//                        for(int i=0;i<split.length;i++){
//                            if(hotel.getStar_rating().equals(split[i]))
//                                removeHotelForStarRating=false;
//                        }
//                    }else
//                        removeHotelForStarRating=false;
//                    if(retrieveSearchLogBean.getCurrentDistricts()!=null && !retrieveSearchLogBean.getCurrentDistricts().equals("")){
//                        String[] split =retrieveSearchLogBean.getCurrentDistricts().split(",");
//                        for(int i=0;i<split.length;i++){
//                            if(hotel.getDistrict().equals(split[i]))
//                                removeHotelForDistricts=false;
//                        }
//                    }else
//                        removeHotelForDistricts=false;
//                    if(retrieveSearchLogBean.getCurrentMealPlans()!=null && !retrieveSearchLogBean.getCurrentMealPlans().equals("")){
//                        String[] split = retrieveSearchLogBean.getCurrentMealPlans().split(",");//todo fix space in strings
//                        for(int i=0;i<split.length;i++){
//                            for(SunHotelsRoomTypeWithRoomsResponse roomtype:hotel.getRoom_types()){
//                                for(SunHotelsRoomResponse room:roomtype.getRooms()){
//                                    for(SunHotelsRoomMealResponse meal:room.getMeals()){
//                                        if(meal.getMealName().equals(split[i]))
//                                            removeHotelForMeals=false;
//                                    }
//                                }
//                            }
//                        }
//                    }else
//                        removeHotelForMeals=false;
//                    if(retrieveSearchLogBean.getCurrentMinPrice()!=null && !retrieveSearchLogBean.getCurrentMinPrice().equals("")) {
//                        for (SunHotelsRoomTypeWithRoomsResponse roomtype : hotel.getRoom_types()) {
//                            for (SunHotelsRoomResponse room : roomtype.getRooms()) {
//                                for(SunHotelsRoomMealResponse meal:room.getMeals()){
//                                    if(Double.parseDouble(meal.getPrice().toString()) > Double.parseDouble(retrieveSearchLogBean.getCurrentMinPrice())){
//                                        removeHotelForMinPrice = false;
//                                    }
//                                }
//                            }
//                        }
//                    }else
//                        removeHotelForMinPrice=false;
//                    if(retrieveSearchLogBean.getCurrentMaxPrice()!=null && !retrieveSearchLogBean.getCurrentMaxPrice().equals("")) {
//                        for (SunHotelsRoomTypeWithRoomsResponse roomtype : hotel.getRoom_types()) {
//                            for (SunHotelsRoomResponse room : roomtype.getRooms()) {
//                                for(SunHotelsRoomMealResponse meal:room.getMeals()){
//                                    if(Double.parseDouble(meal.getPrice().toString()) < Double.parseDouble(retrieveSearchLogBean.getCurrentMaxPrice())){
//                                        removeHotelForMaxPrice = false;
//                                    }
//                                }
//                            }
//                        }
//                    }else
//                        removeHotelForMaxPrice=false;
//
//                    if(removeHotelForMaxPrice==true || removeHotelForMinPrice==true || removeHotelForMeals==true || removeHotelForDistricts==true || removeHotelForStarRating==true)
//                        iter.remove();
//                }
//
//                /**
//                 * Sort Order By ratting
//                 */
//                if(retrieveSearchLogBean.getCurrentSortBy()!=null && retrieveSearchLogBean.getCurrentSortBy().equals("Ratting")){
//                    if(retrieveSearchLogBean.getCurrentSortOrder()!=null && retrieveSearchLogBean.getCurrentSortOrder().equals("Ascending")){
//                        Collections.sort(retrieveResponse.getResults(), SunHotelsResponse.Comparators.ratting);
//                    }
//                    else if(retrieveSearchLogBean.getCurrentSortOrder()!=null && retrieveSearchLogBean.getCurrentSortOrder().equals("Descending")){
//                        Collections.sort(retrieveResponse.getResults(), SunHotelsResponse.Comparators.ratting.reversed());
//                    }
//                }
//                /**
//                 * Sort Order By price.
//                 */
//                if(retrieveSearchLogBean.getCurrentSortBy()!=null && retrieveSearchLogBean.getCurrentSortBy().equals("Price")){
//                    BigDecimal hotelMinprice;
//                    BigDecimal nextHotelMinprice;
//                    if(retrieveSearchLogBean.getCurrentSortOrder()!=null && retrieveSearchLogBean.getCurrentSortOrder().equals("Ascending")){
//
//                        for(int i=0;i<retrieveResponse.getResults().size();i++){
//                            for(int z=0;z<retrieveResponse.getResults().size();z++) {
//                                if(z!=i) {
//                                    if(retrieveResponse.getResults().get(i).getRoom_types()!=null
//                                        && retrieveResponse.getResults().get(i).getRoom_types().size()>0
//                                        && retrieveResponse.getResults().get(i).getRoom_types().get(0).getRooms()!=null
//                                        && retrieveResponse.getResults().get(i).getRoom_types().get(0).getRooms().size()>0
//                                        && retrieveResponse.getResults().get(i).getRoom_types().get(0).getRooms().get(0).getMeals()!=null
//                                        && retrieveResponse.getResults().get(i).getRoom_types().get(0).getRooms().get(0).getMeals().size()>0
//                                        && retrieveResponse.getResults().get(z).getRoom_types()!=null
//                                        && retrieveResponse.getResults().get(z).getRoom_types().size()>0
//                                        && retrieveResponse.getResults().get(z).getRoom_types().get(0).getRooms()!=null
//                                        && retrieveResponse.getResults().get(z).getRoom_types().get(0).getRooms().size()>0
//                                        && retrieveResponse.getResults().get(z).getRoom_types().get(0).getRooms().get(0).getMeals()!=null
//                                        && retrieveResponse.getResults().get(z).getRoom_types().get(0).getRooms().get(0).getMeals().size()>0) {
//
//                                        hotelMinprice = retrieveResponse.getResults().get(i).getRoom_types().get(0).getRooms().get(0).getMeals().get(0).getPrice();
//                                        for (SunHotelsRoomTypeWithRoomsResponse roomtype : retrieveResponse.getResults().get(i).getRoom_types()) {
//                                            for (SunHotelsRoomResponse room : roomtype.getRooms()) {
//                                                if (room.getMeals() != null && room.getMeals().size() > 0) {
//                                                    for (SunHotelsRoomMealResponse meal : room.getMeals()) {
//                                                        if (hotelMinprice.compareTo(meal.getPrice()) == 1)
//                                                            hotelMinprice = meal.getPrice();
//                                                    }
//                                                }
//                                            }
//                                        }
//                                        nextHotelMinprice = retrieveResponse.getResults().get(z).getRoom_types().get(0).getRooms().get(0).getMeals().get(0).getPrice();
//                                        for (SunHotelsRoomTypeWithRoomsResponse nextRoomtype : retrieveResponse.getResults().get(z).getRoom_types()) {
//                                            for (SunHotelsRoomResponse nextRoom : nextRoomtype.getRooms()) {
//                                                if (nextRoom.getMeals() != null && nextRoom.getMeals().size() > 0) {
//                                                    for (SunHotelsRoomMealResponse meal : nextRoom.getMeals()) {
//                                                        if (nextHotelMinprice.compareTo(meal.getPrice()) == 1)
//                                                            nextHotelMinprice = meal.getPrice();
//                                                    }
//                                                }
//                                            }
//                                        }
//                                        if (hotelMinprice.compareTo(nextHotelMinprice) == -1) {
//                                            SunHotelsResponse tmp1 = retrieveResponse.getResults().get(z);
//                                            SunHotelsResponse tmp2 = retrieveResponse.getResults().get(i);
//                                            retrieveResponse.getResults().set(z, tmp2);
//                                            retrieveResponse.getResults().set(i, tmp1);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//
////                        for(int i=0;i<retrieveResponse.getResults().size();i++) {
////                            hotelMinprice = retrieveResponse.getResults().get(i).getRoom_types().get(0).getRooms().get(0).getMeals().get(0).getPrice();
////                            for (SunHotelsRoomTypeWithRoomsResponse roomtype : retrieveResponse.getResults().get(i).getRoom_types()) {
////                                for (SunHotelsRoomResponse room : roomtype.getRooms()) {
////                                    if (room.getMeals() != null && room.getMeals().size() > 0) {
////                                        for (SunHotelsRoomMealResponse meal : room.getMeals()) {
////                                            if (hotelMinprice.compareTo(meal.getPrice()) == 1) {
////                                                hotelMinprice = meal.getPrice();
////                                            }
////                                        }
////                                    }
////                                }
////                            }
////                            System.out.println("hotel id :" + retrieveResponse.getResults().get(i).getId()+" price: "+hotelMinprice);
////                        }
//                    }
//                    else if(retrieveSearchLogBean.getCurrentSortOrder()!=null && retrieveSearchLogBean.getCurrentSortOrder().equals("Descending")){
//                        for(int i=0;i<retrieveResponse.getResults().size();i++){
//                            for(int z=0;z<retrieveResponse.getResults().size();z++) {
//                                if(z!=i) {
//                                    if(retrieveResponse.getResults().get(i).getRoom_types()!=null
//                                        && retrieveResponse.getResults().get(i).getRoom_types().size()>0
//                                        && retrieveResponse.getResults().get(i).getRoom_types().get(0).getRooms()!=null
//                                        && retrieveResponse.getResults().get(i).getRoom_types().get(0).getRooms().size()>0
//                                        && retrieveResponse.getResults().get(i).getRoom_types().get(0).getRooms().get(0).getMeals()!=null
//                                        && retrieveResponse.getResults().get(i).getRoom_types().get(0).getRooms().get(0).getMeals().size()>0
//                                        && retrieveResponse.getResults().get(z).getRoom_types()!=null
//                                        && retrieveResponse.getResults().get(z).getRoom_types().size()>0
//                                        && retrieveResponse.getResults().get(z).getRoom_types().get(0).getRooms()!=null
//                                        && retrieveResponse.getResults().get(z).getRoom_types().get(0).getRooms().size()>0
//                                        && retrieveResponse.getResults().get(z).getRoom_types().get(0).getRooms().get(0).getMeals()!=null
//                                        && retrieveResponse.getResults().get(z).getRoom_types().get(0).getRooms().get(0).getMeals().size()>0) {
//
//                                        hotelMinprice = retrieveResponse.getResults().get(i).getRoom_types().get(0).getRooms().get(0).getMeals().get(0).getPrice();
//                                        for (SunHotelsRoomTypeWithRoomsResponse roomtype : retrieveResponse.getResults().get(i).getRoom_types()) {
//                                            for (SunHotelsRoomResponse room : roomtype.getRooms()) {
//                                                if (room.getMeals() != null && room.getMeals().size() > 0) {
//                                                    for (SunHotelsRoomMealResponse meal : room.getMeals()) {
//                                                        if (hotelMinprice.compareTo(meal.getPrice()) == 1)
//                                                            hotelMinprice = meal.getPrice();
//                                                    }
//                                                }
//                                            }
//                                        }
//                                        nextHotelMinprice = retrieveResponse.getResults().get(z).getRoom_types().get(0).getRooms().get(0).getMeals().get(0).getPrice();
//                                        for (SunHotelsRoomTypeWithRoomsResponse nextRoomtype : retrieveResponse.getResults().get(z).getRoom_types()) {
//                                            for (SunHotelsRoomResponse nextRoom : nextRoomtype.getRooms()) {
//                                                if (nextRoom.getMeals() != null && nextRoom.getMeals().size() > 0) {
//                                                    for (SunHotelsRoomMealResponse meal : nextRoom.getMeals()) {
//                                                        if (nextHotelMinprice.compareTo(meal.getPrice()) == 1)
//                                                            nextHotelMinprice = meal.getPrice();
//                                                    }
//                                                }
//                                            }
//                                        }
//                                        if (hotelMinprice.compareTo(nextHotelMinprice) == 1) {
//                                            SunHotelsResponse tmp1 = retrieveResponse.getResults().get(z);
//                                            SunHotelsResponse tmp2 = retrieveResponse.getResults().get(i);
//                                            retrieveResponse.getResults().set(z, tmp2);
//                                            retrieveResponse.getResults().set(i, tmp1);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//
////                        for(int i=0;i<retrieveResponse.getResults().size();i++) {
////                            hotelMinprice = retrieveResponse.getResults().get(i).getRoom_types().get(0).getRooms().get(0).getMeals().get(0).getPrice();
////                            for (SunHotelsRoomTypeWithRoomsResponse roomtype : retrieveResponse.getResults().get(i).getRoom_types()) {
////                                for (SunHotelsRoomResponse room : roomtype.getRooms()) {
////                                    if (room.getMeals() != null && room.getMeals().size() > 0) {
////                                        for (SunHotelsRoomMealResponse meal : room.getMeals()) {
////                                            if (hotelMinprice.compareTo(meal.getPrice()) == 1)
////                                                hotelMinprice = meal.getPrice();
////                                        }
////                                    }
////                                }
////                            }
////                            System.out.println("hotel id :" + retrieveResponse.getResults().get(i).getId()+" price: "+hotelMinprice);
////                        }
//                    }
//                }
//
//                /**
//                 * If the filters changed start from the top of the list again.If not send as response the next x hotels from the list.
//                 */
//                if(filtersChanged) {
//                    if(retrieveResponse.getResults()!=null) {
//                        for (int i = retrieveResponse.getResults().size() - 1; i > countOfDisplayedHotels-1; i--)
//                            retrieveResponse.getResults().remove(i);
//                    }
//                }else{
//                    int z = 0;
//                    for (Iterator<SunHotelsResponse> iter = retrieveResponse.getResults().listIterator(); iter.hasNext(); ) {
//                        iter.next();
//                        if (retrieveSearchLogBean.getCurrentDisplayedHotels() > z)
//                            iter.remove();
//                        if (retrieveSearchLogBean.getCurrentDisplayedHotels() + countOfDisplayedHotels <= z)
//                            iter.remove();
//                        z++;
//                    }
//                }
//
//
//            } catch (IOException e) {
//                StringWriter errors = new StringWriter();
//                e.printStackTrace(new PrintWriter(errors));
//                errLogger.info(errors.toString());
//            }
//            System.out.println("time: "+ (System.currentTimeMillis()-w));
//
//            return  retrieveResponse;
//        }


        /**
         * If the search is for first time continue to the code bellow.
         */


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
           if(params.getProviderId()!=0)//todo change the code here when add hotelbeds to db
                strOriginalHotelId=params.getHotelID();
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

        /**
         * Get original id from Destination table.
         */
        int originalDestinationId=0;
        String originalDestinationIdStrFormat="";
        if(params.getDestinationId()!=null && !params.getDestinationId().equals("")) {
            DestinationDAO.increaseSortOrderOfDestination(params.getDestinationId());
            originalDestinationId = DestinationDAO.getOriginalDestinationId(params.getDestinationId());
            if (originalDestinationId==0){
                return hotelSearchJSON;
            }else
                originalDestinationIdStrFormat=String.valueOf(originalDestinationId);
        }

        long requestTimeElapsed=0;

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
            result=nonStaticXMLAPISoap.searchV2(sunhotelsUsername,sunhotelspass,"English",currencies,
                    xmlCheckin,xmlCheckout, params.getNumberOfRooms(),"",originalDestinationIdStrFormat,
                    strOriginalHotelId,"","",params.getNumberOfAdults(),
                    params.getNumberOfChildren(), params.getChildrenAges(),params.getInfant(),"Price","Ascending",
                    "", "","","",
                    "","","", "",
                    "","","",params.getMinPrice(),params.getMaxPrice(),"",
                    "","","","",
                    "", params.getCustomerCountry(),"");
        }catch(DatatypeConfigurationException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());}catch(NullPointerException e){}
        requestTimeElapsed = System.currentTimeMillis() - requestTimeElapsed;

        long prepareResponseTimeElapsed=0;
        long dbTransactionTimeElapsed=0;

        /**
         * Response
         */
        if(result!=null && result.getError()==null){

            List<SunHotelsResponse> hotelsResponse=new ArrayList<>();
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
            List<RoomtypeBean> atbRoomTypes=RoomtypeDAO.getRoomsTypes(sanHotelsProviderId);
            List<MealBean> meals=MealDAO.getMeals(sanHotelsProviderId);
            List<HotelBean> atbhotels=null;
            if(originalDestinationId!=0)
                atbhotels = HotelDAO.getHotelByDestId(originalDestinationId, sanHotelsProviderId);
            List<HotelmappingBean> hotelsmapping = HotelmappingDAO.getAllProviderHotelsMapping(sanHotelsProviderId);
            dbTransactionTimeElapsed = System.currentTimeMillis()-dbTransactionTimeElapsed;

            /**
             * Prepare the response data.
             */
            prepareResponseTimeElapsed = System.currentTimeMillis();
            if ( hotelsmapping != null && atbRoomTypes != null & meals != null) {
                for (Hotel hotel : result.getHotels().getHotel()) {
                    if(originalDestinationId==0)
                        atbhotels = HotelDAO.getHotelByHotelId(hotel.getHotelId(),sanHotelsProviderId,null) ;
                    if(atbhotels!=null) {
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
                                    hotelResponse.setDistrict(atbhotel.getCity());
                                    hotelResponse.setId(atbHotelId);
                                    hotelResponse.setLatitude(atbhotel.getLatitude());
                                    hotelResponse.setLongitude(atbhotel.getLongitude());
                                    hotelResponse.setName(atbhotel.getName());
                                    hotelResponse.setStar_rating(atbhotel.getStarRating());
                                    hotelResponse.setState(atbhotel.getState());
                                    hotelResponse.setZip_code(atbhotel.getZipCode());
                                    hotelResponse.setCountry_code(atbhotel.getCountryCode());


                                    roomTypesWithRoomsResponse = new ArrayList<>();
                                    roomMealsResponse = new ArrayList<>();
                                    for (RoomTypeWithRooms roomtype : hotel.getRoomtypes().getRoomtype()) {
                                        roomsResponse = new ArrayList<>();
                                        for (Room room : roomtype.getRooms().getRoom()) {
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
                                                    if (roomMeal.getId() == m.getId()) {
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
                                            if (atbRoomType.getRoomtypeId() == roomtype.getRoomtypeID()) {
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
                        }
                    }
                }
            }
            prepareResponseTimeElapsed = System.currentTimeMillis()-prepareResponseTimeElapsed;


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

//            /**
//             * Store request response to search log.
//             */
//            String reuestJsonInString="";
//            String responseJsonInString="";
//            try {
//                responseJsonInString= mapper.writeValueAsString(hotelSearchJSON);
//                reuestJsonInString = mapper.writeValueAsString(params);
//            }catch(JsonProcessingException e){
//
//            }
//
//            SearchLogBean  stroreSearchLogBean=new SearchLogBean();
//            stroreSearchLogBean.setSearchId(params.getSearchId());
//            stroreSearchLogBean.setCurrentDisplayedHotels(countOfDisplayedHotels);
//            stroreSearchLogBean.setCurrentSortOrder(params.getSortBy());
//            stroreSearchLogBean.setRequest(reuestJsonInString);
//            stroreSearchLogBean.setResponse(responseJsonInString);
//            stroreSearchLogBean.setCurrentDistricts(params.getDistricts());
//            stroreSearchLogBean.setCurrentMaxPrice(params.getMaxPrice());
//            stroreSearchLogBean.setCurrentMealPlans(params.getMealPlans());
//            stroreSearchLogBean.setCurrentMinPrice(params.getMinPrice());
//            stroreSearchLogBean.setCurrentSortBy(params.getSortBy());
//            stroreSearchLogBean.setCurrentStarRatings(params.getStarRatings());
//            SearchLogDAO.addSearchLogBean(stroreSearchLogBean);

            /**
             *  Set count of total hotels.
             */
            hotelSearchJSON.setTotalHotelsCount(hotelsResponse.size());

            /**
             * Send only the first x hotels from the list as a response.
             */
//            if(hotelsResponse!=null) {
//                for (int i = hotelsResponse.size() - 1; i > countOfDisplayedHotels-1; i--)
//                        hotelsResponse.remove(i);
//            }


            hotelSearchJSON.setResults(hotelsResponse);
        }




        userlogs.info("Request Varibles: "+ " hotelID:"+params.getHotelID() +" currencies:"+params.getCurrencies() +
                            " infant:"+params.getInfant() +" childrenAges:"+params.getChildrenAges() +" numberOfChildren:"+
                            params.getNumberOfChildren() + " numberOfRooms:"+params.getNumberOfRooms() +" numberOfAdults:"+
                            params.getNumberOfAdults() +"checkOutDate:"+ params.getCheckOutDate()+" checkInDate:"+params.getCheckInDate() +
                            " customerCountry:"+params.getCustomerCountry());

        if(hotelSearchJSON.getResults()!=null) {
            userlogs.info(" Db transactions time:" + dbTransactionTimeElapsed + ". Sunhotel communication and transactions time:" + requestTimeElapsed +
                    ". Processing time:" + prepareResponseTimeElapsed + " Response Hotels count:" + hotelSearchJSON.getResults().size() + ". Destination:" + originalDestinationId);
        }else
            userlogs.info(" Db transactions time:" + dbTransactionTimeElapsed + ". Sunhotel communication and transactions time:" + requestTimeElapsed +
                    ". Processing time:" + prepareResponseTimeElapsed + " Response Hotels count:" + 0 + ". Destination:" + originalDestinationId);

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
        if(vBookPOST.getItems()!=null) {
            for (ViatorItem it : vBookPOST.getItems()) {
                item = new Item();
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
                boolean languageOptionCodeisSet = false;
                List<ViatorProductTourGradeLanguageServicesBean> tourgradeServices = ViatorProductTourGradeLanguageServicesDAO.getLanguageServicesByProductCodeAndTourGrade(it.getProductCode(), it.getTourGradeCode());
                if (tourgradeServices != null) {
                    for (ViatorProductTourGradeLanguageServicesBean tourgradeService : tourgradeServices) {
                        if (tourgradeService.getLanguageCodeAndService().equals("en/ENGLISH_ONLY")) {
                            item.setLanguageOptionCode("en/ENGLISH_ONLY");
                            languageOptionCodeisSet = true;
                            break;
                        }
                    }
                }
                if (!languageOptionCodeisSet) {
                    if (it.getServiceOption().equals("live"))
                        item.setLanguageOptionCode("en/SERVICE_GUIDE");
                    else if (it.getServiceOption().equals("booklet"))
                        item.setLanguageOptionCode("en/SERVICE_WRITTEN");
                    else if (it.getServiceOption().equals("audio"))
                        item.setLanguageOptionCode("en/SERVICE_AUDIO");
                }

                PartnerItemDetail partnerItemDetail = new PartnerItemDetail();
                distributorItemRef++;
                partnerItemDetail.setDistributorItemRef("" + distributorItemRef);
                item.setPartnerItemDetail(partnerItemDetail);

                Traveller traveller;
                List<Traveller> travellers = new ArrayList<>();
                for (ViatorTraveller tr : it.getTravellers()) {
                    traveller = new Traveller();

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
