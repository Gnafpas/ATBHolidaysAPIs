
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FlightLocator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightLocator">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReservationLocator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Commission" type="{http://www.juniper.es/webservice/2007/}JP_TicketCommission" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FlightLocator", propOrder = {
    "reservationLocator",
    "commission"
})
public class JPFlightLocator {

    @XmlElement(name = "ReservationLocator")
    protected String reservationLocator;
    @XmlElement(name = "Commission")
    protected JPTicketCommission commission;

    /**
     * Gets the value of the reservationLocator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservationLocator() {
        return reservationLocator;
    }

    /**
     * Sets the value of the reservationLocator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservationLocator(String value) {
        this.reservationLocator = value;
    }

    /**
     * Gets the value of the commission property.
     * 
     * @return
     *     possible object is
     *     {@link JPTicketCommission }
     *     
     */
    public JPTicketCommission getCommission() {
        return commission;
    }

    /**
     * Sets the value of the commission property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTicketCommission }
     *     
     */
    public void setCommission(JPTicketCommission value) {
        this.commission = value;
    }

}
