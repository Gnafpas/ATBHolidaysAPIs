
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
 *         &lt;element name="PackageBookingRulesRQ" type="{http://www.juniper.es/webservice/2007/}JP_PackageBookingRulesRQ" minOccurs="0"/>
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
    "packageBookingRulesRQ"
})
@XmlRootElement(name = "PackageBookingRules")
public class PackageBookingRules {

    @XmlElement(name = "PackageBookingRulesRQ")
    protected JPPackageBookingRulesRQ packageBookingRulesRQ;

    /**
     * Gets the value of the packageBookingRulesRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageBookingRulesRQ }
     *     
     */
    public JPPackageBookingRulesRQ getPackageBookingRulesRQ() {
        return packageBookingRulesRQ;
    }

    /**
     * Sets the value of the packageBookingRulesRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageBookingRulesRQ }
     *     
     */
    public void setPackageBookingRulesRQ(JPPackageBookingRulesRQ value) {
        this.packageBookingRulesRQ = value;
    }

}
