
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelBookingRulesAdvancedOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelBookingRulesAdvancedOptions">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BookingRulesAdvancedOptions">
 *       &lt;sequence>
 *         &lt;element name="ShowCompleteInfo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelBookingRulesAdvancedOptions", propOrder = {
    "showCompleteInfo"
})
public class JPHotelBookingRulesAdvancedOptions
    extends JPBookingRulesAdvancedOptions
{

    @XmlElement(name = "ShowCompleteInfo")
    protected Boolean showCompleteInfo;

    /**
     * Gets the value of the showCompleteInfo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowCompleteInfo() {
        return showCompleteInfo;
    }

    /**
     * Sets the value of the showCompleteInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowCompleteInfo(Boolean value) {
        this.showCompleteInfo = value;
    }

}
