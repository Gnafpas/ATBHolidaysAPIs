
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelOptionalElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelOptionalElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Comments" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Comment" minOccurs="0"/>
 *         &lt;element name="HotelSupplements" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelAdditionalElement" minOccurs="0"/>
 *         &lt;element name="Preferences" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelPreference" minOccurs="0"/>
 *         &lt;element name="AllowedCreditCards" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CreditCard" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelOptionalElements", propOrder = {
    "comments",
    "hotelSupplements",
    "preferences",
    "allowedCreditCards"
})
public class JPHotelOptionalElements {

    @XmlElement(name = "Comments")
    protected ArrayOfJPComment comments;
    @XmlElement(name = "HotelSupplements")
    protected ArrayOfJPHotelAdditionalElement hotelSupplements;
    @XmlElement(name = "Preferences")
    protected ArrayOfJPHotelPreference preferences;
    @XmlElement(name = "AllowedCreditCards")
    protected ArrayOfJPCreditCard allowedCreditCards;

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
     * Gets the value of the hotelSupplements property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelAdditionalElement }
     *     
     */
    public ArrayOfJPHotelAdditionalElement getHotelSupplements() {
        return hotelSupplements;
    }

    /**
     * Sets the value of the hotelSupplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelAdditionalElement }
     *     
     */
    public void setHotelSupplements(ArrayOfJPHotelAdditionalElement value) {
        this.hotelSupplements = value;
    }

    /**
     * Gets the value of the preferences property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelPreference }
     *     
     */
    public ArrayOfJPHotelPreference getPreferences() {
        return preferences;
    }

    /**
     * Sets the value of the preferences property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelPreference }
     *     
     */
    public void setPreferences(ArrayOfJPHotelPreference value) {
        this.preferences = value;
    }

    /**
     * Gets the value of the allowedCreditCards property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCreditCard }
     *     
     */
    public ArrayOfJPCreditCard getAllowedCreditCards() {
        return allowedCreditCards;
    }

    /**
     * Sets the value of the allowedCreditCards property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCreditCard }
     *     
     */
    public void setAllowedCreditCards(ArrayOfJPCreditCard value) {
        this.allowedCreditCards = value;
    }

}
