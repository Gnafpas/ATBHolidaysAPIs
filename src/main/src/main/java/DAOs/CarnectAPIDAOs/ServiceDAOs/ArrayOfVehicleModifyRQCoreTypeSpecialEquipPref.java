
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleModifyRQCoreTypeSpecialEquipPref complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleModifyRQCoreTypeSpecialEquipPref">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SpecialEquipPref" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Action" type="{http://www.opentravel.org/OTA/2003/05}ActionType" />
 *               &lt;/restriction>
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
@XmlType(name = "ArrayOfVehicleModifyRQCoreTypeSpecialEquipPref", propOrder = {
    "specialEquipPref"
})
public class ArrayOfVehicleModifyRQCoreTypeSpecialEquipPref {

    @XmlElement(name = "SpecialEquipPref")
    protected List<ArrayOfVehicleModifyRQCoreTypeSpecialEquipPref.SpecialEquipPref> specialEquipPref;

    /**
     * Gets the value of the specialEquipPref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialEquipPref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecialEquipPref().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleModifyRQCoreTypeSpecialEquipPref.SpecialEquipPref }
     * 
     * 
     */
    public List<ArrayOfVehicleModifyRQCoreTypeSpecialEquipPref.SpecialEquipPref> getSpecialEquipPref() {
        if (specialEquipPref == null) {
            specialEquipPref = new ArrayList<ArrayOfVehicleModifyRQCoreTypeSpecialEquipPref.SpecialEquipPref>();
        }
        return this.specialEquipPref;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Action" type="{http://www.opentravel.org/OTA/2003/05}ActionType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SpecialEquipPref {

        @XmlAttribute(name = "Action")
        protected ActionType action;

        /**
         * Gets the value of the action property.
         * 
         * @return
         *     possible object is
         *     {@link ActionType }
         *     
         */
        public ActionType getAction() {
            return action;
        }

        /**
         * Sets the value of the action property.
         * 
         * @param value
         *     allowed object is
         *     {@link ActionType }
         *     
         */
        public void setAction(ActionType value) {
            this.action = value;
        }

    }

}
