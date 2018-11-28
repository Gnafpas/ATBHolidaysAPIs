
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarBookingRulesRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarBookingRulesRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentacarOption" type="{http://www.juniper.es/webservice/2007/}JP_RentacarRequestBookingRulesOption" minOccurs="0"/>
 *         &lt;element name="SearchSegmentsRentacar" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentsRentacarRules" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarBookingRulesRequest", propOrder = {
    "rentacarOption",
    "searchSegmentsRentacar"
})
public class JPRentacarBookingRulesRequest {

    @XmlElement(name = "RentacarOption")
    protected JPRentacarRequestBookingRulesOption rentacarOption;
    @XmlElement(name = "SearchSegmentsRentacar")
    protected JPSearchSegmentsRentacarRules searchSegmentsRentacar;

    /**
     * Gets the value of the rentacarOption property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarRequestBookingRulesOption }
     *     
     */
    public JPRentacarRequestBookingRulesOption getRentacarOption() {
        return rentacarOption;
    }

    /**
     * Sets the value of the rentacarOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarRequestBookingRulesOption }
     *     
     */
    public void setRentacarOption(JPRentacarRequestBookingRulesOption value) {
        this.rentacarOption = value;
    }

    /**
     * Gets the value of the searchSegmentsRentacar property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentsRentacarRules }
     *     
     */
    public JPSearchSegmentsRentacarRules getSearchSegmentsRentacar() {
        return searchSegmentsRentacar;
    }

    /**
     * Sets the value of the searchSegmentsRentacar property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentsRentacarRules }
     *     
     */
    public void setSearchSegmentsRentacar(JPSearchSegmentsRentacarRules value) {
        this.searchSegmentsRentacar = value;
    }

}
