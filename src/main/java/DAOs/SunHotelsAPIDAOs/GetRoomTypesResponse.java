
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
 *         &lt;element name="getRoomTypesResult" type="{http://xml.sunhotels.net/15/}GetRoomTypesResult"/>
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
    "getRoomTypesResult"
})
@XmlRootElement(name = "GetRoomTypesResponse")
public class GetRoomTypesResponse {

    @XmlElement(required = true, nillable = true)
    protected GetRoomTypesResult getRoomTypesResult;

    /**
     * Gets the value of the getRoomTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetRoomTypesResult }
     *     
     */
    public GetRoomTypesResult getGetRoomTypesResult() {
        return getRoomTypesResult;
    }

    /**
     * Sets the value of the getRoomTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetRoomTypesResult }
     *     
     */
    public void setGetRoomTypesResult(GetRoomTypesResult value) {
        this.getRoomTypesResult = value;
    }

}
