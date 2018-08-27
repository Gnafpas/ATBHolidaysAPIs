
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PackageAdditionalElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageAdditionalElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PackageSupplements" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageAdditionalElement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageAdditionalElements", propOrder = {
    "packageSupplements"
})
public class JPPackageAdditionalElements {

    @XmlElement(name = "PackageSupplements")
    protected ArrayOfJPPackageAdditionalElement packageSupplements;

    /**
     * Gets the value of the packageSupplements property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackageAdditionalElement }
     *     
     */
    public ArrayOfJPPackageAdditionalElement getPackageSupplements() {
        return packageSupplements;
    }

    /**
     * Sets the value of the packageSupplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackageAdditionalElement }
     *     
     */
    public void setPackageSupplements(ArrayOfJPPackageAdditionalElement value) {
        this.packageSupplements = value;
    }

}
