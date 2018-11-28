
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SupplementType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_SupplementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="O"/>
 *     &lt;enumeration value="R"/>
 *     &lt;enumeration value="N"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_SupplementType")
@XmlEnum
public enum JPSupplementType {

    M,
    O,
    R,
    N;

    public String value() {
        return name();
    }

    public static JPSupplementType fromValue(String v) {
        return valueOf(v);
    }

}
