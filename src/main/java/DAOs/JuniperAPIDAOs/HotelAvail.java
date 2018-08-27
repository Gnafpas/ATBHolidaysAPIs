
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
 *         &lt;element name="HotelAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_HotelAvail" minOccurs="0"/>
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
    "hotelAvailRQ"
})
@XmlRootElement(name = "HotelAvail")
public class HotelAvail {

    @XmlElement(name = "HotelAvailRQ")
    protected JPHotelAvail hotelAvailRQ;

    /**
     * Gets the value of the hotelAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelAvail }
     *     
     */
    public JPHotelAvail getHotelAvailRQ() {
        return hotelAvailRQ;
    }

    /**
     * Sets the value of the hotelAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelAvail }
     *     
     */
    public void setHotelAvailRQ(JPHotelAvail value) {
        this.hotelAvailRQ = value;
    }

}
