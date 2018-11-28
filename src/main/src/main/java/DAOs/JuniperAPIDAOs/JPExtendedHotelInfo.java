
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ExtendedHotelInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ExtendedHotelInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_HotelSimpleInfo">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AreaID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelCategory" type="{http://www.juniper.es/webservice/2007/}JP_HotelCategory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ExtendedHotelInfo", propOrder = {
    "address",
    "areaID",
    "cityName",
    "countryName",
    "zipCode",
    "latitude",
    "longitude",
    "hotelCategory"
})
@XmlSeeAlso({
    JPHotelInfoPortfolio.class
})
public class JPExtendedHotelInfo
    extends JPHotelSimpleInfo
{

    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "AreaID")
    protected String areaID;
    @XmlElement(name = "CityName")
    protected String cityName;
    @XmlElement(name = "CountryName")
    protected String countryName;
    @XmlElement(name = "ZipCode")
    protected String zipCode;
    @XmlElement(name = "Latitude")
    protected String latitude;
    @XmlElement(name = "Longitude")
    protected String longitude;
    @XmlElement(name = "HotelCategory")
    protected JPHotelCategory hotelCategory;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the areaID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaID() {
        return areaID;
    }

    /**
     * Sets the value of the areaID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaID(String value) {
        this.areaID = value;
    }

    /**
     * Gets the value of the cityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the value of the cityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityName(String value) {
        this.cityName = value;
    }

    /**
     * Gets the value of the countryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the countryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

    /**
     * Gets the value of the zipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the value of the zipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipCode(String value) {
        this.zipCode = value;
    }

    /**
     * Gets the value of the latitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatitude(String value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongitude(String value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the hotelCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelCategory }
     *     
     */
    public JPHotelCategory getHotelCategory() {
        return hotelCategory;
    }

    /**
     * Sets the value of the hotelCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelCategory }
     *     
     */
    public void setHotelCategory(JPHotelCategory value) {
        this.hotelCategory = value;
    }

}
