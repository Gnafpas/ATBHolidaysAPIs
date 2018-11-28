package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 24/11/2017.
 */
@Entity
@Table(name = "destination", schema = "Sunhotels", catalog = "")
public class DestinationBean {
    private int id;
    private String name;
    private int destinationId;
    private String hotelBedsCode;
    private String travelXGateCode;
    private int providerRef;
    private String countryName;
    private String countryCode;
    private String timezone;
    private Integer providerId;//todo dbusage from mehmet:﻿destinations ,photo, hotel mapping , hotel, hotel facility tables
    private int sortOrder;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "destination_id")
    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    @Basic
    @Column(name = "hotel_beds_code")
    public String getHotelBedsCode() {
        return hotelBedsCode;
    }

    public void setHotelBedsCode(String hotelBedsCode) {
        this.hotelBedsCode = hotelBedsCode;
    }

    @Basic
    @Column(name = "travel_x_gate_code")
    public String getTravelXGateCode() {
        return travelXGateCode;
    }

    public void setTravelXGateCode(String travelXGateCode) {
        this.travelXGateCode = travelXGateCode;
    }

    @Basic
    @Column(name = "provider_ref")
    public int getProviderRef() {
        return providerRef;
    }

    public void setProviderRef(int providerRef) {
        this.providerRef = providerRef;
    }

    @Basic
    @Column(name = "country_name")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
    @Column(name = "timezone")
    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Basic
    @Column(name = "provider_id")
    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    @Basic
    @Column(name = "sort_order")
    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DestinationBean that = (DestinationBean) o;

        if (id != that.id) return false;
        if (destinationId != that.destinationId) return false;
        if (providerRef != that.providerRef) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (timezone != null ? !timezone.equals(that.timezone) : that.timezone != null) return false;
        if (providerId != null ? !providerId.equals(that.providerId) : that.providerId != null) return false;
        if (sortOrder != that.sortOrder) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + destinationId;
        result = 31 * result + providerRef;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (timezone != null ? timezone.hashCode() : 0);
        result = 31 * result + (providerId != null ? providerId.hashCode() : 0);
        result = 31 * result + sortOrder;
        return result;
    }
}
