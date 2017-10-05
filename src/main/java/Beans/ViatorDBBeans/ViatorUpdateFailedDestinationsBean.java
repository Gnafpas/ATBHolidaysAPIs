package Beans.ViatorDBBeans;

import javax.persistence.*;

/**
 * Created by George on 08/07/2017.
 */
@Entity
@Table(name = "viator_update_failed_destinations", schema = "develope_viator", catalog = "")
public class ViatorUpdateFailedDestinationsBean {
    private int rid;
    private Integer failedDestination;
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
    @Column(name = "failed_destination")
    public Integer getFailedDestination() {
        return failedDestination;
    }

    public void setFailedDestination(Integer failedDestination) {
        this.failedDestination = failedDestination;
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

        ViatorUpdateFailedDestinationsBean that = (ViatorUpdateFailedDestinationsBean) o;

        if (rid != that.rid) return false;
        if (updateRid != that.updateRid) return false;
        if (failedDestination != null ? !failedDestination.equals(that.failedDestination) : that.failedDestination != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (failedDestination != null ? failedDestination.hashCode() : 0);
        result = 31 * result + updateRid;
        return result;
    }
}
