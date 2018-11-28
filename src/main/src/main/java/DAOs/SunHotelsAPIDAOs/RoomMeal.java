
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoomMeal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoomMeal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="labelId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prices" type="{http://xml.sunhotels.net/15/}ArrayOfPriceWithPaymentMethods" minOccurs="0"/>
 *         &lt;element name="discount" type="{http://xml.sunhotels.net/15/}Discount"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomMeal", propOrder = {
    "id",
    "labelId",
    "prices",
    "discount"
})
public class RoomMeal {

    protected int id;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer labelId;
    protected ArrayOfPriceWithPaymentMethods prices;
    @XmlElement(required = true, nillable = true)
    protected Discount discount;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the labelId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLabelId() {
        return labelId;
    }

    /**
     * Sets the value of the labelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLabelId(Integer value) {
        this.labelId = value;
    }

    /**
     * Gets the value of the prices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPriceWithPaymentMethods }
     *     
     */
    public ArrayOfPriceWithPaymentMethods getPrices() {
        return prices;
    }

    /**
     * Sets the value of the prices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPriceWithPaymentMethods }
     *     
     */
    public void setPrices(ArrayOfPriceWithPaymentMethods value) {
        this.prices = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link Discount }
     *     
     */
    public Discount getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Discount }
     *     
     */
    public void setDiscount(Discount value) {
        this.discount = value;
    }

}
