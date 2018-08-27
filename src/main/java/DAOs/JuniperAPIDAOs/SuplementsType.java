
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SuplementsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SuplementsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OTHERS"/>
 *     &lt;enumeration value="DINING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SuplementsType")
@XmlEnum
public enum SuplementsType {

    OTHERS,
    DINING;

    public String value() {
        return name();
    }

    public static SuplementsType fromValue(String v) {
        return valueOf(v);
    }

}
