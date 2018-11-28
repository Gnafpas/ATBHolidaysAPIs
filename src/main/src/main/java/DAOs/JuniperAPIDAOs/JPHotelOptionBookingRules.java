
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelOptionBookingRules complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelOptionBookingRules">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BookingCode" type="{http://www.juniper.es/webservice/2007/}JP_BookingCode" minOccurs="0"/>
 *         &lt;element name="HotelRequiredFields" type="{http://www.juniper.es/webservice/2007/}JP_HotelRequiredFields" minOccurs="0"/>
 *         &lt;element name="VirtualCreditCardPayment" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="VirtualCreditCardInfo" type="{http://www.juniper.es/webservice/2007/}JP_VirtualCreditCardInfo" minOccurs="0"/>
 *         &lt;element name="CancellationPolicy" type="{http://www.juniper.es/webservice/2007/}JP_CancellationPolicyRules" minOccurs="0"/>
 *         &lt;element name="CancellationPolicyCost" type="{http://www.juniper.es/webservice/2007/}JP_CancellationPolicyRules" minOccurs="0"/>
 *         &lt;element name="PriceInformation" type="{http://www.juniper.es/webservice/2007/}JP_HotelOptionCheckAvail" minOccurs="0"/>
 *         &lt;element name="OptionalElements" type="{http://www.juniper.es/webservice/2007/}JP_HotelOptionalElements" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PaymentDestination" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Status" type="{http://www.juniper.es/webservice/2007/}JP_AvailStatus" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelOptionBookingRules", propOrder = {
    "bookingCode",
    "hotelRequiredFields",
    "virtualCreditCardPayment",
    "virtualCreditCardInfo",
    "cancellationPolicy",
    "cancellationPolicyCost",
    "priceInformation",
    "optionalElements"
})
public class JPHotelOptionBookingRules {

    @XmlElement(name = "BookingCode")
    protected JPBookingCode bookingCode;
    @XmlElement(name = "HotelRequiredFields")
    protected JPHotelRequiredFields hotelRequiredFields;
    @XmlElement(name = "VirtualCreditCardPayment")
    protected Object virtualCreditCardPayment;
    @XmlElement(name = "VirtualCreditCardInfo")
    protected JPVirtualCreditCardInfo virtualCreditCardInfo;
    @XmlElement(name = "CancellationPolicy")
    protected JPCancellationPolicyRules cancellationPolicy;
    @XmlElement(name = "CancellationPolicyCost")
    protected JPCancellationPolicyRules cancellationPolicyCost;
    @XmlElement(name = "PriceInformation")
    protected JPHotelOptionCheckAvail priceInformation;
    @XmlElement(name = "OptionalElements")
    protected JPHotelOptionalElements optionalElements;
    @XmlAttribute(name = "PaymentDestination")
    protected Boolean paymentDestination;
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
     * Gets the value of the hotelRequiredFields property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelRequiredFields }
     *     
     */
    public JPHotelRequiredFields getHotelRequiredFields() {
        return hotelRequiredFields;
    }

    /**
     * Sets the value of the hotelRequiredFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelRequiredFields }
     *     
     */
    public void setHotelRequiredFields(JPHotelRequiredFields value) {
        this.hotelRequiredFields = value;
    }

    /**
     * Gets the value of the virtualCreditCardPayment property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getVirtualCreditCardPayment() {
        return virtualCreditCardPayment;
    }

    /**
     * Sets the value of the virtualCreditCardPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setVirtualCreditCardPayment(Object value) {
        this.virtualCreditCardPayment = value;
    }

    /**
     * Gets the value of the virtualCreditCardInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPVirtualCreditCardInfo }
     *     
     */
    public JPVirtualCreditCardInfo getVirtualCreditCardInfo() {
        return virtualCreditCardInfo;
    }

    /**
     * Sets the value of the virtualCreditCardInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPVirtualCreditCardInfo }
     *     
     */
    public void setVirtualCreditCardInfo(JPVirtualCreditCardInfo value) {
        this.virtualCreditCardInfo = value;
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
     *     {@link JPHotelOptionCheckAvail }
     *     
     */
    public JPHotelOptionCheckAvail getPriceInformation() {
        return priceInformation;
    }

    /**
     * Sets the value of the priceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelOptionCheckAvail }
     *     
     */
    public void setPriceInformation(JPHotelOptionCheckAvail value) {
        this.priceInformation = value;
    }

    /**
     * Gets the value of the optionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelOptionalElements }
     *     
     */
    public JPHotelOptionalElements getOptionalElements() {
        return optionalElements;
    }

    /**
     * Sets the value of the optionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelOptionalElements }
     *     
     */
    public void setOptionalElements(JPHotelOptionalElements value) {
        this.optionalElements = value;
    }

    /**
     * Gets the value of the paymentDestination property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPaymentDestination() {
        return paymentDestination;
    }

    /**
     * Sets the value of the paymentDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPaymentDestination(Boolean value) {
        this.paymentDestination = value;
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
