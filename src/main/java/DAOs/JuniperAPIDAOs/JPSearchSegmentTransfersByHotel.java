
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_SearchSegmentTransfersByHotel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentTransfersByHotel">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentBase">
 *       &lt;sequence>
 *         &lt;element name="Suppliers" type="{http://www.juniper.es/webservice/2007/}ArrayOfString5" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Hour" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="HourEnd" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Route" type="{http://www.juniper.es/webservice/2007/}JP_RouteType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentTransfersByHotel", propOrder = {
    "suppliers"
})
public class JPSearchSegmentTransfersByHotel
    extends JPSearchSegmentBase
{

    @XmlElement(name = "Suppliers")
    protected ArrayOfString5 suppliers;
    @XmlAttribute(name = "HotelCode")
    protected String hotelCode;
    @XmlAttribute(name = "Hour")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar hour;
    @XmlAttribute(name = "HourEnd")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar hourEnd;
    @XmlAttribute(name = "Type")
    protected Integer type;
    @XmlAttribute(name = "Route")
    protected JPRouteType route;

    /**
     * Gets the value of the suppliers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString5 }
     *     
     */
    public ArrayOfString5 getSuppliers() {
        return suppliers;
    }

    /**
     * Sets the value of the suppliers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString5 }
     *     
     */
    public void setSuppliers(ArrayOfString5 value) {
        this.suppliers = value;
    }

    /**
     * Gets the value of the hotelCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCode() {
        return hotelCode;
    }

    /**
     * Sets the value of the hotelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCode(String value) {
        this.hotelCode = value;
    }

    /**
     * Gets the value of the hour property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHour() {
        return hour;
    }

    /**
     * Sets the value of the hour property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHour(XMLGregorianCalendar value) {
        this.hour = value;
    }

    /**
     * Gets the value of the hourEnd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHourEnd() {
        return hourEnd;
    }

    /**
     * Sets the value of the hourEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHourEnd(XMLGregorianCalendar value) {
        this.hourEnd = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setType(Integer value) {
        this.type = value;
    }

    /**
     * Gets the value of the route property.
     * 
     * @return
     *     possible object is
     *     {@link JPRouteType }
     *     
     */
    public JPRouteType getRoute() {
        return route;
    }

    /**
     * Sets the value of the route property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRouteType }
     *     
     */
    public void setRoute(JPRouteType value) {
        this.route = value;
    }

}
