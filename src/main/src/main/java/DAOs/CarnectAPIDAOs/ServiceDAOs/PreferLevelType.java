
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PreferLevelType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PreferLevelType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Required"/>
 *     &lt;enumeration value="Only"/>
 *     &lt;enumeration value="Preferred"/>
 *     &lt;enumeration value="NoPreference"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PreferLevelType")
@XmlEnum
public enum PreferLevelType {

    @XmlEnumValue("Required")
    REQUIRED("Required"),
    @XmlEnumValue("Only")
    ONLY("Only"),
    @XmlEnumValue("Preferred")
    PREFERRED("Preferred"),
    @XmlEnumValue("NoPreference")
    NO_PREFERENCE("NoPreference");
    private final String value;

    PreferLevelType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PreferLevelType fromValue(String v) {
        for (PreferLevelType c: PreferLevelType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
