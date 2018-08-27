
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_RestrictionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_RestrictionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Basic"/>
 *     &lt;enumeration value="MinimuStay"/>
 *     &lt;enumeration value="CheckinDates"/>
 *     &lt;enumeration value="CheckoutDates"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_RestrictionType")
@XmlEnum
public enum JPSOAPRestrictionType {

    @XmlEnumValue("Basic")
    BASIC("Basic"),
    @XmlEnumValue("MinimuStay")
    MINIMU_STAY("MinimuStay"),
    @XmlEnumValue("CheckinDates")
    CHECKIN_DATES("CheckinDates"),
    @XmlEnumValue("CheckoutDates")
    CHECKOUT_DATES("CheckoutDates");
    private final String value;

    JPSOAPRestrictionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPRestrictionType fromValue(String v) {
        for (JPSOAPRestrictionType c: JPSOAPRestrictionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
