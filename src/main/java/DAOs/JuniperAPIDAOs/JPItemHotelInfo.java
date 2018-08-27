
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ItemHotelInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ItemHotelInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelCategory" type="{http://www.juniper.es/webservice/2007/}JP_HotelCategory" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="JPCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="JPDCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DestinationZone" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ItemHotelInfo", propOrder = {
    "name",
    "description",
    "hotelCategory",
    "address"
})
public class JPItemHotelInfo {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "HotelCategory")
    protected JPHotelCategory hotelCategory;
    @XmlElement(name = "Address")
    protected String address;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "JPCode")
    protected String jpCode;
    @XmlAttribute(name = "JPDCode")
    protected String jpdCode;
    @XmlAttribute(name = "DestinationZone")
    protected Integer destinationZone;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the hotelCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelCategory }
     *     
     */
    public JPHotelCategory getHotelCategory() {
        return hotelCategory;
    }

    /**
     * Sets the value of the hotelCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelCategory }
     *     
     */
    public void setHotelCategory(JPHotelCategory value) {
        this.hotelCategory = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
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
     * Gets the value of the jpCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJPCode() {
        return jpCode;
    }

    /**
     * Sets the value of the jpCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJPCode(String value) {
        this.jpCode = value;
    }

    /**
     * Gets the value of the jpdCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJPDCode() {
        return jpdCode;
    }

    /**
     * Sets the value of the jpdCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJPDCode(String value) {
        this.jpdCode = value;
    }

    /**
     * Gets the value of the destinationZone property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDestinationZone() {
        return destinationZone;
    }

    /**
     * Sets the value of the destinationZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDestinationZone(Integer value) {
        this.destinationZone = value;
    }

}
