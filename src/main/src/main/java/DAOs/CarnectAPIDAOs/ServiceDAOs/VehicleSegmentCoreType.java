
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleSegmentCoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleSegmentCoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConfID" type="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Vendor" type="{http://www.opentravel.org/OTA/2003/05}CompanyNameType" minOccurs="0"/>
 *         &lt;element name="VehRentalCore" type="{http://www.opentravel.org/OTA/2003/05}VehicleRentalCoreType" minOccurs="0"/>
 *         &lt;element name="Vehicle" type="{http://www.opentravel.org/OTA/2003/05}VehicleType" minOccurs="0"/>
 *         &lt;element name="RentalRate" type="{http://www.opentravel.org/OTA/2003/05}VehicleRentalRateType" minOccurs="0"/>
 *         &lt;element name="PricedEquips" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleEquipmentPricedType" minOccurs="0"/>
 *         &lt;element name="Fees" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleChargePurposeType1" minOccurs="0"/>
 *         &lt;element name="TotalCharge" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="RateTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="EstimatedTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="IndexNumber" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleSegmentCoreType", propOrder = {
    "confID",
    "vendor",
    "vehRentalCore",
    "vehicle",
    "rentalRate",
    "pricedEquips",
    "fees",
    "totalCharge",
    "tpaExtensions"
})
@XmlSeeAlso({
        VehicleReservationType.VehSegmentCore.class
})
public class VehicleSegmentCoreType {

    @XmlElement(name = "ConfID")
    protected List<UniqueIDType> confID;
    @XmlElement(name = "Vendor")
    protected CompanyNameType vendor;
    @XmlElement(name = "VehRentalCore")
    protected VehicleRentalCoreType vehRentalCore;
    @XmlElement(name = "Vehicle")
    protected VehicleType vehicle;
    @XmlElement(name = "RentalRate")
    protected VehicleRentalRateType rentalRate;
    @XmlElement(name = "PricedEquips")
    protected ArrayOfVehicleEquipmentPricedType pricedEquips;
    @XmlElement(name = "Fees")
    protected ArrayOfVehicleChargePurposeType1 fees;
    @XmlElement(name = "TotalCharge")
    protected VehicleSegmentCoreType.TotalCharge totalCharge;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;
    @XmlAttribute(name = "IndexNumber")
    protected BigInteger indexNumber;

    /**
     * Gets the value of the confID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the confID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UniqueIDType }
     * 
     * 
     */
    public List<UniqueIDType> getConfID() {
        if (confID == null) {
            confID = new ArrayList<UniqueIDType>();
        }
        return this.confID;
    }

    /**
     * Gets the value of the vendor property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyNameType }
     *     
     */
    public CompanyNameType getVendor() {
        return vendor;
    }

    /**
     * Sets the value of the vendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyNameType }
     *     
     */
    public void setVendor(CompanyNameType value) {
        this.vendor = value;
    }

    /**
     * Gets the value of the vehRentalCore property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleRentalCoreType }
     *     
     */
    public VehicleRentalCoreType getVehRentalCore() {
        return vehRentalCore;
    }

    /**
     * Sets the value of the vehRentalCore property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleRentalCoreType }
     *     
     */
    public void setVehRentalCore(VehicleRentalCoreType value) {
        this.vehRentalCore = value;
    }

    /**
     * Gets the value of the vehicle property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleType }
     *     
     */
    public VehicleType getVehicle() {
        return vehicle;
    }

    /**
     * Sets the value of the vehicle property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleType }
     *     
     */
    public void setVehicle(VehicleType value) {
        this.vehicle = value;
    }

    /**
     * Gets the value of the rentalRate property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleRentalRateType }
     *     
     */
    public VehicleRentalRateType getRentalRate() {
        return rentalRate;
    }

    /**
     * Sets the value of the rentalRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleRentalRateType }
     *     
     */
    public void setRentalRate(VehicleRentalRateType value) {
        this.rentalRate = value;
    }

    /**
     * Gets the value of the pricedEquips property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleEquipmentPricedType }
     *     
     */
    public ArrayOfVehicleEquipmentPricedType getPricedEquips() {
        return pricedEquips;
    }

    /**
     * Sets the value of the pricedEquips property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleEquipmentPricedType }
     *     
     */
    public void setPricedEquips(ArrayOfVehicleEquipmentPricedType value) {
        this.pricedEquips = value;
    }

    /**
     * Gets the value of the fees property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleChargePurposeType1 }
     *     
     */
    public ArrayOfVehicleChargePurposeType1 getFees() {
        return fees;
    }

    /**
     * Sets the value of the fees property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleChargePurposeType1 }
     *     
     */
    public void setFees(ArrayOfVehicleChargePurposeType1 value) {
        this.fees = value;
    }

    /**
     * Gets the value of the totalCharge property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleSegmentCoreType.TotalCharge }
     *     
     */
    public VehicleSegmentCoreType.TotalCharge getTotalCharge() {
        return totalCharge;
    }

    /**
     * Sets the value of the totalCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleSegmentCoreType.TotalCharge }
     *     
     */
    public void setTotalCharge(VehicleSegmentCoreType.TotalCharge value) {
        this.totalCharge = value;
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
     * Gets the value of the indexNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIndexNumber() {
        return indexNumber;
    }

    /**
     * Sets the value of the indexNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIndexNumber(BigInteger value) {
        this.indexNumber = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="RateTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="EstimatedTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TotalCharge {

        @XmlAttribute(name = "RateTotalAmount")
        protected BigDecimal rateTotalAmount;
        @XmlAttribute(name = "CurrencyCode")
        protected String currencyCode;
        @XmlAttribute(name = "EstimatedTotalAmount")
        protected BigDecimal estimatedTotalAmount;

        /**
         * Gets the value of the rateTotalAmount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getRateTotalAmount() {
            return rateTotalAmount;
        }

        /**
         * Sets the value of the rateTotalAmount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setRateTotalAmount(BigDecimal value) {
            this.rateTotalAmount = value;
        }

        /**
         * Gets the value of the currencyCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCurrencyCode() {
            return currencyCode;
        }

        /**
         * Sets the value of the currencyCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCurrencyCode(String value) {
            this.currencyCode = value;
        }

        /**
         * Gets the value of the estimatedTotalAmount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getEstimatedTotalAmount() {
            return estimatedTotalAmount;
        }

        /**
         * Sets the value of the estimatedTotalAmount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setEstimatedTotalAmount(BigDecimal value) {
            this.estimatedTotalAmount = value;
        }

    }

}
