
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RoomOccupancy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RoomOccupancy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Occupancy" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MaxOccupancy" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MinOccupancy" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Adults" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MaxAdults" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MinAdults" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Children" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MaxChildren" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MinChildren" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RoomOccupancy")
public class JPRoomOccupancy {

    @XmlAttribute(name = "Occupancy")
    protected Integer occupancy;
    @XmlAttribute(name = "MaxOccupancy")
    protected Integer maxOccupancy;
    @XmlAttribute(name = "MinOccupancy")
    protected Integer minOccupancy;
    @XmlAttribute(name = "Adults")
    protected Integer adults;
    @XmlAttribute(name = "MaxAdults")
    protected Integer maxAdults;
    @XmlAttribute(name = "MinAdults")
    protected Integer minAdults;
    @XmlAttribute(name = "Children")
    protected Integer children;
    @XmlAttribute(name = "MaxChildren")
    protected Integer maxChildren;
    @XmlAttribute(name = "MinChildren")
    protected Integer minChildren;

    /**
     * Gets the value of the occupancy property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOccupancy() {
        return occupancy;
    }

    /**
     * Sets the value of the occupancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOccupancy(Integer value) {
        this.occupancy = value;
    }

    /**
     * Gets the value of the maxOccupancy property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxOccupancy() {
        return maxOccupancy;
    }

    /**
     * Sets the value of the maxOccupancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxOccupancy(Integer value) {
        this.maxOccupancy = value;
    }

    /**
     * Gets the value of the minOccupancy property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinOccupancy() {
        return minOccupancy;
    }

    /**
     * Sets the value of the minOccupancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinOccupancy(Integer value) {
        this.minOccupancy = value;
    }

    /**
     * Gets the value of the adults property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAdults() {
        return adults;
    }

    /**
     * Sets the value of the adults property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAdults(Integer value) {
        this.adults = value;
    }

    /**
     * Gets the value of the maxAdults property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxAdults() {
        return maxAdults;
    }

    /**
     * Sets the value of the maxAdults property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxAdults(Integer value) {
        this.maxAdults = value;
    }

    /**
     * Gets the value of the minAdults property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinAdults() {
        return minAdults;
    }

    /**
     * Sets the value of the minAdults property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinAdults(Integer value) {
        this.minAdults = value;
    }

    /**
     * Gets the value of the children property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getChildren() {
        return children;
    }

    /**
     * Sets the value of the children property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setChildren(Integer value) {
        this.children = value;
    }

    /**
     * Gets the value of the maxChildren property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxChildren() {
        return maxChildren;
    }

    /**
     * Sets the value of the maxChildren property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxChildren(Integer value) {
        this.maxChildren = value;
    }

    /**
     * Gets the value of the minChildren property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinChildren() {
        return minChildren;
    }

    /**
     * Sets the value of the minChildren property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinChildren(Integer value) {
        this.minChildren = value;
    }

}
