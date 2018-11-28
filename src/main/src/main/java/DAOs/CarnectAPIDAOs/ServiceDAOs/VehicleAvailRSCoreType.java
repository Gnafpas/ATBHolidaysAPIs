
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleAvailRSCoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleAvailRSCoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VehRentalCore" type="{http://www.opentravel.org/OTA/2003/05}VehicleRentalCoreType" minOccurs="0"/>
 *         &lt;element name="VehVendorAvails" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleVendorAvailabilityType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleAvailRSCoreType", propOrder = {
    "vehRentalCore",
    "vehVendorAvails"
})
public class VehicleAvailRSCoreType {

    @XmlElement(name = "VehRentalCore")
    protected VehicleRentalCoreType vehRentalCore;
    @XmlElement(name = "VehVendorAvails")
    protected ArrayOfVehicleVendorAvailabilityType vehVendorAvails;

    /**
     * Gets the value of the vehRentalCore property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleRentalCoreType }
     *     
     */
    public VehicleRentalCoreType getVehRentalCore() {
        return vehRentalCore;
    }

    /**
     * Sets the value of the vehRentalCore property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleRentalCoreType }
     *     
     */
    public void setVehRentalCore(VehicleRentalCoreType value) {
        this.vehRentalCore = value;
    }

    /**
     * Gets the value of the vehVendorAvails property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleVendorAvailabilityType }
     *     
     */
    public ArrayOfVehicleVendorAvailabilityType getVehVendorAvails() {
        return vehVendorAvails;
    }

    /**
     * Sets the value of the vehVendorAvails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleVendorAvailabilityType }
     *     
     */
    public void setVehVendorAvails(ArrayOfVehicleVendorAvailabilityType value) {
        this.vehVendorAvails = value;
    }

}
