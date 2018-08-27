
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_Route complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Route">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Segments" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_FlightSegment" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Origin" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Object" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="OriginIATA" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DestinationIATA" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Date" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Route", propOrder = {
    "segments"
})
public class JPRoute {

    @XmlElement(name = "Segments")
    protected ArrayOfJPFlightSegment segments;
    @XmlAttribute(name = "Origin", required = true)
    protected int origin;
    @XmlAttribute(name = "Object", required = true)
    protected int destination;
    @XmlAttribute(name = "OriginIATA")
    protected String originIATA;
    @XmlAttribute(name = "DestinationIATA")
    protected String destinationIATA;
    @XmlAttribute(name = "Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;

    /**
     * Gets the value of the segments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPFlightSegment }
     *     
     */
    public ArrayOfJPFlightSegment getSegments() {
        return segments;
    }

    /**
     * Sets the value of the segments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPFlightSegment }
     *     
     */
    public void setSegments(ArrayOfJPFlightSegment value) {
        this.segments = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     */
    public int getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     */
    public void setOrigin(int value) {
        this.origin = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     */
    public int getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     */
    public void setDestination(int value) {
        this.destination = value;
    }

    /**
     * Gets the value of the originIATA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginIATA() {
        return originIATA;
    }

    /**
     * Sets the value of the originIATA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginIATA(String value) {
        this.originIATA = value;
    }

    /**
     * Gets the value of the destinationIATA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationIATA() {
        return destinationIATA;
    }

    /**
     * Sets the value of the destinationIATA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationIATA(String value) {
        this.destinationIATA = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

}
