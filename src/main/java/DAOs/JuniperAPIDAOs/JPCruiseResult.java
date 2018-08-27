
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_CruiseResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ship" type="{http://www.juniper.es/webservice/2007/}JP_Ship" minOccurs="0"/>
 *         &lt;element name="Itinerary" type="{http://www.juniper.es/webservice/2007/}JP_CruiseItinerary" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Categories" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseCategory" minOccurs="0"/>
 *         &lt;element name="StarDays" type="{http://www.juniper.es/webservice/2007/}JP_CruiseStarDay" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BookingCode" type="{http://www.juniper.es/webservice/2007/}JP_BookingCode" minOccurs="0"/>
 *         &lt;element name="CruiseRequiredFields" type="{http://www.juniper.es/webservice/2007/}JP_CruiseRequiredFields" minOccurs="0"/>
 *         &lt;element name="PriceInformation" type="{http://www.juniper.es/webservice/2007/}JP_CruisePriceInformation" minOccurs="0"/>
 *         &lt;element name="RelPaxesDist" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RelPaxDist" minOccurs="0"/>
 *         &lt;element name="OptionalElements" type="{http://www.juniper.es/webservice/2007/}JP_CruiseOptionalElements" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CruiseCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Zone" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="DaysDuration" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="IncludeFlight" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseResult", propOrder = {
    "sea",
    "name",
    "ship",
    "itinerary",
    "description",
    "categories",
    "starDays",
    "bookingCode",
    "cruiseRequiredFields",
    "priceInformation",
    "relPaxesDist",
    "optionalElements"
})
public class JPCruiseResult {

    @XmlElement(name = "Sea")
    protected String sea;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Ship")
    protected JPShip ship;
    @XmlElement(name = "Itinerary")
    protected JPCruiseItinerary itinerary;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Categories")
    protected ArrayOfJPCruiseCategory categories;
    @XmlElement(name = "StarDays")
    protected List<JPCruiseStarDay> starDays;
    @XmlElement(name = "BookingCode")
    protected JPBookingCode bookingCode;
    @XmlElement(name = "CruiseRequiredFields")
    protected JPCruiseRequiredFields cruiseRequiredFields;
    @XmlElement(name = "PriceInformation")
    protected JPCruisePriceInformation priceInformation;
    @XmlElement(name = "RelPaxesDist")
    protected ArrayOfJPRelPaxDist relPaxesDist;
    @XmlElement(name = "OptionalElements")
    protected JPCruiseOptionalElements optionalElements;
    @XmlAttribute(name = "CruiseCode")
    protected String cruiseCode;
    @XmlAttribute(name = "Zone")
    protected Integer zone;
    @XmlAttribute(name = "StartDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlAttribute(name = "DaysDuration")
    protected Integer daysDuration;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;
    @XmlAttribute(name = "Status")
    protected String status;
    @XmlAttribute(name = "IncludeFlight")
    protected Boolean includeFlight;

    /**
     * Gets the value of the sea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSea() {
        return sea;
    }

    /**
     * Sets the value of the sea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSea(String value) {
        this.sea = value;
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
     * Gets the value of the ship property.
     * 
     * @return
     *     possible object is
     *     {@link JPShip }
     *     
     */
    public JPShip getShip() {
        return ship;
    }

    /**
     * Sets the value of the ship property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPShip }
     *     
     */
    public void setShip(JPShip value) {
        this.ship = value;
    }

    /**
     * Gets the value of the itinerary property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseItinerary }
     *     
     */
    public JPCruiseItinerary getItinerary() {
        return itinerary;
    }

    /**
     * Sets the value of the itinerary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseItinerary }
     *     
     */
    public void setItinerary(JPCruiseItinerary value) {
        this.itinerary = value;
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
     * Gets the value of the categories property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseCategory }
     *     
     */
    public ArrayOfJPCruiseCategory getCategories() {
        return categories;
    }

    /**
     * Sets the value of the categories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseCategory }
     *     
     */
    public void setCategories(ArrayOfJPCruiseCategory value) {
        this.categories = value;
    }

    /**
     * Gets the value of the starDays property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the starDays property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStarDays().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPCruiseStarDay }
     * 
     * 
     */
    public List<JPCruiseStarDay> getStarDays() {
        if (starDays == null) {
            starDays = new ArrayList<JPCruiseStarDay>();
        }
        return this.starDays;
    }

    /**
     * Gets the value of the bookingCode property.
     * 
     * @return
     *     possible object is
     *     {@link JPBookingCode }
     *     
     */
    public JPBookingCode getBookingCode() {
        return bookingCode;
    }

    /**
     * Sets the value of the bookingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBookingCode }
     *     
     */
    public void setBookingCode(JPBookingCode value) {
        this.bookingCode = value;
    }

    /**
     * Gets the value of the cruiseRequiredFields property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseRequiredFields }
     *     
     */
    public JPCruiseRequiredFields getCruiseRequiredFields() {
        return cruiseRequiredFields;
    }

    /**
     * Sets the value of the cruiseRequiredFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseRequiredFields }
     *     
     */
    public void setCruiseRequiredFields(JPCruiseRequiredFields value) {
        this.cruiseRequiredFields = value;
    }

    /**
     * Gets the value of the priceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruisePriceInformation }
     *     
     */
    public JPCruisePriceInformation getPriceInformation() {
        return priceInformation;
    }

    /**
     * Sets the value of the priceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruisePriceInformation }
     *     
     */
    public void setPriceInformation(JPCruisePriceInformation value) {
        this.priceInformation = value;
    }

    /**
     * Gets the value of the relPaxesDist property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRelPaxDist }
     *     
     */
    public ArrayOfJPRelPaxDist getRelPaxesDist() {
        return relPaxesDist;
    }

    /**
     * Sets the value of the relPaxesDist property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRelPaxDist }
     *     
     */
    public void setRelPaxesDist(ArrayOfJPRelPaxDist value) {
        this.relPaxesDist = value;
    }

    /**
     * Gets the value of the optionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseOptionalElements }
     *     
     */
    public JPCruiseOptionalElements getOptionalElements() {
        return optionalElements;
    }

    /**
     * Sets the value of the optionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseOptionalElements }
     *     
     */
    public void setOptionalElements(JPCruiseOptionalElements value) {
        this.optionalElements = value;
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
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the daysDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDaysDuration() {
        return daysDuration;
    }

    /**
     * Sets the value of the daysDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDaysDuration(Integer value) {
        this.daysDuration = value;
    }

    /**
     * Gets the value of the ratePlanCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRatePlanCode() {
        return ratePlanCode;
    }

    /**
     * Sets the value of the ratePlanCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatePlanCode(String value) {
        this.ratePlanCode = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
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
