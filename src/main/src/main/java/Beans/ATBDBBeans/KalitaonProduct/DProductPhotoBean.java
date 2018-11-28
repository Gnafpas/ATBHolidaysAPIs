package Beans.ATBDBBeans.KalitaonProduct;

import javax.persistence.*;

/**
 * Created by George on 14/09/2017.
 */
@Entity
@Table(name = "d_product_photo", schema = "atb_DB", catalog = "")
public class DProductPhotoBean {
    private int id;
    private String productId;
    private String subId;
    private String vt;
    private String photoName;
    private String caption;
    private String mainPhoto;
    private String supplierId;
    private String atb;
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
    @Column(name = "vt")
    public String getVt() {
        return vt;
    }

    public void setVt(String vt) {
        this.vt = vt;
    }

    @Basic
    @Column(name = "photo_name")
    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
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
    @Column(name = "main_photo")
    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    @Basic
    @Column(name = "supplier_id")
    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "atb")
    public String getAtb() {
        return atb;
    }

    public void setAtb(String atb) {
        this.atb = atb;
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

        DProductPhotoBean that = (DProductPhotoBean) o;

        if (id != that.id) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (subId != null ? !subId.equals(that.subId) : that.subId != null) return false;
        if (vt != null ? !vt.equals(that.vt) : that.vt != null) return false;
        if (photoName != null ? !photoName.equals(that.photoName) : that.photoName != null) return false;
        if (caption != null ? !caption.equals(that.caption) : that.caption != null) return false;
        if (mainPhoto != null ? !mainPhoto.equals(that.mainPhoto) : that.mainPhoto != null) return false;
        if (supplierId != null ? !supplierId.equals(that.supplierId) : that.supplierId != null) return false;
        if (atb != null ? !atb.equals(that.atb) : that.atb != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (subId != null ? subId.hashCode() : 0);
        result = 31 * result + (vt != null ? vt.hashCode() : 0);
        result = 31 * result + (photoName != null ? photoName.hashCode() : 0);
        result = 31 * result + (caption != null ? caption.hashCode() : 0);
        result = 31 * result + (mainPhoto != null ? mainPhoto.hashCode() : 0);
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
        result = 31 * result + (atb != null ? atb.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
