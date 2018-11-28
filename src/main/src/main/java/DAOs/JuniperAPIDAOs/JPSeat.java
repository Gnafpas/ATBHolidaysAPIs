
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Seat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Seat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Situations" type="{http://www.juniper.es/webservice/2007/}ArrayOfString3" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Avail" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Group" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Premium" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="SeatSelectionCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Seat", propOrder = {
    "situations"
})
public class JPSeat {

    @XmlElement(name = "Situations")
    protected ArrayOfString3 situations;
    @XmlAttribute(name = "Avail")
    protected String avail;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "Group", required = true)
    protected int group;
    @XmlAttribute(name = "Premium", required = true)
    protected boolean premium;
    @XmlAttribute(name = "SeatSelectionCode")
    protected String seatSelectionCode;

    /**
     * Gets the value of the situations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString3 }
     *     
     */
    public ArrayOfString3 getSituations() {
        return situations;
    }

    /**
     * Sets the value of the situations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString3 }
     *     
     */
    public void setSituations(ArrayOfString3 value) {
        this.situations = value;
    }

    /**
     * Gets the value of the avail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvail() {
        return avail;
    }

    /**
     * Sets the value of the avail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvail(String value) {
        this.avail = value;
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
     * Gets the value of the group property.
     * 
     */
    public int getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     */
    public void setGroup(int value) {
        this.group = value;
    }

    /**
     * Gets the value of the premium property.
     * 
     */
    public boolean isPremium() {
        return premium;
    }

    /**
     * Sets the value of the premium property.
     * 
     */
    public void setPremium(boolean value) {
        this.premium = value;
    }

    /**
     * Gets the value of the seatSelectionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatSelectionCode() {
        return seatSelectionCode;
    }

    /**
     * Sets the value of the seatSelectionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatSelectionCode(String value) {
        this.seatSelectionCode = value;
    }

}
