
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseBookingRulesAdvancedOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseBookingRulesAdvancedOptions">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BookingRulesAdvancedOptions">
 *       &lt;sequence>
 *         &lt;element name="ShowCruiseInfo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseBookingRulesAdvancedOptions", propOrder = {
    "showCruiseInfo"
})
public class JPCruiseBookingRulesAdvancedOptions
    extends JPBookingRulesAdvancedOptions
{

    @XmlElement(name = "ShowCruiseInfo")
    protected Boolean showCruiseInfo;

    /**
     * Gets the value of the showCruiseInfo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowCruiseInfo() {
        return showCruiseInfo;
    }

    /**
     * Sets the value of the showCruiseInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowCruiseInfo(Boolean value) {
        this.showCruiseInfo = value;
    }

}
