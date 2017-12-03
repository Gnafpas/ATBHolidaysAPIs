
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetTransferTypesResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetTransferTypesResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="transferTypes" type="{http://xml.sunhotels.net/15/}ArrayOfTransferType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTransferTypesResult", propOrder = {
    "transferTypes"
})
public class GetTransferTypesResult
    extends BaseResult
{

    protected ArrayOfTransferType transferTypes;

    /**
     * Gets the value of the transferTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTransferType }
     *     
     */
    public ArrayOfTransferType getTransferTypes() {
        return transferTypes;
    }

    /**
     * Sets the value of the transferTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTransferType }
     *     
     */
    public void setTransferTypes(ArrayOfTransferType value) {
        this.transferTypes = value;
    }

}
