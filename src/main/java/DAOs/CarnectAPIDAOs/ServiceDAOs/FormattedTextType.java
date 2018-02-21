
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for FormattedTextType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FormattedTextType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubSection" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextSubSectionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Title" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Language" type="{http://www.w3.org/2001/XMLSchema}language" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FormattedTextType", propOrder = {
    "subSection"
})
@XmlSeeAlso({
        DAOs.CarnectAPIDAOs.ServiceDAOs.ArrayOfVehicleLocationAdditionalDetailsTypeShuttleShuttleInfo.ShuttleInfo.class,
        DAOs.CarnectAPIDAOs.ServiceDAOs.ArrayOfVehicleLocationRequirementsTypeAgeAgeInfo.AgeInfo.class,
        DAOs.CarnectAPIDAOs.ServiceDAOs.ArrayOfVehicleLocationVehiclesTypeVehicleInfo.VehicleInfo.class,
        DAOs.CarnectAPIDAOs.ServiceDAOs.ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo.AddlDriverInfo.class,
        DAOs.CarnectAPIDAOs.ServiceDAOs.ArrayOfVehicleLocationServicesOfferedTypeOffLocationService.OffLocationService.OffLocServiceDesc.class,
    VendorMessageType.class,
        DAOs.CarnectAPIDAOs.ServiceDAOs.ArrayOfVehicleLocationRequirementsTypeRequirementInfo.RequirementInfo.class,
    VehicleLocationInformationType.class,
        DAOs.CarnectAPIDAOs.ServiceDAOs.ArrayOfVehicleLocationServicesOfferedTypeOnLocationService.OnLocationService.OnLocServiceDesc.class
})
public class FormattedTextType {

    @XmlElement(name = "SubSection")
    protected List<FormattedTextSubSectionType> subSection;
    @XmlAttribute(name = "Title")
    protected String title;
    @XmlAttribute(name = "Language")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String language;

    /**
     * Gets the value of the subSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FormattedTextSubSectionType }
     * 
     * 
     */
    public List<FormattedTextSubSectionType> getSubSection() {
        if (subSection == null) {
            subSection = new ArrayList<FormattedTextSubSectionType>();
        }
        return this.subSection;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

}
