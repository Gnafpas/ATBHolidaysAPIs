
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
 *         &lt;element name="HotelContentRQ" type="{http://www.juniper.es/webservice/2007/}JP_HotelContentRQ" minOccurs="0"/>
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
    "hotelContentRQ"
})
@XmlRootElement(name = "HotelContent")
public class HotelContent {

    @XmlElement(name = "HotelContentRQ")
    protected JPHotelContentRQ hotelContentRQ;

    /**
     * Gets the value of the hotelContentRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelContentRQ }
     *     
     */
    public JPHotelContentRQ getHotelContentRQ() {
        return hotelContentRQ;
    }

    /**
     * Sets the value of the hotelContentRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelContentRQ }
     *     
     */
    public void setHotelContentRQ(JPHotelContentRQ value) {
        this.hotelContentRQ = value;
    }

}
