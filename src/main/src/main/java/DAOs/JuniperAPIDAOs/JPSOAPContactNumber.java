
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_ContactNumber complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_ContactNumber">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.juniper.es/webservice/2007/>JPSOAP_Email">
 *       &lt;attribute name="Int" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Area" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_ContactNumber")
public class JPSOAPContactNumber
    extends JPSOAPEmail
{

    @XmlAttribute(name = "Int")
    protected String _int;
    @XmlAttribute(name = "Area")
    protected String area;

    /**
     * Gets the value of the int property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInt() {
        return _int;
    }

    /**
     * Sets the value of the int property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInt(String value) {
        this._int = value;
    }

    /**
     * Gets the value of the area property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArea() {
        return area;
    }

    /**
     * Sets the value of the area property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArea(String value) {
        this.area = value;
    }

}
