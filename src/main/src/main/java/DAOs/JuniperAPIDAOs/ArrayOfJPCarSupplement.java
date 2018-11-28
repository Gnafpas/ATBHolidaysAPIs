
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_CarSupplement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_CarSupplement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CarSupplement" type="{http://www.juniper.es/webservice/2007/}JP_CarSupplement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_CarSupplement", propOrder = {
    "carSupplement"
})
public class ArrayOfJPCarSupplement {

    @XmlElement(name = "CarSupplement")
    protected List<JPCarSupplement> carSupplement;

    /**
     * Gets the value of the carSupplement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the carSupplement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCarSupplement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPCarSupplement }
     * 
     * 
     */
    public List<JPCarSupplement> getCarSupplement() {
        if (carSupplement == null) {
            carSupplement = new ArrayList<JPCarSupplement>();
        }
        return this.carSupplement;
    }

}
