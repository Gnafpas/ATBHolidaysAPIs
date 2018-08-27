
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_AvailResponseRS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_AvailResponseRS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Errors" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ErrorType" minOccurs="0"/>
 *         &lt;element name="Warnings" type="{http://www.juniper.es/webservice/2007/}JP_Warnings" minOccurs="0"/>
 *         &lt;element name="ExtraInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Results" type="{http://www.juniper.es/webservice/2007/}JP_Results" minOccurs="0"/>
 *         &lt;element name="OptionalDescriptions" type="{http://www.juniper.es/webservice/2007/}JP_OptionalDescriptions" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ProcessingTime" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "JP_AvailResponseRS", propOrder = {
    "errors",
    "warnings",
    "extraInfo",
    "results",
    "optionalDescriptions"
})
public class JPAvailResponseRS {

    @XmlElement(name = "Errors")
    protected ArrayOfJPErrorType errors;
    @XmlElement(name = "Warnings")
    protected JPWarnings warnings;
    @XmlElement(name = "ExtraInfo")
    protected String extraInfo;
    @XmlElement(name = "Results")
    protected JPResults results;
    @XmlElement(name = "OptionalDescriptions")
    protected JPOptionalDescriptions optionalDescriptions;
    @XmlAttribute(name = "ProcessingTime")
    protected String processingTime;
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
     * Gets the value of the extraInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtraInfo() {
        return extraInfo;
    }

    /**
     * Sets the value of the extraInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtraInfo(String value) {
        this.extraInfo = value;
    }

    /**
     * Gets the value of the results property.
     * 
     * @return
     *     possible object is
     *     {@link JPResults }
     *     
     */
    public JPResults getResults() {
        return results;
    }

    /**
     * Sets the value of the results property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPResults }
     *     
     */
    public void setResults(JPResults value) {
        this.results = value;
    }

    /**
     * Gets the value of the optionalDescriptions property.
     * 
     * @return
     *     possible object is
     *     {@link JPOptionalDescriptions }
     *     
     */
    public JPOptionalDescriptions getOptionalDescriptions() {
        return optionalDescriptions;
    }

    /**
     * Sets the value of the optionalDescriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPOptionalDescriptions }
     *     
     */
    public void setOptionalDescriptions(JPOptionalDescriptions value) {
        this.optionalDescriptions = value;
    }

    /**
     * Gets the value of the processingTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessingTime() {
        return processingTime;
    }

    /**
     * Sets the value of the processingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessingTime(String value) {
        this.processingTime = value;
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
