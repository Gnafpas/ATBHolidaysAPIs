
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_RoomInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_RoomInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JPRoom" type="{http://www.juniper.es/webservice/2007/}JP_RoomInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_RoomInfo", propOrder = {
    "jpRoom"
})
public class ArrayOfJPRoomInfo {

    @XmlElement(name = "JPRoom")
    protected List<JPRoomInfo> jpRoom;

    /**
     * Gets the value of the jpRoom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jpRoom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJPRoom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPRoomInfo }
     * 
     * 
     */
    public List<JPRoomInfo> getJPRoom() {
        if (jpRoom == null) {
            jpRoom = new ArrayList<JPRoomInfo>();
        }
        return this.jpRoom;
    }

}
