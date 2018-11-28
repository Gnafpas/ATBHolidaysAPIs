
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentsHotels complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentsHotels">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentHotels" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentHotels" minOccurs="0"/>
 *         &lt;element name="Nights" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Suppliers" type="{http://www.juniper.es/webservice/2007/}ArrayOfString5" minOccurs="0"/>
 *         &lt;element name="HotelCodes" type="{http://www.juniper.es/webservice/2007/}ArrayOfString7" minOccurs="0"/>
 *         &lt;element name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryOfResidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelCategories" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelCategory" minOccurs="0"/>
 *         &lt;element name="HotelTypes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelType" minOccurs="0"/>
 *         &lt;element name="PropertyTypes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PropertyType" minOccurs="0"/>
 *         &lt;element name="Boards" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Board" minOccurs="0"/>
 *         &lt;element name="SupplementTypes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_SupplementHotelType" minOccurs="0"/>
 *         &lt;element name="InfoSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PromoCodes" type="{http://www.juniper.es/webservice/2007/}ArrayOfString8" minOccurs="0"/>
 *         &lt;element name="PaymentType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="All"/>
 *               &lt;enumeration value="ExcludePaymentInDestination"/>
 *               &lt;enumeration value="OnlyPaymentInDestination"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PackageContracts" type="{http://www.juniper.es/webservice/2007/}JP_PackageContracts" minOccurs="0"/>
 *         &lt;element name="DailyContracts" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_DailyHotelContract" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentsHotels", propOrder = {
    "searchSegmentHotels",
    "nights",
    "suppliers",
    "hotelCodes",
    "hotelName",
    "countryOfResidence",
    "hotelCategories",
    "hotelTypes",
    "propertyTypes",
    "boards",
    "supplementTypes",
    "infoSource",
    "productClass",
    "promoCodes",
    "paymentType",
    "packageContracts",
    "dailyContracts"
})
@XmlSeeAlso({
    JPSearchSegmentsHotelFutureRates.class
})
public class JPSearchSegmentsHotels {

    @XmlElement(name = "SearchSegmentHotels")
    protected JPSearchSegmentHotels searchSegmentHotels;
    @XmlElement(name = "Nights")
    protected Integer nights;
    @XmlElement(name = "Suppliers")
    protected ArrayOfString5 suppliers;
    @XmlElement(name = "HotelCodes")
    protected ArrayOfString7 hotelCodes;
    @XmlElement(name = "HotelName")
    protected String hotelName;
    @XmlElement(name = "CountryOfResidence")
    protected String countryOfResidence;
    @XmlElement(name = "HotelCategories")
    protected ArrayOfJPHotelCategory hotelCategories;
    @XmlElement(name = "HotelTypes")
    protected ArrayOfJPHotelType hotelTypes;
    @XmlElement(name = "PropertyTypes")
    protected ArrayOfJPPropertyType propertyTypes;
    @XmlElement(name = "Boards")
    protected ArrayOfJPBoard boards;
    @XmlElement(name = "SupplementTypes")
    protected ArrayOfJPSupplementHotelType supplementTypes;
    @XmlElement(name = "InfoSource")
    protected String infoSource;
    @XmlElement(name = "ProductClass")
    protected String productClass;
    @XmlElement(name = "PromoCodes")
    protected ArrayOfString8 promoCodes;
    @XmlElement(name = "PaymentType")
    protected String paymentType;
    @XmlElement(name = "PackageContracts")
    @XmlSchemaType(name = "string")
    protected JPPackageContracts packageContracts;
    @XmlElement(name = "DailyContracts")
    protected ArrayOfJPDailyHotelContract dailyContracts;

    /**
     * Gets the value of the searchSegmentHotels property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentHotels }
     *     
     */
    public JPSearchSegmentHotels getSearchSegmentHotels() {
        return searchSegmentHotels;
    }

    /**
     * Sets the value of the searchSegmentHotels property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentHotels }
     *     
     */
    public void setSearchSegmentHotels(JPSearchSegmentHotels value) {
        this.searchSegmentHotels = value;
    }

    /**
     * Gets the value of the nights property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNights() {
        return nights;
    }

    /**
     * Sets the value of the nights property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNights(Integer value) {
        this.nights = value;
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
     * Gets the value of the hotelCodes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString7 }
     *     
     */
    public ArrayOfString7 getHotelCodes() {
        return hotelCodes;
    }

    /**
     * Sets the value of the hotelCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString7 }
     *     
     */
    public void setHotelCodes(ArrayOfString7 value) {
        this.hotelCodes = value;
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
     * Gets the value of the hotelTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelType }
     *     
     */
    public ArrayOfJPHotelType getHotelTypes() {
        return hotelTypes;
    }

    /**
     * Sets the value of the hotelTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelType }
     *     
     */
    public void setHotelTypes(ArrayOfJPHotelType value) {
        this.hotelTypes = value;
    }

    /**
     * Gets the value of the propertyTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPropertyType }
     *     
     */
    public ArrayOfJPPropertyType getPropertyTypes() {
        return propertyTypes;
    }

    /**
     * Sets the value of the propertyTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPropertyType }
     *     
     */
    public void setPropertyTypes(ArrayOfJPPropertyType value) {
        this.propertyTypes = value;
    }

    /**
     * Gets the value of the boards property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPBoard }
     *     
     */
    public ArrayOfJPBoard getBoards() {
        return boards;
    }

    /**
     * Sets the value of the boards property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPBoard }
     *     
     */
    public void setBoards(ArrayOfJPBoard value) {
        this.boards = value;
    }

    /**
     * Gets the value of the supplementTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSupplementHotelType }
     *     
     */
    public ArrayOfJPSupplementHotelType getSupplementTypes() {
        return supplementTypes;
    }

    /**
     * Sets the value of the supplementTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSupplementHotelType }
     *     
     */
    public void setSupplementTypes(ArrayOfJPSupplementHotelType value) {
        this.supplementTypes = value;
    }

    /**
     * Gets the value of the infoSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoSource() {
        return infoSource;
    }

    /**
     * Sets the value of the infoSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoSource(String value) {
        this.infoSource = value;
    }

    /**
     * Gets the value of the productClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductClass() {
        return productClass;
    }

    /**
     * Sets the value of the productClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductClass(String value) {
        this.productClass = value;
    }

    /**
     * Gets the value of the promoCodes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString8 }
     *     
     */
    public ArrayOfString8 getPromoCodes() {
        return promoCodes;
    }

    /**
     * Sets the value of the promoCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString8 }
     *     
     */
    public void setPromoCodes(ArrayOfString8 value) {
        this.promoCodes = value;
    }

    /**
     * Gets the value of the paymentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the value of the paymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentType(String value) {
        this.paymentType = value;
    }

    /**
     * Gets the value of the packageContracts property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageContracts }
     *     
     */
    public JPPackageContracts getPackageContracts() {
        return packageContracts;
    }

    /**
     * Sets the value of the packageContracts property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageContracts }
     *     
     */
    public void setPackageContracts(JPPackageContracts value) {
        this.packageContracts = value;
    }

    /**
     * Gets the value of the dailyContracts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPDailyHotelContract }
     *     
     */
    public ArrayOfJPDailyHotelContract getDailyContracts() {
        return dailyContracts;
    }

    /**
     * Sets the value of the dailyContracts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPDailyHotelContract }
     *     
     */
    public void setDailyContracts(ArrayOfJPDailyHotelContract value) {
        this.dailyContracts = value;
    }

}
