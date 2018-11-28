
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AcceptablePaymentCardsInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AcceptablePaymentCardsInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AcceptablePaymentCards" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfAcceptablePaymentCardsInfoTypeAcceptablePaymentCard" minOccurs="0"/>
 *         &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AcceptablePaymentCardsInfoType", propOrder = {
    "acceptablePaymentCards",
    "info"
})
public class AcceptablePaymentCardsInfoType {

    @XmlElement(name = "AcceptablePaymentCards")
    protected ArrayOfAcceptablePaymentCardsInfoTypeAcceptablePaymentCard acceptablePaymentCards;
    @XmlElement(name = "Info")
    protected FormattedTextType info;

    /**
     * Gets the value of the acceptablePaymentCards property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAcceptablePaymentCardsInfoTypeAcceptablePaymentCard }
     *     
     */
    public ArrayOfAcceptablePaymentCardsInfoTypeAcceptablePaymentCard getAcceptablePaymentCards() {
        return acceptablePaymentCards;
    }

    /**
     * Sets the value of the acceptablePaymentCards property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAcceptablePaymentCardsInfoTypeAcceptablePaymentCard }
     *     
     */
    public void setAcceptablePaymentCards(ArrayOfAcceptablePaymentCardsInfoTypeAcceptablePaymentCard value) {
        this.acceptablePaymentCards = value;
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link FormattedTextType }
     *     
     */
    public FormattedTextType getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormattedTextType }
     *     
     */
    public void setInfo(FormattedTextType value) {
        this.info = value;
    }

}
