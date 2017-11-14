
package DAOs.SunHotelsDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCalendarNote3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCalendarNote3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="roomNote" type="{http://xml.sunhotels.net/15/}CalendarNote" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCalendarNote3", propOrder = {
    "roomNote"
})
public class ArrayOfCalendarNote3 {

    @XmlElement(nillable = true)
    protected List<CalendarNote> roomNote;

    /**
     * Gets the value of the roomNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalendarNote }
     * 
     * 
     */
    public List<CalendarNote> getRoomNote() {
        if (roomNote == null) {
            roomNote = new ArrayList<CalendarNote>();
        }
        return this.roomNote;
    }

}
