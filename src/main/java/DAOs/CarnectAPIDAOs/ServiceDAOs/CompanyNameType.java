
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for CompanyNameType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompanyNameType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="CompanyShortName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TravelSector" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Division" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Department" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyNameType", propOrder = {
    "value"
})
@XmlSeeAlso({
        VehicleAvailCoreType.Vendor.class,
        DirectBillType.CompanyName.class,
    CompanyNamePrefType.class
})
public class CompanyNameType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "CompanyShortName")
    protected String companyShortName;
    @XmlAttribute(name = "TravelSector")
    protected String travelSector;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "CodeContext")
    protected String codeContext;
    @XmlAttribute(name = "Division")
    protected String division;
    @XmlAttribute(name = "Department")
    protected String department;

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
     * Gets the value of the companyShortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyShortName() {
        return companyShortName;
    }

    /**
     * Sets the value of the companyShortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyShortName(String value) {
        this.companyShortName = value;
    }

    /**
     * Gets the value of the travelSector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelSector() {
        return travelSector;
    }

    /**
     * Sets the value of the travelSector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelSector(String value) {
        this.travelSector = value;
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
     * Gets the value of the codeContext property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeContext() {
        return codeContext;
    }

    /**
     * Sets the value of the codeContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeContext(String value) {
        this.codeContext = value;
    }

    /**
     * Gets the value of the division property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDivision() {
        return division;
    }

    /**
     * Sets the value of the division property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDivision(String value) {
        this.division = value;
    }

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartment(String value) {
        this.department = value;
    }

}
