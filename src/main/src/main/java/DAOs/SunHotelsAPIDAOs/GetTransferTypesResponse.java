
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
 *         &lt;element name="getTransferTypesResult" type="{http://xml.sunhotels.net/15/}GetTransferTypesResult"/>
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
    "getTransferTypesResult"
})
@XmlRootElement(name = "GetTransferTypesResponse")
public class GetTransferTypesResponse {

    @XmlElement(required = true, nillable = true)
    protected GetTransferTypesResult getTransferTypesResult;

    /**
     * Gets the value of the getTransferTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetTransferTypesResult }
     *     
     */
    public GetTransferTypesResult getGetTransferTypesResult() {
        return getTransferTypesResult;
    }

    /**
     * Sets the value of the getTransferTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetTransferTypesResult }
     *     
     */
    public void setGetTransferTypesResult(GetTransferTypesResult value) {
        this.getTransferTypesResult = value;
    }

}
