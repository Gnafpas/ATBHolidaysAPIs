
package DAOs.SunHotelsAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCalendarNote4 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCalendarNote4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="englishRoomNote" type="{http://xml.sunhotels.net/15/}CalendarNote" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCalendarNote4", propOrder = {
    "englishRoomNote"
})
public class ArrayOfCalendarNote4 {

    @XmlElement(nillable = true)
    protected List<CalendarNote> englishRoomNote;

    /**
     * Gets the value of the englishRoomNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the englishRoomNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnglishRoomNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalendarNote }
     * 
     * 
     */
    public List<CalendarNote> getEnglishRoomNote() {
        if (englishRoomNote == null) {
            englishRoomNote = new ArrayList<CalendarNote>();
        }
        return this.englishRoomNote;
    }

}
