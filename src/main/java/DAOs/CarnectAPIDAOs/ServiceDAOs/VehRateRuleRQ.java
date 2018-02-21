
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="POS" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfSourceType" minOccurs="0"/>
 *         &lt;element name="Reference" type="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type" minOccurs="0"/>
 *         &lt;element name="RentalInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="VehRentalCore" type="{http://www.opentravel.org/OTA/2003/05}VehicleRentalCoreType" minOccurs="0"/>
 *                   &lt;element name="VehicleInfo" type="{http://www.opentravel.org/OTA/2003/05}VehiclePrefType" minOccurs="0"/>
 *                   &lt;element name="SpecialEquipPrefs" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfOTA_VehRateRuleRQRentalInfoSpecialEquipPref" minOccurs="0"/>
 *                   &lt;element name="CustLoyalty" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="ProgramID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="MembershipID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="TravelSector" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="RPH" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="VendorCode">
 *                             &lt;simpleType>
 *                               &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="RateQualifier" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="TravelPurpose" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="RateCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="CorpDiscountNmbr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="RateQualifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="RatePeriod" type="{http://www.opentravel.org/OTA/2003/05}OTA_VehRateRuleRQRentalInfoRateQualifierRatePeriod" />
 *                           &lt;attribute name="GuaranteedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="RateAuthorizationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="VendorRateID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="RateModifiedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="OffLocService" type="{http://www.opentravel.org/OTA/2003/05}OffLocationServiceType" minOccurs="0"/>
 *                   &lt;element name="ArrivalDetails" type="{http://www.opentravel.org/OTA/2003/05}VehicleArrivalDetailsType" minOccurs="0"/>
 *                   &lt;element name="TourInfo" type="{http://www.opentravel.org/OTA/2003/05}VehicleTourInfoType" minOccurs="0"/>
 *                   &lt;element name="CustomerID" type="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type" minOccurs="0"/>
 *                   &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="EchoToken" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="Target" default="Production">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Test"/>
 *             &lt;enumeration value="Production"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="TransactionIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SequenceNmbr" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="TransactionStatusCode">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Start"/>
 *             &lt;enumeration value="End"/>
 *             &lt;enumeration value="Rollback"/>
 *             &lt;enumeration value="InSeries"/>
 *             &lt;enumeration value="Continuation"/>
 *             &lt;enumeration value="Subsequent"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="RetransmissionIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="CompanyShortName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TravelSector" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pos",
    "reference",
    "rentalInfo"
})
@XmlRootElement(name = "VehRateRuleRQ")
public class VehRateRuleRQ {

    @XmlElement(name = "POS")
    protected ArrayOfSourceType pos;
    @XmlElement(name = "Reference")
    protected UniqueIDType reference;
    @XmlElement(name = "RentalInfo")
    protected VehRateRuleRQ.RentalInfo rentalInfo;
    @XmlAttribute(name = "EchoToken")
    protected String echoToken;
    @XmlAttribute(name = "TimeStamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp;
    @XmlAttribute(name = "Target")
    protected String target;
    @XmlAttribute(name = "Version", required = true)
    protected BigDecimal version;
    @XmlAttribute(name = "TransactionIdentifier")
    protected String transactionIdentifier;
    @XmlAttribute(name = "SequenceNmbr")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger sequenceNmbr;
    @XmlAttribute(name = "TransactionStatusCode")
    protected String transactionStatusCode;
    @XmlAttribute(name = "RetransmissionIndicator")
    protected Boolean retransmissionIndicator;
    @XmlAttribute(name = "CompanyShortName")
    protected String companyShortName;
    @XmlAttribute(name = "TravelSector")
    protected String travelSector;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "CodeContext")
    protected String codeContext;

    /**
     * Gets the value of the pos property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSourceType }
     *     
     */
    public ArrayOfSourceType getPOS() {
        return pos;
    }

