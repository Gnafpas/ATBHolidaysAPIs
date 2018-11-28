
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseSearch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseSearch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Married" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="SelectionCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseSearch")
public class JPCruiseSearch {

    @XmlAttribute(name = "Married")
    protected Boolean married;
    @XmlAttribute(name = "SelectionCode")
    protected String selectionCode;

    /**
     * Gets the value of the married property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMarried() {
        return married;
    }

    /**
     * Sets the value of the married property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMarried(Boolean value) {
        this.married = value;
    }

    /**
     * Gets the value of the selectionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelectionCode() {
        return selectionCode;
    }

    /**
     * Sets the value of the selectionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelectionCode(String value) {
        this.selectionCode = value;
    }

}
