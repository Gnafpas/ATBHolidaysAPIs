
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
 *         &lt;element name="InsuranceAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_InsuranceAvail" minOccurs="0"/>
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
    "insuranceAvailRQ"
})
@XmlRootElement(name = "InsuranceAvail")
public class InsuranceAvail {

    @XmlElement(name = "InsuranceAvailRQ")
    protected JPInsuranceAvail insuranceAvailRQ;

    /**
     * Gets the value of the insuranceAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPInsuranceAvail }
     *     
     */
    public JPInsuranceAvail getInsuranceAvailRQ() {
        return insuranceAvailRQ;
    }

    /**
     * Sets the value of the insuranceAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPInsuranceAvail }
     *     
     */
    public void setInsuranceAvailRQ(JPInsuranceAvail value) {
        this.insuranceAvailRQ = value;
    }

}
