
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_Pax complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Pax">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Document" type="{http://www.juniper.es/webservice/2007/}JP_Document" minOccurs="0"/>
 *         &lt;element name="PhoneNumbers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PhoneNumber" minOccurs="0"/>
 *         &lt;element name="BillingDataAFIP" type="{http://www.juniper.es/webservice/2007/}JP_BillingDataAFIP" minOccurs="0"/>
 *         &lt;element name="Cards" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Card" minOccurs="0"/>
 *         &lt;element name="ResidentDiscount" type="{http://www.juniper.es/webservice/2007/}JP_ResidentDiscount" minOccurs="0"/>
 *         &lt;element name="LargeFamilyDiscount" type="{http://www.juniper.es/webservice/2007/}JP_LargeFamilyDiscount" minOccurs="0"/>
 *         &lt;element name="TicketNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Age" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BornDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="IdPax" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Gender">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="M"/>
 *             &lt;enumeration value="F"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Pax", propOrder = {
    "document",
    "phoneNumbers",
    "billingDataAFIP",
    "cards",
    "residentDiscount",
    "largeFamilyDiscount",
    "ticketNumber",
    "title",
    "name",
    "surname",
    "age",
    "email",
    "bornDate",
    "address",
    "city",
    "country",
    "postalCode",
    "nationality"
})
public class JPPax {

    @XmlElement(name = "Document")
    protected JPDocument document;
    @XmlElement(name = "PhoneNumbers")
    protected ArrayOfJPPhoneNumber phoneNumbers;
    @XmlElement(name = "BillingDataAFIP")
    protected JPBillingDataAFIP billingDataAFIP;
    @XmlElement(name = "Cards")
    protected ArrayOfJPCard cards;
    @XmlElement(name = "ResidentDiscount")
    protected JPResidentDiscount residentDiscount;
    @XmlElement(name = "LargeFamilyDiscount")
    protected JPLargeFamilyDiscount largeFamilyDiscount;
    @XmlElement(name = "TicketNumber")
    protected String ticketNumber;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Surname")
    protected String surname;
    @XmlElementRef(name = "Age", namespace = "http://www.juniper.es/webservice/2007/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> age;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "BornDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar bornDate;
    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "Country")
    protected String country;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "Nationality")
    protected String nationality;
    @XmlAttribute(name = "IdPax", required = true)
    protected int idPax;
    @XmlAttribute(name = "Gender")
    protected String gender;

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
     * Gets the value of the phoneNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPhoneNumber }
     *     
     */
    public ArrayOfJPPhoneNumber getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Sets the value of the phoneNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPhoneNumber }
     *     
     */
    public void setPhoneNumbers(ArrayOfJPPhoneNumber value) {
        this.phoneNumbers = value;
    }

    /**
     * Gets the value of the billingDataAFIP property.
     * 
     * @return
     *     possible object is
     *     {@link JPBillingDataAFIP }
     *     
     */
    public JPBillingDataAFIP getBillingDataAFIP() {
        return billingDataAFIP;
    }

    /**
     * Sets the value of the billingDataAFIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBillingDataAFIP }
     *     
     */
    public void setBillingDataAFIP(JPBillingDataAFIP value) {
        this.billingDataAFIP = value;
    }

    /**
     * Gets the value of the cards property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCard }
     *     
     */
    public ArrayOfJPCard getCards() {
        return cards;
    }

    /**
     * Sets the value of the cards property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCard }
     *     
     */
    public void setCards(ArrayOfJPCard value) {
        this.cards = value;
    }

    /**
     * Gets the value of the residentDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link JPResidentDiscount }
     *     
     */
    public JPResidentDiscount getResidentDiscount() {
        return residentDiscount;
    }

    /**
     * Sets the value of the residentDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPResidentDiscount }
     *     
     */
    public void setResidentDiscount(JPResidentDiscount value) {
        this.residentDiscount = value;
    }

    /**
     * Gets the value of the largeFamilyDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link JPLargeFamilyDiscount }
     *     
     */
    public JPLargeFamilyDiscount getLargeFamilyDiscount() {
        return largeFamilyDiscount;
    }

    /**
     * Sets the value of the largeFamilyDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPLargeFamilyDiscount }
     *     
     */
    public void setLargeFamilyDiscount(JPLargeFamilyDiscount value) {
        this.largeFamilyDiscount = value;
    }

    /**
     * Gets the value of the ticketNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Sets the value of the ticketNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketNumber(String value) {
        this.ticketNumber = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
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
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setAge(JAXBElement<Integer> value) {
        this.age = value;
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
     * Gets the value of the bornDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBornDate() {
        return bornDate;
    }

    /**
     * Sets the value of the bornDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBornDate(XMLGregorianCalendar value) {
        this.bornDate = value;
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
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the nationality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the value of the nationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationality(String value) {
        this.nationality = value;
    }

    /**
     * Gets the value of the idPax property.
     * 
     */
    public int getIdPax() {
        return idPax;
    }

    /**
     * Sets the value of the idPax property.
     * 
     */
    public void setIdPax(int value) {
        this.idPax = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

}
