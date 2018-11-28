
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
 *         &lt;element name="TransferCheckAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_TransferCheckAvailRQ" minOccurs="0"/>
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
    "transferCheckAvailRQ"
})
@XmlRootElement(name = "TransferCheckAvail")
public class TransferCheckAvail {

    @XmlElement(name = "TransferCheckAvailRQ")
    protected JPTransferCheckAvailRQ transferCheckAvailRQ;

    /**
     * Gets the value of the transferCheckAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferCheckAvailRQ }
     *     
     */
    public JPTransferCheckAvailRQ getTransferCheckAvailRQ() {
        return transferCheckAvailRQ;
    }

    /**
     * Sets the value of the transferCheckAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferCheckAvailRQ }
     *     
     */
    public void setTransferCheckAvailRQ(JPTransferCheckAvailRQ value) {
        this.transferCheckAvailRQ = value;
    }

}
