
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_BaggageType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_BaggageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="handBaggage"/>
 *     &lt;enumeration value="holdBaggage"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_BaggageType")
@XmlEnum
public enum JPBaggageType {

    @XmlEnumValue("handBaggage")
    HAND_BAGGAGE("handBaggage"),
    @XmlEnumValue("holdBaggage")
    HOLD_BAGGAGE("holdBaggage");
    private final String value;

    JPBaggageType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPBaggageType fromValue(String v) {
        for (JPBaggageType c: JPBaggageType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
