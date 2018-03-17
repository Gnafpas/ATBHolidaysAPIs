package Beans.ATBDBBeans.KalitaonSystem;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "supplier", schema = "atb_System_DB", catalog = "")
public class SupplierBean {
    private int id;
    private String supplierName;
    private String countryId;
    private String cityId;
    private String operationPic;
    private String operationTel;
    private String operationMail;
    private String reservationPic;
    private String reservationTel;
    private String reservationMail;
    private String productPic;
    private String productTel;
    private String productMail;
    private String bankDetail;
    private String taxNo;
    private String taxOffice;
    private String address;
    private String officeTel;
    private String mobileTel;
    private String fax;
    private String reservationType;
    private String rstOnlineSite;
    private String rstOnlineLogin;
    private String rstExUsername;
    private String rstExPassword;
    private String rstEmailInfo;
    private String accountPic;
    private String accountTel;
    private String accountMail;
    private String groupPic;
    private String groupTel;
    private String groupMail;
    private String notes;
    private String logs;
    private String authorized;
    private String extranet;
    private String activation;
    private String autoMail;
    private String contractor;
    private String dataSpecialist;
    private String bookingUser;
    private String contract;
    private String paymentDate;
    private String paymentType;
    private Timestamp createDate;
    private Timestamp updateDate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "supplier_name")
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Basic
    @Column(name = "country_id")
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "city_id")
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "operation_pic")
    public String getOperationPic() {
        return operationPic;
    }

    public void setOperationPic(String operationPic) {
        this.operationPic = operationPic;
    }

    @Basic
    @Column(name = "operation_tel")
    public String getOperationTel() {
        return operationTel;
    }

    public void setOperationTel(String operationTel) {
        this.operationTel = operationTel;
    }

    @Basic
    @Column(name = "operation_mail")
    public String getOperationMail() {
        return operationMail;
    }

    public void setOperationMail(String operationMail) {
        this.operationMail = operationMail;
    }

    @Basic
    @Column(name = "reservation_pic")
    public String getReservationPic() {
        return reservationPic;
    }

    public void setReservationPic(String reservationPic) {
        this.reservationPic = reservationPic;
    }

    @Basic
    @Column(name = "reservation_tel")
    public String getReservationTel() {
        return reservationTel;
    }

    public void setReservationTel(String reservationTel) {
        this.reservationTel = reservationTel;
    }

    @Basic
    @Column(name = "reservation_mail")
    public String getReservationMail() {
        return reservationMail;
    }

    public void setReservationMail(String reservationMail) {
        this.reservationMail = reservationMail;
    }

    @Basic
    @Column(name = "product_pic")
    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    @Basic
    @Column(name = "product_tel")
    public String getProductTel() {
        return productTel;
    }

    public void setProductTel(String productTel) {
        this.productTel = productTel;
    }

    @Basic
    @Column(name = "product_mail")
    public String getProductMail() {
        return productMail;
    }

    public void setProductMail(String productMail) {
        this.productMail = productMail;
    }

    @Basic
    @Column(name = "bank_detail")
    public String getBankDetail() {
        return bankDetail;
    }

    public void setBankDetail(String bankDetail) {
        this.bankDetail = bankDetail;
    }

    @Basic
    @Column(name = "tax_no")
    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    @Basic
    @Column(name = "tax_office")
    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "office_tel")
    public String getOfficeTel() {
        return officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    @Basic
    @Column(name = "mobile_tel")
    public String getMobileTel() {
        return mobileTel;
    }

    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel;
    }

    @Basic
    @Column(name = "fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "reservation_type")
    public String getReservationType() {
        return reservationType;
    }

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }

    @Basic
    @Column(name = "rst_online_site")
    public String getRstOnlineSite() {
        return rstOnlineSite;
    }

    public void setRstOnlineSite(String rstOnlineSite) {
        this.rstOnlineSite = rstOnlineSite;
    }

    @Basic
    @Column(name = "rst_online_login")
    public String getRstOnlineLogin() {
        return rstOnlineLogin;
    }

    public void setRstOnlineLogin(String rstOnlineLogin) {
        this.rstOnlineLogin = rstOnlineLogin;
    }

    @Basic
    @Column(name = "rst_ex_username")
    public String getRstExUsername() {
        return rstExUsername;
    }

    public void setRstExUsername(String rstExUsername) {
        this.rstExUsername = rstExUsername;
    }

    @Basic
    @Column(name = "rst_ex_password")
    public String getRstExPassword() {
        return rstExPassword;
    }

    public void setRstExPassword(String rstExPassword) {
        this.rstExPassword = rstExPassword;
    }

    @Basic
    @Column(name = "rst_email_info")
    public String getRstEmailInfo() {
        return rstEmailInfo;
    }

    public void setRstEmailInfo(String rstEmailInfo) {
        this.rstEmailInfo = rstEmailInfo;
    }

    @Basic
    @Column(name = "account_pic")
    public String getAccountPic() {
        return accountPic;
    }

    public void setAccountPic(String accountPic) {
        this.accountPic = accountPic;
    }

    @Basic
    @Column(name = "account_tel")
    public String getAccountTel() {
        return accountTel;
    }

    public void setAccountTel(String accountTel) {
        this.accountTel = accountTel;
    }

    @Basic
    @Column(name = "account_mail")
    public String getAccountMail() {
        return accountMail;
    }

    public void setAccountMail(String accountMail) {
        this.accountMail = accountMail;
    }

    @Basic
    @Column(name = "group_pic")
    public String getGroupPic() {
        return groupPic;
    }

    public void setGroupPic(String groupPic) {
        this.groupPic = groupPic;
    }

    @Basic
    @Column(name = "group_tel")
    public String getGroupTel() {
        return groupTel;
    }

    public void setGroupTel(String groupTel) {
        this.groupTel = groupTel;
    }

    @Basic
    @Column(name = "group_mail")
    public String getGroupMail() {
        return groupMail;
    }

    public void setGroupMail(String groupMail) {
        this.groupMail = groupMail;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "logs")
    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }

    @Basic
    @Column(name = "authorized")
    public String getAuthorized() {
        return authorized;
    }

    public void setAuthorized(String authorized) {
        this.authorized = authorized;
    }

    @Basic
    @Column(name = "extranet")
    public String getExtranet() {
        return extranet;
    }

    public void setExtranet(String extranet) {
        this.extranet = extranet;
    }

    @Basic
    @Column(name = "activation")
    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    @Basic
    @Column(name = "auto_mail")
    public String getAutoMail() {
        return autoMail;
    }

    public void setAutoMail(String autoMail) {
        this.autoMail = autoMail;
    }

    @Basic
    @Column(name = "contractor")
    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    @Basic
    @Column(name = "data_specialist")
    public String getDataSpecialist() {
        return dataSpecialist;
    }

    public void setDataSpecialist(String dataSpecialist) {
        this.dataSpecialist = dataSpecialist;
    }

    @Basic
    @Column(name = "booking_user")
    public String getBookingUser() {
        return bookingUser;
    }

    public void setBookingUser(String bookingUser) {
        this.bookingUser = bookingUser;
    }

    @Basic
    @Column(name = "contract")
    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    @Basic
    @Column(name = "payment_date")
    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Basic
    @Column(name = "payment_type")
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierBean that = (SupplierBean) o;
        return id == that.id &&
                Objects.equals(supplierName, that.supplierName) &&
                Objects.equals(countryId, that.countryId) &&
                Objects.equals(cityId, that.cityId) &&
                Objects.equals(operationPic, that.operationPic) &&
                Objects.equals(operationTel, that.operationTel) &&
                Objects.equals(operationMail, that.operationMail) &&
                Objects.equals(reservationPic, that.reservationPic) &&
                Objects.equals(reservationTel, that.reservationTel) &&
                Objects.equals(reservationMail, that.reservationMail) &&
                Objects.equals(productPic, that.productPic) &&
                Objects.equals(productTel, that.productTel) &&
                Objects.equals(productMail, that.productMail) &&
                Objects.equals(bankDetail, that.bankDetail) &&
                Objects.equals(taxNo, that.taxNo) &&
                Objects.equals(taxOffice, that.taxOffice) &&
                Objects.equals(address, that.address) &&
                Objects.equals(officeTel, that.officeTel) &&
                Objects.equals(mobileTel, that.mobileTel) &&
                Objects.equals(fax, that.fax) &&
                Objects.equals(reservationType, that.reservationType) &&
                Objects.equals(rstOnlineSite, that.rstOnlineSite) &&
                Objects.equals(rstOnlineLogin, that.rstOnlineLogin) &&
                Objects.equals(rstExUsername, that.rstExUsername) &&
                Objects.equals(rstExPassword, that.rstExPassword) &&
                Objects.equals(rstEmailInfo, that.rstEmailInfo) &&
                Objects.equals(accountPic, that.accountPic) &&
                Objects.equals(accountTel, that.accountTel) &&
                Objects.equals(accountMail, that.accountMail) &&
                Objects.equals(groupPic, that.groupPic) &&
                Objects.equals(groupTel, that.groupTel) &&
                Objects.equals(groupMail, that.groupMail) &&
                Objects.equals(notes, that.notes) &&
                Objects.equals(logs, that.logs) &&
                Objects.equals(authorized, that.authorized) &&
                Objects.equals(extranet, that.extranet) &&
                Objects.equals(activation, that.activation) &&
                Objects.equals(autoMail, that.autoMail) &&
                Objects.equals(contractor, that.contractor) &&
                Objects.equals(dataSpecialist, that.dataSpecialist) &&
                Objects.equals(bookingUser, that.bookingUser) &&
                Objects.equals(contract, that.contract) &&
                Objects.equals(paymentDate, that.paymentDate) &&
                Objects.equals(paymentType, that.paymentType) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, supplierName, countryId, cityId, operationPic, operationTel, operationMail, reservationPic, reservationTel, reservationMail, productPic, productTel, productMail, bankDetail, taxNo, taxOffice, address, officeTel, mobileTel, fax, reservationType, rstOnlineSite, rstOnlineLogin, rstExUsername, rstExPassword, rstEmailInfo, accountPic, accountTel, accountMail, groupPic, groupTel, groupMail, notes, logs, authorized, extranet, activation, autoMail, contractor, dataSpecialist, bookingUser, contract, paymentDate, paymentType, createDate, updateDate);
    }
}
