
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_ApplicationRuleQuotation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_ApplicationRuleQuotation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BasePrice"/>
 *     &lt;enumeration value="MealRoomSupplement"/>
 *     &lt;enumeration value="SupplementsOffers"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_ApplicationRuleQuotation")
@XmlEnum
public enum JPSOAPApplicationRuleQuotation {

    @XmlEnumValue("BasePrice")
    BASE_PRICE("BasePrice"),
    @XmlEnumValue("MealRoomSupplement")
    MEAL_ROOM_SUPPLEMENT("MealRoomSupplement"),
    @XmlEnumValue("SupplementsOffers")
    SUPPLEMENTS_OFFERS("SupplementsOffers");
    private final String value;

    JPSOAPApplicationRuleQuotation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPApplicationRuleQuotation fromValue(String v) {
        for (JPSOAPApplicationRuleQuotation c: JPSOAPApplicationRuleQuotation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
