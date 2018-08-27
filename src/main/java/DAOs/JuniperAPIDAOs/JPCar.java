
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_Car complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Car">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentacarInfo" type="{http://www.juniper.es/webservice/2007/}JP_RentacarInfo" minOccurs="0"/>
 *         &lt;element name="PickupOffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DropOffOffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Start" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="End" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="ICode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SearchMore" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Order" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Car", propOrder = {
    "rentacarInfo",
    "pickupOffice",
    "dropOffOffice"
})
public class JPCar {

    @XmlElement(name = "RentacarInfo")
    protected JPRentacarInfo rentacarInfo;
    @XmlElement(name = "PickupOffice")
    protected String pickupOffice;
    @XmlElement(name = "DropOffOffice")
    protected String dropOffOffice;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "Start", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "End", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar end;
    @XmlAttribute(name = "ICode")
    protected String iCode;
    @XmlAttribute(name = "SearchMore")
    protected Boolean searchMore;
    @XmlAttribute(name = "Order")
    protected Integer order;

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
     * Gets the value of the pickupOffice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPickupOffice() {
        return pickupOffice;
    }

    /**
     * Sets the value of the pickupOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPickupOffice(String value) {
        this.pickupOffice = value;
    }

    /**
     * Gets the value of the dropOffOffice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDropOffOffice() {
        return dropOffOffice;
    }

    /**
     * Sets the value of the dropOffOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDropOffOffice(String value) {
        this.dropOffOffice = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
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

    /**
     * Gets the value of the iCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICode() {
        return iCode;
    }

    /**
     * Sets the value of the iCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICode(String value) {
        this.iCode = value;
    }

    /**
     * Gets the value of the searchMore property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSearchMore() {
        return searchMore;
    }

    /**
     * Sets the value of the searchMore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSearchMore(Boolean value) {
        this.searchMore = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrder(Integer value) {
        this.order = value;
    }

}
