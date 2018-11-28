
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Reservation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Reservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExternalBookingReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Holder" type="{http://www.juniper.es/webservice/2007/}JP_Holder" minOccurs="0"/>
 *         &lt;element name="Paxes" type="{http://www.juniper.es/webservice/2007/}JP_Paxes" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Comment" minOccurs="0"/>
 *         &lt;element name="FinalCustomerCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="AgenciesData" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_AgencyData" minOccurs="0"/>
 *         &lt;element name="Items" type="{http://www.juniper.es/webservice/2007/}JP_Items" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ReservationCode" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Locator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BookingChannel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Status" use="required" type="{http://www.juniper.es/webservice/2007/}JP_ResStatus" />
 *       &lt;attribute name="Language" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Reservation", propOrder = {
    "externalBookingReference",
    "holder",
    "paxes",
    "comments",
    "finalCustomerCode",
    "agenciesData",
    "items"
})
public class JPReservation {

    @XmlElement(name = "ExternalBookingReference")
    protected String externalBookingReference;
    @XmlElement(name = "Holder")
    protected JPHolder holder;
    @XmlElement(name = "Paxes")
    protected JPPaxes paxes;
    @XmlElement(name = "Comments")
    protected ArrayOfJPComment comments;
    @XmlElement(name = "FinalCustomerCode")
    protected Integer finalCustomerCode;
    @XmlElement(name = "AgenciesData")
    protected ArrayOfJPAgencyData agenciesData;
    @XmlElement(name = "Items")
    protected JPItems items;
    @XmlAttribute(name = "ReservationCode")
    protected Integer reservationCode;
    @XmlAttribute(name = "Locator")
    protected String locator;
    @XmlAttribute(name = "BookingChannel")
    protected String bookingChannel;
    @XmlAttribute(name = "Status", required = true)
    protected JPResStatus status;
    @XmlAttribute(name = "Language")
    protected String language;

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
     * Gets the value of the finalCustomerCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFinalCustomerCode() {
        return finalCustomerCode;
    }

    /**
     * Sets the value of the finalCustomerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFinalCustomerCode(Integer value) {
        this.finalCustomerCode = value;
    }

    /**
     * Gets the value of the agenciesData property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPAgencyData }
     *     
     */
    public ArrayOfJPAgencyData getAgenciesData() {
        return agenciesData;
    }

    /**
     * Sets the value of the agenciesData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPAgencyData }
     *     
     */
    public void setAgenciesData(ArrayOfJPAgencyData value) {
        this.agenciesData = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link JPItems }
     *     
     */
    public JPItems getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPItems }
     *     
     */
    public void setItems(JPItems value) {
        this.items = value;
    }

    /**
     * Gets the value of the reservationCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReservationCode() {
        return reservationCode;
    }

    /**
     * Sets the value of the reservationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReservationCode(Integer value) {
        this.reservationCode = value;
    }

    /**
     * Gets the value of the locator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocator() {
        return locator;
    }

    /**
     * Sets the value of the locator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocator(String value) {
        this.locator = value;
    }

    /**
     * Gets the value of the bookingChannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingChannel() {
        return bookingChannel;
    }

    /**
     * Sets the value of the bookingChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingChannel(String value) {
        this.bookingChannel = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JPResStatus }
     *     
     */
    public JPResStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPResStatus }
     *     
     */
    public void setStatus(JPResStatus value) {
        this.status = value;
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
