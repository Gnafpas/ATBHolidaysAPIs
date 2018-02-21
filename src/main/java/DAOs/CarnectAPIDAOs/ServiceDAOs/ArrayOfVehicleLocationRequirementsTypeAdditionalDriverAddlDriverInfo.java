
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddlDriverInfo" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}FormattedTextType">
 *                 &lt;attribute name="Type" use="required" type="{http://www.opentravel.org/OTA/2003/05}LocationDetailRequirementAddlDriverInfoType" />
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
@XmlType(name = "ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo", propOrder = {
    "addlDriverInfo"
})
public class ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo {

    @XmlElement(name = "AddlDriverInfo")
    protected List<ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo.AddlDriverInfo> addlDriverInfo;

    /**
     * Gets the value of the addlDriverInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addlDriverInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddlDriverInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo.AddlDriverInfo }
     * 
     * 
     */
    public List<ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo.AddlDriverInfo> getAddlDriverInfo() {
        if (addlDriverInfo == null) {
            addlDriverInfo = new ArrayList<ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo.AddlDriverInfo>();
        }
        return this.addlDriverInfo;
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
     *       &lt;attribute name="Type" use="required" type="{http://www.opentravel.org/OTA/2003/05}LocationDetailRequirementAddlDriverInfoType" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class AddlDriverInfo
        extends FormattedTextType
    {

        @XmlAttribute(name = "Type", required = true)
        protected LocationDetailRequirementAddlDriverInfoType type;

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link LocationDetailRequirementAddlDriverInfoType }
         *     
         */
        public LocationDetailRequirementAddlDriverInfoType getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link LocationDetailRequirementAddlDriverInfoType }
         *     
         */
        public void setType(LocationDetailRequirementAddlDriverInfoType value) {
            this.type = value;
        }

    }

}
