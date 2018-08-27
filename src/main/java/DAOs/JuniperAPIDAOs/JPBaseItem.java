
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_BaseItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_BaseItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExternalInfo" type="{http://www.juniper.es/webservice/2007/}JP_ExternalInfo" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *         &lt;element name="CancellationPolicy" type="{http://www.juniper.es/webservice/2007/}JP_CancellationPolicyRules" minOccurs="0"/>
 *         &lt;element name="CancellationPolicyCost" type="{http://www.juniper.es/webservice/2007/}JP_CancellationPolicyRules" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Comment" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ItemId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Status" type="{http://www.juniper.es/webservice/2007/}JP_ItemStatus" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_BaseItem", propOrder = {
    "externalInfo",
    "prices",
    "cancellationPolicy",
    "cancellationPolicyCost",
    "comments"
})
@XmlSeeAlso({
    JPPackageItem.class,
    JPInsuranceItem.class,
    JPTransferItem.class,
    JPFlightItem.class,
    JPHotelItem.class,
    JPRentacarItem.class,
    JPCruiseItem.class,
    JPVisaItem.class,
    JPServiceItem.class
})
public abstract class JPBaseItem {

    @XmlElement(name = "ExternalInfo")
    protected JPExternalInfo externalInfo;
    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;
    @XmlElement(name = "CancellationPolicy")
    protected JPCancellationPolicyRules cancellationPolicy;
    @XmlElement(name = "CancellationPolicyCost")
    protected JPCancellationPolicyRules cancellationPolicyCost;
    @XmlElement(name = "Comments")
    protected ArrayOfJPComment comments;
    @XmlAttribute(name = "ItemId")
    protected String itemId;
    @XmlAttribute(name = "Status")
    protected JPItemStatus status;

    /**
     * Gets the value of the externalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPExternalInfo }
     *     
     */
    public JPExternalInfo getExternalInfo() {
        return externalInfo;
    }

    /**
     * Sets the value of the externalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPExternalInfo }
     *     
     */
    public void setExternalInfo(JPExternalInfo value) {
        this.externalInfo = value;
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
     * Gets the value of the cancellationPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link JPCancellationPolicyRules }
     *     
     */
    public JPCancellationPolicyRules getCancellationPolicy() {
        return cancellationPolicy;
    }

    /**
     * Sets the value of the cancellationPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCancellationPolicyRules }
     *     
     */
    public void setCancellationPolicy(JPCancellationPolicyRules value) {
        this.cancellationPolicy = value;
    }

    /**
     * Gets the value of the cancellationPolicyCost property.
     * 
     * @return
     *     possible object is
     *     {@link JPCancellationPolicyRules }
     *     
     */
    public JPCancellationPolicyRules getCancellationPolicyCost() {
        return cancellationPolicyCost;
    }

    /**
     * Sets the value of the cancellationPolicyCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCancellationPolicyRules }
     *     
     */
    public void setCancellationPolicyCost(JPCancellationPolicyRules value) {
        this.cancellationPolicyCost = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPComment }
     *     
     */
    public ArrayOfJPComment getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPComment }
     *     
     */
    public void setComments(ArrayOfJPComment value) {
        this.comments = value;
    }

    /**
     * Gets the value of the itemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemId(String value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JPItemStatus }
     *     
     */
    public JPItemStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPItemStatus }
     *     
     */
    public void setStatus(JPItemStatus value) {
        this.status = value;
    }

}
