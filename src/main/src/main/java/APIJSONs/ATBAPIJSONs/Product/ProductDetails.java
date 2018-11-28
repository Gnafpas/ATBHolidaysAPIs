package APIJSONs.ATBAPIJSONs.Product;

import Beans.ATBDBBeans.KalitaonProduct.*;

import java.util.List;

/**
 * Created by George on 23/10/2017.
 */
public class ProductDetails {
    private List<Product> productTitle;
    private List<ProductMoreDetails> productDetails;
    private List<ProductOptions> productOptions;
    private List<Photo> productPhotos;
    private List<PickupPoint> pickupPoints;
    private List<PricePlan> pricePlans;
    private List<BookingQuestion> bookingQuestions;

    public List<Product> getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(List<Product> productTitle) {
        this.productTitle = productTitle;
    }

    public List<ProductMoreDetails> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductMoreDetails> productDetails) {
        this.productDetails = productDetails;
    }

    public List<ProductOptions> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(List<ProductOptions> productOptions) {
        this.productOptions = productOptions;
    }

    public List<Photo> getProductPhotos() {
        return productPhotos;
    }

    public void setProductPhotos(List<Photo> productPhotos) {
        this.productPhotos = productPhotos;
    }

    public List<PricePlan> getPricePlans() {
        return pricePlans;
    }

    public void setPricePlans(List<PricePlan> pricePlans) {
        this.pricePlans = pricePlans;
    }

    public List<BookingQuestion> getBookingQuestions() {
        return bookingQuestions;
    }

    public void setBookingQuestions(List<BookingQuestion> bookingQuestions) {
        this.bookingQuestions = bookingQuestions;
    }

    public List<PickupPoint> getPickupPoints() {
        return pickupPoints;
    }

    public void setPickupPoints(List<PickupPoint> pickupPoints) {
        this.pickupPoints = pickupPoints;
    }
}
