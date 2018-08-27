
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PaymentRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PaymentRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CheckPaymentToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Payment" type="{http://www.juniper.es/webservice/2007/}JP_Payment" minOccurs="0"/>
 *         &lt;element name="Refund" type="{http://www.juniper.es/webservice/2007/}JP_Refund" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ReservationLocator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PaymentRequest", propOrder = {
    "checkPaymentToken",
    "payment",
    "refund"
})
public class JPPaymentRequest {

    @XmlElement(name = "CheckPaymentToken")
    protected String checkPaymentToken;
    @XmlElement(name = "Payment")
    protected JPPayment payment;
    @XmlElement(name = "Refund")
    protected JPRefund refund;
    @XmlAttribute(name = "ReservationLocator")
    protected String reservationLocator;

    /**
     * Gets the value of the checkPaymentToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckPaymentToken() {
        return checkPaymentToken;
    }

    /**
     * Sets the value of the checkPaymentToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckPaymentToken(String value) {
        this.checkPaymentToken = value;
    }

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link JPPayment }
     *     
     */
    public JPPayment getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPayment }
     *     
     */
    public void setPayment(JPPayment value) {
        this.payment = value;
    }

    /**
     * Gets the value of the refund property.
     * 
     * @return
     *     possible object is
     *     {@link JPRefund }
     *     
     */
    public JPRefund getRefund() {
        return refund;
    }

    /**
     * Sets the value of the refund property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRefund }
     *     
     */
    public void setRefund(JPRefund value) {
        this.refund = value;
    }

    /**
     * Gets the value of the reservationLocator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservationLocator() {
        return reservationLocator;
    }

    /**
     * Sets the value of the reservationLocator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservationLocator(String value) {
        this.reservationLocator = value;
    }

}
