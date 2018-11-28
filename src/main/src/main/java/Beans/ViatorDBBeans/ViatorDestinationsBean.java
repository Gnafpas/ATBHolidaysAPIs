package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by George on 30/06/2017.
 */
@Entity
@Table(name = "viator_destinations", schema = "develope_viator", catalog = "")
public class ViatorDestinationsBean {
    private int destinationId;
    private Integer parentId;
    private String lookupId;
    private String destinationType;
    private String destinationNameEn;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String timeZone;
    private String iataCode;
    private String defaultCurrencyCode;
    private boolean selectable;
    private Integer sortOrder;
    private String destinationUrlName;
    private Timestamp updatedAt;

    @Id
    @Column(name = "destination_id")
    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    @Basic
    @Column(name = "parent_id")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "lookup_id")
    public String getLookupId() {
        return lookupId;
    }

    public void setLookupId(String lookupId) {
        this.lookupId = lookupId;
    }

    @Basic
    @Column(name = "destination_type")
    public String getDestinationType() {
        return destinationType;
    }

    public void setDestinationType(String destinationType) {
        this.destinationType = destinationType;
    }

    @Basic
    @Column(name = "destination_name_EN")
    public String getDestinationNameEn() {
        return destinationNameEn;
    }

    public void setDestinationNameEn(String destinationNameEn) {
        this.destinationNameEn = destinationNameEn;
    }

    @Basic
    @Column(name = "latitude")
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "time_zone")
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Basic
    @Column(name = "iata_code")
    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    @Basic
    @Column(name = "default_currency_code")
    public String getDefaultCurrencyCode() {
        return defaultCurrencyCode;
    }

    public void setDefaultCurrencyCode(String defaultCurrencyCode) {
        this.defaultCurrencyCode = defaultCurrencyCode;
    }

    @Basic
    @Column(name = "selectable")
    public boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    @Basic
    @Column(name = "sort_order")
    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Basic
    @Column(name = "destination_Url_Name")
    public String getDestinationUrlName() {
        return destinationUrlName;
    }

    public void setDestinationUrlName(String destinationUrlName) {
        this.destinationUrlName = destinationUrlName;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViatorDestinationsBean that = (ViatorDestinationsBean) o;

        if (destinationId != that.destinationId) return false;
        if (selectable != that.selectable) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (lookupId != null ? !lookupId.equals(that.lookupId) : that.lookupId != null) return false;
        if (destinationType != null ? !destinationType.equals(that.destinationType) : that.destinationType != null)
            return false;
        if (destinationNameEn != null ? !destinationNameEn.equals(that.destinationNameEn) : that.destinationNameEn != null)
            return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (timeZone != null ? !timeZone.equals(that.timeZone) : that.timeZone != null) return false;
        if (iataCode != null ? !iataCode.equals(that.iataCode) : that.iataCode != null) return false;
        if (defaultCurrencyCode != null ? !defaultCurrencyCode.equals(that.defaultCurrencyCode) : that.defaultCurrencyCode != null)
            return false;
        if (sortOrder != null ? !sortOrder.equals(that.sortOrder) : that.sortOrder != null) return false;
        if (destinationUrlName != null ? !destinationUrlName.equals(that.destinationUrlName) : that.destinationUrlName != null)
            return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = destinationId;
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (lookupId != null ? lookupId.hashCode() : 0);
        result = 31 * result + (destinationType != null ? destinationType.hashCode() : 0);
        result = 31 * result + (destinationNameEn != null ? destinationNameEn.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (timeZone != null ? timeZone.hashCode() : 0);
        result = 31 * result + (iataCode != null ? iataCode.hashCode() : 0);
        result = 31 * result + (defaultCurrencyCode != null ? defaultCurrencyCode.hashCode() : 0);
        result = 31 * result + help(selectable);
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        result = 31 * result + (destinationUrlName != null ? destinationUrlName.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    private int help(boolean attribute){
        if(attribute){return 1;}else{return 0;}
    }
}
