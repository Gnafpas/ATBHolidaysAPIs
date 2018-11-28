
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleTransmissionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VehicleTransmissionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Automatic"/>
 *     &lt;enumeration value="Manual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VehicleTransmissionType")
@XmlEnum
public enum VehicleTransmissionType {

    @XmlEnumValue("Automatic")
    AUTOMATIC("Automatic"),
    @XmlEnumValue("Manual")
    MANUAL("Manual");
    private final String value;

    VehicleTransmissionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VehicleTransmissionType fromValue(String v) {
        for (VehicleTransmissionType c: VehicleTransmissionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
