package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 29/12/2017.
 */
@Entity
@Table(name = "resort", schema = "Sunhotels", catalog = "")
@IdClass(ResortBeanPK.class)
public class ResortBean {
    private int resortId;
    private int providerId;
    private String resortName;
    private int destinationId;
    private String destinationName;
    private String countryName;
    private String countryCode;

    @Id
    @Column(name = "resortId")
    public int getResortId() {
        return resortId;
    }

    public void setResortId(int resortId) {
        this.resortId = resortId;
    }

    @Id
    @Column(name = "provider_id")
    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    @Basic
    @Column(name = "resort_name")
    public String getResortName() {
        return resortName;
    }

    public void setResortName(String resortName) {
        this.resortName = resortName;
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
    @Column(name = "destination_name")
    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResortBean that = (ResortBean) o;

        if (resortId != that.resortId) return false;
        if (providerId != that.providerId) return false;
        if (destinationId != that.destinationId) return false;
        if (resortName != null ? !resortName.equals(that.resortName) : that.resortName != null) return false;
        if (destinationName != null ? !destinationName.equals(that.destinationName) : that.destinationName != null)
            return false;
        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resortId;
        result = 31 * result + providerId;
        result = 31 * result + (resortName != null ? resortName.hashCode() : 0);
        result = 31 * result + destinationId;
        result = 31 * result + (destinationName != null ? destinationName.hashCode() : 0);
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        return result;
    }
}
