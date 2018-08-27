
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarLocation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarLocation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="PickUpCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DropOffCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarLocation")
public class JPRentacarLocation {

    @XmlAttribute(name = "PickUpCode")
    protected String pickUpCode;
    @XmlAttribute(name = "DropOffCode")
    protected String dropOffCode;

    /**
     * Gets the value of the pickUpCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPickUpCode() {
        return pickUpCode;
    }

    /**
     * Sets the value of the pickUpCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPickUpCode(String value) {
        this.pickUpCode = value;
    }

    /**
     * Gets the value of the dropOffCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDropOffCode() {
        return dropOffCode;
    }

    /**
     * Sets the value of the dropOffCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDropOffCode(String value) {
        this.dropOffCode = value;
    }

}
