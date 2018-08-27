
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * <p>Java class for JP_PackageContent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageContent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PackageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Origins" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageZone" minOccurs="0"/>
 *         &lt;element name="Destinations" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageZone" minOccurs="0"/>
 *         &lt;element name="StayDestinations" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageZone" minOccurs="0"/>
 *         &lt;element name="Dates" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageDate" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PriceFrom" minOccurs="0"/>
 *         &lt;element name="Images" type="{http://www.juniper.es/webservice/2007/}ArrayOfString1" minOccurs="0"/>
 *         &lt;element name="Descriptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Description" minOccurs="0"/>
 *         &lt;element name="Itineraries" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageItinerary" minOccurs="0"/>
 *         &lt;element name="PackageCalendarPriceItems" type="{http://www.juniper.es/webservice/2007/}JP_PackageCalendarPriceItems" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ProductTypes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ProductType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Duration" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="Master" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageContent", propOrder = {
    "packageName",
    "origins",
    "destinations",
    "stayDestinations",
    "dates",
    "prices",
    "images",
    "descriptions",
    "itineraries",
    "packageCalendarPriceItems",
    "productTypes"
})
public class JPPackageContent {

    @XmlElement(name = "PackageName")
    protected String packageName;
    @XmlElement(name = "Origins")
    protected ArrayOfJPPackageZone origins;
    @XmlElement(name = "Destinations")
    protected ArrayOfJPPackageZone destinations;
    @XmlElement(name = "StayDestinations")
    protected ArrayOfJPPackageZone stayDestinations;
    @XmlElement(name = "Dates")
    protected ArrayOfJPPackageDate dates;
    @XmlElement(name = "Prices")
    protected ArrayOfJPPriceFrom prices;
    @XmlElement(name = "Images")
    protected ArrayOfString1 images;
    @XmlElement(name = "Descriptions")
    protected ArrayOfJPDescription descriptions;
    @XmlElement(name = "Itineraries")
    protected ArrayOfJPPackageItinerary itineraries;
    @XmlElement(name = "PackageCalendarPriceItems")
    protected List<JPPackageCalendarPriceItems> packageCalendarPriceItems;
    @XmlElement(name = "ProductTypes")
    protected ArrayOfJPProductType productTypes;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "Duration")
    protected Duration duration;
    @XmlAttribute(name = "Master")
    protected Boolean master;

    /**
     * Gets the value of the packageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * Sets the value of the packageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageName(String value) {
        this.packageName = value;
    }

    /**
     * Gets the value of the origins property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackageZone }
     *     
     */
    public ArrayOfJPPackageZone getOrigins() {
        return origins;
    }

    /**
     * Sets the value of the origins property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackageZone }
     *     
     */
    public void setOrigins(ArrayOfJPPackageZone value) {
        this.origins = value;
    }

    /**
     * Gets the value of the destinations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackageZone }
     *     
     */
    public ArrayOfJPPackageZone getDestinations() {
        return destinations;
    }

    /**
     * Sets the value of the destinations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackageZone }
     *     
     */
    public void setDestinations(ArrayOfJPPackageZone value) {
        this.destinations = value;
    }

    /**
     * Gets the value of the stayDestinations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackageZone }
     *     
     */
    public ArrayOfJPPackageZone getStayDestinations() {
        return stayDestinations;
    }

    /**
     * Sets the value of the stayDestinations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackageZone }
     *     
     */
    public void setStayDestinations(ArrayOfJPPackageZone value) {
        this.stayDestinations = value;
    }

    /**
     * Gets the value of the dates property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackageDate }
     *     
     */
    public ArrayOfJPPackageDate getDates() {
        return dates;
    }

    /**
     * Sets the value of the dates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackageDate }
     *     
     */
    public void setDates(ArrayOfJPPackageDate value) {
        this.dates = value;
    }

    /**
     * Gets the value of the prices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPriceFrom }
     *     
     */
    public ArrayOfJPPriceFrom getPrices() {
        return prices;
    }

    /**
     * Sets the value of the prices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPriceFrom }
     *     
     */
    public void setPrices(ArrayOfJPPriceFrom value) {
        this.prices = value;
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
     * Gets the value of the itineraries property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackageItinerary }
     *     
     */
    public ArrayOfJPPackageItinerary getItineraries() {
        return itineraries;
    }

    /**
     * Sets the value of the itineraries property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackageItinerary }
     *     
     */
    public void setItineraries(ArrayOfJPPackageItinerary value) {
        this.itineraries = value;
    }

    /**
     * Gets the value of the packageCalendarPriceItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the packageCalendarPriceItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPackageCalendarPriceItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPPackageCalendarPriceItems }
     * 
     * 
     */
    public List<JPPackageCalendarPriceItems> getPackageCalendarPriceItems() {
        if (packageCalendarPriceItems == null) {
            packageCalendarPriceItems = new ArrayList<JPPackageCalendarPriceItems>();
        }
        return this.packageCalendarPriceItems;
    }

    /**
     * Gets the value of the productTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPProductType }
     *     
     */
    public ArrayOfJPProductType getProductTypes() {
        return productTypes;
    }

    /**
     * Sets the value of the productTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPProductType }
     *     
     */
    public void setProductTypes(ArrayOfJPProductType value) {
        this.productTypes = value;
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
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDuration(Duration value) {
        this.duration = value;
    }

    /**
     * Gets the value of the master property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMaster() {
        return master;
    }

    /**
     * Sets the value of the master property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMaster(Boolean value) {
        this.master = value;
    }

}
