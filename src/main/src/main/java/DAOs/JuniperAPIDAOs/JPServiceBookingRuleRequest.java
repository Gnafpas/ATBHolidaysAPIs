
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ServiceBookingRuleRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ServiceBookingRuleRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceRuleOption" type="{http://www.juniper.es/webservice/2007/}JP_ServiceRuleOptionRQ" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ServiceBookingRuleRequest", propOrder = {
    "serviceRuleOption"
})
public class JPServiceBookingRuleRequest {

    @XmlElement(name = "ServiceRuleOption")
    protected JPServiceRuleOptionRQ serviceRuleOption;

    /**
     * Gets the value of the serviceRuleOption property.
     * 
     * @return
     *     possible object is
     *     {@link JPServiceRuleOptionRQ }
     *     
     */
    public JPServiceRuleOptionRQ getServiceRuleOption() {
        return serviceRuleOption;
    }

    /**
     * Sets the value of the serviceRuleOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServiceRuleOptionRQ }
     *     
     */
    public void setServiceRuleOption(JPServiceRuleOptionRQ value) {
        this.serviceRuleOption = value;
    }

}
