
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentsRentacarRules complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentsRentacarRules">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentRentacar" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentRentacarRules" minOccurs="0"/>
 *         &lt;element name="RentacarSuppliers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RentacarSupplier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentsRentacarRules", propOrder = {
    "searchSegmentRentacar",
    "rentacarSuppliers"
})
public class JPSearchSegmentsRentacarRules {

    @XmlElement(name = "SearchSegmentRentacar")
    protected JPSearchSegmentRentacarRules searchSegmentRentacar;
    @XmlElement(name = "RentacarSuppliers")
    protected ArrayOfJPRentacarSupplier rentacarSuppliers;

    /**
     * Gets the value of the searchSegmentRentacar property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentRentacarRules }
     *     
     */
    public JPSearchSegmentRentacarRules getSearchSegmentRentacar() {
        return searchSegmentRentacar;
    }

    /**
     * Sets the value of the searchSegmentRentacar property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentRentacarRules }
     *     
     */
    public void setSearchSegmentRentacar(JPSearchSegmentRentacarRules value) {
        this.searchSegmentRentacar = value;
    }

    /**
     * Gets the value of the rentacarSuppliers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRentacarSupplier }
     *     
     */
    public ArrayOfJPRentacarSupplier getRentacarSuppliers() {
        return rentacarSuppliers;
    }

    /**
     * Sets the value of the rentacarSuppliers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRentacarSupplier }
     *     
     */
    public void setRentacarSuppliers(ArrayOfJPRentacarSupplier value) {
        this.rentacarSuppliers = value;
    }

}
