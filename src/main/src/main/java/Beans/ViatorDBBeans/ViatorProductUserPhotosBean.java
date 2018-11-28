package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 20/06/17.
 */
@Entity
@Table(name = "viator_product_user_photos", schema = "develope_viator", catalog = "")
public class ViatorProductUserPhotosBean {
    private int rid;
    private String productCode;
    private Integer photoId;
    private String photoUrl;
    private String caption;
    private String titleEn;
    private String productTitleEn;
    private String thumbnailUrl;
    private String photoHiResUrl;
    private String photoMediumResUrl;
    private String timeUploaded;
    private boolean editorsPick;
    private Integer ownerId;
    private String ownerName;
    private String ownerCountry;
    private String ownerAvatarUrl;
    private Integer sortOrder;
    private boolean sslSupported;
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
    @Column(name = "photo_id")
    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    @Basic
    @Column(name = "photo_URL")
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Basic
    @Column(name = "caption")
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Basic
    @Column(name = "title_EN")
    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
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
    @Column(name = "thumbnail_URL")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Basic
    @Column(name = "photo_hi_res_URL")
    public String getPhotoHiResUrl() {
        return photoHiResUrl;
    }

    public void setPhotoHiResUrl(String photoHiResUrl) {
        this.photoHiResUrl = photoHiResUrl;
    }

    @Basic
    @Column(name = "photo_medium_res_URL")
    public String getPhotoMediumResUrl() {
        return photoMediumResUrl;
    }

    public void setPhotoMediumResUrl(String photoMediumResUrl) {
        this.photoMediumResUrl = photoMediumResUrl;
    }

    @Basic
    @Column(name = "time_uploaded")
    public String getTimeUploaded() {
        return timeUploaded;
    }

    public void setTimeUploaded(String timeUploaded) {
        this.timeUploaded = timeUploaded;
    }

    @Basic
    @Column(name = "editors_pick")
    public boolean getEditorsPick() {
        return editorsPick;
    }

    public void setEditorsPick(boolean editorsPick) {
        this.editorsPick = editorsPick;
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
    @Column(name = "sslSupported")
    public boolean getSslSupported() {
        return sslSupported;
    }

    public void setSslSupported(boolean sslSupported) {
        this.sslSupported = sslSupported;
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

        ViatorProductUserPhotosBean that = (ViatorProductUserPhotosBean) o;

        if (rid != that.rid) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (photoId != null ? !photoId.equals(that.photoId) : that.photoId != null) return false;
        if (photoUrl != null ? !photoUrl.equals(that.photoUrl) : that.photoUrl != null) return false;
        if (caption != null ? !caption.equals(that.caption) : that.caption != null) return false;
        if (titleEn != null ? !titleEn.equals(that.titleEn) : that.titleEn != null) return false;
        if (productTitleEn != null ? !productTitleEn.equals(that.productTitleEn) : that.productTitleEn != null)
            return false;
        if (thumbnailUrl != null ? !thumbnailUrl.equals(that.thumbnailUrl) : that.thumbnailUrl != null) return false;
        if (photoHiResUrl != null ? !photoHiResUrl.equals(that.photoHiResUrl) : that.photoHiResUrl != null)
            return false;
        if (photoMediumResUrl != null ? !photoMediumResUrl.equals(that.photoMediumResUrl) : that.photoMediumResUrl != null)
            return false;
        if (timeUploaded != null ? !timeUploaded.equals(that.timeUploaded) : that.timeUploaded != null) return false;
        if (editorsPick != that.editorsPick) return false;
        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;
        if (ownerName != null ? !ownerName.equals(that.ownerName) : that.ownerName != null) return false;
        if (ownerCountry != null ? !ownerCountry.equals(that.ownerCountry) : that.ownerCountry != null) return false;
        if (ownerAvatarUrl != null ? !ownerAvatarUrl.equals(that.ownerAvatarUrl) : that.ownerAvatarUrl != null)
            return false;
        if (sortOrder != null ? !sortOrder.equals(that.sortOrder) : that.sortOrder != null) return false;
        if (sslSupported != that.sslSupported) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (photoId != null ? photoId.hashCode() : 0);
        result = 31 * result + (photoUrl != null ? photoUrl.hashCode() : 0);
        result = 31 * result + (caption != null ? caption.hashCode() : 0);
        result = 31 * result + (titleEn != null ? titleEn.hashCode() : 0);
        result = 31 * result + (productTitleEn != null ? productTitleEn.hashCode() : 0);
        result = 31 * result + (thumbnailUrl != null ? thumbnailUrl.hashCode() : 0);
        result = 31 * result + (photoHiResUrl != null ? photoHiResUrl.hashCode() : 0);
        result = 31 * result + (photoMediumResUrl != null ? photoMediumResUrl.hashCode() : 0);
        result = 31 * result + (timeUploaded != null ? timeUploaded.hashCode() : 0);
        result = 31 * result +  help(editorsPick);
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (ownerName != null ? ownerName.hashCode() : 0);
        result = 31 * result + (ownerCountry != null ? ownerCountry.hashCode() : 0);
        result = 31 * result + (ownerAvatarUrl != null ? ownerAvatarUrl.hashCode() : 0);
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        result = 31 * result + help(sslSupported);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    private int help(boolean attribute){
        if(attribute){return 1;}else{return 0;}
    }
}
