
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
 *         &lt;element name="getMealsResult" type="{http://xml.sunhotels.net/15/}GetMealsResult"/>
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
    "getMealsResult"
})
@XmlRootElement(name = "GetMealsResponse")
public class GetMealsResponse {

    @XmlElement(required = true, nillable = true)
    protected GetMealsResult getMealsResult;

    /**
     * Gets the value of the getMealsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetMealsResult }
     *     
     */
    public GetMealsResult getGetMealsResult() {
        return getMealsResult;
    }

    /**
     * Sets the value of the getMealsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMealsResult }
     *     
     */
    public void setGetMealsResult(GetMealsResult value) {
        this.getMealsResult = value;
    }

}
