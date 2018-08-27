
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_InsuranceItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_InsuranceItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BaseItem">
 *       &lt;sequence>
 *         &lt;element name="InsuranceInfo" type="{http://www.juniper.es/webservice/2007/}JP_InsuranceInfo" minOccurs="0"/>
 *         &lt;element name="RelPaxes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RelPax" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Start" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="End" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_InsuranceItem", propOrder = {
    "insuranceInfo",
    "relPaxes"
})
public class JPInsuranceItem
    extends JPBaseItem
{

    @XmlElement(name = "InsuranceInfo")
    protected JPInsuranceInfo insuranceInfo;
    @XmlElement(name = "RelPaxes")
    protected ArrayOfJPRelPax relPaxes;
    @XmlAttribute(name = "Start")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "End")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;

    /**
     * Gets the value of the insuranceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPInsuranceInfo }
     *     
     */
    public JPInsuranceInfo getInsuranceInfo() {
        return insuranceInfo;
    }

    /**
     * Sets the value of the insuranceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPInsuranceInfo }
     *     
     */
    public void setInsuranceInfo(JPInsuranceInfo value) {
        this.insuranceInfo = value;
    }

    /**
     * Gets the value of the relPaxes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRelPax }
     *     
     */
    public ArrayOfJPRelPax getRelPaxes() {
        return relPaxes;
    }

    /**
     * Sets the value of the relPaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRelPax }
     *     
     */
    public void setRelPaxes(ArrayOfJPRelPax value) {
        this.relPaxes = value;
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

}
