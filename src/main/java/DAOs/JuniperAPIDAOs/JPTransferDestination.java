
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_TransferDestination complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_TransferDestination">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MeetingPointInfo" type="{http://www.juniper.es/webservice/2007/}JP_MeetingPointInfo" minOccurs="0"/>
 *         &lt;element name="FlightInfo" type="{http://www.juniper.es/webservice/2007/}JP_FlightInfo" minOccurs="0"/>
 *         &lt;element name="ShipInfo" type="{http://www.juniper.es/webservice/2007/}JP_ShipInfo" minOccurs="0"/>
 *         &lt;element name="TrainInfo" type="{http://www.juniper.es/webservice/2007/}JP_TrainInfo" minOccurs="0"/>
 *         &lt;element name="TerminalDeparture" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TerminalArrival" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Type" use="required" type="{http://www.juniper.es/webservice/2007/}JP_ZoneType" />
 *       &lt;attribute name="Start" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="MeetingTime" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_TransferDestination", propOrder = {
    "meetingPointInfo",
    "flightInfo",
    "shipInfo",
    "trainInfo",
    "terminalDeparture",
    "terminalArrival"
})
public class JPTransferDestination {

    @XmlElement(name = "MeetingPointInfo")
    protected JPMeetingPointInfo meetingPointInfo;
    @XmlElement(name = "FlightInfo")
    protected JPFlightInfo flightInfo;
    @XmlElement(name = "ShipInfo")
    protected JPShipInfo shipInfo;
    @XmlElement(name = "TrainInfo")
    protected JPTrainInfo trainInfo;
    @XmlElement(name = "TerminalDeparture")
    protected String terminalDeparture;
    @XmlElement(name = "TerminalArrival")
    protected String terminalArrival;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "Type", required = true)
    protected JPZoneType type;
    @XmlAttribute(name = "Start")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "MeetingTime")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar meetingTime;
    @XmlAttribute(name = "HotelCode")
    protected String hotelCode;

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
     * Gets the value of the flightInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightInfo }
     *     
     */
    public JPFlightInfo getFlightInfo() {
        return flightInfo;
    }

    /**
     * Sets the value of the flightInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightInfo }
     *     
     */
    public void setFlightInfo(JPFlightInfo value) {
        this.flightInfo = value;
    }

    /**
     * Gets the value of the shipInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPShipInfo }
     *     
     */
    public JPShipInfo getShipInfo() {
        return shipInfo;
    }

    /**
     * Sets the value of the shipInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPShipInfo }
     *     
     */
    public void setShipInfo(JPShipInfo value) {
        this.shipInfo = value;
    }

    /**
     * Gets the value of the trainInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPTrainInfo }
     *     
     */
    public JPTrainInfo getTrainInfo() {
        return trainInfo;
    }

    /**
     * Sets the value of the trainInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTrainInfo }
     *     
     */
    public void setTrainInfo(JPTrainInfo value) {
        this.trainInfo = value;
    }

    /**
     * Gets the value of the terminalDeparture property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalDeparture() {
        return terminalDeparture;
    }

    /**
     * Sets the value of the terminalDeparture property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalDeparture(String value) {
        this.terminalDeparture = value;
    }

    /**
     * Gets the value of the terminalArrival property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalArrival() {
        return terminalArrival;
    }

    /**
     * Sets the value of the terminalArrival property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalArrival(String value) {
        this.terminalArrival = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JPZoneType }
     *     
     */
    public JPZoneType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPZoneType }
     *     
     */
    public void setType(JPZoneType value) {
        this.type = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStart(XMLGregorianCalendar value) {
        this.start = value;
    }

    /**
     * Gets the value of the meetingTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMeetingTime() {
        return meetingTime;
    }

    /**
     * Sets the value of the meetingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMeetingTime(XMLGregorianCalendar value) {
        this.meetingTime = value;
    }

    /**
     * Gets the value of the hotelCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCode() {
        return hotelCode;
    }

    /**
     * Sets the value of the hotelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCode(String value) {
        this.hotelCode = value;
    }

}
