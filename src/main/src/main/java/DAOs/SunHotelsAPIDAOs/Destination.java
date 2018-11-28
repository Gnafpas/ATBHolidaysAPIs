
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Object complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Object">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="destination_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DestinationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DestinationCode.2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DestinationCode.3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DestinationCode.4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DestinationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeZone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Destination", propOrder = {
    "destinationId",
    "destinationCode",
    "destinationCode2",
    "destinationCode3",
    "destinationCode4",
    "destinationName",
    "countryId",
    "countryName",
    "countryCode",
    "timeZone"
})
public class Destination {

    @XmlElement(name = "destination_id")
    protected int destinationId;
    @XmlElement(name = "DestinationCode")
    protected String destinationCode;
    @XmlElement(name = "DestinationCode.2")
    protected String destinationCode2;
    @XmlElement(name = "DestinationCode.3")
    protected String destinationCode3;
    @XmlElement(name = "DestinationCode.4")
    protected String destinationCode4;
    @XmlElement(name = "DestinationName")
    protected String destinationName;
    @XmlElement(name = "CountryId")
    protected int countryId;
    @XmlElement(name = "CountryName")
    protected String countryName;
    @XmlElement(name = "CountryCode")
    protected String countryCode;
    @XmlElement(name = "TimeZone")
    protected String timeZone;

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
     * Gets the value of the destinationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationCode() {
        return destinationCode;
    }

    /**
     * Sets the value of the destinationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationCode(String value) {
        this.destinationCode = value;
    }

    /**
     * Gets the value of the destinationCode2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationCode2() {
        return destinationCode2;
    }

    /**
     * Sets the value of the destinationCode2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationCode2(String value) {
        this.destinationCode2 = value;
    }

    /**
     * Gets the value of the destinationCode3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationCode3() {
        return destinationCode3;
    }

    /**
     * Sets the value of the destinationCode3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationCode3(String value) {
        this.destinationCode3 = value;
    }

    /**
     * Gets the value of the destinationCode4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationCode4() {
        return destinationCode4;
    }

    /**
     * Sets the value of the destinationCode4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationCode4(String value) {
        this.destinationCode4 = value;
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
     * Gets the value of the countryId property.
     * 
     */
    public int getCountryId() {
        return countryId;
    }

    /**
     * Sets the value of the countryId property.
     * 
     */
    public void setCountryId(int value) {
        this.countryId = value;
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

}
