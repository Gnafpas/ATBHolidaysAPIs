
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_AdditionalElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_AdditionalElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fees" type="{http://www.juniper.es/webservice/2007/}ArrayOfString2" minOccurs="0"/>
 *         &lt;element name="Bags" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Bag" minOccurs="0"/>
 *         &lt;element name="CreditCardFee" type="{http://www.juniper.es/webservice/2007/}JP_CreditCardFee" minOccurs="0"/>
 *         &lt;element name="FlightSupplements" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_FlightSupplement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_AdditionalElements", propOrder = {
    "fees",
    "bags",
    "creditCardFee",
    "flightSupplements"
})
public class JPAdditionalElements {

    @XmlElement(name = "Fees")
    protected ArrayOfString2 fees;
    @XmlElement(name = "Bags")
    protected ArrayOfJPBag bags;
    @XmlElement(name = "CreditCardFee")
    protected JPCreditCardFee creditCardFee;
    @XmlElement(name = "FlightSupplements")
    protected ArrayOfJPFlightSupplement flightSupplements;

    /**
     * Gets the value of the fees property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString2 }
     *     
     */
    public ArrayOfString2 getFees() {
        return fees;
    }

    /**
     * Sets the value of the fees property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString2 }
     *     
     */
    public void setFees(ArrayOfString2 value) {
        this.fees = value;
    }

    /**
     * Gets the value of the bags property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPBag }
     *     
     */
    public ArrayOfJPBag getBags() {
        return bags;
    }

    /**
     * Sets the value of the bags property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPBag }
     *     
     */
    public void setBags(ArrayOfJPBag value) {
        this.bags = value;
    }

    /**
     * Gets the value of the creditCardFee property.
     * 
     * @return
     *     possible object is
     *     {@link JPCreditCardFee }
     *     
     */
    public JPCreditCardFee getCreditCardFee() {
        return creditCardFee;
    }

    /**
     * Sets the value of the creditCardFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCreditCardFee }
     *     
     */
    public void setCreditCardFee(JPCreditCardFee value) {
        this.creditCardFee = value;
    }

    /**
     * Gets the value of the flightSupplements property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPFlightSupplement }
     *     
     */
    public ArrayOfJPFlightSupplement getFlightSupplements() {
        return flightSupplements;
    }

    /**
     * Sets the value of the flightSupplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPFlightSupplement }
     *     
     */
    public void setFlightSupplements(ArrayOfJPFlightSupplement value) {
        this.flightSupplements = value;
    }

}
