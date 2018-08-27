
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_TransferElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_TransferElement">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BaseElement">
 *       &lt;sequence>
 *         &lt;element name="TransfersBookingInfo" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_TransferBookingInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_TransferElement", propOrder = {
    "transfersBookingInfo"
})
public class JPTransferElement
    extends JPBaseElement
{

    @XmlElement(name = "TransfersBookingInfo")
    protected ArrayOfJPTransferBookingInfo transfersBookingInfo;

    /**
     * Gets the value of the transfersBookingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPTransferBookingInfo }
     *     
     */
    public ArrayOfJPTransferBookingInfo getTransfersBookingInfo() {
        return transfersBookingInfo;
    }

    /**
     * Sets the value of the transfersBookingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPTransferBookingInfo }
     *     
     */
    public void setTransfersBookingInfo(ArrayOfJPTransferBookingInfo value) {
        this.transfersBookingInfo = value;
    }

}
