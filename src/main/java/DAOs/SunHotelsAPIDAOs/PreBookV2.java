
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
 *         &lt;element name="checkInDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="checkOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="rooms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="adults" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="children" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="childrenAges" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="infant" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mealId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="customerCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="b2c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="searchPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roomId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotelId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roomtypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="blockSuperDeal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="showPriceBreakdown" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "checkInDate",
    "checkOutDate",
    "rooms",
    "adults",
    "children",
    "childrenAges",
    "infant",
    "mealId",
    "customerCountry",
    "b2C",
    "searchPrice",
    "roomId",
    "hotelId",
    "roomtypeId",
    "blockSuperDeal",
    "showPriceBreakdown"
})
@XmlRootElement(name = "PreBookV2")
public class PreBookV2 {

    protected String userName;
    protected String password;
    protected String currency;
    protected String language;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkInDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkOutDate;
    protected int rooms;
    protected int adults;
    protected int children;
    protected String childrenAges;
    protected int infant;
    protected int mealId;
    protected String customerCountry;
    @XmlElement(name = "b2c")
    protected String b2C;
    protected String searchPrice;
    protected String roomId;
    protected String hotelId;
    protected String roomtypeId;
    protected String blockSuperDeal;
    protected String showPriceBreakdown;

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
     * Gets the value of the childrenAges property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenAges() {
        return childrenAges;
    }

    /**
     * Sets the value of the childrenAges property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenAges(String value) {
        this.childrenAges = value;
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
     * Gets the value of the searchPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchPrice() {
        return searchPrice;
    }

    /**
     * Sets the value of the searchPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchPrice(String value) {
        this.searchPrice = value;
    }

    /**
     * Gets the value of the roomId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * Sets the value of the roomId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomId(String value) {
        this.roomId = value;
    }

    /**
     * Gets the value of the hotelId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelId() {
        return hotelId;
    }

    /**
     * Sets the value of the hotelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelId(String value) {
        this.hotelId = value;
    }

    /**
     * Gets the value of the roomtypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomtypeId() {
        return roomtypeId;
    }

    /**
     * Sets the value of the roomtypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomtypeId(String value) {
        this.roomtypeId = value;
    }

    /**
     * Gets the value of the blockSuperDeal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockSuperDeal() {
        return blockSuperDeal;
    }

    /**
     * Sets the value of the blockSuperDeal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockSuperDeal(String value) {
        this.blockSuperDeal = value;
    }

    /**
     * Gets the value of the showPriceBreakdown property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShowPriceBreakdown() {
        return showPriceBreakdown;
    }

    /**
     * Sets the value of the showPriceBreakdown property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShowPriceBreakdown(String value) {
        this.showPriceBreakdown = value;
    }

}
