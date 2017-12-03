
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
 *         &lt;element name="amendmentPriceRequestResult" type="{http://xml.sunhotels.net/15/}AmendmentPriceRequestResult"/>
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
    "amendmentPriceRequestResult"
})
@XmlRootElement(name = "AmendmentPriceRequestResponse")
public class AmendmentPriceRequestResponse {

    @XmlElement(required = true, nillable = true)
    protected AmendmentPriceRequestResult amendmentPriceRequestResult;

    /**
     * Gets the value of the amendmentPriceRequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link AmendmentPriceRequestResult }
     *     
     */
    public AmendmentPriceRequestResult getAmendmentPriceRequestResult() {
        return amendmentPriceRequestResult;
    }

    /**
     * Sets the value of the amendmentPriceRequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendmentPriceRequestResult }
     *     
     */
    public void setAmendmentPriceRequestResult(AmendmentPriceRequestResult value) {
        this.amendmentPriceRequestResult = value;
    }

}
