
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_ReleaseTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_ReleaseTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fixed"/>
 *     &lt;enumeration value="Percentage"/>
 *     &lt;enumeration value="MaxBookings"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_ReleaseTypes")
@XmlEnum
public enum JPSOAPReleaseTypes {

    @XmlEnumValue("Fixed")
    FIXED("Fixed"),
    @XmlEnumValue("Percentage")
    PERCENTAGE("Percentage"),
    @XmlEnumValue("MaxBookings")
    MAX_BOOKINGS("MaxBookings");
    private final String value;

    JPSOAPReleaseTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPReleaseTypes fromValue(String v) {
        for (JPSOAPReleaseTypes c: JPSOAPReleaseTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
