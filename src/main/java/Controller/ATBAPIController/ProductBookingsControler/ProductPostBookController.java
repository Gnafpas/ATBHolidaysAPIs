package Controller.ATBAPIController.ProductBookingsControler;

import APIJSONs.ATBAPIJSONs.Product.*;
import Beans.ATBDBBeans.KalitaonProduct.BProductDetailBean;
import Beans.ATBDBBeans.KalitaonSystem.*;
import Beans.ViatorAPIBeans.Bookings.Cancel.CancelAPIJSON;
import Beans.ViatorAPIBeans.Bookings.Cancel.CancelItem;
import Beans.ViatorAPIBeans.Bookings.Cancel.CancelPOST;
import Controller.Application;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.BProductDetailDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.*;
import DAOs.ViatorAPIDAOs.BookingsAPIDAO;
import Helper.CurrencyConverter;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 02/03/2018.
 */
@RestController
public class ProductPostBookController {

    @RequestMapping("/product/booking/bookingInfo")
    public BookingInfoJSON hotelBookingInfo(@RequestParam(value="bookingId", defaultValue="") String bookingNumber,
                                            @RequestParam(value="dateFrom", defaultValue="") String dateFrom,
                                            @RequestParam(value="dateTo", defaultValue="") String dateTo,
                                            @RequestParam(value = "currencyCode", defaultValue = "") String currencyCode,
                                            @RequestParam("apiKey") String apiKey) {

        Application.agent.increment("app.web.request.api.product.bookingInfo");
        BookingInfoJSON bookInfoJSON=new BookingInfoJSON();
        try {
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            bookInfoJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
            SubAgencyBean subAgencyBean;
            String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + apiKey;
            String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
            subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);


            List<BookingInfoData> responseBookings = new ArrayList<>();
            if (subAgencyBean != null) {

                if (!currencyCode.equals("")) {
                    if (CurrencyConverter.findExchangeRateAndConvert("EUR", currencyCode, new Double(1)) == null) {
                        bookInfoJSON.setSuccess(false);
                        bookInfoJSON.setErrorMessageText("Wrong currrency code");
                        return bookInfoJSON;
                    }
                }

                List<BookingsAllBean> bookingsBeans;

                if (!bookingNumber.equals("")) {
                    bookingsBeans = BookingsAllDAO.getBookingsAllByBookingId(bookingNumber, subAgencyBean.getId());
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
                    bookingsBeans = BookingsAllDAO.getAllProductBookingsByDate(checkin, checkout, subAgencyBean.getId());
                } else {
                    bookInfoJSON.setSuccess(false);
                    bookInfoJSON.setErrorMessageText("Please Specify BookingNumber or Dates");
                    return bookInfoJSON;
                }


                if (bookingsBeans != null && bookingsBeans.size() > 0) {

                    List<BookingInfoItem> items = new ArrayList<>();
                    BookingInfoItem item;
                    BookingInfoData bookResult = null;
                    BigDecimal totalPrice = new BigDecimal(0);
                    for (BookingsAllBean booking : bookingsBeans) {
                        bookResult = new BookingInfoData();
                        bookResult.setBookingDate(booking.getBookingDate().toString());
                        String split[] = booking.getBookingId().split("-");
                        bookResult.setBookingId(split[1]);


                        List<TravellerInfoBean> travellersInfoBean;
                        travellersInfoBean = TravellerInfoDAO.getTravellerInfoBeanByBookingId(booking.getBookingId());
                        if (travellersInfoBean != null) {
                            item = new BookingInfoItem();
                            if (booking.getStatus().equals("4"))
                                item.setBookingStatus("Active");
                            else if (booking.getStatus().equals("7"))
                                item.setBookingStatus("Active(Test Booking)");
                            else if (booking.getStatus().equals("3"))
                                item.setBookingStatus("Cancelled");
                            item.setCity(booking.getCityName());
                            item.setCountry(booking.getCountryName());
                            item.setDeparturePoint(booking.getCommon7());
                            item.setItemId(split[2]);
                            item.setLanguage("");
                            item.setPickupHotelId(booking.getCommon8());
                            item.setPickupPoint(booking.getCommon1());
                            item.setPlanId(booking.getPlanId());
                            item.setPrice(new BigDecimal(Double.parseDouble(booking.getAgentSale())).setScale(2, BigDecimal.ROUND_HALF_UP));
                            item.setProductId(booking.getProductId());

                            /**
                             * Currency conversion
                             */
                            if (!currencyCode.equals("") && booking.getAgentEndSaleCur() != null) {
                                BigDecimal convertedPrice = CurrencyConverter.findExchangeRateAndConvert(booking.getAgentEndSaleCur(), currencyCode, Double.parseDouble(booking.getAgentSale()));
                                if (convertedPrice != null) {
                                    convertedPrice = convertedPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    item.setPrice(convertedPrice);
                                    totalPrice = totalPrice.add(item.getPrice());
                                    item.setCurrencyCode(currencyCode);
                                    bookResult.setCurrencyCode(currencyCode);
                                } else {
                                    item.setCurrencyCode(booking.getAgentEndSaleCur());
                                    item.setPrice(new BigDecimal(Double.parseDouble(booking.getAgentSale())).setScale(2, BigDecimal.ROUND_HALF_UP));
                                    totalPrice = totalPrice.add(item.getPrice());
                                    bookResult.setCurrencyCode(booking.getAgentEndSaleCur());
                                }
                            } else {
                                item.setCurrencyCode(booking.getAgentEndSaleCur());
                                item.setPrice(new BigDecimal(Double.parseDouble(booking.getAgentSale())).setScale(2, BigDecimal.ROUND_HALF_UP));
                                totalPrice = totalPrice.add(item.getPrice());
                                bookResult.setCurrencyCode(booking.getAgentEndSaleCur());
                            }


                            if (booking.getBookletGuide().equals(""))
                                item.setServiceOption(booking.getBookletGuide());
                            else if (booking.getLiveGuide().equals(""))
                                item.setServiceOption(booking.getLiveGuide());
                            else if (booking.getAudioGuide().equals(""))
                                item.setServiceOption(booking.getAudioGuide());
                            else
                                item.setServiceOption("");
                            item.setTravelDate(booking.getCheckIn().toString());
                            List<TravellerInfoBean> travellers = new ArrayList<>();
                            TravellerInfoBean traveller;
                            for (TravellerInfoBean tr : travellersInfoBean) {
                                traveller = new TravellerInfoBean();
                                traveller.setTravelName(tr.getTravelName());
                                traveller.setTravelSurname(tr.getTravelSurname());
                                traveller.setTravelBirdthDate(tr.getTravelBirdthDate());
                                traveller.setTravelType(tr.getTravelType());
                                travellers.add(traveller);
                            }
                            item.setTravellers(travellers);//todo alter travellers class
                            items.add(item);
                        }

                        responseBookings.add(bookResult);


                    }

                    bookResult.setVoucher("");
                    bookResult.setTotalPrice(totalPrice);
                    bookResult.setItems(items);
                }
            } else {
                bookInfoJSON.setSuccess(false);
                bookInfoJSON.setErrorMessageText("Couldn't extract essential data from database.Please contact at:george.nafpaktitis@atbholidays.com");
                return bookInfoJSON;
            }
            bookInfoJSON.setTotalCount(responseBookings.size());
            bookInfoJSON.setBookingInfo(responseBookings);
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


    @RequestMapping("/product/booking/cancelBooking")
    public CancelJSON cancelBooking(@RequestParam(value="bookingId", defaultValue="0") String bookingId,
                                    @RequestParam(value="itemId", defaultValue="") String itemId,
                                    @RequestParam("apiKey") String apiKey) {

        Application.agent.increment("app.web.request.api.product.cancelBooking");
        CancelJSON cancelJSON=new CancelJSON();
        List<ItemCancellationResult> itemsCancellationResult=new ArrayList<>();
        ItemCancellationResult itemCancellationResult;
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

                List<BookingsAllBean> bookings = BookingsAllDAO.getBookingsAllByBookingId(bookingId, subAgencyBean.getId());
                if (bookings != null) {

                    for (BookingsAllBean booking : bookings) {

                        String[] bookingIdSplit = booking.getBookingId().split("-");
                        if (itemId.equals("") || itemId.equals(bookingIdSplit[2])) {
                            itemCancellationResult = new ItemCancellationResult();
                            itemCancellationResult.setCancellationSucceed(false);
                            List<BProductDetailBean> bProductDetails = BProductDetailDAO.getBProductDetailsByProductId(booking.getProductId());
                            if (bProductDetails != null && bProductDetails.size() > 0) {
                                DateTime deadlineDate;
                                if (bProductDetails.get(0).getMerchantCancellable() == null)
                                    deadlineDate = null;
                                else if (bProductDetails.get(0).getMerchantCancellable().equals("")) {
                                    deadlineDate = null;
                                } else if (bProductDetails.get(0).getMerchantCancellable().equals("non-refundable")) {
                                    deadlineDate = null;
                                } else if (bProductDetails.get(0).getMerchantCancellable().equals("false")) {
                                    deadlineDate = null;
                                } else if (bProductDetails.get(0).getMerchantCancellable().equals("true")) {
                                    long i = booking.getCheckIn().getTime() - (48 * 60 * 60 * 1000);//todo
                                    deadlineDate = new DateTime(i);
                                } else {
                                    long i = booking.getCheckIn().getTime() - (Integer.parseInt(bProductDetails.get(0).getMerchantCancellable()) * 60 * 60 * 1000);//todo
                                    deadlineDate = new DateTime(i);
                                }

                                if (booking.getStatus().equals("4")) {

                                    if (deadlineDate != null && dateTime.compareTo(deadlineDate) < 0) {

                                        if (booking.getSupplierName().equals("Viator")) {

                                            CancelPOST cancelPOST = new CancelPOST();
                                            cancelPOST.setDistributorRef(booking.getCommon15());
                                            cancelPOST.setItineraryId(Integer.parseInt(booking.getCommon10()));
                                            List<CancelItem> items = new ArrayList<>();
                                            CancelItem item = new CancelItem();
                                            item.setCancelCode("00");
                                            item.setCancelDescription("");
                                            item.setDistributorItemRef(booking.getCommon14());
                                            item.setItemId(Integer.parseInt(booking.getCommon12()));
                                            items.add(item);
                                            cancelPOST.setCancelItems(items);
                                            CancelAPIJSON cancelAPIJSON = BookingsAPIDAO.cancellation(cancelPOST);

                                            if (cancelAPIJSON != null) {
                                                if (!cancelAPIJSON.isSuccess()) {
                                                    itemCancellationResult.setCancellationSucceed(false);
                                                    itemCancellationResult.setCancellationNote("Cancelation couldn't completed for this item." + cancelAPIJSON.getErrorType());
                                                    itemCancellationResult.setItemId(Integer.parseInt(bookingIdSplit[2]));
                                                    itemCancellationResult.setBookingId(bookingIdSplit[1]);
                                                    itemsCancellationResult.add(itemCancellationResult);
                                                } else {
                                                    if (cancelAPIJSON.getData() != null && cancelAPIJSON.getData().getCancelItems() != null
                                                            && cancelAPIJSON.getData().getCancelItems().size() == 1
                                                            && cancelAPIJSON.getData().getCancelItems().get(0).getCancellationResponseStatusCode().equals("Confirmed")) {

                                                        itemCancellationResult.setCancellationSucceed(true);
                                                        itemCancellationResult.setCancellationNote("Confirmed.");
                                                        itemCancellationResult.setBookingId(bookingIdSplit[1]);
                                                        itemCancellationResult.setItemId(Integer.parseInt(bookingIdSplit[2]));
                                                        itemsCancellationResult.add(itemCancellationResult);
                                                        booking.setStatus("3");
                                                        if (BookingsAllDAO.updateBooking(booking)) {
                                                            errLogger.info("Booking with Id :" + booking.getId() + " cancelled at sunhotels side but failed to update bookingsall table.");
                                                        }


                                                        subAgencyBean.setDeposit(String.valueOf(new BigDecimal(Double.parseDouble(subAgencyBean.getDeposit())).
                                                                add(new BigDecimal(Double.parseDouble(booking.getAgentSale()))).
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
                                                            bookingTransactionBean.setTransRate(String.valueOf(new BigDecimal(Double.parseDouble(booking.getAgentSale())).setScale(2, BigDecimal.ROUND_HALF_UP)));
                                                            bookingTransactionBean.setTransType("Deposit");
                                                            bookingTransactionBean.setTransNote("");

                                                            if (BookingTransactionDAO.storeTransaction(bookingTransactionBean)) {
                                                                errLogger.info("Booking with Id :" + booking.getId() + " cancelled at viator side but failed to store transaction at BookingTransaction table.");
                                                            }
                                                        } else {
                                                            errLogger.info("Booking with Id :" + booking.getId() + " cancelled at viator side but failed to refund the price at subagency table.");
                                                        }

                                                        GsaBean gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()), null);
                                                        if(gsaBean!=null) {
                                                            BigDecimal gsaSaleInGsaCur = CurrencyConverter.findExchangeRateAndConvert(booking.getSaleCurrency(), gsaBean.getCurrency(), Double.parseDouble(booking.getGsaSale().toString()));
                                                            if (gsaSaleInGsaCur != null) {
                                                                gsaBean.setDeposit(String.valueOf(new BigDecimal(Double.parseDouble(gsaBean.getDeposit())).
                                                                        add(gsaSaleInGsaCur.setScale(2, BigDecimal.ROUND_HALF_UP)).
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
                                                                    bookingTransactionBean.setTransRate(String.valueOf(gsaSaleInGsaCur.setScale(2, BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP)));
                                                                    bookingTransactionBean.setTransType("Deposit");
                                                                    bookingTransactionBean.setTransNote("");
                                                                    if (BookingTransactionDAO.storeTransaction(bookingTransactionBean)) {
                                                                        errLogger.info("Booking with Id :" + booking.getId() + " cancelled at viator side but failed to store transaction at BookingTransaction table for gsa transaction.");
                                                                    }
                                                                } else {
                                                                    errLogger.info("Booking with Id :" + booking.getId() + " cancelled at viator side but failed to refund the price at gsa table.");
                                                                }
                                                            }else{
                                                                errLogger.info("Booking with Id :" + booking.getId() + " cancelled at viator side but failed to detuct the price from gsaBean deposit at database because of currency converting issue.");
                                                            }
                                                        }else{
                                                            errLogger.info("Booking with Id :" + booking.getId() + " cancelled at viator side but failed to detuct the price from gsaBean deposit at database.*********");
                                                        }
                                                    } else {
                                                        itemCancellationResult.setCancellationSucceed(false);
                                                        itemCancellationResult.setCancellationNote("Cancellation couldn't completed.Please contact at:george.nafpaktitis@atbholidays.com");
                                                        itemCancellationResult.setItemId(Integer.parseInt(bookingIdSplit[2]));
                                                        itemCancellationResult.setBookingId(bookingIdSplit[1]);
                                                        itemsCancellationResult.add(itemCancellationResult);
                                                    }
                                                }

                                            } else {
                                                itemCancellationResult.setCancellationSucceed(false);
                                                itemCancellationResult.setCancellationNote("Cancellation couldn't completed.");
                                                itemCancellationResult.setItemId(Integer.parseInt(bookingIdSplit[2]));
                                                itemCancellationResult.setBookingId(bookingIdSplit[1]);
                                                itemsCancellationResult.add(itemCancellationResult);
                                            }
                                        }else if (booking.getSupplierName().equals("Events Travel")) {
                                            itemCancellationResult.setCancellationSucceed(false);
                                            itemCancellationResult.setCancellationNote("This  item is not cancellable.");
                                            itemCancellationResult.setBookingId(bookingIdSplit[1]);
                                            itemCancellationResult.setItemId(Integer.parseInt(bookingIdSplit[2]));
                                            itemsCancellationResult.add(itemCancellationResult);
                                        } else {
                                            itemCancellationResult.setCancellationSucceed(true);
                                            itemCancellationResult.setItemId(Integer.parseInt(bookingIdSplit[2]));
                                            itemCancellationResult.setCancellationNote("Confirmed.");
                                            itemCancellationResult.setBookingId(bookingIdSplit[1]);
                                            itemsCancellationResult.add(itemCancellationResult);
                                            booking.setStatus("3");
                                            if (BookingsAllDAO.updateBooking(booking)) {
                                                errLogger.info("Booking with Id :" + booking.getId() + " cancelled  but failed to update bookings_all table.");
                                            }


                                            subAgencyBean.setDeposit(String.valueOf(new BigDecimal(Double.parseDouble(subAgencyBean.getDeposit())).
                                                    add(new BigDecimal(Double.parseDouble(booking.getAgentSale()))).
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
                                                bookingTransactionBean.setTransRate(String.valueOf(new BigDecimal(Double.parseDouble(booking.getAgentSale())).setScale(2, BigDecimal.ROUND_HALF_UP)));
                                                bookingTransactionBean.setTransType("Deposit");
                                                bookingTransactionBean.setTransNote("");

                                                if (BookingTransactionDAO.storeTransaction(bookingTransactionBean)) {
                                                    errLogger.info("Booking with Id :" + booking.getId() + " cancelled   but failed to store transaction at BookingTransaction table.");
                                                }
                                            } else {
                                                errLogger.info("Booking with Id :" + booking.getId() + " cancelled but failed to refund the price at subagency table.");
                                            }

                                            GsaBean gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()), null);
                                            if(gsaBean!=null) {
                                                BigDecimal gsaSaleInGsaCur = CurrencyConverter.findExchangeRateAndConvert(booking.getSaleCurrency(), gsaBean.getCurrency(), Double.parseDouble(booking.getGsaSale().toString()));
                                                if (gsaSaleInGsaCur != null) {
                                                    gsaBean.setDeposit(String.valueOf(new BigDecimal(Double.parseDouble(gsaBean.getDeposit())).
                                                            add(gsaSaleInGsaCur.setScale(2, BigDecimal.ROUND_HALF_UP)).
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
                                                        bookingTransactionBean.setTransRate(String.valueOf(gsaSaleInGsaCur.setScale(2, BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP)));
                                                        bookingTransactionBean.setTransType("Deposit");
                                                        bookingTransactionBean.setTransNote("");
                                                        if (BookingTransactionDAO.storeTransaction(bookingTransactionBean)) {
                                                            errLogger.info("Booking with Id :" + booking.getId() + " cancelled at viator side but failed to store transaction at BookingTransaction table for gsa transaction.");
                                                        }
                                                    } else {
                                                        errLogger.info("Booking with Id :" + booking.getId() + " cancelled at viator side but failed to refund the price at gsa table.");
                                                    }
                                                }else{
                                                    errLogger.info("Booking with Id :" + booking.getId() + " cancelled at viator side but failed to detuct the price from gsaBean deposit at database because of currency converting issue.");
                                                }
                                            }else{
                                                errLogger.info("Booking with Id :" + booking.getId() + " cancelled at viator side but failed to detuct the price from gsaBean deposit at database.*********");
                                            }
                                        }
                                    } else if (deadlineDate != null) {
                                        itemCancellationResult.setCancellationSucceed(false);
                                        itemCancellationResult.setCancellationNote("The booking could not be cancelled for this item due to the cancellation deadline having expired.");
                                        itemCancellationResult.setBookingId(bookingIdSplit[1]);
                                        itemCancellationResult.setItemId(Integer.parseInt(bookingIdSplit[2]));
                                        itemsCancellationResult.add(itemCancellationResult);
                                    } else {
                                        itemCancellationResult.setCancellationSucceed(false);
                                        itemCancellationResult.setCancellationNote("This  item is not cancellable.");
                                        itemCancellationResult.setBookingId(bookingIdSplit[1]);
                                        itemCancellationResult.setItemId(Integer.parseInt(bookingIdSplit[2]));
                                        itemsCancellationResult.add(itemCancellationResult);
                                    }
                                } else if (booking.getStatus().equals("7")) {
                                    booking.setStatus("3");
                                    if (!BookingsAllDAO.updateBooking(booking)) {
                                        itemCancellationResult.setCancellationSucceed(true);
                                        itemCancellationResult.setCancellationNote("Confirmed.");
                                        itemCancellationResult.setBookingId(bookingIdSplit[1]);
                                        itemCancellationResult.setItemId(Integer.parseInt(bookingIdSplit[2]));
                                        itemsCancellationResult.add(itemCancellationResult);
                                    } else {
                                        itemCancellationResult.setCancellationSucceed(false);
                                        itemCancellationResult.setCancellationNote("The booking could not be cancelled for this item..Please contact at:george.nafpaktitis@atbholidays.com");
                                        itemCancellationResult.setBookingId(bookingIdSplit[1]);
                                        itemCancellationResult.setItemId(Integer.parseInt(bookingIdSplit[2]));
                                        itemsCancellationResult.add(itemCancellationResult);
                                    }
                                } else {
                                    itemCancellationResult.setCancellationNote("The booking for this item isn't active");
                                    itemCancellationResult.setCancellationSucceed(false);
                                    itemCancellationResult.setBookingId(bookingIdSplit[1]);
                                    itemCancellationResult.setItemId(Integer.parseInt(bookingIdSplit[2]));
                                    itemsCancellationResult.add(itemCancellationResult);
                                }
                            } else {
                                itemCancellationResult.setCancellationSucceed(false);
                                itemCancellationResult.setCancellationNote("Cancellation couldn't completed for this item.");
                                itemCancellationResult.setBookingId(bookingIdSplit[1]);
                                itemCancellationResult.setItemId(Integer.parseInt(bookingIdSplit[2]));
                                itemsCancellationResult.add(itemCancellationResult);
                            }
                        }
                    }
                    cancelJSON.setCancellationResult(itemsCancellationResult);
                    cancelJSON.setSuccess(false);
                    return cancelJSON;
                } else {
                    cancelJSON.setSuccess(false);
                    cancelJSON.setErrorMessageText("Internal error.Couldn't extract essential data or bookingId doesn't exists.");
                    return cancelJSON;
                }
            } else {
                cancelJSON.setSuccess(false);
                cancelJSON.setErrorMessageText("Internal error.Couldn't extract essential data.");
                return cancelJSON;
            }
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            cancelJSON.setSuccess(false);
            cancelJSON.setErrorMessageText(errors.toString());
            return cancelJSON;
        }

    }
}
