
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJPSOAP_hotelRatePlanCancellationPolicyRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJPSOAP_hotelRatePlanCancellationPolicyRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rule" type="{http://www.juniper.es/webservice/2007/}JPSOAP_hotelRatePlanCancellationPolicyRule" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJPSOAP_hotelRatePlanCancellationPolicyRule", propOrder = {
    "rule"
})
public class ArrayOfJPSOAPHotelRatePlanCancellationPolicyRule {

    @XmlElement(name = "Rule")
    protected List<JPSOAPHotelRatePlanCancellationPolicyRule> rule;

    /**
     * Gets the value of the rule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPSOAPHotelRatePlanCancellationPolicyRule }
     * 
     * 
     */
    public List<JPSOAPHotelRatePlanCancellationPolicyRule> getRule() {
        if (rule == null) {
            rule = new ArrayList<JPSOAPHotelRatePlanCancellationPolicyRule>();
        }
        return this.rule;
    }

}
