
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_VisaBookingRulesRQ complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_VisaBookingRulesRQ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Login" type="{http://www.juniper.es/webservice/2007/}JP_Login" minOccurs="0"/>
 *         &lt;element name="VisaBookingRuleRequest" type="{http://www.juniper.es/webservice/2007/}JP_VisaBookingRuleRequest" minOccurs="0"/>
 *         &lt;element name="AdvancedOptions" type="{http://www.juniper.es/webservice/2007/}JP_ServicesBookingRulesAdvancedOptions" minOccurs="0"/>
 *         &lt;element name="RestrictedOptions" type="{http://www.juniper.es/webservice/2007/}JP_RestrictedOptions" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Language" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_VisaBookingRulesRQ", propOrder = {
    "login",
    "visaBookingRuleRequest",
    "advancedOptions",
    "restrictedOptions"
})
public class JPVisaBookingRulesRQ {

    @XmlElement(name = "Login")
    protected JPLogin login;
    @XmlElement(name = "VisaBookingRuleRequest")
    protected JPVisaBookingRuleRequest visaBookingRuleRequest;
    @XmlElement(name = "AdvancedOptions")
    protected JPServicesBookingRulesAdvancedOptions advancedOptions;
    @XmlElement(name = "RestrictedOptions")
    protected JPRestrictedOptions restrictedOptions;
    @XmlAttribute(name = "Version")
    protected String version;
    @XmlAttribute(name = "Language")
    protected String language;

    /**
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link JPLogin }
     *     
     */
    public JPLogin getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPLogin }
     *     
     */
    public void setLogin(JPLogin value) {
        this.login = value;
    }

    /**
     * Gets the value of the visaBookingRuleRequest property.
     * 
     * @return
     *     possible object is
     *     {@link JPVisaBookingRuleRequest }
     *     
     */
    public JPVisaBookingRuleRequest getVisaBookingRuleRequest() {
        return visaBookingRuleRequest;
    }

    /**
     * Sets the value of the visaBookingRuleRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPVisaBookingRuleRequest }
     *     
     */
    public void setVisaBookingRuleRequest(JPVisaBookingRuleRequest value) {
        this.visaBookingRuleRequest = value;
    }

    /**
     * Gets the value of the advancedOptions property.
     * 
     * @return
     *     possible object is
     *     {@link JPServicesBookingRulesAdvancedOptions }
     *     
     */
    public JPServicesBookingRulesAdvancedOptions getAdvancedOptions() {
        return advancedOptions;
    }

    /**
     * Sets the value of the advancedOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServicesBookingRulesAdvancedOptions }
     *     
     */
    public void setAdvancedOptions(JPServicesBookingRulesAdvancedOptions value) {
        this.advancedOptions = value;
    }

    /**
     * Gets the value of the restrictedOptions property.
     * 
     * @return
     *     possible object is
     *     {@link JPRestrictedOptions }
     *     
     */
    public JPRestrictedOptions getRestrictedOptions() {
        return restrictedOptions;
    }

    /**
     * Sets the value of the restrictedOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRestrictedOptions }
     *     
     */
    public void setRestrictedOptions(JPRestrictedOptions value) {
        this.restrictedOptions = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

}
