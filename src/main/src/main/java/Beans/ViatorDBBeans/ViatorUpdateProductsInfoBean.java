package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 10/07/2017.
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
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    private boolean viatorError;
    private String viatoErrorInfo;
    private boolean dbCommError;
    private Integer dbCommErrorsCounter;

    @Id
    @GeneratedValue
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
    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }

    @Basic
    @Column(name = "end_date_time")
    public Timestamp getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Timestamp endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Basic
    @Column(name = "viator_error")
    public boolean getViatorError() {
        return viatorError;
    }

    public void setViatorError(boolean viatorError) {
        this.viatorError = viatorError;
    }

    @Basic
    @Column(name = "viato_error_Info")
    public String getViatoErrorInfo() {
        return viatoErrorInfo;
    }

    public void setViatoErrorInfo(String viatoErrorInfo) {
        this.viatoErrorInfo = viatoErrorInfo;
    }

    @Basic
    @Column(name = "db_comm_error")
    public boolean getDbCommError() {
        return dbCommError;
    }

    public void setDbCommError(boolean dbCommError) {
        this.dbCommError = dbCommError;
    }

    @Basic
    @Column(name = "db_comm_errors_Counter")
    public Integer getDbCommErrorsCounter() {
        return dbCommErrorsCounter;
    }

    public void setDbCommErrorsCounter(Integer dbCommErrorsCounter) {
        this.dbCommErrorsCounter = dbCommErrorsCounter;
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
        if (viatorError != that.viatorError) return false;
        if (viatoErrorInfo != null ? !viatoErrorInfo.equals(that.viatoErrorInfo) : that.viatoErrorInfo != null)
            return false;
        if (dbCommError != that.dbCommError) return false;
        if (dbCommErrorsCounter != null ? !dbCommErrorsCounter.equals(that.dbCommErrorsCounter) : that.dbCommErrorsCounter != null)
            return false;

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
        result = 31 * result + help(viatorError);
        result = 31 * result + (viatoErrorInfo != null ? viatoErrorInfo.hashCode() : 0);
        result = 31 * result + help(dbCommError);
        result = 31 * result + (dbCommErrorsCounter != null ? dbCommErrorsCounter.hashCode() : 0);
        return result;
    }

    private int help(boolean attribute){
        if(attribute){return 1;}else{return 0;}
    }
}
