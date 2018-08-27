
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_RatePrice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_RatePrice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Adult" type="{http://www.juniper.es/webservice/2007/}JPSOAP_Price" minOccurs="0"/>
 *         &lt;element name="Room" type="{http://www.juniper.es/webservice/2007/}JPSOAP_Price" minOccurs="0"/>
 *         &lt;element name="AdultAdditionals" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_OrderedPrice" minOccurs="0"/>
 *         &lt;element name="ChildrenA" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_OrderedPrice1" minOccurs="0"/>
 *         &lt;element name="ChildrenB" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_OrderedPrice2" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="BoardCode" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="RoomTypeCode" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_RatePrice", propOrder = {
    "adult",
    "room",
    "adultAdditionals",
    "childrenA",
    "childrenB"
})
public class JPSOAPRatePrice {

    @XmlElement(name = "Adult")
    protected JPSOAPPrice adult;
    @XmlElement(name = "Room")
    protected JPSOAPPrice room;
    @XmlElement(name = "AdultAdditionals")
    protected ArrayOfJPSOAPOrderedPrice adultAdditionals;
    @XmlElement(name = "ChildrenA")
    protected ArrayOfJPSOAPOrderedPrice1 childrenA;
    @XmlElement(name = "ChildrenB")
    protected ArrayOfJPSOAPOrderedPrice2 childrenB;
    @XmlAttribute(name = "BoardCode", required = true)
    protected int boardCode;
    @XmlAttribute(name = "RoomTypeCode", required = true)
    protected int roomTypeCode;

    /**
     * Gets the value of the adult property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPPrice }
     *     
     */
    public JPSOAPPrice getAdult() {
        return adult;
    }

    /**
     * Sets the value of the adult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPPrice }
     *     
     */
    public void setAdult(JPSOAPPrice value) {
        this.adult = value;
    }

    /**
     * Gets the value of the room property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPPrice }
     *     
     */
    public JPSOAPPrice getRoom() {
        return room;
    }

    /**
     * Sets the value of the room property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPPrice }
     *     
     */
    public void setRoom(JPSOAPPrice value) {
        this.room = value;
    }

    /**
     * Gets the value of the adultAdditionals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPOrderedPrice }
     *     
     */
    public ArrayOfJPSOAPOrderedPrice getAdultAdditionals() {
        return adultAdditionals;
    }

    /**
     * Sets the value of the adultAdditionals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPOrderedPrice }
     *     
     */
    public void setAdultAdditionals(ArrayOfJPSOAPOrderedPrice value) {
        this.adultAdditionals = value;
    }

    /**
     * Gets the value of the childrenA property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPOrderedPrice1 }
     *     
     */
    public ArrayOfJPSOAPOrderedPrice1 getChildrenA() {
        return childrenA;
    }

    /**
     * Sets the value of the childrenA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPOrderedPrice1 }
     *     
     */
    public void setChildrenA(ArrayOfJPSOAPOrderedPrice1 value) {
        this.childrenA = value;
    }

    /**
     * Gets the value of the childrenB property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPOrderedPrice2 }
     *     
     */
    public ArrayOfJPSOAPOrderedPrice2 getChildrenB() {
        return childrenB;
    }

    /**
     * Sets the value of the childrenB property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPOrderedPrice2 }
     *     
     */
    public void setChildrenB(ArrayOfJPSOAPOrderedPrice2 value) {
        this.childrenB = value;
    }

    /**
     * Gets the value of the boardCode property.
     * 
     */
    public int getBoardCode() {
        return boardCode;
    }

    /**
     * Sets the value of the boardCode property.
     * 
     */
    public void setBoardCode(int value) {
        this.boardCode = value;
    }

    /**
     * Gets the value of the roomTypeCode property.
     * 
     */
    public int getRoomTypeCode() {
        return roomTypeCode;
    }

    /**
     * Sets the value of the roomTypeCode property.
     * 
     */
    public void setRoomTypeCode(int value) {
        this.roomTypeCode = value;
    }

}
