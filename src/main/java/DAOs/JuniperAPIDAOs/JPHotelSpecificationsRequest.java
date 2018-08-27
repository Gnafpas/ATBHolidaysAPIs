
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelSpecificationsRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelSpecificationsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelCodes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelInventoryCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelSpecificationsRequest", propOrder = {
    "hotelCodes"
})
public class JPHotelSpecificationsRequest {

    @XmlElement(name = "HotelCodes")
    protected ArrayOfJPHotelInventoryCode hotelCodes;

    /**
     * Gets the value of the hotelCodes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelInventoryCode }
     *     
     */
    public ArrayOfJPHotelInventoryCode getHotelCodes() {
        return hotelCodes;
    }

    /**
     * Sets the value of the hotelCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelInventoryCode }
     *     
     */
    public void setHotelCodes(ArrayOfJPHotelInventoryCode value) {
        this.hotelCodes = value;
    }

}
