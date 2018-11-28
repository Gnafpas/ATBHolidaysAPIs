
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
 *         &lt;element name="TransferPortfolioRQ" type="{http://www.juniper.es/webservice/2007/}JP_TransferPortfolioRQ" minOccurs="0"/>
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
    "transferPortfolioRQ"
})
@XmlRootElement(name = "TransferPortfolio")
public class TransferPortfolio {

    @XmlElement(name = "TransferPortfolioRQ")
    protected JPTransferPortfolioRQ transferPortfolioRQ;

    /**
     * Gets the value of the transferPortfolioRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferPortfolioRQ }
     *     
     */
    public JPTransferPortfolioRQ getTransferPortfolioRQ() {
        return transferPortfolioRQ;
    }

    /**
     * Sets the value of the transferPortfolioRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferPortfolioRQ }
     *     
     */
    public void setTransferPortfolioRQ(JPTransferPortfolioRQ value) {
        this.transferPortfolioRQ = value;
    }

}
