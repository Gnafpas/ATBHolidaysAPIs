
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RateQueryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RateQueryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Cache"/>
 *     &lt;enumeration value="Cash"/>
 *     &lt;enumeration value="Verification"/>
 *     &lt;enumeration value="Live"/>
 *     &lt;enumeration value="DirectConnection"/>
 *     &lt;enumeration value="NoPreference"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RateQueryType")
@XmlEnum
public enum RateQueryType {

    @XmlEnumValue("Cache")
    CACHE("Cache"),
    @XmlEnumValue("Cash")
    CASH("Cash"),
    @XmlEnumValue("Verification")
    VERIFICATION("Verification"),
    @XmlEnumValue("Live")
    LIVE("Live"),
    @XmlEnumValue("DirectConnection")
    DIRECT_CONNECTION("DirectConnection"),
    @XmlEnumValue("NoPreference")
    NO_PREFERENCE("NoPreference");
    private final String value;

    RateQueryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RateQueryType fromValue(String v) {
        for (RateQueryType c: RateQueryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
