
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_VisaItemStaticData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_VisaItemStaticData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InternalVisaSupplierList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_InternalSupplier2" minOccurs="0"/>
 *         &lt;element name="VisaTypeList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ServiceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_VisaItemStaticData", propOrder = {
    "internalVisaSupplierList",
    "visaTypeList"
})
public class JPVisaItemStaticData {

    @XmlElement(name = "InternalVisaSupplierList")
    protected ArrayOfJPInternalSupplier2 internalVisaSupplierList;
    @XmlElement(name = "VisaTypeList")
    protected ArrayOfJPServiceType visaTypeList;

    /**
     * Gets the value of the internalVisaSupplierList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPInternalSupplier2 }
     *     
     */
    public ArrayOfJPInternalSupplier2 getInternalVisaSupplierList() {
        return internalVisaSupplierList;
    }

    /**
     * Sets the value of the internalVisaSupplierList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPInternalSupplier2 }
     *     
     */
    public void setInternalVisaSupplierList(ArrayOfJPInternalSupplier2 value) {
        this.internalVisaSupplierList = value;
    }

    /**
     * Gets the value of the visaTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPServiceType }
     *     
     */
    public ArrayOfJPServiceType getVisaTypeList() {
        return visaTypeList;
    }

    /**
     * Sets the value of the visaTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPServiceType }
     *     
     */
    public void setVisaTypeList(ArrayOfJPServiceType value) {
        this.visaTypeList = value;
    }

}
