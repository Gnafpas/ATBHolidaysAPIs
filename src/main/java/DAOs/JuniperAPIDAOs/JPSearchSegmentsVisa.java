
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentsVisa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentsVisa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmenVisa" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentVisa" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentsVisa", propOrder = {
    "searchSegmenVisa"
})
public class JPSearchSegmentsVisa {

    @XmlElement(name = "SearchSegmenVisa")
    protected JPSearchSegmentVisa searchSegmenVisa;

    /**
     * Gets the value of the searchSegmenVisa property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentVisa }
     *     
     */
    public JPSearchSegmentVisa getSearchSegmenVisa() {
        return searchSegmenVisa;
    }

    /**
     * Sets the value of the searchSegmenVisa property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentVisa }
     *     
     */
    public void setSearchSegmenVisa(JPSearchSegmentVisa value) {
        this.searchSegmenVisa = value;
    }

}
