
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_IdTypeIntName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_IdTypeIntName">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JPSOAP_IdName">
 *       &lt;attribute name="TypeCode" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_IdTypeIntName")
public class JPSOAPIdTypeIntName
    extends JPSOAPIdName
{

    @XmlAttribute(name = "TypeCode")
    protected Integer typeCode;
    @XmlAttribute(name = "Type")
    protected String type;

    /**
     * Gets the value of the typeCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTypeCode() {
        return typeCode;
    }

    /**
     * Sets the value of the typeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTypeCode(Integer value) {
        this.typeCode = value;
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

}
