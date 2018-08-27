
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_SpecialSupplementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_SpecialSupplementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SpecialSupplementType" type="{http://www.juniper.es/webservice/2007/}JP_SpecialSupplementType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_SpecialSupplementType", propOrder = {
    "specialSupplementType"
})
public class ArrayOfJPSpecialSupplementType {

    @XmlElement(name = "SpecialSupplementType")
    protected List<JPSpecialSupplementType> specialSupplementType;

    /**
     * Gets the value of the specialSupplementType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialSupplementType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecialSupplementType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPSpecialSupplementType }
     * 
     * 
     */
    public List<JPSpecialSupplementType> getSpecialSupplementType() {
        if (specialSupplementType == null) {
            specialSupplementType = new ArrayList<JPSpecialSupplementType>();
        }
        return this.specialSupplementType;
    }

}
