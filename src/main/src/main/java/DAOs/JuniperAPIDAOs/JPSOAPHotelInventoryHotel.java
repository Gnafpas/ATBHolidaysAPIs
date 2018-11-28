
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelInventoryHotel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelInventoryHotel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Category" type="{http://www.juniper.es/webservice/2007/}JPSOAP_IdTypeName" minOccurs="0"/>
 *         &lt;element name="Descriptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_HotelInventoryDescription" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.juniper.es/webservice/2007/}JPSOAP_HotelInventoryAddress" minOccurs="0"/>
 *         &lt;element name="ContactInfo" type="{http://www.juniper.es/webservice/2007/}JPSOAP_HotelInventoryContactInfo" minOccurs="0"/>
 *         &lt;element name="RoomTypes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_HotelInventoryRoomType" minOccurs="0"/>
 *         &lt;element name="Boards" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_IdTypeIntName" minOccurs="0"/>
 *         &lt;element name="DirectPaymentCardTypes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_IdName" minOccurs="0"/>
 *         &lt;element name="Ages" type="{http://www.juniper.es/webservice/2007/}JPSOAP_Ages" minOccurs="0"/>
 *         &lt;element name="Images" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_Image" minOccurs="0"/>
 *         &lt;element name="SpecialNotes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_HotelInventorySpecialNotesNote" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HotelCodeEncrypt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="JPCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="GIATACode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MinAge" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TimeZone" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelInventoryHotel", propOrder = {
    "name",
    "category",
    "descriptions",
    "address",
    "contactInfo",
    "roomTypes",
    "boards",
    "directPaymentCardTypes",
    "ages",
    "images",
    "specialNotes"
})
public class JPSOAPHotelInventoryHotel {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Category")
    protected JPSOAPIdTypeName category;
    @XmlElement(name = "Descriptions")
    protected ArrayOfJPSOAPHotelInventoryDescription descriptions;
    @XmlElement(name = "Address")
    protected JPSOAPHotelInventoryAddress address;
    @XmlElement(name = "ContactInfo")
    protected JPSOAPHotelInventoryContactInfo contactInfo;
    @XmlElement(name = "RoomTypes")
    protected ArrayOfJPSOAPHotelInventoryRoomType roomTypes;
    @XmlElement(name = "Boards")
    protected ArrayOfJPSOAPIdTypeIntName boards;
    @XmlElement(name = "DirectPaymentCardTypes")
    protected ArrayOfJPSOAPIdName directPaymentCardTypes;
    @XmlElement(name = "Ages")
    protected JPSOAPAges ages;
    @XmlElement(name = "Images")
    protected ArrayOfJPSOAPImage images;
    @XmlElement(name = "SpecialNotes")
    protected ArrayOfJPSOAPHotelInventorySpecialNotesNote specialNotes;
    @XmlAttribute(name = "HotelCode")
    protected String hotelCode;
    @XmlAttribute(name = "HotelCodeEncrypt")
    protected String hotelCodeEncrypt;
    @XmlAttribute(name = "JPCode")
    protected String jpCode;
    @XmlAttribute(name = "GIATACode")
    protected String giataCode;
    @XmlAttribute(name = "MinAge")
    protected Integer minAge;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "TimeZone")
    protected String timeZone;

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
     * Gets the value of the descriptions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPHotelInventoryDescription }
     *     
     */
    public ArrayOfJPSOAPHotelInventoryDescription getDescriptions() {
        return descriptions;
    }

    /**
     * Sets the value of the descriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPHotelInventoryDescription }
     *     
     */
    public void setDescriptions(ArrayOfJPSOAPHotelInventoryDescription value) {
        this.descriptions = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPHotelInventoryAddress }
     *     
     */
    public JPSOAPHotelInventoryAddress getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPHotelInventoryAddress }
     *     
     */
    public void setAddress(JPSOAPHotelInventoryAddress value) {
        this.address = value;
    }

    /**
     * Gets the value of the contactInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPHotelInventoryContactInfo }
     *     
     */
    public JPSOAPHotelInventoryContactInfo getContactInfo() {
        return contactInfo;
    }

    /**
     * Sets the value of the contactInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPHotelInventoryContactInfo }
     *     
     */
    public void setContactInfo(JPSOAPHotelInventoryContactInfo value) {
        this.contactInfo = value;
    }

    /**
     * Gets the value of the roomTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPHotelInventoryRoomType }
     *     
     */
    public ArrayOfJPSOAPHotelInventoryRoomType getRoomTypes() {
        return roomTypes;
    }

    /**
     * Sets the value of the roomTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPHotelInventoryRoomType }
     *     
     */
    public void setRoomTypes(ArrayOfJPSOAPHotelInventoryRoomType value) {
        this.roomTypes = value;
    }

    /**
     * Gets the value of the boards property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPIdTypeIntName }
     *     
     */
    public ArrayOfJPSOAPIdTypeIntName getBoards() {
        return boards;
    }

    /**
     * Sets the value of the boards property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPIdTypeIntName }
     *     
     */
    public void setBoards(ArrayOfJPSOAPIdTypeIntName value) {
        this.boards = value;
    }

    /**
     * Gets the value of the directPaymentCardTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPIdName }
     *     
     */
    public ArrayOfJPSOAPIdName getDirectPaymentCardTypes() {
        return directPaymentCardTypes;
    }

    /**
     * Sets the value of the directPaymentCardTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPIdName }
     *     
     */
    public void setDirectPaymentCardTypes(ArrayOfJPSOAPIdName value) {
        this.directPaymentCardTypes = value;
    }

    /**
     * Gets the value of the ages property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPAges }
     *     
     */
    public JPSOAPAges getAges() {
        return ages;
    }

    /**
     * Sets the value of the ages property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPAges }
     *     
     */
    public void setAges(JPSOAPAges value) {
        this.ages = value;
    }

    /**
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPImage }
     *     
     */
    public ArrayOfJPSOAPImage getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPImage }
     *     
     */
    public void setImages(ArrayOfJPSOAPImage value) {
        this.images = value;
    }

    /**
     * Gets the value of the specialNotes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPHotelInventorySpecialNotesNote }
     *     
     */
    public ArrayOfJPSOAPHotelInventorySpecialNotesNote getSpecialNotes() {
        return specialNotes;
    }

    /**
     * Sets the value of the specialNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPHotelInventorySpecialNotesNote }
     *     
     */
    public void setSpecialNotes(ArrayOfJPSOAPHotelInventorySpecialNotesNote value) {
        this.specialNotes = value;
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
     * Gets the value of the hotelCodeEncrypt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCodeEncrypt() {
        return hotelCodeEncrypt;
    }

    /**
     * Sets the value of the hotelCodeEncrypt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCodeEncrypt(String value) {
        this.hotelCodeEncrypt = value;
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
     * Gets the value of the giataCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGIATACode() {
        return giataCode;
    }

    /**
     * Sets the value of the giataCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGIATACode(String value) {
        this.giataCode = value;
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
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the timeZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Sets the value of the timeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZone(String value) {
        this.timeZone = value;
    }

}
