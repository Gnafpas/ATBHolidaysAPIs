
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
 *         &lt;element name="GetResortsResult" type="{http://xml.sunhotels.net/15/}ResortList" minOccurs="0"/>
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
    "getResortsResult"
})
@XmlRootElement(name = "GetResortsResponse")
public class GetResortsResponse {

    @XmlElement(name = "GetResortsResult")
    protected ResortList getResortsResult;

    /**
     * Gets the value of the getResortsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResortList }
     *     
     */
    public ResortList getGetResortsResult() {
        return getResortsResult;
    }

    /**
     * Sets the value of the getResortsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResortList }
     *     
     */
    public void setGetResortsResult(ResortList value) {
        this.getResortsResult = value;
    }

}
