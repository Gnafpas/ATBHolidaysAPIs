
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FlightTicketInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightTicketInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Paxes" type="{http://www.juniper.es/webservice/2007/}JP_Paxes" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Locator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FlightTicketInfo", propOrder = {
    "status",
    "paxes"
})
public class JPFlightTicketInfo {

    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "Paxes")
    protected JPPaxes paxes;
    @XmlAttribute(name = "Locator")
    protected String locator;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the paxes property.
     * 
     * @return
     *     possible object is
     *     {@link JPPaxes }
     *     
     */
    public JPPaxes getPaxes() {
        return paxes;
    }

    /**
     * Sets the value of the paxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPaxes }
     *     
     */
    public void setPaxes(JPPaxes value) {
        this.paxes = value;
    }

    /**
     * Gets the value of the locator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocator() {
        return locator;
    }

    /**
     * Sets the value of the locator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocator(String value) {
        this.locator = value;
    }

}
