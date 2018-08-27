
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentcarRequiredFields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentcarRequiredFields">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentacarBooking" type="{http://www.juniper.es/webservice/2007/}JP_RentacarBooking" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentcarRequiredFields", propOrder = {
    "rentacarBooking"
})
public class JPRentcarRequiredFields {

    @XmlElement(name = "RentacarBooking")
    protected JPRentacarBooking rentacarBooking;

    /**
     * Gets the value of the rentacarBooking property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarBooking }
     *     
     */
    public JPRentacarBooking getRentacarBooking() {
        return rentacarBooking;
    }

    /**
     * Sets the value of the rentacarBooking property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarBooking }
     *     
     */
    public void setRentacarBooking(JPRentacarBooking value) {
        this.rentacarBooking = value;
    }

}
