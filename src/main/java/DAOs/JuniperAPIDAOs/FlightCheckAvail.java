
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
 *         &lt;element name="FlightCheckAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_FlightCheckAvailRQ" minOccurs="0"/>
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
    "flightCheckAvailRQ"
})
@XmlRootElement(name = "FlightCheckAvail")
public class FlightCheckAvail {

    @XmlElement(name = "FlightCheckAvailRQ")
    protected JPFlightCheckAvailRQ flightCheckAvailRQ;

    /**
     * Gets the value of the flightCheckAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightCheckAvailRQ }
     *     
     */
    public JPFlightCheckAvailRQ getFlightCheckAvailRQ() {
        return flightCheckAvailRQ;
    }

    /**
     * Sets the value of the flightCheckAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightCheckAvailRQ }
     *     
     */
    public void setFlightCheckAvailRQ(JPFlightCheckAvailRQ value) {
        this.flightCheckAvailRQ = value;
    }

}
