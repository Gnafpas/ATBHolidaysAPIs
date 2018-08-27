
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJPSOAP_Discount2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJPSOAP_Discount2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChildB" type="{http://www.juniper.es/webservice/2007/}JPSOAP_Discount" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJPSOAP_Discount2", propOrder = {
    "childB"
})
public class ArrayOfJPSOAPDiscount2 {

    @XmlElement(name = "ChildB")
    protected List<JPSOAPDiscount> childB;

    /**
     * Gets the value of the childB property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childB property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildB().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPSOAPDiscount }
     * 
     * 
     */
    public List<JPSOAPDiscount> getChildB() {
        if (childB == null) {
            childB = new ArrayList<JPSOAPDiscount>();
        }
        return this.childB;
    }

}
