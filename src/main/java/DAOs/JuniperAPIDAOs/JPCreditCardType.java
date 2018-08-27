
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CreditCardType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_CreditCardType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AX"/>
 *     &lt;enumeration value="CA"/>
 *     &lt;enumeration value="DC"/>
 *     &lt;enumeration value="DS"/>
 *     &lt;enumeration value="ER"/>
 *     &lt;enumeration value="IT"/>
 *     &lt;enumeration value="JC"/>
 *     &lt;enumeration value="MA"/>
 *     &lt;enumeration value="MC"/>
 *     &lt;enumeration value="NR"/>
 *     &lt;enumeration value="NT"/>
 *     &lt;enumeration value="VE"/>
 *     &lt;enumeration value="VI"/>
 *     &lt;enumeration value="OT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_CreditCardType")
@XmlEnum
public enum JPCreditCardType {

    AX,
    CA,
    DC,
    DS,
    ER,
    IT,
    JC,
    MA,
    MC,
    NR,
    NT,
    VE,
    VI,
    OT;

    public String value() {
        return name();
    }

    public static JPCreditCardType fromValue(String v) {
        return valueOf(v);
    }

}
