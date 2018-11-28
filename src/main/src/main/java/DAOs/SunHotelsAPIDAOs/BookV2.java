
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="checkInDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="checkOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="roomId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rooms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="adults" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="children" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="infant" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="yourRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specialrequest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mealId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="adultGuest1FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest1LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest2FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest2LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest3FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest3LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest4FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest4LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest5FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest5LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest6FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest6LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest7FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest7LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest8FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest8LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest9FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adultGuest9LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest1FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest1LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuestAge1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest2FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest2LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuestAge2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest3FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest3LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuestAge3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest4FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest4LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuestAge4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest5FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest5LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuestAge5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest6FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest6LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuestAge6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest7FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest7LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuestAge7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest8FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest8LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuestAge8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest9FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuest9LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childrenGuestAge9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentMethodId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creditCardType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditCardNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditCardHolder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditCardCVV2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditCardExpYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditCardExpMonth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="b2c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commissionAmountInHotelCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preBookCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userName",
    "password",
    "currency",
    "language",
    "email",
    "checkInDate",
    "checkOutDate",
    "roomId",
    "rooms",
    "adults",
    "children",
    "infant",
    "yourRef",
    "specialrequest",
    "mealId",
    "adultGuest1FirstName",
    "adultGuest1LastName",
    "adultGuest2FirstName",
    "adultGuest2LastName",
    "adultGuest3FirstName",
    "adultGuest3LastName",
    "adultGuest4FirstName",
    "adultGuest4LastName",
    "adultGuest5FirstName",
    "adultGuest5LastName",
    "adultGuest6FirstName",
    "adultGuest6LastName",
    "adultGuest7FirstName",
    "adultGuest7LastName",
    "adultGuest8FirstName",
    "adultGuest8LastName",
    "adultGuest9FirstName",
    "adultGuest9LastName",
    "childrenGuest1FirstName",
    "childrenGuest1LastName",
    "childrenGuestAge1",
    "childrenGuest2FirstName",
    "childrenGuest2LastName",
    "childrenGuestAge2",
    "childrenGuest3FirstName",
    "childrenGuest3LastName",
    "childrenGuestAge3",
    "childrenGuest4FirstName",
    "childrenGuest4LastName",
    "childrenGuestAge4",
    "childrenGuest5FirstName",
    "childrenGuest5LastName",
    "childrenGuestAge5",
    "childrenGuest6FirstName",
    "childrenGuest6LastName",
    "childrenGuestAge6",
    "childrenGuest7FirstName",
    "childrenGuest7LastName",
    "childrenGuestAge7",
    "childrenGuest8FirstName",
    "childrenGuest8LastName",
    "childrenGuestAge8",
    "childrenGuest9FirstName",
    "childrenGuest9LastName",
    "childrenGuestAge9",
    "paymentMethodId",
    "creditCardType",
    "creditCardNumber",
    "creditCardHolder",
    "creditCardCVV2",
    "creditCardExpYear",
    "creditCardExpMonth",
    "customerEmail",
    "invoiceRef",
    "customerCountry",
    "b2C",
    "commissionAmountInHotelCurrency",
    "preBookCode"
})
@XmlRootElement(name = "BookV2")
public class BookV2 {

