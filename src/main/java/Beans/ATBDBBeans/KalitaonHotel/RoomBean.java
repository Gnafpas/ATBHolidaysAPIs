package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 09/12/2017.
 */
@Entity
@Table(name = "room", schema = "Sunhotels", catalog = "")
public class RoomBean {
    private int atbRoomId;
    private int providerId;
    private int hotelId;
    private Integer providerRef;
    private String roomTypeId;
    private boolean dirty;
    private String originalRoomId;

    @Id
    @Column(name = "atb_room_id")
    public int getAtbRoomId() {
        return atbRoomId;
    }

    public void setAtbRoomId(int atbRoomId) {
        this.atbRoomId = atbRoomId;
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
    @Column(name = "hotel_id")
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
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
    @Column(name = "room_type_id")
    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    @Basic
    @Column(name = "dirty")
    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    @Basic
    @Column(name = "original_room_id")
    public String getOriginalRoomId() {
        return originalRoomId;
    }

    public void setOriginalRoomId(String originalRoomId) {
        this.originalRoomId = originalRoomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomBean roomBean = (RoomBean) o;

        if (atbRoomId != roomBean.atbRoomId) return false;
        if (providerId != roomBean.providerId) return false;
        if (hotelId != roomBean.hotelId) return false;
        if (roomTypeId != null ? !roomTypeId.equals(roomBean.roomTypeId) : roomBean.roomTypeId != null)
            return false;
        if (dirty != roomBean.dirty) return false;
        if (providerRef != null ? !providerRef.equals(roomBean.providerRef) : roomBean.providerRef != null)
            return false;
        if (originalRoomId != null ? !originalRoomId.equals(roomBean.originalRoomId) : roomBean.originalRoomId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = atbRoomId;
        result = 31 * result + providerId;
        result = 31 * result + hotelId;
        result = 31 * result + (providerRef != null ? providerRef.hashCode() : 0);
        result = 31 * result + (roomTypeId != null ? roomTypeId.hashCode() : 0);
        result = 31 * result + (dirty ? 1 : 0);
        result = 31 * result + (originalRoomId != null ? originalRoomId.hashCode() : 0);
        return result;
    }
}
