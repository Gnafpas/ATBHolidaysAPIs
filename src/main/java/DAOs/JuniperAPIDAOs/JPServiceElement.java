
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ServiceElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ServiceElement">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BaseElement">
 *       &lt;sequence>
 *         &lt;element name="ServiceBookingInfo" type="{http://www.juniper.es/webservice/2007/}JP_ServiceBookingInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ServiceElement", propOrder = {
    "serviceBookingInfo"
})
public class JPServiceElement
    extends JPBaseElement
{

    @XmlElement(name = "ServiceBookingInfo")
    protected JPServiceBookingInfo serviceBookingInfo;

    /**
     * Gets the value of the serviceBookingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPServiceBookingInfo }
     *     
     */
    public JPServiceBookingInfo getServiceBookingInfo() {
        return serviceBookingInfo;
    }

    /**
     * Sets the value of the serviceBookingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServiceBookingInfo }
     *     
     */
    public void setServiceBookingInfo(JPServiceBookingInfo value) {
        this.serviceBookingInfo = value;
    }

}
