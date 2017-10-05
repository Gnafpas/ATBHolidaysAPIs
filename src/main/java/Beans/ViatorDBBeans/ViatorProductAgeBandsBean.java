package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 20/06/17.
 */
@Entity
@Table(name = "viator_product_age_bands", schema = "develope_viator", catalog = "")
public class ViatorProductAgeBandsBean {
    private int rid;
    private String productCode;
    private int bandId;
    private Integer ageFrom;
    private Integer ageTo;
    private boolean adult;
    private boolean treatAsAdult;
    private String descriptionEn;
    private String pluralDescriptionEn;
    private Integer count;
    private Integer sortOrder;
    private Timestamp updatedAt;

    @Id
    @Column(name = "rid")
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "band_id")
    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    @Basic
    @Column(name = "age_from")
    public Integer getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(Integer ageFrom) {
        this.ageFrom = ageFrom;
    }

    @Basic
    @Column(name = "age_to")
    public Integer getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(Integer ageTo) {
        this.ageTo = ageTo;
    }

    @Basic
    @Column(name = "adult")
    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    @Basic
    @Column(name = "treat_as_adult")
    public boolean getTreatAsAdult() {
        return treatAsAdult;
    }

    public void setTreatAsAdult(boolean treatAsAdult) {
        this.treatAsAdult = treatAsAdult;
    }

    @Basic
    @Column(name = "description_EN")
    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    @Basic
    @Column(name = "plural_description_EN")
    public String getPluralDescriptionEn() {
        return pluralDescriptionEn;
    }

    public void setPluralDescriptionEn(String pluralDescriptionEn) {
        this.pluralDescriptionEn = pluralDescriptionEn;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

        ViatorProductAgeBandsBean that = (ViatorProductAgeBandsBean) o;

        if (rid != that.rid) return false;
        if (bandId != that.bandId) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (ageFrom != null ? !ageFrom.equals(that.ageFrom) : that.ageFrom != null) return false;
        if (ageTo != null ? !ageTo.equals(that.ageTo) : that.ageTo != null) return false;
        if (adult != that.adult) return false;
        if (treatAsAdult != that.treatAsAdult) return false;
        if (descriptionEn != null ? !descriptionEn.equals(that.descriptionEn) : that.descriptionEn != null)
            return false;
        if (pluralDescriptionEn != null ? !pluralDescriptionEn.equals(that.pluralDescriptionEn) : that.pluralDescriptionEn != null)
            return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (sortOrder != null ? !sortOrder.equals(that.sortOrder) : that.sortOrder != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + bandId;
        result = 31 * result + (ageFrom != null ? ageFrom.hashCode() : 0);
        result = 31 * result + (ageTo != null ? ageTo.hashCode() : 0);
        result = 31 * result + help(adult);
        result = 31 * result + help(treatAsAdult);
        result = 31 * result + (descriptionEn != null ? descriptionEn.hashCode() : 0);
        result = 31 * result + (pluralDescriptionEn != null ? pluralDescriptionEn.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    private int help(boolean attribute){
        if(attribute){return 1;}else{return 0;}
    }
}
