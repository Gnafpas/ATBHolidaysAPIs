package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 05/12/2017.
 */
@Entity
@Table(name = "hotelmapping", schema = "Sunhotels", catalog = "")
public class HotelmappingBean {
    private int id;
    private Integer providerRef;
    private Integer providerResortRef;
    private int hotelId;
    private int providerId;


    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "provider_resort_ref")
    public Integer getProviderResortRef() {
        return providerResortRef;
    }

    public void setProviderResortRef(Integer providerResortRef) {
        this.providerResortRef = providerResortRef;
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

        HotelmappingBean that = (HotelmappingBean) o;

        if (id != that.id) return false;
        if (providerRef != that.providerRef) return false;
        if (hotelId != that.hotelId) return false;
        if (providerId != that.providerId) return false;
        if (providerResortRef != null ? !providerResortRef.equals(that.providerResortRef) : that.providerResortRef != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + providerRef;
        result = 31 * result + (providerResortRef != null ? providerResortRef.hashCode() : 0);
        result = 31 * result + hotelId;
        result = 31 * result + providerId;
        return result;
    }
}
