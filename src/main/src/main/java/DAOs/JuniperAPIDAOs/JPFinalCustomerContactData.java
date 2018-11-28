
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FinalCustomerContactData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FinalCustomerContactData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PhoneNumbers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PhoneNumber" minOccurs="0"/>
 *         &lt;element name="AddressData" type="{http://www.juniper.es/webservice/2007/}JP_FinalCustomerContactAddressData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FinalCustomerContactData", propOrder = {
    "email",
    "phoneNumbers",
    "addressData"
})
public class JPFinalCustomerContactData {

    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "PhoneNumbers")
    protected ArrayOfJPPhoneNumber phoneNumbers;
    @XmlElement(name = "AddressData")
    protected JPFinalCustomerContactAddressData addressData;

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
     * Gets the value of the addressData property.
     * 
     * @return
     *     possible object is
     *     {@link JPFinalCustomerContactAddressData }
     *     
     */
    public JPFinalCustomerContactAddressData getAddressData() {
        return addressData;
    }

    /**
     * Sets the value of the addressData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFinalCustomerContactAddressData }
     *     
     */
    public void setAddressData(JPFinalCustomerContactAddressData value) {
        this.addressData = value;
    }

}
