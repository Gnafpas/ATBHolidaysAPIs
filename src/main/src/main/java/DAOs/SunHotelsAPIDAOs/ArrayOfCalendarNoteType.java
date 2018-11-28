
package DAOs.SunHotelsAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCalendarNoteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCalendarNoteType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="noteType" type="{http://xml.sunhotels.net/15/}CalendarNoteType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCalendarNoteType", propOrder = {
    "noteType"
})
public class ArrayOfCalendarNoteType {

    @XmlElement(nillable = true)
    protected List<CalendarNoteType> noteType;

    /**
     * Gets the value of the noteType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the noteType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNoteType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalendarNoteType }
     * 
     * 
     */
    public List<CalendarNoteType> getNoteType() {
        if (noteType == null) {
            noteType = new ArrayList<CalendarNoteType>();
        }
        return this.noteType;
    }

}
