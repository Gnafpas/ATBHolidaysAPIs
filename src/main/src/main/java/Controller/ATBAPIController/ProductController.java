package Controller.ATBAPIController;

import APIJSONs.ATBAPIJSONs.Product.*;
import Beans.ATBDBBeans.KalitaonProduct.*;
import Beans.ATBDBBeans.KalitaonSystem.GsaBean;
import Beans.ATBDBBeans.KalitaonSystem.SubAgencyBean;
import Controller.Application;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.*;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.GsaDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.SubAgencyDAO;
import Helper.CurrencyConverter;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.*;

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
import static Helper.ProjectProperties.photoSupplierId;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Created by George on 27/09/2017.
 */
@RestController
public class ProductController {


    /**
     * Retrieving products by code,title,country,city,region,destination id,primary destination id or
     * a combination of those attributes.Capability of filtering by categories and sort by REVIEW_AVG_RATING_D,
     * REVIEW_AVG_RATING_A, POPULARITY, PRICE_D, PRICE_a, DURATION_D, DURATION_A.Also filtering by dates.Returns
     * all categories and how many products has each category for the specific search.
     */
    @RequestMapping(value = "/product/search", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public ProductsAndCategoriesJSON getATBProductsAndCategories(@RequestBody ProductsAndCategoriesPOST params,
                                                                 @RequestParam("apiKey") String apiKey){


        Application.agent.increment("app.web.request.api.product.search");
        ProductsAndCategoriesJSON productsAndCategoriesJSON =new ProductsAndCategoriesJSON();
        List <AProductTitleBean>  aProductTitlebeans;
        int i=0;

        try {
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


                //todo prevent abstract request(request without defining any parameter.country,city,freetext etc )
                Application.agent.notice(subAgencyBean.getAgentName());
                if (params.getCountryCode()!=null && !params.getCountryCode().equals(""))
                    params.setCountryCode(params.getCountryCode() + " ");//todo fix isocode at the database(Remove the space at the end of the code) or live it like this
                DateTime dateTime = new DateTime(DateTimeZone.UTC);
                productsAndCategoriesJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                        dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                        dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
                /**
                 * Limit Max products per request.
                 */
                if (params.getLastProduct()!=null && params.getFirstProduct()!=null && params.getLastProduct().compareTo(params.getFirstProduct())==-1)
                    params.setLastProduct(params.getFirstProduct() + 1000);
                else if (params.getLastProduct()!=null && params.getFirstProduct()!=null &&(params.getLastProduct() - params.getFirstProduct() > 1000))
                    params.setLastProduct(params.getFirstProduct() + 1000);


                ZonedDateTime startDate = null;
                ZonedDateTime endDate = null;
                if (params.getStartDate() != null && params.getEndDate() != null) {
                    if (!params.getStartDate().equals("") && !params.getEndDate().equals("")) {
                        String sdate[] = params.getStartDate().split("-");
                        String edate[] = params.getEndDate().split("-");
                        if (sdate.length == 3 && edate.length == 3) {
                            try {
                                startDate = ZonedDateTime.of(LocalDate.of(Integer.parseInt(sdate[0]), Integer.parseInt(sdate[1]), Integer.parseInt(sdate[2])),
                                        LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                                endDate = ZonedDateTime.of(LocalDate.of(Integer.parseInt(edate[0]), Integer.parseInt(edate[1]), Integer.parseInt(edate[2])),
                                        LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                                if (DAYS.between(startDate, endDate) > 30) {
                                    productsAndCategoriesJSON.setErrorMessageText("The preiod between 'startDate' and 'endDate' must be less than 30 days");
                                    productsAndCategoriesJSON.setSuccess(false);
                                    return productsAndCategoriesJSON;
                                }
                            } catch (NumberFormatException e) {
                                productsAndCategoriesJSON.setSuccess(false);
                                productsAndCategoriesJSON.setErrorMessageText("Wrong date type.The correct format is yyyy-mm-dd");
                                return productsAndCategoriesJSON;
                            }
                        }

                    }
                }

                if (params.getCurrencyCode()!=null && !params.getCurrencyCode().equals("")) {
                    if (CurrencyConverter.findExchangeRateAndConvert("EUR", params.getCurrencyCode(), new Double(1)) == null) {
                        productsAndCategoriesJSON.setSuccess(false);
                        productsAndCategoriesJSON.setErrorMessageText("Wrong currrency code");
                        return productsAndCategoriesJSON;
                    }
                }

                /**
                 * Get products
                 */
                aProductTitlebeans = AProductTitleDAO.getProducts(params, startDate, endDate, null);
                if (aProductTitlebeans == null) {
                    productsAndCategoriesJSON.setSuccess(false);
                    productsAndCategoriesJSON.setErrorMessageText("Database Communication Error.");
                } else {
                    List<Product> products = new ArrayList<>();
                    for (AProductTitleBean aProductTitleBean : aProductTitlebeans) {
                        Product product = new Product();
                        product.setaPoint(aProductTitleBean.getaPoint());
                        product.setbPoint(aProductTitleBean.getbPoint());
                        product.setUpdatedAt(aProductTitleBean.getUpdatedAt());
                        product.setTypeOfProduct(aProductTitleBean.getTypeOfProduct());
                        product.setThumbnailUrl(aProductTitleBean.getThumbnailUrl());
                        product.setTextLanguage(aProductTitleBean.getTextLanguage());
                        product.setStock(aProductTitleBean.getStock());
                        product.setProductTitle(aProductTitleBean.getProductTitle());
                        if (aProductTitleBean.getOnSale() == null || aProductTitleBean.getOnSale().equals("0"))
                            product.setOnSale(false);
                        else if (aProductTitleBean.getOnSale().equals("1") || aProductTitleBean.getOnSale().equals("ON"))
                            product.setOnSale(true);
                        product.setId(aProductTitleBean.getId());
                        product.setCountryName(aProductTitleBean.getCountryName());
                        product.setCountryCode(aProductTitleBean.getCountryCode());
                        // product.setShippable(aProductTitleBean.isShippable());
                        product.setCityName(aProductTitleBean.getCityName());
                        product.setCityCode(aProductTitleBean.getCityCode());
                        product.setCategoriesTag(aProductTitleBean.getCategoriesTag());

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
                        BigDecimal agentSale = null;
                        if (aProductTitleBean.getMarchandNetPrice() != null && !aProductTitleBean.getMarchandNetPrice().equals("")) {
                            BigDecimal price = new BigDecimal(Double.parseDouble(aProductTitleBean.getMarchandNetPrice()));
                            BigDecimal gsaSale = price.add(price.multiply(BigDecimal.valueOf(gsaMrkUp).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                            agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(subAgencyMrkUp).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                        }
                        if (agentSale != null) {
                            /**
                             * Currency conversion
                             */
                            if (!params.getCurrencyCode().equals("") && aProductTitleBean.getCurrencyCode() != null && aProductTitleBean.getMarchandNetPrice() != null && aProductTitleBean != null) {
                                BigDecimal convertedPrice = CurrencyConverter.findExchangeRateAndConvert(aProductTitleBean.getCurrencyCode(), params.getCurrencyCode(), Double.parseDouble(agentSale.toString()));
                                if (convertedPrice != null) {
                                    convertedPrice = convertedPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    product.setMarchandNetPrice(convertedPrice.toString());
                                    product.setCurrencyCode(params.getCurrencyCode());
                                } else {
                                    product.setCurrencyCode(aProductTitleBean.getCurrencyCode());
                                    product.setMarchandNetPrice(agentSale.toString());
                                }
                            } else {
                                product.setCurrencyCode(aProductTitleBean.getCurrencyCode());
                                product.setMarchandNetPrice(agentSale.toString());
                            }
                        } else {
                            product.setCurrencyCode(aProductTitleBean.getCurrencyCode());
                            product.setMarchandNetPrice("");
                        }

                        products.add(product);
                    }
                    productsAndCategoriesJSON.setTotalCount(products.size());

                    if (params.getLastProduct().compareTo(aProductTitlebeans.size())>=0 || params.getLastProduct() <= 0) {
                        if(params.getFirstProduct().compareTo(aProductTitlebeans.size())<=0){
                            productsAndCategoriesJSON.getData().setProducts(products.subList(params.getFirstProduct(), aProductTitlebeans.size()));
                        }
                    } else {
                        if (params.getFirstProduct().compareTo( params.getLastProduct()) <= 0) {
                            productsAndCategoriesJSON.getData().setProducts(products.subList(params.getFirstProduct(), params.getLastProduct()));
                        }
                    }
                }

                /**
                 * Get all categories and Find products count for each category
                 */
//        List<ProductCategoriesBean> categories;
//        List<String> categoryNames=new ArrayList<>();
//        List<Categories> categoriesInJSON=new ArrayList<>();
//        Categories category;
//        categories=ProductCategoriesDAO.getAllCategories();
//        if(categories!=null) {
//            for (ProductCategoriesBean cat : categories) {
//                category = new Categories();
//                category.setCategories(cat);
//                categoryNames.clear();
//                categoryNames.add(cat.getCategoryName());
//                params.setCategories(categoryNames);
//                products = AProductTitleDAO.getProducts(params,startDate,endDate);
//                if (products != null)
//                    category.setProductCount(products.size());
//                categoriesInJSON.add(category);
//            }
//        }else {
//            productsAndCategoriesJSON.setSuccess(false);
//            productsAndCategoriesJSON.setErrorMessageText("Database Communication Error.");
//        }
//        productsAndCategoriesJSON.getData().setCategories(categoriesInJSON);

            } else {
                productsAndCategoriesJSON.setErrorMessageText("Code:17 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                productsAndCategoriesJSON.setSuccess(false);
            }
        }catch(Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            productsAndCategoriesJSON.setSuccess(false);
            productsAndCategoriesJSON.setErrorMessageText(errors.toString());
        }
        return productsAndCategoriesJSON;
    }


    @RequestMapping("/product/productDetails")
    public ProductDetailsJSON getProductDetails(@RequestParam(value = "productId", defaultValue = "") String productId,
                                                @RequestParam(value = "currencyCode", defaultValue = "") String currencyCode,
                                                @RequestParam("apiKey") String apiKey
                                                ) {

        Application.agent.increment("app.web.request.api.product.productDetails");
        ProductDetailsJSON productDetailsJSON = new ProductDetailsJSON();
        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        productDetailsJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");

        try {
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

                Application.agent.notice(subAgencyBean.getAgentName());
                ProductsAndCategoriesPOST params = new ProductsAndCategoriesPOST();
                params.setProductId(Integer.valueOf(productId));
                if (currencyCode != null)
                    params.setCurrencyCode(currencyCode);
                else
                    params.setCurrencyCode("");


                if (!params.getCurrencyCode().equals("")) {
                    if (CurrencyConverter.findExchangeRateAndConvert("EUR", params.getCurrencyCode(), new Double(1)) == null) {
                        productDetailsJSON.setSuccess(false);
                        productDetailsJSON.setErrorMessageText("Wrong currrency code");
                        return productDetailsJSON;
                    }
                }

                List<PickupPoint> pickupPoints = new ArrayList<>();
                List<EPickupPointBean> ePickupPointsBean = EPickupPointDAO.getePickupPointsByProductId(productId);
                if (ePickupPointsBean != null) {
                    for (EPickupPointBean ePickupPointBean : ePickupPointsBean) {
                        PickupPoint pickupPoint = new PickupPoint();
                        pickupPoint.setDropOfEndPoint(ePickupPointBean.getDropOfEndPoint());
                        pickupPoint.setHotelId(ePickupPointBean.getHotelId());
                        pickupPoint.setHotelPickupPoint(ePickupPointBean.getHotelPickupPoint());
                        pickupPoint.setId(ePickupPointBean.getId());
                        pickupPoint.setLatitude(ePickupPointBean.getLatitude());
                        pickupPoint.setLongitude(ePickupPointBean.getLongitude());
                        pickupPoint.setPickupNote(ePickupPointBean.getPickupNote());
                        pickupPoint.setProductId(ePickupPointBean.getProductId());
                        pickupPoint.setStartingPoint(ePickupPointBean.getStartingPoint());
                        pickupPoint.setUpdatedAt(ePickupPointBean.getUpdatedAt());
                        pickupPoints.add(pickupPoint);
                    }
                } else
                    pickupPoints = null;


                List<ProductMoreDetails> productMoreDetails = new ArrayList<>();
                List<BProductDetailBean> bProductDetailBean = BProductDetailDAO.getBProductDetailsByProductId(productId);
                if (bProductDetailBean != null) {
                    for (BProductDetailBean detailBean : bProductDetailBean) {
                        ProductMoreDetails productMoreDetail = new ProductMoreDetails();
                        productMoreDetail.setAdittionalInfo(detailBean.getAdittionalInfo());
                        productMoreDetail.setCancellationPolicy(detailBean.getCancellationPolicy());//todo add cancelation policy acording to merchant cancellable field
                        productMoreDetail.setVoucherTelephone(detailBean.getVoucherTelephone());
                        productMoreDetail.setVoucherInfo(detailBean.getVoucherInfo());
                        productMoreDetail.setUpdatedAt(detailBean.getUpdatedAt());
                        productMoreDetail.setProductId(detailBean.getProductId());
                        productMoreDetail.setProductDetail(detailBean.getProductDetail());
                        productMoreDetail.setMobileAccess(detailBean.getMobileAccess());
                        if (detailBean.getMerchantCancellable().equals("true"))
                            productMoreDetail.setMerchantCancellable("48");
                        else if (detailBean.getMerchantCancellable().equals("false") || detailBean.getMerchantCancellable().equals("") || detailBean.getMerchantCancellable().equals("non-refundable"))
                            productMoreDetail.setMerchantCancellable("0");
                        else
                            productMoreDetail.setMerchantCancellable(bProductDetailBean.get(0).getMerchantCancellable());
                        productMoreDetail.setInclusions(detailBean.getInclusions());
                        productMoreDetail.setId(detailBean.getId());
                        productMoreDetail.setHighlight(detailBean.getHighlight());
                        productMoreDetail.setExclusions(detailBean.getExclusions());
                        productMoreDetail.setDescriptionSummary(detailBean.getDescriptionSummary());
                        productMoreDetails.add(productMoreDetail);
                    }

                } else
                    productMoreDetails = null;


                List<ProductOptions> productOptions = new ArrayList<>();
                List<CProductOptionsBean> cProductOptionsBean = CProductOptionsDAO.getcProductOptionsByProductId(productId);
                if (cProductOptionsBean != null) {
                    for (CProductOptionsBean cProductOptionBean : cProductOptionsBean) {
                        ProductOptions productOption = new ProductOptions();
                        productOption.setDuration(cProductOptionBean.getDuration());
                        productOption.setGuidingAudio(cProductOptionBean.getGuidingAudio());
                        productOption.setGuidingBooklets(cProductOptionBean.getGuidingBooklets());
                        productOption.setGuidingLive(cProductOptionBean.getGuidingLive());
                        productOption.setId(cProductOptionBean.getId());
                        productOption.setProductId(cProductOptionBean.getProductId());
                        productOption.setUpdatedAt(cProductOptionBean.getUpdatedAt());
                        productOptions.add(productOption);
                    }
                } else
                    productOptions = null;


                List<Product> products = new ArrayList<>();
                List<AProductTitleBean> aProductTitleBeans = AProductTitleDAO.getProducts(params, null, null, null);
                if (aProductTitleBeans != null) {
                    for (AProductTitleBean aProductTitleBean : aProductTitleBeans) {
                        Product product = new Product();
                        product.setaPoint(aProductTitleBean.getaPoint());
                        product.setbPoint(aProductTitleBean.getbPoint());
                        product.setUpdatedAt(aProductTitleBean.getUpdatedAt());
                        product.setTypeOfProduct(aProductTitleBean.getTypeOfProduct());
                        product.setThumbnailUrl(aProductTitleBean.getThumbnailUrl());
                        product.setTextLanguage(aProductTitleBean.getTextLanguage());
                        product.setStock(aProductTitleBean.getStock());
                        product.setProductTitle(aProductTitleBean.getProductTitle());
                        if (aProductTitleBean.getOnSale() == null || aProductTitleBean.getOnSale().equals("0"))
                            product.setOnSale(false);
                        else if (aProductTitleBean.getOnSale().equals("1") || aProductTitleBean.getOnSale().equals("ON"))
                            product.setOnSale(true);
                        // product.setShippable(aProductTitleBean.isShippable());
                        product.setId(aProductTitleBean.getId());
                        product.setCountryName(aProductTitleBean.getCountryName());
                        product.setCountryCode(aProductTitleBean.getCountryCode());
                        product.setCityName(aProductTitleBean.getCityName());
                        product.setCityCode(aProductTitleBean.getCityCode());
                        product.setCategoriesTag(aProductTitleBean.getCategoriesTag());

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
                        BigDecimal agentSale = null;
                        if (aProductTitleBean.getMarchandNetPrice() != null && !aProductTitleBean.getMarchandNetPrice().equals("")) {
                            BigDecimal price = new BigDecimal(Double.parseDouble(aProductTitleBean.getMarchandNetPrice()));
                            BigDecimal gsaSale = price.add(price.multiply(BigDecimal.valueOf(gsaMrkUp).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                            agentSale = gsaSale.add(gsaSale.multiply(BigDecimal.valueOf(subAgencyMrkUp).divide(new BigDecimal(100)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                        }
                        if (agentSale != null) {
                            /**
                             * Currency conversion
                             */
                            if (!params.getCurrencyCode().equals("") && aProductTitleBean.getCurrencyCode() != null && aProductTitleBean.getMarchandNetPrice() != null && aProductTitleBean != null) {
                                BigDecimal convertedPrice = CurrencyConverter.findExchangeRateAndConvert(aProductTitleBean.getCurrencyCode(), params.getCurrencyCode(), Double.parseDouble(agentSale.toString()));
                                if (convertedPrice != null) {
                                    convertedPrice = convertedPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
                                    product.setMarchandNetPrice(convertedPrice.toString());
                                    product.setCurrencyCode(params.getCurrencyCode());
                                } else {
                                    product.setCurrencyCode(aProductTitleBean.getCurrencyCode());
                                    product.setMarchandNetPrice(agentSale.toString());
                                }
                            } else {
                                product.setCurrencyCode(aProductTitleBean.getCurrencyCode());
                                product.setMarchandNetPrice(agentSale.toString());
                            }
                        } else {
                            product.setCurrencyCode(aProductTitleBean.getCurrencyCode());
                            product.setMarchandNetPrice("");
                        }

                        products.add(product);
                    }
                } else {
                    products = null;
                }

                List<PricePlan> pricePlans = new ArrayList<>();
                List<FPricePlanBean> fPricePlanBeans = FPricePlanDAO.getfPricePlansByProductId(productId);
                if (aProductTitleBeans != null) {
                    for (FPricePlanBean fPricePlanBean : fPricePlanBeans) {
                        PricePlan pricePlan = new PricePlan();
                        pricePlan.setId(fPricePlanBean.getId());
                        pricePlan.setMinParticipants(fPricePlanBean.getMinParticipants());
                        pricePlan.setPlanTitle(fPricePlanBean.getPlanTitle());
                        pricePlan.setPriceType(fPricePlanBean.getPriceType());
                        pricePlan.setProductId(fPricePlanBean.getProductId());
                        pricePlan.setUpdatedAt(fPricePlanBean.getUpdatedAt());
                        pricePlans.add(pricePlan);
                    }
                } else {
                    pricePlans = null;
                }

                List<BookingQuestion> bookingQuestions = new ArrayList<>();
                List<JProductQuestionsBean> jProductQuestionsBeans = JProductQuestionsDAO.getProductByCode(productId);
                if (aProductTitleBeans != null) {
                    for (JProductQuestionsBean jProductQuestionsBean : jProductQuestionsBeans) {
                        BookingQuestion bookingQuestion = new BookingQuestion();
                        bookingQuestion.setMessage(jProductQuestionsBean.getMessage());
                        bookingQuestion.setProductId(jProductQuestionsBean.getProductId());
                        bookingQuestion.setQuestionId(jProductQuestionsBean.getQuestionId());
                        bookingQuestion.setRequired(jProductQuestionsBean.isRequired());
                        bookingQuestion.setSortOrder(jProductQuestionsBean.getSortOrder());
                        bookingQuestion.setStringQuestionId(jProductQuestionsBean.getStringQuestionId());
                        bookingQuestion.setSubTitleEn(jProductQuestionsBean.getSubTitleEn());
                        bookingQuestion.setTitleEn(jProductQuestionsBean.getTitleEn());
                        bookingQuestion.setUpdatedAt(jProductQuestionsBean.getUpdatedAt());
                        bookingQuestions.add(bookingQuestion);
                    }
                } else {
                    bookingQuestions = null;
                }

                List<Photo> photos = new ArrayList<>();
                List<DProductPhotoBean> dProductPhotobeans = DProductPhotoDAO.getdProductPhotosByProductId(productId);
                if (dProductPhotobeans != null) {
                    for (DProductPhotoBean dProductPhotoBean : dProductPhotobeans) {
                        Photo photo = new Photo();
                        photo.setCaption(dProductPhotoBean.getCaption());
                        photo.setId(dProductPhotoBean.getId());
                        photo.setMainPhoto(dProductPhotoBean.getMainPhoto());
                        photo.setProductId(dProductPhotoBean.getProductId());
                        photo.setUpdatedAt(dProductPhotoBean.getUpdatedAt());
                        if (dProductPhotoBean.getSupplierId() != null && dProductPhotoBean.getSupplierId().equals(""))
                            photo.setPhotoURL("http://old.atbholidays.com/photo_gallery/max/" + dProductPhotoBean.getPhotoName());//todo change the code to be more dynamic here when we add more providers
                        else if (dProductPhotoBean.getSupplierId() != null && dProductPhotoBean.getSupplierId().equals(String.valueOf(photoSupplierId))) {
                            if (dProductPhotoBean.getPhotoName().charAt(0) == '/')
                                photo.setPhotoURL("http://cache-graphicslib.viator.com/graphicslib" + dProductPhotoBean.getPhotoName());
                            else
                                photo.setPhotoURL("http://cache-graphicslib.viator.com/graphicslib/" + dProductPhotoBean.getPhotoName());
                        } else if (dProductPhotoBean.getSupplierId() != null && dProductPhotoBean.getSupplierId().equals(String.valueOf("10232")))
                            photo.setPhotoURL("http://www.eventstravel.eu/uploads/images/" + dProductPhotoBean.getPhotoName());
                        photos.add(photo);
                    }
                } else
                    photos = null;

                productDetailsJSON.getData().setProductTitle(products);
                productDetailsJSON.getData().setProductDetails(productMoreDetails);
                productDetailsJSON.getData().setProductOptions(productOptions);
                productDetailsJSON.getData().setProductPhotos(photos);
                productDetailsJSON.getData().setPricePlans(pricePlans);
                productDetailsJSON.getData().setPickupPoints(pickupPoints);
                productDetailsJSON.getData().setBookingQuestions(bookingQuestions);
                productDetailsJSON.setTotalCount(1);
                if (productDetailsJSON.getData().getProductTitle() == null || productDetailsJSON.getData().getProductDetails() == null ||
                        productDetailsJSON.getData().getProductOptions() == null || productDetailsJSON.getData().getProductPhotos() == null ||
                        productDetailsJSON.getData().getPickupPoints() == null || productDetailsJSON.getData().getPricePlans() == null ||
                        productDetailsJSON.getData().getBookingQuestions() == null) {
                    productDetailsJSON.setSuccess(false);
                    productDetailsJSON.setErrorMessageText("Database Communication Error.");
                }
            } else {
                productDetailsJSON.setErrorMessageText("Code:17 Essential data are missing  for this product.Please contact at george.nafpaktitis@atbholidays.com");
                productDetailsJSON.setSuccess(false);
            }
        }catch(Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            productDetailsJSON.setSuccess(false);
            productDetailsJSON.setErrorMessageText(errors.toString());
        }
        return productDetailsJSON;
    }
}
