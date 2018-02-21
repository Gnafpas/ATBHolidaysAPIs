package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by George on 29/12/2017.
 */
public class ResortBeanPK implements Serializable {
    private int resortId;
    private int providerId;

    @Column(name = "resortId")
    @Id
    public int getResortId() {
        return resortId;
    }

    public void setResortId(int resortId) {
        this.resortId = resortId;
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

        ResortBeanPK that = (ResortBeanPK) o;

        if (resortId != that.resortId) return false;
        if (providerId != that.providerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resortId;
        result = 31 * result + providerId;
        return result;
    }
}
