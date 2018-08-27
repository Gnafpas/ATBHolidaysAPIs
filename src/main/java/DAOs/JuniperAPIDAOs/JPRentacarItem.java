
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_RentacarItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BaseItem">
 *       &lt;sequence>
 *         &lt;element name="RentacarInfo" type="{http://www.juniper.es/webservice/2007/}JP_RentacarInfo" minOccurs="0"/>
 *         &lt;element name="AdditionalElements" type="{http://www.juniper.es/webservice/2007/}JP_RentacarAdditionalElements" minOccurs="0"/>
 *         &lt;element name="RentacarLocationDetails" type="{http://www.juniper.es/webservice/2007/}JP_RentacarBookLocationDetails" minOccurs="0"/>
 *         &lt;element name="RelPaxes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RelPax" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Start" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="Hour" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="End" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="HourEnd" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarItem", propOrder = {
    "rentacarInfo",
    "additionalElements",
    "rentacarLocationDetails",
    "relPaxes"
})
public class JPRentacarItem
    extends JPBaseItem
{

    @XmlElement(name = "RentacarInfo")
    protected JPRentacarInfo rentacarInfo;
    @XmlElement(name = "AdditionalElements")
    protected JPRentacarAdditionalElements additionalElements;
    @XmlElement(name = "RentacarLocationDetails")
    protected JPRentacarBookLocationDetails rentacarLocationDetails;
    @XmlElement(name = "RelPaxes")
    protected ArrayOfJPRelPax relPaxes;
    @XmlAttribute(name = "Start")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "Hour")
    protected String hour;
    @XmlAttribute(name = "End")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;
    @XmlAttribute(name = "HourEnd")
    protected String hourEnd;

    /**
     * Gets the value of the rentacarInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarInfo }
     *     
     */
    public JPRentacarInfo getRentacarInfo() {
        return rentacarInfo;
    }

    /**
     * Sets the value of the rentacarInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarInfo }
     *     
     */
    public void setRentacarInfo(JPRentacarInfo value) {
        this.rentacarInfo = value;
    }

    /**
     * Gets the value of the additionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarAdditionalElements }
     *     
     */
    public JPRentacarAdditionalElements getAdditionalElements() {
        return additionalElements;
    }

    /**
     * Sets the value of the additionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarAdditionalElements }
     *     
     */
    public void setAdditionalElements(JPRentacarAdditionalElements value) {
        this.additionalElements = value;
    }

    /**
     * Gets the value of the rentacarLocationDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarBookLocationDetails }
     *     
     */
    public JPRentacarBookLocationDetails getRentacarLocationDetails() {
        return rentacarLocationDetails;
    }

    /**
     * Sets the value of the rentacarLocationDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarBookLocationDetails }
     *     
     */
    public void setRentacarLocationDetails(JPRentacarBookLocationDetails value) {
        this.rentacarLocationDetails = value;
    }

    /**
     * Gets the value of the relPaxes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRelPax }
     *     
     */
    public ArrayOfJPRelPax getRelPaxes() {
        return relPaxes;
    }

    /**
     * Sets the value of the relPaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRelPax }
     *     
     */
    public void setRelPaxes(ArrayOfJPRelPax value) {
        this.relPaxes = value;
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
     * Gets the value of the hour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHour() {
        return hour;
    }

    /**
     * Sets the value of the hour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHour(String value) {
        this.hour = value;
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

    /**
     * Gets the value of the hourEnd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHourEnd() {
        return hourEnd;
    }

    /**
     * Sets the value of the hourEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHourEnd(String value) {
        this.hourEnd = value;
    }

}
