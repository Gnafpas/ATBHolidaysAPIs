
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
 *         &lt;element name="ShoppingBasketReadRS" type="{http://www.juniper.es/webservice/2007/}JP_ShoppingBasketResult" minOccurs="0"/>
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
    "shoppingBasketReadRS"
})
@XmlRootElement(name = "ShoppingBasketReadResponse")
public class ShoppingBasketReadResponse {

    @XmlElement(name = "ShoppingBasketReadRS")
    protected JPShoppingBasketResult shoppingBasketReadRS;

    /**
     * Gets the value of the shoppingBasketReadRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPShoppingBasketResult }
     *     
     */
    public JPShoppingBasketResult getShoppingBasketReadRS() {
        return shoppingBasketReadRS;
    }

    /**
     * Sets the value of the shoppingBasketReadRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPShoppingBasketResult }
     *     
     */
    public void setShoppingBasketReadRS(JPShoppingBasketResult value) {
        this.shoppingBasketReadRS = value;
    }

}
