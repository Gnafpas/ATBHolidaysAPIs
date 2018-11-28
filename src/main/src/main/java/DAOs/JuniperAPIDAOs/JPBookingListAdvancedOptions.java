
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_BookingListAdvancedOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_BookingListAdvancedOptions">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BaseAdvancedOptions">
 *       &lt;sequence>
 *         &lt;element name="AllStatus" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_BookingListAdvancedOptions", propOrder = {
    "allStatus"
})
public class JPBookingListAdvancedOptions
    extends JPBaseAdvancedOptions
{

    @XmlElement(name = "AllStatus")
    protected Boolean allStatus;

    /**
     * Gets the value of the allStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllStatus() {
        return allStatus;
    }

    /**
     * Sets the value of the allStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllStatus(Boolean value) {
        this.allStatus = value;
    }

}
