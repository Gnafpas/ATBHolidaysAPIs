
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
 *         &lt;element name="TransferBookingRQ" type="{http://www.juniper.es/webservice/2007/}JP_TransferBooking" minOccurs="0"/>
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
    "transferBookingRQ"
})
@XmlRootElement(name = "TransferBooking")
public class TransferBooking {

    @XmlElement(name = "TransferBookingRQ")
    protected JPTransferBooking transferBookingRQ;

    /**
     * Gets the value of the transferBookingRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferBooking }
     *     
     */
    public JPTransferBooking getTransferBookingRQ() {
        return transferBookingRQ;
    }

    /**
     * Sets the value of the transferBookingRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferBooking }
     *     
     */
    public void setTransferBookingRQ(JPTransferBooking value) {
        this.transferBookingRQ = value;
    }

}
