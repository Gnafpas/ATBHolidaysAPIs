package Beans.ViatorDBBeans;

import javax.persistence.*;

/**
 * Created by George on 03/10/2017.
 */
@Entity
@Table(name = "atb_update_failed_product", schema = "develope_viator", catalog = "")
public class AtbUpdateFailedProductBean {
    private int rid;
    private String failedProductCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AtbUpdateFailedProductBean that = (AtbUpdateFailedProductBean) o;

        if (rid != that.rid) return false;
        if (updateRid != that.updateRid) return false;
        if (failedProductCode != null ? !failedProductCode.equals(that.failedProductCode) : that.failedProductCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (failedProductCode != null ? failedProductCode.hashCode() : 0);
        result = 31 * result + updateRid;
        return result;
    }
}
