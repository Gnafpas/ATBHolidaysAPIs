
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EquipCharge" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType">
 *                 &lt;sequence>
 *                   &lt;element name="Vehicles" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleCoreType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge", propOrder = {
    "equipCharge"
})
public class ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge {

    @XmlElement(name = "EquipCharge")
    protected List<ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge.EquipCharge> equipCharge;

    /**
     * Gets the value of the equipCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the equipCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEquipCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge.EquipCharge }
     * 
     * 
     */
    public List<ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge.EquipCharge> getEquipCharge() {
        if (equipCharge == null) {
            equipCharge = new ArrayList<ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge.EquipCharge>();
        }
        return this.equipCharge;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType">
     *       &lt;sequence>
     *         &lt;element name="Vehicles" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleCoreType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "vehicles"
    })
    public static class EquipCharge
        extends VehicleChargeType
    {

        @XmlElement(name = "Vehicles")
        protected ArrayOfVehicleCoreType vehicles;

        /**
         * Gets the value of the vehicles property.
         * 
         * @return
         *     possible object is
         *     {@link ArrayOfVehicleCoreType }
         *     
         */
        public ArrayOfVehicleCoreType getVehicles() {
            return vehicles;
        }

        /**
         * Sets the value of the vehicles property.
         * 
         * @param value
         *     allowed object is
         *     {@link ArrayOfVehicleCoreType }
         *     
         */
        public void setVehicles(ArrayOfVehicleCoreType value) {
            this.vehicles = value;
        }

    }

}
