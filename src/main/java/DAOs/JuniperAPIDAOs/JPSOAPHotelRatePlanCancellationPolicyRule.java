
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_hotelRatePlanCancellationPolicyRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_hotelRatePlanCancellationPolicyRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="From" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="To" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="StayLengthFrom" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="StayLengthTo" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Type" use="required" type="{http://www.juniper.es/webservice/2007/}JPSOAP_CancellationPolicyRuleTypes" />
 *       &lt;attribute name="FixedPrice" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="PercentPrice" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="ApplicationTypeNights" use="required" type="{http://www.juniper.es/webservice/2007/}JPSOAP_CancellationPolicyRuleQuotationType" />
 *       &lt;attribute name="Nights" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_hotelRatePlanCancellationPolicyRule")
public class JPSOAPHotelRatePlanCancellationPolicyRule {

    @XmlAttribute(name = "From")
    protected Integer from;
    @XmlAttribute(name = "To")
    protected Integer to;
    @XmlAttribute(name = "StayLengthFrom")
    protected Integer stayLengthFrom;
    @XmlAttribute(name = "StayLengthTo")
    protected Integer stayLengthTo;
    @XmlAttribute(name = "Type", required = true)
    protected JPSOAPCancellationPolicyRuleTypes type;
    @XmlAttribute(name = "FixedPrice")
    protected Double fixedPrice;
    @XmlAttribute(name = "PercentPrice")
    protected Double percentPrice;
    @XmlAttribute(name = "ApplicationTypeNights", required = true)
    protected JPSOAPCancellationPolicyRuleQuotationType applicationTypeNights;
    @XmlAttribute(name = "Nights")
    protected Integer nights;

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFrom(Integer value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTo(Integer value) {
        this.to = value;
    }

    /**
     * Gets the value of the stayLengthFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStayLengthFrom() {
        return stayLengthFrom;
    }

    /**
     * Sets the value of the stayLengthFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStayLengthFrom(Integer value) {
        this.stayLengthFrom = value;
    }

    /**
     * Gets the value of the stayLengthTo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStayLengthTo() {
        return stayLengthTo;
    }

    /**
     * Sets the value of the stayLengthTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStayLengthTo(Integer value) {
        this.stayLengthTo = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPCancellationPolicyRuleTypes }
     *     
     */
    public JPSOAPCancellationPolicyRuleTypes getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPCancellationPolicyRuleTypes }
     *     
     */
    public void setType(JPSOAPCancellationPolicyRuleTypes value) {
        this.type = value;
    }

    /**
     * Gets the value of the fixedPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFixedPrice() {
        return fixedPrice;
    }

    /**
     * Sets the value of the fixedPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFixedPrice(Double value) {
        this.fixedPrice = value;
    }

    /**
     * Gets the value of the percentPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentPrice() {
        return percentPrice;
    }

    /**
     * Sets the value of the percentPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentPrice(Double value) {
        this.percentPrice = value;
    }

    /**
     * Gets the value of the applicationTypeNights property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPCancellationPolicyRuleQuotationType }
     *     
     */
    public JPSOAPCancellationPolicyRuleQuotationType getApplicationTypeNights() {
        return applicationTypeNights;
    }

    /**
     * Sets the value of the applicationTypeNights property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPCancellationPolicyRuleQuotationType }
     *     
     */
    public void setApplicationTypeNights(JPSOAPCancellationPolicyRuleQuotationType value) {
        this.applicationTypeNights = value;
    }

    /**
     * Gets the value of the nights property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNights() {
        return nights;
    }

    /**
     * Sets the value of the nights property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNights(Integer value) {
        this.nights = value;
    }

}
