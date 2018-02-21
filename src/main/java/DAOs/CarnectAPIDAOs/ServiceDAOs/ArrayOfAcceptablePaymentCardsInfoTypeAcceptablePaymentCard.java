
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAcceptablePaymentCardsInfoTypeAcceptablePaymentCard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAcceptablePaymentCardsInfoTypeAcceptablePaymentCard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AcceptablePaymentCard" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="CardType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CardName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="UsagePercentage" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="UsageAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAcceptablePaymentCardsInfoTypeAcceptablePaymentCard", propOrder = {
    "acceptablePaymentCard"
})
public class ArrayOfAcceptablePaymentCardsInfoTypeAcceptablePaymentCard {

    @XmlElement(name = "AcceptablePaymentCard")
    protected List<ArrayOfAcceptablePaymentCardsInfoTypeAcceptablePaymentCard.AcceptablePaymentCard> acceptablePaymentCard;

    /**
     * Gets the value of the acceptablePaymentCard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acceptablePaymentCard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcceptablePaymentCard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfAcceptablePaymentCardsInfoTypeAcceptablePaymentCard.AcceptablePaymentCard }
     * 
     * 
     */
    public List<ArrayOfAcceptablePaymentCardsInfoTypeAcceptablePaymentCard.AcceptablePaymentCard> getAcceptablePaymentCard() {
        if (acceptablePaymentCard == null) {
            acceptablePaymentCard = new ArrayList<ArrayOfAcceptablePaymentCardsInfoTypeAcceptablePaymentCard.AcceptablePaymentCard>();
        }
        return this.acceptablePaymentCard;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="CardType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CardName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="UsagePercentage" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="UsageAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class AcceptablePaymentCard {

        @XmlAttribute(name = "CardType")
        protected String cardType;
        @XmlAttribute(name = "CardName")
        protected String cardName;
        @XmlAttribute(name = "UsagePercentage")
        protected BigDecimal usagePercentage;
        @XmlAttribute(name = "UsageAmount")
        protected BigDecimal usageAmount;

        /**
         * Gets the value of the cardType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCardType() {
            return cardType;
        }

        /**
         * Sets the value of the cardType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCardType(String value) {
            this.cardType = value;
        }

        /**
         * Gets the value of the cardName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCardName() {
            return cardName;
        }

        /**
         * Sets the value of the cardName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCardName(String value) {
            this.cardName = value;
        }

        /**
         * Gets the value of the usagePercentage property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getUsagePercentage() {
            return usagePercentage;
        }

        /**
         * Sets the value of the usagePercentage property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setUsagePercentage(BigDecimal value) {
            this.usagePercentage = value;
        }

        /**
         * Gets the value of the usageAmount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getUsageAmount() {
            return usageAmount;
        }

        /**
         * Sets the value of the usageAmount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setUsageAmount(BigDecimal value) {
            this.usageAmount = value;
        }

    }

}
