
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PriceWithPaymentMethods complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PriceWithPaymentMethods">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://xml.sunhotels.net/15/>MonetaryValueWithPaymentMethods">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceWithPaymentMethods")
public class PriceWithPaymentMethods
    extends MonetaryValueWithPaymentMethods
{


}
