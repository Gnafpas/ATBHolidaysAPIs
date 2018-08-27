
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ContractType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_ContractType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Expedia"/>
 *     &lt;enumeration value="FIT"/>
 *     &lt;enumeration value="Guarantee"/>
 *     &lt;enumeration value="Promo"/>
 *     &lt;enumeration value="Rack"/>
 *     &lt;enumeration value="BAR"/>
 *     &lt;enumeration value="Deposit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_ContractType")
@XmlEnum
public enum JPContractType {

    @XmlEnumValue("Expedia")
    EXPEDIA("Expedia"),
    FIT("FIT"),
    @XmlEnumValue("Guarantee")
    GUARANTEE("Guarantee"),
    @XmlEnumValue("Promo")
    PROMO("Promo"),
    @XmlEnumValue("Rack")
    RACK("Rack"),
    BAR("BAR"),
    @XmlEnumValue("Deposit")
    DEPOSIT("Deposit");
    private final String value;

    JPContractType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPContractType fromValue(String v) {
        for (JPContractType c: JPContractType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
