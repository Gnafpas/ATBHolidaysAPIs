
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
 *         &lt;element name="BookingListRQ" type="{http://www.juniper.es/webservice/2007/}JP_BookingListRQ" minOccurs="0"/>
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
    "bookingListRQ"
})
@XmlRootElement(name = "BookingList")
public class BookingList {

    @XmlElement(name = "BookingListRQ")
    protected JPBookingListRQ bookingListRQ;

    /**
     * Gets the value of the bookingListRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPBookingListRQ }
     *     
     */
    public JPBookingListRQ getBookingListRQ() {
        return bookingListRQ;
    }

    /**
     * Sets the value of the bookingListRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBookingListRQ }
     *     
     */
    public void setBookingListRQ(JPBookingListRQ value) {
        this.bookingListRQ = value;
    }

}
