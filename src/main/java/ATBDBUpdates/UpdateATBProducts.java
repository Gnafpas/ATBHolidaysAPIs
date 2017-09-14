package ATBDBUpdates;

import ATBDBBeans.*;
import ATBSysDBBeans.AllLanguageBean;
import DAOs.ATBDBDAOs.*;
import DAOs.ATBSysDAOs.AllLanguageDAO;
import DAOs.DBDAOs.*;
import DBBeans.*;
import WebServicesBeans.ListingPage.GetProductsDAOParams;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by George on 08/08/2017.
 */
public class UpdateATBProducts {

    public static void updateProducts() {

        GetProductsDAOParams params = new GetProductsDAOParams();

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
        List<AllLanguageBean> allLanguages;

        AProductTitleBean aProductTitleBean = new AProductTitleBean();
        BProductDetailBean bProductDetailBean;
        List<BProductDetailBean> bProductDetails = new ArrayList<>();
        CProductOptionsBean cProductOptionsBean;
        List<CProductOptionsBean> cProductOptions = new ArrayList<>();
        DProductPhotoBean dProductPhotoBean;
        List<DProductPhotoBean> dProductPhotos = new ArrayList<>();
        EPickupPointBean ePickupPointBean;
        List<EPickupPointBean> ePickupPoints = new ArrayList<>();
        FPricePlanBean fPricePlanBean = new FPricePlanBean();
        GPriceMatrixBean gPriceMatrixBean;
        List<GPriceMatrixBean> gPriceMatrixes = new ArrayList<>();
        IAvailableTimeBean iAvailableTimeBean = new IAvailableTimeBean();
        HAvailableDateBean hAvailableDateBean = new HAvailableDateBean();
        HStopsaleDateBean hStopsaleDateBean;

        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        AProductTitleBean productTitlelastRecord = null;
        FPricePlanBean pricePlanlastRecord = null;
        boolean firstPriceMatrix;
        List<String> productOptionlanguages=new ArrayList<>();
        boolean langAlreadyExist;
        AProductTitleBean updatedProduct=null;
        List<String> updatedProductsIds=new ArrayList();

        /**
         * Delete expired products from ATBDB.
         */
        DeleteATBExpiredProducts.deleteATBExpiredProducts();

        /**
         * Retrieving all viator products codes.
         */
        List<String> codes = ViatorProductDetailsDAO.getAllProductsCodes();
        if (codes != null) {
            /**
             * For each product retrieve details and store to ATB DB a_product_title table.
             */

            for (String code : codes) {

                params.setCode(code);
                products = ViatorProductDetailsDAO.getProducts(params);
                if (products != null && products.size() > 0) {
                    aProductTitleBean.setBookingEngine(products.get(0).getBookingEngineId());
                    aProductTitleBean.setShowPrice("");
                    aProductTitleBean.setReason("");
                    aProductTitleBean.setProductReferenceCode("");
                    aProductTitleBean.setSortOrder("");
                    aProductTitleBean.setbPoint("");
                    aProductTitleBean.setaPoint("");
                    aProductTitleBean.setCityCode("");
                    aProductTitleBean.setCityName(products.get(0).getCityEn());
                    aProductTitleBean.setCountryCode("");
                    aProductTitleBean.setCountryName(products.get(0).getCountryEn());
                    aProductTitleBean.setCurrencyCode(products.get(0).getCurrencyCode());
                    aProductTitleBean.setMainSupplierId("10236");//todo
                    aProductTitleBean.setMainSupplierName("Viator");
                    aProductTitleBean.setMarchandNetPrice(products.get(0).getMerchantNetPriceFrom().toString());
                    aProductTitleBean.setOnSale("On sale");
                    aProductTitleBean.setProductCode(products.get(0).getCode());
                    aProductTitleBean.setProductTitle(products.get(0).getShortTitleEn());
                    aProductTitleBean.setSubId(products.get(0).getCode());
                    aProductTitleBean.setSubSupplierId("");
                    aProductTitleBean.setSubSupplierName(products.get(0).getSupplierName());
                    aProductTitleBean.setTextLanguage("ENG");
                    aProductTitleBean.setThumbnailUrl(products.get(0).getThumbnailHiResUrl());
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
                         * Add categories to  "categories_tag" field at ATB DB.
                         */
                        aProductTitleBean.setCategoriesTag("");
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
                            if (categories.get(0).getGroupname().equals("Shore Excursions")) {
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
                            if (categories.get(0).getGroupname().equals("Private & Custom Tours"))
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
                     * Add product to ATB DB.
                     */

                    updatedProduct=AProductTitleDAO.getProductByCode(aProductTitleBean.getProductCode());
                    if(updatedProduct!=null)
                        updatedProductsIds.add(String.valueOf(updatedProduct.getId()));
                    AProductTitleDAO.deleteProduct(aProductTitleBean.getProductCode());
                    AProductTitleDAO.addproduct(aProductTitleBean);
                    productTitlelastRecord=AProductTitleDAO.getLastRecord();
                    if(productTitlelastRecord==null)
                        break;

                    /**
                     * Store  other product details to ATB DB b_product_detail table.
                     */
                    bProductDetailBean=new BProductDetailBean();
                    bProductDetailBean.setMobileAccess("");
                    bProductDetailBean.setVoucherTelephone("");
                    bProductDetailBean.setVoucherCountryCode("");
                    bProductDetailBean.setVoucherInfo(products.get(0).getVoucherRequirementsEn());
                    bProductDetailBean.setDescriptionSummary(products.get(0).getShortDescriptionEn());
                    bProductDetailBean.setProductDetail(products.get(0).getDescriptionEn());
                    bProductDetailBean.setProductId(String.valueOf(productTitlelastRecord.getId()));
                    bProductDetailBean.setCategories("");
                    bProductDetailBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                    bProductDetailBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());

                    String info = "";
                    additionalInfos = ViatorProductAdditionalInfoDAO.getAdditionalInfoByProductCode(products.get(0).getCode());
                    if (additionalInfos != null) {
                        for (ViatorProductAdditionalInfoBean additionalInfo : additionalInfos) {
                            info = info + additionalInfo.getAdditionalInfo();
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
                    if (products.get(0).getHighlightsEn() == null)
                        bProductDetailBean.setHighlight("");
                    else
                        bProductDetailBean.setHighlight(products.get(0).getHighlightsEn());
                    if (products.get(0).getMerchantCancellable()) {
                        bProductDetailBean.setMerchantCancellable("true");
                        bProductDetailBean.setCancellationPolicy("Fully refundable up to 48 hours");
                    } else {
                        bProductDetailBean.setMerchantCancellable("false");
                        bProductDetailBean.setCancellationPolicy("Fully non-refundable at time of booking");
                    }


                    bProductDetails.add(bProductDetailBean);


                    /**
                     * Store  photos of product to ATB DB d_Product_Photo table.
                     */
                    photos = ViatorProductPhotosDAO.getPhotosByProductCode(products.get(0).getCode());
                    if (photos != null && photos.size() > 0) {
                        dProductPhotoBean=new DProductPhotoBean();
                        dProductPhotoBean.setProductId(String.valueOf(productTitlelastRecord.getId()));
                        dProductPhotoBean.setPhotoName(products.get(0).getThumbnailHiResUrl());
                        dProductPhotoBean.setSupplierId("10236");//todo
                        dProductPhotoBean.setMainPhoto("");
                        dProductPhotoBean.setCaption("");
                        dProductPhotoBean.setVt("2");
                        dProductPhotoBean.setSubId("");
                        dProductPhotoBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                        dProductPhotoBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());

                        dProductPhotos.add(dProductPhotoBean);
                        for (ViatorProductPhotosBean photo : photos) {
                            dProductPhotoBean=new DProductPhotoBean();
                            dProductPhotoBean.setProductId(String.valueOf(productTitlelastRecord.getId()));
                            String[] photoURL=photo.getPhotoUrl().split("prelive");
                            dProductPhotoBean.setPhotoName("thumbs674x446"+photoURL[1]);//todo
                            dProductPhotoBean.setSupplierId("10236");//todo
                            dProductPhotoBean.setMainPhoto("");
                            dProductPhotoBean.setCaption("");
                            dProductPhotoBean.setVt("2");
                            dProductPhotoBean.setSubId("");
                            dProductPhotoBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                            dProductPhotoBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());

                            dProductPhotos.add(dProductPhotoBean);
                        }
                    }

                    /**
                     * Store  pickupHotels of product to ATB DB e_Pickup_Point table.
                     */
                    pickupHotels = ViatorPickupHotelsDAO.getPickupHotelsByProductCode(products.get(0).getCode());
                    if (pickupHotels != null && pickupHotels.size() > 0) {
                        for (ViatorPickupHotelsBean pickupHotel : pickupHotels) {
                            ePickupPointBean=new EPickupPointBean();
                            ePickupPointBean.setProductId(String.valueOf(productTitlelastRecord.getId()));
                            ePickupPointBean.setHotelPickupPoint(pickupHotel.getHotelName());
                            ePickupPointBean.setLatitude(String.valueOf(pickupHotel.getLatitude()));
                            ePickupPointBean.setLongitude(String.valueOf(pickupHotel.getLongitude()));
                            ePickupPointBean.setStartingPoint(pickupHotel.getAddress() + ", " + pickupHotel.getCityName() + ", " + products.get(0).getCountryEn());
                            ePickupPointBean.setPickupType("");
                            ePickupPointBean.setMeetingPoint("");
                            ePickupPointBean.setMapZoom("13");
                            ePickupPointBean.setDropOfEndPoint("");
                            ePickupPointBean.setPrecisionType("");
                            ePickupPointBean.setPickupNote("");
                            ePickupPointBean.setHotelId(pickupHotel.getHotelId());
                            if (pickupHotel.getNotes() != null)
                                ePickupPointBean.setPickupNote(pickupHotel.getNotes());
                            else
                                ePickupPointBean.setPickupNote("");
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
                    cProductOptionsBean.setProductId(String.valueOf(productTitlelastRecord.getId()));
                    cProductOptionsBean.setGuidingAudio("");
                    cProductOptionsBean.setGuidingBooklets("");
                    cProductOptionsBean.setGuidingLive("");
                    cProductOptionsBean.setTypeOfPricing("");
                    cProductOptionsBean.setPrivateOption("");
                    cProductOptionsBean.setValidy("");
                    cProductOptionsBean.setDuration(products.get(0).getDuration());
                    cProductOptionsBean.setMinConfirmationTime("");
                    cProductOptionsBean.setCustomerDetailRequest("");
                    cProductOptionsBean.setAvailabilityTime("Starting Times");
                    cProductOptionsBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                    cProductOptionsBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                    tourGradeLanguageServices = ViatorProductTourGradeLanguageServicesDAO.getLanguageServicesByProductCode(products.get(0).getCode());
                    if (tourGradeLanguageServices != null) {
                        for (ViatorProductTourGradeLanguageServicesBean tourGradeLanguageService : tourGradeLanguageServices) {
                            String[] splitLanguageServiceDescription = tourGradeLanguageService.getLanguageServiceDescription().split(" ");
                            allLanguages = AllLanguageDAO.getAllLanguages();
                            if (allLanguages != null) {
                                for (AllLanguageBean language : allLanguages) {
                                    if (splitLanguageServiceDescription != null && splitLanguageServiceDescription.length > 0 && splitLanguageServiceDescription[0].equals(language.getLanguage())) {
                                        String[] splitLanguageCodeAndService = tourGradeLanguageService.getLanguageCodeAndService().split("/");
                                        if (splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && splitLanguageCodeAndService[1].equals("SERVICE_AUDIO")) {
                                            langAlreadyExist=false;
                                            for(String lang:productOptionlanguages){
                                                if(splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && lang.equals(language.getLanguageCode()+"SERVICE_AUDIO"))
                                                    langAlreadyExist=true;
                                            }
                                            if(!langAlreadyExist) {
                                                cProductOptionsBean.setGuidingAudio(cProductOptionsBean.getGuidingAudio() + language.getLanguageCode() + ", ");
                                                productOptionlanguages.add(language.getLanguageCode()+"SERVICE_AUDIO");
                                            }
                                        }
                                        else if (splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && splitLanguageCodeAndService[1].equals("SERVICE_GUIDE")) {
                                            langAlreadyExist=false;
                                            for(String lang:productOptionlanguages){
                                                if(splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && lang.equals(language.getLanguageCode()+"SERVICE_GUIDE"))
                                                    langAlreadyExist=true;
                                            }
                                            if(!langAlreadyExist) {
                                                cProductOptionsBean.setGuidingLive(cProductOptionsBean.getGuidingLive() + language.getLanguageCode() + ", ");
                                                productOptionlanguages.add(language.getLanguageCode()+"SERVICE_GUIDE");
                                            }
                                        }
                                        else if (splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && splitLanguageCodeAndService[1].equals("SERVICE_WRITTEN")) {
                                            langAlreadyExist=false;
                                            for(String lang:productOptionlanguages){
                                                if(splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && lang.equals(language.getLanguageCode()+"SERVICE_WRITTEN"))
                                                    langAlreadyExist=true;
                                            }
                                            if(!langAlreadyExist) {
                                                cProductOptionsBean.setGuidingBooklets(cProductOptionsBean.getGuidingBooklets() + language.getLanguageCode() + ", ");
                                                productOptionlanguages.add(language.getLanguageCode()+"SERVICE_WRITTEN");
                                            }
                                        }
                                        else {//todo
                                            langAlreadyExist=false;
                                            for(String lang:productOptionlanguages){
                                                if(splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && lang.equals(language.getLanguageCode()+"SERVICE_GUIDE"))
                                                    langAlreadyExist=true;
                                            }
                                            if(!langAlreadyExist) {
                                                cProductOptionsBean.setGuidingLive(cProductOptionsBean.getGuidingLive() + language.getLanguageCode() + ", ");
                                                productOptionlanguages.add(language.getLanguageCode()+"SERVICE_GUIDE");
                                            }
                                            langAlreadyExist=false;
                                            for(String lang:productOptionlanguages){
                                                if(splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && lang.equals(language.getLanguageCode()+"SERVICE_WRITTEN"))
                                                    langAlreadyExist=true;
                                            }
                                            if(!langAlreadyExist) {
                                                cProductOptionsBean.setGuidingBooklets(cProductOptionsBean.getGuidingBooklets() + language.getLanguageCode() + ", ");
                                                productOptionlanguages.add(language.getLanguageCode()+"SERVICE_WRITTEN");
                                            }
                                            langAlreadyExist=false;
                                            for(String lang:productOptionlanguages){
                                                if(splitLanguageCodeAndService != null && splitLanguageCodeAndService.length > 1 && lang.equals(language.getLanguageCode()+"SERVICE_AUDIO"))
                                                    langAlreadyExist=true;
                                            }
                                            if(!langAlreadyExist) {
                                                cProductOptionsBean.setGuidingAudio(cProductOptionsBean.getGuidingAudio() + language.getLanguageCode() + ", ");
                                                productOptionlanguages.add(language.getLanguageCode()+"SERVICE_AUDIO");
                                            }
                                        }
                                        break;

                                    }
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
                        if(updatedProduct!=null) {
                            FPricePlanDAO.deletePriceplan(String.valueOf(updatedProduct.getId()));
                            IAvailableTimeDAO.deleteavailableTime(String.valueOf(updatedProduct.getId()));
                            HStopsaleDateDAO.deleteStopsaleDate(String.valueOf(updatedProduct.getId()));
                        }
                        firstPriceMatrix=true;
                        fPricePlanBean.setTourGradeCode("");

                        for (ViatorPricingMatrixBean pricingMatrix : pricingMatrixes) {

                            /**
                             * Store tourgrades at priceplan table without dublications.
                             */
                            if (!pricingMatrix.getTourGradeCode().equals(fPricePlanBean.getTourGradeCode())) {//todo change this line to to avoid duplications of plans.It can be a dublication if the tour grades at the price matrix table aren't stucked properly.

                                fPricePlanBean.setMinParticipants(String.valueOf(pricingMatrix.getMinimumCountRequired()));//todo see if this is correct
                                if(pricingMatrix.getPricingUnit()!=null && !pricingMatrix.getPricingUnit().equals(""))
                                fPricePlanBean.setPriceType("Price "+pricingMatrix.getPricingUnit());
                                fPricePlanBean.setProductId(String.valueOf(productTitlelastRecord.getId()));
                                fPricePlanBean.setRateType("net");
                                fPricePlanBean.setSubId("");
                                fPricePlanBean.setTourGradeCode(pricingMatrix.getTourGradeCode());


                                tourGrades = ViatorProductTourGradesDAO.getTourGradesByProductCode(pricingMatrix.getProductCode());
                                fPricePlanBean.setPlanTitle("");
                                if (tourGrades != null) {
                                    for (ViatorProductTourGradesBean tourGrade : tourGrades) {
                                        if (tourGrade.getGradeCode().equals(pricingMatrix.getTourGradeCode())) {
                                            if(tourGrade.getGradeTitle().equals("") || tourGrade.getGradeTitle()==null)
                                                fPricePlanBean.setPlanTitle(products.get(0).getShortTitleEn()+". "+tourGrade.getGradeDescription());
                                            else
                                                fPricePlanBean.setPlanTitle(tourGrade.getGradeTitle()+". "+tourGrade.getGradeDescription());
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



                                FPricePlanDAO.addPriceplan(fPricePlanBean);
                                pricePlanlastRecord = FPricePlanDAO.getLastRecord();

                                if (pricePlanlastRecord != null) {

                                    //  if (firstPriceMatrix) {//todo determine if we store dates at product code level and not at plan level.check if i can leave blank the available_id
                                    firstPriceMatrix=false;

                                    List<ViatorProductDetailsBean> productsDetails = new ArrayList<>();
                                    productsDetails.add(products.get(0));
                                    noneAvailableDates = ViatorNoneAvailableDatesDAO.getNoneAvailDatesOfProducts(productsDetails);

                                    hAvailableDateBean = new HAvailableDateBean();
                                    hAvailableDateBean.setAvailableTimeType("");
                                    hAvailableDateBean.setAvailableTitle(pricePlanlastRecord.getPlanTitle());
                                    hAvailableDateBean.setDepartimeOnOff("");
                                    hAvailableDateBean.setPlanId(String.valueOf(pricePlanlastRecord.getId()));
                                    hAvailableDateBean.setProductId(String.valueOf(productTitlelastRecord.getId()));
                                    Calendar calendar = Calendar.getInstance();
                                    calendar.set(noneAvailableDates.get(noneAvailableDates.size() - 1).getYear(), noneAvailableDates.get(noneAvailableDates.size() - 1).getMonth() - 1, 1);
                                    int lastDate = calendar.getActualMaximum(Calendar.DATE);
                                    hAvailableDateBean.setStartDate(Date.valueOf(String.format("%04d-%02d-%02d",
                                            noneAvailableDates.get(0).getYear(), noneAvailableDates.get(0).getMonth(),
                                            2)));
                                    hAvailableDateBean.setEndDate(Date.valueOf(String.format("%04d-%02d-%02d",
                                            noneAvailableDates.get(noneAvailableDates.size() - 1).getYear(),
                                            noneAvailableDates.get(noneAvailableDates.size() - 1).getMonth(),
                                            lastDate)));
                                    hAvailableDateBean.setUpdatedAt(Date.valueOf(String.format("%04d-%02d-%02d",
                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth())));
                                    hAvailableDateBean.setCreatedAt(Date.valueOf(String.format("%04d-%02d-%02d",
                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth())));

                                    if(updatedProduct!=null)
                                        HAvailableDateDAO.deleteAvailableDate(String.valueOf(updatedProduct.getId()));
                                    HAvailableDateDAO.addAvailableDate(hAvailableDateBean);
                                    HAvailableDateBean lastAvailableDateRecord=HAvailableDateDAO.getLastRecord();

                                    if(lastAvailableDateRecord!=null) {
                                        if (noneAvailableDates != null && noneAvailableDates.size() > 0) {
                                            for (ViatorNoneAvailableDatesBean noneAvailableDate : noneAvailableDates) {

                                                if (noneAvailableDate.getDay() != 0) {
                                                    hStopsaleDateBean = new HStopsaleDateBean();
                                                    hStopsaleDateBean.setAvailableId(String.valueOf(lastAvailableDateRecord.getId()));
                                                    hStopsaleDateBean.setPlanId(String.valueOf(pricePlanlastRecord.getId()));
                                                    hStopsaleDateBean.setProductId(String.valueOf(productTitlelastRecord.getId()));
                                                    hStopsaleDateBean.setStopDate(Date.valueOf(String.format("%04d-%02d-%02d",
                                                            noneAvailableDate.getYear(), noneAvailableDate.getMonth(), noneAvailableDate.getDay())));

                                                    hStopsaleDateBean.setUpdatedAt(Date.valueOf(String.format("%04d-%02d-%02d",
                                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth())));
                                                    hStopsaleDateBean.setCreatedAt(Date.valueOf(String.format("%04d-%02d-%02d",
                                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth())));

                                                    HStopsaleDateDAO.addStopsaleDate(hStopsaleDateBean);
                                                }
                                            }
                                        }
                                        //  }


                                        iAvailableTimeBean.setProductId(String.valueOf(productTitlelastRecord.getId()));
                                        iAvailableTimeBean.setPlanId(String.valueOf(pricePlanlastRecord.getId()));
                                        iAvailableTimeBean.setEndTime(":");
                                        iAvailableTimeBean.setAvailableId(String.valueOf(lastAvailableDateRecord.getId()));
                                        iAvailableTimeBean.setUpdatedAt(Date.valueOf(String.format("%04d-%02d-%02d",
                                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth())));
                                        iAvailableTimeBean.setCreatedAt(Date.valueOf(String.format("%04d-%02d-%02d",
                                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth())));

                                        if (iAvailableTimeBean.getStartTime() != null && !iAvailableTimeBean.getStartTime().equals("")) {
                                            iAvailableTimeBean.setWeekDay("Monday");
                                            IAvailableTimeDAO.addAvailableTime(iAvailableTimeBean);
                                            iAvailableTimeBean.setWeekDay("Tuesday");
                                            IAvailableTimeDAO.addAvailableTime(iAvailableTimeBean);
                                            iAvailableTimeBean.setWeekDay("Wednesday");
                                            IAvailableTimeDAO.addAvailableTime(iAvailableTimeBean);
                                            iAvailableTimeBean.setWeekDay("Thursday");
                                            IAvailableTimeDAO.addAvailableTime(iAvailableTimeBean);
                                            iAvailableTimeBean.setWeekDay("Friday");
                                            IAvailableTimeDAO.addAvailableTime(iAvailableTimeBean);
                                            iAvailableTimeBean.setWeekDay("Saturday");
                                            IAvailableTimeDAO.addAvailableTime(iAvailableTimeBean);
                                            iAvailableTimeBean.setWeekDay("Sunday");
                                            IAvailableTimeDAO.addAvailableTime(iAvailableTimeBean);
                                        }
                                    }
                                }
                            }


                            if (pricePlanlastRecord != null) {
                                gPriceMatrixBean = new GPriceMatrixBean();
                                if(pricingMatrix.getMinNoOfTravellersRequiredForPrice()==1) {//todo check if it s ok like this
                                    gPriceMatrixBean.setPlanId(String.valueOf(pricePlanlastRecord.getId()));
                                    gPriceMatrixBean.setProductId(String.valueOf(productTitlelastRecord.getId()));
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
                                    gPriceMatrixBean.setMinCountRequired(pricingMatrix.getMinimumCountRequired());
                                    if (pricingMatrix.getMaximumCountRequired() == null || pricingMatrix.getMaximumCountRequired() > 9)
                                        gPriceMatrixBean.setMaxCountRequired(9);
                                    else
                                        gPriceMatrixBean.setMaxCountRequired(pricingMatrix.getMaximumCountRequired());
                                    if (pricingMatrix.getBandId() == 1)
                                        gPriceMatrixBean.setPersonType("adult");
                                    else if (pricingMatrix.getBandId() == 2)
                                        gPriceMatrixBean.setPersonType("child");
                                    else if (pricingMatrix.getBandId() == 3)
                                        gPriceMatrixBean.setPersonType("infant");
                                    else if (pricingMatrix.getBandId() == 4)
                                        gPriceMatrixBean.setPersonType("youth");
                                    else if (pricingMatrix.getBandId() == 5)
                                        gPriceMatrixBean.setPersonType("senior");
                                    gPriceMatrixBean.setPriceNet(String.valueOf(pricingMatrix.getMerchantNetPrice()));
                                    gPriceMatrixBean.setPriceRate("");
                                    gPriceMatrixBean.setCommission("");
                                    gPriceMatrixBean.setOptionTitle("");
                                    gPriceMatrixBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());
                                    gPriceMatrixBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour())).toString());

                                    gPriceMatrixes.add(gPriceMatrixBean);
                                }
                            }
                        }//todo put all fields value of "" at first so we dont have null exceptions.And put if clause also when parameter is null set "".

                    }


                    if(bProductDetails.size()>10) {//todo see if it must be returned to first structure without list
                        /**
                         * Delete product if exist and then add the update/new with all the details.
                         */

                        for(String productId:updatedProductsIds)
                            BProductDetailDAO.deleteProduct(productId);
                        BProductDetailDAO.addproduct(bProductDetails);
                        for(DProductPhotoBean productPhoto:dProductPhotos)
                            DProductPhotoDAO.deletePhoto(productPhoto.getProductId());
                        DProductPhotoDAO.addPhoto(dProductPhotos);
                        for(String productId:updatedProductsIds)
                            EPickupPointDAO.deletePickupPoint(productId);
                        EPickupPointDAO.addPickupPoint(ePickupPoints);
                        for(String productId:updatedProductsIds)
                            CProductOptionsDAO.deleteProductOption(productId);
                        CProductOptionsDAO.addProductOption(cProductOptions);
                        for(String productId:updatedProductsIds)
                            GPriceMatrixDAO.deletePriceMatrix(productId);
                        GPriceMatrixDAO.addPriceMatrix(gPriceMatrixes);

                        bProductDetails.clear();
                        cProductOptions.clear();
                        dProductPhotos.clear();
                        ePickupPoints.clear();
                        gPriceMatrixes.clear();
                        updatedProductsIds.clear();
                    }
                }
            }
        }
    }
}
