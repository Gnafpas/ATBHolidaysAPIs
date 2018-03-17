
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelPost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HotelPost">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hotel.id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="destination_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="resort_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transfer" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="roomtypes" type="{http://xml.sunhotels.net/15/}ArrayOfRoomTypeWithRooms" minOccurs="0"/>
 *         &lt;element name="review" type="{http://xml.sunhotels.net/15/}ReviewValues" minOccurs="0"/>
 *         &lt;element name="notes" type="{http://xml.sunhotels.net/15/}ArrayOfCalendarNote" minOccurs="0"/>
 *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="codes" type="{http://xml.sunhotels.net/15/}ArrayOfCode" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="isPrioritized" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Hotel", propOrder = {
    "hotelId",
    "destinationId",
    "resortId",
    "transfer",
    "roomtypes",
    "review",
    "notes",
    "distance",
    "codes"
})
@XmlSeeAlso({
    StaticHotel.class
})
public class Hotel {

    @XmlElement(name = "hotel.id")
    protected int hotelId;
    @XmlElement(name = "destination_id")
    protected int destinationId;
    @XmlElement(name = "resort_id")
    protected int resortId;
    protected int transfer;
    protected ArrayOfRoomTypeWithRooms roomtypes;
    protected ReviewValues review;
    protected ArrayOfCalendarNote notes;
    @XmlElement(required = true, type = Double.class, nillable = true)
    protected Double distance;
    protected ArrayOfCode codes;
    @XmlAttribute(name = "isPrioritized")
    protected Boolean isPrioritized;

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
     * Gets the value of the destinationId property.
     * 
     */
    public int getDestinationId() {
        return destinationId;
    }

    /**
     * Sets the value of the destinationId property.
     * 
     */
    public void setDestinationId(int value) {
        this.destinationId = value;
    }

    /**
     * Gets the value of the resortId property.
     * 
     */
    public int getResortId() {
        return resortId;
    }

    /**
     * Sets the value of the resortId property.
     * 
     */
    public void setResortId(int value) {
        this.resortId = value;
    }

    /**
     * Gets the value of the transfer property.
     * 
     */
    public int getTransfer() {
        return transfer;
    }

    /**
     * Sets the value of the transfer property.
     * 
     */
    public void setTransfer(int value) {
        this.transfer = value;
    }

    /**
     * Gets the value of the roomtypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomTypeWithRooms }
     *     
     */
    public ArrayOfRoomTypeWithRooms getRoomtypes() {
        return roomtypes;
    }

    /**
     * Sets the value of the roomtypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomTypeWithRooms }
     *     
     */
    public void setRoomtypes(ArrayOfRoomTypeWithRooms value) {
        this.roomtypes = value;
    }

    /**
     * Gets the value of the review property.
     * 
     * @return
     *     possible object is
     *     {@link ReviewValues }
     *     
     */
    public ReviewValues getReview() {
        return review;
    }

    /**
     * Sets the value of the review property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReviewValues }
     *     
     */
    public void setReview(ReviewValues value) {
        this.review = value;
    }

    /**
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCalendarNote }
     *     
     */
    public ArrayOfCalendarNote getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCalendarNote }
     *     
     */
    public void setNotes(ArrayOfCalendarNote value) {
        this.notes = value;
    }

    /**
     * Gets the value of the distance property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDistance(Double value) {
        this.distance = value;
    }

    /**
     * Gets the value of the codes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCode }
     *     
     */
    public ArrayOfCode getCodes() {
        return codes;
    }

    /**
     * Sets the value of the codes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCode }
     *     
     */
    public void setCodes(ArrayOfCode value) {
        this.codes = value;
    }

    /**
     * Gets the value of the isPrioritized property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPrioritized() {
        return isPrioritized;
    }

    /**
     * Sets the value of the isPrioritized property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPrioritized(Boolean value) {
        this.isPrioritized = value;
    }

}
