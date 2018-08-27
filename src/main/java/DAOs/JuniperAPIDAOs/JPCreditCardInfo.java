
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CreditCardInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CreditCardInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.juniper.es/webservice/2007/}JP_AddressType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CardCode" use="required" type="{http://www.juniper.es/webservice/2007/}JP_CreditCardType" />
 *       &lt;attribute name="CvC" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CardNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SeriesCode" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ExpireDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CreditCardInfo", propOrder = {
    "name",
    "surname",
    "email",
    "address"
})
public class JPCreditCardInfo {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Surname")
    protected String surname;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "Address")
    protected JPAddressType address;
    @XmlAttribute(name = "CardCode", required = true)
    protected JPCreditCardType cardCode;
    @XmlAttribute(name = "CvC")
    protected String cvC;
    @XmlAttribute(name = "CardNumber")
    protected String cardNumber;
    @XmlAttribute(name = "SeriesCode")
    protected Integer seriesCode;
    @XmlAttribute(name = "ExpireDate")
    protected String expireDate;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link JPAddressType }
     *     
     */
    public JPAddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPAddressType }
     *     
     */
    public void setAddress(JPAddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the cardCode property.
     * 
     * @return
     *     possible object is
     *     {@link JPCreditCardType }
     *     
     */
    public JPCreditCardType getCardCode() {
        return cardCode;
    }

    /**
     * Sets the value of the cardCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCreditCardType }
     *     
     */
    public void setCardCode(JPCreditCardType value) {
        this.cardCode = value;
    }

    /**
     * Gets the value of the cvC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCvC() {
        return cvC;
    }

    /**
     * Sets the value of the cvC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCvC(String value) {
        this.cvC = value;
    }

    /**
     * Gets the value of the cardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the value of the cardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * Gets the value of the seriesCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSeriesCode() {
        return seriesCode;
    }

    /**
     * Sets the value of the seriesCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSeriesCode(Integer value) {
        this.seriesCode = value;
    }

    /**
     * Gets the value of the expireDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpireDate(String value) {
        this.expireDate = value;
    }

}
