
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleVendorAvailabilityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleVendorAvailabilityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VehVendorAvail" type="{http://www.opentravel.org/OTA/2003/05}VehicleVendorAvailabilityType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVehicleVendorAvailabilityType", propOrder = {
    "vehVendorAvail"
})
public class ArrayOfVehicleVendorAvailabilityType {

    @XmlElement(name = "VehVendorAvail")
    protected List<VehicleVendorAvailabilityType> vehVendorAvail;

    /**
     * Gets the value of the vehVendorAvail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehVendorAvail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehVendorAvail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleVendorAvailabilityType }
     * 
     * 
     */
    public List<VehicleVendorAvailabilityType> getVehVendorAvail() {
        if (vehVendorAvail == null) {
            vehVendorAvail = new ArrayList<VehicleVendorAvailabilityType>();
        }
        return this.vehVendorAvail;
    }

}
