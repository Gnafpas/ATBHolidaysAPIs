package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 15/06/2017.
 */
@Entity
@Table(name = "viator_product_x_category", schema = "develope_viator")
public class ViatorProductXCategoryBean {
    private int rid;
    private String productCode;
    private int categoryId;
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
    @Column(name = "category_id")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

        ViatorProductXCategoryBean that = (ViatorProductXCategoryBean) o;

        if (rid != that.rid) return false;
        if (categoryId != that.categoryId) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + categoryId;
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
