package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by George on 06/05/2018.
 */
@Entity
@Table(name = "room_available", schema = "Sunhotels", catalog = "")
public class RoomAvailableBean {
    private int id;
    private Date startDate;
    private Date endDate;
    private String mealType;
    private int hotelId;
    private int roomId;
    private Integer providerId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "meal_type")
    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    @Basic
    @Column(name = "hotel_id")
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "room_id")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "provider_id")
    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomAvailableBean that = (RoomAvailableBean) o;

        if (id != that.id) return false;
        if (hotelId != that.hotelId) return false;
        if (roomId != that.roomId) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (mealType != null ? !mealType.equals(that.mealType) : that.mealType != null) return false;
        if (providerId != null ? !providerId.equals(that.providerId) : that.providerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (mealType != null ? mealType.hashCode() : 0);
        result = 31 * result + hotelId;
        result = 31 * result + roomId;
        result = 31 * result + (providerId != null ? providerId.hashCode() : 0);
        return result;
    }
}
