
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_TransferCheckAvailRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_TransferCheckAvailRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransferCheckOption" type="{http://www.juniper.es/webservice/2007/}JP_TransferOptionRQ" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_TransferCheckAvailRequest", propOrder = {
    "transferCheckOption"
})
public class JPTransferCheckAvailRequest {

    @XmlElement(name = "TransferCheckOption")
    protected JPTransferOptionRQ transferCheckOption;

    /**
     * Gets the value of the transferCheckOption property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferOptionRQ }
     *     
     */
    public JPTransferOptionRQ getTransferCheckOption() {
        return transferCheckOption;
    }

    /**
     * Sets the value of the transferCheckOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferOptionRQ }
     *     
     */
    public void setTransferCheckOption(JPTransferOptionRQ value) {
        this.transferCheckOption = value;
    }

}
