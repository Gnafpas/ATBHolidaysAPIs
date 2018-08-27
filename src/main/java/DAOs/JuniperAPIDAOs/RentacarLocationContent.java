
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
 *         &lt;element name="RentacarLocationContentRQ" type="{http://www.juniper.es/webservice/2007/}JP_RentacarLocationContentRQ" minOccurs="0"/>
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
    "rentacarLocationContentRQ"
})
@XmlRootElement(name = "RentacarLocationContent")
public class RentacarLocationContent {

    @XmlElement(name = "RentacarLocationContentRQ")
    protected JPRentacarLocationContentRQ rentacarLocationContentRQ;

    /**
     * Gets the value of the rentacarLocationContentRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarLocationContentRQ }
     *     
     */
    public JPRentacarLocationContentRQ getRentacarLocationContentRQ() {
        return rentacarLocationContentRQ;
    }

    /**
     * Sets the value of the rentacarLocationContentRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarLocationContentRQ }
     *     
     */
    public void setRentacarLocationContentRQ(JPRentacarLocationContentRQ value) {
        this.rentacarLocationContentRQ = value;
    }

}
