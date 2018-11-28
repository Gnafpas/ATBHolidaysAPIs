
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJPSOAP_OrderedPrice1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJPSOAP_OrderedPrice1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChildrenA" type="{http://www.juniper.es/webservice/2007/}JPSOAP_OrderedPrice" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJPSOAP_OrderedPrice1", propOrder = {
    "childrenA"
})
public class ArrayOfJPSOAPOrderedPrice1 {

    @XmlElement(name = "ChildrenA")
    protected List<JPSOAPOrderedPrice> childrenA;

    /**
     * Gets the value of the childrenA property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childrenA property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildrenA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPSOAPOrderedPrice }
     * 
     * 
     */
    public List<JPSOAPOrderedPrice> getChildrenA() {
        if (childrenA == null) {
            childrenA = new ArrayList<JPSOAPOrderedPrice>();
        }
        return this.childrenA;
    }

}
