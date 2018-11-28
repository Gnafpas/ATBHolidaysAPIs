
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CreditCardFee complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CreditCardFee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Price" type="{http://www.juniper.es/webservice/2007/}JP_Price" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CardCode" use="required" type="{http://www.juniper.es/webservice/2007/}JP_CreditCardType" />
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PerPax" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CreditCardFee", propOrder = {
    "price"
})
public class JPCreditCardFee {

    @XmlElement(name = "Price")
    protected JPPrice price;
    @XmlAttribute(name = "CardCode", required = true)
    protected JPCreditCardType cardCode;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "PerPax", required = true)
    protected boolean perPax;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;

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
     * Gets the value of the cardCode property.
     * 
     * @return
     *     possible object is
     *     {@link JPCreditCardType }
     *     
     */
    public JPCreditCardType getCardCode() {
        return cardCode;
    }

    /**
     * Sets the value of the cardCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCreditCardType }
     *     
     */
    public void setCardCode(JPCreditCardType value) {
        this.cardCode = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the perPax property.
     * 
     */
    public boolean isPerPax() {
        return perPax;
    }

    /**
     * Sets the value of the perPax property.
     * 
     */
    public void setPerPax(boolean value) {
        this.perPax = value;
    }

    /**
     * Gets the value of the ratePlanCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRatePlanCode() {
        return ratePlanCode;
    }

    /**
     * Sets the value of the ratePlanCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatePlanCode(String value) {
        this.ratePlanCode = value;
    }

}
