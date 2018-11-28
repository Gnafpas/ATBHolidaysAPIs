
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_PackageInsurance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_PackageInsurance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Insurance" type="{http://www.juniper.es/webservice/2007/}JP_PackageInsurance" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_PackageInsurance", propOrder = {
    "insurance"
})
public class ArrayOfJPPackageInsurance {

    @XmlElement(name = "Insurance")
    protected List<JPPackageInsurance> insurance;

    /**
     * Gets the value of the insurance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the insurance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInsurance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPPackageInsurance }
     * 
     * 
     */
    public List<JPPackageInsurance> getInsurance() {
        if (insurance == null) {
            insurance = new ArrayList<JPPackageInsurance>();
        }
        return this.insurance;
    }

}
