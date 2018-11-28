
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ZoneInfoType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_ZoneInfoType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BASE"/>
 *     &lt;enumeration value="EXTENDEDLANG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_ZoneInfoType")
@XmlEnum
public enum JPZoneInfoType {

    BASE,
    EXTENDEDLANG;

    public String value() {
        return name();
    }

    public static JPZoneInfoType fromValue(String v) {
        return valueOf(v);
    }

}
