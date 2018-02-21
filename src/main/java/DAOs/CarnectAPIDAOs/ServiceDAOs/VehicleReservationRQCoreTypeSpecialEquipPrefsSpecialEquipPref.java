
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleReservationRQCoreTypeSpecialEquipPrefsSpecialEquipPref complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleReservationRQCoreTypeSpecialEquipPrefsSpecialEquipPref">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleEquipmentCoreType">
 *       &lt;attribute name="PreferLevel" type="{http://www.opentravel.org/OTA/2003/05}PreferLevelType" default="Preferred" />
 *       &lt;attribute name="Action" type="{http://www.opentravel.org/OTA/2003/05}ActionType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleReservationRQCoreTypeSpecialEquipPrefsSpecialEquipPref")
public class VehicleReservationRQCoreTypeSpecialEquipPrefsSpecialEquipPref
    extends VehicleEquipmentCoreType
{

    @XmlAttribute(name = "PreferLevel")
    protected PreferLevelType preferLevel;
    @XmlAttribute(name = "Action")
    protected ActionType action;

    /**
     * Gets the value of the preferLevel property.
     * 
     * @return
     *     possible object is
     *     {@link PreferLevelType }
     *     
     */
    public PreferLevelType getPreferLevel() {
        if (preferLevel == null) {
            return PreferLevelType.PREFERRED;
        } else {
            return preferLevel;
        }
    }

    /**
     * Sets the value of the preferLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreferLevelType }
     *     
     */
    public void setPreferLevel(PreferLevelType value) {
        this.preferLevel = value;
    }

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
