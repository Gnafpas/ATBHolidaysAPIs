package Controller.ATBAPIController.ProductBookingsControler;

import APIJSONs.ATBAPIJSONs.Product.*;
import APIJSONs.ATBAPIJSONs.Product.Traveller;
import Beans.ATBDBBeans.KalitaonProduct.*;
import Beans.ATBDBBeans.KalitaonSystem.*;
import Beans.ViatorAPIBeans.Bookings.Book.*;
import Beans.ViatorAPIBeans.Bookings.Book.BookAPIJSON;
import Beans.ViatorAPIBeans.Bookings.Book.BookPOST;
import Beans.ViatorAPIBeans.Bookings.CalculatePrice.*;
import Beans.ViatorAPIBeans.Bookings.CalculatePrice.CalculatePricePOST;
import Beans.ViatorDBBeans.ViatorProductTourGradeLanguageServicesBean;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.*;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.*;
import DAOs.ViatorAPIDAOs.BookingsAPIDAO;
import DAOs.ViatorDBDAOs.ViatorProductTourGradeLanguageServicesDAO;
import org.apache.http.client.utils.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.defaultCurrencyCode;
import static Helper.ProjectProperties.viatorComission;

/**
 * Created by George on 23/10/2017.
 */
@RestController
public class BookController {


