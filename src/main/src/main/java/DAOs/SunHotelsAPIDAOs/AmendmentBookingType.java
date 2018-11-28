
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmendmentBookingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AmendmentBookingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FullPeriod"/>
 *     &lt;enumeration value="ExtraDays"/>
 *     &lt;enumeration value="NoAmendmentAvailable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AmendmentBookingType")
@XmlEnum
public enum AmendmentBookingType {

    @XmlEnumValue("FullPeriod")
    FULL_PERIOD("FullPeriod"),
    @XmlEnumValue("ExtraDays")
    EXTRA_DAYS("ExtraDays"),
    @XmlEnumValue("NoAmendmentAvailable")
    NO_AMENDMENT_AVAILABLE("NoAmendmentAvailable");
    private final String value;

    AmendmentBookingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AmendmentBookingType fromValue(String v) {
        for (AmendmentBookingType c: AmendmentBookingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
