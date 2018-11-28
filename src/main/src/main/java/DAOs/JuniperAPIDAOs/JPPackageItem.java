
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_PackageItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BaseItem">
 *       &lt;sequence>
 *         &lt;element name="PackageInfo" type="{http://www.juniper.es/webservice/2007/}JP_PackageInfo" minOccurs="0"/>
 *         &lt;element name="Stays" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageStay" minOccurs="0"/>
 *         &lt;element name="AdditionalElements" type="{http://www.juniper.es/webservice/2007/}JP_PackageAdditionalElements" minOccurs="0"/>
 *         &lt;element name="CancellationPolicy" type="{http://www.juniper.es/webservice/2007/}JP_CancellationPolicyRules" minOccurs="0" form="unqualified"/>
 *         &lt;element name="RelPaxes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RelPax" minOccurs="0"/>
 *         &lt;element name="AFIPInformation" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageInfoAFIPAmount" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Start" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="End" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageItem", propOrder = {
    "rest"
})
public class JPPackageItem
    extends JPBaseItem
{

    @XmlElementRefs({
        @XmlElementRef(name = "PackageInfo", namespace = "http://www.juniper.es/webservice/2007/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AdditionalElements", namespace = "http://www.juniper.es/webservice/2007/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CancellationPolicy", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AFIPInformation", namespace = "http://www.juniper.es/webservice/2007/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RelPaxes", namespace = "http://www.juniper.es/webservice/2007/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Stays", namespace = "http://www.juniper.es/webservice/2007/", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;
    @XmlAttribute(name = "Start", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "End", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;
    @XmlAttribute(name = "Code")
    protected String code;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "CancellationPolicy" is used by two different parts of a schema. See: 
     * line 1725 of http://xml2.bookingengine.es/WebService/JP/WebServiceJP.asmx?WSDL
     * line 1468 of http://xml2.bookingengine.es/WebService/JP/WebServiceJP.asmx?WSDL
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the rest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ArrayOfJPRelPax }{@code >}
     * {@link JAXBElement }{@code <}{@link ArrayOfJPPackageStay }{@code >}
     * {@link JAXBElement }{@code <}{@link JPPackageInfo }{@code >}
     * {@link JAXBElement }{@code <}{@link JPPackageAdditionalElements }{@code >}
     * {@link JAXBElement }{@code <}{@link JPCancellationPolicyRules }{@code >}
     * {@link JAXBElement }{@code <}{@link ArrayOfJPPackageInfoAFIPAmount }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<?>>();
        }
        return this.rest;
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

}
