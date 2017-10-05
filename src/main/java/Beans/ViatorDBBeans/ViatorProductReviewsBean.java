package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 20/06/17.
 */
@Entity
@Table(name = "viator_product_reviews", schema = "develope_viator", catalog = "")
public class ViatorProductReviewsBean {
    private int rid;
    private String productCode;
    private Integer reviewId;
    private Integer rating;
    private String review;
    private String productTitleEn;
    private String viatorFeedback;
    private String viatorNotes;
    private String submissionDate;
    private String publishedDate;
    private Integer ownerId;
    private String ownerName;
    private String ownerCountry;
    private String ownerAvatarUrl;
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
    @Column(name = "review_id")
    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    @Basic
    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "review")
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Basic
    @Column(name = "product_title_EN")
    public String getProductTitleEn() {
        return productTitleEn;
    }

    public void setProductTitleEn(String productTitleEn) {
        this.productTitleEn = productTitleEn;
    }

    @Basic
    @Column(name = "viator_feedback")
    public String getViatorFeedback() {
        return viatorFeedback;
    }

    public void setViatorFeedback(String viatorFeedback) {
        this.viatorFeedback = viatorFeedback;
    }

    @Basic
    @Column(name = "viator_notes")
    public String getViatorNotes() {
        return viatorNotes;
    }

    public void setViatorNotes(String viatorNotes) {
        this.viatorNotes = viatorNotes;
    }

    @Basic
    @Column(name = "submission_date")
    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Basic
    @Column(name = "published_date")
    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Basic
    @Column(name = "owner_id")
    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "owner_name")
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Basic
    @Column(name = "owner_country")
    public String getOwnerCountry() {
        return ownerCountry;
    }

    public void setOwnerCountry(String ownerCountry) {
        this.ownerCountry = ownerCountry;
    }

    @Basic
    @Column(name = "owner_avatar_URL")
    public String getOwnerAvatarUrl() {
        return ownerAvatarUrl;
    }

    public void setOwnerAvatarUrl(String ownerAvatarUrl) {
        this.ownerAvatarUrl = ownerAvatarUrl;
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

        ViatorProductReviewsBean that = (ViatorProductReviewsBean) o;

        if (rid != that.rid) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (reviewId != null ? !reviewId.equals(that.reviewId) : that.reviewId != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (review != null ? !review.equals(that.review) : that.review != null) return false;
        if (productTitleEn != null ? !productTitleEn.equals(that.productTitleEn) : that.productTitleEn != null)
            return false;
        if (viatorFeedback != null ? !viatorFeedback.equals(that.viatorFeedback) : that.viatorFeedback != null)
            return false;
        if (viatorNotes != null ? !viatorNotes.equals(that.viatorNotes) : that.viatorNotes != null) return false;
        if (submissionDate != null ? !submissionDate.equals(that.submissionDate) : that.submissionDate != null)
            return false;
        if (publishedDate != null ? !publishedDate.equals(that.publishedDate) : that.publishedDate != null)
            return false;
        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;
        if (ownerName != null ? !ownerName.equals(that.ownerName) : that.ownerName != null) return false;
        if (ownerCountry != null ? !ownerCountry.equals(that.ownerCountry) : that.ownerCountry != null) return false;
        if (ownerAvatarUrl != null ? !ownerAvatarUrl.equals(that.ownerAvatarUrl) : that.ownerAvatarUrl != null)
            return false;
        if (sortOrder != null ? !sortOrder.equals(that.sortOrder) : that.sortOrder != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (reviewId != null ? reviewId.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + (productTitleEn != null ? productTitleEn.hashCode() : 0);
        result = 31 * result + (viatorFeedback != null ? viatorFeedback.hashCode() : 0);
        result = 31 * result + (viatorNotes != null ? viatorNotes.hashCode() : 0);
        result = 31 * result + (submissionDate != null ? submissionDate.hashCode() : 0);
        result = 31 * result + (publishedDate != null ? publishedDate.hashCode() : 0);
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (ownerName != null ? ownerName.hashCode() : 0);
        result = 31 * result + (ownerCountry != null ? ownerCountry.hashCode() : 0);
        result = 31 * result + (ownerAvatarUrl != null ? ownerAvatarUrl.hashCode() : 0);
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
