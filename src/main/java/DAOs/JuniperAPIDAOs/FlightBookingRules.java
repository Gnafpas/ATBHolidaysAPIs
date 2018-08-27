
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
 *         &lt;element name="FlightBookingRulesRQ" type="{http://www.juniper.es/webservice/2007/}JP_FlightBookingRulesRQ" minOccurs="0"/>
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
    "flightBookingRulesRQ"
})
@XmlRootElement(name = "FlightBookingRules")
public class FlightBookingRules {

    @XmlElement(name = "FlightBookingRulesRQ")
    protected JPFlightBookingRulesRQ flightBookingRulesRQ;

    /**
     * Gets the value of the flightBookingRulesRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightBookingRulesRQ }
     *     
     */
    public JPFlightBookingRulesRQ getFlightBookingRulesRQ() {
        return flightBookingRulesRQ;
    }

    /**
     * Sets the value of the flightBookingRulesRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightBookingRulesRQ }
     *     
     */
    public void setFlightBookingRulesRQ(JPFlightBookingRulesRQ value) {
        this.flightBookingRulesRQ = value;
    }

}
