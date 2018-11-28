
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelInventoryContactInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelInventoryContactInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PhoneNumbers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_ContactNumber" minOccurs="0"/>
 *         &lt;element name="Faxes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_ContactNumber1" minOccurs="0"/>
 *         &lt;element name="Emails" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_Email" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelInventoryContactInfo", propOrder = {
    "phoneNumbers",
    "faxes",
    "emails"
})
public class JPSOAPHotelInventoryContactInfo {

    @XmlElement(name = "PhoneNumbers")
    protected ArrayOfJPSOAPContactNumber phoneNumbers;
    @XmlElement(name = "Faxes")
    protected ArrayOfJPSOAPContactNumber1 faxes;
    @XmlElement(name = "Emails")
    protected ArrayOfJPSOAPEmail emails;

    /**
     * Gets the value of the phoneNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPContactNumber }
     *     
     */
    public ArrayOfJPSOAPContactNumber getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Sets the value of the phoneNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPContactNumber }
     *     
     */
    public void setPhoneNumbers(ArrayOfJPSOAPContactNumber value) {
        this.phoneNumbers = value;
    }

    /**
     * Gets the value of the faxes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPContactNumber1 }
     *     
     */
    public ArrayOfJPSOAPContactNumber1 getFaxes() {
        return faxes;
    }

    /**
     * Sets the value of the faxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPContactNumber1 }
     *     
     */
    public void setFaxes(ArrayOfJPSOAPContactNumber1 value) {
        this.faxes = value;
    }

    /**
     * Gets the value of the emails property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPEmail }
     *     
     */
    public ArrayOfJPSOAPEmail getEmails() {
        return emails;
    }

    /**
     * Sets the value of the emails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPEmail }
     *     
     */
    public void setEmails(ArrayOfJPSOAPEmail value) {
        this.emails = value;
    }

}
