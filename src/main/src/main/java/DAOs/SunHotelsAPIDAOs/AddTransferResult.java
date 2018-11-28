
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddTransferResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddTransferResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="transferBooking" type="{http://xml.sunhotels.net/15/}TransferBooking"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddTransferResult", propOrder = {
    "transferBooking"
})
public class AddTransferResult
    extends BaseResult
{

    @XmlElement(required = true, nillable = true)
    protected TransferBooking transferBooking;

    /**
     * Gets the value of the transferBooking property.
     * 
     * @return
     *     possible object is
     *     {@link TransferBooking }
     *     
     */
    public TransferBooking getTransferBooking() {
        return transferBooking;
    }

    /**
     * Sets the value of the transferBooking property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransferBooking }
     *     
     */
    public void setTransferBooking(TransferBooking value) {
        this.transferBooking = value;
    }

}
