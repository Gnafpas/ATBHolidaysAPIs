package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 24/11/2017.
 */
@Entity
@Table(name = "photo", schema = "Sunhotels", catalog = "")
public class PhotoBean {
    private int id;
    private String title;
    private String description;
    private String photoPath;
    private String photoUrl;
    private Integer facilityId;
    private int hotelId;
    private String roomTypeId;
    private int providerId;
    private boolean coverPhoto;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "photo_path")
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Basic
    @Column(name = "photo_url")
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Basic
    @Column(name = "facility_id")
    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
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
    @Column(name = "roomType_id")
    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
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
    @Column(name = "cover_photo")
    public boolean isCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(boolean coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoBean photoBean = (PhotoBean) o;

        if (id != photoBean.id) return false;
        if (hotelId != photoBean.hotelId) return false;
        if (providerId != photoBean.providerId) return false;
        if (coverPhoto != photoBean.coverPhoto) return false;
        if (title != null ? !title.equals(photoBean.title) : photoBean.title != null) return false;
        if (description != null ? !description.equals(photoBean.description) : photoBean.description != null)
            return false;
        if (photoPath != null ? !photoPath.equals(photoBean.photoPath) : photoBean.photoPath != null) return false;
        if (photoUrl != null ? !photoUrl.equals(photoBean.photoUrl) : photoBean.photoUrl != null) return false;
        if (facilityId != null ? !facilityId.equals(photoBean.facilityId) : photoBean.facilityId != null) return false;
        if (roomTypeId != null ? !roomTypeId.equals(photoBean.roomTypeId) : photoBean.roomTypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (photoPath != null ? photoPath.hashCode() : 0);
        result = 31 * result + (photoUrl != null ? photoUrl.hashCode() : 0);
        result = 31 * result + (facilityId != null ? facilityId.hashCode() : 0);
        result = 31 * result + hotelId;
        result = 31 * result + (roomTypeId != null ? roomTypeId.hashCode() : 0);
        result = 31 * result + providerId;
        result = 31 * result + (coverPhoto ? 1 : 0);
        return result;
    }
}
