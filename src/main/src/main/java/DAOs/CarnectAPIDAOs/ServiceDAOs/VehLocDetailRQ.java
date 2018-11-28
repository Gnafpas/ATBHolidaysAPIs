
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
 *         &lt;element name="Location" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>LocationType">
 *                 &lt;attribute name="ExtendedLocationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Vendor" type="{http://www.opentravel.org/OTA/2003/05}CompanyNameType" minOccurs="0"/>
 *         &lt;element name="ResponseFilter" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="LocationAddressPhoneIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                 &lt;attribute name="LocationInfoIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                 &lt;attribute name="VehiclesIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                 &lt;attribute name="RequirementsIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                 &lt;attribute name="AdditionalFeesIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                 &lt;attribute name="LiabilitiesIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                 &lt;attribute name="ServicesOfferedIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
 *         &lt;element name="Keyword" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
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
 *       &lt;attribute name="ReqRespVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "location",
    "vendor",
    "responseFilter",
    "date",
    "keyword",
    "tpaExtensions"
})
@XmlRootElement(name = "VehLocDetailRQ")
public class VehLocDetailRQ {

    @XmlElement(name = "POS")
    protected ArrayOfSourceType pos;
    @XmlElement(name = "Location")
    protected VehLocDetailRQ.Location location;
    @XmlElement(name = "Vendor")
    protected CompanyNameType vendor;
    @XmlElement(name = "ResponseFilter")
    protected VehLocDetailRQ.ResponseFilter responseFilter;
    @XmlElement(name = "Date")
    protected VehLocDetailRQ.Date date;
    @XmlElement(name = "Keyword")
    protected List<VehLocDetailRQ.Keyword> keyword;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;
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
    @XmlAttribute(name = "ReqRespVersion")
    protected String reqRespVersion;

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
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link VehLocDetailRQ.Location }
     *     
     */
    public VehLocDetailRQ.Location getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehLocDetailRQ.Location }
     *     
     */
    public void setLocation(VehLocDetailRQ.Location value) {
        this.location = value;
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
     * Gets the value of the responseFilter property.
     * 
     * @return
     *     possible object is
     *     {@link VehLocDetailRQ.ResponseFilter }
     *     
     */
    public VehLocDetailRQ.ResponseFilter getResponseFilter() {
        return responseFilter;
    }

    /**
     * Sets the value of the responseFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehLocDetailRQ.ResponseFilter }
     *     
     */
    public void setResponseFilter(VehLocDetailRQ.ResponseFilter value) {
        this.responseFilter = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link VehLocDetailRQ.Date }
     *     
     */
    public VehLocDetailRQ.Date getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehLocDetailRQ.Date }
     *     
     */
    public void setDate(VehLocDetailRQ.Date value) {
        this.date = value;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyword property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyword().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehLocDetailRQ.Keyword }
     * 
     * 
     */
    public List<VehLocDetailRQ.Keyword> getKeyword() {
        if (keyword == null) {
            keyword = new ArrayList<VehLocDetailRQ.Keyword>();
        }
        return this.keyword;
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
     * Gets the value of the reqRespVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqRespVersion() {
        return reqRespVersion;
    }

    /**
     * Sets the value of the reqRespVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqRespVersion(String value) {
        this.reqRespVersion = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Keyword {

        @XmlAttribute(name = "Code")
        protected String code;

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
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Location
        extends LocationType
    {

        @XmlAttribute(name = "ExtendedLocationCode")
        protected String extendedLocationCode;

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
     *       &lt;attribute name="LocationAddressPhoneIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *       &lt;attribute name="LocationInfoIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *       &lt;attribute name="VehiclesIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *       &lt;attribute name="RequirementsIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *       &lt;attribute name="AdditionalFeesIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *       &lt;attribute name="LiabilitiesIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *       &lt;attribute name="ServicesOfferedIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ResponseFilter {

        @XmlAttribute(name = "LocationAddressPhoneIndicator")
        protected Boolean locationAddressPhoneIndicator;
        @XmlAttribute(name = "LocationInfoIndicator")
        protected Boolean locationInfoIndicator;
        @XmlAttribute(name = "VehiclesIndicator")
        protected Boolean vehiclesIndicator;
        @XmlAttribute(name = "RequirementsIndicator")
        protected Boolean requirementsIndicator;
        @XmlAttribute(name = "AdditionalFeesIndicator")
        protected Boolean additionalFeesIndicator;
        @XmlAttribute(name = "LiabilitiesIndicator")
        protected Boolean liabilitiesIndicator;
        @XmlAttribute(name = "ServicesOfferedIndicator")
        protected Boolean servicesOfferedIndicator;

        /**
         * Gets the value of the locationAddressPhoneIndicator property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isLocationAddressPhoneIndicator() {
            if (locationAddressPhoneIndicator == null) {
                return false;
            } else {
                return locationAddressPhoneIndicator;
            }
        }

        /**
         * Sets the value of the locationAddressPhoneIndicator property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setLocationAddressPhoneIndicator(Boolean value) {
            this.locationAddressPhoneIndicator = value;
        }

        /**
         * Gets the value of the locationInfoIndicator property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isLocationInfoIndicator() {
            if (locationInfoIndicator == null) {
                return false;
            } else {
                return locationInfoIndicator;
            }
        }

        /**
         * Sets the value of the locationInfoIndicator property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setLocationInfoIndicator(Boolean value) {
            this.locationInfoIndicator = value;
        }

        /**
         * Gets the value of the vehiclesIndicator property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isVehiclesIndicator() {
            if (vehiclesIndicator == null) {
                return false;
            } else {
                return vehiclesIndicator;
            }
        }

        /**
         * Sets the value of the vehiclesIndicator property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setVehiclesIndicator(Boolean value) {
            this.vehiclesIndicator = value;
        }

        /**
         * Gets the value of the requirementsIndicator property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isRequirementsIndicator() {
            if (requirementsIndicator == null) {
                return false;
            } else {
                return requirementsIndicator;
            }
        }

        /**
         * Sets the value of the requirementsIndicator property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setRequirementsIndicator(Boolean value) {
            this.requirementsIndicator = value;
        }

        /**
         * Gets the value of the additionalFeesIndicator property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isAdditionalFeesIndicator() {
            if (additionalFeesIndicator == null) {
                return false;
            } else {
                return additionalFeesIndicator;
            }
        }

        /**
         * Sets the value of the additionalFeesIndicator property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setAdditionalFeesIndicator(Boolean value) {
            this.additionalFeesIndicator = value;
        }

        /**
         * Gets the value of the liabilitiesIndicator property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isLiabilitiesIndicator() {
            if (liabilitiesIndicator == null) {
                return false;
            } else {
                return liabilitiesIndicator;
            }
        }

        /**
         * Sets the value of the liabilitiesIndicator property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setLiabilitiesIndicator(Boolean value) {
            this.liabilitiesIndicator = value;
        }

        /**
         * Gets the value of the servicesOfferedIndicator property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isServicesOfferedIndicator() {
            if (servicesOfferedIndicator == null) {
                return false;
            } else {
                return servicesOfferedIndicator;
            }
        }

        /**
         * Sets the value of the servicesOfferedIndicator property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setServicesOfferedIndicator(Boolean value) {
            this.servicesOfferedIndicator = value;
        }

    }

}
