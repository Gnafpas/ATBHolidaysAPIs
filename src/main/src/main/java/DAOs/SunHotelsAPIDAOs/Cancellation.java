
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Cancellation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Cancellation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="activecancellationpolicy" type="{http://xml.sunhotels.net/15/}StaticPercentageCancellationPolicy" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cancellation", propOrder = {
    "activecancellationpolicy"
})
public class Cancellation {

    protected StaticPercentageCancellationPolicy activecancellationpolicy;
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the activecancellationpolicy property.
     * 
     * @return
     *     possible object is
     *     {@link StaticPercentageCancellationPolicy }
     *     
     */
    public StaticPercentageCancellationPolicy getActivecancellationpolicy() {
        return activecancellationpolicy;
    }

    /**
     * Sets the value of the activecancellationpolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaticPercentageCancellationPolicy }
     *     
     */
    public void setActivecancellationpolicy(StaticPercentageCancellationPolicy value) {
        this.activecancellationpolicy = value;
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

}
