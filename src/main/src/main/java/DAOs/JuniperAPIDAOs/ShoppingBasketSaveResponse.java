
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
 *         &lt;element name="ShoppingBasketSaveRS" type="{http://www.juniper.es/webservice/2007/}JP_ShoppingBasketResult" minOccurs="0"/>
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
    "shoppingBasketSaveRS"
})
@XmlRootElement(name = "ShoppingBasketSaveResponse")
public class ShoppingBasketSaveResponse {

    @XmlElement(name = "ShoppingBasketSaveRS")
    protected JPShoppingBasketResult shoppingBasketSaveRS;

    /**
     * Gets the value of the shoppingBasketSaveRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPShoppingBasketResult }
     *     
     */
    public JPShoppingBasketResult getShoppingBasketSaveRS() {
        return shoppingBasketSaveRS;
    }

    /**
     * Sets the value of the shoppingBasketSaveRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPShoppingBasketResult }
     *     
     */
    public void setShoppingBasketSaveRS(JPShoppingBasketResult value) {
        this.shoppingBasketSaveRS = value;
    }

}
