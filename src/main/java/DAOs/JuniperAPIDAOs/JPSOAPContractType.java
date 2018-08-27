
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_ContractType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_ContractType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Expedia"/>
 *     &lt;enumeration value="FIT"/>
 *     &lt;enumeration value="Guarantee"/>
 *     &lt;enumeration value="Promo"/>
 *     &lt;enumeration value="Rack"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_ContractType")
@XmlEnum
public enum JPSOAPContractType {

    @XmlEnumValue("Expedia")
    EXPEDIA("Expedia"),
    FIT("FIT"),
    @XmlEnumValue("Guarantee")
    GUARANTEE("Guarantee"),
    @XmlEnumValue("Promo")
    PROMO("Promo"),
    @XmlEnumValue("Rack")
    RACK("Rack");
    private final String value;

    JPSOAPContractType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPContractType fromValue(String v) {
        for (JPSOAPContractType c: JPSOAPContractType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
