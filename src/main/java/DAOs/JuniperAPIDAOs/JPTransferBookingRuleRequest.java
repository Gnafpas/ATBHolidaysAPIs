
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_TransferBookingRuleRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_TransferBookingRuleRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransferRuleOption" type="{http://www.juniper.es/webservice/2007/}JP_TransferRuleOptionRQ" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_TransferBookingRuleRequest", propOrder = {
    "transferRuleOption"
})
public class JPTransferBookingRuleRequest {

    @XmlElement(name = "TransferRuleOption")
    protected JPTransferRuleOptionRQ transferRuleOption;

    /**
     * Gets the value of the transferRuleOption property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferRuleOptionRQ }
     *     
     */
    public JPTransferRuleOptionRQ getTransferRuleOption() {
        return transferRuleOption;
    }

    /**
     * Sets the value of the transferRuleOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferRuleOptionRQ }
     *     
     */
    public void setTransferRuleOption(JPTransferRuleOptionRQ value) {
        this.transferRuleOption = value;
    }

}
