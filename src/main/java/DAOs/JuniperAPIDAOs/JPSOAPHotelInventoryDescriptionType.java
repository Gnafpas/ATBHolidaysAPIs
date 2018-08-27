
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelInventoryDescriptionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_HotelInventoryDescriptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Short"/>
 *     &lt;enumeration value="Long"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_HotelInventoryDescriptionType")
@XmlEnum
public enum JPSOAPHotelInventoryDescriptionType {

    @XmlEnumValue("Short")
    SHORT("Short"),
    @XmlEnumValue("Long")
    LONG("Long");
    private final String value;

    JPSOAPHotelInventoryDescriptionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPHotelInventoryDescriptionType fromValue(String v) {
        for (JPSOAPHotelInventoryDescriptionType c: JPSOAPHotelInventoryDescriptionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
