
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for VehicleModifyRQAdditionalInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleModifyRQAdditionalInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SpecialReqPref" type="{http://www.opentravel.org/OTA/2003/05}VehicleSpecialReqPrefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CoveragePrefs" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleModifyRQAdditionalInfoTypeCoveragePref" minOccurs="0"/>
 *         &lt;element name="OffLocService" type="{http://www.opentravel.org/OTA/2003/05}OffLocationServiceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ArrivalDetails" type="{http://www.opentravel.org/OTA/2003/05}VehicleArrivalDetailsType" minOccurs="0"/>
 *         &lt;element name="RentalPaymentPref" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}PaymentDetailType">
 *                 &lt;attribute name="PaymentType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Reference" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type">
 *                 &lt;attribute name="DateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                 &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TourInfo" type="{http://www.opentravel.org/OTA/2003/05}VehicleTourInfoType" minOccurs="0"/>
 *         &lt;element name="WrittenConfInst" type="{http://www.opentravel.org/OTA/2003/05}WrittenConfInstType" minOccurs="0"/>
 *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="LuggageQty" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="PassengerQty" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="SmokingAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="GasPrePay" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleModifyRQAdditionalInfoType", propOrder = {
    "specialReqPref",
    "coveragePrefs",
    "offLocService",
    "arrivalDetails",
    "rentalPaymentPref",
    "reference",
    "tourInfo",
    "writtenConfInst",
    "tpaExtensions"
})
@XmlSeeAlso({
        DAOs.CarnectAPIDAOs.ServiceDAOs.VehModifyRQ.VehModifyRQInfo.class
})
public class VehicleModifyRQAdditionalInfoType {

    @XmlElement(name = "SpecialReqPref")
    protected List<VehicleSpecialReqPrefType> specialReqPref;
    @XmlElement(name = "CoveragePrefs")
    protected ArrayOfVehicleModifyRQAdditionalInfoTypeCoveragePref coveragePrefs;
    @XmlElement(name = "OffLocService")
    protected List<OffLocationServiceType> offLocService;
    @XmlElement(name = "ArrivalDetails")
    protected VehicleArrivalDetailsType arrivalDetails;
    @XmlElement(name = "RentalPaymentPref")
    protected List<VehicleModifyRQAdditionalInfoType.RentalPaymentPref> rentalPaymentPref;
    @XmlElement(name = "Reference")
    protected VehicleModifyRQAdditionalInfoType.Reference reference;
    @XmlElement(name = "TourInfo")
    protected VehicleTourInfoType tourInfo;
    @XmlElement(name = "WrittenConfInst")
    protected WrittenConfInstType writtenConfInst;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;
    @XmlAttribute(name = "LuggageQty")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger luggageQty;
    @XmlAttribute(name = "PassengerQty")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger passengerQty;
    @XmlAttribute(name = "SmokingAllowed")
    protected Boolean smokingAllowed;
    @XmlAttribute(name = "GasPrePay")
    protected Boolean gasPrePay;

    /**
     * Gets the value of the specialReqPref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialReqPref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecialReqPref().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleSpecialReqPrefType }
     * 
     * 
     */
    public List<VehicleSpecialReqPrefType> getSpecialReqPref() {
        if (specialReqPref == null) {
            specialReqPref = new ArrayList<VehicleSpecialReqPrefType>();
        }
        return this.specialReqPref;
    }

    /**
     * Gets the value of the coveragePrefs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleModifyRQAdditionalInfoTypeCoveragePref }
     *     
     */
    public ArrayOfVehicleModifyRQAdditionalInfoTypeCoveragePref getCoveragePrefs() {
        return coveragePrefs;
    }

    /**
     * Sets the value of the coveragePrefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleModifyRQAdditionalInfoTypeCoveragePref }
     *     
     */
    public void setCoveragePrefs(ArrayOfVehicleModifyRQAdditionalInfoTypeCoveragePref value) {
        this.coveragePrefs = value;
    }

    /**
     * Gets the value of the offLocService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offLocService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffLocService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OffLocationServiceType }
     * 
     * 
     */
    public List<OffLocationServiceType> getOffLocService() {
        if (offLocService == null) {
            offLocService = new ArrayList<OffLocationServiceType>();
        }
        return this.offLocService;
    }

