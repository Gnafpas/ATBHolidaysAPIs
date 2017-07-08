package DBBeans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

/**
 * Created by George on 08/07/2017.
 */
@Entity
@Table(name = "viator_update_products_info", schema = "develope_viator", catalog = "")
public class ViatorUpdateProductsInfoBean {
    private int rid;
    private Integer totalLeafNodes;
    private Integer totalProducts;
    private Integer lastLeaDestid;
    private Integer totalExpiredProducts;
    private Long totalRocessSleep;
    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;

    @Id
    @Column(name = "rid")
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "total_leaf_nodes")
    public Integer getTotalLeafNodes() {
        return totalLeafNodes;
    }

    public void setTotalLeafNodes(Integer totalLeafNodes) {
        this.totalLeafNodes = totalLeafNodes;
    }

    @Basic
    @Column(name = "total_products")
    public Integer getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }

    @Basic
    @Column(name = "last_lea_destid")
    public Integer getLastLeaDestid() {
        return lastLeaDestid;
    }

    public void setLastLeaDestid(Integer lastLeaDestid) {
        this.lastLeaDestid = lastLeaDestid;
    }

    @Basic
    @Column(name = "total_expired_products")
    public Integer getTotalExpiredProducts() {
        return totalExpiredProducts;
    }

    public void setTotalExpiredProducts(Integer totalExpiredProducts) {
        this.totalExpiredProducts = totalExpiredProducts;
    }

    @Basic
    @Column(name = "total_rocess_sleep")
    public Long getTotalRocessSleep() {
        return totalRocessSleep;
    }

    public void setTotalRocessSleep(Long totalRocessSleep) {
        this.totalRocessSleep = totalRocessSleep;
    }

    @Basic
    @Column(name = "start_date_time")
    public ZonedDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(ZonedDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    @Basic
    @Column(name = "end_date_time")
    public ZonedDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(ZonedDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViatorUpdateProductsInfoBean that = (ViatorUpdateProductsInfoBean) o;

        if (rid != that.rid) return false;
        if (totalLeafNodes != null ? !totalLeafNodes.equals(that.totalLeafNodes) : that.totalLeafNodes != null)
            return false;
        if (totalProducts != null ? !totalProducts.equals(that.totalProducts) : that.totalProducts != null)
            return false;
        if (lastLeaDestid != null ? !lastLeaDestid.equals(that.lastLeaDestid) : that.lastLeaDestid != null)
            return false;
        if (totalExpiredProducts != null ? !totalExpiredProducts.equals(that.totalExpiredProducts) : that.totalExpiredProducts != null)
            return false;
        if (totalRocessSleep != null ? !totalRocessSleep.equals(that.totalRocessSleep) : that.totalRocessSleep != null)
            return false;
        if (startDateTime != null ? !startDateTime.equals(that.startDateTime) : that.startDateTime != null)
            return false;
        if (endDateTime != null ? !endDateTime.equals(that.endDateTime) : that.endDateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (totalLeafNodes != null ? totalLeafNodes.hashCode() : 0);
        result = 31 * result + (totalProducts != null ? totalProducts.hashCode() : 0);
        result = 31 * result + (lastLeaDestid != null ? lastLeaDestid.hashCode() : 0);
        result = 31 * result + (totalExpiredProducts != null ? totalExpiredProducts.hashCode() : 0);
        result = 31 * result + (totalRocessSleep != null ? totalRocessSleep.hashCode() : 0);
        result = 31 * result + (startDateTime != null ? startDateTime.hashCode() : 0);
        result = 31 * result + (endDateTime != null ? endDateTime.hashCode() : 0);
        return result;
    }
}
