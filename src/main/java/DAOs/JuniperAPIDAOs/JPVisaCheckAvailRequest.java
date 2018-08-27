
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_VisaCheckAvailRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_VisaCheckAvailRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisaCheckOption" type="{http://www.juniper.es/webservice/2007/}JP_VisaOptionRQ" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_VisaCheckAvailRequest", propOrder = {
    "visaCheckOption"
})
public class JPVisaCheckAvailRequest {

    @XmlElement(name = "VisaCheckOption")
    protected JPVisaOptionRQ visaCheckOption;

    /**
     * Gets the value of the visaCheckOption property.
     * 
     * @return
     *     possible object is
     *     {@link JPVisaOptionRQ }
     *     
     */
    public JPVisaOptionRQ getVisaCheckOption() {
        return visaCheckOption;
    }

    /**
     * Sets the value of the visaCheckOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPVisaOptionRQ }
     *     
     */
    public void setVisaCheckOption(JPVisaOptionRQ value) {
        this.visaCheckOption = value;
    }

}
