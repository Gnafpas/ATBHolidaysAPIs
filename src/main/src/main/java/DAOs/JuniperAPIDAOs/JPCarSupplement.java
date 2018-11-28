
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CarSupplement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CarSupplement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PriceType" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Units" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="UntMin" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="UntMax" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="PaymentOffice" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Status" use="required" type="{http://www.juniper.es/webservice/2007/}JP_AvailStatus" />
 *       &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CarSupplement", propOrder = {
    "name",
    "description",
    "prices"
})
public class JPCarSupplement {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;
    @XmlAttribute(name = "PriceType")
    protected Integer priceType;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "Units")
    protected Integer units;
    @XmlAttribute(name = "UntMin")
    protected Integer untMin;
    @XmlAttribute(name = "UntMax")
    protected Integer untMax;
    @XmlAttribute(name = "PaymentOffice")
    protected Boolean paymentOffice;
    @XmlAttribute(name = "Status", required = true)
    protected JPAvailStatus status;
    @XmlAttribute(name = "Amount")
    protected Double amount;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
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
     * Gets the value of the priceType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPriceType() {
        return priceType;
    }

    /**
     * Sets the value of the priceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPriceType(Integer value) {
        this.priceType = value;
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
     * Gets the value of the units property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUnits(Integer value) {
        this.units = value;
    }

    /**
     * Gets the value of the untMin property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUntMin() {
        return untMin;
    }

    /**
     * Sets the value of the untMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUntMin(Integer value) {
        this.untMin = value;
    }

    /**
     * Gets the value of the untMax property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUntMax() {
        return untMax;
    }

    /**
     * Sets the value of the untMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUntMax(Integer value) {
        this.untMax = value;
    }

    /**
     * Gets the value of the paymentOffice property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPaymentOffice() {
        return paymentOffice;
    }

    /**
     * Sets the value of the paymentOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPaymentOffice(Boolean value) {
        this.paymentOffice = value;
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
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAmount(Double value) {
        this.amount = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
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

}
