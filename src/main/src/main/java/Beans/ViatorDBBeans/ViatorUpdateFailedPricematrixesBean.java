package Beans.ViatorDBBeans;

import javax.persistence.*;

/**
 * Created by George on 20/08/2017.
 */
@Entity
@Table(name = "viator_update_failed_pricematrixes", schema = "develope_viator", catalog = "")
public class ViatorUpdateFailedPricematrixesBean {
    private int rid;
    private String productWithFailedPricematrixes;
    private int updateRid;

    @Id
    @Column(name = "rid")
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "product_with_failed_Pricematrixes")
    public String getProductWithFailedPricematrixes() {
        return productWithFailedPricematrixes;
    }

    public void setProductWithFailedPricematrixes(String productWithFailedPricematrixes) {
        this.productWithFailedPricematrixes = productWithFailedPricematrixes;
    }

    @Basic
    @Column(name = "update_rid")
    public int getUpdateRid() {
        return updateRid;
    }

    public void setUpdateRid(int updateRid) {
        this.updateRid = updateRid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViatorUpdateFailedPricematrixesBean that = (ViatorUpdateFailedPricematrixesBean) o;

        if (rid != that.rid) return false;
        if (updateRid != that.updateRid) return false;
        if (productWithFailedPricematrixes != null ? !productWithFailedPricematrixes.equals(that.productWithFailedPricematrixes) : that.productWithFailedPricematrixes != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (productWithFailedPricematrixes != null ? productWithFailedPricematrixes.hashCode() : 0);
        result = 31 * result + updateRid;
        return result;
    }
}
