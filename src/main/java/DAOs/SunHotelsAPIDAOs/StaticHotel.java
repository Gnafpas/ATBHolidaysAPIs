
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StaticHotel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StaticHotel">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}HotelPost">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://xml.sunhotels.net/15/}AccommodationType"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotel.addr.1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotel.addr.2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotel.addr.zip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotel.addr.city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotel.addr.state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotel.addr.country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotel.addr.countrycode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotel.address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotel.mapurl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="headline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destination" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="themes" type="{http://xml.sunhotels.net/15/}ArrayOfTheme" minOccurs="0"/>
 *         &lt;element name="images" type="{http://xml.sunhotels.net/15/}ArrayOfHotelImage" minOccurs="0"/>
 *         &lt;element name="features" type="{http://xml.sunhotels.net/15/}ArrayOfFeatureWithName" minOccurs="0"/>
 *         &lt;element name="classification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coordinates" type="{http://xml.sunhotels.net/15/}CoordinatePair" minOccurs="0"/>
 *         &lt;element name="distanceTypes" type="{http://xml.sunhotels.net/15/}ArrayOfHotelDistanceType" minOccurs="0"/>
 *         &lt;element name="timeZone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isBestBuy" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StaticHotel", propOrder = {
    "type",
    "name",
    "hotelAddr1",
    "hotelAddr2",
    "hotelAddrZip",
    "hotelAddrCity",
    "hotelAddrState",
    "hotelAddrCountry",
    "hotelAddrCountrycode",
    "hotelAddress",
    "hotelMapurl",
    "headline",
    "description",
    "resort",
    "destination",
    "themes",
    "images",
    "features",
    "classification",
    "coordinates",
    "distanceTypes",
    "timeZone",
    "isBestBuy"
})
public class StaticHotel
    extends Hotel
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected AccommodationType type;
    protected String name;
    @XmlElement(name = "hotel.addr.1")
    protected String hotelAddr1;
    @XmlElement(name = "hotel.addr.2")
    protected String hotelAddr2;
    @XmlElement(name = "hotel.addr.zip")
    protected String hotelAddrZip;
    @XmlElement(name = "hotel.addr.city")
    protected String hotelAddrCity;
    @XmlElement(name = "hotel.addr.state")
    protected String hotelAddrState;
    @XmlElement(name = "hotel.addr.country")
    protected String hotelAddrCountry;
    @XmlElement(name = "hotel.addr.countrycode")
    protected String hotelAddrCountrycode;
    @XmlElement(name = "hotel.address")
    protected String hotelAddress;
    @XmlElement(name = "hotel.mapurl")
    protected String hotelMapurl;
    protected String headline;
    protected String description;
    protected String resort;
    protected String destination;
    protected ArrayOfTheme themes;
    protected ArrayOfHotelImage images;
    protected ArrayOfFeatureWithName features;
    protected String classification;
    protected CoordinatePair coordinates;
    protected ArrayOfHotelDistanceType distanceTypes;
    protected String timeZone;
    protected boolean isBestBuy;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AccommodationType }
     *     
     */
    public AccommodationType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccommodationType }
     *     
     */
    public void setType(AccommodationType value) {
        this.type = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the hotelAddr1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelAddr1() {
        return hotelAddr1;
    }

    /**
     * Sets the value of the hotelAddr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelAddr1(String value) {
        this.hotelAddr1 = value;
    }

    /**
     * Gets the value of the hotelAddr2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelAddr2() {
        return hotelAddr2;
    }

    /**
     * Sets the value of the hotelAddr2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelAddr2(String value) {
        this.hotelAddr2 = value;
    }

    /**
     * Gets the value of the hotelAddrZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelAddrZip() {
        return hotelAddrZip;
    }

    /**
     * Sets the value of the hotelAddrZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelAddrZip(String value) {
        this.hotelAddrZip = value;
    }

    /**
     * Gets the value of the hotelAddrCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelAddrCity() {
        return hotelAddrCity;
    }

    /**
     * Sets the value of the hotelAddrCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelAddrCity(String value) {
        this.hotelAddrCity = value;
    }

    /**
     * Gets the value of the hotelAddrState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelAddrState() {
        return hotelAddrState;
    }

    /**
     * Sets the value of the hotelAddrState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelAddrState(String value) {
        this.hotelAddrState = value;
    }

    /**
     * Gets the value of the hotelAddrCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelAddrCountry() {
        return hotelAddrCountry;
    }

    /**
     * Sets the value of the hotelAddrCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelAddrCountry(String value) {
        this.hotelAddrCountry = value;
    }

    /**
     * Gets the value of the hotelAddrCountrycode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelAddrCountrycode() {
        return hotelAddrCountrycode;
    }

    /**
     * Sets the value of the hotelAddrCountrycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelAddrCountrycode(String value) {
        this.hotelAddrCountrycode = value;
    }

    /**
     * Gets the value of the hotelAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelAddress() {
        return hotelAddress;
    }

    /**
     * Sets the value of the hotelAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelAddress(String value) {
        this.hotelAddress = value;
    }

    /**
     * Gets the value of the hotelMapurl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelMapurl() {
        return hotelMapurl;
    }

    /**
     * Sets the value of the hotelMapurl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelMapurl(String value) {
        this.hotelMapurl = value;
    }

    /**
     * Gets the value of the headline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * Sets the value of the headline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeadline(String value) {
        this.headline = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the resort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResort() {
        return resort;
    }

    /**
     * Sets the value of the resort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResort(String value) {
        this.resort = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestination(String value) {
        this.destination = value;
    }

    /**
     * Gets the value of the themes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTheme }
     *     
     */
    public ArrayOfTheme getThemes() {
        return themes;
    }

    /**
     * Sets the value of the themes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTheme }
     *     
     */
    public void setThemes(ArrayOfTheme value) {
        this.themes = value;
    }

    /**
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHotelImage }
     *     
     */
    public ArrayOfHotelImage getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHotelImage }
     *     
     */
    public void setImages(ArrayOfHotelImage value) {
        this.images = value;
    }

    /**
     * Gets the value of the features property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFeatureWithName }
     *     
     */
    public ArrayOfFeatureWithName getFeatures() {
        return features;
    }

    /**
     * Sets the value of the features property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFeatureWithName }
     *     
     */
    public void setFeatures(ArrayOfFeatureWithName value) {
        this.features = value;
    }

    /**
     * Gets the value of the classification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassification() {
        return classification;
    }

    /**
     * Sets the value of the classification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassification(String value) {
        this.classification = value;
    }

    /**
     * Gets the value of the coordinates property.
     * 
     * @return
     *     possible object is
     *     {@link CoordinatePair }
     *     
     */
    public CoordinatePair getCoordinates() {
        return coordinates;
    }

    /**
     * Sets the value of the coordinates property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordinatePair }
     *     
     */
    public void setCoordinates(CoordinatePair value) {
        this.coordinates = value;
    }

    /**
     * Gets the value of the distanceTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHotelDistanceType }
     *     
     */
    public ArrayOfHotelDistanceType getDistanceTypes() {
        return distanceTypes;
    }

    /**
     * Sets the value of the distanceTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHotelDistanceType }
     *     
     */
    public void setDistanceTypes(ArrayOfHotelDistanceType value) {
        this.distanceTypes = value;
    }

    /**
     * Gets the value of the timeZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Sets the value of the timeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZone(String value) {
        this.timeZone = value;
    }

    /**
     * Gets the value of the isBestBuy property.
     * 
     */
    public boolean isIsBestBuy() {
        return isBestBuy;
    }

    /**
     * Sets the value of the isBestBuy property.
     * 
     */
    public void setIsBestBuy(boolean value) {
        this.isBestBuy = value;
    }

}
