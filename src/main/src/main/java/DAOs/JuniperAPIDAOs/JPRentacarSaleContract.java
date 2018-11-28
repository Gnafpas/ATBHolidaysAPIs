
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarSaleContract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarSaleContract">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Includes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NotIncludes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarSaleContract", propOrder = {
    "name",
    "description",
    "includes",
    "notIncludes"
})
public class JPRentacarSaleContract {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Includes")
    protected String includes;
    @XmlElement(name = "NotIncludes")
    protected String notIncludes;

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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the includes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncludes() {
        return includes;
    }

    /**
     * Sets the value of the includes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncludes(String value) {
        this.includes = value;
    }

    /**
     * Gets the value of the notIncludes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotIncludes() {
        return notIncludes;
    }

    /**
     * Sets the value of the notIncludes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotIncludes(String value) {
        this.notIncludes = value;
    }

}
