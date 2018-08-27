
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JPSOAP_SuppleOfferPrice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_SuppleOfferPrice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoomTypes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_IntCodeAttr2" minOccurs="0"/>
 *         &lt;element name="Boards" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_IntCodeAttr3" minOccurs="0"/>
 *         &lt;element name="Percent" type="{http://www.juniper.es/webservice/2007/}JPSOAP_Price" minOccurs="0"/>
 *         &lt;element name="Booking" type="{http://www.juniper.es/webservice/2007/}JPSOAP_PriceTyped" minOccurs="0"/>
 *         &lt;element name="Adult" type="{http://www.juniper.es/webservice/2007/}JPSOAP_PriceTyped" minOccurs="0"/>
 *         &lt;element name="Room" type="{http://www.juniper.es/webservice/2007/}JPSOAP_PriceTyped" minOccurs="0"/>
 *         &lt;element name="AdultsAdditionals" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_OrderedTypedPrice" minOccurs="0"/>
 *         &lt;element name="ChildrenA" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_OrderedTypedPrice1" minOccurs="0"/>
 *         &lt;element name="ChildrenB" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_OrderedTypedPrice2" minOccurs="0"/>
 *         &lt;element name="Infants" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_OrderedTypedPrice3" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="From" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="To" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_SuppleOfferPrice", propOrder = {
    "roomTypes",
    "boards",
    "percent",
    "booking",
    "adult",
    "room",
    "adultsAdditionals",
    "childrenA",
    "childrenB",
    "infants"
})
public class JPSOAPSuppleOfferPrice {

    @XmlElement(name = "RoomTypes")
    protected ArrayOfJPSOAPIntCodeAttr2 roomTypes;
    @XmlElement(name = "Boards")
    protected ArrayOfJPSOAPIntCodeAttr3 boards;
    @XmlElement(name = "Percent")
    protected JPSOAPPrice percent;
    @XmlElement(name = "Booking")
    protected JPSOAPPriceTyped booking;
    @XmlElement(name = "Adult")
    protected JPSOAPPriceTyped adult;
    @XmlElement(name = "Room")
    protected JPSOAPPriceTyped room;
    @XmlElement(name = "AdultsAdditionals")
    protected ArrayOfJPSOAPOrderedTypedPrice adultsAdditionals;
    @XmlElement(name = "ChildrenA")
    protected ArrayOfJPSOAPOrderedTypedPrice1 childrenA;
    @XmlElement(name = "ChildrenB")
    protected ArrayOfJPSOAPOrderedTypedPrice2 childrenB;
    @XmlElement(name = "Infants")
    protected ArrayOfJPSOAPOrderedTypedPrice3 infants;
    @XmlAttribute(name = "From")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar from;
    @XmlAttribute(name = "To")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar to;

    /**
     * Gets the value of the roomTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPIntCodeAttr2 }
     *     
     */
    public ArrayOfJPSOAPIntCodeAttr2 getRoomTypes() {
        return roomTypes;
    }

    /**
     * Sets the value of the roomTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPIntCodeAttr2 }
     *     
     */
    public void setRoomTypes(ArrayOfJPSOAPIntCodeAttr2 value) {
        this.roomTypes = value;
    }

    /**
     * Gets the value of the boards property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPIntCodeAttr3 }
     *     
     */
    public ArrayOfJPSOAPIntCodeAttr3 getBoards() {
        return boards;
    }

    /**
     * Sets the value of the boards property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPIntCodeAttr3 }
     *     
     */
    public void setBoards(ArrayOfJPSOAPIntCodeAttr3 value) {
        this.boards = value;
    }

    /**
     * Gets the value of the percent property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPPrice }
     *     
     */
    public JPSOAPPrice getPercent() {
        return percent;
    }

    /**
     * Sets the value of the percent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPPrice }
     *     
     */
    public void setPercent(JPSOAPPrice value) {
        this.percent = value;
    }

    /**
     * Gets the value of the booking property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPPriceTyped }
     *     
     */
    public JPSOAPPriceTyped getBooking() {
        return booking;
    }

    /**
     * Sets the value of the booking property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPPriceTyped }
     *     
     */
    public void setBooking(JPSOAPPriceTyped value) {
        this.booking = value;
    }

    /**
     * Gets the value of the adult property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPPriceTyped }
     *     
     */
    public JPSOAPPriceTyped getAdult() {
        return adult;
    }

    /**
     * Sets the value of the adult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPPriceTyped }
     *     
     */
    public void setAdult(JPSOAPPriceTyped value) {
        this.adult = value;
    }

    /**
     * Gets the value of the room property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPPriceTyped }
     *     
     */
    public JPSOAPPriceTyped getRoom() {
        return room;
    }

    /**
     * Sets the value of the room property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPPriceTyped }
     *     
     */
    public void setRoom(JPSOAPPriceTyped value) {
        this.room = value;
    }

    /**
     * Gets the value of the adultsAdditionals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPOrderedTypedPrice }
     *     
     */
    public ArrayOfJPSOAPOrderedTypedPrice getAdultsAdditionals() {
        return adultsAdditionals;
    }

    /**
     * Sets the value of the adultsAdditionals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPOrderedTypedPrice }
     *     
     */
    public void setAdultsAdditionals(ArrayOfJPSOAPOrderedTypedPrice value) {
        this.adultsAdditionals = value;
    }

    /**
     * Gets the value of the childrenA property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPOrderedTypedPrice1 }
     *     
     */
    public ArrayOfJPSOAPOrderedTypedPrice1 getChildrenA() {
        return childrenA;
    }

    /**
     * Sets the value of the childrenA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPOrderedTypedPrice1 }
     *     
     */
    public void setChildrenA(ArrayOfJPSOAPOrderedTypedPrice1 value) {
        this.childrenA = value;
    }

    /**
     * Gets the value of the childrenB property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPOrderedTypedPrice2 }
     *     
     */
    public ArrayOfJPSOAPOrderedTypedPrice2 getChildrenB() {
        return childrenB;
    }

    /**
     * Sets the value of the childrenB property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPOrderedTypedPrice2 }
     *     
     */
    public void setChildrenB(ArrayOfJPSOAPOrderedTypedPrice2 value) {
        this.childrenB = value;
    }

    /**
     * Gets the value of the infants property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPOrderedTypedPrice3 }
     *     
     */
    public ArrayOfJPSOAPOrderedTypedPrice3 getInfants() {
        return infants;
    }

    /**
     * Sets the value of the infants property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPOrderedTypedPrice3 }
     *     
     */
    public void setInfants(ArrayOfJPSOAPOrderedTypedPrice3 value) {
        this.infants = value;
    }

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrom(XMLGregorianCalendar value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTo(XMLGregorianCalendar value) {
        this.to = value;
    }

}
