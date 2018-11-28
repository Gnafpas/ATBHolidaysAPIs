
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CommonPriceBreakdown complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CommonPriceBreakdown">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TtaCodes" type="{http://www.juniper.es/webservice/2007/}ArrayOfInt" minOccurs="0"/>
 *         &lt;element name="Total" type="{http://www.juniper.es/webservice/2007/}JP_CommonPriceBreakdownReduced" minOccurs="0"/>
 *         &lt;element name="Commission" type="{http://www.juniper.es/webservice/2007/}JP_CommonPriceBreakdownReduced" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Type">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="A"/>
 *             &lt;enumeration value="P"/>
 *             &lt;enumeration value="V"/>
 *             &lt;enumeration value="C"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Value" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="IsFix" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="TaxAAmount" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="TaxBAmount" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="ByNight" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Commissionable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Included" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CommonPriceBreakdown", propOrder = {
    "ttaCodes",
    "total",
    "commission"
})
public class JPCommonPriceBreakdown {

    @XmlElement(name = "TtaCodes")
    protected ArrayOfInt ttaCodes;
    @XmlElement(name = "Total")
    protected JPCommonPriceBreakdownReduced total;
    @XmlElement(name = "Commission")
    protected JPCommonPriceBreakdownReduced commission;
    @XmlAttribute(name = "Type")
    protected String type;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "Value")
    protected Double value;
    @XmlAttribute(name = "IsFix")
    protected Boolean isFix;
    @XmlAttribute(name = "TaxAAmount")
    protected Double taxAAmount;
    @XmlAttribute(name = "TaxBAmount")
    protected Double taxBAmount;
    @XmlAttribute(name = "ByNight")
    protected Boolean byNight;
    @XmlAttribute(name = "Commissionable")
    protected Boolean commissionable;
    @XmlAttribute(name = "Included")
    protected Boolean included;

    /**
     * Gets the value of the ttaCodes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getTtaCodes() {
        return ttaCodes;
    }

    /**
     * Sets the value of the ttaCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setTtaCodes(ArrayOfInt value) {
        this.ttaCodes = value;
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link JPCommonPriceBreakdownReduced }
     *     
     */
    public JPCommonPriceBreakdownReduced getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCommonPriceBreakdownReduced }
     *     
     */
    public void setTotal(JPCommonPriceBreakdownReduced value) {
        this.total = value;
    }

    /**
     * Gets the value of the commission property.
     * 
     * @return
     *     possible object is
     *     {@link JPCommonPriceBreakdownReduced }
     *     
     */
    public JPCommonPriceBreakdownReduced getCommission() {
        return commission;
    }

    /**
     * Sets the value of the commission property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCommonPriceBreakdownReduced }
     *     
     */
    public void setCommission(JPCommonPriceBreakdownReduced value) {
        this.commission = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

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
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /**
     * Gets the value of the isFix property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsFix() {
        return isFix;
    }

    /**
     * Sets the value of the isFix property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsFix(Boolean value) {
        this.isFix = value;
    }

    /**
     * Gets the value of the taxAAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTaxAAmount() {
        return taxAAmount;
    }

    /**
     * Sets the value of the taxAAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTaxAAmount(Double value) {
        this.taxAAmount = value;
    }

    /**
     * Gets the value of the taxBAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTaxBAmount() {
        return taxBAmount;
    }

    /**
     * Sets the value of the taxBAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTaxBAmount(Double value) {
        this.taxBAmount = value;
    }

    /**
     * Gets the value of the byNight property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isByNight() {
        return byNight;
    }

    /**
     * Sets the value of the byNight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setByNight(Boolean value) {
        this.byNight = value;
    }

    /**
     * Gets the value of the commissionable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCommissionable() {
        return commissionable;
    }

    /**
     * Sets the value of the commissionable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCommissionable(Boolean value) {
        this.commissionable = value;
    }

    /**
     * Gets the value of the included property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncluded() {
        return included;
    }

    /**
     * Sets the value of the included property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncluded(Boolean value) {
        this.included = value;
    }

}
