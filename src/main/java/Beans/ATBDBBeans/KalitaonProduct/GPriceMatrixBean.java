package Beans.ATBDBBeans.KalitaonProduct;

import javax.persistence.*;

/**
 * Created by George on 14/09/2017.
 */
@Entity
@Table(name = "g_price_matrix", schema = "atb_DB", catalog = "")
public class GPriceMatrixBean {
    private int id;
    private String productId;
    private String planId;
    private String optionTitle;
    private String personType;
    private String ageFrom;
    private String ageTo;
    private int minCountRequired;
    private int maxCountRequired;
    private String commission;
    private String priceRate;
    private String priceNet;
    private String currencyCode;
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
    @Column(name = "plan_id")
    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @Basic
    @Column(name = "option_title")
    public String getOptionTitle() {
        return optionTitle;
    }

    public void setOptionTitle(String optionTitle) {
        this.optionTitle = optionTitle;
    }

    @Basic
    @Column(name = "person_type")
    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    @Basic
    @Column(name = "age_from")
    public String getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(String ageFrom) {
        this.ageFrom = ageFrom;
    }

    @Basic
    @Column(name = "age_to")
    public String getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(String ageTo) {
        this.ageTo = ageTo;
    }

    @Basic
    @Column(name = "min_count_required")
    public int getMinCountRequired() {
        return minCountRequired;
    }

    public void setMinCountRequired(int minCountRequired) {
        this.minCountRequired = minCountRequired;
    }

    @Basic
    @Column(name = "max_count_required")
    public int getMaxCountRequired() {
        return maxCountRequired;
    }

    public void setMaxCountRequired(int maxCountRequired) {
        this.maxCountRequired = maxCountRequired;
    }

    @Basic
    @Column(name = "commission")
    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    @Basic
    @Column(name = "price_rate")
    public String getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(String priceRate) {
        this.priceRate = priceRate;
    }

    @Basic
    @Column(name = "price_net")
    public String getPriceNet() {
        return priceNet;
    }

    public void setPriceNet(String priceNet) {
        this.priceNet = priceNet;
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

        GPriceMatrixBean that = (GPriceMatrixBean) o;

        if (id != that.id) return false;
        if (minCountRequired != that.minCountRequired) return false;
        if (maxCountRequired != that.maxCountRequired) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (planId != null ? !planId.equals(that.planId) : that.planId != null) return false;
        if (optionTitle != null ? !optionTitle.equals(that.optionTitle) : that.optionTitle != null) return false;
        if (personType != null ? !personType.equals(that.personType) : that.personType != null) return false;
        if (ageFrom != null ? !ageFrom.equals(that.ageFrom) : that.ageFrom != null) return false;
        if (ageTo != null ? !ageTo.equals(that.ageTo) : that.ageTo != null) return false;
        if (commission != null ? !commission.equals(that.commission) : that.commission != null) return false;
        if (priceRate != null ? !priceRate.equals(that.priceRate) : that.priceRate != null) return false;
        if (priceNet != null ? !priceNet.equals(that.priceNet) : that.priceNet != null) return false;
        if (currencyCode != null ? !currencyCode.equals(that.currencyCode) : that.currencyCode != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (planId != null ? planId.hashCode() : 0);
        result = 31 * result + (optionTitle != null ? optionTitle.hashCode() : 0);
        result = 31 * result + (personType != null ? personType.hashCode() : 0);
        result = 31 * result + (ageFrom != null ? ageFrom.hashCode() : 0);
        result = 31 * result + (ageTo != null ? ageTo.hashCode() : 0);
        result = 31 * result + minCountRequired;
        result = 31 * result + maxCountRequired;
        result = 31 * result + (commission != null ? commission.hashCode() : 0);
        result = 31 * result + (priceRate != null ? priceRate.hashCode() : 0);
        result = 31 * result + (priceNet != null ? priceNet.hashCode() : 0);
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
