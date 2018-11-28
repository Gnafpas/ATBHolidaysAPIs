
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_BaseElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_BaseElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BookingCode" type="{http://www.juniper.es/webservice/2007/}JP_BookingCode" minOccurs="0"/>
 *         &lt;element name="ExternalItemReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RelPaxesDist" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RelPaxDist" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Comment" minOccurs="0"/>
 *         &lt;element name="CreditCard" type="{http://www.juniper.es/webservice/2007/}JP_CreditCardInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ElementId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_BaseElement", propOrder = {
    "bookingCode",
    "externalItemReference",
    "relPaxesDist",
    "comments",
    "creditCard"
})
@XmlSeeAlso({
    JPServiceElement.class,
    JPInsuranceElement.class,
    JPPackageElement.class,
    JPRentacarElement.class,
    JPCruiseElement.class,
    JPTransferByHotelElement.class,
    JPVisaElement.class,
    JPTicketElement.class,
    JPHotelElement.class,
    JPFlightElement.class,
    JPTransferElement.class
})
public abstract class JPBaseElement {

    @XmlElement(name = "BookingCode")
    protected JPBookingCode bookingCode;
    @XmlElement(name = "ExternalItemReference")
    protected String externalItemReference;
    @XmlElement(name = "RelPaxesDist")
    protected ArrayOfJPRelPaxDist relPaxesDist;
    @XmlElement(name = "Comments")
    protected ArrayOfJPComment comments;
    @XmlElement(name = "CreditCard")
    protected JPCreditCardInfo creditCard;
    @XmlAttribute(name = "ElementId")
    protected String elementId;

    /**
     * Gets the value of the bookingCode property.
     * 
     * @return
     *     possible object is
     *     {@link JPBookingCode }
     *     
     */
    public JPBookingCode getBookingCode() {
        return bookingCode;
    }

    /**
     * Sets the value of the bookingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBookingCode }
     *     
     */
    public void setBookingCode(JPBookingCode value) {
        this.bookingCode = value;
    }

    /**
     * Gets the value of the externalItemReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalItemReference() {
        return externalItemReference;
    }

    /**
     * Sets the value of the externalItemReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalItemReference(String value) {
        this.externalItemReference = value;
    }

    /**
     * Gets the value of the relPaxesDist property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRelPaxDist }
     *     
     */
    public ArrayOfJPRelPaxDist getRelPaxesDist() {
        return relPaxesDist;
    }

    /**
     * Sets the value of the relPaxesDist property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRelPaxDist }
     *     
     */
    public void setRelPaxesDist(ArrayOfJPRelPaxDist value) {
        this.relPaxesDist = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPComment }
     *     
     */
    public ArrayOfJPComment getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPComment }
     *     
     */
    public void setComments(ArrayOfJPComment value) {
        this.comments = value;
    }

    /**
     * Gets the value of the creditCard property.
     * 
     * @return
     *     possible object is
     *     {@link JPCreditCardInfo }
     *     
     */
    public JPCreditCardInfo getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the value of the creditCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCreditCardInfo }
     *     
     */
    public void setCreditCard(JPCreditCardInfo value) {
        this.creditCard = value;
    }

    /**
     * Gets the value of the elementId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElementId() {
        return elementId;
    }

    /**
     * Sets the value of the elementId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElementId(String value) {
        this.elementId = value;
    }

}
