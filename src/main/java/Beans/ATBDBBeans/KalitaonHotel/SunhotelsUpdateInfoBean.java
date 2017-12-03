package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 25/11/2017.
 */
@Entity
@Table(name = "sunhotels_update_info", schema = "develope_viator", catalog = "")
public class SunhotelsUpdateInfoBean {
    private int rid;
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    private Integer atbdbCommErrorCounter;
    private Integer sunhotelsCommErrorCounter;
    private Integer totalexpiredHotels;

    @Id
    @Column(name = "rid")
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "start_date_time")
    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }

    @Basic
    @Column(name = "end_date_time")
    public Timestamp getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Timestamp endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Basic
    @Column(name = "atbdb_comm_error_counter")
    public Integer getAtbdbCommErrorCounter() {
        return atbdbCommErrorCounter;
    }

    public void setAtbdbCommErrorCounter(Integer atbdbCommErrorCounter) {
        this.atbdbCommErrorCounter = atbdbCommErrorCounter;
    }

    @Basic
    @Column(name = "sunhotels_comm_error_counter")
    public Integer getSunhotelsCommErrorCounter() {
        return sunhotelsCommErrorCounter;
    }

    public void setSunhotelsCommErrorCounter(Integer sunhotelsCommErrorCounter) {
        this.sunhotelsCommErrorCounter = sunhotelsCommErrorCounter;
    }

    @Basic
    @Column(name = "totalexpired_hotels")
    public Integer getTotalexpiredHotels() {
        return totalexpiredHotels;
    }

    public void setTotalexpiredHotels(Integer totalexpiredHotels) {
        this.totalexpiredHotels = totalexpiredHotels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SunhotelsUpdateInfoBean that = (SunhotelsUpdateInfoBean) o;

        if (rid != that.rid) return false;
        if (startDateTime != null ? !startDateTime.equals(that.startDateTime) : that.startDateTime != null)
            return false;
        if (endDateTime != null ? !endDateTime.equals(that.endDateTime) : that.endDateTime != null) return false;
        if (atbdbCommErrorCounter != null ? !atbdbCommErrorCounter.equals(that.atbdbCommErrorCounter) : that.atbdbCommErrorCounter != null)
            return false;
        if (sunhotelsCommErrorCounter != null ? !sunhotelsCommErrorCounter.equals(that.sunhotelsCommErrorCounter) : that.sunhotelsCommErrorCounter != null)
            return false;
        if (totalexpiredHotels != null ? !totalexpiredHotels.equals(that.totalexpiredHotels) : that.totalexpiredHotels != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (startDateTime != null ? startDateTime.hashCode() : 0);
        result = 31 * result + (endDateTime != null ? endDateTime.hashCode() : 0);
        result = 31 * result + (atbdbCommErrorCounter != null ? atbdbCommErrorCounter.hashCode() : 0);
        result = 31 * result + (sunhotelsCommErrorCounter != null ? sunhotelsCommErrorCounter.hashCode() : 0);
        result = 31 * result + (totalexpiredHotels != null ? totalexpiredHotels.hashCode() : 0);
        return result;
    }
}
