
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
 *         &lt;element name="PackageListRS" type="{http://www.juniper.es/webservice/2007/}JP_StaticDataRS" minOccurs="0"/>
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
    "packageListRS"
})
@XmlRootElement(name = "PackageListResponse")
public class PackageListResponse {

    @XmlElement(name = "PackageListRS")
    protected JPStaticDataRS packageListRS;

    /**
     * Gets the value of the packageListRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPStaticDataRS }
     *     
     */
    public JPStaticDataRS getPackageListRS() {
        return packageListRS;
    }

    /**
     * Sets the value of the packageListRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPStaticDataRS }
     *     
     */
    public void setPackageListRS(JPStaticDataRS value) {
        this.packageListRS = value;
    }

}
