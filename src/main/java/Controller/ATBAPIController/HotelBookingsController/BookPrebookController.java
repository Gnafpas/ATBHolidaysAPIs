package Controller.ATBAPIController.HotelBookingsController;

import APIJSONs.ATBAPIJSONs.Hotel.*;
import APIJSONs.ATBAPIJSONs.Hotel.BookResult;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.CancelationPolicyResponse;
import Beans.ATBDBBeans.KalitaonHotel.*;
import Beans.ATBDBBeans.KalitaonLog.PrebookLogBean;
import Beans.ATBDBBeans.KalitaonSystem.*;
import Beans.HotelBedsAPIBeans.Availability.*;
import Beans.HotelBedsAPIBeans.Book.CheckRateAPIJSON;
import Beans.HotelBedsAPIBeans.Book.CheckRatePost;
import Beans.HotelBedsAPIBeans.Book.Holder;
import Beans.HotelBedsAPIBeans.Book.RateKey;
import Beans.ViatorDBBeans.BookLogBean;
import Controller.Application;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.*;
import DAOs.ATBDBDAOs.KalitaonLogDAOs.PrebookLogDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.*;
import DAOs.HotelBedsAPIDAOs.AvailabilityDAOs;
import DAOs.HotelBedsAPIDAOs.BookDAOs;
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
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.sql.Timestamp;
import java.util.regex.Pattern;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.*;

/**
 * Created by George on 03/12/2017.
 */
@RestController
public class BookPrebookController {


