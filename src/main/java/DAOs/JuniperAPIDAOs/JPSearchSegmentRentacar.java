
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_SearchSegmentRentacar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentRentacar">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentBase">
 *       &lt;sequence>
 *         &lt;element name="CountryOfResidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AgeDriver" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Hour" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="HourEnd" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="CarCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CarType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CarTransmission" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CarDriveAC" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentRentacar", propOrder = {
    "countryOfResidence",
    "ageDriver"
})
public class JPSearchSegmentRentacar
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
    @XmlAttribute(name = "CarCategory")
    protected String carCategory;
    @XmlAttribute(name = "CarType")
    protected String carType;
    @XmlAttribute(name = "CarTransmission")
    protected String carTransmission;
    @XmlAttribute(name = "CarDriveAC")
    protected String carDriveAC;

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
     * Gets the value of the carCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarCategory() {
        return carCategory;
    }

    /**
     * Sets the value of the carCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarCategory(String value) {
        this.carCategory = value;
    }

    /**
     * Gets the value of the carType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarType() {
        return carType;
    }

    /**
     * Sets the value of the carType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarType(String value) {
        this.carType = value;
    }

    /**
     * Gets the value of the carTransmission property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarTransmission() {
        return carTransmission;
    }

    /**
     * Sets the value of the carTransmission property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarTransmission(String value) {
        this.carTransmission = value;
    }

    /**
     * Gets the value of the carDriveAC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarDriveAC() {
        return carDriveAC;
    }

    /**
     * Sets the value of the carDriveAC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarDriveAC(String value) {
        this.carDriveAC = value;
    }

}
