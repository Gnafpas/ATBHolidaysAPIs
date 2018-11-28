
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
 *         &lt;element name="Regions" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfRegion" minOccurs="0"/>
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
    "regions"
})
@XmlRootElement(name = "VehicleRegionResponse")
public class VehicleRegionResponse
    extends DestinationResponse
{

    @XmlElement(name = "Regions")
    protected ArrayOfRegion regions;

    /**
     * Gets the value of the regions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRegion }
     *     
     */
    public ArrayOfRegion getRegions() {
        return regions;
    }

    /**
     * Sets the value of the regions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRegion }
     *     
     */
    public void setRegions(ArrayOfRegion value) {
        this.regions = value;
    }

}
