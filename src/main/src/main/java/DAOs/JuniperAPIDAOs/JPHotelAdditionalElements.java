
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelAdditionalElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelAdditionalElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelSupplements" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelAdditionalElement" minOccurs="0"/>
 *         &lt;element name="HotelOffers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelAdditionalElement1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelAdditionalElements", propOrder = {
    "hotelSupplements",
    "hotelOffers"
})
public class JPHotelAdditionalElements {

    @XmlElement(name = "HotelSupplements")
    protected ArrayOfJPHotelAdditionalElement hotelSupplements;
    @XmlElement(name = "HotelOffers")
    protected ArrayOfJPHotelAdditionalElement1 hotelOffers;

    /**
     * Gets the value of the hotelSupplements property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelAdditionalElement }
     *     
     */
    public ArrayOfJPHotelAdditionalElement getHotelSupplements() {
        return hotelSupplements;
    }

    /**
     * Sets the value of the hotelSupplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelAdditionalElement }
     *     
     */
    public void setHotelSupplements(ArrayOfJPHotelAdditionalElement value) {
        this.hotelSupplements = value;
    }

    /**
     * Gets the value of the hotelOffers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelAdditionalElement1 }
     *     
     */
    public ArrayOfJPHotelAdditionalElement1 getHotelOffers() {
        return hotelOffers;
    }

    /**
     * Sets the value of the hotelOffers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelAdditionalElement1 }
     *     
     */
    public void setHotelOffers(ArrayOfJPHotelAdditionalElement1 value) {
        this.hotelOffers = value;
    }

}
