
package DAOs.SunHotelsAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Booking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Booking">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="bookingnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotel.id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hotel.name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotel.address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotel.phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberofrooms" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="room.type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="room.englishType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mealId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="meal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mealLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishMeal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishMealLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="checkindate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="checkoutdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="prices" type="{http://xml.sunhotels.net/15/}ArrayOfPriceWithPaymentMethods" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bookingdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="bookingdate.timezone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cancellationpolicies" type="{http://xml.sunhotels.net/15/}StaticPercentageCancellationPolicy" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="earliestNonFreeCancellationDate.CET" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="earliestNonFreeCancellationDate.Local" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="yourref" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="voucher" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bookedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transferbooked" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="paymentmethod" type="{http://xml.sunhotels.net/15/}PaymentMethod" minOccurs="0"/>
 *         &lt;element name="hotelNotes" type="{http://xml.sunhotels.net/15/}ArrayOfCalendarNote1" minOccurs="0"/>
 *         &lt;element name="englishHotelNotes" type="{http://xml.sunhotels.net/15/}ArrayOfCalendarNote2" minOccurs="0"/>
 *         &lt;element name="roomNotes" type="{http://xml.sunhotels.net/15/}ArrayOfCalendarNote3" minOccurs="0"/>
 *         &lt;element name="englishRoomNotes" type="{http://xml.sunhotels.net/15/}ArrayOfCalendarNote4" minOccurs="0"/>
 *         &lt;element name="invoiceref" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Booking", propOrder = {
    "bookingnumber",
    "hotelId",
    "hotelName",
    "hotelAddress",
    "hotelPhone",
    "numberofrooms",
    "roomType",
    "roomEnglishType",
    "mealId",
    "meal",
    "mealLabel",
    "englishMeal",
    "englishMealLabel",
    "checkindate",
    "checkoutdate",
    "prices",
    "currency",
    "bookingdate",
    "bookingdateTimezone",
    "cancellationpolicies",
    "earliestNonFreeCancellationDateCET",
    "earliestNonFreeCancellationDateLocal",
    "yourref",
    "voucher",
    "bookedBy",
    "transferbooked",
    "paymentmethod",
    "hotelNotes",
    "englishHotelNotes",
    "roomNotes",
    "englishRoomNotes",
    "invoiceref"
})
@XmlSeeAlso({
    BookingWithStatus.class
})
public class Booking
    extends BaseResult
{

    protected String bookingnumber;
    @XmlElement(name = "hotel.id")
    protected int hotelId;
    @XmlElement(name = "hotel.name")
    protected String hotelName;
    @XmlElement(name = "hotel.address")
    protected String hotelAddress;
    @XmlElement(name = "hotel.phone")
    protected String hotelPhone;
    protected String numberofrooms;
    @XmlElement(name = "room.type")
    protected String roomType;
    @XmlElement(name = "room.englishType")
    protected String roomEnglishType;
    protected int mealId;
    protected String meal;
    protected String mealLabel;
    protected String englishMeal;
    protected String englishMealLabel;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkindate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkoutdate;
    protected ArrayOfPriceWithPaymentMethods prices;
    protected String currency;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar bookingdate;
    @XmlElement(name = "bookingdate.timezone")
    protected String bookingdateTimezone;
    protected List<StaticPercentageCancellationPolicy> cancellationpolicies;
    @XmlElement(name = "earliestNonFreeCancellationDate.CET", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar earliestNonFreeCancellationDateCET;
    @XmlElement(name = "earliestNonFreeCancellationDate.Local", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar earliestNonFreeCancellationDateLocal;
    protected String yourref;
    protected String voucher;
    protected String bookedBy;
    protected int transferbooked;
    protected PaymentMethod paymentmethod;
    protected ArrayOfCalendarNote1 hotelNotes;
    protected ArrayOfCalendarNote2 englishHotelNotes;
    protected ArrayOfCalendarNote3 roomNotes;
    protected ArrayOfCalendarNote4 englishRoomNotes;
    protected String invoiceref;

    /**
     * Gets the value of the bookingnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingnumber() {
        return bookingnumber;
    }

    /**
     * Sets the value of the bookingnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingnumber(String value) {
        this.bookingnumber = value;
    }

    /**
     * Gets the value of the hotelId property.
     * 
     */
    public int getHotelId() {
        return hotelId;
    }

    /**
     * Sets the value of the hotelId property.
     * 
     */
    public void setHotelId(int value) {
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
     * Gets the value of the hotelAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelAddress() {
        return hotelAddress;
    }

    /**
     * Sets the value of the hotelAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelAddress(String value) {
        this.hotelAddress = value;
    }

    /**
     * Gets the value of the hotelPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelPhone() {
        return hotelPhone;
    }

    /**
     * Sets the value of the hotelPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelPhone(String value) {
        this.hotelPhone = value;
    }

    /**
     * Gets the value of the numberofrooms property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberofrooms() {
        return numberofrooms;
    }

    /**
     * Sets the value of the numberofrooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberofrooms(String value) {
        this.numberofrooms = value;
    }

    /**
     * Gets the value of the roomType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Sets the value of the roomType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomType(String value) {
        this.roomType = value;
    }

    /**
     * Gets the value of the roomEnglishType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomEnglishType() {
        return roomEnglishType;
    }

    /**
     * Sets the value of the roomEnglishType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomEnglishType(String value) {
        this.roomEnglishType = value;
    }

    /**
     * Gets the value of the mealId property.
     * 
     */
    public int getMealId() {
        return mealId;
    }

    /**
     * Sets the value of the mealId property.
     * 
     */
    public void setMealId(int value) {
        this.mealId = value;
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
     * Gets the value of the mealLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMealLabel() {
        return mealLabel;
    }

    /**
     * Sets the value of the mealLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMealLabel(String value) {
        this.mealLabel = value;
    }

    /**
     * Gets the value of the englishMeal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishMeal() {
        return englishMeal;
    }

    /**
     * Sets the value of the englishMeal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishMeal(String value) {
        this.englishMeal = value;
    }

    /**
     * Gets the value of the englishMealLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishMealLabel() {
        return englishMealLabel;
    }

    /**
     * Sets the value of the englishMealLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishMealLabel(String value) {
        this.englishMealLabel = value;
    }

    /**
     * Gets the value of the checkindate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckindate() {
        return checkindate;
    }

    /**
     * Sets the value of the checkindate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckindate(XMLGregorianCalendar value) {
        this.checkindate = value;
    }

    /**
     * Gets the value of the checkoutdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckoutdate() {
        return checkoutdate;
    }

    /**
     * Sets the value of the checkoutdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckoutdate(XMLGregorianCalendar value) {
        this.checkoutdate = value;
    }

    /**
     * Gets the value of the prices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPriceWithPaymentMethods }
     *     
     */
    public ArrayOfPriceWithPaymentMethods getPrices() {
        return prices;
    }

    /**
     * Sets the value of the prices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPriceWithPaymentMethods }
     *     
     */
    public void setPrices(ArrayOfPriceWithPaymentMethods value) {
        this.prices = value;
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
     * Gets the value of the bookingdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBookingdate() {
        return bookingdate;
    }

    /**
     * Sets the value of the bookingdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBookingdate(XMLGregorianCalendar value) {
        this.bookingdate = value;
    }

    /**
     * Gets the value of the bookingdateTimezone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingdateTimezone() {
        return bookingdateTimezone;
    }

    /**
     * Sets the value of the bookingdateTimezone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingdateTimezone(String value) {
        this.bookingdateTimezone = value;
    }

    /**
     * Gets the value of the cancellationpolicies property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cancellationpolicies property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCancellationpolicies().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StaticPercentageCancellationPolicy }
     * 
     * 
     */
    public List<StaticPercentageCancellationPolicy> getCancellationpolicies() {
        if (cancellationpolicies == null) {
            cancellationpolicies = new ArrayList<StaticPercentageCancellationPolicy>();
        }
        return this.cancellationpolicies;
    }

    public void setCancellationpolicies(List<StaticPercentageCancellationPolicy> cancellationpolicies) {
        this.cancellationpolicies = cancellationpolicies;
    }

    /**
     * Gets the value of the earliestNonFreeCancellationDateCET property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEarliestNonFreeCancellationDateCET() {
        return earliestNonFreeCancellationDateCET;
    }

    /**
     * Sets the value of the earliestNonFreeCancellationDateCET property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEarliestNonFreeCancellationDateCET(XMLGregorianCalendar value) {
        this.earliestNonFreeCancellationDateCET = value;
    }

    /**
     * Gets the value of the earliestNonFreeCancellationDateLocal property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEarliestNonFreeCancellationDateLocal() {
        return earliestNonFreeCancellationDateLocal;
    }

    /**
     * Sets the value of the earliestNonFreeCancellationDateLocal property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEarliestNonFreeCancellationDateLocal(XMLGregorianCalendar value) {
        this.earliestNonFreeCancellationDateLocal = value;
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

    /**
     * Gets the value of the voucher property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucher() {
        return voucher;
    }

    /**
     * Sets the value of the voucher property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucher(String value) {
        this.voucher = value;
    }

    /**
     * Gets the value of the bookedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookedBy() {
        return bookedBy;
    }

    /**
     * Sets the value of the bookedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookedBy(String value) {
        this.bookedBy = value;
    }

    /**
     * Gets the value of the transferbooked property.
     * 
     */
    public int getTransferbooked() {
        return transferbooked;
    }

    /**
     * Sets the value of the transferbooked property.
     * 
     */
    public void setTransferbooked(int value) {
        this.transferbooked = value;
    }

    /**
     * Gets the value of the paymentmethod property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethod }
     *     
     */
    public PaymentMethod getPaymentmethod() {
        return paymentmethod;
    }

    /**
     * Sets the value of the paymentmethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethod }
     *     
     */
    public void setPaymentmethod(PaymentMethod value) {
        this.paymentmethod = value;
    }

    /**
     * Gets the value of the hotelNotes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCalendarNote1 }
     *     
     */
    public ArrayOfCalendarNote1 getHotelNotes() {
        return hotelNotes;
    }

    /**
     * Sets the value of the hotelNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCalendarNote1 }
     *     
     */
    public void setHotelNotes(ArrayOfCalendarNote1 value) {
        this.hotelNotes = value;
    }

    /**
     * Gets the value of the englishHotelNotes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCalendarNote2 }
     *     
     */
    public ArrayOfCalendarNote2 getEnglishHotelNotes() {
        return englishHotelNotes;
    }

    /**
     * Sets the value of the englishHotelNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCalendarNote2 }
     *     
     */
    public void setEnglishHotelNotes(ArrayOfCalendarNote2 value) {
        this.englishHotelNotes = value;
    }

    /**
     * Gets the value of the roomNotes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCalendarNote3 }
     *     
     */
    public ArrayOfCalendarNote3 getRoomNotes() {
        return roomNotes;
    }

    /**
     * Sets the value of the roomNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCalendarNote3 }
     *     
     */
    public void setRoomNotes(ArrayOfCalendarNote3 value) {
        this.roomNotes = value;
    }

    /**
     * Gets the value of the englishRoomNotes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCalendarNote4 }
     *     
     */
    public ArrayOfCalendarNote4 getEnglishRoomNotes() {
        return englishRoomNotes;
    }

    /**
     * Sets the value of the englishRoomNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCalendarNote4 }
     *     
     */
    public void setEnglishRoomNotes(ArrayOfCalendarNote4 value) {
        this.englishRoomNotes = value;
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

}
