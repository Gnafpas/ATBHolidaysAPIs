
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PackageAvailAdvancedOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageAvailAdvancedOptions">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_AvailAdvancedOptions">
 *       &lt;sequence>
 *         &lt;element name="ShowOnlyAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageAvailAdvancedOptions", propOrder = {
    "showOnlyAvailable"
})
public class JPPackageAvailAdvancedOptions
    extends JPAvailAdvancedOptions
{

    @XmlElement(name = "ShowOnlyAvailable")
    protected Boolean showOnlyAvailable;

    /**
     * Gets the value of the showOnlyAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowOnlyAvailable() {
        return showOnlyAvailable;
    }

    /**
     * Sets the value of the showOnlyAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowOnlyAvailable(Boolean value) {
        this.showOnlyAvailable = value;
    }

}
