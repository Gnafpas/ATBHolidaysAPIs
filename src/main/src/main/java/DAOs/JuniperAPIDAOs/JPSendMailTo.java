
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SendMailTo.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_SendMailTo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SUPPLIER"/>
 *     &lt;enumeration value="CUSTOMER"/>
 *     &lt;enumeration value="ALL"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_SendMailTo")
@XmlEnum
public enum JPSendMailTo {

    SUPPLIER,
    CUSTOMER,
    ALL,
    NONE;

    public String value() {
        return name();
    }

    public static JPSendMailTo fromValue(String v) {
        return valueOf(v);
    }

}
