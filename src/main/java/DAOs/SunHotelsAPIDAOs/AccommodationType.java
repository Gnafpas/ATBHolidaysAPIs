
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccommodationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccommodationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HotelPost"/>
 *     &lt;enumeration value="Apartment"/>
 *     &lt;enumeration value="Villa"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AccommodationType")
@XmlEnum
public enum AccommodationType {

    @XmlEnumValue("HotelPost")
    HOTEL("HotelPost"),
    @XmlEnumValue("Apartment")
    APARTMENT("Apartment"),
    @XmlEnumValue("Villa")
    VILLA("Villa");
    private final String value;

    AccommodationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccommodationType fromValue(String v) {
        for (AccommodationType c: AccommodationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
