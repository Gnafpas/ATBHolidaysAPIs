
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_HotelAdditionalElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelAdditionalElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FreeNights" type="{http://www.juniper.es/webservice/2007/}JP_FreeNights" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *         &lt;element name="SupplementRelPaxesDist" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_SupplementRelPaxDist" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="JPCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Type" type="{http://www.juniper.es/webservice/2007/}JP_SupplementType" />
 *       &lt;attribute name="Category" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SpecialType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DirectPayment" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="NonRefundable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Optional" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Begin" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="End" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ServiceDuration" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="RoomCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PaymentDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="CostValue" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Percentatge" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelAdditionalElement", propOrder = {
    "name",
    "description",
    "freeNights",
    "prices",
    "supplementRelPaxesDist"
})
public class JPHotelAdditionalElement {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "FreeNights")
    protected JPFreeNights freeNights;
    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;
    @XmlElement(name = "SupplementRelPaxesDist")
    protected ArrayOfJPSupplementRelPaxDist supplementRelPaxesDist;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "JPCode")
    protected String jpCode;
    @XmlAttribute(name = "Class")
    protected String clazz;
    @XmlAttribute(name = "Type")
    protected JPSupplementType type;
    @XmlAttribute(name = "Category")
    protected String category;
    @XmlAttribute(name = "SpecialType")
    protected String specialType;
    @XmlAttribute(name = "DirectPayment")
    protected Boolean directPayment;
    @XmlAttribute(name = "NonRefundable")
    protected Boolean nonRefundable;
    @XmlAttribute(name = "Optional")
    protected Boolean optional;
    @XmlAttribute(name = "Quantity")
    protected Integer quantity;
    @XmlAttribute(name = "Begin")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar begin;
    @XmlAttribute(name = "End")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;
    @XmlAttribute(name = "Amount")
    protected Double amount;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;
    @XmlAttribute(name = "ServiceDuration")
    protected Integer serviceDuration;
    @XmlAttribute(name = "RoomCategory")
    protected String roomCategory;
    @XmlAttribute(name = "PaymentDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar paymentDate;
    @XmlAttribute(name = "CostValue")
    protected Double costValue;
    @XmlAttribute(name = "Percentatge")
    protected Double percentatge;

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
     * Gets the value of the freeNights property.
     * 
     * @return
     *     possible object is
     *     {@link JPFreeNights }
     *     
     */
    public JPFreeNights getFreeNights() {
        return freeNights;
    }

    /**
     * Sets the value of the freeNights property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFreeNights }
     *     
     */
    public void setFreeNights(JPFreeNights value) {
        this.freeNights = value;
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
     * Gets the value of the supplementRelPaxesDist property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSupplementRelPaxDist }
     *     
     */
    public ArrayOfJPSupplementRelPaxDist getSupplementRelPaxesDist() {
        return supplementRelPaxesDist;
    }

    /**
     * Sets the value of the supplementRelPaxesDist property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSupplementRelPaxDist }
     *     
     */
    public void setSupplementRelPaxesDist(ArrayOfJPSupplementRelPaxDist value) {
        this.supplementRelPaxesDist = value;
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
     * Gets the value of the jpCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJPCode() {
        return jpCode;
    }

    /**
     * Sets the value of the jpCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJPCode(String value) {
        this.jpCode = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JPSupplementType }
     *     
     */
    public JPSupplementType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSupplementType }
     *     
     */
    public void setType(JPSupplementType value) {
        this.type = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the specialType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialType() {
        return specialType;
    }

    /**
     * Sets the value of the specialType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialType(String value) {
        this.specialType = value;
    }

    /**
     * Gets the value of the directPayment property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDirectPayment() {
        return directPayment;
    }

    /**
     * Sets the value of the directPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDirectPayment(Boolean value) {
        this.directPayment = value;
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
     * Gets the value of the optional property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOptional() {
        return optional;
    }

    /**
     * Sets the value of the optional property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOptional(Boolean value) {
        this.optional = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuantity(Integer value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the begin property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBegin() {
        return begin;
    }

    /**
     * Sets the value of the begin property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBegin(XMLGregorianCalendar value) {
        this.begin = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnd(XMLGregorianCalendar value) {
        this.end = value;
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

    /**
     * Gets the value of the serviceDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getServiceDuration() {
        return serviceDuration;
    }

    /**
     * Sets the value of the serviceDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setServiceDuration(Integer value) {
        this.serviceDuration = value;
    }

    /**
     * Gets the value of the roomCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomCategory() {
        return roomCategory;
    }

    /**
     * Sets the value of the roomCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomCategory(String value) {
        this.roomCategory = value;
    }

    /**
     * Gets the value of the paymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the value of the paymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaymentDate(XMLGregorianCalendar value) {
        this.paymentDate = value;
    }

    /**
     * Gets the value of the costValue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCostValue() {
        return costValue;
    }

    /**
     * Sets the value of the costValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCostValue(Double value) {
        this.costValue = value;
    }

    /**
     * Gets the value of the percentatge property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentatge() {
        return percentatge;
    }

    /**
     * Sets the value of the percentatge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentatge(Double value) {
        this.percentatge = value;
    }

}
