
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
 *         &lt;element name="PackageCalendarPriceRQ" type="{http://www.juniper.es/webservice/2007/}JP_PackageCalendarPriceRQ" minOccurs="0"/>
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
    "packageCalendarPriceRQ"
})
@XmlRootElement(name = "PackageCalendarPrice")
public class PackageCalendarPrice {

    @XmlElement(name = "PackageCalendarPriceRQ")
    protected JPPackageCalendarPriceRQ packageCalendarPriceRQ;

    /**
     * Gets the value of the packageCalendarPriceRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageCalendarPriceRQ }
     *     
     */
    public JPPackageCalendarPriceRQ getPackageCalendarPriceRQ() {
        return packageCalendarPriceRQ;
    }

    /**
     * Sets the value of the packageCalendarPriceRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageCalendarPriceRQ }
     *     
     */
    public void setPackageCalendarPriceRQ(JPPackageCalendarPriceRQ value) {
        this.packageCalendarPriceRQ = value;
    }

}
