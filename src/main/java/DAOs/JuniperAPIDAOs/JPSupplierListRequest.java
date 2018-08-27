
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SupplierListRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SupplierListRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="ProductType" use="required" type="{http://www.juniper.es/webservice/2007/}JP_ProductType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SupplierListRequest")
public class JPSupplierListRequest {

    @XmlAttribute(name = "ProductType", required = true)
    protected JPProductType productType;

    /**
     * Gets the value of the productType property.
     * 
     * @return
     *     possible object is
     *     {@link JPProductType }
     *     
     */
    public JPProductType getProductType() {
        return productType;
    }

    /**
     * Sets the value of the productType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPProductType }
     *     
     */
    public void setProductType(JPProductType value) {
        this.productType = value;
    }

}
