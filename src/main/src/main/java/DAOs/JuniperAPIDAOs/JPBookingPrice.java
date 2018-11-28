
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_BookingPrice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_BookingPrice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PriceRange" type="{http://www.juniper.es/webservice/2007/}JP_PriceRange" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_BookingPrice", propOrder = {
    "priceRange"
})
public class JPBookingPrice {

    @XmlElement(name = "PriceRange")
    protected JPPriceRange priceRange;

    /**
     * Gets the value of the priceRange property.
     * 
     * @return
     *     possible object is
     *     {@link JPPriceRange }
     *     
     */
    public JPPriceRange getPriceRange() {
        return priceRange;
    }

    /**
     * Sets the value of the priceRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPriceRange }
     *     
     */
    public void setPriceRange(JPPriceRange value) {
        this.priceRange = value;
    }

}
