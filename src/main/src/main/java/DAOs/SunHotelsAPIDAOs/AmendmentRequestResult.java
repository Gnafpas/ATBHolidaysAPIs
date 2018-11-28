
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmendmentRequestResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmendmentRequestResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="AmendmentBooking" type="{http://xml.sunhotels.net/15/}BookingWithStatus" minOccurs="0"/>
 *         &lt;element name="OriginalBooking" type="{http://xml.sunhotels.net/15/}BookingWithStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendmentRequestResult", propOrder = {
    "amendmentBooking",
    "originalBooking"
})
public class AmendmentRequestResult
    extends BaseResult
{

    @XmlElement(name = "AmendmentBooking")
    protected BookingWithStatus amendmentBooking;
    @XmlElement(name = "OriginalBooking")
    protected BookingWithStatus originalBooking;

    /**
     * Gets the value of the amendmentBooking property.
     * 
     * @return
     *     possible object is
     *     {@link BookingWithStatus }
     *     
     */
    public BookingWithStatus getAmendmentBooking() {
        return amendmentBooking;
    }

    /**
     * Sets the value of the amendmentBooking property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookingWithStatus }
     *     
     */
    public void setAmendmentBooking(BookingWithStatus value) {
        this.amendmentBooking = value;
    }

    /**
     * Gets the value of the originalBooking property.
     * 
     * @return
     *     possible object is
     *     {@link BookingWithStatus }
     *     
     */
    public BookingWithStatus getOriginalBooking() {
        return originalBooking;
    }

    /**
     * Sets the value of the originalBooking property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookingWithStatus }
     *     
     */
    public void setOriginalBooking(BookingWithStatus value) {
        this.originalBooking = value;
    }

}
