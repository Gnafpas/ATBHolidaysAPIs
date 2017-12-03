package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 24/11/2017.
 */
@Entity
@Table(name = "room", schema = "Sunhotels", catalog = "")
public class RoomBean {
    private int id;
    private String description;
    private Integer roomSize;
    private Integer providerRef;
    private String sizeMeasurement;
    private int minAdultOccupation;
    private int maxAdultOccupation;
    private int minChildOccupation;
    private int maxChildOccupation;
    private int minInfantOccupation;
    private int maxInfantOccupation;
    private int hotelId;
    private int roomTypeId;
    private int providerId;
    private boolean dirty;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "provider_ref")
    public Integer getProviderRef() {
        return providerRef;
    }

    public void setProviderRef(Integer providerRef) {
        this.providerRef = providerRef;
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
    @Column(name = "min_adult_occupation")
    public int getMinAdultOccupation() {
        return minAdultOccupation;
    }

    public void setMinAdultOccupation(int minAdultOccupation) {
        this.minAdultOccupation = minAdultOccupation;
    }

    @Basic
    @Column(name = "max_adult_occupation")
    public int getMaxAdultOccupation() {
        return maxAdultOccupation;
    }

    public void setMaxAdultOccupation(int maxAdultOccupation) {
        this.maxAdultOccupation = maxAdultOccupation;
    }

    @Basic
    @Column(name = "min_child_occupation")
    public int getMinChildOccupation() {
        return minChildOccupation;
    }

    public void setMinChildOccupation(int minChildOccupation) {
        this.minChildOccupation = minChildOccupation;
    }

    @Basic
    @Column(name = "max_child_occupation")
    public int getMaxChildOccupation() {
        return maxChildOccupation;
    }

    public void setMaxChildOccupation(int maxChildOccupation) {
        this.maxChildOccupation = maxChildOccupation;
    }

    @Basic
    @Column(name = "min_infant_occupation")
    public int getMinInfantOccupation() {
        return minInfantOccupation;
    }

    public void setMinInfantOccupation(int minInfantOccupation) {
        this.minInfantOccupation = minInfantOccupation;
    }

    @Basic
    @Column(name = "max_infant_occupation")
    public int getMaxInfantOccupation() {
        return maxInfantOccupation;
    }

    public void setMaxInfantOccupation(int maxInfantOccupation) {
        this.maxInfantOccupation = maxInfantOccupation;
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
    @Column(name = "room_type_id")
    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
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
    @Column(name = "dirty")
    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomBean roomBean = (RoomBean) o;

        if (id != roomBean.id) return false;
        if (minAdultOccupation != roomBean.minAdultOccupation) return false;
        if (maxAdultOccupation != roomBean.maxAdultOccupation) return false;
        if (minChildOccupation != roomBean.minChildOccupation) return false;
        if (maxChildOccupation != roomBean.maxChildOccupation) return false;
        if (minInfantOccupation != roomBean.minInfantOccupation) return false;
        if (maxInfantOccupation != roomBean.maxInfantOccupation) return false;
        if (hotelId != roomBean.hotelId) return false;
        if (roomTypeId != roomBean.roomTypeId) return false;
        if (providerId != roomBean.providerId) return false;
        if (dirty != roomBean.dirty) return false;
        if (description != null ? !description.equals(roomBean.description) : roomBean.description != null)
            return false;
        if (roomSize != null ? !roomSize.equals(roomBean.roomSize) : roomBean.roomSize != null) return false;
        if (providerRef != null ? !providerRef.equals(roomBean.providerRef) : roomBean.providerRef != null)
            return false;
        if (sizeMeasurement != null ? !sizeMeasurement.equals(roomBean.sizeMeasurement) : roomBean.sizeMeasurement != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (roomSize != null ? roomSize.hashCode() : 0);
        result = 31 * result + (providerRef != null ? providerRef.hashCode() : 0);
        result = 31 * result + (sizeMeasurement != null ? sizeMeasurement.hashCode() : 0);
        result = 31 * result + (int) minAdultOccupation;
        result = 31 * result + (int) maxAdultOccupation;
        result = 31 * result + (int) minChildOccupation;
        result = 31 * result + (int) maxChildOccupation;
        result = 31 * result + (int) minInfantOccupation;
        result = 31 * result + (int) maxInfantOccupation;
        result = 31 * result + hotelId;
        result = 31 * result + roomTypeId;
        result = 31 * result + providerId;
        result = 31 * result + (dirty ? 1 : 0);
        return result;
    }
}
