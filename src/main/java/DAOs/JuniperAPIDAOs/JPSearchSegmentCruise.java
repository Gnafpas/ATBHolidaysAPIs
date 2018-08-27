
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_SearchSegmentCruise complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentCruise">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CountryOfResidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ShipCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Zone" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Start" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="End" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="Duration" type="{http://www.juniper.es/webservice/2007/}JP_CruiseDuration" />
 *       &lt;attribute name="CruiseCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Married" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="IncludeFlight" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentCruise", propOrder = {
    "countryOfResidence"
})
public class JPSearchSegmentCruise {

    @XmlElement(name = "CountryOfResidence")
    protected String countryOfResidence;
    @XmlAttribute(name = "ShipCode")
    protected String shipCode;
    @XmlAttribute(name = "Zone")
    protected Integer zone;
    @XmlAttribute(name = "Start")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "End")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;
    @XmlAttribute(name = "Duration")
    protected JPCruiseDuration duration;
    @XmlAttribute(name = "CruiseCode")
    protected String cruiseCode;
    @XmlAttribute(name = "Married")
    protected Boolean married;
    @XmlAttribute(name = "IncludeFlight")
    protected Boolean includeFlight;

    /**
     * Gets the value of the countryOfResidence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    /**
     * Sets the value of the countryOfResidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfResidence(String value) {
        this.countryOfResidence = value;
    }

    /**
     * Gets the value of the shipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipCode() {
        return shipCode;
    }

    /**
     * Sets the value of the shipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipCode(String value) {
        this.shipCode = value;
    }

    /**
     * Gets the value of the zone property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZone() {
        return zone;
    }

    /**
     * Sets the value of the zone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZone(Integer value) {
        this.zone = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStart(XMLGregorianCalendar value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnd(XMLGregorianCalendar value) {
        this.end = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseDuration }
     *     
     */
    public JPCruiseDuration getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseDuration }
     *     
     */
    public void setDuration(JPCruiseDuration value) {
        this.duration = value;
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

    /**
     * Gets the value of the married property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMarried() {
        return married;
    }

    /**
     * Sets the value of the married property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMarried(Boolean value) {
        this.married = value;
    }

    /**
     * Gets the value of the includeFlight property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeFlight() {
        return includeFlight;
    }

    /**
     * Sets the value of the includeFlight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeFlight(Boolean value) {
        this.includeFlight = value;
    }

}
