package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 23/06/17.
 */
@Entity
@Table(name = "viator_product_exclusions", schema = "develope_viator", catalog = "")
public class ViatorProductExclusionsBean {
    private int rid;
    private String productCode;
    private String exclusion;
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
    @Column(name = "exclusion")
    public String getExclusion() {
        return exclusion;
    }

    public void setExclusion(String exclusion) {
        this.exclusion = exclusion;
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

        ViatorProductExclusionsBean that = (ViatorProductExclusionsBean) o;

        if (rid != that.rid) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (exclusion != null ? !exclusion.equals(that.exclusion) : that.exclusion != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (exclusion != null ? exclusion.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
