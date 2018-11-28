
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
 *         &lt;element name="TransferBookingRulesRQ" type="{http://www.juniper.es/webservice/2007/}JP_TransferBookingRulesRQ" minOccurs="0"/>
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
    "transferBookingRulesRQ"
})
@XmlRootElement(name = "TransferBookingRules")
public class TransferBookingRules {

    @XmlElement(name = "TransferBookingRulesRQ")
    protected JPTransferBookingRulesRQ transferBookingRulesRQ;

    /**
     * Gets the value of the transferBookingRulesRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferBookingRulesRQ }
     *     
     */
    public JPTransferBookingRulesRQ getTransferBookingRulesRQ() {
        return transferBookingRulesRQ;
    }

    /**
     * Sets the value of the transferBookingRulesRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferBookingRulesRQ }
     *     
     */
    public void setTransferBookingRulesRQ(JPTransferBookingRulesRQ value) {
        this.transferBookingRulesRQ = value;
    }

}
