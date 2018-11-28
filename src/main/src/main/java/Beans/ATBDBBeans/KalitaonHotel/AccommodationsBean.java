package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 10/03/2018.
 */
@Entity
@Table(name = "accommodations", schema = "Sunhotels", catalog = "")
public class AccommodationsBean {
    private int id;
    private String accommodationId;
    private String name;
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
    @Column(name = "accommodation_id")
    public String getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(String accommodationId) {
        this.accommodationId = accommodationId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccommodationsBean that = (AccommodationsBean) o;

        if (id != that.id) return false;
        if (providerId != that.providerId) return false;
        if (accommodationId != null ? !accommodationId.equals(that.accommodationId) : that.accommodationId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (accommodationId != null ? accommodationId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + providerId;
        return result;
    }
}