    /**
     * Gets the value of the arrivalDetails property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleArrivalDetailsType }
     *     
     */
    public VehicleArrivalDetailsType getArrivalDetails() {
        return arrivalDetails;
    }

    /**
     * Sets the value of the arrivalDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleArrivalDetailsType }
     *     
     */
    public void setArrivalDetails(VehicleArrivalDetailsType value) {
        this.arrivalDetails = value;
    }

    /**
     * Gets the value of the rentalPaymentPref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentalPaymentPref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentalPaymentPref().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleModifyRQAdditionalInfoType.RentalPaymentPref }
     * 
     * 
     */
    public List<VehicleModifyRQAdditionalInfoType.RentalPaymentPref> getRentalPaymentPref() {
        if (rentalPaymentPref == null) {
            rentalPaymentPref = new ArrayList<VehicleModifyRQAdditionalInfoType.RentalPaymentPref>();
        }
        return this.rentalPaymentPref;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleModifyRQAdditionalInfoType.Reference }
     *     
     */
    public VehicleModifyRQAdditionalInfoType.Reference getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleModifyRQAdditionalInfoType.Reference }
     *     
     */
    public void setReference(VehicleModifyRQAdditionalInfoType.Reference value) {
        this.reference = value;
    }

    /**
     * Gets the value of the tourInfo property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleTourInfoType }
     *     
     */
    public VehicleTourInfoType getTourInfo() {
        return tourInfo;
    }

    /**
     * Sets the value of the tourInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleTourInfoType }
     *     
     */
    public void setTourInfo(VehicleTourInfoType value) {
        this.tourInfo = value;
    }

    /**
     * Gets the value of the writtenConfInst property.
     * 
     * @return
     *     possible object is
     *     {@link WrittenConfInstType }
     *     
     */
    public WrittenConfInstType getWrittenConfInst() {
        return writtenConfInst;
    }

    /**
     * Sets the value of the writtenConfInst property.
     * 
     * @param value
     *     allowed object is
     *     {@link WrittenConfInstType }
     *     
     */
    public void setWrittenConfInst(WrittenConfInstType value) {
        this.writtenConfInst = value;
    }

    /**
     * Gets the value of the tpaExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType }
     *     
     */
    public TPAExtensionsType getTPAExtensions() {
        return tpaExtensions;
    }

    /**
     * Sets the value of the tpaExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType }
     *     
     */
    public void setTPAExtensions(TPAExtensionsType value) {
        this.tpaExtensions = value;
    }

    /**
     * Gets the value of the luggageQty property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLuggageQty() {
        return luggageQty;
    }

    /**
     * Sets the value of the luggageQty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLuggageQty(BigInteger value) {
        this.luggageQty = value;
    }

    /**
     * Gets the value of the passengerQty property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPassengerQty() {
        return passengerQty;
    }

    /**
     * Sets the value of the passengerQty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPassengerQty(BigInteger value) {
        this.passengerQty = value;
    }

    /**
     * Gets the value of the smokingAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isSmokingAllowed() {
        if (smokingAllowed == null) {
            return false;
        } else {
            return smokingAllowed;
        }
    }

    /**
     * Sets the value of the smokingAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSmokingAllowed(Boolean value) {
        this.smokingAllowed = value;
    }

    /**
     * Gets the value of the gasPrePay property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isGasPrePay() {
        if (gasPrePay == null) {
            return false;
        } else {
            return gasPrePay;
        }
    }

    /**
     * Sets the value of the gasPrePay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGasPrePay(Boolean value) {
        this.gasPrePay = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type">
     *       &lt;attribute name="DateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *       &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Reference
        extends UniqueIDType
    {

        @XmlAttribute(name = "DateTime")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dateTime;
        @XmlAttribute(name = "Amount")
        protected BigDecimal amount;

        /**
         * Gets the value of the dateTime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDateTime() {
            return dateTime;
        }

        /**
         * Sets the value of the dateTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDateTime(XMLGregorianCalendar value) {
            this.dateTime = value;
        }

        /**
         * Gets the value of the amount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}PaymentDetailType">
     *       &lt;attribute name="PaymentType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class RentalPaymentPref
        extends PaymentDetailType
    {

        @XmlAttribute(name = "PaymentType")
        protected String paymentType;

        /**
         * Gets the value of the paymentType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentType() {
            return paymentType;
        }

        /**
         * Sets the value of the paymentType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentType(String value) {
            this.paymentType = value;
        }

    }

}
