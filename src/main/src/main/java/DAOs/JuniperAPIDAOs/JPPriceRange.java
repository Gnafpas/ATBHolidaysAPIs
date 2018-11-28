
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PriceRange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PriceRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Minimum" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Maximum" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PriceRange")
public class JPPriceRange {

    @XmlAttribute(name = "Minimum", required = true)
    protected double minimum;
    @XmlAttribute(name = "Maximum", required = true)
    protected double maximum;
    @XmlAttribute(name = "Currency")
    protected String currency;

    /**
     * Gets the value of the minimum property.
     * 
     */
    public double getMinimum() {
        return minimum;
    }

    /**
     * Sets the value of the minimum property.
     * 
     */
    public void setMinimum(double value) {
        this.minimum = value;
    }

    /**
     * Gets the value of the maximum property.
     * 
     */
    public double getMaximum() {
        return maximum;
    }

    /**
     * Sets the value of the maximum property.
     * 
     */
    public void setMaximum(double value) {
        this.maximum = value;
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
