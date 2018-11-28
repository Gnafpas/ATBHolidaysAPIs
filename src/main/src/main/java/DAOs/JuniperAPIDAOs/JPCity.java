
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for JP_City complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_City">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="JPDCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_City", propOrder = {
    "value"
})
public class JPCity {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "Id")
    protected String id;
    @XmlAttribute(name = "JPDCode")
    protected String jpdCode;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
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

}
