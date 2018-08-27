
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
 *         &lt;element name="ShoppingBasketSaveRQ" type="{http://www.juniper.es/webservice/2007/}JP_ShoppingBasketSave" minOccurs="0"/>
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
    "shoppingBasketSaveRQ"
})
@XmlRootElement(name = "ShoppingBasketSave")
public class ShoppingBasketSave {

    @XmlElement(name = "ShoppingBasketSaveRQ")
    protected JPShoppingBasketSave shoppingBasketSaveRQ;

    /**
     * Gets the value of the shoppingBasketSaveRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPShoppingBasketSave }
     *     
     */
    public JPShoppingBasketSave getShoppingBasketSaveRQ() {
        return shoppingBasketSaveRQ;
    }

    /**
     * Sets the value of the shoppingBasketSaveRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPShoppingBasketSave }
     *     
     */
    public void setShoppingBasketSaveRQ(JPShoppingBasketSave value) {
        this.shoppingBasketSaveRQ = value;
    }

}
