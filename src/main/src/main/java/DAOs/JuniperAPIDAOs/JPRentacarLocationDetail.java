
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarLocationDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarLocationDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zone" type="{http://www.juniper.es/webservice/2007/}JP_Zone" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PhoneNumbers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PhoneNumber" minOccurs="0"/>
 *         &lt;element name="OperationSchedule" type="{http://www.juniper.es/webservice/2007/}JP_OperationSchedule" minOccurs="0"/>
 *         &lt;element name="Supplier" type="{http://www.juniper.es/webservice/2007/}JP_Supplier" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Group" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LocationType">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="A"/>
 *             &lt;enumeration value="H"/>
 *             &lt;enumeration value="P"/>
 *             &lt;enumeration value="C"/>
 *             &lt;enumeration value="S"/>
 *             &lt;enumeration value="O"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarLocationDetail", propOrder = {
    "name",
    "zone",
    "address",
    "latitude",
    "longitude",
    "phoneNumbers",
    "operationSchedule",
    "supplier"
})
public class JPRentacarLocationDetail {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Zone")
    protected JPZone zone;
    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "Latitude")
    protected String latitude;
    @XmlElement(name = "Longitude")
    protected String longitude;
    @XmlElement(name = "PhoneNumbers")
    protected ArrayOfJPPhoneNumber phoneNumbers;
    @XmlElement(name = "OperationSchedule")
    protected JPOperationSchedule operationSchedule;
    @XmlElement(name = "Supplier")
    protected JPSupplier supplier;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "Group")
    protected String group;
    @XmlAttribute(name = "LocationType")
    protected String locationType;

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
     * Gets the value of the zone property.
     * 
     * @return
     *     possible object is
     *     {@link JPZone }
     *     
     */
    public JPZone getZone() {
        return zone;
    }

    /**
     * Sets the value of the zone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPZone }
     *     
     */
    public void setZone(JPZone value) {
        this.zone = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the latitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatitude(String value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongitude(String value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the phoneNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPhoneNumber }
     *     
     */
    public ArrayOfJPPhoneNumber getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Sets the value of the phoneNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPhoneNumber }
     *     
     */
    public void setPhoneNumbers(ArrayOfJPPhoneNumber value) {
        this.phoneNumbers = value;
    }

    /**
     * Gets the value of the operationSchedule property.
     * 
     * @return
     *     possible object is
     *     {@link JPOperationSchedule }
     *     
     */
    public JPOperationSchedule getOperationSchedule() {
        return operationSchedule;
    }

    /**
     * Sets the value of the operationSchedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPOperationSchedule }
     *     
     */
    public void setOperationSchedule(JPOperationSchedule value) {
        this.operationSchedule = value;
    }

    /**
     * Gets the value of the supplier property.
     * 
     * @return
     *     possible object is
     *     {@link JPSupplier }
     *     
     */
    public JPSupplier getSupplier() {
        return supplier;
    }

    /**
     * Sets the value of the supplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSupplier }
     *     
     */
    public void setSupplier(JPSupplier value) {
        this.supplier = value;
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
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroup(String value) {
        this.group = value;
    }

    /**
     * Gets the value of the locationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationType() {
        return locationType;
    }

    /**
     * Sets the value of the locationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationType(String value) {
        this.locationType = value;
    }

}
