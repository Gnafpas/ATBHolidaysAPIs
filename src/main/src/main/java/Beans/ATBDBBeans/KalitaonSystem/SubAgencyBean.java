package Beans.ATBDBBeans.KalitaonSystem;

import javax.persistence.*;

/**
 * Created by George on 22/01/2018.
 */
@Entity
@Table(name = "sub_agency", schema = "atb_System_DB", catalog = "")
public class SubAgencyBean {
    private int id;
    private String gsaId;
    private String agentName;
    private String typeOfAgency;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String web;
    private String email;
    private String mobile;
    private String telephone;
    private String countryCode;
    private String countryName;
    private String cityCode;
    private String cityName;
    private String billingAddress;
    private String billingEmail;
    private String iata;
    private String tursab;
    private String clia;
    private String asta;
    private String other;
    private String taxOffice;
    private String taxNo;
    private String bankName;
    private String bankAddress;
    private String bankCity;
    private String bankState;
    private String bankCountry;
    private String accountName;
    private String accountNumber;
    private String iban;
    private String swift;
    private String commission;
    private String markup;
    private String trsMkp;
    private String dtrMkp;
    private String mtrMkp;
    private String otlMkp;
    private String grpMkp;
    private String evtMkp;
    private String deposit;
    private String currency;
    private String logo;
    private String xmlStatus;
    private String xmlStorekey;
    private String notes;
    private String activation;
    private String createdDate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "agent_name")
    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    @Basic
    @Column(name = "type_of_agency")
    public String getTypeOfAgency() {
        return typeOfAgency;
    }

    public void setTypeOfAgency(String typeOfAgency) {
        this.typeOfAgency = typeOfAgency;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "job_title")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "web")
    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "country_code")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "country_name")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Basic
    @Column(name = "city_code")
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Basic
    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Basic
    @Column(name = "billing_address")
    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Basic
    @Column(name = "billing_email")
    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    @Basic
    @Column(name = "IATA")
    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    @Basic
    @Column(name = "TURSAB")
    public String getTursab() {
        return tursab;
    }

    public void setTursab(String tursab) {
        this.tursab = tursab;
    }

    @Basic
    @Column(name = "CLIA")
    public String getClia() {
        return clia;
    }

    public void setClia(String clia) {
        this.clia = clia;
    }

    @Basic
    @Column(name = "ASTA")
    public String getAsta() {
        return asta;
    }

    public void setAsta(String asta) {
        this.asta = asta;
    }

    @Basic
    @Column(name = "other")
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
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
    @Column(name = "tax_no")
    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    @Basic
    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "bank_address")
    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    @Basic
    @Column(name = "bank_city")
    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    @Basic
    @Column(name = "bank_state")
    public String getBankState() {
        return bankState;
    }

    public void setBankState(String bankState) {
        this.bankState = bankState;
    }

    @Basic
    @Column(name = "bank_country")
    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    @Basic
    @Column(name = "account_name")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Basic
    @Column(name = "account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "iban")
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Basic
    @Column(name = "swift")
    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    @Basic
    @Column(name = "commission")
    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    @Basic
    @Column(name = "markup")
    public String getMarkup() {
        return markup;
    }

    public void setMarkup(String markup) {
        this.markup = markup;
    }

    @Basic
    @Column(name = "trs_mkp")
    public String getTrsMkp() {
        return trsMkp;
    }

    public void setTrsMkp(String trsMkp) {
        this.trsMkp = trsMkp;
    }

    @Basic
    @Column(name = "dtr_mkp")
    public String getDtrMkp() {
        return dtrMkp;
    }

    public void setDtrMkp(String dtrMkp) {
        this.dtrMkp = dtrMkp;
    }

    @Basic
    @Column(name = "mtr_mkp")
    public String getMtrMkp() {
        return mtrMkp;
    }

    public void setMtrMkp(String mtrMkp) {
        this.mtrMkp = mtrMkp;
    }

    @Basic
    @Column(name = "otl_mkp")
    public String getOtlMkp() {
        return otlMkp;
    }

    public void setOtlMkp(String otlMkp) {
        this.otlMkp = otlMkp;
    }

    @Basic
    @Column(name = "grp_mkp")
    public String getGrpMkp() {
        return grpMkp;
    }

    public void setGrpMkp(String grpMkp) {
        this.grpMkp = grpMkp;
    }

    @Basic
    @Column(name = "evt_mkp")
    public String getEvtMkp() {
        return evtMkp;
    }

    public void setEvtMkp(String evtMkp) {
        this.evtMkp = evtMkp;
    }

    @Basic
    @Column(name = "deposit")
    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    @Basic
    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Basic
    @Column(name = "xml_status")
    public String getXmlStatus() {
        return xmlStatus;
    }

    public void setXmlStatus(String xmlStatus) {
        this.xmlStatus = xmlStatus;
    }

    @Basic
    @Column(name = "xml_storekey")
    public String getXmlStorekey() {
        return xmlStorekey;
    }

    public void setXmlStorekey(String xmlStorekey) {
        this.xmlStorekey = xmlStorekey;
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
    @Column(name = "activation")
    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    @Basic
    @Column(name = "created_date")
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubAgencyBean that = (SubAgencyBean) o;

        if (id != that.id) return false;
        if (gsaId != null ? !gsaId.equals(that.gsaId) : that.gsaId != null) return false;
        if (agentName != null ? !agentName.equals(that.agentName) : that.agentName != null) return false;
        if (typeOfAgency != null ? !typeOfAgency.equals(that.typeOfAgency) : that.typeOfAgency != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (jobTitle != null ? !jobTitle.equals(that.jobTitle) : that.jobTitle != null) return false;
        if (web != null ? !web.equals(that.web) : that.web != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;
        if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;
        if (billingAddress != null ? !billingAddress.equals(that.billingAddress) : that.billingAddress != null)
            return false;
        if (billingEmail != null ? !billingEmail.equals(that.billingEmail) : that.billingEmail != null) return false;
        if (iata != null ? !iata.equals(that.iata) : that.iata != null) return false;
        if (tursab != null ? !tursab.equals(that.tursab) : that.tursab != null) return false;
        if (clia != null ? !clia.equals(that.clia) : that.clia != null) return false;
        if (asta != null ? !asta.equals(that.asta) : that.asta != null) return false;
        if (other != null ? !other.equals(that.other) : that.other != null) return false;
        if (taxOffice != null ? !taxOffice.equals(that.taxOffice) : that.taxOffice != null) return false;
        if (taxNo != null ? !taxNo.equals(that.taxNo) : that.taxNo != null) return false;
        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;
        if (bankAddress != null ? !bankAddress.equals(that.bankAddress) : that.bankAddress != null) return false;
        if (bankCity != null ? !bankCity.equals(that.bankCity) : that.bankCity != null) return false;
        if (bankState != null ? !bankState.equals(that.bankState) : that.bankState != null) return false;
        if (bankCountry != null ? !bankCountry.equals(that.bankCountry) : that.bankCountry != null) return false;
        if (accountName != null ? !accountName.equals(that.accountName) : that.accountName != null) return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;
        if (iban != null ? !iban.equals(that.iban) : that.iban != null) return false;
        if (swift != null ? !swift.equals(that.swift) : that.swift != null) return false;
        if (commission != null ? !commission.equals(that.commission) : that.commission != null) return false;
        if (markup != null ? !markup.equals(that.markup) : that.markup != null) return false;
        if (trsMkp != null ? !trsMkp.equals(that.trsMkp) : that.trsMkp != null) return false;
        if (dtrMkp != null ? !dtrMkp.equals(that.dtrMkp) : that.dtrMkp != null) return false;
        if (mtrMkp != null ? !mtrMkp.equals(that.mtrMkp) : that.mtrMkp != null) return false;
        if (otlMkp != null ? !otlMkp.equals(that.otlMkp) : that.otlMkp != null) return false;
        if (grpMkp != null ? !grpMkp.equals(that.grpMkp) : that.grpMkp != null) return false;
        if (evtMkp != null ? !evtMkp.equals(that.evtMkp) : that.evtMkp != null) return false;
        if (deposit != null ? !deposit.equals(that.deposit) : that.deposit != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;
        if (xmlStatus != null ? !xmlStatus.equals(that.xmlStatus) : that.xmlStatus != null) return false;
        if (xmlStorekey != null ? !xmlStorekey.equals(that.xmlStorekey) : that.xmlStorekey != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (activation != null ? !activation.equals(that.activation) : that.activation != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (gsaId != null ? gsaId.hashCode() : 0);
        result = 31 * result + (agentName != null ? agentName.hashCode() : 0);
        result = 31 * result + (typeOfAgency != null ? typeOfAgency.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (web != null ? web.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (billingAddress != null ? billingAddress.hashCode() : 0);
        result = 31 * result + (billingEmail != null ? billingEmail.hashCode() : 0);
        result = 31 * result + (iata != null ? iata.hashCode() : 0);
        result = 31 * result + (tursab != null ? tursab.hashCode() : 0);
        result = 31 * result + (clia != null ? clia.hashCode() : 0);
        result = 31 * result + (asta != null ? asta.hashCode() : 0);
        result = 31 * result + (other != null ? other.hashCode() : 0);
        result = 31 * result + (taxOffice != null ? taxOffice.hashCode() : 0);
        result = 31 * result + (taxNo != null ? taxNo.hashCode() : 0);
        result = 31 * result + (bankName != null ? bankName.hashCode() : 0);
        result = 31 * result + (bankAddress != null ? bankAddress.hashCode() : 0);
        result = 31 * result + (bankCity != null ? bankCity.hashCode() : 0);
        result = 31 * result + (bankState != null ? bankState.hashCode() : 0);
        result = 31 * result + (bankCountry != null ? bankCountry.hashCode() : 0);
        result = 31 * result + (accountName != null ? accountName.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (iban != null ? iban.hashCode() : 0);
        result = 31 * result + (swift != null ? swift.hashCode() : 0);
        result = 31 * result + (commission != null ? commission.hashCode() : 0);
        result = 31 * result + (markup != null ? markup.hashCode() : 0);
        result = 31 * result + (trsMkp != null ? trsMkp.hashCode() : 0);
        result = 31 * result + (dtrMkp != null ? dtrMkp.hashCode() : 0);
        result = 31 * result + (mtrMkp != null ? mtrMkp.hashCode() : 0);
        result = 31 * result + (otlMkp != null ? otlMkp.hashCode() : 0);
        result = 31 * result + (grpMkp != null ? grpMkp.hashCode() : 0);
        result = 31 * result + (evtMkp != null ? evtMkp.hashCode() : 0);
        result = 31 * result + (deposit != null ? deposit.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (xmlStatus != null ? xmlStatus.hashCode() : 0);
        result = 31 * result + (xmlStorekey != null ? xmlStorekey.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (activation != null ? activation.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }
}
