package Beans.ATBDBBeans.KalitaonProduct;

import javax.persistence.*;

/**
 * Created by George on 05/10/2017.
 */
@Entity
@Table(name = "supplier_photo_path", schema = "atb_DB", catalog = "")
public class SupplierPhotoPathBean {
    private int id;
    private String supplierId;
    private String photoPath;
    private String photoPathThumb;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "photo_path")
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Basic
    @Column(name = "photo_path_thumb")
    public String getPhotoPathThumb() {
        return photoPathThumb;
    }

    public void setPhotoPathThumb(String photoPathThumb) {
        this.photoPathThumb = photoPathThumb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplierPhotoPathBean that = (SupplierPhotoPathBean) o;

        if (id != that.id) return false;
        if (supplierId != null ? !supplierId.equals(that.supplierId) : that.supplierId != null) return false;
        if (photoPath != null ? !photoPath.equals(that.photoPath) : that.photoPath != null) return false;
        if (photoPathThumb != null ? !photoPathThumb.equals(that.photoPathThumb) : that.photoPathThumb != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
        result = 31 * result + (photoPath != null ? photoPath.hashCode() : 0);
        result = 31 * result + (photoPathThumb != null ? photoPathThumb.hashCode() : 0);
        return result;
    }
}
