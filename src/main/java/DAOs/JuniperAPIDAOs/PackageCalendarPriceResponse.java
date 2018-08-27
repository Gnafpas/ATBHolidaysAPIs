
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
 *         &lt;element name="PackageCalendarPriceRS" type="{http://www.juniper.es/webservice/2007/}JP_StaticDataRS" minOccurs="0"/>
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
    "packageCalendarPriceRS"
})
@XmlRootElement(name = "PackageCalendarPriceResponse")
public class PackageCalendarPriceResponse {

    @XmlElement(name = "PackageCalendarPriceRS")
    protected JPStaticDataRS packageCalendarPriceRS;

    /**
     * Gets the value of the packageCalendarPriceRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPStaticDataRS }
     *     
     */
    public JPStaticDataRS getPackageCalendarPriceRS() {
        return packageCalendarPriceRS;
    }

    /**
     * Sets the value of the packageCalendarPriceRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPStaticDataRS }
     *     
     */
    public void setPackageCalendarPriceRS(JPStaticDataRS value) {
        this.packageCalendarPriceRS = value;
    }

}