    @RequestMapping(value = "/product/booking/book", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public APIJSONs.ATBAPIJSONs.Product.BookAPIJSON bookViator(@RequestBody APIJSONs.ATBAPIJSONs.Product.BookPOST bookPOST,@RequestParam("apiKey") String apiKey) {

        APIJSONs.ATBAPIJSONs.Product.BookAPIJSON bookInfoJSON=new APIJSONs.ATBAPIJSONs.Product.BookAPIJSON();
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        bookInfoJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");

        /**
         * Check for availability
         */
        for(APIJSONs.ATBAPIJSONs.Product.Item it:bookPOST.getItems()) {
            List<HStopsaleDateBean> stopSaleDates = HStopsaleDateDAO.gethStopsaleDatesByProductId(it.getProductId(), it.getPlanId());
            String[] split = it.getTravelDate().split("-");
            if (split != null && split.length == 3) {
                LocalDate travelDate = new LocalDate(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d", Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 0, 0, 0)).getTime());
                if (stopSaleDates != null && stopSaleDates.size() > 0) {
                    for (HStopsaleDateBean stopSaleDate : stopSaleDates) {
                        LocalDate date = new LocalDate(stopSaleDate.getStopDate().getTime());
                        if (date.compareTo(travelDate) == 0) {
                            bookInfoJSON.setSuccess(false);
                            bookInfoJSON.setErrorMessageText("No availability for product with id:" + it.getProductId() + " for the requested travelDate");
                            return bookInfoJSON;
                        }

                    }
                }
                List<HAvailableDateBean> availableDates = HAvailableDateDAO.gethAvailableDatesByProductId(it.getProductId(), it.getPlanId());
                if (availableDates != null && availableDates.size() > 0) {
                    for (HAvailableDateBean availableDate : availableDates) {
                        LocalDate startDate = new LocalDate(availableDate.getStartDate().getTime());
                        LocalDate endDate = new LocalDate(availableDate.getEndDate().getTime());
                        if (startDate.isAfter(travelDate) || endDate.isBefore(travelDate)) {
                            bookInfoJSON.setSuccess(false);
                            bookInfoJSON.setErrorMessageText("No availability for product with id:" + it.getProductId() + " for the requested travelDate");
                            return bookInfoJSON;
                        }
                    }
                } else {
                    bookInfoJSON.setSuccess(false);
                    bookInfoJSON.setErrorMessageText("No availability for product with id:" + it.getProductId() + " for the requested travelDate");
                    return bookInfoJSON;
                }
            }else{
                bookInfoJSON.setSuccess(false);
                bookInfoJSON.setErrorMessageText("Wrong TravelDate format.");
                return bookInfoJSON;
            }

        }



        SubAgencyBean subAgencyBean;
        String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + apiKey;
        String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
        subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);
        if (subAgencyBean != null) {

            List<BigDecimal> atbProductPrices=new ArrayList<>();
            BigDecimal atbTotalNetPrice=new BigDecimal(0);
            BigDecimal previusAtbTotalNetPrice=new BigDecimal(0); //Used for count single item total pice.
            BigDecimal viatorTotalPrice=new BigDecimal(0);


            /**
             * Preparing items for calculate price request and  book viator request.
             */
            Beans.ViatorAPIBeans.Bookings.Book.Item item;
            List<Beans.ViatorAPIBeans.Bookings.Book.Item> atbItems = new ArrayList<>();
            List<Beans.ViatorAPIBeans.Bookings.Book.Item> viatorItems = new ArrayList<>();
            Beans.ViatorAPIBeans.Bookings.CalculatePrice.Item cItem=new Beans.ViatorAPIBeans.Bookings.CalculatePrice.Item();;
            List<Beans.ViatorAPIBeans.Bookings.CalculatePrice.Item> cItems=new ArrayList<>();
            int distributorItemRef = 0;
            PartnerItemDetail partnerItemDetail;

            for(APIJSONs.ATBAPIJSONs.Product.Item it:bookPOST.getItems()) {


                AProductTitleBean product=AProductTitleDAO.getProductById(it.getProductId());
                if(product==null){
                    bookInfoJSON.setSuccess(false);
                    bookInfoJSON.setErrorMessageText("Couldn't retrive product with id:"+it.getProductId()+" from database");
                    return bookInfoJSON;
                }
                FPricePlanBean priceplan=FPricePlanDAO.getfPricePlansById(Integer.parseInt(it.getPlanId()));
                if(priceplan==null){
                    bookInfoJSON.setSuccess(false);
                    bookInfoJSON.setErrorMessageText("Couldn't retrive plan with id:"+it.getPlanId()+" from database");
                    return bookInfoJSON;
                }


                item = new Beans.ViatorAPIBeans.Bookings.Book.Item();
                distributorItemRef++;
                partnerItemDetail = new PartnerItemDetail();
                partnerItemDetail.setDistributorItemRef("" + distributorItemRef);
                item.setPartnerItemDetail(partnerItemDetail);
                item.setBookingQuestionAnswers(it.getBookingQuestionAnswers());
                item.setHotelId(it.getHotelId());
                item.setPickupPoint(it.getPickupPoint());
                item.setSpecialRequirements(it.getSpecialRequirements());
                item.setTravelDate(it.getTravelDate());
                if(product.getMainSupplierName().equals("Viator"))
                     item.setProductCode(product.getProductCode());
                else
                     item.setProductCode(String.valueOf(product.getId()));
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

                if(product.getMainSupplierName().equals("Viator")) {
                    cItem = new Beans.ViatorAPIBeans.Bookings.CalculatePrice.Item();
                    cItem.setProductCode(product.getProductCode());
                    cItem.setTourGradeCode(priceplan.getTourGradeCode());
                    cItem.setTravelDate(it.getTravelDate());
                }
                List<Beans.ViatorAPIBeans.Bookings.CalculatePrice.Traveller> cTravellers=new ArrayList<>();
                Beans.ViatorAPIBeans.Bookings.CalculatePrice.Traveller cTraveller;


                /**
                 * Prepare travellers for calculate price and booking requests and define travellers type
                 */
                List<GPriceMatrixBean>  pricematrix=GPriceMatrixDAO.getgPriceMatrixesByProductIdAndPlanId(it.getProductId(),String.valueOf(priceplan.getId()));
                if(pricematrix==null || pricematrix.size()==0){
                    bookInfoJSON.setSuccess(false);
                    bookInfoJSON.setErrorMessageText("No prices for product with id:"+it.getProductId());
                    return bookInfoJSON;
                }
                int adultsCount=0;
                int childCount=0;
                int youthCount=0;
                int infantCount=0;
                int seniorCount=0;
                Beans.ViatorAPIBeans.Bookings.Book.Traveller traveller;
                List<Beans.ViatorAPIBeans.Bookings.Book.Traveller> travellers = new ArrayList<>();
                for(APIJSONs.ATBAPIJSONs.Product.Traveller tr:it.getTravellers()){
                    cTraveller=new  Beans.ViatorAPIBeans.Bookings.CalculatePrice.Traveller();
                    traveller=new Beans.ViatorAPIBeans.Bookings.Book.Traveller();
                    traveller.setFirstname(tr.getFirstname());
                    traveller.setLeadTraveller(tr.isLeadTraveller());
                    traveller.setSurname(tr.getSurname());
                    traveller.setTitle(tr.getTitle());
                    if(tr.getAge()==0){
                        bookInfoJSON.setSuccess(false);
                        bookInfoJSON.setErrorMessageText("Age is a required field for all travellers");
                        return bookInfoJSON;
                    }

                    for(GPriceMatrixBean price:pricematrix){
                        if(!price.getAgeFrom().equals("") && !price.getAgeTo().equals("") ){
                            if( tr.getAge()>=Integer.parseInt(price.getAgeFrom()) && tr.getAge()<Integer.parseInt(price.getAgeTo())) {
                                if (price.getPersonType().equals("adult")) {
                                    cTraveller.setBandId(1);
                                    traveller.setBandId(1);
                                    adultsCount++;
                                    break;
                                } else if (price.getPersonType().equals("child")) {
                                    cTraveller.setBandId(2);
                                    traveller.setBandId(2);
                                    childCount++;
                                    break;
                                } else if (price.getPersonType().equals("infant")) {
                                    cTraveller.setBandId(3);
                                    traveller.setBandId(3);
                                    infantCount++;
                                    break;
                                } else if (price.getPersonType().equals("youth")) {
                                    cTraveller.setBandId(4);
                                    traveller.setBandId(4);
                                    youthCount++;
                                    break;
                                } else if (price.getPersonType().equals("senior")) {
                                    cTraveller.setBandId(5);
                                    traveller.setBandId(5);
                                    seniorCount++;
                                    break;
                                } else {
                                    bookInfoJSON.setSuccess(false);
                                    bookInfoJSON.setErrorMessageText("Couldn't find person type for traveler:" + tr.getFirstname() + "," + tr.getSurname() + " for product with id:" + it.getPlanId());
                                    return bookInfoJSON;
                                }
                            }
                        }else {
                            bookInfoJSON.setSuccess(false);
                            bookInfoJSON.setErrorMessageText("Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                            return bookInfoJSON;
                        }

                    }
                    if (product.getMainSupplierName().equals("Viator")) {
                        cTravellers.add(cTraveller);
                    }
                    travellers.add(traveller);
                }


                /**
                 * Calculate current total price and check number of travellers restrictions.
                 * atbTotalNetPrice:Viator net price plus 5% of the commition.No subagency and GSA markups in this price.
                 * viatorprice:Viator net price
                 */
                int maxPeoplerequired=0;
                int minPeoplerequired=1000;
                boolean atLeastOneAdult=false;
                BigDecimal atbNetPrice;
                BigDecimal viatorprice;
                BigDecimal priceWithAgentCurrency;
                for(GPriceMatrixBean price:pricematrix){
                    price.setPriceNet(price.getPriceNet().replace(",",".").replace(" ", ""));
                    if(price.getPersonType().equals("adult")) {
                        if(adultsCount >=price.getMinCountRequired() && adultsCount <=price.getMaxCountRequired()){
                            priceWithAgentCurrency=Helper.CurrencyConverter.findExchangeRateAndConvert(price.getCurrencyCode(),subAgencyBean.getCurrency(),Double.parseDouble(price.getPriceNet()));
                            if(priceWithAgentCurrency!=null) {
                                atbNetPrice = priceWithAgentCurrency.setScale(2, BigDecimal.ROUND_HALF_UP);
                                viatorprice = ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(105), 2, RoundingMode.HALF_UP));
                                atbTotalNetPrice = atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(adultsCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                if (product.getMainSupplierName().equals("Viator")) {
                                    viatorTotalPrice = viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(adultsCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                }
                                atLeastOneAdult = true;
                            }else{
                                bookInfoJSON.setSuccess(false);
                                bookInfoJSON.setErrorMessageText("Code:21 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                return bookInfoJSON;
                            }
                        }
                        if(price.getMaxCountRequired()>maxPeoplerequired)
                            maxPeoplerequired=price.getMaxCountRequired();
                        if(price.getMinCountRequired()<minPeoplerequired)
                            minPeoplerequired=price.getMinCountRequired();
                    }
                    else if(price.getPersonType().equals("child")){
                        if(childCount >=price.getMinCountRequired() && childCount <=price.getMaxCountRequired()) {
                            priceWithAgentCurrency=Helper.CurrencyConverter.findExchangeRateAndConvert(price.getCurrencyCode(),subAgencyBean.getCurrency(),Double.parseDouble(price.getPriceNet()));
                            if(priceWithAgentCurrency!=null) {
                                atbNetPrice = priceWithAgentCurrency.setScale(2, BigDecimal.ROUND_HALF_UP);
                                viatorprice = ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(100).add(Helper.ProjectProperties.viatorComission.multiply(new BigDecimal(100))), 2, RoundingMode.HALF_UP));
                                atbTotalNetPrice = atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(childCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                if (product.getMainSupplierName().equals("Viator")) {
                                    viatorTotalPrice = viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(childCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                }
                            }else{
                                bookInfoJSON.setSuccess(false);
                                bookInfoJSON.setErrorMessageText("Code:21 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                return bookInfoJSON;
                            }
                        }
                    }
                    else if(price.getPersonType().equals("infant")){
                        if(infantCount >=price.getMinCountRequired() && infantCount <=price.getMaxCountRequired()) {
                            priceWithAgentCurrency=Helper.CurrencyConverter.findExchangeRateAndConvert(price.getCurrencyCode(),subAgencyBean.getCurrency(),Double.parseDouble(price.getPriceNet()));
                            if(priceWithAgentCurrency!=null) {
                                atbNetPrice = priceWithAgentCurrency.setScale(2, BigDecimal.ROUND_HALF_UP);
                                viatorprice = ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(100).add(Helper.ProjectProperties.viatorComission.multiply(new BigDecimal(100))), 2, RoundingMode.HALF_UP));
                                atbTotalNetPrice = atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(infantCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                if (product.getMainSupplierName().equals("Viator")) {
                                    viatorTotalPrice = viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(infantCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                }
                            }else{
                                bookInfoJSON.setSuccess(false);
                                bookInfoJSON.setErrorMessageText("Code:21 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                return bookInfoJSON;
                            }
                        }
                    }
                    else if(price.getPersonType().equals("youth")){
                        if(youthCount >=price.getMinCountRequired() && youthCount <=price.getMaxCountRequired()) {
                            priceWithAgentCurrency=Helper.CurrencyConverter.findExchangeRateAndConvert(price.getCurrencyCode(),subAgencyBean.getCurrency(),Double.parseDouble(price.getPriceNet()));
                            if(priceWithAgentCurrency!=null) {
                                atbNetPrice = priceWithAgentCurrency.setScale(2, BigDecimal.ROUND_HALF_UP);
                                viatorprice = ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(100).add(Helper.ProjectProperties.viatorComission.multiply(new BigDecimal(100))), 2, RoundingMode.HALF_UP));
                                atbTotalNetPrice = atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(youthCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                if (product.getMainSupplierName().equals("Viator")) {
                                    viatorTotalPrice = viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(youthCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                }
                            }else{
                                bookInfoJSON.setSuccess(false);
                                bookInfoJSON.setErrorMessageText("Code:21 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                return bookInfoJSON;
                            }
                        }
                    }
                    else if(price.getPersonType().equals("senior")){
                        if(seniorCount >=price.getMinCountRequired() && seniorCount <=price.getMaxCountRequired()){
                            priceWithAgentCurrency=Helper.CurrencyConverter.findExchangeRateAndConvert(price.getCurrencyCode(),subAgencyBean.getCurrency(),Double.parseDouble(price.getPriceNet()));
                            if(priceWithAgentCurrency!=null) {
                                atbNetPrice = priceWithAgentCurrency.setScale(2, BigDecimal.ROUND_HALF_UP);
                                viatorprice = ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(100).add(Helper.ProjectProperties.viatorComission.multiply(new BigDecimal(100))), 2, RoundingMode.HALF_UP));
                                atbTotalNetPrice = atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(seniorCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                if (product.getMainSupplierName().equals("Viator")) {
                                    viatorTotalPrice = viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(seniorCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                }
                            }else{
                                bookInfoJSON.setSuccess(false);
                                bookInfoJSON.setErrorMessageText("Code:21 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                return bookInfoJSON;
                            }
                            atLeastOneAdult=true;
                        }
                    }
                }

                /**
                 * Check number of travellers restrictions
                 */
                if(minPeoplerequired>adultsCount){
                    bookInfoJSON.setSuccess(false);
                    bookInfoJSON.setErrorMessageText("More adult travellers than required.");
                    return bookInfoJSON;
                }
                if(maxPeoplerequired<adultsCount+childCount+youthCount+seniorCount ){
                    bookInfoJSON.setSuccess(false);
                    bookInfoJSON.setErrorMessageText("More traveller than required.");
                    return bookInfoJSON;
                }
                if(!atLeastOneAdult){
                    bookInfoJSON.setSuccess(false);
                    bookInfoJSON.setErrorMessageText("At least one Adult traveller required.");
                    return bookInfoJSON;
                }

                if (product.getMainSupplierName().equals("Viator")) {
                    cItem.setTravellers(cTravellers);
                    cItems.add(cItem);
                }
                item.setTravellers(travellers);
                if(product.getMainSupplierName().equals("Viator"))
                    viatorItems.add(item);
                else if(product.getMainSupplierName().equals("Atb Holidays")){
                    atbItems.add(item);
                    atbProductPrices.add(atbTotalNetPrice.subtract(previusAtbTotalNetPrice));
                }
                previusAtbTotalNetPrice=atbTotalNetPrice;
            }


            /**
             * Check if viator has the same totalprice as we stored in database at the last update.
             */
            CalculatePriceAPIJSON calculatepriceJson=null;
            if(cItems!=null && cItems.size()>0) {
                CalculatePricePOST calculatePricePOST = new CalculatePricePOST();
                calculatePricePOST.setItems(cItems);
                calculatePricePOST.setPartnerDetail(null);
                calculatePricePOST.setCurrencyCode(defaultCurrencyCode);
                calculatepriceJson = BookingsAPIDAO.calculateprice(calculatePricePOST);
                if (calculatepriceJson != null ) {
                    if(!calculatepriceJson.isSuccess()) {
                        bookInfoJSON.setErrorMessageText("Error: "+calculatepriceJson.getErrorMessage());
                        bookInfoJSON.setSuccess(false);
                        return bookInfoJSON;
                    } else {
                        bookInfoJSON.setErrorMessageText("Error: "+calculatepriceJson.getErrorMessage());
                        bookInfoJSON.setSuccess(false);
                        return bookInfoJSON;
                    }
                } else {
                    bookInfoJSON.setErrorMessageText("Communication Error");
                    bookInfoJSON.setSuccess(false);
                    return bookInfoJSON;
                }
            }

            /**
             * Check if subagency has the amount on it's deposit
             */
            GsaBean gsaBean;//todo errore handling(availability error type price error type)
            BigDecimal agentSale=null;
            if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()));
                if (gsaBean != null) {
                        if (gsaBean.getOtlMkp() != null && !gsaBean.getOtlMkp().equals("")) {
                            BigDecimal sumPrice=new BigDecimal(0);
                            for(BigDecimal atbProductPrice:atbProductPrices)
                                sumPrice=sumPrice.add(atbProductPrice);
                            if(calculatepriceJson!=null && calculatepriceJson.isSuccess() && calculatepriceJson.getData()!=null) {
                                sumPrice=sumPrice.add(calculatepriceJson.getData().getItineraryNewPrice().add(calculatepriceJson.getData().getItineraryNewPrice().multiply(viatorComission)).setScale(2, BigDecimal.ROUND_HALF_UP));
                            }
                            BigDecimal gsaSale = sumPrice.add(sumPrice.multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                            if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                if(agentSale.compareTo(new BigDecimal(Double.parseDouble(subAgencyBean.getDeposit())))==1) {
                                    bookInfoJSON.setSuccess(false);
                                    bookInfoJSON.setErrorMessageText("Total price of this booking exceeds the amount of your deposit.");
                                    return bookInfoJSON;
                                }
                            } else {
                                bookInfoJSON.setSuccess(false);
                                bookInfoJSON.setErrorMessageText("Code:1 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                return bookInfoJSON;
                            }
                        } else {
                            bookInfoJSON.setSuccess(false);
                            bookInfoJSON.setErrorMessageText("Code:2  Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                            return bookInfoJSON;
                        }
                } else {
                    bookInfoJSON.setSuccess(false);
                    bookInfoJSON.setErrorMessageText("Code:3  Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                    return bookInfoJSON;
                }
            } else {
                bookInfoJSON.setSuccess(false);
                bookInfoJSON.setErrorMessageText("Code:4  Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                return bookInfoJSON;
            }

            BigDecimal totalBookingPrice = new BigDecimal(0);
            List<ResponseItem> responseItems = new ArrayList<>();
            ResponseItem responseItem;
            String generalBookCode= dateTime.getMillis()+String.valueOf(subAgencyBean.getId());
            int storedItemNumber=0;
            /**
             * Make the booking in viator side.
             */
            if(viatorItems.size()>0) {
                BookPOST viatorBookPOST = new BookPOST();
                if (subAgencyBean.getXmlStatus().equals("1"))
                    viatorBookPOST.setDemo(false);
                else
                    viatorBookPOST.setDemo(true);
                viatorBookPOST.setItems(viatorItems);
                viatorBookPOST.setNewsletterSignUp(false);
                viatorBookPOST.setBooker(bookPOST.getBooker());
                viatorBookPOST.setCurrencyCode(subAgencyBean.getCurrency());
                PartnerDetail partenerDetail = new PartnerDetail();
                partenerDetail.setDistributorRef(dateTime.toString());
                viatorBookPOST.setPartnerDetail(partenerDetail);
                BookAPIJSON viatorBookResponse = BookingsAPIDAO.book(viatorBookPOST);

                /**
                 * Update database tables and prepare response.
                 */
                if (viatorBookResponse != null) {

                    if(viatorBookResponse.isSuccess() && viatorBookResponse.getData() != null && viatorBookResponse.getData().getItemSummaries() != null) {

                        for (ItemSummary viatorItem : viatorBookResponse.getData().getItemSummaries()) {
                            for (APIJSONs.ATBAPIJSONs.Product.Item atbItem : bookPOST.getItems()) {
                                AProductTitleBean product = AProductTitleDAO.getProductById(atbItem.getProductId());
                                if (viatorItem.getProductCode().equals(product.getProductCode()) && viatorItem.getTravelDate().equals(atbItem.getTravelDate())) {


                                    /**
                                     * Store Booking Results.
                                     */
                                    String bookingCode = "";
                                    BookingsAllBean bookingsAllBean = new BookingsAllBean();
                                    bookingsAllBean.setProductId(atbItem.getProductId());
                                    bookingsAllBean.setProductTitle(viatorItem.getProductTitle());
                                    bookingsAllBean.setCityName(product.getCityName());
                                    bookingsAllBean.setCountryName(product.getCountryName());
                                    bookingsAllBean.setAdittionalRequest(atbItem.getSpecialRequirements());
                                    bookingsAllBean.setAgentCommission("");
                                    bookingsAllBean.setAgentEndSaleCur(defaultCurrencyCode);
                                    bookingsAllBean.setAgentId(String.valueOf(subAgencyBean.getId()));
                                    bookingsAllBean.setPriceId("");
                                    bookingsAllBean.setLiveGuide("");
                                    bookingsAllBean.setBookletGuide("");
                                    bookingsAllBean.setAudioGuide("");
                                    if (atbItem.getServiceOption().equals("live"))
                                        bookingsAllBean.setLiveGuide(atbItem.getLanguage());
                                    else if (atbItem.getServiceOption().equals("booklet"))
                                        bookingsAllBean.setBookletGuide(atbItem.getLanguage());
                                    else if (atbItem.getServiceOption().equals("audio"))
                                        bookingsAllBean.setAudioGuide(atbItem.getLanguage());

                                    if (product.getTypeOfProduct().equals("1")) {
                                        bookingsAllBean.setProductType("TRS");
                                        bookingCode = "TRS-" + generalBookCode + "-" + storedItemNumber++;
                                    } else if (product.getTypeOfProduct().equals("2")) {
                                        bookingsAllBean.setProductType("DTR");
                                        bookingCode = "DTR-" + generalBookCode + "-" + storedItemNumber++;
                                    } else if (product.getTypeOfProduct().equals("3")) {
                                        bookingsAllBean.setProductType("MTR");
                                        bookingCode = "MTR-" + generalBookCode + "-" + storedItemNumber++;
                                    } else if (product.getTypeOfProduct().equals("4")) {
                                        bookingsAllBean.setProductType("SHR");
                                        bookingCode = "SHR-" + generalBookCode + "-" + storedItemNumber++;
                                    } else if (product.getTypeOfProduct().equals("5")) {
                                        bookingsAllBean.setProductType("EVT");
                                        bookingCode = "EVT-" + generalBookCode + "-" + storedItemNumber++;
                                    }
                                    bookingsAllBean.setBookingId(bookingCode);
                                    bookingsAllBean.setBasketId("");
                                    bookingsAllBean.setConfirmationNo("");
                                    bookingsAllBean.setPlanId(atbItem.getPlanId());
                                    bookingsAllBean.setContactTel(bookPOST.getBooker().getCellPhone());
                                    bookingsAllBean.setDiscountAmount("");
                                    bookingsAllBean.setDiscountMarkup("");
                                    bookingsAllBean.setPayType("Deposit");
                                    bookingsAllBean.setPosId("");
                                    bookingsAllBean.setSaleCurrency(defaultCurrencyCode);
                                    if (subAgencyBean.getXmlStatus().equals("1")) {
                                        bookingsAllBean.setStatus("4");
                                        bookingsAllBean.setStatusReason("");
                                    } else {
                                        bookingsAllBean.setStatus("7");
                                        bookingsAllBean.setStatusReason("XML-Test");
                                    }
                                    bookingsAllBean.setSupplierCurrency(defaultCurrencyCode);
                                    bookingsAllBean.setTotalPax(String.valueOf(atbItem.getTravellers().size()));
                                    for (Traveller tr : atbItem.getTravellers()) {
                                        if (tr.isLeadTraveller())
                                            bookingsAllBean.setTourLeader(tr.getFirstname() + " " + tr.getSurname());
                                    }
                                    bookingsAllBean.setXmlAgent(subAgencyBean.getAgentName());
                                    bookingsAllBean.setXmlBookRef("");
                                    if (atbItem.getHotelId() != null && !atbItem.getHotelId().equals("")) {
                                        EPickupPointBean pickupPoint = EPickupPointDAO.getePickupPointByHotelId(atbItem.getHotelId());
                                        if (pickupPoint != null) {
                                            bookingsAllBean.setCommon1(pickupPoint.getHotelPickupPoint());
                                            bookingsAllBean.setCommon7(pickupPoint.getStartingPoint());
                                            bookingsAllBean.setCommon8(pickupPoint.getHotelId());
                                        } else {
                                            bookingsAllBean.setCommon1(atbItem.getPickupPoint());
                                            bookingsAllBean.setCommon7("");
                                            bookingsAllBean.setCommon8("");
                                        }
                                    } else if (atbItem.getPickupPoint() != null) {
                                        bookingsAllBean.setCommon1(atbItem.getPickupPoint());
                                        bookingsAllBean.setCommon7("");
                                        bookingsAllBean.setCommon8("");
                                    } else {
                                        bookingsAllBean.setCommon1("");
                                        bookingsAllBean.setCommon7("");
                                        bookingsAllBean.setCommon8("");
                                    }
                                    bookingsAllBean.setCommon2("");
                                    bookingsAllBean.setCommon3("");
                                    List<IAvailableTimeBean> departureTimes = IAvailableTimeDAO.getiAvailableTimesByProductId(atbItem.getProductId(), atbItem.getPlanId());
                                    if (departureTimes != null && departureTimes.size() > 0) {
                                        bookingsAllBean.setCommon4(departureTimes.get(0).getStartTime());
                                        bookingsAllBean.setCommon13(departureTimes.get(0).getStartTime());
                                    } else {
                                        bookingsAllBean.setCommon4("");
                                        bookingsAllBean.setCommon13("");
                                    }
                                    bookingsAllBean.setCommon5("");
                                    bookingsAllBean.setCommon6("");
                                    bookingsAllBean.setCommon9("");
                                    bookingsAllBean.setCommon10(String.valueOf(viatorBookResponse.getData().getItineraryId()));
                                    bookingsAllBean.setCommon11(String.valueOf(viatorItem.getItineraryId()));
                                    bookingsAllBean.setCommon12(String.valueOf(viatorItem.getItemId()));
                                    bookingsAllBean.setCommon14(viatorItem.getDistributorItemRef());
                                    bookingsAllBean.setCommon15(viatorBookResponse.getData().getDistributorRef());
                                    bookingsAllBean.setInvoiceAmount("");
                                    bookingsAllBean.setInvoiceNo("");
                                    bookingsAllBean.setInvoiceStatus("");
                                    bookingsAllBean.setBasis("");
                                    bookingsAllBean.setUpdater("XML-API");
                                    bookingsAllBean.setPaying("agent");
                                    bookingsAllBean.setSupplierReferences("");
                                    bookingsAllBean.setSupplierName("Viator");//todo
                                    bookingsAllBean.setSupplierId("10236");//todo
                                    if (bookPOST.getCustomerCountry() != null)
                                        bookingsAllBean.setContactCountryCode(bookPOST.getCustomerCountry());
                                    else
                                        bookingsAllBean.setContactCountryCode("");
                                    if (bookPOST.getBooker().getEmail() != null)
                                        bookingsAllBean.setContactEmail(bookPOST.getBooker().getEmail());
                                    else
                                        bookingsAllBean.setContactEmail("");
                                    try {
                                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                        Date parsedDate = dateFormat.parse(viatorItem.getTravelDate());
                                        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime() + 1000 * 60 * 60 * 10);
                                        bookingsAllBean.setCheckIn(new java.sql.Date(timestamp.getTime()));
                                        bookingsAllBean.setCheckOut(new java.sql.Date(timestamp.getTime()));
                                        parsedDate = dateFormat.parse(viatorBookResponse.getData().getBookingDate());
                                        timestamp = new java.sql.Timestamp(parsedDate.getTime() + 1000 * 60 * 60 * 10);
                                        bookingsAllBean.setBookingDate(timestamp);
                                    } catch (Exception e) {
                                        errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:" + viatorItem.getItineraryId() + " completed at sunhotels side but failed to store CheckIn,CheckOut,BookingDate to databse");
                                    }
                                    bookingsAllBean.setUpdateDate(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute()));
                                    bookingsAllBean.setPayDate(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute()));
                                    if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                                        bookingsAllBean.setGsaId(subAgencyBean.getGsaId());
                                        gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()));
                                        if (gsaBean != null) {
                                            bookingsAllBean.setGsaMarkup(gsaBean.getOtlMkp());
                                            bookingsAllBean.setTopGsaName(gsaBean.getGsaName());
                                            if (viatorItem.getMerchantNetPrice() != null) {
                                                if (gsaBean.getOtlMkp() != null && !gsaBean.getOtlMkp().equals("")) {
                                                    BigDecimal priceWithComision = viatorItem.getMerchantNetPrice().add(viatorItem.getMerchantNetPrice().multiply(viatorComission)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                    BigDecimal gsaSale = priceWithComision.add(priceWithComision.multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                    bookingsAllBean.setGsaSale(String.valueOf(gsaSale));
                                                    if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                                        bookingsAllBean.setAgentMarkup(subAgencyBean.getOtlMkp());
                                                        bookingsAllBean.setAgentName(subAgencyBean.getAgentName());
                                                        agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                        totalBookingPrice = agentSale.add(totalBookingPrice);
                                                        bookingsAllBean.setAgentSale(String.valueOf(agentSale));
                                                        bookingsAllBean.setAgentEndSale(String.valueOf(agentSale));
                                                        bookingsAllBean.setSupplierSale(viatorItem.getMerchantNetPrice().toString());
                                                    } else {
                                                        errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:" + viatorItem.getItineraryId() + " completed at sunhotels side but sub agency with id:" + subAgencyBean.getId() + " has not hotel mark up");
                                                    }
                                                } else {
                                                    errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:" + viatorItem.getItineraryId() + " completed at sunhotels side but failed to store correctly to databse");
                                                }
                                            } else {
                                                errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:" + viatorItem.getItineraryId() + " completed at sunhotels side but price didn't came correctly at response");
                                            }
                                        } else {
                                            errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:" + viatorItem.getItineraryId() + " completed at sunhotels side but failed to store correctly to databse");
                                        }
                                    } else {
                                        errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:" + viatorItem.getItineraryId() + " completed at sunhotels side but failed to store correctly to databse");
                                    }

                                    Integer bookingId = BookingsAllDAO.storeBooking(bookingsAllBean);
                                    if (bookingId == 0)
                                        errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:" + viatorItem.getItineraryId() + " completed at sunhotels side but failed to store correctly to databse");


                                    /**
                                     * Store travellers
                                     */
                                    TravellerInfoBean travellerInfoBean;
                                    for (Traveller tr : atbItem.getTravellers()) {

                                        List<GPriceMatrixBean> pricematrix = GPriceMatrixDAO.getgPriceMatrixesByProductIdAndPlanId(atbItem.getProductId(), atbItem.getPlanId());
                                        if (pricematrix != null) {
                                            for (GPriceMatrixBean price : pricematrix) {
                                                if (tr.getAge() >= Integer.parseInt(price.getAgeFrom()) && tr.getAge() < Integer.parseInt(price.getAgeTo())) {
                                                    travellerInfoBean = new TravellerInfoBean();
                                                    travellerInfoBean.setTravelBirdthDate(String.valueOf(tr.getAge()));
                                                    travellerInfoBean.setBookingId(bookingCode);
                                                    travellerInfoBean.setTravelType(price.getPersonType());
                                                    travellerInfoBean.setTravelSurname(tr.getSurname());
                                                    travellerInfoBean.setTravelName(tr.getFirstname());
                                                    TravellerInfoDAO.storeTraveler(travellerInfoBean);
                                                    break;
                                                }
                                            }
                                        } else {
                                            errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:" + viatorItem.getItineraryId() + " completed at viator side but failed to store travelers to databse");
                                        }
                                    }

                                    /**
                                     * Store Transaction if subagency status is in real mode.
                                     */
                                    if (subAgencyBean.getXmlStatus().equals("1")) {
                                        if (agentSale != null) {
                                            subAgencyBean.setDeposit(BigDecimal.valueOf(Double.parseDouble(subAgencyBean.getDeposit())).subtract(agentSale).toString());
                                            if (SubAgencyDAO.updateSubAgentByName(subAgencyBean)) {
                                                errLogger.info("**********Booking with number :Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:" + viatorItem.getItineraryId() + " completed at viator side but failed to detuct the price from sub agency deposit at database.*********");
                                            } else {
                                                BookingTransactionBean bookingTransactionBean = new BookingTransactionBean();
                                                bookingTransactionBean.setAgentId(String.valueOf(subAgencyBean.getId()));
                                                bookingTransactionBean.setAgentName(subAgencyBean.getAgentName());
                                                bookingTransactionBean.setBookingId(bookingCode);
                                                bookingTransactionBean.setGsaId(subAgencyBean.getGsaId());
                                                bookingTransactionBean.setTransactionType("Charge");
                                                bookingTransactionBean.setTransCur(subAgencyBean.getCurrency());
                                                bookingTransactionBean.setTransNote("");
                                                bookingTransactionBean.setTransDate(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                                        dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                        dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute()));
                                                bookingTransactionBean.setTransRate(agentSale.toString());
                                                bookingTransactionBean.setTransType("Deposit");
                                                BookingTransactionDAO.storeTransaction(bookingTransactionBean);
                                            }
                                        }
                                    }


                                    /**
                                     * Response Item.
                                     */
                                    responseItem = new ResponseItem();
                                    responseItem.setBookingEngineId(viatorItem.getBookingEngineId());
                                    responseItem.setCity(product.getCityName());
                                    responseItem.setCountry(product.getCountryName());
                                    responseItem.setCurrencyCode(viatorItem.getCurrencyCode());
                                    responseItem.setDepartsFrom(viatorItem.getDepartsFrom());
                                    responseItem.setDeparturePoint(viatorItem.getDeparturePoint());
                                    responseItem.setDeparturePointAddress(viatorItem.getDeparturePointAddress());
                                    responseItem.setItemId(String.valueOf(viatorBookResponse.getData().getItemSummaries().indexOf(viatorItem)));
                                    responseItem.setLanguage(atbItem.getLanguage());
                                    responseItem.setMerchantCancellable(viatorItem.isMerchantCancellable());
                                    responseItem.setPickupHotelId(atbItem.getHotelId());
                                    responseItem.setPickupHotelName(viatorItem.getPickupHotelName());
                                    responseItem.setPickupPoint(atbItem.getPickupPoint());
                                    responseItem.setPlanId(atbItem.getPlanId());
                                    responseItem.setPlanIdDescription(viatorItem.getTourGradeDescription());
                                    responseItem.setPrice(agentSale);
                                    responseItem.setProductId(atbItem.getProductId());
                                    responseItem.setProductTitle(viatorItem.getProductTitle());
                                    responseItem.setServiceOption(atbItem.getServiceOption());
                                    responseItem.setSupplierName(viatorItem.getSupplierName());
                                    responseItem.setSupplierPhoneNumber(viatorItem.getSupplierPhoneNumber());
                                    responseItem.setTravelDate(viatorItem.getTravelDate());
                                    responseItem.setTravellers(atbItem.getTravellers());
                                    responseItems.add(responseItem);
                                    break;
                                }
                            }

                        }

                    }else{
                        bookInfoJSON.setErrorMessageText("Error: "+viatorBookResponse.getErrorMessage());
                        bookInfoJSON.setSuccess(false);
                        return bookInfoJSON;
                    }

                } else {
                    bookInfoJSON.setErrorMessageText("Communication Error");
                    bookInfoJSON.setSuccess(false);
                    return bookInfoJSON;
                }
            }


            /**
             * Book Atb Products
             */
            for (Beans.ViatorAPIBeans.Bookings.Book.Item atbItem : atbItems) {
                for (APIJSONs.ATBAPIJSONs.Product.Item requestItem : bookPOST.getItems()) {
                    if (atbItem.getProductCode().equals(requestItem.getProductId())) {

                        AProductTitleBean product = AProductTitleDAO.getProductById(requestItem.getProductId());

                        /**
                         * Store Booking Results.
                         */
                        String bookingCode = "";
                        BookingsAllBean bookingsAllBean = new BookingsAllBean();
                        bookingsAllBean.setProductId(String.valueOf(product.getId()));
                        bookingsAllBean.setProductTitle(product.getProductTitle());
                        bookingsAllBean.setCityName(product.getCityName());
                        bookingsAllBean.setCountryName(product.getCountryName());
                        bookingsAllBean.setAdittionalRequest(requestItem.getSpecialRequirements());
                        bookingsAllBean.setAgentCommission("");
                        bookingsAllBean.setAgentEndSaleCur(defaultCurrencyCode);
                        bookingsAllBean.setAgentId(String.valueOf(subAgencyBean.getId()));
                        bookingsAllBean.setPriceId("");
                        bookingsAllBean.setLiveGuide("");
                        bookingsAllBean.setBookletGuide("");
                        bookingsAllBean.setAudioGuide("");
                        if (requestItem.getServiceOption().equals("live"))
                            bookingsAllBean.setLiveGuide(requestItem.getLanguage());
                        else if (requestItem.getServiceOption().equals("booklet"))
                            bookingsAllBean.setBookletGuide(requestItem.getLanguage());
                        else if (requestItem.getServiceOption().equals("audio"))
                            bookingsAllBean.setAudioGuide(requestItem.getLanguage());

                        if (product.getTypeOfProduct().equals("1")) {
                            bookingsAllBean.setProductType("TRS");
                            bookingCode = "TRS-" + generalBookCode + "-" + storedItemNumber++;
                        } else if (product.getTypeOfProduct().equals("2")) {
                            bookingsAllBean.setProductType("DTR");
                            bookingCode = "DTR-" + generalBookCode + "-" + storedItemNumber++;
                        } else if (product.getTypeOfProduct().equals("3")) {
                            bookingsAllBean.setProductType("MTR");
                            bookingCode = "MTR-" + generalBookCode + "-" + storedItemNumber++;
                        } else if (product.getTypeOfProduct().equals("4")) {
                            bookingsAllBean.setProductType("SHR");
                            bookingCode = "SHR-" + generalBookCode + "-" + storedItemNumber++;
                        } else if (product.getTypeOfProduct().equals("5")) {
                            bookingsAllBean.setProductType("EVT");
                            bookingCode = "EVT-" + generalBookCode + "-" + storedItemNumber++;
                        }
                        bookingsAllBean.setBookingId(bookingCode);
                        bookingsAllBean.setBasketId("");
                        bookingsAllBean.setConfirmationNo("");
                        bookingsAllBean.setPlanId(requestItem.getPlanId());
                        bookingsAllBean.setContactTel(bookPOST.getBooker().getCellPhone());
                        bookingsAllBean.setDiscountAmount("");
                        bookingsAllBean.setDiscountMarkup("");
                        bookingsAllBean.setPayType("Deposit");
                        bookingsAllBean.setPosId("");
                        bookingsAllBean.setSaleCurrency(defaultCurrencyCode);
                        if (subAgencyBean.getXmlStatus().equals("1")) {
                            bookingsAllBean.setStatus("4");
                            bookingsAllBean.setStatusReason("");
                        } else {
                            bookingsAllBean.setStatus("7");
                            bookingsAllBean.setStatusReason("XML-Test");
                        }
                        bookingsAllBean.setSupplierCurrency(defaultCurrencyCode);
                        bookingsAllBean.setTotalPax(String.valueOf(requestItem.getTravellers().size()));
                        for (Traveller tr : requestItem.getTravellers()) {
                            if (tr.isLeadTraveller())
                                bookingsAllBean.setTourLeader(tr.getFirstname() + " " + tr.getSurname());
                        }
                        bookingsAllBean.setXmlAgent(subAgencyBean.getAgentName());
                        bookingsAllBean.setXmlBookRef("");
                        if (requestItem.getHotelId() != null && !requestItem.getHotelId().equals("")) {
                            EPickupPointBean pickupPoint = EPickupPointDAO.getePickupPointByHotelId(requestItem.getHotelId());
                            if (pickupPoint != null) {
                                bookingsAllBean.setCommon1(pickupPoint.getHotelPickupPoint());
                                bookingsAllBean.setCommon7(pickupPoint.getStartingPoint());
                                bookingsAllBean.setCommon8(pickupPoint.getHotelId());
                            } else {
                                bookingsAllBean.setCommon1(requestItem.getPickupPoint());
                                bookingsAllBean.setCommon7("");
                                bookingsAllBean.setCommon8("");
                            }
                        } else if (requestItem.getPickupPoint() != null) {
                            bookingsAllBean.setCommon1(requestItem.getPickupPoint());
                            bookingsAllBean.setCommon7("");
                            bookingsAllBean.setCommon8("");
                        } else {
                            bookingsAllBean.setCommon1("");
                            bookingsAllBean.setCommon7("");
                            bookingsAllBean.setCommon8("");
                        }
                        bookingsAllBean.setCommon2("");
                        bookingsAllBean.setCommon3("");
                        List<IAvailableTimeBean> departureTimes = IAvailableTimeDAO.getiAvailableTimesByProductId(requestItem.getProductId(), requestItem.getPlanId());
                        if (departureTimes != null && departureTimes.size() > 0) {
                            bookingsAllBean.setCommon4(departureTimes.get(0).getStartTime());
                            bookingsAllBean.setCommon13(departureTimes.get(0).getStartTime());
                        } else {
                            bookingsAllBean.setCommon4("");
                            bookingsAllBean.setCommon13("");
                        }
                        bookingsAllBean.setCommon5("");
                        bookingsAllBean.setCommon6("");
                        bookingsAllBean.setCommon9("");
                        bookingsAllBean.setCommon10("");
                        bookingsAllBean.setCommon11("");
                        bookingsAllBean.setCommon12("");
                        bookingsAllBean.setCommon14("");
                        bookingsAllBean.setCommon15("");
                        bookingsAllBean.setInvoiceAmount("");
                        bookingsAllBean.setInvoiceNo("");
                        bookingsAllBean.setInvoiceStatus("");
                        bookingsAllBean.setBasis("");
                        bookingsAllBean.setUpdater("XML-API");
                        bookingsAllBean.setPaying("agent");
                        bookingsAllBean.setSupplierReferences("");
                        bookingsAllBean.setSupplierName("Atb Holidays");//todo
                        bookingsAllBean.setSupplierId("387");//todo
                        if (bookPOST.getCustomerCountry() != null)
                            bookingsAllBean.setContactCountryCode(bookPOST.getCustomerCountry());
                        else
                            bookingsAllBean.setContactCountryCode("");
                        if (bookPOST.getBooker().getEmail() != null)
                            bookingsAllBean.setContactEmail(bookPOST.getBooker().getEmail());
                        else
                            bookingsAllBean.setContactEmail("");
                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date parsedDate = dateFormat.parse(requestItem.getTravelDate());
                            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime() + 1000 * 60 * 60 * 10);
                            bookingsAllBean.setCheckIn(new java.sql.Date(timestamp.getTime()));
                            bookingsAllBean.setCheckOut(new java.sql.Date(timestamp.getTime()));
                            parsedDate = dateFormat.parse(dateTime.toString());
                            timestamp = new java.sql.Timestamp(parsedDate.getTime() + 1000 * 60 * 60 * 10);
                            bookingsAllBean.setBookingDate(timestamp);
                        } catch (Exception e) {
                            errLogger.info("Booking with generalBookCode :" + generalBookCode + "and atb item with id:" + storedItemNumber + " completed at sunhotels side but failed to store CheckIn,CheckOut,BookingDate to databse");
                        }
                        bookingsAllBean.setUpdateDate(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute()));
                        bookingsAllBean.setPayDate(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute()));
                        if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                            bookingsAllBean.setGsaId(subAgencyBean.getGsaId());
                            gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()));
                            if (gsaBean != null) {
                                bookingsAllBean.setGsaMarkup(gsaBean.getOtlMkp());
                                bookingsAllBean.setTopGsaName(gsaBean.getGsaName());
                                if (gsaBean.getOtlMkp() != null && !gsaBean.getOtlMkp().equals("")) {
                                    BigDecimal gsaSale = atbProductPrices.get(atbItems.indexOf(atbItem)).add(atbProductPrices.get(atbItems.indexOf(atbItem)).multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                    bookingsAllBean.setGsaSale(String.valueOf(gsaSale));
                                    if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                        bookingsAllBean.setAgentMarkup(subAgencyBean.getOtlMkp());
                                        bookingsAllBean.setAgentName(subAgencyBean.getAgentName());
                                        agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                        totalBookingPrice = agentSale.add(totalBookingPrice);
                                        bookingsAllBean.setAgentSale(String.valueOf(agentSale));
                                        bookingsAllBean.setAgentEndSale(String.valueOf(agentSale));
                                        bookingsAllBean.setSupplierSale(atbProductPrices.get(atbItems.indexOf(atbItem)).toString());
                                    } else {
                                        errLogger.info("Booking with generalBookCode :" + generalBookCode + "and atb item id:" + storedItemNumber + " completed at sunhotels side but sub agency with id:" + subAgencyBean.getId() + " has not hotel mark up");
                                    }
                                } else {
                                    errLogger.info("Booking with generalBookCode :" + generalBookCode + "and atb item id:" + storedItemNumber + " completed at sunhotels side but failed to store correctly to databse");
                                }
                            } else {
                                errLogger.info("Booking with generalBookCode :" + generalBookCode + "and atb item id:" + storedItemNumber + " completed at sunhotels side but failed to store correctly to databse");
                            }
                        } else {
                            errLogger.info("Booking with generalBookCode :" + generalBookCode + "and atb item id:" + storedItemNumber + " completed at sunhotels side but failed to store correctly to databse");
                        }

