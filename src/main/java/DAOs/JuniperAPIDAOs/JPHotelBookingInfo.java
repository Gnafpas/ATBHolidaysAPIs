
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_HotelBookingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelBookingInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Price" type="{http://www.juniper.es/webservice/2007/}JP_BookingPrice" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.juniper.es/webservice/2007/}JP_AvailStatus" minOccurs="0"/>
 *         &lt;element name="PackageContracts" type="{http://www.juniper.es/webservice/2007/}JP_PackageContracts" minOccurs="0"/>
 *         &lt;element name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Preferences" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelPreference" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Start" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="End" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelBookingInfo", propOrder = {
    "price",
    "status",
    "packageContracts",
    "hotelCode",
    "preferences"
})
public class JPHotelBookingInfo {

    @XmlElement(name = "Price")
    protected JPBookingPrice price;
    @XmlElement(name = "Status")
    @XmlSchemaType(name = "string")
    protected JPAvailStatus status;
    @XmlElement(name = "PackageContracts")
    @XmlSchemaType(name = "string")
    protected JPPackageContracts packageContracts;
    @XmlElement(name = "HotelCode")
    protected String hotelCode;
    @XmlElement(name = "Preferences")
    protected ArrayOfJPHotelPreference preferences;
    @XmlAttribute(name = "Start")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "End")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link JPBookingPrice }
     *     
     */
    public JPBookingPrice getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBookingPrice }
     *     
     */
    public void setPrice(JPBookingPrice value) {
        this.price = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JPAvailStatus }
     *     
     */
    public JPAvailStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPAvailStatus }
     *     
     */
    public void setStatus(JPAvailStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the packageContracts property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageContracts }
     *     
     */
    public JPPackageContracts getPackageContracts() {
        return packageContracts;
    }

    /**
     * Sets the value of the packageContracts property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageContracts }
     *     
     */
    public void setPackageContracts(JPPackageContracts value) {
        this.packageContracts = value;
    }

    /**
     * Gets the value of the hotelCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCode() {
        return hotelCode;
    }

    /**
     * Sets the value of the hotelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCode(String value) {
        this.hotelCode = value;
    }

    /**
     * Gets the value of the preferences property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelPreference }
     *     
     */
    public ArrayOfJPHotelPreference getPreferences() {
        return preferences;
    }

    /**
     * Sets the value of the preferences property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelPreference }
     *     
     */
    public void setPreferences(ArrayOfJPHotelPreference value) {
        this.preferences = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStart(XMLGregorianCalendar value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnd(XMLGregorianCalendar value) {
        this.end = value;
    }

}
