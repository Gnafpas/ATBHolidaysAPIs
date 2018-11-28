
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
 *         &lt;element name="ServiceCheckAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_ServiceCheckAvailRQ" minOccurs="0"/>
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
    "serviceCheckAvailRQ"
})
@XmlRootElement(name = "ServiceCheckAvail")
public class ServiceCheckAvail {

    @XmlElement(name = "ServiceCheckAvailRQ")
    protected JPServiceCheckAvailRQ serviceCheckAvailRQ;

    /**
     * Gets the value of the serviceCheckAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPServiceCheckAvailRQ }
     *     
     */
    public JPServiceCheckAvailRQ getServiceCheckAvailRQ() {
        return serviceCheckAvailRQ;
    }

    /**
     * Sets the value of the serviceCheckAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServiceCheckAvailRQ }
     *     
     */
    public void setServiceCheckAvailRQ(JPServiceCheckAvailRQ value) {
        this.serviceCheckAvailRQ = value;
    }

}
