
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_TransferBookingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_TransferBookingInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Origin" type="{http://www.juniper.es/webservice/2007/}JP_TransferOrigin" minOccurs="0"/>
 *         &lt;element name="Object" type="{http://www.juniper.es/webservice/2007/}JP_TransferDestination" minOccurs="0"/>
 *         &lt;element name="HotelService" type="{http://www.juniper.es/webservice/2007/}JP_HotelService" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ICode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Route" type="{http://www.juniper.es/webservice/2007/}JP_RouteType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_TransferBookingInfo", propOrder = {
    "origin",
    "destination",
    "hotelService"
})
public class JPTransferBookingInfo {

    @XmlElement(name = "Origin")
    protected JPTransferOrigin origin;
    @XmlElement(name = "Object")
    protected JPTransferDestination destination;
    @XmlElement(name = "HotelService")
    protected JPHotelService hotelService;
    @XmlAttribute(name = "ICode")
    protected String iCode;
    @XmlAttribute(name = "Route")
    protected JPRouteType route;

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferOrigin }
     *     
     */
    public JPTransferOrigin getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferOrigin }
     *     
     */
    public void setOrigin(JPTransferOrigin value) {
        this.origin = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferDestination }
     *     
     */
    public JPTransferDestination getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferDestination }
     *     
     */
    public void setDestination(JPTransferDestination value) {
        this.destination = value;
    }

    /**
     * Gets the value of the hotelService property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelService }
     *     
     */
    public JPHotelService getHotelService() {
        return hotelService;
    }

    /**
     * Sets the value of the hotelService property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelService }
     *     
     */
    public void setHotelService(JPHotelService value) {
        this.hotelService = value;
    }

    /**
     * Gets the value of the iCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICode() {
        return iCode;
    }

    /**
     * Sets the value of the iCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICode(String value) {
        this.iCode = value;
    }

    /**
     * Gets the value of the route property.
     * 
     * @return
     *     possible object is
     *     {@link JPRouteType }
     *     
     */
    public JPRouteType getRoute() {
        return route;
    }

    /**
     * Sets the value of the route property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRouteType }
     *     
     */
    public void setRoute(JPRouteType value) {
        this.route = value;
    }

}
