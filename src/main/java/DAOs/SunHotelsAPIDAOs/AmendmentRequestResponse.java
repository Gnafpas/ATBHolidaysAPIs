
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
 *         &lt;element name="amendmentRequestResult" type="{http://xml.sunhotels.net/15/}AmendmentRequestResult"/>
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
    "amendmentRequestResult"
})
@XmlRootElement(name = "AmendmentRequestResponse")
public class AmendmentRequestResponse {

    @XmlElement(required = true, nillable = true)
    protected AmendmentRequestResult amendmentRequestResult;

    /**
     * Gets the value of the amendmentRequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link AmendmentRequestResult }
     *     
     */
    public AmendmentRequestResult getAmendmentRequestResult() {
        return amendmentRequestResult;
    }

    /**
     * Sets the value of the amendmentRequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendmentRequestResult }
     *     
     */
    public void setAmendmentRequestResult(AmendmentRequestResult value) {
        this.amendmentRequestResult = value;
    }

}
