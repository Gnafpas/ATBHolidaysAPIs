
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LocationDetailRequirementAgeInfoType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LocationDetailRequirementAgeInfoType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MinimumAge"/>
 *     &lt;enumeration value="MinimumAgeExceptions"/>
 *     &lt;enumeration value="Miscellaneous"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LocationDetailRequirementAgeInfoType")
@XmlEnum
public enum LocationDetailRequirementAgeInfoType {

    @XmlEnumValue("MinimumAge")
    MINIMUM_AGE("MinimumAge"),
    @XmlEnumValue("MinimumAgeExceptions")
    MINIMUM_AGE_EXCEPTIONS("MinimumAgeExceptions"),
    @XmlEnumValue("Miscellaneous")
    MISCELLANEOUS("Miscellaneous");
    private final String value;

    LocationDetailRequirementAgeInfoType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LocationDetailRequirementAgeInfoType fromValue(String v) {
        for (LocationDetailRequirementAgeInfoType c: LocationDetailRequirementAgeInfoType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
