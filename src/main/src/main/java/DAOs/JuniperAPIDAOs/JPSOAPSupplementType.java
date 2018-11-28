
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_SupplementType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_SupplementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Basic"/>
 *     &lt;enumeration value="ShortStay"/>
 *     &lt;enumeration value="PickUpPoint"/>
 *     &lt;enumeration value="MealPlan"/>
 *     &lt;enumeration value="RoomPlan"/>
 *     &lt;enumeration value="IndividualUse"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_SupplementType")
@XmlEnum
public enum JPSOAPSupplementType {

    @XmlEnumValue("Basic")
    BASIC("Basic"),
    @XmlEnumValue("ShortStay")
    SHORT_STAY("ShortStay"),
    @XmlEnumValue("PickUpPoint")
    PICK_UP_POINT("PickUpPoint"),
    @XmlEnumValue("MealPlan")
    MEAL_PLAN("MealPlan"),
    @XmlEnumValue("RoomPlan")
    ROOM_PLAN("RoomPlan"),
    @XmlEnumValue("IndividualUse")
    INDIVIDUAL_USE("IndividualUse");
    private final String value;

    JPSOAPSupplementType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPSupplementType fromValue(String v) {
        for (JPSOAPSupplementType c: JPSOAPSupplementType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
