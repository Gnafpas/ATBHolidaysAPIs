
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
 *         &lt;element name="FlightBookingRQ" type="{http://www.juniper.es/webservice/2007/}JP_FlightBooking" minOccurs="0"/>
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
    "flightBookingRQ"
})
@XmlRootElement(name = "FlightBooking")
public class FlightBooking {

    @XmlElement(name = "FlightBookingRQ")
    protected JPFlightBooking flightBookingRQ;

    /**
     * Gets the value of the flightBookingRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightBooking }
     *     
     */
    public JPFlightBooking getFlightBookingRQ() {
        return flightBookingRQ;
    }

    /**
     * Sets the value of the flightBookingRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightBooking }
     *     
     */
    public void setFlightBookingRQ(JPFlightBooking value) {
        this.flightBookingRQ = value;
    }

}
