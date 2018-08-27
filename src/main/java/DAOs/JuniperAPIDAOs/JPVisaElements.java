
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_VisaElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_VisaElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisaElement" type="{http://www.juniper.es/webservice/2007/}JP_VisaElement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_VisaElements", propOrder = {
    "visaElement"
})
public class JPVisaElements {

    @XmlElement(name = "VisaElement")
    protected JPVisaElement visaElement;

    /**
     * Gets the value of the visaElement property.
     * 
     * @return
     *     possible object is
     *     {@link JPVisaElement }
     *     
     */
    public JPVisaElement getVisaElement() {
        return visaElement;
    }

    /**
     * Sets the value of the visaElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPVisaElement }
     *     
     */
    public void setVisaElement(JPVisaElement value) {
        this.visaElement = value;
    }

}
