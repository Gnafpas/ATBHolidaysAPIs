
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJPSOAP_Allotment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJPSOAP_Allotment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Allotment" type="{http://www.juniper.es/webservice/2007/}JPSOAP_Allotment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJPSOAP_Allotment", propOrder = {
    "allotment"
})
public class ArrayOfJPSOAPAllotment {

    @XmlElement(name = "Allotment")
    protected List<JPSOAPAllotment> allotment;

    /**
     * Gets the value of the allotment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allotment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllotment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPSOAPAllotment }
     * 
     * 
     */
    public List<JPSOAPAllotment> getAllotment() {
        if (allotment == null) {
            allotment = new ArrayList<JPSOAPAllotment>();
        }
        return this.allotment;
    }

}
