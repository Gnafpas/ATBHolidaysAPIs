
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
 *         &lt;element name="getStaticHotelsAndRoomsResult" type="{http://xml.sunhotels.net/15/}GetStaticHotelsAndRoomsResult"/>
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
    "getStaticHotelsAndRoomsResult"
})
@XmlRootElement(name = "GetStaticHotelsAndRoomsResponse")
public class GetStaticHotelsAndRoomsResponse {

    @XmlElement(required = true, nillable = true)
    protected GetStaticHotelsAndRoomsResult getStaticHotelsAndRoomsResult;

    /**
     * Gets the value of the getStaticHotelsAndRoomsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetStaticHotelsAndRoomsResult }
     *     
     */
    public GetStaticHotelsAndRoomsResult getGetStaticHotelsAndRoomsResult() {
        return getStaticHotelsAndRoomsResult;
    }

    /**
     * Sets the value of the getStaticHotelsAndRoomsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetStaticHotelsAndRoomsResult }
     *     
     */
    public void setGetStaticHotelsAndRoomsResult(GetStaticHotelsAndRoomsResult value) {
        this.getStaticHotelsAndRoomsResult = value;
    }

}
