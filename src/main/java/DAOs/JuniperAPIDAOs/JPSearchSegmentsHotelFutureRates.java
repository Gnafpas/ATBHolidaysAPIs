
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentsHotelFutureRates complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentsHotelFutureRates">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentsHotels">
 *       &lt;sequence>
 *         &lt;element name="DestinationZones" type="{http://www.juniper.es/webservice/2007/}ArrayOfString9" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentsHotelFutureRates", propOrder = {
    "destinationZones"
})
public class JPSearchSegmentsHotelFutureRates
    extends JPSearchSegmentsHotels
{

    @XmlElement(name = "DestinationZones")
    protected ArrayOfString9 destinationZones;

    /**
     * Gets the value of the destinationZones property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString9 }
     *     
     */
    public ArrayOfString9 getDestinationZones() {
        return destinationZones;
    }

    /**
     * Sets the value of the destinationZones property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString9 }
     *     
     */
    public void setDestinationZones(ArrayOfString9 value) {
        this.destinationZones = value;
    }

}
