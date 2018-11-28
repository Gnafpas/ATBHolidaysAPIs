
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="destination" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotelIDs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resortIDs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accommodationTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sortBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sortOrder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exactDestinationMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "destination",
    "hotelIDs",
    "resortIDs",
    "accommodationTypes",
    "sortBy",
    "sortOrder",
    "exactDestinationMatch"
})
@XmlRootElement(name = "GetStaticHotelsAndRooms")
public class GetStaticHotelsAndRooms {

    protected String userName;
    protected String password;
    protected String language;
    protected String destination;
    protected String hotelIDs;
    protected String resortIDs;
    protected String accommodationTypes;
    protected String sortBy;
    protected String sortOrder;
    protected String exactDestinationMatch;

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

}
