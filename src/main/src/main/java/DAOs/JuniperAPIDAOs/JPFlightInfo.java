
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_FlightInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Airport" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FlightTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="FlightNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FlightInfo")
public class JPFlightInfo {

    @XmlAttribute(name = "Airport")
    protected String airport;
    @XmlAttribute(name = "FlightTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar flightTime;
    @XmlAttribute(name = "FlightNumber")
    protected String flightNumber;

    /**
     * Gets the value of the airport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirport() {
        return airport;
    }

    /**
     * Sets the value of the airport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirport(String value) {
        this.airport = value;
    }

    /**
     * Gets the value of the flightTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFlightTime() {
        return flightTime;
    }

    /**
     * Sets the value of the flightTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFlightTime(XMLGregorianCalendar value) {
        this.flightTime = value;
    }

    /**
     * Gets the value of the flightNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets the value of the flightNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightNumber(String value) {
        this.flightNumber = value;
    }

}
