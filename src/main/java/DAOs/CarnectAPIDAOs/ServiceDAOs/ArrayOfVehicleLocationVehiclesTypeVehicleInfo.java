
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleLocationVehiclesTypeVehicleInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleLocationVehiclesTypeVehicleInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VehicleInfo" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}FormattedTextType">
 *                 &lt;attribute name="Type" use="required" type="{http://www.opentravel.org/OTA/2003/05}LocationDetailVehicleInfoType" />
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
@XmlType(name = "ArrayOfVehicleLocationVehiclesTypeVehicleInfo", propOrder = {
    "vehicleInfo"
})
public class ArrayOfVehicleLocationVehiclesTypeVehicleInfo {

    @XmlElement(name = "VehicleInfo")
    protected List<ArrayOfVehicleLocationVehiclesTypeVehicleInfo.VehicleInfo> vehicleInfo;

    /**
     * Gets the value of the vehicleInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehicleInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehicleInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleLocationVehiclesTypeVehicleInfo.VehicleInfo }
     * 
     * 
     */
    public List<ArrayOfVehicleLocationVehiclesTypeVehicleInfo.VehicleInfo> getVehicleInfo() {
        if (vehicleInfo == null) {
            vehicleInfo = new ArrayList<ArrayOfVehicleLocationVehiclesTypeVehicleInfo.VehicleInfo>();
        }
        return this.vehicleInfo;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}FormattedTextType">
     *       &lt;attribute name="Type" use="required" type="{http://www.opentravel.org/OTA/2003/05}LocationDetailVehicleInfoType" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class VehicleInfo
        extends FormattedTextType
    {

        @XmlAttribute(name = "Type", required = true)
        protected LocationDetailVehicleInfoType type;

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link LocationDetailVehicleInfoType }
         *     
         */
        public LocationDetailVehicleInfoType getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link LocationDetailVehicleInfoType }
         *     
         */
        public void setType(LocationDetailVehicleInfoType value) {
            this.type = value;
        }

    }

}
