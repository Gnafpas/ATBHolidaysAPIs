
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
 *         &lt;element name="RentacarLocationListRQ" type="{http://www.juniper.es/webservice/2007/}JP_RentacarLocationListRQ" minOccurs="0"/>
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
    "rentacarLocationListRQ"
})
@XmlRootElement(name = "RentacarLocationList")
public class RentacarLocationList {

    @XmlElement(name = "RentacarLocationListRQ")
    protected JPRentacarLocationListRQ rentacarLocationListRQ;

    /**
     * Gets the value of the rentacarLocationListRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarLocationListRQ }
     *     
     */
    public JPRentacarLocationListRQ getRentacarLocationListRQ() {
        return rentacarLocationListRQ;
    }

    /**
     * Sets the value of the rentacarLocationListRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarLocationListRQ }
     *     
     */
    public void setRentacarLocationListRQ(JPRentacarLocationListRQ value) {
        this.rentacarLocationListRQ = value;
    }

}
