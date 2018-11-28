
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetTransferBookingInformationResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetTransferBookingInformationResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="transferBookings" type="{http://xml.sunhotels.net/15/}ArrayOfTransferBooking" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTransferBookingInformationResult", propOrder = {
    "transferBookings"
})
public class GetTransferBookingInformationResult
    extends BaseResult
{

    protected ArrayOfTransferBooking transferBookings;

    /**
     * Gets the value of the transferBookings property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTransferBooking }
     *     
     */
    public ArrayOfTransferBooking getTransferBookings() {
        return transferBookings;
    }

    /**
     * Sets the value of the transferBookings property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTransferBooking }
     *     
     */
    public void setTransferBookings(ArrayOfTransferBooking value) {
        this.transferBookings = value;
    }

}
