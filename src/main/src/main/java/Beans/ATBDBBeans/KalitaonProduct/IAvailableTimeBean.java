package Beans.ATBDBBeans.KalitaonProduct;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 14/09/2017.
 */
@Entity
@Table(name = "i_available_time", schema = "atb_DB", catalog = "")
public class IAvailableTimeBean {
    private int id;
    private String productId;
    private String planId;
    private String availableId;
    private String weekDay;
    private String startTime;
    private String endTime;
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
    @Column(name = "week_day")
    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    @Basic
    @Column(name = "start_time")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

        IAvailableTimeBean that = (IAvailableTimeBean) o;

        if (id != that.id) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (planId != null ? !planId.equals(that.planId) : that.planId != null) return false;
        if (availableId != null ? !availableId.equals(that.availableId) : that.availableId != null) return false;
        if (weekDay != null ? !weekDay.equals(that.weekDay) : that.weekDay != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
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
        result = 31 * result + (weekDay != null ? weekDay.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
