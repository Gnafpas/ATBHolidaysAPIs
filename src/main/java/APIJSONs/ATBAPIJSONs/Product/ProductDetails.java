package APIJSONs.ATBAPIJSONs.Product;

import Beans.ATBDBBeans.KalitaonProduct.*;

import java.util.List;

/**
 * Created by George on 23/10/2017.
 */
public class ProductDetails {
    private List<AProductTitleBean> productTitle;
    private List<BProductDetailBean> productDetails;
    private List<CProductOptionsBean> productOptions;
    private List<DProductPhotoBean> productPhotos;
    private List<EPickupPointBean> pickupPoints;
    private List<FPricePlanBean> pricePlans;
    private List<JProductQuestionsBean> bookingQuestions;

    public List<AProductTitleBean> getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(List<AProductTitleBean> productTitle) {
        this.productTitle = productTitle;
    }

    public List<BProductDetailBean> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<BProductDetailBean> productDetails) {
        this.productDetails = productDetails;
    }

    public List<CProductOptionsBean> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(List<CProductOptionsBean> productOptions) {
        this.productOptions = productOptions;
    }

    public List<DProductPhotoBean> getProductPhotos() {
        return productPhotos;
    }

    public void setProductPhotos(List<DProductPhotoBean> productPhotos) {
        this.productPhotos = productPhotos;
    }

    public List<EPickupPointBean> getPickupPoints() {
        return pickupPoints;
    }

    public void setPickupPoints(List<EPickupPointBean> pickupPoints) {
        this.pickupPoints = pickupPoints;
    }

    public List<FPricePlanBean> getPricePlans() {
        return pricePlans;
    }

    public void setPricePlans(List<FPricePlanBean> pricePlans) {
        this.pricePlans = pricePlans;
    }

    public List<JProductQuestionsBean> getBookingQuestions() {
        return bookingQuestions;
    }

    public void setBookingQuestions(List<JProductQuestionsBean> bookingQuestions) {
        this.bookingQuestions = bookingQuestions;
    }
}
