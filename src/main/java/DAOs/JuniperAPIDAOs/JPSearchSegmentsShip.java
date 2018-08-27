
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentsShip complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentsShip">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentShip" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentShip" minOccurs="0"/>
 *         &lt;element name="CruiseSuppliers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseSupplier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentsShip", propOrder = {
    "searchSegmentShip",
    "cruiseSuppliers"
})
public class JPSearchSegmentsShip {

    @XmlElement(name = "SearchSegmentShip")
    protected JPSearchSegmentShip searchSegmentShip;
    @XmlElement(name = "CruiseSuppliers")
    protected ArrayOfJPCruiseSupplier cruiseSuppliers;

    /**
     * Gets the value of the searchSegmentShip property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentShip }
     *     
     */
    public JPSearchSegmentShip getSearchSegmentShip() {
        return searchSegmentShip;
    }

    /**
     * Sets the value of the searchSegmentShip property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentShip }
     *     
     */
    public void setSearchSegmentShip(JPSearchSegmentShip value) {
        this.searchSegmentShip = value;
    }

    /**
     * Gets the value of the cruiseSuppliers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseSupplier }
     *     
     */
    public ArrayOfJPCruiseSupplier getCruiseSuppliers() {
        return cruiseSuppliers;
    }

    /**
     * Sets the value of the cruiseSuppliers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseSupplier }
     *     
     */
    public void setCruiseSuppliers(ArrayOfJPCruiseSupplier value) {
        this.cruiseSuppliers = value;
    }

}
