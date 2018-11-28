
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PriceInformationService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PriceInformationService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceInfo" type="{http://www.juniper.es/webservice/2007/}JP_ServiceInfo" minOccurs="0"/>
 *         &lt;element name="ServiceOptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ServiceOption" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PriceInformationService", propOrder = {
    "serviceInfo",
    "serviceOptions"
})
public class JPPriceInformationService {

    @XmlElement(name = "ServiceInfo")
    protected JPServiceInfo serviceInfo;
    @XmlElement(name = "ServiceOptions")
    protected ArrayOfJPServiceOption serviceOptions;

    /**
     * Gets the value of the serviceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPServiceInfo }
     *     
     */
    public JPServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    /**
     * Sets the value of the serviceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServiceInfo }
     *     
     */
    public void setServiceInfo(JPServiceInfo value) {
        this.serviceInfo = value;
    }

    /**
     * Gets the value of the serviceOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPServiceOption }
     *     
     */
    public ArrayOfJPServiceOption getServiceOptions() {
        return serviceOptions;
    }

    /**
     * Sets the value of the serviceOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPServiceOption }
     *     
     */
    public void setServiceOptions(ArrayOfJPServiceOption value) {
        this.serviceOptions = value;
    }

}
