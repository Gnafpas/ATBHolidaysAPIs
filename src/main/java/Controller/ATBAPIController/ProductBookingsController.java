package Controller.ATBAPIController;

import APIJSONs.ATBAPIJSONs.Product.*;
import APIJSONs.ATBAPIJSONs.Product.Traveller;
import Beans.ATBDBBeans.KalitaonProduct.*;
import Beans.ATBDBBeans.KalitaonSystem.*;
import Beans.ViatorAPIBeans.Bookings.Book.*;
import Beans.ViatorAPIBeans.Bookings.Book.BookAPIJSON;
import Beans.ViatorAPIBeans.Bookings.Book.BookPOST;
import Beans.ViatorAPIBeans.Bookings.CalculatePrice.*;
import Beans.ViatorDBBeans.ViatorProductTourGradeLanguageServicesBean;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.*;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.*;
import DAOs.ViatorAPIDAOs.BookingsAPIDAO;
import DAOs.ViatorDBDAOs.ViatorProductTourGradeLanguageServicesDAO;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.defaultCurrencyCode;
import static Helper.ProjectProperties.viatorComission;

/**
 * Created by George on 23/10/2017.
 */
@RestController
public class ProductBookingsController {

    @RequestMapping("/product/booking/availability")
    public AvailabilityJSON availability(@RequestParam(value = "productId", defaultValue = "") String productId,
                                         @RequestParam(value = "planId", defaultValue = "") String planId) {

        AvailabilityJSON availabilityJSON = new AvailabilityJSON();
        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        availabilityJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");

        List<HAvailableDateBean> availableDates=HAvailableDateDAO.gethAvailableDatesByProductId(productId,planId);
        List<HSpecialDateBean> specialDates=HSpecialDateDAO.getSpecialDatesByProductId(productId,planId);
        List<HStopsaleDateBean> stopsaleDates=HStopsaleDateDAO.gethStopsaleDatesByProductId(productId,planId);
        List<IAvailableTimeBean> availableTime=IAvailableTimeDAO.getiAvailableTimesByProductId(productId,planId);

        Availability availability;
        boolean planIdExists;
        if(availableDates!=null) {
            for(HAvailableDateBean ad:availableDates) {
                planIdExists=false;
                for(Availability a:availabilityJSON.getData()){
                    if(a.getPlanId().equals(ad.getPlanId())) {
                        a.getAvailableDates().add(ad);
                        planIdExists=true;
                        break;
                    }
                }
                if(!planIdExists) {
                    availability = new Availability();
                    availability.getAvailableDates().add(ad);
                    availability.setPlanId(ad.getPlanId());
                    availabilityJSON.getData().add(availability);
                }
            }
        }

        if(specialDates!=null) {
            for(HSpecialDateBean sd:specialDates) {
                planIdExists=false;
                for(Availability a:availabilityJSON.getData()){
                    if(a.getPlanId().equals(sd.getPlanId())) {
                        a.getSpecialDates().add(sd);
                        planIdExists=true;
                        break;
                    }
                }
                if(!planIdExists) {
                    availability = new Availability();
                    availability.getSpecialDates().add(sd);
                    availability.setPlanId(sd.getPlanId());
                    availabilityJSON.getData().add(availability);
                }
            }
        }

        if(stopsaleDates!=null) {
            for(HStopsaleDateBean sd:stopsaleDates) {
                planIdExists=false;
                for(Availability a:availabilityJSON.getData()){
                    if(a.getPlanId().equals(sd.getPlanId())) {
                        a.getStopsaleDates().add(sd);
                        planIdExists=true;
                        break;
                    }
                }
                if(!planIdExists) {
                    availability = new Availability();
                    availability.getStopsaleDates().add(sd);
                    availability.setPlanId(sd.getPlanId());
                    availabilityJSON.getData().add(availability);
                }
            }
        }

        if(availableTime!=null) {
            for(IAvailableTimeBean at:availableTime) {
                planIdExists=false;
                for(Availability a:availabilityJSON.getData()){
                    if(a.getPlanId().equals(at.getPlanId())) {
                        a.getAvailableTime().add(at);
                        planIdExists=true;
                        break;
                    }
                }
                if(!planIdExists) {
                    availability = new Availability();
                    availability.getAvailableTime().add(at);
                    availability.setPlanId(at.getPlanId());
                    availabilityJSON.getData().add(availability);
                }
            }
        }

        availabilityJSON.setTotalCount(availabilityJSON.getData().size());
        if (availableTime== null || stopsaleDates == null ||
            specialDates == null || availableDates == null ) {
              availabilityJSON.setSuccess(false);
              availabilityJSON.setErrorMessageText("Database Communication Error.");
        }

        return availabilityJSON;
    }

