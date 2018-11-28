
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ProductType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_ProductType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TKT"/>
 *     &lt;enumeration value="TRF"/>
 *     &lt;enumeration value="VSD"/>
 *     &lt;enumeration value="CAR"/>
 *     &lt;enumeration value="HOT"/>
 *     &lt;enumeration value="FLH"/>
 *     &lt;enumeration value="PCK"/>
 *     &lt;enumeration value="INS"/>
 *     &lt;enumeration value="CRU"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_ProductType")
@XmlEnum
public enum JPProductType {

    TKT,
    TRF,
    VSD,
    CAR,
    HOT,
    FLH,
    PCK,
    INS,
    CRU;

    public String value() {
        return name();
    }

    public static JPProductType fromValue(String v) {
        return valueOf(v);
    }

}
