
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PackageCheckAvailRS" type="{http://www.juniper.es/webservice/2007/}JP_CheckAvailRS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "packageCheckAvailRS"
})
@XmlRootElement(name = "PackageCheckAvailResponse")
public class PackageCheckAvailResponse {

    @XmlElement(name = "PackageCheckAvailRS")
    protected JPCheckAvailRS packageCheckAvailRS;

    /**
     * Gets the value of the packageCheckAvailRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPCheckAvailRS }
     *     
     */
    public JPCheckAvailRS getPackageCheckAvailRS() {
        return packageCheckAvailRS;
    }

    /**
     * Sets the value of the packageCheckAvailRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCheckAvailRS }
     *     
     */
    public void setPackageCheckAvailRS(JPCheckAvailRS value) {
        this.packageCheckAvailRS = value;
    }

}