    private  void storePrebookLog(PrebookPOST params, AvailabilityPOST availabilityPOST,AvailabilityAPIJSON availabilityJson , String sunHotelsRequest, PrebookJSON prebookJSON, PreBookResult result, SubAgencyBean subAgencyBean, String prebookRef, String providerName){
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
                prebookLogBean.setProviderResponse("");
            }
        }else if(availabilityJson!=null){
            try {
                prebookLogBean.setProviderResponse(mapper.writeValueAsString(availabilityJson).toString());
            } catch (JsonProcessingException e1) {
                prebookLogBean.setProviderResponse("");
            }
        }else
            prebookLogBean.setProviderResponse("");
        if(!sunHotelsRequest.equals(""))
             prebookLogBean.setProviderRequest(sunHotelsRequest);
        else if(availabilityPOST!=null){
            try {
                prebookLogBean.setProviderRequest(mapper.writeValueAsString(availabilityPOST).toString());
            } catch (JsonProcessingException e1) {
                prebookLogBean.setProviderRequest("");
            }
        }else
            prebookLogBean.setProviderRequest("");
        prebookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())));
        prebookLogBean.setPrebookRef(prebookRef);
        prebookLogBean.setProvider(providerName);

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
                AvailabilityPOST availabilityPOST = new AvailabilityPOST();
                AvailabilityAPIJSON availabilityAPIJSON=null;

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
                            storePrebookLog(params,null ,null,"", prebookJSON, null, subAgencyBean, "", "");
                            return prebookJSON;
                        }
                    }

                }

                if (!params.getCurrencyCode().equals("")) {
                    if (CurrencyConverter.findExchangeRateAndConvert(subAgencyBean.getCurrency(), params.getCurrencyCode(), new Double(1)) == null) {
                        prebookJSON.setSuccess(false);
                        prebookJSON.setErrorMessageText("Wrong currrency code");
                        storePrebookLog(params,null ,null, "", prebookJSON, null, subAgencyBean, "", "");
                        return prebookJSON;
                    }
                }

                String childrenAges = "";
                if (params.getChildrenAges() != null && params.getChildrenAges().size() > 0) {
                    childrenAges = "" + params.getChildrenAges().get(0);
                    for (int i = 1; i < params.getChildrenAges().size(); i++)
                        childrenAges = childrenAges + "," + params.getChildrenAges().get(i);
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
                 * RoomtypeId check.Used for recognize provider
                 */
                RoomtypeBean roomtypeBean;
                if (params.getRoomTypeId() == null) {
                    prebookJSON.setSuccess(false);
                    prebookJSON.setErrorMessageText("Wrong roomtypeId");
                    storePrebookLog(params,null ,null, "", prebookJSON, result, subAgencyBean, "", "");
                    return prebookJSON;
                } else {
                    roomtypeBean = RoomtypeDAO.getRoomtypeATBId(params.getRoomTypeId());
                    if (roomtypeBean == null) {
                        prebookJSON.setSuccess(false);
                        prebookJSON.setErrorMessageText("Wrong roomtypeId");
                        storePrebookLog(params, null ,null,"", prebookJSON, result, subAgencyBean, "", "");
                        return prebookJSON;
                    }
                }




                /**
                 * Get original hotel id
                 */
                int originalHotelId = 0;
                String originalHotelIdStringFormat = "";
                if (params.getHotelId() != null && !params.getHotelId().equals("")) {
                    HotelmappingBean hotelmappingBean = HotelmappingDAO.getHotelMappingbyATBId(Integer.parseInt(params.getHotelId()));
                    if (hotelmappingBean != null) {

                        if (hotelmappingBean.getProviderId() != roomtypeBean.getProviderId()) {

                            List<HotelBean> hotels = HotelDAO.getHotelByHotelId(hotelmappingBean.getHotelId(), hotelmappingBean.getProviderId(), null);
                            if (hotels != null && hotels.size() > 0) {
                                DestinationBean destination = DestinationDAO.getDestinationBean(hotels.get(0).getDestinationId(), hotels.get(0).getProviderId(), null);
                                List<HotelBean> roomTypeProviderHotels = null;
                                if (roomtypeBean.getProviderId() == sanHotelsProviderId)
                                    roomTypeProviderHotels = HotelDAO.getHotelByDestId(String.valueOf(destination.getDestinationId()), roomtypeBean.getProviderId());
                                else if (roomtypeBean.getProviderId() == hotelBedsProviderId)
                                    roomTypeProviderHotels = HotelDAO.getHotelByDestId(destination.getHotelBedsCode(), roomtypeBean.getProviderId());
                                if (roomTypeProviderHotels != null && roomTypeProviderHotels.size() > 0 && destination != null) {
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
                                                                                originalHotelId = roomTypeProviderHotels.get(z).getHotelId();
                                                                                originalHotelIdStringFormat=  String.valueOf(originalHotelId);
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
                        } else {
                            originalHotelId = hotelmappingBean.getHotelId();
                            originalHotelIdStringFormat= String.valueOf(originalHotelId);
                        }
                    }else{
                        prebookJSON.setSuccess(false);
                        prebookJSON.setErrorMessageText("Wrong hotelId");
                        storePrebookLog(params,null ,null, "", prebookJSON, result, subAgencyBean, "", "");
                        return prebookJSON;
                    }
                }else{
                    prebookJSON.setSuccess(false);
                    prebookJSON.setErrorMessageText("Wrong hotelId");
                    storePrebookLog(params,null ,null, "", prebookJSON, result, subAgencyBean, "", "");
                    return prebookJSON;
                }

                /**
                 * Get original meal id
                 */
                String originalMealId = "";
                String id = MealDAO.getOriginalMealId(String.valueOf(params.getMealId()));
                if (id != null)
                    originalMealId = id;


                if(new Integer(roomtypeBean.getProviderId()).compareTo(sanHotelsProviderId)==0) {
                    int sunHotelsOriginalMealId=0;
                    sunHotelsOriginalMealId= Integer.parseInt(originalMealId);
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
                                childrenAges, params.getInfant(), sunHotelsOriginalMealId, params.getCustomerCountry(), "",
                                "", params.getRoomId(), originalHotelIdStringFormat, originalRoomTypeIdStrFrm, blockSuperDeal,
                                "");
                    } catch (DatatypeConfigurationException e) {
                        prebookJSON.setSuccess(false);
                        prebookJSON.setErrorMessageText("Wrong date type.The correct format is yyyy-mm-dd");
                        storePrebookLog(params,null ,null, sunHotelsRequest, prebookJSON, result, subAgencyBean, "", "SunHotels");
                        return prebookJSON;
                    } catch (NullPointerException e) {
                        prebookJSON.setSuccess(false);
                        prebookJSON.setErrorMessageText("Wrong date type.The correct format is yyyy-mm-dd");
                        storePrebookLog(params,null ,null, sunHotelsRequest, prebookJSON, result, subAgencyBean, "", "SunHotels");
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
                                            storePrebookLog(params,null ,null, sunHotelsRequest, prebookJSON, result, subAgencyBean, result.getPreBookCode(), "SunHotels");
                                            errLogger.info(prebookJSON.getErrorMessageText());
                                            return prebookJSON;
                                        }
                                    } else {
                                        prebookJSON.setSuccess(false);
                                        prebookJSON.setErrorMessageText("Code:2.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                                        storePrebookLog(params,null ,null, sunHotelsRequest, prebookJSON, result, subAgencyBean, result.getPreBookCode(), "SunHotels");
                                        errLogger.info(prebookJSON.getErrorMessageText());
                                        return prebookJSON;
                                    }
                                } else {
                                    prebookJSON.setSuccess(false);
                                    prebookJSON.setErrorMessageText("");
                                    storePrebookLog(params,null ,null, sunHotelsRequest, prebookJSON, result, subAgencyBean, result.getPreBookCode(), "SunHotels");
                                    return prebookJSON;
                                }
                            } else {
                                prebookJSON.setSuccess(false);
                                prebookJSON.setErrorMessageText("Code:3.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                                errLogger.info(prebookJSON.getErrorMessageText());
                                storePrebookLog(params, null ,null,sunHotelsRequest, prebookJSON, result, subAgencyBean, result.getPreBookCode(), "SunHotels");
                                return prebookJSON;
                            }
                        } else {
                            prebookJSON.setSuccess(false);
                            prebookJSON.setErrorMessageText("Code:4.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                            errLogger.info(prebookJSON.getErrorMessageText());
                            storePrebookLog(params,null ,null, sunHotelsRequest, prebookJSON, result, subAgencyBean, result.getPreBookCode(), "SunHotels");
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
                            cancelationPolicy.setPercentage(new BigDecimal(100));//todo fix cancelation policies(search in the whole class to fix all the references) .
                            if (atbPolicy.getDeadline() != null) {//todo I am setting all cancelation policies to 100% because there are policies with the longest deadline and less percentage
                                cancelationPolicy.setDeadline(atbPolicy.getDeadline() + plusCancelationPolicyHours);//todo If i added the real percentage there will be a problem because we have only one cancelation policy currently.When we add the feuture for more policies  this code must be changed to real percentenge
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
                        prebookJSON.setPreBookCode(result.getPreBookCode() + "ID:" + sanHotelsProviderId);
                        prebookJSON.setSuccess(true);
                    }
                    storePrebookLog(params,null ,null, sunHotelsRequest, prebookJSON, result, subAgencyBean, result.getPreBookCode() + "ID:" + sanHotelsProviderId, "SunHotels");
                }else if(new Integer(roomtypeBean.getProviderId()).compareTo(hotelBedsProviderId)==0){

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
                    if (params.getChildrenAges() != null && params.getChildrenAges().size() > 0) {
                        for (int age : params.getChildrenAges()) {
                            if (age != 0 ) {
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
                    if (originalHotelId!=0)
                        hs.add(originalHotelId);
                    else{
                        prebookJSON.setSuccess(false);
                        prebookJSON.setErrorMessageText("Wrong hotelId");
                        storePrebookLog(params,null ,null, "", prebookJSON, result, subAgencyBean, "", "Hotelbeds");
                        return prebookJSON;
                    }

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

                                                    List<CancelationPolicyResponse> cancelationPolicies;
                                                    CancelationPolicyResponse cancelationPolicy;
                                                    cancelationPolicies = new ArrayList<>();
                                                    cancelationPolicy = new CancelationPolicyResponse();


                                                    if (rate.getCancellationPolicies() != null && rate.getCancellationPolicies().size()>0) {
                                                        cancelationPolicy.setDeadline(0);
                                                        for (CancellationPolicy policy : rate.getCancellationPolicies()) {//todo ask about roomtypes codes whichare not comming all
                                                            //BigDecimal percentange = new BigDecimal((Double.parseDouble(policy.getAmount()) * 100) / Double.parseDouble(rate.getNet())).setScale(0, BigDecimal.ROUND_HALF_UP);
                                                            //cancelationPolicy.setPercentage(percentange);//todo uncomment this when we add the fuature for more cancelation policies per prebook request

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
                                                                            cancelationPolicies.add(cancelationPolicy);
                                                                            break;
                                                                        } else {
                                                                            if((int) Duration.between(cancelationDate, checkin).getSeconds() / 60 / 60 > cancelationPolicy.getDeadline())
                                                                            cancelationPolicy.setDeadline((int) Duration.between(cancelationDate, checkin).getSeconds() / 60 / 60);
                                                                        }
                                                                        cancelationPolicies.add(cancelationPolicy);
                                                                    } catch (NumberFormatException e) {
                                                                        e.printStackTrace();
                                                                    }
                                                                } else {
                                                                    cancelationPolicy.setText("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                                                                    cancelationPolicy.setDeadline(null);
                                                                    cancelationPolicy.setPercentage(new BigDecimal(100));
                                                                    break;
                                                                }
                                                            } else {
                                                                cancelationPolicy.setText("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                                                                cancelationPolicy.setDeadline(null);
                                                                cancelationPolicy.setPercentage(new BigDecimal(100));
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        cancelationPolicy.setText("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                                                        cancelationPolicy.setDeadline(null);
                                                        cancelationPolicy.setPercentage(new BigDecimal(100));
                                                    }

                                                    cancelationPolicy.setPercentage(new BigDecimal(100));//todo delete this when we add the fuature for more cancelation policies per prebook request also change the 100% at text.
                                                    if (cancelationPolicy.getDeadline() != null) {
                                                        cancelationPolicy.setDeadline(cancelationPolicy.getDeadline() + plusCancelationPolicyHours);
                                                        cancelationPolicy.setText("Cancellation made less than " + (cancelationPolicy.getDeadline() + plusCancelationPolicyHours) + " hours (12:00) prior to the arrival will be charged with 100% of the total booking value.");
                                                    } else {
                                                        cancelationPolicy.setText("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                                                    }
                                                    cancelationPolicies.add(cancelationPolicy);



                                                    prebookJSON.setCancelationPolicies(cancelationPolicies);
                                                    ArrayOfCalendarNote5 arrayOfCalendarNote5 = new ArrayOfCalendarNote5();
                                                    prebookJSON.setNotes(arrayOfCalendarNote5);


                                                    if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                                                        gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()), null);
                                                        if (gsaBean != null) {
                                                            if (rate.getNet() != null) {
                                                                if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                                                    BigDecimal gsaSale = new BigDecimal(rate.getNet()).add(new BigDecimal(rate.getNet()).multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP));
                                                                    if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                                                        BigDecimal agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP));
                                                                        MonetaryValue monetaryValue = new MonetaryValue();
                                                                        BigDecimal price=null;
                                                                        price= CurrencyConverter.findExchangeRateAndConvert( hotelBedsDeafultCurrency, params.getCurrencyCode(), Double.parseDouble(agentSale.toString()));
                                                                        if(price!=null)
                                                                            monetaryValue.setValue(price.setScale(2, BigDecimal.ROUND_HALF_UP));
                                                                        else{
                                                                            prebookJSON.setSuccess(false);
                                                                            prebookJSON.setErrorMessageText("Code:32.Couldn't convert currency.");
                                                                            storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON, null, subAgencyBean, result.getPreBookCode(), "HotelBeds");
                                                                            errLogger.info(prebookJSON.getErrorMessageText());
                                                                            return prebookJSON;
                                                                        }
                                                                        monetaryValue.setCurrency(params.getCurrencyCode());
                                                                        prebookJSON.setPrice(monetaryValue);
                                                                        storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON, null, subAgencyBean, result.getPreBookCode(), "HotelBeds");
                                                                    } else {
                                                                        prebookJSON.setSuccess(false);
                                                                        prebookJSON.setErrorMessageText("Code:1.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                                                                        storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON, null, subAgencyBean, result.getPreBookCode(), "HotelBeds");
                                                                        errLogger.info(prebookJSON.getErrorMessageText());
                                                                        return prebookJSON;
                                                                    }
                                                                } else {
                                                                    prebookJSON.setSuccess(false);
                                                                    prebookJSON.setErrorMessageText("Code:2.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                                                                    storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON, null, subAgencyBean, result.getPreBookCode(), "HotelBeds");
                                                                    errLogger.info(prebookJSON.getErrorMessageText());
                                                                    return prebookJSON;
                                                                }
                                                            } else {
                                                                prebookJSON.setSuccess(false);
                                                                prebookJSON.setErrorMessageText("");
                                                                storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON, null, subAgencyBean, result.getPreBookCode(), "HotelBeds");
                                                                return prebookJSON;
                                                            }
                                                        } else {
                                                            prebookJSON.setSuccess(false);
                                                            prebookJSON.setErrorMessageText("Code:3.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                                                            errLogger.info(prebookJSON.getErrorMessageText());
                                                            storePrebookLog(params,availabilityPOST,null, sunHotelsRequest, prebookJSON, null, subAgencyBean, result.getPreBookCode(), "HotelBeds");
                                                            return prebookJSON;
                                                        }
                                                    }


                                                    prebookJSON.setPreBookCode(rate.getRateKey()+"ID:"+hotelBedsProviderId);
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
                                                                        List<CancelationPolicyResponse> cancelationPolicies;
                                                                        CancelationPolicyResponse cancelationPolicy=new CancelationPolicyResponse();
                                                                        cancelationPolicies = new ArrayList<>();

                                                                        if (checkRate.getCancellationPolicies() != null && checkRate.getCancellationPolicies().size()>0) {
                                                                            cancelationPolicy.setDeadline(0);
                                                                            for (CancellationPolicy policy : checkRate.getCancellationPolicies()) {//todo ask about roomtypes codes whichare not comming all
                                                                                //BigDecimal percentange = new BigDecimal((Double.parseDouble(policy.getAmount()) * 100) / Double.parseDouble(rate.getNet())).setScale(0, BigDecimal.ROUND_HALF_UP);
                                                                                //cancelationPolicy.setPercentage(percentange);//todo uncomment this when we add the fuature for more cancelation policies per prebook request

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
                                                                                                cancelationPolicies.add(cancelationPolicy);
                                                                                                break;
                                                                                            } else {
                                                                                                if((int) Duration.between(cancelationDate, checkin).getSeconds() / 60 / 60 > cancelationPolicy.getDeadline())
                                                                                                    cancelationPolicy.setDeadline((int) Duration.between(cancelationDate, checkin).getSeconds() / 60 / 60);
                                                                                            }
                                                                                            cancelationPolicies.add(cancelationPolicy);
                                                                                        } catch (NumberFormatException e) {
                                                                                            e.printStackTrace();
                                                                                        }
                                                                                    } else {
                                                                                        cancelationPolicy.setText("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                                                                                        cancelationPolicy.setDeadline(null);
                                                                                        cancelationPolicy.setPercentage(new BigDecimal(100));
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    cancelationPolicy.setText("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                                                                                    cancelationPolicy.setDeadline(null);
                                                                                    cancelationPolicy.setPercentage(new BigDecimal(100));
                                                                                    break;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            cancelationPolicy.setText("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                                                                            cancelationPolicy.setDeadline(null);
                                                                            cancelationPolicy.setPercentage(new BigDecimal(100));
                                                                        }

                                                                        cancelationPolicy.setPercentage(new BigDecimal(100));//todo delete this when we add the fuature for more cancelation policies per prebook request also change the 100% at text.
                                                                        if (cancelationPolicy.getDeadline() != null) {
                                                                            cancelationPolicy.setDeadline(cancelationPolicy.getDeadline() + plusCancelationPolicyHours);
                                                                            cancelationPolicy.setText("Cancellation made less than " + (cancelationPolicy.getDeadline() + plusCancelationPolicyHours) + " hours (12:00) prior to the arrival will be charged with 100% of the total booking value.");
                                                                        } else {
                                                                            cancelationPolicy.setText("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                                                                        }
                                                                        cancelationPolicies.add(cancelationPolicy);






                                                                        prebookJSON.setCancelationPolicies(cancelationPolicies);
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

                                                                                if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                                                                                    gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()), null);
                                                                                    if (gsaBean != null) {
                                                                                        if (rate.getNet() != null) {
                                                                                            if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                                                                                BigDecimal gsaSale = new BigDecimal(rate.getNet()).add(new BigDecimal(rate.getNet()).multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP));
                                                                                                if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                                                                                    BigDecimal agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP));
                                                                                                    monetaryValue = new MonetaryValue();
                                                                                                    BigDecimal price=null;
                                                                                                    price= CurrencyConverter.findExchangeRateAndConvert( hotelBedsDeafultCurrency, params.getCurrencyCode(), Double.parseDouble(agentSale.toString()));
                                                                                                    if(price!=null)
                                                                                                        monetaryValue.setValue(price.setScale(2, BigDecimal.ROUND_HALF_UP));
                                                                                                    else{
                                                                                                        prebookJSON.setSuccess(false);
                                                                                                        prebookJSON.setErrorMessageText("Code:32.Couldn't convert currency.");
                                                                                                        storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON, null, subAgencyBean, result.getPreBookCode(), "HotelBeds");
                                                                                                        errLogger.info(prebookJSON.getErrorMessageText());
                                                                                                        return prebookJSON;
                                                                                                    }
                                                                                                    monetaryValue.setCurrency(params.getCurrencyCode());
                                                                                                    prebookJSON.setPrice(monetaryValue);
                                                                                                } else {
                                                                                                    prebookJSON.setSuccess(false);
                                                                                                    prebookJSON.setErrorMessageText("Code:1.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                                                                                                    storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON, null, subAgencyBean, result.getPreBookCode(), "HotelBeds");
                                                                                                    errLogger.info(prebookJSON.getErrorMessageText());
                                                                                                    return prebookJSON;
                                                                                                }
                                                                                            } else {
                                                                                                prebookJSON.setSuccess(false);
                                                                                                prebookJSON.setErrorMessageText("Code:2.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                                                                                                storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON, null, subAgencyBean, result.getPreBookCode(), "HotelBeds");
                                                                                                errLogger.info(prebookJSON.getErrorMessageText());
                                                                                                return prebookJSON;
                                                                                            }
                                                                                        } else {
                                                                                            prebookJSON.setSuccess(false);
                                                                                            prebookJSON.setErrorMessageText("");
                                                                                            storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON, null, subAgencyBean, result.getPreBookCode(), "HotelBeds");
                                                                                            return prebookJSON;
                                                                                        }
                                                                                    } else {
                                                                                        prebookJSON.setSuccess(false);
                                                                                        prebookJSON.setErrorMessageText("Code:3.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                                                                                        errLogger.info(prebookJSON.getErrorMessageText());
                                                                                        storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON, null, subAgencyBean, result.getPreBookCode(), "HotelBeds");
                                                                                        return prebookJSON;
                                                                                    }
                                                                                }
                                                                                prebookJSON.setPrice(monetaryValue);
                                                                                prebookJSON.setPreBookCode(checkRate.getRateKey()+"ID:"+hotelBedsProviderId);
                                                                                prebookJSON.setRoomId(String.valueOf(roomtypeBean.getId()));
                                                                                prebookJSON.setSuccess(true);//todo change the provider response from  availabilityAPIJSON to checkRateAPIJSON at storePrebookLog.That way is more correct because some parameters like cancelation policies may changed at cherate stage
                                                                                storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON,null, subAgencyBean, checkRate.getRateKey()+"ID:"+hotelBedsProviderId, "Hotelbeds");
                                                                            }else{
                                                                                prebookJSON.setSuccess(false);
                                                                                prebookJSON.setErrorMessageText("Couldn't make the rate key bookable.");
                                                                                storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON,null, subAgencyBean, "", "Hotelbeds");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }else {
                                                            prebookJSON.setSuccess(false);
                                                            prebookJSON.setErrorMessageText("No data found");
                                                            storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON,null, subAgencyBean, "", "Hotelbeds");
                                                        }
                                                    }else {
                                                        if(checkRateAPIJSON.getError()!=null)
                                                            prebookJSON.setErrorMessageText(checkRateAPIJSON.getError().getMessage());
                                                        else
                                                            prebookJSON.setErrorMessageText("Communication Error");
                                                        prebookJSON.setSuccess(false);
                                                        storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON,null, subAgencyBean, "", "Hotelbeds");
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
                            storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON,null, subAgencyBean, "", "Hotelbeds");
                        }
                    }else {
                        if(availabilityAPIJSON.getError()!=null)
                            prebookJSON.setErrorMessageText(availabilityAPIJSON.getError().getMessage());
                        else
                            prebookJSON.setErrorMessageText("Communication Error");
                        prebookJSON.setSuccess(false);
                        storePrebookLog(params,availabilityPOST,availabilityAPIJSON, "", prebookJSON,null, subAgencyBean, "", "Hotelbeds");
                    }
                }
            } else {
                prebookJSON.setSuccess(false);
                prebookJSON.setErrorMessageText("Code:5.Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                storePrebookLog(params,null,null, "", prebookJSON, null, subAgencyBean, "", "SunHotels/HotelBeds");
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
            storePrebookLog(params,null,null, "", prebookJSON, null, subAgencyBean, "", "SunHotels/Hotelbads");
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
        Beans.HotelBedsAPIBeans.Book.BookAPIJSON bookAPIJSON=null;
        Beans.HotelBedsAPIBeans.Book.BookPost bookPOST=null;
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
                gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()), null);
                if (gsaBean != null) {
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
                    } else{
                        List<BookingsAllBean> booking=BookingsAllDAO.getBookingsAllByPrebookCode(params.getPrebookcode(),subAgencyBean.getId());
                        if(booking!=null && booking.size()>0){
                            bookJSON.setSuccess(false);
                            bookJSON.setErrorMessageText("Prebook code already used");
                            storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "");
                            return bookJSON;
                        }
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
                    Beans.ViatorDBBeans.PrebookLogBean prebook = DAOs.ViatorDBDAOs.PrebookLogDAO.getPrebookLogByRefAndProvider(params.getPrebookcode(), null);
                    if (prebook == null) {
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
                    String originalMealId = "";
                    String id = MealDAO.getOriginalMealId(String.valueOf(params.getMealId()));
                    if (id != null)
                        originalMealId = id;

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
                        int prebooklogId = PrebookLogDAO.storePrebookLog(prebookLogBean);
                        if (prebooklogId == 0) {
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



                        String[] prebookCode = params.getPrebookcode().split("ID:");
                        if (prebookCode == null || prebookCode.length == 0) {
                            bookJSON.setErrorMessageText("");
                            bookJSON.setErrorType("Code 32:Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                            storeBookLog(params, sunHotelsRequest, bookJSON, null, subAgencyBean, "", "SunHotels");
                            errLogger.info(bookJSON.getErrorMessageText());
                            return bookJSON;
                        }else{
                            if(prebookCode[1].equals(String.valueOf(sanHotelsProviderId))){
                                /**
                                 * Case that  Subagency is in Real mode currently.
                                 */
                                bookJSON.setTestBooking(false);
                                BigDecimal agentSale = null;
                                BigDecimal gsaSale = null;

                                int sunHotelsOriginalMealId=0;
                                sunHotelsOriginalMealId= Integer.parseInt(originalMealId);

                                /**
                                 * Book request.
                                 */
                                try {
                                    GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
                                    GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);


                                    XMLGregorianCalendar xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
                                    XMLGregorianCalendar xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
                                    NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
                                    NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();//todo remove email and add atb's fixed email
                                    sunHotelsRequest = subAgencyBean.getCurrency() + "" + "English" + "" +
                                            "george@skamnos.com" + "" + xmlCheckin + "" + xmlCheckout + "" + params.getRoomId() + "" + params.getRooms() + "" +
                                            numOfAdults + "" + numOfChildren + "" + params.getInfant() + "" +
                                            sunHotelsOriginalMealId + "" + adults[0].getFirst_name() + "" + adults[0].getLast_name() + "" + adults[1].getFirst_name() + "" + adults[1].getLast_name() + "" +
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
                                            sunHotelsOriginalMealId, adults[0].getFirst_name(), adults[0].getLast_name(), adults[1].getFirst_name(), adults[1].getLast_name(),
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
                                    int prebookLogId = PrebookLogDAO.storePrebookLog(prebookLogBean);

                                    if (prebookLogId == 0)
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
                                        if (gsaBean != null) {
                                            bookingsAllBean.setGsaMarkup(gsaBean.getOtlMkp());
                                            bookingsAllBean.setTopGsaName(gsaBean.getGsaName());
                                            if (result.getBooking().getPrices().getPrice() != null && result.getBooking().getPrices().getPrice().size() > 0) {
                                                if (gsaBean.getOtlMkp() != null && !gsaBean.getOtlMkp().equals("")) {
                                                    for (PriceWithPaymentMethods price : result.getBooking().getPrices().getPrice()) {
                                                        if (price.getCurrency().equals(subAgencyBean.getCurrency())) {
                                                            gsaSale = price.getValue().add(price.getValue().multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
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

                                    if (gsaSale != null) {
                                        BigDecimal gsaSaleInGsaCur = CurrencyConverter.findExchangeRateAndConvert(subAgencyBean.getCurrency(), gsaBean.getCurrency(), Double.parseDouble(gsaSale.toString()));
                                        if(gsaSaleInGsaCur!=null) {
                                            if (gsaSaleInGsaCur != null) {
                                                gsaBean.setDeposit(BigDecimal.valueOf(Double.parseDouble(gsaBean.getDeposit())).subtract(gsaSaleInGsaCur.setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
                                                if (GsaDAO.updateGsaBean(gsaBean)) {
                                                    errLogger.info("**********Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to detuct the price from gsa deposit at database.*********");
                                                } else {
                                                    /**
                                                     * Store transaction to BookingTransaction table
                                                     */
                                                    BookingTransactionBean bookingTransactionBean = new BookingTransactionBean();
                                                    bookingTransactionBean.setAgentId("");
                                                    bookingTransactionBean.setAgentName("");
                                                    bookingTransactionBean.setBookingId(bookingCode);
                                                    bookingTransactionBean.setGsaId(String.valueOf(gsaBean.getId()));
                                                    bookingTransactionBean.setTransactionType("Charge");
                                                    bookingTransactionBean.setTransCur(gsaBean.getCurrency());
                                                    bookingTransactionBean.setTransNote("");
                                                    bookingTransactionBean.setTransDate(timestamp.toString());
                                                    bookingTransactionBean.setTransRate(gsaSaleInGsaCur.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                                                    bookingTransactionBean.setTransType("Deposit");
                                                    if (BookingTransactionDAO.storeTransaction(bookingTransactionBean)) {
                                                        errLogger.info("Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to store transaction at bookingtransaction table.");
                                                    }
                                                }
                                            } else
                                                errLogger.info("**********Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to detuct the price from gsaBean deposit at database because of currency converting issue.*********");
                                        }else
                                            errLogger.info("**********Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to detuct the price from gsaBean deposit at database because of currency converting issue.*********");
                                    } else
                                        errLogger.info("**********Booking with number :" + result.getBooking().getBookingnumber() + " completed at sunhotels side but failed to detuct the price from gsaBean deposit at database.*********");


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
                                if (result != null && result.getBooking() != null)
                                    storeBookLog(params, sunHotelsRequest, bookJSON, result, subAgencyBean, result.getBooking().getBookingnumber(), "SunHotels");
                                else
                                    storeBookLog(params, sunHotelsRequest, bookJSON, result, subAgencyBean, "", "SunHotels");
                            }else if(prebookCode[1].equals(String.valueOf(hotelBedsProviderId))){
                                if(numOfAdults>0) {
                                    bookPOST = new Beans.HotelBedsAPIBeans.Book.BookPost();
                                    bookPOST.setClientReference("ATB" + System.currentTimeMillis());
                                    Holder holder = new Holder();
                                    holder.setName(adults[0].getFirst_name());
                                    holder.setSurname(adults[0].getLast_name());
                                    bookPOST.setHolder(holder);
                                    List<Beans.HotelBedsAPIBeans.Book.Room> rooms = new ArrayList<>();
                                    Beans.HotelBedsAPIBeans.Book.Room room = new Beans.HotelBedsAPIBeans.Book.Room();
                                    List<Beans.HotelBedsAPIBeans.Book.Pax> paxes = new ArrayList<>();
                                    Beans.HotelBedsAPIBeans.Book.Pax pax;

                                    int paxPerRoom = (numOfAdults + numOfChildren) / params.getRooms();
                                    int roomId = 1;
                                    int paxCount = 0;
                                    for (int k = 0; k < numOfAdults; k++) {
                                        pax = new Beans.HotelBedsAPIBeans.Book.Pax();
                                        pax.setName(adults[k].getFirst_name());
                                        pax.setSurname(adults[k].getLast_name());
                                        pax.setRoomId(roomId);
                                        paxCount++;
                                        if (paxPerRoom == paxCount) {
                                            roomId++;
                                            paxCount = 0;
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
                                        if (paxPerRoom == paxCount) {
                                            roomId++;
                                            paxCount = 0;
                                        }
                                        pax.setType("CH");
                                        paxes.add(pax);
                                    }
                                    room.setRateKey(prebookCode[0]);
                                    room.setPaxes(paxes);//todo check with many pax and check if prebooklog store failed. For all prebook services(frontend,client api)
                                    rooms.add(room);
                                    bookPOST.setRooms(rooms);
                                    bookAPIJSON = BookDAOs.book(bookPOST);
                                    if (bookAPIJSON != null && bookAPIJSON.getError() == null) {



                                        if(bookAPIJSON.getBooking()!=null && bookAPIJSON.getBooking().getHotel()!=null &&
                                                bookAPIJSON.getBooking().getHotel().getRooms()!=null && bookAPIJSON.getBooking().getHotel().getRooms().size()==1) {


                                            int prebookLogId=0;
                                            for (Beans.HotelBedsAPIBeans.Book.Rate checkRate : bookAPIJSON.getBooking().getHotel().getRooms().get(0).getRates()) {


                                                List<StaticPercentageCancellationPolicy> cancelationPolicies;
                                                StaticPercentageCancellationPolicy cancelationPolicy;
                                                cancelationPolicies = new ArrayList<>();
                                                if (checkRate.getCancellationPolicies() != null) {
                                                    for (Beans.HotelBedsAPIBeans.Book.CancelationPolicy policy : checkRate.getCancellationPolicies()) {//todo fix cancelation policies,ask about roomtypes codes whichare not comming all,ask about currency
                                                        BigDecimal percentange = new BigDecimal((Double.parseDouble(policy.getAmount()) * 100) / Double.parseDouble(checkRate.getNet())).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                        cancelationPolicy = new StaticPercentageCancellationPolicy();
                                                        cancelationPolicy.setPercentage(percentange);

                                                        Date date1=null;
                                                        SimpleDateFormat simpleDateFormat;
                                                        GregorianCalendar gregorianCalendar;
                                                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                                                        String[] from= policy.getFrom().split(Pattern.quote("+"));
                                                        if(from!=null && from.length>0)
                                                            date1 = simpleDateFormat.parse(from[0]);
                                                        gregorianCalendar = (GregorianCalendar)GregorianCalendar.getInstance();
                                                        gregorianCalendar.setTime(date1);
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

                                                List<Note> hotelnotes = new ArrayList<>();
                                                Note hotelnote;
                                                if (checkRate.getRateComments() != null ) {
                                                        hotelnote = new Note();
                                                        hotelnote.setEndDate(null);
                                                        hotelnote.setStartDate(null);
                                                        hotelnote.setText(checkRate.getRateComments());
                                                        hotelnotes.add(hotelnote);
                                                }
                                                bookResult.setHotelNotes(hotelnotes);
                                                List<Note> roomnotes = new ArrayList<>();
                                                Note roomnote;
                                                bookResult.setRoomNotes(roomnotes);



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
                                                    prebookLogBean.setNotes(mapper.writeValueAsString(hotelnotes));
                                                } catch (JsonProcessingException e) {
                                                    errLogger.info("Booking with number :" +bookAPIJSON.getBooking().getReference()+ " completed at hotelbeds side but failed to store correctly to databse(HotelNotes)");
                                                }

                                                List<CancelationPolicyResponse> cancelationPoliciesResponse = new ArrayList<>();
                                                CancelationPolicyResponse cancelationPolicyResponse = new CancelationPolicyResponse();
                                                if (cancelationPolicies != null && cancelationPolicies.size() > 0) {
                                                    StaticPercentageCancellationPolicy atbPolicy = new StaticPercentageCancellationPolicy();
                                                    atbPolicy.setDeadline(0);
                                                    for (StaticPercentageCancellationPolicy policy : cancelationPolicies) {
                                                        if (policy.getDeadline() == null) {
                                                            atbPolicy = policy;
                                                            break;
                                                        }
                                                        if (policy.getDeadline() > atbPolicy.getDeadline())
                                                            atbPolicy = policy;
                                                    }
                                                    prebookLogBean.setPercentage("100");
                                                    if(atbPolicy.getText()!=null)
                                                        prebookLogBean.setCancelPolicy(atbPolicy.getText());
                                                    else
                                                        prebookLogBean.setCancelPolicy("");
                                                    cancelationPolicyResponse.setPercentage(new BigDecimal(100));
                                                    if (atbPolicy.getDeadline() != null) {
                                                        prebookLogBean.setAtbCancelPolicy("Cancellation made less than " + (atbPolicy.getDeadline() + plusCancelationPolicyHours) + " hours (12:00) prior to the arrival will be charged with 100% of the total booking value.");
                                                        prebookLogBean.setDeadline(String.valueOf(atbPolicy.getDeadline() + plusCancelationPolicyHours));
                                                        cancelationPolicyResponse.setDeadline(atbPolicy.getDeadline() + plusCancelationPolicyHours);
                                                        cancelationPolicyResponse.setText("Cancellation made less than " + (atbPolicy.getDeadline() + plusCancelationPolicyHours) + " hours (12:00) prior to the arrival will be charged with 100% of the total booking value.");

                                                    } else {
                                                        prebookLogBean.setAtbCancelPolicy("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                                                        prebookLogBean.setDeadline("null");
                                                        cancelationPolicyResponse.setText("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                                                        cancelationPolicyResponse.setDeadline(null);
                                                    }
                                                } else {
                                                    prebookLogBean.setAtbCancelPolicy("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                                                    prebookLogBean.setDeadline("null");
                                                    prebookLogBean.setPercentage("100");
                                                    cancelationPolicyResponse.setText("Please note that this room is non-refundable. If the booking is cancelled, no money will be refunded.");
                                                    cancelationPolicyResponse.setDeadline(null);
                                                    cancelationPolicyResponse.setPercentage(new BigDecimal(100));
                                                }
                                                cancelationPoliciesResponse.add(cancelationPolicyResponse);
                                                bookResult.setCancellationpolicies(cancelationPoliciesResponse);
                                                prebookLogId = PrebookLogDAO.storePrebookLog(prebookLogBean);

                                                break;

                                            }

                                            /**
                                             * Store Booking Results to Hotel_Bookings_All table
                                             */
                                            String bookingCode = "HTL-API-" + bookAPIJSON.getBooking().getReference() + "-0";
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
                                            bookingsAllBean.setCommon13("");
                                            bookingsAllBean.setCommon6(String.valueOf(prebookLogId));
                                            bookingsAllBean.setCommon8("");
                                            bookingsAllBean.setCommon9(params.getPrebookcode());
                                            bookingsAllBean.setCommon10(bookAPIJSON.getBooking().getReference());
                                            bookingsAllBean.setCommon11("");//todo
                                            bookingsAllBean.setCommon15(String.valueOf(params.getMealId()));
                                            bookingsAllBean.setInvoiceAmount("");
                                            bookingsAllBean.setInvoiceNo("");
                                            bookingsAllBean.setInvoiceStatus("");
                                            bookingsAllBean.setBasis("");//todo
                                            bookingsAllBean.setUpdater("XML-API");
                                            bookingsAllBean.setPaying("agent");
                                            bookingsAllBean.setBookingId(bookingCode);//todo
                                            bookingsAllBean.setSupplierReferences("");//todo
                                            bookingsAllBean.setSupplierName("HOTELBEDS");//todo
                                            bookingsAllBean.setSupplierId("1771");//todo
                                            bookingsAllBean.setPriceId(String.valueOf(bookAPIJSON.getBooking().getHotel().getRooms().size()));
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

                                            PrebookPOST prebookPOST = mapper.readValue(prebook.getClientRequest(), PrebookPOST.class);
                                            if(prebookPOST!=null){
                                                String orealId=MealDAO.getOriginalMealId(String.valueOf(prebookPOST.getMealId()));
                                                if(orealId!=null) {
                                                    MealBean meal = MealDAO.getMealByMealId(orealId, hotelBedsProviderId, null);
                                                    if (meal != null)
                                                        bookResult.setMeal(meal.getName());
                                                }
                                                bookResult.setMealId(prebookPOST.getMealId());
                                                String originalRoomTypeId=RoomtypeDAO.getOriginalRoomtypeId(prebookPOST.getRoomTypeId());
                                                if(originalRoomTypeId!=null) {
                                                    RoomtypeBean roomtypeBean = RoomtypeDAO.getRoomsTypesbyId(originalRoomTypeId, hotelBedsProviderId, null);
                                                    if(roomtypeBean!=null) {
                                                        bookResult.setRoomType(roomtypeBean.getRoomType());
                                                        bookingsAllBean.setCommon13(roomtypeBean.getRoomType());
                                                    }
                                                }
                                            }else{
                                                bookResult.setMeal("");
                                                bookResult.setMealId(0);
                                                bookResult.setRoomType("");
                                            }

                                            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                                            java.util.Date date = sdf1.parse(bookAPIJSON.getBooking().getHotel().getCheckIn());
                                            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
                                            bookingsAllBean.setCheckIn(sqlStartDate);
                                            date = sdf1.parse(bookAPIJSON.getBooking().getHotel().getCheckOut());
                                            sqlStartDate = new java.sql.Date(date.getTime());
                                            bookingsAllBean.setCheckOut(sqlStartDate);
                                            date = sdf1.parse(bookAPIJSON.getBooking().getCreationDate());
                                            Timestamp timestamp = new Timestamp(date.getTime());
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
                                                    bookingsAllBean.setCommon13("");
                                                    bookingsAllBean.setCommon7(hotelsbean.get(0).getAddress());
                                                    bookingsAllBean.setCityName(hotelsbean.get(0).getCity());
                                                    bookingsAllBean.setProductTitle(hotelsbean.get(0).getName());
                                                    bookingsAllBean.setCountryName(hotelsbean.get(0).getCountry());
                                                    bookingsAllBean.setProductId(String.valueOf(HotelmappingDAO.getOriginalHotelId(Integer.parseInt(params.getHotelId()), null)));
                                                    bookResult.setHotelAddress(hotelsbean.get(0).getAddress());
                                                    bookResult.setHotelId(Integer.parseInt(params.getHotelId()));
                                                    bookResult.setHotelName(hotelsbean.get(0).getName());
                                                    bookResult.setHotelPhone("");
                                                } else {
                                                    errLogger.info("Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but failed to store correctly to databse");
                                                }
                                            } else {
                                                errLogger.info("Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds  side but failed to store correctly to databse");
                                            }

                                            BigDecimal gsaSale=null;
                                            BigDecimal agentSale=null;
                                            if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                                                bookingsAllBean.setGsaId(subAgencyBean.getGsaId());
                                                if (gsaBean != null) {
                                                    bookingsAllBean.setGsaMarkup(gsaBean.getOtlMkp());
                                                    bookingsAllBean.setTopGsaName(gsaBean.getGsaName());
                                                        if (gsaBean.getOtlMkp() != null && !gsaBean.getOtlMkp().equals("")) {

                                                            BigDecimal convertedPrice = CurrencyConverter.findExchangeRateAndConvert(bookAPIJSON.getBooking().getCurrency(), subAgencyBean.getCurrency(), bookAPIJSON.getBooking().getTotalNet());
                                                            if (convertedPrice!=null) {
                                                                    gsaSale = convertedPrice.add(convertedPrice.multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                                    bookingsAllBean.setGsaSale(String.valueOf(gsaSale));
                                                                    if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                                                        bookingsAllBean.setAgentMarkup(subAgencyBean.getOtlMkp());
                                                                        bookingsAllBean.setAgentName(subAgencyBean.getAgentName());
                                                                        agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                                        bookingsAllBean.setAgentSale(String.valueOf(agentSale));
                                                                        bookingsAllBean.setAgentEndSale(String.valueOf(agentSale));
                                                                        bookingsAllBean.setSupplierSale((gsaSale.multiply(new BigDecimal(100))).divide(new BigDecimal(Integer.parseInt(gsaBean.getOtlMkp()) + 100), 2, RoundingMode.HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                                                                    } else {
                                                                        errLogger.info("Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but sub agency with id:" + subAgencyBean.getId() + " has not hotel mark up");
                                                                    }
                                                            } else {
                                                                errLogger.info("Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but failed to store correctly to databse");
                                                            }
                                                        } else {
                                                            errLogger.info("Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but failed to store correctly to databse");
                                                        }
                                                } else {
                                                    errLogger.info("Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but failed to store correctly to databse");
                                                }
                                            } else {
                                                errLogger.info("Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but failed to store correctly to databse");
                                            }

                                            Integer bookingId = BookingsAllDAO.storeBooking(bookingsAllBean);
                                            if (bookingId == 0)
                                                errLogger.info("Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but failed to store correctly to databse");


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
                                                    errLogger.info("**********Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but failed to detuct the price from sub agency deposit at database.*********");
                                                } else {
                                                    /**
                                                     * Store transaction to BookingTransaction table
                                                     */
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
                                                        errLogger.info("Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but failed to store transaction at bookingtransaction table.");
                                                    }
                                                }


                                            } else
                                                errLogger.info("**********Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but failed to detuct the price from sub agency deposit at database.*********");

                                            if (gsaSale != null) {
                                                BigDecimal gsaSaleInGsaCur = CurrencyConverter.findExchangeRateAndConvert(subAgencyBean.getCurrency(), gsaBean.getCurrency(), Double.parseDouble(gsaSale.toString()));
                                                if(gsaSaleInGsaCur!=null) {
                                                    if (gsaSaleInGsaCur != null) {
                                                        gsaBean.setDeposit(BigDecimal.valueOf(Double.parseDouble(gsaBean.getDeposit())).subtract(gsaSaleInGsaCur.setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
                                                        if (GsaDAO.updateGsaBean(gsaBean)) {
                                                            errLogger.info("**********Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but failed to detuct the price from gsa deposit at database.*********");
                                                        } else {
                                                            /**
                                                             * Store transaction to BookingTransaction table
                                                             */
                                                            BookingTransactionBean bookingTransactionBean = new BookingTransactionBean();
                                                            bookingTransactionBean.setAgentId("");
                                                            bookingTransactionBean.setAgentName("");
                                                            bookingTransactionBean.setBookingId(bookingCode);
                                                            bookingTransactionBean.setGsaId(String.valueOf(gsaBean.getId()));
                                                            bookingTransactionBean.setTransactionType("Charge");
                                                            bookingTransactionBean.setTransCur(gsaBean.getCurrency());
                                                            bookingTransactionBean.setTransNote("");
                                                            bookingTransactionBean.setTransDate(timestamp.toString());
                                                            bookingTransactionBean.setTransRate(gsaSaleInGsaCur.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                                                            bookingTransactionBean.setTransType("Deposit");
                                                            if (BookingTransactionDAO.storeTransaction(bookingTransactionBean)) {
                                                                errLogger.info("Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but failed to store transaction at bookingtransaction table.");
                                                            }
                                                        }
                                                    } else
                                                        errLogger.info("**********Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but failed to detuct the price from gsaBean deposit at database because of currency converting issue.*********");
                                                }else
                                                    errLogger.info("**********Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but failed to detuct the price from gsaBean deposit at database because of currency converting issue.*********");
                                            } else
                                                errLogger.info("**********Booking with number :" + bookAPIJSON.getBooking().getReference() + " completed at hotelbeds side but failed to detuct the price from gsaBean deposit at database.*********");

                                            /**
                                             * Prepare response
                                             */


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
                                                bookResult.setBookingdate(currentDateTime);
                                                bookResult.setCheckindate(xmlCheckin);
                                                bookResult.setCheckoutdate(xmlCheckout);
                                            } catch (DatatypeConfigurationException e) {
                                                bookResult.setBookingdate(null);
                                                bookResult.setCheckindate(null);
                                                bookResult.setCheckoutdate(null);
                                            }
                                            bookResult.setBookingdateTimezone(null);
                                            bookResult.setBookingnumber(String.valueOf(bookingId));
                                            bookResult.setCurrency(bookAPIJSON.getBooking().getCurrency());
                                            bookResult.setEarliestNonFreeCancellationDateUTC(null);//todo
                                            bookResult.setInvoiceref("");
                                            bookResult.setNumberofrooms(String.valueOf(bookAPIJSON.getBooking().getHotel().getRooms().size()));
                                            bookResult.setPrice(agentSale);
                                            bookResult.setPaymentmethod("Deposit");
                                            bookResult.setBookingStatus("Active");
                                            bookResult.setTravellerInfo(travellers);
                                            bookResult.setVoucher("");
                                            //todo fix booklog storring for hotelbeds
                                            bookJSON.setBookResult(bookResult);
                                            bookJSON.setSuccess(true);

                                        }
                                    }else{
                                        if(bookAPIJSON!=null && bookAPIJSON.getError()!=null) {
                                            bookJSON.setErrorMessageText(bookAPIJSON.getError().getCode()+" "+bookAPIJSON.getError().getMessage());
                                            bookJSON.setSuccess(false);
                                            bookJSON.setErrorType(bookAPIJSON.getError().getMessage());
                                        }else{
                                            bookJSON.setErrorMessageText("Communication Error");
                                            bookJSON.setSuccess(false);
                                            bookJSON.setErrorType("");
                                        }
                                    }
                                }
                                if (bookAPIJSON != null && bookAPIJSON.getBooking() != null)
                                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "HotelBeds");
                                else
                                    storeBookLog(params, sunHotelsRequest, bookJSON, null, subAgencyBean, "", "HotelBeds");
                            }
                        }
                    }
                } else {
                    bookJSON.setSuccess(false);
                    bookJSON.setErrorType("Internal Error");
                    errLogger.info(bookJSON.getErrorMessageText());
                    bookJSON.setErrorMessageText("Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                    storeBookLog(params, "", bookJSON, null, subAgencyBean, "", "SunHotels");
                }
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
