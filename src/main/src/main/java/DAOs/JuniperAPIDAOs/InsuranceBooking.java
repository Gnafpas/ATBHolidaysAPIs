
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
 *         &lt;element name="InsuranceBookingRQ" type="{http://www.juniper.es/webservice/2007/}JP_InsuranceBooking" minOccurs="0"/>
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
    "insuranceBookingRQ"
})
@XmlRootElement(name = "InsuranceBooking")
public class InsuranceBooking {

    @XmlElement(name = "InsuranceBookingRQ")
    protected JPInsuranceBooking insuranceBookingRQ;

    /**
     * Gets the value of the insuranceBookingRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPInsuranceBooking }
     *     
     */
    public JPInsuranceBooking getInsuranceBookingRQ() {
        return insuranceBookingRQ;
    }

    /**
     * Sets the value of the insuranceBookingRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPInsuranceBooking }
     *     
     */
    public void setInsuranceBookingRQ(JPInsuranceBooking value) {
        this.insuranceBookingRQ = value;
    }

}
