
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_InsuranceCheckAvailRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_InsuranceCheckAvailRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Insurance" type="{http://www.juniper.es/webservice/2007/}JP_InsuranceOptionRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_InsuranceCheckAvailRequest", propOrder = {
    "insurance"
})
public class JPInsuranceCheckAvailRequest {

    @XmlElement(name = "Insurance")
    protected JPInsuranceOptionRequest insurance;

    /**
     * Gets the value of the insurance property.
     * 
     * @return
     *     possible object is
     *     {@link JPInsuranceOptionRequest }
     *     
     */
    public JPInsuranceOptionRequest getInsurance() {
        return insurance;
    }

    /**
     * Sets the value of the insurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPInsuranceOptionRequest }
     *     
     */
    public void setInsurance(JPInsuranceOptionRequest value) {
        this.insurance = value;
    }

}
