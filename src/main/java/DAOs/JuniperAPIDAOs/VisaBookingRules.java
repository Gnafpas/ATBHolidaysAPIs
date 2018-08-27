
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
 *         &lt;element name="VisaBookingRulesRQ" type="{http://www.juniper.es/webservice/2007/}JP_VisaBookingRulesRQ" minOccurs="0"/>
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
    "visaBookingRulesRQ"
})
@XmlRootElement(name = "VisaBookingRules")
public class VisaBookingRules {

    @XmlElement(name = "VisaBookingRulesRQ")
    protected JPVisaBookingRulesRQ visaBookingRulesRQ;

    /**
     * Gets the value of the visaBookingRulesRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPVisaBookingRulesRQ }
     *     
     */
    public JPVisaBookingRulesRQ getVisaBookingRulesRQ() {
        return visaBookingRulesRQ;
    }

    /**
     * Sets the value of the visaBookingRulesRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPVisaBookingRulesRQ }
     *     
     */
    public void setVisaBookingRulesRQ(JPVisaBookingRulesRQ value) {
        this.visaBookingRulesRQ = value;
    }

}
