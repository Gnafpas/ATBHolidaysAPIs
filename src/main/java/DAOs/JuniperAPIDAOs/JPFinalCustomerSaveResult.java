
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_FinalCustomerSaveResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FinalCustomerSaveResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Errors" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ErrorType" minOccurs="0"/>
 *         &lt;element name="Warnings" type="{http://www.juniper.es/webservice/2007/}JP_Warnings" minOccurs="0"/>
 *         &lt;element name="FinalCustomer" type="{http://www.juniper.es/webservice/2007/}JP_FinalCustomerData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Url" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="IntCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FinalCustomerSaveResult", propOrder = {
    "errors",
    "warnings",
    "finalCustomer"
})
public class JPFinalCustomerSaveResult {

    @XmlElement(name = "Errors")
    protected ArrayOfJPErrorType errors;
    @XmlElement(name = "Warnings")
    protected JPWarnings warnings;
    @XmlElement(name = "FinalCustomer")
    protected List<JPFinalCustomerData> finalCustomer;
    @XmlAttribute(name = "Url")
    protected String url;
    @XmlAttribute(name = "TimeStamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp;
    @XmlAttribute(name = "IntCode")
    protected String intCode;

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPErrorType }
     *     
     */
    public ArrayOfJPErrorType getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPErrorType }
     *     
     */
    public void setErrors(ArrayOfJPErrorType value) {
        this.errors = value;
    }

    /**
     * Gets the value of the warnings property.
     * 
     * @return
     *     possible object is
     *     {@link JPWarnings }
     *     
     */
    public JPWarnings getWarnings() {
        return warnings;
    }

    /**
     * Sets the value of the warnings property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPWarnings }
     *     
     */
    public void setWarnings(JPWarnings value) {
        this.warnings = value;
    }

    /**
     * Gets the value of the finalCustomer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the finalCustomer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFinalCustomer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPFinalCustomerData }
     * 
     * 
     */
    public List<JPFinalCustomerData> getFinalCustomer() {
        if (finalCustomer == null) {
            finalCustomer = new ArrayList<JPFinalCustomerData>();
        }
        return this.finalCustomer;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the timeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeStamp(XMLGregorianCalendar value) {
        this.timeStamp = value;
    }

    /**
     * Gets the value of the intCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntCode() {
        return intCode;
    }

    /**
     * Sets the value of the intCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntCode(String value) {
        this.intCode = value;
    }

}
