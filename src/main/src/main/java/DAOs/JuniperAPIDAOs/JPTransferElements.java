
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_TransferElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_TransferElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransferElement" type="{http://www.juniper.es/webservice/2007/}JP_TransferElement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_TransferElements", propOrder = {
    "transferElement"
})
public class JPTransferElements {

    @XmlElement(name = "TransferElement")
    protected JPTransferElement transferElement;

    /**
     * Gets the value of the transferElement property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferElement }
     *     
     */
    public JPTransferElement getTransferElement() {
        return transferElement;
    }

    /**
     * Sets the value of the transferElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferElement }
     *     
     */
    public void setTransferElement(JPTransferElement value) {
        this.transferElement = value;
    }

}
