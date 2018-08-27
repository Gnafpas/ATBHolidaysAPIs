
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_PricePerTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_PricePerTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NightPax"/>
 *     &lt;enumeration value="NightRoom"/>
 *     &lt;enumeration value="NightPaxRoom"/>
 *     &lt;enumeration value="NightBooking"/>
 *     &lt;enumeration value="StayPax"/>
 *     &lt;enumeration value="StayRoom"/>
 *     &lt;enumeration value="StayPaxRoom"/>
 *     &lt;enumeration value="StayBooking"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_PricePerTypes")
@XmlEnum
public enum JPSOAPPricePerTypes {

    @XmlEnumValue("NightPax")
    NIGHT_PAX("NightPax"),
    @XmlEnumValue("NightRoom")
    NIGHT_ROOM("NightRoom"),
    @XmlEnumValue("NightPaxRoom")
    NIGHT_PAX_ROOM("NightPaxRoom"),
    @XmlEnumValue("NightBooking")
    NIGHT_BOOKING("NightBooking"),
    @XmlEnumValue("StayPax")
    STAY_PAX("StayPax"),
    @XmlEnumValue("StayRoom")
    STAY_ROOM("StayRoom"),
    @XmlEnumValue("StayPaxRoom")
    STAY_PAX_ROOM("StayPaxRoom"),
    @XmlEnumValue("StayBooking")
    STAY_BOOKING("StayBooking");
    private final String value;

    JPSOAPPricePerTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPPricePerTypes fromValue(String v) {
        for (JPSOAPPricePerTypes c: JPSOAPPricePerTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
