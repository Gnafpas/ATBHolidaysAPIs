
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FlightPriceInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightPriceInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Routes" type="{http://www.juniper.es/webservice/2007/}JP_Routes" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *         &lt;element name="AdditionalElements" type="{http://www.juniper.es/webservice/2007/}JP_AdditionalElements" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FlightPriceInformation", propOrder = {
    "routes",
    "prices",
    "additionalElements"
})
public class JPFlightPriceInformation {

    @XmlElement(name = "Routes")
    protected JPRoutes routes;
    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;
    @XmlElement(name = "AdditionalElements")
    protected JPAdditionalElements additionalElements;

    /**
     * Gets the value of the routes property.
     * 
     * @return
     *     possible object is
     *     {@link JPRoutes }
     *     
     */
    public JPRoutes getRoutes() {
        return routes;
    }

    /**
     * Sets the value of the routes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRoutes }
     *     
     */
    public void setRoutes(JPRoutes value) {
        this.routes = value;
    }

    /**
     * Gets the value of the prices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPrice }
     *     
     */
    public ArrayOfJPPrice getPrices() {
        return prices;
    }

    /**
     * Sets the value of the prices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPrice }
     *     
     */
    public void setPrices(ArrayOfJPPrice value) {
        this.prices = value;
    }

    /**
     * Gets the value of the additionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPAdditionalElements }
     *     
     */
    public JPAdditionalElements getAdditionalElements() {
        return additionalElements;
    }

    /**
     * Sets the value of the additionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPAdditionalElements }
     *     
     */
    public void setAdditionalElements(JPAdditionalElements value) {
        this.additionalElements = value;
    }

}
