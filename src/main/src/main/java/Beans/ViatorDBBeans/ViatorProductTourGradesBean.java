package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by George on 23/06/17.
 */
@Entity
@Table(name = "viator_product_tour_grades", schema = "develope_viator", catalog = "")
public class ViatorProductTourGradesBean {
    private int rid;
    private String productCode;
    private String gradeCode;
    private String gradeTitle;
    private String gradeDepartureTime;
    private String gradeDescription;
    private String defaultLanguageCode;
    private String currencyCode;
    private BigDecimal priceFrom;
    private BigDecimal merchantNetPriceFrom;
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
    @Column(name = "grade_code")
    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    @Basic
    @Column(name = "grade_title")
    public String getGradeTitle() {
        return gradeTitle;
    }

    public void setGradeTitle(String gradeTitle) {
        this.gradeTitle = gradeTitle;
    }

    @Basic
    @Column(name = "grade_departure_time")
    public String getGradeDepartureTime() {
        return gradeDepartureTime;
    }

    public void setGradeDepartureTime(String gradeDepartureTime) {
        this.gradeDepartureTime = gradeDepartureTime;
    }

    @Basic
    @Column(name = "grade_description")
    public String getGradeDescription() {
        return gradeDescription;
    }

    public void setGradeDescription(String gradeDescription) {
        this.gradeDescription = gradeDescription;
    }

    @Basic
    @Column(name = "default_language_code")
    public String getDefaultLanguageCode() {
        return defaultLanguageCode;
    }

    public void setDefaultLanguageCode(String defaultLanguageCode) {
        this.defaultLanguageCode = defaultLanguageCode;
    }

    @Basic
    @Column(name = "currency_code")
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Basic
    @Column(name = "price_from")
    public BigDecimal getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(BigDecimal priceFrom) {
        this.priceFrom = priceFrom;
    }

    @Basic
    @Column(name = "merchant_net_price_from")
    public BigDecimal getMerchantNetPriceFrom() {
        return merchantNetPriceFrom;
    }

    public void setMerchantNetPriceFrom(BigDecimal merchantNetPriceFrom) {
        this.merchantNetPriceFrom = merchantNetPriceFrom;
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

        ViatorProductTourGradesBean that = (ViatorProductTourGradesBean) o;

        if (rid != that.rid) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (gradeCode != null ? !gradeCode.equals(that.gradeCode) : that.gradeCode != null) return false;
        if (gradeTitle != null ? !gradeTitle.equals(that.gradeTitle) : that.gradeTitle != null) return false;
        if (gradeDepartureTime != null ? !gradeDepartureTime.equals(that.gradeDepartureTime) : that.gradeDepartureTime != null)
            return false;
        if (gradeDescription != null ? !gradeDescription.equals(that.gradeDescription) : that.gradeDescription != null)
            return false;
        if (defaultLanguageCode != null ? !defaultLanguageCode.equals(that.defaultLanguageCode) : that.defaultLanguageCode != null)
            return false;
        if (currencyCode != null ? !currencyCode.equals(that.currencyCode) : that.currencyCode != null) return false;
        if (priceFrom != null ? !priceFrom.equals(that.priceFrom) : that.priceFrom != null) return false;
        if (merchantNetPriceFrom != null ? !merchantNetPriceFrom.equals(that.merchantNetPriceFrom) : that.merchantNetPriceFrom != null)
            return false;
        if (sortOrder != null ? !sortOrder.equals(that.sortOrder) : that.sortOrder != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (gradeCode != null ? gradeCode.hashCode() : 0);
        result = 31 * result + (gradeTitle != null ? gradeTitle.hashCode() : 0);
        result = 31 * result + (gradeDepartureTime != null ? gradeDepartureTime.hashCode() : 0);
        result = 31 * result + (gradeDescription != null ? gradeDescription.hashCode() : 0);
        result = 31 * result + (defaultLanguageCode != null ? defaultLanguageCode.hashCode() : 0);
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + (priceFrom != null ? priceFrom.hashCode() : 0);
        result = 31 * result + (merchantNetPriceFrom != null ? merchantNetPriceFrom.hashCode() : 0);
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
