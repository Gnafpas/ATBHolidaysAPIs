
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
 *         &lt;element name="CruiseBookingRQ" type="{http://www.juniper.es/webservice/2007/}JP_CruiseBooking" minOccurs="0"/>
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
    "cruiseBookingRQ"
})
@XmlRootElement(name = "CruiseBooking")
public class CruiseBooking {

    @XmlElement(name = "CruiseBookingRQ")
    protected JPCruiseBooking cruiseBookingRQ;

    /**
     * Gets the value of the cruiseBookingRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseBooking }
     *     
     */
    public JPCruiseBooking getCruiseBookingRQ() {
        return cruiseBookingRQ;
    }

    /**
     * Sets the value of the cruiseBookingRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseBooking }
     *     
     */
    public void setCruiseBookingRQ(JPCruiseBooking value) {
        this.cruiseBookingRQ = value;
    }

}
