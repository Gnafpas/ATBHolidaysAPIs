
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CancellationPolicyRules complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CancellationPolicyRules">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FirstDayCostCancellation" type="{http://www.juniper.es/webservice/2007/}JP_FirstDayCostCancellation" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PolicyRules" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Rule" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CancellationPolicyRules", propOrder = {
    "firstDayCostCancellation",
    "description",
    "policyRules"
})
public class JPCancellationPolicyRules {

    @XmlElement(name = "FirstDayCostCancellation")
    protected JPFirstDayCostCancellation firstDayCostCancellation;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "PolicyRules")
    protected ArrayOfJPRule policyRules;
    @XmlAttribute(name = "CurrencyCode")
    protected String currencyCode;

    /**
     * Gets the value of the firstDayCostCancellation property.
     * 
     * @return
     *     possible object is
     *     {@link JPFirstDayCostCancellation }
     *     
     */
    public JPFirstDayCostCancellation getFirstDayCostCancellation() {
        return firstDayCostCancellation;
    }

    /**
     * Sets the value of the firstDayCostCancellation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFirstDayCostCancellation }
     *     
     */
    public void setFirstDayCostCancellation(JPFirstDayCostCancellation value) {
        this.firstDayCostCancellation = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the policyRules property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRule }
     *     
     */
    public ArrayOfJPRule getPolicyRules() {
        return policyRules;
    }

    /**
     * Sets the value of the policyRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRule }
     *     
     */
    public void setPolicyRules(ArrayOfJPRule value) {
        this.policyRules = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

}
