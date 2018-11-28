
package DAOs.SunHotelsAPIDAOs;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancelTransferBookingResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelTransferBookingResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="cancellationFeeInEuros" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="cancellationFeeInLocalCurrency" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelTransferBookingResult", propOrder = {
    "cancellationFeeInEuros",
    "cancellationFeeInLocalCurrency",
    "currency",
    "code"
})
public class CancelTransferBookingResult
    extends BaseResult
{

    @XmlElement(required = true)
    protected BigDecimal cancellationFeeInEuros;
    @XmlElement(required = true)
    protected BigDecimal cancellationFeeInLocalCurrency;
    protected String currency;
    protected int code;

    /**
     * Gets the value of the cancellationFeeInEuros property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCancellationFeeInEuros() {
        return cancellationFeeInEuros;
    }

    /**
     * Sets the value of the cancellationFeeInEuros property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCancellationFeeInEuros(BigDecimal value) {
        this.cancellationFeeInEuros = value;
    }

    /**
     * Gets the value of the cancellationFeeInLocalCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCancellationFeeInLocalCurrency() {
        return cancellationFeeInLocalCurrency;
    }

    /**
     * Sets the value of the cancellationFeeInLocalCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCancellationFeeInLocalCurrency(BigDecimal value) {
        this.cancellationFeeInLocalCurrency = value;
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

    /**
     * Gets the value of the code property.
     * 
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     */
    public void setCode(int value) {
        this.code = value;
    }

}
