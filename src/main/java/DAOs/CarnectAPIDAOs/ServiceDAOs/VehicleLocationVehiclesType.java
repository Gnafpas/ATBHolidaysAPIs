
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleLocationVehiclesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleLocationVehiclesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VehicleInfos" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationVehiclesTypeVehicleInfo" minOccurs="0"/>
 *         &lt;element name="Vehicle" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleType">
 *                 &lt;sequence>
 *                   &lt;element name="Text" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="IsConfirmableInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="DistanceUnit" type="{http://www.opentravel.org/OTA/2003/05}DistanceUnitNameType" />
 *                 &lt;attribute name="DistancePerFuelUnit" type="{http://www.w3.org/2001/XMLSchema}integer" />
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
@XmlType(name = "VehicleLocationVehiclesType", propOrder = {
    "vehicleInfos",
    "vehicle"
})
public class VehicleLocationVehiclesType {

    @XmlElement(name = "VehicleInfos")
    protected ArrayOfVehicleLocationVehiclesTypeVehicleInfo vehicleInfos;
    @XmlElement(name = "Vehicle")
    protected List<VehicleLocationVehiclesType.Vehicle> vehicle;

    /**
     * Gets the value of the vehicleInfos property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleLocationVehiclesTypeVehicleInfo }
     *     
     */
    public ArrayOfVehicleLocationVehiclesTypeVehicleInfo getVehicleInfos() {
        return vehicleInfos;
    }

    /**
     * Sets the value of the vehicleInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleLocationVehiclesTypeVehicleInfo }
     *     
     */
    public void setVehicleInfos(ArrayOfVehicleLocationVehiclesTypeVehicleInfo value) {
        this.vehicleInfos = value;
    }

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
     * {@link VehicleLocationVehiclesType.Vehicle }
     * 
     * 
     */
    public List<VehicleLocationVehiclesType.Vehicle> getVehicle() {
        if (vehicle == null) {
            vehicle = new ArrayList<VehicleLocationVehiclesType.Vehicle>();
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
     *       &lt;sequence>
     *         &lt;element name="Text" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="IsConfirmableInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="DistanceUnit" type="{http://www.opentravel.org/OTA/2003/05}DistanceUnitNameType" />
     *       &lt;attribute name="DistancePerFuelUnit" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "text"
    })
    public static class Vehicle
        extends VehicleType
    {

        @XmlElement(name = "Text")
        protected List<FormattedTextType> text;
        @XmlAttribute(name = "IsConfirmableInd")
        protected Boolean isConfirmableInd;
        @XmlAttribute(name = "DistanceUnit")
        protected DistanceUnitNameType distanceUnit;
        @XmlAttribute(name = "DistancePerFuelUnit")
        protected BigInteger distancePerFuelUnit;

        /**
         * Gets the value of the text property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the text property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getText().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FormattedTextType }
         * 
         * 
         */
        public List<FormattedTextType> getText() {
            if (text == null) {
                text = new ArrayList<FormattedTextType>();
            }
            return this.text;
        }

        /**
         * Gets the value of the isConfirmableInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsConfirmableInd() {
            return isConfirmableInd;
        }

        /**
         * Sets the value of the isConfirmableInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsConfirmableInd(Boolean value) {
            this.isConfirmableInd = value;
        }

        /**
         * Gets the value of the distanceUnit property.
         * 
         * @return
         *     possible object is
         *     {@link DistanceUnitNameType }
         *     
         */
        public DistanceUnitNameType getDistanceUnit() {
            return distanceUnit;
        }

        /**
         * Sets the value of the distanceUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link DistanceUnitNameType }
         *     
         */
        public void setDistanceUnit(DistanceUnitNameType value) {
            this.distanceUnit = value;
        }

        /**
         * Gets the value of the distancePerFuelUnit property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getDistancePerFuelUnit() {
            return distancePerFuelUnit;
        }

        /**
         * Sets the value of the distancePerFuelUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setDistancePerFuelUnit(BigInteger value) {
            this.distancePerFuelUnit = value;
        }

    }

}
