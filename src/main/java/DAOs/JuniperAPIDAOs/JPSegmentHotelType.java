
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SegmentHotelType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_SegmentHotelType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VERIFIED"/>
 *     &lt;enumeration value="GREY"/>
 *     &lt;enumeration value="NOHOTEL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_SegmentHotelType")
@XmlEnum
public enum JPSegmentHotelType {

    VERIFIED,
    GREY,
    NOHOTEL;

    public String value() {
        return name();
    }

    public static JPSegmentHotelType fromValue(String v) {
        return valueOf(v);
    }

}
