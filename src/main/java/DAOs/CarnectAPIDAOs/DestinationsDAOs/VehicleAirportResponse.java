
package DAOs.CarnectAPIDAOs.DestinationsDAOs;

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
 *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}DestinationResponse">
 *       &lt;sequence>
 *         &lt;element name="Airports" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfAirport" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "airports"
})
@XmlRootElement(name = "VehicleAirportResponse")
public class VehicleAirportResponse
    extends DestinationResponse
{

    @XmlElement(name = "Airports")
    protected ArrayOfAirport airports;

    /**
     * Gets the value of the airports property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAirport }
     *     
     */
    public ArrayOfAirport getAirports() {
        return airports;
    }

    /**
     * Sets the value of the airports property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAirport }
     *     
     */
    public void setAirports(ArrayOfAirport value) {
        this.airports = value;
    }

}
