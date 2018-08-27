
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelRoomSizeUnitType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_HotelRoomSizeUnitType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ft2"/>
 *     &lt;enumeration value="m2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_HotelRoomSizeUnitType")
@XmlEnum
public enum JPHotelRoomSizeUnitType {

    @XmlEnumValue("ft2")
    FT_2("ft2"),
    @XmlEnumValue("m2")
    M_2("m2");
    private final String value;

    JPHotelRoomSizeUnitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPHotelRoomSizeUnitType fromValue(String v) {
        for (JPHotelRoomSizeUnitType c: JPHotelRoomSizeUnitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
