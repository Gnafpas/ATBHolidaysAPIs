package Beans.ATBDBBeans.KalitaonSystem;

import javax.persistence.*;

/**
 * Created by George on 22/01/2018.
 */
@Entity
@Table(name = "booking_transaction", schema = "atb_System_DB", catalog = "")
public class BookingTransactionBean {
    private int id;
    private String transactionType;
    private String bookingId;
    private String gsaId;
    private String agentId;
    private String agentName;
    private String transDate;
    private String transRate;
    private String transCur;
    private String transType;
    private String transNote;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "transaction_type")
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
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
    @Column(name = "gsa_id")
    public String getGsaId() {
        return gsaId;
    }

    public void setGsaId(String gsaId) {
        this.gsaId = gsaId;
    }

    @Basic
    @Column(name = "agent_id")
    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    @Basic
    @Column(name = "agent_name")
    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    @Basic
    @Column(name = "trans_date")
    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    @Basic
    @Column(name = "trans_rate")
    public String getTransRate() {
        return transRate;
    }

    public void setTransRate(String transRate) {
        this.transRate = transRate;
    }

    @Basic
    @Column(name = "trans_cur")
    public String getTransCur() {
        return transCur;
    }

    public void setTransCur(String transCur) {
        this.transCur = transCur;
    }

    @Basic
    @Column(name = "trans_type")
    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @Basic
    @Column(name = "trans_note")
    public String getTransNote() {
        return transNote;
    }

    public void setTransNote(String transNote) {
        this.transNote = transNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingTransactionBean that = (BookingTransactionBean) o;

        if (id != that.id) return false;
        if (transactionType != null ? !transactionType.equals(that.transactionType) : that.transactionType != null)
            return false;
        if (bookingId != null ? !bookingId.equals(that.bookingId) : that.bookingId != null) return false;
        if (gsaId != null ? !gsaId.equals(that.gsaId) : that.gsaId != null) return false;
        if (agentId != null ? !agentId.equals(that.agentId) : that.agentId != null) return false;
        if (agentName != null ? !agentName.equals(that.agentName) : that.agentName != null) return false;
        if (transDate != null ? !transDate.equals(that.transDate) : that.transDate != null) return false;
        if (transRate != null ? !transRate.equals(that.transRate) : that.transRate != null) return false;
        if (transCur != null ? !transCur.equals(that.transCur) : that.transCur != null) return false;
        if (transType != null ? !transType.equals(that.transType) : that.transType != null) return false;
        if (transNote != null ? !transNote.equals(that.transNote) : that.transNote != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (transactionType != null ? transactionType.hashCode() : 0);
        result = 31 * result + (bookingId != null ? bookingId.hashCode() : 0);
        result = 31 * result + (gsaId != null ? gsaId.hashCode() : 0);
        result = 31 * result + (agentId != null ? agentId.hashCode() : 0);
        result = 31 * result + (agentName != null ? agentName.hashCode() : 0);
        result = 31 * result + (transDate != null ? transDate.hashCode() : 0);
        result = 31 * result + (transRate != null ? transRate.hashCode() : 0);
        result = 31 * result + (transCur != null ? transCur.hashCode() : 0);
        result = 31 * result + (transType != null ? transType.hashCode() : 0);
        result = 31 * result + (transNote != null ? transNote.hashCode() : 0);
        return result;
    }
}
