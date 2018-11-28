
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
 *         &lt;element name="updateSpecialRequestResult" type="{http://xml.sunhotels.net/15/}UpdateSpecialRequestResult"/>
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
    "updateSpecialRequestResult"
})
@XmlRootElement(name = "UpdateSpecialRequestResponse")
public class UpdateSpecialRequestResponse {

    @XmlElement(required = true, nillable = true)
    protected UpdateSpecialRequestResult updateSpecialRequestResult;

    /**
     * Gets the value of the updateSpecialRequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateSpecialRequestResult }
     *     
     */
    public UpdateSpecialRequestResult getUpdateSpecialRequestResult() {
        return updateSpecialRequestResult;
    }

    /**
     * Sets the value of the updateSpecialRequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateSpecialRequestResult }
     *     
     */
    public void setUpdateSpecialRequestResult(UpdateSpecialRequestResult value) {
        this.updateSpecialRequestResult = value;
    }

}
