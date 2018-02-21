
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * <p>Java class for VehicleAvailAdditionalInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleAvailAdditionalInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PricedCoverages" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfCoveragePricedType" minOccurs="0"/>
 *         &lt;element name="PaymentRules" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfMonetaryRuleType" minOccurs="0"/>
 *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ChargeablePeriod" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleAvailAdditionalInfoType", propOrder = {
    "pricedCoverages",
    "paymentRules",
    "tpaExtensions"
})
public class VehicleAvailAdditionalInfoType {

    @XmlElement(name = "PricedCoverages")
    protected ArrayOfCoveragePricedType pricedCoverages;
    @XmlElement(name = "PaymentRules")
    protected ArrayOfMonetaryRuleType paymentRules;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;
    @XmlAttribute(name = "ChargeablePeriod")
    protected Duration chargeablePeriod;

    /**
     * Gets the value of the pricedCoverages property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCoveragePricedType }
     *     
     */
    public ArrayOfCoveragePricedType getPricedCoverages() {
        return pricedCoverages;
    }

    /**
     * Sets the value of the pricedCoverages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCoveragePricedType }
     *     
     */
    public void setPricedCoverages(ArrayOfCoveragePricedType value) {
        this.pricedCoverages = value;
    }

    /**
     * Gets the value of the paymentRules property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMonetaryRuleType }
     *     
     */
    public ArrayOfMonetaryRuleType getPaymentRules() {
        return paymentRules;
    }

    /**
     * Sets the value of the paymentRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMonetaryRuleType }
     *     
     */
    public void setPaymentRules(ArrayOfMonetaryRuleType value) {
        this.paymentRules = value;
    }

    /**
     * Gets the value of the tpaExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType }
     *     
     */
    public TPAExtensionsType getTPAExtensions() {
        return tpaExtensions;
    }

    /**
     * Sets the value of the tpaExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType }
     *     
     */
    public void setTPAExtensions(TPAExtensionsType value) {
        this.tpaExtensions = value;
    }

    /**
     * Gets the value of the chargeablePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getChargeablePeriod() {
        return chargeablePeriod;
    }

    /**
     * Sets the value of the chargeablePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setChargeablePeriod(Duration value) {
        this.chargeablePeriod = value;
    }

}
