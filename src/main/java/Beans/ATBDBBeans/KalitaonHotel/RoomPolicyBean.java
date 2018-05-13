package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 06/05/2018.
 */
@Entity
@Table(name = "room_policy", schema = "Sunhotels", catalog = "")
public class RoomPolicyBean {
    private int id;
    private String policyType;
    private String night;
    private String nightDeadline;
    private String percent;
    private String perDeadline;
    private String hotelId;
    private String roomId;
    private String providerId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "policy_type")
    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    @Basic
    @Column(name = "night")
    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    @Basic
    @Column(name = "night_deadline")
    public String getNightDeadline() {
        return nightDeadline;
    }

    public void setNightDeadline(String nightDeadline) {
        this.nightDeadline = nightDeadline;
    }

    @Basic
    @Column(name = "percent")
    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    @Basic
    @Column(name = "per_deadline")
    public String getPerDeadline() {
        return perDeadline;
    }

    public void setPerDeadline(String perDeadline) {
        this.perDeadline = perDeadline;
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
    @Column(name = "provider_id")
    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomPolicyBean that = (RoomPolicyBean) o;

        if (id != that.id) return false;
        if (policyType != null ? !policyType.equals(that.policyType) : that.policyType != null) return false;
        if (night != null ? !night.equals(that.night) : that.night != null) return false;
        if (nightDeadline != null ? !nightDeadline.equals(that.nightDeadline) : that.nightDeadline != null)
            return false;
        if (percent != null ? !percent.equals(that.percent) : that.percent != null) return false;
        if (perDeadline != null ? !perDeadline.equals(that.perDeadline) : that.perDeadline != null) return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (providerId != null ? !providerId.equals(that.providerId) : that.providerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (policyType != null ? policyType.hashCode() : 0);
        result = 31 * result + (night != null ? night.hashCode() : 0);
        result = 31 * result + (nightDeadline != null ? nightDeadline.hashCode() : 0);
        result = 31 * result + (percent != null ? percent.hashCode() : 0);
        result = 31 * result + (perDeadline != null ? perDeadline.hashCode() : 0);
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (providerId != null ? providerId.hashCode() : 0);
        return result;
    }
}
