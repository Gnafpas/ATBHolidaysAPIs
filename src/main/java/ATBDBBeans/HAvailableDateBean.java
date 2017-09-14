package ATBDBBeans;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by George on 14/09/2017.
 */
@Entity
@Table(name = "h_available_date", schema = "atb_DB", catalog = "")
public class HAvailableDateBean {
    private int id;
    private String productId;
    private String planId;
    private String availableTitle;
    private String availableTimeType;
    private String departimeOnOff;
    private Date startDate;
    private Date endDate;
    private Date createdAt;
    private Date updatedAt;

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
    @Column(name = "available_title")
    public String getAvailableTitle() {
        return availableTitle;
    }

    public void setAvailableTitle(String availableTitle) {
        this.availableTitle = availableTitle;
    }

    @Basic
    @Column(name = "available_time_type")
    public String getAvailableTimeType() {
        return availableTimeType;
    }

    public void setAvailableTimeType(String availableTimeType) {
        this.availableTimeType = availableTimeType;
    }

    @Basic
    @Column(name = "departime_on_off")
    public String getDepartimeOnOff() {
        return departimeOnOff;
    }

    public void setDepartimeOnOff(String departimeOnOff) {
        this.departimeOnOff = departimeOnOff;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HAvailableDateBean that = (HAvailableDateBean) o;

        if (id != that.id) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (planId != null ? !planId.equals(that.planId) : that.planId != null) return false;
        if (availableTitle != null ? !availableTitle.equals(that.availableTitle) : that.availableTitle != null)
            return false;
        if (availableTimeType != null ? !availableTimeType.equals(that.availableTimeType) : that.availableTimeType != null)
            return false;
        if (departimeOnOff != null ? !departimeOnOff.equals(that.departimeOnOff) : that.departimeOnOff != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (planId != null ? planId.hashCode() : 0);
        result = 31 * result + (availableTitle != null ? availableTitle.hashCode() : 0);
        result = 31 * result + (availableTimeType != null ? availableTimeType.hashCode() : 0);
        result = 31 * result + (departimeOnOff != null ? departimeOnOff.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
