
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelRelPaxDist complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelRelPaxDist">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_RelPaxDist">
 *       &lt;sequence>
 *         &lt;element name="RoomCategories" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RoomCategory" minOccurs="0"/>
 *         &lt;element name="Rooms" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelRoomCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelRelPaxDist", propOrder = {
    "roomCategories",
    "rooms"
})
public class JPHotelRelPaxDist
    extends JPRelPaxDist
{

    @XmlElement(name = "RoomCategories")
    protected ArrayOfJPRoomCategory roomCategories;
    @XmlElement(name = "Rooms")
    protected ArrayOfJPHotelRoomCode rooms;

    /**
     * Gets the value of the roomCategories property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRoomCategory }
     *     
     */
    public ArrayOfJPRoomCategory getRoomCategories() {
        return roomCategories;
    }

    /**
     * Sets the value of the roomCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRoomCategory }
     *     
     */
    public void setRoomCategories(ArrayOfJPRoomCategory value) {
        this.roomCategories = value;
    }

    /**
     * Gets the value of the rooms property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelRoomCode }
     *     
     */
    public ArrayOfJPHotelRoomCode getRooms() {
        return rooms;
    }

    /**
     * Sets the value of the rooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelRoomCode }
     *     
     */
    public void setRooms(ArrayOfJPHotelRoomCode value) {
        this.rooms = value;
    }

}
