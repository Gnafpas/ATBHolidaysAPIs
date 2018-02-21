
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
 * <p>Java class for VehicleModifyRQCoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleModifyRQCoreType">
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
 *         &lt;element name="RateQualifier" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="TravelPurpose" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RateCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CorpDiscountNmbr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RateQualifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RatePeriod" type="{http://www.opentravel.org/OTA/2003/05}VehicleModifyRQCoreTypeRateQualifierRatePeriod" />
 *                 &lt;attribute name="GuaranteedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="VendorRateID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RateRestriction" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="CancellationPenaltyInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="ModificationPenaltyInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SpecialEquipPrefs" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleModifyRQCoreTypeSpecialEquipPref" minOccurs="0"/>
 *         &lt;element name="VehicleCharge" type="{http://www.opentravel.org/OTA/2003/05}VehicleChargePurposeType" maxOccurs="unbounded" minOccurs="0"/>
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
 *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Status" type="{http://www.opentravel.org/OTA/2003/05}InventoryStatusType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleModifyRQCoreType", propOrder = {
    "uniqueID",
    "vehRentalCore",
    "customer",
    "vendorPref",
    "vehPref",
    "driverType",
    "rateQualifier",
    "rateRestriction",
    "specialEquipPrefs",
    "vehicleCharge",
    "totalCharge",
    "rateDistance",
    "tpaExtensions"
})
@XmlSeeAlso({
        DAOs.CarnectAPIDAOs.ServiceDAOs.VehModifyRQ.VehModifyRQCore.class
})
public class VehicleModifyRQCoreType {

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
    protected List<VehicleModifyRQCoreType.DriverType> driverType;
    @XmlElement(name = "RateQualifier")
    protected VehicleModifyRQCoreType.RateQualifier rateQualifier;
    @XmlElement(name = "RateRestriction")
    protected VehicleModifyRQCoreType.RateRestriction rateRestriction;
    @XmlElement(name = "SpecialEquipPrefs")
    protected ArrayOfVehicleModifyRQCoreTypeSpecialEquipPref specialEquipPrefs;
    @XmlElement(name = "VehicleCharge")
    protected List<VehicleChargePurposeType> vehicleCharge;
    @XmlElement(name = "TotalCharge")
    protected VehicleModifyRQCoreType.TotalCharge totalCharge;
    @XmlElement(name = "RateDistance")
    protected List<VehicleModifyRQCoreType.RateDistance> rateDistance;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;
    @XmlAttribute(name = "Status")
    protected InventoryStatusType status;

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
     * {@link VehicleModifyRQCoreType.DriverType }
     * 
     * 
     */
    public List<VehicleModifyRQCoreType.DriverType> getDriverType() {
        if (driverType == null) {
            driverType = new ArrayList<VehicleModifyRQCoreType.DriverType>();
        }
        return this.driverType;
    }

    /**
     * Gets the value of the rateQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleModifyRQCoreType.RateQualifier }
     *     
     */
    public VehicleModifyRQCoreType.RateQualifier getRateQualifier() {
        return rateQualifier;
    }

    /**
     * Sets the value of the rateQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleModifyRQCoreType.RateQualifier }
     *     
     */
    public void setRateQualifier(VehicleModifyRQCoreType.RateQualifier value) {
        this.rateQualifier = value;
    }

    /**
     * Gets the value of the rateRestriction property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleModifyRQCoreType.RateRestriction }
     *     
     */
    public VehicleModifyRQCoreType.RateRestriction getRateRestriction() {
        return rateRestriction;
    }

    /**
     * Sets the value of the rateRestriction property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleModifyRQCoreType.RateRestriction }
     *     
     */
    public void setRateRestriction(VehicleModifyRQCoreType.RateRestriction value) {
        this.rateRestriction = value;
    }

    /**
     * Gets the value of the specialEquipPrefs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleModifyRQCoreTypeSpecialEquipPref }
     *     
     */
    public ArrayOfVehicleModifyRQCoreTypeSpecialEquipPref getSpecialEquipPrefs() {
        return specialEquipPrefs;
    }

    /**
     * Sets the value of the specialEquipPrefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleModifyRQCoreTypeSpecialEquipPref }
     *     
     */
    public void setSpecialEquipPrefs(ArrayOfVehicleModifyRQCoreTypeSpecialEquipPref value) {
        this.specialEquipPrefs = value;
    }

    /**
     * Gets the value of the vehicleCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehicleCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehicleCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleChargePurposeType }
     * 
     * 
     */
    public List<VehicleChargePurposeType> getVehicleCharge() {
        if (vehicleCharge == null) {
            vehicleCharge = new ArrayList<VehicleChargePurposeType>();
        }
        return this.vehicleCharge;
    }

