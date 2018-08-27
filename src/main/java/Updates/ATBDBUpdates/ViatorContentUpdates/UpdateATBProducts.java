package Updates.ATBDBUpdates.ViatorContentUpdates;

import Beans.ATBDBBeans.KalitaonProduct.*;
import Beans.ATBDBBeans.KalitaonSystem.AllLanguageBean;
import Beans.ATBDBBeans.KalitaonSystem.CityCodeBean;
import Beans.ATBDBBeans.KalitaonSystem.CountryCodeBean;
import Controller.AdminController.AdminController;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.*;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.AllLanguageDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.CityCodeDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.CountryCodeDAO;
import DAOs.ViatorDBDAOs.*;
import Beans.ViatorDBBeans.*;
import Helper.ProjectProperties;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static Controller.AdminController.AdminController.atbimidiateUpdateStop;
import static Controller.Application.errLogger;
import static Helper.ProjectProperties.viatorComission;

/**
 * Created by George on 08/08/2017.
 */
public class UpdateATBProducts {

    public static void updateProducts(String firstProductCode,String lastProductCode) {


        List<ViatorProductDetailsBean> products;
        List<ViatorCategoriesBean> categories;
        List<ViatorSubcategoriesBean> subCategories;
        List<ViatorProductInclusionsBean> inclusions;
        List<ViatorProductExclusionsBean> exclusions;
        List<ViatorProductAdditionalInfoBean> additionalInfos;
        List<ViatorProductPhotosBean> photos;
        List<ViatorPickupHotelsBean> pickupHotels;
        List<ViatorPricingMatrixBean> pricingMatrixes;
        List<ViatorProductTourGradesBean> tourGrades;
        List<ViatorProductTourGradeLanguageServicesBean> tourGradeLanguageServices;
        List<ViatorProductAgeBandsBean> ageBands;
        List<ViatorNoneAvailableDatesBean> noneAvailableDates;
        List<ViatorProductBookingQuestionsBean> bookingQuestions;

        AProductTitleBean aProductTitleBean = new AProductTitleBean();
        BProductDetailBean bProductDetailBean;
        List<BProductDetailBean> bProductDetails = new ArrayList<>();
        CProductOptionsBean cProductOptionsBean;
        List<CProductOptionsBean> cProductOptions = new ArrayList<>();
        DProductPhotoBean dProductPhotoBean;
        List<DProductPhotoBean> dProductPhotos = new ArrayList<>();
        JProductQuestionsBean jProductQuestionsBean;
        List<JProductQuestionsBean> jProductQuestions=new ArrayList<>();
        EPickupPointBean ePickupPointBean;
        List<EPickupPointBean> ePickupPoints = new ArrayList<>();
        FPricePlanBean fPricePlanBean = new FPricePlanBean();
        GPriceMatrixBean gPriceMatrixBean;
        List<GPriceMatrixBean> gPriceMatrixes = new ArrayList<>();
        IAvailableTimeBean iAvailableTimeBean = new IAvailableTimeBean();
        HAvailableDateBean hAvailableDateBean = new HAvailableDateBean();
        HStopsaleDateBean hStopsaleDateBean;

        try {
            AdminController.atbViatorUpdateRunning = true;

            /**
             * Update info variables
             */
            int totalproducts = 0;
            int dbCommErrors = 0;
            int totalExpiredProducts = 0;
            AtbUpdateProductsInfoBean lastrec;
            DateTime dT = new DateTime(DateTimeZone.UTC);
            boolean failedProductCodeExist;
            List<String> failedProductCodes = new ArrayList<>();
            AtbUpdateFailedProductBean failedProduct = new AtbUpdateFailedProductBean();
            AtbUpdateProductsInfoBean atbUpdateProductsInfoBean = new AtbUpdateProductsInfoBean();
            atbUpdateProductsInfoBean.setStartDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                    dT.getYear(), dT.getMonthOfYear(), dT.getDayOfMonth(),
                    dT.getHourOfDay(), dT.getMinuteOfHour())));

            /**
             * Set up logger.
             */
            Logger logger = Logger.getLogger("UpdateATBProductsLog");
            FileHandler fh;
            try {
                for (Handler handler : logger.getHandlers()) {
                    logger.removeHandler(handler);
                }
                // This block configure the logger with handler and formatter
                fh = new FileHandler(ProjectProperties.logspath + "UpdateATBProductsLog.log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
            } catch (SecurityException e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                errLogger.info(errors.toString());
            } catch (IOException e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                errLogger.info(errors.toString());
            }


            List<AllLanguageBean> allLanguages = AllLanguageDAO.getAllLanguages();
            if (allLanguages == null)
                allLanguages = new ArrayList<>();
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            AProductTitleBean productTitleRecord = null;
            FPricePlanBean pricePlanlastRecord = null;
            boolean firstPriceMatrix;
            List<String> productOptionlanguages = new ArrayList<>();
            boolean langAlreadyExist;
            AProductTitleBean updatedProduct = null;           /*Variable for determine if the product is updated or added for first time.*/
            List<String> updatedProductsIds = new ArrayList(); /*If it is updated ,delete the old details to add the new ones*/
            List<CityCodeBean> cities = CityCodeDAO.getCities();
            List<CountryCodeBean> countries = CountryCodeDAO.getCountries();
            if (countries == null || cities == null) {
                logger.info("Couldn't retrieve countries and citys from Atb Database.Update failed");
                return;
            }

            /** BProductDetail Table Parameters*/
            String info = "";

            /** DProductPhoto Table Parameters*/
            String[] photoURL;

            /** CProductOptions Table Parameters*/
            String[] splitLanguageServiceDescription;
            String[] splitLanguageCodeAndService;

            /** HAvailableDate Table Parameters*/
            HAvailableDateBean lastAvailableDateRecord;
            int lastDate;
            Calendar calendar;
            calendar = Calendar.getInstance();


            /** FPricePlan Table Parameters*/
            List<String> productTourGradeCodes = new ArrayList<>();
            boolean tourgradeExists;
            List<String> tourGradeWithAgeBandcodes = new ArrayList<>();
            boolean tourGradeWithAgeBandExists;

            /** Determine from which product to start the update from the list*/
            boolean updateProduct = false;
            if (firstProductCode.equals("")) {
                updateProduct = true;
            }


            /**
             * Delete expired products from ATBDB.
             */
            totalExpiredProducts = DeleteATBExpiredProducts.deleteATBExpiredProducts(logger).getTotalExpiredProducts();

            /**
             * Retrieving all viator products codes.
             */
            List<String> codes = ViatorProductDetailsDAO.getAllProductsCodes();
            List<String> bannedViatorProductCodes= AProductTitleDAO.getAllBannedViatorProductsCodes();
            if (codes != null) {
                /**
                 * For each product retrieve details and store to ATB DB a_product_title table.
                 */

                for (String code : codes) {

                    /**
                     * Don't Update products that we have direct contract and we have skipped Viator for them.
                     */
                    if(bannedViatorProductCodes!=null){
                        boolean bannedProduct=false;
                        for(String c:bannedViatorProductCodes){
                            if(c.equals(code)){
                                bannedProduct=true;
                                break;
                            }
                        }
                        if(bannedProduct)
                            continue;
                    }

                    if (atbimidiateUpdateStop)
                        break;
                    /**
                     * Determine from which product to start the update from the list
                     */
                    if (code.equals(firstProductCode)) {
                        updateProduct = true;
                    }
                    if (code.equals(lastProductCode)) {
                        updateProduct = false;
                    }
                    if (!updateProduct)
                        continue;

                    products = ViatorProductDetailsDAO.getProducts(code);
                    if (products != null && products.size() > 0) {

                        aProductTitleBean.setBookingEngine("");
                        aProductTitleBean.setShowPrice((products.get(0).getMerchantNetPriceFrom().add(products.get(0).getMerchantNetPriceFrom().multiply(viatorComission)).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
                        aProductTitleBean.setReason("");
                        aProductTitleBean.setProductReferenceCode("");
                        if (products.get(0).getSortOrder() != null)
                            aProductTitleBean.setSortOrder(String.valueOf(products.get(0).getSortOrder()));
                        else
                            aProductTitleBean.setSortOrder("");
                        aProductTitleBean.setbPoint("");
                        aProductTitleBean.setaPoint("");
                        aProductTitleBean.setCityCode("");
                        aProductTitleBean.setSubSupplierId("");
                        aProductTitleBean.setCountryCode("");
                        aProductTitleBean.setCountryName("");
                        aProductTitleBean.setCurrencyCode("");
                        aProductTitleBean.setMainSupplierId("");
                        aProductTitleBean.setMarchandNetPrice("");
                        aProductTitleBean.setProductCode("");
                        aProductTitleBean.setProductTitle("");
                        aProductTitleBean.setSubId("");
                        aProductTitleBean.setSubSupplierName("");
                        aProductTitleBean.setThumbnailUrl("");
                        aProductTitleBean.setCityName("");
                        aProductTitleBean.setTypeOfProduct("");
                        aProductTitleBean.setCategoriesTag("");
                        aProductTitleBean.setMainSupplierName("Viator");
                        aProductTitleBean.setOnSale("1");
                        aProductTitleBean.setTextLanguage("ENG");
                        aProductTitleBean.setCurrencyCode(products.get(0).getCurrencyCode());
                        aProductTitleBean.setMainSupplierId(ProjectProperties.photoSupplierId);
                        aProductTitleBean.setMarchandNetPrice((products.get(0).getMerchantNetPriceFrom().add(products.get(0).getMerchantNetPriceFrom().multiply(viatorComission)).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
                        aProductTitleBean.setProductCode(products.get(0).getCode());
                        aProductTitleBean.setProductTitle(products.get(0).getShortTitleEn());
                        aProductTitleBean.setSubId(products.get(0).getCode());
                        aProductTitleBean.setSubSupplierName(products.get(0).getSupplierName());
                        aProductTitleBean.setThumbnailUrl(products.get(0).getThumbnailHiResUrl());
                        aProductTitleBean.setCityName(products.get(0).getCityEn().toUpperCase());
                        aProductTitleBean.setUpdatable(true);
                        if (products.get(0).getBookingEngineId() != null)
                            aProductTitleBean.setBookingEngine(products.get(0).getBookingEngineId());

                        /**
                         * Countries matching
                         */
                        if (products.get(0).getCountryEn() != null) {//todo remove this code when destinations id match is completed
                            if (products.get(0).getCountryEn().equals("United States of America"))
                                aProductTitleBean.setCountryName("USA");
                            else if (products.get(0).getCountryEn().equals("Russian Federation"))
                                aProductTitleBean.setCountryName("RUSSIA");
                            else if (products.get(0).getCountryEn().equalsIgnoreCase("HONG KONG"))
                                aProductTitleBean.setCountryName("CHINA");
                            else
                                aProductTitleBean.setCountryName(products.get(0).getCountryEn().toUpperCase());

                            for (CountryCodeBean country : countries) {
                                if (country.getCountryName().equalsIgnoreCase(aProductTitleBean.getCountryName()))
                                    aProductTitleBean.setCountryCode(country.getIsoCode());
                            }
                        }

                        /**
                         * Cities/Countries matching
                         */
                        if (products.get(0).getCityEn() != null) {
                            for (CityCodeBean city : cities) {
                                if (city.getOriginalName().equalsIgnoreCase(products.get(0).getCityEn())) {
                                    aProductTitleBean.setCityCode(city.getGeonameid());//todo remove this code when destinations id match is completed
                                    aProductTitleBean.setCityName(city.getOriginalName());
                                }
                                if (city.getViatorid() != null && city.getViatorid().equals(products.get(0).getDestinationId())) {
                                    aProductTitleBean.setCityCode(city.getGeonameid());
                                    aProductTitleBean.setCityName(city.getSanitizedName().toUpperCase());
                                    aProductTitleBean.setCountryCode(city.getCountryCodeIso());
                                    for (CountryCodeBean country : countries) {
                                        if (city.getCountryCodeIso().equals(country.getIsoCode()))
                                            aProductTitleBean.setCountryCode(country.getIsoCode());
                                    }
                                    break;
                                }
                            }
                        }

                        aProductTitleBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                        aProductTitleBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());

                        /**
                         * Matching Viator's categories with ATB categories
                         */
                        categories = ViatorProductXCategoryDAO.getProductCategoriesByProductCode(products.get(0).getCode());
                        if (categories != null && categories.size() > 0) {

                            /**
                             * Set "type of product" field at ATB DB.
                             */
                            for (ViatorCategoriesBean category : categories) {
                                if (category.getGroupname().equals("Shore Excursions")) {
                                    aProductTitleBean.setTypeOfProduct("4");
                                } else if (category.getGroupname().equals("Transfers & Ground Transport")) {
                                    aProductTitleBean.setTypeOfProduct("1");
                                } else if (category.getGroupname().equals("Shows, Concerts & Sports")) {
                                    aProductTitleBean.setTypeOfProduct("5");
                                } else if (category.getGroupname().equals("Multi-day & Extended Tours")) {
                                    aProductTitleBean.setTypeOfProduct("3");
                                    break;
                                } else {
                                    aProductTitleBean.setTypeOfProduct("2");
                                }
                            }

                            /**
                             * Do not store multiday tours for turkey
                             */
                            if(products.get(0).getCountryEn().toUpperCase().equals("TURKEY") && aProductTitleBean.getTypeOfProduct().equals("3"))
                                continue;

                            /**
                             * Add categories to  "categories_tag" field at ATB DB.
                             */
                            for (ViatorCategoriesBean category : categories) {
                                subCategories = ViatorProductXSubcategoryDAO.getProductSubcategoriesByProductCode(products.get(0).getCode(), category.getId());

                                if (category.getGroupname().equals("Air, Helicopter & Balloon Tours")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Balloon Rides"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Balloon Tours , ");
                                        }
                                    }
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Air and Helicopter Tours , ");
                                }
                                if (category.getGroupname().equals("Cruises, Sailing & Water Tours")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Gondola Cruises"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Gondola Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Dinner Cruises"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Dinner Tours , ");
                                        }
                                    }
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Cruises and Sailing Tours , ");
                                }
                                if (category.getGroupname().equals("Cultural & Theme Tours")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Historical & Heritage Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "History   Heritage   Culture , ");
                                            else if (subCategory.getSubcategoryName().equals("Movie & TV Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Movie and Tv Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Jewish Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Jewish Heritage Tours , ");
                                        }
                                    }
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Cultural and Theme Tours , ");
                                }
                                if (category.getGroupname().equals("Day Trips & Excursions"))
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Day Trips and Excursions , ");
                                if (category.getGroupname().equals("Food, Wine & Nightlife")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Dining Experiences"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Dinner Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Cooking Classes"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Cooking Class , ");
                                            else if (subCategory.getSubcategoryName().equals("Bar, Club & Pub Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Pub Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Wine Tasting & Winery Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Wine Tasting Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Dinner Theater"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Dinner Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Food Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Food Tasting Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Beer & Brewery Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Beer Tasting , ");
                                        }
                                    }
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Food Wine Nightlife , ");
                                }
                                if (category.getGroupname().equals("Holiday & Seasonal Tours")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Christmas"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Christmas Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("New Years "))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "New Year`s Eve , ");
                                            else if (subCategory.getSubcategoryName().equals("Valentine's Day"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Valentine`s Day Programs , ");
                                        }
                                    }
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Holiday & Seasonal Tours , ");
                                }
                                if (category.getGroupname().equals("Sightseeing Tickets & Passes")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Sightseeing & City Passes"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "City Sightseeing Tours , ");
                                        }
                                    }
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Sightseeing Tours , ");
                                }
                                if (category.getGroupname().equals("Outdoor Activities")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Fishing Charters & Tours")) {
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Fishing Tours , ");
                                            } else if (subCategory.getSubcategoryName().equals("Hiking & Camping")) {
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Hiking Tours , ");
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Camping Tours , ");
                                            } else if (subCategory.getSubcategoryName().equals("Nature & Wildlife")) {
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Nature Discovery Tours , ");
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Wildlife Park , ");
                                            } else if (subCategory.getSubcategoryName().equals("Safaris")) {
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Desert Safari Tours , ");
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Safari Tours , ");
                                            } else if (subCategory.getSubcategoryName().equals("Ski & Snow")) {
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Ski Packages , ");
                                            } else if (subCategory.getSubcategoryName().equals("Ski & Snowboard Rentals")) {
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Ski Packages , ");
                                            }
                                        }
                                    }
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Outdoor Activities , ");
                                }
                                if (category.getGroupname().equals("Shopping & Fashion"))
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Shopping Tours , ");
                                if (category.getGroupname().equals("Shows, Concerts & Sports")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Family-friendly Shows "))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Family Friendly , ");
                                            else if (subCategory.getSubcategoryName().equals("Cirque du Soleil"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Cirque du Soleil , ");
                                            else if (subCategory.getSubcategoryName().equals("Light & Sound Shows"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Sound and Light Show , ");
                                        }
                                    }
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Shows Concerts Sports , ");
                                }
                                if (category.getGroupname().equals("Tours & Sightseeing")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Segway Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Segway Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Private Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Private Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Full-day Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Full Day Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Half-day Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Half Day Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Night Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Night Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Hop-on Hop-off Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Hop On Hop Off Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("City Packages"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "City Break Packages , ");
                                            else if (subCategory.getSubcategoryName().equals("Vespa, Scooter & Moped Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Vespa Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Super Savers"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Super Saver Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Skip-the-Line Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Skip the Line Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("City Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "City Viewing , ");
                                            else if (subCategory.getSubcategoryName().equals("Photography Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Photo Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Bike Rentals"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Bike and Pedicab Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Vespa Rentals"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Vespa Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Layover Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "City Stopovers , ");
                                            else if (subCategory.getSubcategoryName().equals("Pedicab Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Bike and Pedicab Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Trikke Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Bike and Pedicab Tours , ");
                                        }
                                    }
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Sightseeing Tours , ");
                                }
                                if (category.getGroupname().equals("Theme Parks")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Disney® Parks "))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Disney Theme Parks , ");
                                        }
                                    }
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Theme Parks , ");
                                }
                                if (category.getGroupname().equals("Transfers & Ground Transport")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Private Transfers"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Private Transfers , ");
                                        }
                                    }
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Transfers & Ground Transport , ");
                                }
                                if (category.getGroupname().equals("Walking & Biking Tours")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Bike & Mountain Bike Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Bike and Pedicab Tours , ");
                                            else if (subCategory.getSubcategoryName().equals("Walking Tours"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Walking Tours , ");
                                        }
                                    }
                                }
                                if (category.getGroupname().equals("Water Sports"))
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Water Sports , ");
                                if (category.getGroupname().equals("Weddings & Honeymoons")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Wedding Packages"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Wedding Packages , ");
                                            else if (subCategory.getSubcategoryName().equals("Honeymoon Packages"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Honeymoon Packages , ");
                                        }
                                    }

                                }
                                if (category.getGroupname().equals("Multi-day & Extended Tours")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Multi-day Cruises"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Cruises and Sailing Tours , ");
                                        }
                                    }
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Multiday Tours , ");
                                }
                                if (category.getGroupname().equals("Kid Friendly"))
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Kid Friendly Tours & Activities , ");
                                if (category.getGroupname().equals("Shore Excursions")) {
                                    if (subCategories != null && subCategories.size() > 0) {
                                        for (ViatorSubcategoriesBean subCategory : subCategories) {
                                            if (subCategory.getSubcategoryName().equals("Port Transfers"))
                                                aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Cruise Port Transfers , ");
                                        }
                                    }
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Shore Excursion , ");
                                }
                                if (category.getGroupname().equals("Luxury & Special Occasions"))
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Luxury & Special Occasions , ");
                                if (category.getGroupname().equals("Private & Custom Tours"))
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Private   Custom Tours , ");
                                if (category.getGroupname().equals("Viator VIP & Exclusive Tours"))
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "VIP & Exclusive Tours , ");
                                if (category.getGroupname().equals("Spa Tours"))
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Spa and Wellness , ");
                                if (category.getGroupname().equals("Classes & Workshops"))
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Workshops and Art Classes , ");
                                if (category.getGroupname().equals("Skip-the-Line Tours"))
                                    aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag() + "Skip the Line Tours , ");
                            }
                        }

                        /**
                         * Remove " , " at the end of categories_tag field
                         */
                        if (aProductTitleBean.getCategoriesTag().length() > 1)
                            aProductTitleBean.setCategoriesTag(aProductTitleBean.getCategoriesTag().substring(0, aProductTitleBean.getCategoriesTag().length() - 3));

                        /**
                         * Add product to ATB DB.Record database communication errors to add them to update info table.
                         */
                        updatedProduct = AProductTitleDAO.getProductByCode(aProductTitleBean.getProductCode(), "Viator");
                        if (updatedProduct != null) {
                            updatedProductsIds.add(String.valueOf(updatedProduct.getId()));
                            aProductTitleBean.setId(updatedProduct.getId());
                            if (AProductTitleDAO.updateproduct(aProductTitleBean)) {
                                failedProductCodeExist = false;
                                for (String failedProductCode : failedProductCodes) {
                                    if (failedProductCode.equals(code))
                                        failedProductCodeExist = true;
                                }
                                if (!failedProductCodeExist)
                                    failedProductCodes.add(code);
                                dbCommErrors++;
                            } else {
                                totalproducts++;
                                logger.info("Total  products added: " + totalproducts + "Product with code: " + aProductTitleBean.getProductCode() + " updated.");
                            }
                        } else {
                            aProductTitleBean.setId(0);
                            if (AProductTitleDAO.addproduct(aProductTitleBean) == 0) {
                                failedProductCodeExist = false;
                                for (String failedProductCode : failedProductCodes) {
                                    if (failedProductCode.equals(code))
                                        failedProductCodeExist = true;
                                }
                                if (!failedProductCodeExist)
                                    failedProductCodes.add(code);
                                dbCommErrors++;
                            } else {
                                totalproducts++;
                                logger.info("Total  products added: " + totalproducts + "Product with code: " + aProductTitleBean.getProductCode() + " added.");
                            }
                        }

                        productTitleRecord = AProductTitleDAO.getProductByCode(code, "Viator");//todo see if i can take the id when i add to the table the new record
                        if (productTitleRecord == null) {
                            failedProductCodeExist = false;
                            for (String failedProductCode : failedProductCodes) {
                                if (failedProductCode.equals(code))
                                    failedProductCodeExist = true;
                            }
                            if (!failedProductCodeExist)
                                failedProductCodes.add(code);
                            dbCommErrors++;
                            continue;
                        }


                        /**
                         * Store  other product details to ATB DB b_product_detail table.
                         */
                        bProductDetailBean = new BProductDetailBean();
                        bProductDetailBean.setMobileAccess("");
                        bProductDetailBean.setVoucherTelephone("");
                        bProductDetailBean.setVoucherCountryCode("");
                        bProductDetailBean.setAdittionalInfo("");
                        bProductDetailBean.setExclusions("");
                        bProductDetailBean.setInclusions("");
                        bProductDetailBean.setHighlight("");
                        bProductDetailBean.setVoucherInfo("");
                        bProductDetailBean.setDescriptionSummary("");
                        bProductDetailBean.setProductDetail("");
                        bProductDetailBean.setCategories("");
                        bProductDetailBean.setVoucherInfo(products.get(0).getVoucherRequirementsEn());
                        bProductDetailBean.setDescriptionSummary(products.get(0).getShortDescriptionEn());
                        bProductDetailBean.setProductDetail(products.get(0).getDescriptionEn());
                        bProductDetailBean.setProductId(String.valueOf(productTitleRecord.getId()));
                        bProductDetailBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                        bProductDetailBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());

                        info = "";
                        additionalInfos = ViatorProductAdditionalInfoDAO.getAdditionalInfoByProductCode(products.get(0).getCode());
                        if (additionalInfos != null) {
                            for (ViatorProductAdditionalInfoBean additionalInfo : additionalInfos) {
                                info = info + additionalInfo.getAdditionalInfo() + ". ";
                            }
                            bProductDetailBean.setAdittionalInfo(info);
                        }
                        info = "";
                        exclusions = ViatorProductExclusionsDAO.getExclusionsByProductCode(products.get(0).getCode());
                        if (exclusions != null) {
                            for (ViatorProductExclusionsBean exclusion : exclusions) {
                                info = info + "\n" + exclusion.getExclusion();
                            }
                            bProductDetailBean.setExclusions(info);
                        }
                        info = "";
                        inclusions = ViatorProductInclusionsDAO.getInclusionsByProductCode(products.get(0).getCode());
                        if (inclusions != null) {
                            for (ViatorProductInclusionsBean inclusion : inclusions) {
                                info = info + "\n" + inclusion.getInclusion();
                            }
                            bProductDetailBean.setInclusions(info);
                        }
                        if (products.get(0).getHighlightsEn() != null)
                            bProductDetailBean.setHighlight(products.get(0).getHighlightsEn());
                        if (products.get(0).getMerchantCancellable()) {
                            bProductDetailBean.setMerchantCancellable("48");
                            bProductDetailBean.setCancellationPolicy("Fully refundable up to 48 hours");
                        } else {
                            bProductDetailBean.setMerchantCancellable("non-refundable");
                            bProductDetailBean.setCancellationPolicy("Fully non-refundable at time of booking");
                        }

                        bProductDetails.add(bProductDetailBean);


                        /**
                         * Store  photos of product to ATB DB d_Product_Photo table.
                         */
                        dProductPhotoBean = new DProductPhotoBean();
                        photoURL = products.get(0).getThumbnailHiResUrl().split(ProjectProperties.photoUrlSplitKey);
                        dProductPhotoBean.setSupplierId("");
                        dProductPhotoBean.setMainPhoto("");
                        dProductPhotoBean.setCaption("");
                        dProductPhotoBean.setVt("2");
                        dProductPhotoBean.setSubId("");
                        dProductPhotoBean.setPhotoName("");
                        dProductPhotoBean.setAtb("");
                        dProductPhotoBean.setSupplierId(ProjectProperties.photoSupplierId);
                        if (photoURL.length > 1) {
                            dProductPhotoBean.setPhotoName(photoURL[1]);
                            dProductPhotoBean.setProductId(String.valueOf(productTitleRecord.getId()));
                            dProductPhotoBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                            dProductPhotoBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());

                            dProductPhotos.add(dProductPhotoBean);
                        }
                        photos = ViatorProductPhotosDAO.getPhotosByProductCode(products.get(0).getCode());
                        if (photos != null && photos.size() > 0) {

                            for (ViatorProductPhotosBean photo : photos) {

                                dProductPhotoBean = new DProductPhotoBean();
                                photoURL = photo.getPhotoUrl().split(ProjectProperties.photoUrlSplitKey);
                                dProductPhotoBean.setSupplierId("");
                                dProductPhotoBean.setMainPhoto("");
                                dProductPhotoBean.setCaption("");
                                dProductPhotoBean.setVt("2");
                                dProductPhotoBean.setSubId("");
                                dProductPhotoBean.setPhotoName("");
                                dProductPhotoBean.setAtb("");
                                if (photoURL.length > 1) {
                                    dProductPhotoBean.setPhotoName(ProjectProperties.photoSizeUrl + photoURL[1]);
                                    dProductPhotoBean.setProductId(String.valueOf(productTitleRecord.getId()));
                                    dProductPhotoBean.setSupplierId(ProjectProperties.photoSupplierId);
                                    dProductPhotoBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                                    dProductPhotoBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());

                                    dProductPhotos.add(dProductPhotoBean);
                                }
                            }
                        }

                        /**
                         * Store  bookingQuestions of product to ATB DB j_product_questions table.
                         */
                        bookingQuestions = ViatorProductBookingQuestionsDAO.getBookingQuestionsByProductCode(code);
                        if (bookingQuestions != null && bookingQuestions.size() > 0) {

                            for (ViatorProductBookingQuestionsBean bookingQuestion : bookingQuestions) {
                                jProductQuestionsBean = new JProductQuestionsBean();
                                jProductQuestionsBean.setMessage(bookingQuestion.getMessage());
                                jProductQuestionsBean.setProductCode(bookingQuestion.getProductCode());
                                jProductQuestionsBean.setProductId(String.valueOf(productTitleRecord.getId()));
                                jProductQuestionsBean.setQuestionId(bookingQuestion.getQuestionId());
                                jProductQuestionsBean.setRequired(bookingQuestion.getRequired());
                                jProductQuestionsBean.setSortOrder(bookingQuestion.getSortOrder());
                                jProductQuestionsBean.setStringQuestionId(bookingQuestion.getStringQuestionId());
                                jProductQuestionsBean.setSubTitleEn(bookingQuestion.getSubTitleEn());
                                jProductQuestionsBean.setTitleEn(bookingQuestion.getTitleEn());
                                jProductQuestionsBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                        dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                        dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));

                                jProductQuestions.add(jProductQuestionsBean);
                            }
                        }

                        /**
                         * Store  pickupHotels of product to ATB DB e_Pickup_Point table.
                         */

                        if(products.get(0).getDeparturePoint()!=null && !products.get(0).getDeparturePoint().equals("")) {
                            ePickupPointBean = new EPickupPointBean();
                            ePickupPointBean.setPickupType("Meeting Point");
                            ePickupPointBean.setMapZoom("");
                            ePickupPointBean.setPrecisionType("");
                            ePickupPointBean.setPickupNote("");
                            ePickupPointBean.setHotelPickupPoint("");
                            ePickupPointBean.setLatitude("");
                            ePickupPointBean.setLongitude("");
                            ePickupPointBean.setHotelId("");
                            ePickupPointBean.setLatitude("");
                            ePickupPointBean.setLongitude("");
                            ePickupPointBean.setMeetingPoint(products.get(0).getDeparturePoint());
                            ePickupPointBean.setDropOfEndPoint(products.get(0).getDeparturePoint());
                            ePickupPointBean.setStartingPoint(products.get(0).getDeparturePoint());
                            ePickupPointBean.setProductId(String.valueOf(productTitleRecord.getId()));
                            ePickupPointBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                            ePickupPointBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                            ePickupPoints.add(ePickupPointBean);
                        }

                        pickupHotels = ViatorPickupHotelsDAO.getPickupHotelsByProductCode(products.get(0).getCode());
                        if (pickupHotels != null && pickupHotels.size() > 0) {
                            for (ViatorPickupHotelsBean pickupHotel : pickupHotels) {
                                ePickupPointBean = new EPickupPointBean();
                                ePickupPointBean.setPickupType("Hotel");
                                ePickupPointBean.setMeetingPoint("");
                                ePickupPointBean.setMapZoom("13");
                                ePickupPointBean.setDropOfEndPoint("");
                                ePickupPointBean.setPrecisionType("");
                                ePickupPointBean.setPickupNote("");
                                ePickupPointBean.setHotelPickupPoint("");
                                ePickupPointBean.setLatitude("");
                                ePickupPointBean.setLongitude("");
                                ePickupPointBean.setStartingPoint("");
                                ePickupPointBean.setHotelId("");
                                ePickupPointBean.setProductId(String.valueOf(productTitleRecord.getId()));
                                ePickupPointBean.setHotelPickupPoint(pickupHotel.getHotelName());
                                ePickupPointBean.setLatitude(String.valueOf(pickupHotel.getLatitude()));
                                ePickupPointBean.setLongitude(String.valueOf(pickupHotel.getLongitude()));
                                ePickupPointBean.setStartingPoint(pickupHotel.getAddress() + ", " + pickupHotel.getCityName() + ", " + products.get(0).getCountryEn());
                                ePickupPointBean.setHotelId(pickupHotel.getHotelId());
                                if (pickupHotel.getNotes() != null)
                                    ePickupPointBean.setPickupNote(pickupHotel.getNotes());
                                ePickupPointBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                        dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                        dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                                ePickupPointBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                        dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                        dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());

                                ePickupPoints.add(ePickupPointBean);

                            }
                        }

                        /**
                         * Store  Viator TourGradeLanguageServices of product to ATB DB c_product_options table.
                         */
                        cProductOptionsBean = new CProductOptionsBean();
                        cProductOptionsBean.setGuidingAudio("");
                        cProductOptionsBean.setGuidingBooklets("");
                        cProductOptionsBean.setGuidingLive("");
                        cProductOptionsBean.setTypeOfPricing("");
                        cProductOptionsBean.setPrivateOption("");
                        cProductOptionsBean.setValidy("");
                        cProductOptionsBean.setMinConfirmationTime("");
                        cProductOptionsBean.setCustomerDetailRequest("");
                        cProductOptionsBean.setDuration("");
                        cProductOptionsBean.setAvailabilityTime("Starting Times");
                        cProductOptionsBean.setProductId(String.valueOf(productTitleRecord.getId()));
                        cProductOptionsBean.setDuration(products.get(0).getDuration());
                        cProductOptionsBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                        cProductOptionsBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                        tourGradeLanguageServices = ViatorProductTourGradeLanguageServicesDAO.getLanguageServicesByProductCode(products.get(0).getCode());
                        if (tourGradeLanguageServices != null) {
                            for (ViatorProductTourGradeLanguageServicesBean tourGradeLanguageService : tourGradeLanguageServices) {
                                splitLanguageServiceDescription = tourGradeLanguageService.getLanguageServiceDescription().split(" ");

                                for (AllLanguageBean language : allLanguages) {
                                    if (splitLanguageServiceDescription != null && splitLanguageServiceDescription.length > 0 && splitLanguageServiceDescription[0].equals(language.getLanguage())) {
                                        splitLanguageCodeAndService = tourGradeLanguageService.getLanguageCodeAndService().split("/");
                                        if (splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && splitLanguageCodeAndService[1].equals("SERVICE_AUDIO")) {
                                            langAlreadyExist = false;
                                            for (String lang : productOptionlanguages) {
                                                if (splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && lang.equals(language.getLanguageCode() + "SERVICE_AUDIO"))
                                                    langAlreadyExist = true;
                                            }
                                            if (!langAlreadyExist) {
                                                cProductOptionsBean.setGuidingAudio(cProductOptionsBean.getGuidingAudio() + language.getLanguageCode() + ", ");
                                                productOptionlanguages.add(language.getLanguageCode() + "SERVICE_AUDIO");
                                            }
                                        } else if (splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && splitLanguageCodeAndService[1].equals("SERVICE_GUIDE")) {
                                            langAlreadyExist = false;
                                            for (String lang : productOptionlanguages) {
                                                if (splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && lang.equals(language.getLanguageCode() + "SERVICE_GUIDE"))
                                                    langAlreadyExist = true;
                                            }
                                            if (!langAlreadyExist) {
                                                cProductOptionsBean.setGuidingLive(cProductOptionsBean.getGuidingLive() + language.getLanguageCode() + ", ");
                                                productOptionlanguages.add(language.getLanguageCode() + "SERVICE_GUIDE");
                                            }
                                        } else if (splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && splitLanguageCodeAndService[1].equals("SERVICE_WRITTEN")) {
                                            langAlreadyExist = false;
                                            for (String lang : productOptionlanguages) {
                                                if (splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && lang.equals(language.getLanguageCode() + "SERVICE_WRITTEN"))
                                                    langAlreadyExist = true;
                                            }
                                            if (!langAlreadyExist) {
                                                cProductOptionsBean.setGuidingBooklets(cProductOptionsBean.getGuidingBooklets() + language.getLanguageCode() + ", ");
                                                productOptionlanguages.add(language.getLanguageCode() + "SERVICE_WRITTEN");
                                            }
                                        } else {
                                            langAlreadyExist = false;
                                            for (String lang : productOptionlanguages) {
                                                if (splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && lang.equals(language.getLanguageCode() + "SERVICE_GUIDE"))
                                                    langAlreadyExist = true;
                                            }
                                            if (!langAlreadyExist) {
                                                cProductOptionsBean.setGuidingLive(cProductOptionsBean.getGuidingLive() + language.getLanguageCode() + ", ");
                                                productOptionlanguages.add(language.getLanguageCode() + "SERVICE_GUIDE");
                                            }
                                            langAlreadyExist = false;
                                            for (String lang : productOptionlanguages) {
                                                if (splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && lang.equals(language.getLanguageCode() + "SERVICE_WRITTEN"))
                                                    langAlreadyExist = true;
                                            }
                                            if (!langAlreadyExist) {
                                                cProductOptionsBean.setGuidingBooklets(cProductOptionsBean.getGuidingBooklets() + language.getLanguageCode() + ", ");
                                                productOptionlanguages.add(language.getLanguageCode() + "SERVICE_WRITTEN");
                                            }
                                            langAlreadyExist = false;
                                            for (String lang : productOptionlanguages) {
                                                if (splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && lang.equals(language.getLanguageCode() + "SERVICE_AUDIO"))
                                                    langAlreadyExist = true;
                                            }
                                            if (!langAlreadyExist) {
                                                cProductOptionsBean.setGuidingAudio(cProductOptionsBean.getGuidingAudio() + language.getLanguageCode() + ", ");
                                                productOptionlanguages.add(language.getLanguageCode() + "SERVICE_AUDIO");
                                            }
                                        }
                                        break;

                                    }
                                }
                            }
                            productOptionlanguages.clear();
                            /**
                             * Remove ", " at the end of guiding_live/guidin_booklets/guiding_audio fields.
                             */
                            if (cProductOptionsBean.getGuidingLive().length() > 1)
                                cProductOptionsBean.setGuidingLive(cProductOptionsBean.getGuidingLive().substring(0, cProductOptionsBean.getGuidingLive().length() - 2));
                            if (cProductOptionsBean.getGuidingBooklets().length() > 1)
                                cProductOptionsBean.setGuidingBooklets(cProductOptionsBean.getGuidingBooklets().substring(0, cProductOptionsBean.getGuidingBooklets().length() - 2));
                            if (cProductOptionsBean.getGuidingAudio().length() > 1)
                                cProductOptionsBean.setGuidingAudio(cProductOptionsBean.getGuidingAudio().substring(0, cProductOptionsBean.getGuidingAudio().length() - 2));
                        }
                        cProductOptions.add(cProductOptionsBean);


                        /**
                         * Store  pricematrix of product to ATB DB e_Pickup_Point table.
                         */
                        pricingMatrixes = ViatorPricingMatrixDAO.getPricingMatrixByProductCode(products.get(0).getCode());
                        if (pricingMatrixes != null && pricingMatrixes.size() > 0) {
                            if (updatedProduct != null) {

                                if (IAvailableTimeDAO.deleteavailableTime(String.valueOf(updatedProduct.getId()))) {
                                    failedProductCodeExist = false;
                                    for (String failedProductCode : failedProductCodes) {
                                        if (failedProductCode.equals(String.valueOf(updatedProduct.getId())))
                                            failedProductCodeExist = true;
                                    }
                                    if (!failedProductCodeExist)
                                        failedProductCodes.add(String.valueOf(updatedProduct.getId()));
                                    dbCommErrors++;
                                }
                                if (HStopsaleDateDAO.deleteStopsaleDate(String.valueOf(updatedProduct.getId()))) {
                                    failedProductCodeExist = false;
                                    for (String failedProductCode : failedProductCodes) {
                                        if (failedProductCode.equals(String.valueOf(updatedProduct.getId())))
                                            failedProductCodeExist = true;
                                    }
                                    if (!failedProductCodeExist)
                                        failedProductCodes.add(String.valueOf(updatedProduct.getId()));
                                    dbCommErrors++;
                                }
                            }
                            //firstPriceMatrix=true;

                            productTourGradeCodes.clear();
                            tourGradeWithAgeBandcodes.clear();
                            for (ViatorPricingMatrixBean pricingMatrix : pricingMatrixes) {

                                /**
                                 * Store tourgrades at priceplan table without dublications.
                                 */
                                tourgradeExists = false;
                                for (String tgcode : productTourGradeCodes) {
                                    if (tgcode.equals(pricingMatrix.getTourGradeCode()))
                                        tourgradeExists = true;
                                }
                                tourGradeWithAgeBandExists = false;
                                for (String tgcodewageband : tourGradeWithAgeBandcodes) {
                                    if (tgcodewageband.equals(pricingMatrix.getTourGradeCode() + pricingMatrix.getBandId()))
                                        tourGradeWithAgeBandExists = true;
                                }
                                if (!tourgradeExists || tourGradeWithAgeBandExists) {
                                    productTourGradeCodes.add(pricingMatrix.getTourGradeCode());
                                    tourGradeWithAgeBandcodes.add(pricingMatrix.getTourGradeCode() + pricingMatrix.getBandId());
                                    fPricePlanBean.setTourGradeCode("");
                                    fPricePlanBean.setRateType("net");
                                    fPricePlanBean.setSubId("");
                                    fPricePlanBean.setPlanTitle("");
                                    fPricePlanBean.setPriceType("");
                                    fPricePlanBean.setMinParticipants("");
                                    iAvailableTimeBean.setStartTime("");
                                    if (pricingMatrix.getMinimumCountRequired() == 0)
                                        fPricePlanBean.setMinParticipants("1");
                                    else
                                        fPricePlanBean.setMinParticipants(String.valueOf(pricingMatrix.getMinimumCountRequired()));

                                    fPricePlanBean.setProductId(String.valueOf(productTitleRecord.getId()));
                                    fPricePlanBean.setTourGradeCode(pricingMatrix.getTourGradeCode());
                                    if (pricingMatrix.getPricingUnit() != null && !pricingMatrix.getPricingUnit().equals("")) {
                                        if (!pricingMatrix.getPricingUnit().equals("per person"))
                                            fPricePlanBean.setPriceType("Price per group");
                                        else
                                            fPricePlanBean.setPriceType("Price per person");
                                    }
                                    tourGrades = ViatorProductTourGradesDAO.getTourGradesByProductCode(pricingMatrix.getProductCode());
                                    if (tourGrades != null) {
                                        for (ViatorProductTourGradesBean tourGrade : tourGrades) {
                                            if (tourGrade.getGradeCode().equals(pricingMatrix.getTourGradeCode())) {
                                                if (tourGrade.getGradeTitle().equals("") || tourGrade.getGradeTitle() == null)
                                                    fPricePlanBean.setPlanTitle(products.get(0).getShortTitleEn() + ". " + tourGrade.getGradeDescription());
                                                else
                                                    fPricePlanBean.setPlanTitle(tourGrade.getGradeTitle() + ". " + tourGrade.getGradeDescription());
                                                iAvailableTimeBean.setStartTime(tourGrade.getGradeDepartureTime());
                                                break;
                                            }
                                        }
                                    }
                                    fPricePlanBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                                    fPricePlanBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());

                                    /**
                                     * Add product's pricePlan.
                                     */
                                    pricePlanlastRecord=FPricePlanDAO.saveOrUpdatePriceplanViatorProductsOnly(fPricePlanBean);
                                    if (pricePlanlastRecord == null) {
                                        failedProductCodeExist = false;
                                        for (String failedProductCode : failedProductCodes) {
                                            if (failedProductCode.equals(fPricePlanBean.getProductId()))
                                                failedProductCodeExist = true;
                                        }
                                        if (!failedProductCodeExist)
                                            failedProductCodes.add(fPricePlanBean.getProductId());
                                        dbCommErrors++;
                                    }else  {

                                        //  if (firstPriceMatrix) {//todo determine if we store dates at product code level and not at plan level.check if i can leave blank the available_id
                                        //firstPriceMatrix=false;

                                        noneAvailableDates = ViatorNoneAvailableDatesDAO.getNoneAvailDatesOfProducts(products);
                                        if (noneAvailableDates != null && noneAvailableDates.size() > 0) {

                                            hAvailableDateBean = new HAvailableDateBean();
                                            hAvailableDateBean.setAvailableTimeType("");
                                            hAvailableDateBean.setAvailableTitle("");
                                            hAvailableDateBean.setDepartimeOnOff("");
                                            hAvailableDateBean.setPlanId("");
                                            hAvailableDateBean.setAvailableTitle(pricePlanlastRecord.getPlanTitle());
                                            hAvailableDateBean.setPlanId(String.valueOf(pricePlanlastRecord.getId()));
                                            hAvailableDateBean.setProductId(String.valueOf(productTitleRecord.getId()));
                                            hAvailableDateBean.setStartDate(Timestamp.valueOf(String.format("%04d-%02d-%02d 13:00:00",
                                                    noneAvailableDates.get(0).getYear(), noneAvailableDates.get(0).getMonth(), 1)));
                                            calendar.set(noneAvailableDates.get(noneAvailableDates.size() - 1).getYear(), noneAvailableDates.get(noneAvailableDates.size() - 1).getMonth() - 1, 1);//todo check the -1 at month
                                            lastDate = calendar.getActualMaximum(Calendar.DATE);
                                            hAvailableDateBean.setEndDate(Timestamp.valueOf(String.format("%04d-%02d-%02d 13:00:00",
                                                    noneAvailableDates.get(noneAvailableDates.size() - 1).getYear(), noneAvailableDates.get(noneAvailableDates.size() - 1).getMonth(), lastDate)));
                                            hAvailableDateBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));//todo check the month
                                            hAvailableDateBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));

                                            if (updatedProduct != null) {
                                                if (HAvailableDateDAO.deleteAvailableDateWithPlanId(String.valueOf(updatedProduct.getId()),hAvailableDateBean.getPlanId())) {
                                                    failedProductCodeExist = false;
                                                    for (String failedProductCode : failedProductCodes) {
                                                        if (failedProductCode.equals(hAvailableDateBean.getProductId()))
                                                            failedProductCodeExist = true;
                                                    }
                                                    if (!failedProductCodeExist)
                                                        failedProductCodes.add(hAvailableDateBean.getProductId());
                                                    dbCommErrors++;
                                                }
                                            }
                                            if (HAvailableDateDAO.addAvailableDate(hAvailableDateBean) == 0) {
                                                failedProductCodeExist = false;
                                                for (String failedProductCode : failedProductCodes) {
                                                    if (failedProductCode.equals(hAvailableDateBean.getProductId()))
                                                        failedProductCodeExist = true;
                                                }
                                                if (!failedProductCodeExist)
                                                    failedProductCodes.add(hAvailableDateBean.getProductId());
                                                dbCommErrors++;
                                            }
                                            lastAvailableDateRecord = HAvailableDateDAO.getLastRecord();//todo get id from the save operation instantly

                                            if (lastAvailableDateRecord != null) {
                                                if (noneAvailableDates != null && noneAvailableDates.size() > 0) {
                                                    for (ViatorNoneAvailableDatesBean noneAvailableDate : noneAvailableDates) {

                                                        if (noneAvailableDate.getDay() != 0) {
                                                            hStopsaleDateBean = new HStopsaleDateBean();
                                                            hStopsaleDateBean.setAvailableId("");
                                                            hStopsaleDateBean.setPlanId("");
                                                            hStopsaleDateBean.setAvailableId(String.valueOf(lastAvailableDateRecord.getId()));
                                                            hStopsaleDateBean.setPlanId(String.valueOf(pricePlanlastRecord.getId()));
                                                            hStopsaleDateBean.setProductId(String.valueOf(productTitleRecord.getId()));
                                                            hStopsaleDateBean.setStopDate(Timestamp.valueOf(String.format("%04d-%02d-%02d 13:00:00",
                                                                    noneAvailableDate.getYear(), noneAvailableDate.getMonth(), noneAvailableDate.getDay())));
                                                            hStopsaleDateBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));
                                                            hStopsaleDateBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));

                                                            if (HStopsaleDateDAO.addStopsaleDate(hStopsaleDateBean)) {
                                                                failedProductCodeExist = false;
                                                                for (String failedProductCode : failedProductCodes) {
                                                                    if (failedProductCode.equals(hStopsaleDateBean.getProductId()))
                                                                        failedProductCodeExist = true;
                                                                }
                                                                if (!failedProductCodeExist)
                                                                    failedProductCodes.add(hStopsaleDateBean.getProductId());
                                                                dbCommErrors++;
                                                            }
                                                        }
                                                    }
                                                }
                                                //  }


                                                iAvailableTimeBean.setProductId(String.valueOf(productTitleRecord.getId()));
                                                iAvailableTimeBean.setPlanId(String.valueOf(pricePlanlastRecord.getId()));
                                                iAvailableTimeBean.setEndTime(":");
                                                iAvailableTimeBean.setAvailableId(String.valueOf(lastAvailableDateRecord.getId()));
                                                iAvailableTimeBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                        dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                        dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));
                                                iAvailableTimeBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                        dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                        dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));

                                                if (iAvailableTimeBean.getStartTime() != null && !iAvailableTimeBean.getStartTime().equals("")) {
                                                    iAvailableTimeBean.setWeekDay("Monday");
                                                    if (IAvailableTimeDAO.addAvailableTime(iAvailableTimeBean)) {
                                                        failedProductCodeExist = false;
                                                        for (String failedProductCode : failedProductCodes) {
                                                            if (failedProductCode.equals(iAvailableTimeBean.getProductId()))
                                                                failedProductCodeExist = true;
                                                        }
                                                        if (!failedProductCodeExist)
                                                            failedProductCodes.add(iAvailableTimeBean.getProductId());
                                                        dbCommErrors++;
                                                    }
                                                    iAvailableTimeBean.setWeekDay("Tuesday");
                                                    if (IAvailableTimeDAO.addAvailableTime(iAvailableTimeBean)) {
                                                        failedProductCodeExist = false;
                                                        for (String failedProductCode : failedProductCodes) {
                                                            if (failedProductCode.equals(iAvailableTimeBean.getProductId()))
                                                                failedProductCodeExist = true;
                                                        }
                                                        if (!failedProductCodeExist)
                                                            failedProductCodes.add(iAvailableTimeBean.getProductId());
                                                        dbCommErrors++;
                                                    }
                                                    iAvailableTimeBean.setWeekDay("Wednesday");
                                                    if (IAvailableTimeDAO.addAvailableTime(iAvailableTimeBean)) {
                                                        failedProductCodeExist = false;
                                                        for (String failedProductCode : failedProductCodes) {
                                                            if (failedProductCode.equals(iAvailableTimeBean.getProductId()))
                                                                failedProductCodeExist = true;
                                                        }
                                                        if (!failedProductCodeExist)
                                                            failedProductCodes.add(iAvailableTimeBean.getProductId());
                                                        dbCommErrors++;
                                                    }
                                                    iAvailableTimeBean.setWeekDay("Thursday");
                                                    if (IAvailableTimeDAO.addAvailableTime(iAvailableTimeBean)) {
                                                        failedProductCodeExist = false;
                                                        for (String failedProductCode : failedProductCodes) {
                                                            if (failedProductCode.equals(iAvailableTimeBean.getProductId()))
                                                                failedProductCodeExist = true;
                                                        }
                                                        if (!failedProductCodeExist)
                                                            failedProductCodes.add(iAvailableTimeBean.getProductId());
                                                        dbCommErrors++;
                                                    }
                                                    iAvailableTimeBean.setWeekDay("Friday");
                                                    if (IAvailableTimeDAO.addAvailableTime(iAvailableTimeBean)) {
                                                        failedProductCodeExist = false;
                                                        for (String failedProductCode : failedProductCodes) {
                                                            if (failedProductCode.equals(iAvailableTimeBean.getProductId()))
                                                                failedProductCodeExist = true;
                                                        }
                                                        if (!failedProductCodeExist)
                                                            failedProductCodes.add(iAvailableTimeBean.getProductId());
                                                        dbCommErrors++;
                                                    }
                                                    iAvailableTimeBean.setWeekDay("Saturday");
                                                    if (IAvailableTimeDAO.addAvailableTime(iAvailableTimeBean)) {
                                                        failedProductCodeExist = false;
                                                        for (String failedProductCode : failedProductCodes) {
                                                            if (failedProductCode.equals(iAvailableTimeBean.getProductId()))
                                                                failedProductCodeExist = true;
                                                        }
                                                        if (!failedProductCodeExist)
                                                            failedProductCodes.add(iAvailableTimeBean.getProductId());
                                                        dbCommErrors++;
                                                    }
                                                    iAvailableTimeBean.setWeekDay("Sunday");
                                                    if (IAvailableTimeDAO.addAvailableTime(iAvailableTimeBean)) {
                                                        failedProductCodeExist = false;
                                                        for (String failedProductCode : failedProductCodes) {
                                                            if (failedProductCode.equals(iAvailableTimeBean.getProductId()))
                                                                failedProductCodeExist = true;
                                                        }
                                                        if (!failedProductCodeExist)
                                                            failedProductCodes.add(iAvailableTimeBean.getProductId());
                                                        dbCommErrors++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }


                                if (pricePlanlastRecord != null) {
                                    gPriceMatrixBean = new GPriceMatrixBean();
                                    if (pricingMatrix.getMinNoOfTravellersRequiredForPrice() == 1) {//todo check if it s ok like this.Maybe I can remove this becouse I keep only one now at the viator update with the "avoid AgeBand duplications with same minmum/maximum count requirments."

                                        gPriceMatrixBean.setPriceRate("");
                                        gPriceMatrixBean.setCommission("");
                                        gPriceMatrixBean.setOptionTitle("");
                                        gPriceMatrixBean.setPriceNet("");
                                        gPriceMatrixBean.setPersonType("");
                                        gPriceMatrixBean.setMinCountRequired(0);
                                        gPriceMatrixBean.setCurrencyCode("");
                                        gPriceMatrixBean.setAgeFrom("");
                                        gPriceMatrixBean.setAgeTo("");
                                        gPriceMatrixBean.setPlanId(String.valueOf(pricePlanlastRecord.getId()));
                                        gPriceMatrixBean.setProductId(String.valueOf(productTitleRecord.getId()));
                                        ageBands = ViatorProductAgeBandsDAO.getAgeBandsByProductCode(pricingMatrix.getProductCode());
                                        if (ageBands != null) {
                                            for (ViatorProductAgeBandsBean ageBand : ageBands) {
                                                if (ageBand.getBandId() == pricingMatrix.getBandId()) {
                                                    gPriceMatrixBean.setAgeFrom(String.valueOf(ageBand.getAgeFrom()));
                                                    gPriceMatrixBean.setAgeTo(String.valueOf(ageBand.getAgeTo()));
                                                }
                                            }
                                        }
                                        gPriceMatrixBean.setCurrencyCode(pricingMatrix.getCurrencyCode());
                                        if (pricingMatrix.getMaximumCountRequired() > 9)
                                            gPriceMatrixBean.setMaxCountRequired(9);
                                        else
                                            gPriceMatrixBean.setMaxCountRequired(pricingMatrix.getMaximumCountRequired());
                                        if (pricingMatrix.getBandId() == 1) {
                                            gPriceMatrixBean.setPersonType("adult");
                                            if(pricingMatrix.getMinimumCountRequired()<1)
                                                gPriceMatrixBean.setMinCountRequired(1);
                                            else
                                                gPriceMatrixBean.setMinCountRequired(pricingMatrix.getMinimumCountRequired());
                                        }
                                        else if (pricingMatrix.getBandId() == 2) {
                                            gPriceMatrixBean.setPersonType("child");
                                            gPriceMatrixBean.setMinCountRequired(pricingMatrix.getMinimumCountRequired());
                                        }
                                        else if (pricingMatrix.getBandId() == 3) {
                                            gPriceMatrixBean.setPersonType("infant");
                                            gPriceMatrixBean.setMinCountRequired(pricingMatrix.getMinimumCountRequired());
                                        }
                                        else if (pricingMatrix.getBandId() == 4) {
                                            gPriceMatrixBean.setPersonType("youth");
                                            gPriceMatrixBean.setMinCountRequired(pricingMatrix.getMinimumCountRequired());
                                        }
                                        else if (pricingMatrix.getBandId() == 5) {
                                            gPriceMatrixBean.setPersonType("senior");
                                            gPriceMatrixBean.setMinCountRequired(pricingMatrix.getMinimumCountRequired());
                                        }
                                        gPriceMatrixBean.setPriceNet(String.valueOf(pricingMatrix.getMerchantNetPrice().add(pricingMatrix.getMerchantNetPrice().multiply(viatorComission).setScale(2, BigDecimal.ROUND_HALF_UP))));
                                        gPriceMatrixBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                                        gPriceMatrixBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());

                                        gPriceMatrixes.add(gPriceMatrixBean);
                                    }
                                }
                            }

                        }


                        if (bProductDetails.size() > 10) {//todo see if it must be returned to first structure without list
                            /**
                             * Delete product if exist and then add the update/new with all the details.
                             */
                            if (BProductDetailDAO.saveOrUpdateProductDetail(bProductDetails)) {
                                for (BProductDetailBean bProductDetail : bProductDetails) {
                                    failedProductCodeExist = false;
                                    for (String failedProductCode : failedProductCodes) {
                                        if (failedProductCode.equals(bProductDetail.getProductId()))
                                            failedProductCodeExist = true;
                                    }
                                    if (!failedProductCodeExist)
                                        failedProductCodes.add(bProductDetail.getProductId());
                                }
                                dbCommErrors++;
                            }
                            if (DProductPhotoDAO.saveOrUpdatePhoto(dProductPhotos)) {
                                for (DProductPhotoBean dProductPhoto : dProductPhotos) {
                                    failedProductCodeExist = false;
                                    for (String failedProductCode : failedProductCodes) {
                                        if (failedProductCode.equals(dProductPhoto.getProductId()))
                                            failedProductCodeExist = true;
                                    }
                                    if (!failedProductCodeExist)
                                        failedProductCodes.add(dProductPhoto.getProductId());
                                    dbCommErrors++;
                                }
                            }
                            for (String productId : updatedProductsIds) {
                                if (JProductQuestionsDAO.deleteProductQuestions(productId)) {
                                    failedProductCodeExist = false;
                                    for (String failedProductCode : failedProductCodes) {
                                        if (failedProductCode.equals(productId))
                                            failedProductCodeExist = true;
                                    }
                                    if (!failedProductCodeExist)
                                        failedProductCodes.add(productId);
                                    dbCommErrors++;
                                }
                            }
                            if (JProductQuestionsDAO.addpProductQuestion(jProductQuestions)) {
                                for (JProductQuestionsBean jProductQuestion : jProductQuestions) {
                                    failedProductCodeExist = false;
                                    for (String failedProductCode : failedProductCodes) {
                                        if (failedProductCode.equals(jProductQuestion.getProductId()))
                                            failedProductCodeExist = true;
                                    }
                                    if (!failedProductCodeExist)
                                        failedProductCodes.add(jProductQuestion.getProductId());
                                    dbCommErrors++;
                                }
                            }
                            for (String productId : updatedProductsIds) {
                                if (EPickupPointDAO.deletePickupPoint(productId)) {
                                    failedProductCodeExist = false;
                                    for (String failedProductCode : failedProductCodes) {
                                        if (failedProductCode.equals(productId))
                                            failedProductCodeExist = true;
                                    }
                                    if (!failedProductCodeExist)
                                        failedProductCodes.add(productId);
                                    dbCommErrors++;
                                }
                            }
                            if (EPickupPointDAO.addPickupPoint(ePickupPoints)) {
                                for (EPickupPointBean ePickupPoint : ePickupPoints) {
                                    failedProductCodeExist = false;
                                    for (String failedProductCode : failedProductCodes) {
                                        if (failedProductCode.equals(ePickupPoint.getProductId()))
                                            failedProductCodeExist = true;
                                    }
                                    if (!failedProductCodeExist)
                                        failedProductCodes.add(ePickupPoint.getProductId());
                                    dbCommErrors++;
                                }
                            }
                            if (CProductOptionsDAO.saveOrUpdateProductOption(cProductOptions)) {
                                for (CProductOptionsBean cProductOption : cProductOptions) {
                                    failedProductCodeExist = false;
                                    for (String failedProductCode : failedProductCodes) {
                                        if (failedProductCode.equals(cProductOption.getProductId()))
                                            failedProductCodeExist = true;
                                    }
                                    if (!failedProductCodeExist)
                                        failedProductCodes.add(cProductOption.getProductId());
                                    dbCommErrors++;
                                }
                            }
                            if (GPriceMatrixDAO.saveOrUpdatePriceMatrix(gPriceMatrixes)) {
                                for (GPriceMatrixBean gPriceMatrix : gPriceMatrixes) {
                                    failedProductCodeExist = false;
                                    for (String failedProductCode : failedProductCodes) {
                                        if (failedProductCode.equals(gPriceMatrix.getProductId()))
                                            failedProductCodeExist = true;
                                    }
                                    if (!failedProductCodeExist)
                                        failedProductCodes.add(gPriceMatrix.getProductId());
                                    dbCommErrors++;
                                }
                            }

                            bProductDetails.clear();
                            cProductOptions.clear();
                            dProductPhotos.clear();
                            jProductQuestions.clear();
                            ePickupPoints.clear();
                            gPriceMatrixes.clear();
                            updatedProductsIds.clear();
                        }
                    }
                }
                dT = new DateTime(DateTimeZone.UTC);
                atbUpdateProductsInfoBean.setEndDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                        dT.getYear(), dT.getMonthOfYear(), dT.getDayOfMonth(),
                        dT.getHourOfDay(), dT.getMinuteOfHour())));
                atbUpdateProductsInfoBean.setTotalProducts(totalproducts);
                atbUpdateProductsInfoBean.setDbCommErrorsCounter(dbCommErrors);
                atbUpdateProductsInfoBean.setTotalExpiredProducts(totalExpiredProducts);
                AtbUpdateProductsInfoDAO.addATBUpdateProductsInfo(atbUpdateProductsInfoBean);
                lastrec = AtbUpdateProductsInfoDAO.getLastRecord();
                if (lastrec != null)
                    for (String fp : failedProductCodes) {
                        failedProduct.setFailedProductCode(fp);
                        failedProduct.setUpdateRid(lastrec.getRid());
                        AtbUpdateFailedProductDAO.addATBUpdateFailedProduct(failedProduct);
                    }
                logger.info("\n\n**********************     " + " Update started at: " + atbUpdateProductsInfoBean.getStartDateTime() +
                        "\n**********************     " + " Update ended at: " + atbUpdateProductsInfoBean.getEndDateTime() +
                        "\n**********************     " + " Total Products updated/added: " + atbUpdateProductsInfoBean.getTotalProducts() +
                        "\n**********************     " + " Total Expired Products deleted: " + atbUpdateProductsInfoBean.getTotalExpiredProducts() +
                        "\n**********************     " + " Database Errors counter: " + atbUpdateProductsInfoBean.getDbCommErrorsCounter());
            }
            AdminController.atbViatorUpdateRunning = false;
        }catch(Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }
    }
}
