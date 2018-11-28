
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentPackages complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentPackages">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentBase">
 *       &lt;sequence>
 *         &lt;element name="CountryOfResidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PackageCodes" type="{http://www.juniper.es/webservice/2007/}ArrayOfString6" minOccurs="0"/>
 *         &lt;element name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelCategories" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelCategory" minOccurs="0"/>
 *         &lt;element name="Suppliers" type="{http://www.juniper.es/webservice/2007/}ArrayOfString5" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="DestinationZoneForHotel" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ProductChangeType" type="{http://www.juniper.es/webservice/2007/}JP_ProductType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentPackages", propOrder = {
    "countryOfResidence",
    "packageCodes",
    "hotelName",
    "hotelCategories",
    "suppliers"
})
public class JPSearchSegmentPackages
    extends JPSearchSegmentBase
{

    @XmlElement(name = "CountryOfResidence")
    protected String countryOfResidence;
    @XmlElement(name = "PackageCodes")
    protected ArrayOfString6 packageCodes;
    @XmlElement(name = "HotelName")
    protected String hotelName;
    @XmlElement(name = "HotelCategories")
    protected ArrayOfJPHotelCategory hotelCategories;
    @XmlElement(name = "Suppliers")
    protected ArrayOfString5 suppliers;
    @XmlAttribute(name = "DestinationZoneForHotel")
    protected Integer destinationZoneForHotel;
    @XmlAttribute(name = "ProductChangeType")
    protected JPProductType productChangeType;

    /**
     * Gets the value of the countryOfResidence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    /**
     * Sets the value of the countryOfResidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfResidence(String value) {
        this.countryOfResidence = value;
    }

    /**
     * Gets the value of the packageCodes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString6 }
     *     
     */
    public ArrayOfString6 getPackageCodes() {
        return packageCodes;
    }

    /**
     * Sets the value of the packageCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString6 }
     *     
     */
    public void setPackageCodes(ArrayOfString6 value) {
        this.packageCodes = value;
    }

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
     * Gets the value of the hotelCategories property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelCategory }
     *     
     */
    public ArrayOfJPHotelCategory getHotelCategories() {
        return hotelCategories;
    }

    /**
     * Sets the value of the hotelCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelCategory }
     *     
     */
    public void setHotelCategories(ArrayOfJPHotelCategory value) {
        this.hotelCategories = value;
    }

    /**
     * Gets the value of the suppliers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString5 }
     *     
     */
    public ArrayOfString5 getSuppliers() {
        return suppliers;
    }

    /**
     * Sets the value of the suppliers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString5 }
     *     
     */
    public void setSuppliers(ArrayOfString5 value) {
        this.suppliers = value;
    }

    /**
     * Gets the value of the destinationZoneForHotel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDestinationZoneForHotel() {
        return destinationZoneForHotel;
    }

    /**
     * Sets the value of the destinationZoneForHotel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDestinationZoneForHotel(Integer value) {
        this.destinationZoneForHotel = value;
    }

    /**
     * Gets the value of the productChangeType property.
     * 
     * @return
     *     possible object is
     *     {@link JPProductType }
     *     
     */
    public JPProductType getProductChangeType() {
        return productChangeType;
    }

    /**
     * Sets the value of the productChangeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPProductType }
     *     
     */
    public void setProductChangeType(JPProductType value) {
        this.productChangeType = value;
    }

}
