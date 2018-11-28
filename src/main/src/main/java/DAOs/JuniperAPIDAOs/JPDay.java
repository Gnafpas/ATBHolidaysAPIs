
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_Day complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Day">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Harbor" type="{http://www.juniper.es/webservice/2007/}JP_Harbor" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DepartureTime" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="ArrivalTime" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="Order" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="OnSea" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Day", propOrder = {
    "harbor"
})
public class JPDay {

    @XmlElement(name = "Harbor")
    protected JPHarbor harbor;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "DepartureTime")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar departureTime;
    @XmlAttribute(name = "ArrivalTime")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar arrivalTime;
    @XmlAttribute(name = "Order")
    protected Integer order;
    @XmlAttribute(name = "OnSea")
    protected Boolean onSea;

    /**
     * Gets the value of the harbor property.
     * 
     * @return
     *     possible object is
     *     {@link JPHarbor }
     *     
     */
    public JPHarbor getHarbor() {
        return harbor;
    }

    /**
     * Sets the value of the harbor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHarbor }
     *     
     */
    public void setHarbor(JPHarbor value) {
        this.harbor = value;
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
     * Gets the value of the departureTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets the value of the departureTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDepartureTime(XMLGregorianCalendar value) {
        this.departureTime = value;
    }

    /**
     * Gets the value of the arrivalTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets the value of the arrivalTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArrivalTime(XMLGregorianCalendar value) {
        this.arrivalTime = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrder(Integer value) {
        this.order = value;
    }

    /**
     * Gets the value of the onSea property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOnSea() {
        return onSea;
    }

    /**
     * Sets the value of the onSea property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOnSea(Boolean value) {
        this.onSea = value;
    }

}
