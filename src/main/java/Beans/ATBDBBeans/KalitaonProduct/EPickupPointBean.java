package Beans.ATBDBBeans.KalitaonProduct;

import javax.persistence.*;

/**
 * Created by George on 14/09/2017.
 */
@Entity
@Table(name = "e_pickup_point", schema = "atb_DB", catalog = "")
public class EPickupPointBean {
    private int id;
    private String productId;
    private String pickupType;
    private String meetingPoint;
    private String hotelId;
    private String hotelPickupPoint;
    private String dropOfEndPoint;
    private String startingPoint;
    private String latitude;
    private String longitude;
    private String mapZoom;
    private String precisionType;
    private String pickupNote;
    private String createdAt;
    private String updatedAt;

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
    @Column(name = "pickup_type")
    public String getPickupType() {
        return pickupType;
    }

    public void setPickupType(String pickupType) {
        this.pickupType = pickupType;
    }

    @Basic
    @Column(name = "meeting_point")
    public String getMeetingPoint() {
        return meetingPoint;
    }

    public void setMeetingPoint(String meetingPoint) {
        this.meetingPoint = meetingPoint;
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
    @Column(name = "hotel_pickup_point")
    public String getHotelPickupPoint() {
        return hotelPickupPoint;
    }

    public void setHotelPickupPoint(String hotelPickupPoint) {
        this.hotelPickupPoint = hotelPickupPoint;
    }

    @Basic
    @Column(name = "drop_of_end_point")
    public String getDropOfEndPoint() {
        return dropOfEndPoint;
    }

    public void setDropOfEndPoint(String dropOfEndPoint) {
        this.dropOfEndPoint = dropOfEndPoint;
    }

    @Basic
    @Column(name = "starting_point")
    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    @Basic
    @Column(name = "latitude")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "map_zoom")
    public String getMapZoom() {
        return mapZoom;
    }

    public void setMapZoom(String mapZoom) {
        this.mapZoom = mapZoom;
    }

    @Basic
    @Column(name = "precision_type")
    public String getPrecisionType() {
        return precisionType;
    }

    public void setPrecisionType(String precisionType) {
        this.precisionType = precisionType;
    }

    @Basic
    @Column(name = "pickup_note")
    public String getPickupNote() {
        return pickupNote;
    }

    public void setPickupNote(String pickupNote) {
        this.pickupNote = pickupNote;
    }

    @Basic
    @Column(name = "created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EPickupPointBean that = (EPickupPointBean) o;

        if (id != that.id) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (pickupType != null ? !pickupType.equals(that.pickupType) : that.pickupType != null) return false;
        if (meetingPoint != null ? !meetingPoint.equals(that.meetingPoint) : that.meetingPoint != null) return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (hotelPickupPoint != null ? !hotelPickupPoint.equals(that.hotelPickupPoint) : that.hotelPickupPoint != null)
            return false;
        if (dropOfEndPoint != null ? !dropOfEndPoint.equals(that.dropOfEndPoint) : that.dropOfEndPoint != null)
            return false;
        if (startingPoint != null ? !startingPoint.equals(that.startingPoint) : that.startingPoint != null)
            return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (mapZoom != null ? !mapZoom.equals(that.mapZoom) : that.mapZoom != null) return false;
        if (precisionType != null ? !precisionType.equals(that.precisionType) : that.precisionType != null)
            return false;
        if (pickupNote != null ? !pickupNote.equals(that.pickupNote) : that.pickupNote != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (pickupType != null ? pickupType.hashCode() : 0);
        result = 31 * result + (meetingPoint != null ? meetingPoint.hashCode() : 0);
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (hotelPickupPoint != null ? hotelPickupPoint.hashCode() : 0);
        result = 31 * result + (dropOfEndPoint != null ? dropOfEndPoint.hashCode() : 0);
        result = 31 * result + (startingPoint != null ? startingPoint.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (mapZoom != null ? mapZoom.hashCode() : 0);
        result = 31 * result + (precisionType != null ? precisionType.hashCode() : 0);
        result = 31 * result + (pickupNote != null ? pickupNote.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
