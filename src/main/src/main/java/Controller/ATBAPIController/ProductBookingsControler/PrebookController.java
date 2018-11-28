package Controller.ATBAPIController.ProductBookingsControler;

import APIJSONs.ATBAPIJSONs.Product.*;
import Beans.ATBDBBeans.KalitaonProduct.*;
import Beans.ATBDBBeans.KalitaonSystem.*;
import Beans.ViatorAPIBeans.Bookings.Book.*;
import Beans.ViatorAPIBeans.Bookings.CalculatePrice.CalculatePriceAPIJSON;
import Beans.ViatorAPIBeans.Bookings.CalculatePrice.CalculatePricePOST;
import Controller.Application;
import Controller.EventsTravelController.EventsTravelController;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.*;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.*;
import DAOs.ViatorAPIDAOs.BookingsAPIDAO;
import Helper.CurrencyConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.io.StringWriter;
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

        Application.agent.increment("app.web.request.api.product.availability");
        AvailabilityJSON availabilityJSON = new AvailabilityJSON();
        try {
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            availabilityJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");

            List<HAvailableDateBean> availableDates = HAvailableDateDAO.gethAvailableDatesByProductId(productId, planId);
            List<HSpecialDateBean> specialDates = HSpecialDateDAO.getSpecialDatesByProductId(productId, planId);
            List<HStopsaleDateBean> stopsaleDates = HStopsaleDateDAO.gethStopsaleDatesByProductId(productId, planId);
            List<IAvailableTimeBean> availableTime = IAvailableTimeDAO.getiAvailableTimesByProductId(productId, planId);

            Availability availability;
            boolean planIdExists;
            if (availableDates != null) {
                for (HAvailableDateBean ad : availableDates) {
                    planIdExists = false;
                    for (Availability a : availabilityJSON.getData()) {
                        if (a.getPlanId().equals(ad.getPlanId())) {
                            a.getAvailableDates().add(ad);
                            planIdExists = true;
                            break;
                        }
                    }
                    if (!planIdExists) {
                        availability = new Availability();
                        availability.getAvailableDates().add(ad);
                        availability.setPlanId(ad.getPlanId());
                        availabilityJSON.getData().add(availability);
                    }
                }
            }

            if (specialDates != null) {
                for (HSpecialDateBean sd : specialDates) {
                    planIdExists = false;
                    for (Availability a : availabilityJSON.getData()) {
                        if (a.getPlanId().equals(sd.getPlanId())) {
                            a.getSpecialDates().add(sd);
                            planIdExists = true;
                            break;
                        }
                    }
                    if (!planIdExists) {
                        availability = new Availability();
                        availability.getSpecialDates().add(sd);
                        availability.setPlanId(sd.getPlanId());
                        availabilityJSON.getData().add(availability);
                    }
                }
            }

            if (stopsaleDates != null) {
                for (HStopsaleDateBean sd : stopsaleDates) {
                    planIdExists = false;
                    for (Availability a : availabilityJSON.getData()) {
                        if (a.getPlanId().equals(sd.getPlanId())) {
                            a.getStopsaleDates().add(sd);
                            planIdExists = true;
                            break;
                        }
                    }
                    if (!planIdExists) {
                        availability = new Availability();
                        availability.getStopsaleDates().add(sd);
                        availability.setPlanId(sd.getPlanId());
                        availabilityJSON.getData().add(availability);
                    }
                }
            }

//        if(availableTime!=null) {
//            for(IAvailableTimeBean at:availableTime) {
//                planIdExists=false;
//                for(Availability a:availabilityJSON.getData()){
//                    if(a.getPlanId().equals(at.getPlanId())) {
//                        a.getAvailableTime().add(at);
//                        planIdExists=true;
//                        break;
//                    }
//                }
//                if(!planIdExists) {
//                    availability = new Availability();
//                    availability.getAvailableTime().add(at);
//                    availability.setPlanId(at.getPlanId());
//                    availabilityJSON.getData().add(availability);
//                }
//            }
//        }

            availabilityJSON.setTotalCount(availabilityJSON.getData().size());
            if (availableTime == null || stopsaleDates == null ||
                    specialDates == null || availableDates == null) {
                availabilityJSON.setSuccess(false);
                availabilityJSON.setErrorMessageText("Database Communication Error.");
            }
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            availabilityJSON.setSuccess(false);
            availabilityJSON.setErrorMessageText(errors.toString());
        }
        return availabilityJSON;
    }

    @RequestMapping("/product/booking/pricingmatrix")
    public PricingmatrixJSON pricingmatrix(@RequestParam(value = "productId", defaultValue = "") String productId,
                                           @RequestParam(value = "planId", defaultValue = "") String planId,
                                           @RequestParam(value = "currencyCode", defaultValue = "") String currencyCode,
                                           @RequestParam("apiKey") String apiKey) {

        Application.agent.increment("app.web.request.api.product.pricingmatrix");
        PricingmatrixJSON pricingmatrixJSON = new PricingmatrixJSON();
        try {
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            pricingmatrixJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");

            SubAgencyBean subAgencyBean;
            String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + apiKey;
            String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
            subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);
            GsaBean gsaBean = null;
            if (subAgencyBean != null)
                gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()), null);
            if (subAgencyBean != null && gsaBean != null && subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("") &&
                    subAgencyBean.getTrsMkp() != null && !subAgencyBean.getTrsMkp().equals("") &&
                    subAgencyBean.getDtrMkp() != null && !subAgencyBean.getDtrMkp().equals("") &&
                    subAgencyBean.getMtrMkp() != null && !subAgencyBean.getMtrMkp().equals("") &&
                    subAgencyBean.getEvtMkp() != null && !subAgencyBean.getEvtMkp().equals("") && gsaBean.getTrsMkp() != null && !gsaBean.getTrsMkp().equals("") &&
                    gsaBean.getDtrMkp() != null && !gsaBean.getDtrMkp().equals("") &&
                    gsaBean.getMtrMkp() != null && !gsaBean.getMtrMkp().equals("") &&
                    gsaBean.getEvtMkp() != null && !gsaBean.getEvtMkp().equals("")) {

                if (!currencyCode.equals("")) {
                    if (CurrencyConverter.findExchangeRateAndConvert("EUR", currencyCode, new Double(1)) == null) {
                        pricingmatrixJSON.setSuccess(false);
                        pricingmatrixJSON.setErrorMessageText("Wrong currrency code");
                        return pricingmatrixJSON;
                    }
                }

                int gsaMrkUp;
                int subAgencyMrkUp;
                List<GPriceMatrixBean> priceMatrixes = GPriceMatrixDAO.getgPriceMatrixesByProductIdAndPlanId(productId, planId);
                boolean planIdExists;
                PricingmatrixWithPlanId pricingmatrixWithPlanId;
                if (priceMatrixes != null) {
                    for (GPriceMatrixBean pm : priceMatrixes) {
                        planIdExists = false;
                        AProductTitleBean product = AProductTitleDAO.getProductById(pm.getProductId());
                        if (product == null) {
                            pricingmatrixJSON.setSuccess(false);
                            pricingmatrixJSON.setErrorMessageText("Couldn't retrive product with id:" + pm.getProductId() + " from database");
                            return pricingmatrixJSON;
                        } else {
                            if (product.getTypeOfProduct().equals("1")) {
                                gsaMrkUp = Integer.parseInt(gsaBean.getTrsMkp());
                                subAgencyMrkUp = Integer.parseInt(subAgencyBean.getTrsMkp());
                            } else if (product.getTypeOfProduct().equals("2")) {
                                gsaMrkUp = Integer.parseInt(gsaBean.getDtrMkp());
                                subAgencyMrkUp = Integer.parseInt(subAgencyBean.getDtrMkp());
                            } else if (product.getTypeOfProduct().equals("3")) {
                                gsaMrkUp = Integer.parseInt(gsaBean.getMtrMkp());
                                subAgencyMrkUp = Integer.parseInt(subAgencyBean.getMtrMkp());
                            } else if (product.getTypeOfProduct().equals("4")) {
                                gsaMrkUp = Integer.parseInt(gsaBean.getDtrMkp());
                                subAgencyMrkUp = Integer.parseInt(subAgencyBean.getDtrMkp());
                            } else {
                                gsaMrkUp = Integer.parseInt(gsaBean.getEvtMkp());
                                subAgencyMrkUp = Integer.parseInt(subAgencyBean.getEvtMkp());
                            }
                        }
                        for (PricingmatrixWithPlanId p : pricingmatrixJSON.getData()) {
                            if (p.getPlanId().equals(pm.getPlanId())) {
                                PriceMatrix priceMatrix = new PriceMatrix();
                                priceMatrix.setAgeFrom(pm.getAgeFrom());
                                priceMatrix.setAgeTo(pm.getAgeTo());
                                priceMatrix.setId(pm.getId());
                                priceMatrix.setMaxCountRequired(pm.getMaxCountRequired());
                                priceMatrix.setMinCountRequired(pm.getMinCountRequired());
                                priceMatrix.setPersonType(pm.getPersonType());
                                priceMatrix.setPlanId(pm.getPlanId());
                                BigDecimal agentSale;
                                if (pm.getPriceNet() != null) {
                                    BigDecimal priceWithAgentCurrency = Helper.CurrencyConverter.findExchangeRateAndConvert(pm.getCurrencyCode(), subAgencyBean.getCurrency(), Double.parseDouble(pm.getPriceNet()));
                                    if (priceWithAgentCurrency != null) {

                                        BigDecimal gsaSale = priceWithAgentCurrency.add(priceWithAgentCurrency.multiply(BigDecimal.valueOf(gsaMrkUp).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                        agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(subAgencyMrkUp).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                    } else {
                                        pricingmatrixJSON.setErrorMessageText("Code:14 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                                        pricingmatrixJSON.setSuccess(false);
                                        return pricingmatrixJSON;
                                    }
                                } else {
                                    pricingmatrixJSON.setErrorMessageText("Code:14 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                                    pricingmatrixJSON.setSuccess(false);
                                    return pricingmatrixJSON;
                                }
                                if (agentSale != null) {

                                    /**
                                     * Currency conversion
                                     */
                                    if (currencyCode != null && !currencyCode.equals("")) {
                                        BigDecimal convertedPrice = CurrencyConverter.findExchangeRateAndConvert(subAgencyBean.getCurrency(), currencyCode, Double.parseDouble(agentSale.toString()));
                                        if (convertedPrice != null) {
                                            convertedPrice = convertedPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
                                            priceMatrix.setPriceNet(convertedPrice.toString());
                                            priceMatrix.setCurrencyCode(currencyCode);
                                        } else {
                                            priceMatrix.setPriceNet(agentSale.toString());
                                            priceMatrix.setCurrencyCode(subAgencyBean.getCurrency());
                                        }
                                    } else {
                                        priceMatrix.setPriceNet(agentSale.toString());
                                        priceMatrix.setCurrencyCode(subAgencyBean.getCurrency());
                                    }
                                } else {
                                    pricingmatrixJSON.setErrorMessageText("Code:14 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                                    pricingmatrixJSON.setSuccess(false);
                                    return pricingmatrixJSON;
                                }
                                priceMatrix.setProductId(pm.getProductId());
                                priceMatrix.setUpdatedAt(pm.getUpdatedAt());
                                p.getPriceMatrix().add(priceMatrix);
                                planIdExists = true;
                                break;
                            }
                        }
                        if (!planIdExists) {
                            pricingmatrixWithPlanId = new PricingmatrixWithPlanId();
                            PriceMatrix priceMatrix = new PriceMatrix();
                            priceMatrix.setAgeFrom(pm.getAgeFrom());
                            priceMatrix.setAgeTo(pm.getAgeTo());
                            priceMatrix.setId(pm.getId());
                            priceMatrix.setMaxCountRequired(pm.getMaxCountRequired());
                            priceMatrix.setMinCountRequired(pm.getMinCountRequired());
                            priceMatrix.setPersonType(pm.getPersonType());
                            priceMatrix.setPlanId(pm.getPlanId());
                            BigDecimal agentSale;
                            if (pm.getPriceNet() != null) {
                                BigDecimal priceWithAgentCurrency = Helper.CurrencyConverter.findExchangeRateAndConvert(pm.getCurrencyCode(), subAgencyBean.getCurrency(), Double.parseDouble(pm.getPriceNet()));
                                if (priceWithAgentCurrency != null) {

                                    BigDecimal gsaSale = priceWithAgentCurrency.add(priceWithAgentCurrency.multiply(BigDecimal.valueOf(gsaMrkUp).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                    agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(subAgencyMrkUp).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                } else {
                                    pricingmatrixJSON.setErrorMessageText("Code:14 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                                    pricingmatrixJSON.setSuccess(false);
                                    return pricingmatrixJSON;
                                }
                            } else {
                                pricingmatrixJSON.setErrorMessageText("Code:14 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                                pricingmatrixJSON.setSuccess(false);
                                return pricingmatrixJSON;
                            }
                            if (agentSale != null) {
                                /**
                                 * Currency conversion
                                 */
                                if (currencyCode != null && !currencyCode.equals("") && subAgencyBean.getCurrency() != null) {
                                    BigDecimal convertedPrice = CurrencyConverter.findExchangeRateAndConvert(subAgencyBean.getCurrency(), currencyCode, Double.parseDouble(agentSale.toString()));
                                    if (convertedPrice != null) {
                                        convertedPrice = convertedPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
                                        priceMatrix.setPriceNet(convertedPrice.toString());
                                        priceMatrix.setCurrencyCode(currencyCode);
                                    } else {
                                        priceMatrix.setPriceNet(agentSale.toString());
                                        priceMatrix.setCurrencyCode(subAgencyBean.getCurrency());
                                    }
                                } else {
                                    priceMatrix.setPriceNet(agentSale.toString());
                                    priceMatrix.setCurrencyCode(subAgencyBean.getCurrency());
                                }
                            } else {
                                pricingmatrixJSON.setErrorMessageText("Code:14 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                                pricingmatrixJSON.setSuccess(false);
                                return pricingmatrixJSON;
                            }
                            priceMatrix.setProductId(pm.getProductId());
                            priceMatrix.setUpdatedAt(pm.getUpdatedAt());
                            pricingmatrixWithPlanId.getPriceMatrix().add(priceMatrix);
                            pricingmatrixWithPlanId.setPlanId(pm.getPlanId());
                            pricingmatrixJSON.getData().add(pricingmatrixWithPlanId);
                        }
                    }
                }
                pricingmatrixJSON.setTotalCount(pricingmatrixJSON.getData().size());
                if (priceMatrixes == null) {
                    pricingmatrixJSON.setSuccess(false);
                    pricingmatrixJSON.setErrorMessageText("Database Communication Error.");
                }
                pricingmatrixJSON.setTotalCount(pricingmatrixJSON.getData().size());
            } else {
                pricingmatrixJSON.setErrorMessageText("Code:17 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                pricingmatrixJSON.setSuccess(false);
            }
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            pricingmatrixJSON.setSuccess(false);
            pricingmatrixJSON.setErrorMessageText(errors.toString());
        }
        return pricingmatrixJSON;
    }


    private  void storePrebookLog(APIJSONs.ATBAPIJSONs.Product.CalculatePricePOST calculatePricePOST, CalculatePriceJSON calculatePriceJSON, CalculatePriceAPIJSON calculatepriceAPIJson,CalculatePricePOST viatorCalculatePricePOST, SubAgencyBean subAgencyBean, String providerName){
        ObjectMapper mapper = new ObjectMapper();
        Beans.ViatorDBBeans.PrebookLogBean prebookLogBean=new Beans.ViatorDBBeans.PrebookLogBean();
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        if(subAgencyBean!=null)
            prebookLogBean.setClient(subAgencyBean.getAgentName());
        else
            prebookLogBean.setClient("");
        try {
            prebookLogBean.setClientRequest(mapper.writeValueAsString(calculatePricePOST).toString());
        }catch(JsonProcessingException e1){
            prebookLogBean.setClientRequest("");
        }
        try {
            prebookLogBean.setClientResponse(mapper.writeValueAsString(calculatePriceJSON).toString());
        }catch(JsonProcessingException e1){
            prebookLogBean.setClientResponse("");
        }

        if(calculatepriceAPIJson!=null) {
            try {
                prebookLogBean.setProviderRequest(mapper.writeValueAsString(calculatepriceAPIJson).toString());
            } catch (JsonProcessingException e1) {
                prebookLogBean.setProviderRequest("");
            }
        }else
            prebookLogBean.setProviderRequest("");
        if(viatorCalculatePricePOST!=null) {
            try {
                prebookLogBean.setProviderResponse(mapper.writeValueAsString(viatorCalculatePricePOST).toString());
            } catch (JsonProcessingException e1) {
                prebookLogBean.setProviderResponse("");
            }
        }else
            prebookLogBean.setProviderResponse("");
        prebookLogBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())));
        prebookLogBean.setPrebookRef("");
        prebookLogBean.setProvider(providerName);
        DAOs.ViatorDBDAOs.PrebookLogDAO.addPrebookLogBean(prebookLogBean);
    }

    @RequestMapping(value = "/product/booking/calculatePrice", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public CalculatePriceJSON bookViator(@RequestBody APIJSONs.ATBAPIJSONs.Product.CalculatePricePOST calculatePricePOST, @RequestParam("apiKey") String apiKey) {




        Application.agent.increment("app.web.request.api.product.calculatePrice");
        CalculatePriceJSON calculatePriceJSON = new CalculatePriceJSON();
        try {
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            calculatePriceJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
            SubAgencyBean subAgencyBean;
            String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + apiKey;
            String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
            subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);
            if (subAgencyBean != null) {


                if (!calculatePricePOST.getCurrencyCode().equals("")) {
                    if (CurrencyConverter.findExchangeRateAndConvert("EUR", calculatePricePOST.getCurrencyCode(), new Double(1)) == null) {
                        calculatePriceJSON.setSuccess(false);
                        calculatePriceJSON.setErrorMessageText("Wrong currrency code");
                        return calculatePriceJSON;
                    }
                }
                /**
                 * Check for availability
                 */
                for (CalculatePriceItemPOST it : calculatePricePOST.getItems()) {
                    String[] split = it.getTravelDate().split("-");
                    if (split != null && split.length == 3) {
                        LocalDate travelDate = new LocalDate(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d", Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 0, 0, 0)).getTime());

                        List<HStopsaleDateBean> stopSaleDates = HStopsaleDateDAO.gethStopsaleDatesByProductId(it.getProductId(), it.getPlanId());
                        if (stopSaleDates != null && stopSaleDates.size() > 0) {
                            for (HStopsaleDateBean stopSaleDate : stopSaleDates) {
                                LocalDate date = new LocalDate(stopSaleDate.getStopDate().getTime());
                                if (date.compareTo(travelDate) == 0) {
                                    calculatePriceJSON.setSuccess(false);
                                    calculatePriceJSON.setErrorMessageText("No availability for product with id:" + it.getProductId() + " for the requested travelDate");
                                    storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
                                    return calculatePriceJSON;
                                }

                            }
                        }

                        List<HSpecialDateBean> specialDates = HSpecialDateDAO.getSpecialDatesByProductId(it.getProductId(), it.getPlanId());
                        if (specialDates != null && specialDates.size() > 0) {
                            boolean travelDateExists = false;
                            for (HSpecialDateBean specialDate : specialDates) {

                                LocalDate date = new LocalDate(specialDate.getServiceDate().getTime());
                                if (date.compareTo(travelDate) == 0) {
                                    travelDateExists = true;

                                }
                            }
                            if (!travelDateExists) {
                                calculatePriceJSON.setSuccess(false);
                                calculatePriceJSON.setErrorMessageText("No availability for product with id:" + it.getProductId() + " for the requested travelDate");
                                storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
                                return calculatePriceJSON;
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
                                    storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
                                    return calculatePriceJSON;
                                }
                            }
                        } else {
                            calculatePriceJSON.setSuccess(false);
                            calculatePriceJSON.setErrorMessageText("No availability for product with id:" + it.getProductId() + " for the requested travelDate");
                            storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
                            return calculatePriceJSON;
                        }
                    } else {
                        calculatePriceJSON.setSuccess(false);
                        calculatePriceJSON.setErrorMessageText("Wrong TravelDate format.");
                        storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
                        return calculatePriceJSON;
                    }

                }


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
                List<Beans.ViatorAPIBeans.Bookings.CalculatePrice.Item> cItems = new ArrayList<>();
                int distributorItemRef = 0;
                PartnerItemDetail partnerItemDetail;

                for (CalculatePriceItemPOST it : calculatePricePOST.getItems()) {


                    AProductTitleBean product = AProductTitleDAO.getProductById(it.getProductId());
                    if (product == null) {
                        calculatePriceJSON.setSuccess(false);
                        calculatePriceJSON.setErrorMessageText("Couldn't retrive product with id:" + it.getProductId() + " from database");
                        storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
                        return calculatePriceJSON;
                    }
                    FPricePlanBean priceplan = FPricePlanDAO.getfPricePlansById(Integer.parseInt(it.getPlanId()));
                    if (priceplan == null) {
                        calculatePriceJSON.setSuccess(false);
                        calculatePriceJSON.setErrorMessageText("Couldn't retrive plan with id:" + it.getPlanId() + " from database");
                        storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
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
                        storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
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
                            storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
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
                                        storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
                                        return calculatePriceJSON;
                                    }
                                }
                            } else {
                                calculatePriceJSON.setSuccess(false);
                                calculatePriceJSON.setErrorMessageText("Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                                storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
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
                                    storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
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
                                    calculatePriceJSON.setErrorMessageText("Code:22 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                    storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
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
                                    calculatePriceJSON.setErrorMessageText("Code:23 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                    storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
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
                                    calculatePriceJSON.setErrorMessageText("Code:24 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                    storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
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
                                    calculatePriceJSON.setErrorMessageText("Code:25 Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                                    storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
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
                        calculatePriceJSON.setErrorMessageText("Less adult travellers than required.");
                        storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
                        return calculatePriceJSON;
                    }
                    if (maxPeoplerequired < adultsCount + childCount + youthCount + seniorCount) {
                        calculatePriceJSON.setSuccess(false);
                        calculatePriceJSON.setErrorMessageText("More traveller than required.");
                        storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
                        return calculatePriceJSON;
                    }
                    if (!atLeastOneAdult) {
                        calculatePriceJSON.setSuccess(false);
                        calculatePriceJSON.setErrorMessageText("At least one Adult traveller required.");
                        storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
                        return calculatePriceJSON;
                    }

                    if (product.getMainSupplierName().equals("Viator")) {
                        cItem.setTravellers(cTravellers);
                        cItems.add(cItem);
                    }
                    item.setTravellers(travellers);
                    if (product.getMainSupplierName().equals("Viator"))
                        viatorItems.add(item);
                    else  {
                        atbItems.add(item);
                        atbProductPrices.add(atbTotalNetPrice.subtract(previusAtbTotalNetPrice));
                    }
                    previusAtbTotalNetPrice = atbTotalNetPrice;
                }


                /**
                 * Calculate price for viator products.
                 */
                CalculatePriceAPIJSON calculatepriceJson = null;
                CalculatePricePOST viatorCalculatePricePOST = new CalculatePricePOST();
                if (cItems != null && cItems.size() > 0) {
                    viatorCalculatePricePOST.setItems(cItems);
                    viatorCalculatePricePOST.setPartnerDetail(null);
                    viatorCalculatePricePOST.setCurrencyCode(defaultCurrencyCode);
                    calculatepriceJson = BookingsAPIDAO.calculateprice(viatorCalculatePricePOST);
                    if (calculatepriceJson != null) {
                        if (!calculatepriceJson.isSuccess()) {
                            calculatePriceJSON.setErrorMessageText("Error:" + calculatepriceJson.getErrorMessage());
                            calculatePriceJSON.setSuccess(false);
                            storePrebookLog(calculatePricePOST, calculatePriceJSON, calculatepriceJson, viatorCalculatePricePOST, subAgencyBean, "Viator");
                            return calculatePriceJSON;
                        }

                        if (calculatepriceJson.getData() == null || calculatepriceJson.getData().getItinerary() == null || calculatepriceJson.getData().getItinerary().getItemSummaries() == null) {
                            calculatePriceJSON.setErrorMessageText("Communication Error1");
                            calculatePriceJSON.setSuccess(false);
                            storePrebookLog(calculatePricePOST, calculatePriceJSON, calculatepriceJson, viatorCalculatePricePOST, subAgencyBean, "Viator");
                            return calculatePriceJSON;
                        }
                    } else {
                        calculatePriceJSON.setErrorMessageText("Communication Error2");
                        calculatePriceJSON.setSuccess(false);
                        storePrebookLog(calculatePricePOST, calculatePriceJSON, calculatepriceJson, viatorCalculatePricePOST, subAgencyBean, "Viator");
                        return calculatePriceJSON;
                    }
                }

                /**
                 * Check if subagency has the amount on it's deposit
                 */
                GsaBean gsaBean;//todo errore handling(availability error type price error type)
                BigDecimal agentSale = null;
                if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("") &&
                        subAgencyBean.getTrsMkp() != null && !subAgencyBean.getTrsMkp().equals("") &&
                        subAgencyBean.getDtrMkp() != null && !subAgencyBean.getDtrMkp().equals("") &&
                        subAgencyBean.getMtrMkp() != null && !subAgencyBean.getMtrMkp().equals("") &&
                        subAgencyBean.getEvtMkp() != null && !subAgencyBean.getEvtMkp().equals("")) {
                    gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()), null);
                    if (gsaBean != null) {
                        if (gsaBean.getTrsMkp() != null && !gsaBean.getTrsMkp().equals("") &&
                                gsaBean.getDtrMkp() != null && !gsaBean.getDtrMkp().equals("") &&
                                gsaBean.getMtrMkp() != null && !gsaBean.getMtrMkp().equals("") &&
                                gsaBean.getEvtMkp() != null && !gsaBean.getEvtMkp().equals("")) {

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

                                        int gsaMrkUp;
                                        int subAgencyMrkUp;
                                        if (product.getTypeOfProduct().equals("1")) {
                                            gsaMrkUp = Integer.parseInt(gsaBean.getTrsMkp());
                                            subAgencyMrkUp = Integer.parseInt(subAgencyBean.getTrsMkp());
                                        } else if (product.getTypeOfProduct().equals("2")) {
                                            gsaMrkUp = Integer.parseInt(gsaBean.getDtrMkp());
                                            subAgencyMrkUp = Integer.parseInt(subAgencyBean.getDtrMkp());
                                        } else if (product.getTypeOfProduct().equals("3")) {
                                            gsaMrkUp = Integer.parseInt(gsaBean.getMtrMkp());
                                            subAgencyMrkUp = Integer.parseInt(subAgencyBean.getMtrMkp());
                                        } else if (product.getTypeOfProduct().equals("4")) {
                                            gsaMrkUp = Integer.parseInt(gsaBean.getDtrMkp());
                                            subAgencyMrkUp = Integer.parseInt(subAgencyBean.getDtrMkp());
                                        } else {
                                            gsaMrkUp = Integer.parseInt(gsaBean.getEvtMkp());
                                            subAgencyMrkUp = Integer.parseInt(subAgencyBean.getEvtMkp());
                                        }
                                        if (viatorItem.getProductCode().equals(product.getProductCode()) && viatorItem.getTravelDate().equals(atbItem.getTravelDate())) {
                                            if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                                                gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()), null);
                                                if (viatorItem.getMerchantNetPrice() != null) {
                                                    BigDecimal priceWithComision = viatorItem.getMerchantNetPrice().add(viatorItem.getMerchantNetPrice().multiply(viatorComission)).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                    BigDecimal gsaSale = priceWithComision.add(priceWithComision.multiply(BigDecimal.valueOf(gsaMrkUp).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                    agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(subAgencyMrkUp).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                                    totalBookingPrice = agentSale.add(totalBookingPrice);
                                                } else {
                                                    calculatePriceJSON.setErrorMessageText("Code:14 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                                                    calculatePriceJSON.setSuccess(false);
                                                    storePrebookLog(calculatePricePOST, calculatePriceJSON, calculatepriceJson, viatorCalculatePricePOST, subAgencyBean, "Viator");
                                                    return calculatePriceJSON;
                                                }
                                            } else {
                                                calculatePriceJSON.setErrorMessageText("Code:16 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                                                calculatePriceJSON.setSuccess(false);
                                                storePrebookLog(calculatePricePOST, calculatePriceJSON, calculatepriceJson, viatorCalculatePricePOST, subAgencyBean, "Viator");
                                                return calculatePriceJSON;
                                            }


                                            /**
                                             * Response Item.
                                             */
                                            responseItem = new CalculatePriceItem();
                                            responseItem.setPlanId(atbItem.getPlanId());
                                            responseItem.setProductId(atbItem.getProductId());
                                            responseItem.setTravelDate(viatorItem.getTravelDate());
                                            /**
                                             * Currency conversion
                                             */
                                            if (calculatePricePOST.getCurrencyCode() != null && !calculatePricePOST.getCurrencyCode().equals("") && subAgencyBean.getCurrency() != null) {
                                                BigDecimal convertedPrice = CurrencyConverter.findExchangeRateAndConvert(subAgencyBean.getCurrency(), calculatePricePOST.getCurrencyCode(), Double.parseDouble(agentSale.toString()));
                                                if (convertedPrice != null) {
                                                    convertedPrice = convertedPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
                                                    responseItem.setPrice(convertedPrice);
                                                    responseItem.setCurrency(calculatePricePOST.getCurrencyCode());
                                                } else {
                                                    responseItem.setCurrency(subAgencyBean.getCurrency());
                                                    responseItem.setPrice(agentSale);
                                                }
                                            } else {
                                                responseItem.setCurrency(subAgencyBean.getCurrency());
                                                responseItem.setPrice(agentSale);
                                            }
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
                                        int gsaMrkUp;
                                        int subAgencyMrkUp;
                                        if (product.getTypeOfProduct().equals("1")) {
                                            gsaMrkUp = Integer.parseInt(gsaBean.getTrsMkp());
                                            subAgencyMrkUp = Integer.parseInt(subAgencyBean.getTrsMkp());
                                        } else if (product.getTypeOfProduct().equals("2")) {
                                            gsaMrkUp = Integer.parseInt(gsaBean.getDtrMkp());
                                            subAgencyMrkUp = Integer.parseInt(subAgencyBean.getDtrMkp());
                                        } else if (product.getTypeOfProduct().equals("3")) {
                                            gsaMrkUp = Integer.parseInt(gsaBean.getMtrMkp());
                                            subAgencyMrkUp = Integer.parseInt(subAgencyBean.getMtrMkp());
                                        } else if (product.getTypeOfProduct().equals("4")) {
                                            gsaMrkUp = Integer.parseInt(gsaBean.getDtrMkp());
                                            subAgencyMrkUp = Integer.parseInt(subAgencyBean.getDtrMkp());
                                        } else {
                                            gsaMrkUp = Integer.parseInt(gsaBean.getEvtMkp());
                                            subAgencyMrkUp = Integer.parseInt(subAgencyBean.getEvtMkp());
                                        }
                                        if (subAgencyBean.getGsaId() != null && !subAgencyBean.getGsaId().equals("")) {
                                            gsaBean = GsaDAO.getGsaById(Integer.parseInt(subAgencyBean.getGsaId()), null);
                                            BigDecimal gsaSale = atbProductPrices.get(atbItems.indexOf(atbItem)).add(atbProductPrices.get(atbItems.indexOf(atbItem)).multiply(BigDecimal.valueOf(gsaMrkUp).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                            agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(subAgencyMrkUp).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                                            totalBookingPrice = agentSale.add(totalBookingPrice);
                                        } else {
                                            errLogger.info("Booking with generalBookCode :" + generalBookCode + "and atb item id:" + storedItemNumber + " completed at sunhotels side but failed to store correctly to databse");
                                        }//todo replace error logs with return


                                        /**
                                         * Response Item.
                                         */
                                        responseItem = new CalculatePriceItem();
                                        responseItem.setPlanId(requestItem.getPlanId());
                                        responseItem.setProductId(requestItem.getProductId());
                                        responseItem.setTravelDate(requestItem.getTravelDate());
                                        /**
                                         * Currency conversion
                                         */
                                        if (calculatePricePOST.getCurrencyCode() != null && calculatePricePOST.getCurrencyCode() != "" && subAgencyBean.getCurrency() != null) {
                                            BigDecimal convertedPrice = CurrencyConverter.findExchangeRateAndConvert(subAgencyBean.getCurrency(), calculatePricePOST.getCurrencyCode(), Double.parseDouble(agentSale.toString()));
                                            if (convertedPrice != null) {
                                                convertedPrice = convertedPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
                                                responseItem.setPrice(convertedPrice);
                                                responseItem.setCurrency(calculatePricePOST.getCurrencyCode());
                                            } else {
                                                responseItem.setCurrency(subAgencyBean.getCurrency());
                                                responseItem.setPrice(agentSale);
                                            }
                                        } else {
                                            responseItem.setCurrency(subAgencyBean.getCurrency());
                                            responseItem.setPrice(agentSale);
                                        }
                                        responseItems.add(responseItem);
                                    }
                                }
                            }
                            /**
                             * Response.
                             */

                            calculatePriceJSON.setItems(responseItems);
                            /**
                             * Currency conversion
                             */
                            if (calculatePricePOST.getCurrencyCode() != null && calculatePricePOST.getCurrencyCode() != "" && subAgencyBean.getCurrency() != null) {
                                BigDecimal convertedPrice = CurrencyConverter.findExchangeRateAndConvert(subAgencyBean.getCurrency(), calculatePricePOST.getCurrencyCode(), Double.parseDouble(totalBookingPrice.toString()));
                                if (convertedPrice != null) {
                                    convertedPrice = convertedPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    calculatePriceJSON.setTotalPrice(convertedPrice);
                                    calculatePriceJSON.setCurrencyCode(calculatePricePOST.getCurrencyCode());
                                } else {
                                    calculatePriceJSON.setTotalPrice(totalBookingPrice);
                                    calculatePriceJSON.setCurrencyCode(subAgencyBean.getCurrency());
                                }
                            } else {
                                calculatePriceJSON.setTotalPrice(totalBookingPrice);
                                calculatePriceJSON.setCurrencyCode(subAgencyBean.getCurrency());
                            }
                            storePrebookLog(calculatePricePOST, calculatePriceJSON, calculatepriceJson, viatorCalculatePricePOST, subAgencyBean, "Viator/ATB Holidays");
                            return calculatePriceJSON;

                        } else {
                            calculatePriceJSON.setSuccess(false);
                            calculatePriceJSON.setErrorMessageText("Code:2  Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                            storePrebookLog(calculatePricePOST, calculatePriceJSON, calculatepriceJson, viatorCalculatePricePOST, subAgencyBean, "");
                            return calculatePriceJSON;
                        }
                    } else {
                        calculatePriceJSON.setSuccess(false);
                        calculatePriceJSON.setErrorMessageText("Code:3  Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                        storePrebookLog(calculatePricePOST, calculatePriceJSON, calculatepriceJson, viatorCalculatePricePOST, subAgencyBean, "");
                        return calculatePriceJSON;
                    }
                } else {
                    calculatePriceJSON.setSuccess(false);
                    calculatePriceJSON.setErrorMessageText("Code:4  Couldn't retrieve essential data from database.Please contact at george.nafpaktitis@atbholidays.com");
                    storePrebookLog(calculatePricePOST, calculatePriceJSON, calculatepriceJson, viatorCalculatePricePOST, subAgencyBean, "");
                    return calculatePriceJSON;
                }
            } else {
                calculatePriceJSON.setErrorMessageText("Code:17 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                calculatePriceJSON.setSuccess(false);
                storePrebookLog(calculatePricePOST, calculatePriceJSON, null, null, subAgencyBean, "");
                return calculatePriceJSON;
            }
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            calculatePriceJSON.setSuccess(false);
            calculatePriceJSON.setErrorMessageText(errors.toString());
            return calculatePriceJSON;
        }

    }

}
