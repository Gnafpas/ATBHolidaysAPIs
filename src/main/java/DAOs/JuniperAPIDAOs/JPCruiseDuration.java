
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseDuration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_CruiseDuration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="all"/>
 *     &lt;enumeration value="LessThan7Days"/>
 *     &lt;enumeration value="Between7And8Days"/>
 *     &lt;enumeration value="Between9And12Days"/>
 *     &lt;enumeration value="MoreThan12Days"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_CruiseDuration")
@XmlEnum
public enum JPCruiseDuration {

    @XmlEnumValue("all")
    ALL("all"),
    @XmlEnumValue("LessThan7Days")
    LESS_THAN_7_DAYS("LessThan7Days"),
    @XmlEnumValue("Between7And8Days")
    BETWEEN_7_AND_8_DAYS("Between7And8Days"),
    @XmlEnumValue("Between9And12Days")
    BETWEEN_9_AND_12_DAYS("Between9And12Days"),
    @XmlEnumValue("MoreThan12Days")
    MORE_THAN_12_DAYS("MoreThan12Days");
    private final String value;

    JPCruiseDuration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPCruiseDuration fromValue(String v) {
        for (JPCruiseDuration c: JPCruiseDuration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
