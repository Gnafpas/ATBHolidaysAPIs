
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_VisaCheckAvailResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_VisaCheckAvailResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisaInfo" type="{http://www.juniper.es/webservice/2007/}JP_VisaInfo" minOccurs="0"/>
 *         &lt;element name="VisaOptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_VisaOption" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Start" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="End" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="DestinationZone" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Status" use="required" type="{http://www.juniper.es/webservice/2007/}JP_AvailStatus" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_VisaCheckAvailResult", propOrder = {
    "visaInfo",
    "visaOptions"
})
public class JPVisaCheckAvailResult {

    @XmlElement(name = "VisaInfo")
    protected JPVisaInfo visaInfo;
    @XmlElement(name = "VisaOptions")
    protected ArrayOfJPVisaOption visaOptions;
    @XmlAttribute(name = "Start", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "End", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;
    @XmlAttribute(name = "DestinationZone", required = true)
    protected int destinationZone;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "Status", required = true)
    protected JPAvailStatus status;

    /**
     * Gets the value of the visaInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPVisaInfo }
     *     
     */
    public JPVisaInfo getVisaInfo() {
        return visaInfo;
    }

    /**
     * Sets the value of the visaInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPVisaInfo }
     *     
     */
    public void setVisaInfo(JPVisaInfo value) {
        this.visaInfo = value;
    }

    /**
     * Gets the value of the visaOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPVisaOption }
     *     
     */
    public ArrayOfJPVisaOption getVisaOptions() {
        return visaOptions;
    }

    /**
     * Sets the value of the visaOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPVisaOption }
     *     
     */
    public void setVisaOptions(ArrayOfJPVisaOption value) {
        this.visaOptions = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStart(XMLGregorianCalendar value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnd(XMLGregorianCalendar value) {
        this.end = value;
    }

    /**
     * Gets the value of the destinationZone property.
     * 
     */
    public int getDestinationZone() {
        return destinationZone;
    }

    /**
     * Sets the value of the destinationZone property.
     * 
     */
    public void setDestinationZone(int value) {
        this.destinationZone = value;
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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JPAvailStatus }
     *     
     */
    public JPAvailStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPAvailStatus }
     *     
     */
    public void setStatus(JPAvailStatus value) {
        this.status = value;
    }

}
