
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for VehicleAvailCoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleAvailCoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Vehicle" type="{http://www.opentravel.org/OTA/2003/05}VehicleType" minOccurs="0"/>
 *         &lt;element name="RentalRate" type="{http://www.opentravel.org/OTA/2003/05}VehicleRentalRateType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TotalCharge" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RateTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="EstimatedTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="RateConvertInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PricedEquips" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleEquipmentPricedType" minOccurs="0"/>
 *         &lt;element name="Fees" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleChargePurposeType1" minOccurs="0"/>
 *         &lt;element name="Reference" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type">
 *                 &lt;attribute name="DateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Vendor" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>CompanyNameType">
 *                 &lt;attribute name="ParticipationLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="VendorLocation" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>LocationType">
 *                 &lt;attribute name="ExtendedLocationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CounterLocation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CounterLocInfo">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="WalkToCar"/>
 *                       &lt;enumeration value="ShuttleToCar"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DropOffLocation" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>LocationType">
 *                 &lt;attribute name="ExtendedLocationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CounterLocation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Status" use="required" type="{http://www.opentravel.org/OTA/2003/05}InventoryStatusType" />
 *       &lt;attribute name="IsAlternateInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleAvailCoreType", propOrder = {
    "vehicle",
    "rentalRate",
    "totalCharge",
    "pricedEquips",
    "fees",
    "reference",
    "vendor",
    "vendorLocation",
    "dropOffLocation",
    "tpaExtensions"
})
public class VehicleAvailCoreType {

