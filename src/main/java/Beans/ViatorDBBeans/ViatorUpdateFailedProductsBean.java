package Beans.ViatorDBBeans;

import javax.persistence.*;

/**
 * Created by George on 08/07/2017.
 */
@Entity
@Table(name = "viator_update_failed_products", schema = "develope_viator", catalog = "")
public class ViatorUpdateFailedProductsBean {
    private int rid;
    private String failedProductCode;
    private int updateRid;
    private Integer failedProductDestid;

    @Id
    @Column(name = "rid")
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "failed_product_code")
    public String getFailedProductCode() {
        return failedProductCode;
    }

    public void setFailedProductCode(String failedProductCode) {
        this.failedProductCode = failedProductCode;
    }

    @Basic
    @Column(name = "update_rid")
    public int getUpdateRid() {
        return updateRid;
    }

    public void setUpdateRid(int updateRid) {
        this.updateRid = updateRid;
    }

    @Basic
    @Column(name = "failed_product_destid")
    public Integer getFailedProductDestid() {
        return failedProductDestid;
    }

    public void setFailedProductDestid(Integer failedProductDestid) {
        this.failedProductDestid = failedProductDestid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViatorUpdateFailedProductsBean that = (ViatorUpdateFailedProductsBean) o;

        if (rid != that.rid) return false;
        if (updateRid != that.updateRid) return false;
        if (failedProductCode != null ? !failedProductCode.equals(that.failedProductCode) : that.failedProductCode != null)
            return false;
        if (failedProductDestid != null ? !failedProductDestid.equals(that.failedProductDestid) : that.failedProductDestid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (failedProductCode != null ? failedProductCode.hashCode() : 0);
        result = 31 * result + updateRid;
        result = 31 * result + (failedProductDestid != null ? failedProductDestid.hashCode() : 0);
        return result;
    }
}
