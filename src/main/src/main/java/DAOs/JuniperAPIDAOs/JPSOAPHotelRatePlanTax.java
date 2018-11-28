
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_hotelRatePlanTax complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_hotelRatePlanTax">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Date" type="{http://www.juniper.es/webservice/2007/}JPSOAP_DateIntervals" minOccurs="0"/>
 *         &lt;element name="SupplementTypes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_IntCodeAttr1" minOccurs="0"/>
 *         &lt;element name="Ages" type="{http://www.juniper.es/webservice/2007/}JPSOAP_Ages" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Type" use="required" type="{http://www.juniper.es/webservice/2007/}JPSOAP_TaxTypes" />
 *       &lt;attribute name="Amount" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="IsFix" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Comissionable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="CancellationCharges" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="IncludedTaxes" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="InfantAmount" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="ChildAAmount" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="ChildBAmount" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_hotelRatePlanTax", propOrder = {
    "name",
    "date",
    "supplementTypes",
    "ages"
})
public class JPSOAPHotelRatePlanTax {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Date")
    protected JPSOAPDateIntervals date;
    @XmlElement(name = "SupplementTypes")
    protected ArrayOfJPSOAPIntCodeAttr1 supplementTypes;
    @XmlElement(name = "Ages")
    protected JPSOAPAges ages;
    @XmlAttribute(name = "Code", required = true)
    protected int code;
    @XmlAttribute(name = "Type", required = true)
    protected JPSOAPTaxTypes type;
    @XmlAttribute(name = "Amount", required = true)
    protected double amount;
    @XmlAttribute(name = "IsFix", required = true)
    protected boolean isFix;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "Comissionable", required = true)
    protected boolean comissionable;
    @XmlAttribute(name = "CancellationCharges", required = true)
    protected boolean cancellationCharges;
    @XmlAttribute(name = "IncludedTaxes", required = true)
    protected boolean includedTaxes;
    @XmlAttribute(name = "InfantAmount")
    protected Double infantAmount;
    @XmlAttribute(name = "ChildAAmount")
    protected Double childAAmount;
    @XmlAttribute(name = "ChildBAmount")
    protected Double childBAmount;

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
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPDateIntervals }
     *     
     */
    public JPSOAPDateIntervals getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPDateIntervals }
     *     
     */
    public void setDate(JPSOAPDateIntervals value) {
        this.date = value;
    }

    /**
     * Gets the value of the supplementTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPIntCodeAttr1 }
     *     
     */
    public ArrayOfJPSOAPIntCodeAttr1 getSupplementTypes() {
        return supplementTypes;
    }

    /**
     * Sets the value of the supplementTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPIntCodeAttr1 }
     *     
     */
    public void setSupplementTypes(ArrayOfJPSOAPIntCodeAttr1 value) {
        this.supplementTypes = value;
    }

    /**
     * Gets the value of the ages property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPAges }
     *     
     */
    public JPSOAPAges getAges() {
        return ages;
    }

    /**
     * Sets the value of the ages property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPAges }
     *     
     */
    public void setAges(JPSOAPAges value) {
        this.ages = value;
    }

    /**
     * Gets the value of the code property.
     * 
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     */
    public void setCode(int value) {
        this.code = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPTaxTypes }
     *     
     */
    public JPSOAPTaxTypes getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPTaxTypes }
     *     
     */
    public void setType(JPSOAPTaxTypes value) {
        this.type = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(double value) {
        this.amount = value;
    }

    /**
     * Gets the value of the isFix property.
     * 
     */
    public boolean isIsFix() {
        return isFix;
    }

    /**
     * Sets the value of the isFix property.
     * 
     */
    public void setIsFix(boolean value) {
        this.isFix = value;
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
     * Gets the value of the comissionable property.
     * 
     */
    public boolean isComissionable() {
        return comissionable;
    }

    /**
     * Sets the value of the comissionable property.
     * 
     */
    public void setComissionable(boolean value) {
        this.comissionable = value;
    }

    /**
     * Gets the value of the cancellationCharges property.
     * 
     */
    public boolean isCancellationCharges() {
        return cancellationCharges;
    }

    /**
     * Sets the value of the cancellationCharges property.
     * 
     */
    public void setCancellationCharges(boolean value) {
        this.cancellationCharges = value;
    }

    /**
     * Gets the value of the includedTaxes property.
     * 
     */
    public boolean isIncludedTaxes() {
        return includedTaxes;
    }

    /**
     * Sets the value of the includedTaxes property.
     * 
     */
    public void setIncludedTaxes(boolean value) {
        this.includedTaxes = value;
    }

    /**
     * Gets the value of the infantAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInfantAmount() {
        return infantAmount;
    }

    /**
     * Sets the value of the infantAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInfantAmount(Double value) {
        this.infantAmount = value;
    }

    /**
     * Gets the value of the childAAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getChildAAmount() {
        return childAAmount;
    }

    /**
     * Sets the value of the childAAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setChildAAmount(Double value) {
        this.childAAmount = value;
    }

    /**
     * Gets the value of the childBAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getChildBAmount() {
        return childBAmount;
    }

    /**
     * Sets the value of the childBAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setChildBAmount(Double value) {
        this.childBAmount = value;
    }

}
