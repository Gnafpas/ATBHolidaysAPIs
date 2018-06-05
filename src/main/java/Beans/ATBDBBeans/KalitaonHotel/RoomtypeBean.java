package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 24/11/2017.
 */
@Entity
@Table(name = "roomtype", schema = "Sunhotels", catalog = "")
public class RoomtypeBean {
    private int id;
    private String roomType;
    private int providerId;
    private boolean sharedRoom;
    private String roomtypeId;
    private String sizeMeasurement;
    private String description;
    private Integer roomSize;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "room_type")
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "room_size")
    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }

    @Basic
    @Column(name = "size_measurement")
    public String getSizeMeasurement() {
        return sizeMeasurement;
    }

    public void setSizeMeasurement(String sizeMeasurement) {
        this.sizeMeasurement = sizeMeasurement;
    }

    @Basic
    @Column(name = "provider_id")
    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    @Basic
    @Column(name = "shared_room")
    public boolean isSharedRoom() {
        return sharedRoom;
    }

    public void setSharedRoom(boolean sharedRoom) {
        this.sharedRoom = sharedRoom;
    }

    @Basic
    @Column(name = "roomtype_id")
    public String getRoomtypeId() {
        return roomtypeId;
    }

    public void setRoomtypeId(String roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomtypeBean that = (RoomtypeBean) o;

        if (id != that.id) return false;
        if (providerId != that.providerId) return false;
        if (sharedRoom != that.sharedRoom) return false;
        if (roomtypeId != null ? !roomtypeId.equals(that.roomtypeId) : that.roomtypeId != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (roomSize != null ? !roomSize.equals(that.roomSize) : that.roomSize != null) return false;
        if (sizeMeasurement != null ? !sizeMeasurement.equals(that.sizeMeasurement) : that.sizeMeasurement != null)
            return false;
        if (roomType != null ? !roomType.equals(that.roomType) : that.roomType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
        result = 31 * result + providerId;
        result = 31 * result + (sharedRoom ? 1 : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (roomSize != null ? roomSize.hashCode() : 0);
        result = 31 * result + (sizeMeasurement != null ? sizeMeasurement.hashCode() : 0);
        result = 31 * result + (roomtypeId != null ? roomtypeId.hashCode() : 0);
        return result;
    }
}
