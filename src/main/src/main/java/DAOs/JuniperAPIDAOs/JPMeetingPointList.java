
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_MeetingPointList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_MeetingPointList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MeetingPointZones" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_MeetingPointsZone" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_MeetingPointList", propOrder = {
    "meetingPointZones"
})
public class JPMeetingPointList {

    @XmlElement(name = "MeetingPointZones")
    protected ArrayOfJPMeetingPointsZone meetingPointZones;

    /**
     * Gets the value of the meetingPointZones property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPMeetingPointsZone }
     *     
     */
    public ArrayOfJPMeetingPointsZone getMeetingPointZones() {
        return meetingPointZones;
    }

    /**
     * Sets the value of the meetingPointZones property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPMeetingPointsZone }
     *     
     */
    public void setMeetingPointZones(ArrayOfJPMeetingPointsZone value) {
        this.meetingPointZones = value;
    }

}
