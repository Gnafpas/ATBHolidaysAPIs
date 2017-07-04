package DBUpdates;

import APIBeans.ProductDetails.*;
import APIBeans.ProductsByDestIDSeoID.ProductsByAttractionPOST;
import APIBeans.ProductsByDestIDSeoID.ProductsByDestIdSeoIdAPIJSON;
import APIBeans.ProductsByDestIDSeoID.ProductsByDestinationPOST;
import APIBeans.Taxonomy.TaxonomyDestinationsAPIJSON;
import APIBeans.Taxonomy.TaxonomyDestinationsData;
import DAOs.APIDAOs.ProductAPIDAO;
import DAOs.APIDAOs.TaxonomyAPIDAO;
import DAOs.DBDAOs.*;
import DBBeans.*;
import WebServicesBeans.UpdateDBJSONs.FailedProduct;
import WebServicesBeans.UpdateDBJSONs.UpdateProductsInfoJSON;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 15/06/2017.
 */
public class UpdateProducts {



    public UpdateProductsInfoJSON updateProducts(int destIdToStartRetrieveProducts, int destIdToStopRetrieveProducts) {

        ProductsByDestIdSeoIdAPIJSON productsByDestIdSeoIdAPIJSON;
        ProductDetailedInfoAPIJSON productDetailedInfoAPIJSON;
        ProductAPIDAO productAPIDAO = new ProductAPIDAO();
        ProductsByAttractionPOST productsByAttractionPOST = new ProductsByAttractionPOST();
        ProductsByDestinationPOST productsByDestinationPOST = new ProductsByDestinationPOST();
        TaxonomyAPIDAO taxonomy=new TaxonomyAPIDAO();
        TaxonomyDestinationsAPIJSON taxonomyDestinationsAPIJSON;
        ViatorProductDetailsBean productDetailsBean = new ViatorProductDetailsBean();
        ViatorProductDetailsDAO viatorProductDetailsDAO = new ViatorProductDetailsDAO();
        ViatorProductXCategoryDAO viatorProductXcategoryDAO=new ViatorProductXCategoryDAO();
        ViatorProductXCategoryBean viatorProductXCategoryBean=new ViatorProductXCategoryBean();
        ViatorProductXSubcategoryBean viatorProductXSubcategoryBean=new ViatorProductXSubcategoryBean();
        ViatorProductXSubcategoryDAO viatorProductXsubcategoryDAO=new ViatorProductXSubcategoryDAO();
        ViatorProductUserPhotosDAO viatorProductuserphotosDAO=new ViatorProductUserPhotosDAO();
        ViatorProductUserPhotosBean viatorProductUserPhotosBean=new ViatorProductUserPhotosBean();
        ViatorProductReviewsDAO viatorProductReviewsDAO=new ViatorProductReviewsDAO();
        ViatorProductReviewsBean viatorProductReviewsBean=new ViatorProductReviewsBean();
        ViatorProductAgeBandsDAO viatorProductAgebandsDAO=new ViatorProductAgeBandsDAO();
        ViatorProductAgeBandsBean viatorProductAgebandsBean=new ViatorProductAgeBandsBean();
        ViatorProductSalesPointsDAO viatorProductSalesPointsDAO=new ViatorProductSalesPointsDAO();
        ViatorProductSalesPointsBean viatorProductSalesPointsBean=new ViatorProductSalesPointsBean();
        ViatorProductInclusionsBean viatorProductInclusionsBean=new ViatorProductInclusionsBean();
        ViatorProductInclusionsDAO viatorProductInclusionsDAO=new ViatorProductInclusionsDAO();
        ViatorProductAdditionalInfoBean viatorProductAdditionalInfoBean=new ViatorProductAdditionalInfoBean();
        ViatorProductAdditionalInfoDAO viatorProductAdditionalInfoDAO=new ViatorProductAdditionalInfoDAO();
        ViatorProductExclusionsBean viatorProductExclusionsBean=new ViatorProductExclusionsBean();
        ViatorProductExclusionsDAO viatorProductExclusionsDAO=new ViatorProductExclusionsDAO();
        ViatorProductPhotosBean viatorProductPhotosBean=new ViatorProductPhotosBean();
        ViatorProductPhotosDAO viatorProductPhotosDAO=new ViatorProductPhotosDAO();
        ViatorProductTourGradesBean viatorProductTourGradesBean=new ViatorProductTourGradesBean();
        ViatorProductTourGradesDAO viatorProductTourGradesDAO=new ViatorProductTourGradesDAO();
        ViatorProductVideosBean viatorProductVideosBean=new ViatorProductVideosBean();
        ViatorProductVideosDAO viatorProductVideosDAO=new ViatorProductVideosDAO();
        ViatorProductTourGradeLanguageServicesBean vProductTourGradeLangServBean=new ViatorProductTourGradeLanguageServicesBean();
        ViatorProductTourGradeLanguageServicesDAO vProductTourGradeLangServDAO=new ViatorProductTourGradeLanguageServicesDAO();

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
        String currencyCode = "EUR";
        String startDate = "";
        String endDate = "";
        int catId = 0;
        int subCatId = 0;
        boolean dealsOnly = false;
        boolean leafNodeDest;
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
         * Statistic Values/Information/Results in JSON for Admin.
         */
        UpdateProductsInfoJSON updateProductsInfoJSON =new UpdateProductsInfoJSON();
        updateProductsInfoJSON.setStartDateTime(ZonedDateTime.now(ZoneOffset.UTC));
        updateProductsInfoJSON.setTotalLeafNodes(0);
        updateProductsInfoJSON.setLastLeafDestid(0);
        updateProductsInfoJSON.setTotalProducts(0);
        updateProductsInfoJSON.setDbCommError(false);
        updateProductsInfoJSON.setViatorError(false);
        updateProductsInfoJSON.setDbCommErrorCounter(0);
        updateProductsInfoJSON.setTotalProcessSleep(0);
        List<Integer> failedDestinations=new ArrayList<>();
        List<FailedProduct> failedProducts=new ArrayList();
        FailedProduct failedProduct;

        /**
         * Time between viator server requests.There is a limit for the number of requests per
         * 10 seconds that we can make at viator's server(15req/10sec for prelive and 35req/10sec for live).
         * Process may sleep for an amount of time to stay in the limits.
         */
        long timeElapsed=0;

        /**
         * Clear Database from expired products.
         */
        DeleteExpiredProducts delete=new DeleteExpiredProducts();
        updateProductsInfoJSON.setTotalExpiredProducts(delete.deleteExpiredProducts());

        /**
         * Search all Destinations.
         */
         taxonomyDestinationsAPIJSON=taxonomy.retrieveDestinations();

        /**
         * If couldn't retrieve destinations cancel the update.//todo make an extra call of updateprodact function before cancel the update
         */
         if(!taxonomyDestinationsAPIJSON.isSuccess() || taxonomyDestinationsAPIJSON.getData()==null) {
            System.out.println("********************** Communication ERROR.Did not received Destinations **********************");
            updateProductsInfoJSON.setViatorError(true);
            updateProductsInfoJSON.setViatorErrorInfo("Communication ERROR.Did not received Destinations");
            return updateProductsInfoJSON;
        }

        for(TaxonomyDestinationsData dest :taxonomyDestinationsAPIJSON.getData()) {

            System.out.println();
            System.out.println("* * * * * * * * * * *      DESTINATION : "+ dest.getDestinationName()
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
            leafNodeDest=true;
            for (TaxonomyDestinationsData d : taxonomyDestinationsAPIJSON.getData()){
                if(dest.getDestinationId()==d.getParentId() ) {
                    leafNodeDest = false;
                    break;
                }
            }
            /**
             * If a destination it's a leaf retrieve all its products and store in DB.
             */
            if(leafNodeDest && RetrieveProducts) {

                /**
                 * Statistic Information for Admin.
                 */
                updateProductsInfoJSON.setTotalLeafNodes(updateProductsInfoJSON.getTotalLeafNodes()+1);
                updateProductsInfoJSON.setLastLeafDestid(dest.getDestinationId());

                /**
                 * Process may sleep for an amount of time to stay in the limits.
                 */
                timeElapsed = System.currentTimeMillis() - timeElapsed;
                if (670 - timeElapsed > 0) {//todo change time elapsed when go out live
                    try {
                        Thread.sleep(670 - timeElapsed);
                        updateProductsInfoJSON.setTotalProcessSleep(updateProductsInfoJSON.getTotalProcessSleep()+ 670 - timeElapsed);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                /** Get product summary*/
                productsByDestinationPOST.setDestId(dest.getDestinationId());
                productsByDestIdSeoIdAPIJSON = productAPIDAO.searchProducts(productsByDestinationPOST, productsByAttractionPOST, true);
                timeElapsed=System.currentTimeMillis();

                if (productsByDestIdSeoIdAPIJSON.isSuccess() && productsByDestIdSeoIdAPIJSON.getData()!=null) {

                    for (int i = 0; i < productsByDestIdSeoIdAPIJSON.getData().size(); i++) {

                        /**
                         * Update/Add records of all related tables of product in the DB.
                         */
                        if(productsByDestIdSeoIdAPIJSON.getData().get(i).getCode()!=null) {
                            productDetailsBean.setCode(productsByDestIdSeoIdAPIJSON.getData().get(i).getCode());

                            /**
                             * Process may sleep for an amount of time to stay in the limits.
                             */
                            timeElapsed = System.currentTimeMillis() - timeElapsed;
                            if (670 - timeElapsed > 0) {//todo change time elapsed when go out live
                                try {
                                    Thread.sleep(670 - timeElapsed);
                                    updateProductsInfoJSON.setTotalProcessSleep(updateProductsInfoJSON.getTotalProcessSleep()+ 670 - timeElapsed);
                                } catch (InterruptedException ex) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                            /** Get product's details*/
                            productDetailedInfoAPIJSON = productAPIDAO.productDetailedInfo(productDetailsBean.getCode(), "EUR", false, false);
                            timeElapsed = System.currentTimeMillis();

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
                                productDetailsBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                                if(viatorProductDetailsDAO.deleteProduct(productDetailsBean.getCode())){
                                    updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
                                    updateProductsInfoJSON.setDbCommError(true);
                                }
                                if(viatorProductDetailsDAO.addproduct(productDetailsBean)){
                                    updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
                                    updateProductsInfoJSON.setDbCommError(true);
                                }else {
                                    updateProductsInfoJSON.setTotalProducts(updateProductsInfoJSON.getTotalProducts() + 1);
                                    if (productDetailedInfoAPIJSON.getData().getCode() != null)
                                        System.out.println("      ****************     Product code : " + productDetailedInfoAPIJSON.getData().getCode() + " . Product count :" + updateProductsInfoJSON.getTotalProducts() + "     ****************      ");
                                }

                                if (productDetailedInfoAPIJSON.getData().getCatIds() != null) {
                                    for (int catid : productDetailedInfoAPIJSON.getData().getCatIds()) {
                                        viatorProductXCategoryBean.setCategoryId(catid);
                                        viatorProductXCategoryBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductXCategoryBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                                        if(viatorProductXcategoryDAO.addprodactXcategory(viatorProductXCategoryBean)){
                                            updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getSubCatIds() != null) {
                                    for (int subcatid : productDetailedInfoAPIJSON.getData().getSubCatIds()) {
                                        viatorProductXSubcategoryBean.setSubcategoryId(subcatid);
                                        viatorProductXSubcategoryBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductXSubcategoryBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                                        if(viatorProductXsubcategoryDAO.addprodactXsubcategory(viatorProductXSubcategoryBean)){
                                            updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
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
                                        viatorProductUserPhotosBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                                        if(viatorProductuserphotosDAO.addproductuserphotos(viatorProductUserPhotosBean)){
                                            updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
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
                                        viatorProductReviewsBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                                        if(viatorProductReviewsDAO.addproductreviews(viatorProductReviewsBean)){
                                            updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
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
                                        viatorProductAgebandsBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                                        if(viatorProductAgebandsDAO.addproductagebandsBean(viatorProductAgebandsBean)){
                                            updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getSalesPoints() != null) {
                                    for (String salespoint : productDetailedInfoAPIJSON.getData().getSalesPoints()) {
                                        viatorProductSalesPointsBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductSalesPointsBean.setSalesPointEn(salespoint);
                                        viatorProductSalesPointsBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                                        if(viatorProductSalesPointsDAO.addproductsalespointsBean(viatorProductSalesPointsBean)){
                                            updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getInclusions() != null) {
                                    for (String inclusion : productDetailedInfoAPIJSON.getData().getInclusions()) {
                                        viatorProductInclusionsBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductInclusionsBean.setInclusion(inclusion);
                                        viatorProductInclusionsBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                                        if(viatorProductInclusionsDAO.addproductinclusions(viatorProductInclusionsBean)){
                                            updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getExclusions() != null) {
                                    for (String exclusion : productDetailedInfoAPIJSON.getData().getExclusions()) {
                                        viatorProductExclusionsBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductExclusionsBean.setExclusion(exclusion);
                                        viatorProductExclusionsBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                                        if(viatorProductExclusionsDAO.addproductexclusions(viatorProductExclusionsBean)){
                                            updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getAdditionalInfo() != null) {
                                    for (String addinfo : productDetailedInfoAPIJSON.getData().getAdditionalInfo()) {
                                        viatorProductAdditionalInfoBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductAdditionalInfoBean.setAdditionalInfo(addinfo);
                                        viatorProductAdditionalInfoBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                                        if(viatorProductAdditionalInfoDAO.addproductadditionalinfo(viatorProductAdditionalInfoBean)){
                                            updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }
                                    }
                                }

                                if (productDetailedInfoAPIJSON.getData().getProductPhotos() != null) {
                                    for (ProductDetailProductPhotos prodphoto : productDetailedInfoAPIJSON.getData().getProductPhotos()) {
                                        if (prodphoto.getPhotoURL() == null)
                                            break;//todo check if there is a leak of photos
                                        viatorProductPhotosBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                        viatorProductPhotosBean.setCaption(prodphoto.getCaption());
                                        viatorProductPhotosBean.setPhotoUrl(prodphoto.getPhotoURL());
                                        viatorProductPhotosBean.setSupplier(prodphoto.getSupplier());
                                        viatorProductPhotosBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                                        if(viatorProductPhotosDAO.addproductphotos(viatorProductPhotosBean)){
                                            updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
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
                                        viatorProductTourGradesBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                                        if(viatorProductTourGradesDAO.addproducttourgrades(viatorProductTourGradesBean)){
                                            updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }

                                        if (tourgrade.getLangServices() != null) {
                                            for (Object name : tourgrade.getLangServices().keySet()) {

                                                vProductTourGradeLangServBean.setProductCode(productDetailedInfoAPIJSON.getData().getCode());
                                                vProductTourGradeLangServBean.setLanguageServiceDescription(tourgrade.getLangServices().get(name).toString());
                                                vProductTourGradeLangServBean.setLanguageCodeAndService(name.toString());
                                                vProductTourGradeLangServBean.setGradeCode(tourgrade.getGradeCode());
                                                vProductTourGradeLangServBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                                                if(vProductTourGradeLangServDAO.addproducttourgradelanguageservicesBean(vProductTourGradeLangServBean)){
                                                    updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
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
                                        viatorProductVideosBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                                        if(viatorProductVideosDAO.addproductvideos(viatorProductVideosBean)){
                                            updateProductsInfoJSON.setDbCommErrorCounter(updateProductsInfoJSON.getDbCommErrorCounter()+1);
                                            updateProductsInfoJSON.setDbCommError(true);
                                        }//todo deside if it is better to add an external loop for the products/destinations that hadn't updated/added to DB due to viator comm Error
                                    }
                                }

                            }else{
                                failedProduct=new FailedProduct();
                                failedProduct.setDestId(productDetailsBean.getDestinationId());
                                failedProduct.setProductCode(productDetailsBean.getCode());
                                failedProducts.add(failedProduct);
                                updateProductsInfoJSON.setViatorError(true);
                                updateProductsInfoJSON.setViatorErrorInfo("Update completed but some products did not added to DB or not updated.Check Failed Destinations/Failed Products List.");
                            }
                        }
                    }

                }else{
                    failedDestinations.add(dest.getDestinationId());
                    updateProductsInfoJSON.setViatorError(true);
                    updateProductsInfoJSON.setViatorErrorInfo("Update completed but some Products did not added to DB or not updated.Check Failed Destinations/Failed Products List.");
                }
            }

            /**
             * Stop receiving products after the update has reached the desired destination.
             */
            if(destIdToStopRetrieveProducts!=0 && destIdToStopRetrieveProducts==dest.getDestinationId())
                RetrieveProducts=false;
        }

        updateProductsInfoJSON.setFailedDestinations(failedDestinations);
        updateProductsInfoJSON.setFailedProducts(failedProducts);
        updateProductsInfoJSON.setEndDateTime(ZonedDateTime.now(ZoneOffset.UTC));
        System.out.println("\n\n**********************     "+" Update started at: "+ updateProductsInfoJSON.getStartDateTime()+
                           "\n**********************     "+" Update ended at: "+ updateProductsInfoJSON.getEndDateTime()+
                           "\n**********************     "+" Error: "+ updateProductsInfoJSON.isViatorError()+
                           "\n**********************     "+" Error info: "+ updateProductsInfoJSON.getViatorErrorInfo()+
                           "\n**********************     "+" Total process Sleep(in milliseconds): "+ updateProductsInfoJSON.getTotalProcessSleep()+
                           "\n**********************     "+" Total Leaf Nodes: "+ updateProductsInfoJSON.getTotalLeafNodes()+
                           "\n**********************     "+" Total Products updated/added: "+ updateProductsInfoJSON.getTotalProducts()+
                           "\n**********************     "+" Total Expired Products deleted: "+ updateProductsInfoJSON.getTotalExpiredProducts().getTotalExpiredProducts()+
                           "\n**********************     "+" Last Leaf Node Destination Id: "+ updateProductsInfoJSON.getLastLeafDestid()+
                           "\n**********************     "+" Failed Destinations Id: "+ updateProductsInfoJSON.getFailedDestinations());
        for(int i = 0; i< updateProductsInfoJSON.getFailedProducts().size(); i++){
            System.out.println("**********************     "+" Failed Product code/Dest Id: "+ updateProductsInfoJSON.getFailedProducts().get(i).getProductCode()
                                                              +","+ updateProductsInfoJSON.getFailedProducts().get(i).getDestId());
        }
        return updateProductsInfoJSON;
    }
}

