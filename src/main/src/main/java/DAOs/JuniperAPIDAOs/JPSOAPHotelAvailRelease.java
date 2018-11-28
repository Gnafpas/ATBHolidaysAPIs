
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelAvailRelease complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelAvailRelease">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoomTypes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_IntCodeAttr2" minOccurs="0"/>
 *         &lt;element name="Dates" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_DateIntervals" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Days" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Type" use="required" type="{http://www.juniper.es/webservice/2007/}JPSOAP_ReleaseTypes" />
 *       &lt;attribute name="Value" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="AffectsBaseAllotment" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="AffectsSecurityAllotment" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="AffectsGuaranteedAllotment" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelAvailRelease", propOrder = {
    "roomTypes",
    "dates"
})
public class JPSOAPHotelAvailRelease {

    @XmlElement(name = "RoomTypes")
    protected ArrayOfJPSOAPIntCodeAttr2 roomTypes;
    @XmlElement(name = "Dates")
    protected ArrayOfJPSOAPDateIntervals dates;
    @XmlAttribute(name = "Days", required = true)
    protected int days;
    @XmlAttribute(name = "Type", required = true)
    protected JPSOAPReleaseTypes type;
    @XmlAttribute(name = "Value", required = true)
    protected int value;
    @XmlAttribute(name = "AffectsBaseAllotment", required = true)
    protected boolean affectsBaseAllotment;
    @XmlAttribute(name = "AffectsSecurityAllotment", required = true)
    protected boolean affectsSecurityAllotment;
    @XmlAttribute(name = "AffectsGuaranteedAllotment", required = true)
    protected boolean affectsGuaranteedAllotment;

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
     * Gets the value of the dates property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPDateIntervals }
     *     
     */
    public ArrayOfJPSOAPDateIntervals getDates() {
        return dates;
    }

    /**
     * Sets the value of the dates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPDateIntervals }
     *     
     */
    public void setDates(ArrayOfJPSOAPDateIntervals value) {
        this.dates = value;
    }

    /**
     * Gets the value of the days property.
     * 
     */
    public int getDays() {
        return days;
    }

    /**
     * Sets the value of the days property.
     * 
     */
    public void setDays(int value) {
        this.days = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPReleaseTypes }
     *     
     */
    public JPSOAPReleaseTypes getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPReleaseTypes }
     *     
     */
    public void setType(JPSOAPReleaseTypes value) {
        this.type = value;
    }

    /**
     * Gets the value of the value property.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Gets the value of the affectsBaseAllotment property.
     * 
     */
    public boolean isAffectsBaseAllotment() {
        return affectsBaseAllotment;
    }

    /**
     * Sets the value of the affectsBaseAllotment property.
     * 
     */
    public void setAffectsBaseAllotment(boolean value) {
        this.affectsBaseAllotment = value;
    }

    /**
     * Gets the value of the affectsSecurityAllotment property.
     * 
     */
    public boolean isAffectsSecurityAllotment() {
        return affectsSecurityAllotment;
    }

    /**
     * Sets the value of the affectsSecurityAllotment property.
     * 
     */
    public void setAffectsSecurityAllotment(boolean value) {
        this.affectsSecurityAllotment = value;
    }

    /**
     * Gets the value of the affectsGuaranteedAllotment property.
     * 
     */
    public boolean isAffectsGuaranteedAllotment() {
        return affectsGuaranteedAllotment;
    }

    /**
     * Sets the value of the affectsGuaranteedAllotment property.
     * 
     */
    public void setAffectsGuaranteedAllotment(boolean value) {
        this.affectsGuaranteedAllotment = value;
    }

}
