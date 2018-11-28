
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PackageList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Packages" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackagesCodeList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageList", propOrder = {
    "packages"
})
public class JPPackageList {

    @XmlElement(name = "Packages")
    protected ArrayOfJPPackagesCodeList packages;

    /**
     * Gets the value of the packages property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackagesCodeList }
     *     
     */
    public ArrayOfJPPackagesCodeList getPackages() {
        return packages;
    }

    /**
     * Sets the value of the packages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackagesCodeList }
     *     
     */
    public void setPackages(ArrayOfJPPackagesCodeList value) {
        this.packages = value;
    }

}
