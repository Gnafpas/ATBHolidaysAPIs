
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PackageBookingRuleRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageBookingRuleRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PackageOption" type="{http://www.juniper.es/webservice/2007/}JP_PackageOptionRQ" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageBookingRuleRequest", propOrder = {
    "packageOption"
})
public class JPPackageBookingRuleRequest {

    @XmlElement(name = "PackageOption")
    protected JPPackageOptionRQ packageOption;

    /**
     * Gets the value of the packageOption property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageOptionRQ }
     *     
     */
    public JPPackageOptionRQ getPackageOption() {
        return packageOption;
    }

    /**
     * Sets the value of the packageOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageOptionRQ }
     *     
     */
    public void setPackageOption(JPPackageOptionRQ value) {
        this.packageOption = value;
    }

}
