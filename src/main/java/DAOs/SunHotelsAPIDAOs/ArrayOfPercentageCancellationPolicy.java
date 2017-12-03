
package DAOs.SunHotelsAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPercentageCancellationPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPercentageCancellationPolicy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cancellation_policy" type="{http://xml.sunhotels.net/15/}PercentageCancellationPolicy" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPercentageCancellationPolicy", propOrder = {
    "cancellationPolicy"
})
public class ArrayOfPercentageCancellationPolicy {

    @XmlElement(name = "cancellation_policy", nillable = true)
    protected List<PercentageCancellationPolicy> cancellationPolicy;

    /**
     * Gets the value of the cancellationPolicy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cancellationPolicy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCancellationPolicy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PercentageCancellationPolicy }
     * 
     * 
     */
    public List<PercentageCancellationPolicy> getCancellationPolicy() {
        if (cancellationPolicy == null) {
            cancellationPolicy = new ArrayList<PercentageCancellationPolicy>();
        }
        return this.cancellationPolicy;
    }

}
