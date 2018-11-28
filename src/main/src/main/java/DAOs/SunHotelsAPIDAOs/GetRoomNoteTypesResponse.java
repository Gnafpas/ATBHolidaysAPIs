
package DAOs.SunHotelsAPIDAOs;

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
 *         &lt;element name="getRoomNoteTypesResult" type="{http://xml.sunhotels.net/15/}GetRoomNoteTypesResult"/>
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
    "getRoomNoteTypesResult"
})
@XmlRootElement(name = "GetRoomNoteTypesResponse")
public class GetRoomNoteTypesResponse {

    @XmlElement(required = true, nillable = true)
    protected GetRoomNoteTypesResult getRoomNoteTypesResult;

    /**
     * Gets the value of the getRoomNoteTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetRoomNoteTypesResult }
     *     
     */
    public GetRoomNoteTypesResult getGetRoomNoteTypesResult() {
        return getRoomNoteTypesResult;
    }

    /**
     * Sets the value of the getRoomNoteTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetRoomNoteTypesResult }
     *     
     */
    public void setGetRoomNoteTypesResult(GetRoomNoteTypesResult value) {
        this.getRoomNoteTypesResult = value;
    }

}
