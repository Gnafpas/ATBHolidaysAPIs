package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 26/07/2017.
 */
@Entity
@Table(name = "viator_update_categories_info", schema = "develope_viator", catalog = "")
public class ViatorUpdateCategoriesInfoBean {
    private int rid;
    private Timestamp dateTime;
    private boolean viatorError;
    private String viatoErrorInfo;
    private boolean dbCommError;
    private Integer dbCommErrorsCounter;

    @Id
    @Column(name = "rid")
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "date_time")
    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Basic
    @Column(name = "viator_error")
    public boolean getViatorError() {
        return viatorError;
    }

    public void setViatorError(boolean viatorError) {
        this.viatorError = viatorError;
    }

    @Basic
    @Column(name = "viato_error_Info")
    public String getViatoErrorInfo() {
        return viatoErrorInfo;
    }

    public void setViatoErrorInfo(String viatoErrorInfo) {
        this.viatoErrorInfo = viatoErrorInfo;
    }

    @Basic
    @Column(name = "db_comm_error")
    public boolean getDbCommError() {
        return dbCommError;
    }

    public void setDbCommError(boolean dbCommError) {
        this.dbCommError = dbCommError;
    }

    @Basic
    @Column(name = "db_comm_errors_Counter")
    public Integer getDbCommErrorsCounter() {
        return dbCommErrorsCounter;
    }

    public void setDbCommErrorsCounter(Integer dbCommErrorsCounter) {
        this.dbCommErrorsCounter = dbCommErrorsCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViatorUpdateCategoriesInfoBean that = (ViatorUpdateCategoriesInfoBean) o;

        if (rid != that.rid) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (viatorError != that.viatorError) return false;
        if (viatoErrorInfo != null ? !viatoErrorInfo.equals(that.viatoErrorInfo) : that.viatoErrorInfo != null)
            return false;
        if (dbCommError != that.dbCommError) return false;
        if (dbCommErrorsCounter != null ? !dbCommErrorsCounter.equals(that.dbCommErrorsCounter) : that.dbCommErrorsCounter != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + help(viatorError);
        result = 31 * result + (viatoErrorInfo != null ? viatoErrorInfo.hashCode() : 0);
        result = 31 * result + help(dbCommError);
        result = 31 * result + (dbCommErrorsCounter != null ? dbCommErrorsCounter.hashCode() : 0);
        return result;
    }

    private int help(boolean attribute){
        if(attribute){return 1;}else{return 0;}
    }
}
