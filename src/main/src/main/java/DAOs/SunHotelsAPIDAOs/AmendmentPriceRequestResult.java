
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmendmentPriceRequestResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmendmentPriceRequestResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="Price" type="{http://xml.sunhotels.net/15/}MonetaryValue" minOccurs="0"/>
 *         &lt;element name="RoomId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hotelnotes" type="{http://xml.sunhotels.net/15/}ArrayOfCalendarNote" minOccurs="0"/>
 *         &lt;element name="roomnotes" type="{http://xml.sunhotels.net/15/}ArrayOfCalendarNote" minOccurs="0"/>
 *         &lt;element name="cancellation_policies" type="{http://xml.sunhotels.net/15/}ArrayOfPercentageCancellationPolicy" minOccurs="0"/>
 *         &lt;element name="BookingType" type="{http://xml.sunhotels.net/15/}AmendmentBookingType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendmentPriceRequestResult", propOrder = {
    "price",
    "roomId",
    "hotelnotes",
    "roomnotes",
    "cancellationPolicies",
    "bookingType"
})
public class AmendmentPriceRequestResult
    extends BaseResult
{

    @XmlElement(name = "Price")
    protected MonetaryValue price;
    @XmlElement(name = "RoomId")
    protected int roomId;
    protected ArrayOfCalendarNote hotelnotes;
    protected ArrayOfCalendarNote roomnotes;
    @XmlElement(name = "cancellation_policies")
    protected ArrayOfPercentageCancellationPolicy cancellationPolicies;
    @XmlElement(name = "BookingType", required = true)
    @XmlSchemaType(name = "string")
    protected AmendmentBookingType bookingType;

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link MonetaryValue }
     *     
     */
    public MonetaryValue getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link MonetaryValue }
     *     
     */
    public void setPrice(MonetaryValue value) {
        this.price = value;
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
     * Gets the value of the hotelnotes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCalendarNote }
     *     
     */
    public ArrayOfCalendarNote getHotelnotes() {
        return hotelnotes;
    }

    /**
     * Sets the value of the hotelnotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCalendarNote }
     *     
     */
    public void setHotelnotes(ArrayOfCalendarNote value) {
        this.hotelnotes = value;
    }

    /**
     * Gets the value of the roomnotes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCalendarNote }
     *     
     */
    public ArrayOfCalendarNote getRoomnotes() {
        return roomnotes;
    }

    /**
     * Sets the value of the roomnotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCalendarNote }
     *     
     */
    public void setRoomnotes(ArrayOfCalendarNote value) {
        this.roomnotes = value;
    }

    /**
     * Gets the value of the cancellationPolicies property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPercentageCancellationPolicy }
     *     
     */
    public ArrayOfPercentageCancellationPolicy getCancellationPolicies() {
        return cancellationPolicies;
    }

    /**
     * Sets the value of the cancellationPolicies property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPercentageCancellationPolicy }
     *     
     */
    public void setCancellationPolicies(ArrayOfPercentageCancellationPolicy value) {
        this.cancellationPolicies = value;
    }

    /**
     * Gets the value of the bookingType property.
     * 
     * @return
     *     possible object is
     *     {@link AmendmentBookingType }
     *     
     */
    public AmendmentBookingType getBookingType() {
        return bookingType;
    }

    /**
     * Sets the value of the bookingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendmentBookingType }
     *     
     */
    public void setBookingType(AmendmentBookingType value) {
        this.bookingType = value;
    }

}
