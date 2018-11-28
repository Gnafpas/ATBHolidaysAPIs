
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Zone complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Zone">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="JPDCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ParentJPDCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="IATA" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AreaType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Searchable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ParentCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Zone", propOrder = {
    "name"
})
@XmlSeeAlso({
    JPZoneInfo.class
})
public class JPZone {

    @XmlElement(name = "Name")
    protected String name;
    @XmlAttribute(name = "JPDCode")
    protected String jpdCode;
    @XmlAttribute(name = "ParentJPDCode")
    protected String parentJPDCode;
    @XmlAttribute(name = "IATA")
    protected String iata;
    @XmlAttribute(name = "AreaType")
    protected String areaType;
    @XmlAttribute(name = "Searchable")
    protected Boolean searchable;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "ParentCode")
    protected String parentCode;

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
     * Gets the value of the jpdCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJPDCode() {
        return jpdCode;
    }

    /**
     * Sets the value of the jpdCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJPDCode(String value) {
        this.jpdCode = value;
    }

    /**
     * Gets the value of the parentJPDCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentJPDCode() {
        return parentJPDCode;
    }

    /**
     * Sets the value of the parentJPDCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentJPDCode(String value) {
        this.parentJPDCode = value;
    }

    /**
     * Gets the value of the iata property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIATA() {
        return iata;
    }

    /**
     * Sets the value of the iata property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIATA(String value) {
        this.iata = value;
    }

    /**
     * Gets the value of the areaType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaType() {
        return areaType;
    }

    /**
     * Sets the value of the areaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaType(String value) {
        this.areaType = value;
    }

    /**
     * Gets the value of the searchable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSearchable() {
        return searchable;
    }

    /**
     * Sets the value of the searchable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSearchable(Boolean value) {
        this.searchable = value;
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
     * Gets the value of the parentCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * Sets the value of the parentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentCode(String value) {
        this.parentCode = value;
    }

}
