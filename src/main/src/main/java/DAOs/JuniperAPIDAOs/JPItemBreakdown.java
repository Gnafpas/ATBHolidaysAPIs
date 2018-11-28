
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_ItemBreakdown complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ItemBreakdown">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Date" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Days" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="PaxType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TtaCode" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="SupplierAmount" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="SupplierCurrency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Source" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ItemBreakdown")
public class JPItemBreakdown {

    @XmlAttribute(name = "Amount")
    protected Double amount;
    @XmlAttribute(name = "Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlAttribute(name = "Quantity")
    protected Integer quantity;
    @XmlAttribute(name = "Days")
    protected Integer days;
    @XmlAttribute(name = "PaxType")
    protected String paxType;
    @XmlAttribute(name = "TtaCode")
    protected Integer ttaCode;
    @XmlAttribute(name = "SupplierAmount")
    protected Double supplierAmount;
    @XmlAttribute(name = "SupplierCurrency")
    protected String supplierCurrency;
    @XmlAttribute(name = "Source")
    protected String source;

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
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
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
     * Gets the value of the days property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDays() {
        return days;
    }

    /**
     * Sets the value of the days property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDays(Integer value) {
        this.days = value;
    }

    /**
     * Gets the value of the paxType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaxType() {
        return paxType;
    }

    /**
     * Sets the value of the paxType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaxType(String value) {
        this.paxType = value;
    }

    /**
     * Gets the value of the ttaCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTtaCode() {
        return ttaCode;
    }

    /**
     * Sets the value of the ttaCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTtaCode(Integer value) {
        this.ttaCode = value;
    }

    /**
     * Gets the value of the supplierAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSupplierAmount() {
        return supplierAmount;
    }

    /**
     * Sets the value of the supplierAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSupplierAmount(Double value) {
        this.supplierAmount = value;
    }

    /**
     * Gets the value of the supplierCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierCurrency() {
        return supplierCurrency;
    }

    /**
     * Sets the value of the supplierCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierCurrency(String value) {
        this.supplierCurrency = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

}
