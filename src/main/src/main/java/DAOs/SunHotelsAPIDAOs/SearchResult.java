
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="hotels" type="{http://xml.sunhotels.net/15/}ArrayOfHotel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchResult", propOrder = {
    "hotels"
})
public class SearchResult
    extends BaseResult
{

    protected ArrayOfHotel hotels;

    /**
     * Gets the value of the hotels property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHotel }
     *     
     */
    public ArrayOfHotel getHotels() {
        return hotels;
    }

    /**
     * Sets the value of the hotels property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHotel }
     *     
     */
    public void setHotels(ArrayOfHotel value) {
        this.hotels = value;
    }

}
