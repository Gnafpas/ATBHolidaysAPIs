
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelRequiredFields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelRequiredFields">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelBooking" type="{http://www.juniper.es/webservice/2007/}JP_HotelBooking" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelRequiredFields", propOrder = {
    "hotelBooking"
})
public class JPHotelRequiredFields {

    @XmlElement(name = "HotelBooking")
    protected JPHotelBooking hotelBooking;

    /**
     * Gets the value of the hotelBooking property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelBooking }
     *     
     */
    public JPHotelBooking getHotelBooking() {
        return hotelBooking;
    }

    /**
     * Sets the value of the hotelBooking property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelBooking }
     *     
     */
    public void setHotelBooking(JPHotelBooking value) {
        this.hotelBooking = value;
    }

}
