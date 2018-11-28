
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentsPackages complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentsPackages">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentPackages" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentPackages" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentsPackages", propOrder = {
    "searchSegmentPackages"
})
public class JPSearchSegmentsPackages {

    @XmlElement(name = "SearchSegmentPackages")
    protected JPSearchSegmentPackages searchSegmentPackages;

    /**
     * Gets the value of the searchSegmentPackages property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentPackages }
     *     
     */
    public JPSearchSegmentPackages getSearchSegmentPackages() {
        return searchSegmentPackages;
    }

    /**
     * Sets the value of the searchSegmentPackages property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentPackages }
     *     
     */
    public void setSearchSegmentPackages(JPSearchSegmentPackages value) {
        this.searchSegmentPackages = value;
    }

}
