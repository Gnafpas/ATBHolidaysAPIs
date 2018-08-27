
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CabinType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_CabinType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Undefined"/>
 *     &lt;enumeration value="Business"/>
 *     &lt;enumeration value="First"/>
 *     &lt;enumeration value="Economy"/>
 *     &lt;enumeration value="Premium"/>
 *     &lt;enumeration value="PremiumBusiness"/>
 *     &lt;enumeration value="PremiumFirst"/>
 *     &lt;enumeration value="PremiumEconomy"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_CabinType")
@XmlEnum
public enum JPCabinType {

    @XmlEnumValue("Undefined")
    UNDEFINED("Undefined"),
    @XmlEnumValue("Business")
    BUSINESS("Business"),
    @XmlEnumValue("First")
    FIRST("First"),
    @XmlEnumValue("Economy")
    ECONOMY("Economy"),
    @XmlEnumValue("Premium")
    PREMIUM("Premium"),
    @XmlEnumValue("PremiumBusiness")
    PREMIUM_BUSINESS("PremiumBusiness"),
    @XmlEnumValue("PremiumFirst")
    PREMIUM_FIRST("PremiumFirst"),
    @XmlEnumValue("PremiumEconomy")
    PREMIUM_ECONOMY("PremiumEconomy");
    private final String value;

    JPCabinType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPCabinType fromValue(String v) {
        for (JPCabinType c: JPCabinType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
