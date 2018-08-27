
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_BillingDataAFIP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_BillingDataAFIP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="BillingType" use="required" type="{http://www.juniper.es/webservice/2007/}JP_BillingType" />
 *       &lt;attribute name="BillingDocType" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="FiscalCondition" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_BillingDataAFIP")
public class JPBillingDataAFIP {

    @XmlAttribute(name = "BillingType", required = true)
    protected JPBillingType billingType;
    @XmlAttribute(name = "BillingDocType", required = true)
    protected int billingDocType;
    @XmlAttribute(name = "FiscalCondition", required = true)
    protected int fiscalCondition;

    /**
     * Gets the value of the billingType property.
     * 
     * @return
     *     possible object is
     *     {@link JPBillingType }
     *     
     */
    public JPBillingType getBillingType() {
        return billingType;
    }

    /**
     * Sets the value of the billingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBillingType }
     *     
     */
    public void setBillingType(JPBillingType value) {
        this.billingType = value;
    }

    /**
     * Gets the value of the billingDocType property.
     * 
     */
    public int getBillingDocType() {
        return billingDocType;
    }

    /**
     * Sets the value of the billingDocType property.
     * 
     */
    public void setBillingDocType(int value) {
        this.billingDocType = value;
    }

    /**
     * Gets the value of the fiscalCondition property.
     * 
     */
    public int getFiscalCondition() {
        return fiscalCondition;
    }

    /**
     * Sets the value of the fiscalCondition property.
     * 
     */
    public void setFiscalCondition(int value) {
        this.fiscalCondition = value;
    }

}
