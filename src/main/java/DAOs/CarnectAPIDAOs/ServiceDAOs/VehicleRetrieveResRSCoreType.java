
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleRetrieveResRSCoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleRetrieveResRSCoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VehReservation" type="{http://www.opentravel.org/OTA/2003/05}VehicleReservationType" minOccurs="0"/>
 *         &lt;element name="VehResSummaries" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleReservationSummaryType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleRetrieveResRSCoreType", propOrder = {
    "vehReservation",
    "vehResSummaries"
})
public class VehicleRetrieveResRSCoreType {

    @XmlElement(name = "VehReservation")
    protected VehicleReservationType vehReservation;
    @XmlElement(name = "VehResSummaries")
    protected ArrayOfVehicleReservationSummaryType vehResSummaries;

    /**
     * Gets the value of the vehReservation property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleReservationType }
     *     
     */
    public VehicleReservationType getVehReservation() {
        return vehReservation;
    }

    /**
     * Sets the value of the vehReservation property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleReservationType }
     *     
     */
    public void setVehReservation(VehicleReservationType value) {
        this.vehReservation = value;
    }

    /**
     * Gets the value of the vehResSummaries property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleReservationSummaryType }
     *     
     */
    public ArrayOfVehicleReservationSummaryType getVehResSummaries() {
        return vehResSummaries;
    }

    /**
     * Sets the value of the vehResSummaries property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleReservationSummaryType }
     *     
     */
    public void setVehResSummaries(ArrayOfVehicleReservationSummaryType value) {
        this.vehResSummaries = value;
    }

}
