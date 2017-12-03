package Updates.ViatorDBUpdates;

import Beans.ViatorAPIBeans.Bookings.AvailabilityAndPricingMatrix.AvailabilityAndPricingMatrixAPIJSON;
import Beans.ViatorAPIBeans.Bookings.AvailabilityDatesAPIJSON;
import Beans.ViatorAPIBeans.Bookings.PickupHotel.PickupHotel;
import Beans.ViatorAPIBeans.Bookings.PickupHotel.PickupHotelsAPIJSON;
import Beans.ViatorAPIBeans.ProductDetails.*;
import Beans.ViatorAPIBeans.ProductsByDestIDSeoID.ProductsByAttractionPOST;
import Beans.ViatorAPIBeans.ProductsByDestIDSeoID.ProductsByDestIdSeoIdAPIJSON;
import Beans.ViatorAPIBeans.ProductsByDestIDSeoID.ProductsByDestinationPOST;
import Beans.ViatorAPIBeans.Taxonomy.TaxonomyDestinationsAPIJSON;
import Beans.ViatorAPIBeans.Taxonomy.TaxonomyDestinationsData;
import Controller.AdminController.AdminController;
import DAOs.ViatorAPIDAOs.BookingsAPIDAO;
import DAOs.ViatorAPIDAOs.ProductAPIDAO;
import DAOs.ViatorAPIDAOs.TaxonomyAPIDAO;
import DAOs.ViatorDBDAOs.*;
import Beans.ViatorDBBeans.*;
import Helper.CustomDate;
import Helper.ProjectProperties;
import Beans.ViatorDBBeans.UpdateDBBeans.FailedProduct;
import Beans.ViatorDBBeans.UpdateDBBeans.UpdateProductsInfoJSON;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import static Controller.AdminController.AdminController.viatorimidiateUpdateStop;
import static Controller.Application.errLogger;

/**
 * Created by George on 15/06/2017.
 */
public class UpdateProducts {




    public static UpdateProductsInfoJSON updateProducts(int destIdToStartRetrieveProducts, int destIdToStopRetrieveProducts) {

        ProductsByDestIdSeoIdAPIJSON productsByDestIdSeoIdAPIJSON;
        ProductDetailedInfoAPIJSON productDetailedInfoAPIJSON;
        ProductsByAttractionPOST productsByAttractionPOST = new ProductsByAttractionPOST();
        ProductsByDestinationPOST productsByDestinationPOST = new ProductsByDestinationPOST();
        TaxonomyDestinationsAPIJSON taxonomyDestinationsAPIJSON;
        AvailabilityDatesAPIJSON availabilityDatesAPIJSON;
        AvailabilityAndPricingMatrixAPIJSON availabilityAndPricingMatrixAPIJSON;
        PickupHotelsAPIJSON pickupHotelsAPIJSON;
        ViatorProductDetailsBean productDetailsBean = new ViatorProductDetailsBean();
        ViatorProductXCategoryBean viatorProductXCategoryBean=new ViatorProductXCategoryBean();
        ViatorProductXSubcategoryBean viatorProductXSubcategoryBean=new ViatorProductXSubcategoryBean();
        ViatorProductUserPhotosBean viatorProductUserPhotosBean=new ViatorProductUserPhotosBean();
        ViatorProductReviewsBean viatorProductReviewsBean=new ViatorProductReviewsBean();
        ViatorProductAgeBandsBean viatorProductAgebandsBean=new ViatorProductAgeBandsBean();
        ViatorProductSalesPointsBean viatorProductSalesPointsBean=new ViatorProductSalesPointsBean();
        ViatorProductInclusionsBean viatorProductInclusionsBean=new ViatorProductInclusionsBean();
        ViatorProductAdditionalInfoBean viatorProductAdditionalInfoBean=new ViatorProductAdditionalInfoBean();
        ViatorProductExclusionsBean viatorProductExclusionsBean=new ViatorProductExclusionsBean();
        ViatorProductPhotosBean viatorProductPhotosBean=new ViatorProductPhotosBean();
        ViatorProductTourGradesBean viatorProductTourGradesBean=new ViatorProductTourGradesBean();
        ViatorProductVideosBean viatorProductVideosBean=new ViatorProductVideosBean();
        ViatorProductTourGradeLanguageServicesBean vProductTourGradeLangServBean=new ViatorProductTourGradeLanguageServicesBean();
        ViatorNoneAvailableDatesBean noneAvailableDatesBean=new ViatorNoneAvailableDatesBean();
        ViatorPricingMatrixBean pricingMatrixBean=new ViatorPricingMatrixBean();
        boolean priceMatrixExists;
        List<ViatorPricingMatrixBean> singleTourGradepricingMatrixes=new ArrayList<>(); /*Keep a list of the price matrixes of a Single Tourgrade to check*/
        ViatorPickupHotelsBean pickupHotelsBean=new ViatorPickupHotelsBean();           /*and avoid AgeBand duplications with same minmum/maximum count requirments*/
        ViatorUpdateFailedAvailDatesBean viatorUpdateFailedAvailDatesBean=new ViatorUpdateFailedAvailDatesBean();
        ViatorUpdateFailedPricematrixesBean viatorUpdateFailedPricematrixesBean=new ViatorUpdateFailedPricematrixesBean();
        ViatorUpdateFailedDestinationsBean viatorUpdateFailedDestinationsBean=new ViatorUpdateFailedDestinationsBean();
        ViatorUpdateFailedProductsBean viatorUpdateFailedProductsBean=new ViatorUpdateFailedProductsBean();
        ViatorUpdateProductsInfoBean viatorUpdateProductsInfoBean=new ViatorUpdateProductsInfoBean();
        ViatorProductBookingQuestionsBean viatorProductBookingQuestionsBean=new ViatorProductBookingQuestionsBean();
        ViatorUpdateProductsInfoBean lastrec;

        AdminController.viatorUpdateRunning=true;


        /**
         * Set up logger.
         */
        Logger logger = Logger.getLogger("UpdateViatorProductsLog");
        FileHandler fh;
        try {
            for(Handler handler:logger.getHandlers()) {
                logger.removeHandler(handler);
            }
            // This block configure the logger with handler and formatter
            fh = new FileHandler(ProjectProperties.logspath+"UpdateViatorProductsLog.log");
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

        /**
         * Arguments for non-available-dates  table of a product.
         */
        List<CustomDate> nonAvailableDates=new ArrayList();
        List<Integer> nonAvailableDays=new ArrayList();
        List<Integer> availableDays=new ArrayList();
        String[] splitYearMonth;
        String yearMonth;
        List<Integer> days;
        DateTimeFormatter dtf;
        LocalDate firstAvailableDate;
        LocalDate lastAvailabledate;

        /**
         * Declare from which point in the destinations list start to retrieving destination's products and at which destination to stop.If  destIdToStartRetrieveProducts
         * is 0 and destIdToStopRetrieveProducts is 0 retrieve products from all destinations.Else retrieve products for the destinations in the list which are following the one
         * with destination Id "destIdToStartRetrieveProducts" and stop at destination with destination Id"destIdToStopRetrieveProducts".
         */
        boolean RetrieveProducts;
        if(destIdToStartRetrieveProducts==0)
            RetrieveProducts=true;
        else
            RetrieveProducts=false;

        /**
         * Set Default Values to POST object to retrieve all Viator's products.
         */
        String topX = "";
        String currencyCode = ProjectProperties.defaultCurrencyCode;
        String startDate = "";
        String endDate = "";
        int catId = 0;
        int subCatId = 0;
        boolean dealsOnly = false;
        String sortOrder = "TOP_SELLERS";

        productsByDestinationPOST.setCatId(catId);
        productsByDestinationPOST.setCurrencyCode(currencyCode);
        productsByDestinationPOST.setDealsOnly(dealsOnly);
        productsByDestinationPOST.setEndDate(endDate);
        productsByDestinationPOST.setStartDate(startDate);
        productsByDestinationPOST.setSortOrder(sortOrder);
        productsByDestinationPOST.setTopX(topX);
        productsByDestinationPOST.setSubCatId(subCatId);

        /**
         * Statistic Values/Information/Results.
         */
        UpdateProductsInfoJSON updateProductsInfoJSON =new UpdateProductsInfoJSON();
        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        updateProductsInfoJSON.setStartDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));
        updateProductsInfoJSON.setTotalLeafNodes(0);
        updateProductsInfoJSON.setLastLeafDestid(0);
        updateProductsInfoJSON.setTotalProducts(0);
        updateProductsInfoJSON.setDbCommError(false);
        updateProductsInfoJSON.setViatorError(false);
        updateProductsInfoJSON.setDbCommErrorsCounter(0);
        updateProductsInfoJSON.setTotalProcessSleep(0);
        List<Integer> failedDestinations=new ArrayList<>();
        List<FailedProduct> failedProducts=new ArrayList();


