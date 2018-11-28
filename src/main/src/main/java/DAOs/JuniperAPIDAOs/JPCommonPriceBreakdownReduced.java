
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CommonPriceBreakdownReduced complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CommonPriceBreakdownReduced">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Base" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CommonPriceBreakdownReduced")
public class JPCommonPriceBreakdownReduced {

    @XmlAttribute(name = "Base")
    protected Double base;
    @XmlAttribute(name = "Amount")
    protected Double amount;

    /**
     * Gets the value of the base property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBase() {
        return base;
    }

    /**
     * Sets the value of the base property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBase(Double value) {
        this.base = value;
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

}
