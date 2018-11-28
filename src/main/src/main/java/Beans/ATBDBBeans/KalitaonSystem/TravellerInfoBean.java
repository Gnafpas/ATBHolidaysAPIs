package Beans.ATBDBBeans.KalitaonSystem;

import javax.persistence.*;

/**
 * Created by George on 31/01/2018.
 */
@Entity
@Table(name = "traveller_info", schema = "atb_System_DB", catalog = "")
public class TravellerInfoBean {
    private int id;
    private String bookingId;
    private String travelType;
    private String travelName;
    private String travelSurname;
    private String travelBirdthDate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "booking_id")
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @Basic
    @Column(name = "travel_type")
    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    @Basic
    @Column(name = "travel_name")
    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    @Basic
    @Column(name = "travel_surname")
    public String getTravelSurname() {
        return travelSurname;
    }


    public void setTravelSurname(String travelSurname) {
        this.travelSurname = travelSurname;
    }

    @Basic
    @Column(name = "travel_birdth_date")
    public String getTravelBirdthDate() {
        return travelBirdthDate;
    }

    public void setTravelBirdthDate(String travelBirdthDate) {
        this.travelBirdthDate = travelBirdthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TravellerInfoBean that = (TravellerInfoBean) o;

        if (id != that.id) return false;
        if (bookingId != null ? !bookingId.equals(that.bookingId) : that.bookingId != null) return false;
        if (travelType != null ? !travelType.equals(that.travelType) : that.travelType != null) return false;
        if (travelName != null ? !travelName.equals(that.travelName) : that.travelName != null) return false;
        if (travelSurname != null ? !travelSurname.equals(that.travelSurname) : that.travelSurname != null) return false;
        if (travelBirdthDate != null ? !travelBirdthDate.equals(that.travelBirdthDate) : that.travelBirdthDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bookingId != null ? bookingId.hashCode() : 0);
        result = 31 * result + (travelType != null ? travelType.hashCode() : 0);
        result = 31 * result + (travelName != null ? travelName.hashCode() : 0);
        result = 31 * result + (travelSurname != null ? travelSurname.hashCode() : 0);
        result = 31 * result + (travelBirdthDate != null ? travelBirdthDate.hashCode() : 0);
        return result;
    }
}
