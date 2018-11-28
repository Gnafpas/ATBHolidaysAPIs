package Beans.ATBDBBeans.KalitaonProduct;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 14/09/2017.
 */
@Entity
@Table(name = "h_stopsale_date", schema = "atb_DB", catalog = "")
public class HStopsaleDateBean {
    private int id;
    private String productId;
    private String planId;
    private String availableId;
    private Timestamp stopDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "plan_id")
    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @Basic
    @Column(name = "available_id")
    public String getAvailableId() {
        return availableId;
    }

    public void setAvailableId(String availableId) {
        this.availableId = availableId;
    }

    @Basic
    @Column(name = "stop_date")
    public Timestamp getStopDate() {
        return stopDate;
    }

    public void setStopDate(Timestamp stopDate) {
        this.stopDate = stopDate;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
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

        HStopsaleDateBean that = (HStopsaleDateBean) o;

        if (id != that.id) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (planId != null ? !planId.equals(that.planId) : that.planId != null) return false;
        if (availableId != null ? !availableId.equals(that.availableId) : that.availableId != null) return false;
        if (stopDate != null ? !stopDate.equals(that.stopDate) : that.stopDate != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (planId != null ? planId.hashCode() : 0);
        result = 31 * result + (availableId != null ? availableId.hashCode() : 0);
        result = 31 * result + (stopDate != null ? stopDate.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
