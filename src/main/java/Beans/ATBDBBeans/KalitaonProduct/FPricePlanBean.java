package Beans.ATBDBBeans.KalitaonProduct;

import javax.persistence.*;

/**
 * Created by George on 14/09/2017.
 */
@Entity
@Table(name = "f_price_plan", schema = "atb_DB", catalog = "")
public class FPricePlanBean {
    private int id;
    private String productId;
    private String subId;
    private String planTitle;
    private String priceType;
    private String minParticipants;
    private String rateType;
    private String tourGradeCode;
    private String createdAt;
    private String updatedAt;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "sub_id")
    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    @Basic
    @Column(name = "plan_title")
    public String getPlanTitle() {
        return planTitle;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    @Basic
    @Column(name = "price_type")
    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    @Basic
    @Column(name = "min_participants")
    public String getMinParticipants() {
        return minParticipants;
    }

    public void setMinParticipants(String minParticipants) {
        this.minParticipants = minParticipants;
    }

    @Basic
    @Column(name = "rate_type")
    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
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
    @Column(name = "created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FPricePlanBean that = (FPricePlanBean) o;

        if (id != that.id) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (subId != null ? !subId.equals(that.subId) : that.subId != null) return false;
        if (planTitle != null ? !planTitle.equals(that.planTitle) : that.planTitle != null) return false;
        if (priceType != null ? !priceType.equals(that.priceType) : that.priceType != null) return false;
        if (minParticipants != null ? !minParticipants.equals(that.minParticipants) : that.minParticipants != null)
            return false;
        if (rateType != null ? !rateType.equals(that.rateType) : that.rateType != null) return false;
        if (tourGradeCode != null ? !tourGradeCode.equals(that.tourGradeCode) : that.tourGradeCode != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (subId != null ? subId.hashCode() : 0);
        result = 31 * result + (planTitle != null ? planTitle.hashCode() : 0);
        result = 31 * result + (priceType != null ? priceType.hashCode() : 0);
        result = 31 * result + (minParticipants != null ? minParticipants.hashCode() : 0);
        result = 31 * result + (rateType != null ? rateType.hashCode() : 0);
        result = 31 * result + (tourGradeCode != null ? tourGradeCode.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
