
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NonStaticTransfer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NonStaticTransfer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rates" type="{http://xml.sunhotels.net/15/}ArrayOfTransferRate" minOccurs="0"/>
 *         &lt;element name="transferId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NonStaticTransfer", propOrder = {
    "rates",
    "transferId"
})
@XmlSeeAlso({
    Transfer.class
})
public class NonStaticTransfer {

    protected ArrayOfTransferRate rates;
    protected int transferId;

    /**
     * Gets the value of the rates property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTransferRate }
     *     
     */
    public ArrayOfTransferRate getRates() {
        return rates;
    }

    /**
     * Sets the value of the rates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTransferRate }
     *     
     */
    public void setRates(ArrayOfTransferRate value) {
        this.rates = value;
    }

    /**
     * Gets the value of the transferId property.
     * 
     */
    public int getTransferId() {
        return transferId;
    }

    /**
     * Sets the value of the transferId property.
     * 
     */
    public void setTransferId(int value) {
        this.transferId = value;
    }

}
