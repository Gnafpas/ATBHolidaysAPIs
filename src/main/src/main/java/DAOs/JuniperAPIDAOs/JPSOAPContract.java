
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_Contract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_Contract">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HotelCodeEncrypt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Active" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Delta" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_Contract", propOrder = {
    "name"
})
@XmlSeeAlso({
    JPSOAPHotelRatePlanContract.class,
    JPSOAPHotelAvailContract.class
})
public class JPSOAPContract {

    @XmlElement(name = "Name")
    protected String name;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "HotelCode")
    protected String hotelCode;
    @XmlAttribute(name = "HotelCodeEncrypt")
    protected String hotelCodeEncrypt;
    @XmlAttribute(name = "Active", required = true)
    protected boolean active;
    @XmlAttribute(name = "Delta")
    protected Boolean delta;

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
     * Gets the value of the delta property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDelta() {
        return delta;
    }

    /**
     * Sets the value of the delta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDelta(Boolean value) {
        this.delta = value;
    }

}
