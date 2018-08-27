
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
 *         &lt;element name="FlightAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_FlightAvail" minOccurs="0"/>
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
    "flightAvailRQ"
})
@XmlRootElement(name = "FlightAvail")
public class FlightAvail {

    @XmlElement(name = "FlightAvailRQ")
    protected JPFlightAvail flightAvailRQ;

    /**
     * Gets the value of the flightAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightAvail }
     *     
     */
    public JPFlightAvail getFlightAvailRQ() {
        return flightAvailRQ;
    }

    /**
     * Sets the value of the flightAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightAvail }
     *     
     */
    public void setFlightAvailRQ(JPFlightAvail value) {
        this.flightAvailRQ = value;
    }

}
