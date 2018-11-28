
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_OptionalElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_OptionalElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bags" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Bag" minOccurs="0"/>
 *         &lt;element name="CreditCardsFee" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CreditCardFee" minOccurs="0"/>
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
@XmlType(name = "JP_OptionalElements", propOrder = {
    "bags",
    "creditCardsFee",
    "flightSupplements"
})
public class JPOptionalElements {

    @XmlElement(name = "Bags")
    protected ArrayOfJPBag bags;
    @XmlElement(name = "CreditCardsFee")
    protected ArrayOfJPCreditCardFee creditCardsFee;
    @XmlElement(name = "FlightSupplements")
    protected ArrayOfJPFlightSupplement flightSupplements;

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
     * Gets the value of the creditCardsFee property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCreditCardFee }
     *     
     */
    public ArrayOfJPCreditCardFee getCreditCardsFee() {
        return creditCardsFee;
    }

    /**
     * Sets the value of the creditCardsFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCreditCardFee }
     *     
     */
    public void setCreditCardsFee(ArrayOfJPCreditCardFee value) {
        this.creditCardsFee = value;
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
