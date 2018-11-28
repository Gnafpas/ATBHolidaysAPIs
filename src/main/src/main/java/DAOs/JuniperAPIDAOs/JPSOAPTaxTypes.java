
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_TaxTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_TaxTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FixedPerPerson"/>
 *     &lt;enumeration value="FixedPerPersonPerNight"/>
 *     &lt;enumeration value="FixedPerRoom"/>
 *     &lt;enumeration value="FixedPerRoomPerNight"/>
 *     &lt;enumeration value="FixedPerBooking"/>
 *     &lt;enumeration value="FixedPerBookingPerNight"/>
 *     &lt;enumeration value="Percentage"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_TaxTypes")
@XmlEnum
public enum JPSOAPTaxTypes {

    @XmlEnumValue("FixedPerPerson")
    FIXED_PER_PERSON("FixedPerPerson"),
    @XmlEnumValue("FixedPerPersonPerNight")
    FIXED_PER_PERSON_PER_NIGHT("FixedPerPersonPerNight"),
    @XmlEnumValue("FixedPerRoom")
    FIXED_PER_ROOM("FixedPerRoom"),
    @XmlEnumValue("FixedPerRoomPerNight")
    FIXED_PER_ROOM_PER_NIGHT("FixedPerRoomPerNight"),
    @XmlEnumValue("FixedPerBooking")
    FIXED_PER_BOOKING("FixedPerBooking"),
    @XmlEnumValue("FixedPerBookingPerNight")
    FIXED_PER_BOOKING_PER_NIGHT("FixedPerBookingPerNight"),
    @XmlEnumValue("Percentage")
    PERCENTAGE("Percentage");
    private final String value;

    JPSOAPTaxTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPTaxTypes fromValue(String v) {
        for (JPSOAPTaxTypes c: JPSOAPTaxTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
