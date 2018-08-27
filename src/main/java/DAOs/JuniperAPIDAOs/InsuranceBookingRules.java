
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
 *         &lt;element name="InsuranceBookingRulesRQ" type="{http://www.juniper.es/webservice/2007/}JP_InsuranceBookingRulesRQ" minOccurs="0"/>
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
    "insuranceBookingRulesRQ"
})
@XmlRootElement(name = "InsuranceBookingRules")
public class InsuranceBookingRules {

    @XmlElement(name = "InsuranceBookingRulesRQ")
    protected JPInsuranceBookingRulesRQ insuranceBookingRulesRQ;

    /**
     * Gets the value of the insuranceBookingRulesRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPInsuranceBookingRulesRQ }
     *     
     */
    public JPInsuranceBookingRulesRQ getInsuranceBookingRulesRQ() {
        return insuranceBookingRulesRQ;
    }

    /**
     * Sets the value of the insuranceBookingRulesRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPInsuranceBookingRulesRQ }
     *     
     */
    public void setInsuranceBookingRulesRQ(JPInsuranceBookingRulesRQ value) {
        this.insuranceBookingRulesRQ = value;
    }

}
