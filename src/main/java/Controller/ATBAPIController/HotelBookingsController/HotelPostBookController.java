package Controller.ATBAPIController.HotelBookingsController;

import APIJSONs.ATBAPIJSONs.Hotel.*;
import APIJSONs.ATBAPIJSONs.Hotel.BookResult;
import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.CancelationPolicyResponse;
import Beans.ATBDBBeans.KalitaonHotel.MealBean;
import Beans.ATBDBBeans.KalitaonLog.PrebookLogBean;
import Beans.ATBDBBeans.KalitaonSystem.*;
import Controller.Application;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.MealDAO;
import DAOs.ATBDBDAOs.KalitaonLogDAOs.PrebookLogDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.*;
import DAOs.SunHotelsAPIDAOs.*;
import Helper.CurrencyConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.sanHotelsProviderId;
import static Helper.ProjectProperties.sunhotelsUsername;
import static Helper.ProjectProperties.sunhotelspass;

/**
 * Created by George on 03/02/2018.
 */
@RestController
public class HotelPostBookController {

    @RequestMapping("/hotel/booking/bookingInfo")
    public BookInfoJSON hotelBookingInfo(@RequestParam(value="bookingNumber", defaultValue="0") int bookingNumber,
                                         @RequestParam(value="dateFrom", defaultValue="") String dateFrom,
                                         @RequestParam(value="dateTo", defaultValue="") String dateTo,
                                         @RequestParam(value = "currencyCode", defaultValue = "") String currencyCode,
                                         @RequestParam("apiKey") String apiKey) {

        Application.agent.increment("app.web.request.api.hotel.bookingInfo");
        BookInfoJSON bookInfoJSON=new BookInfoJSON();
        List<BookResult> bookings=new ArrayList<>();
        try {
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            bookInfoJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
            SubAgencyBean subAgencyBean;
            String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + apiKey;
            String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
            subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);


            if (subAgencyBean != null) {
                BookResult bookResult;
                List<BookingsAllBean> bookingsBeans = new ArrayList<>();
                BookingsAllBean bookingsAllBean;


                if (!currencyCode.equals("")) {
                    if (CurrencyConverter.findExchangeRateAndConvert("EUR", currencyCode, new Double(1)) == null) {
                        bookInfoJSON.setSuccess(false);
                        bookInfoJSON.setErrorMessageText("Wrong currrency code");
                        return bookInfoJSON;
                    }
                }

                if (bookingNumber != 0) {
                    bookingsAllBean = BookingsAllDAO.getBookingsAllBeanById(bookingNumber, subAgencyBean.getId());
                    if (bookingsAllBean != null)
                        bookingsBeans.add(bookingsAllBean);
                } else if (!dateFrom.equals("") && !dateTo.equals("")) {
                    ZonedDateTime checkin = null;
                    ZonedDateTime checkout = null;
                    String checkIndate[] = dateFrom.split("-");
                    String checkOutdate[] = dateTo.split("-");
                    if (checkIndate.length == 3 && checkOutdate.length == 3) {
                        try {
                            checkin = ZonedDateTime.of(LocalDate.of(Integer.parseInt(checkIndate[0]), Integer.parseInt(checkIndate[1]), Integer.parseInt(checkIndate[2])),
                                    LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                            checkout = ZonedDateTime.of(LocalDate.of(Integer.parseInt(checkOutdate[0]), Integer.parseInt(checkOutdate[1]), Integer.parseInt(checkOutdate[2])),
                                    LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                        } catch (NumberFormatException e) {
                        }
                    }
                    bookingsBeans = BookingsAllDAO.getAllHotelBookingsByDate(checkin, checkout, subAgencyBean.getId());
                } else {
                    bookInfoJSON.setSuccess(false);
                    bookInfoJSON.setErrorType("Missing Parameters");
                    bookInfoJSON.setErrorMessageText("Please Specify BookingNumber or Dates");
                    return bookInfoJSON;
                }


                if (bookingsBeans != null && bookingsBeans.size() > 0) {

                    for (BookingsAllBean booking : bookingsBeans) {
                        PrebookLogBean prebookLogBean = null;
                        if (booking.getCommon9() != null && !booking.getCommon9().equals(""))
                            prebookLogBean = PrebookLogDAO.getPrebooklogBeanByPrebookRef(booking.getCommon6(),booking.getCommon9());
                        List<TravellerInfoBean> travellersInfoBean;
                        travellersInfoBean = TravellerInfoDAO.getTravellerInfoBeanByBookingId(booking.getBookingId());

                        if (prebookLogBean != null && travellersInfoBean != null) {

                            bookResult = new BookResult();
                            XMLGregorianCalendar xmlCheckin = null;
                            XMLGregorianCalendar xmlCheckout = null;
                            XMLGregorianCalendar currentDateTime = null;
                            try {
                                GregorianCalendar gregorianCheckin = new GregorianCalendar();
                                gregorianCheckin.setTime(booking.getCheckIn());
                                GregorianCalendar gregorianCheckout = new GregorianCalendar();
                                gregorianCheckout.setTime(booking.getCheckOut());
                                GregorianCalendar gregorianCurrentDateTime = new GregorianCalendar();
                                xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
                                xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
                                currentDateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCurrentDateTime);
                            } catch (DatatypeConfigurationException e) {
                                bookInfoJSON.setSuccess(false);
                                bookInfoJSON.setErrorMessageText("Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                                bookInfoJSON.setErrorType("Internal Error");
                                return bookInfoJSON;
                            }
                            bookResult.setBookingdate(currentDateTime);
                            bookResult.setBookingdateTimezone("UTC");
                            bookResult.setBookingnumber(String.valueOf(booking.getId()));
                            bookResult.setInvoiceref("");
                            List<MealBean> meals = MealDAO.getMeals(sanHotelsProviderId);
                            if (meals != null) {
                                for (MealBean meal : MealDAO.getMeals(sanHotelsProviderId)) {
                                    if (meal.getId() == Integer.parseInt(booking.getCommon15())) {
                                        bookResult.setMeal(meal.getName());
                                    }
                                }
                            } else
                                bookResult.setMeal("");
                            bookResult.setMealId(Integer.parseInt(booking.getCommon15()));
                            bookResult.setNumberofrooms(booking.getPriceId());
                            bookResult.setRoomType("");//todo
                            bookResult.setCheckindate(xmlCheckin);
                            bookResult.setCheckoutdate(xmlCheckout);
                            bookResult.setPaymentmethod("Deposit");
                            bookResult.setErrorMessage(null);
                            bookResult.setErrorMessage(null);
                            bookResult.setErrorAttributes(null);
                            bookResult.setHotelPhone(booking.getCommon8());
                            bookResult.setHotelId(Integer.parseInt(booking.getProductId()));
                            bookResult.setHotelName(booking.getProductTitle());
                            bookResult.setHotelAddress(booking.getCommon7());
                            if (booking.getStatus().equals("4"))
                                bookResult.setBookingStatus("Active");
                            else if (booking.getStatus().equals("7"))
                                bookResult.setBookingStatus("Active(Test Booking)");
                            else if (booking.getStatus().equals("3"))
                                bookResult.setBookingStatus("Cancelled");

                            /**
                             * Currency conversion
                             */
                            if (!currencyCode.equals("") && booking.getAgentEndSaleCur() != null && booking.getAgentSale() != null) {
                                BigDecimal convertedPrice = CurrencyConverter.findExchangeRateAndConvert(booking.getAgentEndSaleCur(), currencyCode, Double.parseDouble(booking.getAgentSale()));
                                if (convertedPrice != null) {
                                    convertedPrice = convertedPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    bookResult.setPrice(convertedPrice);
                                    bookResult.setCurrency(currencyCode);
                                } else {
                                    bookResult.setPrice(new BigDecimal(Double.parseDouble(booking.getAgentSale())).setScale(2, BigDecimal.ROUND_HALF_UP));
                                    bookResult.setCurrency(booking.getAgentEndSaleCur());
                                }
                            } else {
                                bookResult.setPrice(new BigDecimal(Double.parseDouble(booking.getAgentSale())).setScale(2, BigDecimal.ROUND_HALF_UP));
                                bookResult.setCurrency(booking.getAgentEndSaleCur());
                            }


                            List<CancelationPolicyResponse> cancelationPolicies = new ArrayList();
                            CancelationPolicyResponse cancelationPolicy = new CancelationPolicyResponse();
                            if (prebookLogBean.getDeadline() != null && !prebookLogBean.getDeadline().equals("null"))
                                cancelationPolicy.setDeadline(Integer.parseInt(prebookLogBean.getDeadline()));
                            else
                                cancelationPolicy.setDeadline(null);
                            cancelationPolicy.setText(prebookLogBean.getAtbCancelPolicy());
                            cancelationPolicy.setPercentage(new BigDecimal(Double.parseDouble(prebookLogBean.getPercentage())));
                            cancelationPolicies.add(cancelationPolicy);
                            bookResult.setCancellationpolicies(cancelationPolicies);
                            bookResult.setTravellerInfo(travellersInfoBean);
                            // bookResult.setVoucher();//todo
                            // bookResult.setEarliestNonFreeCancellationDateUTC("");


                            if (prebookLogBean.getNotes() != null && !prebookLogBean.getNotes().equals("")) {
                                ObjectMapper mapper = new ObjectMapper();
                                try {
                                    ArrayOfCalendarNote1 arrayOfCalendarNote1 = mapper.readValue(prebookLogBean.getNotes(), ArrayOfCalendarNote1.class);
                                    List<Note> hotelNotes = new ArrayList<>();
                                    Note hotelNote;
                                    for (CalendarNote note : arrayOfCalendarNote1.getHotelNote()) {
                                        hotelNote = new Note();
                                        hotelNote.setEndDate(note.getEndDate());
                                        hotelNote.setStartDate(note.getStartDate());
                                        hotelNote.setText(note.getText());
                                        hotelNotes.add(hotelNote);
                                    }
                                    bookResult.setHotelNotes(hotelNotes);
                                } catch (IOException e) {
                                }
                            }

                            bookings.add(bookResult);
                        }
                    }
                }
            } else {
                bookInfoJSON.setSuccess(false);
                bookInfoJSON.setErrorType("Internal Error");
                bookInfoJSON.setErrorMessageText("Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                return bookInfoJSON;
            }
            bookInfoJSON.setTotalCount(bookings.size());
            bookInfoJSON.setBookingInfo(bookings);
            bookInfoJSON.setSuccess(true);
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            bookInfoJSON.setSuccess(false);
            bookInfoJSON.setErrorMessageText(errors.toString());
        }
        return bookInfoJSON;
    }


    @RequestMapping("/hotel/booking/cancelBooking")
    public CancelJSON cancelBooking(@RequestParam(value="bookingNumber", defaultValue="0") int bookingId,
                                    @RequestParam("apiKey") String apiKey) {

        Application.agent.increment("app.web.request.api.hotel.cancelBooking");
        CancelJSON cancelJSON=new CancelJSON();
        CancellResult cancellResult= new CancellResult();
        cancellResult.setCancellationSucceed(false);
        try {
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            cancelJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
            SubAgencyBean subAgencyBean;
            String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + apiKey;
            String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
            subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);


            if (subAgencyBean != null) {
                GsaBean gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()), null);
                if(gsaBean!=null) {
                    BookingsAllBean booking = BookingsAllDAO.getBookingsAllBeanById(bookingId, subAgencyBean.getId());
                    if (booking != null) {

                        PrebookLogBean prebook = PrebookLogDAO.getPrebooklogBeanByPrebookRef(booking.getCommon6(), booking.getCommon9());
                        if (prebook != null) {


                            DateTime deadlineDate;
                            if (prebook.getDeadline().equals("null"))
                                deadlineDate = null;
                            else {
                                long i = booking.getCheckIn().getTime() - (Integer.parseInt(prebook.getDeadline() + 24) * 60 * 60 * 1000);//todo
                                deadlineDate = new DateTime(i);//todo see what we ll do with multiple cancelation policies
                            }

                            if (booking.getStatus().equals("4")) {

                                if (deadlineDate == null || dateTime.compareTo(deadlineDate) < 0) {

                                    CancellationResult result = null;
                                    try {
                                        NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
                                        NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();
                                        result = nonStaticXMLAPISoap.cancelBooking(sunhotelsUsername, sunhotelspass, booking.getCommon10(), "English");
                                    } catch (NullPointerException e) {
                                    }

                                    if (result != null) {
                                        if (result.getError() != null) {
                                            cancellResult.setCancellationSucceed(false);
                                            cancellResult.setCancellationNote("Cancelation couldn't completed.");
                                            cancelJSON.setCancellationResult(cancellResult);
                                            cancelJSON.setErrorMessageText(result.getError().getMessage());
                                            cancelJSON.setSuccess(false);
                                            return cancelJSON;
                                        } else {
                                            if (result.getCode() == 1) {

                                                cancellResult.setCancellationSucceed(true);
                                                cancellResult.setRefund(new BigDecimal((Double.parseDouble(booking.getAgentSale()) * Double.parseDouble(prebook.getPercentage()) / 100)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                                booking.setStatus("3");
                                                if (BookingsAllDAO.updateBooking(booking)) {
                                                    errLogger.info("Booking with Id :" + booking.getId() + " cancelled at sunhotels side but failed to update bookingsall table.");
                                                }


                                                subAgencyBean.setDeposit(String.valueOf(new BigDecimal(Double.parseDouble(subAgencyBean.getDeposit())).
                                                        add(new BigDecimal((Double.parseDouble(booking.getAgentSale()) * Double.parseDouble(prebook.getPercentage()) / 100))).
                                                        setScale(2, BigDecimal.ROUND_HALF_UP)));
                                                if (!SubAgencyDAO.updateSubAgentByName(subAgencyBean)) {
                                                    BookingTransactionBean bookingTransactionBean = new BookingTransactionBean();
                                                    bookingTransactionBean.setAgentId(String.valueOf(subAgencyBean.getId()));
                                                    bookingTransactionBean.setAgentName(subAgencyBean.getAgentName());
                                                    bookingTransactionBean.setBookingId(booking.getBookingId());
                                                    bookingTransactionBean.setGsaId(subAgencyBean.getGsaId());
                                                    bookingTransactionBean.setTransactionType("Refund");
                                                    bookingTransactionBean.setTransCur(subAgencyBean.getCurrency());
                                                    bookingTransactionBean.setTransDate(dateTime.toString());
                                                    bookingTransactionBean.setTransRate(String.valueOf(new BigDecimal((Double.parseDouble(booking.getAgentSale()) * Double.parseDouble(prebook.getPercentage()) / 100)).setScale(2, BigDecimal.ROUND_HALF_UP)));
                                                    bookingTransactionBean.setTransType("Deposit");
                                                    bookingTransactionBean.setTransNote("");

                                                    if (BookingTransactionDAO.storeTransaction(bookingTransactionBean)) {
                                                        errLogger.info("Booking with Id :" + booking.getId() + " cancelled at sunhotels side but failed to store subagency transaction at BookingTransaction table.");
                                                    }
                                                } else {
                                                    errLogger.info("Booking with Id :" + booking.getId() + " cancelled at sunhotels side but failed to refund the price at subagency table.");
                                                }


                                                BigDecimal gsaSaleInGsaCur=CurrencyConverter.findExchangeRateAndConvert(booking.getSaleCurrency(), gsaBean.getCurrency(), Double.parseDouble(booking.getGsaSale().toString()));
                                                if(gsaSaleInGsaCur!=null) {
                                                    gsaBean.setDeposit(String.valueOf(new BigDecimal(Double.parseDouble(gsaBean.getDeposit())).
                                                            add(new BigDecimal((Double.parseDouble(gsaSaleInGsaCur.setScale(2, BigDecimal.ROUND_HALF_UP).toString()) * Double.parseDouble(prebook.getPercentage()) / 100))).
                                                            setScale(2, BigDecimal.ROUND_HALF_UP)));
                                                    if (!GsaDAO.updateGsaBean(gsaBean)) {
                                                        BookingTransactionBean bookingTransactionBean = new BookingTransactionBean();
                                                        bookingTransactionBean.setAgentId("");
                                                        bookingTransactionBean.setAgentName("");
                                                        bookingTransactionBean.setBookingId(booking.getBookingId());
                                                        bookingTransactionBean.setGsaId(String.valueOf(gsaBean.getId()));
                                                        bookingTransactionBean.setTransactionType("Refund");
                                                        bookingTransactionBean.setTransCur(gsaBean.getCurrency());
                                                        bookingTransactionBean.setTransDate(dateTime.toString());
                                                        bookingTransactionBean.setTransRate(String.valueOf(new BigDecimal((Double.parseDouble(gsaSaleInGsaCur.setScale(2, BigDecimal.ROUND_HALF_UP).toString()) * Double.parseDouble(prebook.getPercentage()) / 100)).setScale(2, BigDecimal.ROUND_HALF_UP)));
                                                        bookingTransactionBean.setTransType("Deposit");
                                                        bookingTransactionBean.setTransNote("");

                                                        if (BookingTransactionDAO.storeTransaction(bookingTransactionBean)) {
                                                            errLogger.info("Booking with Id :" + booking.getId() + " cancelled at sunhotels side but failed to store gsa transaction at BookingTransaction table.");
                                                        }
                                                    } else {
                                                        errLogger.info("Booking with Id :" + booking.getId() + " cancelled at sunhotels side but failed to refund the price at gsa table.");
                                                    }
                                                }else{
                                                    errLogger.info("Booking with Id :" + booking.getId() + " cancelled at sunhotels side but failed to refund the price at gsa table.");
                                                }
                                            } else {
                                                cancellResult.setCancellationSucceed(false);
                                                cancellResult.setCancellationNote("Cancelation couldn't completed.Please contact at:george.nafpaktitis@atbholidays.com");
                                                cancelJSON.setCancellationResult(cancellResult);
                                                cancelJSON.setSuccess(true);
                                                return cancelJSON;
                                            }

                                        }
                                    } else {
                                        cancellResult.setCancellationSucceed(false);
                                        cancellResult.setCancellationNote("Cancelation couldn't completed.");
                                        cancelJSON.setCancellationResult(cancellResult);
                                        cancelJSON.setSuccess(false);
                                        cancelJSON.setErrorMessageText("Communication error");
                                        return cancelJSON;
                                    }
                                } else {
                                    cancellResult.setCancellationSucceed(false);
                                    cancellResult.setCancellationNote("The booking could not be cancelled due to the cancellation deadline having expired.");
                                }
                            } else if (booking.getStatus().equals("7")) {
                                booking.setStatus("3");
                                if (!BookingsAllDAO.updateBooking(booking)) {
                                    cancellResult.setCancellationSucceed(true);
                                }
                            } else {
                                cancellResult.setCancellationNote("This booking isn't active");
                                cancellResult.setCancellationSucceed(false);
                                cancelJSON.setCancellationResult(cancellResult);
                                cancelJSON.setSuccess(true);
                                return cancelJSON;
                            }

                        } else {
                            cancelJSON.setSuccess(false);
                            cancelJSON.setErrorMessageText("Internal error.Couldn't extract essential data.");
                            return cancelJSON;
                        }
                    } else {
                        cancelJSON.setSuccess(false);
                        cancelJSON.setErrorMessageText("Internal error.Couldn't extract essential data or bookingId doesn't exists.");
                        return cancelJSON;
                    }
                }else{
                    cancelJSON.setSuccess(false);
                    cancelJSON.setErrorMessageText("Internal error.Couldn't extract essential data.");
                    return cancelJSON;
                }
            } else {
                cancelJSON.setSuccess(false);
                cancelJSON.setErrorMessageText("Internal error.Couldn't extract essential data.");
                return cancelJSON;
            }

            cancelJSON.setCancellationResult(cancellResult);
            cancelJSON.setSuccess(true);
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            cancelJSON.setSuccess(false);
            cancelJSON.setErrorMessageText(errors.toString());
        }
        return cancelJSON;

    }


}
