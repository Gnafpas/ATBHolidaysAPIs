
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FlightDiscount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightDiscount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Resident" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="LargeFamily" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FlightDiscount")
public class JPFlightDiscount {

    @XmlAttribute(name = "Resident")
    protected Boolean resident;
    @XmlAttribute(name = "LargeFamily")
    protected String largeFamily;

    /**
     * Gets the value of the resident property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isResident() {
        return resident;
    }

    /**
     * Sets the value of the resident property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setResident(Boolean value) {
        this.resident = value;
    }

    /**
     * Gets the value of the largeFamily property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLargeFamily() {
        return largeFamily;
    }

    /**
     * Sets the value of the largeFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLargeFamily(String value) {
        this.largeFamily = value;
    }

}
