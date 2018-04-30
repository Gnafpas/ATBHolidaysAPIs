package Controller.ATBAPIController.HotelBookingsController;

import APIJSONs.ATBAPIJSONs.Hotel.*;
import APIJSONs.ATBAPIJSONs.Hotel.BookResult;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.CancelationPolicyResponse;
import Beans.ATBDBBeans.KalitaonHotel.HotelBean;
import Beans.ATBDBBeans.KalitaonHotel.HotelmappingBean;
import Beans.ATBDBBeans.KalitaonHotel.RoomtypeBean;
import Beans.ATBDBBeans.KalitaonLog.PrebookLogBean;
import Beans.ATBDBBeans.KalitaonSystem.*;
import Beans.ViatorDBBeans.BookLogBean;
import Controller.Application;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.HotelDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.HotelmappingDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.MealDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.RoomtypeDAO;
import DAOs.ATBDBDAOs.KalitaonLogDAOs.PrebookLogDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.*;
import DAOs.SunHotelsAPIDAOs.*;
import DAOs.ViatorDBDAOs.BookLogDAO;
import Helper.CurrencyConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.*;
import java.util.*;
import java.sql.Timestamp;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.*;

/**
 * Created by George on 03/12/2017.
 */
@RestController
public class BookPrebookController {


