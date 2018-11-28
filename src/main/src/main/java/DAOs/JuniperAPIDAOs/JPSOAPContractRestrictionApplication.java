
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_ContractRestrictionApplication.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_ContractRestrictionApplication">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OnlyAccommodationWithPossiblePackage"/>
 *     &lt;enumeration value="OnlyAccommodation"/>
 *     &lt;enumeration value="OnlyDynamicPackage"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_ContractRestrictionApplication")
@XmlEnum
public enum JPSOAPContractRestrictionApplication {

    @XmlEnumValue("OnlyAccommodationWithPossiblePackage")
    ONLY_ACCOMMODATION_WITH_POSSIBLE_PACKAGE("OnlyAccommodationWithPossiblePackage"),
    @XmlEnumValue("OnlyAccommodation")
    ONLY_ACCOMMODATION("OnlyAccommodation"),
    @XmlEnumValue("OnlyDynamicPackage")
    ONLY_DYNAMIC_PACKAGE("OnlyDynamicPackage");
    private final String value;

    JPSOAPContractRestrictionApplication(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPContractRestrictionApplication fromValue(String v) {
        for (JPSOAPContractRestrictionApplication c: JPSOAPContractRestrictionApplication.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
