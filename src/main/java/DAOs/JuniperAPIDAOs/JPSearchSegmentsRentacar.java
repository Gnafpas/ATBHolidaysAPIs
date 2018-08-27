
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentsRentacar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentsRentacar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentRentacar" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentRentacar" minOccurs="0"/>
 *         &lt;element name="RentacarSuppliers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RentacarSupplier" minOccurs="0"/>
 *         &lt;element name="RentacarLocations" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RentacarLocation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentsRentacar", propOrder = {
    "searchSegmentRentacar",
    "rentacarSuppliers",
    "rentacarLocations"
})
public class JPSearchSegmentsRentacar {

    @XmlElement(name = "SearchSegmentRentacar")
    protected JPSearchSegmentRentacar searchSegmentRentacar;
    @XmlElement(name = "RentacarSuppliers")
    protected ArrayOfJPRentacarSupplier rentacarSuppliers;
    @XmlElement(name = "RentacarLocations")
    protected ArrayOfJPRentacarLocation rentacarLocations;

    /**
     * Gets the value of the searchSegmentRentacar property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentRentacar }
     *     
     */
    public JPSearchSegmentRentacar getSearchSegmentRentacar() {
        return searchSegmentRentacar;
    }

    /**
     * Sets the value of the searchSegmentRentacar property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentRentacar }
     *     
     */
    public void setSearchSegmentRentacar(JPSearchSegmentRentacar value) {
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

    /**
     * Gets the value of the rentacarLocations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRentacarLocation }
     *     
     */
    public ArrayOfJPRentacarLocation getRentacarLocations() {
        return rentacarLocations;
    }

    /**
     * Sets the value of the rentacarLocations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRentacarLocation }
     *     
     */
    public void setRentacarLocations(ArrayOfJPRentacarLocation value) {
        this.rentacarLocations = value;
    }

}
