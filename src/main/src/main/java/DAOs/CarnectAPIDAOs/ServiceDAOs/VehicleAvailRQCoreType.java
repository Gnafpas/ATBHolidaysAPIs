
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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleAvailRQCoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleAvailRQCoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RateQueryParameterType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VehRentalCore" type="{http://www.opentravel.org/OTA/2003/05}VehicleRentalCoreType" minOccurs="0"/>
 *         &lt;element name="VendorPrefs" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="VendorPref" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>CompanyNamePrefType">
 *                           &lt;attribute name="CorpDiscountNmbr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="ParticipationLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="LocationCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="VehPrefs" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleAvailRQCoreTypeVehPref" minOccurs="0"/>
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
 *         &lt;element name="RateQualifier" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="TravelPurpose" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RateCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CorpDiscountNmbr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RateQualifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RatePeriod" type="{http://www.opentravel.org/OTA/2003/05}VehicleAvailRQCoreTypeRateQualifierRatePeriod" />
 *                 &lt;attribute name="GuaranteedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RateRange" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="MinRate" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="MaxRate" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="FixedRate" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="RateTimeUnit" type="{http://www.opentravel.org/OTA/2003/05}TimeUnitType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SpecialEquipPrefs" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleAvailRQCoreTypeSpecialEquipPref" minOccurs="0"/>
 *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="RateQueryType" use="required" type="{http://www.opentravel.org/OTA/2003/05}RateQueryType" />
 *       &lt;attribute name="Status" type="{http://www.opentravel.org/OTA/2003/05}InventoryStatusType" />
 *       &lt;attribute name="TargetSource" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleAvailRQCoreType", propOrder = {
    "rateQueryParameterType",
    "vehRentalCore",
    "vendorPrefs",
    "vehPrefs",
    "driverType",
    "rateQualifier",
    "rateRange",
    "specialEquipPrefs",
    "tpaExtensions"
})
public class VehicleAvailRQCoreType {

    @XmlElement(name = "RateQueryParameterType")
    protected String rateQueryParameterType;
    @XmlElement(name = "VehRentalCore")
    protected VehicleRentalCoreType vehRentalCore;
    @XmlElement(name = "VendorPrefs")
    protected VehicleAvailRQCoreType.VendorPrefs vendorPrefs;
    @XmlElement(name = "VehPrefs")
    protected ArrayOfVehicleAvailRQCoreTypeVehPref vehPrefs;
    @XmlElement(name = "DriverType")
    protected List<VehicleAvailRQCoreType.DriverType> driverType;
    @XmlElement(name = "RateQualifier")
    protected List<VehicleAvailRQCoreType.RateQualifier> rateQualifier;
    @XmlElement(name = "RateRange")
    protected VehicleAvailRQCoreType.RateRange rateRange;
    @XmlElement(name = "SpecialEquipPrefs")
    protected ArrayOfVehicleAvailRQCoreTypeSpecialEquipPref specialEquipPrefs;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;
    @XmlAttribute(name = "RateQueryType", required = true)
    protected RateQueryType rateQueryType;
    @XmlAttribute(name = "Status")
    protected InventoryStatusType status;
    @XmlAttribute(name = "TargetSource")
    protected String targetSource;

    /**
     * Gets the value of the rateQueryParameterType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateQueryParameterType() {
        return rateQueryParameterType;
    }

    /**
     * Sets the value of the rateQueryParameterType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateQueryParameterType(String value) {
        this.rateQueryParameterType = value;
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
     * Gets the value of the vendorPrefs property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleAvailRQCoreType.VendorPrefs }
     *     
     */
    public VehicleAvailRQCoreType.VendorPrefs getVendorPrefs() {
        return vendorPrefs;
    }

    /**
     * Sets the value of the vendorPrefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleAvailRQCoreType.VendorPrefs }
     *     
     */
    public void setVendorPrefs(VehicleAvailRQCoreType.VendorPrefs value) {
        this.vendorPrefs = value;
    }

    /**
     * Gets the value of the vehPrefs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleAvailRQCoreTypeVehPref }
     *     
     */
    public ArrayOfVehicleAvailRQCoreTypeVehPref getVehPrefs() {
        return vehPrefs;
    }

