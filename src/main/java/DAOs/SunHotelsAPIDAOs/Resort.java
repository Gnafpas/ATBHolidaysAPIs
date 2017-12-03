
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Resort complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Resort">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResortId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ResortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destination_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DestinationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Resort", propOrder = {
    "resortId",
    "resortName",
    "destinationId",
    "destinationName",
    "countryName",
    "countryCode"
})
public class Resort {

    @XmlElement(name = "ResortId")
    protected int resortId;
    @XmlElement(name = "ResortName")
    protected String resortName;
    @XmlElement(name = "destination_id")
    protected int destinationId;
    @XmlElement(name = "DestinationName")
    protected String destinationName;
    @XmlElement(name = "CountryName")
    protected String countryName;
    @XmlElement(name = "CountryCode")
    protected String countryCode;

    /**
     * Gets the value of the resortId property.
     * 
     */
    public int getResortId() {
        return resortId;
    }

    /**
     * Sets the value of the resortId property.
     * 
     */
    public void setResortId(int value) {
        this.resortId = value;
    }

    /**
     * Gets the value of the resortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResortName() {
        return resortName;
    }

    /**
     * Sets the value of the resortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResortName(String value) {
        this.resortName = value;
    }

    /**
     * Gets the value of the destinationId property.
     * 
     */
    public int getDestinationId() {
        return destinationId;
    }

    /**
     * Sets the value of the destinationId property.
     * 
     */
    public void setDestinationId(int value) {
        this.destinationId = value;
    }

    /**
     * Gets the value of the destinationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationName() {
        return destinationName;
    }

    /**
     * Sets the value of the destinationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationName(String value) {
        this.destinationName = value;
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
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

}
