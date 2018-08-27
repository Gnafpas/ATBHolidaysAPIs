
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FlightBookingRulesRQ complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightBookingRulesRQ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Login" type="{http://www.juniper.es/webservice/2007/}JP_Login" minOccurs="0"/>
 *         &lt;element name="Paxes" type="{http://www.juniper.es/webservice/2007/}JP_Paxes" minOccurs="0"/>
 *         &lt;element name="FlightBookingRulesRequest" type="{http://www.juniper.es/webservice/2007/}JP_FlightBookingRulesRequest" minOccurs="0"/>
 *         &lt;element name="AdvancedOptions" type="{http://www.juniper.es/webservice/2007/}JP_FlightBookingRulesAdvancedOptions" minOccurs="0"/>
 *         &lt;element name="RestrictedOptions" type="{http://www.juniper.es/webservice/2007/}JP_RestrictedOptions" minOccurs="0"/>
 *         &lt;element name="AssignSeats" type="{http://www.juniper.es/webservice/2007/}JP_FlightAssignSeats" minOccurs="0"/>
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
@XmlType(name = "JP_FlightBookingRulesRQ", propOrder = {
    "login",
    "paxes",
    "flightBookingRulesRequest",
    "advancedOptions",
    "restrictedOptions",
    "assignSeats"
})
public class JPFlightBookingRulesRQ {

    @XmlElement(name = "Login")
    protected JPLogin login;
    @XmlElement(name = "Paxes")
    protected JPPaxes paxes;
    @XmlElement(name = "FlightBookingRulesRequest")
    protected JPFlightBookingRulesRequest flightBookingRulesRequest;
    @XmlElement(name = "AdvancedOptions")
    protected JPFlightBookingRulesAdvancedOptions advancedOptions;
    @XmlElement(name = "RestrictedOptions")
    protected JPRestrictedOptions restrictedOptions;
    @XmlElement(name = "AssignSeats")
    protected JPFlightAssignSeats assignSeats;
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
     * Gets the value of the paxes property.
     * 
     * @return
     *     possible object is
     *     {@link JPPaxes }
     *     
     */
    public JPPaxes getPaxes() {
        return paxes;
    }

    /**
     * Sets the value of the paxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPaxes }
     *     
     */
    public void setPaxes(JPPaxes value) {
        this.paxes = value;
    }

    /**
     * Gets the value of the flightBookingRulesRequest property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightBookingRulesRequest }
     *     
     */
    public JPFlightBookingRulesRequest getFlightBookingRulesRequest() {
        return flightBookingRulesRequest;
    }

    /**
     * Sets the value of the flightBookingRulesRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightBookingRulesRequest }
     *     
     */
    public void setFlightBookingRulesRequest(JPFlightBookingRulesRequest value) {
        this.flightBookingRulesRequest = value;
    }

    /**
     * Gets the value of the advancedOptions property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightBookingRulesAdvancedOptions }
     *     
     */
    public JPFlightBookingRulesAdvancedOptions getAdvancedOptions() {
        return advancedOptions;
    }

    /**
     * Sets the value of the advancedOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightBookingRulesAdvancedOptions }
     *     
     */
    public void setAdvancedOptions(JPFlightBookingRulesAdvancedOptions value) {
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
     * Gets the value of the assignSeats property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightAssignSeats }
     *     
     */
    public JPFlightAssignSeats getAssignSeats() {
        return assignSeats;
    }

    /**
     * Sets the value of the assignSeats property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightAssignSeats }
     *     
     */
    public void setAssignSeats(JPFlightAssignSeats value) {
        this.assignSeats = value;
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
