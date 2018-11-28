
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_OfferType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_OfferType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Basic"/>
 *     &lt;enumeration value="EarlyBooking"/>
 *     &lt;enumeration value="InvalidateMinimuStay"/>
 *     &lt;enumeration value="LowerPrices"/>
 *     &lt;enumeration value="FreeNights"/>
 *     &lt;enumeration value="FreePaxes"/>
 *     &lt;enumeration value="BoardUpgrade"/>
 *     &lt;enumeration value="RoomTypeUpgrade"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_OfferType")
@XmlEnum
public enum JPSOAPOfferType {

    @XmlEnumValue("Basic")
    BASIC("Basic"),
    @XmlEnumValue("EarlyBooking")
    EARLY_BOOKING("EarlyBooking"),
    @XmlEnumValue("InvalidateMinimuStay")
    INVALIDATE_MINIMU_STAY("InvalidateMinimuStay"),
    @XmlEnumValue("LowerPrices")
    LOWER_PRICES("LowerPrices"),
    @XmlEnumValue("FreeNights")
    FREE_NIGHTS("FreeNights"),
    @XmlEnumValue("FreePaxes")
    FREE_PAXES("FreePaxes"),
    @XmlEnumValue("BoardUpgrade")
    BOARD_UPGRADE("BoardUpgrade"),
    @XmlEnumValue("RoomTypeUpgrade")
    ROOM_TYPE_UPGRADE("RoomTypeUpgrade");
    private final String value;

    JPSOAPOfferType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPOfferType fromValue(String v) {
        for (JPSOAPOfferType c: JPSOAPOfferType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
