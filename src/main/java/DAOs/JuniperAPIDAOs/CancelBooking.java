
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
 *         &lt;element name="CancelRQ" type="{http://www.juniper.es/webservice/2007/}JP_CancelRQ" minOccurs="0"/>
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
    "cancelRQ"
})
@XmlRootElement(name = "CancelBooking")
public class CancelBooking {

    @XmlElement(name = "CancelRQ")
    protected JPCancelRQ cancelRQ;

    /**
     * Gets the value of the cancelRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPCancelRQ }
     *     
     */
    public JPCancelRQ getCancelRQ() {
        return cancelRQ;
    }

    /**
     * Sets the value of the cancelRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCancelRQ }
     *     
     */
    public void setCancelRQ(JPCancelRQ value) {
        this.cancelRQ = value;
    }

}
