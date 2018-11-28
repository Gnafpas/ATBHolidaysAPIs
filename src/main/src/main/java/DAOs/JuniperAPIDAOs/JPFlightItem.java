
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FlightItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BaseItem">
 *       &lt;sequence>
 *         &lt;element name="Routes" type="{http://www.juniper.es/webservice/2007/}JP_Routes" minOccurs="0"/>
 *         &lt;element name="AdditionalElements" type="{http://www.juniper.es/webservice/2007/}JP_AdditionalElements" minOccurs="0"/>
 *         &lt;element name="RelPaxes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RelPax" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Ticketing" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Direction" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FlightItem", propOrder = {
    "routes",
    "additionalElements",
    "relPaxes"
})
public class JPFlightItem
    extends JPBaseItem
{

    @XmlElement(name = "Routes")
    protected JPRoutes routes;
    @XmlElement(name = "AdditionalElements")
    protected JPAdditionalElements additionalElements;
    @XmlElement(name = "RelPaxes")
    protected ArrayOfJPRelPax relPaxes;
    @XmlAttribute(name = "Ticketing")
    protected Boolean ticketing;
    @XmlAttribute(name = "Direction")
    protected String direction;

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

    /**
     * Gets the value of the relPaxes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRelPax }
     *     
     */
    public ArrayOfJPRelPax getRelPaxes() {
        return relPaxes;
    }

    /**
     * Sets the value of the relPaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRelPax }
     *     
     */
    public void setRelPaxes(ArrayOfJPRelPax value) {
        this.relPaxes = value;
    }

    /**
     * Gets the value of the ticketing property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTicketing() {
        return ticketing;
    }

    /**
     * Sets the value of the ticketing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTicketing(Boolean value) {
        this.ticketing = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirection(String value) {
        this.direction = value;
    }

}
