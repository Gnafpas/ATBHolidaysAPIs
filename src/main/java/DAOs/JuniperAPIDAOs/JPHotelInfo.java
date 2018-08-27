
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Images" type="{http://www.juniper.es/webservice/2007/}ArrayOfString1" minOccurs="0"/>
 *         &lt;element name="HotelChain" type="{http://www.juniper.es/webservice/2007/}JP_HotelChain" minOccurs="0"/>
 *         &lt;element name="HotelCategory" type="{http://www.juniper.es/webservice/2007/}JP_HotelCategory" minOccurs="0"/>
 *         &lt;element name="HotelType" type="{http://www.juniper.es/webservice/2007/}JP_HotelType" minOccurs="0"/>
 *         &lt;element name="PropertyType" type="{http://www.juniper.es/webservice/2007/}JP_PropertyType" minOccurs="0"/>
 *         &lt;element name="Label" type="{http://www.juniper.es/webservice/2007/}JP_LabelType" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeepLink" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContentProviders" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ContentProvider" minOccurs="0"/>
 *         &lt;element name="TimeInformation" type="{http://www.juniper.es/webservice/2007/}JP_HotelTimeInformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelInfo", propOrder = {
    "name",
    "description",
    "images",
    "hotelChain",
    "hotelCategory",
    "hotelType",
    "propertyType",
    "label",
    "address",
    "latitude",
    "longitude",
    "deepLink",
    "contentProviders",
    "timeInformation"
})
public class JPHotelInfo {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Images")
    protected ArrayOfString1 images;
    @XmlElement(name = "HotelChain")
    protected JPHotelChain hotelChain;
    @XmlElement(name = "HotelCategory")
    protected JPHotelCategory hotelCategory;
    @XmlElement(name = "HotelType")
    protected JPHotelType hotelType;
    @XmlElement(name = "PropertyType")
    protected JPPropertyType propertyType;
    @XmlElement(name = "Label")
    protected JPLabelType label;
    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "Latitude")
    protected String latitude;
    @XmlElement(name = "Longitude")
    protected String longitude;
    @XmlElement(name = "DeepLink")
    protected String deepLink;
    @XmlElement(name = "ContentProviders")
    protected ArrayOfJPContentProvider contentProviders;
    @XmlElement(name = "TimeInformation")
    protected JPHotelTimeInformation timeInformation;

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
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString1 }
     *     
     */
    public ArrayOfString1 getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString1 }
     *     
     */
    public void setImages(ArrayOfString1 value) {
        this.images = value;
    }

    /**
     * Gets the value of the hotelChain property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelChain }
     *     
     */
    public JPHotelChain getHotelChain() {
        return hotelChain;
    }

    /**
     * Sets the value of the hotelChain property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelChain }
     *     
     */
    public void setHotelChain(JPHotelChain value) {
        this.hotelChain = value;
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
     * Gets the value of the propertyType property.
     * 
     * @return
     *     possible object is
     *     {@link JPPropertyType }
     *     
     */
    public JPPropertyType getPropertyType() {
        return propertyType;
    }

    /**
     * Sets the value of the propertyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPropertyType }
     *     
     */
    public void setPropertyType(JPPropertyType value) {
        this.propertyType = value;
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
     * Gets the value of the latitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatitude(String value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongitude(String value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the deepLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeepLink() {
        return deepLink;
    }

    /**
     * Sets the value of the deepLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeepLink(String value) {
        this.deepLink = value;
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

}
