
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelOption">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Supplier" type="{http://www.juniper.es/webservice/2007/}JP_Supplier" minOccurs="0"/>
 *         &lt;element name="Board" type="{http://www.juniper.es/webservice/2007/}JP_Board" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *         &lt;element name="CancellationPolicy" type="{http://www.juniper.es/webservice/2007/}JP_CancellationPolicyRules" minOccurs="0"/>
 *         &lt;element name="CancellationPolicyCost" type="{http://www.juniper.es/webservice/2007/}JP_CancellationPolicyRules" minOccurs="0"/>
 *         &lt;element name="HotelRooms" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelRoom" minOccurs="0"/>
 *         &lt;element name="AdditionalElements" type="{http://www.juniper.es/webservice/2007/}JP_HotelAdditionalElements" minOccurs="0"/>
 *         &lt;element name="ProductType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PaymentDestination" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Status" type="{http://www.juniper.es/webservice/2007/}JP_AvailStatus" />
 *       &lt;attribute name="NonRefundable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="PackageContract" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="DynamicInventory" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ExtranetContract" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelOption", propOrder = {
    "supplier",
    "board",
    "prices",
    "cancellationPolicy",
    "cancellationPolicyCost",
    "hotelRooms",
    "additionalElements",
    "productType"
})
public class JPHotelOption {

    @XmlElement(name = "Supplier")
    protected JPSupplier supplier;
    @XmlElement(name = "Board")
    protected JPBoard board;
    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;
    @XmlElement(name = "CancellationPolicy")
    protected JPCancellationPolicyRules cancellationPolicy;
    @XmlElement(name = "CancellationPolicyCost")
    protected JPCancellationPolicyRules cancellationPolicyCost;
    @XmlElement(name = "HotelRooms")
    protected ArrayOfJPHotelRoom hotelRooms;
    @XmlElement(name = "AdditionalElements")
    protected JPHotelAdditionalElements additionalElements;
    @XmlElement(name = "ProductType")
    protected String productType;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;
    @XmlAttribute(name = "PaymentDestination")
    protected Boolean paymentDestination;
    @XmlAttribute(name = "Status")
    protected JPAvailStatus status;
    @XmlAttribute(name = "NonRefundable")
    protected Boolean nonRefundable;
    @XmlAttribute(name = "PackageContract", required = true)
    protected boolean packageContract;
    @XmlAttribute(name = "DynamicInventory")
    protected Boolean dynamicInventory;
    @XmlAttribute(name = "ExtranetContract")
    protected Boolean extranetContract;

    /**
     * Gets the value of the supplier property.
     * 
     * @return
     *     possible object is
     *     {@link JPSupplier }
     *     
     */
    public JPSupplier getSupplier() {
        return supplier;
    }

    /**
     * Sets the value of the supplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSupplier }
     *     
     */
    public void setSupplier(JPSupplier value) {
        this.supplier = value;
    }

    /**
     * Gets the value of the board property.
     * 
     * @return
     *     possible object is
     *     {@link JPBoard }
     *     
     */
    public JPBoard getBoard() {
        return board;
    }

    /**
     * Sets the value of the board property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBoard }
     *     
     */
    public void setBoard(JPBoard value) {
        this.board = value;
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
     * Gets the value of the hotelRooms property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelRoom }
     *     
     */
    public ArrayOfJPHotelRoom getHotelRooms() {
        return hotelRooms;
    }

    /**
     * Sets the value of the hotelRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelRoom }
     *     
     */
    public void setHotelRooms(ArrayOfJPHotelRoom value) {
        this.hotelRooms = value;
    }

    /**
     * Gets the value of the additionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelAdditionalElements }
     *     
     */
    public JPHotelAdditionalElements getAdditionalElements() {
        return additionalElements;
    }

    /**
     * Sets the value of the additionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelAdditionalElements }
     *     
     */
    public void setAdditionalElements(JPHotelAdditionalElements value) {
        this.additionalElements = value;
    }

    /**
     * Gets the value of the productType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductType() {
        return productType;
    }

    /**
     * Sets the value of the productType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductType(String value) {
        this.productType = value;
    }

    /**
     * Gets the value of the ratePlanCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRatePlanCode() {
        return ratePlanCode;
    }

    /**
     * Sets the value of the ratePlanCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatePlanCode(String value) {
        this.ratePlanCode = value;
    }

    /**
     * Gets the value of the paymentDestination property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPaymentDestination() {
        return paymentDestination;
    }

    /**
     * Sets the value of the paymentDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPaymentDestination(Boolean value) {
        this.paymentDestination = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JPAvailStatus }
     *     
     */
    public JPAvailStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPAvailStatus }
     *     
     */
    public void setStatus(JPAvailStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the nonRefundable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNonRefundable() {
        return nonRefundable;
    }

    /**
     * Sets the value of the nonRefundable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNonRefundable(Boolean value) {
        this.nonRefundable = value;
    }

    /**
     * Gets the value of the packageContract property.
     * 
     */
    public boolean isPackageContract() {
        return packageContract;
    }

    /**
     * Sets the value of the packageContract property.
     * 
     */
    public void setPackageContract(boolean value) {
        this.packageContract = value;
    }

    /**
     * Gets the value of the dynamicInventory property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDynamicInventory() {
        return dynamicInventory;
    }

    /**
     * Sets the value of the dynamicInventory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDynamicInventory(Boolean value) {
        this.dynamicInventory = value;
    }

    /**
     * Gets the value of the extranetContract property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExtranetContract() {
        return extranetContract;
    }

    /**
     * Sets the value of the extranetContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExtranetContract(Boolean value) {
        this.extranetContract = value;
    }

}
