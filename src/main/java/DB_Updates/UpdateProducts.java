package DB_Updates;

import APIBeans.Product_Details.*;
import APIBeans.Products_By_DestID_SeoID.Products_By_Attraction_POST;
import APIBeans.Products_By_DestID_SeoID.Products_By_DestID_SeoID_APIJSON;
import APIBeans.Products_By_DestID_SeoID.Products_By_Destination_POST;
import APIBeans.Taxonomy.Taxonomy_Destinations_APIJSON;
import APIBeans.Taxonomy.Taxonomy_Destinations_Data;
import DAOs.API_DAOs.Product_API_DAO;
import DAOs.API_DAOs.Taxonomy_API_DAO;
import DAOs.DB_DAOs.*;
import DB_Beans.*;
import com.fasterxml.jackson.databind.util.TypeKey;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Created by George on 15/06/2017.
 */
public class UpdateProducts {



    public void updateProducts() {

        Products_By_DestID_SeoID_APIJSON products_by_destIDSeoID_APIJSON;
        Product_API_DAO product_API_DAO = new Product_API_DAO();
        Products_By_Attraction_POST products_by_attraction_POST = new Products_By_Attraction_POST();
        Products_By_Destination_POST products_by_destination_POST = new Products_By_Destination_POST();
        Taxonomy_API_DAO taxonomy=new Taxonomy_API_DAO();
        ViatorProductDetailsBean productDetailsBean = new ViatorProductDetailsBean();
        Viator_Product_Details_DAO viator_product_details_DAO = new Viator_Product_Details_DAO();
        Viator_ProductXCategory_DAO viator_productXcategory_DAO=new Viator_ProductXCategory_DAO();
        ViatorProductXCategoryBean viatorproductXcategoryBean=new ViatorProductXCategoryBean();
        ViatorProductXSubcategoryBean viatorproductXsubcategoryBean=new ViatorProductXSubcategoryBean();
        Viator_ProductXSubcategory_DAO viator_productXsubcategory_DAO=new Viator_ProductXSubcategory_DAO();
        Viator_ProductUserPhotos_DAO viator_productuserphotos_DAO=new Viator_ProductUserPhotos_DAO();
        ViatorProductUserPhotosBean viatorproductuserphotosBean=new ViatorProductUserPhotosBean();
        Viator_ProductReviews_DAO viator_productreviews_DAO=new Viator_ProductReviews_DAO();
        ViatorProductReviewsBean viatorproductreviewsBean=new ViatorProductReviewsBean();
        Viator_ProductAgeBands_DAO viator_productAgebands_DAO=new Viator_ProductAgeBands_DAO();
        ViatorProductAgeBandsBean viatorproductagebandsBean=new ViatorProductAgeBandsBean();
        Viator_ProductSalesPoints_DAO viator_productsalespoints_DAO=new Viator_ProductSalesPoints_DAO();
        ViatorProductSalesPointsBean viatorproductsalespointsBean=new ViatorProductSalesPointsBean();
        ViatorProductInclusionsBean viatorproductinclusionsBean=new ViatorProductInclusionsBean();
        Viator_ProductInclusions_DAO viator_productinclusions_DAO=new Viator_ProductInclusions_DAO();
        ViatorProductAdditionalInfoBean viatorproductadditionalinfoBean=new ViatorProductAdditionalInfoBean();
        Viator_ProductAdditionalInfo_DAO viator_productadditionalinfo_DAO=new Viator_ProductAdditionalInfo_DAO();
        ViatorProductExclusionsBean viatorproductexclusionsBean=new ViatorProductExclusionsBean();
        Viator_ProductExclusions_DAO viator_productexclusions_DAO=new Viator_ProductExclusions_DAO();
        ViatorProductPhotosBean viatorproductphotosBean=new ViatorProductPhotosBean();
        Viator_ProductPhotos_DAO viator_productphotos_DAO=new Viator_ProductPhotos_DAO();
        ViatorProductTourGradesBean viatoproducttourgradesBean=new ViatorProductTourGradesBean();
        Viator_ProductTourGrades_DAO viator_producttourgrades_DAO=new Viator_ProductTourGrades_DAO();
        ViatorProductVideosBean viatorproductvideosBean=new ViatorProductVideosBean();
        Viator_ProductVideos_DAO viator_productvideos_DAO=new Viator_ProductVideos_DAO();
        ViatorProductTourGradeLanguageServicesBean vproducttourgradeLangservBean=new ViatorProductTourGradeLanguageServicesBean();
        Viator_ProductTourGradeLanguageServices_DAO vproducttourgradelangserv_DAO=new Viator_ProductTourGradeLanguageServices_DAO();

        Date date=new Date();//todo
        long time_elapsed=0;

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
        boolean leaf_node_Dest;
        String sortOrder = "TOP_SELLERS";

        products_by_destination_POST.setCatId(catId);
        products_by_destination_POST.setCurrencyCode(currencyCode);
        products_by_destination_POST.setDealsOnly(dealsOnly);
        products_by_destination_POST.setEndDate(endDate);
        products_by_destination_POST.setStartDate(startDate);
        products_by_destination_POST.setSortOrder(sortOrder);
        products_by_destination_POST.setTopX(topX);
        products_by_destination_POST.setSubCatId(subCatId);

        /**
         * Search all Destinations.
         */
        Taxonomy_Destinations_APIJSON taxonomy_destinations_APIJSON=taxonomy.retrieve_destinations();
        int count=0;//todo remove this
        for(Taxonomy_Destinations_Data dest :taxonomy_destinations_APIJSON.getData()) {

            leaf_node_Dest=true;
            for (Taxonomy_Destinations_Data d : taxonomy_destinations_APIJSON.getData()){
                if(dest.getDestinationId()==d.getParentId()) {
                    leaf_node_Dest = false;
                    break;
                }
            }
            /**
             * If a destination it's a leaf retrieve all its products and store in DB.
             */
            if(leaf_node_Dest) {
                /** Get product summary*/
                products_by_destination_POST.setDestId(dest.getDestinationId());
                products_by_destIDSeoID_APIJSON = product_API_DAO.search_products(products_by_destination_POST, products_by_attraction_POST, true);
                time_elapsed=System.currentTimeMillis();
                count++;
               // if(count>1000)//todo remove this
                 //   break;

                if (products_by_destIDSeoID_APIJSON.isSuccess()) {
                    for (int i = 0; i < products_by_destIDSeoID_APIJSON.getData().size(); i++) {

                        productDetailsBean.setCode(products_by_destIDSeoID_APIJSON.getData().get(i).getCode());
                        /** Get product's details*/

                        time_elapsed=System.currentTimeMillis()-time_elapsed;
//                        if(670-time_elapsed>0) {
//                            try {
//                                Thread.sleep(670 - time_elapsed);
//                            } catch (InterruptedException ex) {
//                                Thread.currentThread().interrupt();
//                            }
//                        }

                        Product_Detailed_Info_APIJSON product_detailed_info_APIJSON=product_API_DAO.product_detailed_info(productDetailsBean.getCode(),"EUR",false,false);
                        time_elapsed=System.currentTimeMillis();


                        productDetailsBean.setPrimaryDestinationId(product_detailed_info_APIJSON.getData().getPrimaryDestinationId());
                        productDetailsBean.setDestinationId(product_detailed_info_APIJSON.getData().getDestinationId());
                        productDetailsBean.setPrimaryCategoryId(product_detailed_info_APIJSON.getData().getPrimaryGroupId());
                        productDetailsBean.setSupplierCode(product_detailed_info_APIJSON.getData().getSupplierCode());
                        productDetailsBean.setBookingEngineId(product_detailed_info_APIJSON.getData().getBookingEngineId());
                        productDetailsBean.setTitleEn(product_detailed_info_APIJSON.getData().getTitle());
                        productDetailsBean.setShortTitleEn(product_detailed_info_APIJSON.getData().getShortTitle());
                        productDetailsBean.setHighlightsEn(product_detailed_info_APIJSON.getData().getHighlights());
                        productDetailsBean.setPrimaryDestinationNameEn(product_detailed_info_APIJSON.getData().getPrimaryDestinationName());
                        productDetailsBean.setLocationEn(product_detailed_info_APIJSON.getData().getLocation());
                        productDetailsBean.setCityEn(product_detailed_info_APIJSON.getData().getCity());
                        productDetailsBean.setCountryEn(product_detailed_info_APIJSON.getData().getCountry());
                        productDetailsBean.setRegionEn(product_detailed_info_APIJSON.getData().getRegion());
                        productDetailsBean.setDeparturePoint(product_detailed_info_APIJSON.getData().getDeparturePoint());
                        productDetailsBean.setOperatesEn(product_detailed_info_APIJSON.getData().getOperates());
                        productDetailsBean.setReturnDetails(product_detailed_info_APIJSON.getData().getReturnDetails());
                        productDetailsBean.setShortDescriptionEn(product_detailed_info_APIJSON.getData().getShortDescription());
                        productDetailsBean.setDescriptionEn(product_detailed_info_APIJSON.getData().getDescription());
                        productDetailsBean.setVoucherRequirementsEn(product_detailed_info_APIJSON.getData().getVoucherRequirements());
                        productDetailsBean.setDuration(product_detailed_info_APIJSON.getData().getDuration());
                        productDetailsBean.setThumbnailUrl(product_detailed_info_APIJSON.getData().getThumbnailURL());
                        productDetailsBean.setThumbnailHiResUrl(product_detailed_info_APIJSON.getData().getThumbnailHiResURL());
                        productDetailsBean.setWebUrl(product_detailed_info_APIJSON.getData().getWebURL());
                        productDetailsBean.setCurrencyCode(product_detailed_info_APIJSON.getData().getCurrencyCode());
                        productDetailsBean.setPrice(product_detailed_info_APIJSON.getData().getPrice());
                        productDetailsBean.setRrp(product_detailed_info_APIJSON.getData().getRrp());
                        productDetailsBean.setMerchantNetPriceFrom(product_detailed_info_APIJSON.getData().getMerchantNetPriceFrom());
                        productDetailsBean.setSavingAmount(product_detailed_info_APIJSON.getData().getSavingAmount());
                        productDetailsBean.setRating(product_detailed_info_APIJSON.getData().getRating());
                        productDetailsBean.setVoucherOption(product_detailed_info_APIJSON.getData().getVoucherOption());
                        productDetailsBean.setDepartureTimeEn(product_detailed_info_APIJSON.getData().getDepartureTime());
                        productDetailsBean.setDepartureTimeCommentsEn(product_detailed_info_APIJSON.getData().getDepartureTimeComments());
                        productDetailsBean.setOnRequestPeriod(product_detailed_info_APIJSON.getData().getOnRequestPeriod());
                        productDetailsBean.setSupplierName(product_detailed_info_APIJSON.getData().getSupplierName());
                        productDetailsBean.setSpecialReservation(product_detailed_info_APIJSON.getData().isSpecialReservation());
                        productDetailsBean.setSpecialReservationDetails(product_detailed_info_APIJSON.getData().getSpecialReservationDetails());
                        productDetailsBean.setItineraryEn(product_detailed_info_APIJSON.getData().getItinerary());
                        productDetailsBean.setTermsAndConditionsEn(product_detailed_info_APIJSON.getData().getTermsAndConditions());
                        productDetailsBean.setMerchantCancellable(product_detailed_info_APIJSON.getData().isMerchantCancellable());
                        productDetailsBean.setOnSale(product_detailed_info_APIJSON.getData().isOnSale());
                        productDetailsBean.setSpecialOfferAvailable(product_detailed_info_APIJSON.getData().isSpecialOfferAvailable());
                        productDetailsBean.setSpecialOfferEn(product_detailed_info_APIJSON.getData().getSpecialOffer());
                        productDetailsBean.setTourGradesAvailable(product_detailed_info_APIJSON.getData().isTourGradesAvailable());
                        productDetailsBean.setHotelPickup(product_detailed_info_APIJSON.getData().isHotelPickup());
                        productDetailsBean.setVideoCount(product_detailed_info_APIJSON.getData().getVideoCount());
                        productDetailsBean.setPanoramaCount(product_detailed_info_APIJSON.getData().getPanoramaCount());
                        productDetailsBean.setPhotoCount(product_detailed_info_APIJSON.getData().getPhotoCount());
                        productDetailsBean.setReviewCount(product_detailed_info_APIJSON.getData().getReviewCount());
                        productDetailsBean.setTranslationLevel(product_detailed_info_APIJSON.getData().getTranslationLevel());
                        productDetailsBean.setRating1Count(Integer.parseInt(product_detailed_info_APIJSON.getData().getRatingCounts().get("1").toString()));
                        productDetailsBean.setRating2Count(Integer.parseInt(product_detailed_info_APIJSON.getData().getRatingCounts().get("2").toString()));
                        productDetailsBean.setRating3Count(Integer.parseInt(product_detailed_info_APIJSON.getData().getRatingCounts().get("3").toString()));
                        productDetailsBean.setRating4Count(Integer.parseInt(product_detailed_info_APIJSON.getData().getRatingCounts().get("4").toString()));
                        productDetailsBean.setRating5Count(Integer.parseInt(product_detailed_info_APIJSON.getData().getRatingCounts().get("5").toString()));
                        productDetailsBean.setCreatedAt(new Timestamp(date.getTime()));
                        productDetailsBean.setUpdatedAt(new Timestamp(date.getTime()));

                        viator_product_details_DAO.addproduct(productDetailsBean);

                        if(product_detailed_info_APIJSON.getData().getCatIds()!=null) {
                            for (int catid : product_detailed_info_APIJSON.getData().getCatIds()) {
                                viatorproductXcategoryBean.setCategoryId(catid);
                                viatorproductXcategoryBean.setProductCode(product_detailed_info_APIJSON.getData().getCode());
                                viatorproductXcategoryBean.setCreatedAt(new Timestamp(date.getTime()));
                                viatorproductXcategoryBean.setUpdatedAt(new Timestamp(date.getTime()));

                                viator_productXcategory_DAO.addprodactXcategory(viatorproductXcategoryBean);
                            }
                        }

                        if( product_detailed_info_APIJSON.getData().getSubCatIds()!=null) {
                            for (int subcatid : product_detailed_info_APIJSON.getData().getSubCatIds()) {
                                viatorproductXsubcategoryBean.setSubcategoryId(subcatid);
                                viatorproductXsubcategoryBean.setProductCode(product_detailed_info_APIJSON.getData().getCode());
                                viatorproductXsubcategoryBean.setCreatedAt(new Timestamp(date.getTime()));
                                viatorproductXsubcategoryBean.setUpdatedAt(new Timestamp(date.getTime()));

                                viator_productXsubcategory_DAO.addprodactXsubcategory(viatorproductXsubcategoryBean);
                            }
                        }


                        if(product_detailed_info_APIJSON.getData().getUserPhotos()!=null) {
                            for (Product_Detail_userPhotos usrphotos : product_detailed_info_APIJSON.getData().getUserPhotos()) {
                                viatorproductuserphotosBean.setCaption(usrphotos.getCaption());
                                viatorproductuserphotosBean.setEditorsPick(usrphotos.isEditorsPick());
                                viatorproductuserphotosBean.setSslSupported(usrphotos.isSslSupported());
                                viatorproductuserphotosBean.setOwnerAvatarUrl(usrphotos.getOwnerAvatarURL());
                                viatorproductuserphotosBean.setOwnerCountry(usrphotos.getOwnerCountry());
                                viatorproductuserphotosBean.setOwnerId(usrphotos.getOwnerId());
                                viatorproductuserphotosBean.setOwnerName(usrphotos.getOwnerName());
                                viatorproductuserphotosBean.setPhotoHiResUrl(usrphotos.getPhotoHiResURL());
                                viatorproductuserphotosBean.setPhotoId(usrphotos.getPhotoId());
                                viatorproductuserphotosBean.setPhotoMediumResUrl(usrphotos.getPhotoMediumResURL());
                                viatorproductuserphotosBean.setPhotoUrl(usrphotos.getPhotoURL());
                                viatorproductuserphotosBean.setProductCode(usrphotos.getProductCode());
                                viatorproductuserphotosBean.setProductTitleEn(usrphotos.getProductTitle());
                                viatorproductuserphotosBean.setSortOrder(usrphotos.getSortOrder());
                                viatorproductuserphotosBean.setTitleEn(usrphotos.getTitle());
                                viatorproductuserphotosBean.setThumbnailUrl(usrphotos.getThumbnailURL());
                                viatorproductuserphotosBean.setTimeUploaded(usrphotos.getTimeUploaded());
                                viatorproductuserphotosBean.setUpdatedAt(new Timestamp(date.getTime()));
                                viatorproductuserphotosBean.setCreatedAt(new Timestamp(date.getTime()));

                                viator_productuserphotos_DAO.addproductuserphotos(viatorproductuserphotosBean);
                            }
                        }

                        if(product_detailed_info_APIJSON.getData().getReviews()!=null) {
                            for (Product_Detail_reviews review : product_detailed_info_APIJSON.getData().getReviews()) {
                                viatorproductreviewsBean.setOwnerAvatarUrl(review.getOwnerAvatarURL());
                                viatorproductreviewsBean.setOwnerCountry(review.getOwnerCountry());
                                viatorproductreviewsBean.setOwnerId(review.getOwnerId());
                                viatorproductreviewsBean.setOwnerName(review.getOwnerName());
                                viatorproductreviewsBean.setProductCode(review.getProductCode());
                                viatorproductreviewsBean.setProductTitleEn(review.getProductTitle());
                                viatorproductreviewsBean.setPublishedDate(review.getPublishedDate());
                                viatorproductreviewsBean.setRating(review.getRating());
                                viatorproductreviewsBean.setReview(review.getReview());
                                viatorproductreviewsBean.setReviewId(review.getReviewId());
                                viatorproductreviewsBean.setSortOrder(review.getSortOrder());
                                viatorproductreviewsBean.setSubmissionDate(review.getSubmissionDate());
                                viatorproductreviewsBean.setViatorFeedback(review.getViatorFeedback());
                                viatorproductreviewsBean.setViatorNotes(review.getViatorNotes());
                                viatorproductreviewsBean.setUpdatedAt(new Timestamp(date.getTime()));
                                viatorproductreviewsBean.setCreatedAt(new Timestamp(date.getTime()));

                                viator_productreviews_DAO.addproductreviews(viatorproductreviewsBean);
                            }
                        }

                        if(product_detailed_info_APIJSON.getData().getAgeBands()!=null) {
                            for (Product_Detail_ageBands ageband : product_detailed_info_APIJSON.getData().getAgeBands()) {
                                viatorproductagebandsBean.setAdult(ageband.isAdult());
                                viatorproductagebandsBean.setAgeFrom(ageband.getAgeFrom());
                                viatorproductagebandsBean.setAgeTo(ageband.getAgeTo());
                                viatorproductagebandsBean.setBandId(ageband.getBandId());
                                viatorproductagebandsBean.setCount(ageband.getCount());
                                viatorproductagebandsBean.setDescriptionEn(ageband.getDescription());
                                viatorproductagebandsBean.setPluralDescriptionEn(ageband.getPluralDescription());
                                viatorproductagebandsBean.setProductCode(product_detailed_info_APIJSON.getData().getCode());
                                viatorproductagebandsBean.setSortOrder(ageband.getSortOrder());
                                viatorproductagebandsBean.setTreatAsAdult(ageband.isTreatAsAdult());
                                viatorproductagebandsBean.setCreatedAt(new Timestamp(date.getTime()));
                                viatorproductagebandsBean.setUpdatedAt(new Timestamp(date.getTime()));

                                viator_productAgebands_DAO.addproductagebandsBean(viatorproductagebandsBean);
                            }
                        }

                        if(product_detailed_info_APIJSON.getData().getSalesPoints()!=null) {
                            for (String salespoint : product_detailed_info_APIJSON.getData().getSalesPoints()) {
                                viatorproductsalespointsBean.setProductCode(product_detailed_info_APIJSON.getData().getCode());
                                viatorproductsalespointsBean.setSalesPointEn(salespoint);
                                viatorproductsalespointsBean.setCreatedAt(new Timestamp(date.getTime()));
                                viatorproductsalespointsBean.setUpdatedAt(new Timestamp(date.getTime()));

                                viator_productsalespoints_DAO.addproductsalespointsBean(viatorproductsalespointsBean);
                            }
                        }

                        if(product_detailed_info_APIJSON.getData().getInclusions()!=null) {
                            for (String inclusion : product_detailed_info_APIJSON.getData().getInclusions()) {
                                viatorproductinclusionsBean.setProductCode(product_detailed_info_APIJSON.getData().getCode());
                                viatorproductinclusionsBean.setInclusion(inclusion);
                                viatorproductinclusionsBean.setCreatedAt(new Timestamp(date.getTime()));
                                viatorproductinclusionsBean.setUpdatedAt(new Timestamp(date.getTime()));

                                viator_productinclusions_DAO.addproductinclusions(viatorproductinclusionsBean);
                            }
                        }

                        if(product_detailed_info_APIJSON.getData().getExclusions()!=null) {
                            for (String exclusion : product_detailed_info_APIJSON.getData().getExclusions()) {
                                viatorproductexclusionsBean.setProductCode(product_detailed_info_APIJSON.getData().getCode());
                                viatorproductexclusionsBean.setExclusion(exclusion);
                                viatorproductexclusionsBean.setCreatedAt(new Timestamp(date.getTime()));
                                viatorproductexclusionsBean.setUpdatedAt(new Timestamp(date.getTime()));

                                viator_productexclusions_DAO.addproductexclusions(viatorproductexclusionsBean);
                            }
                        }

                        if(product_detailed_info_APIJSON.getData().getAdditionalInfo()!=null) {
                            for (String addinfo : product_detailed_info_APIJSON.getData().getAdditionalInfo()) {
                                viatorproductadditionalinfoBean.setProductCode(product_detailed_info_APIJSON.getData().getCode());
                                viatorproductadditionalinfoBean.setAdditionalInfo(addinfo);
                                viatorproductadditionalinfoBean.setCreatedAt(new Timestamp(date.getTime()));
                                viatorproductadditionalinfoBean.setUpdatedAt(new Timestamp(date.getTime()));

                                viator_productadditionalinfo_DAO.addproductadditionalinfo(viatorproductadditionalinfoBean);
                            }
                        }

                        if(product_detailed_info_APIJSON.getData().getProductPhotos()!=null) {
                            for (Product_Detail_productPhotos prodphoto : product_detailed_info_APIJSON.getData().getProductPhotos()) {
                                if(prodphoto.getPhotoURL()==null)
                                    break;//todo check if there is a leak of photos
                                viatorproductphotosBean.setProductCode(product_detailed_info_APIJSON.getData().getCode());
                                viatorproductphotosBean.setCaption(prodphoto.getCaption());
                                viatorproductphotosBean.setPhotoUrl(prodphoto.getPhotoURL());
                                viatorproductphotosBean.setSupplier(prodphoto.getSupplier());
                                viatorproductphotosBean.setCreatedAt(new Timestamp(date.getTime()));
                                viatorproductphotosBean.setUpdatedAt(new Timestamp(date.getTime()));

                                viator_productphotos_DAO.addproductphotos(viatorproductphotosBean);
                            }
                        }

                        if(product_detailed_info_APIJSON.getData().getTourGrades()!=null) {
                            for (Product_Detail_tourGrades tourgrade : product_detailed_info_APIJSON.getData().getTourGrades()) {
                                viatoproducttourgradesBean.setProductCode(product_detailed_info_APIJSON.getData().getCode());
                                viatoproducttourgradesBean.setCurrencyCode(tourgrade.getCurrencyCode());
                                viatoproducttourgradesBean.setDefaultLanguageCode(tourgrade.getDefaultLanguageCode());
                                viatoproducttourgradesBean.setGradeCode(tourgrade.getGradeCode());
                                viatoproducttourgradesBean.setGradeDepartureTime(tourgrade.getGradeDepartureTime());
                                viatoproducttourgradesBean.setGradeDescription(tourgrade.getGradeDescription());
                                viatoproducttourgradesBean.setGradeTitle(tourgrade.getGradeTitle());
                                viatoproducttourgradesBean.setMerchantNetPriceFrom(tourgrade.getMerchantNetPriceFrom());
                                viatoproducttourgradesBean.setPriceFrom(tourgrade.getPriceFrom());
                                viatoproducttourgradesBean.setSortOrder(tourgrade.getSortOrder());
                                viatoproducttourgradesBean.setCreatedAt(new Timestamp(date.getTime()));
                                viatoproducttourgradesBean.setUpdatedAt(new Timestamp(date.getTime()));

                                viator_producttourgrades_DAO.addproducttourgrades(viatoproducttourgradesBean);

                                if(tourgrade.getLangServices()!=null) {
                                    for (Object name : tourgrade.getLangServices().keySet()) {

                                        vproducttourgradeLangservBean.setProductCode(product_detailed_info_APIJSON.getData().getCode());
                                        vproducttourgradeLangservBean.setLanguageServiceDescription(tourgrade.getLangServices().get(name).toString());
                                        vproducttourgradeLangservBean.setLanguageCodeAndService(name.toString());
                                        vproducttourgradeLangservBean.setGradeCode(tourgrade.getGradeCode());
                                        vproducttourgradeLangservBean.setCreatedAt(new Timestamp(date.getTime()));
                                        vproducttourgradeLangservBean.setUpdatedAt(new Timestamp(date.getTime()));

                                        vproducttourgradelangserv_DAO.addproducttourgradelanguageservicesBean(vproducttourgradeLangservBean);
                                    }
                                }
                            }
                        }

                        if(product_detailed_info_APIJSON.getData().getVideos()!=null) {
                            for (Product_Detail_videos video : product_detailed_info_APIJSON.getData().getVideos()) {
                                viatorproductvideosBean.setProductCode(product_detailed_info_APIJSON.getData().getCode());
                                viatorproductvideosBean.setCaption(video.getCaption());
                                viatorproductvideosBean.setCopyright(video.getCopyright());
                                viatorproductvideosBean.setDescriptionEn(video.getDescription());
                                viatorproductvideosBean.setOwnerAvatarUrl(video.getOwnerAvatarURL());
                                viatorproductvideosBean.setOwnerCountry(video.getOwnerCountry());
                                viatorproductvideosBean.setOwnerId(video.getOwnerId());
                                viatorproductvideosBean.setOwnerName(video.getOwnerName());
                                viatorproductvideosBean.setPhotoHiResUrl(video.getPhotoHiResURL());
                                viatorproductvideosBean.setPhotoUrl(video.getPhotoURL());
                                viatorproductvideosBean.setPrivatE(video.isPrivatE());
                                viatorproductvideosBean.setProductTitleEn(video.getProductTitle());
                                viatorproductvideosBean.setShortDescriptionEn(video.getShortDescription());
                                viatorproductvideosBean.setSortOrder(video.getSortOrder());
                                viatorproductvideosBean.setSource(video.getSource());
                                viatorproductvideosBean.setThumbnailUrl(video.getThumbnailURL());
                                viatorproductvideosBean.setTitleEn(video.getTitle());
                                viatorproductvideosBean.setVideoId(video.getVideoId());
                                viatorproductvideosBean.setCreatedAt(new Timestamp(date.getTime()));
                                viatorproductvideosBean.setUpdatedAt(new Timestamp(date.getTime()));

                                viator_productvideos_DAO.addproductvideos(viatorproductvideosBean);
                            }
                        }
                    }
                }
            }
        }
    }
}
