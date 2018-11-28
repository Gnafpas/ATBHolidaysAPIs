package Beans.ATBDBBeans.KalitaonSystem;

import javax.persistence.*;

/**
 * Created by George on 22/01/2018.
 */
@Entity
@Table(name = "gsa_deposit_statement", schema = "atb_System_DB", catalog = "")
public class GsaDepositStatementBean {
    private int id;
    private String transactionSign;
    private String transactionDate;
    private String gsaId;
    private String agentId;
    private String agentName;
    private String bookingId;
    private String amound;
    private String balance;
    private String notes;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "transaction_sign")
    public String getTransactionSign() {
        return transactionSign;
    }

    public void setTransactionSign(String transactionSign) {
        this.transactionSign = transactionSign;
    }

    @Basic
    @Column(name = "transaction_date")
    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
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
    @Column(name = "booking_id")
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @Basic
    @Column(name = "amound")
    public String getAmound() {
        return amound;
    }

    public void setAmound(String amound) {
        this.amound = amound;
    }

    @Basic
    @Column(name = "balance")
    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GsaDepositStatementBean that = (GsaDepositStatementBean) o;

        if (id != that.id) return false;
        if (transactionSign != null ? !transactionSign.equals(that.transactionSign) : that.transactionSign != null)
            return false;
        if (transactionDate != null ? !transactionDate.equals(that.transactionDate) : that.transactionDate != null)
            return false;
        if (gsaId != null ? !gsaId.equals(that.gsaId) : that.gsaId != null) return false;
        if (agentId != null ? !agentId.equals(that.agentId) : that.agentId != null) return false;
        if (agentName != null ? !agentName.equals(that.agentName) : that.agentName != null) return false;
        if (bookingId != null ? !bookingId.equals(that.bookingId) : that.bookingId != null) return false;
        if (amound != null ? !amound.equals(that.amound) : that.amound != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (transactionSign != null ? transactionSign.hashCode() : 0);
        result = 31 * result + (transactionDate != null ? transactionDate.hashCode() : 0);
        result = 31 * result + (gsaId != null ? gsaId.hashCode() : 0);
        result = 31 * result + (agentId != null ? agentId.hashCode() : 0);
        result = 31 * result + (agentName != null ? agentName.hashCode() : 0);
        result = 31 * result + (bookingId != null ? bookingId.hashCode() : 0);
        result = 31 * result + (amound != null ? amound.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
