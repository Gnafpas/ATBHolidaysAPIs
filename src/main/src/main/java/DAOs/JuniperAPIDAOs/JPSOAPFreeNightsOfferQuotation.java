
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_FreeNightsOfferQuotation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_FreeNightsOfferQuotation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Cheapest"/>
 *     &lt;enumeration value="MostExpensive"/>
 *     &lt;enumeration value="FirstNights"/>
 *     &lt;enumeration value="LastNights"/>
 *     &lt;enumeration value="CheapestPeriod"/>
 *     &lt;enumeration value="LastPeriodNights"/>
 *     &lt;enumeration value="Average"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_FreeNightsOfferQuotation")
@XmlEnum
public enum JPSOAPFreeNightsOfferQuotation {

    @XmlEnumValue("Cheapest")
    CHEAPEST("Cheapest"),
    @XmlEnumValue("MostExpensive")
    MOST_EXPENSIVE("MostExpensive"),
    @XmlEnumValue("FirstNights")
    FIRST_NIGHTS("FirstNights"),
    @XmlEnumValue("LastNights")
    LAST_NIGHTS("LastNights"),
    @XmlEnumValue("CheapestPeriod")
    CHEAPEST_PERIOD("CheapestPeriod"),
    @XmlEnumValue("LastPeriodNights")
    LAST_PERIOD_NIGHTS("LastPeriodNights"),
    @XmlEnumValue("Average")
    AVERAGE("Average");
    private final String value;

    JPSOAPFreeNightsOfferQuotation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPFreeNightsOfferQuotation fromValue(String v) {
        for (JPSOAPFreeNightsOfferQuotation c: JPSOAPFreeNightsOfferQuotation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
