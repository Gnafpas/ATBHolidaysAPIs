
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehiclePrefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehiclePrefType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleCoreType">
 *       &lt;attribute name="TypePref" type="{http://www.opentravel.org/OTA/2003/05}PreferLevelType" />
 *       &lt;attribute name="ClassPref" type="{http://www.opentravel.org/OTA/2003/05}PreferLevelType" />
 *       &lt;attribute name="AirConditionPref" type="{http://www.opentravel.org/OTA/2003/05}PreferLevelType" />
 *       &lt;attribute name="TransmissionPref" type="{http://www.opentravel.org/OTA/2003/05}PreferLevelType" />
 *       &lt;attribute name="VendorCarType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="VehicleQty" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehiclePrefType")
@XmlSeeAlso({
        DAOs.CarnectAPIDAOs.ServiceDAOs.ArrayOfVehicleAvailRQCoreTypeVehPref.VehPref.class
})
public class VehiclePrefType
    extends VehicleCoreType
{

    @XmlAttribute(name = "TypePref")
    protected PreferLevelType typePref;
    @XmlAttribute(name = "ClassPref")
    protected PreferLevelType classPref;
    @XmlAttribute(name = "AirConditionPref")
    protected PreferLevelType airConditionPref;
    @XmlAttribute(name = "TransmissionPref")
    protected PreferLevelType transmissionPref;
    @XmlAttribute(name = "VendorCarType")
    protected String vendorCarType;
    @XmlAttribute(name = "VehicleQty")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger vehicleQty;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "CodeContext")
    protected String codeContext;

    /**
     * Gets the value of the typePref property.
     * 
     * @return
     *     possible object is
     *     {@link PreferLevelType }
     *     
     */
    public PreferLevelType getTypePref() {
        return typePref;
    }

    /**
     * Sets the value of the typePref property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreferLevelType }
     *     
     */
    public void setTypePref(PreferLevelType value) {
        this.typePref = value;
    }

    /**
     * Gets the value of the classPref property.
     * 
     * @return
     *     possible object is
     *     {@link PreferLevelType }
     *     
     */
    public PreferLevelType getClassPref() {
        return classPref;
    }

    /**
     * Sets the value of the classPref property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreferLevelType }
     *     
     */
    public void setClassPref(PreferLevelType value) {
        this.classPref = value;
    }

    /**
     * Gets the value of the airConditionPref property.
     * 
     * @return
     *     possible object is
     *     {@link PreferLevelType }
     *     
     */
    public PreferLevelType getAirConditionPref() {
        return airConditionPref;
    }

    /**
     * Sets the value of the airConditionPref property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreferLevelType }
     *     
     */
    public void setAirConditionPref(PreferLevelType value) {
        this.airConditionPref = value;
    }

    /**
     * Gets the value of the transmissionPref property.
     * 
     * @return
     *     possible object is
     *     {@link PreferLevelType }
     *     
     */
    public PreferLevelType getTransmissionPref() {
        return transmissionPref;
    }

    /**
     * Sets the value of the transmissionPref property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreferLevelType }
     *     
     */
    public void setTransmissionPref(PreferLevelType value) {
        this.transmissionPref = value;
    }

    /**
     * Gets the value of the vendorCarType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorCarType() {
        return vendorCarType;
    }

    /**
     * Sets the value of the vendorCarType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorCarType(String value) {
        this.vendorCarType = value;
    }

    /**
     * Gets the value of the vehicleQty property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVehicleQty() {
        return vehicleQty;
    }

    /**
     * Sets the value of the vehicleQty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVehicleQty(BigInteger value) {
        this.vehicleQty = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the codeContext property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeContext() {
        return codeContext;
    }

    /**
     * Sets the value of the codeContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeContext(String value) {
        this.codeContext = value;
    }

}
