
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_InsuranceRequiredFields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_InsuranceRequiredFields">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InsuranceBooking" type="{http://www.juniper.es/webservice/2007/}JP_InsuranceBooking" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_InsuranceRequiredFields", propOrder = {
    "insuranceBooking"
})
public class JPInsuranceRequiredFields {

    @XmlElement(name = "InsuranceBooking")
    protected JPInsuranceBooking insuranceBooking;

    /**
     * Gets the value of the insuranceBooking property.
     * 
     * @return
     *     possible object is
     *     {@link JPInsuranceBooking }
     *     
     */
    public JPInsuranceBooking getInsuranceBooking() {
        return insuranceBooking;
    }

    /**
     * Sets the value of the insuranceBooking property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPInsuranceBooking }
     *     
     */
    public void setInsuranceBooking(JPInsuranceBooking value) {
        this.insuranceBooking = value;
    }

}
