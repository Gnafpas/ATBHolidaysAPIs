
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoomTypeWithRooms complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoomTypeWithRooms">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="roomtype.ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rooms" type="{http://xml.sunhotels.net/15/}ArrayOfRoom" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomTypeWithRooms", propOrder = {
    "roomtypeID",
    "rooms"
})
@XmlSeeAlso({
    StaticRoomTypeWithRooms.class
})
public class RoomTypeWithRooms {

    @XmlElement(name = "roomtype.ID")
    protected int roomtypeID;
    protected ArrayOfRoom rooms;

    /**
     * Gets the value of the roomtypeID property.
     * 
     */
    public int getRoomtypeID() {
        return roomtypeID;
    }

    /**
     * Sets the value of the roomtypeID property.
     * 
     */
    public void setRoomtypeID(int value) {
        this.roomtypeID = value;
    }

    /**
     * Gets the value of the rooms property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoom }
     *     
     */
    public ArrayOfRoom getRooms() {
        return rooms;
    }

    /**
     * Sets the value of the rooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoom }
     *     
     */
    public void setRooms(ArrayOfRoom value) {
        this.rooms = value;
    }

}
