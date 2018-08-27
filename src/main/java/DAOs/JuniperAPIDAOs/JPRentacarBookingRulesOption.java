
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarBookingRulesOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarBookingRulesOption">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentacarInfo" type="{http://www.juniper.es/webservice/2007/}JP_RentacarInfo" minOccurs="0"/>
 *         &lt;element name="BookingCode" type="{http://www.juniper.es/webservice/2007/}JP_BookingCode" minOccurs="0"/>
 *         &lt;element name="RentcarRequiredFields" type="{http://www.juniper.es/webservice/2007/}JP_RentcarRequiredFields" minOccurs="0"/>
 *         &lt;element name="CancellationPolicy" type="{http://www.juniper.es/webservice/2007/}JP_CancellationPolicyRules" minOccurs="0"/>
 *         &lt;element name="CancellationPolicyCost" type="{http://www.juniper.es/webservice/2007/}JP_CancellationPolicyRules" minOccurs="0"/>
 *         &lt;element name="PriceInformation" type="{http://www.juniper.es/webservice/2007/}JP_RentacarPriceInformation" minOccurs="0"/>
 *         &lt;element name="OptionalElements" type="{http://www.juniper.es/webservice/2007/}JP_RentacarOptionalElements" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PickUpCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DropOffCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AcrissCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Status" type="{http://www.juniper.es/webservice/2007/}JP_AvailStatus" />
 *       &lt;attribute name="PaymentOffice" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarBookingRulesOption", propOrder = {
    "rentacarInfo",
    "bookingCode",
    "rentcarRequiredFields",
    "cancellationPolicy",
    "cancellationPolicyCost",
    "priceInformation",
    "optionalElements"
})
public class JPRentacarBookingRulesOption {

    @XmlElement(name = "RentacarInfo")
    protected JPRentacarInfo rentacarInfo;
    @XmlElement(name = "BookingCode")
    protected JPBookingCode bookingCode;
    @XmlElement(name = "RentcarRequiredFields")
    protected JPRentcarRequiredFields rentcarRequiredFields;
    @XmlElement(name = "CancellationPolicy")
    protected JPCancellationPolicyRules cancellationPolicy;
    @XmlElement(name = "CancellationPolicyCost")
    protected JPCancellationPolicyRules cancellationPolicyCost;
    @XmlElement(name = "PriceInformation")
    protected JPRentacarPriceInformation priceInformation;
    @XmlElement(name = "OptionalElements")
    protected JPRentacarOptionalElements optionalElements;
    @XmlAttribute(name = "PickUpCode")
    protected String pickUpCode;
    @XmlAttribute(name = "DropOffCode")
    protected String dropOffCode;
    @XmlAttribute(name = "AcrissCode")
    protected String acrissCode;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;
    @XmlAttribute(name = "Status")
    protected JPAvailStatus status;
    @XmlAttribute(name = "PaymentOffice")
    protected Boolean paymentOffice;

    /**
     * Gets the value of the rentacarInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarInfo }
     *     
     */
    public JPRentacarInfo getRentacarInfo() {
        return rentacarInfo;
    }

    /**
     * Sets the value of the rentacarInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarInfo }
     *     
     */
    public void setRentacarInfo(JPRentacarInfo value) {
        this.rentacarInfo = value;
    }

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
     * Gets the value of the rentcarRequiredFields property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentcarRequiredFields }
     *     
     */
    public JPRentcarRequiredFields getRentcarRequiredFields() {
        return rentcarRequiredFields;
    }

    /**
     * Sets the value of the rentcarRequiredFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentcarRequiredFields }
     *     
     */
    public void setRentcarRequiredFields(JPRentcarRequiredFields value) {
        this.rentcarRequiredFields = value;
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
     *     {@link JPRentacarPriceInformation }
     *     
     */
    public JPRentacarPriceInformation getPriceInformation() {
        return priceInformation;
    }

    /**
     * Sets the value of the priceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarPriceInformation }
     *     
     */
    public void setPriceInformation(JPRentacarPriceInformation value) {
        this.priceInformation = value;
    }

    /**
     * Gets the value of the optionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarOptionalElements }
     *     
     */
    public JPRentacarOptionalElements getOptionalElements() {
        return optionalElements;
    }

    /**
     * Sets the value of the optionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarOptionalElements }
     *     
     */
    public void setOptionalElements(JPRentacarOptionalElements value) {
        this.optionalElements = value;
    }

    /**
     * Gets the value of the pickUpCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPickUpCode() {
        return pickUpCode;
    }

    /**
     * Sets the value of the pickUpCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPickUpCode(String value) {
        this.pickUpCode = value;
    }

    /**
     * Gets the value of the dropOffCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDropOffCode() {
        return dropOffCode;
    }

    /**
     * Sets the value of the dropOffCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDropOffCode(String value) {
        this.dropOffCode = value;
    }

    /**
     * Gets the value of the acrissCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcrissCode() {
        return acrissCode;
    }

    /**
     * Sets the value of the acrissCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcrissCode(String value) {
        this.acrissCode = value;
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

    /**
     * Gets the value of the paymentOffice property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPaymentOffice() {
        return paymentOffice;
    }

    /**
     * Sets the value of the paymentOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPaymentOffice(Boolean value) {
        this.paymentOffice = value;
    }

}
