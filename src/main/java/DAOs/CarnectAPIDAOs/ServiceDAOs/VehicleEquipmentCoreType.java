
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleEquipmentCoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleEquipmentCoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="EquipType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleEquipmentCoreType")
@XmlSeeAlso({
    VehicleReservationRQCoreTypeSpecialEquipPrefsSpecialEquipPref.class
})
public class VehicleEquipmentCoreType {

    @XmlAttribute(name = "EquipType")
    protected String equipType;
    @XmlAttribute(name = "Quantity")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger quantity;

    /**
     * Gets the value of the equipType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquipType() {
        return equipType;
    }

    /**
     * Sets the value of the equipType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquipType(String value) {
        this.equipType = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQuantity(BigInteger value) {
        this.quantity = value;
    }

}
