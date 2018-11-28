
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_BaseSupleOfferRest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_BaseSupleOfferRest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ages" type="{http://www.juniper.es/webservice/2007/}JPSOAP_Ages" minOccurs="0"/>
 *         &lt;element name="RoomTypes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_IntCodeAttr2" minOccurs="0"/>
 *         &lt;element name="Boards" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_IntCodeAttr3" minOccurs="0"/>
 *         &lt;element name="CountryOfResidence" type="{http://www.juniper.es/webservice/2007/}JPSOAP_CountryOfResidence" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Active" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="OnRequest" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="CategoryCode" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="SpecialTypeCode" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="SpecialTax" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_BaseSupleOfferRest", propOrder = {
    "name",
    "ages",
    "roomTypes",
    "boards",
    "countryOfResidence"
})
@XmlSeeAlso({
    JPSOAPHotelRatePlanSupplement.class,
    JPSOAPHotelRatePlanRestriction.class,
    JPSOAPHotelRatePlanOffer.class
})
public abstract class JPSOAPBaseSupleOfferRest {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Ages")
    protected JPSOAPAges ages;
    @XmlElement(name = "RoomTypes")
    protected ArrayOfJPSOAPIntCodeAttr2 roomTypes;
    @XmlElement(name = "Boards")
    protected ArrayOfJPSOAPIntCodeAttr3 boards;
    @XmlElement(name = "CountryOfResidence")
    protected JPSOAPCountryOfResidence countryOfResidence;
    @XmlAttribute(name = "Code", required = true)
    protected int code;
    @XmlAttribute(name = "Active", required = true)
    protected boolean active;
    @XmlAttribute(name = "OnRequest", required = true)
    protected boolean onRequest;
    @XmlAttribute(name = "CategoryCode")
    protected Integer categoryCode;
    @XmlAttribute(name = "SpecialTypeCode")
    protected Integer specialTypeCode;
    @XmlAttribute(name = "SpecialTax", required = true)
    protected boolean specialTax;

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
     * Gets the value of the roomTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPIntCodeAttr2 }
     *     
     */
    public ArrayOfJPSOAPIntCodeAttr2 getRoomTypes() {
        return roomTypes;
    }

    /**
     * Sets the value of the roomTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPIntCodeAttr2 }
     *     
     */
    public void setRoomTypes(ArrayOfJPSOAPIntCodeAttr2 value) {
        this.roomTypes = value;
    }

    /**
     * Gets the value of the boards property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPIntCodeAttr3 }
     *     
     */
    public ArrayOfJPSOAPIntCodeAttr3 getBoards() {
        return boards;
    }

    /**
     * Sets the value of the boards property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPIntCodeAttr3 }
     *     
     */
    public void setBoards(ArrayOfJPSOAPIntCodeAttr3 value) {
        this.boards = value;
    }

    /**
     * Gets the value of the countryOfResidence property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPCountryOfResidence }
     *     
     */
    public JPSOAPCountryOfResidence getCountryOfResidence() {
        return countryOfResidence;
    }

    /**
     * Sets the value of the countryOfResidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPCountryOfResidence }
     *     
     */
    public void setCountryOfResidence(JPSOAPCountryOfResidence value) {
        this.countryOfResidence = value;
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
     * Gets the value of the active property.
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setActive(boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the onRequest property.
     * 
     */
    public boolean isOnRequest() {
        return onRequest;
    }

    /**
     * Sets the value of the onRequest property.
     * 
     */
    public void setOnRequest(boolean value) {
        this.onRequest = value;
    }

    /**
     * Gets the value of the categoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCategoryCode() {
        return categoryCode;
    }

    /**
     * Sets the value of the categoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCategoryCode(Integer value) {
        this.categoryCode = value;
    }

    /**
     * Gets the value of the specialTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSpecialTypeCode() {
        return specialTypeCode;
    }

    /**
     * Sets the value of the specialTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSpecialTypeCode(Integer value) {
        this.specialTypeCode = value;
    }

    /**
     * Gets the value of the specialTax property.
     * 
     */
    public boolean isSpecialTax() {
        return specialTax;
    }

    /**
     * Sets the value of the specialTax property.
     * 
     */
    public void setSpecialTax(boolean value) {
        this.specialTax = value;
    }

}
