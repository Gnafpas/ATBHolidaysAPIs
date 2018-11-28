
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FlightTicketingRS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightTicketingRS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Warnings" type="{http://www.juniper.es/webservice/2007/}JP_Warnings" minOccurs="0"/>
 *         &lt;element name="Errors" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ErrorType" minOccurs="0"/>
 *         &lt;element name="Reservations" type="{http://www.juniper.es/webservice/2007/}ArrayOfArrayOfJP_FlightTicketInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FlightTicketingRS", propOrder = {
    "warnings",
    "errors",
    "reservations"
})
public class JPFlightTicketingRS {

    @XmlElement(name = "Warnings")
    protected JPWarnings warnings;
    @XmlElement(name = "Errors")
    protected ArrayOfJPErrorType errors;
    @XmlElement(name = "Reservations")
    protected ArrayOfArrayOfJPFlightTicketInfo reservations;

    /**
     * Gets the value of the warnings property.
     * 
     * @return
     *     possible object is
     *     {@link JPWarnings }
     *     
     */
    public JPWarnings getWarnings() {
        return warnings;
    }

    /**
     * Sets the value of the warnings property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPWarnings }
     *     
     */
    public void setWarnings(JPWarnings value) {
        this.warnings = value;
    }

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPErrorType }
     *     
     */
    public ArrayOfJPErrorType getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPErrorType }
     *     
     */
    public void setErrors(ArrayOfJPErrorType value) {
        this.errors = value;
    }

    /**
     * Gets the value of the reservations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArrayOfJPFlightTicketInfo }
     *     
     */
    public ArrayOfArrayOfJPFlightTicketInfo getReservations() {
        return reservations;
    }

    /**
     * Sets the value of the reservations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArrayOfJPFlightTicketInfo }
     *     
     */
    public void setReservations(ArrayOfArrayOfJPFlightTicketInfo value) {
        this.reservations = value;
    }

}