    protected String userName;
    protected String password;
    protected String currency;
    protected String language;
    protected String email;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkInDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkOutDate;
    protected int roomId;
    protected int rooms;
    protected int adults;
    protected int children;
    protected int infant;
    protected String yourRef;
    protected String specialrequest;
    protected int mealId;
    protected String adultGuest1FirstName;
    protected String adultGuest1LastName;
    protected String adultGuest2FirstName;
    protected String adultGuest2LastName;
    protected String adultGuest3FirstName;
    protected String adultGuest3LastName;
    protected String adultGuest4FirstName;
    protected String adultGuest4LastName;
    protected String adultGuest5FirstName;
    protected String adultGuest5LastName;
    protected String adultGuest6FirstName;
    protected String adultGuest6LastName;
    protected String adultGuest7FirstName;
    protected String adultGuest7LastName;
    protected String adultGuest8FirstName;
    protected String adultGuest8LastName;
    protected String adultGuest9FirstName;
    protected String adultGuest9LastName;
    protected String childrenGuest1FirstName;
    protected String childrenGuest1LastName;
    protected String childrenGuestAge1;
    protected String childrenGuest2FirstName;
    protected String childrenGuest2LastName;
    protected String childrenGuestAge2;
    protected String childrenGuest3FirstName;
    protected String childrenGuest3LastName;
    protected String childrenGuestAge3;
    protected String childrenGuest4FirstName;
    protected String childrenGuest4LastName;
    protected String childrenGuestAge4;
    protected String childrenGuest5FirstName;
    protected String childrenGuest5LastName;
    protected String childrenGuestAge5;
    protected String childrenGuest6FirstName;
    protected String childrenGuest6LastName;
    protected String childrenGuestAge6;
    protected String childrenGuest7FirstName;
    protected String childrenGuest7LastName;
    protected String childrenGuestAge7;
    protected String childrenGuest8FirstName;
    protected String childrenGuest8LastName;
    protected String childrenGuestAge8;
    protected String childrenGuest9FirstName;
    protected String childrenGuest9LastName;
    protected String childrenGuestAge9;
    protected int paymentMethodId;
    protected String creditCardType;
    protected String creditCardNumber;
    protected String creditCardHolder;
    protected String creditCardCVV2;
    protected String creditCardExpYear;
    protected String creditCardExpMonth;
    protected String customerEmail;
    protected String invoiceRef;
    protected String customerCountry;
    @XmlElement(name = "b2c")
    protected String b2C;
    protected String commissionAmountInHotelCurrency;
    protected String preBookCode;

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
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
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the checkInDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckInDate() {
        return checkInDate;
    }

    /**
     * Sets the value of the checkInDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckInDate(XMLGregorianCalendar value) {
        this.checkInDate = value;
    }

    /**
     * Gets the value of the checkOutDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Sets the value of the checkOutDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckOutDate(XMLGregorianCalendar value) {
        this.checkOutDate = value;
    }

    /**
     * Gets the value of the roomId property.
     * 
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * Sets the value of the roomId property.
     * 
     */
    public void setRoomId(int value) {
        this.roomId = value;
    }

    /**
     * Gets the value of the rooms property.
     * 
     */
    public int getRooms() {
        return rooms;
    }

    /**
     * Sets the value of the rooms property.
     * 
     */
    public void setRooms(int value) {
        this.rooms = value;
    }

    /**
     * Gets the value of the adults property.
     * 
     */
    public int getAdults() {
        return adults;
    }

    /**
     * Sets the value of the adults property.
     * 
     */
    public void setAdults(int value) {
        this.adults = value;
    }

    /**
     * Gets the value of the children property.
     * 
     */
    public int getChildren() {
        return children;
    }

    /**
     * Sets the value of the children property.
     * 
     */
    public void setChildren(int value) {
        this.children = value;
    }

    /**
     * Gets the value of the infant property.
     * 
     */
    public int getInfant() {
        return infant;
    }

    /**
     * Sets the value of the infant property.
     * 
     */
    public void setInfant(int value) {
        this.infant = value;
    }

