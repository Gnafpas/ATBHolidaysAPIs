
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelInventoryContactNumberType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_HotelInventoryContactNumberType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GEN"/>
 *     &lt;enumeration value="BOOK"/>
 *     &lt;enumeration value="ADM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_HotelInventoryContactNumberType")
@XmlEnum
public enum JPSOAPHotelInventoryContactNumberType {

    GEN,
    BOOK,
    ADM;

    public String value() {
        return name();
    }

    public static JPSOAPHotelInventoryContactNumberType fromValue(String v) {
        return valueOf(v);
    }

}
