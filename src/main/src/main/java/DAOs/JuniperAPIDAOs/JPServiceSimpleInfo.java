
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ServiceSimpleInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ServiceSimpleInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Option" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ServiceOption" minOccurs="0"/>
 *         &lt;element name="Zones" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Zone" minOccurs="0"/>
 *         &lt;element name="Origins" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Origin" minOccurs="0"/>
 *         &lt;element name="Destinations" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Destination" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ServiceSimpleInfo", propOrder = {
    "name",
    "options",
    "zones",
    "origins",
    "destinations"
})
public class JPServiceSimpleInfo {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Option")
    protected ArrayOfJPServiceOption options;
    @XmlElement(name = "Zones")
    protected ArrayOfJPZone zones;
    @XmlElement(name = "Origins")
    protected ArrayOfJPOrigin origins;
    @XmlElement(name = "Destinations")
    protected ArrayOfJPDestination destinations;
    @XmlAttribute(name = "Code")
    protected String code;

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
     * Gets the value of the options property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPServiceOption }
     *     
     */
    public ArrayOfJPServiceOption getOptions() {
        return options;
    }

    /**
     * Sets the value of the options property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPServiceOption }
     *     
     */
    public void setOptions(ArrayOfJPServiceOption value) {
        this.options = value;
    }

    /**
     * Gets the value of the zones property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPZone }
     *     
     */
    public ArrayOfJPZone getZones() {
        return zones;
    }

    /**
     * Sets the value of the zones property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPZone }
     *     
     */
    public void setZones(ArrayOfJPZone value) {
        this.zones = value;
    }

    /**
     * Gets the value of the origins property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPOrigin }
     *     
     */
    public ArrayOfJPOrigin getOrigins() {
        return origins;
    }

    /**
     * Sets the value of the origins property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPOrigin }
     *     
     */
    public void setOrigins(ArrayOfJPOrigin value) {
        this.origins = value;
    }

    /**
     * Gets the value of the destinations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPDestination }
     *     
     */
    public ArrayOfJPDestination getDestinations() {
        return destinations;
    }

    /**
     * Sets the value of the destinations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPDestination }
     *     
     */
    public void setDestinations(ArrayOfJPDestination value) {
        this.destinations = value;
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

}
