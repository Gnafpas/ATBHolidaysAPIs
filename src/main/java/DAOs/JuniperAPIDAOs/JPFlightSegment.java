
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_FlightSegment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightSegment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Equipments" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Equipment" minOccurs="0"/>
 *         &lt;element name="TechnicalStops" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_TechnicalStop" minOccurs="0"/>
 *         &lt;element name="SeatingMap" type="{http://www.juniper.es/webservice/2007/}JP_SeatingMap" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Order" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Stops" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="DepartureAirport" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ArrivalAirport" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DepartureDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="ArrivalDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="OperatingAirline" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MarquetingAirline" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FlightNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="JourneyDuration" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="GroundDuration" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="Class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Meal" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Cabin" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AirplaneType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FareBasis" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="VendorLocator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FlightSegment", propOrder = {
    "equipments",
    "technicalStops",
    "seatingMap"
})
public class JPFlightSegment {

    @XmlElement(name = "Equipments")
    protected ArrayOfJPEquipment equipments;
    @XmlElement(name = "TechnicalStops")
    protected ArrayOfJPTechnicalStop technicalStops;
    @XmlElement(name = "SeatingMap")
    protected JPSeatingMap seatingMap;
    @XmlAttribute(name = "Order")
    protected Integer order;
    @XmlAttribute(name = "Stops")
    protected Integer stops;
    @XmlAttribute(name = "DepartureAirport")
    protected String departureAirport;
    @XmlAttribute(name = "ArrivalAirport")
    protected String arrivalAirport;
    @XmlAttribute(name = "DepartureDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar departureDate;
    @XmlAttribute(name = "ArrivalDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar arrivalDate;
    @XmlAttribute(name = "OperatingAirline")
    protected String operatingAirline;
    @XmlAttribute(name = "MarquetingAirline")
    protected String marquetingAirline;
    @XmlAttribute(name = "FlightNumber")
    protected String flightNumber;
    @XmlAttribute(name = "JourneyDuration")
    protected Duration journeyDuration;
    @XmlAttribute(name = "GroundDuration")
    protected Duration groundDuration;
    @XmlAttribute(name = "Class")
    protected String clazz;
    @XmlAttribute(name = "Meal")
    protected String meal;
    @XmlAttribute(name = "Cabin")
    protected String cabin;
    @XmlAttribute(name = "AirplaneType")
    protected String airplaneType;
    @XmlAttribute(name = "FareBasis")
    protected String fareBasis;
    @XmlAttribute(name = "VendorLocator")
    protected String vendorLocator;

    /**
     * Gets the value of the equipments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPEquipment }
     *     
     */
    public ArrayOfJPEquipment getEquipments() {
        return equipments;
    }

    /**
     * Sets the value of the equipments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPEquipment }
     *     
     */
    public void setEquipments(ArrayOfJPEquipment value) {
        this.equipments = value;
    }

    /**
     * Gets the value of the technicalStops property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPTechnicalStop }
     *     
     */
    public ArrayOfJPTechnicalStop getTechnicalStops() {
        return technicalStops;
    }

    /**
     * Sets the value of the technicalStops property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPTechnicalStop }
     *     
     */
    public void setTechnicalStops(ArrayOfJPTechnicalStop value) {
        this.technicalStops = value;
    }

    /**
     * Gets the value of the seatingMap property.
     * 
     * @return
     *     possible object is
     *     {@link JPSeatingMap }
     *     
     */
    public JPSeatingMap getSeatingMap() {
        return seatingMap;
    }

    /**
     * Sets the value of the seatingMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSeatingMap }
     *     
     */
    public void setSeatingMap(JPSeatingMap value) {
        this.seatingMap = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrder(Integer value) {
        this.order = value;
    }

    /**
     * Gets the value of the stops property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStops() {
        return stops;
    }

    /**
     * Sets the value of the stops property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStops(Integer value) {
        this.stops = value;
    }

    /**
     * Gets the value of the departureAirport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartureAirport() {
        return departureAirport;
    }

    /**
     * Sets the value of the departureAirport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartureAirport(String value) {
        this.departureAirport = value;
    }

    /**
     * Gets the value of the arrivalAirport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalAirport() {
        return arrivalAirport;
    }

    /**
     * Sets the value of the arrivalAirport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalAirport(String value) {
        this.arrivalAirport = value;
    }

    /**
     * Gets the value of the departureDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets the value of the departureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDepartureDate(XMLGregorianCalendar value) {
        this.departureDate = value;
    }

    /**
     * Gets the value of the arrivalDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the value of the arrivalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArrivalDate(XMLGregorianCalendar value) {
        this.arrivalDate = value;
    }

    /**
     * Gets the value of the operatingAirline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatingAirline() {
        return operatingAirline;
    }

    /**
     * Sets the value of the operatingAirline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatingAirline(String value) {
        this.operatingAirline = value;
    }

    /**
     * Gets the value of the marquetingAirline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarquetingAirline() {
        return marquetingAirline;
    }

    /**
     * Sets the value of the marquetingAirline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarquetingAirline(String value) {
        this.marquetingAirline = value;
    }

    /**
     * Gets the value of the flightNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets the value of the flightNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightNumber(String value) {
        this.flightNumber = value;
    }

    /**
     * Gets the value of the journeyDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getJourneyDuration() {
        return journeyDuration;
    }

    /**
     * Sets the value of the journeyDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setJourneyDuration(Duration value) {
        this.journeyDuration = value;
    }

    /**
     * Gets the value of the groundDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getGroundDuration() {
        return groundDuration;
    }

    /**
     * Sets the value of the groundDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setGroundDuration(Duration value) {
        this.groundDuration = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the meal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeal() {
        return meal;
    }

    /**
     * Sets the value of the meal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeal(String value) {
        this.meal = value;
    }

    /**
     * Gets the value of the cabin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCabin() {
        return cabin;
    }

    /**
     * Sets the value of the cabin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCabin(String value) {
        this.cabin = value;
    }

    /**
     * Gets the value of the airplaneType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirplaneType() {
        return airplaneType;
    }

    /**
     * Sets the value of the airplaneType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirplaneType(String value) {
        this.airplaneType = value;
    }

    /**
     * Gets the value of the fareBasis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFareBasis() {
        return fareBasis;
    }

    /**
     * Sets the value of the fareBasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFareBasis(String value) {
        this.fareBasis = value;
    }

    /**
     * Gets the value of the vendorLocator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorLocator() {
        return vendorLocator;
    }

    /**
     * Sets the value of the vendorLocator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorLocator(String value) {
        this.vendorLocator = value;
    }

}
