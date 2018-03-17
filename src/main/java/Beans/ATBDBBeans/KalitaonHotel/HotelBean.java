package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 02/12/2017.
 */
@Entity
@Table(name = "hotel", schema = "Sunhotels", catalog = "")
@IdClass(HotelBeanPK.class)
public class HotelBean {
    private int hotelId;
    private String name;
    private String description;
    private String mealType;
    private boolean active;
    private String starRating;
    private String district;
    private String city;
    private String state;
    private String country;
    private String countryCode;
    private String address;
    private String zipCode;
    private String mapUrl;
    private Integer providerRef;
    private String latitude;
    private String longitude;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer currencyId;
    private String destinationId;
    private String accommodationId;
    private String accommodationName;
    private int providerId;
    private int resortId;

    @Id
    @Column(name = "hotel_id")
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "resort_id")
    public int getResortId() {
        return resortId;
    }

    public void setResortId(int resortId) {
        this.resortId = resortId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "meal_type")
    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    @Basic
    @Column(name = "active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "star_rating")
    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    @Basic
    @Column(name = "district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "country_code")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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
    @Column(name = "zip_code")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "map_url")
    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    @Basic
    @Column(name = "provider_ref")
    public Integer getProviderRef() {
        return providerRef;
    }

    public void setProviderRef(Integer providerRef) {
        this.providerRef = providerRef;
    }

    @Basic
    @Column(name = "latitude")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "currency_id")
    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    @Basic
    @Column(name = "destination_id")
    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    @Basic
    @Column(name = "accommodation_id")
    public String getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(String accommodationId) {
        this.accommodationId = accommodationId;
    }

    @Basic
    @Column(name = "accommodation_name")
    public String getAccommodationName() {
        return accommodationName;
    }

    public void setAccommodationName(String accommodationName) {
        this.accommodationName = accommodationName;
    }

    @Basic
    @Column(name = "provider_id")
    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelBean hotelBean = (HotelBean) o;

        if (hotelId != hotelBean.hotelId) return false;
        if (active != hotelBean.active) return false;
        if (providerId != hotelBean.providerId) return false;
        if (resortId != hotelBean.resortId) return false;
        if (name != null ? !name.equals(hotelBean.name) : hotelBean.name != null) return false;
        if (description != null ? !description.equals(hotelBean.description) : hotelBean.description != null)
            return false;
        if (mealType != null ? !mealType.equals(hotelBean.mealType) : hotelBean.mealType != null) return false;
        if (starRating != null ? !starRating.equals(hotelBean.starRating) : hotelBean.starRating != null) return false;
        if (district != null ? !district.equals(hotelBean.district) : hotelBean.district != null) return false;
        if (city != null ? !city.equals(hotelBean.city) : hotelBean.city != null) return false;
        if (state != null ? !state.equals(hotelBean.state) : hotelBean.state != null) return false;
        if (country != null ? !country.equals(hotelBean.country) : hotelBean.country != null) return false;
        if (countryCode != null ? !countryCode.equals(hotelBean.countryCode) : hotelBean.countryCode != null)
            return false;
        if (address != null ? !address.equals(hotelBean.address) : hotelBean.address != null) return false;
        if (zipCode != null ? !zipCode.equals(hotelBean.zipCode) : hotelBean.zipCode != null) return false;
        if (mapUrl != null ? !mapUrl.equals(hotelBean.mapUrl) : hotelBean.mapUrl != null) return false;
        if (providerRef != null ? !providerRef.equals(hotelBean.providerRef) : hotelBean.providerRef != null)
            return false;
        if (latitude != null ? !latitude.equals(hotelBean.latitude) : hotelBean.latitude != null) return false;
        if (longitude != null ? !longitude.equals(hotelBean.longitude) : hotelBean.longitude != null) return false;
        if (createdAt != null ? !createdAt.equals(hotelBean.createdAt) : hotelBean.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(hotelBean.updatedAt) : hotelBean.updatedAt != null) return false;
        if (currencyId != null ? !currencyId.equals(hotelBean.currencyId) : hotelBean.currencyId != null) return false;
        if (destinationId != null ? !destinationId.equals(hotelBean.destinationId) : hotelBean.destinationId != null)
            return false;
        if (accommodationId != null ? !accommodationId.equals(hotelBean.accommodationId) : hotelBean.accommodationId != null) return false;
        if (accommodationName != null ? !accommodationName.equals(hotelBean.accommodationName) : hotelBean.accommodationName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hotelId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (mealType != null ? mealType.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (starRating != null ? starRating.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (mapUrl != null ? mapUrl.hashCode() : 0);
        result = 31 * result + (providerRef != null ? providerRef.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (currencyId != null ? currencyId.hashCode() : 0);
        result = 31 * result + (destinationId != null ? destinationId.hashCode() : 0);
        result = 31 * result + (accommodationId != null ? accommodationId.hashCode() : 0);
        result = 31 * result + (accommodationName != null ? accommodationName.hashCode() : 0);
        result = 31 * result + providerId;
        result = 31 * result + resortId;
        return result;
    }
}
