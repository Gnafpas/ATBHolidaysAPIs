package Beans.ATBDBBeans.KalitaonSystem;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by George on 22/01/2018.
 */
@Entity
@Table(name = "bookings_all", schema = "atb_System_DB", catalog = "")
public class BookingsAllBean {
    private int id;
    private Timestamp bookingDate;
    private String basketId;
    private String productType;
    private String productTitle;
    private String bookingId;
    private String productId;
    private String planId;
    private String priceId;
    private String gsaId;
    private String topGsaName;
    private String agentId;
    private String agentName;
    private String supplierId;
    private String supplierName;
    private String countryName;
    private String cityName;
    private Date checkIn;
    private Date checkOut;
    private String supplierSale;
    private String supplierCurrency;
    private String gsaMarkup;
    private String gsaSale;
    private String agentMarkup;
    private String agentSale;
    private String agentCommission;
    private String agentEndSale;
    private String agentEndSaleCur;
    private String saleCurrency;
    private String payType;
    private String payDate;
    private String paying;
    private String adittionalRequest;
    private String basis;
    private String confirmationNo;
    private String xmlBookRef;
    private String xmlAgent;
    private String discountMarkup;
    private String discountAmount;
    private String invoiceNo;
    private String invoiceStatus;
    private String invoiceAmount;
    private String status;
    private String statusReason;
    private String updater;
    private String updateDate;
    private String tourLeader;
    private String totalPax;
    private String liveGuide;
    private String audioGuide;
    private String bookletGuide;
    private String contactCountryCode;
    private String contactTel;
    private String contactEmail;
    private String common1;
    private String common2;
    private String common3;
    private String common4;
    private String common5;
    private String common6;
    private String common7;
    private String common8;
    private String common9;
    private String common10;
    private String common11;
    private String common12;
    private String common13;
    private String common14;
    private String common15;
    private String posId;
    private String supplierReferences;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "booking_date")
    public Timestamp getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Timestamp bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Basic
    @Column(name = "basket_id")
    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    @Basic
    @Column(name = "product_type")
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "product_title")
    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
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
    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "plan_id")
    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @Basic
    @Column(name = "price_id")
    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
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
    @Column(name = "top_gsa_name")
    public String getTopGsaName() {
        return topGsaName;
    }

    public void setTopGsaName(String topGsaName) {
        this.topGsaName = topGsaName;
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
    @Column(name = "supplier_id")
    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
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
    @Column(name = "country_name")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
    @Column(name = "check_in")
    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    @Basic
    @Column(name = "check_out")
    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    @Basic
    @Column(name = "supplier_sale")
    public String getSupplierSale() {
        return supplierSale;
    }

    public void setSupplierSale(String supplierSale) {
        this.supplierSale = supplierSale;
    }

    @Basic
    @Column(name = "supplier_currency")
    public String getSupplierCurrency() {
        return supplierCurrency;
    }

    public void setSupplierCurrency(String supplierCurrency) {
        this.supplierCurrency = supplierCurrency;
    }

    @Basic
    @Column(name = "gsa_markup")
    public String getGsaMarkup() {
        return gsaMarkup;
    }

    public void setGsaMarkup(String gsaMarkup) {
        this.gsaMarkup = gsaMarkup;
    }

    @Basic
    @Column(name = "gsa_sale")
    public String getGsaSale() {
        return gsaSale;
    }

    public void setGsaSale(String gsaSale) {
        this.gsaSale = gsaSale;
    }

    @Basic
    @Column(name = "agent_markup")
    public String getAgentMarkup() {
        return agentMarkup;
    }

    public void setAgentMarkup(String agentMarkup) {
        this.agentMarkup = agentMarkup;
    }

    @Basic
    @Column(name = "agent_sale")
    public String getAgentSale() {
        return agentSale;
    }

    public void setAgentSale(String agentSale) {
        this.agentSale = agentSale;
    }

    @Basic
    @Column(name = "agent_commission")
    public String getAgentCommission() {
        return agentCommission;
    }

    public void setAgentCommission(String agentCommission) {
        this.agentCommission = agentCommission;
    }

    @Basic
    @Column(name = "agent_end_sale")
    public String getAgentEndSale() {
        return agentEndSale;
    }

    public void setAgentEndSale(String agentEndSale) {
        this.agentEndSale = agentEndSale;
    }

    @Basic
    @Column(name = "agent_end_sale_cur")
    public String getAgentEndSaleCur() {
        return agentEndSaleCur;
    }

    public void setAgentEndSaleCur(String agentEndSaleCur) {
        this.agentEndSaleCur = agentEndSaleCur;
    }

    @Basic
    @Column(name = "sale_currency")
    public String getSaleCurrency() {
        return saleCurrency;
    }

    public void setSaleCurrency(String saleCurrency) {
        this.saleCurrency = saleCurrency;
    }

    @Basic
    @Column(name = "pay_type")
    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Basic
    @Column(name = "pay_date")
    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    @Basic
    @Column(name = "paying")
    public String getPaying() {
        return paying;
    }

    public void setPaying(String paying) {
        this.paying = paying;
    }

    @Basic
    @Column(name = "adittional_request")
    public String getAdittionalRequest() {
        return adittionalRequest;
    }

    public void setAdittionalRequest(String adittionalRequest) {
        this.adittionalRequest = adittionalRequest;
    }

    @Basic
    @Column(name = "basis")
    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    @Basic
    @Column(name = "confirmation_no")
    public String getConfirmationNo() {
        return confirmationNo;
    }

    public void setConfirmationNo(String confirmationNo) {
        this.confirmationNo = confirmationNo;
    }

    @Basic
    @Column(name = "xml_book_ref")
    public String getXmlBookRef() {
        return xmlBookRef;
    }

    public void setXmlBookRef(String xmlBookRef) {
        this.xmlBookRef = xmlBookRef;
    }

    @Basic
    @Column(name = "xml_agent")
    public String getXmlAgent() {
        return xmlAgent;
    }

    public void setXmlAgent(String xmlAgent) {
        this.xmlAgent = xmlAgent;
    }

    @Basic
    @Column(name = "discount_markup")
    public String getDiscountMarkup() {
        return discountMarkup;
    }

    public void setDiscountMarkup(String discountMarkup) {
        this.discountMarkup = discountMarkup;
    }

    @Basic
    @Column(name = "discount_amount")
    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Basic
    @Column(name = "invoice_no")
    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    @Basic
    @Column(name = "invoice_status")
    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    @Basic
    @Column(name = "invoice_amount")
    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "status_reason")
    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    @Basic
    @Column(name = "updater")
    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    @Basic
    @Column(name = "update_date")
    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "tour_leader")
    public String getTourLeader() {
        return tourLeader;
    }

    public void setTourLeader(String tourLeader) {
        this.tourLeader = tourLeader;
    }

    @Basic
    @Column(name = "total_pax")
    public String getTotalPax() {
        return totalPax;
    }

    public void setTotalPax(String totalPax) {
        this.totalPax = totalPax;
    }

    @Basic
    @Column(name = "live_guide")
    public String getLiveGuide() {
        return liveGuide;
    }

    public void setLiveGuide(String liveGuide) {
        this.liveGuide = liveGuide;
    }

    @Basic
    @Column(name = "audio_guide")
    public String getAudioGuide() {
        return audioGuide;
    }

    public void setAudioGuide(String audioGuide) {
        this.audioGuide = audioGuide;
    }

    @Basic
    @Column(name = "booklet_guide")
    public String getBookletGuide() {
        return bookletGuide;
    }

    public void setBookletGuide(String bookletGuide) {
        this.bookletGuide = bookletGuide;
    }

    @Basic
    @Column(name = "contact_country_code")
    public String getContactCountryCode() {
        return contactCountryCode;
    }

    public void setContactCountryCode(String contactCountryCode) {
        this.contactCountryCode = contactCountryCode;
    }

    @Basic
    @Column(name = "contact_tel")
    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    @Basic
    @Column(name = "contact_email")
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Basic
    @Column(name = "common_1")
    public String getCommon1() {
        return common1;
    }

    public void setCommon1(String common1) {
        this.common1 = common1;
    }

    @Basic
    @Column(name = "common_2")
    public String getCommon2() {
        return common2;
    }

    public void setCommon2(String common2) {
        this.common2 = common2;
    }

    @Basic
    @Column(name = "common_3")
    public String getCommon3() {
        return common3;
    }

    public void setCommon3(String common3) {
        this.common3 = common3;
    }

    @Basic
    @Column(name = "common_4")
    public String getCommon4() {
        return common4;
    }

    public void setCommon4(String common4) {
        this.common4 = common4;
    }

    @Basic
    @Column(name = "common_5")
    public String getCommon5() {
        return common5;
    }

    public void setCommon5(String common5) {
        this.common5 = common5;
    }

    @Basic
    @Column(name = "common_6")
    public String getCommon6() {
        return common6;
    }

    public void setCommon6(String common6) {
        this.common6 = common6;
    }

    @Basic
    @Column(name = "common_7")
    public String getCommon7() {
        return common7;
    }

    public void setCommon7(String common7) {
        this.common7 = common7;
    }

    @Basic
    @Column(name = "common_8")
    public String getCommon8() {
        return common8;
    }

    public void setCommon8(String common8) {
        this.common8 = common8;
    }

    @Basic
    @Column(name = "common_9")
    public String getCommon9() {
        return common9;
    }

    public void setCommon9(String common9) {
        this.common9 = common9;
    }

    @Basic
    @Column(name = "common_10")
    public String getCommon10() {
        return common10;
    }

    public void setCommon10(String common10) {
        this.common10 = common10;
    }

    @Basic
    @Column(name = "common_11")
    public String getCommon11() {
        return common11;
    }

    public void setCommon11(String common11) {
        this.common11 = common11;
    }

    @Basic
    @Column(name = "common_12")
    public String getCommon12() {
        return common12;
    }

    public void setCommon12(String common12) {
        this.common12 = common12;
    }

    @Basic
    @Column(name = "common_13")
    public String getCommon13() {
        return common13;
    }

    public void setCommon13(String common13) {
        this.common13 = common13;
    }

    @Basic
    @Column(name = "common_14")
    public String getCommon14() {
        return common14;
    }

    public void setCommon14(String common14) {
        this.common14 = common14;
    }

    @Basic
    @Column(name = "common_15")
    public String getCommon15() {
        return common15;
    }

    public void setCommon15(String common15) {
        this.common15 = common15;
    }

    @Basic
    @Column(name = "pos_id")
    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    @Basic
    @Column(name = "supplier_references")
    public String getSupplierReferences() {
        return supplierReferences;
    }

    public void setSupplierReferences(String supplierReferences) {
        this.supplierReferences = supplierReferences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingsAllBean that = (BookingsAllBean) o;

        if (id != that.id) return false;
        if (bookingDate != null ? !bookingDate.equals(that.bookingDate) : that.bookingDate != null) return false;
        if (basketId != null ? !basketId.equals(that.basketId) : that.basketId != null) return false;
        if (productType != null ? !productType.equals(that.productType) : that.productType != null) return false;
        if (productTitle != null ? !productTitle.equals(that.productTitle) : that.productTitle != null) return false;
        if (bookingId != null ? !bookingId.equals(that.bookingId) : that.bookingId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (planId != null ? !planId.equals(that.planId) : that.planId != null) return false;
        if (priceId != null ? !priceId.equals(that.priceId) : that.priceId != null) return false;
        if (gsaId != null ? !gsaId.equals(that.gsaId) : that.gsaId != null) return false;
        if (topGsaName != null ? !topGsaName.equals(that.topGsaName) : that.topGsaName != null) return false;
        if (agentId != null ? !agentId.equals(that.agentId) : that.agentId != null) return false;
        if (agentName != null ? !agentName.equals(that.agentName) : that.agentName != null) return false;
        if (supplierId != null ? !supplierId.equals(that.supplierId) : that.supplierId != null) return false;
        if (supplierName != null ? !supplierName.equals(that.supplierName) : that.supplierName != null) return false;
        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;
        if (checkIn != null ? !checkIn.equals(that.checkIn) : that.checkIn != null) return false;
        if (checkOut != null ? !checkOut.equals(that.checkOut) : that.checkOut != null) return false;
        if (supplierSale != null ? !supplierSale.equals(that.supplierSale) : that.supplierSale != null) return false;
        if (supplierCurrency != null ? !supplierCurrency.equals(that.supplierCurrency) : that.supplierCurrency != null)
            return false;
        if (gsaMarkup != null ? !gsaMarkup.equals(that.gsaMarkup) : that.gsaMarkup != null) return false;
        if (gsaSale != null ? !gsaSale.equals(that.gsaSale) : that.gsaSale != null) return false;
        if (agentMarkup != null ? !agentMarkup.equals(that.agentMarkup) : that.agentMarkup != null) return false;
        if (agentSale != null ? !agentSale.equals(that.agentSale) : that.agentSale != null) return false;
        if (agentCommission != null ? !agentCommission.equals(that.agentCommission) : that.agentCommission != null)
            return false;
        if (agentEndSale != null ? !agentEndSale.equals(that.agentEndSale) : that.agentEndSale != null) return false;
        if (agentEndSaleCur != null ? !agentEndSaleCur.equals(that.agentEndSaleCur) : that.agentEndSaleCur != null)
            return false;
        if (saleCurrency != null ? !saleCurrency.equals(that.saleCurrency) : that.saleCurrency != null) return false;
        if (payType != null ? !payType.equals(that.payType) : that.payType != null) return false;
        if (payDate != null ? !payDate.equals(that.payDate) : that.payDate != null) return false;
        if (paying != null ? !paying.equals(that.paying) : that.paying != null) return false;
        if (adittionalRequest != null ? !adittionalRequest.equals(that.adittionalRequest) : that.adittionalRequest != null)
            return false;
        if (basis != null ? !basis.equals(that.basis) : that.basis != null) return false;
        if (confirmationNo != null ? !confirmationNo.equals(that.confirmationNo) : that.confirmationNo != null)
            return false;
        if (xmlBookRef != null ? !xmlBookRef.equals(that.xmlBookRef) : that.xmlBookRef != null) return false;
        if (xmlAgent != null ? !xmlAgent.equals(that.xmlAgent) : that.xmlAgent != null) return false;
        if (discountMarkup != null ? !discountMarkup.equals(that.discountMarkup) : that.discountMarkup != null)
            return false;
        if (discountAmount != null ? !discountAmount.equals(that.discountAmount) : that.discountAmount != null)
            return false;
        if (invoiceNo != null ? !invoiceNo.equals(that.invoiceNo) : that.invoiceNo != null) return false;
        if (invoiceStatus != null ? !invoiceStatus.equals(that.invoiceStatus) : that.invoiceStatus != null)
            return false;
        if (invoiceAmount != null ? !invoiceAmount.equals(that.invoiceAmount) : that.invoiceAmount != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (statusReason != null ? !statusReason.equals(that.statusReason) : that.statusReason != null) return false;
        if (updater != null ? !updater.equals(that.updater) : that.updater != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (tourLeader != null ? !tourLeader.equals(that.tourLeader) : that.tourLeader != null) return false;
        if (totalPax != null ? !totalPax.equals(that.totalPax) : that.totalPax != null) return false;
        if (liveGuide != null ? !liveGuide.equals(that.liveGuide) : that.liveGuide != null) return false;
        if (audioGuide != null ? !audioGuide.equals(that.audioGuide) : that.audioGuide != null) return false;
        if (bookletGuide != null ? !bookletGuide.equals(that.bookletGuide) : that.bookletGuide != null) return false;
        if (contactCountryCode != null ? !contactCountryCode.equals(that.contactCountryCode) : that.contactCountryCode != null)
            return false;
        if (contactTel != null ? !contactTel.equals(that.contactTel) : that.contactTel != null) return false;
        if (contactEmail != null ? !contactEmail.equals(that.contactEmail) : that.contactEmail != null) return false;
        if (common1 != null ? !common1.equals(that.common1) : that.common1 != null) return false;
        if (common2 != null ? !common2.equals(that.common2) : that.common2 != null) return false;
        if (common3 != null ? !common3.equals(that.common3) : that.common3 != null) return false;
        if (common4 != null ? !common4.equals(that.common4) : that.common4 != null) return false;
        if (common5 != null ? !common5.equals(that.common5) : that.common5 != null) return false;
        if (common6 != null ? !common6.equals(that.common6) : that.common6 != null) return false;
        if (common7 != null ? !common7.equals(that.common7) : that.common7 != null) return false;
        if (common8 != null ? !common8.equals(that.common8) : that.common8 != null) return false;
        if (common9 != null ? !common9.equals(that.common9) : that.common9 != null) return false;
        if (common10 != null ? !common10.equals(that.common10) : that.common10 != null) return false;
        if (common11 != null ? !common11.equals(that.common11) : that.common11 != null) return false;
        if (common12 != null ? !common12.equals(that.common12) : that.common12 != null) return false;
        if (common13 != null ? !common13.equals(that.common13) : that.common13 != null) return false;
        if (common14 != null ? !common14.equals(that.common14) : that.common14 != null) return false;
        if (common15 != null ? !common15.equals(that.common15) : that.common15 != null) return false;
        if (posId != null ? !posId.equals(that.posId) : that.posId != null) return false;
        if (supplierReferences != null ? !supplierReferences.equals(that.supplierReferences) : that.supplierReferences != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bookingDate != null ? bookingDate.hashCode() : 0);
        result = 31 * result + (basketId != null ? basketId.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (productTitle != null ? productTitle.hashCode() : 0);
        result = 31 * result + (bookingId != null ? bookingId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (planId != null ? planId.hashCode() : 0);
        result = 31 * result + (priceId != null ? priceId.hashCode() : 0);
        result = 31 * result + (gsaId != null ? gsaId.hashCode() : 0);
        result = 31 * result + (topGsaName != null ? topGsaName.hashCode() : 0);
        result = 31 * result + (agentId != null ? agentId.hashCode() : 0);
        result = 31 * result + (agentName != null ? agentName.hashCode() : 0);
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
        result = 31 * result + (supplierName != null ? supplierName.hashCode() : 0);
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (checkIn != null ? checkIn.hashCode() : 0);
        result = 31 * result + (checkOut != null ? checkOut.hashCode() : 0);
        result = 31 * result + (supplierSale != null ? supplierSale.hashCode() : 0);
        result = 31 * result + (supplierCurrency != null ? supplierCurrency.hashCode() : 0);
        result = 31 * result + (gsaMarkup != null ? gsaMarkup.hashCode() : 0);
        result = 31 * result + (gsaSale != null ? gsaSale.hashCode() : 0);
        result = 31 * result + (agentMarkup != null ? agentMarkup.hashCode() : 0);
        result = 31 * result + (agentSale != null ? agentSale.hashCode() : 0);
        result = 31 * result + (agentCommission != null ? agentCommission.hashCode() : 0);
        result = 31 * result + (agentEndSale != null ? agentEndSale.hashCode() : 0);
        result = 31 * result + (agentEndSaleCur != null ? agentEndSaleCur.hashCode() : 0);
        result = 31 * result + (saleCurrency != null ? saleCurrency.hashCode() : 0);
        result = 31 * result + (payType != null ? payType.hashCode() : 0);
        result = 31 * result + (payDate != null ? payDate.hashCode() : 0);
        result = 31 * result + (paying != null ? paying.hashCode() : 0);
        result = 31 * result + (adittionalRequest != null ? adittionalRequest.hashCode() : 0);
        result = 31 * result + (basis != null ? basis.hashCode() : 0);
        result = 31 * result + (confirmationNo != null ? confirmationNo.hashCode() : 0);
        result = 31 * result + (xmlBookRef != null ? xmlBookRef.hashCode() : 0);
        result = 31 * result + (xmlAgent != null ? xmlAgent.hashCode() : 0);
        result = 31 * result + (discountMarkup != null ? discountMarkup.hashCode() : 0);
        result = 31 * result + (discountAmount != null ? discountAmount.hashCode() : 0);
        result = 31 * result + (invoiceNo != null ? invoiceNo.hashCode() : 0);
        result = 31 * result + (invoiceStatus != null ? invoiceStatus.hashCode() : 0);
        result = 31 * result + (invoiceAmount != null ? invoiceAmount.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (statusReason != null ? statusReason.hashCode() : 0);
        result = 31 * result + (updater != null ? updater.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (tourLeader != null ? tourLeader.hashCode() : 0);
        result = 31 * result + (totalPax != null ? totalPax.hashCode() : 0);
        result = 31 * result + (liveGuide != null ? liveGuide.hashCode() : 0);
        result = 31 * result + (audioGuide != null ? audioGuide.hashCode() : 0);
        result = 31 * result + (bookletGuide != null ? bookletGuide.hashCode() : 0);
        result = 31 * result + (contactCountryCode != null ? contactCountryCode.hashCode() : 0);
        result = 31 * result + (contactTel != null ? contactTel.hashCode() : 0);
        result = 31 * result + (contactEmail != null ? contactEmail.hashCode() : 0);
        result = 31 * result + (common1 != null ? common1.hashCode() : 0);
        result = 31 * result + (common2 != null ? common2.hashCode() : 0);
        result = 31 * result + (common3 != null ? common3.hashCode() : 0);
        result = 31 * result + (common4 != null ? common4.hashCode() : 0);
        result = 31 * result + (common5 != null ? common5.hashCode() : 0);
        result = 31 * result + (common6 != null ? common6.hashCode() : 0);
        result = 31 * result + (common7 != null ? common7.hashCode() : 0);
        result = 31 * result + (common8 != null ? common8.hashCode() : 0);
        result = 31 * result + (common9 != null ? common9.hashCode() : 0);
        result = 31 * result + (common10 != null ? common10.hashCode() : 0);
        result = 31 * result + (common11 != null ? common11.hashCode() : 0);
        result = 31 * result + (common12 != null ? common12.hashCode() : 0);
        result = 31 * result + (common13 != null ? common13.hashCode() : 0);
        result = 31 * result + (common14 != null ? common14.hashCode() : 0);
        result = 31 * result + (common15 != null ? common15.hashCode() : 0);
        result = 31 * result + (posId != null ? posId.hashCode() : 0);
        result = 31 * result + (supplierReferences != null ? supplierReferences.hashCode() : 0);
        return result;
    }
}
