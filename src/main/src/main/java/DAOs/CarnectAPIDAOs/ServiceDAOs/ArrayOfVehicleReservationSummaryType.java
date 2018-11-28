
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleReservationSummaryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleReservationSummaryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VehResSummary" type="{http://www.opentravel.org/OTA/2003/05}VehicleReservationSummaryType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVehicleReservationSummaryType", propOrder = {
    "vehResSummary"
})
public class ArrayOfVehicleReservationSummaryType {

    @XmlElement(name = "VehResSummary")
    protected List<VehicleReservationSummaryType> vehResSummary;

    /**
     * Gets the value of the vehResSummary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehResSummary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehResSummary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleReservationSummaryType }
     * 
     * 
     */
    public List<VehicleReservationSummaryType> getVehResSummary() {
        if (vehResSummary == null) {
            vehResSummary = new ArrayList<VehicleReservationSummaryType>();
        }
        return this.vehResSummary;
    }

}
