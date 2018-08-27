package Controller.ATBFrontEndAPI;


import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.*;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsCancelationPolicy;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomMealResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomResponse;
import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomTypeWithRoomsResponse;
import APIJSONs.ATBAPIJSONs.Product.ResponseItem;
import APIJSONs.ATBAPIJSONs.ViatorATBFrontEnd.Book.EventsTravelBookPOST;
import APIJSONs.ATBAPIJSONs.ViatorATBFrontEnd.Book.ViatorItem;
import APIJSONs.ATBAPIJSONs.ViatorATBFrontEnd.Book.ViatorBookPOST;
import APIJSONs.ATBAPIJSONs.ViatorATBFrontEnd.Book.ViatorTraveller;
import Beans.ATBDBBeans.KalitaonHotel.*;
import Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean;
import Beans.ATBDBBeans.KalitaonProduct.FPricePlanBean;
import Beans.ATBDBBeans.KalitaonProduct.GPriceMatrixBean;
import Beans.ATBDBBeans.KalitaonSystem.GsaBean;
import Beans.ATBDBBeans.KalitaonSystem.SubAgencyBean;
import Beans.EventsTravelAPIBeans.EventsTravelCreateOrderRequest;
import Beans.EventsTravelAPIBeans.EventsTravelCreateOrderResponse;
import Beans.EventsTravelAPIBeans.EventsTravelProductsRespone;
import Beans.EventsTravelAPIBeans.OrderProduct;
import Beans.HotelBedsAPIBeans.Availability.*;
import Beans.HotelBedsAPIBeans.Availability.Hotel;
import Beans.HotelBedsAPIBeans.Availability.Pax;
import Beans.HotelBedsAPIBeans.Availability.Rate;
import Beans.HotelBedsAPIBeans.Availability.Room;
import Beans.HotelBedsAPIBeans.Book.*;
import Beans.ViatorAPIBeans.Bookings.Book.*;
import Beans.ViatorAPIBeans.Bookings.Book.BookAPIJSON;
import Beans.ViatorAPIBeans.Bookings.Cancel.CancelAPIJSON;
import Beans.ViatorAPIBeans.Bookings.Cancel.CancelPOST;
import Beans.ViatorAPIBeans.Bookings.PastBooking.PastBookingAPIJSON;
import Beans.ViatorDBBeans.BookLogBean;
import Beans.ViatorDBBeans.PrebookLogBean;
import Beans.ViatorDBBeans.ViatorProductTourGradeLanguageServicesBean;
import Controller.Application;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.*;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.AProductTitleDAO;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.FPricePlanDAO;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.GPriceMatrixDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.GsaDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.SubAgencyDAO;
import DAOs.EventsTravelAPIDAO.EventsTravelProductsAPIDAO;
import DAOs.HotelBedsAPIDAOs.AvailabilityDAOs;
import DAOs.HotelBedsAPIDAOs.BookDAOs;
import DAOs.SunHotelsAPIDAOs.*;
import DAOs.SunHotelsAPIDAOs.Booking;
import DAOs.ViatorAPIDAOs.BookingsAPIDAO;
import DAOs.ViatorDBDAOs.BookLogDAO;
import DAOs.ViatorDBDAOs.PrebookLogDAO;
import DAOs.ViatorDBDAOs.ViatorProductTourGradeLanguageServicesDAO;
import DBConnection.SunHotelsHibernateUtil;
import Helper.CurrencyConverter;
import Helper.GenerateRandomString;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.StatelessSession;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Pattern;

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

        Application.agent.increment("app.web.request.frontend.HotelBook");

        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        BookLogBean bookLogBean=new BookLogBean();
        ObjectMapper mapper = new ObjectMapper();
        BookResult result=null;
        SunHotelsBookJSON  bookJSON=new SunHotelsBookJSON();
        String sunHotelsRequest="";
        Beans.HotelBedsAPIBeans.Book.BookAPIJSON bookAPIJSON=null;
        Beans.HotelBedsAPIBeans.Book.BookPost bookPOST=null;

        SubAgencyBean subAgencyBean;
        String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + apiKey;
        String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
        subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);
        HotelmappingBean hotelmappingBean=null;

        try {
            if (subAgencyBean != null) {
                if (subAgencyBean.getAgentName() == null || !subAgencyBean.getAgentName().equals("Nafpas")) {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorType("Authentication");
                    bookJSON.setErrorMessageText("Wrong API key");
                    bookLogBean.setClient("ATB Holidays");
                    bookLogBean.setClientBookingId("not_succeed");
                    try {
                        bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                    } catch (JsonProcessingException e) {
                        bookLogBean.setClientRequest("");
                    }
                    try {
                        bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                    } catch (JsonProcessingException e1) {
                        bookLogBean.setClientResponse("");
                    }
                    bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                    bookLogBean.setPrebookRef(params.getPrebookcode());
                    bookLogBean.setProvider("");
                    bookLogBean.setProviderBookingId("");
                    bookLogBean.setProviderRequest("");
                    bookLogBean.setProviderResponse("");
                    BookLogDAO.addBookLogBean(bookLogBean);
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
                            bookJSON.setSuccess(false);
                            bookJSON.setErrorMessageText("Wrong date type.The correct format is yyyy-mm-dd");
                            bookLogBean.setClient("ATB Holidays");
                            bookLogBean.setClientBookingId("not_succeed");
                            try {
                                bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                            } catch (JsonProcessingException e1) {
                                bookLogBean.setClientRequest("");
                            }
                            try {
                                bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                            } catch (JsonProcessingException e1) {
                                bookLogBean.setClientResponse("");
                            }
                            bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                            bookLogBean.setPrebookRef(params.getPrebookcode());
                            bookLogBean.setProvider("");
                            bookLogBean.setProviderBookingId("");
                            bookLogBean.setProviderRequest("");
                            bookLogBean.setProviderResponse("");
                            BookLogDAO.addBookLogBean(bookLogBean);
                            return bookJSON;
                        }
                    }

                }


                /**
                 * Hotelid check.Used for recognize provider
                 */
