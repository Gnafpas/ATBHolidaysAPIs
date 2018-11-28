
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleLocationServicesOfferedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleLocationServicesOfferedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OnLocationServices" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationServicesOfferedTypeOnLocationService" minOccurs="0"/>
 *         &lt;element name="OffLocationServices" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationServicesOfferedTypeOffLocationService" minOccurs="0"/>
 *         &lt;element name="SpecialEquipments" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipment" minOccurs="0"/>
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
@XmlType(name = "VehicleLocationServicesOfferedType", propOrder = {
    "onLocationServices",
    "offLocationServices",
    "specialEquipments",
    "tpaExtensions"
})
public class VehicleLocationServicesOfferedType {

    @XmlElement(name = "OnLocationServices")
    protected ArrayOfVehicleLocationServicesOfferedTypeOnLocationService onLocationServices;
    @XmlElement(name = "OffLocationServices")
    protected ArrayOfVehicleLocationServicesOfferedTypeOffLocationService offLocationServices;
    @XmlElement(name = "SpecialEquipments")
    protected ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipment specialEquipments;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;

    /**
     * Gets the value of the onLocationServices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleLocationServicesOfferedTypeOnLocationService }
     *     
     */
    public ArrayOfVehicleLocationServicesOfferedTypeOnLocationService getOnLocationServices() {
        return onLocationServices;
    }

    /**
     * Sets the value of the onLocationServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleLocationServicesOfferedTypeOnLocationService }
     *     
     */
    public void setOnLocationServices(ArrayOfVehicleLocationServicesOfferedTypeOnLocationService value) {
        this.onLocationServices = value;
    }

    /**
     * Gets the value of the offLocationServices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleLocationServicesOfferedTypeOffLocationService }
     *     
     */
    public ArrayOfVehicleLocationServicesOfferedTypeOffLocationService getOffLocationServices() {
        return offLocationServices;
    }

    /**
     * Sets the value of the offLocationServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleLocationServicesOfferedTypeOffLocationService }
     *     
     */
    public void setOffLocationServices(ArrayOfVehicleLocationServicesOfferedTypeOffLocationService value) {
        this.offLocationServices = value;
    }

    /**
     * Gets the value of the specialEquipments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipment }
     *     
     */
    public ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipment getSpecialEquipments() {
        return specialEquipments;
    }

    /**
     * Sets the value of the specialEquipments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipment }
     *     
     */
    public void setSpecialEquipments(ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipment value) {
        this.specialEquipments = value;
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
