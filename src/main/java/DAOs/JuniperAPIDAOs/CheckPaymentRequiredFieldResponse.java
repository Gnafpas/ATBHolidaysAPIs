
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CheckPaymentRequiredFieldsRS" type="{http://www.juniper.es/webservice/2007/}JP_CheckPaymentRequiredFieldsRS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "checkPaymentRequiredFieldsRS"
})
@XmlRootElement(name = "CheckPaymentRequiredFieldResponse")
public class CheckPaymentRequiredFieldResponse {

    @XmlElement(name = "CheckPaymentRequiredFieldsRS")
    protected JPCheckPaymentRequiredFieldsRS checkPaymentRequiredFieldsRS;

    /**
     * Gets the value of the checkPaymentRequiredFieldsRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPCheckPaymentRequiredFieldsRS }
     *     
     */
    public JPCheckPaymentRequiredFieldsRS getCheckPaymentRequiredFieldsRS() {
        return checkPaymentRequiredFieldsRS;
    }

    /**
     * Sets the value of the checkPaymentRequiredFieldsRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCheckPaymentRequiredFieldsRS }
     *     
     */
    public void setCheckPaymentRequiredFieldsRS(JPCheckPaymentRequiredFieldsRS value) {
        this.checkPaymentRequiredFieldsRS = value;
    }

}
