
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_AgencyStaticData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_AgencyStaticData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PhoneNumber" type="{http://www.juniper.es/webservice/2007/}JP_PhoneNumber" minOccurs="0"/>
 *         &lt;element name="AgencyGroup" type="{http://www.juniper.es/webservice/2007/}JP_AgencyGroup" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_AgencyStaticData", propOrder = {
    "code",
    "name",
    "email",
    "phoneNumber",
    "agencyGroup",
    "type"
})
public class JPAgencyStaticData {

    @XmlElement(name = "Code")
    protected int code;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "PhoneNumber")
    protected JPPhoneNumber phoneNumber;
    @XmlElement(name = "AgencyGroup")
    protected JPAgencyGroup agencyGroup;
    @XmlElement(name = "Type")
    protected int type;

    /**
     * Gets the value of the code property.
     * 
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     */
    public void setCode(int value) {
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
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JPPhoneNumber }
     *     
     */
    public JPPhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPhoneNumber }
     *     
     */
    public void setPhoneNumber(JPPhoneNumber value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the agencyGroup property.
     * 
     * @return
     *     possible object is
     *     {@link JPAgencyGroup }
     *     
     */
    public JPAgencyGroup getAgencyGroup() {
        return agencyGroup;
    }

    /**
     * Sets the value of the agencyGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPAgencyGroup }
     *     
     */
    public void setAgencyGroup(JPAgencyGroup value) {
        this.agencyGroup = value;
    }

    /**
     * Gets the value of the type property.
     * 
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     */
    public void setType(int value) {
        this.type = value;
    }

}
