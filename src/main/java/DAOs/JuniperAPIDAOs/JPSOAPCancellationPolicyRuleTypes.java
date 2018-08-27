
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_CancellationPolicyRuleTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_CancellationPolicyRuleTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="V"/>
 *     &lt;enumeration value="R"/>
 *     &lt;enumeration value="S"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_CancellationPolicyRuleTypes")
@XmlEnum
public enum JPSOAPCancellationPolicyRuleTypes {

    V,
    R,
    S;

    public String value() {
        return name();
    }

    public static JPSOAPCancellationPolicyRuleTypes fromValue(String v) {
        return valueOf(v);
    }

}
