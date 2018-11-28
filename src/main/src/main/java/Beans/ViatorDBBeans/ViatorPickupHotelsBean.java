package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by George on 12/07/2017.
 */
@Entity
@Table(name = "viator_pickup_hotels", schema = "develope_viator", catalog = "")
public class ViatorPickupHotelsBean {
    private int rid;
    private String productCode;
    private String hotelId;
    private Integer destinationId;
    private String hotelName;
    private String brand;
    private String hotelString;
    private String address;
    private String postCode;
    private String cityName;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String phone;
    private String notes;
    private int sortOrder;
    private Timestamp updatedAt;

    @Id
    @Column(name = "rid")
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "hotel_id")
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "destination_id")
    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    @Basic
    @Column(name = "hotel_name")
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "hotel_string")
    public String getHotelString() {
        return hotelString;
    }

    public void setHotelString(String hotelString) {
        this.hotelString = hotelString;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "post_code")
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Basic
    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Basic
    @Column(name = "latitude")
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "sort_order")
    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViatorPickupHotelsBean that = (ViatorPickupHotelsBean) o;

        if (rid != that.rid) return false;
        if (sortOrder != that.sortOrder) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (destinationId != null ? !destinationId.equals(that.destinationId) : that.destinationId != null)
            return false;
        if (hotelName != null ? !hotelName.equals(that.hotelName) : that.hotelName != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (hotelString != null ? !hotelString.equals(that.hotelString) : that.hotelString != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (postCode != null ? !postCode.equals(that.postCode) : that.postCode != null) return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (destinationId != null ? destinationId.hashCode() : 0);
        result = 31 * result + (hotelName != null ? hotelName.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (hotelString != null ? hotelString.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + sortOrder;
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
