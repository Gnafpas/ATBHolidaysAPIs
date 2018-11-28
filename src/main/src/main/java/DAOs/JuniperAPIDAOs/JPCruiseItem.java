
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_CruiseItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BaseItem">
 *       &lt;sequence>
 *         &lt;element name="Cruise" type="{http://www.juniper.es/webservice/2007/}JP_CruiseResult" minOccurs="0"/>
 *         &lt;element name="AdditionalElements" type="{http://www.juniper.es/webservice/2007/}JP_AdditionalElements" minOccurs="0"/>
 *         &lt;element name="RelPaxesDist" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ExtendedRelPaxDist" minOccurs="0"/>
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
@XmlType(name = "JP_CruiseItem", propOrder = {
    "cruise",
    "additionalElements",
    "relPaxesDist"
})
public class JPCruiseItem
    extends JPBaseItem
{

    @XmlElement(name = "Cruise")
    protected JPCruiseResult cruise;
    @XmlElement(name = "AdditionalElements")
    protected JPAdditionalElements additionalElements;
    @XmlElement(name = "RelPaxesDist")
    protected ArrayOfJPExtendedRelPaxDist relPaxesDist;
    @XmlAttribute(name = "Start")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "End")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;

    /**
     * Gets the value of the cruise property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseResult }
     *     
     */
    public JPCruiseResult getCruise() {
        return cruise;
    }

    /**
     * Sets the value of the cruise property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseResult }
     *     
     */
    public void setCruise(JPCruiseResult value) {
        this.cruise = value;
    }

    /**
     * Gets the value of the additionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPAdditionalElements }
     *     
     */
    public JPAdditionalElements getAdditionalElements() {
        return additionalElements;
    }

    /**
     * Sets the value of the additionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPAdditionalElements }
     *     
     */
    public void setAdditionalElements(JPAdditionalElements value) {
        this.additionalElements = value;
    }

    /**
     * Gets the value of the relPaxesDist property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPExtendedRelPaxDist }
     *     
     */
    public ArrayOfJPExtendedRelPaxDist getRelPaxesDist() {
        return relPaxesDist;
    }

    /**
     * Sets the value of the relPaxesDist property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPExtendedRelPaxDist }
     *     
     */
    public void setRelPaxesDist(ArrayOfJPExtendedRelPaxDist value) {
        this.relPaxesDist = value;
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
