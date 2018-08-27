
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ZoneType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_ZoneType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALO"/>
 *     &lt;enumeration value="ARP"/>
 *     &lt;enumeration value="EST"/>
 *     &lt;enumeration value="PRT"/>
 *     &lt;enumeration value="OTR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_ZoneType")
@XmlEnum
public enum JPZoneType {

    ALO,
    ARP,
    EST,
    PRT,
    OTR;

    public String value() {
        return name();
    }

    public static JPZoneType fromValue(String v) {
        return valueOf(v);
    }

}
