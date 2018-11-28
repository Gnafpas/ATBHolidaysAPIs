
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FreeNights complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FreeNights">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Nights" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Free" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FreeNights")
public class JPFreeNights {

    @XmlAttribute(name = "Nights")
    protected Integer nights;
    @XmlAttribute(name = "Free")
    protected Integer free;

    /**
     * Gets the value of the nights property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNights() {
        return nights;
    }

    /**
     * Sets the value of the nights property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNights(Integer value) {
        this.nights = value;
    }

    /**
     * Gets the value of the free property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFree() {
        return free;
    }

    /**
     * Sets the value of the free property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFree(Integer value) {
        this.free = value;
    }

}
