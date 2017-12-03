
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetRoomNoteTypesResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetRoomNoteTypesResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="noteTypes" type="{http://xml.sunhotels.net/15/}ArrayOfCalendarNoteType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRoomNoteTypesResult", propOrder = {
    "noteTypes"
})
public class GetRoomNoteTypesResult
    extends BaseResult
{

    protected ArrayOfCalendarNoteType noteTypes;

    /**
     * Gets the value of the noteTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCalendarNoteType }
     *     
     */
    public ArrayOfCalendarNoteType getNoteTypes() {
        return noteTypes;
    }

    /**
     * Sets the value of the noteTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCalendarNoteType }
     *     
     */
    public void setNoteTypes(ArrayOfCalendarNoteType value) {
        this.noteTypes = value;
    }

}
