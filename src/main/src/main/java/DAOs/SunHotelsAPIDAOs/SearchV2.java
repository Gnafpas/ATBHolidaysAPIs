
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currencies" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="checkInDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="checkOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="numberOfRooms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="destination" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destinationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotelIDs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resortIDs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accommodationTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberOfAdults" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfChildren" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="childrenAges" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="infant" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sortBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sortOrder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exactDestinationMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="blockSuperdeal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mealIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="showCoordinates" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="showReviews" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referencePointLatitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referencePointLongitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxDistanceFromReferencePoint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minStarRating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxStarRating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="featureIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="themeIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="excludeSharedRooms" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="excludeSharedFacilities" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prioritizedHotelIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalRoomsInBatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentMethodId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="b2c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userName",
    "password",
    "language",
    "currencies",
    "checkInDate",
    "checkOutDate",
    "numberOfRooms",
    "destination",
    "destinationID",
    "hotelIDs",
    "resortIDs",
    "accommodationTypes",
    "numberOfAdults",
    "numberOfChildren",
    "childrenAges",
    "infant",
    "sortBy",
    "sortOrder",
    "exactDestinationMatch",
    "blockSuperdeal",
    "mealIds",
    "showCoordinates",
    "showReviews",
    "referencePointLatitude",
    "referencePointLongitude",
    "maxDistanceFromReferencePoint",
    "minStarRating",
    "maxStarRating",
    "featureIds",
    "minPrice",
    "maxPrice",
    "themeIds",
    "excludeSharedRooms",
    "excludeSharedFacilities",
    "prioritizedHotelIds",
    "totalRoomsInBatch",
    "paymentMethodId",
    "customerCountry",
    "b2C"
})
@XmlRootElement(name = "SearchV2")
public class SearchV2 {

    protected String userName;
    protected String password;
    protected String language;
    protected String currencies;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkInDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkOutDate;
    protected int numberOfRooms;
    protected String destination;
    protected String destinationID;
    protected String hotelIDs;
    protected String resortIDs;
    protected String accommodationTypes;
    protected int numberOfAdults;
    protected int numberOfChildren;
    protected String childrenAges;
    protected int infant;
    protected String sortBy;
    protected String sortOrder;
    protected String exactDestinationMatch;
    protected String blockSuperdeal;
    protected String mealIds;
    protected String showCoordinates;
    protected String showReviews;
    protected String referencePointLatitude;
    protected String referencePointLongitude;
    protected String maxDistanceFromReferencePoint;
    protected String minStarRating;
    protected String maxStarRating;
    protected String featureIds;
    protected String minPrice;
    protected String maxPrice;
    protected String themeIds;
    protected String excludeSharedRooms;
    protected String excludeSharedFacilities;
    protected String prioritizedHotelIds;
    protected String totalRoomsInBatch;
    protected String paymentMethodId;
    protected String customerCountry;
    @XmlElement(name = "b2c")
    protected String b2C;

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the currencies property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencies() {
        return currencies;
    }

