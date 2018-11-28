
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_EmergencyContact complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_EmergencyContact">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PhoneNumbers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PhoneNumber" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Allowed" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_EmergencyContact", propOrder = {
    "name",
    "phoneNumbers"
})
public class JPEmergencyContact {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "PhoneNumbers")
    protected ArrayOfJPPhoneNumber phoneNumbers;
    @XmlAttribute(name = "Allowed")
    protected Boolean allowed;

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
     * Gets the value of the allowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowed() {
        return allowed;
    }

    /**
     * Sets the value of the allowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowed(Boolean value) {
        this.allowed = value;
    }

}
