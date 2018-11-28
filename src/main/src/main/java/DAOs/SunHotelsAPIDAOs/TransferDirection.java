
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransferDirection.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransferDirection">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Arrival"/>
 *     &lt;enumeration value="Return"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransferDirection")
@XmlEnum
public enum TransferDirection {

    @XmlEnumValue("Arrival")
    ARRIVAL("Arrival"),
    @XmlEnumValue("Return")
    RETURN("Return");
    private final String value;

    TransferDirection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransferDirection fromValue(String v) {
        for (TransferDirection c: TransferDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
