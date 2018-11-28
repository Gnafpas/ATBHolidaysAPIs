
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PackageSearcherRS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageSearcherRS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PackageSearcherItems" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageSearcherItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageSearcherRS", propOrder = {
    "packageSearcherItems"
})
public class JPPackageSearcherRS {

    @XmlElement(name = "PackageSearcherItems")
    protected ArrayOfJPPackageSearcherItem packageSearcherItems;

    /**
     * Gets the value of the packageSearcherItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackageSearcherItem }
     *     
     */
    public ArrayOfJPPackageSearcherItem getPackageSearcherItems() {
        return packageSearcherItems;
    }

    /**
     * Sets the value of the packageSearcherItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackageSearcherItem }
     *     
     */
    public void setPackageSearcherItems(ArrayOfJPPackageSearcherItem value) {
        this.packageSearcherItems = value;
    }

}
