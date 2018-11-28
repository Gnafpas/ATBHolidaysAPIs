
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
 * <p>Java class for JP_AgencyList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_AgencyList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AgencyData" type="{http://www.juniper.es/webservice/2007/}JP_AgencyStaticData" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "JP_AgencyList", propOrder = {
    "agencyData"
})
public class JPAgencyList {

    @XmlElement(name = "AgencyData")
    protected List<JPAgencyStaticData> agencyData;
    @XmlAttribute(name = "Url")
    protected String url;
    @XmlAttribute(name = "TimeStamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp;
    @XmlAttribute(name = "IntCode")
    protected String intCode;

    /**
     * Gets the value of the agencyData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the agencyData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAgencyData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPAgencyStaticData }
     * 
     * 
     */
    public List<JPAgencyStaticData> getAgencyData() {
        if (agencyData == null) {
            agencyData = new ArrayList<JPAgencyStaticData>();
        }
        return this.agencyData;
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
