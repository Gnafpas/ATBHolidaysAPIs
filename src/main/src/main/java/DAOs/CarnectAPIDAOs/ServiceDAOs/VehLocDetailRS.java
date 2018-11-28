
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigInteger;
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
 *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}OtaResponse">
 *       &lt;sequence>
 *         &lt;element name="Success" type="{http://www.opentravel.org/OTA/2003/05}SuccessType" minOccurs="0"/>
 *         &lt;element name="Warnings" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfWarningType" minOccurs="0"/>
 *         &lt;element name="Vendor" type="{http://www.opentravel.org/OTA/2003/05}CompanyNameType" minOccurs="0"/>
 *         &lt;element name="LocationDetail" type="{http://www.opentravel.org/OTA/2003/05}VehicleLocationDetailsType" minOccurs="0"/>
 *         &lt;element name="Vehicles" type="{http://www.opentravel.org/OTA/2003/05}VehicleLocationVehiclesType" minOccurs="0"/>
 *         &lt;element name="Requirements" type="{http://www.opentravel.org/OTA/2003/05}VehicleLocationRequirementsType" minOccurs="0"/>
 *         &lt;element name="AdditionalFees" type="{http://www.opentravel.org/OTA/2003/05}VehicleLocationAdditionalFeesType" minOccurs="0"/>
 *         &lt;element name="Liabilities" type="{http://www.opentravel.org/OTA/2003/05}VehicleLocationLiabilitiesType" minOccurs="0"/>
 *         &lt;element name="ServicesOffered" type="{http://www.opentravel.org/OTA/2003/05}VehicleLocationServicesOfferedType" minOccurs="0"/>
 *         &lt;element name="Date" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="PickUpDateTime" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ReturnDateTime" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
 *         &lt;element name="Errors" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfErrorType" minOccurs="0"/>
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
 *       &lt;attribute name="Version" type="{http://www.w3.org/2001/XMLSchema}string" />
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
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "success",
    "warnings",
    "vendor",
    "locationDetail",
    "vehicles",
    "requirements",
    "additionalFees",
    "liabilities",
    "servicesOffered",
    "date",
    "tpaExtensions",
    "errors"
})
@XmlRootElement(name = "VehLocDetailRS")
public class VehLocDetailRS
    extends OtaResponse
{

    @XmlElement(name = "Success")
    protected SuccessType success;
    @XmlElement(name = "Warnings")
    protected ArrayOfWarningType warnings;
    @XmlElement(name = "Vendor")
    protected CompanyNameType vendor;
    @XmlElement(name = "LocationDetail")
    protected VehicleLocationDetailsType locationDetail;
    @XmlElement(name = "Vehicles")
    protected VehicleLocationVehiclesType vehicles;
    @XmlElement(name = "Requirements")
    protected VehicleLocationRequirementsType requirements;
    @XmlElement(name = "AdditionalFees")
    protected VehicleLocationAdditionalFeesType additionalFees;
    @XmlElement(name = "Liabilities")
    protected VehicleLocationLiabilitiesType liabilities;
    @XmlElement(name = "ServicesOffered")
    protected VehicleLocationServicesOfferedType servicesOffered;
    @XmlElement(name = "Date")
    protected VehLocDetailRS.Date date;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;
    @XmlElement(name = "Errors")
    protected ArrayOfErrorType errors;
    @XmlAttribute(name = "EchoToken")
    protected String echoToken;
    @XmlAttribute(name = "TimeStamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp;
    @XmlAttribute(name = "Target")
    protected String target;
    @XmlAttribute(name = "Version")
    protected String version;
    @XmlAttribute(name = "TransactionIdentifier")
    protected String transactionIdentifier;
    @XmlAttribute(name = "SequenceNmbr")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger sequenceNmbr;
    @XmlAttribute(name = "TransactionStatusCode")
    protected String transactionStatusCode;
    @XmlAttribute(name = "RetransmissionIndicator")
    protected Boolean retransmissionIndicator;

    /**
     * Gets the value of the success property.
     * 
     * @return
     *     possible object is
     *     {@link SuccessType }
     *     
     */
    public SuccessType getSuccess() {
        return success;
    }

    /**
     * Sets the value of the success property.
     * 
     * @param value
     *     allowed object is
     *     {@link SuccessType }
     *     
     */
    public void setSuccess(SuccessType value) {
        this.success = value;
    }

    /**
     * Gets the value of the warnings property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWarningType }
     *     
     */
    public ArrayOfWarningType getWarnings() {
        return warnings;
    }

    /**
     * Sets the value of the warnings property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWarningType }
     *     
     */
    public void setWarnings(ArrayOfWarningType value) {
        this.warnings = value;
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
     * Gets the value of the locationDetail property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationDetailsType }
     *     
     */
    public VehicleLocationDetailsType getLocationDetail() {
        return locationDetail;
    }

    /**
     * Sets the value of the locationDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationDetailsType }
     *     
     */
    public void setLocationDetail(VehicleLocationDetailsType value) {
        this.locationDetail = value;
    }

    /**
     * Gets the value of the vehicles property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationVehiclesType }
     *     
     */
    public VehicleLocationVehiclesType getVehicles() {
        return vehicles;
    }

    /**
     * Sets the value of the vehicles property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationVehiclesType }
     *     
     */
    public void setVehicles(VehicleLocationVehiclesType value) {
        this.vehicles = value;
    }

    /**
     * Gets the value of the requirements property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationRequirementsType }
     *     
     */
    public VehicleLocationRequirementsType getRequirements() {
        return requirements;
    }

    /**
     * Sets the value of the requirements property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationRequirementsType }
     *     
     */
    public void setRequirements(VehicleLocationRequirementsType value) {
        this.requirements = value;
    }

    /**
     * Gets the value of the additionalFees property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationAdditionalFeesType }
     *     
     */
    public VehicleLocationAdditionalFeesType getAdditionalFees() {
        return additionalFees;
    }

    /**
     * Sets the value of the additionalFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationAdditionalFeesType }
     *     
     */
    public void setAdditionalFees(VehicleLocationAdditionalFeesType value) {
        this.additionalFees = value;
    }

    /**
     * Gets the value of the liabilities property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationLiabilitiesType }
     *     
     */
    public VehicleLocationLiabilitiesType getLiabilities() {
        return liabilities;
    }

    /**
     * Sets the value of the liabilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationLiabilitiesType }
     *     
     */
    public void setLiabilities(VehicleLocationLiabilitiesType value) {
        this.liabilities = value;
    }

    /**
     * Gets the value of the servicesOffered property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationServicesOfferedType }
     *     
     */
    public VehicleLocationServicesOfferedType getServicesOffered() {
        return servicesOffered;
    }

    /**
     * Sets the value of the servicesOffered property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationServicesOfferedType }
     *     
     */
    public void setServicesOffered(VehicleLocationServicesOfferedType value) {
        this.servicesOffered = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link VehLocDetailRS.Date }
     *     
     */
    public VehLocDetailRS.Date getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehLocDetailRS.Date }
     *     
     */
    public void setDate(VehLocDetailRS.Date value) {
        this.date = value;
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
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfErrorType }
     *     
     */
    public ArrayOfErrorType getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfErrorType }
     *     
     */
    public void setErrors(ArrayOfErrorType value) {
        this.errors = value;
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
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="PickUpDateTime" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ReturnDateTime" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Date {

        @XmlAttribute(name = "PickUpDateTime")
        protected String pickUpDateTime;
        @XmlAttribute(name = "ReturnDateTime")
        protected String returnDateTime;

        /**
         * Gets the value of the pickUpDateTime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPickUpDateTime() {
            return pickUpDateTime;
        }

        /**
         * Sets the value of the pickUpDateTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPickUpDateTime(String value) {
            this.pickUpDateTime = value;
        }

        /**
         * Gets the value of the returnDateTime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReturnDateTime() {
            return returnDateTime;
        }

        /**
         * Sets the value of the returnDateTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReturnDateTime(String value) {
            this.returnDateTime = value;
        }

    }

}
