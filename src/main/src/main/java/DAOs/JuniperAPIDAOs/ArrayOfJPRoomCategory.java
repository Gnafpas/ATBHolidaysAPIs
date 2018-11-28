
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_RoomCategory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_RoomCategory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoomCategory" type="{http://www.juniper.es/webservice/2007/}JP_RoomCategory" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_RoomCategory", propOrder = {
    "roomCategory"
})
public class ArrayOfJPRoomCategory {

    @XmlElement(name = "RoomCategory")
    protected List<JPRoomCategory> roomCategory;

    /**
     * Gets the value of the roomCategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomCategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPRoomCategory }
     * 
     * 
     */
    public List<JPRoomCategory> getRoomCategory() {
        if (roomCategory == null) {
            roomCategory = new ArrayList<JPRoomCategory>();
        }
        return this.roomCategory;
    }

}
