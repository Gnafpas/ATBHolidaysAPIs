
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJPSOAP_OrderedTypedPrice3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJPSOAP_OrderedTypedPrice3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Infant" type="{http://www.juniper.es/webservice/2007/}JPSOAP_OrderedTypedPrice" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJPSOAP_OrderedTypedPrice3", propOrder = {
    "infant"
})
public class ArrayOfJPSOAPOrderedTypedPrice3 {

    @XmlElement(name = "Infant")
    protected List<JPSOAPOrderedTypedPrice> infant;

    /**
     * Gets the value of the infant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPSOAPOrderedTypedPrice }
     * 
     * 
     */
    public List<JPSOAPOrderedTypedPrice> getInfant() {
        if (infant == null) {
            infant = new ArrayList<JPSOAPOrderedTypedPrice>();
        }
        return this.infant;
    }

}
