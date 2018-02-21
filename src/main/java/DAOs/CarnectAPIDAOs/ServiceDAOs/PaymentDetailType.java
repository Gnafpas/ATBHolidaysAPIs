
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentDetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentDetailType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}PaymentFormType">
 *       &lt;sequence>
 *         &lt;element name="PaymentAmount" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="ApprovalCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentDetailType", propOrder = {
    "paymentAmount"
})
@XmlSeeAlso({
        DAOs.CarnectAPIDAOs.ServiceDAOs.VehicleReservationRQAdditionalInfoType.RentalPaymentPref.class,
        DAOs.CarnectAPIDAOs.ServiceDAOs.VehicleModifyRQAdditionalInfoType.RentalPaymentPref.class
})
public class PaymentDetailType
    extends PaymentFormType
{

    @XmlElement(name = "PaymentAmount")
    protected PaymentDetailType.PaymentAmount paymentAmount;

    /**
     * Gets the value of the paymentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentDetailType.PaymentAmount }
     *     
     */
    public PaymentDetailType.PaymentAmount getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Sets the value of the paymentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDetailType.PaymentAmount }
     *     
     */
    public void setPaymentAmount(PaymentDetailType.PaymentAmount value) {
        this.paymentAmount = value;
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
     *       &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="ApprovalCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class PaymentAmount {

        @XmlAttribute(name = "Amount")
        protected BigDecimal amount;
        @XmlAttribute(name = "ApprovalCode")
        protected String approvalCode;

        /**
         * Gets the value of the amount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

        /**
         * Gets the value of the approvalCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApprovalCode() {
            return approvalCode;
        }

        /**
         * Sets the value of the approvalCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApprovalCode(String value) {
            this.approvalCode = value;
        }

    }

}
