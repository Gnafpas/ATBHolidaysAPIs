
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Vehicle" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleType">
 *                 &lt;attribute name="IncludeExclude" type="{http://www.opentravel.org/OTA/2003/05}IncludeExcludeType" />
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
@XmlType(name = "ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle", propOrder = {
    "vehicle"
})
public class ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle {

    @XmlElement(name = "Vehicle")
    protected List<ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle.Vehicle> vehicle;

    /**
     * Gets the value of the vehicle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehicle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehicle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle.Vehicle }
     * 
     * 
     */
    public List<ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle.Vehicle> getVehicle() {
        if (vehicle == null) {
            vehicle = new ArrayList<ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle.Vehicle>();
        }
        return this.vehicle;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleType">
     *       &lt;attribute name="IncludeExclude" type="{http://www.opentravel.org/OTA/2003/05}IncludeExcludeType" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Vehicle
        extends VehicleType
    {

        @XmlAttribute(name = "IncludeExclude")
        protected IncludeExcludeType includeExclude;

        /**
         * Gets the value of the includeExclude property.
         * 
         * @return
         *     possible object is
         *     {@link IncludeExcludeType }
         *     
         */
        public IncludeExcludeType getIncludeExclude() {
            return includeExclude;
        }

        /**
         * Sets the value of the includeExclude property.
         * 
         * @param value
         *     allowed object is
         *     {@link IncludeExcludeType }
         *     
         */
        public void setIncludeExclude(IncludeExcludeType value) {
            this.includeExclude = value;
        }

    }

}
