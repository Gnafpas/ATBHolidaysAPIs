package Controller.ATBAPIController.ProductBookingsControler;

import APIJSONs.ATBAPIJSONs.Product.*;
import Beans.ATBDBBeans.KalitaonProduct.*;
import Beans.ATBDBBeans.KalitaonSystem.*;
import Beans.ViatorAPIBeans.Bookings.Book.*;
import Beans.ViatorAPIBeans.Bookings.CalculatePrice.CalculatePriceAPIJSON;
import Beans.ViatorAPIBeans.Bookings.CalculatePrice.CalculatePricePOST;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.*;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.*;
import DAOs.ViatorAPIDAOs.BookingsAPIDAO;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import static Controller.Application.errLogger;
import static Helper.ProjectProperties.defaultCurrencyCode;
import static Helper.ProjectProperties.viatorComission;

/**
 * Created by George on 02/03/2018.
 */
@RestController
public class PrebookController {

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

    @RequestMapping(value = "/product/booking/calculatePrice", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public CalculatePriceJSON bookViator(@RequestBody APIJSONs.ATBAPIJSONs.Product.CalculatePricePOST calculatePricePOST, @RequestParam("apiKey") String apiKey) {

        CalculatePriceJSON calculatePriceJSON = new CalculatePriceJSON();
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        calculatePriceJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");

        /**
         * Check for availability
         */
        for (CalculatePriceItemPOST it : calculatePricePOST.getItems()) {
            List<HStopsaleDateBean> stopSaleDates = HStopsaleDateDAO.gethStopsaleDatesByProductId(it.getProductId(), it.getPlanId());
            String[] split = it.getTravelDate().split("-");
            if (split != null && split.length == 3) {
                LocalDate travelDate = new LocalDate(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d", Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 0, 0, 0)).getTime());
                if (stopSaleDates != null && stopSaleDates.size() > 0) {
                    for (HStopsaleDateBean stopSaleDate : stopSaleDates) {
                        LocalDate date = new LocalDate(stopSaleDate.getStopDate().getTime());
                        if (date.compareTo(travelDate) == 0) {
                            calculatePriceJSON.setSuccess(false);
                            calculatePriceJSON.setErrorMessageText("No availability for product with id:" + it.getProductId() + " for the requested travelDate");
                            return calculatePriceJSON;
                        }

                    }
                }
                List<HAvailableDateBean> availableDates = HAvailableDateDAO.gethAvailableDatesByProductId(it.getProductId(), it.getPlanId());
                if (availableDates != null && availableDates.size() > 0) {
                    for (HAvailableDateBean availableDate : availableDates) {
                        LocalDate startDate = new LocalDate(availableDate.getStartDate().getTime());
                        LocalDate endDate = new LocalDate(availableDate.getEndDate().getTime());
                        if (startDate.isAfter(travelDate) || endDate.isBefore(travelDate)) {
                            calculatePriceJSON.setSuccess(false);
                            calculatePriceJSON.setErrorMessageText("No availability for product with id:" + it.getProductId() + " for the requested travelDate");
                            return calculatePriceJSON;
                        }
                    }
                } else {
                    calculatePriceJSON.setSuccess(false);
                    calculatePriceJSON.setErrorMessageText("No availability for product with id:" + it.getProductId() + " for the requested travelDate");
                    return calculatePriceJSON;
                }
            } else {
                calculatePriceJSON.setSuccess(false);
                calculatePriceJSON.setErrorMessageText("Wrong TravelDate format.");
                return calculatePriceJSON;
            }

        }


        SubAgencyBean subAgencyBean;
        String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + apiKey;
        String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
        subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);
        if (subAgencyBean != null) {

            List<BigDecimal> atbProductPrices = new ArrayList<>();
            BigDecimal atbTotalNetPrice = new BigDecimal(0);
            BigDecimal previusAtbTotalNetPrice = new BigDecimal(0); //Used for count single item total pice.
            BigDecimal viatorTotalPrice = new BigDecimal(0);


            /**
             * Preparing items for calculate price request and  book viator request.
             */
            Beans.ViatorAPIBeans.Bookings.Book.Item item;
            List<Beans.ViatorAPIBeans.Bookings.Book.Item> atbItems = new ArrayList<>();
            List<Beans.ViatorAPIBeans.Bookings.Book.Item> viatorItems = new ArrayList<>();
            Beans.ViatorAPIBeans.Bookings.CalculatePrice.Item cItem = new Beans.ViatorAPIBeans.Bookings.CalculatePrice.Item();
            ;
            List<Beans.ViatorAPIBeans.Bookings.CalculatePrice.Item> cItems = new ArrayList<>();
            int distributorItemRef = 0;
            PartnerItemDetail partnerItemDetail;

            for (CalculatePriceItemPOST it : calculatePricePOST.getItems()) {


                AProductTitleBean product = AProductTitleDAO.getProductById(it.getProductId());
                if (product == null) {
                    calculatePriceJSON.setSuccess(false);
                    calculatePriceJSON.setErrorMessageText("Couldn't retrive product with id:" + it.getProductId() + " from database");
                    return calculatePriceJSON;
                }
                FPricePlanBean priceplan = FPricePlanDAO.getfPricePlansById(Integer.parseInt(it.getPlanId()));
                if (priceplan == null) {
                    calculatePriceJSON.setSuccess(false);
                    calculatePriceJSON.setErrorMessageText("Couldn't retrive plan with id:" + it.getPlanId() + " from database");
                    return calculatePriceJSON;
                }


                item = new Beans.ViatorAPIBeans.Bookings.Book.Item();
                distributorItemRef++;
                partnerItemDetail = new PartnerItemDetail();
                partnerItemDetail.setDistributorItemRef("" + distributorItemRef);
                item.setPartnerItemDetail(partnerItemDetail);
                item.setTravelDate(it.getTravelDate());
                if (product.getMainSupplierName().equals("Viator"))
                    item.setProductCode(product.getProductCode());
                else
                    item.setProductCode(String.valueOf(product.getId()));
                item.setTourGradeCode(priceplan.getTourGradeCode());

                if (product.getMainSupplierName().equals("Viator")) {
                    cItem = new Beans.ViatorAPIBeans.Bookings.CalculatePrice.Item();
                    cItem.setProductCode(product.getProductCode());
                    cItem.setTourGradeCode(priceplan.getTourGradeCode());
                    cItem.setTravelDate(it.getTravelDate());
                }
                List<Beans.ViatorAPIBeans.Bookings.CalculatePrice.Traveller> cTravellers = new ArrayList<>();
                Beans.ViatorAPIBeans.Bookings.CalculatePrice.Traveller cTraveller;


                /**
                 * Prepare travellers for calculate price and booking requests and define travellers type
                 */
                List<GPriceMatrixBean> pricematrix = GPriceMatrixDAO.getgPriceMatrixesByProductIdAndPlanId(it.getProductId(), String.valueOf(priceplan.getId()));
                if (pricematrix == null || pricematrix.size() == 0) {
                    calculatePriceJSON.setSuccess(false);
                    calculatePriceJSON.setErrorMessageText("No prices for product with id:" + it.getProductId());
                    return calculatePriceJSON;
                }
                int adultsCount = 0;
                int childCount = 0;
                int youthCount = 0;
                int infantCount = 0;
                int seniorCount = 0;
                Beans.ViatorAPIBeans.Bookings.Book.Traveller traveller;
                List<Beans.ViatorAPIBeans.Bookings.Book.Traveller> travellers = new ArrayList<>();
                for (CalculatePriceTraveller tr : it.getTravellers()) {
                    cTraveller = new Beans.ViatorAPIBeans.Bookings.CalculatePrice.Traveller();
                    traveller = new Beans.ViatorAPIBeans.Bookings.Book.Traveller();
                    if (tr.getAge() == 0) {
                        calculatePriceJSON.setSuccess(false);
                        calculatePriceJSON.setErrorMessageText("Age is a required field for all travellers");
                        return calculatePriceJSON;
                    }

                    for (GPriceMatrixBean price : pricematrix) {
                        if (!price.getAgeFrom().equals("") && !price.getAgeTo().equals("")) {
                            if (tr.getAge() >= Integer.parseInt(price.getAgeFrom()) && tr.getAge() < Integer.parseInt(price.getAgeTo())) {
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
                                    calculatePriceJSON.setSuccess(false);
                                    calculatePriceJSON.setErrorMessageText("Couldn't find person type for traveler for product with id:" + it.getPlanId());
                                    return calculatePriceJSON;
                                }
                            }
                        } else {
                            calculatePriceJSON.setSuccess(false);
                            calculatePriceJSON.setErrorMessageText("Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                            return calculatePriceJSON;
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
                int maxPeoplerequired = 0;
                int minPeoplerequired = 1000;
                boolean atLeastOneAdult = false;
                BigDecimal atbNetPrice;
                BigDecimal viatorprice;
                BigDecimal priceWithAgentCurrency;
                for (GPriceMatrixBean price : pricematrix) {
                    price.setPriceNet(price.getPriceNet().replace(",", ".").replace(" ", ""));
                    if (price.getPersonType().equals("adult")) {
                        if (adultsCount >= price.getMinCountRequired() && adultsCount <= price.getMaxCountRequired()) {
                            priceWithAgentCurrency = Helper.CurrencyConverter.findExchangeRateAndConvert(price.getCurrencyCode(), subAgencyBean.getCurrency(), Double.parseDouble(price.getPriceNet()));
                            if (priceWithAgentCurrency != null) {
                                atbNetPrice = priceWithAgentCurrency.setScale(2, BigDecimal.ROUND_HALF_UP);
                                viatorprice = ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(105), 2, RoundingMode.HALF_UP));
                                atbTotalNetPrice = atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(adultsCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                if (product.getMainSupplierName().equals("Viator")) {
                                    viatorTotalPrice = viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(adultsCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                }
                                atLeastOneAdult = true;
                            } else {
                                calculatePriceJSON.setSuccess(false);
                                calculatePriceJSON.setErrorMessageText("Code:21 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                return calculatePriceJSON;
                            }
                        }
                        if (price.getMaxCountRequired() > maxPeoplerequired)
                            maxPeoplerequired = price.getMaxCountRequired();
                        if (price.getMinCountRequired() < minPeoplerequired)
                            minPeoplerequired = price.getMinCountRequired();
                    } else if (price.getPersonType().equals("child")) {
                        if (childCount >= price.getMinCountRequired() && childCount <= price.getMaxCountRequired()) {
                            priceWithAgentCurrency = Helper.CurrencyConverter.findExchangeRateAndConvert(price.getCurrencyCode(), subAgencyBean.getCurrency(), Double.parseDouble(price.getPriceNet()));
                            if (priceWithAgentCurrency != null) {
                                atbNetPrice = priceWithAgentCurrency.setScale(2, BigDecimal.ROUND_HALF_UP);
                                viatorprice = ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(100).add(Helper.ProjectProperties.viatorComission.multiply(new BigDecimal(100))), 2, RoundingMode.HALF_UP));
                                atbTotalNetPrice = atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(childCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                if (product.getMainSupplierName().equals("Viator")) {
                                    viatorTotalPrice = viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(childCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                }
                            } else {
                                calculatePriceJSON.setSuccess(false);
                                calculatePriceJSON.setErrorMessageText("Code:21 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                return calculatePriceJSON;
                            }
                        }
                    } else if (price.getPersonType().equals("infant")) {
                        if (infantCount >= price.getMinCountRequired() && infantCount <= price.getMaxCountRequired()) {
                            priceWithAgentCurrency = Helper.CurrencyConverter.findExchangeRateAndConvert(price.getCurrencyCode(), subAgencyBean.getCurrency(), Double.parseDouble(price.getPriceNet()));
                            if (priceWithAgentCurrency != null) {
                                atbNetPrice = priceWithAgentCurrency.setScale(2, BigDecimal.ROUND_HALF_UP);
                                viatorprice = ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(100).add(Helper.ProjectProperties.viatorComission.multiply(new BigDecimal(100))), 2, RoundingMode.HALF_UP));
                                atbTotalNetPrice = atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(infantCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                if (product.getMainSupplierName().equals("Viator")) {
                                    viatorTotalPrice = viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(infantCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                }
                            } else {
                                calculatePriceJSON.setSuccess(false);
                                calculatePriceJSON.setErrorMessageText("Code:21 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                return calculatePriceJSON;
                            }
                        }
                    } else if (price.getPersonType().equals("youth")) {
                        if (youthCount >= price.getMinCountRequired() && youthCount <= price.getMaxCountRequired()) {
                            priceWithAgentCurrency = Helper.CurrencyConverter.findExchangeRateAndConvert(price.getCurrencyCode(), subAgencyBean.getCurrency(), Double.parseDouble(price.getPriceNet()));
                            if (priceWithAgentCurrency != null) {
                                atbNetPrice = priceWithAgentCurrency.setScale(2, BigDecimal.ROUND_HALF_UP);
                                viatorprice = ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(100).add(Helper.ProjectProperties.viatorComission.multiply(new BigDecimal(100))), 2, RoundingMode.HALF_UP));
                                atbTotalNetPrice = atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(youthCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                if (product.getMainSupplierName().equals("Viator")) {
                                    viatorTotalPrice = viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(youthCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                }
                            } else {
                                calculatePriceJSON.setSuccess(false);
                                calculatePriceJSON.setErrorMessageText("Code:21 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                return calculatePriceJSON;
                            }
                        }
                    } else if (price.getPersonType().equals("senior")) {
                        if (seniorCount >= price.getMinCountRequired() && seniorCount <= price.getMaxCountRequired()) {
                            priceWithAgentCurrency = Helper.CurrencyConverter.findExchangeRateAndConvert(price.getCurrencyCode(), subAgencyBean.getCurrency(), Double.parseDouble(price.getPriceNet()));
                            if (priceWithAgentCurrency != null) {
                                atbNetPrice = priceWithAgentCurrency.setScale(2, BigDecimal.ROUND_HALF_UP);
                                viatorprice = ((atbNetPrice.multiply(new BigDecimal(100))).divide(new BigDecimal(100).add(Helper.ProjectProperties.viatorComission.multiply(new BigDecimal(100))), 2, RoundingMode.HALF_UP));
                                atbTotalNetPrice = atbTotalNetPrice.add(atbNetPrice.multiply(new BigDecimal(seniorCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                if (product.getMainSupplierName().equals("Viator")) {
                                    viatorTotalPrice = viatorTotalPrice.add(viatorprice.multiply(new BigDecimal(seniorCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                }
                            } else {
                                calculatePriceJSON.setSuccess(false);
                                calculatePriceJSON.setErrorMessageText("Code:21 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                return calculatePriceJSON;
                            }
                            atLeastOneAdult = true;
                        }
                    }
                }

                /**
                 * Check number of travellers restrictions
                 */
                if (minPeoplerequired > adultsCount) {
                    calculatePriceJSON.setSuccess(false);
                    calculatePriceJSON.setErrorMessageText("More adult travellers than required.");
                    return calculatePriceJSON;
                }
                if (maxPeoplerequired < adultsCount + childCount + youthCount + seniorCount) {
                    calculatePriceJSON.setSuccess(false);
                    calculatePriceJSON.setErrorMessageText("More traveller than required.");
                    return calculatePriceJSON;
                }
                if (!atLeastOneAdult) {
                    calculatePriceJSON.setSuccess(false);
                    calculatePriceJSON.setErrorMessageText("At least one Adult traveller required.");
                    return calculatePriceJSON;
                }

                if (product.getMainSupplierName().equals("Viator")) {
                    cItem.setTravellers(cTravellers);
                    cItems.add(cItem);
                }
                item.setTravellers(travellers);
                if (product.getMainSupplierName().equals("Viator"))
                    viatorItems.add(item);
                else if(product.getMainSupplierName().equals("Atb Holidays")) {
                    atbItems.add(item);
                    atbProductPrices.add(atbTotalNetPrice.subtract(previusAtbTotalNetPrice));
                }
                previusAtbTotalNetPrice = atbTotalNetPrice;
            }


            /**
             * Calculate price for viator products.
             */
            CalculatePriceAPIJSON calculatepriceJson = null;
            if (cItems != null && cItems.size() > 0) {
                CalculatePricePOST viatorCalculatePricePOST = new CalculatePricePOST();
                viatorCalculatePricePOST.setItems(cItems);
                viatorCalculatePricePOST.setPartnerDetail(null);
                viatorCalculatePricePOST.setCurrencyCode(defaultCurrencyCode);
                calculatepriceJson = BookingsAPIDAO.calculateprice(viatorCalculatePricePOST);
                if (calculatepriceJson != null) {
                    if (!calculatepriceJson.isSuccess() ){
                        calculatePriceJSON.setErrorMessageText("Error:" + calculatepriceJson.getErrorMessage());
                        calculatePriceJSON.setSuccess(false);
                        return calculatePriceJSON;
                    }

                    if ( calculatepriceJson.getData() == null || calculatepriceJson.getData().getItinerary() == null || calculatepriceJson.getData().getItinerary().getItemSummaries() == null) {
                        calculatePriceJSON.setErrorMessageText("Communication Error1");
                        calculatePriceJSON.setSuccess(false);
                        return calculatePriceJSON;
                    }
                } else {
                    calculatePriceJSON.setErrorMessageText("Communication Error2");
                    calculatePriceJSON.setSuccess(false);
                    return calculatePriceJSON;
                }
            }

            /**
             * Check if subagency has the amount on it's deposit
             */
            GsaBean gsaBean;//todo errore handling(availability error type price error type)
            BigDecimal agentSale = null;
            if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()));
                if (gsaBean != null) {
                    if (gsaBean.getOtlMkp() != null && !gsaBean.getOtlMkp().equals("")) {

                        BigDecimal totalBookingPrice = new BigDecimal(0);
                        List<CalculatePriceItem> responseItems = new ArrayList<>();
                        CalculatePriceItem responseItem;
                        String generalBookCode = dateTime.getMillis() + String.valueOf(subAgencyBean.getId());
                        int storedItemNumber = 0;
                        /**
                         * Make the booking in viator side.
                         */
                        if (viatorItems.size() > 0) {
                            for (ItemSummary viatorItem : calculatepriceJson.getData().getItinerary().getItemSummaries()) {
                                for (CalculatePriceItemPOST atbItem : calculatePricePOST.getItems()) {
                                    AProductTitleBean product = AProductTitleDAO.getProductById(atbItem.getProductId());
                                    if (viatorItem.getProductCode().equals(product.getProductCode()) && viatorItem.getTravelDate().equals(atbItem.getTravelDate())) {
                                        if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                                            gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()));
                                            if (gsaBean != null) {
                                                if (viatorItem.getMerchantNetPrice() != null) {
                                                    if (gsaBean.getOtlMkp() != null && !gsaBean.getOtlMkp().equals("")) {
                                                        BigDecimal priceWithComision = viatorItem.getMerchantNetPrice().add(viatorItem.getMerchantNetPrice().multiply(viatorComission)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                        BigDecimal gsaSale = priceWithComision.add(priceWithComision.multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                        if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                                            agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                            totalBookingPrice = agentSale.add(totalBookingPrice);
                                                        } else {
                                                            calculatePriceJSON.setErrorMessageText("Code:12 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                                                            calculatePriceJSON.setSuccess(false);
                                                            return calculatePriceJSON;
                                                        }
                                                    } else {
                                                        calculatePriceJSON.setErrorMessageText("Code:13 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                                                        calculatePriceJSON.setSuccess(false);
                                                        return calculatePriceJSON;
                                                    }
                                                } else {
                                                    calculatePriceJSON.setErrorMessageText("Code:14 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                                                    calculatePriceJSON.setSuccess(false);
                                                    return calculatePriceJSON;
                                                }
                                            } else {
                                                calculatePriceJSON.setErrorMessageText("Code:15 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                                                calculatePriceJSON.setSuccess(false);
                                                return calculatePriceJSON;
                                            }
                                        } else {
                                            calculatePriceJSON.setErrorMessageText("Code:16 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                                            calculatePriceJSON.setSuccess(false);
                                            return calculatePriceJSON;
                                        }


                                        /**
                                         * Response Item.
                                         */
                                        responseItem = new CalculatePriceItem();
                                        responseItem.setPlanId(atbItem.getPlanId());
                                        responseItem.setPrice(agentSale);
                                        responseItem.setProductId(atbItem.getProductId());
                                        responseItem.setCurrency(subAgencyBean.getCurrency());
                                        responseItem.setTravelDate(viatorItem.getTravelDate());
                                        responseItems.add(responseItem);
                                        break;
                                    }
                                }

                            }

                        }


                        /**
                         * Book Atb Products
                         */
                        for (Beans.ViatorAPIBeans.Bookings.Book.Item atbItem : atbItems) {
                            for (CalculatePriceItemPOST requestItem : calculatePricePOST.getItems()) {
                                if (atbItem.getProductCode().equals(requestItem.getProductId())) {

                                    AProductTitleBean product = AProductTitleDAO.getProductById(requestItem.getProductId());


                                    if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                                        gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()));
                                        if (gsaBean != null) {
                                            if (gsaBean.getOtlMkp() != null && !gsaBean.getOtlMkp().equals("")) {
                                                BigDecimal gsaSale = atbProductPrices.get(atbItems.indexOf(atbItem)).add(atbProductPrices.get(atbItems.indexOf(atbItem)).multiply(BigDecimal.valueOf(Integer.parseInt(gsaBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                if (subAgencyBean.getOtlMkp() != null && !subAgencyBean.getOtlMkp().equals("")) {
                                                    agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(Integer.parseInt(subAgencyBean.getOtlMkp())).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                    totalBookingPrice = agentSale.add(totalBookingPrice);
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
                                    }//todo replace error logs with return


                                    /**
                                     * Response Item.
                                     */
                                    responseItem = new CalculatePriceItem();
                                    responseItem.setPlanId(requestItem.getPlanId());
                                    responseItem.setPrice(agentSale);
                                    responseItem.setProductId(requestItem.getProductId());
                                    responseItem.setTravelDate(requestItem.getTravelDate());
                                    responseItem.setCurrency(subAgencyBean.getCurrency());
                                    responseItems.add(responseItem);
                                }
                            }
                        }
                        /**
                         * Response.
                         */
                        calculatePriceJSON.setItems(responseItems);
                        calculatePriceJSON.setTotalPrice(totalBookingPrice);
                        calculatePriceJSON.setCurrencyCode(subAgencyBean.getCurrency());


                        return calculatePriceJSON;

                    } else {
                        calculatePriceJSON.setSuccess(false);
                        calculatePriceJSON.setErrorMessageText("Code:2  Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                        return calculatePriceJSON;
                    }
                } else {
                    calculatePriceJSON.setSuccess(false);
                    calculatePriceJSON.setErrorMessageText("Code:3  Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                    return calculatePriceJSON;
                }
            } else {
                calculatePriceJSON.setSuccess(false);
                calculatePriceJSON.setErrorMessageText("Code:4  Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                return calculatePriceJSON;
            }


        }else{
            calculatePriceJSON.setErrorMessageText("Code:17 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
            calculatePriceJSON.setSuccess(false);
            return calculatePriceJSON;
        }

    }

}
