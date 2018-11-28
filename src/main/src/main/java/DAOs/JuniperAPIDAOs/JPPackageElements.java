
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PackageElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PackageElement" type="{http://www.juniper.es/webservice/2007/}JP_PackageElement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageElements", propOrder = {
    "packageElement"
})
public class JPPackageElements {

    @XmlElement(name = "PackageElement")
    protected JPPackageElement packageElement;

    /**
     * Gets the value of the packageElement property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageElement }
     *     
     */
    public JPPackageElement getPackageElement() {
        return packageElement;
    }

    /**
     * Sets the value of the packageElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageElement }
     *     
     */
    public void setPackageElement(JPPackageElement value) {
        this.packageElement = value;
    }

}
