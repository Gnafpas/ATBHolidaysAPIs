
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_DateIntervalsGroupsCheckInDates complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_DateIntervalsGroupsCheckInDates">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JPSOAP_DateIntervalsGroupsStayDates">
 *       &lt;attribute name="ApplyToCheckInAndOutToo" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_DateIntervalsGroupsCheckInDates")
public class JPSOAPDateIntervalsGroupsCheckInDates
    extends JPSOAPDateIntervalsGroupsStayDates
{

    @XmlAttribute(name = "ApplyToCheckInAndOutToo", required = true)
    protected boolean applyToCheckInAndOutToo;

    /**
     * Gets the value of the applyToCheckInAndOutToo property.
     * 
     */
    public boolean isApplyToCheckInAndOutToo() {
        return applyToCheckInAndOutToo;
    }

    /**
     * Sets the value of the applyToCheckInAndOutToo property.
     * 
     */
    public void setApplyToCheckInAndOutToo(boolean value) {
        this.applyToCheckInAndOutToo = value;
    }

}
