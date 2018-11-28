
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
 *         &lt;element name="RentacarCheckAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_RentacarCheckAvailRQ" minOccurs="0"/>
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
    "rentacarCheckAvailRQ"
})
@XmlRootElement(name = "RentacarCheckAvail")
public class RentacarCheckAvail {

    @XmlElement(name = "RentacarCheckAvailRQ")
    protected JPRentacarCheckAvailRQ rentacarCheckAvailRQ;

    /**
     * Gets the value of the rentacarCheckAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarCheckAvailRQ }
     *     
     */
    public JPRentacarCheckAvailRQ getRentacarCheckAvailRQ() {
        return rentacarCheckAvailRQ;
    }

    /**
     * Sets the value of the rentacarCheckAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarCheckAvailRQ }
     *     
     */
    public void setRentacarCheckAvailRQ(JPRentacarCheckAvailRQ value) {
        this.rentacarCheckAvailRQ = value;
    }

}
