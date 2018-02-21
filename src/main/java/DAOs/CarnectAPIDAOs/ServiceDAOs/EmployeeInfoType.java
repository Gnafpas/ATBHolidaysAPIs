
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for EmployeeInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EmployeeInfoType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="EmployeeId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="EmployeeLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="EmployeeTitle" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="EmployeeStatus" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmployeeInfoType", propOrder = {
    "value"
})
public class EmployeeInfoType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "EmployeeId")
    protected String employeeId;
    @XmlAttribute(name = "EmployeeLevel")
    protected String employeeLevel;
    @XmlAttribute(name = "EmployeeTitle")
    protected String employeeTitle;
    @XmlAttribute(name = "EmployeeStatus")
    protected String employeeStatus;

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
     * Gets the value of the employeeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the value of the employeeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeId(String value) {
        this.employeeId = value;
    }

    /**
     * Gets the value of the employeeLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeLevel() {
        return employeeLevel;
    }

    /**
     * Sets the value of the employeeLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeLevel(String value) {
        this.employeeLevel = value;
    }

    /**
     * Gets the value of the employeeTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeTitle() {
        return employeeTitle;
    }

    /**
     * Sets the value of the employeeTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeTitle(String value) {
        this.employeeTitle = value;
    }

    /**
     * Gets the value of the employeeStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeStatus() {
        return employeeStatus;
    }

    /**
     * Sets the value of the employeeStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeStatus(String value) {
        this.employeeStatus = value;
    }

}
