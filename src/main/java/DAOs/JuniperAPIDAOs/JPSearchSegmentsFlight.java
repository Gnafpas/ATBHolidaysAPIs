
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentsFlight complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentsFlight">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentFlight" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentFlight" minOccurs="0"/>
 *         &lt;element name="FlightSuppliers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_FlightSupplier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentsFlight", propOrder = {
    "searchSegmentFlight",
    "flightSuppliers"
})
public class JPSearchSegmentsFlight {

    @XmlElement(name = "SearchSegmentFlight")
    protected JPSearchSegmentFlight searchSegmentFlight;
    @XmlElement(name = "FlightSuppliers")
    protected ArrayOfJPFlightSupplier flightSuppliers;

    /**
     * Gets the value of the searchSegmentFlight property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentFlight }
     *     
     */
    public JPSearchSegmentFlight getSearchSegmentFlight() {
        return searchSegmentFlight;
    }

    /**
     * Sets the value of the searchSegmentFlight property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentFlight }
     *     
     */
    public void setSearchSegmentFlight(JPSearchSegmentFlight value) {
        this.searchSegmentFlight = value;
    }

    /**
     * Gets the value of the flightSuppliers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPFlightSupplier }
     *     
     */
    public ArrayOfJPFlightSupplier getFlightSuppliers() {
        return flightSuppliers;
    }

    /**
     * Sets the value of the flightSuppliers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPFlightSupplier }
     *     
     */
    public void setFlightSuppliers(ArrayOfJPFlightSupplier value) {
        this.flightSuppliers = value;
    }

}
