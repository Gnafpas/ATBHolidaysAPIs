
package DAOs.JuniperAPIDAOs;

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
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoomListRQ" type="{http://www.juniper.es/webservice/2007/}JP_RoomListRQ" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "roomListRQ"
})
@XmlRootElement(name = "RoomList")
public class RoomList {

    @XmlElement(name = "RoomListRQ")
    protected JPRoomListRQ roomListRQ;

    /**
     * Gets the value of the roomListRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPRoomListRQ }
     *     
     */
    public JPRoomListRQ getRoomListRQ() {
        return roomListRQ;
    }

    /**
     * Sets the value of the roomListRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRoomListRQ }
     *     
     */
    public void setRoomListRQ(JPRoomListRQ value) {
        this.roomListRQ = value;
    }

}
