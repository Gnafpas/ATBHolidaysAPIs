package APIJSONs.ATBAPIJSONs.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by George on 14/02/2018.
 */
public class ResponseItem {

    private String pickupHotelId;
    private String pickupHotelName;
    private String pickupPoint;
    private String travelDate;
    private String productId;
    private String planId;
    private String language;
    private String serviceOption;
    private List<Traveller> Travellers;
    private BigDecimal price;
    private String productTitle;
    private String merchantCancellable;
    private String supplierName;
    private String supplierPhoneNumber;
    private String planIdDescription;
    private String itemId;
    private String country;
    private String city;
    private String departurePoint;
    private String departurePointAddress;
    private String bookingEngineId;
    private String currencyCode;
    private String departsFrom;
    private boolean bookedSuccesfully=true;

    public boolean isBookedSuccesfully() {
        return bookedSuccesfully;
    }

    public void setBookedSuccesfully(boolean bookedSuccesfully) {
        this.bookedSuccesfully = bookedSuccesfully;
    }

    public String getPickupHotelId() {
        return pickupHotelId;
    }

    public void setPickupHotelId(String pickupHotelId) {
        this.pickupHotelId = pickupHotelId;
    }

    public String getPickupHotelName() {
        return pickupHotelName;
    }

    public void setPickupHotelName(String pickupHotelName) {
        this.pickupHotelName = pickupHotelName;
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

    public List<Traveller> getTravellers() {
        return Travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        Travellers = travellers;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getMerchantCancellable() {
        return merchantCancellable;
    }

    public void setMerchantCancellable(String merchantCancellable) {
        this.merchantCancellable = merchantCancellable;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierPhoneNumber() {
        return supplierPhoneNumber;
    }

    public void setSupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
    }

    public String getPlanIdDescription() {
        return planIdDescription;
    }

    public void setPlanIdDescription(String planIdDescription) {
        this.planIdDescription = planIdDescription;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getDeparturePointAddress() {
        return departurePointAddress;
    }

    public void setDeparturePointAddress(String departurePointAddress) {
        this.departurePointAddress = departurePointAddress;
    }

    public String getBookingEngineId() {
        return bookingEngineId;
    }

    public void setBookingEngineId(String bookingEngineId) {
        this.bookingEngineId = bookingEngineId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDepartsFrom() {
        return departsFrom;
    }

    public void setDepartsFrom(String departsFrom) {
        this.departsFrom = departsFrom;
    }
}
