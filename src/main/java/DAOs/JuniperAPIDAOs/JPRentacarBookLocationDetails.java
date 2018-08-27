
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarBookLocationDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarBookLocationDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentacarLocationDetailPickUp" type="{http://www.juniper.es/webservice/2007/}JP_RentacarLocationDetail" minOccurs="0"/>
 *         &lt;element name="RentacarLocationDetailDropOff" type="{http://www.juniper.es/webservice/2007/}JP_RentacarLocationDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarBookLocationDetails", propOrder = {
    "rentacarLocationDetailPickUp",
    "rentacarLocationDetailDropOff"
})
public class JPRentacarBookLocationDetails {

    @XmlElement(name = "RentacarLocationDetailPickUp")
    protected JPRentacarLocationDetail rentacarLocationDetailPickUp;
    @XmlElement(name = "RentacarLocationDetailDropOff")
    protected JPRentacarLocationDetail rentacarLocationDetailDropOff;

    /**
     * Gets the value of the rentacarLocationDetailPickUp property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarLocationDetail }
     *     
     */
    public JPRentacarLocationDetail getRentacarLocationDetailPickUp() {
        return rentacarLocationDetailPickUp;
    }

    /**
     * Sets the value of the rentacarLocationDetailPickUp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarLocationDetail }
     *     
     */
    public void setRentacarLocationDetailPickUp(JPRentacarLocationDetail value) {
        this.rentacarLocationDetailPickUp = value;
    }

    /**
     * Gets the value of the rentacarLocationDetailDropOff property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarLocationDetail }
     *     
     */
    public JPRentacarLocationDetail getRentacarLocationDetailDropOff() {
        return rentacarLocationDetailDropOff;
    }

    /**
     * Sets the value of the rentacarLocationDetailDropOff property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarLocationDetail }
     *     
     */
    public void setRentacarLocationDetailDropOff(JPRentacarLocationDetail value) {
        this.rentacarLocationDetailDropOff = value;
    }

}