    /**
     * Sets the value of the currencies property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencies(String value) {
        this.currencies = value;
    }

    /**
     * Gets the value of the checkInDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckInDate() {
        return checkInDate;
    }

    /**
     * Sets the value of the checkInDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckInDate(XMLGregorianCalendar value) {
        this.checkInDate = value;
    }

    /**
     * Gets the value of the checkOutDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Sets the value of the checkOutDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckOutDate(XMLGregorianCalendar value) {
        this.checkOutDate = value;
    }

    /**
     * Gets the value of the numberOfRooms property.
     * 
     */
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * Sets the value of the numberOfRooms property.
     * 
     */
    public void setNumberOfRooms(int value) {
        this.numberOfRooms = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestination(String value) {
        this.destination = value;
    }

    /**
     * Gets the value of the destinationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationID() {
        return destinationID;
    }

    /**
     * Sets the value of the destinationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationID(String value) {
        this.destinationID = value;
    }

    /**
     * Gets the value of the hotelIDs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelIDs() {
        return hotelIDs;
    }

    /**
     * Sets the value of the hotelIDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelIDs(String value) {
        this.hotelIDs = value;
    }

    /**
     * Gets the value of the resortIDs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResortIDs() {
        return resortIDs;
    }

    /**
     * Sets the value of the resortIDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResortIDs(String value) {
        this.resortIDs = value;
    }

    /**
     * Gets the value of the accommodationTypes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccommodationTypes() {
        return accommodationTypes;
    }

    /**
     * Sets the value of the accommodationTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccommodationTypes(String value) {
        this.accommodationTypes = value;
    }

    /**
     * Gets the value of the numberOfAdults property.
     * 
     */
    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    /**
     * Sets the value of the numberOfAdults property.
     * 
     */
    public void setNumberOfAdults(int value) {
        this.numberOfAdults = value;
    }

    /**
     * Gets the value of the numberOfChildren property.
     * 
     */
    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    /**
     * Sets the value of the numberOfChildren property.
     * 
     */
    public void setNumberOfChildren(int value) {
        this.numberOfChildren = value;
    }

    /**
     * Gets the value of the childrenAges property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildrenAges() {
        return childrenAges;
    }

    /**
     * Sets the value of the childrenAges property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildrenAges(String value) {
        this.childrenAges = value;
    }

    /**
     * Gets the value of the infant property.
     * 
     */
    public int getInfant() {
        return infant;
    }

    /**
     * Sets the value of the infant property.
     * 
     */
    public void setInfant(int value) {
        this.infant = value;
    }

    /**
     * Gets the value of the sortBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortBy() {
        return sortBy;
    }

    /**
     * Sets the value of the sortBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortBy(String value) {
        this.sortBy = value;
    }

    /**
     * Gets the value of the sortOrder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * Sets the value of the sortOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortOrder(String value) {
        this.sortOrder = value;
    }

    /**
     * Gets the value of the exactDestinationMatch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExactDestinationMatch() {
        return exactDestinationMatch;
    }

    /**
     * Sets the value of the exactDestinationMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExactDestinationMatch(String value) {
        this.exactDestinationMatch = value;
    }

    /**
     * Gets the value of the blockSuperdeal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockSuperdeal() {
        return blockSuperdeal;
    }

    /**
     * Sets the value of the blockSuperdeal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockSuperdeal(String value) {
        this.blockSuperdeal = value;
    }

    /**
     * Gets the value of the mealIds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMealIds() {
        return mealIds;
    }

    /**
     * Sets the value of the mealIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMealIds(String value) {
        this.mealIds = value;
    }

    /**
     * Gets the value of the showCoordinates property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShowCoordinates() {
        return showCoordinates;
    }

    /**
     * Sets the value of the showCoordinates property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShowCoordinates(String value) {
        this.showCoordinates = value;
    }

    /**
     * Gets the value of the showReviews property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShowReviews() {
        return showReviews;
    }

    /**
     * Sets the value of the showReviews property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShowReviews(String value) {
        this.showReviews = value;
    }

    /**
     * Gets the value of the referencePointLatitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencePointLatitude() {
        return referencePointLatitude;
    }

    /**
     * Sets the value of the referencePointLatitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencePointLatitude(String value) {
        this.referencePointLatitude = value;
    }

    /**
     * Gets the value of the referencePointLongitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencePointLongitude() {
        return referencePointLongitude;
    }

    /**
     * Sets the value of the referencePointLongitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencePointLongitude(String value) {
        this.referencePointLongitude = value;
    }

    /**
     * Gets the value of the maxDistanceFromReferencePoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxDistanceFromReferencePoint() {
        return maxDistanceFromReferencePoint;
    }

    /**
     * Sets the value of the maxDistanceFromReferencePoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxDistanceFromReferencePoint(String value) {
        this.maxDistanceFromReferencePoint = value;
    }

    /**
     * Gets the value of the minStarRating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinStarRating() {
        return minStarRating;
    }

    /**
     * Sets the value of the minStarRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinStarRating(String value) {
        this.minStarRating = value;
    }

    /**
     * Gets the value of the maxStarRating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxStarRating() {
        return maxStarRating;
    }

    /**
     * Sets the value of the maxStarRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxStarRating(String value) {
        this.maxStarRating = value;
    }

    /**
     * Gets the value of the featureIds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeatureIds() {
        return featureIds;
    }

    /**
     * Sets the value of the featureIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeatureIds(String value) {
        this.featureIds = value;
    }

    /**
     * Gets the value of the minPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinPrice() {
        return minPrice;
    }

    /**
     * Sets the value of the minPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinPrice(String value) {
        this.minPrice = value;
    }

    /**
     * Gets the value of the maxPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxPrice() {
        return maxPrice;
    }

    /**
     * Sets the value of the maxPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxPrice(String value) {
        this.maxPrice = value;
    }

    /**
     * Gets the value of the themeIds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThemeIds() {
        return themeIds;
    }

    /**
     * Sets the value of the themeIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThemeIds(String value) {
        this.themeIds = value;
    }

    /**
     * Gets the value of the excludeSharedRooms property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExcludeSharedRooms() {
        return excludeSharedRooms;
    }

    /**
     * Sets the value of the excludeSharedRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExcludeSharedRooms(String value) {
        this.excludeSharedRooms = value;
    }

    /**
     * Gets the value of the excludeSharedFacilities property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExcludeSharedFacilities() {
        return excludeSharedFacilities;
    }

    /**
     * Sets the value of the excludeSharedFacilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExcludeSharedFacilities(String value) {
        this.excludeSharedFacilities = value;
    }

    /**
     * Gets the value of the prioritizedHotelIds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrioritizedHotelIds() {
        return prioritizedHotelIds;
    }

    /**
     * Sets the value of the prioritizedHotelIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrioritizedHotelIds(String value) {
        this.prioritizedHotelIds = value;
    }

    /**
     * Gets the value of the totalRoomsInBatch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalRoomsInBatch() {
        return totalRoomsInBatch;
    }

    /**
     * Sets the value of the totalRoomsInBatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalRoomsInBatch(String value) {
        this.totalRoomsInBatch = value;
    }

    /**
     * Gets the value of the paymentMethodId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    /**
     * Sets the value of the paymentMethodId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethodId(String value) {
        this.paymentMethodId = value;
    }

    /**
     * Gets the value of the customerCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerCountry() {
        return customerCountry;
    }

    /**
     * Sets the value of the customerCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerCountry(String value) {
        this.customerCountry = value;
    }

    /**
     * Gets the value of the b2C property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getB2C() {
        return b2C;
    }

    /**
     * Sets the value of the b2C property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setB2C(String value) {
        this.b2C = value;
    }

}
