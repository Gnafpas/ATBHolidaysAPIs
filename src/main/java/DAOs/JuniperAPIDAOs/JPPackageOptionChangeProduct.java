
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PackageOptionChangeProduct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageOptionChangeProduct">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_PackageOptionRQ">
 *       &lt;attribute name="ProductType" type="{http://www.juniper.es/webservice/2007/}JP_ProductType" />
 *       &lt;attribute name="ICode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageOptionChangeProduct")
public class JPPackageOptionChangeProduct
    extends JPPackageOptionRQ
{

    @XmlAttribute(name = "ProductType")
    protected JPProductType productType;
    @XmlAttribute(name = "ICode")
    protected String iCode;

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

    /**
     * Gets the value of the iCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICode() {
        return iCode;
    }

    /**
     * Sets the value of the iCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICode(String value) {
        this.iCode = value;
    }

}
