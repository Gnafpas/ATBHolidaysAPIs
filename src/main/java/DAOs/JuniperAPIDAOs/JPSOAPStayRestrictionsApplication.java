
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_StayRestrictionsApplication.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_StayRestrictionsApplication">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TotalBookedNights"/>
 *     &lt;enumeration value="StayNightsAffected"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_StayRestrictionsApplication")
@XmlEnum
public enum JPSOAPStayRestrictionsApplication {

    @XmlEnumValue("TotalBookedNights")
    TOTAL_BOOKED_NIGHTS("TotalBookedNights"),
    @XmlEnumValue("StayNightsAffected")
    STAY_NIGHTS_AFFECTED("StayNightsAffected");
    private final String value;

    JPSOAPStayRestrictionsApplication(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPStayRestrictionsApplication fromValue(String v) {
        for (JPSOAPStayRestrictionsApplication c: JPSOAPStayRestrictionsApplication.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
