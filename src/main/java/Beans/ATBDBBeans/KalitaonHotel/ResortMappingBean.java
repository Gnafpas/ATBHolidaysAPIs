package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 29/12/2017.
 */
@Entity
@Table(name = "resort_mapping", schema = "Sunhotels", catalog = "")
public class ResortMappingBean {
    private int id;
    private int providerId;
    private String resortId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "provider_id")
    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    @Basic
    @Column(name = "resort_id")
    public String getResortId() {
        return resortId;
    }

    public void setResortId(String resortId) {
        this.resortId = resortId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResortMappingBean that = (ResortMappingBean) o;

        if (id != that.id) return false;
        if (providerId != that.providerId) return false;
        if (resortId != null ? !resortId.equals(that.resortId) : that.resortId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + providerId;
        result = 31 * result + (resortId != null ? resortId.hashCode() : 0);
        return result;
    }
}
