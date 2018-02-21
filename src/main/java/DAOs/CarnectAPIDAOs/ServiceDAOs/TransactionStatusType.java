
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Pending"/>
 *     &lt;enumeration value="Cancelled"/>
 *     &lt;enumeration value="Modified"/>
 *     &lt;enumeration value="Committed"/>
 *     &lt;enumeration value="Ignored"/>
 *     &lt;enumeration value="On Hold"/>
 *     &lt;enumeration value="Unsuccessful"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionStatusType")
@XmlEnum
public enum TransactionStatusType {

    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("Modified")
    MODIFIED("Modified"),
    @XmlEnumValue("Committed")
    COMMITTED("Committed"),
    @XmlEnumValue("Ignored")
    IGNORED("Ignored"),
    @XmlEnumValue("On Hold")
    ON_HOLD("On Hold"),
    @XmlEnumValue("Unsuccessful")
    UNSUCCESSFUL("Unsuccessful");
    private final String value;

    TransactionStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransactionStatusType fromValue(String v) {
        for (TransactionStatusType c: TransactionStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
