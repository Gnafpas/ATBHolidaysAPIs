
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StationsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StationsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AEO"/>
 *     &lt;enumeration value="CITY"/>
 *     &lt;enumeration value="BUS"/>
 *     &lt;enumeration value="TRN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StationsType")
@XmlEnum
public enum StationsType {

    AEO,
    CITY,
    BUS,
    TRN;

    public String value() {
        return name();
    }

    public static StationsType fromValue(String v) {
        return valueOf(v);
    }

}
