
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FlightBookingRules complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightBookingRules">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BookingCode" type="{http://www.juniper.es/webservice/2007/}JP_BookingCode" minOccurs="0"/>
 *         &lt;element name="FlightRequiredFields" type="{http://www.juniper.es/webservice/2007/}JP_FlightRequiredFields" minOccurs="0"/>
 *         &lt;element name="CancellationPolicy" type="{http://www.juniper.es/webservice/2007/}JP_CancellationPolicyRules" minOccurs="0"/>
 *         &lt;element name="CancellationPolicyCost" type="{http://www.juniper.es/webservice/2007/}JP_CancellationPolicyRules" minOccurs="0"/>
 *         &lt;element name="PriceInformation" type="{http://www.juniper.es/webservice/2007/}JP_FlightPriceInformation" minOccurs="0"/>
 *         &lt;element name="OptionalElements" type="{http://www.juniper.es/webservice/2007/}JP_OptionalElements" minOccurs="0"/>
 *         &lt;element name="FareGroup" type="{http://www.juniper.es/webservice/2007/}JP_FareGroup" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Status" use="required" type="{http://www.juniper.es/webservice/2007/}JP_AvailStatus" />
 *       &lt;attribute name="Source" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Direction" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LowCost" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Additionalnformation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FlightBookingRules", propOrder = {
    "bookingCode",
    "flightRequiredFields",
    "cancellationPolicy",
    "cancellationPolicyCost",
    "priceInformation",
    "optionalElements",
    "fareGroup"
})
public class JPFlightBookingRules {

    @XmlElement(name = "BookingCode")
    protected JPBookingCode bookingCode;
    @XmlElement(name = "FlightRequiredFields")
    protected JPFlightRequiredFields flightRequiredFields;
    @XmlElement(name = "CancellationPolicy")
    protected JPCancellationPolicyRules cancellationPolicy;
    @XmlElement(name = "CancellationPolicyCost")
    protected JPCancellationPolicyRules cancellationPolicyCost;
    @XmlElement(name = "PriceInformation")
    protected JPFlightPriceInformation priceInformation;
    @XmlElement(name = "OptionalElements")
    protected JPOptionalElements optionalElements;
    @XmlElement(name = "FareGroup")
    protected JPFareGroup fareGroup;
    @XmlAttribute(name = "Status", required = true)
    protected JPAvailStatus status;
    @XmlAttribute(name = "Source")
    protected String source;
    @XmlAttribute(name = "Direction")
    protected String direction;
    @XmlAttribute(name = "LowCost", required = true)
    protected boolean lowCost;
    @XmlAttribute(name = "Additionalnformation")
    protected String additionalnformation;

    /**
     * Gets the value of the bookingCode property.
     * 
     * @return
     *     possible object is
     *     {@link JPBookingCode }
     *     
     */
    public JPBookingCode getBookingCode() {
        return bookingCode;
    }

    /**
     * Sets the value of the bookingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBookingCode }
     *     
     */
    public void setBookingCode(JPBookingCode value) {
        this.bookingCode = value;
    }

    /**
     * Gets the value of the flightRequiredFields property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightRequiredFields }
     *     
     */
    public JPFlightRequiredFields getFlightRequiredFields() {
        return flightRequiredFields;
    }

    /**
     * Sets the value of the flightRequiredFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightRequiredFields }
     *     
     */
    public void setFlightRequiredFields(JPFlightRequiredFields value) {
        this.flightRequiredFields = value;
    }

    /**
     * Gets the value of the cancellationPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link JPCancellationPolicyRules }
     *     
     */
    public JPCancellationPolicyRules getCancellationPolicy() {
        return cancellationPolicy;
    }

    /**
     * Sets the value of the cancellationPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCancellationPolicyRules }
     *     
     */
    public void setCancellationPolicy(JPCancellationPolicyRules value) {
        this.cancellationPolicy = value;
    }

    /**
     * Gets the value of the cancellationPolicyCost property.
     * 
     * @return
     *     possible object is
     *     {@link JPCancellationPolicyRules }
     *     
     */
    public JPCancellationPolicyRules getCancellationPolicyCost() {
        return cancellationPolicyCost;
    }

    /**
     * Sets the value of the cancellationPolicyCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCancellationPolicyRules }
     *     
     */
    public void setCancellationPolicyCost(JPCancellationPolicyRules value) {
        this.cancellationPolicyCost = value;
    }

    /**
     * Gets the value of the priceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightPriceInformation }
     *     
     */
    public JPFlightPriceInformation getPriceInformation() {
        return priceInformation;
    }

    /**
     * Sets the value of the priceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightPriceInformation }
     *     
     */
    public void setPriceInformation(JPFlightPriceInformation value) {
        this.priceInformation = value;
    }

    /**
     * Gets the value of the optionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPOptionalElements }
     *     
     */
    public JPOptionalElements getOptionalElements() {
        return optionalElements;
    }

    /**
     * Sets the value of the optionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPOptionalElements }
     *     
     */
    public void setOptionalElements(JPOptionalElements value) {
        this.optionalElements = value;
    }

    /**
     * Gets the value of the fareGroup property.
     * 
     * @return
     *     possible object is
     *     {@link JPFareGroup }
     *     
     */
    public JPFareGroup getFareGroup() {
        return fareGroup;
    }

    /**
     * Sets the value of the fareGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFareGroup }
     *     
     */
    public void setFareGroup(JPFareGroup value) {
        this.fareGroup = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JPAvailStatus }
     *     
     */
    public JPAvailStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPAvailStatus }
     *     
     */
    public void setStatus(JPAvailStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirection(String value) {
        this.direction = value;
    }

    /**
     * Gets the value of the lowCost property.
     * 
     */
    public boolean isLowCost() {
        return lowCost;
    }

    /**
     * Sets the value of the lowCost property.
     * 
     */
    public void setLowCost(boolean value) {
        this.lowCost = value;
    }

    /**
     * Gets the value of the additionalnformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalnformation() {
        return additionalnformation;
    }

    /**
     * Sets the value of the additionalnformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalnformation(String value) {
        this.additionalnformation = value;
    }

}
