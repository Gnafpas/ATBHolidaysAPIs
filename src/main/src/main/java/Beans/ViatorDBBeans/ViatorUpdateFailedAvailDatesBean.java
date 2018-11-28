package Beans.ViatorDBBeans;

import javax.persistence.*;

/**
 * Created by George on 08/07/2017.
 */
@Entity
@Table(name = "viator_update_failed_availDates", schema = "develope_viator", catalog = "")
public class ViatorUpdateFailedAvailDatesBean {
    private int rid;
    private String productWithFailedAvailDates;
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
    @Column(name = "product_with_failed_AvailDates")
    public String getProductWithFailedAvailDates() {
        return productWithFailedAvailDates;
    }

    public void setProductWithFailedAvailDates(String productWithFailedAvailDates) {
        this.productWithFailedAvailDates = productWithFailedAvailDates;
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

        ViatorUpdateFailedAvailDatesBean that = (ViatorUpdateFailedAvailDatesBean) o;

        if (rid != that.rid) return false;
        if (updateRid != that.updateRid) return false;
        if (productWithFailedAvailDates != null ? !productWithFailedAvailDates.equals(that.productWithFailedAvailDates) : that.productWithFailedAvailDates != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (productWithFailedAvailDates != null ? productWithFailedAvailDates.hashCode() : 0);
        result = 31 * result + updateRid;
        return result;
    }
}
