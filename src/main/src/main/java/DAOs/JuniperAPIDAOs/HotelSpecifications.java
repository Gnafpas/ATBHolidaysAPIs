
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
 *         &lt;element name="HotelSpecificationsRQ" type="{http://www.juniper.es/webservice/2007/}JP_HotelSpecificationsRQ" minOccurs="0"/>
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
    "hotelSpecificationsRQ"
})
@XmlRootElement(name = "HotelSpecifications")
public class HotelSpecifications {

    @XmlElement(name = "HotelSpecificationsRQ")
    protected JPHotelSpecificationsRQ hotelSpecificationsRQ;

    /**
     * Gets the value of the hotelSpecificationsRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelSpecificationsRQ }
     *     
     */
    public JPHotelSpecificationsRQ getHotelSpecificationsRQ() {
        return hotelSpecificationsRQ;
    }

    /**
     * Sets the value of the hotelSpecificationsRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelSpecificationsRQ }
     *     
     */
    public void setHotelSpecificationsRQ(JPHotelSpecificationsRQ value) {
        this.hotelSpecificationsRQ = value;
    }

}
