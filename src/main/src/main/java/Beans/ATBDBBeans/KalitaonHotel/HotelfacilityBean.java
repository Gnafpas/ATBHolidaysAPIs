package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by George on 23/11/2017.
 */
@Entity
@Table(name = "hotelfacility", schema = "Sunhotels", catalog = "")
public class HotelfacilityBean {
    private int id;
    private BigDecimal price;
    private String explanation;
    private String facilityId;
    private int hotelId;
    private int providerId;

    @Basic
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "explanation")
    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Basic
    @Column(name = "facility_id")
    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    @Basic
    @Column(name = "hotel_id")
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
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

        HotelfacilityBean that = (HotelfacilityBean) o;

        if (id != that.id) return false;
        if (facilityId != null ? !facilityId.equals(that.facilityId) : that.facilityId != null) return false;
        if (hotelId != that.hotelId) return false;
        if (providerId != that.providerId) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (explanation != null ? !explanation.equals(that.explanation) : that.explanation != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (explanation != null ? explanation.hashCode() : 0);
        result = 31 * result + (facilityId != null ? facilityId.hashCode() : 0);
        result = 31 * result + hotelId;
        result = 31 * result + providerId;
        return result;
    }
}
