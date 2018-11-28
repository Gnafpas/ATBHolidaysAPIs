
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ServiceCheckAvailRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ServiceCheckAvailRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceCheckOption" type="{http://www.juniper.es/webservice/2007/}JP_ServiceOptionRQ" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ServiceCheckAvailRequest", propOrder = {
    "serviceCheckOption"
})
public class JPServiceCheckAvailRequest {

    @XmlElement(name = "ServiceCheckOption")
    protected JPServiceOptionRQ serviceCheckOption;

    /**
     * Gets the value of the serviceCheckOption property.
     * 
     * @return
     *     possible object is
     *     {@link JPServiceOptionRQ }
     *     
     */
    public JPServiceOptionRQ getServiceCheckOption() {
        return serviceCheckOption;
    }

    /**
     * Sets the value of the serviceCheckOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServiceOptionRQ }
     *     
     */
    public void setServiceCheckOption(JPServiceOptionRQ value) {
        this.serviceCheckOption = value;
    }

}
