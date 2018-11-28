
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_Tour complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Tour">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Image" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelInfo" type="{http://www.juniper.es/webservice/2007/}JP_HotelInfo" minOccurs="0"/>
 *         &lt;element name="HotelOptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelOption" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Start" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="End" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
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
@XmlType(name = "JP_Tour", propOrder = {
    "name",
    "description",
    "image",
    "hotelInfo",
    "hotelOptions"
})
public class JPTour {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Image")
    protected String image;
    @XmlElement(name = "HotelInfo")
    protected JPHotelInfo hotelInfo;
    @XmlElement(name = "HotelOptions")
    protected ArrayOfJPHotelOption hotelOptions;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "Start", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "End", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;
    @XmlAttribute(name = "ICode")
    protected String iCode;
    @XmlAttribute(name = "SearchMore")
    protected Boolean searchMore;
    @XmlAttribute(name = "Order")
    protected Integer order;

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
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Gets the value of the hotelInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelInfo }
     *     
     */
    public JPHotelInfo getHotelInfo() {
        return hotelInfo;
    }

    /**
     * Sets the value of the hotelInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelInfo }
     *     
     */
    public void setHotelInfo(JPHotelInfo value) {
        this.hotelInfo = value;
    }

    /**
     * Gets the value of the hotelOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelOption }
     *     
     */
    public ArrayOfJPHotelOption getHotelOptions() {
        return hotelOptions;
    }

    /**
     * Sets the value of the hotelOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelOption }
     *     
     */
    public void setHotelOptions(ArrayOfJPHotelOption value) {
        this.hotelOptions = value;
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
