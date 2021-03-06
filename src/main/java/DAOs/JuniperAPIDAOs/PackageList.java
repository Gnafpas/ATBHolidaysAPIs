
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
 *         &lt;element name="PackageListRQ" type="{http://www.juniper.es/webservice/2007/}JP_PackageListRQ" minOccurs="0"/>
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
    "packageListRQ"
})
@XmlRootElement(name = "PackageList")
public class PackageList {

    @XmlElement(name = "PackageListRQ")
    protected JPPackageListRQ packageListRQ;

    /**
     * Gets the value of the packageListRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageListRQ }
     *     
     */
    public JPPackageListRQ getPackageListRQ() {
        return packageListRQ;
    }

    /**
     * Sets the value of the packageListRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageListRQ }
     *     
     */
    public void setPackageListRQ(JPPackageListRQ value) {
        this.packageListRQ = value;
    }

}
