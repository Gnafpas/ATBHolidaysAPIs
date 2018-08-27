
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JPSOAP_ContractRestrictions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_ContractRestrictions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequiredOptionalSupplements" type="{http://www.juniper.es/webservice/2007/}JPSOAP_RequiredOptionalSupplements" minOccurs="0"/>
 *         &lt;element name="CountryOfResidence" type="{http://www.juniper.es/webservice/2007/}JPSOAP_CountryOfResidence" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="MinNights" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MaxNights" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MinAdults" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="BookingFrom" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="BookingTo" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="Application" use="required" type="{http://www.juniper.es/webservice/2007/}JPSOAP_ContractRestrictionApplication" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_ContractRestrictions", propOrder = {
    "requiredOptionalSupplements",
    "countryOfResidence"
})
public class JPSOAPContractRestrictions {

    @XmlElement(name = "RequiredOptionalSupplements")
    protected JPSOAPRequiredOptionalSupplements requiredOptionalSupplements;
    @XmlElement(name = "CountryOfResidence")
    protected JPSOAPCountryOfResidence countryOfResidence;
    @XmlAttribute(name = "MinNights")
    protected Integer minNights;
    @XmlAttribute(name = "MaxNights")
    protected Integer maxNights;
    @XmlAttribute(name = "MinAdults")
    protected Integer minAdults;
    @XmlAttribute(name = "BookingFrom")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar bookingFrom;
    @XmlAttribute(name = "BookingTo")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar bookingTo;
    @XmlAttribute(name = "Application", required = true)
    protected JPSOAPContractRestrictionApplication application;

    /**
     * Gets the value of the requiredOptionalSupplements property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPRequiredOptionalSupplements }
     *     
     */
    public JPSOAPRequiredOptionalSupplements getRequiredOptionalSupplements() {
        return requiredOptionalSupplements;
    }

    /**
     * Sets the value of the requiredOptionalSupplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPRequiredOptionalSupplements }
     *     
     */
    public void setRequiredOptionalSupplements(JPSOAPRequiredOptionalSupplements value) {
        this.requiredOptionalSupplements = value;
    }

    /**
     * Gets the value of the countryOfResidence property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPCountryOfResidence }
     *     
     */
    public JPSOAPCountryOfResidence getCountryOfResidence() {
        return countryOfResidence;
    }

    /**
     * Sets the value of the countryOfResidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPCountryOfResidence }
     *     
     */
    public void setCountryOfResidence(JPSOAPCountryOfResidence value) {
        this.countryOfResidence = value;
    }

    /**
     * Gets the value of the minNights property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinNights() {
        return minNights;
    }

    /**
     * Sets the value of the minNights property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinNights(Integer value) {
        this.minNights = value;
    }

    /**
     * Gets the value of the maxNights property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxNights() {
        return maxNights;
    }

    /**
     * Sets the value of the maxNights property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxNights(Integer value) {
        this.maxNights = value;
    }

    /**
     * Gets the value of the minAdults property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinAdults() {
        return minAdults;
    }

    /**
     * Sets the value of the minAdults property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinAdults(Integer value) {
        this.minAdults = value;
    }

    /**
     * Gets the value of the bookingFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBookingFrom() {
        return bookingFrom;
    }

    /**
     * Sets the value of the bookingFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBookingFrom(XMLGregorianCalendar value) {
        this.bookingFrom = value;
    }

    /**
     * Gets the value of the bookingTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBookingTo() {
        return bookingTo;
    }

    /**
     * Sets the value of the bookingTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBookingTo(XMLGregorianCalendar value) {
        this.bookingTo = value;
    }

    /**
     * Gets the value of the application property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPContractRestrictionApplication }
     *     
     */
    public JPSOAPContractRestrictionApplication getApplication() {
        return application;
    }

    /**
     * Sets the value of the application property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPContractRestrictionApplication }
     *     
     */
    public void setApplication(JPSOAPContractRestrictionApplication value) {
        this.application = value;
    }

}
