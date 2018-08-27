
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PackageChangeProductRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageChangeProductRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PackageOption" type="{http://www.juniper.es/webservice/2007/}JP_PackageOptionChangeProduct" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageChangeProductRequest", propOrder = {
    "packageOption"
})
public class JPPackageChangeProductRequest {

    @XmlElement(name = "PackageOption")
    protected JPPackageOptionChangeProduct packageOption;

    /**
     * Gets the value of the packageOption property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageOptionChangeProduct }
     *     
     */
    public JPPackageOptionChangeProduct getPackageOption() {
        return packageOption;
    }

    /**
     * Sets the value of the packageOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageOptionChangeProduct }
     *     
     */
    public void setPackageOption(JPPackageOptionChangeProduct value) {
        this.packageOption = value;
    }

}
