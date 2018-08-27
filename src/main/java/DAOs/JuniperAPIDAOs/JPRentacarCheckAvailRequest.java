
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarCheckAvailRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarCheckAvailRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentacarOption" type="{http://www.juniper.es/webservice/2007/}JP_RentacarRequestCheckAvailOption" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarCheckAvailRequest", propOrder = {
    "rentacarOption"
})
public class JPRentacarCheckAvailRequest {

    @XmlElement(name = "RentacarOption")
    protected JPRentacarRequestCheckAvailOption rentacarOption;

    /**
     * Gets the value of the rentacarOption property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarRequestCheckAvailOption }
     *     
     */
    public JPRentacarRequestCheckAvailOption getRentacarOption() {
        return rentacarOption;
    }

    /**
     * Sets the value of the rentacarOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarRequestCheckAvailOption }
     *     
     */
    public void setRentacarOption(JPRentacarRequestCheckAvailOption value) {
        this.rentacarOption = value;
    }

}
