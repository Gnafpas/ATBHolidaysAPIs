package Beans.ATBDBBeans.KalitaonSystem;

import javax.persistence.*;

/**
 * Created by George on 30/09/2017.
 */
@Entity
@Table(name = "sub_agency", schema = "atb_System_DB", catalog = "")
public class SubAgencyBean {
    private int id;
    private String gsaId;
    private String agentName;
    private String countryCode;
    private String pic;
    private String web;
    private String email;
    private String tel;
    private String fax;
    private String address;
    private String iata;
    private String tursab;
    private String clia;
    private String asta;
    private String other;
    private String taxOffice;
    private String taxNo;
    private String bankInfo;
    private String commission;
    private String markup;
    private String deposit;
    private String currency;
    private String masterUsercode;
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
    @Column(name = "country_code")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "pic")
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    @Column(name = "bank_info")
    public String getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(String bankInfo) {
        this.bankInfo = bankInfo;
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
    @Column(name = "master_usercode")
    public String getMasterUsercode() {
        return masterUsercode;
    }

    public void setMasterUsercode(String masterUsercode) {
        this.masterUsercode = masterUsercode;
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
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (pic != null ? !pic.equals(that.pic) : that.pic != null) return false;
        if (web != null ? !web.equals(that.web) : that.web != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (iata != null ? !iata.equals(that.iata) : that.iata != null) return false;
        if (tursab != null ? !tursab.equals(that.tursab) : that.tursab != null) return false;
        if (clia != null ? !clia.equals(that.clia) : that.clia != null) return false;
        if (asta != null ? !asta.equals(that.asta) : that.asta != null) return false;
        if (other != null ? !other.equals(that.other) : that.other != null) return false;
        if (taxOffice != null ? !taxOffice.equals(that.taxOffice) : that.taxOffice != null) return false;
        if (taxNo != null ? !taxNo.equals(that.taxNo) : that.taxNo != null) return false;
        if (bankInfo != null ? !bankInfo.equals(that.bankInfo) : that.bankInfo != null) return false;
        if (commission != null ? !commission.equals(that.commission) : that.commission != null) return false;
        if (markup != null ? !markup.equals(that.markup) : that.markup != null) return false;
        if (deposit != null ? !deposit.equals(that.deposit) : that.deposit != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (masterUsercode != null ? !masterUsercode.equals(that.masterUsercode) : that.masterUsercode != null)
            return false;
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
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        result = 31 * result + (web != null ? web.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (iata != null ? iata.hashCode() : 0);
        result = 31 * result + (tursab != null ? tursab.hashCode() : 0);
        result = 31 * result + (clia != null ? clia.hashCode() : 0);
        result = 31 * result + (asta != null ? asta.hashCode() : 0);
        result = 31 * result + (other != null ? other.hashCode() : 0);
        result = 31 * result + (taxOffice != null ? taxOffice.hashCode() : 0);
        result = 31 * result + (taxNo != null ? taxNo.hashCode() : 0);
        result = 31 * result + (bankInfo != null ? bankInfo.hashCode() : 0);
        result = 31 * result + (commission != null ? commission.hashCode() : 0);
        result = 31 * result + (markup != null ? markup.hashCode() : 0);
        result = 31 * result + (deposit != null ? deposit.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (masterUsercode != null ? masterUsercode.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (xmlStatus != null ? xmlStatus.hashCode() : 0);
        result = 31 * result + (xmlStorekey != null ? xmlStorekey.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (activation != null ? activation.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }
}
