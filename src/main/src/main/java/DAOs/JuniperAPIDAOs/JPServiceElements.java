
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ServiceElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ServiceElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceElement" type="{http://www.juniper.es/webservice/2007/}JP_ServiceElement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ServiceElements", propOrder = {
    "serviceElement"
})
public class JPServiceElements {

    @XmlElement(name = "ServiceElement")
    protected JPServiceElement serviceElement;

    /**
     * Gets the value of the serviceElement property.
     * 
     * @return
     *     possible object is
     *     {@link JPServiceElement }
     *     
     */
    public JPServiceElement getServiceElement() {
        return serviceElement;
    }

    /**
     * Sets the value of the serviceElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServiceElement }
     *     
     */
    public void setServiceElement(JPServiceElement value) {
        this.serviceElement = value;
    }

}
