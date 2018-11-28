
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
 *         &lt;element name="VisaCheckAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_VisaCheckAvailRQ" minOccurs="0"/>
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
    "visaCheckAvailRQ"
})
@XmlRootElement(name = "VisaCheckAvail")
public class VisaCheckAvail {

    @XmlElement(name = "VisaCheckAvailRQ")
    protected JPVisaCheckAvailRQ visaCheckAvailRQ;

    /**
     * Gets the value of the visaCheckAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPVisaCheckAvailRQ }
     *     
     */
    public JPVisaCheckAvailRQ getVisaCheckAvailRQ() {
        return visaCheckAvailRQ;
    }

    /**
     * Sets the value of the visaCheckAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPVisaCheckAvailRQ }
     *     
     */
    public void setVisaCheckAvailRQ(JPVisaCheckAvailRQ value) {
        this.visaCheckAvailRQ = value;
    }

}
