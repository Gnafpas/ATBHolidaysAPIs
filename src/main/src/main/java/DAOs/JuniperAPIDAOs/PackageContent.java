
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
 *         &lt;element name="PackageContentRQ" type="{http://www.juniper.es/webservice/2007/}JP_PackageContentRQ" minOccurs="0"/>
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
    "packageContentRQ"
})
@XmlRootElement(name = "PackageContent")
public class PackageContent {

    @XmlElement(name = "PackageContentRQ")
    protected JPPackageContentRQ packageContentRQ;

    /**
     * Gets the value of the packageContentRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageContentRQ }
     *     
     */
    public JPPackageContentRQ getPackageContentRQ() {
        return packageContentRQ;
    }

    /**
     * Sets the value of the packageContentRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageContentRQ }
     *     
     */
    public void setPackageContentRQ(JPPackageContentRQ value) {
        this.packageContentRQ = value;
    }

}