                        Integer bookingId = BookingsAllDAO.storeBooking(bookingsAllBean);
                        if (bookingId == 0)
                            errLogger.info("Booking with generalBookCode :" + generalBookCode + "and atb item id:" + storedItemNumber + " completed at sunhotels side but failed to store correctly to databse");


                        /**
                         * Store travellers
                         */
                        TravellerInfoBean travellerInfoBean;
                        for (Traveller tr : requestItem.getTravellers()) {

                            List<GPriceMatrixBean> pricematrix = GPriceMatrixDAO.getgPriceMatrixesByProductIdAndPlanId(requestItem.getProductId(), requestItem.getPlanId());
                            if (pricematrix != null) {
                                for (GPriceMatrixBean price : pricematrix) {
                                    if (tr.getAge() >= Integer.parseInt(price.getAgeFrom()) && tr.getAge() < Integer.parseInt(price.getAgeTo())) {
                                        travellerInfoBean = new TravellerInfoBean();
                                        travellerInfoBean.setTravelBirdthDate(String.valueOf(tr.getAge()));
                                        travellerInfoBean.setBookingId(bookingCode);
                                        travellerInfoBean.setTravelType(price.getPersonType());
                                        travellerInfoBean.setTravelSurname(tr.getSurname());
                                        travellerInfoBean.setTravelName(tr.getFirstname());
                                        TravellerInfoDAO.storeTraveler(travellerInfoBean);
                                        break;
                                    }
                                }
                            } else {
                                errLogger.info("Booking with generalBookCode :" + generalBookCode + "and atb item id:" + storedItemNumber + " completed at viator side but failed to store travelers to databse");
                            }
                        }

