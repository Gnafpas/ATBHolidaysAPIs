
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
 *         &lt;element name="preBookResult" type="{http://xml.sunhotels.net/15/}PreBookResult"/>
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
    "preBookResult"
})
@XmlRootElement(name = "PreBookV2Response")
public class PreBookV2Response {

    @XmlElement(required = true, nillable = true)
    protected PreBookResult preBookResult;

    /**
     * Gets the value of the preBookResult property.
     * 
     * @return
     *     possible object is
     *     {@link PreBookResult }
     *     
     */
    public PreBookResult getPreBookResult() {
        return preBookResult;
    }

    /**
     * Sets the value of the preBookResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreBookResult }
     *     
     */
    public void setPreBookResult(PreBookResult value) {
        this.preBookResult = value;
    }

}
