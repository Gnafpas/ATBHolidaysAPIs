
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_hotelRatePlanCancellationPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_hotelRatePlanCancellationPolicy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BookingDate" type="{http://www.juniper.es/webservice/2007/}JPSOAP_DateIntervals" minOccurs="0"/>
 *         &lt;element name="CheckInDates" type="{http://www.juniper.es/webservice/2007/}JPSOAP_DateIntervalsGroupsStayDates" minOccurs="0"/>
 *         &lt;element name="Rules" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_hotelRatePlanCancellationPolicyRule" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Priority" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="OnlyEarlyBooking" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="NonRefundable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_hotelRatePlanCancellationPolicy", propOrder = {
    "name",
    "description",
    "bookingDate",
    "checkInDates",
    "rules"
})
public class JPSOAPHotelRatePlanCancellationPolicy {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "BookingDate")
    protected JPSOAPDateIntervals bookingDate;
    @XmlElement(name = "CheckInDates")
    protected JPSOAPDateIntervalsGroupsStayDates checkInDates;
    @XmlElement(name = "Rules")
    protected ArrayOfJPSOAPHotelRatePlanCancellationPolicyRule rules;
    @XmlAttribute(name = "Code", required = true)
    protected int code;
    @XmlAttribute(name = "Priority", required = true)
    protected int priority;
    @XmlAttribute(name = "OnlyEarlyBooking", required = true)
    protected boolean onlyEarlyBooking;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "NonRefundable", required = true)
    protected boolean nonRefundable;

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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the bookingDate property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPDateIntervals }
     *     
     */
    public JPSOAPDateIntervals getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the value of the bookingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPDateIntervals }
     *     
     */
    public void setBookingDate(JPSOAPDateIntervals value) {
        this.bookingDate = value;
    }

    /**
     * Gets the value of the checkInDates property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPDateIntervalsGroupsStayDates }
     *     
     */
    public JPSOAPDateIntervalsGroupsStayDates getCheckInDates() {
        return checkInDates;
    }

    /**
     * Sets the value of the checkInDates property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPDateIntervalsGroupsStayDates }
     *     
     */
    public void setCheckInDates(JPSOAPDateIntervalsGroupsStayDates value) {
        this.checkInDates = value;
    }

    /**
     * Gets the value of the rules property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPHotelRatePlanCancellationPolicyRule }
     *     
     */
    public ArrayOfJPSOAPHotelRatePlanCancellationPolicyRule getRules() {
        return rules;
    }

    /**
     * Sets the value of the rules property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPHotelRatePlanCancellationPolicyRule }
     *     
     */
    public void setRules(ArrayOfJPSOAPHotelRatePlanCancellationPolicyRule value) {
        this.rules = value;
    }

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
     * Gets the value of the priority property.
     * 
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     */
    public void setPriority(int value) {
        this.priority = value;
    }

    /**
     * Gets the value of the onlyEarlyBooking property.
     * 
     */
    public boolean isOnlyEarlyBooking() {
        return onlyEarlyBooking;
    }

    /**
     * Sets the value of the onlyEarlyBooking property.
     * 
     */
    public void setOnlyEarlyBooking(boolean value) {
        this.onlyEarlyBooking = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the nonRefundable property.
     * 
     */
    public boolean isNonRefundable() {
        return nonRefundable;
    }

    /**
     * Sets the value of the nonRefundable property.
     * 
     */
    public void setNonRefundable(boolean value) {
        this.nonRefundable = value;
    }

}