                        /**
                         * Store Transaction if subagency status is in real mode.
                         */
                        if (subAgencyBean.getXmlStatus().equals("1")) {
                            if (agentSale != null) {
                                subAgencyBean.setDeposit(BigDecimal.valueOf(Double.parseDouble(subAgencyBean.getDeposit())).subtract(agentSale).toString());
                                if (SubAgencyDAO.updateSubAgentByName(subAgencyBean)) {
                                    errLogger.info("**********Booking with number :Booking with generalBookCode :" + generalBookCode + "and atb item id:" + storedItemNumber + " completed at viator side but failed to detuct the price from sub agency deposit at database.*********");
                                } else {
                                    BookingTransactionBean bookingTransactionBean = new BookingTransactionBean();
                                    bookingTransactionBean.setAgentId(String.valueOf(subAgencyBean.getId()));
                                    bookingTransactionBean.setAgentName(subAgencyBean.getAgentName());
                                    bookingTransactionBean.setBookingId(bookingCode);
                                    bookingTransactionBean.setGsaId(subAgencyBean.getGsaId());
                                    bookingTransactionBean.setTransactionType("Charge");
                                    bookingTransactionBean.setTransCur(subAgencyBean.getCurrency());
                                    bookingTransactionBean.setTransNote("");
                                    bookingTransactionBean.setTransDate(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute()));
                                    bookingTransactionBean.setTransRate(agentSale.toString());
                                    bookingTransactionBean.setTransType("Deposit");
                                    BookingTransactionDAO.storeTransaction(bookingTransactionBean);
                                }
                            }
                        }


                        /**
                         * Response Item.
                         */
                        responseItem = new ResponseItem();
                        responseItem.setBookingEngineId("");
                        responseItem.setCity(product.getCityName());
                        responseItem.setCountry(product.getCountryName());
                        responseItem.setCurrencyCode(product.getCurrencyCode());
                        responseItem.setDepartsFrom(product.getaPoint());
                        responseItem.setDeparturePoint(product.getaPoint());
                        responseItem.setDeparturePointAddress(product.getaPoint());
                        responseItem.setItemId(String.valueOf(atbItems.indexOf(atbItem)));
                        responseItem.setLanguage(requestItem.getLanguage());
                        List<BProductDetailBean> bProductDetailBean = BProductDetailDAO.getBProductDetailsByProductId(requestItem.getProductId());
                        if (bProductDetailBean != null && bProductDetailBean.size() > 0 && !bProductDetailBean.get(0).getMerchantCancellable().equals("non-refundable"))
                            responseItem.setMerchantCancellable(true);
                        else
                            responseItem.setMerchantCancellable(false);
                        responseItem.setPickupHotelId(requestItem.getHotelId());
                        responseItem.setPickupHotelName("");
                        responseItem.setPickupPoint(requestItem.getPickupPoint());
                        responseItem.setPlanId(requestItem.getPlanId());
                        responseItem.setPlanIdDescription(FPricePlanDAO.getfPricePlansById(Integer.parseInt(requestItem.getPlanId())).getPlanTitle());
                        responseItem.setPrice(agentSale);
                        responseItem.setProductId(requestItem.getProductId());
                        responseItem.setProductTitle(product.getProductTitle());
                        responseItem.setServiceOption(requestItem.getServiceOption());
                        responseItem.setSupplierName(product.getMainSupplierName());
                        responseItem.setSupplierPhoneNumber("");
                        responseItem.setTravelDate(requestItem.getTravelDate());
                        responseItem.setTravellers(requestItem.getTravellers());
                        responseItems.add(responseItem);
                    }
                }
            }

            /**
             * Response.
             */
            BookResult bookResult = new BookResult();
            bookResult.setBooker(bookPOST.getBooker());
            bookResult.setBookingId(generalBookCode);
            bookResult.setBookingStatus("Active");
            bookResult.setCurrencyCode(subAgencyBean.getCurrency());
            bookResult.setTotalPrice(totalBookingPrice);
            bookResult.setVoucher("");
            bookResult.setItems(responseItems);
            bookInfoJSON.setBookingInfo(bookResult);
            bookResult.setBookingDate(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute()));

        }
        return bookInfoJSON;

    }


}
