
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
 *         &lt;element name="RentacarBookingRulesRQ" type="{http://www.juniper.es/webservice/2007/}JP_RentacarBookingRulesRQ" minOccurs="0"/>
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
    "rentacarBookingRulesRQ"
})
@XmlRootElement(name = "RentacarBookingRules")
public class RentacarBookingRules {

    @XmlElement(name = "RentacarBookingRulesRQ")
    protected JPRentacarBookingRulesRQ rentacarBookingRulesRQ;

    /**
     * Gets the value of the rentacarBookingRulesRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarBookingRulesRQ }
     *     
     */
    public JPRentacarBookingRulesRQ getRentacarBookingRulesRQ() {
        return rentacarBookingRulesRQ;
    }

    /**
     * Sets the value of the rentacarBookingRulesRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarBookingRulesRQ }
     *     
     */
    public void setRentacarBookingRulesRQ(JPRentacarBookingRulesRQ value) {
        this.rentacarBookingRulesRQ = value;
    }

}
