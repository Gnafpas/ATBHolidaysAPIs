
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseElement">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BaseElement">
 *       &lt;sequence>
 *         &lt;element name="CruiseBookingInfo" type="{http://www.juniper.es/webservice/2007/}JP_CruiseBookingInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseElement", propOrder = {
    "cruiseBookingInfo"
})
public class JPCruiseElement
    extends JPBaseElement
{

    @XmlElement(name = "CruiseBookingInfo")
    protected JPCruiseBookingInfo cruiseBookingInfo;

    /**
     * Gets the value of the cruiseBookingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseBookingInfo }
     *     
     */
    public JPCruiseBookingInfo getCruiseBookingInfo() {
        return cruiseBookingInfo;
    }

    /**
     * Sets the value of the cruiseBookingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseBookingInfo }
     *     
     */
    public void setCruiseBookingInfo(JPCruiseBookingInfo value) {
        this.cruiseBookingInfo = value;
    }

}
