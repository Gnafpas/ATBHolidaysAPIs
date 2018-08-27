
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelInventoryRoomType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelInventoryRoomType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Occupancies" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_Occupancy" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Category" type="{http://www.juniper.es/webservice/2007/}JPSOAP_IdTypeName" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MinAge" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MaxPax" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="AdultAdditionalFrom" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="AlternativeAllotmentRoomType" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ExternalCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PricePerRoom" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="NonRefundable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="childAsAdult" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelInventoryRoomType", propOrder = {
    "occupancies",
    "name",
    "category"
})
public class JPSOAPHotelInventoryRoomType {

    @XmlElement(name = "Occupancies")
    protected ArrayOfJPSOAPOccupancy occupancies;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Category")
    protected JPSOAPIdTypeName category;
    @XmlAttribute(name = "Code", required = true)
    protected int code;
    @XmlAttribute(name = "MinAge")
    protected Integer minAge;
    @XmlAttribute(name = "MaxPax")
    protected Integer maxPax;
    @XmlAttribute(name = "AdultAdditionalFrom")
    protected Integer adultAdditionalFrom;
    @XmlAttribute(name = "AlternativeAllotmentRoomType")
    protected Integer alternativeAllotmentRoomType;
    @XmlAttribute(name = "ExternalCode")
    protected String externalCode;
    @XmlAttribute(name = "PricePerRoom", required = true)
    protected boolean pricePerRoom;
    @XmlAttribute(name = "NonRefundable", required = true)
    protected boolean nonRefundable;
    @XmlAttribute(name = "childAsAdult", required = true)
    protected boolean childAsAdult;

    /**
     * Gets the value of the occupancies property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPOccupancy }
     *     
     */
    public ArrayOfJPSOAPOccupancy getOccupancies() {
        return occupancies;
    }

    /**
     * Sets the value of the occupancies property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPOccupancy }
     *     
     */
    public void setOccupancies(ArrayOfJPSOAPOccupancy value) {
        this.occupancies = value;
    }

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
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPIdTypeName }
     *     
     */
    public JPSOAPIdTypeName getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPIdTypeName }
     *     
     */
    public void setCategory(JPSOAPIdTypeName value) {
        this.category = value;
    }

    /**
     * Gets the value of the code property.
     * 
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     */
    public void setCode(int value) {
        this.code = value;
    }

    /**
     * Gets the value of the minAge property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinAge() {
        return minAge;
    }

    /**
     * Sets the value of the minAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinAge(Integer value) {
        this.minAge = value;
    }

    /**
     * Gets the value of the maxPax property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxPax() {
        return maxPax;
    }

    /**
     * Sets the value of the maxPax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxPax(Integer value) {
        this.maxPax = value;
    }

    /**
     * Gets the value of the adultAdditionalFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAdultAdditionalFrom() {
        return adultAdditionalFrom;
    }

    /**
     * Sets the value of the adultAdditionalFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAdultAdditionalFrom(Integer value) {
        this.adultAdditionalFrom = value;
    }

    /**
     * Gets the value of the alternativeAllotmentRoomType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAlternativeAllotmentRoomType() {
        return alternativeAllotmentRoomType;
    }

    /**
     * Sets the value of the alternativeAllotmentRoomType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAlternativeAllotmentRoomType(Integer value) {
        this.alternativeAllotmentRoomType = value;
    }

    /**
     * Gets the value of the externalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalCode() {
        return externalCode;
    }

    /**
     * Sets the value of the externalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalCode(String value) {
        this.externalCode = value;
    }

    /**
     * Gets the value of the pricePerRoom property.
     * 
     */
    public boolean isPricePerRoom() {
        return pricePerRoom;
    }

    /**
     * Sets the value of the pricePerRoom property.
     * 
     */
    public void setPricePerRoom(boolean value) {
        this.pricePerRoom = value;
    }

    /**
     * Gets the value of the nonRefundable property.
     * 
     */
    public boolean isNonRefundable() {
        return nonRefundable;
    }

    /**
     * Sets the value of the nonRefundable property.
     * 
     */
    public void setNonRefundable(boolean value) {
        this.nonRefundable = value;
    }

    /**
     * Gets the value of the childAsAdult property.
     * 
     */
    public boolean isChildAsAdult() {
        return childAsAdult;
    }

    /**
     * Sets the value of the childAsAdult property.
     * 
     */
    public void setChildAsAdult(boolean value) {
        this.childAsAdult = value;
    }

}
