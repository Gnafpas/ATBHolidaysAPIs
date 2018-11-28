
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
 *         &lt;element name="PackageAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_PackageAvailabilityRQ" minOccurs="0"/>
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
    "packageAvailRQ"
})
@XmlRootElement(name = "PackageAvail")
public class PackageAvail {

    @XmlElement(name = "PackageAvailRQ")
    protected JPPackageAvailabilityRQ packageAvailRQ;

    /**
     * Gets the value of the packageAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageAvailabilityRQ }
     *     
     */
    public JPPackageAvailabilityRQ getPackageAvailRQ() {
        return packageAvailRQ;
    }

    /**
     * Sets the value of the packageAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageAvailabilityRQ }
     *     
     */
    public void setPackageAvailRQ(JPPackageAvailabilityRQ value) {
        this.packageAvailRQ = value;
    }

}
