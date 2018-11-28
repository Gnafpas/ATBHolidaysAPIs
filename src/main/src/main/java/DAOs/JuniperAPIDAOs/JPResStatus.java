
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ResStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_ResStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INI"/>
 *     &lt;enumeration value="PRE"/>
 *     &lt;enumeration value="PDI"/>
 *     &lt;enumeration value="CON"/>
 *     &lt;enumeration value="TAR"/>
 *     &lt;enumeration value="ETA"/>
 *     &lt;enumeration value="PAG"/>
 *     &lt;enumeration value="CAC"/>
 *     &lt;enumeration value="CAN"/>
 *     &lt;enumeration value="QUO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_ResStatus")
@XmlEnum
public enum JPResStatus {

    INI,
    PRE,
    PDI,
    CON,
    TAR,
    ETA,
    PAG,
    CAC,
    CAN,
    QUO;

    public String value() {
        return name();
    }

    public static JPResStatus fromValue(String v) {
        return valueOf(v);
    }

}
