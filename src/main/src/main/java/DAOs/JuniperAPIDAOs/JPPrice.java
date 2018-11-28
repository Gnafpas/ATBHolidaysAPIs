
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Price complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Price">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TotalFixAmounts" type="{http://www.juniper.es/webservice/2007/}JP_TotalFixAmounts" minOccurs="0"/>
 *         &lt;element name="Breakdown" type="{http://www.juniper.es/webservice/2007/}JP_BreakdownPrice" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Type">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="S"/>
 *             &lt;enumeration value="C"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Price", propOrder = {
    "totalFixAmounts",
    "breakdown"
})
public class JPPrice {

    @XmlElement(name = "TotalFixAmounts")
    protected JPTotalFixAmounts totalFixAmounts;
    @XmlElement(name = "Breakdown")
    protected JPBreakdownPrice breakdown;
    @XmlAttribute(name = "Type")
    protected String type;
    @XmlAttribute(name = "Currency")
    protected String currency;

    /**
     * Gets the value of the totalFixAmounts property.
     * 
     * @return
     *     possible object is
     *     {@link JPTotalFixAmounts }
     *     
     */
    public JPTotalFixAmounts getTotalFixAmounts() {
        return totalFixAmounts;
    }

    /**
     * Sets the value of the totalFixAmounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTotalFixAmounts }
     *     
     */
    public void setTotalFixAmounts(JPTotalFixAmounts value) {
        this.totalFixAmounts = value;
    }

    /**
     * Gets the value of the breakdown property.
     * 
     * @return
     *     possible object is
     *     {@link JPBreakdownPrice }
     *     
     */
    public JPBreakdownPrice getBreakdown() {
        return breakdown;
    }

    /**
     * Sets the value of the breakdown property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBreakdownPrice }
     *     
     */
    public void setBreakdown(JPBreakdownPrice value) {
        this.breakdown = value;
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

}
