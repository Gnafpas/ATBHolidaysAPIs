
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetStaticHotelsAndRoomsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetStaticHotelsAndRoomsResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="hotels" type="{http://xml.sunhotels.net/15/}ArrayOfStaticHotel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetStaticHotelsAndRoomsResult", propOrder = {
    "hotels"
})
public class GetStaticHotelsAndRoomsResult
    extends BaseResult
{

    protected ArrayOfStaticHotel hotels;

    /**
     * Gets the value of the hotels property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfStaticHotel }
     *     
     */
    public ArrayOfStaticHotel getHotels() {
        return hotels;
    }

    /**
     * Sets the value of the hotels property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfStaticHotel }
     *     
     */
    public void setHotels(ArrayOfStaticHotel value) {
        this.hotels = value;
    }

}
