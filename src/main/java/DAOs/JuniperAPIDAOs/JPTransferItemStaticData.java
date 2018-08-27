
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_TransferItemStaticData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_TransferItemStaticData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InternalTransferSupplierList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_InternalSupplier1" minOccurs="0"/>
 *         &lt;element name="TransferTypeList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ServiceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_TransferItemStaticData", propOrder = {
    "internalTransferSupplierList",
    "transferTypeList"
})
public class JPTransferItemStaticData {

    @XmlElement(name = "InternalTransferSupplierList")
    protected ArrayOfJPInternalSupplier1 internalTransferSupplierList;
    @XmlElement(name = "TransferTypeList")
    protected ArrayOfJPServiceType transferTypeList;

    /**
     * Gets the value of the internalTransferSupplierList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPInternalSupplier1 }
     *     
     */
    public ArrayOfJPInternalSupplier1 getInternalTransferSupplierList() {
        return internalTransferSupplierList;
    }

    /**
     * Sets the value of the internalTransferSupplierList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPInternalSupplier1 }
     *     
     */
    public void setInternalTransferSupplierList(ArrayOfJPInternalSupplier1 value) {
        this.internalTransferSupplierList = value;
    }

    /**
     * Gets the value of the transferTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPServiceType }
     *     
     */
    public ArrayOfJPServiceType getTransferTypeList() {
        return transferTypeList;
    }

    /**
     * Sets the value of the transferTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPServiceType }
     *     
     */
    public void setTransferTypeList(ArrayOfJPServiceType value) {
        this.transferTypeList = value;
    }

}
