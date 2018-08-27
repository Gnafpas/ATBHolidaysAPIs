
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PackageElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageElement">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BaseElement">
 *       &lt;sequence>
 *         &lt;element name="PackageBookingInfo" type="{http://www.juniper.es/webservice/2007/}JP_PackageBookingInfo" minOccurs="0"/>
 *         &lt;element name="TransfersBookingInfo" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_TransferBookingInfo" minOccurs="0"/>
 *         &lt;element name="ServicesBookingInfo" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ServiceBookingInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageElement", propOrder = {
    "packageBookingInfo",
    "transfersBookingInfo",
    "servicesBookingInfo"
})
public class JPPackageElement
    extends JPBaseElement
{

    @XmlElement(name = "PackageBookingInfo")
    protected JPPackageBookingInfo packageBookingInfo;
    @XmlElement(name = "TransfersBookingInfo")
    protected ArrayOfJPTransferBookingInfo transfersBookingInfo;
    @XmlElement(name = "ServicesBookingInfo")
    protected ArrayOfJPServiceBookingInfo servicesBookingInfo;

    /**
     * Gets the value of the packageBookingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageBookingInfo }
     *     
     */
    public JPPackageBookingInfo getPackageBookingInfo() {
        return packageBookingInfo;
    }

    /**
     * Sets the value of the packageBookingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageBookingInfo }
     *     
     */
    public void setPackageBookingInfo(JPPackageBookingInfo value) {
        this.packageBookingInfo = value;
    }

    /**
     * Gets the value of the transfersBookingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPTransferBookingInfo }
     *     
     */
    public ArrayOfJPTransferBookingInfo getTransfersBookingInfo() {
        return transfersBookingInfo;
    }

    /**
     * Sets the value of the transfersBookingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPTransferBookingInfo }
     *     
     */
    public void setTransfersBookingInfo(ArrayOfJPTransferBookingInfo value) {
        this.transfersBookingInfo = value;
    }

    /**
     * Gets the value of the servicesBookingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPServiceBookingInfo }
     *     
     */
    public ArrayOfJPServiceBookingInfo getServicesBookingInfo() {
        return servicesBookingInfo;
    }

    /**
     * Sets the value of the servicesBookingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPServiceBookingInfo }
     *     
     */
    public void setServicesBookingInfo(ArrayOfJPServiceBookingInfo value) {
        this.servicesBookingInfo = value;
    }

}
