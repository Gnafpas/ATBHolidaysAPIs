
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleAvailRQCoreTypeVehPref complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleAvailRQCoreTypeVehPref">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VehPref" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehiclePrefType">
 *                 &lt;attribute name="UpSellInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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
@XmlType(name = "ArrayOfVehicleAvailRQCoreTypeVehPref", propOrder = {
    "vehPref"
})
public class ArrayOfVehicleAvailRQCoreTypeVehPref {

    @XmlElement(name = "VehPref")
    protected List<ArrayOfVehicleAvailRQCoreTypeVehPref.VehPref> vehPref;

    /**
     * Gets the value of the vehPref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehPref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehPref().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleAvailRQCoreTypeVehPref.VehPref }
     * 
     * 
     */
    public List<ArrayOfVehicleAvailRQCoreTypeVehPref.VehPref> getVehPref() {
        if (vehPref == null) {
            vehPref = new ArrayList<ArrayOfVehicleAvailRQCoreTypeVehPref.VehPref>();
        }
        return this.vehPref;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehiclePrefType">
     *       &lt;attribute name="UpSellInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class VehPref
        extends VehiclePrefType
    {

        @XmlAttribute(name = "UpSellInd")
        protected Boolean upSellInd;

        /**
         * Gets the value of the upSellInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isUpSellInd() {
            return upSellInd;
        }

        /**
         * Sets the value of the upSellInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setUpSellInd(Boolean value) {
            this.upSellInd = value;
        }

    }

}