    /**
     * Gets the value of the yourRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYourRef() {
        return yourRef;
    }

    /**
     * Sets the value of the yourRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYourRef(String value) {
        this.yourRef = value;
    }

    /**
     * Gets the value of the specialrequest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialrequest() {
        return specialrequest;
    }

    /**
     * Sets the value of the specialrequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialrequest(String value) {
        this.specialrequest = value;
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
     * Gets the value of the adultGuest1FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest1FirstName() {
        return adultGuest1FirstName;
    }

    /**
     * Sets the value of the adultGuest1FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest1FirstName(String value) {
        this.adultGuest1FirstName = value;
    }

    /**
     * Gets the value of the adultGuest1LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest1LastName() {
        return adultGuest1LastName;
    }

    /**
     * Sets the value of the adultGuest1LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest1LastName(String value) {
        this.adultGuest1LastName = value;
    }

    /**
     * Gets the value of the adultGuest2FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest2FirstName() {
        return adultGuest2FirstName;
    }

    /**
     * Sets the value of the adultGuest2FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest2FirstName(String value) {
        this.adultGuest2FirstName = value;
    }

    /**
     * Gets the value of the adultGuest2LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest2LastName() {
        return adultGuest2LastName;
    }

    /**
     * Sets the value of the adultGuest2LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest2LastName(String value) {
        this.adultGuest2LastName = value;
    }

    /**
     * Gets the value of the adultGuest3FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest3FirstName() {
        return adultGuest3FirstName;
    }

    /**
     * Sets the value of the adultGuest3FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest3FirstName(String value) {
        this.adultGuest3FirstName = value;
    }

    /**
     * Gets the value of the adultGuest3LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest3LastName() {
        return adultGuest3LastName;
    }

    /**
     * Sets the value of the adultGuest3LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest3LastName(String value) {
        this.adultGuest3LastName = value;
    }

    /**
     * Gets the value of the adultGuest4FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest4FirstName() {
        return adultGuest4FirstName;
    }

    /**
     * Sets the value of the adultGuest4FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest4FirstName(String value) {
        this.adultGuest4FirstName = value;
    }

    /**
     * Gets the value of the adultGuest4LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest4LastName() {
        return adultGuest4LastName;
    }

    /**
     * Sets the value of the adultGuest4LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest4LastName(String value) {
        this.adultGuest4LastName = value;
    }

    /**
     * Gets the value of the adultGuest5FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest5FirstName() {
        return adultGuest5FirstName;
    }

    /**
     * Sets the value of the adultGuest5FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest5FirstName(String value) {
        this.adultGuest5FirstName = value;
    }

    /**
     * Gets the value of the adultGuest5LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest5LastName() {
        return adultGuest5LastName;
    }

    /**
     * Sets the value of the adultGuest5LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest5LastName(String value) {
        this.adultGuest5LastName = value;
    }

    /**
     * Gets the value of the adultGuest6FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest6FirstName() {
        return adultGuest6FirstName;
    }

    /**
     * Sets the value of the adultGuest6FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest6FirstName(String value) {
        this.adultGuest6FirstName = value;
    }

    /**
     * Gets the value of the adultGuest6LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest6LastName() {
        return adultGuest6LastName;
    }

    /**
     * Sets the value of the adultGuest6LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest6LastName(String value) {
        this.adultGuest6LastName = value;
    }

    /**
     * Gets the value of the adultGuest7FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest7FirstName() {
        return adultGuest7FirstName;
    }

    /**
     * Sets the value of the adultGuest7FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest7FirstName(String value) {
        this.adultGuest7FirstName = value;
    }

    /**
     * Gets the value of the adultGuest7LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest7LastName() {
        return adultGuest7LastName;
    }

    /**
     * Sets the value of the adultGuest7LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest7LastName(String value) {
        this.adultGuest7LastName = value;
    }

    /**
     * Gets the value of the adultGuest8FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest8FirstName() {
        return adultGuest8FirstName;
    }

    /**
     * Sets the value of the adultGuest8FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest8FirstName(String value) {
        this.adultGuest8FirstName = value;
    }

    /**
     * Gets the value of the adultGuest8LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest8LastName() {
        return adultGuest8LastName;
    }

    /**
     * Sets the value of the adultGuest8LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest8LastName(String value) {
        this.adultGuest8LastName = value;
    }

    /**
     * Gets the value of the adultGuest9FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest9FirstName() {
        return adultGuest9FirstName;
    }

    /**
     * Sets the value of the adultGuest9FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest9FirstName(String value) {
        this.adultGuest9FirstName = value;
    }

    /**
     * Gets the value of the adultGuest9LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdultGuest9LastName() {
        return adultGuest9LastName;
    }

    /**
     * Sets the value of the adultGuest9LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdultGuest9LastName(String value) {
        this.adultGuest9LastName = value;
    }

    /**
     * Gets the value of the childrenGuest1FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest1FirstName() {
        return childrenGuest1FirstName;
    }

    /**
     * Sets the value of the childrenGuest1FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest1FirstName(String value) {
        this.childrenGuest1FirstName = value;
    }

    /**
     * Gets the value of the childrenGuest1LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest1LastName() {
        return childrenGuest1LastName;
    }

    /**
     * Sets the value of the childrenGuest1LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest1LastName(String value) {
        this.childrenGuest1LastName = value;
    }

    /**
     * Gets the value of the childrenGuestAge1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuestAge1() {
        return childrenGuestAge1;
    }

    /**
     * Sets the value of the childrenGuestAge1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuestAge1(String value) {
        this.childrenGuestAge1 = value;
    }

    /**
     * Gets the value of the childrenGuest2FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest2FirstName() {
        return childrenGuest2FirstName;
    }

    /**
     * Sets the value of the childrenGuest2FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest2FirstName(String value) {
        this.childrenGuest2FirstName = value;
    }

    /**
     * Gets the value of the childrenGuest2LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest2LastName() {
        return childrenGuest2LastName;
    }

    /**
     * Sets the value of the childrenGuest2LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest2LastName(String value) {
        this.childrenGuest2LastName = value;
    }

    /**
     * Gets the value of the childrenGuestAge2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuestAge2() {
        return childrenGuestAge2;
    }

    /**
     * Sets the value of the childrenGuestAge2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuestAge2(String value) {
        this.childrenGuestAge2 = value;
    }

    /**
     * Gets the value of the childrenGuest3FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest3FirstName() {
        return childrenGuest3FirstName;
    }

    /**
     * Sets the value of the childrenGuest3FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest3FirstName(String value) {
        this.childrenGuest3FirstName = value;
    }

    /**
     * Gets the value of the childrenGuest3LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest3LastName() {
        return childrenGuest3LastName;
    }

    /**
     * Sets the value of the childrenGuest3LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest3LastName(String value) {
        this.childrenGuest3LastName = value;
    }

    /**
     * Gets the value of the childrenGuestAge3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuestAge3() {
        return childrenGuestAge3;
    }

    /**
     * Sets the value of the childrenGuestAge3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuestAge3(String value) {
        this.childrenGuestAge3 = value;
    }

    /**
     * Gets the value of the childrenGuest4FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest4FirstName() {
        return childrenGuest4FirstName;
    }

    /**
     * Sets the value of the childrenGuest4FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest4FirstName(String value) {
        this.childrenGuest4FirstName = value;
    }

    /**
     * Gets the value of the childrenGuest4LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest4LastName() {
        return childrenGuest4LastName;
    }

    /**
     * Sets the value of the childrenGuest4LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest4LastName(String value) {
        this.childrenGuest4LastName = value;
    }

    /**
     * Gets the value of the childrenGuestAge4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuestAge4() {
        return childrenGuestAge4;
    }

    /**
     * Sets the value of the childrenGuestAge4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuestAge4(String value) {
        this.childrenGuestAge4 = value;
    }

    /**
     * Gets the value of the childrenGuest5FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest5FirstName() {
        return childrenGuest5FirstName;
    }

    /**
     * Sets the value of the childrenGuest5FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest5FirstName(String value) {
        this.childrenGuest5FirstName = value;
    }

    /**
     * Gets the value of the childrenGuest5LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest5LastName() {
        return childrenGuest5LastName;
    }

    /**
     * Sets the value of the childrenGuest5LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest5LastName(String value) {
        this.childrenGuest5LastName = value;
    }

    /**
     * Gets the value of the childrenGuestAge5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuestAge5() {
        return childrenGuestAge5;
    }

    /**
     * Sets the value of the childrenGuestAge5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuestAge5(String value) {
        this.childrenGuestAge5 = value;
    }

    /**
     * Gets the value of the childrenGuest6FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest6FirstName() {
        return childrenGuest6FirstName;
    }

    /**
     * Sets the value of the childrenGuest6FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest6FirstName(String value) {
        this.childrenGuest6FirstName = value;
    }

    /**
     * Gets the value of the childrenGuest6LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest6LastName() {
        return childrenGuest6LastName;
    }

    /**
     * Sets the value of the childrenGuest6LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest6LastName(String value) {
        this.childrenGuest6LastName = value;
    }

    /**
     * Gets the value of the childrenGuestAge6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuestAge6() {
        return childrenGuestAge6;
    }

    /**
     * Sets the value of the childrenGuestAge6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuestAge6(String value) {
        this.childrenGuestAge6 = value;
    }

    /**
     * Gets the value of the childrenGuest7FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest7FirstName() {
        return childrenGuest7FirstName;
    }

    /**
     * Sets the value of the childrenGuest7FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest7FirstName(String value) {
        this.childrenGuest7FirstName = value;
    }

    /**
     * Gets the value of the childrenGuest7LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest7LastName() {
        return childrenGuest7LastName;
    }

    /**
     * Sets the value of the childrenGuest7LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest7LastName(String value) {
        this.childrenGuest7LastName = value;
    }

    /**
     * Gets the value of the childrenGuestAge7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuestAge7() {
        return childrenGuestAge7;
    }

    /**
     * Sets the value of the childrenGuestAge7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuestAge7(String value) {
        this.childrenGuestAge7 = value;
    }

    /**
     * Gets the value of the childrenGuest8FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest8FirstName() {
        return childrenGuest8FirstName;
    }

    /**
     * Sets the value of the childrenGuest8FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest8FirstName(String value) {
        this.childrenGuest8FirstName = value;
    }

    /**
     * Gets the value of the childrenGuest8LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest8LastName() {
        return childrenGuest8LastName;
    }

    /**
     * Sets the value of the childrenGuest8LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest8LastName(String value) {
        this.childrenGuest8LastName = value;
    }

    /**
     * Gets the value of the childrenGuestAge8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuestAge8() {
        return childrenGuestAge8;
    }

    /**
     * Sets the value of the childrenGuestAge8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuestAge8(String value) {
        this.childrenGuestAge8 = value;
    }

    /**
     * Gets the value of the childrenGuest9FirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest9FirstName() {
        return childrenGuest9FirstName;
    }

    /**
     * Sets the value of the childrenGuest9FirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest9FirstName(String value) {
        this.childrenGuest9FirstName = value;
    }

    /**
     * Gets the value of the childrenGuest9LastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuest9LastName() {
        return childrenGuest9LastName;
    }

    /**
     * Sets the value of the childrenGuest9LastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuest9LastName(String value) {
        this.childrenGuest9LastName = value;
    }

    /**
     * Gets the value of the childrenGuestAge9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenGuestAge9() {
        return childrenGuestAge9;
    }

    /**
     * Sets the value of the childrenGuestAge9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenGuestAge9(String value) {
        this.childrenGuestAge9 = value;
    }

    /**
     * Gets the value of the paymentMethodId property.
     * 
     */
    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    /**
     * Sets the value of the paymentMethodId property.
     * 
     */
    public void setPaymentMethodId(int value) {
        this.paymentMethodId = value;
    }

