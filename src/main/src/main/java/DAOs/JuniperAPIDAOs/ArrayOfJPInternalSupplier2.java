
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_InternalSupplier2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_InternalSupplier2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InternalVisaSupplier" type="{http://www.juniper.es/webservice/2007/}JP_InternalSupplier" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_InternalSupplier2", propOrder = {
    "internalVisaSupplier"
})
public class ArrayOfJPInternalSupplier2 {

    @XmlElement(name = "InternalVisaSupplier")
    protected List<JPInternalSupplier> internalVisaSupplier;

    /**
     * Gets the value of the internalVisaSupplier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the internalVisaSupplier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInternalVisaSupplier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPInternalSupplier }
     * 
     * 
     */
    public List<JPInternalSupplier> getInternalVisaSupplier() {
        if (internalVisaSupplier == null) {
            internalVisaSupplier = new ArrayList<JPInternalSupplier>();
        }
        return this.internalVisaSupplier;
    }

}
