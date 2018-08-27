
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_PackageStay complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageStay">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Hotels" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageHotel" minOccurs="0"/>
 *         &lt;element name="Flights" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Flight" minOccurs="0"/>
 *         &lt;element name="Transfers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Transfer" minOccurs="0"/>
 *         &lt;element name="Services" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ServiceProduct" minOccurs="0"/>
 *         &lt;element name="Insurances" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageInsurance" minOccurs="0"/>
 *         &lt;element name="Packages" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Tour" minOccurs="0"/>
 *         &lt;element name="Rentacars" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Car" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DestinationZone" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Start" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="End" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageStay", propOrder = {
    "hotels",
    "flights",
    "transfers",
    "services",
    "insurances",
    "packages",
    "rentacars"
})
public class JPPackageStay {

    @XmlElement(name = "Hotels")
    protected ArrayOfJPPackageHotel hotels;
    @XmlElement(name = "Flights")
    protected ArrayOfJPFlight flights;
    @XmlElement(name = "Transfers")
    protected ArrayOfJPTransfer transfers;
    @XmlElement(name = "Services")
    protected ArrayOfJPServiceProduct services;
    @XmlElement(name = "Insurances")
    protected ArrayOfJPPackageInsurance insurances;
    @XmlElement(name = "Packages")
    protected ArrayOfJPTour packages;
    @XmlElement(name = "Rentacars")
    protected ArrayOfJPCar rentacars;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "DestinationZone")
    protected Integer destinationZone;
    @XmlAttribute(name = "Start", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "End", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;

    /**
     * Gets the value of the hotels property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackageHotel }
     *     
     */
    public ArrayOfJPPackageHotel getHotels() {
        return hotels;
    }

    /**
     * Sets the value of the hotels property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackageHotel }
     *     
     */
    public void setHotels(ArrayOfJPPackageHotel value) {
        this.hotels = value;
    }

    /**
     * Gets the value of the flights property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPFlight }
     *     
     */
    public ArrayOfJPFlight getFlights() {
        return flights;
    }

    /**
     * Sets the value of the flights property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPFlight }
     *     
     */
    public void setFlights(ArrayOfJPFlight value) {
        this.flights = value;
    }

    /**
     * Gets the value of the transfers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPTransfer }
     *     
     */
    public ArrayOfJPTransfer getTransfers() {
        return transfers;
    }

    /**
     * Sets the value of the transfers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPTransfer }
     *     
     */
    public void setTransfers(ArrayOfJPTransfer value) {
        this.transfers = value;
    }

    /**
     * Gets the value of the services property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPServiceProduct }
     *     
     */
    public ArrayOfJPServiceProduct getServices() {
        return services;
    }

    /**
     * Sets the value of the services property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPServiceProduct }
     *     
     */
    public void setServices(ArrayOfJPServiceProduct value) {
        this.services = value;
    }

    /**
     * Gets the value of the insurances property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackageInsurance }
     *     
     */
    public ArrayOfJPPackageInsurance getInsurances() {
        return insurances;
    }

    /**
     * Sets the value of the insurances property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackageInsurance }
     *     
     */
    public void setInsurances(ArrayOfJPPackageInsurance value) {
        this.insurances = value;
    }

    /**
     * Gets the value of the packages property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPTour }
     *     
     */
    public ArrayOfJPTour getPackages() {
        return packages;
    }

    /**
     * Sets the value of the packages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPTour }
     *     
     */
    public void setPackages(ArrayOfJPTour value) {
        this.packages = value;
    }

    /**
     * Gets the value of the rentacars property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCar }
     *     
     */
    public ArrayOfJPCar getRentacars() {
        return rentacars;
    }

    /**
     * Sets the value of the rentacars property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCar }
     *     
     */
    public void setRentacars(ArrayOfJPCar value) {
        this.rentacars = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the destinationZone property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDestinationZone() {
        return destinationZone;
    }

    /**
     * Sets the value of the destinationZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDestinationZone(Integer value) {
        this.destinationZone = value;
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

}
