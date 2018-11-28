
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TransferBooking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransferBooking">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transferbookingnumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hotel.id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hotel.name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contactPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contactCellphone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="airline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flightNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="departureAirport" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arrivalAirport" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="departureTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arrivalDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="arrivalTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passengers" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transferID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transferTypeID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transferType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arrivalVoucherText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returnVoucherText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="voucherURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="providerPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="providerEmergencyPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returntransfer" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="returnairline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returnflightNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returndepartureDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="returndepartureTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price.EUR" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bookingstatus" type="{http://xml.sunhotels.net/15/}BookingStatus"/>
 *         &lt;element name="invoiceref" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="yourref" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransferBooking", propOrder = {
    "transferbookingnumber",
    "hotelId",
    "hotelName",
    "contactPerson",
    "contactCellphone",
    "airline",
    "flightNumber",
    "departureAirport",
    "arrivalAirport",
    "departureTime",
    "arrivalDate",
    "arrivalTime",
    "passengers",
    "transferID",
    "transferTypeID",
    "transferType",
    "arrivalVoucherText",
    "returnVoucherText",
    "voucherURL",
    "provider",
    "providerPhone",
    "providerEmergencyPhone",
    "returntransfer",
    "returnairline",
    "returnflightNumber",
    "returndepartureDate",
    "returndepartureTime",
    "price",
    "currency",
    "priceEUR",
    "bookingstatus",
    "invoiceref",
    "yourref"
})
public class TransferBooking {

    protected int transferbookingnumber;
    @XmlElement(name = "hotel.id", required = true, type = Integer.class, nillable = true)
    protected Integer hotelId;
    @XmlElement(name = "hotel.name")
    protected String hotelName;
    protected String contactPerson;
    protected String contactCellphone;
    protected String airline;
    protected String flightNumber;
    protected String departureAirport;
    protected String arrivalAirport;
    protected String departureTime;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar arrivalDate;
    protected String arrivalTime;
    protected int passengers;
    protected int transferID;
    protected int transferTypeID;
    protected String transferType;
    protected String arrivalVoucherText;
    protected String returnVoucherText;
    protected String voucherURL;
    protected String provider;
    protected String providerPhone;
    protected String providerEmergencyPhone;
    protected int returntransfer;
    protected String returnairline;
    protected String returnflightNumber;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar returndepartureDate;
    protected String returndepartureTime;
    protected int price;
    protected String currency;
    @XmlElement(name = "price.EUR")
    protected int priceEUR;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected BookingStatus bookingstatus;
    protected String invoiceref;
    protected String yourref;

    /**
     * Gets the value of the transferbookingnumber property.
     * 
     */
    public int getTransferbookingnumber() {
        return transferbookingnumber;
    }

    /**
     * Sets the value of the transferbookingnumber property.
     * 
     */
    public void setTransferbookingnumber(int value) {
        this.transferbookingnumber = value;
    }

    /**
     * Gets the value of the hotelId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHotelId() {
        return hotelId;
    }

    /**
     * Sets the value of the hotelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHotelId(Integer value) {
        this.hotelId = value;
    }

    /**
     * Gets the value of the hotelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Sets the value of the hotelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelName(String value) {
        this.hotelName = value;
    }

    /**
     * Gets the value of the contactPerson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * Sets the value of the contactPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPerson(String value) {
        this.contactPerson = value;
    }

    /**
     * Gets the value of the contactCellphone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactCellphone() {
        return contactCellphone;
    }

    /**
     * Sets the value of the contactCellphone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactCellphone(String value) {
        this.contactCellphone = value;
    }

    /**
     * Gets the value of the airline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirline() {
        return airline;
    }

    /**
     * Sets the value of the airline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirline(String value) {
        this.airline = value;
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
     * Gets the value of the departureTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets the value of the departureTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartureTime(String value) {
        this.departureTime = value;
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
     * Gets the value of the arrivalTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets the value of the arrivalTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalTime(String value) {
        this.arrivalTime = value;
    }

    /**
     * Gets the value of the passengers property.
     * 
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Sets the value of the passengers property.
     * 
     */
    public void setPassengers(int value) {
        this.passengers = value;
    }

    /**
     * Gets the value of the transferID property.
     * 
     */
    public int getTransferID() {
        return transferID;
    }

