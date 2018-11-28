
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ItemHotelRoom complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ItemHotelRoom">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomCategory" type="{http://www.juniper.es/webservice/2007/}JP_RoomCategory" minOccurs="0"/>
 *         &lt;element name="RelPaxes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RelPax" minOccurs="0"/>
 *         &lt;element name="Contracts" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelDailyContracts" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Source" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="JRCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ItemHotelRoom", propOrder = {
    "name",
    "description",
    "roomCategory",
    "relPaxes",
    "contracts"
})
public class JPItemHotelRoom {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "RoomCategory")
    protected JPRoomCategory roomCategory;
    @XmlElement(name = "RelPaxes")
    protected ArrayOfJPRelPax relPaxes;
    @XmlElement(name = "Contracts")
    protected ArrayOfJPHotelDailyContracts contracts;
    @XmlAttribute(name = "Source")
    protected String source;
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
     * Gets the value of the contracts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelDailyContracts }
     *     
     */
    public ArrayOfJPHotelDailyContracts getContracts() {
        return contracts;
    }

    /**
     * Sets the value of the contracts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelDailyContracts }
     *     
     */
    public void setContracts(ArrayOfJPHotelDailyContracts value) {
        this.contracts = value;
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
