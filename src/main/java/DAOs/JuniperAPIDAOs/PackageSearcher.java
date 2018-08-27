
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
 *         &lt;element name="PackageSearcherRQ" type="{http://www.juniper.es/webservice/2007/}JP_PackageSearcherRQ" minOccurs="0"/>
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
    "packageSearcherRQ"
})
@XmlRootElement(name = "PackageSearcher")
public class PackageSearcher {

    @XmlElement(name = "PackageSearcherRQ")
    protected JPPackageSearcherRQ packageSearcherRQ;

    /**
     * Gets the value of the packageSearcherRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageSearcherRQ }
     *     
     */
    public JPPackageSearcherRQ getPackageSearcherRQ() {
        return packageSearcherRQ;
    }

    /**
     * Sets the value of the packageSearcherRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageSearcherRQ }
     *     
     */
    public void setPackageSearcherRQ(JPPackageSearcherRQ value) {
        this.packageSearcherRQ = value;
    }

}
