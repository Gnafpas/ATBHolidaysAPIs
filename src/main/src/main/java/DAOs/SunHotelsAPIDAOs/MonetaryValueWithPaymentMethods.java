
package DAOs.SunHotelsAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MonetaryValueWithPaymentMethods complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MonetaryValueWithPaymentMethods">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://xml.sunhotels.net/15/>MonetaryValue">
 *       &lt;attribute name="paymentMethods" use="required">
 *         &lt;simpleType>
 *           &lt;list itemType="{http://www.w3.org/2001/XMLSchema}int" />
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MonetaryValueWithPaymentMethods")
@XmlSeeAlso({
    DiscountAmountWithPaymentMethods.class,
    PriceWithPaymentMethods.class
})
public class MonetaryValueWithPaymentMethods
    extends MonetaryValue
{

    @XmlAttribute(name = "paymentMethods", required = true)
    protected List<Integer> paymentMethods;

    /**
     * Gets the value of the paymentMethods property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentMethods property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentMethods().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getPaymentMethods() {
        if (paymentMethods == null) {
            paymentMethods = new ArrayList<Integer>();
        }
        return this.paymentMethods;
    }

}
