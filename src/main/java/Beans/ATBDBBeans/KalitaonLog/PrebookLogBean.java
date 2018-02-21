package Beans.ATBDBBeans.KalitaonLog;

import javax.persistence.*;

/**
 * Created by George on 31/01/2018.
 */
@Entity
@Table(name = "prebook_log", schema = "kalitaon_search_log", catalog = "")
public class PrebookLogBean {
    private int id;
    private String prebookRef;
    private String prebookDate;
    private String hotelId;
    private String roomId;
    private String roomTypeName;
    private String mealName;
    private String price;
    private String notes;
    private String cancelPolicy;
    private String percentage;
    private String deadline;
    private String atbCancelPolicy;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "prebook_ref")
    public String getPrebookRef() {
        return prebookRef;
    }

    public void setPrebookRef(String prebookRef) {
        this.prebookRef = prebookRef;
    }

    @Basic
    @Column(name = "prebook_date")
    public String getPrebookDate() {
        return prebookDate;
    }

    public void setPrebookDate(String prebookDate) {
        this.prebookDate = prebookDate;
    }

    @Basic
    @Column(name = "hotel_id")
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "room_id")
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "room_type_name")
    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    @Basic
    @Column(name = "meal_name")
    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "cancel_policy")
    public String getCancelPolicy() {
        return cancelPolicy;
    }

    public void setCancelPolicy(String cancelPolicy) {
        this.cancelPolicy = cancelPolicy;
    }

    @Basic
    @Column(name = "percentage")
    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @Basic
    @Column(name = "deadline")
    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(name = "atb_cancel_policy")
    public String getAtbCancelPolicy() {
        return atbCancelPolicy;
    }

    public void setAtbCancelPolicy(String atbCancelPolicy) {
        this.atbCancelPolicy = atbCancelPolicy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrebookLogBean that = (PrebookLogBean) o;

        if (id != that.id) return false;
        if (prebookRef != null ? !prebookRef.equals(that.prebookRef) : that.prebookRef != null) return false;
        if (prebookDate != null ? !prebookDate.equals(that.prebookDate) : that.prebookDate != null) return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (roomTypeName != null ? !roomTypeName.equals(that.roomTypeName) : that.roomTypeName != null) return false;
        if (mealName != null ? !mealName.equals(that.mealName) : that.mealName != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (cancelPolicy != null ? !cancelPolicy.equals(that.cancelPolicy) : that.cancelPolicy != null) return false;
        if (percentage != null ? !percentage.equals(that.percentage) : that.percentage != null) return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;
        if (atbCancelPolicy != null ? !atbCancelPolicy.equals(that.atbCancelPolicy) : that.atbCancelPolicy != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (prebookRef != null ? prebookRef.hashCode() : 0);
        result = 31 * result + (prebookDate != null ? prebookDate.hashCode() : 0);
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (roomTypeName != null ? roomTypeName.hashCode() : 0);
        result = 31 * result + (mealName != null ? mealName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (cancelPolicy != null ? cancelPolicy.hashCode() : 0);
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (atbCancelPolicy != null ? atbCancelPolicy.hashCode() : 0);
        return result;
    }
}
