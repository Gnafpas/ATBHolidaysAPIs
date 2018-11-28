
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for JP_ResidentDiscount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ResidentDiscount">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Municipality" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ResidentDiscount", propOrder = {
    "value"
})
public class JPResidentDiscount {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "Type")
    protected String type;
    @XmlAttribute(name = "Municipality")
    protected String municipality;

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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the municipality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMunicipality() {
        return municipality;
    }

    /**
     * Sets the value of the municipality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMunicipality(String value) {
        this.municipality = value;
    }

}
