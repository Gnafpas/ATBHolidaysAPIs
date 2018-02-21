
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocHolderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocHolderFormattedName" type="{http://www.opentravel.org/OTA/2003/05}PersonNameType" minOccurs="0"/>
 *         &lt;element name="DocLimitations" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AdditionalPersonNames" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfString" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ShareSynchInd">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Yes"/>
 *             &lt;enumeration value="No"/>
 *             &lt;enumeration value="Inherit"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ShareMarketInd">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Yes"/>
 *             &lt;enumeration value="No"/>
 *             &lt;enumeration value="Inherit"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="DocIssueAuthority" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DocIssueLocation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DocID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DocType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Gender">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Male"/>
 *             &lt;enumeration value="Female"/>
 *             &lt;enumeration value="Unknown"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="BirthDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="ExpireDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="DocIssueStateProv" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DocIssueCountry" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BirthCountry" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DocHolderNationality" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentType", propOrder = {
    "docHolderName",
    "docHolderFormattedName",
    "docLimitations",
    "additionalPersonNames"
})
public class DocumentType {

    @XmlElement(name = "DocHolderName")
    protected String docHolderName;
    @XmlElement(name = "DocHolderFormattedName")
    protected PersonNameType docHolderFormattedName;
    @XmlElement(name = "DocLimitations")
    protected List<String> docLimitations;
    @XmlElement(name = "AdditionalPersonNames")
    protected ArrayOfString additionalPersonNames;
    @XmlAttribute(name = "ShareSynchInd")
    protected String shareSynchInd;
    @XmlAttribute(name = "ShareMarketInd")
    protected String shareMarketInd;
    @XmlAttribute(name = "DocIssueAuthority")
    protected String docIssueAuthority;
    @XmlAttribute(name = "DocIssueLocation")
    protected String docIssueLocation;
    @XmlAttribute(name = "DocID")
    protected String docID;
    @XmlAttribute(name = "DocType")
    protected String docType;
    @XmlAttribute(name = "Gender")
    protected String gender;
    @XmlAttribute(name = "BirthDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDate;
    @XmlAttribute(name = "EffectiveDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar effectiveDate;
    @XmlAttribute(name = "ExpireDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar expireDate;
    @XmlAttribute(name = "DocIssueStateProv")
    protected String docIssueStateProv;
    @XmlAttribute(name = "DocIssueCountry")
    protected String docIssueCountry;
    @XmlAttribute(name = "BirthCountry")
    protected String birthCountry;
    @XmlAttribute(name = "DocHolderNationality")
    protected String docHolderNationality;

    /**
     * Gets the value of the docHolderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocHolderName() {
        return docHolderName;
    }

    /**
     * Sets the value of the docHolderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocHolderName(String value) {
        this.docHolderName = value;
    }

    /**
     * Gets the value of the docHolderFormattedName property.
     * 
     * @return
     *     possible object is
     *     {@link PersonNameType }
     *     
     */
    public PersonNameType getDocHolderFormattedName() {
        return docHolderFormattedName;
    }

    /**
     * Sets the value of the docHolderFormattedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonNameType }
     *     
     */
    public void setDocHolderFormattedName(PersonNameType value) {
        this.docHolderFormattedName = value;
    }

    /**
     * Gets the value of the docLimitations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the docLimitations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocLimitations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDocLimitations() {
        if (docLimitations == null) {
            docLimitations = new ArrayList<String>();
        }
        return this.docLimitations;
    }

    /**
     * Gets the value of the additionalPersonNames property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getAdditionalPersonNames() {
        return additionalPersonNames;
    }

    /**
     * Sets the value of the additionalPersonNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setAdditionalPersonNames(ArrayOfString value) {
        this.additionalPersonNames = value;
    }

    /**
     * Gets the value of the shareSynchInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShareSynchInd() {
        return shareSynchInd;
    }

    /**
     * Sets the value of the shareSynchInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShareSynchInd(String value) {
        this.shareSynchInd = value;
    }

    /**
     * Gets the value of the shareMarketInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShareMarketInd() {
        return shareMarketInd;
    }

    /**
     * Sets the value of the shareMarketInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShareMarketInd(String value) {
        this.shareMarketInd = value;
    }

    /**
     * Gets the value of the docIssueAuthority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocIssueAuthority() {
        return docIssueAuthority;
    }

    /**
     * Sets the value of the docIssueAuthority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocIssueAuthority(String value) {
        this.docIssueAuthority = value;
    }

    /**
     * Gets the value of the docIssueLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocIssueLocation() {
        return docIssueLocation;
    }

    /**
     * Sets the value of the docIssueLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocIssueLocation(String value) {
        this.docIssueLocation = value;
    }

    /**
     * Gets the value of the docID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocID() {
        return docID;
    }

    /**
     * Sets the value of the docID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocID(String value) {
        this.docID = value;
    }

    /**
     * Gets the value of the docType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocType() {
        return docType;
    }

    /**
     * Sets the value of the docType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocType(String value) {
        this.docType = value;
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

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectiveDate(XMLGregorianCalendar value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the expireDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpireDate(XMLGregorianCalendar value) {
        this.expireDate = value;
    }

    /**
     * Gets the value of the docIssueStateProv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocIssueStateProv() {
        return docIssueStateProv;
    }

    /**
     * Sets the value of the docIssueStateProv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocIssueStateProv(String value) {
        this.docIssueStateProv = value;
    }

    /**
     * Gets the value of the docIssueCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocIssueCountry() {
        return docIssueCountry;
    }

    /**
     * Sets the value of the docIssueCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocIssueCountry(String value) {
        this.docIssueCountry = value;
    }

    /**
     * Gets the value of the birthCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthCountry() {
        return birthCountry;
    }

    /**
     * Sets the value of the birthCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthCountry(String value) {
        this.birthCountry = value;
    }

    /**
     * Gets the value of the docHolderNationality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocHolderNationality() {
        return docHolderNationality;
    }

    /**
     * Sets the value of the docHolderNationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocHolderNationality(String value) {
        this.docHolderNationality = value;
    }

}
