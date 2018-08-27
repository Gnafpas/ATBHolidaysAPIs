
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfArrayOfJPSOAP_HotelRatePlanSpecialNoteText complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfArrayOfJPSOAP_HotelRatePlanSpecialNoteText">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Note" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_HotelRatePlanSpecialNoteText" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfArrayOfJPSOAP_HotelRatePlanSpecialNoteText", propOrder = {
    "note"
})
public class ArrayOfArrayOfJPSOAPHotelRatePlanSpecialNoteText {

    @XmlElement(name = "Note")
    protected List<ArrayOfJPSOAPHotelRatePlanSpecialNoteText> note;

    /**
     * Gets the value of the note property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the note property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfJPSOAPHotelRatePlanSpecialNoteText }
     * 
     * 
     */
    public List<ArrayOfJPSOAPHotelRatePlanSpecialNoteText> getNote() {
        if (note == null) {
            note = new ArrayList<ArrayOfJPSOAPHotelRatePlanSpecialNoteText>();
        }
        return this.note;
    }

}
