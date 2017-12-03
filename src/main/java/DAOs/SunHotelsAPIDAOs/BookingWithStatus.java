
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for BookingWithStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BookingWithStatus">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}Booking">
 *       &lt;sequence>
 *         &lt;element name="bookingStatus" type="{http://xml.sunhotels.net/15/}BookingStatus"/>
 *         &lt;element name="currentCancellationPolicyFee" type="{http://xml.sunhotels.net/15/}ArrayOfPriceWithPaymentMethods1" minOccurs="0"/>
 *         &lt;element name="currentCancellationPolicyDeadline" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BookingWithStatus", propOrder = {
    "bookingStatus",
    "currentCancellationPolicyFee",
    "currentCancellationPolicyDeadline"
})
public class BookingWithStatus
    extends Booking
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected BookingStatus bookingStatus;
    protected ArrayOfPriceWithPaymentMethods1 currentCancellationPolicyFee;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar currentCancellationPolicyDeadline;

    /**
     * Gets the value of the bookingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link BookingStatus }
     *     
     */
    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    /**
     * Sets the value of the bookingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookingStatus }
     *     
     */
    public void setBookingStatus(BookingStatus value) {
        this.bookingStatus = value;
    }

    /**
     * Gets the value of the currentCancellationPolicyFee property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPriceWithPaymentMethods1 }
     *     
     */
    public ArrayOfPriceWithPaymentMethods1 getCurrentCancellationPolicyFee() {
        return currentCancellationPolicyFee;
    }

    /**
     * Sets the value of the currentCancellationPolicyFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPriceWithPaymentMethods1 }
     *     
     */
    public void setCurrentCancellationPolicyFee(ArrayOfPriceWithPaymentMethods1 value) {
        this.currentCancellationPolicyFee = value;
    }

    /**
     * Gets the value of the currentCancellationPolicyDeadline property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCurrentCancellationPolicyDeadline() {
        return currentCancellationPolicyDeadline;
    }

    /**
     * Sets the value of the currentCancellationPolicyDeadline property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCurrentCancellationPolicyDeadline(XMLGregorianCalendar value) {
        this.currentCancellationPolicyDeadline = value;
    }

}
