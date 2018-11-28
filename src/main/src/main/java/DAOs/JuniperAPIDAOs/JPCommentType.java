
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CommentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JP_CommentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HOT"/>
 *     &lt;enumeration value="SUP"/>
 *     &lt;enumeration value="CHKAV"/>
 *     &lt;enumeration value="RES"/>
 *     &lt;enumeration value="INT"/>
 *     &lt;enumeration value="ESP"/>
 *     &lt;enumeration value="ELE"/>
 *     &lt;enumeration value="OTHER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JP_CommentType")
@XmlEnum
public enum JPCommentType {

    HOT,
    SUP,
    CHKAV,
    RES,
    INT,
    ESP,
    ELE,
    OTHER;

    public String value() {
        return name();
    }

    public static JPCommentType fromValue(String v) {
        return valueOf(v);
    }

}
