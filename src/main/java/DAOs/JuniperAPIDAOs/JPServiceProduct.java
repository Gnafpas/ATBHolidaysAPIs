
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ServiceProduct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ServiceProduct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceInfo" type="{http://www.juniper.es/webservice/2007/}JP_ServiceInfo" minOccurs="0"/>
 *         &lt;element name="ServiceOptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ServiceOption" minOccurs="0"/>
 *         &lt;element name="ServiceBookingInfo" type="{http://www.juniper.es/webservice/2007/}JP_ServiceBookingInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ICode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SearchMore" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Order" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ServiceProduct", propOrder = {
    "serviceInfo",
    "serviceOptions",
    "serviceBookingInfo"
})
public class JPServiceProduct {

    @XmlElement(name = "ServiceInfo")
    protected JPServiceInfo serviceInfo;
    @XmlElement(name = "ServiceOptions")
    protected ArrayOfJPServiceOption serviceOptions;
    @XmlElement(name = "ServiceBookingInfo")
    protected JPServiceBookingInfo serviceBookingInfo;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "ICode")
    protected String iCode;
    @XmlAttribute(name = "SearchMore")
    protected Boolean searchMore;
    @XmlAttribute(name = "Order")
    protected Integer order;

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

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the iCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICode() {
        return iCode;
    }

    /**
     * Sets the value of the iCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICode(String value) {
        this.iCode = value;
    }

    /**
     * Gets the value of the searchMore property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSearchMore() {
        return searchMore;
    }

    /**
     * Sets the value of the searchMore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSearchMore(Boolean value) {
        this.searchMore = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrder(Integer value) {
        this.order = value;
    }

}
