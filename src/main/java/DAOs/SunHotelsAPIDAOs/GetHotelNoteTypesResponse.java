
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
 *         &lt;element name="getHotelNoteTypesResult" type="{http://xml.sunhotels.net/15/}GetHotelNoteTypesResult"/>
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
    "getHotelNoteTypesResult"
})
@XmlRootElement(name = "GetHotelNoteTypesResponse")
public class GetHotelNoteTypesResponse {

    @XmlElement(required = true, nillable = true)
    protected GetHotelNoteTypesResult getHotelNoteTypesResult;

    /**
     * Gets the value of the getHotelNoteTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetHotelNoteTypesResult }
     *     
     */
    public GetHotelNoteTypesResult getGetHotelNoteTypesResult() {
        return getHotelNoteTypesResult;
    }

    /**
     * Sets the value of the getHotelNoteTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetHotelNoteTypesResult }
     *     
     */
    public void setGetHotelNoteTypesResult(GetHotelNoteTypesResult value) {
        this.getHotelNoteTypesResult = value;
    }

}
