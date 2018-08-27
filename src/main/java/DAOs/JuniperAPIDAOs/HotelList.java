
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
 *         &lt;element name="HotelListRQ" type="{http://www.juniper.es/webservice/2007/}JP_HotelListRQ" minOccurs="0"/>
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
    "hotelListRQ"
})
@XmlRootElement(name = "HotelList")
public class HotelList {

    @XmlElement(name = "HotelListRQ")
    protected JPHotelListRQ hotelListRQ;

    /**
     * Gets the value of the hotelListRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelListRQ }
     *     
     */
    public JPHotelListRQ getHotelListRQ() {
        return hotelListRQ;
    }

    /**
     * Sets the value of the hotelListRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelListRQ }
     *     
     */
    public void setHotelListRQ(JPHotelListRQ value) {
        this.hotelListRQ = value;
    }

}
