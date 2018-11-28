
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
 *         &lt;element name="Cities" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfCity" minOccurs="0"/>
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
    "cities"
})
@XmlRootElement(name = "VehicleCityResponse")
public class VehicleCityResponse
    extends DestinationResponse
{

    @XmlElement(name = "Cities")
    protected ArrayOfCity cities;

    /**
     * Gets the value of the cities property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCity }
     *     
     */
    public ArrayOfCity getCities() {
        return cities;
    }

    /**
     * Sets the value of the cities property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCity }
     *     
     */
    public void setCities(ArrayOfCity value) {
        this.cities = value;
    }

}
