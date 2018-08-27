
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruisePreRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruisePreRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentsCruise" type="{http://www.juniper.es/webservice/2007/}JP_SearchPreSegmentsCruise" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruisePreRequest", propOrder = {
    "searchSegmentsCruise"
})
public class JPCruisePreRequest {

    @XmlElement(name = "SearchSegmentsCruise")
    protected JPSearchPreSegmentsCruise searchSegmentsCruise;

    /**
     * Gets the value of the searchSegmentsCruise property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchPreSegmentsCruise }
     *     
     */
    public JPSearchPreSegmentsCruise getSearchSegmentsCruise() {
        return searchSegmentsCruise;
    }

    /**
     * Sets the value of the searchSegmentsCruise property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchPreSegmentsCruise }
     *     
     */
    public void setSearchSegmentsCruise(JPSearchPreSegmentsCruise value) {
        this.searchSegmentsCruise = value;
    }

}
