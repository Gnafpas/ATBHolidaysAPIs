
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_CalculationBySeason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JPSOAP_CalculationBySeason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PerNight"/>
 *     &lt;enumeration value="PeriodWithMoreNightsApplyFirstNightPriceIfCoincidence"/>
 *     &lt;enumeration value="PeriodWithMoreNightsApplyMostExpensivePriceIfCoincidence"/>
 *     &lt;enumeration value="PeriodWithMoreNightsApplyCheapestPriceIfCoincidence"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JPSOAP_CalculationBySeason")
@XmlEnum
public enum JPSOAPCalculationBySeason {

    @XmlEnumValue("PerNight")
    PER_NIGHT("PerNight"),
    @XmlEnumValue("PeriodWithMoreNightsApplyFirstNightPriceIfCoincidence")
    PERIOD_WITH_MORE_NIGHTS_APPLY_FIRST_NIGHT_PRICE_IF_COINCIDENCE("PeriodWithMoreNightsApplyFirstNightPriceIfCoincidence"),
    @XmlEnumValue("PeriodWithMoreNightsApplyMostExpensivePriceIfCoincidence")
    PERIOD_WITH_MORE_NIGHTS_APPLY_MOST_EXPENSIVE_PRICE_IF_COINCIDENCE("PeriodWithMoreNightsApplyMostExpensivePriceIfCoincidence"),
    @XmlEnumValue("PeriodWithMoreNightsApplyCheapestPriceIfCoincidence")
    PERIOD_WITH_MORE_NIGHTS_APPLY_CHEAPEST_PRICE_IF_COINCIDENCE("PeriodWithMoreNightsApplyCheapestPriceIfCoincidence");
    private final String value;

    JPSOAPCalculationBySeason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JPSOAPCalculationBySeason fromValue(String v) {
        for (JPSOAPCalculationBySeason c: JPSOAPCalculationBySeason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
