
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
 *         &lt;element name="RentacarAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_RentacarAvail" minOccurs="0"/>
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
    "rentacarAvailRQ"
})
@XmlRootElement(name = "RentacarAvail")
public class RentacarAvail {

    @XmlElement(name = "RentacarAvailRQ")
    protected JPRentacarAvail rentacarAvailRQ;

    /**
     * Gets the value of the rentacarAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarAvail }
     *     
     */
    public JPRentacarAvail getRentacarAvailRQ() {
        return rentacarAvailRQ;
    }

    /**
     * Sets the value of the rentacarAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarAvail }
     *     
     */
    public void setRentacarAvailRQ(JPRentacarAvail value) {
        this.rentacarAvailRQ = value;
    }

}
