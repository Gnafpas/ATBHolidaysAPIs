
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelContent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelContent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zone" type="{http://www.juniper.es/webservice/2007/}JP_Zone" minOccurs="0"/>
 *         &lt;element name="HotelCategory" type="{http://www.juniper.es/webservice/2007/}JP_HotelCategory" minOccurs="0"/>
 *         &lt;element name="HotelType" type="{http://www.juniper.es/webservice/2007/}JP_HotelType" minOccurs="0"/>
 *         &lt;element name="Label" type="{http://www.juniper.es/webservice/2007/}JP_LabelType" minOccurs="0"/>
 *         &lt;element name="SegmentHotel" type="{http://www.juniper.es/webservice/2007/}JP_SegmentHotel" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.juniper.es/webservice/2007/}JP_AddressType" minOccurs="0"/>
 *         &lt;element name="ContactInfo" type="{http://www.juniper.es/webservice/2007/}JP_ContactInfo" minOccurs="0"/>
 *         &lt;element name="Images" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ImageLong" minOccurs="0"/>
 *         &lt;element name="Descriptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Description" minOccurs="0"/>
 *         &lt;element name="Features" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Feature" minOccurs="0"/>
 *         &lt;element name="PointsOfInterest" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PointOfInterest" minOccurs="0"/>
 *         &lt;element name="ContentProviders" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ContentProvider" minOccurs="0"/>
 *         &lt;element name="TimeInformation" type="{http://www.juniper.es/webservice/2007/}JP_HotelTimeInformation" minOccurs="0"/>
 *         &lt;element name="HotelRooms" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelRoom" minOccurs="0"/>
 *         &lt;element name="JPRooms" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RoomInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="JPCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelContent", propOrder = {
    "hotelName",
    "zone",
    "hotelCategory",
    "hotelType",
    "label",
    "segmentHotel",
    "address",
    "contactInfo",
    "images",
    "descriptions",
    "features",
    "pointsOfInterest",
    "contentProviders",
    "timeInformation",
    "hotelRooms",
    "jpRooms"
})
public class JPHotelContent {

