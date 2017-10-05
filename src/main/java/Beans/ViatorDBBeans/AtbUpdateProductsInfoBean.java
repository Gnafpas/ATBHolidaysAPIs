package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 03/10/2017.
 */
@Entity
@Table(name = "atb_update_products_info", schema = "develope_viator", catalog = "")
public class AtbUpdateProductsInfoBean {
    private int rid;
    private Integer totalProducts;
    private Integer totalExpiredProducts;
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    private Integer dbCommErrorsCounter;

    @Id
    @Column(name = "rid")
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
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
    @Column(name = "total_expired_products")
    public Integer getTotalExpiredProducts() {
        return totalExpiredProducts;
    }

    public void setTotalExpiredProducts(Integer totalExpiredProducts) {
        this.totalExpiredProducts = totalExpiredProducts;
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

        AtbUpdateProductsInfoBean that = (AtbUpdateProductsInfoBean) o;

        if (rid != that.rid) return false;
        if (totalProducts != null ? !totalProducts.equals(that.totalProducts) : that.totalProducts != null)
            return false;
        if (totalExpiredProducts != null ? !totalExpiredProducts.equals(that.totalExpiredProducts) : that.totalExpiredProducts != null)
            return false;
        if (startDateTime != null ? !startDateTime.equals(that.startDateTime) : that.startDateTime != null)
            return false;
        if (endDateTime != null ? !endDateTime.equals(that.endDateTime) : that.endDateTime != null) return false;
        if (dbCommErrorsCounter != null ? !dbCommErrorsCounter.equals(that.dbCommErrorsCounter) : that.dbCommErrorsCounter != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (totalProducts != null ? totalProducts.hashCode() : 0);
        result = 31 * result + (totalExpiredProducts != null ? totalExpiredProducts.hashCode() : 0);
        result = 31 * result + (startDateTime != null ? startDateTime.hashCode() : 0);
        result = 31 * result + (endDateTime != null ? endDateTime.hashCode() : 0);
        result = 31 * result + (dbCommErrorsCounter != null ? dbCommErrorsCounter.hashCode() : 0);
        return result;
    }
}
