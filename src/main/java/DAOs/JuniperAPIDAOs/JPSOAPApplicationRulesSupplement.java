
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_ApplicationRulesSupplement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_ApplicationRulesSupplement">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JPSOAP_ApplicationRules">
 *       &lt;sequence>
 *         &lt;element name="AlternateWithSupplements" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_IntCodeAttr1" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CalculationBySeason" type="{http://www.juniper.es/webservice/2007/}JPSOAP_CalculationBySeason" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_ApplicationRulesSupplement", propOrder = {
    "alternateWithSupplements"
})
public class JPSOAPApplicationRulesSupplement
    extends JPSOAPApplicationRules
{

    @XmlElement(name = "AlternateWithSupplements")
    protected ArrayOfJPSOAPIntCodeAttr1 alternateWithSupplements;
    @XmlAttribute(name = "CalculationBySeason")
    protected JPSOAPCalculationBySeason calculationBySeason;

    /**
     * Gets the value of the alternateWithSupplements property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPIntCodeAttr1 }
     *     
     */
    public ArrayOfJPSOAPIntCodeAttr1 getAlternateWithSupplements() {
        return alternateWithSupplements;
    }

    /**
     * Sets the value of the alternateWithSupplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPIntCodeAttr1 }
     *     
     */
    public void setAlternateWithSupplements(ArrayOfJPSOAPIntCodeAttr1 value) {
        this.alternateWithSupplements = value;
    }

    /**
     * Gets the value of the calculationBySeason property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPCalculationBySeason }
     *     
     */
    public JPSOAPCalculationBySeason getCalculationBySeason() {
        return calculationBySeason;
    }

    /**
     * Sets the value of the calculationBySeason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPCalculationBySeason }
     *     
     */
    public void setCalculationBySeason(JPSOAPCalculationBySeason value) {
        this.calculationBySeason = value;
    }

}
