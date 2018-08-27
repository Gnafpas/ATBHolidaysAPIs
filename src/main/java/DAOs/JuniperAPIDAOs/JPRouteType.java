
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RouteType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_RouteType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="In"/>
 *     &lt;enumeration value="Out"/>
 *     &lt;enumeration value="InOut"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_RouteType")
@XmlEnum
public enum JPRouteType {

    @XmlEnumValue("In")
    IN("In"),
    @XmlEnumValue("Out")
    OUT("Out"),
    @XmlEnumValue("InOut")
    IN_OUT("InOut");
    private final String value;

    JPRouteType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPRouteType fromValue(String v) {
        for (JPRouteType c: JPRouteType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
