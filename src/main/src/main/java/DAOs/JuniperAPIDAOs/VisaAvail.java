
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
 *         &lt;element name="VisaAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_VisaAvailabilityRQ" minOccurs="0"/>
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
    "visaAvailRQ"
})
@XmlRootElement(name = "VisaAvail")
public class VisaAvail {

    @XmlElement(name = "VisaAvailRQ")
    protected JPVisaAvailabilityRQ visaAvailRQ;

    /**
     * Gets the value of the visaAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPVisaAvailabilityRQ }
     *     
     */
    public JPVisaAvailabilityRQ getVisaAvailRQ() {
        return visaAvailRQ;
    }

    /**
     * Sets the value of the visaAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPVisaAvailabilityRQ }
     *     
     */
    public void setVisaAvailRQ(JPVisaAvailabilityRQ value) {
        this.visaAvailRQ = value;
    }

}
