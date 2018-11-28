
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelAvailAllotment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelAvailAllotment">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JPSOAP_Allotment">
 *       &lt;attribute name="RoomTypeCode" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="IsSecurityAllotment" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="IsGuaranteedAllotment" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="MinimumAllotment" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelAvailAllotment")
public class JPSOAPHotelAvailAllotment
    extends JPSOAPAllotment
{

    @XmlAttribute(name = "RoomTypeCode", required = true)
    protected int roomTypeCode;
    @XmlAttribute(name = "IsSecurityAllotment", required = true)
    protected boolean isSecurityAllotment;
    @XmlAttribute(name = "IsGuaranteedAllotment", required = true)
    protected boolean isGuaranteedAllotment;
    @XmlAttribute(name = "MinimumAllotment")
    protected Integer minimumAllotment;

    /**
     * Gets the value of the roomTypeCode property.
     * 
     */
    public int getRoomTypeCode() {
        return roomTypeCode;
    }

    /**
     * Sets the value of the roomTypeCode property.
     * 
     */
    public void setRoomTypeCode(int value) {
        this.roomTypeCode = value;
    }

    /**
     * Gets the value of the isSecurityAllotment property.
     * 
     */
    public boolean isIsSecurityAllotment() {
        return isSecurityAllotment;
    }

    /**
     * Sets the value of the isSecurityAllotment property.
     * 
     */
    public void setIsSecurityAllotment(boolean value) {
        this.isSecurityAllotment = value;
    }

    /**
     * Gets the value of the isGuaranteedAllotment property.
     * 
     */
    public boolean isIsGuaranteedAllotment() {
        return isGuaranteedAllotment;
    }

    /**
     * Sets the value of the isGuaranteedAllotment property.
     * 
     */
    public void setIsGuaranteedAllotment(boolean value) {
        this.isGuaranteedAllotment = value;
    }

    /**
     * Gets the value of the minimumAllotment property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinimumAllotment() {
        return minimumAllotment;
    }

    /**
     * Sets the value of the minimumAllotment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinimumAllotment(Integer value) {
        this.minimumAllotment = value;
    }

}
