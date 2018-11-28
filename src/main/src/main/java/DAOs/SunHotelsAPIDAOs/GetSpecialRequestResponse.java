
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
 *         &lt;element name="getSpecialRequestResult" type="{http://xml.sunhotels.net/15/}GetSpecialRequestResult"/>
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
    "getSpecialRequestResult"
})
@XmlRootElement(name = "GetSpecialRequestResponse")
public class GetSpecialRequestResponse {

    @XmlElement(required = true, nillable = true)
    protected GetSpecialRequestResult getSpecialRequestResult;

    /**
     * Gets the value of the getSpecialRequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetSpecialRequestResult }
     *     
     */
    public GetSpecialRequestResult getGetSpecialRequestResult() {
        return getSpecialRequestResult;
    }

    /**
     * Sets the value of the getSpecialRequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetSpecialRequestResult }
     *     
     */
    public void setGetSpecialRequestResult(GetSpecialRequestResult value) {
        this.getSpecialRequestResult = value;
    }

}
