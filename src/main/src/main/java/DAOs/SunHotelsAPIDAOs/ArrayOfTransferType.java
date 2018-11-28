
package DAOs.SunHotelsAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfTransferType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTransferType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transferType" type="{http://xml.sunhotels.net/15/}TransferType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTransferType", propOrder = {
    "transferType"
})
public class ArrayOfTransferType {

    @XmlElement(nillable = true)
    protected List<TransferType> transferType;

    /**
     * Gets the value of the transferType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transferType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransferType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransferType }
     * 
     * 
     */
    public List<TransferType> getTransferType() {
        if (transferType == null) {
            transferType = new ArrayList<TransferType>();
        }
        return this.transferType;
    }

}
