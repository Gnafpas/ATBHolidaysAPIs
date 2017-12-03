
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetBookingInformationResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBookingInformationResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="bookings" type="{http://xml.sunhotels.net/15/}ArrayOfBookingWithStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBookingInformationResult", propOrder = {
    "bookings"
})
public class GetBookingInformationResult
    extends BaseResult
{

    protected ArrayOfBookingWithStatus bookings;

    /**
     * Gets the value of the bookings property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBookingWithStatus }
     *     
     */
    public ArrayOfBookingWithStatus getBookings() {
        return bookings;
    }

    /**
     * Sets the value of the bookings property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBookingWithStatus }
     *     
     */
    public void setBookings(ArrayOfBookingWithStatus value) {
        this.bookings = value;
    }

}
