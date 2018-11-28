
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
 *         &lt;element name="InventoryRS" type="{http://www.juniper.es/webservice/2007/}JP_InventoryRS" minOccurs="0"/>
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
    "inventoryRS"
})
@XmlRootElement(name = "HotelListInventoryResponse")
public class HotelListInventoryResponse {

    @XmlElement(name = "InventoryRS")
    protected JPInventoryRS inventoryRS;

    /**
     * Gets the value of the inventoryRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPInventoryRS }
     *     
     */
    public JPInventoryRS getInventoryRS() {
        return inventoryRS;
    }

    /**
     * Sets the value of the inventoryRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPInventoryRS }
     *     
     */
    public void setInventoryRS(JPInventoryRS value) {
        this.inventoryRS = value;
    }

}
