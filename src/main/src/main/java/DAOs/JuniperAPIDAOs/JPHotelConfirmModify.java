
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelConfirmModify complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelConfirmModify">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Login" type="{http://www.juniper.es/webservice/2007/}JP_Login" minOccurs="0"/>
 *         &lt;element name="ReservationLocator" type="{http://www.juniper.es/webservice/2007/}JP_ReservationLocationModify" minOccurs="0"/>
 *         &lt;element name="Paxes" type="{http://www.juniper.es/webservice/2007/}JP_Paxes" minOccurs="0"/>
 *         &lt;element name="Holder" type="{http://www.juniper.es/webservice/2007/}JP_Holder" minOccurs="0"/>
 *         &lt;element name="ExternalBookingReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Comment" minOccurs="0"/>
 *         &lt;element name="HotelElement" type="{http://www.juniper.es/webservice/2007/}JP_HotelConfirmElement" minOccurs="0"/>
 *         &lt;element name="AdvancedOptions" type="{http://www.juniper.es/webservice/2007/}JP_HotelModifyAdvancedOptions" minOccurs="0"/>
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
@XmlType(name = "JP_HotelConfirmModify", propOrder = {
    "login",
    "reservationLocator",
    "paxes",
    "holder",
    "externalBookingReference",
    "comments",
    "hotelElement",
    "advancedOptions",
    "restrictedOptions"
})
public class JPHotelConfirmModify {

    @XmlElement(name = "Login")
    protected JPLogin login;
    @XmlElement(name = "ReservationLocator")
    protected JPReservationLocationModify reservationLocator;
    @XmlElement(name = "Paxes")
    protected JPPaxes paxes;
    @XmlElement(name = "Holder")
    protected JPHolder holder;
    @XmlElement(name = "ExternalBookingReference")
    protected String externalBookingReference;
    @XmlElement(name = "Comments")
    protected ArrayOfJPComment comments;
    @XmlElement(name = "HotelElement")
    protected JPHotelConfirmElement hotelElement;
    @XmlElement(name = "AdvancedOptions")
    protected JPHotelModifyAdvancedOptions advancedOptions;
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
     * Gets the value of the reservationLocator property.
     * 
     * @return
     *     possible object is
     *     {@link JPReservationLocationModify }
     *     
     */
    public JPReservationLocationModify getReservationLocator() {
        return reservationLocator;
    }

    /**
     * Sets the value of the reservationLocator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPReservationLocationModify }
     *     
     */
    public void setReservationLocator(JPReservationLocationModify value) {
        this.reservationLocator = value;
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
     * Gets the value of the holder property.
     * 
     * @return
     *     possible object is
     *     {@link JPHolder }
     *     
     */
    public JPHolder getHolder() {
        return holder;
    }

    /**
     * Sets the value of the holder property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHolder }
     *     
     */
    public void setHolder(JPHolder value) {
        this.holder = value;
    }

    /**
     * Gets the value of the externalBookingReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalBookingReference() {
        return externalBookingReference;
    }

    /**
     * Sets the value of the externalBookingReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalBookingReference(String value) {
        this.externalBookingReference = value;
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
     * Gets the value of the hotelElement property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelConfirmElement }
     *     
     */
    public JPHotelConfirmElement getHotelElement() {
        return hotelElement;
    }

    /**
     * Sets the value of the hotelElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelConfirmElement }
     *     
     */
    public void setHotelElement(JPHotelConfirmElement value) {
        this.hotelElement = value;
    }

    /**
     * Gets the value of the advancedOptions property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelModifyAdvancedOptions }
     *     
     */
    public JPHotelModifyAdvancedOptions getAdvancedOptions() {
        return advancedOptions;
    }

    /**
     * Sets the value of the advancedOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelModifyAdvancedOptions }
     *     
     */
    public void setAdvancedOptions(JPHotelModifyAdvancedOptions value) {
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
