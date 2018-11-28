
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseCabinServices complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseCabinServices">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Dryer" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Phone" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Cabinasistan" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Internet" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Safe" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Contiguous" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseCabinServices")
public class JPCruiseCabinServices {

    @XmlAttribute(name = "Dryer")
    protected Boolean dryer;
    @XmlAttribute(name = "Phone")
    protected Boolean phone;
    @XmlAttribute(name = "Cabinasistan")
    protected Boolean cabinasistan;
    @XmlAttribute(name = "Internet")
    protected Boolean internet;
    @XmlAttribute(name = "Safe")
    protected Boolean safe;
    @XmlAttribute(name = "Contiguous")
    protected Boolean contiguous;

    /**
     * Gets the value of the dryer property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDryer() {
        return dryer;
    }

    /**
     * Sets the value of the dryer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDryer(Boolean value) {
        this.dryer = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPhone(Boolean value) {
        this.phone = value;
    }

    /**
     * Gets the value of the cabinasistan property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCabinasistan() {
        return cabinasistan;
    }

    /**
     * Sets the value of the cabinasistan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCabinasistan(Boolean value) {
        this.cabinasistan = value;
    }

    /**
     * Gets the value of the internet property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInternet() {
        return internet;
    }

    /**
     * Sets the value of the internet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInternet(Boolean value) {
        this.internet = value;
    }

    /**
     * Gets the value of the safe property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSafe() {
        return safe;
    }

    /**
     * Sets the value of the safe property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSafe(Boolean value) {
        this.safe = value;
    }

    /**
     * Gets the value of the contiguous property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isContiguous() {
        return contiguous;
    }

    /**
     * Sets the value of the contiguous property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContiguous(Boolean value) {
        this.contiguous = value;
    }

}
