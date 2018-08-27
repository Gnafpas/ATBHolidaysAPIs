
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_CruiseStarDay complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_CruiseStarDay">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StarDay" type="{http://www.juniper.es/webservice/2007/}JP_CruiseStarDay" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_CruiseStarDay", propOrder = {
    "starDay"
})
public class ArrayOfJPCruiseStarDay {

    @XmlElement(name = "StarDay")
    protected List<JPCruiseStarDay> starDay;

    /**
     * Gets the value of the starDay property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the starDay property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStarDay().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPCruiseStarDay }
     * 
     * 
     */
    public List<JPCruiseStarDay> getStarDay() {
        if (starDay == null) {
            starDay = new ArrayList<JPCruiseStarDay>();
        }
        return this.starDay;
    }

}
