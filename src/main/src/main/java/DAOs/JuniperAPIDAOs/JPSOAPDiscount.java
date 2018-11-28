
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_Discount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_Discount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Order" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Discount" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_Discount")
public class JPSOAPDiscount {

    @XmlAttribute(name = "Order", required = true)
    protected int order;
    @XmlAttribute(name = "Discount", required = true)
    protected double discount;

    /**
     * Gets the value of the order property.
     * 
     */
    public int getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     */
    public void setOrder(int value) {
        this.order = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     */
    public void setDiscount(double value) {
        this.discount = value;
    }

}
