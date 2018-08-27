
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelRoom complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelRoom">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomCategory" type="{http://www.juniper.es/webservice/2007/}JP_RoomCategory" minOccurs="0"/>
 *         &lt;element name="RoomOccupancy" type="{http://www.juniper.es/webservice/2007/}JP_RoomOccupancy" minOccurs="0"/>
 *         &lt;element name="Images" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ImageLong" minOccurs="0"/>
 *         &lt;element name="Size" type="{http://www.juniper.es/webservice/2007/}JP_HotelRoomSize" minOccurs="0"/>
 *         &lt;element name="Contracts" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelRoomContract" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Units" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Source" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AvailRooms" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="JRCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelRoom", propOrder = {
    "name",
    "description",
    "roomCategory",
    "roomOccupancy",
    "images",
    "size",
    "contracts"
})
public class JPHotelRoom {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "RoomCategory")
    protected JPRoomCategory roomCategory;
    @XmlElement(name = "RoomOccupancy")
    protected JPRoomOccupancy roomOccupancy;
    @XmlElement(name = "Images")
    protected ArrayOfJPImageLong images;
    @XmlElement(name = "Size")
    protected JPHotelRoomSize size;
    @XmlElement(name = "Contracts")
    protected ArrayOfJPHotelRoomContract contracts;
    @XmlAttribute(name = "Units")
    protected Integer units;
    @XmlAttribute(name = "Source")
    protected String source;
    @XmlAttribute(name = "AvailRooms")
    protected Integer availRooms;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "JRCode")
    protected String jrCode;

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
     * Gets the value of the roomCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JPRoomCategory }
     *     
     */
    public JPRoomCategory getRoomCategory() {
        return roomCategory;
    }

    /**
     * Sets the value of the roomCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRoomCategory }
     *     
     */
    public void setRoomCategory(JPRoomCategory value) {
        this.roomCategory = value;
    }

    /**
     * Gets the value of the roomOccupancy property.
     * 
     * @return
     *     possible object is
     *     {@link JPRoomOccupancy }
     *     
     */
    public JPRoomOccupancy getRoomOccupancy() {
        return roomOccupancy;
    }

    /**
     * Sets the value of the roomOccupancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRoomOccupancy }
     *     
     */
    public void setRoomOccupancy(JPRoomOccupancy value) {
        this.roomOccupancy = value;
    }

    /**
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPImageLong }
     *     
     */
    public ArrayOfJPImageLong getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPImageLong }
     *     
     */
    public void setImages(ArrayOfJPImageLong value) {
        this.images = value;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelRoomSize }
     *     
     */
    public JPHotelRoomSize getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelRoomSize }
     *     
     */
    public void setSize(JPHotelRoomSize value) {
        this.size = value;
    }

    /**
     * Gets the value of the contracts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelRoomContract }
     *     
     */
    public ArrayOfJPHotelRoomContract getContracts() {
        return contracts;
    }

    /**
     * Sets the value of the contracts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelRoomContract }
     *     
     */
    public void setContracts(ArrayOfJPHotelRoomContract value) {
        this.contracts = value;
    }

    /**
     * Gets the value of the units property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUnits(Integer value) {
        this.units = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the availRooms property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAvailRooms() {
        return availRooms;
    }

    /**
     * Sets the value of the availRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAvailRooms(Integer value) {
        this.availRooms = value;
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
     * Gets the value of the jrCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJRCode() {
        return jrCode;
    }

    /**
     * Sets the value of the jrCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJRCode(String value) {
        this.jrCode = value;
    }

}