    @XmlElement(name = "HotelName")
    protected String hotelName;
    @XmlElement(name = "Zone")
    protected JPZone zone;
    @XmlElement(name = "HotelCategory")
    protected JPHotelCategory hotelCategory;
    @XmlElement(name = "HotelType")
    protected JPHotelType hotelType;
    @XmlElement(name = "Label")
    protected JPLabelType label;
    @XmlElement(name = "SegmentHotel")
    protected JPSegmentHotel segmentHotel;
    @XmlElement(name = "Address")
    protected JPAddressType address;
    @XmlElement(name = "ContactInfo")
    protected JPContactInfo contactInfo;
    @XmlElement(name = "Images")
    protected ArrayOfJPImageLong images;
    @XmlElement(name = "Descriptions")
    protected ArrayOfJPDescription descriptions;
    @XmlElement(name = "Features")
    protected ArrayOfJPFeature features;
    @XmlElement(name = "PointsOfInterest")
    protected ArrayOfJPPointOfInterest pointsOfInterest;
    @XmlElement(name = "ContentProviders")
    protected ArrayOfJPContentProvider contentProviders;
    @XmlElement(name = "TimeInformation")
    protected JPHotelTimeInformation timeInformation;
    @XmlElement(name = "HotelRooms")
    protected ArrayOfJPHotelRoom hotelRooms;
    @XmlElement(name = "JPRooms")
    protected ArrayOfJPRoomInfo jpRooms;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "JPCode")
    protected String jpCode;

    /**
     * Gets the value of the hotelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Sets the value of the hotelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelName(String value) {
        this.hotelName = value;
    }

    /**
     * Gets the value of the zone property.
     * 
     * @return
     *     possible object is
     *     {@link JPZone }
     *     
     */
    public JPZone getZone() {
        return zone;
    }

    /**
     * Sets the value of the zone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPZone }
     *     
     */
    public void setZone(JPZone value) {
        this.zone = value;
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
     * Gets the value of the hotelType property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelType }
     *     
     */
    public JPHotelType getHotelType() {
        return hotelType;
    }

    /**
     * Sets the value of the hotelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelType }
     *     
     */
    public void setHotelType(JPHotelType value) {
        this.hotelType = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link JPLabelType }
     *     
     */
    public JPLabelType getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPLabelType }
     *     
     */
    public void setLabel(JPLabelType value) {
        this.label = value;
    }

    /**
     * Gets the value of the segmentHotel property.
     * 
     * @return
     *     possible object is
     *     {@link JPSegmentHotel }
     *     
     */
    public JPSegmentHotel getSegmentHotel() {
        return segmentHotel;
    }

    /**
     * Sets the value of the segmentHotel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSegmentHotel }
     *     
     */
    public void setSegmentHotel(JPSegmentHotel value) {
        this.segmentHotel = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link JPAddressType }
     *     
     */
    public JPAddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPAddressType }
     *     
     */
    public void setAddress(JPAddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the contactInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPContactInfo }
     *     
     */
    public JPContactInfo getContactInfo() {
        return contactInfo;
    }

    /**
     * Sets the value of the contactInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPContactInfo }
     *     
     */
    public void setContactInfo(JPContactInfo value) {
        this.contactInfo = value;
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
     * Gets the value of the descriptions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPDescription }
     *     
     */
    public ArrayOfJPDescription getDescriptions() {
        return descriptions;
    }

    /**
     * Sets the value of the descriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPDescription }
     *     
     */
    public void setDescriptions(ArrayOfJPDescription value) {
        this.descriptions = value;
    }

    /**
     * Gets the value of the features property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPFeature }
     *     
     */
    public ArrayOfJPFeature getFeatures() {
        return features;
    }

    /**
     * Sets the value of the features property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPFeature }
     *     
     */
    public void setFeatures(ArrayOfJPFeature value) {
        this.features = value;
    }

    /**
     * Gets the value of the pointsOfInterest property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPointOfInterest }
     *     
     */
    public ArrayOfJPPointOfInterest getPointsOfInterest() {
        return pointsOfInterest;
    }

    /**
     * Sets the value of the pointsOfInterest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPointOfInterest }
     *     
     */
    public void setPointsOfInterest(ArrayOfJPPointOfInterest value) {
        this.pointsOfInterest = value;
    }

    /**
     * Gets the value of the contentProviders property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPContentProvider }
     *     
     */
    public ArrayOfJPContentProvider getContentProviders() {
        return contentProviders;
    }

    /**
     * Sets the value of the contentProviders property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPContentProvider }
     *     
     */
    public void setContentProviders(ArrayOfJPContentProvider value) {
        this.contentProviders = value;
    }

    /**
     * Gets the value of the timeInformation property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelTimeInformation }
     *     
     */
    public JPHotelTimeInformation getTimeInformation() {
        return timeInformation;
    }

    /**
     * Sets the value of the timeInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelTimeInformation }
     *     
     */
    public void setTimeInformation(JPHotelTimeInformation value) {
        this.timeInformation = value;
    }

    /**
     * Gets the value of the hotelRooms property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelRoom }
     *     
     */
    public ArrayOfJPHotelRoom getHotelRooms() {
        return hotelRooms;
    }

    /**
     * Sets the value of the hotelRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelRoom }
     *     
     */
    public void setHotelRooms(ArrayOfJPHotelRoom value) {
        this.hotelRooms = value;
    }

    /**
     * Gets the value of the jpRooms property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRoomInfo }
     *     
     */
    public ArrayOfJPRoomInfo getJPRooms() {
        return jpRooms;
    }

    /**
     * Sets the value of the jpRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRoomInfo }
     *     
     */
    public void setJPRooms(ArrayOfJPRoomInfo value) {
        this.jpRooms = value;
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

}
