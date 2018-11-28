
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Payment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Payment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Price" type="{http://www.juniper.es/webservice/2007/}JP_PaymentPrice" minOccurs="0"/>
 *         &lt;element name="CreditCard" type="{http://www.juniper.es/webservice/2007/}JP_CreditCardInfo" minOccurs="0"/>
 *         &lt;element name="Installments" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="AlternateReceiptCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Action" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="PAY"/>
 *               &lt;enumeration value="RFD"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="PaymentType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Payment", propOrder = {
    "price",
    "creditCard",
    "installments",
    "alternateReceiptCode",
    "action"
})
public class JPPayment {

    @XmlElement(name = "Price")
    protected JPPaymentPrice price;
    @XmlElement(name = "CreditCard")
    protected JPCreditCardInfo creditCard;
    @XmlElement(name = "Installments")
    protected Integer installments;
    @XmlElement(name = "AlternateReceiptCode")
    protected Integer alternateReceiptCode;
    @XmlElement(name = "Action")
    protected String action;
    @XmlAttribute(name = "PaymentType")
    protected String paymentType;

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
     * Gets the value of the creditCard property.
     * 
     * @return
     *     possible object is
     *     {@link JPCreditCardInfo }
     *     
     */
    public JPCreditCardInfo getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the value of the creditCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCreditCardInfo }
     *     
     */
    public void setCreditCard(JPCreditCardInfo value) {
        this.creditCard = value;
    }

    /**
     * Gets the value of the installments property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInstallments() {
        return installments;
    }

    /**
     * Sets the value of the installments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInstallments(Integer value) {
        this.installments = value;
    }

    /**
     * Gets the value of the alternateReceiptCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAlternateReceiptCode() {
        return alternateReceiptCode;
    }

    /**
     * Sets the value of the alternateReceiptCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAlternateReceiptCode(Integer value) {
        this.alternateReceiptCode = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Gets the value of the paymentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the value of the paymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentType(String value) {
        this.paymentType = value;
    }

}
