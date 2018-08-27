
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
 *         &lt;element name="FlightTicketingRS" type="{http://www.juniper.es/webservice/2007/}JP_FlightTicketingRS" minOccurs="0"/>
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
    "flightTicketingRS"
})
@XmlRootElement(name = "FlightTicketingResponse")
public class FlightTicketingResponse {

    @XmlElement(name = "FlightTicketingRS")
    protected JPFlightTicketingRS flightTicketingRS;

    /**
     * Gets the value of the flightTicketingRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightTicketingRS }
     *     
     */
    public JPFlightTicketingRS getFlightTicketingRS() {
        return flightTicketingRS;
    }

    /**
     * Sets the value of the flightTicketingRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightTicketingRS }
     *     
     */
    public void setFlightTicketingRS(JPFlightTicketingRS value) {
        this.flightTicketingRS = value;
    }

}
