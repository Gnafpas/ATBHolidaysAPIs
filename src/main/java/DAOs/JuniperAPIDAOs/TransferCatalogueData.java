
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
 *         &lt;element name="TransferCatalogueDataRQ" type="{http://www.juniper.es/webservice/2007/}JP_TransferCatalogueDataRQ" minOccurs="0"/>
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
    "transferCatalogueDataRQ"
})
@XmlRootElement(name = "TransferCatalogueData")
public class TransferCatalogueData {

    @XmlElement(name = "TransferCatalogueDataRQ")
    protected JPTransferCatalogueDataRQ transferCatalogueDataRQ;

    /**
     * Gets the value of the transferCatalogueDataRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferCatalogueDataRQ }
     *     
     */
    public JPTransferCatalogueDataRQ getTransferCatalogueDataRQ() {
        return transferCatalogueDataRQ;
    }

    /**
     * Sets the value of the transferCatalogueDataRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferCatalogueDataRQ }
     *     
     */
    public void setTransferCatalogueDataRQ(JPTransferCatalogueDataRQ value) {
        this.transferCatalogueDataRQ = value;
    }

}