    /**
     * Gets the value of the totalCharge property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleModifyRQCoreType.TotalCharge }
     *     
     */
    public VehicleModifyRQCoreType.TotalCharge getTotalCharge() {
        return totalCharge;
    }

    /**
     * Sets the value of the totalCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleModifyRQCoreType.TotalCharge }
     *     
     */
    public void setTotalCharge(VehicleModifyRQCoreType.TotalCharge value) {
        this.totalCharge = value;
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
     * {@link VehicleModifyRQCoreType.RateDistance }
     * 
     * 
     */
    public List<VehicleModifyRQCoreType.RateDistance> getRateDistance() {
        if (rateDistance == null) {
            rateDistance = new ArrayList<VehicleModifyRQCoreType.RateDistance>();
        }
        return this.rateDistance;
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
     *       &lt;attribute name="TravelPurpose" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RateCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CorpDiscountNmbr" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RateQualifier" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RatePeriod" type="{http://www.opentravel.org/OTA/2003/05}VehicleModifyRQCoreTypeRateQualifierRatePeriod" />
     *       &lt;attribute name="GuaranteedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="VendorRateID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class RateQualifier {

        @XmlAttribute(name = "TravelPurpose")
        protected String travelPurpose;
        @XmlAttribute(name = "RateCategory")
        protected String rateCategory;
        @XmlAttribute(name = "CorpDiscountNmbr")
        protected String corpDiscountNmbr;
        @XmlAttribute(name = "RateQualifier")
        protected String rateQualifier;
        @XmlAttribute(name = "RatePeriod")
        protected VehicleModifyRQCoreTypeRateQualifierRatePeriod ratePeriod;
        @XmlAttribute(name = "GuaranteedInd")
        protected Boolean guaranteedInd;
        @XmlAttribute(name = "VendorRateID")
        protected String vendorRateID;

        /**
         * Gets the value of the travelPurpose property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTravelPurpose() {
            return travelPurpose;
        }

        /**
         * Sets the value of the travelPurpose property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTravelPurpose(String value) {
            this.travelPurpose = value;
        }

        /**
         * Gets the value of the rateCategory property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRateCategory() {
            return rateCategory;
        }

        /**
         * Sets the value of the rateCategory property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRateCategory(String value) {
            this.rateCategory = value;
        }

        /**
         * Gets the value of the corpDiscountNmbr property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCorpDiscountNmbr() {
            return corpDiscountNmbr;
        }

        /**
         * Sets the value of the corpDiscountNmbr property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCorpDiscountNmbr(String value) {
            this.corpDiscountNmbr = value;
        }

        /**
         * Gets the value of the rateQualifier property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRateQualifier() {
            return rateQualifier;
        }

        /**
         * Sets the value of the rateQualifier property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRateQualifier(String value) {
            this.rateQualifier = value;
        }

        /**
         * Gets the value of the ratePeriod property.
         * 
         * @return
         *     possible object is
         *     {@link VehicleModifyRQCoreTypeRateQualifierRatePeriod }
         *     
         */
        public VehicleModifyRQCoreTypeRateQualifierRatePeriod getRatePeriod() {
            return ratePeriod;
        }

        /**
         * Sets the value of the ratePeriod property.
         * 
         * @param value
         *     allowed object is
         *     {@link VehicleModifyRQCoreTypeRateQualifierRatePeriod }
         *     
         */
        public void setRatePeriod(VehicleModifyRQCoreTypeRateQualifierRatePeriod value) {
            this.ratePeriod = value;
        }

        /**
         * Gets the value of the guaranteedInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isGuaranteedInd() {
            return guaranteedInd;
        }

        /**
         * Sets the value of the guaranteedInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setGuaranteedInd(Boolean value) {
            this.guaranteedInd = value;
        }

        /**
         * Gets the value of the vendorRateID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVendorRateID() {
            return vendorRateID;
        }

        /**
         * Sets the value of the vendorRateID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVendorRateID(String value) {
            this.vendorRateID = value;
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
     *       &lt;attribute name="CancellationPenaltyInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="ModificationPenaltyInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class RateRestriction {

        @XmlAttribute(name = "CancellationPenaltyInd")
        protected Boolean cancellationPenaltyInd;
        @XmlAttribute(name = "ModificationPenaltyInd")
        protected Boolean modificationPenaltyInd;

        /**
         * Gets the value of the cancellationPenaltyInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCancellationPenaltyInd() {
            return cancellationPenaltyInd;
        }

        /**
         * Sets the value of the cancellationPenaltyInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCancellationPenaltyInd(Boolean value) {
            this.cancellationPenaltyInd = value;
        }

        /**
         * Gets the value of the modificationPenaltyInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isModificationPenaltyInd() {
            return modificationPenaltyInd;
        }

        /**
         * Sets the value of the modificationPenaltyInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setModificationPenaltyInd(Boolean value) {
            this.modificationPenaltyInd = value;
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
