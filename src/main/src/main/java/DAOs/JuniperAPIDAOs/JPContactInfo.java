
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ContactInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ContactInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PhoneNumbers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PhoneNumber" minOccurs="0"/>
 *         &lt;element name="Faxes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Fax" minOccurs="0"/>
 *         &lt;element name="Emails" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Email" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ContactInfo", propOrder = {
    "phoneNumbers",
    "faxes",
    "emails"
})
public class JPContactInfo {

    @XmlElement(name = "PhoneNumbers")
    protected ArrayOfJPPhoneNumber phoneNumbers;
    @XmlElement(name = "Faxes")
    protected ArrayOfJPFax faxes;
    @XmlElement(name = "Emails")
    protected ArrayOfJPEmail emails;

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
     * Gets the value of the faxes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPFax }
     *     
     */
    public ArrayOfJPFax getFaxes() {
        return faxes;
    }

    /**
     * Sets the value of the faxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPFax }
     *     
     */
    public void setFaxes(ArrayOfJPFax value) {
        this.faxes = value;
    }

    /**
     * Gets the value of the emails property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPEmail }
     *     
     */
    public ArrayOfJPEmail getEmails() {
        return emails;
    }

    /**
     * Sets the value of the emails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPEmail }
     *     
     */
    public void setEmails(ArrayOfJPEmail value) {
        this.emails = value;
    }

}
