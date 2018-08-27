
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ServiceRequiredFields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ServiceRequiredFields">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceBooking" type="{http://www.juniper.es/webservice/2007/}JP_ServiceBooking" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ServiceRequiredFields", propOrder = {
    "serviceBooking"
})
public class JPServiceRequiredFields {

    @XmlElement(name = "ServiceBooking")
    protected JPServiceBooking serviceBooking;

    /**
     * Gets the value of the serviceBooking property.
     * 
     * @return
     *     possible object is
     *     {@link JPServiceBooking }
     *     
     */
    public JPServiceBooking getServiceBooking() {
        return serviceBooking;
    }

    /**
     * Sets the value of the serviceBooking property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServiceBooking }
     *     
     */
    public void setServiceBooking(JPServiceBooking value) {
        this.serviceBooking = value;
    }

}