    /**
     * Gets the value of the creditCardType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCardType() {
        return creditCardType;
    }

    /**
     * Sets the value of the creditCardType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCardType(String value) {
        this.creditCardType = value;
    }

    /**
     * Gets the value of the creditCardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Sets the value of the creditCardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCardNumber(String value) {
        this.creditCardNumber = value;
    }

    /**
     * Gets the value of the creditCardHolder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCardHolder() {
        return creditCardHolder;
    }

    /**
     * Sets the value of the creditCardHolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCardHolder(String value) {
        this.creditCardHolder = value;
    }

    /**
     * Gets the value of the creditCardCVV2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCardCVV2() {
        return creditCardCVV2;
    }

    /**
     * Sets the value of the creditCardCVV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCardCVV2(String value) {
        this.creditCardCVV2 = value;
    }

    /**
     * Gets the value of the creditCardExpYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCardExpYear() {
        return creditCardExpYear;
    }

    /**
     * Sets the value of the creditCardExpYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCardExpYear(String value) {
        this.creditCardExpYear = value;
    }

    /**
     * Gets the value of the creditCardExpMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCardExpMonth() {
        return creditCardExpMonth;
    }

    /**
     * Sets the value of the creditCardExpMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCardExpMonth(String value) {
        this.creditCardExpMonth = value;
    }

    /**
     * Gets the value of the customerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Sets the value of the customerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerEmail(String value) {
        this.customerEmail = value;
    }

    /**
     * Gets the value of the invoiceRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceRef() {
        return invoiceRef;
    }

    /**
     * Sets the value of the invoiceRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceRef(String value) {
        this.invoiceRef = value;
    }

    /**
     * Gets the value of the customerCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerCountry() {
        return customerCountry;
    }

    /**
     * Sets the value of the customerCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerCountry(String value) {
        this.customerCountry = value;
    }

    /**
     * Gets the value of the b2C property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getB2C() {
        return b2C;
    }

    /**
     * Sets the value of the b2C property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setB2C(String value) {
        this.b2C = value;
    }

    /**
     * Gets the value of the commissionAmountInHotelCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommissionAmountInHotelCurrency() {
        return commissionAmountInHotelCurrency;
    }

    /**
     * Sets the value of the commissionAmountInHotelCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommissionAmountInHotelCurrency(String value) {
        this.commissionAmountInHotelCurrency = value;
    }

    /**
     * Gets the value of the preBookCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreBookCode() {
        return preBookCode;
    }

    /**
     * Sets the value of the preBookCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreBookCode(String value) {
        this.preBookCode = value;
    }

}
