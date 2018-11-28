
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Transfer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Transfer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransferInfo" type="{http://www.juniper.es/webservice/2007/}JP_TransferInfo" minOccurs="0"/>
 *         &lt;element name="TransferOptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_TransferOption" minOccurs="0"/>
 *         &lt;element name="TransferBookingInfo" type="{http://www.juniper.es/webservice/2007/}JP_TransferBookingInfo" minOccurs="0"/>
 *         &lt;element name="Origins" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Origin" minOccurs="0"/>
 *         &lt;element name="Destinations" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Destination" minOccurs="0"/>
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
@XmlType(name = "JP_Transfer", propOrder = {
    "transferInfo",
    "transferOptions",
    "transferBookingInfo",
    "origins",
    "destinations"
})
public class JPTransfer {

    @XmlElement(name = "TransferInfo")
    protected JPTransferInfo transferInfo;
    @XmlElement(name = "TransferOptions")
    protected ArrayOfJPTransferOption transferOptions;
    @XmlElement(name = "TransferBookingInfo")
    protected JPTransferBookingInfo transferBookingInfo;
    @XmlElement(name = "Origins")
    protected ArrayOfJPOrigin origins;
    @XmlElement(name = "Destinations")
    protected ArrayOfJPDestination destinations;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "ICode")
    protected String iCode;
    @XmlAttribute(name = "SearchMore")
    protected Boolean searchMore;
    @XmlAttribute(name = "Order")
    protected Integer order;

    /**
     * Gets the value of the transferInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferInfo }
     *     
     */
    public JPTransferInfo getTransferInfo() {
        return transferInfo;
    }

    /**
     * Sets the value of the transferInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferInfo }
     *     
     */
    public void setTransferInfo(JPTransferInfo value) {
        this.transferInfo = value;
    }

    /**
     * Gets the value of the transferOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPTransferOption }
     *     
     */
    public ArrayOfJPTransferOption getTransferOptions() {
        return transferOptions;
    }

    /**
     * Sets the value of the transferOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPTransferOption }
     *     
     */
    public void setTransferOptions(ArrayOfJPTransferOption value) {
        this.transferOptions = value;
    }

    /**
     * Gets the value of the transferBookingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferBookingInfo }
     *     
     */
    public JPTransferBookingInfo getTransferBookingInfo() {
        return transferBookingInfo;
    }

    /**
     * Sets the value of the transferBookingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferBookingInfo }
     *     
     */
    public void setTransferBookingInfo(JPTransferBookingInfo value) {
        this.transferBookingInfo = value;
    }

    /**
     * Gets the value of the origins property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPOrigin }
     *     
     */
    public ArrayOfJPOrigin getOrigins() {
        return origins;
    }

    /**
     * Sets the value of the origins property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPOrigin }
     *     
     */
    public void setOrigins(ArrayOfJPOrigin value) {
        this.origins = value;
    }

    /**
     * Gets the value of the destinations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPDestination }
     *     
     */
    public ArrayOfJPDestination getDestinations() {
        return destinations;
    }

    /**
     * Sets the value of the destinations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPDestination }
     *     
     */
    public void setDestinations(ArrayOfJPDestination value) {
        this.destinations = value;
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
