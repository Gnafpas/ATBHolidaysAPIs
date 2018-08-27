
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ServiceItemStaticData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ServiceItemStaticData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InternalServiceSupplierList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_InternalSupplier" minOccurs="0"/>
 *         &lt;element name="ServiceCategoryList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ServiceCategory" minOccurs="0"/>
 *         &lt;element name="ServiceTypeList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ServiceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ServiceItemStaticData", propOrder = {
    "internalServiceSupplierList",
    "serviceCategoryList",
    "serviceTypeList"
})
public class JPServiceItemStaticData {

    @XmlElement(name = "InternalServiceSupplierList")
    protected ArrayOfJPInternalSupplier internalServiceSupplierList;
    @XmlElement(name = "ServiceCategoryList")
    protected ArrayOfJPServiceCategory serviceCategoryList;
    @XmlElement(name = "ServiceTypeList")
    protected ArrayOfJPServiceType serviceTypeList;

    /**
     * Gets the value of the internalServiceSupplierList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPInternalSupplier }
     *     
     */
    public ArrayOfJPInternalSupplier getInternalServiceSupplierList() {
        return internalServiceSupplierList;
    }

    /**
     * Sets the value of the internalServiceSupplierList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPInternalSupplier }
     *     
     */
    public void setInternalServiceSupplierList(ArrayOfJPInternalSupplier value) {
        this.internalServiceSupplierList = value;
    }

    /**
     * Gets the value of the serviceCategoryList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPServiceCategory }
     *     
     */
    public ArrayOfJPServiceCategory getServiceCategoryList() {
        return serviceCategoryList;
    }

    /**
     * Sets the value of the serviceCategoryList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPServiceCategory }
     *     
     */
    public void setServiceCategoryList(ArrayOfJPServiceCategory value) {
        this.serviceCategoryList = value;
    }

    /**
     * Gets the value of the serviceTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPServiceType }
     *     
     */
    public ArrayOfJPServiceType getServiceTypeList() {
        return serviceTypeList;
    }

    /**
     * Sets the value of the serviceTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPServiceType }
     *     
     */
    public void setServiceTypeList(ArrayOfJPServiceType value) {
        this.serviceTypeList = value;
    }

}
