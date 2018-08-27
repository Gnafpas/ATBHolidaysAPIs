
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FareGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FareGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FareGroupServices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_FareGroupService" minOccurs="0"/>
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
@XmlType(name = "JP_FareGroup", propOrder = {
    "name",
    "fareGroupServices"
})
public class JPFareGroup {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "FareGroupServices")
    protected ArrayOfJPFareGroupService fareGroupServices;
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
     * Gets the value of the fareGroupServices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPFareGroupService }
     *     
     */
    public ArrayOfJPFareGroupService getFareGroupServices() {
        return fareGroupServices;
    }

    /**
     * Sets the value of the fareGroupServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPFareGroupService }
     *     
     */
    public void setFareGroupServices(ArrayOfJPFareGroupService value) {
        this.fareGroupServices = value;
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
