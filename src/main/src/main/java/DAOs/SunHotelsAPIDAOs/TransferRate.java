
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransferRate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransferRate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="direction" type="{http://xml.sunhotels.net/15/}TransferDirection"/>
 *         &lt;element name="startHour" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="endHour" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prices" type="{http://xml.sunhotels.net/15/}ArrayOfTransferRatePrice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransferRate", propOrder = {
    "direction",
    "startHour",
    "endHour",
    "prices"
})
public class TransferRate {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TransferDirection direction;
    protected int startHour;
    protected int endHour;
    protected ArrayOfTransferRatePrice prices;

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link TransferDirection }
     *     
     */
    public TransferDirection getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransferDirection }
     *     
     */
    public void setDirection(TransferDirection value) {
        this.direction = value;
    }

    /**
     * Gets the value of the startHour property.
     * 
     */
    public int getStartHour() {
        return startHour;
    }

    /**
     * Sets the value of the startHour property.
     * 
     */
    public void setStartHour(int value) {
        this.startHour = value;
    }

    /**
     * Gets the value of the endHour property.
     * 
     */
    public int getEndHour() {
        return endHour;
    }

    /**
     * Sets the value of the endHour property.
     * 
     */
    public void setEndHour(int value) {
        this.endHour = value;
    }

    /**
     * Gets the value of the prices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTransferRatePrice }
     *     
     */
    public ArrayOfTransferRatePrice getPrices() {
        return prices;
    }

    /**
     * Sets the value of the prices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTransferRatePrice }
     *     
     */
    public void setPrices(ArrayOfTransferRatePrice value) {
        this.prices = value;
    }

}
