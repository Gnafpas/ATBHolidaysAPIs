
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_InsuranceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_InsuranceInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Descriptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Description" minOccurs="0"/>
 *         &lt;element name="Images" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ImageLong" minOccurs="0"/>
 *         &lt;element name="Coverages" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Coverage" minOccurs="0"/>
 *         &lt;element name="EmergencyContact" type="{http://www.juniper.es/webservice/2007/}JP_EmergencyContact" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_InsuranceInfo", propOrder = {
    "name",
    "descriptions",
    "images",
    "coverages",
    "emergencyContact"
})
public class JPInsuranceInfo {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Descriptions")
    protected ArrayOfJPDescription descriptions;
    @XmlElement(name = "Images")
    protected ArrayOfJPImageLong images;
    @XmlElement(name = "Coverages")
    protected ArrayOfJPCoverage coverages;
    @XmlElement(name = "EmergencyContact")
    protected JPEmergencyContact emergencyContact;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the descriptions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPDescription }
     *     
     */
    public ArrayOfJPDescription getDescriptions() {
        return descriptions;
    }

    /**
     * Sets the value of the descriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPDescription }
     *     
     */
    public void setDescriptions(ArrayOfJPDescription value) {
        this.descriptions = value;
    }

    /**
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPImageLong }
     *     
     */
    public ArrayOfJPImageLong getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPImageLong }
     *     
     */
    public void setImages(ArrayOfJPImageLong value) {
        this.images = value;
    }

    /**
     * Gets the value of the coverages property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCoverage }
     *     
     */
    public ArrayOfJPCoverage getCoverages() {
        return coverages;
    }

    /**
     * Sets the value of the coverages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCoverage }
     *     
     */
    public void setCoverages(ArrayOfJPCoverage value) {
        this.coverages = value;
    }

    /**
     * Gets the value of the emergencyContact property.
     * 
     * @return
     *     possible object is
     *     {@link JPEmergencyContact }
     *     
     */
    public JPEmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    /**
     * Sets the value of the emergencyContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPEmergencyContact }
     *     
     */
    public void setEmergencyContact(JPEmergencyContact value) {
        this.emergencyContact = value;
    }

}
