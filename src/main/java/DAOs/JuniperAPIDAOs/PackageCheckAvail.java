
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
 *         &lt;element name="PackageCheckAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_PackageCheckAvailRQ" minOccurs="0"/>
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
    "packageCheckAvailRQ"
})
@XmlRootElement(name = "PackageCheckAvail")
public class PackageCheckAvail {

    @XmlElement(name = "PackageCheckAvailRQ")
    protected JPPackageCheckAvailRQ packageCheckAvailRQ;

    /**
     * Gets the value of the packageCheckAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageCheckAvailRQ }
     *     
     */
    public JPPackageCheckAvailRQ getPackageCheckAvailRQ() {
        return packageCheckAvailRQ;
    }

    /**
     * Sets the value of the packageCheckAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageCheckAvailRQ }
     *     
     */
    public void setPackageCheckAvailRQ(JPPackageCheckAvailRQ value) {
        this.packageCheckAvailRQ = value;
    }

}
