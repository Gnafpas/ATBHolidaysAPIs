
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_InsuranceElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_InsuranceElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InsuranceElement" type="{http://www.juniper.es/webservice/2007/}JP_InsuranceElement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_InsuranceElements", propOrder = {
    "insuranceElement"
})
public class JPInsuranceElements {

    @XmlElement(name = "InsuranceElement")
    protected JPInsuranceElement insuranceElement;

    /**
     * Gets the value of the insuranceElement property.
     * 
     * @return
     *     possible object is
     *     {@link JPInsuranceElement }
     *     
     */
    public JPInsuranceElement getInsuranceElement() {
        return insuranceElement;
    }

    /**
     * Sets the value of the insuranceElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPInsuranceElement }
     *     
     */
    public void setInsuranceElement(JPInsuranceElement value) {
        this.insuranceElement = value;
    }

}
