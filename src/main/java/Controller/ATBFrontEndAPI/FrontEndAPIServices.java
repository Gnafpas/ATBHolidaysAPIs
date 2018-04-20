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
import Beans.ViatorAPIBeans.Bookings.Book.*;
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
import DAOs.SunHotelsAPIDAOs.*;
import DAOs.ViatorAPIDAOs.BookingsAPIDAO;
import DAOs.ViatorDBDAOs.BookLogDAO;
import DAOs.ViatorDBDAOs.PrebookLogDAO;
import DAOs.ViatorDBDAOs.ViatorProductTourGradeLanguageServicesDAO;
import DBConnection.SunHotelsHibernateUtil;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;

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
                if (params.getHotelId() != null && !params.getHotelId().equals("")) {
                    hotelmappingBean = HotelmappingDAO.getHotelMappingbyATBId(Integer.parseInt(params.getHotelId()));
                    if (hotelmappingBean == null) {
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorType("HotelId missing");
                        bookJSON.setErrorMessageText("HotelId missing");
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
                    bookJSON.setErrorType("HotelId missing");
                    bookJSON.setErrorMessageText("HotelId missing");
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
                 * Get original meal id
                 */
                int originalMealId = 0;
                String id = MealDAO.getOriginalMealId(String.valueOf(params.getMealId()));
                if (id != null)
                    originalMealId = Integer.parseInt(id);
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

                if (hotelmappingBean.getProviderId() == sanHotelsProviderId) {

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
                                children[8].getAge() + "" + 1 + "" + params.getCustomerCountry() + "" + params.getPrebookcode();
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
                } else if (hotelmappingBean.getProviderId() == hotelBedsProviderId) {


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
                bookLogBean.setProvider("SunHotels");
                try {
                    bookLogBean.setProviderRequest(sunHotelsRequest);
                    bookLogBean.setProviderResponse(mapper.writeValueAsString(result).toString());
                } catch (JsonProcessingException e) {
                    bookLogBean.setProviderRequest("");
                    bookLogBean.setProviderResponse("");
                }
            } else if (hotelmappingBean != null && hotelmappingBean.getProviderId() == hotelBedsProviderId) {
                bookLogBean.setProvider("HotelBeds");
                try {
                    bookLogBean.setProviderRequest(mapper.writeValueAsString(result).toString());
                    bookLogBean.setProviderResponse(mapper.writeValueAsString(result).toString());
                } catch (JsonProcessingException e) {
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


            if (roomtypeBean.getProviderId() == sanHotelsProviderId) {

                /**
                 * Get original meal id
                 */
                int originalMealId = 0;
                String id = MealDAO.getOriginalMealId(String.valueOf(params.getMealId()));
                if (id != null)
                    originalMealId = Integer.parseInt(id);

                /**
                 * Get original hotel id
                 */
                String originalHotelId = "";
                if (params.getHotelId() != null && !params.getHotelId().equals("")) {
                    originalHotelId = String.valueOf(HotelmappingDAO.getOriginalHotelId(Integer.parseInt(params.getHotelId()), null));
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
                    sunHotelsRequest = params.getCurrency() + "," + "English" + "," +
                            xmlCheckin + "," + xmlCheckout + "," + params.getRooms() + "," + params.getAdults() + "," + params.getChildren() + "," +
                            childrenAges + "," + params.getInfant() + "," + originalMealId + "," + params.getCustomerCountry() + "," + "" + "," +
                            params.getSearchPrice() + "," + "" + "," + originalHotelId + "," + roomtypeBean.getRoomtypeId() + "," + "false" + "," +
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
                    prebookJSON.setPreBookCode(result.getPreBookCode());
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
                HotelPost hotels = new HotelPost();
                List<Integer> hs = new ArrayList<>();
                if (params.getHotelId() != null && !params.getHotelId().equals("")) {
                    hs.add(HotelmappingDAO.getOriginalHotelId(Integer.parseInt(params.getHotelId()), null));
                    hotels.setHotel(hs);
                    availabilityPOST.setHotels(hotels);
                    availabilityAPIJSON = AvailabilityDAOs.availability(availabilityPOST);
                    if (availabilityAPIJSON != null && availabilityAPIJSON.getError() == null) {

                        if (availabilityAPIJSON.getHotels() != null && availabilityAPIJSON.getHotels().getHotels() != null) {
                            for (Beans.HotelBedsAPIBeans.Availability.Hotel hotel : availabilityAPIJSON.getHotels().getHotels()) {
                                int atbHotelId = HotelmappingDAO.getATBHotelId(hotel.getCode(), hotelBedsProviderId, null);
                                if (atbHotelId != Integer.parseInt(params.getHotelId())) {
                                    for (Beans.HotelBedsAPIBeans.Availability.Room room : hotel.getRooms()) {
                                        if (room.getCode().equals(roomtypeBean.getRoomtypeId())) {
                                            for (Rate rate : room.getRates()) {
                                                MealBean meal = MealDAO.getMealByMealId(rate.getBoardCode(), hotelBedsProviderId, null);
                                                if (meal != null) {//todo correct the meal id (we get atb meal id from params and then we must request with the original)
                                                    if (meal.getId() == params.getMealId()) {
                                                        if (roomtypeBean != null) {

                                                            ArrayOfStaticPercentageCancellationPolicy arrayOfStaticPercentageCancellationPolicy = new ArrayOfStaticPercentageCancellationPolicy();
                                                            List<StaticPercentageCancellationPolicy> cancelationPolicies;
                                                            StaticPercentageCancellationPolicy cancelationPolicy;
                                                            cancelationPolicies = new ArrayList<>();
                                                            if (rate.getCancellationPolicies() != null) {
                                                                for (CancellationPolicy policy : rate.getCancellationPolicies()) {//todo fix cancelation policies,ask about roomtypes codes whichare not comming all,ask about currency
                                                                    cancelationPolicy = new StaticPercentageCancellationPolicy();
                                                                    cancelationPolicy.setPercentage(new BigDecimal(100));
                                                                    cancelationPolicy.setDeadline(50);
                                                                    cancelationPolicies.add(cancelationPolicy);
                                                                }
                                                                arrayOfStaticPercentageCancellationPolicy.setCancellationPolicy(cancelationPolicies);
                                                            }
                                                            prebookJSON.setCancelationPolicies(arrayOfStaticPercentageCancellationPolicy);
                                                            ArrayOfCalendarNote5 arrayOfCalendarNote5 = new ArrayOfCalendarNote5();
                                                            prebookJSON.setNotes(arrayOfCalendarNote5);
                                                            MonetaryValue monetaryValue = new MonetaryValue();
                                                            if (rate.getNet() != null && !rate.getNet().equals("")) {

                                                                if (rate.getRateType().equals("BOOKABLE")) {

                                                                    monetaryValue.setValue(new BigDecimal(Double.parseDouble(rate.getNet())).setScale(2, BigDecimal.ROUND_HALF_UP));
                                                                    monetaryValue.setCurrency(hotel.getCurrency());
                                                                    prebookJSON.setPrice(monetaryValue);
                                                                    prebookJSON.setPreBookCode(rate.getRateKey());
                                                                    prebookJSON.setPriceBreakDown(null);
                                                                    prebookJSON.setRoomId(String.valueOf(roomtypeBean.getId()));
                                                                    prebookJSON.setSuccess(true);
                                                                } else if (rate.getRateType().equals("RECHECK")) {

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
            prebookLogBean.setPrebookRef(prebookJSON.getPreBookCode());
            if (roomtypeBean.getProviderId() == sanHotelsProviderId) {
                prebookLogBean.setProvider("SunHotels");
                try {
                    prebookLogBean.setProviderResponse(mapper.writeValueAsString(result).toString());
                    prebookLogBean.setProviderRequest(sunHotelsRequest);
                } catch (JsonProcessingException e1) {
                    prebookLogBean.setProviderResponse("");
                    prebookLogBean.setProviderRequest("");
                }
            } else if (roomtypeBean.getProviderId() == hotelBedsProviderId) {
                prebookLogBean.setProvider("HotelBeds");
                prebookLogBean.setProviderRequest("");
                try {
                    prebookLogBean.setProviderResponse(mapper.writeValueAsString(availabilityAPIJSON).toString());
                    prebookLogBean.setProviderRequest(mapper.writeValueAsString(availabilityPOST).toString());
                } catch (JsonProcessingException e1) {
                    prebookLogBean.setProviderResponse("");
                    prebookLogBean.setProviderRequest("");
                }
            }
            PrebookLogDAO.addPrebookLogBean(prebookLogBean);
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


        Application.agent.increment("app.web.request.frontend.noPircturesSearch");

        StatelessSession session = SunHotelsHibernateUtil.getSession();
        session.beginTransaction();
        SunHotelsSearchJSON hotelSearchJSON=new SunHotelsSearchJSON();

        /**
         * If the search is for first time continue to the code bellow.
         */

        DestinationBean destinationBean=null;
        String[] childrenAgesSplit=null;
        String strOriginalHotelId="";
        String childrenAges="";
        String originalDestinationIdStrFormat="";
        String currencies="";
        ZonedDateTime checkin=null;
        ZonedDateTime checkout=null;
        int originalDestinationId=0;
        long prepareResponseTimeElapsed = 0;
        long dbTransactionTimeElapsed = 0;
        long requestTimeElapsed=0;


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
             * Get original id from Destination table.
             */
            if (params.getDestinationId() != null && !params.getDestinationId().equals("")) {
                DestinationDAO.increaseSortOrderOfDestination(params.getDestinationId());
                destinationBean = DestinationDAO.getDestinationBeanByATBId(params.getDestinationId());
                if (destinationBean != null) {
                    if (destinationBean.getDestinationId() != 0)
                        originalDestinationId = destinationBean.getDestinationId();
                    if (originalDestinationId == 0 && (destinationBean.getHotelBedsCode() == null || destinationBean.getHotelBedsCode().equals(""))) {
                        return hotelSearchJSON;
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


            /**
             * Prepare and run threads for different Providers
             */
            List<SunHotelsResponse> hotelsResponse = new ArrayList<>();
            CountDownLatch latch = new CountDownLatch(1);
            //HotelBedsSearchThread hotelBedsSearchThread =new HotelBedsSearchThread(destinationBean,childrenAgesSplit,checkout,checkin,session,params,latch);
            //new Thread(hotelBedsSearchThread).start();
            SunHotelsSearchThread sunHotelsSearchThread = new SunHotelsSearchThread(originalDestinationId, checkout, checkin, currencies, originalDestinationIdStrFormat, childrenAges, session, params, latch);
            new Thread(sunHotelsSearchThread).start();
            try {
                latch.await();//todo check what i can do when an exception is at one of the threads
            } catch (InterruptedException e) {
            }
//        if(hotelBedsSearchThread.getHotelBedsSearchRequestResponse()!=null) {
//            if(hotelBedsSearchThread.getHotelBedsSearchRequestResponse()!=null && hotelBedsSearchThread.getHotelBedsSearchRequestResponse().getHotelsResponse()!=null)
//                 hotelsResponse.addAll(hotelBedsSearchThread.getHotelBedsSearchRequestResponse().getHotelsResponse());
//            dbTransactionTimeElapsed = dbTransactionTimeElapsed + hotelBedsSearchThread.getHotelBedsSearchRequestResponse().getDbTransactionTimeElapsed();
//            prepareResponseTimeElapsed = prepareResponseTimeElapsed + hotelBedsSearchThread.getHotelBedsSearchRequestResponse().getPrepareResponseTimeElapsed();
//            requestTimeElapsed = requestTimeElapsed + hotelBedsSearchThread.getHotelBedsSearchRequestResponse().getRequestTimeElapsed();
//        }
            if (sunHotelsSearchThread.getSunHotelsSearchRequestResponse() != null) {
                if (sunHotelsSearchThread.getSunHotelsSearchRequestResponse() != null && sunHotelsSearchThread.getSunHotelsSearchRequestResponse().getHotelsResponse() != null)
                    hotelsResponse.addAll(sunHotelsSearchThread.getSunHotelsSearchRequestResponse().getHotelsResponse());
                dbTransactionTimeElapsed = dbTransactionTimeElapsed + sunHotelsSearchThread.getSunHotelsSearchRequestResponse().getDbTransactionTimeElapsed();
                prepareResponseTimeElapsed = prepareResponseTimeElapsed + sunHotelsSearchThread.getSunHotelsSearchRequestResponse().getPrepareResponseTimeElapsed();
                requestTimeElapsed = requestTimeElapsed + sunHotelsSearchThread.getSunHotelsSearchRequestResponse().getRequestTimeElapsed();
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


//        for(int i=0;i<hotelsResponse.size();i++) {
//            String[] hotelName1=null;
//            hotelName1 = hotelsResponse.get(i).getName().split("( )|(\\()|(\\))|(-)");
//            String h1longt =  hotelsResponse.get(i).getLongitude();
//            String h1lat = hotelsResponse.get(i).getLatitude();
//            String[] splitH1lat=h1lat.split(".");
//            String[] splitH1longt=h1longt.split(".");
//            for (int z = 0; z < hotelsResponse.size(); z++) {
//
//                String[] hotelName2=null;
//                hotelName2 = hotelsResponse.get(z).getName().split("( )|(\\()|(\\))|(-)");
//
//                boolean wordExists = false;
//                if (hotelName1 != null && hotelName2 != null) {
//                    for (int k = 0; k < hotelName1.length; k++) {
//                        if (hotelName1.equals(""))
//                            continue;
//                        wordExists = false;
//                        for (int j = 0; j < hotelName2.length; j++) {
//                            if (hotelName1[k].equals(hotelName2[j]))
//                                wordExists = true;
//                        }
//                        if (!wordExists)
//                            break;
//                    }
//                    if (wordExists) {
//
//
//                        if(hotelsResponse.get(i).getLatitude()!=null &&  hotelsResponse.get(i).getLongitude()!=null &&  hotelsResponse.get(z).getLatitude()!=null && hotelsResponse.get(z).getLongitude()!=null) {
//
//                            String h2lat =hotelsResponse.get(z).getLatitude();
//                            String h2longt=hotelsResponse.get(z).getLongitude();
//
//                            if(h1lat.length()>1 && h1longt.length()>1 && h2lat.length()>1 && h2longt.length()>1 ) {
//
//                                String[] splitH2lat=h2lat.split(".");
//                                String[] splitH2longt=h2longt.split(".");
//
//                                if(splitH1lat!=null && splitH1longt!=null && splitH2lat!=null && splitH2longt!=null
//                                   && splitH1lat.length>1 && splitH1longt.length>1 && splitH2lat.length>1 && splitH2longt.length>1 ) {
//                                    splitH1lat[1] = splitH1lat[1].substring(0, 1);
//                                    splitH1longt[1] = splitH1longt[1].substring(0, 1);
//                                    splitH2lat[1] = splitH2lat[1].substring(0, 1);
//                                    splitH2longt[1] = splitH2longt[1].substring(0, 1);
//                                    if (splitH1lat[0].equals(splitH2lat[0]) && splitH1longt[0].equals(splitH2longt[0]) && splitH1lat[1].equals(splitH2lat[1]) && splitH1longt[1].equals(splitH2longt[1])) {
//                                        if(hotelsResponse.get(i).getProviderId()==hotelBedsProviderId){
//                                            hotelsResponse.get(i).getRoom_types().addAll(new ArrayList<>(hotelsResponse.get(z).getRoom_types()));
//                                            hotelsResponse.remove(z);
//                                        }else if(hotelsResponse.get(z).getProviderId()==hotelBedsProviderId){
//                                            hotelsResponse.get(z).getRoom_types().addAll(new ArrayList<>(hotelsResponse.get(i).getRoom_types()));
//                                            hotelsResponse.remove(i);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                        break;
//                    }
//                } else {
//                    break;
//                }
//            }
//
//        }

//        for(int i=0;i<hotelsResponse.size();i++) {
//            if(hotelsResponse.get(i).getRoom_types()!=null
//                    && hotelsResponse.get(i).getRoom_types().size()>0
//                    && hotelsResponse.get(i).getRoom_types().get(0).getRooms()!=null
//                    && hotelsResponse.get(i).getRoom_types().get(0).getRooms().size()>0
//                    && hotelsResponse.get(i).getRoom_types().get(0).getRooms().get(0).getMeals()!=null
//                    && hotelsResponse.get(i).getRoom_types().get(0).getRooms().get(0).getMeals().size()>0) {
//                hotelMinprice = hotelsResponse.get(i).getRoom_types().get(0).getRooms().get(0).getMeals().get(0).getPrice();
//                for (SunHotelsRoomTypeWithRoomsResponse roomtype : hotelsResponse.get(i).getRoom_types()) {
//                    for (SunHotelsRoomResponse room : roomtype.getRooms()) {
//                        if (room.getMeals() != null && room.getMeals().size() > 0) {
//                            for (SunHotelsRoomMealResponse meal : room.getMeals()) {
//                                if (hotelMinprice.compareTo(meal.getPrice()) == 1) {
//                                    hotelMinprice = meal.getPrice();
//                                }
//                            }
//                        }
//                    }
//                }
//                System.out.println("hotel id :" + hotelsResponse.get(i).getId()+" price: "+hotelMinprice +" and providerId:"+hotelsResponse.get(i).getProviderId()+"  and i=   "+i);
//            }
//
//        }


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
                        ". Processing time:" + prepareResponseTimeElapsed / 2 + " Response Hotels count:" + hotelSearchJSON.getResults().size() + ". Destination:" + originalDestinationId);
            } else
                userlogs.info(" Db transactions time:" + dbTransactionTimeElapsed / 2 + ". Sunhotel communication and transactions time:" + requestTimeElapsed / 2 +
                        ". Processing time:" + prepareResponseTimeElapsed / 2 + " Response Hotels count:" + 0 + ". Destination:" + originalDestinationId);
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }
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
