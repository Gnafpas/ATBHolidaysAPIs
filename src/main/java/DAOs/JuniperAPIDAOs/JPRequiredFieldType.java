
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RequiredFieldType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_RequiredFieldType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="String"/>
 *     &lt;enumeration value="Integer"/>
 *     &lt;enumeration value="Datetime"/>
 *     &lt;enumeration value="Decimal"/>
 *     &lt;enumeration value="Boolean"/>
 *     &lt;enumeration value="Enum"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_RequiredFieldType")
@XmlEnum
public enum JPRequiredFieldType {

    @XmlEnumValue("String")
    STRING("String"),
    @XmlEnumValue("Integer")
    INTEGER("Integer"),
    @XmlEnumValue("Datetime")
    DATETIME("Datetime"),
    @XmlEnumValue("Decimal")
    DECIMAL("Decimal"),
    @XmlEnumValue("Boolean")
    BOOLEAN("Boolean"),
    @XmlEnumValue("Enum")
    ENUM("Enum");
    private final String value;

    JPRequiredFieldType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPRequiredFieldType fromValue(String v) {
        for (JPRequiredFieldType c: JPRequiredFieldType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
