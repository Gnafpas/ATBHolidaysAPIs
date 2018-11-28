
package DAOs.SunHotelsAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHotelDistanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHotelDistanceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="distanceType" type="{http://xml.sunhotels.net/15/}HotelDistanceType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHotelDistanceType", propOrder = {
    "distanceType"
})
public class ArrayOfHotelDistanceType {

    @XmlElement(nillable = true)
    protected List<HotelDistanceType> distanceType;

    /**
     * Gets the value of the distanceType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distanceType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistanceType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HotelDistanceType }
     * 
     * 
     */
    public List<HotelDistanceType> getDistanceType() {
        if (distanceType == null) {
            distanceType = new ArrayList<HotelDistanceType>();
        }
        return this.distanceType;
    }

}
