
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_HotelRoom complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_HotelRoom">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelRoom" type="{http://www.juniper.es/webservice/2007/}JP_HotelRoom" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_HotelRoom", propOrder = {
    "hotelRoom"
})
public class ArrayOfJPHotelRoom {

    @XmlElement(name = "HotelRoom")
    protected List<JPHotelRoom> hotelRoom;

    /**
     * Gets the value of the hotelRoom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelRoom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelRoom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPHotelRoom }
     * 
     * 
     */
    public List<JPHotelRoom> getHotelRoom() {
        if (hotelRoom == null) {
            hotelRoom = new ArrayList<JPHotelRoom>();
        }
        return this.hotelRoom;
    }

}
