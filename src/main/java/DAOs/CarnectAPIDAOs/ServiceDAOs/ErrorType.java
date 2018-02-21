
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ErrorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ErrorType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>FreeTextType">
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ShortText" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DocURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="Status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Tag" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RecordID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="NodeList" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErrorType")
public class ErrorType
    extends FreeTextType
{

    @XmlAttribute(name = "Type")
    protected String type;
    @XmlAttribute(name = "ShortText")
    protected String shortText;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "DocURL")
    @XmlSchemaType(name = "anyURI")
    protected String docURL;
    @XmlAttribute(name = "Status")
    protected String status;
    @XmlAttribute(name = "Tag")
    protected String tag;
    @XmlAttribute(name = "RecordID")
    protected String recordID;
    @XmlAttribute(name = "NodeList")
    protected String nodeList;

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
     * Gets the value of the shortText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortText() {
        return shortText;
    }

    /**
     * Sets the value of the shortText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortText(String value) {
        this.shortText = value;
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
     * Gets the value of the docURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocURL() {
        return docURL;
    }

    /**
     * Sets the value of the docURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocURL(String value) {
        this.docURL = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the tag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets the value of the tag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag(String value) {
        this.tag = value;
    }

    /**
     * Gets the value of the recordID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordID() {
        return recordID;
    }

    /**
     * Sets the value of the recordID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordID(String value) {
        this.recordID = value;
    }

    /**
     * Gets the value of the nodeList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNodeList() {
        return nodeList;
    }

    /**
     * Sets the value of the nodeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNodeList(String value) {
        this.nodeList = value;
    }

}
