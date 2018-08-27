
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_DateIntervalsGroupsStayDates complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_DateIntervalsGroupsStayDates">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JPSOAP_DateIntervalsGroups">
 *       &lt;attribute name="WeekDays" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_DateIntervalsGroupsStayDates")
@XmlSeeAlso({
    JPSOAPDateIntervalsGroupsCheckInDates.class
})
public class JPSOAPDateIntervalsGroupsStayDates
    extends JPSOAPDateIntervalsGroups
{

    @XmlAttribute(name = "WeekDays")
    protected String weekDays;

    /**
     * Gets the value of the weekDays property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeekDays() {
        return weekDays;
    }

    /**
     * Sets the value of the weekDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeekDays(String value) {
        this.weekDays = value;
    }

}