        /**
         * Time between viator server requests.There is a limit for the number of requests per
         * 10 seconds that we can make at viator's server(15req/10sec for prelive and 35req/10sec for live).
         * Process may sleep for an amount of time to stay in the limits.
         */
        long timeElapsed=0;

        /**
         * Clear Database from expired products.
         */
        updateProductsInfoJSON.setTotalExpiredProducts(DeleteExpiredProducts.deleteExpiredProducts(logger));

        /**
         * Search all Destinations.
         */
        taxonomyDestinationsAPIJSON=TaxonomyAPIDAO.retrieveDestinations();

        /**
         * If couldn't retrieve destinations cancel the update.//todo make an extra call of updateprodact function before cancel the update
         */
        if(!taxonomyDestinationsAPIJSON.isSuccess() || taxonomyDestinationsAPIJSON.getData()==null) {
            logger.info("********************** Communication ERROR.Did not received Destinations **********************");
            updateProductsInfoJSON.setViatorError(true);
            updateProductsInfoJSON.setViatorErrorInfo("Communication ERROR.Did not received Destinations");
            return updateProductsInfoJSON;
        }

        for(TaxonomyDestinationsData dest :taxonomyDestinationsAPIJSON.getData()) {

            logger.info("* * * * * * * * * * *      DESTINATION : "+ dest.getDestinationName()
                                                    +"  DESTINATION ID : "+ dest.getDestinationId()
                                                    +"      * * * * * * * * * * *");

            /**
             * Start receiving products for the desired destinations.
             */
            if(destIdToStartRetrieveProducts==dest.getDestinationId())
                RetrieveProducts=true;

            /**
             * Check if current destination is a leaf.Only leaf destinations have products.Parerent
             * Destination have same products as their child.
             */
            boolean leafNodeDest=true;
            for (TaxonomyDestinationsData d : taxonomyDestinationsAPIJSON.getData()){
                if(dest.getDestinationId()==d.getParentId() ) {
                    leafNodeDest = false;
                    break;
                }
            }
            /**
             * If a destination it's a leaf retrieve all its products and store in DB.
             */
            if(leafNodeDest && RetrieveProducts ) {

                if(viatorimidiateUpdateStop)
                    break;
                /**
                 * Statistic Information for Admin.
                 */
                updateProductsInfoJSON.setTotalLeafNodes(updateProductsInfoJSON.getTotalLeafNodes()+1);
                updateProductsInfoJSON.setLastLeafDestid(dest.getDestinationId());

                /**
                 * Process may sleep for an amount of time to stay in the limits.
                 */
                timeElapsed = System.currentTimeMillis() - timeElapsed;
                if (ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed > 0) {
                    try {
                        Thread.sleep(ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                        updateProductsInfoJSON.setTotalProcessSleep(updateProductsInfoJSON.getTotalProcessSleep()+ ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                /** Get product summary*/
                productsByDestinationPOST.setDestId(dest.getDestinationId());
                productsByDestIdSeoIdAPIJSON = ProductAPIDAO.searchProducts(productsByDestinationPOST, productsByAttractionPOST, true);
                timeElapsed=System.currentTimeMillis();

                if (productsByDestIdSeoIdAPIJSON.isSuccess() && productsByDestIdSeoIdAPIJSON.getData()!=null) {

                    for (int i = 0; i < productsByDestIdSeoIdAPIJSON.getData().size(); i++) {

                        if(viatorimidiateUpdateStop)
                            break;

                        /**
                         * Update/Add records of all related tables of product in the DB.
                         */
                        if(productsByDestIdSeoIdAPIJSON.getData().get(i).getCode()!=null) {
                            productDetailsBean.setCode(productsByDestIdSeoIdAPIJSON.getData().get(i).getCode());

                            /**
                             * Process may sleep for an amount of time to stay in the limits.
                             */
                            timeElapsed = System.currentTimeMillis() - timeElapsed;
                            if (ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed > 0) {
                                try {
                                    Thread.sleep(ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                                    updateProductsInfoJSON.setTotalProcessSleep(updateProductsInfoJSON.getTotalProcessSleep()+ ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                                } catch (InterruptedException ex) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                            /** Get product's details*/
                            productDetailedInfoAPIJSON = ProductAPIDAO.productDetailedInfo(productDetailsBean.getCode(), "EUR", false, false);
                            timeElapsed = System.currentTimeMillis();

                            dateTime =new DateTime( DateTimeZone.UTC);
                            if (productDetailedInfoAPIJSON.isSuccess() && productDetailedInfoAPIJSON.getData()!= null) {

                                productDetailsBean.setPrimaryDestinationId(productDetailedInfoAPIJSON.getData().getPrimaryDestinationId());
                                productDetailsBean.setDestinationId(productDetailedInfoAPIJSON.getData().getDestinationId());
                                productDetailsBean.setPrimaryGroupId(productDetailedInfoAPIJSON.getData().getPrimaryGroupId());
                                productDetailsBean.setSupplierCode(productDetailedInfoAPIJSON.getData().getSupplierCode());
                                productDetailsBean.setBookingEngineId(productDetailedInfoAPIJSON.getData().getBookingEngineId());
                                productDetailsBean.setTitleEn(productDetailedInfoAPIJSON.getData().getTitle());
                                productDetailsBean.setShortTitleEn(productDetailedInfoAPIJSON.getData().getShortTitle());
                                productDetailsBean.setHighlightsEn(productDetailedInfoAPIJSON.getData().getHighlights());
                                productDetailsBean.setPrimaryDestinationNameEn(productDetailedInfoAPIJSON.getData().getPrimaryDestinationName());
                                productDetailsBean.setLocationEn(productDetailedInfoAPIJSON.getData().getLocation());
                                productDetailsBean.setCityEn(productDetailedInfoAPIJSON.getData().getCity());
                                productDetailsBean.setCountryEn(productDetailedInfoAPIJSON.getData().getCountry());
                                productDetailsBean.setRegionEn(productDetailedInfoAPIJSON.getData().getRegion());
                                productDetailsBean.setDeparturePoint(productDetailedInfoAPIJSON.getData().getDeparturePoint());
                                productDetailsBean.setOperatesEn(productDetailedInfoAPIJSON.getData().getOperates());
                                productDetailsBean.setReturnDetails(productDetailedInfoAPIJSON.getData().getReturnDetails());
                                productDetailsBean.setShortDescriptionEn(productDetailedInfoAPIJSON.getData().getShortDescription());
                                productDetailsBean.setDescriptionEn(productDetailedInfoAPIJSON.getData().getDescription());
                                productDetailsBean.setVoucherRequirementsEn(productDetailedInfoAPIJSON.getData().getVoucherRequirements());
                                productDetailsBean.setDuration(productDetailedInfoAPIJSON.getData().getDuration());
                                productDetailsBean.setThumbnailUrl(productDetailedInfoAPIJSON.getData().getThumbnailURL());
                                productDetailsBean.setThumbnailHiResUrl(productDetailedInfoAPIJSON.getData().getThumbnailHiResURL());
                                productDetailsBean.setWebUrl(productDetailedInfoAPIJSON.getData().getWebURL());
                                productDetailsBean.setCurrencyCode(productDetailedInfoAPIJSON.getData().getCurrencyCode());
                                productDetailsBean.setPrice(productDetailedInfoAPIJSON.getData().getPrice());
                                productDetailsBean.setRrp(productDetailedInfoAPIJSON.getData().getRrp());
                                productDetailsBean.setMerchantNetPriceFrom(productDetailedInfoAPIJSON.getData().getMerchantNetPriceFrom());
                                productDetailsBean.setSavingAmount(productDetailedInfoAPIJSON.getData().getSavingAmount());
                                productDetailsBean.setRating(productDetailedInfoAPIJSON.getData().getRating());
                                productDetailsBean.setVoucherOption(productDetailedInfoAPIJSON.getData().getVoucherOption());
                                productDetailsBean.setDepartureTimeEn(productDetailedInfoAPIJSON.getData().getDepartureTime());
                                productDetailsBean.setDepartureTimeCommentsEn(productDetailedInfoAPIJSON.getData().getDepartureTimeComments());
                                productDetailsBean.setOnRequestPeriod(productDetailedInfoAPIJSON.getData().getOnRequestPeriod());
                                productDetailsBean.setSupplierName(productDetailedInfoAPIJSON.getData().getSupplierName());
                                productDetailsBean.setSpecialReservation(productDetailedInfoAPIJSON.getData().isSpecialReservation());
                                productDetailsBean.setSpecialReservationDetails(productDetailedInfoAPIJSON.getData().getSpecialReservationDetails());
                                productDetailsBean.setItineraryEn(productDetailedInfoAPIJSON.getData().getItinerary());
                                productDetailsBean.setTermsAndConditionsEn(productDetailedInfoAPIJSON.getData().getTermsAndConditions());
                                productDetailsBean.setMerchantCancellable(productDetailedInfoAPIJSON.getData().isMerchantCancellable());
                                productDetailsBean.setOnSale(productDetailedInfoAPIJSON.getData().isOnSale());
                                productDetailsBean.setSpecialOfferAvailable(productDetailedInfoAPIJSON.getData().isSpecialOfferAvailable());
                                productDetailsBean.setSpecialOfferEn(productDetailedInfoAPIJSON.getData().getSpecialOffer());
                                productDetailsBean.setTourGradesAvailable(productDetailedInfoAPIJSON.getData().isTourGradesAvailable());
                                productDetailsBean.setHotelPickup(productDetailedInfoAPIJSON.getData().isHotelPickup());
                                productDetailsBean.setVideoCount(productDetailedInfoAPIJSON.getData().getVideoCount());
                                productDetailsBean.setPanoramaCount(productDetailedInfoAPIJSON.getData().getPanoramaCount());
                                productDetailsBean.setPhotoCount(productDetailedInfoAPIJSON.getData().getPhotoCount());
                                productDetailsBean.setReviewCount(productDetailedInfoAPIJSON.getData().getReviewCount());
                                productDetailsBean.setTranslationLevel(productDetailedInfoAPIJSON.getData().getTranslationLevel());
                                productDetailsBean.setRating1Count(Integer.parseInt(productDetailedInfoAPIJSON.getData().getRatingCounts().get("1").toString()));
                                productDetailsBean.setRating2Count(Integer.parseInt(productDetailedInfoAPIJSON.getData().getRatingCounts().get("2").toString()));
                                productDetailsBean.setRating3Count(Integer.parseInt(productDetailedInfoAPIJSON.getData().getRatingCounts().get("3").toString()));
                                productDetailsBean.setRating4Count(Integer.parseInt(productDetailedInfoAPIJSON.getData().getRatingCounts().get("4").toString()));
                                productDetailsBean.setRating5Count(Integer.parseInt(productDetailedInfoAPIJSON.getData().getRatingCounts().get("5").toString()));
                                productDetailsBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                        dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));
                                if(ViatorProductDetailsDAO.deleteProduct(productDetailsBean.getCode())){
                                    updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                    updateProductsInfoJSON.setDbCommError(true);
                                }
                                if(ViatorProductDetailsDAO.addproduct(productDetailsBean)){
                                    updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                    updateProductsInfoJSON.setDbCommError(true);
                                }else {
                                    updateProductsInfoJSON.setTotalProducts(updateProductsInfoJSON.getTotalProducts() + 1);
                                    if (productDetailedInfoAPIJSON.getData().getCode() != null)
                                        logger.info("      ****************     Product code : " + productDetailedInfoAPIJSON.getData().getCode() +
                                                           " . Product count :" + updateProductsInfoJSON.getTotalProducts() + "     ****************      ");
                                }

                                if (productDetailedInfoAPIJSON.getData().getCatIds() != null) {
                                    for (int catid : productDetailedInfoAPIJSON.getData().getCatIds()) {
                                        viatorProductXCategoryBean.setCategoryId(catid);
                                        viatorProductXCategoryBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductXCategoryBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                                dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                        if(ViatorProductXCategoryDAO.addprodactXcategory(viatorProductXCategoryBean)){
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getSubCatIds() != null) {
                                    for (int subcatid : productDetailedInfoAPIJSON.getData().getSubCatIds()) {
                                        viatorProductXSubcategoryBean.setSubcategoryId(subcatid);
                                        viatorProductXSubcategoryBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductXSubcategoryBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                                   dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                                   dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                        if(ViatorProductXSubcategoryDAO.addprodactXsubcategory(viatorProductXSubcategoryBean)){
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }


                                if (productDetailedInfoAPIJSON.getData().getUserPhotos() != null) {
                                    for (ProductDetailUserPhotos usrphotos : productDetailedInfoAPIJSON.getData().getUserPhotos()) {
                                        viatorProductUserPhotosBean.setCaption(usrphotos.getCaption());
                                        viatorProductUserPhotosBean.setEditorsPick(usrphotos.isEditorsPick());
                                        viatorProductUserPhotosBean.setSslSupported(usrphotos.isSslSupported());
                                        viatorProductUserPhotosBean.setOwnerAvatarUrl(usrphotos.getOwnerAvatarURL());
                                        viatorProductUserPhotosBean.setOwnerCountry(usrphotos.getOwnerCountry());
                                        viatorProductUserPhotosBean.setOwnerId(usrphotos.getOwnerId());
                                        viatorProductUserPhotosBean.setOwnerName(usrphotos.getOwnerName());
                                        viatorProductUserPhotosBean.setPhotoHiResUrl(usrphotos.getPhotoHiResURL());
                                        viatorProductUserPhotosBean.setPhotoId(usrphotos.getPhotoId());
                                        viatorProductUserPhotosBean.setPhotoMediumResUrl(usrphotos.getPhotoMediumResURL());
                                        viatorProductUserPhotosBean.setPhotoUrl(usrphotos.getPhotoURL());
                                        viatorProductUserPhotosBean.setProductCode(usrphotos.getProductCode());
                                        viatorProductUserPhotosBean.setProductTitleEn(usrphotos.getProductTitle());
                                        viatorProductUserPhotosBean.setSortOrder(usrphotos.getSortOrder());
                                        viatorProductUserPhotosBean.setTitleEn(usrphotos.getTitle());
                                        viatorProductUserPhotosBean.setThumbnailUrl(usrphotos.getThumbnailURL());
                                        viatorProductUserPhotosBean.setTimeUploaded(usrphotos.getTimeUploaded());
                                        viatorProductUserPhotosBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                                 dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                                 dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                        if(ViatorProductUserPhotosDAO.addproductuserphotos(viatorProductUserPhotosBean)){
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                /**
                                 * Process may sleep for an amount of time to stay in the limits.
                                 */
                                timeElapsed = System.currentTimeMillis() - timeElapsed;
                                if (ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed > 0) {
                                    try {
                                        Thread.sleep(ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                                        updateProductsInfoJSON.setTotalProcessSleep(updateProductsInfoJSON.getTotalProcessSleep()+ ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                                    } catch (InterruptedException ex) {
                                        Thread.currentThread().interrupt();
                                    }
                                }

                                /**
                                 * Requesting viator for pickup Hotels of a product to add them to Pickup Hotels DB table.
                                 */
                                pickupHotelsAPIJSON=BookingsAPIDAO.productPickupHotels(productDetailedInfoAPIJSON.getData().getCode());
                                timeElapsed = System.currentTimeMillis();
                                if(pickupHotelsAPIJSON.isSuccess() && pickupHotelsAPIJSON.getData()!=null) {

                                    for (PickupHotel pickupHotel : pickupHotelsAPIJSON.getData()) {
                                        pickupHotelsBean.setAddress(pickupHotel.getAddress());
                                        pickupHotelsBean.setBrand(pickupHotel.getBrand());
                                        pickupHotelsBean.setCityName(pickupHotel.getCity());
                                        pickupHotelsBean.setDestinationId(pickupHotel.getDestinationId());
                                        pickupHotelsBean.setHotelId(pickupHotel.getId());
                                        pickupHotelsBean.setHotelName(pickupHotel.getName());
                                        pickupHotelsBean.setHotelString(pickupHotel.getHotelString());
                                        pickupHotelsBean.setLatitude(pickupHotel.getLatitude());
                                        pickupHotelsBean.setLongitude(pickupHotel.getLongitude());
                                        pickupHotelsBean.setNotes(pickupHotel.getNotes());
                                        pickupHotelsBean.setPhone(pickupHotel.getPhone());
                                        pickupHotelsBean.setPostCode(pickupHotel.getPostcode());
                                        pickupHotelsBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        pickupHotelsBean.setSortOrder(pickupHotel.getSortOrder());
                                        pickupHotelsBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                      dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                      dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                        if(ViatorPickupHotelsDAO.addPickupHotel(pickupHotelsBean)) {
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter() + 1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }else{
                                    boolean productexists=false;
                                    for(String code: updateProductsInfoJSON.getProductsWithFailedAvailDates()){
                                        if(code.equals(productDetailedInfoAPIJSON.getData().getCode()))
                                            productexists=true;
                                    }
                                    if(!productexists) {
                                        updateProductsInfoJSON.getProductsWithFailedPickupHotels().add(productDetailedInfoAPIJSON.getData().getCode());
                                        updateProductsInfoJSON.setViatorErrorInfo("Update completed but some Products did not added correctly to DB or " +
                                                "not updated.Check Failed Destinations/Failed Products List and" +
                                                " ProductsWithFailedAvailDates/ProductsWithFailedPickupHotels list.");
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getReviews() != null) {
                                    for (ProductDetailReviews review : productDetailedInfoAPIJSON.getData().getReviews()) {
                                        viatorProductReviewsBean.setOwnerAvatarUrl(review.getOwnerAvatarURL());
                                        viatorProductReviewsBean.setOwnerCountry(review.getOwnerCountry());
                                        viatorProductReviewsBean.setOwnerId(review.getOwnerId());
                                        viatorProductReviewsBean.setOwnerName(review.getOwnerName());
                                        viatorProductReviewsBean.setProductCode(review.getProductCode());
                                        viatorProductReviewsBean.setProductTitleEn(review.getProductTitle());
                                        viatorProductReviewsBean.setPublishedDate(review.getPublishedDate());
                                        viatorProductReviewsBean.setRating(review.getRating());
                                        viatorProductReviewsBean.setReview(review.getReview());
                                        viatorProductReviewsBean.setReviewId(review.getReviewId());
                                        viatorProductReviewsBean.setSortOrder(review.getSortOrder());
                                        viatorProductReviewsBean.setSubmissionDate(review.getSubmissionDate());
                                        viatorProductReviewsBean.setViatorFeedback(review.getViatorFeedback());
                                        viatorProductReviewsBean.setViatorNotes(review.getViatorNotes());
                                        viatorProductReviewsBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                              dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                              dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                        if(ViatorProductReviewsDAO.addproductreviews(viatorProductReviewsBean)){
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getAgeBands() != null) {
                                    for (ProductDetailAgeBands ageband : productDetailedInfoAPIJSON.getData().getAgeBands()) {
                                        viatorProductAgebandsBean.setAdult(ageband.isAdult());
                                        viatorProductAgebandsBean.setAgeFrom(ageband.getAgeFrom());
                                        viatorProductAgebandsBean.setAgeTo(ageband.getAgeTo());
                                        viatorProductAgebandsBean.setBandId(ageband.getBandId());
                                        viatorProductAgebandsBean.setCount(ageband.getCount());
                                        viatorProductAgebandsBean.setDescriptionEn(ageband.getDescription());
                                        viatorProductAgebandsBean.setPluralDescriptionEn(ageband.getPluralDescription());
                                        viatorProductAgebandsBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductAgebandsBean.setSortOrder(ageband.getSortOrder());
                                        viatorProductAgebandsBean.setTreatAsAdult(ageband.isTreatAsAdult());
                                        viatorProductAgebandsBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                               dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                               dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                        if(ViatorProductAgeBandsDAO.addproductagebandsBean(viatorProductAgebandsBean)){
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getSalesPoints() != null) {
                                    for (String salespoint : productDetailedInfoAPIJSON.getData().getSalesPoints()) {
                                        viatorProductSalesPointsBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductSalesPointsBean.setSalesPointEn(salespoint);
                                        viatorProductSalesPointsBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                                  dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                                  dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                        if(ViatorProductSalesPointsDAO.addproductsalespointsBean(viatorProductSalesPointsBean)){
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getInclusions() != null) {
                                    for (String inclusion : productDetailedInfoAPIJSON.getData().getInclusions()) {
                                        viatorProductInclusionsBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductInclusionsBean.setInclusion(inclusion);
                                        viatorProductInclusionsBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                                 dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                                 dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                        if(ViatorProductInclusionsDAO.addproductinclusions(viatorProductInclusionsBean)){
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getExclusions() != null) {
                                    for (String exclusion : productDetailedInfoAPIJSON.getData().getExclusions()) {
                                        viatorProductExclusionsBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductExclusionsBean.setExclusion(exclusion);
                                        viatorProductExclusionsBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                                 dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                                 dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                        if(ViatorProductExclusionsDAO.addproductexclusions(viatorProductExclusionsBean)){
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getAdditionalInfo() != null) {
                                    for (String addinfo : productDetailedInfoAPIJSON.getData().getAdditionalInfo()) {
                                        viatorProductAdditionalInfoBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductAdditionalInfoBean.setAdditionalInfo(addinfo);
                                        viatorProductAdditionalInfoBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                                     dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                                     dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                        if(ViatorProductAdditionalInfoDAO.addproductadditionalinfo(viatorProductAdditionalInfoBean)){
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                /**
                                 * Process may sleep for an amount of time to stay in the limits.
                                 */
                                timeElapsed = System.currentTimeMillis() - timeElapsed;
                                if (ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed > 0) {
                                    try {
                                        Thread.sleep(ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                                        updateProductsInfoJSON.setTotalProcessSleep(updateProductsInfoJSON.getTotalProcessSleep()+ ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                                    } catch (InterruptedException ex) {
                                        Thread.currentThread().interrupt();
                                    }
                                }
                                /**
                                 * Requesting viator for availability dates of product.
                                 */
                                availabilityDatesAPIJSON=BookingsAPIDAO.productAvailabilityDates(productDetailedInfoAPIJSON.getData().getCode());
                                timeElapsed = System.currentTimeMillis();

                                /**
                                 * Given the available dates,Add to database non available dates of the product.
                                 * If there is a product with availability to all days of a month
                                 * store only date with day=0 to ensure that DB have
                                 * availability information for this month.
                                 */
                                if(availabilityDatesAPIJSON.isSuccess() && availabilityDatesAPIJSON.getData()!=null) {

                                    for (String key : availabilityDatesAPIJSON.getData().keySet()) {
                                        yearMonth = key;
                                        splitYearMonth = yearMonth.split("-");
                                        dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
                                        firstAvailableDate = dtf.parseLocalDate(String.format("%04d-%02d-%02d",
                                                                                Integer.parseInt(splitYearMonth[0]),
                                                                                Integer.parseInt(splitYearMonth[1]), 1));
                                        lastAvailabledate = dtf.parseLocalDate(String.format("%04d-%02d-%02d",
                                                                               Integer.parseInt(splitYearMonth[0]),
                                                                               Integer.parseInt(splitYearMonth[1]),
                                                                               Integer.parseInt(firstAvailableDate.dayOfMonth().withMaximumValue().dayOfMonth().getAsText())));
                                        for (int date = 0;date <= lastAvailabledate.getDayOfMonth(); date++)
                                            nonAvailableDays.add(date);
                                        if (splitYearMonth != null && splitYearMonth.length == 2) {
                                            days = availabilityDatesAPIJSON.getData().get(key);
                                            if (days != null) {
                                                for (int day : days)
                                                    availableDays.add(day);
                                            }
                                        }
                                        nonAvailableDays.removeAll(availableDays);/**Removing the available dates of the non available dates list */
                                        for (int nonAvailableDay : nonAvailableDays) {
                                            CustomDate nonAvailableDate = new CustomDate();
                                            nonAvailableDate.setDay(nonAvailableDay);
                                            nonAvailableDate.setMonth(Integer.parseInt(splitYearMonth[1]));
                                            nonAvailableDate.setYear(Integer.parseInt(splitYearMonth[0]));
                                            nonAvailableDates.add(nonAvailableDate);
                                        }
                                        availableDays.clear();
                                        nonAvailableDays.clear();
                                    }

                                    noneAvailableDatesBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                    for(CustomDate cDate : nonAvailableDates) {
                                        noneAvailableDatesBean.setDay(cDate.getDay());
                                        noneAvailableDatesBean.setMonth(cDate.getMonth());
                                        noneAvailableDatesBean.setYear(cDate.getYear());
                                        noneAvailableDatesBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));
                                        if (ViatorNoneAvailableDatesDAO.addNoneAvailabilityDate(noneAvailableDatesBean)) {
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter() + 1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                    nonAvailableDates.clear();
                                }else{
                                    boolean productexists=false;
                                    for(String code: updateProductsInfoJSON.getProductsWithFailedAvailDates()){
                                        if(code.equals(productDetailedInfoAPIJSON.getData().getCode()))
                                            productexists=true;
                                    }
                                    if(!productexists) {
                                        updateProductsInfoJSON.getProductsWithFailedAvailDates().add(productDetailedInfoAPIJSON.getData().getCode());
                                        updateProductsInfoJSON.setViatorErrorInfo("Update completed but some Products did not added correctly to DB or " +
                                                "not updated.Check Failed Destinations/Failed Products List and" +
                                                " ProductsWithFailedAvailDates list.");
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getBookingQuestions() != null) {
                                    for (ProductDetailBookingQuestions bookingQuestion : productDetailedInfoAPIJSON.getData().getBookingQuestions()) {
                                        viatorProductBookingQuestionsBean.setMessage(bookingQuestion.getMessage());
                                        viatorProductBookingQuestionsBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductBookingQuestionsBean.setQuestionId(bookingQuestion.getQuestionId());
                                        viatorProductBookingQuestionsBean.setRequired(bookingQuestion.isRequired());
                                        viatorProductBookingQuestionsBean.setSortOrder(bookingQuestion.getSortOrder());
                                        viatorProductBookingQuestionsBean.setStringQuestionId(bookingQuestion.getStringQuestionId());
                                        viatorProductBookingQuestionsBean.setSubTitleEn(bookingQuestion.getSubTitle());
                                        viatorProductBookingQuestionsBean.setTitleEn(bookingQuestion.getTitle());
                                        viatorProductBookingQuestionsBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                                       dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                                       dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                        if(ViatorProductBookingQuestionsDAO.addBookingQuestion(viatorProductBookingQuestionsBean)){
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }



                                /**
                                 * Process may sleep for an amount of time to stay in the limits.
                                 */
                                timeElapsed = System.currentTimeMillis() - timeElapsed;
                                if (ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed > 0) {
                                    try {
                                        Thread.sleep(ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                                        updateProductsInfoJSON.setTotalProcessSleep(updateProductsInfoJSON.getTotalProcessSleep()+ ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                                    } catch (InterruptedException ex) {
                                        Thread.currentThread().interrupt();
                                    }
                                }
                                /**
                                 * Requesting viator for pricingmatrix of product.
                                 */
                                availabilityAndPricingMatrixAPIJSON=BookingsAPIDAO.productAvailabilityAndPricingMatrix(productDetailedInfoAPIJSON.getData().getCode(),
                                                                                                                       Integer.toString(dateTime.getMonthOfYear()),
                                                                                                                       Integer.toString(dateTime.getYear()));
                                timeElapsed = System.currentTimeMillis();

                                if(availabilityAndPricingMatrixAPIJSON.isSuccess() && availabilityAndPricingMatrixAPIJSON.getData()!=null
                                    && availabilityAndPricingMatrixAPIJSON.getData().getDates()!=null  && availabilityAndPricingMatrixAPIJSON.getData().getDates().size()>0) {

                                    pricingMatrixBean.setSortOrderOfDate(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getSortOrder());
                                    pricingMatrixBean.setBookingDate(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getBookingDate());
                                    pricingMatrixBean.setCallForLastMinAvailability(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).isCallForLastMinAvailability());

                                    for(int j=0;j<availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().size();j++) {
                                        pricingMatrixBean.setSortOrderOfTourGrade(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getSortOrder());
                                        pricingMatrixBean.setTourGradeCode(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getGradeCode());
                                        pricingMatrixBean.setTourGradeTitle(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getGradeTitle());
                                        for(int x=0;x<availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().size();x++) {
                                            pricingMatrixBean.setSortOrderOfPricing(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getSortOrder());
                                            pricingMatrixBean.setPricingUnit(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getPricingUnit());
                                            for(int y=0;y<availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getAgeBandPrices().size();y++) {
                                                pricingMatrixBean.setSortOrderOfAgeBand(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getAgeBandPrices().get(y).getSortOrder());
                                                pricingMatrixBean.setBandId(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getAgeBandPrices().get(y).getBandId());
                                                if(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getAgeBandPrices().get(y).getMaximumCountRequired()!=null)
                                                    pricingMatrixBean.setMaximumCountRequired((int)availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getAgeBandPrices().get(y).getMaximumCountRequired());
                                                else
                                                    pricingMatrixBean.setMaximumCountRequired(9);//todo ask umut the max number
                                                pricingMatrixBean.setMinimumCountRequired((int) availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getAgeBandPrices().get(y).getMinimumCountRequired());
                                                for(int z=0;z<availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getAgeBandPrices().get(y).getPrices().size();z++) {
                                                    if(!availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getAgeBandPrices().get(y).getPrices().get(z).getMerchantNetPrice().equals(0)) {
                                                        pricingMatrixBean.setSortOrderOfPrice(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getAgeBandPrices().get(y).getPrices().get(z).getSortOrder());
                                                        pricingMatrixBean.setCurrencyCode(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getAgeBandPrices().get(y).getPrices().get(z).getCurrencyCode());
                                                        pricingMatrixBean.setPrice(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getAgeBandPrices().get(y).getPrices().get(z).getPrice());
                                                        pricingMatrixBean.setMerchantNetPrice(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getAgeBandPrices().get(y).getPrices().get(z).getMerchantNetPrice());
                                                        pricingMatrixBean.setMinNoOfTravellersRequiredForPrice(availabilityAndPricingMatrixAPIJSON.getData().getDates().get(0).getTourGrades().get(j).getPricingMatrix().get(x).getAgeBandPrices().get(y).getPrices().get(z).getMinNoOfTravellersRequiredForPrice());

                                                        pricingMatrixBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                                        pricingMatrixBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));


                                                        /** Keep a list of the price matrixes of a Single Tourgrade to check
                                                         *  and avoid AgeBand duplications with same minmum/maximum count requirments.
                                                         */
                                                        priceMatrixExists=false;
                                                        for(ViatorPricingMatrixBean singleTourGradepricingMatrix:singleTourGradepricingMatrixes) {
                                                            if (singleTourGradepricingMatrix.getBandId() == pricingMatrixBean.getBandId() &&
                                                                pricingMatrixBean.getMinimumCountRequired() == singleTourGradepricingMatrix.getMinimumCountRequired() &&
                                                                singleTourGradepricingMatrix.getMaximumCountRequired() == pricingMatrixBean.getMaximumCountRequired()) {
                                                                priceMatrixExists = true;
                                                            }
                                                        }
                                                        if(!priceMatrixExists) {
                                                            ViatorPricingMatrixBean singleTourGradepricingMatrix=new ViatorPricingMatrixBean();
                                                            singleTourGradepricingMatrix.setBandId(pricingMatrixBean.getBandId());
                                                            singleTourGradepricingMatrix.setMaximumCountRequired(pricingMatrixBean.getMaximumCountRequired());
                                                            singleTourGradepricingMatrix.setMinimumCountRequired(pricingMatrixBean.getMinimumCountRequired());
                                                            singleTourGradepricingMatrixes.add(singleTourGradepricingMatrix);
                                                            if (ViatorPricingMatrixDAO.addPricingMatrix(pricingMatrixBean)) {
                                                                updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter() + 1);
                                                                updateProductsInfoJSON.setDbCommError(true);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        singleTourGradepricingMatrixes.clear();

                                    }


                                }else{
                                    boolean productexists=false;
                                    for(String code: updateProductsInfoJSON.getProductsWithFailedAvailDates()){
                                        if(code.equals(productDetailedInfoAPIJSON.getData().getCode()))
                                            productexists=true;
                                    }
                                    if(!productexists) {
                                        updateProductsInfoJSON.getProductsWithFailedPricingMatrixes().add(productDetailedInfoAPIJSON.getData().getCode());
                                        updateProductsInfoJSON.setViatorErrorInfo("Update completed but some Products did not added correctly to DB or " +
                                                "not updated.Check Failed Destinations/Failed Products List and" +
                                                " ProductsWithFailedAvailDates list.");
                                    }
                                }


                                if (productDetailedInfoAPIJSON.getData().getProductPhotos() != null) {
                                    for (ProductDetailProductPhotos prodphoto : productDetailedInfoAPIJSON.getData().getProductPhotos()) {
                                        if (prodphoto.getPhotoURL() == null)
                                            continue;
                                        viatorProductPhotosBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductPhotosBean.setCaption(prodphoto.getCaption());
                                        viatorProductPhotosBean.setPhotoUrl(prodphoto.getPhotoURL());
                                        viatorProductPhotosBean.setSupplier(prodphoto.getSupplier());
                                        viatorProductPhotosBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                             dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                             dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                        if(ViatorProductPhotosDAO.addproductphotos(viatorProductPhotosBean)){
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getTourGrades() != null) {
                                    for (ProductDetailTourGrades tourgrade : productDetailedInfoAPIJSON.getData().getTourGrades()) {
                                        viatorProductTourGradesBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductTourGradesBean.setCurrencyCode(tourgrade.getCurrencyCode());
                                        viatorProductTourGradesBean.setDefaultLanguageCode(tourgrade.getDefaultLanguageCode());
                                        viatorProductTourGradesBean.setGradeCode(tourgrade.getGradeCode());
                                        viatorProductTourGradesBean.setGradeDepartureTime(tourgrade.getGradeDepartureTime());
                                        viatorProductTourGradesBean.setGradeDescription(tourgrade.getGradeDescription());
                                        viatorProductTourGradesBean.setGradeTitle(tourgrade.getGradeTitle());
                                        viatorProductTourGradesBean.setMerchantNetPriceFrom(tourgrade.getMerchantNetPriceFrom());
                                        viatorProductTourGradesBean.setPriceFrom(tourgrade.getPriceFrom());
                                        viatorProductTourGradesBean.setSortOrder(tourgrade.getSortOrder());
                                        viatorProductTourGradesBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                                 dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                                 dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                        if(ViatorProductTourGradesDAO.addproducttourgrades(viatorProductTourGradesBean)){
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }

                                        if (tourgrade.getLangServices() != null) {
                                            for (Object name : tourgrade.getLangServices().keySet()) {

                                                vProductTourGradeLangServBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                                vProductTourGradeLangServBean.setLanguageServiceDescription(tourgrade.getLangServices().get(name).toString());
                                                vProductTourGradeLangServBean.setLanguageCodeAndService(name.toString());
                                                vProductTourGradeLangServBean.setGradeCode(tourgrade.getGradeCode());
                                                vProductTourGradeLangServBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                                           dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                                           dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                                if(ViatorProductTourGradeLanguageServicesDAO.addproducttourgradelanguageservicesBean(vProductTourGradeLangServBean)){
                                                    updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                                    updateProductsInfoJSON.setDbCommError(true);
                                                }
                                            }
                                        }
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getVideos() != null) {
                                    for (ProductDetailVideos video : productDetailedInfoAPIJSON.getData().getVideos()) {
                                        viatorProductVideosBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductVideosBean.setCaption(video.getCaption());
                                        viatorProductVideosBean.setCopyright(video.getCopyright());
                                        viatorProductVideosBean.setDescriptionEn(video.getDescription());
                                        viatorProductVideosBean.setOwnerAvatarUrl(video.getOwnerAvatarURL());
                                        viatorProductVideosBean.setOwnerCountry(video.getOwnerCountry());
                                        viatorProductVideosBean.setOwnerId(video.getOwnerId());
                                        viatorProductVideosBean.setOwnerName(video.getOwnerName());
                                        viatorProductVideosBean.setPhotoHiResUrl(video.getPhotoHiResURL());
                                        viatorProductVideosBean.setPhotoUrl(video.getPhotoURL());
                                        viatorProductVideosBean.setPrivatE(video.isPrivatE());
                                        viatorProductVideosBean.setProductTitleEn(video.getProductTitle());
                                        viatorProductVideosBean.setShortDescriptionEn(video.getShortDescription());
                                        viatorProductVideosBean.setSortOrder(video.getSortOrder());
                                        viatorProductVideosBean.setSource(video.getSource());
                                        viatorProductVideosBean.setThumbnailUrl(video.getThumbnailURL());
                                        viatorProductVideosBean.setTitleEn(video.getTitle());
                                        viatorProductVideosBean.setVideoId(video.getVideoId());
                                        viatorProductVideosBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                                             dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                                             dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                                        if(ViatorProductVideosDAO.addproductvideos(viatorProductVideosBean)){
                                            updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }//todo deside if it is better to add an external loop for the products/destinations that hadn't updated/added to DB due to viator comm Error
                                    }
                                }

                            }else{
                                FailedProduct failedProduct=new FailedProduct();
                                failedProduct.setDestId(dest.getDestinationId());
                                failedProduct.setProductCode(productDetailsBean.getCode());
                                failedProducts.add(failedProduct);
                                updateProductsInfoJSON.setViatorError(true);
                                updateProductsInfoJSON.setViatorErrorInfo("Update completed but some Products did not added correctly " +
                                                                          "to DB or not updated.Check Failed Destinations/Failed Products " +
                                                                          "List and ProductsWithFailedAvailDates list.");
                            }
                        }
                    }

                }else{
                    failedDestinations.add(dest.getDestinationId());
                    updateProductsInfoJSON.setViatorError(true);
                    updateProductsInfoJSON.setViatorErrorInfo("Update completed but some Products did not added correctly to DB " +
                                                              "or not updated.Check Failed Destinations/Failed Products List and " +
                                                              "ProductsWithFailedAvailDates list.");
                }
            }

            /**
             * Stop receiving products after the update has reached the desired destination.
             */
            if(destIdToStopRetrieveProducts!=0 && destIdToStopRetrieveProducts==dest.getDestinationId())
                RetrieveProducts=false;
        }

        /**
         * Set last update informations
         */
        if(updateProductsInfoJSON.getTotalExpiredProducts().isDbCommError())
            updateProductsInfoJSON.setDbCommError(true);
        if(updateProductsInfoJSON.getTotalExpiredProducts().isViatorError())
            updateProductsInfoJSON.setViatorError(true);
        updateProductsInfoJSON.setDbCommErrorsCounter(updateProductsInfoJSON.getTotalExpiredProducts().getDbCommErrorsCounter()
                                                      + updateProductsInfoJSON.getDbCommErrorsCounter());
        updateProductsInfoJSON.setViatorErrorInfo(updateProductsInfoJSON.getTotalExpiredProducts().getViatorErrorInfo()
                                                  + updateProductsInfoJSON.getViatorErrorInfo());
        updateProductsInfoJSON.setFailedDestinations(failedDestinations);
        updateProductsInfoJSON.setFailedProducts(failedProducts);
        dateTime =new DateTime( DateTimeZone.UTC);
        updateProductsInfoJSON.setEndDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                              dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                              dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));


        /**
         * Add update info to Database
         */
        viatorUpdateProductsInfoBean.setEndDateTime(updateProductsInfoJSON.getEndDateTime());
        viatorUpdateProductsInfoBean.setLastLeaDestid(updateProductsInfoJSON.getLastLeafDestid());
        viatorUpdateProductsInfoBean.setStartDateTime(updateProductsInfoJSON.getStartDateTime());
        viatorUpdateProductsInfoBean.setTotalExpiredProducts(updateProductsInfoJSON.getTotalExpiredProducts().getTotalExpiredProducts());
        viatorUpdateProductsInfoBean.setTotalLeafNodes(updateProductsInfoJSON.getTotalLeafNodes());
        viatorUpdateProductsInfoBean.setTotalProducts(updateProductsInfoJSON.getTotalProducts());
        viatorUpdateProductsInfoBean.setTotalRocessSleep(updateProductsInfoJSON.getTotalProcessSleep());
        viatorUpdateProductsInfoBean.setDbCommError(updateProductsInfoJSON.isDbCommError());
        viatorUpdateProductsInfoBean.setDbCommErrorsCounter(updateProductsInfoJSON.getDbCommErrorsCounter());
        viatorUpdateProductsInfoBean.setViatoErrorInfo(updateProductsInfoJSON.getViatorErrorInfo());
        viatorUpdateProductsInfoBean.setViatorError(updateProductsInfoJSON.isViatorError());
        ViatorUpdateProductsInfoDAO.addViatorUpdateProductsInfo(viatorUpdateProductsInfoBean);
        lastrec=ViatorUpdateProductsInfoDAO.getLastRecord();

        if(lastrec!=null) {
            for (FailedProduct failedProd : updateProductsInfoJSON.getFailedProducts()) {
                viatorUpdateFailedProductsBean.setFailedProductCode(failedProd.getProductCode());
                viatorUpdateFailedProductsBean.setFailedProductDestid(failedProd.getDestId());
                viatorUpdateFailedProductsBean.setUpdateRid(lastrec.getRid());
                ViatorUpdateFailedProductsDAO.addViatorUpdateFailedProduct(viatorUpdateFailedProductsBean);
            }

            for (int failedDest : updateProductsInfoJSON.getFailedDestinations()) {
                viatorUpdateFailedDestinationsBean.setFailedDestination(failedDest);
                viatorUpdateFailedDestinationsBean.setUpdateRid(lastrec.getRid());
                ViatorUpdateFailedDestinationsDAO.addViatorUpdateFailedDestination(viatorUpdateFailedDestinationsBean);
            }

            for (String prod : updateProductsInfoJSON.getProductsWithFailedAvailDates()) {
                viatorUpdateFailedAvailDatesBean.setProductWithFailedAvailDates(prod);
                viatorUpdateFailedAvailDatesBean.setUpdateRid(lastrec.getRid());
                ViatorUpdateFailedAvailDatesDAO.addViatorUpdateFailedAvailDates(viatorUpdateFailedAvailDatesBean);
            }

            for (String prod : updateProductsInfoJSON.getProductsWithFailedPricingMatrixes()) {
                viatorUpdateFailedPricematrixesBean.setProductWithFailedPricematrixes(prod);
                viatorUpdateFailedPricematrixesBean.setUpdateRid(lastrec.getRid());
                ViatorUpdateFailedPricematrixesDAO.addViatorUpdateFailedPricematrixes(viatorUpdateFailedPricematrixesBean);
            }
        }

        /**
         * Delete failed products from database
         */
        if(DeleteCorruptedProducts.deleteCorruptedProducts(logger)) {
            updateProductsInfoJSON.setDbCommError(true);
            logger.info("\n\n**********************     " + " Error while delleting corrupted products from database");
        }//todo If ever change to simultation atb and viator update:remove this code and delete details of the product imidiately  when a failed viator communication takes place
        /**
         * Print update Informations
         */
        logger.info("\n\n**********************     "+" Update started at: "+ updateProductsInfoJSON.getStartDateTime()+
                "\n**********************     "+" Update ended at: "+ updateProductsInfoJSON.getEndDateTime()+
                "\n**********************     "+" Viator communication Error: "+ updateProductsInfoJSON.isViatorError()+
                "\n**********************     "+" Viator communication Error info: "+ updateProductsInfoJSON.getViatorErrorInfo()+
                "\n**********************     "+" Database Error: "+ updateProductsInfoJSON.isDbCommError()+
                "\n**********************     "+" Database Errors counter: "+ updateProductsInfoJSON.getDbCommErrorsCounter()+
                "\n**********************     "+" Total process Sleep(in milliseconds): "+ updateProductsInfoJSON.getTotalProcessSleep()+
                "\n**********************     "+" Total Leaf Nodes: "+ updateProductsInfoJSON.getTotalLeafNodes()+
                "\n**********************     "+" Total Products updated/added: "+ updateProductsInfoJSON.getTotalProducts()+
                "\n**********************     "+" Total Expired Products deleted: "+ updateProductsInfoJSON.getTotalExpiredProducts().getTotalExpiredProducts()+
                "\n**********************     "+" Last Leaf Node Destination Id: "+ updateProductsInfoJSON.getLastLeafDestid()+
                "\n**********************     "+" Failed Destinations Id: "+ updateProductsInfoJSON.getFailedDestinations());
        for(int i = 0; i< updateProductsInfoJSON.getFailedProducts().size(); i++){
            logger.info("**********************     "+" Failed Product code/Dest Id: "+ updateProductsInfoJSON.getFailedProducts().get(i).getProductCode()
                    +","+ updateProductsInfoJSON.getFailedProducts().get(i).getDestId());
        }

        AdminController.viatorUpdateRunning=false;
        return updateProductsInfoJSON;
    }
}

