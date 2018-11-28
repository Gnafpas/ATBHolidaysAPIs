
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StaticRoomTypeWithRooms complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StaticRoomTypeWithRooms">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}RoomTypeWithRooms">
 *       &lt;sequence>
 *         &lt;element name="room.type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sharedRoom" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sharedFacilities" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StaticRoomTypeWithRooms", propOrder = {
    "roomType",
    "sharedRoom",
    "sharedFacilities"
})
public class StaticRoomTypeWithRooms
    extends RoomTypeWithRooms
{

    @XmlElement(name = "room.type")
    protected String roomType;
    protected boolean sharedRoom;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean sharedFacilities;

    /**
     * Gets the value of the roomType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Sets the value of the roomType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomType(String value) {
        this.roomType = value;
    }

    /**
     * Gets the value of the sharedRoom property.
     * 
     */
    public boolean isSharedRoom() {
        return sharedRoom;
    }

    /**
     * Sets the value of the sharedRoom property.
     * 
     */
    public void setSharedRoom(boolean value) {
        this.sharedRoom = value;
    }

    /**
     * Gets the value of the sharedFacilities property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSharedFacilities() {
        return sharedFacilities;
    }

    /**
     * Sets the value of the sharedFacilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSharedFacilities(Boolean value) {
        this.sharedFacilities = value;
    }

}
