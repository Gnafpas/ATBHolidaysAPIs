
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PaymentReservation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PaymentReservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaymentInfo" type="{http://www.juniper.es/webservice/2007/}JP_PaymentInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Locator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Status" use="required" type="{http://www.juniper.es/webservice/2007/}JP_ResStatus" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PaymentReservation", propOrder = {
    "paymentInfo"
})
public class JPPaymentReservation {

    @XmlElement(name = "PaymentInfo")
    protected JPPaymentInfo paymentInfo;
    @XmlAttribute(name = "Locator")
    protected String locator;
    @XmlAttribute(name = "Status", required = true)
    protected JPResStatus status;

    /**
     * Gets the value of the paymentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPPaymentInfo }
     *     
     */
    public JPPaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    /**
     * Sets the value of the paymentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPaymentInfo }
     *     
     */
    public void setPaymentInfo(JPPaymentInfo value) {
        this.paymentInfo = value;
    }

    /**
     * Gets the value of the locator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocator() {
        return locator;
    }

    /**
     * Sets the value of the locator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocator(String value) {
        this.locator = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JPResStatus }
     *     
     */
    public JPResStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPResStatus }
     *     
     */
    public void setStatus(JPResStatus value) {
        this.status = value;
    }

}
