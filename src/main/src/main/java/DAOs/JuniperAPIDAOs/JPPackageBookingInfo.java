
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_PackageBookingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageBookingInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Price" type="{http://www.juniper.es/webservice/2007/}JP_BookingPrice" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.juniper.es/webservice/2007/}JP_AvailStatus" minOccurs="0"/>
 *         &lt;element name="PackageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Start" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="End" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageBookingInfo", propOrder = {
    "price",
    "status",
    "packageCode"
})
public class JPPackageBookingInfo {

    @XmlElement(name = "Price")
    protected JPBookingPrice price;
    @XmlElement(name = "Status")
    @XmlSchemaType(name = "string")
    protected JPAvailStatus status;
    @XmlElement(name = "PackageCode")
    protected String packageCode;
    @XmlAttribute(name = "Start", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "End", required = true)
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
     * Gets the value of the packageCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageCode() {
        return packageCode;
    }

    /**
     * Sets the value of the packageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageCode(String value) {
        this.packageCode = value;
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
