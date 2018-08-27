
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShoppingBasketReadRQ" type="{http://www.juniper.es/webservice/2007/}JP_ShoppingBasketRead" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "shoppingBasketReadRQ"
})
@XmlRootElement(name = "ShoppingBasketRead")
public class ShoppingBasketRead {

    @XmlElement(name = "ShoppingBasketReadRQ")
    protected JPShoppingBasketRead shoppingBasketReadRQ;

    /**
     * Gets the value of the shoppingBasketReadRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPShoppingBasketRead }
     *     
     */
    public JPShoppingBasketRead getShoppingBasketReadRQ() {
        return shoppingBasketReadRQ;
    }

    /**
     * Sets the value of the shoppingBasketReadRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPShoppingBasketRead }
     *     
     */
    public void setShoppingBasketReadRQ(JPShoppingBasketRead value) {
        this.shoppingBasketReadRQ = value;
    }

}
