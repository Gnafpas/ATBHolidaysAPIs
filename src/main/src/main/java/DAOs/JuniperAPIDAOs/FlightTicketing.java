
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
 *         &lt;element name="FlightTicketingRQ" type="{http://www.juniper.es/webservice/2007/}JP_FlightTicketingRQ" minOccurs="0"/>
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
    "flightTicketingRQ"
})
@XmlRootElement(name = "FlightTicketing")
public class FlightTicketing {

    @XmlElement(name = "FlightTicketingRQ")
    protected JPFlightTicketingRQ flightTicketingRQ;

    /**
     * Gets the value of the flightTicketingRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightTicketingRQ }
     *     
     */
    public JPFlightTicketingRQ getFlightTicketingRQ() {
        return flightTicketingRQ;
    }

    /**
     * Sets the value of the flightTicketingRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightTicketingRQ }
     *     
     */
    public void setFlightTicketingRQ(JPFlightTicketingRQ value) {
        this.flightTicketingRQ = value;
    }

}
