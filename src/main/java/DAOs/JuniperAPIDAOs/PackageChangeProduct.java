
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
 *         &lt;element name="PackageChangeProductRQ" type="{http://www.juniper.es/webservice/2007/}JP_PackageChangeProductRQ" minOccurs="0"/>
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
    "packageChangeProductRQ"
})
@XmlRootElement(name = "PackageChangeProduct")
public class PackageChangeProduct {

    @XmlElement(name = "PackageChangeProductRQ")
    protected JPPackageChangeProductRQ packageChangeProductRQ;

    /**
     * Gets the value of the packageChangeProductRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageChangeProductRQ }
     *     
     */
    public JPPackageChangeProductRQ getPackageChangeProductRQ() {
        return packageChangeProductRQ;
    }

    /**
     * Sets the value of the packageChangeProductRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageChangeProductRQ }
     *     
     */
    public void setPackageChangeProductRQ(JPPackageChangeProductRQ value) {
        this.packageChangeProductRQ = value;
    }

}
