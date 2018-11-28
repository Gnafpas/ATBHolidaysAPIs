
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ItemStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_ItemStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="AV"/>
 *     &lt;enumeration value="RQ"/>
 *     &lt;enumeration value="CA"/>
 *     &lt;enumeration value="SO"/>
 *     &lt;enumeration value="RP"/>
 *     &lt;enumeration value="UN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_ItemStatus")
@XmlEnum
public enum JPItemStatus {

    OK,
    AV,
    RQ,
    CA,
    SO,
    RP,
    UN;

    public String value() {
        return name();
    }

    public static JPItemStatus fromValue(String v) {
        return valueOf(v);
    }

}