    /**
     * Sets the value of the pos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSourceType }
     *     
     */
    public void setPOS(ArrayOfSourceType value) {
        this.pos = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link UniqueIDType }
     *     
     */
    public UniqueIDType getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniqueIDType }
     *     
     */
    public void setReference(UniqueIDType value) {
        this.reference = value;
    }

    /**
     * Gets the value of the rentalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link VehRateRuleRQ.RentalInfo }
     *     
     */
    public VehRateRuleRQ.RentalInfo getRentalInfo() {
        return rentalInfo;
    }

    /**
     * Sets the value of the rentalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehRateRuleRQ.RentalInfo }
     *     
     */
    public void setRentalInfo(VehRateRuleRQ.RentalInfo value) {
        this.rentalInfo = value;
    }

    /**
     * Gets the value of the echoToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEchoToken() {
        return echoToken;
    }

    /**
     * Sets the value of the echoToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEchoToken(String value) {
        this.echoToken = value;
    }

    /**
     * Gets the value of the timeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeStamp(XMLGregorianCalendar value) {
        this.timeStamp = value;
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarget() {
        if (target == null) {
            return "Production";
        } else {
            return target;
        }
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarget(String value) {
        this.target = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVersion(BigDecimal value) {
        this.version = value;
    }

    /**
     * Gets the value of the transactionIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionIdentifier() {
        return transactionIdentifier;
    }

    /**
     * Sets the value of the transactionIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionIdentifier(String value) {
        this.transactionIdentifier = value;
    }

    /**
     * Gets the value of the sequenceNmbr property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSequenceNmbr() {
        return sequenceNmbr;
    }

    /**
     * Sets the value of the sequenceNmbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSequenceNmbr(BigInteger value) {
        this.sequenceNmbr = value;
    }

    /**
     * Gets the value of the transactionStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionStatusCode() {
        return transactionStatusCode;
    }

    /**
     * Sets the value of the transactionStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionStatusCode(String value) {
        this.transactionStatusCode = value;
    }

    /**
     * Gets the value of the retransmissionIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRetransmissionIndicator() {
        return retransmissionIndicator;
    }

    /**
     * Sets the value of the retransmissionIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRetransmissionIndicator(Boolean value) {
        this.retransmissionIndicator = value;
    }

    /**
     * Gets the value of the companyShortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyShortName() {
        return companyShortName;
    }

    /**
     * Sets the value of the companyShortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyShortName(String value) {
        this.companyShortName = value;
    }

    /**
     * Gets the value of the travelSector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelSector() {
        return travelSector;
    }

    /**
     * Sets the value of the travelSector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelSector(String value) {
        this.travelSector = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="VehRentalCore" type="{http://www.opentravel.org/OTA/2003/05}VehicleRentalCoreType" minOccurs="0"/>
     *         &lt;element name="VehicleInfo" type="{http://www.opentravel.org/OTA/2003/05}VehiclePrefType" minOccurs="0"/>
     *         &lt;element name="SpecialEquipPrefs" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfOTA_VehRateRuleRQRentalInfoSpecialEquipPref" minOccurs="0"/>
     *         &lt;element name="CustLoyalty" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="ProgramID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="MembershipID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="TravelSector" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="RPH" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="VendorCode">
     *                   &lt;simpleType>
     *                     &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
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
     *                 &lt;attribute name="RatePeriod" type="{http://www.opentravel.org/OTA/2003/05}OTA_VehRateRuleRQRentalInfoRateQualifierRatePeriod" />
     *                 &lt;attribute name="GuaranteedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="RateAuthorizationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="VendorRateID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="RateModifiedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="OffLocService" type="{http://www.opentravel.org/OTA/2003/05}OffLocationServiceType" minOccurs="0"/>
     *         &lt;element name="ArrivalDetails" type="{http://www.opentravel.org/OTA/2003/05}VehicleArrivalDetailsType" minOccurs="0"/>
     *         &lt;element name="TourInfo" type="{http://www.opentravel.org/OTA/2003/05}VehicleTourInfoType" minOccurs="0"/>
     *         &lt;element name="CustomerID" type="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type" minOccurs="0"/>
     *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
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
        "vehRentalCore",
        "vehicleInfo",
        "specialEquipPrefs",
        "custLoyalty",
        "rateQualifier",
        "offLocService",
        "arrivalDetails",
        "tourInfo",
        "customerID",
        "tpaExtensions"
    })
    public static class RentalInfo {

        @XmlElement(name = "VehRentalCore")
        protected VehicleRentalCoreType vehRentalCore;
        @XmlElement(name = "VehicleInfo")
        protected VehiclePrefType vehicleInfo;
        @XmlElement(name = "SpecialEquipPrefs")
        protected ArrayOfOTAVehRateRuleRQRentalInfoSpecialEquipPref specialEquipPrefs;
        @XmlElement(name = "CustLoyalty")
        protected List<VehRateRuleRQ.RentalInfo.CustLoyalty> custLoyalty;
        @XmlElement(name = "RateQualifier")
        protected VehRateRuleRQ.RentalInfo.RateQualifier rateQualifier;
        @XmlElement(name = "OffLocService")
        protected OffLocationServiceType offLocService;
        @XmlElement(name = "ArrivalDetails")
        protected VehicleArrivalDetailsType arrivalDetails;
        @XmlElement(name = "TourInfo")
        protected VehicleTourInfoType tourInfo;
        @XmlElement(name = "CustomerID")
        protected UniqueIDType customerID;
        @XmlElement(name = "TPA_Extensions")
        protected TPAExtensionsType tpaExtensions;

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
         * Gets the value of the vehicleInfo property.
         * 
         * @return
         *     possible object is
         *     {@link VehiclePrefType }
         *     
         */
        public VehiclePrefType getVehicleInfo() {
            return vehicleInfo;
        }

        /**
         * Sets the value of the vehicleInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link VehiclePrefType }
         *     
         */
        public void setVehicleInfo(VehiclePrefType value) {
            this.vehicleInfo = value;
        }

        /**
         * Gets the value of the specialEquipPrefs property.
         * 
         * @return
         *     possible object is
         *     {@link ArrayOfOTAVehRateRuleRQRentalInfoSpecialEquipPref }
         *     
         */
        public ArrayOfOTAVehRateRuleRQRentalInfoSpecialEquipPref getSpecialEquipPrefs() {
            return specialEquipPrefs;
        }

        /**
         * Sets the value of the specialEquipPrefs property.
         * 
         * @param value
         *     allowed object is
         *     {@link ArrayOfOTAVehRateRuleRQRentalInfoSpecialEquipPref }
         *     
         */
        public void setSpecialEquipPrefs(ArrayOfOTAVehRateRuleRQRentalInfoSpecialEquipPref value) {
            this.specialEquipPrefs = value;
        }

        /**
         * Gets the value of the custLoyalty property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the custLoyalty property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCustLoyalty().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VehRateRuleRQ.RentalInfo.CustLoyalty }
         * 
         * 
         */
        public List<VehRateRuleRQ.RentalInfo.CustLoyalty> getCustLoyalty() {
            if (custLoyalty == null) {
                custLoyalty = new ArrayList<VehRateRuleRQ.RentalInfo.CustLoyalty>();
            }
            return this.custLoyalty;
        }

        /**
         * Gets the value of the rateQualifier property.
         * 
         * @return
         *     possible object is
         *     {@link VehRateRuleRQ.RentalInfo.RateQualifier }
         *     
         */
        public VehRateRuleRQ.RentalInfo.RateQualifier getRateQualifier() {
            return rateQualifier;
        }

        /**
         * Sets the value of the rateQualifier property.
         * 
         * @param value
         *     allowed object is
         *     {@link VehRateRuleRQ.RentalInfo.RateQualifier }
         *     
         */
        public void setRateQualifier(VehRateRuleRQ.RentalInfo.RateQualifier value) {
            this.rateQualifier = value;
        }

        /**
         * Gets the value of the offLocService property.
         * 
         * @return
         *     possible object is
         *     {@link OffLocationServiceType }
         *     
         */
        public OffLocationServiceType getOffLocService() {
            return offLocService;
        }

        /**
         * Sets the value of the offLocService property.
         * 
         * @param value
         *     allowed object is
         *     {@link OffLocationServiceType }
         *     
         */
        public void setOffLocService(OffLocationServiceType value) {
            this.offLocService = value;
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
         * Gets the value of the customerID property.
         * 
         * @return
         *     possible object is
         *     {@link UniqueIDType }
         *     
         */
        public UniqueIDType getCustomerID() {
            return customerID;
        }

        /**
         * Sets the value of the customerID property.
         * 
         * @param value
         *     allowed object is
         *     {@link UniqueIDType }
         *     
         */
        public void setCustomerID(UniqueIDType value) {
            this.customerID = value;
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
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="ProgramID" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="MembershipID" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="TravelSector" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="RPH" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="VendorCode">
         *         &lt;simpleType>
         *           &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class CustLoyalty {

            @XmlAttribute(name = "ProgramID")
            protected String programID;
            @XmlAttribute(name = "MembershipID")
            protected String membershipID;
            @XmlAttribute(name = "TravelSector")
            protected String travelSector;
            @XmlAttribute(name = "RPH")
            protected String rph;
            @XmlAttribute(name = "VendorCode")
            protected List<String> vendorCode;

            /**
             * Gets the value of the programID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProgramID() {
                return programID;
            }

            /**
             * Sets the value of the programID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProgramID(String value) {
                this.programID = value;
            }

            /**
             * Gets the value of the membershipID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMembershipID() {
                return membershipID;
            }

            /**
             * Sets the value of the membershipID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMembershipID(String value) {
                this.membershipID = value;
            }

            /**
             * Gets the value of the travelSector property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTravelSector() {
                return travelSector;
            }

            /**
             * Sets the value of the travelSector property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTravelSector(String value) {
                this.travelSector = value;
            }

            /**
             * Gets the value of the rph property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRPH() {
                return rph;
            }

            /**
             * Sets the value of the rph property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRPH(String value) {
                this.rph = value;
            }

            /**
             * Gets the value of the vendorCode property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the vendorCode property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getVendorCode().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getVendorCode() {
                if (vendorCode == null) {
                    vendorCode = new ArrayList<String>();
                }
                return this.vendorCode;
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
         *       &lt;attribute name="RatePeriod" type="{http://www.opentravel.org/OTA/2003/05}OTA_VehRateRuleRQRentalInfoRateQualifierRatePeriod" />
         *       &lt;attribute name="GuaranteedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="RateAuthorizationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="VendorRateID" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="RateModifiedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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
            protected OTAVehRateRuleRQRentalInfoRateQualifierRatePeriod ratePeriod;
            @XmlAttribute(name = "GuaranteedInd")
            protected Boolean guaranteedInd;
            @XmlAttribute(name = "RateAuthorizationCode")
            protected String rateAuthorizationCode;
            @XmlAttribute(name = "VendorRateID")
            protected String vendorRateID;
            @XmlAttribute(name = "RateModifiedInd")
            protected Boolean rateModifiedInd;

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
             *     {@link OTAVehRateRuleRQRentalInfoRateQualifierRatePeriod }
             *     
             */
            public OTAVehRateRuleRQRentalInfoRateQualifierRatePeriod getRatePeriod() {
                return ratePeriod;
            }

            /**
             * Sets the value of the ratePeriod property.
             * 
             * @param value
             *     allowed object is
             *     {@link OTAVehRateRuleRQRentalInfoRateQualifierRatePeriod }
             *     
             */
            public void setRatePeriod(OTAVehRateRuleRQRentalInfoRateQualifierRatePeriod value) {
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
             * Gets the value of the rateAuthorizationCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRateAuthorizationCode() {
                return rateAuthorizationCode;
            }

            /**
             * Sets the value of the rateAuthorizationCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRateAuthorizationCode(String value) {
                this.rateAuthorizationCode = value;
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

            /**
             * Gets the value of the rateModifiedInd property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isRateModifiedInd() {
                return rateModifiedInd;
            }

            /**
             * Sets the value of the rateModifiedInd property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setRateModifiedInd(Boolean value) {
                this.rateModifiedInd = value;
            }

        }

    }

}
