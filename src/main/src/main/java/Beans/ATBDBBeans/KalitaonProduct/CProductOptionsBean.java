package Beans.ATBDBBeans.KalitaonProduct;

import javax.persistence.*;

/**
 * Created by George on 14/09/2017.
 */
@Entity
@Table(name = "c_product_options", schema = "atb_DB", catalog = "")
public class CProductOptionsBean {
    private int id;
    private String productId;
    private String guidingLive;
    private String guidingAudio;
    private String guidingBooklets;
    private String duration;
    private String validy;
    private String minConfirmationTime;
    private String privateOption;
    private String typeOfPricing;
    private String availabilityTime;
    private String customerDetailRequest;
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
    @Column(name = "guiding_live")
    public String getGuidingLive() {
        return guidingLive;
    }

    public void setGuidingLive(String guidingLive) {
        this.guidingLive = guidingLive;
    }

    @Basic
    @Column(name = "guiding_audio")
    public String getGuidingAudio() {
        return guidingAudio;
    }

    public void setGuidingAudio(String guidingAudio) {
        this.guidingAudio = guidingAudio;
    }

    @Basic
    @Column(name = "guiding_booklets")
    public String getGuidingBooklets() {
        return guidingBooklets;
    }

    public void setGuidingBooklets(String guidingBooklets) {
        this.guidingBooklets = guidingBooklets;
    }

    @Basic
    @Column(name = "duration")
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "validy")
    public String getValidy() {
        return validy;
    }

    public void setValidy(String validy) {
        this.validy = validy;
    }

    @Basic
    @Column(name = "min_confirmation_time")
    public String getMinConfirmationTime() {
        return minConfirmationTime;
    }

    public void setMinConfirmationTime(String minConfirmationTime) {
        this.minConfirmationTime = minConfirmationTime;
    }

    @Basic
    @Column(name = "private_option")
    public String getPrivateOption() {
        return privateOption;
    }

    public void setPrivateOption(String privateOption) {
        this.privateOption = privateOption;
    }

    @Basic
    @Column(name = "type_of_pricing")
    public String getTypeOfPricing() {
        return typeOfPricing;
    }

    public void setTypeOfPricing(String typeOfPricing) {
        this.typeOfPricing = typeOfPricing;
    }

    @Basic
    @Column(name = "availability_time")
    public String getAvailabilityTime() {
        return availabilityTime;
    }

    public void setAvailabilityTime(String availabilityTime) {
        this.availabilityTime = availabilityTime;
    }

    @Basic
    @Column(name = "customer_detail_request")
    public String getCustomerDetailRequest() {
        return customerDetailRequest;
    }

    public void setCustomerDetailRequest(String customerDetailRequest) {
        this.customerDetailRequest = customerDetailRequest;
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

        CProductOptionsBean that = (CProductOptionsBean) o;

        if (id != that.id) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (guidingLive != null ? !guidingLive.equals(that.guidingLive) : that.guidingLive != null) return false;
        if (guidingAudio != null ? !guidingAudio.equals(that.guidingAudio) : that.guidingAudio != null) return false;
        if (guidingBooklets != null ? !guidingBooklets.equals(that.guidingBooklets) : that.guidingBooklets != null)
            return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (validy != null ? !validy.equals(that.validy) : that.validy != null) return false;
        if (minConfirmationTime != null ? !minConfirmationTime.equals(that.minConfirmationTime) : that.minConfirmationTime != null)
            return false;
        if (privateOption != null ? !privateOption.equals(that.privateOption) : that.privateOption != null)
            return false;
        if (typeOfPricing != null ? !typeOfPricing.equals(that.typeOfPricing) : that.typeOfPricing != null)
            return false;
        if (availabilityTime != null ? !availabilityTime.equals(that.availabilityTime) : that.availabilityTime != null)
            return false;
        if (customerDetailRequest != null ? !customerDetailRequest.equals(that.customerDetailRequest) : that.customerDetailRequest != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (guidingLive != null ? guidingLive.hashCode() : 0);
        result = 31 * result + (guidingAudio != null ? guidingAudio.hashCode() : 0);
        result = 31 * result + (guidingBooklets != null ? guidingBooklets.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (validy != null ? validy.hashCode() : 0);
        result = 31 * result + (minConfirmationTime != null ? minConfirmationTime.hashCode() : 0);
        result = 31 * result + (privateOption != null ? privateOption.hashCode() : 0);
        result = 31 * result + (typeOfPricing != null ? typeOfPricing.hashCode() : 0);
        result = 31 * result + (availabilityTime != null ? availabilityTime.hashCode() : 0);
        result = 31 * result + (customerDetailRequest != null ? customerDetailRequest.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
