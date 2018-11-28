
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_TicketCommission complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_TicketCommission">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Type" use="required" type="{http://www.juniper.es/webservice/2007/}JP_CommissionType" />
 *       &lt;attribute name="Amount" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_TicketCommission")
public class JPTicketCommission {

    @XmlAttribute(name = "Type", required = true)
    protected JPCommissionType type;
    @XmlAttribute(name = "Amount", required = true)
    protected int amount;
    @XmlAttribute(name = "Currency")
    protected String currency;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JPCommissionType }
     *     
     */
    public JPCommissionType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCommissionType }
     *     
     */
    public void setType(JPCommissionType value) {
        this.type = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(int value) {
        this.amount = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}
