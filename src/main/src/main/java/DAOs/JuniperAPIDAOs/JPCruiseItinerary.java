
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseItinerary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseItinerary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StarDays" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseStarDay" minOccurs="0"/>
 *         &lt;element name="Images" type="{http://www.juniper.es/webservice/2007/}ArrayOfString1" minOccurs="0"/>
 *         &lt;element name="Ship" type="{http://www.juniper.es/webservice/2007/}JP_Ship" minOccurs="0"/>
 *         &lt;element name="Route" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Day" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CruiseCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseItinerary", propOrder = {
    "sea",
    "starDays",
    "images",
    "ship",
    "route"
})
public class JPCruiseItinerary {

    @XmlElement(name = "Sea")
    protected String sea;
    @XmlElement(name = "StarDays")
    protected ArrayOfJPCruiseStarDay starDays;
    @XmlElement(name = "Images")
    protected ArrayOfString1 images;
    @XmlElement(name = "Ship")
    protected JPShip ship;
    @XmlElement(name = "Route")
    protected ArrayOfJPDay route;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "CruiseCode")
    protected String cruiseCode;

    /**
     * Gets the value of the sea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSea() {
        return sea;
    }

    /**
     * Sets the value of the sea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSea(String value) {
        this.sea = value;
    }

    /**
     * Gets the value of the starDays property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseStarDay }
     *     
     */
    public ArrayOfJPCruiseStarDay getStarDays() {
        return starDays;
    }

    /**
     * Sets the value of the starDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseStarDay }
     *     
     */
    public void setStarDays(ArrayOfJPCruiseStarDay value) {
        this.starDays = value;
    }

    /**
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString1 }
     *     
     */
    public ArrayOfString1 getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString1 }
     *     
     */
    public void setImages(ArrayOfString1 value) {
        this.images = value;
    }

    /**
     * Gets the value of the ship property.
     * 
     * @return
     *     possible object is
     *     {@link JPShip }
     *     
     */
    public JPShip getShip() {
        return ship;
    }

    /**
     * Sets the value of the ship property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPShip }
     *     
     */
    public void setShip(JPShip value) {
        this.ship = value;
    }

    /**
     * Gets the value of the route property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPDay }
     *     
     */
    public ArrayOfJPDay getRoute() {
        return route;
    }

    /**
     * Sets the value of the route property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPDay }
     *     
     */
    public void setRoute(ArrayOfJPDay value) {
        this.route = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the cruiseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCruiseCode() {
        return cruiseCode;
    }

    /**
     * Sets the value of the cruiseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCruiseCode(String value) {
        this.cruiseCode = value;
    }

}
