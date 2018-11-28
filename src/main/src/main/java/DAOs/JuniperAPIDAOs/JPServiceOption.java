
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_ServiceOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ServiceOption">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Images" type="{http://www.juniper.es/webservice/2007/}ArrayOfString1" minOccurs="0"/>
 *         &lt;element name="DestinationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dates" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ServiceDate" minOccurs="0"/>
 *         &lt;element name="RestrictedMeetingPoints" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_MeetingPoint" minOccurs="0"/>
 *         &lt;element name="ServiceBookingInfo" type="{http://www.juniper.es/webservice/2007/}JP_ServiceBookingInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Start" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="End" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="Object" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Duration" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ServiceOption", propOrder = {
    "name",
    "description",
    "images",
    "destinationName",
    "dates",
    "restrictedMeetingPoints",
    "serviceBookingInfo"
})
public class JPServiceOption {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Images")
    protected ArrayOfString1 images;
    @XmlElement(name = "DestinationName")
    protected String destinationName;
    @XmlElement(name = "Dates")
    protected ArrayOfJPServiceDate dates;
    @XmlElement(name = "RestrictedMeetingPoints")
    protected ArrayOfJPMeetingPoint restrictedMeetingPoints;
    @XmlElement(name = "ServiceBookingInfo")
    protected JPServiceBookingInfo serviceBookingInfo;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "Start")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "End")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar end;
    @XmlAttribute(name = "Object")
    protected Integer destination;
    @XmlAttribute(name = "Duration")
    protected Duration duration;

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
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString1 }
     *     
     */
    public ArrayOfString1 getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString1 }
     *     
     */
    public void setImages(ArrayOfString1 value) {
        this.images = value;
    }

    /**
     * Gets the value of the destinationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationName() {
        return destinationName;
    }

    /**
     * Sets the value of the destinationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationName(String value) {
        this.destinationName = value;
    }

    /**
     * Gets the value of the dates property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPServiceDate }
     *     
     */
    public ArrayOfJPServiceDate getDates() {
        return dates;
    }

    /**
     * Sets the value of the dates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPServiceDate }
     *     
     */
    public void setDates(ArrayOfJPServiceDate value) {
        this.dates = value;
    }

    /**
     * Gets the value of the restrictedMeetingPoints property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPMeetingPoint }
     *     
     */
    public ArrayOfJPMeetingPoint getRestrictedMeetingPoints() {
        return restrictedMeetingPoints;
    }

    /**
     * Sets the value of the restrictedMeetingPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPMeetingPoint }
     *     
     */
    public void setRestrictedMeetingPoints(ArrayOfJPMeetingPoint value) {
        this.restrictedMeetingPoints = value;
    }

    /**
     * Gets the value of the serviceBookingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPServiceBookingInfo }
     *     
     */
    public JPServiceBookingInfo getServiceBookingInfo() {
        return serviceBookingInfo;
    }

    /**
     * Sets the value of the serviceBookingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServiceBookingInfo }
     *     
     */
    public void setServiceBookingInfo(JPServiceBookingInfo value) {
        this.serviceBookingInfo = value;
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
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnd(XMLGregorianCalendar value) {
        this.end = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDestination(Integer value) {
        this.destination = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDuration(Duration value) {
        this.duration = value;
    }

}
