
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OtaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OtaResponse">
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
@XmlType(name = "OtaResponse")
@XmlSeeAlso({
    VehAvailRateRS.class,
    VehRateRuleRS.class,
    VehCancelResRS.class,
    VehModifyRS.class,
    VehLocationSearchRS.class,
    VehResRS.class,
    PingRS.class,
    VehRetResRS.class,
    VehLocDetailRS.class
})
public abstract class OtaResponse {


}
