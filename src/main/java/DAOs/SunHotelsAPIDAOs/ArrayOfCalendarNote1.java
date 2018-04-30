
package DAOs.SunHotelsAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCalendarNote1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCalendarNote1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hotelNote" type="{http://xml.sunhotels.net/15/}CalendarNote" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCalendarNote1", propOrder = {
    "hotelNote"
})
public class ArrayOfCalendarNote1 {

    @XmlElement(nillable = true)
    protected List<CalendarNote> hotelNote;

    /**
     * Gets the value of the hotelNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalendarNote }
     * 
     * 
     */
    public List<CalendarNote> getHotelNote() {
        if (hotelNote == null) {
            hotelNote = new ArrayList<CalendarNote>();
        }
        return this.hotelNote;
    }

    public void setHotelNote(List<CalendarNote> hotelNote) {
        this.hotelNote = hotelNote;
    }
}
