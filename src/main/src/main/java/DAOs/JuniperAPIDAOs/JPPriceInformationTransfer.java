
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PriceInformationTransfer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PriceInformationTransfer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransferInfo" type="{http://www.juniper.es/webservice/2007/}JP_TransferInfo" minOccurs="0"/>
 *         &lt;element name="TransferOptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_TransferOption" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *         &lt;element name="Origins" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Origin" minOccurs="0"/>
 *         &lt;element name="Destinations" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Destination" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PriceInformationTransfer", propOrder = {
    "transferInfo",
    "transferOptions",
    "prices",
    "origins",
    "destinations"
})
public class JPPriceInformationTransfer {

    @XmlElement(name = "TransferInfo")
    protected JPTransferInfo transferInfo;
    @XmlElement(name = "TransferOptions")
    protected ArrayOfJPTransferOption transferOptions;
    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;
    @XmlElement(name = "Origins")
    protected ArrayOfJPOrigin origins;
    @XmlElement(name = "Destinations")
    protected ArrayOfJPDestination destinations;

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
     * Gets the value of the prices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPrice }
     *     
     */
    public ArrayOfJPPrice getPrices() {
        return prices;
    }

    /**
     * Sets the value of the prices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPrice }
     *     
     */
    public void setPrices(ArrayOfJPPrice value) {
        this.prices = value;
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

}
