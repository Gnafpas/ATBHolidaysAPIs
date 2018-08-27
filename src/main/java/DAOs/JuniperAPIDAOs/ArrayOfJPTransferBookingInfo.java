
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_TransferBookingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_TransferBookingInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransferBookingInfo" type="{http://www.juniper.es/webservice/2007/}JP_TransferBookingInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_TransferBookingInfo", propOrder = {
    "transferBookingInfo"
})
public class ArrayOfJPTransferBookingInfo {

    @XmlElement(name = "TransferBookingInfo")
    protected List<JPTransferBookingInfo> transferBookingInfo;

    /**
     * Gets the value of the transferBookingInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transferBookingInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransferBookingInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPTransferBookingInfo }
     * 
     * 
     */
    public List<JPTransferBookingInfo> getTransferBookingInfo() {
        if (transferBookingInfo == null) {
            transferBookingInfo = new ArrayList<JPTransferBookingInfo>();
        }
        return this.transferBookingInfo;
    }

}
