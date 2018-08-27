
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_BaseAdvancedOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_BaseAdvancedOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_BaseAdvancedOptions")
@XmlSeeAlso({
    JPCancelAdvancedOptions.class,
    JPReadAdvancedOptions.class,
    JPModifyAdvancedOptions.class,
    JPBookingRulesAdvancedOptions.class,
    JPAvailAdvancedOptions.class,
    JPBookingAdvancedOptions.class,
    JPBookingListAdvancedOptions.class,
    JPCheckAvailAdvancedOptions.class
})
public abstract class JPBaseAdvancedOptions {


}
