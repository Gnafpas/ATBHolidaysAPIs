
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentsServices complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentsServices">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmenServices" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentServices" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentsServices", propOrder = {
    "searchSegmenServices"
})
public class JPSearchSegmentsServices {

    @XmlElement(name = "SearchSegmenServices")
    protected JPSearchSegmentServices searchSegmenServices;

    /**
     * Gets the value of the searchSegmenServices property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentServices }
     *     
     */
    public JPSearchSegmentServices getSearchSegmenServices() {
        return searchSegmenServices;
    }

    /**
     * Sets the value of the searchSegmenServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentServices }
     *     
     */
    public void setSearchSegmenServices(JPSearchSegmentServices value) {
        this.searchSegmenServices = value;
    }

}
