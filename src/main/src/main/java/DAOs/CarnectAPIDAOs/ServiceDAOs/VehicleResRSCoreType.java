
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleResRSCoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleResRSCoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VehReservation" type="{http://www.opentravel.org/OTA/2003/05}VehicleReservationType" minOccurs="0"/>
 *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleResRSCoreType", propOrder = {
    "vehReservation",
    "tpaExtensions"
})
@XmlSeeAlso({
        DAOs.CarnectAPIDAOs.ServiceDAOs.VehResRS.VehResRSCore.class
})
public class VehicleResRSCoreType {

    @XmlElement(name = "VehReservation")
    protected VehicleReservationType vehReservation;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;

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
     * Gets the value of the tpaExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType }
     *     
     */
    public TPAExtensionsType getTPAExtensions() {
        return tpaExtensions;
    }

    /**
     * Sets the value of the tpaExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType }
     *     
     */
    public void setTPAExtensions(TPAExtensionsType value) {
        this.tpaExtensions = value;
    }

}
