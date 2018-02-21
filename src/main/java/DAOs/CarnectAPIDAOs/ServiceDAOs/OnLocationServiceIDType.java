
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OnLocationServiceID_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OnLocationServiceID_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ComputerDrivingDirections"/>
 *     &lt;enumeration value="ExpressReturnService"/>
 *     &lt;enumeration value="SpecialNeeds"/>
 *     &lt;enumeration value="FrequentRenter"/>
 *     &lt;enumeration value="Miscellaneous"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OnLocationServiceID_Type")
@XmlEnum
public enum OnLocationServiceIDType {

    @XmlEnumValue("ComputerDrivingDirections")
    COMPUTER_DRIVING_DIRECTIONS("ComputerDrivingDirections"),
    @XmlEnumValue("ExpressReturnService")
    EXPRESS_RETURN_SERVICE("ExpressReturnService"),
    @XmlEnumValue("SpecialNeeds")
    SPECIAL_NEEDS("SpecialNeeds"),
    @XmlEnumValue("FrequentRenter")
    FREQUENT_RENTER("FrequentRenter"),
    @XmlEnumValue("Miscellaneous")
    MISCELLANEOUS("Miscellaneous");
    private final String value;

    OnLocationServiceIDType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OnLocationServiceIDType fromValue(String v) {
        for (OnLocationServiceIDType c: OnLocationServiceIDType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
