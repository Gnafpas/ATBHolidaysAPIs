
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PaymentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PaymentInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Price" type="{http://www.juniper.es/webservice/2007/}JP_PaymentPrice" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="OrderCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PaymentCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AcceptanceCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ECI" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="PaymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BrandCard" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PaymentInfo", propOrder = {
    "price"
})
public class JPPaymentInfo {

    @XmlElement(name = "Price")
    protected JPPaymentPrice price;
    @XmlAttribute(name = "OrderCode")
    protected String orderCode;
    @XmlAttribute(name = "PaymentCode")
    protected String paymentCode;
    @XmlAttribute(name = "AcceptanceCode")
    protected String acceptanceCode;
    @XmlAttribute(name = "ECI")
    protected Integer eci;
    @XmlAttribute(name = "PaymentMethod")
    protected String paymentMethod;
    @XmlAttribute(name = "BrandCard")
    protected String brandCard;

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link JPPaymentPrice }
     *     
     */
    public JPPaymentPrice getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPaymentPrice }
     *     
     */
    public void setPrice(JPPaymentPrice value) {
        this.price = value;
    }

    /**
     * Gets the value of the orderCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * Sets the value of the orderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderCode(String value) {
        this.orderCode = value;
    }

    /**
     * Gets the value of the paymentCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentCode() {
        return paymentCode;
    }

    /**
     * Sets the value of the paymentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentCode(String value) {
        this.paymentCode = value;
    }

    /**
     * Gets the value of the acceptanceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcceptanceCode() {
        return acceptanceCode;
    }

    /**
     * Sets the value of the acceptanceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcceptanceCode(String value) {
        this.acceptanceCode = value;
    }

    /**
     * Gets the value of the eci property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getECI() {
        return eci;
    }

    /**
     * Sets the value of the eci property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setECI(Integer value) {
        this.eci = value;
    }

    /**
     * Gets the value of the paymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the value of the paymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethod(String value) {
        this.paymentMethod = value;
    }

    /**
     * Gets the value of the brandCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrandCard() {
        return brandCard;
    }

    /**
     * Sets the value of the brandCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrandCard(String value) {
        this.brandCard = value;
    }

}
