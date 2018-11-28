
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleLocationInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleLocationInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VehRentLocInfo" type="{http://www.opentravel.org/OTA/2003/05}VehicleLocationInformationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVehicleLocationInformationType", propOrder = {
    "vehRentLocInfo"
})
public class ArrayOfVehicleLocationInformationType {

    @XmlElement(name = "VehRentLocInfo")
    protected List<VehicleLocationInformationType> vehRentLocInfo;

    /**
     * Gets the value of the vehRentLocInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehRentLocInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehRentLocInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleLocationInformationType }
     * 
     * 
     */
    public List<VehicleLocationInformationType> getVehRentLocInfo() {
        if (vehRentLocInfo == null) {
            vehRentLocInfo = new ArrayList<VehicleLocationInformationType>();
        }
        return this.vehRentLocInfo;
    }

}
