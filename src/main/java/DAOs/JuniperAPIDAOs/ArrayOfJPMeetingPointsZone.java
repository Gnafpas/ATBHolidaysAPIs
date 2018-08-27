
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_MeetingPointsZone complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_MeetingPointsZone">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MeetingPointZone" type="{http://www.juniper.es/webservice/2007/}JP_MeetingPointsZone" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_MeetingPointsZone", propOrder = {
    "meetingPointZone"
})
public class ArrayOfJPMeetingPointsZone {

    @XmlElement(name = "MeetingPointZone")
    protected List<JPMeetingPointsZone> meetingPointZone;

    /**
     * Gets the value of the meetingPointZone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meetingPointZone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeetingPointZone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPMeetingPointsZone }
     * 
     * 
     */
    public List<JPMeetingPointsZone> getMeetingPointZone() {
        if (meetingPointZone == null) {
            meetingPointZone = new ArrayList<JPMeetingPointsZone>();
        }
        return this.meetingPointZone;
    }

}
