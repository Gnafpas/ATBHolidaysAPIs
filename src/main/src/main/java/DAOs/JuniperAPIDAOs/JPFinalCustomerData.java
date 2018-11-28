
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FinalCustomerData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FinalCustomerData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactData" type="{http://www.juniper.es/webservice/2007/}JP_FinalCustomerContactData" minOccurs="0"/>
 *         &lt;element name="Document" type="{http://www.juniper.es/webservice/2007/}JP_Document" minOccurs="0"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Comment" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="IsCorporative" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="AcceptOfferMailing" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Active" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FinalCustomerData", propOrder = {
    "code",
    "name",
    "surname",
    "contactData",
    "document",
    "password",
    "comments"
})
public class JPFinalCustomerData {

    @XmlElement(name = "Code")
    protected Integer code;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Surname")
    protected String surname;
    @XmlElement(name = "ContactData")
    protected JPFinalCustomerContactData contactData;
    @XmlElement(name = "Document")
    protected JPDocument document;
    @XmlElement(name = "Password")
    protected String password;
    @XmlElement(name = "Comments")
    protected ArrayOfJPComment comments;
    @XmlAttribute(name = "IsCorporative", required = true)
    protected boolean isCorporative;
    @XmlAttribute(name = "AcceptOfferMailing", required = true)
    protected boolean acceptOfferMailing;
    @XmlAttribute(name = "Active", required = true)
    protected boolean active;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCode(Integer value) {
        this.code = value;
    }

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
     * Gets the value of the contactData property.
     * 
     * @return
     *     possible object is
     *     {@link JPFinalCustomerContactData }
     *     
     */
    public JPFinalCustomerContactData getContactData() {
        return contactData;
    }

    /**
     * Sets the value of the contactData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFinalCustomerContactData }
     *     
     */
    public void setContactData(JPFinalCustomerContactData value) {
        this.contactData = value;
    }

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link JPDocument }
     *     
     */
    public JPDocument getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPDocument }
     *     
     */
    public void setDocument(JPDocument value) {
        this.document = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
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
     * Gets the value of the isCorporative property.
     * 
     */
    public boolean isIsCorporative() {
        return isCorporative;
    }

    /**
     * Sets the value of the isCorporative property.
     * 
     */
    public void setIsCorporative(boolean value) {
        this.isCorporative = value;
    }

    /**
     * Gets the value of the acceptOfferMailing property.
     * 
     */
    public boolean isAcceptOfferMailing() {
        return acceptOfferMailing;
    }

    /**
     * Sets the value of the acceptOfferMailing property.
     * 
     */
    public void setAcceptOfferMailing(boolean value) {
        this.acceptOfferMailing = value;
    }

    /**
     * Gets the value of the active property.
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setActive(boolean value) {
        this.active = value;
    }

}
