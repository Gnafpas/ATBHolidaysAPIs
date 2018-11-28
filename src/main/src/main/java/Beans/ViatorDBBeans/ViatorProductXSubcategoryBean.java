package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 20/06/17.
 */
@Entity
@Table(name = "viator_product_x_subcategory", schema = "develope_viator", catalog = "")
public class ViatorProductXSubcategoryBean {
    private int rid;
    private String productCode;
    private int subcategoryId;
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
    @Column(name = "subcategory_id")
    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
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

        ViatorProductXSubcategoryBean that = (ViatorProductXSubcategoryBean) o;

        if (rid != that.rid) return false;
        if (subcategoryId != that.subcategoryId) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + subcategoryId;
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
