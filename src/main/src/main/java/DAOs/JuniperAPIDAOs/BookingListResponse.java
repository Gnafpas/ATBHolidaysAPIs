
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="BookingListRS" type="{http://www.juniper.es/webservice/2007/}JP_BookingListRS" minOccurs="0"/>
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
    "bookingListRS"
})
@XmlRootElement(name = "BookingListResponse")
public class BookingListResponse {

    @XmlElement(name = "BookingListRS")
    protected JPBookingListRS bookingListRS;

    /**
     * Gets the value of the bookingListRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPBookingListRS }
     *     
     */
    public JPBookingListRS getBookingListRS() {
        return bookingListRS;
    }

    /**
     * Sets the value of the bookingListRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBookingListRS }
     *     
     */
    public void setBookingListRS(JPBookingListRS value) {
        this.bookingListRS = value;
    }

}
