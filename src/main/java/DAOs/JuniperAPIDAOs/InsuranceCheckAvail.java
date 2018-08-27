
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
 *         &lt;element name="InsuranceCheckAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_InsuranceCheckAvail" minOccurs="0"/>
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
    "insuranceCheckAvailRQ"
})
@XmlRootElement(name = "InsuranceCheckAvail")
public class InsuranceCheckAvail {

    @XmlElement(name = "InsuranceCheckAvailRQ")
    protected JPInsuranceCheckAvail insuranceCheckAvailRQ;

    /**
     * Gets the value of the insuranceCheckAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPInsuranceCheckAvail }
     *     
     */
    public JPInsuranceCheckAvail getInsuranceCheckAvailRQ() {
        return insuranceCheckAvailRQ;
    }

    /**
     * Sets the value of the insuranceCheckAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPInsuranceCheckAvail }
     *     
     */
    public void setInsuranceCheckAvailRQ(JPInsuranceCheckAvail value) {
        this.insuranceCheckAvailRQ = value;
    }

}
