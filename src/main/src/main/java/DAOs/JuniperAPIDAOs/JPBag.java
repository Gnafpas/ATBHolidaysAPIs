
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Bag complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Bag">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RelPaxes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ExtendedRelPaxBag" minOccurs="0"/>
 *         &lt;element name="Price" type="{http://www.juniper.es/webservice/2007/}JP_Price" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="BaggageType" use="required" type="{http://www.juniper.es/webservice/2007/}JP_BaggageType" />
 *       &lt;attribute name="Quantity" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Weight" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Size" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Bag", propOrder = {
    "relPaxes",
    "price"
})
public class JPBag {

    @XmlElement(name = "RelPaxes")
    protected ArrayOfJPExtendedRelPaxBag relPaxes;
    @XmlElement(name = "Price")
    protected JPPrice price;
    @XmlAttribute(name = "BaggageType", required = true)
    protected JPBaggageType baggageType;
    @XmlAttribute(name = "Quantity", required = true)
    protected int quantity;
    @XmlAttribute(name = "Weight")
    protected Integer weight;
    @XmlAttribute(name = "Size")
    protected String size;

    /**
     * Gets the value of the relPaxes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPExtendedRelPaxBag }
     *     
     */
    public ArrayOfJPExtendedRelPaxBag getRelPaxes() {
        return relPaxes;
    }

    /**
     * Sets the value of the relPaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPExtendedRelPaxBag }
     *     
     */
    public void setRelPaxes(ArrayOfJPExtendedRelPaxBag value) {
        this.relPaxes = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link JPPrice }
     *     
     */
    public JPPrice getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPrice }
     *     
     */
    public void setPrice(JPPrice value) {
        this.price = value;
    }

    /**
     * Gets the value of the baggageType property.
     * 
     * @return
     *     possible object is
     *     {@link JPBaggageType }
     *     
     */
    public JPBaggageType getBaggageType() {
        return baggageType;
    }

    /**
     * Sets the value of the baggageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBaggageType }
     *     
     */
    public void setBaggageType(JPBaggageType value) {
        this.baggageType = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWeight(Integer value) {
        this.weight = value;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSize(String value) {
        this.size = value;
    }

}
