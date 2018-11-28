
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_GroupFee complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_GroupFee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Paxes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RelPaxDist" minOccurs="0"/>
 *         &lt;element name="Price" type="{http://www.juniper.es/webservice/2007/}JP_Price" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_GroupFee", propOrder = {
    "paxes",
    "price"
})
public class JPGroupFee {

    @XmlElement(name = "Paxes")
    protected ArrayOfJPRelPaxDist paxes;
    @XmlElement(name = "Price")
    protected JPPrice price;

    /**
     * Gets the value of the paxes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRelPaxDist }
     *     
     */
    public ArrayOfJPRelPaxDist getPaxes() {
        return paxes;
    }

    /**
     * Sets the value of the paxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRelPaxDist }
     *     
     */
    public void setPaxes(ArrayOfJPRelPaxDist value) {
        this.paxes = value;
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

}
