
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SupplementApplicationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_SupplementApplicationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="U"/>
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="B"/>
 *     &lt;enumeration value="N"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_SupplementApplicationType")
@XmlEnum
public enum JPSupplementApplicationType {

    U,
    P,
    B,
    N;

    public String value() {
        return name();
    }

    public static JPSupplementApplicationType fromValue(String v) {
        return valueOf(v);
    }

}
