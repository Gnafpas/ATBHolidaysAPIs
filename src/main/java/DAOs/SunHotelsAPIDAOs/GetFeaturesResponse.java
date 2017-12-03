
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
 *         &lt;element name="getFeaturesResult" type="{http://xml.sunhotels.net/15/}GetFeaturesResult"/>
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
    "getFeaturesResult"
})
@XmlRootElement(name = "GetFeaturesResponse")
public class GetFeaturesResponse {

    @XmlElement(required = true, nillable = true)
    protected GetFeaturesResult getFeaturesResult;

    /**
     * Gets the value of the getFeaturesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetFeaturesResult }
     *     
     */
    public GetFeaturesResult getGetFeaturesResult() {
        return getFeaturesResult;
    }

    /**
     * Sets the value of the getFeaturesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFeaturesResult }
     *     
     */
    public void setGetFeaturesResult(GetFeaturesResult value) {
        this.getFeaturesResult = value;
    }

}