    @RequestMapping("/product/booking/pricingmatrix")
    public PricingmatrixJSON pricingmatrix(@RequestParam(value = "productId", defaultValue = "") String productId,
                                           @RequestParam(value = "planId", defaultValue = "") String planId) {

        PricingmatrixJSON pricingmatrixJSON = new PricingmatrixJSON();
        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        pricingmatrixJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");

        List<GPriceMatrixBean> priceMatrixes=GPriceMatrixDAO.getgPriceMatrixesByProductIdAndPlanId(productId,planId);
        boolean planIdExists;
        Pricingmatrix pricingmatrix;
        if(priceMatrixes!=null) {
            for(GPriceMatrixBean pm:priceMatrixes) {
                planIdExists=false;
                for(Pricingmatrix p:pricingmatrixJSON.getData()){
                    if(p.getPlanId().equals(pm.getPlanId())) {
                        p.getPriceMatrix().add(pm);
                        planIdExists=true;
                        break;
                    }
                }
                if(!planIdExists) {
                    pricingmatrix = new Pricingmatrix();
                    pricingmatrix.getPriceMatrix().add(pm);
                    pricingmatrix.setPlanId(pm.getPlanId());
                    pricingmatrixJSON.getData().add(pricingmatrix);
                }
            }
        }
        pricingmatrixJSON.setTotalCount(pricingmatrixJSON.getData().size());
        if (priceMatrixes== null ) {
            pricingmatrixJSON.setSuccess(false);
            pricingmatrixJSON.setErrorMessageText("Database Communication Error.");
        }
        pricingmatrixJSON.setTotalCount(pricingmatrixJSON.getData().size());
        return pricingmatrixJSON;
    }

