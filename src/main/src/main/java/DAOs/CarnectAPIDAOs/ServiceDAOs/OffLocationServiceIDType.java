
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OffLocationServiceID_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OffLocationServiceID_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CustPickUp"/>
 *     &lt;enumeration value="VehDelivery"/>
 *     &lt;enumeration value="CustDropOff"/>
 *     &lt;enumeration value="VehCollection"/>
 *     &lt;enumeration value="Exchange"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OffLocationServiceID_Type")
@XmlEnum
public enum OffLocationServiceIDType {

    @XmlEnumValue("CustPickUp")
    CUST_PICK_UP("CustPickUp"),
    @XmlEnumValue("VehDelivery")
    VEH_DELIVERY("VehDelivery"),
    @XmlEnumValue("CustDropOff")
    CUST_DROP_OFF("CustDropOff"),
    @XmlEnumValue("VehCollection")
    VEH_COLLECTION("VehCollection"),
    @XmlEnumValue("Exchange")
    EXCHANGE("Exchange");
    private final String value;

    OffLocationServiceIDType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OffLocationServiceIDType fromValue(String v) {
        for (OffLocationServiceIDType c: OffLocationServiceIDType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
