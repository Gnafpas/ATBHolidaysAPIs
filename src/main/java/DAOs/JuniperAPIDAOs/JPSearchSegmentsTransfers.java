
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentsTransfers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentsTransfers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmenTransfers" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentTransfers" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentsTransfers", propOrder = {
    "searchSegmenTransfers"
})
public class JPSearchSegmentsTransfers {

    @XmlElement(name = "SearchSegmenTransfers")
    protected JPSearchSegmentTransfers searchSegmenTransfers;

    /**
     * Gets the value of the searchSegmenTransfers property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentTransfers }
     *     
     */
    public JPSearchSegmentTransfers getSearchSegmenTransfers() {
        return searchSegmenTransfers;
    }

    /**
     * Sets the value of the searchSegmenTransfers property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentTransfers }
     *     
     */
    public void setSearchSegmenTransfers(JPSearchSegmentTransfers value) {
        this.searchSegmenTransfers = value;
    }

}