    @RequestMapping(value = "/product/booking/book", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public APIJSONs.ATBAPIJSONs.Product.BookAPIJSON bookViator(@RequestBody APIJSONs.ATBAPIJSONs.Product.BookPOST bookPOST,@RequestParam("apiKey") String apiKey) {

        APIJSONs.ATBAPIJSONs.Product.BookAPIJSON bookInfoJSON=new APIJSONs.ATBAPIJSONs.Product.BookAPIJSON();
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        bookInfoJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");


        SubAgencyBean subAgencyBean;
        String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + apiKey;
        String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
        subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);
        if (subAgencyBean != null) {


            BigDecimal atbTotalNetPrice=new BigDecimal(0);
            BigDecimal viatorTotalPrice=new BigDecimal(0);

            /**
             * Preparing items for calculate price request and  book viator request.
             */
            Beans.ViatorAPIBeans.Bookings.Book.Item item;
            List<Beans.ViatorAPIBeans.Bookings.Book.Item> items = new ArrayList<>();
            Beans.ViatorAPIBeans.Bookings.CalculatePrice.Item cItem;
            List<Beans.ViatorAPIBeans.Bookings.CalculatePrice.Item> cItems=new ArrayList<>();
            int distributorItemRef = 0;
            PartnerItemDetail partnerItemDetail = new PartnerItemDetail();

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


                cItem=new Beans.ViatorAPIBeans.Bookings.CalculatePrice.Item();
                cItem.setProductCode(product.getProductCode());
                cItem.setTourGradeCode(priceplan.getTourGradeCode());
                cItem.setTravelDate(it.getTravelDate());
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
                        if(tr.getAge()>=Integer.parseInt(price.getAgeFrom()) && tr.getAge()<Integer.parseInt(price.getAgeTo())){
                            if(price.getPersonType().equals("adult")) {
                                cTraveller.setBandId(1);
                                traveller.setBandId(1);
                                adultsCount++;
                                break;
                            }
                            else if(price.getPersonType().equals("child")){
                                cTraveller.setBandId(2);
                                traveller.setBandId(2);
                                childCount++;
                                break;
                            }
                            else if(price.getPersonType().equals("infant")){
                                cTraveller.setBandId(3);
                                traveller.setBandId(3);
                                infantCount++;
                                break;
                            }
                            else if(price.getPersonType().equals("youth")){
                                cTraveller.setBandId(4);
                                traveller.setBandId(4);
                                youthCount++;
                                break;
                            }
                            else if(price.getPersonType().equals("senior")){
                                cTraveller.setBandId(5);
                                traveller.setBandId(5);
                                seniorCount++;
                                break;
                            }
                            else {
                                bookInfoJSON.setSuccess(false);
                                bookInfoJSON.setErrorMessageText("Couldn't find person type for traveler:"+tr.getFirstname()+","+tr.getSurname()+" for product with id:"+it.getPlanId());
                                return bookInfoJSON;
                            }
                        }
                    }
                    cTravellers.add(cTraveller);
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
                for(GPriceMatrixBean price:pricematrix){
                    if(price.getPersonType().equals("adult")) {
                        if(adultsCount >=price.getMinCountRequired() && adultsCount <=price.getMaxCountRequired()){
                            atbNetPrice=new BigDecimal(Double.parseDouble(price.getPriceNet())).setScale(2, BigDecimal.ROUND_HALF_UP);
                            viatorprice= ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(105),2, RoundingMode.HALF_UP));
                            atbTotalNetPrice= atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(adultsCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                            viatorTotalPrice= viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(adultsCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                            atLeastOneAdult=true;
                        }
                        if(price.getMaxCountRequired()>maxPeoplerequired)
                            maxPeoplerequired=price.getMaxCountRequired();
                        if(price.getMinCountRequired()<minPeoplerequired)
                            minPeoplerequired=price.getMinCountRequired();
                    }
                    else if(price.getPersonType().equals("child")){
                        if(childCount >=price.getMinCountRequired() && childCount <=price.getMaxCountRequired()){
                            atbNetPrice=new BigDecimal(Double.parseDouble(price.getPriceNet())).setScale(2, BigDecimal.ROUND_HALF_UP);
                            viatorprice= ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(100).add(Helper.ProjectProperties.viatorComission.multiply(new BigDecimal(100))),2, RoundingMode.HALF_UP));
                            atbTotalNetPrice= atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(childCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                            viatorTotalPrice= viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(childCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                        }
                    }
                    else if(price.getPersonType().equals("infant")){
                        if(infantCount >=price.getMinCountRequired() && infantCount <=price.getMaxCountRequired()){
                            atbNetPrice=new BigDecimal(Double.parseDouble(price.getPriceNet())).setScale(2, BigDecimal.ROUND_HALF_UP);
                            viatorprice= ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(100).add(Helper.ProjectProperties.viatorComission.multiply(new BigDecimal(100))),2, RoundingMode.HALF_UP));
                            atbTotalNetPrice= atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(infantCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                            viatorTotalPrice= viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(infantCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                        }
                    }
                    else if(price.getPersonType().equals("youth")){
                        if(youthCount >=price.getMinCountRequired() && youthCount <=price.getMaxCountRequired()){
                            atbNetPrice=new BigDecimal(Double.parseDouble(price.getPriceNet())).setScale(2, BigDecimal.ROUND_HALF_UP);
                            viatorprice= ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(100).add(Helper.ProjectProperties.viatorComission.multiply(new BigDecimal(100))),2, RoundingMode.HALF_UP));
                            atbTotalNetPrice= atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(youthCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                            viatorTotalPrice= viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(youthCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                        }
                    }
                    else if(price.getPersonType().equals("senior")){
                        if(seniorCount >=price.getMinCountRequired() && seniorCount <=price.getMaxCountRequired()){
                            atbNetPrice=new BigDecimal(Double.parseDouble(price.getPriceNet())).setScale(2, BigDecimal.ROUND_HALF_UP);
                            viatorprice= ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(100).add(Helper.ProjectProperties.viatorComission.multiply(new BigDecimal(100))),2, RoundingMode.HALF_UP));
                            atbTotalNetPrice= atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(seniorCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                            viatorTotalPrice= viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(seniorCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
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

                cItem.setTravellers(cTravellers);
                cItems.add(cItem);
                item.setTravellers(travellers);
                items.add(item);
            }


            /**
             * Check if viator has the same totalprice as we stored in database at the last update.
             */
            CalculatePriceAPIJSON calculatepriceJson;
            CalculatePricePOST calculatePricePOST=new CalculatePricePOST();
            calculatePricePOST.setItems(cItems);
            calculatePricePOST.setPartnerDetail(null);
            calculatePricePOST.setCurrencyCode(defaultCurrencyCode);
            calculatepriceJson=BookingsAPIDAO.calculateprice(calculatePricePOST);
            if(calculatepriceJson!=null && calculatepriceJson.isSuccess()){
                if(calculatepriceJson.getData().getItineraryNewPrice().compareTo(viatorTotalPrice)==1) {//todo what if the updated price is bigger than the one we have in db
                    bookInfoJSON.setSuccess(false);
                    bookInfoJSON.setErrorMessageText("Total price increased because some of the products in the booking list changed their price.Pleace contact at george.nafpaktitis@atbholidays.com");
                    return bookInfoJSON;
                }else{

                    /**
                     * Check if subagency has the amount on it's deposit
                     */
                    GsaBean gsaBean=null;
                    BigDecimal agentSale=null;
                    if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                        gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()));
                        if (gsaBean != null) {
                                if (gsaBean.getOtlMkp() != null && !gsaBean.getOtlMkp().equals("")) {
                                    BigDecimal priceWithComision=calculatepriceJson.getData().getItineraryNewPrice().add(calculatepriceJson.getData().getItineraryNewPrice().multiply(viatorComission)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                    BigDecimal gsaSale = priceWithComision.add(priceWithComision.multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
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


                    /**
                     * Make the booking in viator side and update database tables.
                     */
                    BookPOST viatorBookPOST=new BookPOST();
                    if(subAgencyBean.getXmlStatus().equals("1"))
                        viatorBookPOST.setDemo(false);
                    else
                        viatorBookPOST.setDemo(true);
                    viatorBookPOST.setItems(items);
                    viatorBookPOST.setNewsletterSignUp(false);
                    viatorBookPOST.setBooker(bookPOST.getBooker());
                    viatorBookPOST.setCurrencyCode(defaultCurrencyCode);
                    PartnerDetail partenerDetail = new PartnerDetail();
                    partenerDetail.setDistributorRef("587687687689");//todo
                    viatorBookPOST.setPartnerDetail(partenerDetail);
                    BookAPIJSON  viatorBookResponse=BookingsAPIDAO.book(viatorBookPOST);

                    if(viatorBookResponse!=null && viatorBookResponse.isSuccess() ){

                        if(viatorBookResponse.getData()!=null && viatorBookResponse.getData().getItemSummaries()!=null) {


                            BigDecimal totalBookingPrice=new BigDecimal(0);
                            List<ResponseItem> responseItems=new ArrayList<>();
                            ResponseItem responseItem;
                            for(ItemSummary viatorItem:viatorBookResponse.getData().getItemSummaries()) {
                                for(APIJSONs.ATBAPIJSONs.Product.Item atbItem:bookPOST.getItems()){
                                    AProductTitleBean product=AProductTitleDAO.getProductById(atbItem.getProductId());
                                    if(viatorItem.getProductCode().equals(product.getProductCode())) {


                                        /**
                                         * Store Booking Results to Hotel_Bookings_All table
                                         */
                                        String bookingCode="";
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

                                        if(product.getTypeOfProduct().equals("1")) {
                                            bookingsAllBean.setProductType("TRS");
                                            bookingCode = "TRS-" + viatorBookResponse.getData().getItineraryId() +"-"+viatorBookResponse.getData().getItemSummaries().indexOf(viatorItem);
                                        }
                                        else if(product.getTypeOfProduct().equals("2")){
                                            bookingsAllBean.setProductType("DTR");
                                            bookingCode = "DTR-" + viatorBookResponse.getData().getItineraryId() +"-"+viatorBookResponse.getData().getItemSummaries().indexOf(viatorItem);
                                        }
                                        else if(product.getTypeOfProduct().equals("3")){
                                            bookingsAllBean.setProductType("MTR");
                                            bookingCode = "MTR-" + viatorBookResponse.getData().getItineraryId() +"-"+viatorBookResponse.getData().getItemSummaries().indexOf(viatorItem);
                                        }
                                        else if(product.getTypeOfProduct().equals("4")){
                                            bookingsAllBean.setProductType("SHR");
                                            bookingCode = "SHR-" + viatorBookResponse.getData().getItineraryId() +"-"+viatorBookResponse.getData().getItemSummaries().indexOf(viatorItem);
                                        }
                                        else if(product.getTypeOfProduct().equals("5")){
                                            bookingsAllBean.setProductType("EVT");
                                            bookingCode = "EVT-" + viatorBookResponse.getData().getItineraryId() +"-"+viatorBookResponse.getData().getItemSummaries().indexOf(viatorItem);
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

                                        if(subAgencyBean.getXmlStatus().equals("1")) {
                                            bookingsAllBean.setStatus("4");
                                            bookingsAllBean.setStatusReason("");
                                        }
                                        else {
                                            bookingsAllBean.setStatus("7");
                                            bookingsAllBean.setStatusReason("XML-Test");
                                        }
                                        bookingsAllBean.setSupplierCurrency(defaultCurrencyCode);

                                        bookingsAllBean.setTotalPax(String.valueOf(atbItem.getTravellers().size()));

                                        for(Traveller tr:atbItem.getTravellers()) {
                                            if(tr.isLeadTraveller())
                                                bookingsAllBean.setTourLeader(tr.getFirstname()+" "+tr.getSurname());
                                        }

                                        bookingsAllBean.setXmlAgent(subAgencyBean.getAgentName());
                                        bookingsAllBean.setXmlBookRef("");


                                        if(atbItem.getHotelId()!=null && !atbItem.getHotelId().equals("")) {
                                            EPickupPointBean pickupPoint = EPickupPointDAO.getePickupPointByHotelId(atbItem.getHotelId());
                                            if (pickupPoint != null) {
                                                bookingsAllBean.setCommon1(pickupPoint.getHotelPickupPoint());
                                                bookingsAllBean.setCommon7(pickupPoint.getStartingPoint());
                                                bookingsAllBean.setCommon8(pickupPoint.getHotelId());
                                            }
                                            else {
                                                bookingsAllBean.setCommon1(atbItem.getPickupPoint());
                                                bookingsAllBean.setCommon7("");
                                                bookingsAllBean.setCommon8("");
                                            }
                                        }else if(atbItem.getPickupPoint()!=null) {
                                            bookingsAllBean.setCommon1(atbItem.getPickupPoint());
                                            bookingsAllBean.setCommon7("");
                                            bookingsAllBean.setCommon8("");
                                        }
                                        else {
                                            bookingsAllBean.setCommon1("");
                                            bookingsAllBean.setCommon7("");
                                            bookingsAllBean.setCommon8("");
                                        }

                                        bookingsAllBean.setCommon2("");
                                        bookingsAllBean.setCommon3("");

                                        List<IAvailableTimeBean> departureTimes=IAvailableTimeDAO.getiAvailableTimesByProductId(atbItem.getProductId(),atbItem.getPlanId());
                                        if(departureTimes!=null && departureTimes.size()>0) {
                                            bookingsAllBean.setCommon4(departureTimes.get(0).getStartTime());
                                            bookingsAllBean.setCommon13(departureTimes.get(0).getStartTime());
                                        }
                                        else {
                                            bookingsAllBean.setCommon4("");
                                            bookingsAllBean.setCommon13("");
                                        }
                                        bookingsAllBean.setCommon5("");
                                        bookingsAllBean.setCommon6("");
                                        bookingsAllBean.setCommon9("");
                                        bookingsAllBean.setCommon10("VT"+String.valueOf(viatorBookResponse.getData().getItineraryId()));
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
                                            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime()+ 1000 * 60 * 60 * 10);
                                            bookingsAllBean.setCheckIn(new java.sql.Date(timestamp.getTime()));
                                            bookingsAllBean.setCheckOut(new java.sql.Date(timestamp.getTime()));
                                            parsedDate = dateFormat.parse(viatorBookResponse.getData().getBookingDate());
                                            timestamp = new java.sql.Timestamp(parsedDate.getTime());
                                            bookingsAllBean.setBookingDate(timestamp);
                                        } catch(Exception e) {
                                            e.printStackTrace();
                                            return bookInfoJSON;
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
                                                if (viatorItem.getMerchantNetPrice() != null ) {
                                                    if (gsaBean.getOtlMkp() != null && !gsaBean.getOtlMkp().equals("")) {
                                                        BigDecimal priceWithComision=viatorItem.getMerchantNetPrice().add(viatorItem.getMerchantNetPrice().multiply(viatorComission)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                        BigDecimal gsaSale = priceWithComision.add(priceWithComision.multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                                bookingsAllBean.setGsaSale(String.valueOf(gsaSale));
                                                                if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                                                    bookingsAllBean.setAgentMarkup(subAgencyBean.getOtlMkp());
                                                                    bookingsAllBean.setAgentName(subAgencyBean.getAgentName());
                                                                    agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                                    totalBookingPrice=agentSale.add(totalBookingPrice);
                                                                    bookingsAllBean.setAgentSale(String.valueOf(agentSale));
                                                                    bookingsAllBean.setAgentEndSale(String.valueOf(agentSale));
                                                                    bookingsAllBean.setSupplierSale((gsaSale.multiply(new BigDecimal(100))).divide(new BigDecimal(Integer.parseInt(gsaBean.getOtlMkp()) + 100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                                                                } else {
                                                                    errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:"+viatorItem.getItineraryId()+" completed at sunhotels side but sub agency with id:" + subAgencyBean.getId() + " has not hotel mark up");
                                                                }


                                                    } else {
                                                        errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:"+viatorItem.getItineraryId()+" completed at sunhotels side but failed to store correctly to databse");
                                                    }
                                                } else {
                                                    errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:"+viatorItem.getItineraryId()+ " completed at sunhotels side but price didn't came correctly at response");
                                                }
                                            } else {
                                                errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:"+viatorItem.getItineraryId()+" completed at sunhotels side but failed to store correctly to databse");
                                            }
                                        } else {
                                            errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:"+viatorItem.getItineraryId()+" completed at sunhotels side but failed to store correctly to databse");
                                        }

                                        Integer bookingId = BookingsAllDAO.storeBooking(bookingsAllBean);
                                        if (bookingId == 0)
                                            errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:"+viatorItem.getItineraryId()+" completed at sunhotels side but failed to store correctly to databse");


                                        TravellerInfoBean  travellerInfoBean;
                                        for(Traveller tr:atbItem.getTravellers()){

                                            List<GPriceMatrixBean> pricematrix= GPriceMatrixDAO.getgPriceMatrixesByProductIdAndPlanId(atbItem.getProductId(),atbItem.getPlanId());
                                            if(pricematrix!=null) {
                                                for (GPriceMatrixBean price : pricematrix) {
                                                    if (tr.getAge() >= Integer.parseInt(price.getAgeFrom()) && tr.getAge() < Integer.parseInt(price.getAgeTo())) {
                                                        travellerInfoBean = new TravellerInfoBean();
                                                        travellerInfoBean.setTravelBirdthDate(String.valueOf(tr.getAge()));
                                                        travellerInfoBean.setBookingId(bookingCode);
                                                        travellerInfoBean.setTravelType(price.getPersonType());
                                                        travellerInfoBean.setTravelSurname(tr.getSurname());
                                                        travellerInfoBean.setTravelName(tr.getFirstname());
                                                        TravellerInfoDAO.storeTraveler(travellerInfoBean);
                                                    }
                                                }
                                            }else{
                                                errLogger.info("Booking with itineraryID :" + viatorBookResponse.getData().getItineraryId() + "and item itineraryID:"+viatorItem.getItineraryId()+" completed at viator side but failed to store travelers to databse");
                                            }
                                        }

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


                                        responseItem =new ResponseItem();
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
                                    }
                                }

                            }
                            BookResult bookResult =new BookResult();
                            bookResult.setBooker(bookPOST.getBooker());
                            bookResult.setBookingId("VT"+String.valueOf(viatorBookResponse.getData().getItineraryId()));
                            bookResult.setBookingDate(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                                                      dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                      dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute()));
                            bookResult.setBookingStatus("Active");
                            bookResult.setCurrencyCode(defaultCurrencyCode);
                            bookResult.setTotalPrice(totalBookingPrice);
                            bookResult.setVoucher("");


                            bookResult.setItems(responseItems);
                            bookInfoJSON.setBookingInfo(bookResult);

                        }


                    }else{
                        bookInfoJSON.setErrorMessageText("Communication Error");
                        bookInfoJSON.setSuccess(false);
                        return bookInfoJSON;
                    }

                }
            }else{
                bookInfoJSON.setErrorMessageText("Communication Error");
                bookInfoJSON.setSuccess(false);
                return bookInfoJSON;
            }
        }
        return bookInfoJSON;

    }


}
