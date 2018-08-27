
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelResultsBookingRules complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelResultsBookingRules">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelOptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelOptionBookingRules" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelResultsBookingRules", propOrder = {
    "hotelOptions"
})
public class JPHotelResultsBookingRules {

    @XmlElement(name = "HotelOptions")
    protected ArrayOfJPHotelOptionBookingRules hotelOptions;

    /**
     * Gets the value of the hotelOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelOptionBookingRules }
     *     
     */
    public ArrayOfJPHotelOptionBookingRules getHotelOptions() {
        return hotelOptions;
    }

    /**
     * Sets the value of the hotelOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelOptionBookingRules }
     *     
     */
    public void setHotelOptions(ArrayOfJPHotelOptionBookingRules value) {
        this.hotelOptions = value;
    }

}
