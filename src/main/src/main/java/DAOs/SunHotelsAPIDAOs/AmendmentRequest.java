
package DAOs.SunHotelsAPIDAOs;

import java.math.BigDecimal;
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
 *         &lt;element name="bookingID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roomId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="checkInDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="checkOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="maxPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bookingType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "bookingID",
    "roomId",
    "checkInDate",
    "checkOutDate",
    "maxPrice",
    "language",
    "bookingType"
})
@XmlRootElement(name = "AmendmentRequest")
public class AmendmentRequest {

    protected String userName;
    protected String password;
    protected String bookingID;
    protected int roomId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkInDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkOutDate;
    @XmlElement(required = true)
    protected BigDecimal maxPrice;
    protected String language;
    protected String bookingType;

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
     * Gets the value of the bookingID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingID() {
        return bookingID;
    }

    /**
     * Sets the value of the bookingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingID(String value) {
        this.bookingID = value;
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
     * Gets the value of the maxPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    /**
     * Sets the value of the maxPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxPrice(BigDecimal value) {
        this.maxPrice = value;
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
     * Gets the value of the bookingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingType() {
        return bookingType;
    }

    /**
     * Sets the value of the bookingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingType(String value) {
        this.bookingType = value;
    }

}
