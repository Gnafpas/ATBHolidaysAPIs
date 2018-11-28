package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by George on 19/08/2017.
 */
@Entity
@Table(name = "viator_pricing_matrix", schema = "develope_viator", catalog = "")
public class ViatorPricingMatrixBean {
    private int rid;
    private String productCode;
    private boolean callForLastMinAvailability;
    private String tourGradeCode;
    private String tourGradeTitle;
    private String pricingUnit;
    private String bookingDate;
    private int bandId;
    private int minimumCountRequired;
    private Integer maximumCountRequired;
    private int minNoOfTravellersRequiredForPrice;
    private String currencyCode;
    private BigDecimal price;
    private BigDecimal merchantNetPrice;
    private int sortOrderOfDate;
    private int sortOrderOfTourGrade;
    private int sortOrderOfPricing;
    private int sortOrderOfAgeBand;
    private int sortOrderOfPrice;
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
    @Column(name = "call_for_last_min_availability")
    public boolean isCallForLastMinAvailability() {
        return callForLastMinAvailability;
    }

    public void setCallForLastMinAvailability(boolean callForLastMinAvailability) {
        this.callForLastMinAvailability = callForLastMinAvailability;
    }

    @Basic
    @Column(name = "tour_grade_code")
    public String getTourGradeCode() {
        return tourGradeCode;
    }

    public void setTourGradeCode(String tourGradeCode) {
        this.tourGradeCode = tourGradeCode;
    }

    @Basic
    @Column(name = "tour_grade_title")
    public String getTourGradeTitle() {
        return tourGradeTitle;
    }

    public void setTourGradeTitle(String tourGradeTitle) {
        this.tourGradeTitle = tourGradeTitle;
    }

    @Basic
    @Column(name = "pricing_unit")
    public String getPricingUnit() {
        return pricingUnit;
    }

    public void setPricingUnit(String pricingUnit) {
        this.pricingUnit = pricingUnit;
    }

    @Basic
    @Column(name = "booking_date")
    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
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
    @Column(name = "minimum_count_required")
    public int getMinimumCountRequired() {
        return minimumCountRequired;
    }

    public void setMinimumCountRequired(int minimumCountRequired) {
        this.minimumCountRequired = minimumCountRequired;
    }

    @Basic
    @Column(name = "maximum_count_required")
    public Integer getMaximumCountRequired() {
        return maximumCountRequired;
    }

    public void setMaximumCountRequired(Integer maximumCountRequired) {
        this.maximumCountRequired = maximumCountRequired;
    }

    @Basic
    @Column(name = "min_no_of_travellers_required_for_price")
    public int getMinNoOfTravellersRequiredForPrice() {
        return minNoOfTravellersRequiredForPrice;
    }

    public void setMinNoOfTravellersRequiredForPrice(int minNoOfTravellersRequiredForPrice) {
        this.minNoOfTravellersRequiredForPrice = minNoOfTravellersRequiredForPrice;
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
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "merchant_net_price")
    public BigDecimal getMerchantNetPrice() {
        return merchantNetPrice;
    }

    public void setMerchantNetPrice(BigDecimal merchantNetPrice) {
        this.merchantNetPrice = merchantNetPrice;
    }

    @Basic
    @Column(name = "sort_order_of_date")
    public int getSortOrderOfDate() {
        return sortOrderOfDate;
    }

    public void setSortOrderOfDate(int sortOrderOfDate) {
        this.sortOrderOfDate = sortOrderOfDate;
    }

    @Basic
    @Column(name = "sort_order_of_tour_grade")
    public int getSortOrderOfTourGrade() {
        return sortOrderOfTourGrade;
    }

    public void setSortOrderOfTourGrade(int sortOrderOfTourGrade) {
        this.sortOrderOfTourGrade = sortOrderOfTourGrade;
    }

    @Basic
    @Column(name = "sort_order_of_pricing")
    public int getSortOrderOfPricing() {
        return sortOrderOfPricing;
    }

    public void setSortOrderOfPricing(int sortOrderOfPricing) {
        this.sortOrderOfPricing = sortOrderOfPricing;
    }

    @Basic
    @Column(name = "sort_order_of_age_band")
    public int getSortOrderOfAgeBand() {
        return sortOrderOfAgeBand;
    }

    public void setSortOrderOfAgeBand(int sortOrderOfAgeBand) {
        this.sortOrderOfAgeBand = sortOrderOfAgeBand;
    }

    @Basic
    @Column(name = "sort_order_of_price")
    public int getSortOrderOfPrice() {
        return sortOrderOfPrice;
    }

    public void setSortOrderOfPrice(int sortOrderOfPrice) {
        this.sortOrderOfPrice = sortOrderOfPrice;
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

        ViatorPricingMatrixBean that = (ViatorPricingMatrixBean) o;

        if (rid != that.rid) return false;
        if (callForLastMinAvailability != that.callForLastMinAvailability) return false;
        if (bandId != that.bandId) return false;
        if (minimumCountRequired != that.minimumCountRequired) return false;
        if (minNoOfTravellersRequiredForPrice != that.minNoOfTravellersRequiredForPrice) return false;
        if (sortOrderOfDate != that.sortOrderOfDate) return false;
        if (sortOrderOfTourGrade != that.sortOrderOfTourGrade) return false;
        if (sortOrderOfPricing != that.sortOrderOfPricing) return false;
        if (sortOrderOfAgeBand != that.sortOrderOfAgeBand) return false;
        if (sortOrderOfPrice != that.sortOrderOfPrice) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (tourGradeCode != null ? !tourGradeCode.equals(that.tourGradeCode) : that.tourGradeCode != null)
            return false;
        if (tourGradeTitle != null ? !tourGradeTitle.equals(that.tourGradeTitle) : that.tourGradeTitle != null)
            return false;
        if (pricingUnit != null ? !pricingUnit.equals(that.pricingUnit) : that.pricingUnit != null) return false;
        if (bookingDate != null ? !bookingDate.equals(that.bookingDate) : that.bookingDate != null) return false;
        if (maximumCountRequired != null ? !maximumCountRequired.equals(that.maximumCountRequired) : that.maximumCountRequired != null)
            return false;
        if (currencyCode != null ? !currencyCode.equals(that.currencyCode) : that.currencyCode != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (merchantNetPrice != null ? !merchantNetPrice.equals(that.merchantNetPrice) : that.merchantNetPrice != null)
            return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (callForLastMinAvailability ? 1 : 0);
        result = 31 * result + (tourGradeCode != null ? tourGradeCode.hashCode() : 0);
        result = 31 * result + (tourGradeTitle != null ? tourGradeTitle.hashCode() : 0);
        result = 31 * result + (pricingUnit != null ? pricingUnit.hashCode() : 0);
        result = 31 * result + (bookingDate != null ? bookingDate.hashCode() : 0);
        result = 31 * result + bandId;
        result = 31 * result + minimumCountRequired;
        result = 31 * result + (maximumCountRequired != null ? maximumCountRequired.hashCode() : 0);
        result = 31 * result + minNoOfTravellersRequiredForPrice;
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (merchantNetPrice != null ? merchantNetPrice.hashCode() : 0);
        result = 31 * result + sortOrderOfDate;
        result = 31 * result + sortOrderOfTourGrade;
        result = 31 * result + sortOrderOfPricing;
        result = 31 * result + sortOrderOfAgeBand;
        result = 31 * result + sortOrderOfPrice;
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
