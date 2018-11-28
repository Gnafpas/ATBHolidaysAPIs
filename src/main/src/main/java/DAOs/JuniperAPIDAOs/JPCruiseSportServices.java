
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseSportServices complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseSportServices">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Pools" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Indorpools" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Extpools" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Basketball" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Tennis" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Golf" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Jogging" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Minigolf" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Rocodrom" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Pathinhileo" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Gym" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Aquaticplant" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseSportServices", propOrder = {
    "pools",
    "indorpools",
    "extpools"
})
public class JPCruiseSportServices {

    @XmlElement(name = "Pools")
    protected Integer pools;
    @XmlElement(name = "Indorpools")
    protected Integer indorpools;
    @XmlElement(name = "Extpools")
    protected Integer extpools;
    @XmlAttribute(name = "Basketball")
    protected Boolean basketball;
    @XmlAttribute(name = "Tennis")
    protected Boolean tennis;
    @XmlAttribute(name = "Golf")
    protected Boolean golf;
    @XmlAttribute(name = "Jogging")
    protected Boolean jogging;
    @XmlAttribute(name = "Minigolf")
    protected Boolean minigolf;
    @XmlAttribute(name = "Rocodrom")
    protected Boolean rocodrom;
    @XmlAttribute(name = "Pathinhileo")
    protected Boolean pathinhileo;
    @XmlAttribute(name = "Gym")
    protected Boolean gym;
    @XmlAttribute(name = "Aquaticplant")
    protected Boolean aquaticplant;

    /**
     * Gets the value of the pools property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPools() {
        return pools;
    }

    /**
     * Sets the value of the pools property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPools(Integer value) {
        this.pools = value;
    }

    /**
     * Gets the value of the indorpools property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIndorpools() {
        return indorpools;
    }

    /**
     * Sets the value of the indorpools property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIndorpools(Integer value) {
        this.indorpools = value;
    }

    /**
     * Gets the value of the extpools property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExtpools() {
        return extpools;
    }

    /**
     * Sets the value of the extpools property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExtpools(Integer value) {
        this.extpools = value;
    }

    /**
     * Gets the value of the basketball property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBasketball() {
        return basketball;
    }

    /**
     * Sets the value of the basketball property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBasketball(Boolean value) {
        this.basketball = value;
    }

    /**
     * Gets the value of the tennis property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTennis() {
        return tennis;
    }

    /**
     * Sets the value of the tennis property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTennis(Boolean value) {
        this.tennis = value;
    }

    /**
     * Gets the value of the golf property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGolf() {
        return golf;
    }

    /**
     * Sets the value of the golf property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGolf(Boolean value) {
        this.golf = value;
    }

    /**
     * Gets the value of the jogging property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isJogging() {
        return jogging;
    }

    /**
     * Sets the value of the jogging property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setJogging(Boolean value) {
        this.jogging = value;
    }

    /**
     * Gets the value of the minigolf property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMinigolf() {
        return minigolf;
    }

    /**
     * Sets the value of the minigolf property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMinigolf(Boolean value) {
        this.minigolf = value;
    }

    /**
     * Gets the value of the rocodrom property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRocodrom() {
        return rocodrom;
    }

    /**
     * Sets the value of the rocodrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRocodrom(Boolean value) {
        this.rocodrom = value;
    }

    /**
     * Gets the value of the pathinhileo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPathinhileo() {
        return pathinhileo;
    }

    /**
     * Sets the value of the pathinhileo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPathinhileo(Boolean value) {
        this.pathinhileo = value;
    }

    /**
     * Gets the value of the gym property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGym() {
        return gym;
    }

    /**
     * Sets the value of the gym property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGym(Boolean value) {
        this.gym = value;
    }

    /**
     * Gets the value of the aquaticplant property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAquaticplant() {
        return aquaticplant;
    }

    /**
     * Sets the value of the aquaticplant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAquaticplant(Boolean value) {
        this.aquaticplant = value;
    }

}
