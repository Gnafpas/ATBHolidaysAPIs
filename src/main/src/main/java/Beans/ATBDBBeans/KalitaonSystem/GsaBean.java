package Beans.ATBDBBeans.KalitaonSystem;

import javax.persistence.*;

/**
 * Created by George on 22/01/2018.
 */
@Entity
@Table(name = "GSA", schema = "atb_System_DB", catalog = "")
public class GsaBean {
    private int id;
    private String gsaName;
    private String countryCode;
    private String pic;
    private String tel;
    private String fax;
    private String mobile;
    private String email;
    private String address;
    private String iata;
    private String tursab;
    private String clia;
    private String asta;
    private String other;
    private String taxOffice;
    private String taxNo;
    private String bankInfo;
    private String trsMkp;
    private String mtrMkp;
    private String dtrMkp;
    private String otlMkp;
    private String grpMkp;
    private String evtMkp;
    private String nonrefTrsMkp;
    private String nonrefMtrMkp;
    private String nonrefDtrMkp;
    private String nonrefOtlMkp;
    private String nonrefEvtMkp;
    private String customCommission;
    private String deposit;
    private String currency;
    private String activation;
    private String createDate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gsa_name")
    public String getGsaName() {
        return gsaName;
    }

    public void setGsaName(String gsaName) {
        this.gsaName = gsaName;
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
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
    @Column(name = "OTHER")
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
    @Column(name = "trs_mkp")
    public String getTrsMkp() {
        return trsMkp;
    }

    public void setTrsMkp(String trsMkp) {
        this.trsMkp = trsMkp;
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
    @Column(name = "dtr_mkp")
    public String getDtrMkp() {
        return dtrMkp;
    }

    public void setDtrMkp(String dtrMkp) {
        this.dtrMkp = dtrMkp;
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
    @Column(name = "nonref_trs_mkp")
    public String getNonrefTrsMkp() {
        return nonrefTrsMkp;
    }

    public void setNonrefTrsMkp(String nonrefTrsMkp) {
        this.nonrefTrsMkp = nonrefTrsMkp;
    }

    @Basic
    @Column(name = "nonref_mtr_mkp")
    public String getNonrefMtrMkp() {
        return nonrefMtrMkp;
    }

    public void setNonrefMtrMkp(String nonrefMtrMkp) {
        this.nonrefMtrMkp = nonrefMtrMkp;
    }

    @Basic
    @Column(name = "nonref_dtr_mkp")
    public String getNonrefDtrMkp() {
        return nonrefDtrMkp;
    }

    public void setNonrefDtrMkp(String nonrefDtrMkp) {
        this.nonrefDtrMkp = nonrefDtrMkp;
    }

    @Basic
    @Column(name = "nonref_otl_mkp")
    public String getNonrefOtlMkp() {
        return nonrefOtlMkp;
    }

    public void setNonrefOtlMkp(String nonrefOtlMkp) {
        this.nonrefOtlMkp = nonrefOtlMkp;
    }

    @Basic
    @Column(name = "nonref_evt_mkp")
    public String getNonrefEvtMkp() {
        return nonrefEvtMkp;
    }

    public void setNonrefEvtMkp(String nonrefEvtMkp) {
        this.nonrefEvtMkp = nonrefEvtMkp;
    }

    @Basic
    @Column(name = "custom_commission")
    public String getCustomCommission() {
        return customCommission;
    }

    public void setCustomCommission(String customCommission) {
        this.customCommission = customCommission;
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
    @Column(name = "activation")
    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    @Basic
    @Column(name = "create_date")
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GsaBean gsaBean = (GsaBean) o;

        if (id != gsaBean.id) return false;
        if (gsaName != null ? !gsaName.equals(gsaBean.gsaName) : gsaBean.gsaName != null) return false;
        if (countryCode != null ? !countryCode.equals(gsaBean.countryCode) : gsaBean.countryCode != null) return false;
        if (pic != null ? !pic.equals(gsaBean.pic) : gsaBean.pic != null) return false;
        if (tel != null ? !tel.equals(gsaBean.tel) : gsaBean.tel != null) return false;
        if (fax != null ? !fax.equals(gsaBean.fax) : gsaBean.fax != null) return false;
        if (mobile != null ? !mobile.equals(gsaBean.mobile) : gsaBean.mobile != null) return false;
        if (email != null ? !email.equals(gsaBean.email) : gsaBean.email != null) return false;
        if (address != null ? !address.equals(gsaBean.address) : gsaBean.address != null) return false;
        if (iata != null ? !iata.equals(gsaBean.iata) : gsaBean.iata != null) return false;
        if (tursab != null ? !tursab.equals(gsaBean.tursab) : gsaBean.tursab != null) return false;
        if (clia != null ? !clia.equals(gsaBean.clia) : gsaBean.clia != null) return false;
        if (asta != null ? !asta.equals(gsaBean.asta) : gsaBean.asta != null) return false;
        if (other != null ? !other.equals(gsaBean.other) : gsaBean.other != null) return false;
        if (taxOffice != null ? !taxOffice.equals(gsaBean.taxOffice) : gsaBean.taxOffice != null) return false;
        if (taxNo != null ? !taxNo.equals(gsaBean.taxNo) : gsaBean.taxNo != null) return false;
        if (bankInfo != null ? !bankInfo.equals(gsaBean.bankInfo) : gsaBean.bankInfo != null) return false;
        if (trsMkp != null ? !trsMkp.equals(gsaBean.trsMkp) : gsaBean.trsMkp != null) return false;
        if (mtrMkp != null ? !mtrMkp.equals(gsaBean.mtrMkp) : gsaBean.mtrMkp != null) return false;
        if (dtrMkp != null ? !dtrMkp.equals(gsaBean.dtrMkp) : gsaBean.dtrMkp != null) return false;
        if (otlMkp != null ? !otlMkp.equals(gsaBean.otlMkp) : gsaBean.otlMkp != null) return false;
        if (grpMkp != null ? !grpMkp.equals(gsaBean.grpMkp) : gsaBean.grpMkp != null) return false;
        if (evtMkp != null ? !evtMkp.equals(gsaBean.evtMkp) : gsaBean.evtMkp != null) return false;
        if (nonrefTrsMkp != null ? !nonrefTrsMkp.equals(gsaBean.nonrefTrsMkp) : gsaBean.nonrefTrsMkp != null)
            return false;
        if (nonrefMtrMkp != null ? !nonrefMtrMkp.equals(gsaBean.nonrefMtrMkp) : gsaBean.nonrefMtrMkp != null)
            return false;
        if (nonrefDtrMkp != null ? !nonrefDtrMkp.equals(gsaBean.nonrefDtrMkp) : gsaBean.nonrefDtrMkp != null)
            return false;
        if (nonrefOtlMkp != null ? !nonrefOtlMkp.equals(gsaBean.nonrefOtlMkp) : gsaBean.nonrefOtlMkp != null)
            return false;
        if (nonrefEvtMkp != null ? !nonrefEvtMkp.equals(gsaBean.nonrefEvtMkp) : gsaBean.nonrefEvtMkp != null)
            return false;
        if (customCommission != null ? !customCommission.equals(gsaBean.customCommission) : gsaBean.customCommission != null)
            return false;
        if (deposit != null ? !deposit.equals(gsaBean.deposit) : gsaBean.deposit != null) return false;
        if (currency != null ? !currency.equals(gsaBean.currency) : gsaBean.currency != null) return false;
        if (activation != null ? !activation.equals(gsaBean.activation) : gsaBean.activation != null) return false;
        if (createDate != null ? !createDate.equals(gsaBean.createDate) : gsaBean.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (gsaName != null ? gsaName.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (iata != null ? iata.hashCode() : 0);
        result = 31 * result + (tursab != null ? tursab.hashCode() : 0);
        result = 31 * result + (clia != null ? clia.hashCode() : 0);
        result = 31 * result + (asta != null ? asta.hashCode() : 0);
        result = 31 * result + (other != null ? other.hashCode() : 0);
        result = 31 * result + (taxOffice != null ? taxOffice.hashCode() : 0);
        result = 31 * result + (taxNo != null ? taxNo.hashCode() : 0);
        result = 31 * result + (bankInfo != null ? bankInfo.hashCode() : 0);
        result = 31 * result + (trsMkp != null ? trsMkp.hashCode() : 0);
        result = 31 * result + (mtrMkp != null ? mtrMkp.hashCode() : 0);
        result = 31 * result + (dtrMkp != null ? dtrMkp.hashCode() : 0);
        result = 31 * result + (otlMkp != null ? otlMkp.hashCode() : 0);
        result = 31 * result + (grpMkp != null ? grpMkp.hashCode() : 0);
        result = 31 * result + (evtMkp != null ? evtMkp.hashCode() : 0);
        result = 31 * result + (nonrefTrsMkp != null ? nonrefTrsMkp.hashCode() : 0);
        result = 31 * result + (nonrefMtrMkp != null ? nonrefMtrMkp.hashCode() : 0);
        result = 31 * result + (nonrefDtrMkp != null ? nonrefDtrMkp.hashCode() : 0);
        result = 31 * result + (nonrefOtlMkp != null ? nonrefOtlMkp.hashCode() : 0);
        result = 31 * result + (nonrefEvtMkp != null ? nonrefEvtMkp.hashCode() : 0);
        result = 31 * result + (customCommission != null ? customCommission.hashCode() : 0);
        result = 31 * result + (deposit != null ? deposit.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (activation != null ? activation.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
