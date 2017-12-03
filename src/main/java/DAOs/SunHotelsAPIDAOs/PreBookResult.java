
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PreBookResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PreBookResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="RoomId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Notes" type="{http://xml.sunhotels.net/15/}ArrayOfCalendarNote5" minOccurs="0"/>
 *         &lt;element name="PreBookCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Price" type="{http://xml.sunhotels.net/15/}MonetaryValue" minOccurs="0"/>
 *         &lt;element name="PriceBreakdown" type="{http://xml.sunhotels.net/15/}PriceBreakdownResult" minOccurs="0"/>
 *         &lt;element name="CancellationPolicies" type="{http://xml.sunhotels.net/15/}ArrayOfStaticPercentageCancellationPolicy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PreBookResult", propOrder = {
    "roomId",
    "notes",
    "preBookCode",
    "price",
    "priceBreakdown",
    "cancellationPolicies"
})
public class PreBookResult
    extends BaseResult
{

    @XmlElement(name = "RoomId")
    protected String roomId;
    @XmlElement(name = "Notes")
    protected ArrayOfCalendarNote5 notes;
    @XmlElement(name = "PreBookCode")
    protected String preBookCode;
    @XmlElement(name = "Price")
    protected MonetaryValue price;
    @XmlElement(name = "PriceBreakdown")
    protected PriceBreakdownResult priceBreakdown;
    @XmlElement(name = "CancellationPolicies")
    protected ArrayOfStaticPercentageCancellationPolicy cancellationPolicies;

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
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCalendarNote5 }
     *     
     */
    public ArrayOfCalendarNote5 getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCalendarNote5 }
     *     
     */
    public void setNotes(ArrayOfCalendarNote5 value) {
        this.notes = value;
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
     * Gets the value of the priceBreakdown property.
     * 
     * @return
     *     possible object is
     *     {@link PriceBreakdownResult }
     *     
     */
    public PriceBreakdownResult getPriceBreakdown() {
        return priceBreakdown;
    }

    /**
     * Sets the value of the priceBreakdown property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceBreakdownResult }
     *     
     */
    public void setPriceBreakdown(PriceBreakdownResult value) {
        this.priceBreakdown = value;
    }

    /**
     * Gets the value of the cancellationPolicies property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfStaticPercentageCancellationPolicy }
     *     
     */
    public ArrayOfStaticPercentageCancellationPolicy getCancellationPolicies() {
        return cancellationPolicies;
    }

    /**
     * Sets the value of the cancellationPolicies property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfStaticPercentageCancellationPolicy }
     *     
     */
    public void setCancellationPolicies(ArrayOfStaticPercentageCancellationPolicy value) {
        this.cancellationPolicies = value;
    }

}
