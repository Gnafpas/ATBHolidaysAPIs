
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_SuppleOfferPrices complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_SuppleOfferPrices">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Price" type="{http://www.juniper.es/webservice/2007/}JPSOAP_SuppleOfferPrice" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PricePer" use="required" type="{http://www.juniper.es/webservice/2007/}JPSOAP_PricePerTypes" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_SuppleOfferPrices", propOrder = {
    "price"
})
public class JPSOAPSuppleOfferPrices {

    @XmlElement(name = "Price")
    protected List<JPSOAPSuppleOfferPrice> price;
    @XmlAttribute(name = "PricePer", required = true)
    protected JPSOAPPricePerTypes pricePer;

    /**
     * Gets the value of the price property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the price property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPSOAPSuppleOfferPrice }
     * 
     * 
     */
    public List<JPSOAPSuppleOfferPrice> getPrice() {
        if (price == null) {
            price = new ArrayList<JPSOAPSuppleOfferPrice>();
        }
        return this.price;
    }

    /**
     * Gets the value of the pricePer property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPPricePerTypes }
     *     
     */
    public JPSOAPPricePerTypes getPricePer() {
        return pricePer;
    }

    /**
     * Sets the value of the pricePer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPPricePerTypes }
     *     
     */
    public void setPricePer(JPSOAPPricePerTypes value) {
        this.pricePer = value;
    }

}
