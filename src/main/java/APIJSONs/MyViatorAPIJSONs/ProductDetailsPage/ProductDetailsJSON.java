package APIJSONs.MyViatorAPIJSONs.ProductDetailsPage;

import Beans.ViatorDBBeans.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 13/07/2017.
 */
public class ProductDetailsJSON {
    private List<ViatorPickupHotelsBean> pickupHotels;
    private List<ViatorProductAdditionalInfoBean> additionalInfo;
    private List<ViatorProductAgeBandsBean> ageBands;
    private List<ViatorProductDetailsBean> details;
    private List<ViatorProductExclusionsBean> exclusions;
    private List<ViatorProductInclusionsBean> inclusions;
    private List<ViatorProductPhotosBean> photos;
    private List<ViatorProductReviewsBean> reviews;
    private List<ViatorProductSalesPointsBean> salesPoints;
    private List<TourGrade> tourGrades=new ArrayList<>();
    private List<ViatorProductUserPhotosBean> userPhotos;
    private List<ViatorProductVideosBean> videos;
    private List<Category> productCategories=new ArrayList<>();
    private boolean DBError=false;

    public boolean isDBError() {
        return DBError;
    }

    public void setDBError(boolean DBError) {
        this.DBError = DBError;
    }

    public List<Category> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<Category> productCategories) {
        this.productCategories = productCategories;
    }

    public List<ViatorPickupHotelsBean> getPickupHotels() {
        return pickupHotels;
    }

    public void setPickupHotels(List<ViatorPickupHotelsBean> pickupHotels) {
        this.pickupHotels = pickupHotels;
    }

    public List<ViatorProductAdditionalInfoBean> getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(List<ViatorProductAdditionalInfoBean> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public List<ViatorProductAgeBandsBean> getAgeBands() {
        return ageBands;
    }

    public void setAgeBands(List<ViatorProductAgeBandsBean> ageBands) {
        this.ageBands = ageBands;
    }

    public List<ViatorProductDetailsBean> getDetails() {
        return details;
    }

    public void setDetails(List<ViatorProductDetailsBean> details) {
        this.details = details;
    }

    public List<ViatorProductExclusionsBean> getExclusions() {
        return exclusions;
    }

    public void setExclusions(List<ViatorProductExclusionsBean> exclusions) {
        this.exclusions = exclusions;
    }

    public List<ViatorProductInclusionsBean> getInclusions() {
        return inclusions;
    }

    public void setInclusions(List<ViatorProductInclusionsBean> inclusions) {
        this.inclusions = inclusions;
    }

    public List<ViatorProductPhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<ViatorProductPhotosBean> photos) {
        this.photos = photos;
    }

    public List<ViatorProductReviewsBean> getReviews() {
        return reviews;
    }

    public void setReviews(List<ViatorProductReviewsBean> reviews) {
        this.reviews = reviews;
    }

    public List<ViatorProductSalesPointsBean> getSalesPoints() {
        return salesPoints;
    }

    public void setSalesPoints(List<ViatorProductSalesPointsBean> salesPoints) {
        this.salesPoints = salesPoints;
    }

    public List<TourGrade> getTourGrades() {
        return tourGrades;
    }

    public void setTourGrades(List<TourGrade> tourGrades) {
        this.tourGrades = tourGrades;
    }

    public List<ViatorProductUserPhotosBean> getUserPhotos() {
        return userPhotos;
    }

    public void setUserPhotos(List<ViatorProductUserPhotosBean> userPhotos) {
        this.userPhotos = userPhotos;
    }

    public List<ViatorProductVideosBean> getVideos() {
        return videos;
    }

    public void setVideos(List<ViatorProductVideosBean> videos) {
        this.videos = videos;
    }
}