    private  void storePrebookLog(PrebookPOST params, String sunHotelsRequest, PrebookJSON prebookJSON, PreBookResult result, SubAgencyBean subAgencyBean, String prebookRef, String providerName){
        ObjectMapper mapper = new ObjectMapper();
        Beans.ViatorDBBeans.PrebookLogBean prebookLogBean=new Beans.ViatorDBBeans.PrebookLogBean();
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        if(subAgencyBean!=null)
            prebookLogBean.setClient(subAgencyBean.getAgentName());
        else
            prebookLogBean.setClient("");
        try {
            prebookLogBean.setClientRequest(mapper.writeValueAsString(params).toString());
        }catch(JsonProcessingException e1){
            prebookLogBean.setClientRequest("");
        }
        try {
            prebookLogBean.setClientResponse(mapper.writeValueAsString(prebookJSON).toString());
        }catch(JsonProcessingException e1){
            prebookLogBean.setClientResponse("");
        }
        if(result!=null) {
            try {
                prebookLogBean.setProviderResponse(mapper.writeValueAsString(result).toString());
            } catch (JsonProcessingException e1) {
                prebookLogBean.setClientResponse("");
            }
        }else
            prebookLogBean.setClientResponse("");
        prebookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())));
        prebookLogBean.setPrebookRef(prebookRef);
        prebookLogBean.setProvider(providerName);
        prebookLogBean.setProviderRequest(sunHotelsRequest);
        DAOs.ViatorDBDAOs.PrebookLogDAO.addPrebookLogBean(prebookLogBean);
    }

    private  void storeBookLog(BookPOST params, String sunHotelsRequest, BookJSON bookJSON, DAOs.SunHotelsAPIDAOs.BookResult result, SubAgencyBean subAgencyBean, String providerBookingId, String providerName) {
        ObjectMapper mapper = new ObjectMapper();
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        BookLogBean bookLogBean=new BookLogBean();
        if(subAgencyBean!=null)
            bookLogBean.setClient(subAgencyBean.getAgentName());
        else
            bookLogBean.setClient("");
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
        if(result!=null) {
            try {
                bookLogBean.setProviderResponse(mapper.writeValueAsString(result).toString());
            } catch (JsonProcessingException e1) {
                bookLogBean.setProviderResponse("");
            }
        }else
            bookLogBean.setProviderResponse("");
        if(bookJSON.getBookResult()!=null)
            bookLogBean.setClientBookingId(bookJSON.getBookResult().getBookingnumber());
        else
            bookLogBean.setClientBookingId("");
        bookLogBean.setPrebookRef(params.getPrebookcode());
        bookLogBean.setProvider(providerName);
        bookLogBean.setProviderBookingId(providerBookingId);
        bookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())));
        bookLogBean.setProviderRequest(sunHotelsRequest);
        BookLogDAO.addBookLogBean(bookLogBean);
    }

    @RequestMapping(value = "/hotel/booking/prebook", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public PrebookJSON hotelPrebook(@RequestBody PrebookPOST params,@RequestParam("apiKey") String apiKey) {

        Application.agent.increment("app.web.request.api.hotel.prebook");
        SubAgencyBean subAgencyBean = null;
        GsaBean gsaBean;
        String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + apiKey;
        String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
        subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);
        PrebookJSON prebookJSON = new PrebookJSON();
        try {
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            prebookJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
            if (subAgencyBean != null) {

                ZonedDateTime checkin = null;
                ZonedDateTime checkout = null;
                PreBookResult result = null;

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
                            storePrebookLog(params, "", prebookJSON, null, subAgencyBean, "", "");
                            return prebookJSON;
                        }
                    }

                }

                if (!params.getCurrencyCode().equals("")) {
                    if (CurrencyConverter.findExchangeRateAndConvert(subAgencyBean.getCurrency(), params.getCurrencyCode(), new Double(1)) == null) {
                        prebookJSON.setSuccess(false);
                        prebookJSON.setErrorMessageText("Wrong currrency code");
                        storePrebookLog(params, "", prebookJSON, null, subAgencyBean, "", "");
                        return prebookJSON;
                    }
                }

                String childrenAges = "";
                if (params.getChildrenAges() != null && params.getChildrenAges().size() > 0) {
                    childrenAges = "" + params.getChildrenAges().get(0);
                    for (int i = 1; i < params.getChildrenAges().size(); i++)
                        childrenAges = childrenAges + "," + params.getChildrenAges().get(i);
                }

                int originalHotelId;
                String originalHotelIdStringFormat = "";
                if (params.getHotelId() == null || params.getHotelId().equals("")) {
                    prebookJSON.setSuccess(false);
                    prebookJSON.setErrorMessageText("Wrong hotelId");
                    storePrebookLog(params, "", prebookJSON, result, subAgencyBean, "", "");
                    return prebookJSON;
                } else {
                    originalHotelId = HotelmappingDAO.getOriginalHotelId(Integer.parseInt(params.getHotelId()), null);
                    if (originalHotelId == 0) {
                        prebookJSON.setSuccess(false);
                        prebookJSON.setErrorMessageText("Wrong hotelId");
                        storePrebookLog(params, "", prebookJSON, result, subAgencyBean, "", "");
                        return prebookJSON;
                    } else if (!params.getRoomTypeId().equals("")) {
                        originalHotelIdStringFormat = String.valueOf(originalHotelId);
                    }
                }

                String blockSuperDeal = "";
                String originalRoomTypeIdStrFrm = "";
                String sunHotelsRequest = "";
                if (params.getRoomTypeId() != null && !params.getRoomTypeId().equals("")) {
                    blockSuperDeal = "true";//todo add superdeal in the future
                    String originalRoomTypeId = RoomtypeDAO.getOriginalRoomtypeId(params.getRoomTypeId());
                    if (originalRoomTypeId != null)
                        originalRoomTypeIdStrFrm = originalRoomTypeId;
                }

                /**
                 * Get original meal id
                 */
                int originalMealId = 0;
                String id = MealDAO.getOriginalMealId(String.valueOf(params.getMealId()));
                if (id != null)
                    originalMealId = Integer.parseInt(id);

                try {
                    GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
                    GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);

                    XMLGregorianCalendar xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
                    XMLGregorianCalendar xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
                    NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
                    NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();
                    sunHotelsRequest = subAgencyBean.getCurrency() + "," + "English" + "," +
                            xmlCheckin + "," + xmlCheckout + "," + params.getRooms() + "," + params.getAdults() + "," + params.getChildren() + "," +
                            childrenAges + "," + params.getInfant() + "," + originalMealId + "," + params.getCustomerCountry() + "," + "" + "," +
                            "," + params.getRoomId() + "," + originalHotelIdStringFormat + "," + originalRoomTypeIdStrFrm + "," + blockSuperDeal;
                    result = nonStaticXMLAPISoap.preBookV2(sunhotelsUsername, sunhotelspass, subAgencyBean.getCurrency(), "English",
                            xmlCheckin, xmlCheckout, params.getRooms(), params.getAdults(), params.getChildren(),
                            childrenAges, params.getInfant(), originalMealId, params.getCustomerCountry(), "",
                            "", params.getRoomId(), originalHotelIdStringFormat, originalRoomTypeIdStrFrm, blockSuperDeal,
                            "");
                } catch (DatatypeConfigurationException e) {
                    prebookJSON.setSuccess(false);
                    prebookJSON.setErrorMessageText("Wrong date type.The correct format is yyyy-mm-dd");
                    storePrebookLog(params, sunHotelsRequest, prebookJSON, result, subAgencyBean, "", "SunHotels");
                    return prebookJSON;
                } catch (NullPointerException e) {
                    prebookJSON.setSuccess(false);
                    prebookJSON.setErrorMessageText("Wrong date type.The correct format is yyyy-mm-dd");
                    storePrebookLog(params, sunHotelsRequest, prebookJSON, result, subAgencyBean, "", "SunHotels");
                    return prebookJSON;
                }

                if (result.getError() != null) {
                    prebookJSON.setErrorMessageText(result.getError().getMessage());
                    prebookJSON.setSuccess(false);
                } else {
                    if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                        gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()), null);
                        if (gsaBean != null) {
                            if (result.getPrice() != null && result.getPrice().getValue() != null) {
                                if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                    BigDecimal gsaSale = result.getPrice().getValue().add(result.getPrice().getValue().multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP));
                                    if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                        BigDecimal agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP));
                                        result.getPrice().setValue(agentSale);
                                        prebookJSON.setPrice(result.getPrice());
                                    } else {
                                        prebookJSON.setSuccess(false);
                                        prebookJSON.setErrorMessageText("Code:1.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                                        storePrebookLog(params, sunHotelsRequest, prebookJSON, result, subAgencyBean, result.getPreBookCode(), "SunHotels");
                                        errLogger.info(prebookJSON.getErrorMessageText());
                                        return prebookJSON;
                                    }
                                } else {
                                    prebookJSON.setSuccess(false);
                                    prebookJSON.setErrorMessageText("Code:2.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                                    storePrebookLog(params, sunHotelsRequest, prebookJSON, result, subAgencyBean, result.getPreBookCode(), "SunHotels");
                                    errLogger.info(prebookJSON.getErrorMessageText());
                                    return prebookJSON;
                                }
                            } else {
                                prebookJSON.setSuccess(false);
                                prebookJSON.setErrorMessageText("");
                                storePrebookLog(params, sunHotelsRequest, prebookJSON, result, subAgencyBean, result.getPreBookCode(), "SunHotels");
                                return prebookJSON;
                            }
                        } else {
                            prebookJSON.setSuccess(false);
                            prebookJSON.setErrorMessageText("Code:3.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                            errLogger.info(prebookJSON.getErrorMessageText());
                            storePrebookLog(params, sunHotelsRequest, prebookJSON, result, subAgencyBean, result.getPreBookCode(), "SunHotels");
                            return prebookJSON;
                        }
                    } else {
                        prebookJSON.setSuccess(false);
                        prebookJSON.setErrorMessageText("Code:4.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                        errLogger.info(prebookJSON.getErrorMessageText());
                        storePrebookLog(params, sunHotelsRequest, prebookJSON, result, subAgencyBean, result.getPreBookCode(), "SunHotels");
                        return prebookJSON;
                    }

                    List<CancelationPolicyResponse> cancelationPolicies = new ArrayList<>();
                    CancelationPolicyResponse cancelationPolicy = new CancelationPolicyResponse();
                    if (result.getCancellationPolicies() != null && result.getCancellationPolicies().getCancellationPolicy().size() > 0) {
                        StaticPercentageCancellationPolicy atbPolicy = new StaticPercentageCancellationPolicy();
                        atbPolicy.setDeadline(0);
                        for (StaticPercentageCancellationPolicy policy : result.getCancellationPolicies().getCancellationPolicy()) {
                            if (policy.getDeadline() == null) {
                                atbPolicy = policy;
                                break;
                            }
                            if (policy.getDeadline() > atbPolicy.getDeadline())
                                atbPolicy = policy;
                        }
                        cancelationPolicy.setPercentage(new BigDecimal(100));//todo fix cancelation policies(search in the whole class to fix all the references)
                        if (atbPolicy.getDeadline() != null) {
                            cancelationPolicy.setDeadline(atbPolicy.getDeadline() + plusCancelationPolicyHours);
                            cancelationPolicy.setText("Cancellation made less than " + (atbPolicy.getDeadline() + plusCancelationPolicyHours) + " hours (12:00) prior to the arrival will be charged with 100% of the total booking value.");
                        } else {
                            cancelationPolicy.setText("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                            cancelationPolicy.setDeadline(null);
                        }
                    } else {
                        cancelationPolicy.setText("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                        cancelationPolicy.setDeadline(null);
                        cancelationPolicy.setPercentage(new BigDecimal(100));
                    }
                    cancelationPolicies.add(cancelationPolicy);
                    prebookJSON.setCancelationPolicies(cancelationPolicies);


                    prebookJSON.setNotes(result.getNotes());
                    prebookJSON.setRoomId(result.getRoomId());
                    prebookJSON.setPreBookCode(result.getPreBookCode()+"ID:"+sanHotelsProviderId);
                    prebookJSON.setSuccess(true);
                }
                storePrebookLog(params, sunHotelsRequest, prebookJSON, result, subAgencyBean, result.getPreBookCode()+"ID:"+sanHotelsProviderId, "SunHotels");
            } else {
                prebookJSON.setSuccess(false);
                prebookJSON.setErrorMessageText("Code:5.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                storePrebookLog(params, "", prebookJSON, null, subAgencyBean, "", "SunHotels");
                errLogger.info(prebookJSON.getErrorMessageText());
                return prebookJSON;
            }

            /**
             * Currency conversion
             */
            if (!params.getCurrencyCode().equals("") && prebookJSON.getPrice() != null && prebookJSON.getPrice().getValue() != null && prebookJSON.getPrice().getCurrency() != null) {
                BigDecimal convertedPrice = CurrencyConverter.findExchangeRateAndConvert(prebookJSON.getPrice().getCurrency(), params.getCurrencyCode(), Double.parseDouble(prebookJSON.getPrice().getValue().toString()));
                if (convertedPrice != null) {
                    convertedPrice = convertedPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
                    prebookJSON.getPrice().setValue(convertedPrice);
                    prebookJSON.getPrice().setCurrency(params.getCurrencyCode());
                }
            }
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            prebookJSON.setSuccess(false);
            prebookJSON.setErrorMessageText(errors.toString());
        }
        return prebookJSON;
    }


    @RequestMapping(value = "/hotel/booking/book", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public BookJSON hotelBook(@RequestBody BookPOST params,@RequestParam("apiKey") String apiKey) {

        Application.agent.increment("app.web.request.api.hotel.book");
        SubAgencyBean subAgencyBean=null;
        BookJSON bookJSON = new BookJSON();
        BookResult bookResult = new BookResult();
        try {
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            bookJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");

            GsaBean gsaBean;
            String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + apiKey;
            String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
            subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);
            String sunHotelsRequest = "";
            DAOs.SunHotelsAPIDAOs.BookResult result = null;
            if (subAgencyBean != null) {
                /**
                 * Parametrs Check
                 */

                if (params.getPrebookcode() == null) {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorMessageText("Prebook code not defined");
                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "");
                    return bookJSON;
                } else if (params.getPrebookcode().equals("")) {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorMessageText("Prebook code not defined");
                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "");
                    return bookJSON;
                }

                if (!params.getCurrencyCode().equals("")) {
                    if (CurrencyConverter.findExchangeRateAndConvert(subAgencyBean.getCurrency(), params.getCurrencyCode(), new Double(1)) == null) {
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorMessageText("Wrong currrency code");
                        bookJSON.setErrorType("Missing Parameters");
                        storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "");
                        return bookJSON;
                    }
                }
                if (params.getHotelId() == null || params.getHotelId().equals("")) {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorMessageText("Please Specify hotelId");
                    bookJSON.setErrorType("Missing Parameters");
                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "");
                    return bookJSON;
                }
                if (params.getAdults() == null) {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorMessageText("Please Specify Adults");
                    bookJSON.setErrorType("Missing Parameters");
                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "");
                    return bookJSON;
                }
                if (params.getCheckInDate() == null || params.getCheckInDate().equals("")) {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorMessageText("Please Specify Checkin Date");
                    bookJSON.setErrorType("Missing Parameters");
                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "");
                    return bookJSON;
                }
                if (params.getCheckOutDate() == null || params.getCheckOutDate().equals("")) {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorMessageText("Please Specify Checkout Date");
                    bookJSON.setErrorType("Missing Parameters");
                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "");
                    return bookJSON;
                }
                if (params.getMealId() == 0) {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorMessageText("Please Specify MealId");
                    bookJSON.setErrorType("Missing Parameters");
                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "");
                    return bookJSON;
                }
                if (params.getRoomId() == 0) {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorMessageText("Please Specify RoomId");
                    bookJSON.setErrorType("Missing Parameters");
                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "");
                    return bookJSON;
                }
                if (params.getRooms() == 0) {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorMessageText("Please Specify Rooms number");
                    bookJSON.setErrorType("Missing Parameters");
                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "");
                    return bookJSON;
                }


                /**
                 * Retrieving Prebook response from prebook log.Used for checking if booking price exceeds sub_agency's deposit amount.
                 */
                PrebookJSON prebookJSON = null;
                Beans.ViatorDBBeans.PrebookLogBean prebook=DAOs.ViatorDBDAOs.PrebookLogDAO.getPrebookLogByRefAndProvider(params.getPrebookcode(),null);
                if(prebook==null){
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorMessageText("");
                    bookJSON.setErrorType("Code 52:Couldn't extract essential data.");
                    errLogger.info(bookJSON.getErrorMessageText());
                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                    return bookJSON;
                }
                ObjectMapper mapper = new ObjectMapper();
                prebookJSON = mapper.readValue(prebook.getClientResponse(), PrebookJSON.class);

                if (prebookJSON != null) {
                    if (prebookJSON.isSuccess()) {
                        if ((subAgencyBean.getDeposit() == null || BigDecimal.valueOf(Double.parseDouble(subAgencyBean.getDeposit())).compareTo(prebookJSON.getPrice().getValue()) == -1) && subAgencyBean.getXmlStatus().equals("1")) {
                            bookJSON.setSuccess(false);
                            bookJSON.setErrorMessageText("The price of the booking exceeds the amount on your Deposit");
                            bookJSON.setErrorType("Booking Price");
                            storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                            return bookJSON;
                        }
                    } else {
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorMessageText(prebookJSON.getErrorMessageText());
                        bookJSON.setErrorType("Comunication Error");
                        errLogger.info(bookJSON.getErrorMessageText());
                        storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                        return bookJSON;
                    }
                } else {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorMessageText("");
                    bookJSON.setErrorType("Code 51:Couldn't extract essential data.");
                    errLogger.info(bookJSON.getErrorMessageText());
                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
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
                            bookJSON.setErrorType("Incomplete Request");
                            bookJSON.setErrorMessageText("Wrong date type.The correct format is yyyy-mm-dd");
                            storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                            return bookJSON;
                        }
                    }

                } else {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorType("Incomplete Request");
                    bookJSON.setErrorMessageText("Empty dates parameters");
                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                    return bookJSON;
                }

                /**
                 * HotelId check.Used for recognize provider
                 */
                int originalHotelId;
                if (params.getHotelId() == null) {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorMessageText("Wrong hotelId");
                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                    return bookJSON;
                } else {
                    originalHotelId = HotelmappingDAO.getOriginalHotelId(Integer.parseInt(params.getHotelId()), null);
                    if (originalHotelId == 0) {
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorMessageText("Wrong hotelId");
                        storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
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
                 * Get original meal id
                 */
                int originalMealId = 0;
                String id = MealDAO.getOriginalMealId(String.valueOf(params.getMealId()));
                if (id != null)
                    originalMealId = Integer.parseInt(id);

                if (subAgencyBean.getXmlStatus().equals("0") || params.isDemo()) {

                    /**
                     * Case that  Subagency is in test mode currently.
                     */

                    bookJSON.setTestBooking(true);
                    BigDecimal agentSale;

                    /**
                     * Store Booking Results(Cancelation policies and prebookcode) prebookLog table.
                     */
                    PrebookLogBean prebookLogBean = new PrebookLogBean();
                    prebookLogBean.setHotelId(String.valueOf(HotelmappingDAO.getOriginalHotelId(Integer.parseInt(params.getHotelId()), null)));
                    prebookLogBean.setPrebookDate(prebookJSON.getDateStamp());
                    prebookLogBean.setPrebookRef(params.getPrebookcode());
                    prebookLogBean.setPrice(String.valueOf(prebookJSON.getPrice().getValue()));
                    prebookLogBean.setRoomId(String.valueOf(params.getRoomId()));
                    prebookLogBean.setRoomTypeName("");
                    prebookLogBean.setMealName("");


                    mapper = new ObjectMapper();
                    try {
                        prebookLogBean.setNotes(mapper.writeValueAsString(prebookJSON.getNotes()));
                    } catch (JsonProcessingException e) {
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorMessageText("Code:5.Couldn't store essential data to database.Please contact at:george.nafpaktitis@atbholidays.com");
                        bookJSON.setErrorType("Internal Error");
                        errLogger.info(bookJSON.getErrorMessageText());
                        storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels/AtbHolidays");
                        return bookJSON;
                    }


                    if (prebookJSON.getCancelationPolicies() != null && prebookJSON.getCancelationPolicies() != null && prebookJSON.getCancelationPolicies().size() > 0) {
                        prebookLogBean.setCancelPolicy("");
                        prebookLogBean.setAtbCancelPolicy(prebookJSON.getCancelationPolicies().get(0).getText());
                        prebookLogBean.setDeadline(String.valueOf(prebookJSON.getCancelationPolicies().get(0).getDeadline()));
                        prebookLogBean.setPercentage(String.valueOf(prebookJSON.getCancelationPolicies().get(0).getPercentage()));
                    }
                    int prebooklogId=PrebookLogDAO.storePrebookLog(prebookLogBean);
                    if(prebooklogId==0){
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorMessageText("Code:20.Couldn't store essential data to database.Please contact at:george.nafpaktitis@atbholidays.com");
                        bookJSON.setErrorType("Internal Error");
                        errLogger.info(bookJSON.getErrorMessageText());
                        storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels/AtbHolidays");
                        return bookJSON;
                    }


                    /**
                     * Store Booking Results to Hotel_Bookings_All table
                     */
                    String bookingCode = "HTL-API-TEST-SN-" + params.getPrebookcode();
                    BookingsAllBean bookingsAllBean = new BookingsAllBean();
                    bookingsAllBean.setAdittionalRequest("");
                    bookingsAllBean.setAgentCommission("");
                    bookingsAllBean.setAgentEndSaleCur(subAgencyBean.getCurrency());
                    bookingsAllBean.setAgentId(String.valueOf(subAgencyBean.getId()));
                    bookingsAllBean.setAudioGuide("");
                    bookingsAllBean.setBasketId("");
                    bookingsAllBean.setBookletGuide("");
                    bookingsAllBean.setConfirmationNo("");
                    bookingsAllBean.setPlanId(String.valueOf(params.getRoomId()));
                    bookingsAllBean.setPriceId(String.valueOf(params.getRooms()));
                    bookingsAllBean.setContactTel("");
                    bookingsAllBean.setDiscountAmount("");
                    bookingsAllBean.setDiscountMarkup("");
                    bookingsAllBean.setLiveGuide("");
                    bookingsAllBean.setPayType("Deposit");
                    bookingsAllBean.setPosId("");
                    bookingsAllBean.setProductType("HTL");
                    bookingsAllBean.setSaleCurrency(subAgencyBean.getCurrency());
                    bookingsAllBean.setStatus("7");
                    bookingsAllBean.setSupplierCurrency(subAgencyBean.getCurrency());
                    bookingsAllBean.setStatusReason("XML-Test");
                    bookingsAllBean.setTotalPax(String.valueOf(numOfAdults + numOfChildren));
                    bookingsAllBean.setTourLeader(adults[0].getFirst_name() + " " + adults[0].getLast_name());
                    bookingsAllBean.setXmlAgent(subAgencyBean.getAgentName());
                    bookingsAllBean.setXmlBookRef("");
                    bookingsAllBean.setCommon1("");
                    bookingsAllBean.setCommon2("");
                    bookingsAllBean.setCommon3("");
                    bookingsAllBean.setCommon4("");
                    bookingsAllBean.setCommon5("");
                    bookingsAllBean.setCommon6(String.valueOf(prebooklogId));
                    bookingsAllBean.setCommon7("");
                    bookingsAllBean.setCommon8("");
                    bookingsAllBean.setCommon9(params.getPrebookcode());
                    bookingsAllBean.setCommon10("");//todo change it in real booking
                    bookingsAllBean.setCommon11("");
                    bookingsAllBean.setCommon15(String.valueOf(params.getMealId()));
                    bookingsAllBean.setInvoiceAmount("");
                    bookingsAllBean.setInvoiceNo("");
                    bookingsAllBean.setInvoiceStatus("");
                    bookingsAllBean.setBasis("");//todo
                    bookingsAllBean.setUpdater("XML-API");
                    bookingsAllBean.setPaying("agent");
                    bookingsAllBean.setBookingId("");//todo
                    bookingsAllBean.setSupplierReferences("");//todo
                    bookingsAllBean.setSupplierName("Sun Hotels");//todo
                    bookingsAllBean.setSupplierId("10239");//todo
                    if (params.getCustomerCountry() != null)
                        bookingsAllBean.setContactCountryCode(params.getCustomerCountry());
                    else
                        bookingsAllBean.setContactCountryCode("");
                    if (params.getEmail() != null)
                        bookingsAllBean.setContactEmail(params.getEmail());
                    else
                        bookingsAllBean.setContactEmail("");
                    if (params.getInfant() > 0)
                        bookingsAllBean.setCommon12("1");
                    else
                        bookingsAllBean.setCommon12("0");
                    if (params.getCustomerCountry() != null)
                        bookingsAllBean.setCommon14(params.getCustomerCountry());
                    else
                        bookingsAllBean.setCommon14("");
                    Timestamp timestamp = Timestamp.from(checkin.toInstant());
                    bookingsAllBean.setCheckIn(new java.sql.Date(timestamp.getTime()));
                    timestamp = Timestamp.from(checkout.toInstant());
                    bookingsAllBean.setCheckOut(new java.sql.Date(timestamp.getTime()));
                    timestamp = Timestamp.from(ZonedDateTime.now(ZoneOffset.UTC).toInstant());
                    bookingsAllBean.setBookingDate(timestamp);
                    bookingsAllBean.setUpdateDate(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute()));
                    bookingsAllBean.setPayDate(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute()));


                    HotelmappingBean hotelmappingBean = HotelmappingDAO.getHotelMappingbyATBId(Integer.parseInt(params.getHotelId()));
                    if (hotelmappingBean != null) {
                        List<HotelBean> hotelsbean = HotelDAO.getHotelByHotelId(hotelmappingBean.getHotelId(), hotelmappingBean.getProviderId(), null);
                        if (hotelsbean != null && hotelsbean.size() == 1) {
                            bookingsAllBean.setCommon13("");//todo roomtypeId
                            bookingsAllBean.setCityName(hotelsbean.get(0).getCity());
                            bookingsAllBean.setProductTitle(hotelsbean.get(0).getName());
                            bookingsAllBean.setCountryName(hotelsbean.get(0).getCountry());
                            bookingsAllBean.setProductId(String.valueOf(HotelmappingDAO.getOriginalHotelId(Integer.parseInt(params.getHotelId()), null)));
                            bookResult.setHotelAddress(hotelsbean.get(0).getAddress());
                            bookResult.setHotelId(Integer.parseInt(params.getHotelId()));
                            bookResult.setHotelName(hotelsbean.get(0).getName());
                            bookResult.setHotelPhone("");
                            bookResult.setBookingStatus("Active(Test Booking)");
                        } else {
                            bookJSON.setSuccess(false);
                            bookJSON.setErrorMessageText("Code:6.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                            bookJSON.setErrorType("Internal Error");
                            errLogger.info(bookJSON.getErrorMessageText());
                            storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                            return bookJSON;
                        }
                    } else {
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorMessageText("Code:7.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                        bookJSON.setErrorType("Internal Error");
                        errLogger.info(bookJSON.getErrorMessageText());
                        storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                        return bookJSON;
                    }


                    if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                        bookingsAllBean.setGsaId(subAgencyBean.getGsaId());
                        gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()), null);
                        if (gsaBean != null) {
                            bookingsAllBean.setGsaMarkup(gsaBean.getOtlMkp());
                            bookingsAllBean.setTopGsaName(gsaBean.getGsaName());
                            if (prebookJSON.getPrice() != null) {
                                if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                    BigDecimal gsaSale = prebookJSON.getPrice().getValue().multiply(new BigDecimal(100).divide(new BigDecimal(Integer.parseInt(subAgencyBean.getOtlMkp()) + 100), 2, RoundingMode.HALF_UP)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                    bookingsAllBean.setGsaSale(String.valueOf(gsaSale));
                                    bookingsAllBean.setAgentMarkup(subAgencyBean.getOtlMkp());
                                    if (gsaBean.getOtlMkp() != null && !gsaBean.getOtlMkp().equals("")) {
                                        bookingsAllBean.setAgentName(subAgencyBean.getAgentName());
                                        agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                        bookingsAllBean.setAgentSale(String.valueOf(agentSale));
                                        bookingsAllBean.setAgentEndSale(String.valueOf(agentSale));
                                        bookingsAllBean.setSupplierSale((gsaSale.multiply(new BigDecimal(100))).divide(new BigDecimal(Integer.parseInt(gsaBean.getOtlMkp()) + 100), 2, RoundingMode.HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                                    } else {
                                        bookJSON.setSuccess(false);
                                        bookJSON.setErrorMessageText("Code:1.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                                        bookJSON.setErrorType("Internal Error");
                                        errLogger.info(bookJSON.getErrorMessageText());
                                        storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                                        return bookJSON;
                                    }
                                } else {
                                    bookJSON.setSuccess(false);
                                    bookJSON.setErrorMessageText("Code:2.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                                    bookJSON.setErrorType("Internal Error");
                                    errLogger.info(bookJSON.getErrorMessageText());
                                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                                    return bookJSON;
                                }
                            } else {
                                bookJSON.setSuccess(false);
                                bookJSON.setErrorMessageText("");
                                bookJSON.setErrorType("Communication Error");
                                errLogger.info(bookJSON.getErrorMessageText());
                                storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                                return bookJSON;
                            }
                        } else {
                            bookJSON.setSuccess(false);
                            bookJSON.setErrorMessageText("Code:3.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                            bookJSON.setErrorType("Internal Error");
                            errLogger.info(bookJSON.getErrorMessageText());
                            storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                            return bookJSON;
                        }
                    } else {
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorMessageText("Code:4.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                        bookJSON.setErrorType("Internal Error");
                        errLogger.info(bookJSON.getErrorMessageText());
                        storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                        return bookJSON;
                    }

                    Integer bookingId = BookingsAllDAO.storeBooking(bookingsAllBean);



                    /**
                     * Store travellers to TravellerInfo table.
                     */
                    TravellerInfoBean travellerInfoBean;
                    for (int j = 0; j < numOfAdults; j++) {
                        travellerInfoBean = new TravellerInfoBean();
                        travellerInfoBean.setTravelName(adults[j].getFirst_name());
                        travellerInfoBean.setTravelSurname(adults[j].getLast_name());
                        travellerInfoBean.setTravelType("adult");
                        travellerInfoBean.setBookingId(String.valueOf(bookingId));
                        travellerInfoBean.setTravelBirdthDate("");
                        TravellerInfoDAO.storeTraveler(travellerInfoBean);
                    }
                    for (int j = 0; j < numOfChildren; j++) {
                        travellerInfoBean = new TravellerInfoBean();
                        travellerInfoBean.setTravelName(children[j].getFirst_name());
                        travellerInfoBean.setTravelSurname(children[j].getLast_name());
                        travellerInfoBean.setTravelType("child");
                        travellerInfoBean.setBookingId(String.valueOf(bookingId));
                        travellerInfoBean.setTravelBirdthDate("");
                        TravellerInfoDAO.storeTraveler(travellerInfoBean);
                    }


                    /**
                     * Preparing response
                     */
                    if (bookingId != 0) {
                        XMLGregorianCalendar xmlCheckin = null;
                        XMLGregorianCalendar xmlCheckout = null;
                        XMLGregorianCalendar currentDateTime = null;
                        try {
                            GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
                            GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);
                            GregorianCalendar gregorianCurrentDateTime = new GregorianCalendar();
                            xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
                            xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
                            currentDateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCurrentDateTime);
                        } catch (DatatypeConfigurationException e) {
                            bookJSON.setSuccess(false);
                            bookJSON.setErrorMessageText("Code:8.Please contact at:george.nafpaktitis@atbholidays.com");
                            bookJSON.setErrorType("Internal Error");
                            errLogger.info(bookJSON.getErrorMessageText());
                            storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                            return bookJSON;
                        }
                        bookResult.setBookingdate(currentDateTime);
                        bookResult.setBookingdateTimezone("UTC");
                        bookResult.setBookingnumber(String.valueOf(bookingId));
                        bookResult.setInvoiceref("");
                        bookResult.setMeal("");
                        bookResult.setMealId(params.getMealId());
                        bookResult.setNumberofrooms(String.valueOf(params.getRooms()));
                        bookResult.setPrice(agentSale);
                        bookResult.setRoomType("");
                        bookResult.setCheckindate(xmlCheckin);
                        bookResult.setCheckoutdate(xmlCheckout);
                        bookResult.setCurrency(subAgencyBean.getCurrency());
                        bookResult.setPaymentmethod("Deposit");
                        bookResult.setErrorMessage(null);
                        bookResult.setErrorMessage(null);
                        bookResult.setErrorAttributes(null);
                        bookResult.setCancellationpolicies(prebookJSON.getCancelationPolicies());
                        // bookResult.setVoucher();
                        // bookResult.setEarliestNonFreeCancellationDateUTC("");


                        List<Note> hotelNotes = new ArrayList<>();
                        Note hotelNote;
                        if (prebookJSON.getNotes() != null && prebookJSON.getNotes().getNote().size() > 0) {
                            for (CalendarNote note : prebookJSON.getNotes().getNote()) {
                                hotelNote = new Note();
                                hotelNote.setEndDate(note.getEndDate());
                                hotelNote.setStartDate(note.getStartDate());
                                hotelNote.setText(note.getText());
                                hotelNotes.add(hotelNote);
                            }
                        }
                        bookResult.setHotelNotes(hotelNotes);

                        bookJSON.setBookResult(bookResult);
                        bookJSON.setSuccess(true);
                    } else {
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorMessageText("Code:9.Couldn't store essential data to database.Please contact at:george.nafpaktitis@atbholidays.com");
                        bookJSON.setErrorType("Internal Error");
                        errLogger.info(bookJSON.getErrorMessageText());
                        storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                        return bookJSON;
                    }

                } else {
                    /**
                     * Case that  Subagency is in Real mode currently.
                     */
                    bookJSON.setTestBooking(false);
                    BigDecimal agentSale = null;

                    /**
                     * Book request.
                     */
                    try {
                        GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
                        GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);

                        String[]  prebookCode=params.getPrebookcode().split("ID:");
                        if(prebookCode==null || prebookCode.length==0){
                            bookJSON.setErrorMessageText("");
                            bookJSON.setErrorType("Code 32:Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                            storeBookLog(params, sunHotelsRequest, bookJSON, null, subAgencyBean, "", "SunHotels");
                            errLogger.info(bookJSON.getErrorMessageText());
                            return bookJSON;
                        }
                        XMLGregorianCalendar xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
                        XMLGregorianCalendar xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
                        NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
                        NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();//todo remove email and add atb's fixed email
                        sunHotelsRequest = subAgencyBean.getCurrency() + "" + "English" + "" +
                                "george@skamnos.com" + "" + xmlCheckin + "" + xmlCheckout + "" + params.getRoomId() + "" + params.getRooms() + "" +
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
                                children[8].getAge() + "" + 1 + "," + params.getEmail() + "," + params.getCustomerCountry() + "" + prebookCode[0];
                        result = nonStaticXMLAPISoap.bookV2(sunhotelsUsername, sunhotelspass, subAgencyBean.getCurrency(), "English",//todo change email to info@atbholidays
                                "george@skamnos.com", xmlCheckin, xmlCheckout, params.getRoomId(), params.getRooms(),
                                numOfAdults, numOfChildren, params.getInfant(), "", "",
                                originalMealId, adults[0].getFirst_name(), adults[0].getLast_name(), adults[1].getFirst_name(), adults[1].getLast_name(),
                                adults[2].getFirst_name(), adults[2].getLast_name(), adults[3].getFirst_name(), adults[3].getLast_name(), adults[4].getFirst_name(),
                                adults[4].getLast_name(), adults[5].getFirst_name(), adults[5].getLast_name(), adults[6].getFirst_name(), adults[6].getLast_name(),
                                adults[7].getFirst_name(), adults[7].getLast_name(), adults[8].getFirst_name(), adults[8].getLast_name(), children[0].getFirst_name(),
                                children[0].getLast_name(), children[0].getAge(), children[1].getFirst_name(), children[1].getLast_name(), children[1].getAge(),
                                children[2].getFirst_name(), children[2].getLast_name(), children[2].getAge(), children[3].getFirst_name(), children[3].getLast_name(),
                                children[3].getAge(), children[4].getFirst_name(), children[4].getLast_name(), children[4].getAge(), children[5].getFirst_name(),
                                children[5].getLast_name(), children[5].getAge(), children[6].getFirst_name(), children[6].getLast_name(), children[6].getAge(),
                                children[7].getFirst_name(), children[7].getLast_name(), children[7].getAge(), children[8].getFirst_name(), children[8].getLast_name(),
                                children[8].getAge(), 1, "", "", "", "", "",
                                "", params.getEmail(), "", params.getCustomerCountry(), "", "", prebookCode[0]);
                    } catch (DatatypeConfigurationException e) {
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorMessageText("");
                        bookJSON.setErrorType("Communication Error");
                        storeBookLog(params, sunHotelsRequest, bookJSON, null, subAgencyBean, "", "SunHotels");
                        errLogger.info(bookJSON.getErrorMessageText());
                        return bookJSON;
                    } catch (NullPointerException e) {
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorMessageText("");
                        bookJSON.setErrorType("Communication Error");
                        storeBookLog(params, sunHotelsRequest, bookJSON, null, subAgencyBean, "", "SunHotels");
                        errLogger.info(bookJSON.getErrorMessageText());
                        return bookJSON;
                    }

                    /**
                     * Response
                     */
                    if (result.getError() != null) {
                        bookJSON.setErrorMessageText(result.getError().getMessage());
                        bookJSON.setSuccess(false);
                        bookJSON.setErrorType(result.getError().getErrorType());
                    } else {

                        /**
                         * Store Booking Results(Cancelation policies and prebookcode) prebookLog table.
                         */
                        PrebookLogBean prebookLogBean = new PrebookLogBean();
                        prebookLogBean.setHotelId(String.valueOf(HotelmappingDAO.getOriginalHotelId(Integer.parseInt(params.getHotelId()), null)));
                        prebookLogBean.setPrebookDate(prebookJSON.getDateStamp());
                        prebookLogBean.setPrebookRef(params.getPrebookcode());
                        prebookLogBean.setPrice(String.valueOf(prebookJSON.getPrice().getValue()));
                        prebookLogBean.setRoomId(String.valueOf(params.getRoomId()));
                        prebookLogBean.setRoomTypeName("");
                        prebookLogBean.setMealName("");


                        mapper = new ObjectMapper();
                        try {
                            prebookLogBean.setNotes(mapper.writeValueAsString(result.getBooking().getHotelNotes()));
                        } catch (JsonProcessingException e) {
                            errLogger.info("Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to store correctly to databse(HotelNotes)");
                        }


                        if (result.getBooking().getCancellationpolicies() != null && result.getBooking().getCancellationpolicies().size() > 0) {
                            StaticPercentageCancellationPolicy atbPolicy = new StaticPercentageCancellationPolicy();
                            atbPolicy.setDeadline(0);
                            for (StaticPercentageCancellationPolicy policy : result.getBooking().getCancellationpolicies()) {
                                if (policy.getDeadline() == null) {
                                    atbPolicy = policy;
                                    break;
                                }
                                if (policy.getDeadline() > atbPolicy.getDeadline())
                                    atbPolicy = policy;
                            }
                            prebookLogBean.setPercentage("100");
                            prebookLogBean.setCancelPolicy(atbPolicy.getText());
                            if (atbPolicy.getDeadline() != null) {
                                prebookLogBean.setAtbCancelPolicy("Cancellation made less than " + (atbPolicy.getDeadline() + plusCancelationPolicyHours) + " hours (12:00) prior to the arrival will be charged with 100% of the total booking value.");
                                prebookLogBean.setDeadline(String.valueOf(atbPolicy.getDeadline() + plusCancelationPolicyHours));
                            } else {
                                prebookLogBean.setAtbCancelPolicy("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                                prebookLogBean.setDeadline("null");
                            }
                        } else {
                            prebookLogBean.setAtbCancelPolicy("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                            prebookLogBean.setDeadline("null");
                            prebookLogBean.setPercentage("100");
                        }
                        int prebookLogId=PrebookLogDAO.storePrebookLog(prebookLogBean);

                        if(prebookLogId==0)
                            errLogger.info("Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to get preeboklogId");

                        /**
                         * Store Booking Results to Hotel_Bookings_All table
                         */
                        String bookingCode = "HTL-API-" + result.getBooking().getBookingnumber() + "-0";
                        BookingsAllBean bookingsAllBean = new BookingsAllBean();
                        bookingsAllBean.setAdittionalRequest("");
                        bookingsAllBean.setAgentCommission("");
                        bookingsAllBean.setAgentEndSaleCur(subAgencyBean.getCurrency());
                        bookingsAllBean.setAgentId(String.valueOf(subAgencyBean.getId()));
                        bookingsAllBean.setAudioGuide("");
                        bookingsAllBean.setBasketId("");
                        bookingsAllBean.setBookletGuide("");
                        bookingsAllBean.setConfirmationNo("");
                        bookingsAllBean.setPlanId(String.valueOf(params.getRoomId()));
                        bookingsAllBean.setContactTel("");
                        bookingsAllBean.setDiscountAmount("");
                        bookingsAllBean.setDiscountMarkup("");
                        bookingsAllBean.setLiveGuide("");
                        bookingsAllBean.setPayType("Deposit");
                        bookingsAllBean.setPosId("");
                        bookingsAllBean.setProductType("HTL");
                        bookingsAllBean.setSaleCurrency(subAgencyBean.getCurrency());
                        bookingsAllBean.setStatus("4");
                        bookingsAllBean.setSupplierCurrency(subAgencyBean.getCurrency());
                        bookingsAllBean.setStatusReason("");
                        bookingsAllBean.setTotalPax(String.valueOf(numOfAdults + numOfChildren));
                        bookingsAllBean.setTourLeader(adults[0].getFirst_name() + " " + adults[0].getLast_name());
                        bookingsAllBean.setXmlAgent(subAgencyBean.getAgentName());
                        bookingsAllBean.setXmlBookRef("");
                        bookingsAllBean.setCommon1("");
                        bookingsAllBean.setCommon2("");
                        bookingsAllBean.setCommon3("");
                        bookingsAllBean.setCommon4("");
                        bookingsAllBean.setCommon5("");
                        bookingsAllBean.setCommon6(String.valueOf(prebookLogId));
                        bookingsAllBean.setCommon7(result.getBooking().getHotelAddress());
                        bookingsAllBean.setCommon8(result.getBooking().getHotelPhone());
                        bookingsAllBean.setCommon9(params.getPrebookcode());
                        bookingsAllBean.setCommon10(result.getBooking().getBookingnumber());
                        bookingsAllBean.setCommon11(result.getBooking().getVoucher());
                        bookingsAllBean.setCommon15(String.valueOf(params.getMealId()));
                        bookingsAllBean.setInvoiceAmount("");
                        bookingsAllBean.setInvoiceNo("");
                        bookingsAllBean.setInvoiceStatus("");
                        bookingsAllBean.setBasis("");//todo
                        bookingsAllBean.setUpdater("XML-API");
                        bookingsAllBean.setPaying("agent");
                        bookingsAllBean.setBookingId(bookingCode);//todo
                        bookingsAllBean.setSupplierReferences("");//todo
                        bookingsAllBean.setSupplierName("Sun Hotels");//todo
                        bookingsAllBean.setSupplierId("10239");//todo
                        if (params.getCustomerCountry() != null)
                            bookingsAllBean.setContactCountryCode(params.getCustomerCountry());
                        else
                            bookingsAllBean.setContactCountryCode("");
                        if (params.getEmail() != null)
                            bookingsAllBean.setContactEmail(params.getEmail());
                        else
                            bookingsAllBean.setContactEmail("");
                        if (params.getInfant() > 0)
                            bookingsAllBean.setCommon12("1");
                        else
                            bookingsAllBean.setCommon12("0");
                        if (params.getCustomerCountry() != null)
                            bookingsAllBean.setCommon14(params.getCustomerCountry());
                        else
                            bookingsAllBean.setCommon14("");
                        if (result.getBooking().getNumberofrooms() != null && !result.getBooking().getNumberofrooms().equals(""))
                            bookingsAllBean.setPriceId(String.valueOf(Integer.parseInt(result.getBooking().getNumberofrooms())));

                        XMLGregorianCalendar xmlGregorianCalendar = result.getBooking().getCheckindate();
                        Timestamp timestamp = new Timestamp(xmlGregorianCalendar.toGregorianCalendar().getTimeInMillis() + 1000 * 60 * 60 * 10);
                        bookingsAllBean.setCheckIn(new java.sql.Date(timestamp.getTime()));
                        xmlGregorianCalendar = result.getBooking().getCheckoutdate();
                        timestamp = new Timestamp(xmlGregorianCalendar.toGregorianCalendar().getTimeInMillis() + 1000 * 60 * 60 * 10);
                        bookingsAllBean.setCheckOut(new java.sql.Date(timestamp.getTime()));
                        xmlGregorianCalendar = result.getBooking().getBookingdate();
                        timestamp = new Timestamp(xmlGregorianCalendar.toGregorianCalendar().getTimeInMillis());
                        bookingsAllBean.setBookingDate(timestamp);
                        bookingsAllBean.setUpdateDate(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute()));
                        bookingsAllBean.setPayDate(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute()));


                        HotelmappingBean hotelmappingBean = HotelmappingDAO.getHotelMappingbyATBId(Integer.parseInt(params.getHotelId()));
                        if (hotelmappingBean != null) {
                            List<HotelBean> hotelsbean = HotelDAO.getHotelByHotelId(hotelmappingBean.getHotelId(), hotelmappingBean.getProviderId(), null);
                            if (hotelsbean != null && hotelsbean.size() == 1) {
                                bookingsAllBean.setCommon13(result.getBooking().getRoomType());//todo roomtypeId
                                bookingsAllBean.setCityName(hotelsbean.get(0).getCity());
                                bookingsAllBean.setProductTitle(hotelsbean.get(0).getName());
                                bookingsAllBean.setCountryName(hotelsbean.get(0).getCountry());
                                bookingsAllBean.setProductId(String.valueOf(HotelmappingDAO.getOriginalHotelId(Integer.parseInt(params.getHotelId()), null)));
                                bookResult.setHotelAddress(hotelsbean.get(0).getAddress());
                                bookResult.setHotelId(Integer.parseInt(params.getHotelId()));
                                bookResult.setHotelName(hotelsbean.get(0).getName());
                                bookResult.setHotelPhone(result.getBooking().getHotelPhone());
                            } else {
                                errLogger.info("Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to store correctly to databse");
                            }
                        } else {
                            errLogger.info("Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels  side but failed to store correctly to databse");
                        }


                        if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                            bookingsAllBean.setGsaId(subAgencyBean.getGsaId());
                            gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()), null);
                            if (gsaBean != null) {
                                bookingsAllBean.setGsaMarkup(gsaBean.getOtlMkp());
                                bookingsAllBean.setTopGsaName(gsaBean.getGsaName());
                                if (result.getBooking().getPrices().getPrice() != null && result.getBooking().getPrices().getPrice().size() > 0) {
                                    if (gsaBean.getOtlMkp() != null && !gsaBean.getOtlMkp().equals("")) {
                                        for (PriceWithPaymentMethods price : result.getBooking().getPrices().getPrice()) {
                                            if (price.getCurrency().equals(subAgencyBean.getCurrency())) {
                                                BigDecimal gsaSale = price.getValue().add(price.getValue().multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                bookingsAllBean.setGsaSale(String.valueOf(gsaSale));
                                                if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                                    bookingsAllBean.setAgentMarkup(subAgencyBean.getOtlMkp());
                                                    bookingsAllBean.setAgentName(subAgencyBean.getAgentName());
                                                    agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                    bookingsAllBean.setAgentSale(String.valueOf(agentSale));
                                                    bookingsAllBean.setAgentEndSale(String.valueOf(agentSale));
                                                    bookingsAllBean.setSupplierSale((gsaSale.multiply(new BigDecimal(100))).divide(new BigDecimal(Integer.parseInt(gsaBean.getOtlMkp()) + 100), 2, RoundingMode.HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                                                } else {
                                                    errLogger.info("Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but sub agency with id:" + subAgencyBean.getId() + " has not hotel mark up");
                                                }
                                            }
                                        }
                                    } else {
                                        errLogger.info("Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to store correctly to databse");
                                    }
                                } else {
                                    errLogger.info("Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but price didn't came correctly at response");
                                }
                            } else {
                                errLogger.info("Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to store correctly to databse");
                            }
                        } else {
                            errLogger.info("Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to store correctly to databse");
                        }

                        Integer bookingId = BookingsAllDAO.storeBooking(bookingsAllBean);
                        if (bookingId == 0)
                            errLogger.info("Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to store correctly to databse");



                        /**
                         * Store travellers to TravellerInfo table.
                         */
                        TravellerInfoBean travellerInfoBean;
                        List<TravellerInfoBean> travellers = new ArrayList<>();
                        for (int j = 0; j < numOfAdults; j++) {
                            travellerInfoBean = new TravellerInfoBean();
                            travellerInfoBean.setTravelName(adults[j].getFirst_name());
                            travellerInfoBean.setTravelSurname(adults[j].getLast_name());
                            travellerInfoBean.setTravelType("adult");
                            travellerInfoBean.setBookingId(bookingCode);
                            travellerInfoBean.setTravelBirdthDate("");
                            travellers.add(travellerInfoBean);
                            TravellerInfoDAO.storeTraveler(travellerInfoBean);
                        }
                        for (int j = 0; j < numOfChildren; j++) {
                            travellerInfoBean = new TravellerInfoBean();
                            travellerInfoBean.setTravelName(children[j].getFirst_name());
                            travellerInfoBean.setTravelSurname(children[j].getLast_name());
                            travellerInfoBean.setTravelType("child");
                            travellerInfoBean.setBookingId(bookingCode);//todo change to other bookig id
                            travellerInfoBean.setTravelBirdthDate("");
                            travellers.add(travellerInfoBean);
                            TravellerInfoDAO.storeTraveler(travellerInfoBean);
                        }


                        /**
                         * Detuct price from sub agency's deposit
                         */
                        if (agentSale != null) {
                            subAgencyBean.setDeposit(BigDecimal.valueOf(Double.parseDouble(subAgencyBean.getDeposit())).subtract(agentSale).toString());
                            if (SubAgencyDAO.updateSubAgentByName(subAgencyBean)) {
                                errLogger.info("**********Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to detuct the price from sub agency deposit at database.*********");
                            } else {
                                /**
                                 * Store transaction to BookingTransaction table
                                 */
                                //todo charge gsa also
                                BookingTransactionBean bookingTransactionBean = new BookingTransactionBean();
                                bookingTransactionBean.setAgentId(String.valueOf(subAgencyBean.getId()));
                                bookingTransactionBean.setAgentName(subAgencyBean.getAgentName());
                                bookingTransactionBean.setBookingId(bookingCode);
                                bookingTransactionBean.setGsaId(subAgencyBean.getGsaId());
                                bookingTransactionBean.setTransactionType("Charge");
                                bookingTransactionBean.setTransCur(subAgencyBean.getCurrency());
                                bookingTransactionBean.setTransNote("");
                                bookingTransactionBean.setTransDate(timestamp.toString());
                                bookingTransactionBean.setTransRate(agentSale.toString());
                                bookingTransactionBean.setTransType("Deposit");
                                if (BookingTransactionDAO.storeTransaction(bookingTransactionBean)) {
                                    errLogger.info("Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to store transaction at bookingtransaction table.");
                                }
                            }
                        } else
                            errLogger.info("**********Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to detuct the price from sub agency deposit at database.*********");


                        /**
                         * Prepare response
                         */
                        bookResult.setBookingdate(result.getBooking().getBookingdate());
                        bookResult.setBookingdateTimezone(result.getBooking().getBookingdateTimezone());
                        bookResult.setBookingnumber(String.valueOf(bookingId));
                        bookResult.setCheckindate(result.getBooking().getCheckindate());
                        bookResult.setCheckoutdate(result.getBooking().getCheckoutdate());
                        bookResult.setCurrency(result.getBooking().getCurrency());
                        bookResult.setEarliestNonFreeCancellationDateUTC(result.getBooking().getEarliestNonFreeCancellationDateCET());
                        bookResult.setHotelAddress(result.getBooking().getHotelAddress());
                        bookResult.setHotelId(HotelmappingDAO.getATBHotelId(result.getBooking().getHotelId(), sanHotelsProviderId, null));
                        bookResult.setHotelName(result.getBooking().getHotelName());
                        bookResult.setHotelPhone(result.getBooking().getHotelPhone());
                        bookResult.setInvoiceref(result.getBooking().getInvoiceref());
                        bookResult.setMeal(result.getBooking().getMeal());
                        bookResult.setMealId(result.getBooking().getMealId());
                        bookResult.setNumberofrooms(result.getBooking().getNumberofrooms());
                        bookResult.setPrice(agentSale);
                        bookResult.setRoomType(result.getBooking().getRoomType());
                        bookResult.setPaymentmethod("Deposit");
                        bookResult.setBookingStatus("Active");
                        bookResult.setTravellerInfo(travellers);
                        // bookResult.setVoucher();

                        List<CancelationPolicyResponse> cancelationPolicies = new ArrayList<>();
                        CancelationPolicyResponse cancelationPolicy = new CancelationPolicyResponse();
                        if (result.getBooking().getCancellationpolicies() != null && result.getBooking().getCancellationpolicies().size() > 0) {
                            StaticPercentageCancellationPolicy atbPolicy = new StaticPercentageCancellationPolicy();
                            atbPolicy.setDeadline(0);
                            for (StaticPercentageCancellationPolicy policy : result.getBooking().getCancellationpolicies()) {
                                if (policy.getDeadline() == null) {
                                    atbPolicy = policy;
                                    break;
                                }
                                if (policy.getDeadline() > atbPolicy.getDeadline())
                                    atbPolicy = policy;
                            }
                            cancelationPolicy.setPercentage(new BigDecimal(100));
                            if (atbPolicy.getDeadline() != null) {
                                cancelationPolicy.setDeadline(atbPolicy.getDeadline() + plusCancelationPolicyHours);
                                cancelationPolicy.setText("Cancellation made less than " + (atbPolicy.getDeadline() + plusCancelationPolicyHours) + " hours (12:00) prior to the arrival will be charged with 100% of the total booking value.");
                            } else {
                                cancelationPolicy.setText("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                                cancelationPolicy.setDeadline(null);
                            }
                        } else {
                            cancelationPolicy.setText("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                            cancelationPolicy.setDeadline(null);
                            cancelationPolicy.setPercentage(new BigDecimal(100));
                        }
                        cancelationPolicies.add(cancelationPolicy);
                        bookResult.setCancellationpolicies(cancelationPolicies);

                        List<Note> hotelnotes = new ArrayList<>();
                        Note hotelnote;
                        if (result.getBooking().getHotelNotes().getHotelNote() != null && result.getBooking().getHotelNotes().getHotelNote().size() > 0) {
                            for (CalendarNote note : result.getBooking().getHotelNotes().getHotelNote()) {
                                hotelnote = new Note();
                                hotelnote.setEndDate(note.getEndDate());
                                hotelnote.setStartDate(note.getStartDate());
                                hotelnote.setText(note.getText());
                                hotelnotes.add(hotelnote);
                            }
                        }
                        List<Note> roomnotes = new ArrayList<>();
                        Note roomnote;
                        if (result.getBooking().getRoomNotes().getRoomNote() != null && result.getBooking().getRoomNotes().getRoomNote().size() > 0) {
                            for (CalendarNote note : result.getBooking().getRoomNotes().getRoomNote()) {
                                roomnote = new Note();
                                roomnote.setEndDate(note.getEndDate());
                                roomnote.setStartDate(note.getStartDate());
                                roomnote.setText(note.getText());
                                roomnotes.add(roomnote);
                            }
                        }
                        bookResult.setHotelNotes(hotelnotes);
                        bookResult.setRoomNotes(roomnotes);

                        if (result.getBooking().getError() != null && result.getBooking().getError().getErrorType() != null)
                            bookResult.setErrorMessage(result.getBooking().getError().getErrorType());
                        if (result.getBooking().getError() != null && result.getBooking().getError().getMessage() != null)
                            bookResult.setErrorMessage(result.getBooking().getError().getMessage());
                        if (result.getBooking().getError() != null && result.getBooking().getErrorAttributes().getErrorAttribute() != null)
                            bookResult.setErrorAttributes(result.getBooking().getErrorAttributes().getErrorAttribute().toString());

                        bookJSON.setBookResult(bookResult);
                        bookJSON.setSuccess(true);
                    }
                }

                if (result != null && result.getBooking() != null)
                    storeBookLog(params, sunHotelsRequest, bookJSON, result, subAgencyBean, result.getBooking().getBookingnumber(), "SunHotels");
                else
                    storeBookLog(params, sunHotelsRequest, bookJSON, result, subAgencyBean, "", "SunHotels");
            } else {
                bookJSON.setSuccess(false);
                bookJSON.setErrorType("Internal Error");
                errLogger.info(bookJSON.getErrorMessageText());
                bookJSON.setErrorMessageText("Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
            }


            /**
             * Currency conversion
             */
            if (!params.getCurrencyCode().equals("") && bookJSON.getBookResult() != null && bookJSON.getBookResult().getPrice() != null && bookJSON.getBookResult().getCurrency() != null) {
                BigDecimal convertedPrice = CurrencyConverter.findExchangeRateAndConvert(bookJSON.getBookResult().getCurrency(), params.getCurrencyCode(), Double.parseDouble(bookJSON.getBookResult().getPrice().toString()));
                if (convertedPrice != null) {
                    convertedPrice = convertedPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
                    bookJSON.getBookResult().setPrice(convertedPrice);
                    bookJSON.getBookResult().setCurrency(params.getCurrencyCode());
                }
            }
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            bookJSON.setSuccess(false);
            bookJSON.setErrorMessageText(errors.toString());
        }
        return bookJSON;
    }

}