
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
 *         &lt;element name="Countries" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfCountry" minOccurs="0"/>
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
    "countries"
})
@XmlRootElement(name = "VehicleCountryResponse")
public class VehicleCountryResponse
    extends DestinationResponse
{

    @XmlElement(name = "Countries")
    protected ArrayOfCountry countries;

    /**
     * Gets the value of the countries property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCountry }
     *     
     */
    public ArrayOfCountry getCountries() {
        return countries;
    }

    /**
     * Sets the value of the countries property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCountry }
     *     
     */
    public void setCountries(ArrayOfCountry value) {
        this.countries = value;
    }

}
