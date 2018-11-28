package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 24/11/2017.
 */
@Entity
@Table(name = "facility", schema = "Sunhotels", catalog = "")
public class FacilityBean {
    private int id;
    private String name;
    private int providerId;
    private String facilityId;

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
    @Column(name = "provider_id")
    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    @Basic
    @Column(name = "facility_id")
    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacilityBean that = (FacilityBean) o;

        if (id != that.id) return false;
        if (providerId != that.providerId) return false;
        if (facilityId != null ? !facilityId.equals(that.facilityId) : that.facilityId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + providerId;
        result = 31 * result + (facilityId != null ? facilityId.hashCode() : 0);
        return result;
    }
}
