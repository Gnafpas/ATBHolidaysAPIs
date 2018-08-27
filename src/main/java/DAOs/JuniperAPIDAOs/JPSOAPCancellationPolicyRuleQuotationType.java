
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_CancellationPolicyRuleQuotationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_CancellationPolicyRuleQuotationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Average"/>
 *     &lt;enumeration value="FirstNight"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_CancellationPolicyRuleQuotationType")
@XmlEnum
public enum JPSOAPCancellationPolicyRuleQuotationType {

    @XmlEnumValue("Average")
    AVERAGE("Average"),
    @XmlEnumValue("FirstNight")
    FIRST_NIGHT("FirstNight");
    private final String value;

    JPSOAPCancellationPolicyRuleQuotationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPCancellationPolicyRuleQuotationType fromValue(String v) {
        for (JPSOAPCancellationPolicyRuleQuotationType c: JPSOAPCancellationPolicyRuleQuotationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
