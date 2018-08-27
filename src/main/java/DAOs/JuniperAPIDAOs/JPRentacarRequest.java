
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentsRentacar" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentsRentacar" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarRequest", propOrder = {
    "searchSegmentsRentacar"
})
public class JPRentacarRequest {

    @XmlElement(name = "SearchSegmentsRentacar")
    protected JPSearchSegmentsRentacar searchSegmentsRentacar;

    /**
     * Gets the value of the searchSegmentsRentacar property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentsRentacar }
     *     
     */
    public JPSearchSegmentsRentacar getSearchSegmentsRentacar() {
        return searchSegmentsRentacar;
    }

    /**
     * Sets the value of the searchSegmentsRentacar property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentsRentacar }
     *     
     */
    public void setSearchSegmentsRentacar(JPSearchSegmentsRentacar value) {
        this.searchSegmentsRentacar = value;
    }

}