    /**
     * Sets the value of the vehPrefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleAvailRQCoreTypeVehPref }
     *     
     */
    public void setVehPrefs(ArrayOfVehicleAvailRQCoreTypeVehPref value) {
        this.vehPrefs = value;
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
     * {@link VehicleAvailRQCoreType.DriverType }
     * 
     * 
     */
    public List<VehicleAvailRQCoreType.DriverType> getDriverType() {
        if (driverType == null) {
            driverType = new ArrayList<VehicleAvailRQCoreType.DriverType>();
        }
        return this.driverType;
    }

    /**
     * Gets the value of the rateQualifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rateQualifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRateQualifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleAvailRQCoreType.RateQualifier }
     * 
     * 
     */
    public List<VehicleAvailRQCoreType.RateQualifier> getRateQualifier() {
        if (rateQualifier == null) {
            rateQualifier = new ArrayList<VehicleAvailRQCoreType.RateQualifier>();
        }
        return this.rateQualifier;
    }

    /**
     * Gets the value of the rateRange property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleAvailRQCoreType.RateRange }
     *     
     */
    public VehicleAvailRQCoreType.RateRange getRateRange() {
        return rateRange;
    }

    /**
     * Sets the value of the rateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleAvailRQCoreType.RateRange }
     *     
     */
    public void setRateRange(VehicleAvailRQCoreType.RateRange value) {
        this.rateRange = value;
    }

    /**
     * Gets the value of the specialEquipPrefs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleAvailRQCoreTypeSpecialEquipPref }
     *     
     */
    public ArrayOfVehicleAvailRQCoreTypeSpecialEquipPref getSpecialEquipPrefs() {
        return specialEquipPrefs;
    }

    /**
     * Sets the value of the specialEquipPrefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleAvailRQCoreTypeSpecialEquipPref }
     *     
     */
    public void setSpecialEquipPrefs(ArrayOfVehicleAvailRQCoreTypeSpecialEquipPref value) {
        this.specialEquipPrefs = value;
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
     * Gets the value of the rateQueryType property.
     * 
     * @return
     *     possible object is
     *     {@link RateQueryType }
     *     
     */
    public RateQueryType getRateQueryType() {
        return rateQueryType;
    }

    /**
     * Sets the value of the rateQueryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateQueryType }
     *     
     */
    public void setRateQueryType(RateQueryType value) {
        this.rateQueryType = value;
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
     * Gets the value of the targetSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetSource() {
        return targetSource;
    }

    /**
     * Sets the value of the targetSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetSource(String value) {
        this.targetSource = value;
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
     *       &lt;attribute name="TravelPurpose" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RateCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CorpDiscountNmbr" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RateQualifier" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RatePeriod" type="{http://www.opentravel.org/OTA/2003/05}VehicleAvailRQCoreTypeRateQualifierRatePeriod" />
     *       &lt;attribute name="GuaranteedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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
        protected VehicleAvailRQCoreTypeRateQualifierRatePeriod ratePeriod;
        @XmlAttribute(name = "GuaranteedInd")
        protected Boolean guaranteedInd;

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
         *     {@link VehicleAvailRQCoreTypeRateQualifierRatePeriod }
         *     
         */
        public VehicleAvailRQCoreTypeRateQualifierRatePeriod getRatePeriod() {
            return ratePeriod;
        }

        /**
         * Sets the value of the ratePeriod property.
         * 
         * @param value
         *     allowed object is
         *     {@link VehicleAvailRQCoreTypeRateQualifierRatePeriod }
         *     
         */
        public void setRatePeriod(VehicleAvailRQCoreTypeRateQualifierRatePeriod value) {
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
     *       &lt;attribute name="MinRate" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="MaxRate" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="FixedRate" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="RateTimeUnit" type="{http://www.opentravel.org/OTA/2003/05}TimeUnitType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class RateRange {

        @XmlAttribute(name = "MinRate")
        protected BigDecimal minRate;
        @XmlAttribute(name = "MaxRate")
        protected BigDecimal maxRate;
        @XmlAttribute(name = "FixedRate")
        protected BigDecimal fixedRate;
        @XmlAttribute(name = "RateTimeUnit")
        protected TimeUnitType rateTimeUnit;

        /**
         * Gets the value of the minRate property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMinRate() {
            return minRate;
        }

        /**
         * Sets the value of the minRate property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMinRate(BigDecimal value) {
            this.minRate = value;
        }

        /**
         * Gets the value of the maxRate property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMaxRate() {
            return maxRate;
        }

        /**
         * Sets the value of the maxRate property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMaxRate(BigDecimal value) {
            this.maxRate = value;
        }

        /**
         * Gets the value of the fixedRate property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFixedRate() {
            return fixedRate;
        }

        /**
         * Sets the value of the fixedRate property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFixedRate(BigDecimal value) {
            this.fixedRate = value;
        }

        /**
         * Gets the value of the rateTimeUnit property.
         * 
         * @return
         *     possible object is
         *     {@link TimeUnitType }
         *     
         */
        public TimeUnitType getRateTimeUnit() {
            return rateTimeUnit;
        }

        /**
         * Sets the value of the rateTimeUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link TimeUnitType }
         *     
         */
        public void setRateTimeUnit(TimeUnitType value) {
            this.rateTimeUnit = value;
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
     *         &lt;element name="VendorPref" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>CompanyNamePrefType">
     *                 &lt;attribute name="CorpDiscountNmbr" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="ParticipationLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="LocationCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "vendorPref"
    })
    public static class VendorPrefs {

        @XmlElement(name = "VendorPref")
        protected List<VehicleAvailRQCoreType.VendorPrefs.VendorPref> vendorPref;
        @XmlAttribute(name = "ParticipationLevelCode")
        protected String participationLevelCode;
        @XmlAttribute(name = "LocationCategory")
        protected String locationCategory;

        /**
         * Gets the value of the vendorPref property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the vendorPref property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVendorPref().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VehicleAvailRQCoreType.VendorPrefs.VendorPref }
         * 
         * 
         */
        public List<VehicleAvailRQCoreType.VendorPrefs.VendorPref> getVendorPref() {
            if (vendorPref == null) {
                vendorPref = new ArrayList<VehicleAvailRQCoreType.VendorPrefs.VendorPref>();
            }
            return this.vendorPref;
        }

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

        /**
         * Gets the value of the locationCategory property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocationCategory() {
            return locationCategory;
        }

        /**
         * Sets the value of the locationCategory property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocationCategory(String value) {
            this.locationCategory = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>CompanyNamePrefType">
         *       &lt;attribute name="CorpDiscountNmbr" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class VendorPref
            extends CompanyNamePrefType
        {

            @XmlAttribute(name = "CorpDiscountNmbr")
            protected String corpDiscountNmbr;

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

        }

    }

}