    /**
     * Sets the value of the transferID property.
     * 
     */
    public void setTransferID(int value) {
        this.transferID = value;
    }

    /**
     * Gets the value of the transferTypeID property.
     * 
     */
    public int getTransferTypeID() {
        return transferTypeID;
    }

    /**
     * Sets the value of the transferTypeID property.
     * 
     */
    public void setTransferTypeID(int value) {
        this.transferTypeID = value;
    }

    /**
     * Gets the value of the transferType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferType() {
        return transferType;
    }

    /**
     * Sets the value of the transferType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferType(String value) {
        this.transferType = value;
    }

    /**
     * Gets the value of the arrivalVoucherText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalVoucherText() {
        return arrivalVoucherText;
    }

    /**
     * Sets the value of the arrivalVoucherText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalVoucherText(String value) {
        this.arrivalVoucherText = value;
    }

    /**
     * Gets the value of the returnVoucherText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnVoucherText() {
        return returnVoucherText;
    }

    /**
     * Sets the value of the returnVoucherText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnVoucherText(String value) {
        this.returnVoucherText = value;
    }

    /**
     * Gets the value of the voucherURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherURL() {
        return voucherURL;
    }

    /**
     * Sets the value of the voucherURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherURL(String value) {
        this.voucherURL = value;
    }

    /**
     * Gets the value of the provider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvider() {
        return provider;
    }

    /**
     * Sets the value of the provider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvider(String value) {
        this.provider = value;
    }

    /**
     * Gets the value of the providerPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderPhone() {
        return providerPhone;
    }

    /**
     * Sets the value of the providerPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderPhone(String value) {
        this.providerPhone = value;
    }

    /**
     * Gets the value of the providerEmergencyPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderEmergencyPhone() {
        return providerEmergencyPhone;
    }

    /**
     * Sets the value of the providerEmergencyPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderEmergencyPhone(String value) {
        this.providerEmergencyPhone = value;
    }

    /**
     * Gets the value of the returntransfer property.
     * 
     */
    public int getReturntransfer() {
        return returntransfer;
    }

    /**
     * Sets the value of the returntransfer property.
     * 
     */
    public void setReturntransfer(int value) {
        this.returntransfer = value;
    }

    /**
     * Gets the value of the returnairline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnairline() {
        return returnairline;
    }

    /**
     * Sets the value of the returnairline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnairline(String value) {
        this.returnairline = value;
    }

    /**
     * Gets the value of the returnflightNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnflightNumber() {
        return returnflightNumber;
    }

    /**
     * Sets the value of the returnflightNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnflightNumber(String value) {
        this.returnflightNumber = value;
    }

    /**
     * Gets the value of the returndepartureDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReturndepartureDate() {
        return returndepartureDate;
    }

    /**
     * Sets the value of the returndepartureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReturndepartureDate(XMLGregorianCalendar value) {
        this.returndepartureDate = value;
    }

    /**
     * Gets the value of the returndepartureTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturndepartureTime() {
        return returndepartureTime;
    }

    /**
     * Sets the value of the returndepartureTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturndepartureTime(String value) {
        this.returndepartureTime = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(int value) {
        this.price = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the priceEUR property.
     * 
     */
    public int getPriceEUR() {
        return priceEUR;
    }

    /**
     * Sets the value of the priceEUR property.
     * 
     */
    public void setPriceEUR(int value) {
        this.priceEUR = value;
    }

    /**
     * Gets the value of the bookingstatus property.
     * 
     * @return
     *     possible object is
     *     {@link BookingStatus }
     *     
     */
    public BookingStatus getBookingstatus() {
        return bookingstatus;
    }

    /**
     * Sets the value of the bookingstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookingStatus }
     *     
     */
    public void setBookingstatus(BookingStatus value) {
        this.bookingstatus = value;
    }

    /**
     * Gets the value of the invoiceref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceref() {
        return invoiceref;
    }

    /**
     * Sets the value of the invoiceref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceref(String value) {
        this.invoiceref = value;
    }

    /**
     * Gets the value of the yourref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYourref() {
        return yourref;
    }

    /**
     * Sets the value of the yourref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYourref(String value) {
        this.yourref = value;
    }

}