    @XmlElement(name = "Vehicle")
    protected VehicleType vehicle;
    @XmlElement(name = "RentalRate")
    protected List<VehicleRentalRateType> rentalRate;
    @XmlElement(name = "TotalCharge")
    protected List<VehicleAvailCoreType.TotalCharge> totalCharge;
    @XmlElement(name = "PricedEquips")
    protected ArrayOfVehicleEquipmentPricedType pricedEquips;
    @XmlElement(name = "Fees")
    protected ArrayOfVehicleChargePurposeType1 fees;
    @XmlElement(name = "Reference")
    protected VehicleAvailCoreType.Reference reference;
    @XmlElement(name = "Vendor")
    protected VehicleAvailCoreType.Vendor vendor;
    @XmlElement(name = "VendorLocation")
    protected VehicleAvailCoreType.VendorLocation vendorLocation;
    @XmlElement(name = "DropOffLocation")
    protected VehicleAvailCoreType.DropOffLocation dropOffLocation;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;
    @XmlAttribute(name = "Status", required = true)
    protected InventoryStatusType status;
    @XmlAttribute(name = "IsAlternateInd")
    protected Boolean isAlternateInd;

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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentalRate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentalRate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleRentalRateType }
     * 
     * 
     */
    public List<VehicleRentalRateType> getRentalRate() {
        if (rentalRate == null) {
            rentalRate = new ArrayList<VehicleRentalRateType>();
        }
        return this.rentalRate;
    }

    /**
     * Gets the value of the totalCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleAvailCoreType.TotalCharge }
     * 
     * 
     */
    public List<VehicleAvailCoreType.TotalCharge> getTotalCharge() {
        if (totalCharge == null) {
            totalCharge = new ArrayList<VehicleAvailCoreType.TotalCharge>();
        }
        return this.totalCharge;
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
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleAvailCoreType.Reference }
     *     
     */
    public VehicleAvailCoreType.Reference getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleAvailCoreType.Reference }
     *     
     */
    public void setReference(VehicleAvailCoreType.Reference value) {
        this.reference = value;
    }

    /**
     * Gets the value of the vendor property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleAvailCoreType.Vendor }
     *     
     */
    public VehicleAvailCoreType.Vendor getVendor() {
        return vendor;
    }

    /**
     * Sets the value of the vendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleAvailCoreType.Vendor }
     *     
     */
    public void setVendor(VehicleAvailCoreType.Vendor value) {
        this.vendor = value;
    }

    /**
     * Gets the value of the vendorLocation property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleAvailCoreType.VendorLocation }
     *     
     */
    public VehicleAvailCoreType.VendorLocation getVendorLocation() {
        return vendorLocation;
    }

    /**
     * Sets the value of the vendorLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleAvailCoreType.VendorLocation }
     *     
     */
    public void setVendorLocation(VehicleAvailCoreType.VendorLocation value) {
        this.vendorLocation = value;
    }

    /**
     * Gets the value of the dropOffLocation property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleAvailCoreType.DropOffLocation }
     *     
     */
    public VehicleAvailCoreType.DropOffLocation getDropOffLocation() {
        return dropOffLocation;
    }

    /**
     * Sets the value of the dropOffLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleAvailCoreType.DropOffLocation }
     *     
     */
    public void setDropOffLocation(VehicleAvailCoreType.DropOffLocation value) {
        this.dropOffLocation = value;
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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link InventoryStatusType }
     *     
     */
    public InventoryStatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link InventoryStatusType }
     *     
     */
    public void setStatus(InventoryStatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the isAlternateInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsAlternateInd() {
        return isAlternateInd;
    }

    /**
     * Sets the value of the isAlternateInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsAlternateInd(Boolean value) {
        this.isAlternateInd = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>LocationType">
     *       &lt;attribute name="ExtendedLocationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CounterLocation" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class DropOffLocation
        extends LocationType
    {

        @XmlAttribute(name = "ExtendedLocationCode")
        protected String extendedLocationCode;
        @XmlAttribute(name = "CounterLocation")
        protected String counterLocation;
        @XmlAttribute(name = "Name")
        protected String name;

        /**
         * Gets the value of the extendedLocationCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExtendedLocationCode() {
            return extendedLocationCode;
        }

        /**
         * Sets the value of the extendedLocationCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExtendedLocationCode(String value) {
            this.extendedLocationCode = value;
        }

        /**
         * Gets the value of the counterLocation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCounterLocation() {
            return counterLocation;
        }

        /**
         * Sets the value of the counterLocation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCounterLocation(String value) {
            this.counterLocation = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
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
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type">
     *       &lt;attribute name="DateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
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
     *       &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RateTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="EstimatedTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="RateConvertInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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

        @XmlAttribute(name = "CurrencyCode")
        protected String currencyCode;
        @XmlAttribute(name = "RateTotalAmount")
        protected BigDecimal rateTotalAmount;
        @XmlAttribute(name = "EstimatedTotalAmount")
        protected BigDecimal estimatedTotalAmount;
        @XmlAttribute(name = "RateConvertInd")
        protected Boolean rateConvertInd;

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

        /**
         * Gets the value of the rateConvertInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isRateConvertInd() {
            return rateConvertInd;
        }

        /**
         * Sets the value of the rateConvertInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setRateConvertInd(Boolean value) {
            this.rateConvertInd = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>CompanyNameType">
     *       &lt;attribute name="ParticipationLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Vendor
        extends CompanyNameType
    {

        @XmlAttribute(name = "ParticipationLevelCode")
        protected String participationLevelCode;

        /**
         * Gets the value of the participationLevelCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getParticipationLevelCode() {
            return participationLevelCode;
        }

        /**
         * Sets the value of the participationLevelCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setParticipationLevelCode(String value) {
            this.participationLevelCode = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>LocationType">
     *       &lt;attribute name="ExtendedLocationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CounterLocation" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CounterLocInfo">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="WalkToCar"/>
     *             &lt;enumeration value="ShuttleToCar"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class VendorLocation
        extends LocationType
    {

        @XmlAttribute(name = "ExtendedLocationCode")
        protected String extendedLocationCode;
        @XmlAttribute(name = "CounterLocation")
        protected String counterLocation;
        @XmlAttribute(name = "Name")
        protected String name;
        @XmlAttribute(name = "CounterLocInfo")
        protected String counterLocInfo;

        /**
         * Gets the value of the extendedLocationCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExtendedLocationCode() {
            return extendedLocationCode;
        }

        /**
         * Sets the value of the extendedLocationCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExtendedLocationCode(String value) {
            this.extendedLocationCode = value;
        }

        /**
         * Gets the value of the counterLocation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCounterLocation() {
            return counterLocation;
        }

        /**
         * Sets the value of the counterLocation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCounterLocation(String value) {
            this.counterLocation = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the counterLocInfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCounterLocInfo() {
            return counterLocInfo;
        }

        /**
         * Sets the value of the counterLocInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCounterLocInfo(String value) {
            this.counterLocInfo = value;
        }

    }

}
