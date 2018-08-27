
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
 *         &lt;element name="HotelCheckAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_HotelCheckAvail" minOccurs="0"/>
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
    "hotelCheckAvailRQ"
})
@XmlRootElement(name = "HotelCheckAvail")
public class HotelCheckAvail {

    @XmlElement(name = "HotelCheckAvailRQ")
    protected JPHotelCheckAvail hotelCheckAvailRQ;

    /**
     * Gets the value of the hotelCheckAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelCheckAvail }
     *     
     */
    public JPHotelCheckAvail getHotelCheckAvailRQ() {
        return hotelCheckAvailRQ;
    }

    /**
     * Sets the value of the hotelCheckAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelCheckAvail }
     *     
     */
    public void setHotelCheckAvailRQ(JPHotelCheckAvail value) {
        this.hotelCheckAvailRQ = value;
    }

}
