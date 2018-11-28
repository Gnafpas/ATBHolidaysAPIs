
package DAOs.CarnectAPIDAOs.DestinationsDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleAirportRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleAirportRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RegionId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CountryID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleAirportRequest", propOrder = {
    "regionId",
    "language",
    "cityID",
    "countryID"
})
public class VehicleAirportRequest {

    @XmlElement(name = "RegionId")
    protected int regionId;
    @XmlElement(name = "Language")
    protected String language;
    @XmlElement(name = "CityID")
    protected int cityID;
    @XmlElement(name = "CountryID")
    protected int countryID;

    /**
     * Gets the value of the regionId property.
     * 
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * Sets the value of the regionId property.
     * 
     */
    public void setRegionId(int value) {
        this.regionId = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the cityID property.
     * 
     */
    public int getCityID() {
        return cityID;
    }

    /**
     * Sets the value of the cityID property.
     * 
     */
    public void setCityID(int value) {
        this.cityID = value;
    }

    /**
     * Gets the value of the countryID property.
     * 
     */
    public int getCountryID() {
        return countryID;
    }

    /**
     * Sets the value of the countryID property.
     * 
     */
    public void setCountryID(int value) {
        this.countryID = value;
    }

}
