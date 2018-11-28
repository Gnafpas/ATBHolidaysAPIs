
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_DocumentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_DocumentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PAS"/>
 *     &lt;enumeration value="NIF"/>
 *     &lt;enumeration value="DNI"/>
 *     &lt;enumeration value="CIF"/>
 *     &lt;enumeration value="NIE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_DocumentType")
@XmlEnum
public enum JPDocumentType {

    PAS,
    NIF,
    DNI,
    CIF,
    NIE;

    public String value() {
        return name();
    }

    public static JPDocumentType fromValue(String v) {
        return valueOf(v);
    }

}
