
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BookingStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BookingStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotActive"/>
 *     &lt;enumeration value="Active"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BookingStatus")
@XmlEnum
public enum BookingStatus {

    @XmlEnumValue("NotActive")
    NOT_ACTIVE("NotActive"),
    @XmlEnumValue("Active")
    ACTIVE("Active");
    private final String value;

    BookingStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BookingStatus fromValue(String v) {
        for (BookingStatus c: BookingStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
