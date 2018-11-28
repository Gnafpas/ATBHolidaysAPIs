
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleLocationRequirementsTypeRequirementInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleLocationRequirementsTypeRequirementInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequirementInfo" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}FormattedTextType">
 *                 &lt;attribute name="Type" use="required" type="{http://www.opentravel.org/OTA/2003/05}LocationDetailRequirementInfoType" />
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
@XmlType(name = "ArrayOfVehicleLocationRequirementsTypeRequirementInfo", propOrder = {
    "requirementInfo"
})
public class ArrayOfVehicleLocationRequirementsTypeRequirementInfo {

    @XmlElement(name = "RequirementInfo")
    protected List<ArrayOfVehicleLocationRequirementsTypeRequirementInfo.RequirementInfo> requirementInfo;

    /**
     * Gets the value of the requirementInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requirementInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequirementInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleLocationRequirementsTypeRequirementInfo.RequirementInfo }
     * 
     * 
     */
    public List<ArrayOfVehicleLocationRequirementsTypeRequirementInfo.RequirementInfo> getRequirementInfo() {
        if (requirementInfo == null) {
            requirementInfo = new ArrayList<ArrayOfVehicleLocationRequirementsTypeRequirementInfo.RequirementInfo>();
        }
        return this.requirementInfo;
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
     *       &lt;attribute name="Type" use="required" type="{http://www.opentravel.org/OTA/2003/05}LocationDetailRequirementInfoType" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class RequirementInfo
        extends FormattedTextType
    {

        @XmlAttribute(name = "Type", required = true)
        protected LocationDetailRequirementInfoType type;

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link LocationDetailRequirementInfoType }
         *     
         */
        public LocationDetailRequirementInfoType getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link LocationDetailRequirementInfoType }
         *     
         */
        public void setType(LocationDetailRequirementInfoType value) {
            this.type = value;
        }

    }

}
