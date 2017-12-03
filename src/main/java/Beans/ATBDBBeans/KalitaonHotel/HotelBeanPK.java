package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by George on 02/12/2017.
 */
public class HotelBeanPK implements Serializable {
    private int hotelId;
    private int providerId;

    @Column(name = "hotel_id")
    @Id
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Column(name = "provider_id")
    @Id
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

        HotelBeanPK that = (HotelBeanPK) o;

        if (hotelId != that.hotelId) return false;
        if (providerId != that.providerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hotelId;
        result = 31 * result + providerId;
        return result;
    }
}
