package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 23/11/2017.
 */
@Entity
@Table(name = "roombed", schema = "Sunhotels", catalog = "")
public class RoombedBean {
    private int id;
    private int bedCount;
    private String bedType;
    private int hotelId;
    private int roomId;
    private int extraBedCount;
    private int providerId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bed_count")
    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    @Basic
    @Column(name = "bed_type")
    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
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
    @Column(name = "extra_bed_count")
    public int getExtraBedCount() {
        return extraBedCount;
    }

    public void setExtraBedCount(int extraBedCount) {
        this.extraBedCount = extraBedCount;
    }

    @Basic
    @Column(name = "provider_id")
    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoombedBean that = (RoombedBean) o;

        if (id != that.id) return false;
        if (bedCount != that.bedCount) return false;
        if (hotelId != that.hotelId) return false;
        if (roomId != that.roomId) return false;
        if (extraBedCount != that.extraBedCount) return false;
        if (providerId != that.providerId) return false;
        if (bedType != null ? !bedType.equals(that.bedType) : that.bedType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) bedCount;
        result = 31 * result + (bedType != null ? bedType.hashCode() : 0);
        result = 31 * result + hotelId;
        result = 31 * result + roomId;
        result = 31 * result + extraBedCount;
        result = 31 * result + providerId;
        return result;
    }
}
