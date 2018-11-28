
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_GenericCatalogueType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_GenericCatalogueType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CURRENCY"/>
 *     &lt;enumeration value="CURRENCYCONVERTER"/>
 *     &lt;enumeration value="FAMILYDISCOUNTS"/>
 *     &lt;enumeration value="DOCTYPE"/>
 *     &lt;enumeration value="CHANNEL"/>
 *     &lt;enumeration value="LANGUAGES"/>
 *     &lt;enumeration value="AGENCIES"/>
 *     &lt;enumeration value="COUNTRIES"/>
 *     &lt;enumeration value="MESSAGES"/>
 *     &lt;enumeration value="OBSERVATIONS"/>
 *     &lt;enumeration value="SEARCHZONES"/>
 *     &lt;enumeration value="CLIENTMODULES"/>
 *     &lt;enumeration value="SBQUOTATIONS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_GenericCatalogueType")
@XmlEnum
public enum JPGenericCatalogueType {

    CURRENCY,
    CURRENCYCONVERTER,
    FAMILYDISCOUNTS,
    DOCTYPE,
    CHANNEL,
    LANGUAGES,
    AGENCIES,
    COUNTRIES,
    MESSAGES,
    OBSERVATIONS,
    SEARCHZONES,
    CLIENTMODULES,
    SBQUOTATIONS;

    public String value() {
        return name();
    }

    public static JPGenericCatalogueType fromValue(String v) {
        return valueOf(v);
    }

}
