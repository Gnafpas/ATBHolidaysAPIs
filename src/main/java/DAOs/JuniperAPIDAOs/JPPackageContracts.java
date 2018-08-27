
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PackageContracts.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_PackageContracts">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Hotel"/>
 *     &lt;enumeration value="Package"/>
 *     &lt;enumeration value="OnlyPackage"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_PackageContracts")
@XmlEnum
public enum JPPackageContracts {

    @XmlEnumValue("Hotel")
    HOTEL("Hotel"),
    @XmlEnumValue("Package")
    PACKAGE("Package"),
    @XmlEnumValue("OnlyPackage")
    ONLY_PACKAGE("OnlyPackage");
    private final String value;

    JPPackageContracts(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPPackageContracts fromValue(String v) {
        for (JPPackageContracts c: JPPackageContracts.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
