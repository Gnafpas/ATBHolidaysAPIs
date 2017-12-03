
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
 *         &lt;element name="getBookingInformationResult" type="{http://xml.sunhotels.net/15/}GetBookingInformationResult"/>
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
    "getBookingInformationResult"
})
@XmlRootElement(name = "GetBookingInformationResponse")
public class GetBookingInformationResponse {

    @XmlElement(required = true, nillable = true)
    protected GetBookingInformationResult getBookingInformationResult;

    /**
     * Gets the value of the getBookingInformationResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetBookingInformationResult }
     *     
     */
    public GetBookingInformationResult getGetBookingInformationResult() {
        return getBookingInformationResult;
    }

    /**
     * Sets the value of the getBookingInformationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetBookingInformationResult }
     *     
     */
    public void setGetBookingInformationResult(GetBookingInformationResult value) {
        this.getBookingInformationResult = value;
    }

}
