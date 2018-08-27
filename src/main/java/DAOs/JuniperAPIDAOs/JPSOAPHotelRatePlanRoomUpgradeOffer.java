
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelRatePlanRoomUpgradeOffer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelRatePlanRoomUpgradeOffer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="RoomTypeCodePay" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="RoomTypeCodeGet" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelRatePlanRoomUpgradeOffer")
public class JPSOAPHotelRatePlanRoomUpgradeOffer {

    @XmlAttribute(name = "RoomTypeCodePay", required = true)
    protected int roomTypeCodePay;
    @XmlAttribute(name = "RoomTypeCodeGet", required = true)
    protected int roomTypeCodeGet;

    /**
     * Gets the value of the roomTypeCodePay property.
     * 
     */
    public int getRoomTypeCodePay() {
        return roomTypeCodePay;
    }

    /**
     * Sets the value of the roomTypeCodePay property.
     * 
     */
    public void setRoomTypeCodePay(int value) {
        this.roomTypeCodePay = value;
    }

    /**
     * Gets the value of the roomTypeCodeGet property.
     * 
     */
    public int getRoomTypeCodeGet() {
        return roomTypeCodeGet;
    }

    /**
     * Sets the value of the roomTypeCodeGet property.
     * 
     */
    public void setRoomTypeCodeGet(int value) {
        this.roomTypeCodeGet = value;
    }

}
