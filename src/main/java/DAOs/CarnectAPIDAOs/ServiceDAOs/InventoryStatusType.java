
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InventoryStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InventoryStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Available"/>
 *     &lt;enumeration value="Unavailable"/>
 *     &lt;enumeration value="OnRequest"/>
 *     &lt;enumeration value="Confirmed"/>
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="Waitlist"/>
 *     &lt;enumeration value="SupplierBooked"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InventoryStatusType")
@XmlEnum
public enum InventoryStatusType {

    @XmlEnumValue("Available")
    AVAILABLE("Available"),
    @XmlEnumValue("Unavailable")
    UNAVAILABLE("Unavailable"),
    @XmlEnumValue("OnRequest")
    ON_REQUEST("OnRequest"),
    @XmlEnumValue("Confirmed")
    CONFIRMED("Confirmed"),
    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("Waitlist")
    WAITLIST("Waitlist"),
    @XmlEnumValue("SupplierBooked")
    SUPPLIER_BOOKED("SupplierBooked");
    private final String value;

    InventoryStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InventoryStatusType fromValue(String v) {
        for (InventoryStatusType c: InventoryStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
