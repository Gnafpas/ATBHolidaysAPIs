
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_Rule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Rule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="From" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="To" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="DateFromHour" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DateTo" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="DateToHour" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Type">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="V"/>
 *             &lt;enumeration value="R"/>
 *             &lt;enumeration value="S"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="FixedPrice" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="PercentPrice" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="FirstNightPrice" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="MostExpensiveNightPrice" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Nights" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="StayLengthFrom" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="StayLengthTo" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ApplicationTypeNights">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Average"/>
 *             &lt;enumeration value="FirstNight"/>
 *             &lt;enumeration value="MostExpensiveNight"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Rule")
public class JPRule {

    @XmlAttribute(name = "From")
    protected Integer from;
    @XmlAttribute(name = "To")
    protected Integer to;
    @XmlAttribute(name = "DateFrom")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateFrom;
    @XmlAttribute(name = "DateFromHour")
    protected String dateFromHour;
    @XmlAttribute(name = "DateTo")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateTo;
    @XmlAttribute(name = "DateToHour")
    protected String dateToHour;
    @XmlAttribute(name = "Type")
    protected String type;
    @XmlAttribute(name = "FixedPrice")
    protected Double fixedPrice;
    @XmlAttribute(name = "PercentPrice")
    protected Double percentPrice;
    @XmlAttribute(name = "FirstNightPrice")
    protected Double firstNightPrice;
    @XmlAttribute(name = "MostExpensiveNightPrice")
    protected Double mostExpensiveNightPrice;
    @XmlAttribute(name = "Nights")
    protected Integer nights;
    @XmlAttribute(name = "StayLengthFrom")
    protected Integer stayLengthFrom;
    @XmlAttribute(name = "StayLengthTo")
    protected Integer stayLengthTo;
    @XmlAttribute(name = "ApplicationTypeNights")
    protected String applicationTypeNights;

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFrom(Integer value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTo(Integer value) {
        this.to = value;
    }

    /**
     * Gets the value of the dateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFrom() {
        return dateFrom;
    }

    /**
     * Sets the value of the dateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFrom(XMLGregorianCalendar value) {
        this.dateFrom = value;
    }

    /**
     * Gets the value of the dateFromHour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateFromHour() {
        return dateFromHour;
    }

    /**
     * Sets the value of the dateFromHour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFromHour(String value) {
        this.dateFromHour = value;
    }

    /**
     * Gets the value of the dateTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTo() {
        return dateTo;
    }

    /**
     * Sets the value of the dateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTo(XMLGregorianCalendar value) {
        this.dateTo = value;
    }

    /**
     * Gets the value of the dateToHour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateToHour() {
        return dateToHour;
    }

    /**
     * Sets the value of the dateToHour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateToHour(String value) {
        this.dateToHour = value;
    }

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
     * Gets the value of the fixedPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFixedPrice() {
        return fixedPrice;
    }

    /**
     * Sets the value of the fixedPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFixedPrice(Double value) {
        this.fixedPrice = value;
    }

    /**
     * Gets the value of the percentPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentPrice() {
        return percentPrice;
    }

    /**
     * Sets the value of the percentPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentPrice(Double value) {
        this.percentPrice = value;
    }

    /**
     * Gets the value of the firstNightPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFirstNightPrice() {
        return firstNightPrice;
    }

    /**
     * Sets the value of the firstNightPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFirstNightPrice(Double value) {
        this.firstNightPrice = value;
    }

    /**
     * Gets the value of the mostExpensiveNightPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMostExpensiveNightPrice() {
        return mostExpensiveNightPrice;
    }

    /**
     * Sets the value of the mostExpensiveNightPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMostExpensiveNightPrice(Double value) {
        this.mostExpensiveNightPrice = value;
    }

    /**
     * Gets the value of the nights property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNights() {
        return nights;
    }

    /**
     * Sets the value of the nights property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNights(Integer value) {
        this.nights = value;
    }

    /**
     * Gets the value of the stayLengthFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStayLengthFrom() {
        return stayLengthFrom;
    }

    /**
     * Sets the value of the stayLengthFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStayLengthFrom(Integer value) {
        this.stayLengthFrom = value;
    }

    /**
     * Gets the value of the stayLengthTo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStayLengthTo() {
        return stayLengthTo;
    }

    /**
     * Sets the value of the stayLengthTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStayLengthTo(Integer value) {
        this.stayLengthTo = value;
    }

    /**
     * Gets the value of the applicationTypeNights property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationTypeNights() {
        return applicationTypeNights;
    }

    /**
     * Sets the value of the applicationTypeNights property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationTypeNights(String value) {
        this.applicationTypeNights = value;
    }

}
