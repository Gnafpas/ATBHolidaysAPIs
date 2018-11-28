
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Airport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Airport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="airportId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="resortId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="airportName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iataCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeZone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transfers" type="{http://xml.sunhotels.net/15/}ArrayOfStaticTransfer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Airport", propOrder = {
    "airportId",
    "resortId",
    "airportName",
    "iataCode",
    "timeZone",
    "transfers"
})
public class Airport {

    protected int airportId;
    protected int resortId;
    protected String airportName;
    protected String iataCode;
    protected String timeZone;
    protected ArrayOfStaticTransfer transfers;

    /**
     * Gets the value of the airportId property.
     * 
     */
    public int getAirportId() {
        return airportId;
    }

    /**
     * Sets the value of the airportId property.
     * 
     */
    public void setAirportId(int value) {
        this.airportId = value;
    }

    /**
     * Gets the value of the resortId property.
     * 
     */
    public int getResortId() {
        return resortId;
    }

    /**
     * Sets the value of the resortId property.
     * 
     */
    public void setResortId(int value) {
        this.resortId = value;
    }

    /**
     * Gets the value of the airportName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirportName() {
        return airportName;
    }

    /**
     * Sets the value of the airportName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirportName(String value) {
        this.airportName = value;
    }

    /**
     * Gets the value of the iataCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIataCode() {
        return iataCode;
    }

    /**
     * Sets the value of the iataCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIataCode(String value) {
        this.iataCode = value;
    }

    /**
     * Gets the value of the timeZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Sets the value of the timeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZone(String value) {
        this.timeZone = value;
    }

    /**
     * Gets the value of the transfers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfStaticTransfer }
     *     
     */
    public ArrayOfStaticTransfer getTransfers() {
        return transfers;
    }

    /**
     * Sets the value of the transfers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfStaticTransfer }
     *     
     */
    public void setTransfers(ArrayOfStaticTransfer value) {
        this.transfers = value;
    }

}
