
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleLocationLiabilitiesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleLocationLiabilitiesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Coverages" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationLiabilitiesTypeCoverage" minOccurs="0"/>
 *         &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleLocationLiabilitiesType", propOrder = {
    "coverages",
    "info",
    "tpaExtensions"
})
public class VehicleLocationLiabilitiesType {

    @XmlElement(name = "Coverages")
    protected ArrayOfVehicleLocationLiabilitiesTypeCoverage coverages;
    @XmlElement(name = "Info")
    protected FormattedTextType info;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;

    /**
     * Gets the value of the coverages property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleLocationLiabilitiesTypeCoverage }
     *     
     */
    public ArrayOfVehicleLocationLiabilitiesTypeCoverage getCoverages() {
        return coverages;
    }

    /**
     * Sets the value of the coverages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleLocationLiabilitiesTypeCoverage }
     *     
     */
    public void setCoverages(ArrayOfVehicleLocationLiabilitiesTypeCoverage value) {
        this.coverages = value;
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link FormattedTextType }
     *     
     */
    public FormattedTextType getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormattedTextType }
     *     
     */
    public void setInfo(FormattedTextType value) {
        this.info = value;
    }

    /**
     * Gets the value of the tpaExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType }
     *     
     */
    public TPAExtensionsType getTPAExtensions() {
        return tpaExtensions;
    }

    /**
     * Sets the value of the tpaExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType }
     *     
     */
    public void setTPAExtensions(TPAExtensionsType value) {
        this.tpaExtensions = value;
    }

}
