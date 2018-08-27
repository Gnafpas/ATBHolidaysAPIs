
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComponentsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ComponentsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FLIGHT"/>
 *     &lt;enumeration value="HOTEL"/>
 *     &lt;enumeration value="TRANSPORT"/>
 *     &lt;enumeration value="TERMINAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ComponentsType")
@XmlEnum
public enum ComponentsType {

    FLIGHT,
    HOTEL,
    TRANSPORT,
    TERMINAL;

    public String value() {
        return name();
    }

    public static ComponentsType fromValue(String v) {
        return valueOf(v);
    }

}
