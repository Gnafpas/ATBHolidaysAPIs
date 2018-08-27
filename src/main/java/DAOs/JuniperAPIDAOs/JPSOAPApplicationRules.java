
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_ApplicationRules complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_ApplicationRules">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StayDates" type="{http://www.juniper.es/webservice/2007/}JPSOAP_DateIntervalsGroupsStayDates" minOccurs="0"/>
 *         &lt;element name="CheckInDates" type="{http://www.juniper.es/webservice/2007/}JPSOAP_DateIntervalsGroupsCheckInDates" minOccurs="0"/>
 *         &lt;element name="CheckOutDates" type="{http://www.juniper.es/webservice/2007/}JPSOAP_DateIntervalsGroupsCheckInDates" minOccurs="0"/>
 *         &lt;element name="BookingDates" type="{http://www.juniper.es/webservice/2007/}JPSOAP_DateIntervals" minOccurs="0"/>
 *         &lt;element name="StayRestrictions" type="{http://www.juniper.es/webservice/2007/}JPSOAP_StayRestrictions" minOccurs="0"/>
 *         &lt;element name="BookingInAdvance" type="{http://www.juniper.es/webservice/2007/}JPSOAP_BookingInAdvance" minOccurs="0"/>
 *         &lt;element name="OccupancyRules" type="{http://www.juniper.es/webservice/2007/}JPSOAP_OccupanciesRules" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="MustMatchAllStayDates" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ApplyAllStayIfMatchAnyDate" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Quotation" use="required" type="{http://www.juniper.es/webservice/2007/}JPSOAP_ApplicationRuleQuotation" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_ApplicationRules", propOrder = {
    "stayDates",
    "checkInDates",
    "checkOutDates",
    "bookingDates",
    "stayRestrictions",
    "bookingInAdvance",
    "occupancyRules"
})
@XmlSeeAlso({
    JPSOAPApplicationRulesSupplement.class,
    JPSOAPApplicationRulesOffers.class
})
public class JPSOAPApplicationRules {

    @XmlElement(name = "StayDates")
    protected JPSOAPDateIntervalsGroupsStayDates stayDates;
    @XmlElement(name = "CheckInDates")
    protected JPSOAPDateIntervalsGroupsCheckInDates checkInDates;
    @XmlElement(name = "CheckOutDates")
    protected JPSOAPDateIntervalsGroupsCheckInDates checkOutDates;
    @XmlElement(name = "BookingDates")
    protected JPSOAPDateIntervals bookingDates;
    @XmlElement(name = "StayRestrictions")
    protected JPSOAPStayRestrictions stayRestrictions;
    @XmlElement(name = "BookingInAdvance")
    protected JPSOAPBookingInAdvance bookingInAdvance;
    @XmlElement(name = "OccupancyRules")
    protected JPSOAPOccupanciesRules occupancyRules;
    @XmlAttribute(name = "MustMatchAllStayDates", required = true)
    protected boolean mustMatchAllStayDates;
    @XmlAttribute(name = "ApplyAllStayIfMatchAnyDate", required = true)
    protected boolean applyAllStayIfMatchAnyDate;
    @XmlAttribute(name = "Quotation", required = true)
    protected JPSOAPApplicationRuleQuotation quotation;

    /**
     * Gets the value of the stayDates property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPDateIntervalsGroupsStayDates }
     *     
     */
    public JPSOAPDateIntervalsGroupsStayDates getStayDates() {
        return stayDates;
    }

    /**
     * Sets the value of the stayDates property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPDateIntervalsGroupsStayDates }
     *     
     */
    public void setStayDates(JPSOAPDateIntervalsGroupsStayDates value) {
        this.stayDates = value;
    }

    /**
     * Gets the value of the checkInDates property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPDateIntervalsGroupsCheckInDates }
     *     
     */
    public JPSOAPDateIntervalsGroupsCheckInDates getCheckInDates() {
        return checkInDates;
    }

    /**
     * Sets the value of the checkInDates property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPDateIntervalsGroupsCheckInDates }
     *     
     */
    public void setCheckInDates(JPSOAPDateIntervalsGroupsCheckInDates value) {
        this.checkInDates = value;
    }

    /**
     * Gets the value of the checkOutDates property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPDateIntervalsGroupsCheckInDates }
     *     
     */
    public JPSOAPDateIntervalsGroupsCheckInDates getCheckOutDates() {
        return checkOutDates;
    }

    /**
     * Sets the value of the checkOutDates property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPDateIntervalsGroupsCheckInDates }
     *     
     */
    public void setCheckOutDates(JPSOAPDateIntervalsGroupsCheckInDates value) {
        this.checkOutDates = value;
    }

    /**
     * Gets the value of the bookingDates property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPDateIntervals }
     *     
     */
    public JPSOAPDateIntervals getBookingDates() {
        return bookingDates;
    }

    /**
     * Sets the value of the bookingDates property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPDateIntervals }
     *     
     */
    public void setBookingDates(JPSOAPDateIntervals value) {
        this.bookingDates = value;
    }

    /**
     * Gets the value of the stayRestrictions property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPStayRestrictions }
     *     
     */
    public JPSOAPStayRestrictions getStayRestrictions() {
        return stayRestrictions;
    }

    /**
     * Sets the value of the stayRestrictions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPStayRestrictions }
     *     
     */
    public void setStayRestrictions(JPSOAPStayRestrictions value) {
        this.stayRestrictions = value;
    }

    /**
     * Gets the value of the bookingInAdvance property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPBookingInAdvance }
     *     
     */
    public JPSOAPBookingInAdvance getBookingInAdvance() {
        return bookingInAdvance;
    }

    /**
     * Sets the value of the bookingInAdvance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPBookingInAdvance }
     *     
     */
    public void setBookingInAdvance(JPSOAPBookingInAdvance value) {
        this.bookingInAdvance = value;
    }

    /**
     * Gets the value of the occupancyRules property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPOccupanciesRules }
     *     
     */
    public JPSOAPOccupanciesRules getOccupancyRules() {
        return occupancyRules;
    }

    /**
     * Sets the value of the occupancyRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPOccupanciesRules }
     *     
     */
    public void setOccupancyRules(JPSOAPOccupanciesRules value) {
        this.occupancyRules = value;
    }

    /**
     * Gets the value of the mustMatchAllStayDates property.
     * 
     */
    public boolean isMustMatchAllStayDates() {
        return mustMatchAllStayDates;
    }

    /**
     * Sets the value of the mustMatchAllStayDates property.
     * 
     */
    public void setMustMatchAllStayDates(boolean value) {
        this.mustMatchAllStayDates = value;
    }

    /**
     * Gets the value of the applyAllStayIfMatchAnyDate property.
     * 
     */
    public boolean isApplyAllStayIfMatchAnyDate() {
        return applyAllStayIfMatchAnyDate;
    }

    /**
     * Sets the value of the applyAllStayIfMatchAnyDate property.
     * 
     */
    public void setApplyAllStayIfMatchAnyDate(boolean value) {
        this.applyAllStayIfMatchAnyDate = value;
    }

    /**
     * Gets the value of the quotation property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPApplicationRuleQuotation }
     *     
     */
    public JPSOAPApplicationRuleQuotation getQuotation() {
        return quotation;
    }

    /**
     * Sets the value of the quotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPApplicationRuleQuotation }
     *     
     */
    public void setQuotation(JPSOAPApplicationRuleQuotation value) {
        this.quotation = value;
    }

}
