
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_FareGroupPrice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_FareGroupPrice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FareGroupPrice" type="{http://www.juniper.es/webservice/2007/}JP_FareGroupPrice" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_FareGroupPrice", propOrder = {
    "fareGroupPrice"
})
public class ArrayOfJPFareGroupPrice {

    @XmlElement(name = "FareGroupPrice")
    protected List<JPFareGroupPrice> fareGroupPrice;

    /**
     * Gets the value of the fareGroupPrice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fareGroupPrice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFareGroupPrice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPFareGroupPrice }
     * 
     * 
     */
    public List<JPFareGroupPrice> getFareGroupPrice() {
        if (fareGroupPrice == null) {
            fareGroupPrice = new ArrayList<JPFareGroupPrice>();
        }
        return this.fareGroupPrice;
    }

}
