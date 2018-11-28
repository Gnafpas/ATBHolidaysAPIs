package Beans.HotelBedsAPIBeans.Book;

/**
 * Created by George on 27/04/2018.
 */
public class Booking {
    private String reference;
    private String clientReference;
    private String creationDate;
    private String status;
    private ModificationPolicies modificationPolicies;
    private String creationUser;
    private Holder holder;
    private Hotel hotel;
    private InvoiceCompany invoiceCompany;
    private double totalNet;
    private double pendingAmount;
    private String currency;


    public InvoiceCompany getInvoiceCompany() {
        return invoiceCompany;
    }

    public void setInvoiceCompany(InvoiceCompany invoiceCompany) {
        this.invoiceCompany = invoiceCompany;
    }

    public double getTotalNet() {
        return totalNet;
    }

    public void setTotalNet(double totalNet) {
        this.totalNet = totalNet;
    }

    public double getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(double pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getClientReference() {
        return clientReference;
    }

    public void setClientReference(String clientReference) {
        this.clientReference = clientReference;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ModificationPolicies getModificationPolicies() {
        return modificationPolicies;
    }

    public void setModificationPolicies(ModificationPolicies modificationPolicies) {
        this.modificationPolicies = modificationPolicies;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
