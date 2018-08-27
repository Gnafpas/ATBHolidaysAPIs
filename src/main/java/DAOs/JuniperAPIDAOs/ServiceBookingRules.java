
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
 *         &lt;element name="ServiceBookingRulesRQ" type="{http://www.juniper.es/webservice/2007/}JP_ServiceBookingRulesRQ" minOccurs="0"/>
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
    "serviceBookingRulesRQ"
})
@XmlRootElement(name = "ServiceBookingRules")
public class ServiceBookingRules {

    @XmlElement(name = "ServiceBookingRulesRQ")
    protected JPServiceBookingRulesRQ serviceBookingRulesRQ;

    /**
     * Gets the value of the serviceBookingRulesRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPServiceBookingRulesRQ }
     *     
     */
    public JPServiceBookingRulesRQ getServiceBookingRulesRQ() {
        return serviceBookingRulesRQ;
    }

    /**
     * Sets the value of the serviceBookingRulesRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServiceBookingRulesRQ }
     *     
     */
    public void setServiceBookingRulesRQ(JPServiceBookingRulesRQ value) {
        this.serviceBookingRulesRQ = value;
    }

}
