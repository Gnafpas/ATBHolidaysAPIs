
package DAOs.JuniperAPIDAOs;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CancelInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CancelInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BookingCodeState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BookingCancelCost" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BookingCancelCostCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CancelInformation", propOrder = {
    "bookingCodeState",
    "bookingCancelCost",
    "bookingCancelCostCurrency"
})
public class JPCancelInformation {

    @XmlElement(name = "BookingCodeState")
    protected String bookingCodeState;
    @XmlElement(name = "BookingCancelCost")
    protected BigDecimal bookingCancelCost;
    @XmlElement(name = "BookingCancelCostCurrency")
    protected String bookingCancelCostCurrency;

    /**
     * Gets the value of the bookingCodeState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingCodeState() {
        return bookingCodeState;
    }

    /**
     * Sets the value of the bookingCodeState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingCodeState(String value) {
        this.bookingCodeState = value;
    }

    /**
     * Gets the value of the bookingCancelCost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBookingCancelCost() {
        return bookingCancelCost;
    }

    /**
     * Sets the value of the bookingCancelCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBookingCancelCost(BigDecimal value) {
        this.bookingCancelCost = value;
    }

    /**
     * Gets the value of the bookingCancelCostCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingCancelCostCurrency() {
        return bookingCancelCostCurrency;
    }

    /**
     * Sets the value of the bookingCancelCostCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingCancelCostCurrency(String value) {
        this.bookingCancelCostCurrency = value;
    }

}
