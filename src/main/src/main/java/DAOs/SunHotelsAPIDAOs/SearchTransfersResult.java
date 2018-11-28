
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchTransfersResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchTransfersResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="airports" type="{http://xml.sunhotels.net/15/}ArrayOfAirport" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchTransfersResult", propOrder = {
    "airports"
})
public class SearchTransfersResult
    extends BaseResult
{

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
