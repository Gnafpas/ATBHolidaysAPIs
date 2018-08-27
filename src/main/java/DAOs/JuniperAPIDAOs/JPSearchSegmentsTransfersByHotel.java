
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentsTransfersByHotel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentsTransfersByHotel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmenTransfers" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentTransfersByHotel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentsTransfersByHotel", propOrder = {
    "searchSegmenTransfers"
})
public class JPSearchSegmentsTransfersByHotel {

    @XmlElement(name = "SearchSegmenTransfers")
    protected JPSearchSegmentTransfersByHotel searchSegmenTransfers;

    /**
     * Gets the value of the searchSegmenTransfers property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentTransfersByHotel }
     *     
     */
    public JPSearchSegmentTransfersByHotel getSearchSegmenTransfers() {
        return searchSegmenTransfers;
    }

    /**
     * Sets the value of the searchSegmenTransfers property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentTransfersByHotel }
     *     
     */
    public void setSearchSegmenTransfers(JPSearchSegmentTransfersByHotel value) {
        this.searchSegmenTransfers = value;
    }

}
