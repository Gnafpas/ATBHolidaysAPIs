
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LocationDetailRequirementInfoType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LocationDetailRequirementInfoType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OneWayRental"/>
 *     &lt;enumeration value="Geographic"/>
 *     &lt;enumeration value="DropOff"/>
 *     &lt;enumeration value="License"/>
 *     &lt;enumeration value="Insurance"/>
 *     &lt;enumeration value="Eligibility"/>
 *     &lt;enumeration value="Miscellaneous"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LocationDetailRequirementInfoType")
@XmlEnum
public enum LocationDetailRequirementInfoType {

    @XmlEnumValue("OneWayRental")
    ONE_WAY_RENTAL("OneWayRental"),
    @XmlEnumValue("Geographic")
    GEOGRAPHIC("Geographic"),
    @XmlEnumValue("DropOff")
    DROP_OFF("DropOff"),
    @XmlEnumValue("License")
    LICENSE("License"),
    @XmlEnumValue("Insurance")
    INSURANCE("Insurance"),
    @XmlEnumValue("Eligibility")
    ELIGIBILITY("Eligibility"),
    @XmlEnumValue("Miscellaneous")
    MISCELLANEOUS("Miscellaneous");
    private final String value;

    LocationDetailRequirementInfoType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LocationDetailRequirementInfoType fromValue(String v) {
        for (LocationDetailRequirementInfoType c: LocationDetailRequirementInfoType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
