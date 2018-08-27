
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentFlight complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentFlight">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CountryOfResidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Routes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RouteDispo" minOccurs="0"/>
 *         &lt;element name="Discount" type="{http://www.juniper.es/webservice/2007/}JP_FlightDiscount" minOccurs="0"/>
 *         &lt;element name="Airlines" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Airline" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Cabin" type="{http://www.juniper.es/webservice/2007/}JP_CabinType" />
 *       &lt;attribute name="Class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LowCost" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Stops" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentFlight", propOrder = {
    "countryOfResidence",
    "routes",
    "discount",
    "airlines"
})
public class JPSearchSegmentFlight {

    @XmlElement(name = "CountryOfResidence")
    protected String countryOfResidence;
    @XmlElement(name = "Routes")
    protected ArrayOfJPRouteDispo routes;
    @XmlElement(name = "Discount")
    protected JPFlightDiscount discount;
    @XmlElement(name = "Airlines")
    protected ArrayOfJPAirline airlines;
    @XmlAttribute(name = "Cabin")
    protected JPCabinType cabin;
    @XmlAttribute(name = "Class")
    protected String clazz;
    @XmlAttribute(name = "LowCost")
    protected Boolean lowCost;
    @XmlAttribute(name = "Stops")
    protected Integer stops;

    /**
     * Gets the value of the countryOfResidence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    /**
     * Sets the value of the countryOfResidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfResidence(String value) {
        this.countryOfResidence = value;
    }

    /**
     * Gets the value of the routes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRouteDispo }
     *     
     */
    public ArrayOfJPRouteDispo getRoutes() {
        return routes;
    }

    /**
     * Sets the value of the routes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRouteDispo }
     *     
     */
    public void setRoutes(ArrayOfJPRouteDispo value) {
        this.routes = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightDiscount }
     *     
     */
    public JPFlightDiscount getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightDiscount }
     *     
     */
    public void setDiscount(JPFlightDiscount value) {
        this.discount = value;
    }

    /**
     * Gets the value of the airlines property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPAirline }
     *     
     */
    public ArrayOfJPAirline getAirlines() {
        return airlines;
    }

    /**
     * Sets the value of the airlines property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPAirline }
     *     
     */
    public void setAirlines(ArrayOfJPAirline value) {
        this.airlines = value;
    }

    /**
     * Gets the value of the cabin property.
     * 
     * @return
     *     possible object is
     *     {@link JPCabinType }
     *     
     */
    public JPCabinType getCabin() {
        return cabin;
    }

    /**
     * Sets the value of the cabin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCabinType }
     *     
     */
    public void setCabin(JPCabinType value) {
        this.cabin = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the lowCost property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLowCost() {
        return lowCost;
    }

    /**
     * Sets the value of the lowCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLowCost(Boolean value) {
        this.lowCost = value;
    }

    /**
     * Gets the value of the stops property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStops() {
        return stops;
    }

    /**
     * Sets the value of the stops property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStops(Integer value) {
        this.stops = value;
    }

}
