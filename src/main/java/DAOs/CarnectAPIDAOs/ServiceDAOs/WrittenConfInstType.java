
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WrittenConfInstType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WrittenConfInstType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SupplementalData" type="{http://www.opentravel.org/OTA/2003/05}ParagraphType" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.opentravel.org/OTA/2003/05}EmailType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="LanguageID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AddresseeName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Address" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Telephone" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ConfirmInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WrittenConfInstType", propOrder = {
    "supplementalData",
    "email"
})
public class WrittenConfInstType {

    @XmlElement(name = "SupplementalData")
    protected ParagraphType supplementalData;
    @XmlElement(name = "Email")
    protected EmailType email;
    @XmlAttribute(name = "LanguageID")
    protected String languageID;
    @XmlAttribute(name = "AddresseeName")
    protected String addresseeName;
    @XmlAttribute(name = "Address")
    protected String address;
    @XmlAttribute(name = "Telephone")
    protected String telephone;
    @XmlAttribute(name = "ConfirmInd")
    protected Boolean confirmInd;

    /**
     * Gets the value of the supplementalData property.
     * 
     * @return
     *     possible object is
     *     {@link ParagraphType }
     *     
     */
    public ParagraphType getSupplementalData() {
        return supplementalData;
    }

    /**
     * Sets the value of the supplementalData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParagraphType }
     *     
     */
    public void setSupplementalData(ParagraphType value) {
        this.supplementalData = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link EmailType }
     *     
     */
    public EmailType getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmailType }
     *     
     */
    public void setEmail(EmailType value) {
        this.email = value;
    }

    /**
     * Gets the value of the languageID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageID() {
        return languageID;
    }

    /**
     * Sets the value of the languageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageID(String value) {
        this.languageID = value;
    }

    /**
     * Gets the value of the addresseeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddresseeName() {
        return addresseeName;
    }

    /**
     * Sets the value of the addresseeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddresseeName(String value) {
        this.addresseeName = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephone(String value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the confirmInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConfirmInd() {
        return confirmInd;
    }

    /**
     * Sets the value of the confirmInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConfirmInd(Boolean value) {
        this.confirmInd = value;
    }

}
