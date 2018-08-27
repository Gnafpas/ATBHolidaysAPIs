
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentacarElement" type="{http://www.juniper.es/webservice/2007/}JP_RentacarElement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarElements", propOrder = {
    "rentacarElement"
})
public class JPRentacarElements {

    @XmlElement(name = "RentacarElement")
    protected JPRentacarElement rentacarElement;

    /**
     * Gets the value of the rentacarElement property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarElement }
     *     
     */
    public JPRentacarElement getRentacarElement() {
        return rentacarElement;
    }

    /**
     * Sets the value of the rentacarElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarElement }
     *     
     */
    public void setRentacarElement(JPRentacarElement value) {
        this.rentacarElement = value;
    }

}
