
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseServices complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseServices">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Barlounges" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Languages" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Jacuzzies" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Restaurants" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Stores" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Lifts" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Casino" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Cinema" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Beautysalons" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Chapel" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Library" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Theater" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Disco" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Spa" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Playroom" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Wedding" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Internet" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Laundry" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Autolaundry" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Showroom" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseServices", propOrder = {
    "barlounges",
    "languages",
    "jacuzzies",
    "restaurants",
    "stores",
    "lifts"
})
public class JPCruiseServices {

    @XmlElement(name = "Barlounges")
    protected Integer barlounges;
    @XmlElement(name = "Languages")
    protected String languages;
    @XmlElement(name = "Jacuzzies")
    protected Integer jacuzzies;
    @XmlElement(name = "Restaurants")
    protected Integer restaurants;
    @XmlElement(name = "Stores")
    protected Integer stores;
    @XmlElement(name = "Lifts")
    protected Integer lifts;
    @XmlAttribute(name = "Casino")
    protected Boolean casino;
    @XmlAttribute(name = "Cinema")
    protected Boolean cinema;
    @XmlAttribute(name = "Beautysalons")
    protected Boolean beautysalons;
    @XmlAttribute(name = "Chapel")
    protected Boolean chapel;
    @XmlAttribute(name = "Library")
    protected Boolean library;
    @XmlAttribute(name = "Theater")
    protected Boolean theater;
    @XmlAttribute(name = "Disco")
    protected Boolean disco;
    @XmlAttribute(name = "Spa")
    protected Boolean spa;
    @XmlAttribute(name = "Playroom")
    protected Boolean playroom;
    @XmlAttribute(name = "Wedding")
    protected Boolean wedding;
    @XmlAttribute(name = "Internet")
    protected Boolean internet;
    @XmlAttribute(name = "Laundry")
    protected Boolean laundry;
    @XmlAttribute(name = "Autolaundry")
    protected Boolean autolaundry;
    @XmlAttribute(name = "Showroom")
    protected Boolean showroom;

    /**
     * Gets the value of the barlounges property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBarlounges() {
        return barlounges;
    }

    /**
     * Sets the value of the barlounges property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBarlounges(Integer value) {
        this.barlounges = value;
    }

    /**
     * Gets the value of the languages property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguages() {
        return languages;
    }

    /**
     * Sets the value of the languages property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguages(String value) {
        this.languages = value;
    }

    /**
     * Gets the value of the jacuzzies property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getJacuzzies() {
        return jacuzzies;
    }

    /**
     * Sets the value of the jacuzzies property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setJacuzzies(Integer value) {
        this.jacuzzies = value;
    }

    /**
     * Gets the value of the restaurants property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRestaurants() {
        return restaurants;
    }

    /**
     * Sets the value of the restaurants property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRestaurants(Integer value) {
        this.restaurants = value;
    }

    /**
     * Gets the value of the stores property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStores() {
        return stores;
    }

    /**
     * Sets the value of the stores property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStores(Integer value) {
        this.stores = value;
    }

    /**
     * Gets the value of the lifts property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLifts() {
        return lifts;
    }

    /**
     * Sets the value of the lifts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLifts(Integer value) {
        this.lifts = value;
    }

    /**
     * Gets the value of the casino property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCasino() {
        return casino;
    }

    /**
     * Sets the value of the casino property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCasino(Boolean value) {
        this.casino = value;
    }

    /**
     * Gets the value of the cinema property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCinema() {
        return cinema;
    }

    /**
     * Sets the value of the cinema property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCinema(Boolean value) {
        this.cinema = value;
    }

    /**
     * Gets the value of the beautysalons property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBeautysalons() {
        return beautysalons;
    }

    /**
     * Sets the value of the beautysalons property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBeautysalons(Boolean value) {
        this.beautysalons = value;
    }

    /**
     * Gets the value of the chapel property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChapel() {
        return chapel;
    }

    /**
     * Sets the value of the chapel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChapel(Boolean value) {
        this.chapel = value;
    }

    /**
     * Gets the value of the library property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLibrary() {
        return library;
    }

    /**
     * Sets the value of the library property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLibrary(Boolean value) {
        this.library = value;
    }

    /**
     * Gets the value of the theater property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTheater() {
        return theater;
    }

    /**
     * Sets the value of the theater property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTheater(Boolean value) {
        this.theater = value;
    }

    /**
     * Gets the value of the disco property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDisco() {
        return disco;
    }

    /**
     * Sets the value of the disco property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisco(Boolean value) {
        this.disco = value;
    }

    /**
     * Gets the value of the spa property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSpa() {
        return spa;
    }

    /**
     * Sets the value of the spa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSpa(Boolean value) {
        this.spa = value;
    }

    /**
     * Gets the value of the playroom property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPlayroom() {
        return playroom;
    }

    /**
     * Sets the value of the playroom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPlayroom(Boolean value) {
        this.playroom = value;
    }

    /**
     * Gets the value of the wedding property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWedding() {
        return wedding;
    }

    /**
     * Sets the value of the wedding property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWedding(Boolean value) {
        this.wedding = value;
    }

    /**
     * Gets the value of the internet property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInternet() {
        return internet;
    }

    /**
     * Sets the value of the internet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInternet(Boolean value) {
        this.internet = value;
    }

    /**
     * Gets the value of the laundry property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLaundry() {
        return laundry;
    }

    /**
     * Sets the value of the laundry property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLaundry(Boolean value) {
        this.laundry = value;
    }

    /**
     * Gets the value of the autolaundry property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutolaundry() {
        return autolaundry;
    }

    /**
     * Sets the value of the autolaundry property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutolaundry(Boolean value) {
        this.autolaundry = value;
    }

    /**
     * Gets the value of the showroom property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowroom() {
        return showroom;
    }

    /**
     * Sets the value of the showroom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowroom(Boolean value) {
        this.showroom = value;
    }

}
