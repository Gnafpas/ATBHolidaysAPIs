package Beans.ViatorAPIBeans.Bookings.PickupHotel;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by George on 12/07/2017.
 */
public class PickupHotel {
    private  int sortOrder;
    private  int destinationId;
    private  String phone;
    private  List<String> productCodes;
    private  String notes;
    private  String city;
    private  String postcode;
    private  String brand;
    private  String hotelString;
    private  BigDecimal latitude;
    private  BigDecimal longitude;
    private  String address;
    private  String name;
    private  String id;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getProductCodes() {
        return productCodes;
    }

    public void setProductCodes(List<String> productCodes) {
        this.productCodes = productCodes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getHotelString() {
        return hotelString;
    }

    public void setHotelString(String hotelString) {
        this.hotelString = hotelString;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
