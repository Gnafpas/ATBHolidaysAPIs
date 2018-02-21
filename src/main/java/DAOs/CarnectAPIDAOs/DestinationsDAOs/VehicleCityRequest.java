
package DAOs.CarnectAPIDAOs.DestinationsDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleCityRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleCityRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RegionId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CountryID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CountryISO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleCityRequest", propOrder = {
    "regionId",
    "countryID",
    "countryISO",
    "language"
})
public class VehicleCityRequest {

    @XmlElement(name = "RegionId")
    protected int regionId;
    @XmlElement(name = "CountryID")
    protected int countryID;
    @XmlElement(name = "CountryISO")
    protected String countryISO;
    @XmlElement(name = "Language")
    protected String language;

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

    /**
     * Gets the value of the countryISO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryISO() {
        return countryISO;
    }

    /**
     * Sets the value of the countryISO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryISO(String value) {
        this.countryISO = value;
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

}
