
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_PriceTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_PriceTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Specified"/>
 *     &lt;enumeration value="Porcentual"/>
 *     &lt;enumeration value="Replace"/>
 *     &lt;enumeration value="RateDiscount"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_PriceTypes")
@XmlEnum
public enum JPSOAPPriceTypes {

    @XmlEnumValue("Specified")
    SPECIFIED("Specified"),
    @XmlEnumValue("Porcentual")
    PORCENTUAL("Porcentual"),
    @XmlEnumValue("Replace")
    REPLACE("Replace"),
    @XmlEnumValue("RateDiscount")
    RATE_DISCOUNT("RateDiscount");
    private final String value;

    JPSOAPPriceTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPPriceTypes fromValue(String v) {
        for (JPSOAPPriceTypes c: JPSOAPPriceTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
