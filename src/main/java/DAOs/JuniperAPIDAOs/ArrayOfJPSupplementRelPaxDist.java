
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_SupplementRelPaxDist complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_SupplementRelPaxDist">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SupplementRelPaxDist" type="{http://www.juniper.es/webservice/2007/}JP_SupplementRelPaxDist" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_SupplementRelPaxDist", propOrder = {
    "supplementRelPaxDist"
})
public class ArrayOfJPSupplementRelPaxDist {

    @XmlElement(name = "SupplementRelPaxDist")
    protected List<JPSupplementRelPaxDist> supplementRelPaxDist;

    /**
     * Gets the value of the supplementRelPaxDist property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supplementRelPaxDist property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupplementRelPaxDist().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPSupplementRelPaxDist }
     * 
     * 
     */
    public List<JPSupplementRelPaxDist> getSupplementRelPaxDist() {
        if (supplementRelPaxDist == null) {
            supplementRelPaxDist = new ArrayList<JPSupplementRelPaxDist>();
        }
        return this.supplementRelPaxDist;
    }

}
