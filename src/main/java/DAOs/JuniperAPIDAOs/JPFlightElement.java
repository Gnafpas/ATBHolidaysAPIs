
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FlightElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightElement">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BaseElement">
 *       &lt;sequence>
 *         &lt;element name="FlightBookingInfo" type="{http://www.juniper.es/webservice/2007/}JP_FlightBookingInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FlightElement", propOrder = {
    "flightBookingInfo"
})
public class JPFlightElement
    extends JPBaseElement
{

    @XmlElement(name = "FlightBookingInfo")
    protected JPFlightBookingInfo flightBookingInfo;

    /**
     * Gets the value of the flightBookingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightBookingInfo }
     *     
     */
    public JPFlightBookingInfo getFlightBookingInfo() {
        return flightBookingInfo;
    }

    /**
     * Sets the value of the flightBookingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightBookingInfo }
     *     
     */
    public void setFlightBookingInfo(JPFlightBookingInfo value) {
        this.flightBookingInfo = value;
    }

}
