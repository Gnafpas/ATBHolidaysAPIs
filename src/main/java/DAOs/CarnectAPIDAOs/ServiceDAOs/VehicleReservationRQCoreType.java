
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


/**
 * <p>Java class for VehicleReservationRQCoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleReservationRQCoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UniqueID" type="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="VehRentalCore" type="{http://www.opentravel.org/OTA/2003/05}VehicleRentalCoreType" minOccurs="0"/>
 *         &lt;element name="Customer" type="{http://www.opentravel.org/OTA/2003/05}CustomerPrimaryAdditionalType" minOccurs="0"/>
 *         &lt;element name="VendorPref" type="{http://www.opentravel.org/OTA/2003/05}CompanyNamePrefType" minOccurs="0"/>
 *         &lt;element name="VehPref" type="{http://www.opentravel.org/OTA/2003/05}VehiclePrefType" minOccurs="0"/>
 *         &lt;element name="DriverType" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Age" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RateQualifier" type="{http://www.opentravel.org/OTA/2003/05}RateQualifierType" minOccurs="0"/>
 *         &lt;element name="Fees" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleChargePurposeType1" minOccurs="0"/>
 *         &lt;element name="VehicleCharges" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleChargePurposeType" minOccurs="0"/>
 *         &lt;element name="SpecialEquipPrefs" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SpecialEquipPref" type="{http://www.opentravel.org/OTA/2003/05}VehicleReservationRQCoreTypeSpecialEquipPrefsSpecialEquipPref" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="Charge" type="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RateDistance" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Unlimited" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *                 &lt;attribute name="DistUnitName" type="{http://www.opentravel.org/OTA/2003/05}DistanceUnitNameType" />
 *                 &lt;attribute name="VehiclePeriodUnitName" type="{http://www.opentravel.org/OTA/2003/05}VehiclePeriodUnitNameType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TotalCharge" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="RateTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="EstimatedTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Queue" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="PseudoCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="QueueNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="QueueCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="SystemCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="QueueID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleReservationRQCoreType", propOrder = {
    "uniqueID",
    "vehRentalCore",
    "customer",
    "vendorPref",
    "vehPref",
    "driverType",
    "rateQualifier",
    "fees",
    "vehicleCharges",
    "specialEquipPrefs",
    "rateDistance",
    "totalCharge",
    "queue",
    "tpaExtensions"
})
@XmlSeeAlso({
        DAOs.CarnectAPIDAOs.ServiceDAOs.VehResRQ.VehResRQCore.class
})
public class VehicleReservationRQCoreType {

    @XmlElement(name = "UniqueID")
    protected List<UniqueIDType> uniqueID;
    @XmlElement(name = "VehRentalCore")
    protected VehicleRentalCoreType vehRentalCore;
    @XmlElement(name = "Customer")
    protected CustomerPrimaryAdditionalType customer;
    @XmlElement(name = "VendorPref")
    protected CompanyNamePrefType vendorPref;
    @XmlElement(name = "VehPref")
    protected VehiclePrefType vehPref;
    @XmlElement(name = "DriverType")
    protected List<VehicleReservationRQCoreType.DriverType> driverType;
    @XmlElement(name = "RateQualifier")
    protected RateQualifierType rateQualifier;
    @XmlElement(name = "Fees")
    protected ArrayOfVehicleChargePurposeType1 fees;
    @XmlElement(name = "VehicleCharges")
    protected ArrayOfVehicleChargePurposeType vehicleCharges;
    @XmlElement(name = "SpecialEquipPrefs")
    protected VehicleReservationRQCoreType.SpecialEquipPrefs specialEquipPrefs;
    @XmlElement(name = "RateDistance")
    protected List<VehicleReservationRQCoreType.RateDistance> rateDistance;
    @XmlElement(name = "TotalCharge")
    protected VehicleReservationRQCoreType.TotalCharge totalCharge;
    @XmlElement(name = "Queue")
    protected VehicleReservationRQCoreType.Queue queue;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;
    @XmlAttribute(name = "Status")
    protected String status;

    /**
     * Gets the value of the uniqueID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uniqueID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUniqueID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UniqueIDType }
     * 
     * 
     */
    public List<UniqueIDType> getUniqueID() {
        if (uniqueID == null) {
            uniqueID = new ArrayList<UniqueIDType>();
        }
        return this.uniqueID;
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
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerPrimaryAdditionalType }
     *     
     */
    public CustomerPrimaryAdditionalType getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerPrimaryAdditionalType }
     *     
     */
    public void setCustomer(CustomerPrimaryAdditionalType value) {
        this.customer = value;
    }

    /**
     * Gets the value of the vendorPref property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyNamePrefType }
     *     
     */
    public CompanyNamePrefType getVendorPref() {
        return vendorPref;
    }

    /**
     * Sets the value of the vendorPref property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyNamePrefType }
     *     
     */
    public void setVendorPref(CompanyNamePrefType value) {
        this.vendorPref = value;
    }

    /**
     * Gets the value of the vehPref property.
     * 
     * @return
     *     possible object is
     *     {@link VehiclePrefType }
     *     
     */
    public VehiclePrefType getVehPref() {
        return vehPref;
    }

    /**
     * Sets the value of the vehPref property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehiclePrefType }
     *     
     */
    public void setVehPref(VehiclePrefType value) {
        this.vehPref = value;
    }

    /**
     * Gets the value of the driverType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the driverType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDriverType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleReservationRQCoreType.DriverType }
     * 
     * 
     */
    public List<VehicleReservationRQCoreType.DriverType> getDriverType() {
        if (driverType == null) {
            driverType = new ArrayList<VehicleReservationRQCoreType.DriverType>();
        }
        return this.driverType;
    }

    /**
     * Gets the value of the rateQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link RateQualifierType }
     *     
     */
    public RateQualifierType getRateQualifier() {
        return rateQualifier;
    }

    /**
     * Sets the value of the rateQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateQualifierType }
     *     
     */
    public void setRateQualifier(RateQualifierType value) {
        this.rateQualifier = value;
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
     * Gets the value of the vehicleCharges property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleChargePurposeType }
     *     
     */
    public ArrayOfVehicleChargePurposeType getVehicleCharges() {
        return vehicleCharges;
    }

    /**
     * Sets the value of the vehicleCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleChargePurposeType }
     *     
     */
    public void setVehicleCharges(ArrayOfVehicleChargePurposeType value) {
        this.vehicleCharges = value;
    }

    /**
     * Gets the value of the specialEquipPrefs property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleReservationRQCoreType.SpecialEquipPrefs }
     *     
     */
    public VehicleReservationRQCoreType.SpecialEquipPrefs getSpecialEquipPrefs() {
        return specialEquipPrefs;
    }

    /**
     * Sets the value of the specialEquipPrefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleReservationRQCoreType.SpecialEquipPrefs }
     *     
     */
    public void setSpecialEquipPrefs(VehicleReservationRQCoreType.SpecialEquipPrefs value) {
        this.specialEquipPrefs = value;
    }

    /**
     * Gets the value of the rateDistance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rateDistance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRateDistance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleReservationRQCoreType.RateDistance }
     * 
     * 
     */
    public List<VehicleReservationRQCoreType.RateDistance> getRateDistance() {
        if (rateDistance == null) {
            rateDistance = new ArrayList<VehicleReservationRQCoreType.RateDistance>();
        }
        return this.rateDistance;
    }

    /**
     * Gets the value of the totalCharge property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleReservationRQCoreType.TotalCharge }
     *     
     */
    public VehicleReservationRQCoreType.TotalCharge getTotalCharge() {
        return totalCharge;
    }

    /**
     * Sets the value of the totalCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleReservationRQCoreType.TotalCharge }
     *     
     */
    public void setTotalCharge(VehicleReservationRQCoreType.TotalCharge value) {
        this.totalCharge = value;
    }

    /**
     * Gets the value of the queue property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleReservationRQCoreType.Queue }
     *     
     */
    public VehicleReservationRQCoreType.Queue getQueue() {
        return queue;
    }

    /**
     * Sets the value of the queue property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleReservationRQCoreType.Queue }
     *     
     */
    public void setQueue(VehicleReservationRQCoreType.Queue value) {
        this.queue = value;
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
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
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
     *       &lt;attribute name="Age" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class DriverType {

        @XmlAttribute(name = "Age")
        protected BigInteger age;
        @XmlAttribute(name = "Code")
        protected String code;
        @XmlAttribute(name = "CodeContext")
        protected String codeContext;
        @XmlAttribute(name = "URI")
        @XmlSchemaType(name = "anyURI")
        protected String uri;

        /**
         * Gets the value of the age property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getAge() {
            return age;
        }

        /**
         * Sets the value of the age property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setAge(BigInteger value) {
            this.age = value;
        }

        /**
         * Gets the value of the code property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

        /**
         * Gets the value of the codeContext property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodeContext() {
            return codeContext;
        }

        /**
         * Sets the value of the codeContext property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodeContext(String value) {
            this.codeContext = value;
        }

        /**
         * Gets the value of the uri property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getURI() {
            return uri;
        }

        /**
         * Sets the value of the uri property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setURI(String value) {
            this.uri = value;
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
     *       &lt;attribute name="PseudoCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="QueueNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="QueueCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="SystemCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="QueueID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Queue {

        @XmlAttribute(name = "PseudoCityCode")
        protected String pseudoCityCode;
        @XmlAttribute(name = "QueueNumber")
        protected String queueNumber;
        @XmlAttribute(name = "QueueCategory")
        protected String queueCategory;
        @XmlAttribute(name = "SystemCode")
        protected String systemCode;
        @XmlAttribute(name = "QueueID")
        protected String queueID;

        /**
         * Gets the value of the pseudoCityCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPseudoCityCode() {
            return pseudoCityCode;
        }

        /**
         * Sets the value of the pseudoCityCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPseudoCityCode(String value) {
            this.pseudoCityCode = value;
        }

        /**
         * Gets the value of the queueNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQueueNumber() {
            return queueNumber;
        }

        /**
         * Sets the value of the queueNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQueueNumber(String value) {
            this.queueNumber = value;
        }

        /**
         * Gets the value of the queueCategory property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQueueCategory() {
            return queueCategory;
        }

        /**
         * Sets the value of the queueCategory property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQueueCategory(String value) {
            this.queueCategory = value;
        }

        /**
         * Gets the value of the systemCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSystemCode() {
            return systemCode;
        }

        /**
         * Sets the value of the systemCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSystemCode(String value) {
            this.systemCode = value;
        }

        /**
         * Gets the value of the queueID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQueueID() {
            return queueID;
        }

        /**
         * Sets the value of the queueID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQueueID(String value) {
            this.queueID = value;
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
     *       &lt;attribute name="Unlimited" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
     *       &lt;attribute name="DistUnitName" type="{http://www.opentravel.org/OTA/2003/05}DistanceUnitNameType" />
     *       &lt;attribute name="VehiclePeriodUnitName" type="{http://www.opentravel.org/OTA/2003/05}VehiclePeriodUnitNameType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class RateDistance {

        @XmlAttribute(name = "Unlimited", required = true)
        protected boolean unlimited;
        @XmlAttribute(name = "Quantity")
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger quantity;
        @XmlAttribute(name = "DistUnitName")
        protected DistanceUnitNameType distUnitName;
        @XmlAttribute(name = "VehiclePeriodUnitName")
        protected VehiclePeriodUnitNameType vehiclePeriodUnitName;

        /**
         * Gets the value of the unlimited property.
         * 
         */
        public boolean isUnlimited() {
            return unlimited;
        }

        /**
         * Sets the value of the unlimited property.
         * 
         */
        public void setUnlimited(boolean value) {
            this.unlimited = value;
        }

        /**
         * Gets the value of the quantity property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getQuantity() {
            return quantity;
        }

        /**
         * Sets the value of the quantity property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setQuantity(BigInteger value) {
            this.quantity = value;
        }

        /**
         * Gets the value of the distUnitName property.
         * 
         * @return
         *     possible object is
         *     {@link DistanceUnitNameType }
         *     
         */
        public DistanceUnitNameType getDistUnitName() {
            return distUnitName;
        }

        /**
         * Sets the value of the distUnitName property.
         * 
         * @param value
         *     allowed object is
         *     {@link DistanceUnitNameType }
         *     
         */
        public void setDistUnitName(DistanceUnitNameType value) {
            this.distUnitName = value;
        }

        /**
         * Gets the value of the vehiclePeriodUnitName property.
         * 
         * @return
         *     possible object is
         *     {@link VehiclePeriodUnitNameType }
         *     
         */
        public VehiclePeriodUnitNameType getVehiclePeriodUnitName() {
            return vehiclePeriodUnitName;
        }

        /**
         * Sets the value of the vehiclePeriodUnitName property.
         * 
         * @param value
         *     allowed object is
         *     {@link VehiclePeriodUnitNameType }
         *     
         */
        public void setVehiclePeriodUnitName(VehiclePeriodUnitNameType value) {
            this.vehiclePeriodUnitName = value;
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
     *       &lt;sequence>
     *         &lt;element name="SpecialEquipPref" type="{http://www.opentravel.org/OTA/2003/05}VehicleReservationRQCoreTypeSpecialEquipPrefsSpecialEquipPref" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="Charge" type="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "specialEquipPref",
        "charge"
    })
    public static class SpecialEquipPrefs {

        @XmlElement(name = "SpecialEquipPref")
        protected List<VehicleReservationRQCoreTypeSpecialEquipPrefsSpecialEquipPref> specialEquipPref;
        @XmlElement(name = "Charge")
        protected VehicleChargeType charge;

        /**
         * Gets the value of the specialEquipPref property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the specialEquipPref property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSpecialEquipPref().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VehicleReservationRQCoreTypeSpecialEquipPrefsSpecialEquipPref }
         * 
         * 
         */
        public List<VehicleReservationRQCoreTypeSpecialEquipPrefsSpecialEquipPref> getSpecialEquipPref() {
            if (specialEquipPref == null) {
                specialEquipPref = new ArrayList<VehicleReservationRQCoreTypeSpecialEquipPrefsSpecialEquipPref>();
            }
            return this.specialEquipPref;
        }

        /**
         * Gets the value of the charge property.
         * 
         * @return
         *     possible object is
         *     {@link VehicleChargeType }
         *     
         */
        public VehicleChargeType getCharge() {
            return charge;
        }

        /**
         * Sets the value of the charge property.
         * 
         * @param value
         *     allowed object is
         *     {@link VehicleChargeType }
         *     
         */
        public void setCharge(VehicleChargeType value) {
            this.charge = value;
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
     *       &lt;attribute name="RateTotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
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
