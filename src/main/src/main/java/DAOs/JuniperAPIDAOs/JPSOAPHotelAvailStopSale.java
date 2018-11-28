
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JPSOAP_HotelAvailStopSale complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelAvailStopSale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="From" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="To" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="OnRequest" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ApplyToCheckInDate" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelAvailStopSale")
public class JPSOAPHotelAvailStopSale {

    @XmlAttribute(name = "RoomTypeCode")
    protected Integer roomTypeCode;
    @XmlAttribute(name = "From", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar from;
    @XmlAttribute(name = "To", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar to;
    @XmlAttribute(name = "OnRequest", required = true)
    protected boolean onRequest;
    @XmlAttribute(name = "ApplyToCheckInDate")
    protected Boolean applyToCheckInDate;

    /**
     * Gets the value of the roomTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRoomTypeCode() {
        return roomTypeCode;
    }

    /**
     * Sets the value of the roomTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRoomTypeCode(Integer value) {
        this.roomTypeCode = value;
    }

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrom(XMLGregorianCalendar value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTo(XMLGregorianCalendar value) {
        this.to = value;
    }

    /**
     * Gets the value of the onRequest property.
     * 
     */
    public boolean isOnRequest() {
        return onRequest;
    }

    /**
     * Sets the value of the onRequest property.
     * 
     */
    public void setOnRequest(boolean value) {
        this.onRequest = value;
    }

    /**
     * Gets the value of the applyToCheckInDate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isApplyToCheckInDate() {
        return applyToCheckInDate;
    }

    /**
     * Sets the value of the applyToCheckInDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setApplyToCheckInDate(Boolean value) {
        this.applyToCheckInDate = value;
    }

}
