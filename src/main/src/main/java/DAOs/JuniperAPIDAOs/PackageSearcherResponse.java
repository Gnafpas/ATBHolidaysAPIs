
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
 *         &lt;element name="PackageSearcherRS" type="{http://www.juniper.es/webservice/2007/}JP_StaticDataRS" minOccurs="0"/>
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
    "packageSearcherRS"
})
@XmlRootElement(name = "PackageSearcherResponse")
public class PackageSearcherResponse {

    @XmlElement(name = "PackageSearcherRS")
    protected JPStaticDataRS packageSearcherRS;

    /**
     * Gets the value of the packageSearcherRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPStaticDataRS }
     *     
     */
    public JPStaticDataRS getPackageSearcherRS() {
        return packageSearcherRS;
    }

    /**
     * Sets the value of the packageSearcherRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPStaticDataRS }
     *     
     */
    public void setPackageSearcherRS(JPStaticDataRS value) {
        this.packageSearcherRS = value;
    }

}
