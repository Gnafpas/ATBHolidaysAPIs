
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_InsuranceBookingRules complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_InsuranceBookingRules">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BookingCode" type="{http://www.juniper.es/webservice/2007/}JP_BookingCode" minOccurs="0"/>
 *         &lt;element name="InsuranceRequiredFields" type="{http://www.juniper.es/webservice/2007/}JP_InsuranceRequiredFields" minOccurs="0"/>
 *         &lt;element name="CancellationPolicy" type="{http://www.juniper.es/webservice/2007/}JP_CancellationPolicyRules" minOccurs="0"/>
 *         &lt;element name="CancellationPolicyCost" type="{http://www.juniper.es/webservice/2007/}JP_CancellationPolicyRules" minOccurs="0"/>
 *         &lt;element name="PriceInformation" type="{http://www.juniper.es/webservice/2007/}JP_InsurancePriceInformation" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Status" type="{http://www.juniper.es/webservice/2007/}JP_AvailStatus" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_InsuranceBookingRules", propOrder = {
    "bookingCode",
    "insuranceRequiredFields",
    "cancellationPolicy",
    "cancellationPolicyCost",
    "priceInformation"
})
public class JPInsuranceBookingRules {

    @XmlElement(name = "BookingCode")
    protected JPBookingCode bookingCode;
    @XmlElement(name = "InsuranceRequiredFields")
    protected JPInsuranceRequiredFields insuranceRequiredFields;
    @XmlElement(name = "CancellationPolicy")
    protected JPCancellationPolicyRules cancellationPolicy;
    @XmlElement(name = "CancellationPolicyCost")
    protected JPCancellationPolicyRules cancellationPolicyCost;
    @XmlElement(name = "PriceInformation")
    protected JPInsurancePriceInformation priceInformation;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;
    @XmlAttribute(name = "Status")
    protected JPAvailStatus status;

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
     * Gets the value of the insuranceRequiredFields property.
     * 
     * @return
     *     possible object is
     *     {@link JPInsuranceRequiredFields }
     *     
     */
    public JPInsuranceRequiredFields getInsuranceRequiredFields() {
        return insuranceRequiredFields;
    }

    /**
     * Sets the value of the insuranceRequiredFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPInsuranceRequiredFields }
     *     
     */
    public void setInsuranceRequiredFields(JPInsuranceRequiredFields value) {
        this.insuranceRequiredFields = value;
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
     *     {@link JPInsurancePriceInformation }
     *     
     */
    public JPInsurancePriceInformation getPriceInformation() {
        return priceInformation;
    }

    /**
     * Sets the value of the priceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPInsurancePriceInformation }
     *     
     */
    public void setPriceInformation(JPInsurancePriceInformation value) {
        this.priceInformation = value;
    }

    /**
     * Gets the value of the ratePlanCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRatePlanCode() {
        return ratePlanCode;
    }

    /**
     * Sets the value of the ratePlanCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatePlanCode(String value) {
        this.ratePlanCode = value;
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

}