//                if (params.getHotelId() != null && !params.getHotelId().equals("")) {
//                    hotelmappingBean = HotelmappingDAO.getHotelMappingbyATBId(Integer.parseInt(params.getHotelId()));
//                    if (hotelmappingBean == null) {
//                        bookJSON.setSuccess(false);
//                        bookJSON.setErrorType("HotelId missing");
//                        bookJSON.setErrorMessageText("HotelId missing");
//                        bookLogBean.setClient("ATB Holidays");
//                        bookLogBean.setClientBookingId("not_succeed");
//                        try {
//                            bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
//                        } catch (JsonProcessingException e) {
//                            bookLogBean.setClientRequest("");
//                        }
//                        try {
//                            bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
//                        } catch (JsonProcessingException e) {
//                            bookLogBean.setClientResponse("");
//                        }
//                        bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
//                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
//                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
//                        bookLogBean.setPrebookRef(params.getPrebookcode());
//                        bookLogBean.setProvider("");
//                        bookLogBean.setProviderBookingId("");
//                        bookLogBean.setProviderRequest("");
//                        bookLogBean.setProviderResponse("");
//                        BookLogDAO.addBookLogBean(bookLogBean);
//                        return bookJSON;
//                    }
//                } else {
//                    bookJSON.setSuccess(false);
//                    bookJSON.setErrorType("HotelId missing");
//                    bookJSON.setErrorMessageText("HotelId missing");
//                    bookLogBean.setClient("ATB Holidays");
//                    bookLogBean.setClientBookingId("not_succeed");
//                    try {
//                        bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
//                    } catch (JsonProcessingException e) {
//                        bookLogBean.setClientRequest("");
//                    }
//                    try {
//                        bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
//                    } catch (JsonProcessingException e) {
//                        bookLogBean.setClientResponse("");
//                    }
//                    bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
//                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
//                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
//                    bookLogBean.setPrebookRef(params.getPrebookcode());
//                    bookLogBean.setProvider("");
//                    bookLogBean.setProviderBookingId("");
//                    bookLogBean.setProviderRequest("");
//                    bookLogBean.setProviderResponse("");
//                    BookLogDAO.addBookLogBean(bookLogBean);
//                    return bookJSON;
//                }

                PrebookLogBean prebookLogBean=null;
                if(params.getPrebookcode()!=null && !params.getPrebookcode().equals("")) {
                    prebookLogBean = PrebookLogDAO.getPrebookLogByRefAndProvider(params.getPrebookcode(), null);
                    if (prebookLogBean == null) {
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorType("Prebook code missing");
                        bookJSON.setErrorMessageText("Prebook code missing");
                        bookLogBean.setClient("ATB Holidays");
                        bookLogBean.setClientBookingId("not_succeed");
                        try {
                            bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                        } catch (JsonProcessingException e) {
                            bookLogBean.setClientRequest("");
                        }
                        try {
                            bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                        } catch (JsonProcessingException e) {
                            bookLogBean.setClientResponse("");
                        }
                        bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                        bookLogBean.setPrebookRef(params.getPrebookcode());
                        bookLogBean.setProvider("");
                        bookLogBean.setProviderBookingId("");
                        bookLogBean.setProviderRequest("");
                        bookLogBean.setProviderResponse("");
                        BookLogDAO.addBookLogBean(bookLogBean);
                        return bookJSON;
                    }
                }else{
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorType("Prebook code missing");
                    bookJSON.setErrorMessageText("Prebook code missing");
                    bookLogBean.setClient("ATB Holidays");
                    bookLogBean.setClientBookingId("not_succeed");
                    try {
                        bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                    } catch (JsonProcessingException e) {
                        bookLogBean.setClientRequest("");
                    }
                    try {
                        bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                    } catch (JsonProcessingException e) {
                        bookLogBean.setClientResponse("");
                    }
                    bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                    bookLogBean.setPrebookRef(params.getPrebookcode());
                    bookLogBean.setProvider("");
                    bookLogBean.setProviderBookingId("");
                    bookLogBean.setProviderRequest("");
                    bookLogBean.setProviderResponse("");
                    BookLogDAO.addBookLogBean(bookLogBean);
                    return bookJSON;
                }

                String[]  prebookCode=params.getPrebookcode().split("ID:");
                if(prebookCode==null || prebookCode.length==0){
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorMessageText("Wrong prebbok code");
                    bookLogBean.setClient("ATB Holidays");
                    bookLogBean.setClientBookingId("not_succeed");
                    try {
                        bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                    } catch (JsonProcessingException e1) {
                        bookLogBean.setClientRequest("");
                    }
                    try {
                        bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                    } catch (JsonProcessingException e1) {
                        bookLogBean.setClientResponse("");
                    }
                    bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                    bookLogBean.setPrebookRef(params.getPrebookcode());
                    bookLogBean.setProvider("");
                    bookLogBean.setProviderBookingId("");
                    bookLogBean.setProviderRequest("");
                    bookLogBean.setProviderResponse("");
                    BookLogDAO.addBookLogBean(bookLogBean);
                    return bookJSON;
                }

                /**
                 * Get original meal id
                 */
                String originalMealId = "";
                String id = MealDAO.getOriginalMealId(String.valueOf(params.getMealId()));
                if (id != null)
                    originalMealId = id;
                else{
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorType("Mealid missing");
                    bookJSON.setErrorMessageText("Mealid missing");
                    bookLogBean.setClient("ATB Holidays");
                    bookLogBean.setClientBookingId("not_succeed");
                    try {
                        bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                    } catch (JsonProcessingException e) {
                        bookLogBean.setClientRequest("");
                    }
                    try {
                        bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                    } catch (JsonProcessingException e) {
                        bookLogBean.setClientResponse("");
                    }
                    bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                    bookLogBean.setPrebookRef(params.getPrebookcode());
                    bookLogBean.setProvider("");
                    bookLogBean.setProviderBookingId("");
                    bookLogBean.setProviderRequest("");
                    bookLogBean.setProviderResponse("");
                    BookLogDAO.addBookLogBean(bookLogBean);
                    return bookJSON;
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

                if (prebookLogBean.getProvider().equals(sanHotelsProviderName)) {

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
                        sunHotelsRequest = params.getCurrency() + "" + "English" + "" +
                                params.getEmail() + "" + xmlCheckin + "" + xmlCheckout + "" + params.getRoomId() + "" + params.getRooms() + "" +
                                numOfAdults + "" + numOfChildren + "" + params.getInfant() + "" +
                                originalMealId + "" + adults[0].getFirst_name() + "" + adults[0].getLast_name() + "" + adults[1].getFirst_name() + "" + adults[1].getLast_name() + "" +
                                adults[2].getFirst_name() + "" + adults[2].getLast_name() + "" + adults[3].getFirst_name() + "" + adults[3].getLast_name() + "" + adults[4].getFirst_name() + "" +
                                adults[4].getLast_name() + "" + adults[5].getFirst_name() + "" + adults[5].getLast_name() + "" + adults[6].getFirst_name() + "" + adults[6].getLast_name() + "" +
                                adults[7].getFirst_name() + "" + adults[7].getLast_name() + "" + adults[8].getFirst_name() + "" + adults[8].getLast_name() + "" + children[0].getFirst_name() + "" +
                                children[0].getLast_name() + "" + children[0].getAge() + "" + children[1].getFirst_name() + "" + children[1].getLast_name() + "" + children[1].getAge() + "" +
                                children[2].getFirst_name() + "" + children[2].getLast_name() + "" + children[2].getAge() + "" + children[3].getFirst_name() + "" + children[3].getLast_name() + "" +
                                children[3].getAge() + "" + children[4].getFirst_name() + "" + children[4].getLast_name() + "" + children[4].getAge() + "" + children[5].getFirst_name() + "" +
                                children[5].getLast_name() + "" + children[5].getAge() + "" + children[6].getFirst_name() + "" + children[6].getLast_name() + "" + children[6].getAge() + "" +
                                children[7].getFirst_name() + "" + children[7].getLast_name() + "" + children[7].getAge() + "" + children[8].getFirst_name() + "" + children[8].getLast_name() + "" +
                                children[8].getAge() + "" + 1 + "" + params.getCustomerCountry() + "" + prebookCode[0];
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
                                "", params.getCustomerCountry(), "", "", prebookCode[0]);
                    } catch (DatatypeConfigurationException e) {
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorMessageText("Wrong date type.The correct format is yyyy-mm-dd");
                        bookLogBean.setClient("ATB Holidays");
                        bookLogBean.setClientBookingId("not_succeed");
                        try {
                            bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                        } catch (JsonProcessingException e1) {
                            bookLogBean.setClientRequest("");
                        }
                        try {
                            bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                        } catch (JsonProcessingException e1) {
                            bookLogBean.setClientResponse("");
                        }
                        bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                        bookLogBean.setPrebookRef(params.getPrebookcode());
                        bookLogBean.setProvider("SunHotels");
                        bookLogBean.setProviderBookingId("");
                        bookLogBean.setProviderRequest("");
                        bookLogBean.setProviderResponse("");
                        BookLogDAO.addBookLogBean(bookLogBean);
                        return bookJSON;
                    } catch (NullPointerException e) {
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorMessageText("Wrong date type.The correct format is yyyy-mm-dd");
                        bookLogBean.setClient("ATB Holidays");
                        bookLogBean.setClientBookingId("not_succeed");
                        try {
                            bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                        } catch (JsonProcessingException e1) {
                            bookLogBean.setClientRequest("");
                        }
                        try {
                            bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                        } catch (JsonProcessingException e1) {
                            bookLogBean.setClientResponse("");
                        }
                        bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                        bookLogBean.setPrebookRef(params.getPrebookcode());
                        bookLogBean.setProvider("SunHotels");
                        bookLogBean.setProviderBookingId("");
                        bookLogBean.setProviderRequest("");
                        bookLogBean.setProviderResponse("");
                        BookLogDAO.addBookLogBean(bookLogBean);
                        return bookJSON;
                    }

                    /**
                     * Response
                     */
                    if (result != null && result.getError() != null) {
                        bookJSON.setErrorMessageText(result.getError().getMessage());
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorType(result.getError().getErrorType());
                    } else if (result != null) {
                        bookJSON.setBookResult(result.getBooking());
                        bookJSON.setSuccess(true);
                    } else {
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorType("Communication Error");
                        bookJSON.setErrorMessageText("");
                        bookLogBean.setClient("ATB Holidays");
                        bookLogBean.setClientBookingId("not_succeed");
                        try {
                            bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                        } catch (JsonProcessingException e) {
                            bookLogBean.setClientRequest("");
                        }
                        try {
                            bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                        } catch (JsonProcessingException e) {
                            bookLogBean.setClientResponse("");
                        }
                        bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                        bookLogBean.setPrebookRef(params.getPrebookcode());
                        bookLogBean.setProvider("SunHotels");
                        bookLogBean.setProviderBookingId("");
                        bookLogBean.setProviderRequest("");
                        bookLogBean.setProviderResponse("");
                        BookLogDAO.addBookLogBean(bookLogBean);
                        return bookJSON;
                    }
                } else if (prebookLogBean.getProvider().equals(hotelBedsProvideName)) {

                    if(numOfAdults>0) {
                        bookPOST = new Beans.HotelBedsAPIBeans.Book.BookPost();
                        bookPOST.setClientReference("ATB"+System.currentTimeMillis());
                        Holder holder = new Holder();
                        holder.setName(adults[0].getFirst_name());
                        holder.setSurname(adults[0].getLast_name());
                        bookPOST.setHolder(holder);
                        List<Beans.HotelBedsAPIBeans.Book.Room> rooms = new ArrayList<>();
                        Beans.HotelBedsAPIBeans.Book.Room room = new Beans.HotelBedsAPIBeans.Book.Room();
                        List<Beans.HotelBedsAPIBeans.Book.Pax> paxes = new ArrayList<>();
                        Beans.HotelBedsAPIBeans.Book.Pax pax;

                        int paxPerRoom=(numOfAdults+numOfChildren)/params.getRooms();
                        int roomId=1;
                        int paxCount=0;
                        for (int k = 0; k < numOfAdults; k++) {
                            pax = new Beans.HotelBedsAPIBeans.Book.Pax();
                            pax.setName(adults[k].getFirst_name());
                            pax.setSurname(adults[k].getLast_name());
                            pax.setRoomId(roomId);
                            paxCount++;
                            if(paxPerRoom==paxCount){
                                roomId++;
                                paxCount=0;
                            }
                            pax.setType("AD");
                            paxes.add(pax);
                        }

                        for (int k = 0; k < numOfChildren; k++) {
                            pax = new Beans.HotelBedsAPIBeans.Book.Pax();
                            pax.setAge(Integer.parseInt(children[k].getAge()));
                            pax.setName(children[k].getFirst_name());
                            pax.setSurname(children[k].getLast_name());
                            pax.setRoomId(roomId);
                            paxCount++;
                            if(paxPerRoom==paxCount){
                                roomId++;
                                paxCount=0;
                            }
                            pax.setType("CH");
                            paxes.add(pax);
                        }
                        room.setRateKey(prebookCode[0]);
                        room.setPaxes(paxes);//todo check with many pax and check if prebooklog store failed. For all prebook services(frontend,client api)
                        rooms.add(room);
                        bookPOST.setRooms(rooms);
                        bookAPIJSON = BookDAOs.book(bookPOST);
                        if(bookAPIJSON!=null && bookAPIJSON.getError()==null){


                            if(bookAPIJSON.getBooking()!=null && bookAPIJSON.getBooking().getHotel()!=null &&
                               bookAPIJSON.getBooking().getHotel().getRooms()!=null && bookAPIJSON.getBooking().getHotel().getRooms().size()==1) {
                                Booking booking = new Booking();
                                booking.setRoomType(bookAPIJSON.getBooking().getHotel().getRooms().get(0).getName());
                                booking.setNumberofrooms(String.valueOf(bookAPIJSON.getBooking().getHotel().getRooms().get(0).getRates().get(0).getRooms()));
                                booking.setHotelName(bookAPIJSON.getBooking().getHotel().getName());
                                booking.setHotelId(bookAPIJSON.getBooking().getHotel().getCode());
                                booking.setBookingnumber(bookAPIJSON.getBooking().getReference());
                                booking.setHotelAddress("");
                                booking.setError(null);
                                booking.setErrorAttributes(null);
                                booking.setRoomNotes(null);
                                booking.setHotelPhone("");
                                booking.setRoomEnglishType(bookAPIJSON.getBooking().getHotel().getRooms().get(0).getName());
                                booking.setPaymentmethod(null);
                                booking.setMealLabel("");
                                booking.setInvoiceref("");
                                booking.setVoucher("");
                                booking.setYourref(bookAPIJSON.getBooking().getClientReference());
                                booking.setBookedBy(bookAPIJSON.getBooking().getHolder().getName() +" "+bookAPIJSON.getBooking().getHolder().getSurname());
                                booking.setCurrency(params.getCurrency());
                                booking.setTransferbooked(0);
                                booking.setEnglishMealLabel("");
                                booking.setEnglishRoomNotes(null);

                                for (Beans.HotelBedsAPIBeans.Book.Rate checkRate : bookAPIJSON.getBooking().getHotel().getRooms().get(0).getRates()) {

                                    List<StaticPercentageCancellationPolicy> cancelationPolicies;
                                    StaticPercentageCancellationPolicy cancelationPolicy;
                                    cancelationPolicies = new ArrayList<>();
                                    if (checkRate.getCancellationPolicies() != null) {
                                        for (Beans.HotelBedsAPIBeans.Book.CancelationPolicy policy : checkRate.getCancellationPolicies()) {//todo fix cancelation policies,ask about roomtypes codes whichare not comming all,ask about currency
                                            BigDecimal percentange = new BigDecimal((Double.parseDouble(policy.getAmount()) * 100) / Double.parseDouble(checkRate.getNet())).setScale(2, BigDecimal.ROUND_HALF_UP);
                                            cancelationPolicy = new StaticPercentageCancellationPolicy();
                                            cancelationPolicy.setPercentage(percentange);

                                            XMLGregorianCalendar xMLGregorianCalendar = null;
                                            Date date1=null;
                                            SimpleDateFormat simpleDateFormat;
                                            GregorianCalendar gregorianCalendar;
                                            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                                            String[] from= policy.getFrom().split(Pattern.quote("+"));
                                            if(from!=null && from.length>0)
                                                date1 = simpleDateFormat.parse(from[0]);
                                            gregorianCalendar = (GregorianCalendar)GregorianCalendar.getInstance();
                                            gregorianCalendar.setTime(date1);
                                            xMLGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
                                            if(booking.getEarliestNonFreeCancellationDateCET()==null || Integer.compare(booking.getEarliestNonFreeCancellationDateCET().getMillisecond(),xMLGregorianCalendar.getMillisecond())==1) {
                                               booking.setEarliestNonFreeCancellationDateCET(xMLGregorianCalendar);
                                               booking.setEarliestNonFreeCancellationDateLocal(xMLGregorianCalendar);
                                            }
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
                                    booking.setCancellationpolicies(cancelationPolicies);
                                    ArrayOfCalendarNote2 arrayOfCalendarNote2 = new ArrayOfCalendarNote2();
                                    ArrayOfCalendarNote1 arrayOfCalendarNote1 = new ArrayOfCalendarNote1();
                                    CalendarNote calendarNote = new CalendarNote();
                                    calendarNote.setText(checkRate.getRateComments());
                                    List<CalendarNote> notes = new ArrayList<>();
                                    notes.add(calendarNote);
                                    arrayOfCalendarNote2.setEnglishHotelNote(notes);
                                    arrayOfCalendarNote1.setHotelNote(notes);
                                    booking.setEnglishHotelNotes(arrayOfCalendarNote2);
                                    booking.setHotelNotes(arrayOfCalendarNote1);
                                    if (checkRate.getNet() != null && !checkRate.getNet().equals("")) {
                                        ArrayOfPriceWithPaymentMethods arrayOfPriceWithPaymentMethods = new ArrayOfPriceWithPaymentMethods();
                                        PriceWithPaymentMethods priceWithPaymentMethod = new PriceWithPaymentMethods();
                                        List<PriceWithPaymentMethods> priceWithPaymentMethods = new ArrayList<>();
                                        BigDecimal price = null;
                                        if (params.getCurrency() != null)
                                            price = CurrencyConverter.findExchangeRateAndConvert(hotelBedsDeafultCurrency, params.getCurrency(), Double.parseDouble(checkRate.getNet()));
                                        if (price != null)
                                            priceWithPaymentMethod.setValue(price.setScale(2, BigDecimal.ROUND_HALF_UP));
                                        priceWithPaymentMethod.setCurrency(params.getCurrency());

                                        priceWithPaymentMethods.add(priceWithPaymentMethod);
                                        arrayOfPriceWithPaymentMethods.setPrice(priceWithPaymentMethods);
                                        booking.setPrices(arrayOfPriceWithPaymentMethods);
                                    }
                                    MealBean meal=MealDAO.getMealByMealId(checkRate.getBoardCode(),hotelBedsProviderId,null);
                                    booking.setEnglishMeal(checkRate.getBoardName());
                                    if(meal!=null)
                                        booking.setMealId(meal.getId());


                                }
                                Date date=new Date();
                                GregorianCalendar gregorianCalendar;
                                gregorianCalendar = (GregorianCalendar)GregorianCalendar.getInstance();
                                gregorianCalendar.setTime(date);
                                booking.setBookingdate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));
                                booking.setBookingdateTimezone("GMT+02:00:00");
                                SimpleDateFormat simpleDateFormat;
                                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                date = simpleDateFormat.parse(bookAPIJSON.getBooking().getHotel().getCheckIn());
                                gregorianCalendar.setTime(date);
                                booking.setCheckindate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));
                                date = simpleDateFormat.parse(bookAPIJSON.getBooking().getHotel().getCheckOut());
                                gregorianCalendar.setTime(date);
                                booking.setCheckoutdate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));
                                bookJSON.setBookResult(booking);
                                bookJSON.setSuccess(true);
                            }else{
                                bookJSON.setErrorMessageText("Did not retreive the data properly");
                                bookJSON.setSuccess(false);
                                bookLogBean.setClient("ATB Holidays");
                                bookLogBean.setClientBookingId("not_succeed");
                                try {
                                    bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                                } catch (JsonProcessingException e) {
                                    bookLogBean.setClientRequest("");
                                }
                                try {
                                    bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                                } catch (JsonProcessingException e) {
                                    bookLogBean.setClientResponse("");
                                }
                                bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                        dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                        dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                                bookLogBean.setPrebookRef(params.getPrebookcode());
                                bookLogBean.setProvider(hotelBedsProvideName);
                                bookLogBean.setProviderBookingId("not_succeed");
                                try {
                                    bookLogBean.setProviderRequest(mapper.writeValueAsString(bookPOST).toString());
                                    bookLogBean.setProviderResponse(mapper.writeValueAsString(bookAPIJSON).toString());
                                } catch (JsonProcessingException e) {
                                    bookLogBean.setProviderRequest("");
                                    bookLogBean.setProviderResponse("");
                                }
                                BookLogDAO.addBookLogBean(bookLogBean);
                            }
                        }else{
                            if(bookAPIJSON!=null && bookAPIJSON.getError()!=null) {
                                bookJSON.setErrorMessageText(bookAPIJSON.getError().getMessage());
                                try {
                                    bookLogBean.setProviderResponse(mapper.writeValueAsString(bookAPIJSON).toString());
                                } catch (JsonProcessingException e) {
                                    bookLogBean.setProviderResponse("");
                                }
                            }
                            else {
                                bookJSON.setErrorMessageText("Communication Error");
                                bookLogBean.setProviderResponse("");
                            }
                            bookJSON.setSuccess(false);
                            bookLogBean.setClient("ATB Holidays");
                            bookLogBean.setClientBookingId("not_succeed");
                            try {
                                bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                            } catch (JsonProcessingException e) {
                                bookLogBean.setClientRequest("");
                            }
                            try {
                                bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                            } catch (JsonProcessingException e) {
                                bookLogBean.setClientResponse("");
                            }
                            bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                            bookLogBean.setPrebookRef(params.getPrebookcode());
                            bookLogBean.setProvider(hotelBedsProvideName);
                            bookLogBean.setProviderBookingId("not_succeed");
                            try {
                                bookLogBean.setProviderRequest(mapper.writeValueAsString(bookPOST).toString());
                            } catch (JsonProcessingException e) {
                                bookLogBean.setProviderRequest("");
                            }
                            BookLogDAO.addBookLogBean(bookLogBean);
                        }
                    }else{
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorMessageText("Number of adults is 0");
                        bookLogBean.setClient("ATB Holidays");
                        bookLogBean.setClientBookingId("not_succeed");
                        try {
                            bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                        } catch (JsonProcessingException e) {
                            bookLogBean.setClientRequest("");
                        }
                        try {
                            bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                        } catch (JsonProcessingException e) {
                            bookLogBean.setClientResponse("");
                        }
                        bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                        bookLogBean.setPrebookRef(params.getPrebookcode());
                        bookLogBean.setProvider(hotelBedsProvideName);
                        bookLogBean.setProviderBookingId("not_succeed");
                        bookLogBean.setProviderRequest("");
                        bookLogBean.setProviderResponse("");
                        BookLogDAO.addBookLogBean(bookLogBean);
                    }

                } else if (prebookLogBean.getProvider().equals(String.valueOf(mattHotelsProvider)) || prebookLogBean.getProvider().equals(String.valueOf(atbHotelsProvider))) {


                    long timePassed=Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).getTime()-prebookLogBean.getDateTime().getTime();
                    if(timePassed>1800000){
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorType("Prebook Code is active for 30 minutes.");
                        bookJSON.setErrorMessageText("Prebook Code Expired");
                        bookLogBean.setClient("ATB Holidays");
                        bookLogBean.setClientBookingId("not_succeed");
                        try {
                            bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                        } catch (JsonProcessingException e) {
                            bookLogBean.setClientRequest("");
                        }
                        try {
                            bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                        } catch (JsonProcessingException e) {
                            bookLogBean.setClientResponse("");
                        }
                        bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                        bookLogBean.setPrebookRef(params.getPrebookcode());
                        bookLogBean.setProvider("");
                        bookLogBean.setProviderBookingId("");
                        bookLogBean.setProviderRequest("");
                        bookLogBean.setProviderResponse("");
                        BookLogDAO.addBookLogBean(bookLogBean);
                        return bookJSON;
                    }
                    SunHotelsPrebookJSON prebookJSON=mapper.readValue(prebookLogBean.getClientResponse(),SunHotelsPrebookJSON.class);
                    SunHotelsPrebookPOST prebookPOST=mapper.readValue(prebookLogBean.getClientRequest(),SunHotelsPrebookPOST.class);
                    if(prebookJSON!=null && prebookPOST!=null) {

                        if(params.getRooms()!=prebookPOST.getRooms() ||
                                (params.getChildren()==null && prebookPOST.getChildren()>0) ||
                                (params.getChildren()!=null && params.getChildren().size()!=prebookPOST.getChildren()) ||
                                (params.getHotelId()!=null && !params.getHotelId().equals(prebookPOST.getHotelId()))||
                                (params.getAdults()==null && prebookPOST.getAdults()>0) ||
                                (params.getAdults()!=null && params.getAdults().size()!=prebookPOST.getAdults()) ||
                                !params.getCheckInDate().equals(prebookPOST.getCheckInDate()) ||
                                !params.getCheckOutDate().equals(prebookPOST.getCheckOutDate()) ||
                                params.getInfant()!=prebookPOST.getInfant() ||
                                params.getMealId()!=prebookPOST.getMealId()){

                            bookJSON.setSuccess(false);
                            bookJSON.setErrorType("Some of the parameters are different bettween prebook and book requests.");
                            bookJSON.setErrorMessageText("Parameters Match");
                            bookLogBean.setClient("ATB Holidays");
                            bookLogBean.setClientBookingId("not_succeed");
                            try {
                                bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                            } catch (JsonProcessingException e) {
                                bookLogBean.setClientRequest("");
                            }
                            try {
                                bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                            } catch (JsonProcessingException e) {
                                bookLogBean.setClientResponse("");
                            }
                            bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                            bookLogBean.setPrebookRef(params.getPrebookcode());
                            bookLogBean.setProvider("");
                            bookLogBean.setProviderBookingId("");
                            bookLogBean.setProviderRequest("");
                            bookLogBean.setProviderResponse("");
                            BookLogDAO.addBookLogBean(bookLogBean);
                            return bookJSON;

                        }
                        HotelmappingBean hotelmapping=HotelmappingDAO.getHotelMappingbyATBId(Integer.parseInt(prebookPOST.getHotelId()));

                        if(hotelmapping!=null) {
                            List<HotelBean> hotels = HotelDAO.getHotelByHotelId(hotelmapping.getHotelId(), Integer.parseInt(prebookLogBean.getProvider()), null);
                            RoomtypeBean roomtypeBean = RoomtypeDAO.getRoomtypeATBId(prebookPOST.getRoomtypeId());

                            if (hotels != null && hotels.size() == 1 && roomtypeBean != null) {
                                bookJSON.setSuccess(true);
                                bookJSON.setTotalCount(0);
                                bookJSON.setErrorMessageText("");
                                bookJSON.setErrorType("");
                                Booking bookresult = new Booking();
                                bookresult.setErrorAttributes(null);
                                bookresult.setHotelNotes(null);
                                bookresult.setError(null);
                                bookresult.setRoomNotes(null);
                                bookresult.setPaymentmethod(null);
                                bookresult.setNumberofrooms(String.valueOf(prebookPOST.getRooms()));
                                bookresult.setMealLabel("");
                                bookresult.setMeal("");
                                bookresult.setMealId(prebookPOST.getMealId());
                                bookresult.setInvoiceref("");
                                bookresult.setHotelId(Integer.parseInt(prebookPOST.getHotelId()));
                                bookresult.setBookedBy("");
                                GregorianCalendar c = new GregorianCalendar();
                                c.setTime(new Date());
                                XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
                                bookresult.setBookingdate(xmlDate);
                                bookresult.setBookingdateTimezone("UTC");
                                if(prebookLogBean.getProvider().equals(String.valueOf(mattHotelsProvider)))
                                    bookresult.setBookingnumber("MATT-"+GenerateRandomString.randomUUID(10, 0, 'd'));
                                else
                                    bookresult.setBookingnumber("ATB-"+GenerateRandomString.randomUUID(10, 0, 'd'));
                                bookresult.setCurrency(prebookPOST.getCurrency());
                                bookresult.setEnglishMeal("");
                                bookresult.setEnglishMealLabel("");
                                bookresult.setEnglishRoomNotes(null);
                                bookresult.setYourref("");
                                bookresult.setVoucher("");
                                bookresult.setTransferbooked(0);
                                bookresult.setHotelPhone("");
                                bookresult.setHotelName(hotels.get(0).getName());
                                bookresult.setRoomType(roomtypeBean.getRoomType());
                                bookresult.setRoomEnglishType(roomtypeBean.getRoomType());
                                bookresult.setEnglishHotelNotes(null);
                                bookresult.setHotelAddress(hotels.get(0).getAddress());
                                ArrayOfPriceWithPaymentMethods arrayOfPriceWithPaymentMethods=new ArrayOfPriceWithPaymentMethods();
                                List<PriceWithPaymentMethods> prices=new ArrayList<>();
                                PriceWithPaymentMethods price=new PriceWithPaymentMethods();
                                price.setValue(prebookJSON.getPrice().getValue());
                                price.setCurrency(prebookJSON.getPrice().getCurrency());
                                prices.add(price);
                                arrayOfPriceWithPaymentMethods.setPrice(prices);
                                bookresult.setPrices(arrayOfPriceWithPaymentMethods);
                                bookresult.setCancellationpolicies(prebookJSON.getCancelationPolicies().getCancellationPolicy());
                                GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
                                GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);
                                XMLGregorianCalendar xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
                                XMLGregorianCalendar xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
                                bookresult.setCheckindate(xmlCheckin);
                                bookresult.setCheckoutdate(xmlCheckout);
                                bookresult.setEarliestNonFreeCancellationDateCET(null);//todo
                                bookresult.setEarliestNonFreeCancellationDateLocal(null);//todo
                                bookJSON.setBookResult(bookresult);
                            }
                        }
                    }

                }else{

                    bookJSON.setSuccess(false);
                    bookJSON.setErrorType("Provider missing");
                    bookJSON.setErrorMessageText("No provider specified");
                    bookLogBean.setClient("ATB Holidays");
                    bookLogBean.setClientBookingId("not_succeed");
                    try {
                        bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                    } catch (JsonProcessingException e) {
                        bookLogBean.setClientRequest("");
                    }
                    try {
                        bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                    } catch (JsonProcessingException e) {
                        bookLogBean.setClientResponse("");
                    }
                    bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                    bookLogBean.setPrebookRef(params.getPrebookcode());
                    bookLogBean.setProvider("");
                    bookLogBean.setProviderBookingId("");
                    bookLogBean.setProviderRequest("");
                    bookLogBean.setProviderResponse("");
                    BookLogDAO.addBookLogBean(bookLogBean);
                    return bookJSON;
                }

            } else {
                bookJSON.setSuccess(false);
                bookJSON.setErrorType("Authentication");
                bookJSON.setErrorMessageText("Wrong API key");
                bookLogBean.setClient("ATB Holidays");
                bookLogBean.setClientBookingId("not_succeed");
                try {
                    bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                } catch (JsonProcessingException e) {
                    bookLogBean.setClientRequest("");
                }
                try {
                    bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
                } catch (JsonProcessingException e) {
                    bookLogBean.setClientResponse("");
                }
                bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                        dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                        dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                bookLogBean.setPrebookRef(params.getPrebookcode());
                bookLogBean.setProvider("");
                bookLogBean.setProviderBookingId("");
                bookLogBean.setProviderRequest("");
                bookLogBean.setProviderResponse("");
                BookLogDAO.addBookLogBean(bookLogBean);
                return bookJSON;
            }

            bookJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
            bookLogBean.setClient("ATB Holidays");

            try {
                bookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
            } catch (JsonProcessingException e) {
                bookLogBean.setClientRequest("");
            }
            try {
                bookLogBean.setClientResponse(mapper.writeValueAsString(bookJSON).toString());
            } catch (JsonProcessingException e) {
                bookLogBean.setClientResponse("");
            }
            bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
            bookLogBean.setPrebookRef(params.getPrebookcode());
            if (hotelmappingBean != null && hotelmappingBean.getProviderId() == sanHotelsProviderId) {
                bookLogBean.setProvider(sanHotelsProviderName);
                try {
                    bookLogBean.setProviderRequest(sunHotelsRequest);
                    bookLogBean.setProviderResponse(mapper.writeValueAsString(result).toString());
                } catch (JsonProcessingException e) {
                    bookLogBean.setProviderRequest("");
                    bookLogBean.setProviderResponse("");
                }
            } else if (hotelmappingBean != null && hotelmappingBean.getProviderId() == hotelBedsProviderId) {
                bookLogBean.setProvider(hotelBedsProvideName);
                if(bookAPIJSON!=null && bookPOST!=null) {
                    try {
                        bookLogBean.setProviderRequest(mapper.writeValueAsString(bookAPIJSON).toString());
                        bookLogBean.setProviderResponse(mapper.writeValueAsString(bookPOST).toString());
                    } catch (JsonProcessingException e) {
                        bookLogBean.setProviderRequest("");
                        bookLogBean.setProviderResponse("");
                    }
                }else{
                    bookLogBean.setProviderRequest("");
                    bookLogBean.setProviderResponse("");
                }
            } else if (hotelmappingBean == null) {
                bookLogBean.setProvider("");
                bookLogBean.setProviderRequest("");
                bookLogBean.setProviderResponse("");
            }
            if (bookJSON.getBookResult() != null) {
                bookLogBean.setClientBookingId(bookJSON.getBookResult().getBookingnumber());
                bookLogBean.setProviderBookingId(bookJSON.getBookResult().getBookingnumber());
            } else
                bookLogBean.setClientBookingId("not_succeed");
            BookLogDAO.addBookLogBean(bookLogBean);
        }catch(Exception e){
            bookJSON.setSuccess(false);
            bookJSON.setErrorType("Internal Error");
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }
        return bookJSON;

    }



    @RequestMapping(value = "/hotelBookingsController/sunHotelsPrebook", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public SunHotelsPrebookJSON hotelPrebook(@RequestBody SunHotelsPrebookPOST params){

        Application.agent.increment("app.web.request.frontend.preBook");

        PreBookResult result=null;
        AvailabilityPOST availabilityPOST = new AvailabilityPOST();
        AvailabilityAPIJSON availabilityAPIJSON=null;
        SunHotelsPrebookJSON  prebookJSON=new SunHotelsPrebookJSON();
        PrebookLogBean prebookLogBean=new PrebookLogBean();
        ObjectMapper mapper = new ObjectMapper();
        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        String sunHotelsRequest="";

        /**
         * Dates request parameters
         */
        ZonedDateTime checkin=null;
        ZonedDateTime checkout=null;
        try {
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
                        prebookJSON.setSuccess(false);
                        prebookJSON.setErrorMessageText("Wrong date type.The correct format is yyyy-mm-dd");
                        prebookLogBean.setClient("ATB Holidays");
                        try {
                            prebookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                        } catch (JsonProcessingException e1) {
                            prebookLogBean.setClientRequest("");
                        }
                        try {
                            prebookLogBean.setClientResponse(mapper.writeValueAsString(prebookJSON).toString());
                        } catch (JsonProcessingException e1) {
                            prebookLogBean.setClientResponse("");
                        }
                        prebookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                        prebookLogBean.setPrebookRef("");
                        prebookLogBean.setProvider("");
                        prebookLogBean.setProviderRequest("");
                        prebookLogBean.setProviderResponse("");
                        PrebookLogDAO.addPrebookLogBean(prebookLogBean);
                        return prebookJSON;
                    }
                }

            }


            /**
             * RoomtypeId check.Used for recognize provider
             */
            RoomtypeBean roomtypeBean;
            if (params.getRoomtypeId() == null) {
                prebookJSON.setSuccess(false);
                prebookJSON.setErrorMessageText("Wrong roomtypeId");
                prebookLogBean.setClient("ATB Holidays");
                try {
                    prebookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                } catch (JsonProcessingException e1) {
                    prebookLogBean.setClientRequest("");
                }
                try {
                    prebookLogBean.setClientResponse(mapper.writeValueAsString(prebookJSON).toString());
                } catch (JsonProcessingException e1) {
                    prebookLogBean.setClientResponse("");
                }
                prebookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                        dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                        dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                prebookLogBean.setPrebookRef("");
                prebookLogBean.setProvider("");
                prebookLogBean.setProviderRequest("");
                prebookLogBean.setProviderResponse("");
                PrebookLogDAO.addPrebookLogBean(prebookLogBean);
                return prebookJSON;
            } else {
                roomtypeBean = RoomtypeDAO.getRoomtypeATBId(params.getRoomtypeId());
                if (roomtypeBean == null) {
                    prebookJSON.setSuccess(false);
                    prebookJSON.setErrorMessageText("Wrong roomtypeId");
                    prebookLogBean.setClient("ATB Holidays");
                    try {
                        prebookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                    } catch (JsonProcessingException e1) {
                        prebookLogBean.setClientRequest("");
                    }
                    try {
                        prebookLogBean.setClientResponse(mapper.writeValueAsString(prebookJSON).toString());
                    } catch (JsonProcessingException e1) {
                        prebookLogBean.setClientResponse("");
                    }
                    prebookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                    prebookLogBean.setPrebookRef("");
                    prebookLogBean.setProvider("");
                    prebookLogBean.setProviderRequest("");
                    prebookLogBean.setProviderResponse("");
                    PrebookLogDAO.addPrebookLogBean(prebookLogBean);
                    return prebookJSON;
                }
            }


            /**
             * Fix children ages because they come like this ﻿'0,0,0,5,4,0,0,0'
             */
            String childrenAges = "";
            String[] childrenAgesSplit = null;
            boolean firstChildAge = true;//todo  check duplications in hotel types and meals and prices
            if (params.getChildrenAges() != null && params.getChildrenAges() != "") {
                childrenAgesSplit = params.getChildrenAges().split(",");
                if (childrenAgesSplit != null && childrenAgesSplit.length > 0) {
                    for (String age : childrenAgesSplit) {
                        if (age != null && !age.equals("0") && !age.equals("")) {
                            if (firstChildAge) {
                                childrenAges = age;
                                firstChildAge = false;
                            } else {
                                childrenAges = childrenAges + "," + age;
                            }
                        }
                    }
                }
            }


            /**
             * Get original hotel id
             */
            String originalHotelId = "";
            if (params.getHotelId() != null && !params.getHotelId().equals("")) {
                HotelmappingBean hotelmappingBean = HotelmappingDAO.getHotelMappingbyATBId(Integer.parseInt(params.getHotelId()));
                if(hotelmappingBean!=null) {

                    if (hotelmappingBean.getProviderId() != roomtypeBean.getProviderId()) {

                        List<HotelBean> hotels=HotelDAO.getHotelByHotelId(hotelmappingBean.getHotelId(),hotelmappingBean.getProviderId(),null);
                        if(hotels!=null && hotels.size()>0){
                            DestinationBean destination=DestinationDAO.getDestinationBean(hotels.get(0).getDestinationId(),hotels.get(0).getProviderId(),null);
                            List<HotelBean> roomTypeProviderHotels=null;
                            if(roomtypeBean.getProviderId()==sanHotelsProviderId)
                                roomTypeProviderHotels=HotelDAO.getHotelByDestId(String.valueOf(destination.getDestinationId()),roomtypeBean.getProviderId());
                            else if(roomtypeBean.getProviderId()==hotelBedsProviderId)
                                roomTypeProviderHotels=HotelDAO.getHotelByDestId(destination.getHotelBedsCode(),roomtypeBean.getProviderId());
                            if(roomTypeProviderHotels!=null && roomTypeProviderHotels.size()>0 && destination!=null) {
                                String[] hoteNameWithoutBrackets1 = hotels.get(0).getName().split("(\\()");
                                String[] hotelName1 = null;
                                hotelName1 = hoteNameWithoutBrackets1[0].split("( )|(\\()|(\\))|(-)");
                                if (hotels.get(0).getLongitude() != null && hotels.get(0).getLatitude() != null
                                        && !hotels.get(0).getLongitude().equals("") && !hotels.get(0).getLatitude().equals("")) {
                                    String h1longt = hotels.get(0).getLongitude();
                                    String h1lat = hotels.get(0).getLatitude();
                                    if (h1lat.length() > 1 && h1longt.length() > 1) {
                                        String[] splitH1lat = h1lat.split(Pattern.quote("."));
                                        String[] splitH1longt = h1longt.split(Pattern.quote("."));
                                        if (splitH1lat[1].length() > 3)
                                            splitH1lat[1] = splitH1lat[1].substring(0, 3);
                                        if (splitH1longt[1].length() > 3)
                                            splitH1longt[1] = splitH1longt[1].substring(0, 3);
                                        if (splitH1lat != null && splitH1longt != null && splitH1lat.length > 1 && splitH1longt.length > 1) {
                                            for (int z = 0; z < roomTypeProviderHotels.size(); z++) {
                                                if (roomTypeProviderHotels.get(z).getProviderId() != hotels.get(0).getProviderId()) {
                                                    String[] hoteNameWithoutBrackets2 = roomTypeProviderHotels.get(z).getName().split("(\\()");
                                                    String[] hotelName2 = null;
                                                    hotelName2 = hoteNameWithoutBrackets2[0].split("( )|(\\()|(\\))|(-)");
                                                    int countSamewords = 0;
                                                    if (hotelName1 != null && hotelName2 != null) {
                                                        for (int k = 0; k < hotelName1.length; k++) {
                                                            if (hotelName1.equals(""))
                                                                continue;
                                                            for (int j = 0; j < hotelName2.length; j++) {
                                                                if (hotelName1[k].equals(hotelName2[j]) && !hotelName1[k].equals("Hotel") && !hotelName1[k].equals("HOTEL")) {
                                                                    countSamewords++;
                                                                }
                                                            }
                                                        }
                                                        if ((hotelName1.length >= 2 && countSamewords > 1) || (hotelName1.length < 2 && countSamewords > 0)) {
                                                            if (roomTypeProviderHotels.get(z).getLatitude() != null && roomTypeProviderHotels.get(z).getLongitude() != null
                                                                    && !roomTypeProviderHotels.get(z).getLongitude().equals("") && !roomTypeProviderHotels.get(z).getLatitude().equals("")) {

                                                                String h2lat = roomTypeProviderHotels.get(z).getLatitude();
                                                                String h2longt = roomTypeProviderHotels.get(z).getLongitude();
                                                                if (h2lat.length() > 1 && h2longt.length() > 1) {
                                                                    String[] splitH2lat = h2lat.split(Pattern.quote("."));
                                                                    String[] splitH2longt = h2longt.split(Pattern.quote("."));
                                                                    if (splitH2lat[1].length() > 3)
                                                                        splitH2lat[1] = splitH2lat[1].substring(0, 3);
                                                                    if (splitH2longt[1].length() > 3)
                                                                        splitH2longt[1] = splitH2longt[1].substring(0, 3);
                                                                    if (splitH2lat != null && splitH2longt != null && splitH2lat.length > 1 && splitH2longt.length > 1) {
                                                                        if (splitH1lat[0].equals(splitH2lat[0]) && splitH1longt[0].equals(splitH2longt[0]) && splitH1lat[1].equals(splitH2lat[1]) && splitH1longt[1].equals(splitH2longt[1])) {
                                                                            originalHotelId=String.valueOf(roomTypeProviderHotels.get(z).getHotelId());
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else
                        originalHotelId = String.valueOf(hotelmappingBean.getHotelId());
                }
            }

            if (roomtypeBean.getProviderId() == sanHotelsProviderId) {

                /**
                 * Get original meal id
                 */
                int originalMealId = 0;
                String id = MealDAO.getOriginalMealId(String.valueOf(params.getMealId()));
                if (id != null)
                    originalMealId = Integer.parseInt(id);



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
                    sunHotelsRequest = params.getCurrency() + "," + "English" + "," +
                            xmlCheckin + "," + xmlCheckout + "," + params.getRooms() + "," + params.getAdults() + "," + params.getChildren() + "," +
                            childrenAges + "," + params.getInfant() + "," + originalMealId + "," + params.getCustomerCountry() + "," + "" + "," +
                            params.getSearchPrice() + "," + "" + "," + originalHotelId + "," + roomtypeBean.getRoomtypeId() + "," + "true" + "," +
                            params.getShowPriceBreakdown();
                    result = nonStaticXMLAPISoap.preBookV2(sunhotelsUsername, sunhotelspass, params.getCurrency(), "English",
                            xmlCheckin, xmlCheckout, params.getRooms(), params.getAdults(), params.getChildren(),
                            childrenAges, params.getInfant(), originalMealId, params.getCustomerCountry(), "",
                            params.getSearchPrice(), "", originalHotelId, roomtypeBean.getRoomtypeId(), "true",
                            params.getShowPriceBreakdown());
                } catch (DatatypeConfigurationException e) {
                    prebookJSON.setSuccess(false);
                    prebookJSON.setErrorMessageText("Wrong date type.The correct format is yyyy-mm-dd");
                    prebookLogBean.setClient("ATB Holidays");
                    try {
                        prebookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                    } catch (JsonProcessingException e1) {
                        prebookLogBean.setClientRequest("");
                    }
                    try {
                        prebookLogBean.setClientResponse(mapper.writeValueAsString(prebookJSON).toString());
                    } catch (JsonProcessingException e1) {
                        prebookLogBean.setClientResponse("");
                    }
                    prebookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                    prebookLogBean.setPrebookRef("");
                    prebookLogBean.setProvider("SunHotels");
                    prebookLogBean.setProviderRequest("");
                    prebookLogBean.setProviderResponse("");
                    PrebookLogDAO.addPrebookLogBean(prebookLogBean);
                    return prebookJSON;
                } catch (NullPointerException e) {
                    prebookJSON.setSuccess(false);
                    prebookJSON.setErrorMessageText("Wrong date type.The correct format is yyyy-mm-dd");
                    prebookLogBean.setClient("ATB Holidays");
                    try {
                        prebookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                    } catch (JsonProcessingException e1) {
                        prebookLogBean.setClientRequest("");
                    }
                    try {
                        prebookLogBean.setClientResponse(mapper.writeValueAsString(prebookJSON).toString());
                    } catch (JsonProcessingException e1) {
                        prebookLogBean.setClientResponse("");
                    }
                    prebookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                    prebookLogBean.setPrebookRef("");
                    prebookLogBean.setProvider("SunHotels");
                    prebookLogBean.setProviderRequest("");
                    prebookLogBean.setProviderResponse("");
                    PrebookLogDAO.addPrebookLogBean(prebookLogBean);
                    return prebookJSON;
                }


                /**
                 * Response
                 */
                if (result != null && result.getError() != null) {
                    prebookJSON.setErrorMessageText(result.getError().getMessage());
                    prebookJSON.setSuccess(false);
                } else if (result != null) {
                    prebookJSON.setCancelationPolicies(result.getCancellationPolicies());
                    prebookJSON.setNotes(result.getNotes());
                    prebookJSON.setPrice(result.getPrice());
                    prebookJSON.setPreBookCode(result.getPreBookCode()+"ID:"+sanHotelsProviderId);
                    prebookJSON.setPriceBreakDown(result.getPriceBreakdown());
                    prebookJSON.setRoomId(result.getRoomId());
                    prebookJSON.setSuccess(true);
                } else {
                    prebookJSON.setSuccess(false);
                    prebookJSON.setErrorMessageText("Communication Error");
                    prebookLogBean.setClient("ATB Holidays");
                    try {
                        prebookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
                    } catch (JsonProcessingException e1) {
                        prebookLogBean.setClientRequest("");
                    }
                    try {
                        prebookLogBean.setClientResponse(mapper.writeValueAsString(prebookJSON).toString());
                    } catch (JsonProcessingException e1) {
                        prebookLogBean.setClientResponse("");
                    }
                    prebookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                    prebookLogBean.setPrebookRef("");
                    prebookLogBean.setProvider("SunHotels");
                    prebookLogBean.setProviderRequest("");
                    prebookLogBean.setProviderResponse("");
                    PrebookLogDAO.addPrebookLogBean(prebookLogBean);
                    return prebookJSON;
                }
            } else if (roomtypeBean.getProviderId() == hotelBedsProviderId) {

                childrenAgesSplit = null;
                Stay stay = new Stay();
                stay.setCheckIn(params.getCheckInDate());
                stay.setCheckOut(params.getCheckOutDate());
                stay.setShiftDays("1");
                availabilityPOST.setStay(stay);
                Occupancy occupancy = new Occupancy();
                List<Occupancy> occupancies = new ArrayList<>();
                occupancy.setAdults(params.getAdults());
                occupancy.setChildren(params.getChildren());
                occupancy.setRooms(params.getRooms());
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
                filter.setMaxRate(null);
                filter.setMinRate(null);
                availabilityPOST.setFilter(filter);
                Board board=new Board();
                board.setIncluded(true);
                List<String> boardcodes=new ArrayList<>();
                boardcodes.add(MealDAO.getOriginalMealId(String.valueOf(params.getMealId())));
                board.setBoard(boardcodes);
                availabilityPOST.setBoards(board);
                HotelPost hotels = new HotelPost();
                List<Integer> hs = new ArrayList<>();
                if (params.getHotelId() != null && !params.getHotelId().equals("")) {
                    if(!originalHotelId.equals(""))
                        hs.add(Integer.parseInt(originalHotelId));
                    hotels.setHotel(hs);
                    availabilityPOST.setHotels(hotels);
                    availabilityAPIJSON = AvailabilityDAOs.availability(availabilityPOST);
                    if (availabilityAPIJSON != null && availabilityAPIJSON.getError() == null) {
                        if (availabilityAPIJSON.getHotels() != null && availabilityAPIJSON.getHotels().getHotels() != null) {
                            for (Beans.HotelBedsAPIBeans.Availability.Hotel hotel : availabilityAPIJSON.getHotels().getHotels()) {
                                for (Beans.HotelBedsAPIBeans.Availability.Room room : hotel.getRooms()) {
                                    if (room.getCode().equals(roomtypeBean.getRoomtypeId())) {
                                        for (Rate rate : room.getRates()) {

                                            if (rate.getNet() != null && !rate.getNet().equals("")) {

                                                if (false) {//rate.getRateType().equals("BOOKABLE")

                                                    ArrayOfStaticPercentageCancellationPolicy arrayOfStaticPercentageCancellationPolicy = new ArrayOfStaticPercentageCancellationPolicy();
                                                    List<StaticPercentageCancellationPolicy> cancelationPolicies;
                                                    StaticPercentageCancellationPolicy cancelationPolicy;
                                                    cancelationPolicies = new ArrayList<>();
                                                    if (rate.getCancellationPolicies() != null) {
                                                        for (CancellationPolicy policy : rate.getCancellationPolicies()) {//todo ask about roomtypes codes whichare not comming all
                                                            BigDecimal percentange = new BigDecimal((Double.parseDouble(policy.getAmount()) * 100) / Double.parseDouble(rate.getNet())).setScale(0, BigDecimal.ROUND_HALF_UP);
                                                            cancelationPolicy = new StaticPercentageCancellationPolicy();
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
                                                        arrayOfStaticPercentageCancellationPolicy.setCancellationPolicy(cancelationPolicies);
                                                    }
                                                    prebookJSON.setCancelationPolicies(arrayOfStaticPercentageCancellationPolicy);
                                                    ArrayOfCalendarNote5 arrayOfCalendarNote5 = new ArrayOfCalendarNote5();
                                                    prebookJSON.setNotes(arrayOfCalendarNote5);
                                                    MonetaryValue monetaryValue = new MonetaryValue();
                                                    BigDecimal price=null;
                                                    if( params.getCurrency()!=null)
                                                        price= CurrencyConverter.findExchangeRateAndConvert( hotelBedsDeafultCurrency, params.getCurrency(), Double.parseDouble(rate.getNet()));
                                                    if(price!=null)
                                                        monetaryValue.setValue(price.setScale(2, BigDecimal.ROUND_HALF_UP));
                                                    monetaryValue.setCurrency(params.getCurrency());
                                                    prebookJSON.setPrice(monetaryValue);
                                                    prebookJSON.setPreBookCode(rate.getRateKey()+"ID:"+hotelBedsProviderId);
                                                    prebookJSON.setPriceBreakDown(null);
                                                    prebookJSON.setRoomId(String.valueOf(roomtypeBean.getId()));
                                                    prebookJSON.setSuccess(true);
                                                } else{ //if (rate.getRateType().equals("RECHECK")) {
                                                    CheckRatePost checkRatePost=new CheckRatePost();
                                                    RateKey rateKey =new RateKey();
                                                    rateKey.setRateKey(rate.getRateKey());
                                                    List<RateKey> rateKeys=new ArrayList<>();
                                                    rateKeys.add(rateKey);
                                                    checkRatePost.setRooms(rateKeys);
                                                    CheckRateAPIJSON checkRateAPIJSON=null;
                                                    checkRateAPIJSON = BookDAOs.checkRate(checkRatePost);

                                                    if (checkRateAPIJSON != null && checkRateAPIJSON.getError() == null) {
                                                        if (checkRateAPIJSON.getHotel() != null) {
                                                                for (Beans.HotelBedsAPIBeans.Availability.Room checkRateroom : checkRateAPIJSON.getHotel().getRooms()) {
                                                                    if (checkRateroom.getCode().equals(roomtypeBean.getRoomtypeId())) {
                                                                        for (Rate checkRate : checkRateroom.getRates()) {
                                                                            ArrayOfStaticPercentageCancellationPolicy arrayOfStaticPercentageCancellationPolicy = new ArrayOfStaticPercentageCancellationPolicy();
                                                                            List<StaticPercentageCancellationPolicy> cancelationPolicies;
                                                                            StaticPercentageCancellationPolicy cancelationPolicy;
                                                                            cancelationPolicies = new ArrayList<>();
                                                                            if (checkRate.getCancellationPolicies() != null) {
                                                                                for (CancellationPolicy policy : checkRate.getCancellationPolicies()) {
                                                                                    BigDecimal percentange = new BigDecimal((Double.parseDouble(policy.getAmount()) * 100) / Double.parseDouble(checkRate.getNet())).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                                                    cancelationPolicy = new StaticPercentageCancellationPolicy();
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
                                                                                arrayOfStaticPercentageCancellationPolicy.setCancellationPolicy(cancelationPolicies);
                                                                            }
                                                                            prebookJSON.setCancelationPolicies(arrayOfStaticPercentageCancellationPolicy);
                                                                            ArrayOfCalendarNote5 arrayOfCalendarNote5 = new ArrayOfCalendarNote5();
                                                                            CalendarNote calendarNote=new CalendarNote();
                                                                            calendarNote.setText(checkRate.getRateComments());
                                                                            List<CalendarNote> notes=new ArrayList<>();
                                                                            notes.add(calendarNote);
                                                                            arrayOfCalendarNote5.setNote(notes);

                                                                            prebookJSON.setNotes(arrayOfCalendarNote5);
                                                                            MonetaryValue monetaryValue = new MonetaryValue();
                                                                            if (checkRate.getNet() != null && !checkRate.getNet().equals("")) {

                                                                                if (checkRate.getRateType().equals("BOOKABLE")) {

                                                                                    BigDecimal price=null;
                                                                                    if( params.getCurrency()!=null)
                                                                                        price= CurrencyConverter.findExchangeRateAndConvert( hotelBedsDeafultCurrency, params.getCurrency(), Double.parseDouble(checkRate.getNet()));
                                                                                    if(price!=null)
                                                                                        monetaryValue.setValue(price.setScale(2, BigDecimal.ROUND_HALF_UP));
                                                                                    monetaryValue.setCurrency(params.getCurrency());
                                                                                    prebookJSON.setPrice(monetaryValue);
                                                                                    prebookJSON.setPreBookCode(checkRate.getRateKey()+"ID:"+hotelBedsProviderId);
                                                                                    prebookJSON.setPriceBreakDown(null);
                                                                                    prebookJSON.setRoomId(String.valueOf(roomtypeBean.getId()));
                                                                                    prebookJSON.setSuccess(true);
                                                                                }else{
                                                                                    prebookJSON.setSuccess(false);
                                                                                    prebookJSON.setErrorMessageText("Couldn't make the rate key bookable.");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                        }else {
                                                            prebookJSON.setSuccess(false);
                                                            prebookJSON.setErrorMessageText("No data found");
                                                        }
                                                    }else {
                                                        if(checkRateAPIJSON.getError()!=null)
                                                            prebookJSON.setErrorMessageText(checkRateAPIJSON.getError().getMessage());
                                                        else
                                                            prebookJSON.setErrorMessageText("Communication Error");
                                                        prebookJSON.setSuccess(false);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }else {
                            prebookJSON.setSuccess(false);
                            prebookJSON.setErrorMessageText("No data found");
                        }
                    }else {
                        if(availabilityAPIJSON.getError()!=null)
                            prebookJSON.setErrorMessageText(availabilityAPIJSON.getError().getMessage());
                        else
                            prebookJSON.setErrorMessageText("Communication Error");
                        prebookJSON.setSuccess(false);
                    }
                }


            } else if (roomtypeBean.getProviderId() == atbHotelsProvider || roomtypeBean.getProviderId() == mattHotelsProvider) {

                if(checkout.isBefore(checkin) || params.getCheckInDate().equals(params.getCheckOutDate())){
                    prebookJSON.setPrice(null);
                    prebookJSON.setNotes(null);
                    prebookJSON.setErrorMessageText("Wrong dates.");
                    prebookJSON.setPriceBreakDown(null);
                    prebookJSON.setRoomId("");
                    prebookJSON.setCancelationPolicies(null);
                    prebookJSON.setPreBookCode("");
                }else {
                    List<HotelBean> hotels = null;
                    List<RoomAvailableBean> rooms = null;
                    if (!originalHotelId.equals("")) {
                        hotels = HotelDAO.getHotelByHotelId(Integer.parseInt(originalHotelId), roomtypeBean.getProviderId(), null);
                        if (hotels != null && hotels.size() == 1) {
                            String mealid = MealDAO.getOriginalMealId(String.valueOf(params.getMealId()));
                            if (mealid != null)
                                rooms = RoomAvailableDAO.getRoomAvailable(hotels, params.getCheckInDate(), params.getCheckOutDate(), mealid);
                            if (rooms != null) {
                                for (HotelBean hotel : hotels) {
                                    if (hotel.isActive()) {
                                        for (RoomAvailableBean roomAvailableBean : rooms) {
                                            if (Integer.compare(roomAvailableBean.getHotelId(), hotel.getHotelId()) == 0) {
                                                RoomBean room = RoomDAO.getRoomBeanByAtbRoomId(String.valueOf(roomAvailableBean.getRoomId()), roomAvailableBean.getHotelId(), roomAvailableBean.getProviderId(), null);
                                                if (room != null) {

                                                    int adultsPerRoom = (params.getAdults() + params.getRooms() - 1) / params.getRooms();
                                                    int childsPerRoom = (params.getChildren() + params.getRooms() - 1) / params.getRooms();
                                                    int infantPerRoom = (params.getInfant() + params.getRooms() - 1) / params.getRooms();
                                                    if (adultsPerRoom <= room.getMaxAdultOccupation() && childsPerRoom <= room.getMaxChildOccupation() &&
                                                            adultsPerRoom >= room.getMinAdultOccupation() && childsPerRoom >= room.getMinChildOccupation() &&
                                                            infantPerRoom >= room.getMinInfantOccupation() && infantPerRoom <= room.getMaxInfantOccupation() &&
                                                            adultsPerRoom + childsPerRoom <= room.getMaxAdultOccupation()) {


                                                        String checkIndate[] = params.getCheckInDate().split("-");
                                                        String checkOutdate[] = params.getCheckOutDate().split("-");
                                                        if (checkIndate.length == 3 && checkOutdate.length == 3) {
                                                            try {
                                                                checkin = ZonedDateTime.of(LocalDate.of(Integer.parseInt(checkIndate[0]), Integer.parseInt(checkIndate[1]), Integer.parseInt(checkIndate[2])),
                                                                        LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                                                                checkout = ZonedDateTime.of(LocalDate.of(Integer.parseInt(checkOutdate[0]), Integer.parseInt(checkOutdate[1]), Integer.parseInt(checkOutdate[2])),
                                                                        LocalTime.of(9, 30), ZoneId.of("America/New_York"));

                                                                List<String> dates = new ArrayList<>();

                                                                for (ZonedDateTime date = checkin; date.isBefore(checkout); date = date.plusDays(1)) {
                                                                    String day;
                                                                    String month;
                                                                    if (date.getMonthValue() < 10)
                                                                        month = "0" + date.getMonthValue();
                                                                    else
                                                                        month = "" + date.getMonthValue();
                                                                    if (date.getDayOfMonth() < 10)
                                                                        day = "0" + date.getDayOfMonth();
                                                                    else
                                                                        day = "" + date.getDayOfMonth();
                                                                    dates.add(date.getYear() + "-" + month + "-" + day);
                                                                }
                                                                List<RoomPriceBean> roomPrices = RoomPriceDAO.getRoomPricesbyRoomId(String.valueOf(room.getAtbRoomId()), room.getProviderId(), dates, roomAvailableBean.getId(), null);
                                                                Double sumPrice = new Double(0);
                                                                if (roomPrices != null && roomPrices.size() == dates.size()) {
                                                                    for (RoomPriceBean roomPrice : roomPrices) {
                                                                        Double price = Double.parseDouble(CurrencyConverter.findExchangeRateAndConvert(roomPrice.getCurrency(), params.getCurrency(), Double.parseDouble(roomPrice.getRoomPrice())).toString());
                                                                        Period period = Period.between(LocalDate.now(), LocalDate.parse(params.getCheckInDate()));
                                                                        period.getDays();
                                                                        if (price == null || Integer.valueOf(roomPrice.getMinStay()).compareTo(dates.size()) == 1 ||
                                                                                (period != null && period.getYears() == 0 && period.getMonths() == 0 &&
                                                                                        Integer.compare(Integer.parseInt(roomPrice.getReleaseDay()), period.getDays()) == 1)) {//todo check if release day is more than one month
                                                                            sumPrice = 0.0;
                                                                            break;
                                                                        }
                                                                        Double priceforRooms = price * params.getRooms();
                                                                        Double priceforextrabeds = (((params.getAdults() + params.getChildren()) - (params.getRooms() * room.getBedCount())) * Double.parseDouble(roomPrice.getExtraBedPrice()));
                                                                        priceforextrabeds = Double.parseDouble(CurrencyConverter.findExchangeRateAndConvert(roomPrice.getCurrency(), params.getCurrency(), priceforextrabeds).toString());
                                                                        Double proceForInfants = (Double.parseDouble(roomPrice.getInfantPrice()) * params.getInfant());
                                                                        proceForInfants = Double.parseDouble(CurrencyConverter.findExchangeRateAndConvert(roomPrice.getCurrency(), params.getCurrency(), proceForInfants).toString());
                                                                        sumPrice = sumPrice + (priceforRooms) + priceforextrabeds + proceForInfants;
                                                                    }
                                                                }

                                                                ArrayOfStaticPercentageCancellationPolicy arrayOfStaticPercentageCancellationPolicy = new ArrayOfStaticPercentageCancellationPolicy();
                                                                List<StaticPercentageCancellationPolicy> policiesResponse = new ArrayList<>();
                                                                List<RoomPolicyBean> policices = RoomPolicyDAO.getRoomPolicies(room.getHotelId(), String.valueOf(room.getAtbRoomId()), room.getProviderId());
                                                                if (policices != null) {
                                                                    for (RoomPolicyBean policy : policices) {
                                                                        StaticPercentageCancellationPolicy policyResponse = new StaticPercentageCancellationPolicy();
                                                                        policyResponse.setText("Cancellation made less than " + Integer.parseInt(policy.getPerDeadline()) + " hours  prior to the arrival will be charged with " + new BigDecimal(Double.parseDouble(policy.getPercent())) + "% of the total booking value.");
                                                                        policyResponse.setDeadline(Integer.parseInt(policy.getPerDeadline()));
                                                                        policyResponse.setPercentage(new BigDecimal(Double.parseDouble(policy.getPercent())));
                                                                        policiesResponse.add(policyResponse);
                                                                    }
                                                                }
                                                                arrayOfStaticPercentageCancellationPolicy.setCancellationPolicy(policiesResponse);


                                                                if (sumPrice != 0.0) {
                                                                    MonetaryValue monetaryValue = new MonetaryValue();
                                                                    monetaryValue.setValue(new BigDecimal(sumPrice).setScale(2, BigDecimal.ROUND_HALF_UP));
                                                                    monetaryValue.setCurrency(params.getCurrency());
                                                                    prebookJSON.setPrice(monetaryValue);
                                                                    GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
                                                                    GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);
                                                                    XMLGregorianCalendar xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
                                                                    XMLGregorianCalendar xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
                                                                    ArrayOfCalendarNote5 arrayOfCalendarNote5=new ArrayOfCalendarNote5();
                                                                    List<CalendarNote> notes=new ArrayList<>();
                                                                    CalendarNote note=new CalendarNote();
                                                                    note.setText("This is A note");
                                                                    note.setEndDate(xmlCheckout);
                                                                    note.setStartDate(xmlCheckin);
                                                                    notes.add(note);
                                                                    arrayOfCalendarNote5.setNote(notes);
                                                                    prebookJSON.setNotes(arrayOfCalendarNote5);
                                                                    prebookJSON.setErrorMessageText("");
                                                                    PriceBreakdownResult priceBreakdownResult=new PriceBreakdownResult();
                                                                    priceBreakdownResult.setCurrency(params.getCurrency());
                                                                    priceBreakdownResult.setTotal(new BigDecimal(sumPrice).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                                                                    priceBreakdownResult.setTo(xmlCheckout);
                                                                    priceBreakdownResult.setFrom(xmlCheckin);
                                                                    prebookJSON.setPriceBreakDown(priceBreakdownResult);
                                                                    prebookJSON.setRoomId(String.valueOf(room.getAtbRoomId()));
                                                                    prebookJSON.setCancelationPolicies(arrayOfStaticPercentageCancellationPolicy);
                                                                    prebookJSON.setPreBookCode(GenerateRandomString.randomUUID(25, 0, 'd'));
                                                                } else {
                                                                    prebookJSON.setPrice(null);
                                                                    prebookJSON.setNotes(null);
                                                                    prebookJSON.setErrorMessageText("No rates.");
                                                                    prebookJSON.setPriceBreakDown(null);
                                                                    prebookJSON.setRoomId("");
                                                                    prebookJSON.setCancelationPolicies(null);
                                                                    prebookJSON.setPreBookCode("");
                                                                }


                                                                //todo check for stock and allocation


                                                            } catch (NumberFormatException e) {
                                                                StringWriter errors = new StringWriter();
                                                                e.printStackTrace(new PrintWriter(errors));
                                                                errLogger.info(errors.toString());
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }


            prebookJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
            prebookLogBean.setClient("ATB Holidays");
            try {
                prebookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
            } catch (JsonProcessingException e1) {
                prebookLogBean.setClientRequest("");
            }
            try {
                prebookLogBean.setClientResponse(mapper.writeValueAsString(prebookJSON).toString());
            } catch (JsonProcessingException e1) {
                prebookLogBean.setClientResponse("");
            }
            prebookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));

            if (roomtypeBean.getProviderId() == sanHotelsProviderId) {
                prebookLogBean.setPrebookRef(prebookJSON.getPreBookCode());
                prebookLogBean.setProvider(sanHotelsProviderName);
                try {
                    prebookLogBean.setProviderResponse(mapper.writeValueAsString(result).toString());
                    prebookLogBean.setProviderRequest(sunHotelsRequest);
                } catch (JsonProcessingException e1) {
                    prebookLogBean.setProviderResponse("");
                    prebookLogBean.setProviderRequest("");
                }
            } else if (roomtypeBean.getProviderId() == hotelBedsProviderId) {
                prebookLogBean.setPrebookRef(prebookJSON.getPreBookCode());
                prebookLogBean.setProvider(hotelBedsProvideName);
                prebookLogBean.setProviderRequest("");
                try {
                    prebookLogBean.setProviderResponse(mapper.writeValueAsString(availabilityAPIJSON).toString());
                    prebookLogBean.setProviderRequest(mapper.writeValueAsString(availabilityPOST).toString());
                } catch (JsonProcessingException e1) {
                    prebookLogBean.setProviderResponse("");
                    prebookLogBean.setProviderRequest("");
                }
            } else if (roomtypeBean.getProviderId() == mattHotelsProvider) {
                prebookLogBean.setPrebookRef(prebookJSON.getPreBookCode());
                prebookLogBean.setProvider(String.valueOf(mattHotelsProvider));
                prebookLogBean.setProviderRequest("");
                try {
                    prebookLogBean.setProviderResponse(mapper.writeValueAsString(availabilityAPIJSON).toString());
                    prebookLogBean.setProviderRequest(mapper.writeValueAsString(availabilityPOST).toString());
                } catch (JsonProcessingException e1) {
                    prebookLogBean.setProviderResponse("");
                    prebookLogBean.setProviderRequest("");
                }
            }else if (roomtypeBean.getProviderId() == atbHotelsProvider) {
                prebookLogBean.setPrebookRef(prebookJSON.getPreBookCode());
                prebookLogBean.setProvider(String.valueOf(atbHotelsProvider));
                prebookLogBean.setProviderRequest("");
                try {
                    prebookLogBean.setProviderResponse(mapper.writeValueAsString(availabilityAPIJSON).toString());
                    prebookLogBean.setProviderRequest(mapper.writeValueAsString(availabilityPOST).toString());
                } catch (JsonProcessingException e1) {
                    prebookLogBean.setProviderResponse("");
                    prebookLogBean.setProviderRequest("");
                }
            }
            if(PrebookLogDAO.addPrebookLogBean(prebookLogBean)){
                prebookJSON.setSuccess(false);
                prebookJSON.setRoomId(null);
                prebookJSON.setPreBookCode(null);
                prebookJSON.setPriceBreakDown(null);
                prebookJSON.setPrice(null);
                prebookJSON.setNotes(null);
                prebookJSON.setCancelationPolicies(null);
                prebookJSON.setErrorMessageText("Failed to store prebook at prebookLog");
            }
        }catch(Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }
        return prebookJSON;

    }




    @RequestMapping(value = "/hotel/noPicturesSearch", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public SunHotelsSearchJSON noPicturesSearch(@RequestBody SunHotelsSearchPOST params){

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
//
//              //**
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
//        /**
//         * Send only the first x hotels from the list as a response.
//         */
//            if(hotelsResponse!=null) {
//                for (int i = hotelsResponse.size() - 1; i > countOfDisplayedHotels-1; i--)
//                        hotelsResponse.remove(i);
//            }
        SunHotelsSearchJSON hotelSearchJSON = new SunHotelsSearchJSON();
        Application.agent.time("app.web.request.timming.frontend.noPicturesSearch", new Runnable() {
            public void run() {
                Application.agent.increment("app.web.request.frontend.noPircturesSearch");

                StatelessSession session = SunHotelsHibernateUtil.getSession();
                session.beginTransaction();


                /**
                 * If the search is for first time continue to the code bellow.
                 */

                DestinationBean destinationBean = null;
                String[] childrenAgesSplit = null;
                String strOriginalHotelId = "";
                String childrenAges = "";
                String originalDestinationIdStrFormat = "";
                String currencies = "";
                ZonedDateTime checkin = null;
                ZonedDateTime checkout = null;
                int originalDestinationId = 0;
                long prepareResponseTimeElapsed = 0;
                long dbTransactionTimeElapsed = 0;
                long requestTimeElapsed = 0;


                try {
                    /**
                     * Dates request parameters
                     */
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
                     * Currencies Attributes
                     */
                    if (params.getCurrencies() != null && params.getCurrencies().size() > 0) {
                        currencies = "" + params.getCurrencies().get(0);
                        for (String currency : params.getCurrencies())
                            currencies = currencies + "," + currency;
                    }

                    /**
                     * Get original id from Object table.
                     */
                    if (params.getDestinationId() != null && !params.getDestinationId().equals("")) {
                        DestinationDAO.increaseSortOrderOfDestination(params.getDestinationId());
                        destinationBean = DestinationDAO.getDestinationBeanByATBId(params.getDestinationId());
                        if (destinationBean != null) {
                            if (destinationBean.getDestinationId() != 0)
                                originalDestinationId = destinationBean.getDestinationId();
                            if (originalDestinationId == 0 && (destinationBean.getHotelBedsCode() == null || destinationBean.getHotelBedsCode().equals(""))) {
                                return ;
                            } else
                                originalDestinationIdStrFormat = String.valueOf(originalDestinationId);
                        }
                    }


                    /**
                     * Fix children ages because they come like this ﻿'0,0,0,5,4,0,0,0'
                     */

                    boolean firstChildAge = true;//todo  check duplications in hotel types and meals and prices
                    if (params.getChildrenAges() != null && params.getChildrenAges() != "") {
                        childrenAgesSplit = params.getChildrenAges().split(",");
                        if (childrenAgesSplit != null && childrenAgesSplit.length > 0) {
                            for (String age : childrenAgesSplit) {
                                if (age != null && !age.equals("0") && !age.equals("")) {
                                    if (firstChildAge) {
                                        childrenAges = age;
                                        firstChildAge = false;
                                    } else {
                                        childrenAges = childrenAges + "," + age;
                                    }
                                }
                            }
                        }

                    }

                    if(params.getCurrencies()==null || params.getCurrencies().size()!=1){
                        return;
                    }


                    /**
                     * Prepare and run threads for different Providers
                     */
                    List<SunHotelsResponse> hotelsResponse = new ArrayList<>();
                    CountDownLatch latch = new CountDownLatch(1);
//                    HotelBedsSearchThread hotelBedsSearchThread = new HotelBedsSearchThread(destinationBean, childrenAgesSplit, checkout, checkin, session, params, latch);
//                    new Thread(hotelBedsSearchThread).start();
//                    SunHotelsSearchThread sunHotelsSearchThread = new SunHotelsSearchThread(originalDestinationId, checkout, checkin, currencies, originalDestinationIdStrFormat, childrenAges, session, params, latch);
//                    new Thread(sunHotelsSearchThread).start();
//                    ATBHotelsSearchThread aTBHotelsSearchThread = new ATBHotelsSearchThread(destinationBean, childrenAgesSplit, checkout, checkin, session, params, latch);
//                    new Thread(aTBHotelsSearchThread).start();
                    TravelGateXSearchThread travelGateXSearchThread = new TravelGateXSearchThread(destinationBean, childrenAgesSplit, checkout, checkin, session, params, latch);
                    new Thread(travelGateXSearchThread).start();
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                    }
//                    if (hotelBedsSearchThread.getHotelBedsSearchRequestResponse() != null) {
//                        if (hotelBedsSearchThread.getHotelBedsSearchRequestResponse() != null && hotelBedsSearchThread.getHotelBedsSearchRequestResponse().getHotelsResponse() != null)
//                            hotelsResponse.addAll(hotelBedsSearchThread.getHotelBedsSearchRequestResponse().getHotelsResponse());
//                        dbTransactionTimeElapsed = dbTransactionTimeElapsed + hotelBedsSearchThread.getHotelBedsSearchRequestResponse().getDbTransactionTimeElapsed();
//                        prepareResponseTimeElapsed = prepareResponseTimeElapsed + hotelBedsSearchThread.getHotelBedsSearchRequestResponse().getPrepareResponseTimeElapsed();
//                        requestTimeElapsed = requestTimeElapsed + hotelBedsSearchThread.getHotelBedsSearchRequestResponse().getRequestTimeElapsed();
//                    }
//                    if (sunHotelsSearchThread.getSunHotelsSearchRequestResponse() != null) {
//                        if (sunHotelsSearchThread.getSunHotelsSearchRequestResponse() != null && sunHotelsSearchThread.getSunHotelsSearchRequestResponse().getHotelsResponse() != null)
//                            hotelsResponse.addAll(sunHotelsSearchThread.getSunHotelsSearchRequestResponse().getHotelsResponse());
//                        dbTransactionTimeElapsed = dbTransactionTimeElapsed + sunHotelsSearchThread.getSunHotelsSearchRequestResponse().getDbTransactionTimeElapsed();
//                        prepareResponseTimeElapsed = prepareResponseTimeElapsed + sunHotelsSearchThread.getSunHotelsSearchRequestResponse().getPrepareResponseTimeElapsed();
//                        requestTimeElapsed = requestTimeElapsed + sunHotelsSearchThread.getSunHotelsSearchRequestResponse().getRequestTimeElapsed();
//                    }
//                    if (aTBHotelsSearchThread.getaTBHotelsSearchRequestResponse() != null) {
//                        if (aTBHotelsSearchThread.getaTBHotelsSearchRequestResponse() != null && aTBHotelsSearchThread.getaTBHotelsSearchRequestResponse().getHotelsResponse() != null)
//                            hotelsResponse.addAll(aTBHotelsSearchThread.getaTBHotelsSearchRequestResponse().getHotelsResponse());
//                        dbTransactionTimeElapsed = dbTransactionTimeElapsed + aTBHotelsSearchThread.getaTBHotelsSearchRequestResponse().getDbTransactionTimeElapsed();
//                        prepareResponseTimeElapsed = prepareResponseTimeElapsed + aTBHotelsSearchThread.getaTBHotelsSearchRequestResponse().getPrepareResponseTimeElapsed();
//                        requestTimeElapsed = requestTimeElapsed + aTBHotelsSearchThread.getaTBHotelsSearchRequestResponse().getRequestTimeElapsed();
//                    }

                    if (travelGateXSearchThread.getTravelGateXSearchRequestResponse() != null) {
                        if (travelGateXSearchThread.getTravelGateXSearchRequestResponse() != null && travelGateXSearchThread.getTravelGateXSearchRequestResponse().getHotelsResponse() != null)
                            hotelsResponse.addAll(travelGateXSearchThread.getTravelGateXSearchRequestResponse().getHotelsResponse());
                        dbTransactionTimeElapsed = dbTransactionTimeElapsed + travelGateXSearchThread.getTravelGateXSearchRequestResponse().getDbTransactionTimeElapsed();
                        prepareResponseTimeElapsed = prepareResponseTimeElapsed + travelGateXSearchThread.getTravelGateXSearchRequestResponse().getPrepareResponseTimeElapsed();
                        requestTimeElapsed = requestTimeElapsed + travelGateXSearchThread.getTravelGateXSearchRequestResponse().getRequestTimeElapsed();
                    }

                    session.close();


                    /**
                     * Sort order by price Ascending
                     */
                    BigDecimal hotelMinprice;
                    BigDecimal nextHotelMinprice;
                    for (int i = 0; i < hotelsResponse.size(); i++) {
                        for (int z = 0; z < hotelsResponse.size(); z++) {
                            if (z != i) {
                                if (hotelsResponse.get(i).getRoom_types() != null
                                        && hotelsResponse.get(i).getRoom_types().size() > 0
                                        && hotelsResponse.get(i).getRoom_types().get(0).getRooms() != null
                                        && hotelsResponse.get(i).getRoom_types().get(0).getRooms().size() > 0
                                        && hotelsResponse.get(i).getRoom_types().get(0).getRooms().get(0).getMeals() != null
                                        && hotelsResponse.get(i).getRoom_types().get(0).getRooms().get(0).getMeals().size() > 0
                                        && hotelsResponse.get(z).getRoom_types() != null
                                        && hotelsResponse.get(z).getRoom_types().size() > 0
                                        && hotelsResponse.get(z).getRoom_types().get(0).getRooms() != null
                                        && hotelsResponse.get(z).getRoom_types().get(0).getRooms().size() > 0
                                        && hotelsResponse.get(z).getRoom_types().get(0).getRooms().get(0).getMeals() != null
                                        && hotelsResponse.get(z).getRoom_types().get(0).getRooms().get(0).getMeals().size() > 0) {

                                    hotelMinprice = hotelsResponse.get(i).getRoom_types().get(0).getRooms().get(0).getMeals().get(0).getPrice();
                                    for (SunHotelsRoomTypeWithRoomsResponse roomtype : hotelsResponse.get(i).getRoom_types()) {
                                        for (SunHotelsRoomResponse room : roomtype.getRooms()) {
                                            if (room.getMeals() != null && room.getMeals().size() > 0) {
                                                for (SunHotelsRoomMealResponse meal : room.getMeals()) {
                                                    if (hotelMinprice.compareTo(meal.getPrice()) == 1)
                                                        hotelMinprice = meal.getPrice();
                                                }
                                            }
                                        }
                                    }
                                    nextHotelMinprice = hotelsResponse.get(z).getRoom_types().get(0).getRooms().get(0).getMeals().get(0).getPrice();
                                    for (SunHotelsRoomTypeWithRoomsResponse nextRoomtype : hotelsResponse.get(z).getRoom_types()) {
                                        for (SunHotelsRoomResponse nextRoom : nextRoomtype.getRooms()) {
                                            if (nextRoom.getMeals() != null && nextRoom.getMeals().size() > 0) {
                                                for (SunHotelsRoomMealResponse meal : nextRoom.getMeals()) {
                                                    if (nextHotelMinprice.compareTo(meal.getPrice()) == 1)
                                                        nextHotelMinprice = meal.getPrice();
                                                }
                                            }
                                        }
                                    }
                                    if (hotelMinprice.compareTo(nextHotelMinprice) == -1) {
                                        SunHotelsResponse tmp1 = hotelsResponse.get(z);
                                        SunHotelsResponse tmp2 = hotelsResponse.get(i);
                                        hotelsResponse.set(z, tmp2);
                                        hotelsResponse.set(i, tmp1);
                                    }
                                }
                            }
                        }
                    }


                    /**
                     * Match same hotels from different providers.Add to hotelbeds provider hotel roomtypes from all providers
                     */
                    for (int i = 0; i < hotelsResponse.size(); i++) {
                        String[] hoteNameWithoutBrackets1 = hotelsResponse.get(i).getName().split("(\\()");
                        String[] hotelName1 = null;
                        hotelName1 = hoteNameWithoutBrackets1[0].split("( )|(\\()|(\\))|(-)");
                        if (hotelsResponse.get(i).getLongitude() != null && hotelsResponse.get(i).getLatitude() != null
                                && !hotelsResponse.get(i).getLongitude().equals("") && !hotelsResponse.get(i).getLatitude().equals("")) {
                            String h1longt = hotelsResponse.get(i).getLongitude();
                            String h1lat = hotelsResponse.get(i).getLatitude();
                            if (h1lat.length() > 1 && h1longt.length() > 1) {
                                String[] splitH1lat = h1lat.split(Pattern.quote("."));
                                String[] splitH1longt = h1longt.split(Pattern.quote("."));
                                if (splitH1lat[1].length() > 3)
                                    splitH1lat[1] = splitH1lat[1].substring(0, 3);
                                if (splitH1longt[1].length() > 3)
                                    splitH1longt[1] = splitH1longt[1].substring(0, 3);
                                if (splitH1lat != null && splitH1longt != null && splitH1lat.length > 1 && splitH1longt.length > 1) {
                                    for (int z = 0; z < hotelsResponse.size(); z++) {
                                        if (hotelsResponse.get(z).getProviderId() != hotelsResponse.get(i).getProviderId()) {
                                            String[] hoteNameWithoutBrackets2 = hotelsResponse.get(z).getName().split("(\\()");
                                            String[] hotelName2 = null;
                                            hotelName2 = hoteNameWithoutBrackets2[0].split("( )|(\\()|(\\))|(-)");
                                            int countSamewords = 0;
                                            if (hotelName1 != null && hotelName2 != null) {
                                                for (int k = 0; k < hotelName1.length; k++) {
                                                    if (hotelName1.equals(""))
                                                        continue;
                                                    for (int j = 0; j < hotelName2.length; j++) {
                                                        if (hotelName1[k].equals(hotelName2[j]) && !hotelName1[k].equals("Hotel") && !hotelName1[k].equals("HOTEL")) {
                                                            countSamewords++;
                                                        }
                                                    }
                                                }
                                                if ((hotelName1.length >= 2 && countSamewords > 1) || (hotelName1.length < 2 && countSamewords > 0)) {
                                                    if (hotelsResponse.get(z).getLatitude() != null && hotelsResponse.get(z).getLongitude() != null
                                                            && !hotelsResponse.get(z).getLongitude().equals("") && !hotelsResponse.get(z).getLatitude().equals("")) {

                                                        String h2lat = hotelsResponse.get(z).getLatitude();
                                                        String h2longt = hotelsResponse.get(z).getLongitude();
                                                        if (h2lat.length() > 1 && h2longt.length() > 1) {
                                                            String[] splitH2lat = h2lat.split(Pattern.quote("."));
                                                            String[] splitH2longt = h2longt.split(Pattern.quote("."));
                                                            if (splitH2lat[1].length() > 3)
                                                                splitH2lat[1] = splitH2lat[1].substring(0, 3);
                                                            if (splitH2longt[1].length() > 3)
                                                                splitH2longt[1] = splitH2longt[1].substring(0, 3);
                                                            if (splitH2lat != null && splitH2longt != null && splitH2lat.length > 1 && splitH2longt.length > 1) {
                                                                if (splitH1lat[0].equals(splitH2lat[0]) && splitH1longt[0].equals(splitH2longt[0]) && splitH1lat[1].equals(splitH2lat[1]) && splitH1longt[1].equals(splitH2longt[1])) {
                                                                    if (hotelsResponse.get(z).getProviderId() == mattHotelsProvider) {
                                                                        hotelsResponse.get(z).getRoom_types().addAll(new ArrayList<>(hotelsResponse.get(i).getRoom_types()));
                                                                        hotelsResponse.get(z).setName(hotelsResponse.get(z).getName());
                                                                        hotelsResponse.remove(i);
                                                                        break;
                                                                    }else if (hotelsResponse.get(i).getProviderId() == mattHotelsProvider) {
                                                                        hotelsResponse.get(i).getRoom_types().addAll(new ArrayList<>(hotelsResponse.get(z).getRoom_types()));
                                                                        hotelsResponse.get(i).setName(hotelsResponse.get(i).getName());
                                                                        hotelsResponse.remove(z);
                                                                        break;
                                                                    }else if (hotelsResponse.get(z).getProviderId() == atbHotelsProvider) {
                                                                        hotelsResponse.get(z).getRoom_types().addAll(new ArrayList<>(hotelsResponse.get(i).getRoom_types()));
                                                                        hotelsResponse.get(z).setName(hotelsResponse.get(z).getName());
                                                                        hotelsResponse.remove(i);
                                                                        break;
                                                                    }else if (hotelsResponse.get(i).getProviderId() == atbHotelsProvider) {
                                                                        hotelsResponse.get(i).getRoom_types().addAll(new ArrayList<>(hotelsResponse.get(z).getRoom_types()));
                                                                        hotelsResponse.get(i).setName(hotelsResponse.get(i).getName());
                                                                        hotelsResponse.remove(z);
                                                                        break;
                                                                    }else if (hotelsResponse.get(i).getProviderId() == hotelBedsProviderId) {
                                                                        hotelsResponse.get(i).setName(hotelsResponse.get(i).getName());
                                                                        hotelsResponse.get(i).getRoom_types().addAll(new ArrayList<>(hotelsResponse.get(z).getRoom_types()));
                                                                        hotelsResponse.remove(z);
                                                                        break;
                                                                    } else if (hotelsResponse.get(z).getProviderId() == hotelBedsProviderId) {
                                                                        hotelsResponse.get(z).getRoom_types().addAll(new ArrayList<>(hotelsResponse.get(i).getRoom_types()));
                                                                        hotelsResponse.get(z).setName(hotelsResponse.get(z).getName());
                                                                        hotelsResponse.remove(i);
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }


//            for(int i=0;i<hotelsResponse.size();i++) {
//                if(hotelsResponse.get(i).getRoom_types()!=null
//                        && hotelsResponse.get(i).getRoom_types().size()>0
//                        && hotelsResponse.get(i).getRoom_types().get(0).getRooms()!=null
//                        && hotelsResponse.get(i).getRoom_types().get(0).getRooms().size()>0
//                        && hotelsResponse.get(i).getRoom_types().get(0).getRooms().get(0).getMeals()!=null
//                        && hotelsResponse.get(i).getRoom_types().get(0).getRooms().get(0).getMeals().size()>0) {
//                    hotelMinprice = hotelsResponse.get(i).getRoom_types().get(0).getRooms().get(0).getMeals().get(0).getPrice();
//                    for (SunHotelsRoomTypeWithRoomsResponse roomtype : hotelsResponse.get(i).getRoom_types()) {
//                        for (SunHotelsRoomResponse room : roomtype.getRooms()) {
//                            if (room.getMeals() != null && room.getMeals().size() > 0) {
//                                for (SunHotelsRoomMealResponse meal : room.getMeals()) {
//                                    if (hotelMinprice.compareTo(meal.getPrice()) == 1) {
//                                        hotelMinprice = meal.getPrice();
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    System.out.println("hotel id :" + hotelsResponse.get(i).getId()+" price: "+hotelMinprice +" and providerId:"+hotelsResponse.get(i).getProviderId()+"  and i=   "+i);
//                }
//
//            }


                    /**
                     * Set 10 4star Hotels at the beggining of the list from cheap to expensive.Hotels without star ratting goes to the bottom of the list
                     */
                    int foutStarHotelsCount = 0;
                    for (int i = 0; i < hotelsResponse.size(); i++) {
                        if (foutStarHotelsCount <= 9 && hotelsResponse.get(i).getStar_rating() != null && hotelsResponse.get(i).getStar_rating().length() > 0) {
                            if (Character.getNumericValue(hotelsResponse.get(i).getStar_rating().charAt(0)) == 4) {
                                SunHotelsResponse hotel;
                                hotel = hotelsResponse.get(i);
                                hotelsResponse.remove(i);
                                hotelsResponse.add(foutStarHotelsCount, hotel);
                                foutStarHotelsCount++;
                                continue;
                            }
                        }

                        if ((hotelsResponse.get(i).getStar_rating() == null || hotelsResponse.get(i).getStar_rating().equals(""))) {
                            SunHotelsResponse hotel;
                            hotel = hotelsResponse.get(i);
                            hotelsResponse.remove(i);
                            hotelsResponse.add(hotelsResponse.size(), hotel);
                            continue;
                        } else if (hotelsResponse.get(i).getStar_rating() != null && !hotelsResponse.get(i).getStar_rating().equals("")
                                && Character.getNumericValue(hotelsResponse.get(i).getStar_rating().charAt(0)) == 0) {
                            SunHotelsResponse hotel;
                            hotel = hotelsResponse.get(i);
                            hotelsResponse.remove(i);
                            hotelsResponse.add(hotelsResponse.size(), hotel);
                        }
                    }


//        /**
//         * Send only the x hotels from the list as a response.
//         */
//        if (hotelsResponse != null) {
//            int z = 0;
//            for (Iterator<SunHotelsResponse> iter = hotelsResponse.listIterator(); iter.hasNext(); ) {
//                iter.next();
//                if (params.getListStartPosition() > z)
//                    iter.remove();
//                if (params.getListLastPosition() < z)
//                    iter.remove();
//                z++;
//            }
//        }

                    hotelSearchJSON.setResults(hotelsResponse);

                    /**
                     *  Set count of total hotels.
                     */
                    hotelSearchJSON.setTotalHotelsCount(hotelsResponse.size());

                    hotelSearchJSON.setResults(hotelsResponse);


                    userlogs.info("Request Varibles: " + " hotelID:" + params.getHotelID() + " currencies:" + params.getCurrencies() +
                            " infant:" + params.getInfant() + " childrenAges:" + params.getChildrenAges() + " numberOfChildren:" +
                            params.getNumberOfChildren() + " numberOfRooms:" + params.getNumberOfRooms() + " numberOfAdults:" +
                            params.getNumberOfAdults() + "checkOutDate:" + params.getCheckOutDate() + " checkInDate:" + params.getCheckInDate() +
                            " customerCountry:" + params.getCustomerCountry());

                    if (hotelSearchJSON.getResults() != null) {
                        userlogs.info(" Db transactions time:" + dbTransactionTimeElapsed / 2 + ". Sunhotel communication and transactions time:" + requestTimeElapsed / 2 +
                                ". Processing time:" + prepareResponseTimeElapsed / 2 + " Response Hotels count:" + hotelSearchJSON.getResults().size() + ". Object:" + originalDestinationId);
                    } else
                        userlogs.info(" Db transactions time:" + dbTransactionTimeElapsed / 2 + ". Sunhotel communication and transactions time:" + requestTimeElapsed / 2 +
                                ". Processing time:" + prepareResponseTimeElapsed / 2 + " Response Hotels count:" + 0 + ". Object:" + originalDestinationId);
                } catch (Exception e) {
                    StringWriter errors = new StringWriter();
                    e.printStackTrace(new PrintWriter(errors));
                    errLogger.info(errors.toString());
                }
            }});
                return hotelSearchJSON;


    }




    @RequestMapping(value = "/booking/viatorBook", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public BookAPIJSON bookViator(@RequestBody APIJSONs.ATBAPIJSONs.Product.BookPOST bookPOST,@RequestParam(value="demo", defaultValue="true") boolean demo){

//        BookPOST bookPOST=new BookPOST();
//
//        bookPOST.setBooker(vBookPOST.getBooker());
//        bookPOST.setCurrencyCode(vBookPOST.getCurrencyCode());
//        bookPOST.setDemo(vBookPOST.isDemo());
//
//        Item item;
//        List<Item> items=new ArrayList<>();
//        int distributorItemRef=0;
//        if(vBookPOST.getItems()!=null) {
//            for (ViatorItem it : vBookPOST.getItems()) {
//                item = new Item();
//                item.setBookingQuestionAnswers(it.getBookingQuestionAnswers());
//                item.setHotelId(it.getHotelId());
//                item.setPickupPoint(it.getPickupPoint());
//                item.setProductCode(it.getProductCode());
//                item.setSpecialRequirements(it.getSpecialRequirements());
//                item.setTourGradeCode(it.getTourGradeCode());
//                item.setTravelDate(it.getTravelDate());
//
//
//                /**
//                 * Set service and language option //todo ask if viator is gonna add more languages than english in the fueature.If yes the code bellow must be changed
//                 */
//                boolean languageOptionCodeisSet = false;
//                List<ViatorProductTourGradeLanguageServicesBean> tourgradeServices = ViatorProductTourGradeLanguageServicesDAO.getLanguageServicesByProductCodeAndTourGrade(it.getProductCode(), it.getTourGradeCode());
//                if (tourgradeServices != null) {
//                    for (ViatorProductTourGradeLanguageServicesBean tourgradeService : tourgradeServices) {
//                        if (tourgradeService.getLanguageCodeAndService().equals("en/ENGLISH_ONLY")) {
//                            item.setLanguageOptionCode("en/ENGLISH_ONLY");
//                            languageOptionCodeisSet = true;
//                            break;
//                        }
//                    }
//                }
//                if (!languageOptionCodeisSet) {
//                    if (it.getServiceOption().equals("live"))
//                        item.setLanguageOptionCode("en/SERVICE_GUIDE");
//                    else if (it.getServiceOption().equals("booklet"))
//                        item.setLanguageOptionCode("en/SERVICE_WRITTEN");
//                    else if (it.getServiceOption().equals("audio"))
//                        item.setLanguageOptionCode("en/SERVICE_AUDIO");
//                }
//
//                PartnerItemDetail partnerItemDetail = new PartnerItemDetail();
//                distributorItemRef++;
//                partnerItemDetail.setDistributorItemRef("" + distributorItemRef);
//                item.setPartnerItemDetail(partnerItemDetail);
//
//                Traveller traveller;
//                List<Traveller> travellers = new ArrayList<>();
//                for (ViatorTraveller tr : it.getTravellers()) {
//                    traveller = new Traveller();
//
//                    if (tr.getPersonType().equals("adult"))
//                        traveller.setBandId(1);
//                    else if (tr.getPersonType().equals("child"))
//                        traveller.setBandId(2);
//                    else if (tr.getPersonType().equals("infant"))
//                        traveller.setBandId(3);
//                    else if (tr.getPersonType().equals("youth"))
//                        traveller.setBandId(4);
//                    else if (tr.getPersonType().equals("senior"))
//                        traveller.setBandId(5);
//                    traveller.setFirstname(tr.getFirstname());
//                    traveller.setLeadTraveller(tr.isLeadTraveller());
//                    traveller.setSurname(tr.getSurname());
//                    traveller.setTitle(tr.getTitle());
//                    travellers.add(traveller);
//                }
//                item.setTravellers(travellers);
//                items.add(item);
//            }
//        }
//        bookPOST.setItems(items);
//        bookPOST.setNewsletterSignUp(false);
//
//        PartnerDetail partenerDetail=new PartnerDetail();
//        partenerDetail.setDistributorRef(vBookPOST.getBookRef());
//        bookPOST.setPartnerDetail(partenerDetail);
//        return BookingsAPIDAO.book(bookPOST);

        Application.agent.increment("app.web.request.frontend.viatorBook");

        BookAPIJSON bookInfoJSON = new BookAPIJSON();
        try {
            ObjectMapper mapper = new ObjectMapper();
            BookLogBean bookLogBean = new BookLogBean();

            List<BigDecimal> atbProductPrices = new ArrayList<>();
            BigDecimal atbTotalNetPrice = new BigDecimal(0);
            BigDecimal previusAtbTotalNetPrice = new BigDecimal(0); //Used for count single item total pice.
            BigDecimal viatorTotalPrice = new BigDecimal(0);


            /**
             * Preparing items  book viator request.
             */
            Beans.ViatorAPIBeans.Bookings.Book.Item item;
            List<Beans.ViatorAPIBeans.Bookings.Book.Item> atbItems = new ArrayList<>();
            List<Beans.ViatorAPIBeans.Bookings.Book.Item> viatorItems = new ArrayList<>();
            int distributorItemRef = 0;
            PartnerItemDetail partnerItemDetail = new PartnerItemDetail();

            for (APIJSONs.ATBAPIJSONs.Product.Item it : bookPOST.getItems()) {


                AProductTitleBean product = AProductTitleDAO.getProductById(it.getProductId());
                if (product == null) {
                    bookInfoJSON.setSuccess(false);
                    bookInfoJSON.setErrorReference("Couldn't retrive product with id:" + it.getProductId() + " from database");
                    bookLogBean.setClient("ATB Holidays");
                    bookLogBean.setClientBookingId("not_succeed");
                    try {
                        bookLogBean.setClientRequest(mapper.writeValueAsString(bookPOST).toString());
                        bookLogBean.setProviderRequest("");
                    } catch (JsonProcessingException e) {
                        bookLogBean.setClientRequest("");
                        bookLogBean.setProviderRequest("");
                    }
                    try {
                        bookLogBean.setClientResponse(mapper.writeValueAsString(bookInfoJSON).toString());
                        bookLogBean.setProviderResponse("");
                    } catch (JsonProcessingException e) {
                        bookLogBean.setClientResponse("");
                        bookLogBean.setProviderResponse("");
                    }
                    DateTime dateTime = new DateTime(DateTimeZone.UTC);
                    bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                    bookLogBean.setProvider("Viator");
                    bookLogBean.setProviderBookingId("");
                    BookLogDAO.addBookLogBean(bookLogBean);
                    return bookInfoJSON;
                }
                FPricePlanBean priceplan = FPricePlanDAO.getfPricePlansById(Integer.parseInt(it.getPlanId()));
                if (priceplan == null) {
                    bookInfoJSON.setSuccess(false);
                    bookInfoJSON.setErrorReference("Couldn't retrive plan with id:" + it.getPlanId() + " from database");
                    bookLogBean.setClient("ATB Holidays");
                    bookLogBean.setClientBookingId("not_succeed");
                    try {
                        bookLogBean.setClientRequest(mapper.writeValueAsString(bookPOST).toString());
                        bookLogBean.setProviderRequest("");
                    } catch (JsonProcessingException e) {
                        bookLogBean.setClientRequest("");
                        bookLogBean.setProviderRequest("");
                    }
                    try {
                        bookLogBean.setClientResponse(mapper.writeValueAsString(bookInfoJSON).toString());
                        bookLogBean.setProviderResponse("");
                    } catch (JsonProcessingException e) {
                        bookLogBean.setClientResponse("");
                        bookLogBean.setProviderResponse("");
                    }
                    DateTime dateTime = new DateTime(DateTimeZone.UTC);
                    bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                    bookLogBean.setProvider("Viator");
                    bookLogBean.setProviderBookingId("");
                    BookLogDAO.addBookLogBean(bookLogBean);
                    return bookInfoJSON;
                }


                item = new Beans.ViatorAPIBeans.Bookings.Book.Item();
                distributorItemRef++;
                partnerItemDetail.setDistributorItemRef("" + distributorItemRef);
                item.setPartnerItemDetail(partnerItemDetail);
                item.setBookingQuestionAnswers(it.getBookingQuestionAnswers());
                item.setHotelId(it.getHotelId());
                item.setPickupPoint(it.getPickupPoint());
                item.setSpecialRequirements(it.getSpecialRequirements());
                item.setTravelDate(it.getTravelDate());
                item.setProductCode(product.getProductCode());
                item.setTourGradeCode(priceplan.getTourGradeCode());

                /**
                 * Set service and language option //todo ask if viator is gonna add more languages than english in the fueature.If yes the code bellow must be changed
                 */
                boolean languageOptionCodeisSet = false;
                List<ViatorProductTourGradeLanguageServicesBean> tourgradeServices = ViatorProductTourGradeLanguageServicesDAO.getLanguageServicesByProductCodeAndTourGrade(product.getProductCode(), priceplan.getTourGradeCode());
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

                /**
                 * Prepare travellers for calculate price and booking requests and define travellers type
                 */
                List<GPriceMatrixBean> pricematrix = GPriceMatrixDAO.getgPriceMatrixesByProductIdAndPlanId(it.getProductId(), String.valueOf(priceplan.getId()));
                if (pricematrix == null || pricematrix.size() == 0) {
                    bookInfoJSON.setSuccess(false);
                    bookInfoJSON.setErrorReference("No prices for product with id:" + it.getProductId());
                    bookLogBean.setClient("ATB Holidays");
                    bookLogBean.setClientBookingId("not_succeed");
                    try {
                        bookLogBean.setClientRequest(mapper.writeValueAsString(bookPOST).toString());
                        bookLogBean.setProviderRequest("");
                    } catch (JsonProcessingException e) {
                        bookLogBean.setClientRequest("");
                        bookLogBean.setProviderRequest("");
                    }
                    try {
                        bookLogBean.setClientResponse(mapper.writeValueAsString(bookInfoJSON).toString());
                        bookLogBean.setProviderResponse("");
                    } catch (JsonProcessingException e) {
                        bookLogBean.setClientResponse("");
                        bookLogBean.setProviderResponse("");
                    }
                    DateTime dateTime = new DateTime(DateTimeZone.UTC);
                    bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                    bookLogBean.setProvider("Viator");
                    bookLogBean.setProviderBookingId("");
                    BookLogDAO.addBookLogBean(bookLogBean);
                    return bookInfoJSON;
                }
                Beans.ViatorAPIBeans.Bookings.Book.Traveller traveller;
                List<Beans.ViatorAPIBeans.Bookings.Book.Traveller> travellers = new ArrayList<>();
                for (APIJSONs.ATBAPIJSONs.Product.Traveller tr : it.getTravellers()) {
                    traveller = new Beans.ViatorAPIBeans.Bookings.Book.Traveller();
                    traveller.setFirstname(tr.getFirstname());
                    traveller.setLeadTraveller(tr.isLeadTraveller());
                    traveller.setSurname(tr.getSurname());
                    traveller.setTitle(tr.getTitle());
                    if (tr.getAge() == 0) {
                        bookInfoJSON.setSuccess(false);
                        bookInfoJSON.setErrorReference("Age is a required field for all travellers");
                        bookLogBean.setClient("ATB Holidays");
                        bookLogBean.setClientBookingId("not_succeed");
                        try {
                            bookLogBean.setClientRequest(mapper.writeValueAsString(bookPOST).toString());
                            bookLogBean.setProviderRequest("");
                        } catch (JsonProcessingException e) {
                            bookLogBean.setClientRequest("");
                            bookLogBean.setProviderRequest("");
                        }
                        try {
                            bookLogBean.setClientResponse(mapper.writeValueAsString(bookInfoJSON).toString());
                            bookLogBean.setProviderResponse("");
                        } catch (JsonProcessingException e) {
                            bookLogBean.setClientResponse("");
                            bookLogBean.setProviderResponse("");
                        }
                        DateTime dateTime = new DateTime(DateTimeZone.UTC);
                        bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                        bookLogBean.setProvider("Viator");
                        bookLogBean.setProviderBookingId("");
                        BookLogDAO.addBookLogBean(bookLogBean);
                        return bookInfoJSON;
                    }

                    for (GPriceMatrixBean price : pricematrix) {
                        if (!price.getAgeFrom().equals("") && !price.getAgeTo().equals("")) {
                            if (tr.getAge() >= Integer.parseInt(price.getAgeFrom()) && tr.getAge() < Integer.parseInt(price.getAgeTo())) {
                                if (price.getPersonType().equals("adult")) {
                                    traveller.setBandId(1);
                                    break;
                                } else if (price.getPersonType().equals("child")) {
                                    traveller.setBandId(2);
                                    break;
                                } else if (price.getPersonType().equals("infant")) {
                                    traveller.setBandId(3);
                                    break;
                                } else if (price.getPersonType().equals("youth")) {
                                    traveller.setBandId(4);
                                    break;
                                } else if (price.getPersonType().equals("senior")) {
                                    traveller.setBandId(5);
                                    break;
                                } else {
                                    bookInfoJSON.setSuccess(false);
                                    bookInfoJSON.setErrorReference("Couldn't find person type for traveler:" + tr.getFirstname() + "," + tr.getSurname() + " for product with id:" + it.getPlanId());
                                    bookLogBean.setClient("ATB Holidays");
                                    bookLogBean.setClientBookingId("not_succeed");
                                    try {
                                        bookLogBean.setClientRequest(mapper.writeValueAsString(bookPOST).toString());
                                        bookLogBean.setProviderRequest("");
                                    } catch (JsonProcessingException e) {
                                        bookLogBean.setClientRequest("");
                                        bookLogBean.setProviderRequest("");
                                    }
                                    try {
                                        bookLogBean.setClientResponse(mapper.writeValueAsString(bookInfoJSON).toString());
                                        bookLogBean.setProviderResponse("");
                                    } catch (JsonProcessingException e) {
                                        bookLogBean.setClientResponse("");
                                        bookLogBean.setProviderResponse("");
                                    }
                                    DateTime dateTime = new DateTime(DateTimeZone.UTC);
                                    bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                                    bookLogBean.setProvider("Viator");
                                    bookLogBean.setProviderBookingId("");
                                    BookLogDAO.addBookLogBean(bookLogBean);
                                    return bookInfoJSON;
                                }
                            }
                        } else {
                            bookInfoJSON.setSuccess(false);
                            bookInfoJSON.setErrorReference("Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                            bookLogBean.setClient("ATB Holidays");
                            bookLogBean.setClientBookingId("not_succeed");
                            try {
                                bookLogBean.setClientRequest(mapper.writeValueAsString(bookPOST).toString());
                                bookLogBean.setProviderRequest("");
                            } catch (JsonProcessingException e) {
                                bookLogBean.setClientRequest("");
                                bookLogBean.setProviderRequest("");
                            }
                            try {
                                bookLogBean.setClientResponse(mapper.writeValueAsString(bookInfoJSON).toString());
                                bookLogBean.setProviderResponse("");
                            } catch (JsonProcessingException e) {
                                bookLogBean.setClientResponse("");
                                bookLogBean.setProviderResponse("");
                            }
                            DateTime dateTime = new DateTime(DateTimeZone.UTC);
                            bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
                            bookLogBean.setProvider("Viator");
                            bookLogBean.setProviderBookingId("");
                            BookLogDAO.addBookLogBean(bookLogBean);
                            return bookInfoJSON;
                        }
                    }
                    travellers.add(traveller);
                }


                item.setTravellers(travellers);
                if (product.getMainSupplierName().equals("Viator"))
                    viatorItems.add(item);
                else {
                    atbItems.add(item);
                    atbProductPrices.add(atbTotalNetPrice.subtract(previusAtbTotalNetPrice));
                }
                previusAtbTotalNetPrice = atbTotalNetPrice;
            }

            DateTime dateTime = new DateTime(DateTimeZone.UTC);

            /**
             * Make the booking in viator side.
             */
            BookPOST viatorBookPOST = new BookPOST();
            if (viatorItems.size() > 0) {
                viatorBookPOST.setDemo(demo);
                viatorBookPOST.setItems(viatorItems);
                viatorBookPOST.setNewsletterSignUp(false);
                viatorBookPOST.setBooker(bookPOST.getBooker());
                viatorBookPOST.setCurrencyCode("USD");
                PartnerDetail partenerDetail = new PartnerDetail();
                partenerDetail.setDistributorRef(dateTime.toString());
                viatorBookPOST.setPartnerDetail(partenerDetail);
                bookInfoJSON = BookingsAPIDAO.book(viatorBookPOST);
            }
            bookLogBean.setClient("ATB Holidays");
            if (bookInfoJSON.getData() != null)
                bookLogBean.setClientBookingId(String.valueOf(bookInfoJSON.getData().getItineraryId()));
            try {
                bookLogBean.setClientRequest(mapper.writeValueAsString(bookPOST).toString());
                bookLogBean.setProviderRequest(mapper.writeValueAsString(viatorBookPOST).toString());
            } catch (JsonProcessingException e) {
                bookLogBean.setClientRequest("");
                bookLogBean.setProviderRequest("");
            }
            try {
                bookLogBean.setClientResponse(mapper.writeValueAsString(bookInfoJSON).toString());
                bookLogBean.setProviderResponse(mapper.writeValueAsString(bookInfoJSON).toString());
            } catch (JsonProcessingException e) {
                bookLogBean.setClientResponse("");
                bookLogBean.setProviderResponse("");
            }
            bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
            bookLogBean.setProvider("Viator");
            bookLogBean.setProviderBookingId("");
            BookLogDAO.addBookLogBean(bookLogBean);
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            bookInfoJSON.setErrorName(errors.toString());
            bookInfoJSON.setSuccess(false);
            return bookInfoJSON;
        }
        return bookInfoJSON;
    }

    @RequestMapping(value = "/booking/viatorCancel", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public CancelAPIJSON cancelViator(@RequestBody CancelPOST cancelPOST){
        Application.agent.increment("app.web.request.frontend.viatorCancel");
        return BookingsAPIDAO.cancellation(cancelPOST);
    }

    @RequestMapping(value = "/booking/viatorPastBooking", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public PastBookingAPIJSON pastBookingiator(@RequestParam(value = "email", defaultValue = "") String email,
                                               @RequestParam(value = "itineraryId", defaultValue = "") int itineraryId){
        Application.agent.increment("app.web.request.frontend.viatorPastBooking");
        return BookingsAPIDAO.pastbooking(email,itineraryId);
    }


    @RequestMapping(value = "/booking/bookEventsTravel", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public EventsTravelCreateOrderResponse bookEventsTravel(@RequestBody EventsTravelBookPOST bookPOST, @RequestParam(value="demo", defaultValue="true") boolean demo){

        Application.agent.increment("app.web.request.frontend.bookEventsTravel");

        ObjectMapper mapper = new ObjectMapper();
        BookLogBean bookLogBean=new BookLogBean();
        InitialContext initialContext;
        String eventsTravelAPIkey=null;
        String apiKeyJNDI = "java:comp/env/string/EventsTravelAPIkey";
        EventsTravelCreateOrderResponse response=null;
        try {
            EventsTravelCreateOrderRequest eventsTravelCreateOrderRequest = new EventsTravelCreateOrderRequest();
            List<OrderProduct> products = new ArrayList<>();
            OrderProduct product;
            if (bookPOST.getProducts() != null) {
                for (APIJSONs.ATBAPIJSONs.ViatorATBFrontEnd.Book.OrderProduct order : bookPOST.getProducts()) {
                    product = new OrderProduct();
                    AProductTitleBean atbProduct = AProductTitleDAO.getProductById(order.getProductCode());
                    if (atbProduct != null) {
                        product.setSku(atbProduct.getProductCode());
                        product.setAmount(order.getAmount());
                        product.setBooking_reference(order.getBooking_reference());
                        product.setCheckin_date(order.getCheckin_date());
                        product.setCity(order.getCity());
                        product.setCompany(order.getCompany());
                        product.setCountry(order.getCountry());
                        product.setDate_of_birth(order.getDate_of_birth());
                        product.setZipcode(order.getZipcode());
                        product.setStreet(order.getStreet());
                        product.setPhonenumber(order.getPhonenumber());
                        product.setPassport_name(order.getPassport_name());
                        product.setNationality(order.getNationality());
                        product.setLastname(order.getLastname());
                        product.setHousenumber(order.getHousenumber());
                        product.setFirstname(order.getFirstname());
                        product.setEmail(order.getEmail());
                        products.add(product);
                    }

                }
            }
            eventsTravelCreateOrderRequest.setProducts(products);

            StringBuilder request = new StringBuilder("?");
            try {
                initialContext = new InitialContext();
                eventsTravelAPIkey = (String) initialContext.lookup(apiKeyJNDI);
            } catch (NamingException e) {

            }
            //logger.debug("API key " + eventsTravelAPIkey);
        /* Build Request */
            if (eventsTravelAPIkey != null && !"".equals(eventsTravelAPIkey)) {
                if (demo)
                    request.append("token=" + eventsTravelAPIkey + "&test=true");
                else
                    request.append("token=" + eventsTravelAPIkey);
            }

            response = EventsTravelProductsAPIDAO.createOrder(request.toString(), eventsTravelCreateOrderRequest);
            bookLogBean.setClient("ATB Holidays");
            bookLogBean.setClientBookingId("not_provided");
            try {
                bookLogBean.setClientRequest(mapper.writeValueAsString(bookPOST).toString());
                bookLogBean.setProviderRequest(mapper.writeValueAsString(eventsTravelCreateOrderRequest).toString());
            } catch (JsonProcessingException e) {
                bookLogBean.setClientRequest("");
                bookLogBean.setProviderRequest("");
            }
            try {
                bookLogBean.setClientResponse(mapper.writeValueAsString(response).toString());
                if (response != null)
                    bookLogBean.setProviderResponse(mapper.writeValueAsString(response).toString());
            } catch (JsonProcessingException e) {
                bookLogBean.setClientResponse("");
                bookLogBean.setProviderResponse("");
            }
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
            bookLogBean.setProvider("Events Travel");
            bookLogBean.setProviderBookingId("");
            BookLogDAO.addBookLogBean(bookLogBean);
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            response.setMessage(errors.toString());
            return response;
        }
        return  response; //todo test to be removed
    }

}
