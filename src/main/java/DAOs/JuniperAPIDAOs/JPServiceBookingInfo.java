
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ServiceBookingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ServiceBookingInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MeetingPointInfo" type="{http://www.juniper.es/webservice/2007/}JP_MeetingPointInfo" minOccurs="0"/>
 *         &lt;element name="GroundHandlingComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelService" type="{http://www.juniper.es/webservice/2007/}JP_HotelService" minOccurs="0"/>
 *         &lt;element name="FlightInfoOrigin" type="{http://www.juniper.es/webservice/2007/}JP_FlightInfoService" minOccurs="0"/>
 *         &lt;element name="FlightInfoDestination" type="{http://www.juniper.es/webservice/2007/}JP_FlightInfoService" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ICode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ServiceBookingInfo", propOrder = {
    "meetingPointInfo",
    "groundHandlingComments",
    "hotelService",
    "flightInfoOrigin",
    "flightInfoDestination"
})
public class JPServiceBookingInfo {

    @XmlElement(name = "MeetingPointInfo")
    protected JPMeetingPointInfo meetingPointInfo;
    @XmlElement(name = "GroundHandlingComments")
    protected String groundHandlingComments;
    @XmlElement(name = "HotelService")
    protected JPHotelService hotelService;
    @XmlElement(name = "FlightInfoOrigin")
    protected JPFlightInfoService flightInfoOrigin;
    @XmlElement(name = "FlightInfoDestination")
    protected JPFlightInfoService flightInfoDestination;
    @XmlAttribute(name = "ICode")
    protected String iCode;

    /**
     * Gets the value of the meetingPointInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPMeetingPointInfo }
     *     
     */
    public JPMeetingPointInfo getMeetingPointInfo() {
        return meetingPointInfo;
    }

    /**
     * Sets the value of the meetingPointInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPMeetingPointInfo }
     *     
     */
    public void setMeetingPointInfo(JPMeetingPointInfo value) {
        this.meetingPointInfo = value;
    }

    /**
     * Gets the value of the groundHandlingComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroundHandlingComments() {
        return groundHandlingComments;
    }

    /**
     * Sets the value of the groundHandlingComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroundHandlingComments(String value) {
        this.groundHandlingComments = value;
    }

    /**
     * Gets the value of the hotelService property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelService }
     *     
     */
    public JPHotelService getHotelService() {
        return hotelService;
    }

    /**
     * Sets the value of the hotelService property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelService }
     *     
     */
    public void setHotelService(JPHotelService value) {
        this.hotelService = value;
    }

    /**
     * Gets the value of the flightInfoOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightInfoService }
     *     
     */
    public JPFlightInfoService getFlightInfoOrigin() {
        return flightInfoOrigin;
    }

    /**
     * Sets the value of the flightInfoOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightInfoService }
     *     
     */
    public void setFlightInfoOrigin(JPFlightInfoService value) {
        this.flightInfoOrigin = value;
    }

    /**
     * Gets the value of the flightInfoDestination property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightInfoService }
     *     
     */
    public JPFlightInfoService getFlightInfoDestination() {
        return flightInfoDestination;
    }

    /**
     * Sets the value of the flightInfoDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightInfoService }
     *     
     */
    public void setFlightInfoDestination(JPFlightInfoService value) {
        this.flightInfoDestination = value;
    }

    /**
     * Gets the value of the iCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICode() {
        return iCode;
    }

    /**
     * Sets the value of the iCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICode(String value) {
        this.iCode = value;
    }

}
