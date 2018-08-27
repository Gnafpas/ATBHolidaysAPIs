
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelElement">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BaseElement">
 *       &lt;sequence>
 *         &lt;element name="HotelBookingInfo" type="{http://www.juniper.es/webservice/2007/}JP_HotelBookingInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelElement", propOrder = {
    "hotelBookingInfo"
})
public class JPHotelElement
    extends JPBaseElement
{

    @XmlElement(name = "HotelBookingInfo")
    protected JPHotelBookingInfo hotelBookingInfo;

    /**
     * Gets the value of the hotelBookingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelBookingInfo }
     *     
     */
    public JPHotelBookingInfo getHotelBookingInfo() {
        return hotelBookingInfo;
    }

    /**
     * Sets the value of the hotelBookingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelBookingInfo }
     *     
     */
    public void setHotelBookingInfo(JPHotelBookingInfo value) {
        this.hotelBookingInfo = value;
    }

}
