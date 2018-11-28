
package DAOs.SunHotelsAPIDAOs;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PercentageCancellationPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PercentageCancellationPolicy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deadline" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="percentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PercentageCancellationPolicy", propOrder = {
    "deadline",
    "percentage"
})
@XmlSeeAlso({
    StaticPercentageCancellationPolicy.class
})
public class PercentageCancellationPolicy {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer deadline;
    @XmlElement(required = true)
    protected BigDecimal percentage;

    /**
     * Gets the value of the deadline property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeadline() {
        return deadline;
    }

    /**
     * Sets the value of the deadline property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeadline(Integer value) {
        this.deadline = value;
    }

    /**
     * Gets the value of the percentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentage() {
        return percentage;
    }

    /**
     * Sets the value of the percentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentage(BigDecimal value) {
        this.percentage = value;
    }

}
