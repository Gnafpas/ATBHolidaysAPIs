
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_SearchSegmentRentacarRules complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentRentacarRules">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentBase">
 *       &lt;sequence>
 *         &lt;element name="CountryOfResidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AgeDriver" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Hour" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="HourEnd" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="PickUpCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DropOffCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AcrissCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ProductID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentRentacarRules", propOrder = {
    "countryOfResidence",
    "ageDriver"
})
public class JPSearchSegmentRentacarRules
    extends JPSearchSegmentBase
{

    @XmlElement(name = "CountryOfResidence")
    protected String countryOfResidence;
    @XmlElement(name = "AgeDriver")
    protected int ageDriver;
    @XmlAttribute(name = "Hour")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar hour;
    @XmlAttribute(name = "HourEnd")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar hourEnd;
    @XmlAttribute(name = "PickUpCode")
    protected String pickUpCode;
    @XmlAttribute(name = "DropOffCode")
    protected String dropOffCode;
    @XmlAttribute(name = "AcrissCode")
    protected String acrissCode;
    @XmlAttribute(name = "ProductID")
    protected String productID;

    /**
     * Gets the value of the countryOfResidence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    /**
     * Sets the value of the countryOfResidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfResidence(String value) {
        this.countryOfResidence = value;
    }

    /**
     * Gets the value of the ageDriver property.
     * 
     */
    public int getAgeDriver() {
        return ageDriver;
    }

    /**
     * Sets the value of the ageDriver property.
     * 
     */
    public void setAgeDriver(int value) {
        this.ageDriver = value;
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
     * Gets the value of the pickUpCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPickUpCode() {
        return pickUpCode;
    }

    /**
     * Sets the value of the pickUpCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPickUpCode(String value) {
        this.pickUpCode = value;
    }

    /**
     * Gets the value of the dropOffCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDropOffCode() {
        return dropOffCode;
    }

    /**
     * Sets the value of the dropOffCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDropOffCode(String value) {
        this.dropOffCode = value;
    }

    /**
     * Gets the value of the acrissCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcrissCode() {
        return acrissCode;
    }

    /**
     * Sets the value of the acrissCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcrissCode(String value) {
        this.acrissCode = value;
    }

    /**
     * Gets the value of the productID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductID() {
        return productID;
    }

    /**
     * Sets the value of the productID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductID(String value) {
        this.productID = value;
    }

}
