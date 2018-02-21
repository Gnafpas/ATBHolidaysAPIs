
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OffLocServiceCharge" maxOccurs="unbounded" minOccurs="0">
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
@XmlType(name = "ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge", propOrder = {
    "offLocServiceCharge"
})
public class ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge {

    @XmlElement(name = "OffLocServiceCharge")
    protected List<ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge.OffLocServiceCharge> offLocServiceCharge;

    /**
     * Gets the value of the offLocServiceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offLocServiceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffLocServiceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge.OffLocServiceCharge }
     * 
     * 
     */
    public List<ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge.OffLocServiceCharge> getOffLocServiceCharge() {
        if (offLocServiceCharge == null) {
            offLocServiceCharge = new ArrayList<ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge.OffLocServiceCharge>();
        }
        return this.offLocServiceCharge;
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
    public static class OffLocServiceCharge
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
