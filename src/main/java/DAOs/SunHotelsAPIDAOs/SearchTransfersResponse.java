
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
 *         &lt;element name="searchTransfersResult" type="{http://xml.sunhotels.net/15/}SearchTransfersResult"/>
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
    "searchTransfersResult"
})
@XmlRootElement(name = "SearchTransfersResponse")
public class SearchTransfersResponse {

    @XmlElement(required = true, nillable = true)
    protected SearchTransfersResult searchTransfersResult;

    /**
     * Gets the value of the searchTransfersResult property.
     * 
     * @return
     *     possible object is
     *     {@link SearchTransfersResult }
     *     
     */
    public SearchTransfersResult getSearchTransfersResult() {
        return searchTransfersResult;
    }

    /**
     * Sets the value of the searchTransfersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchTransfersResult }
     *     
     */
    public void setSearchTransfersResult(SearchTransfersResult value) {
        this.searchTransfersResult = value;
    }

}
