
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
 *         &lt;element name="HotelBookingRQ" type="{http://www.juniper.es/webservice/2007/}JP_HotelBooking" minOccurs="0"/>
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
    "hotelBookingRQ"
})
@XmlRootElement(name = "HotelBooking")
public class HotelBooking {

    @XmlElement(name = "HotelBookingRQ")
    protected JPHotelBooking hotelBookingRQ;

    /**
     * Gets the value of the hotelBookingRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelBooking }
     *     
     */
    public JPHotelBooking getHotelBookingRQ() {
        return hotelBookingRQ;
    }

    /**
     * Sets the value of the hotelBookingRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelBooking }
     *     
     */
    public void setHotelBookingRQ(JPHotelBooking value) {
        this.hotelBookingRQ = value;
    }

}
