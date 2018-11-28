package Beans.ATBDBBeans.KalitaonProduct;

import javax.persistence.*;

/**
 * Created by George on 14/09/2017.
 */
@Entity
@Table(name = "b_product_detail", schema = "atb_DB", catalog = "")
public class BProductDetailBean {
    private int id;
    private String productId;
    private String descriptionSummary;
    private String categories;
    private String highlight;
    private String productDetail;
    private String inclusions;
    private String exclusions;
    private String cancellationPolicy;
    private String adittionalInfo;
    private String voucherInfo;
    private String voucherCountryCode;
    private String voucherTelephone;
    private String mobileAccess;
    private String merchantCancellable;
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
    @Column(name = "description_summary")
    public String getDescriptionSummary() {
        return descriptionSummary;
    }

    public void setDescriptionSummary(String descriptionSummary) {
        this.descriptionSummary = descriptionSummary;
    }

    @Basic
    @Column(name = "categories")
    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @Basic
    @Column(name = "highlight")
    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    @Basic
    @Column(name = "product_detail")
    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    @Basic
    @Column(name = "inclusions")
    public String getInclusions() {
        return inclusions;
    }

    public void setInclusions(String inclusions) {
        this.inclusions = inclusions;
    }

    @Basic
    @Column(name = "exclusions")
    public String getExclusions() {
        return exclusions;
    }

    public void setExclusions(String exclusions) {
        this.exclusions = exclusions;
    }

    @Basic
    @Column(name = "cancellation_policy")
    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    @Basic
    @Column(name = "adittional_info")
    public String getAdittionalInfo() {
        return adittionalInfo;
    }

    public void setAdittionalInfo(String adittionalInfo) {
        this.adittionalInfo = adittionalInfo;
    }

    @Basic
    @Column(name = "voucher_info")
    public String getVoucherInfo() {
        return voucherInfo;
    }

    public void setVoucherInfo(String voucherInfo) {
        this.voucherInfo = voucherInfo;
    }

    @Basic
    @Column(name = "voucher_country_code")
    public String getVoucherCountryCode() {
        return voucherCountryCode;
    }

    public void setVoucherCountryCode(String voucherCountryCode) {
        this.voucherCountryCode = voucherCountryCode;
    }

    @Basic
    @Column(name = "voucher_telephone")
    public String getVoucherTelephone() {
        return voucherTelephone;
    }

    public void setVoucherTelephone(String voucherTelephone) {
        this.voucherTelephone = voucherTelephone;
    }

    @Basic
    @Column(name = "mobile_access")
    public String getMobileAccess() {
        return mobileAccess;
    }

    public void setMobileAccess(String mobileAccess) {
        this.mobileAccess = mobileAccess;
    }

    @Basic
    @Column(name = "merchant_cancellable")
    public String getMerchantCancellable() {
        return merchantCancellable;
    }

    public void setMerchantCancellable(String merchantCancellable) {
        this.merchantCancellable = merchantCancellable;
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

        BProductDetailBean that = (BProductDetailBean) o;

        if (id != that.id) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (descriptionSummary != null ? !descriptionSummary.equals(that.descriptionSummary) : that.descriptionSummary != null)
            return false;
        if (categories != null ? !categories.equals(that.categories) : that.categories != null) return false;
        if (highlight != null ? !highlight.equals(that.highlight) : that.highlight != null) return false;
        if (productDetail != null ? !productDetail.equals(that.productDetail) : that.productDetail != null)
            return false;
        if (inclusions != null ? !inclusions.equals(that.inclusions) : that.inclusions != null) return false;
        if (exclusions != null ? !exclusions.equals(that.exclusions) : that.exclusions != null) return false;
        if (cancellationPolicy != null ? !cancellationPolicy.equals(that.cancellationPolicy) : that.cancellationPolicy != null)
            return false;
        if (adittionalInfo != null ? !adittionalInfo.equals(that.adittionalInfo) : that.adittionalInfo != null)
            return false;
        if (voucherInfo != null ? !voucherInfo.equals(that.voucherInfo) : that.voucherInfo != null) return false;
        if (voucherCountryCode != null ? !voucherCountryCode.equals(that.voucherCountryCode) : that.voucherCountryCode != null)
            return false;
        if (voucherTelephone != null ? !voucherTelephone.equals(that.voucherTelephone) : that.voucherTelephone != null)
            return false;
        if (mobileAccess != null ? !mobileAccess.equals(that.mobileAccess) : that.mobileAccess != null) return false;
        if (merchantCancellable != null ? !merchantCancellable.equals(that.merchantCancellable) : that.merchantCancellable != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (descriptionSummary != null ? descriptionSummary.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (highlight != null ? highlight.hashCode() : 0);
        result = 31 * result + (productDetail != null ? productDetail.hashCode() : 0);
        result = 31 * result + (inclusions != null ? inclusions.hashCode() : 0);
        result = 31 * result + (exclusions != null ? exclusions.hashCode() : 0);
        result = 31 * result + (cancellationPolicy != null ? cancellationPolicy.hashCode() : 0);
        result = 31 * result + (adittionalInfo != null ? adittionalInfo.hashCode() : 0);
        result = 31 * result + (voucherInfo != null ? voucherInfo.hashCode() : 0);
        result = 31 * result + (voucherCountryCode != null ? voucherCountryCode.hashCode() : 0);
        result = 31 * result + (voucherTelephone != null ? voucherTelephone.hashCode() : 0);
        result = 31 * result + (mobileAccess != null ? mobileAccess.hashCode() : 0);
        result = 31 * result + (merchantCancellable != null ? merchantCancellable.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
