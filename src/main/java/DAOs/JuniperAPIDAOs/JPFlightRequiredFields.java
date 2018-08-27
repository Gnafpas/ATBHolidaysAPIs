
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FlightRequiredFields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightRequiredFields">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FlightBooking" type="{http://www.juniper.es/webservice/2007/}JP_FlightBooking" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FlightRequiredFields", propOrder = {
    "flightBooking"
})
public class JPFlightRequiredFields {

    @XmlElement(name = "FlightBooking")
    protected JPFlightBooking flightBooking;

    /**
     * Gets the value of the flightBooking property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightBooking }
     *     
     */
    public JPFlightBooking getFlightBooking() {
        return flightBooking;
    }

    /**
     * Sets the value of the flightBooking property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightBooking }
     *     
     */
    public void setFlightBooking(JPFlightBooking value) {
        this.flightBooking = value;
    }

}
