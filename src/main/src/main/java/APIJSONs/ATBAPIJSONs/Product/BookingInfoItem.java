package APIJSONs.ATBAPIJSONs.Product;

import Beans.ATBDBBeans.KalitaonSystem.TravellerInfoBean;
import Beans.ViatorAPIBeans.Bookings.Book.BookingQuestionAnswer;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by George on 02/03/2018.
 */
public class BookingInfoItem {
    private String hotelId;
    private String pickupPoint;
    private String travelDate;
    private String productId;
    private String planId;
    private String language;
    private String serviceOption;
    private List<TravellerInfoBean> Travellers;
    private String city;
    private String country;
    private  String currencyCode;
    private  String departurePoint;
    private String itemId;
    private String pickupHotelId;
    private BigDecimal price;
    private String bookingStatus;

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getPickupHotelId() {
        return pickupHotelId;
    }

    public void setPickupHotelId(String pickupHotelId) {
        this.pickupHotelId = pickupHotelId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(String pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getServiceOption() {
        return serviceOption;
    }

    public void setServiceOption(String serviceOption) {
        this.serviceOption = serviceOption;
    }

    public List<TravellerInfoBean> getTravellers() {
        return Travellers;
    }

    public void setTravellers(List<TravellerInfoBean> travellers) {
        Travellers = travellers;
    }
}
