
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_WarningDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_WarningDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Dates" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_WarningDate" minOccurs="0"/>
 *         &lt;element name="DestinationZones" type="{http://www.juniper.es/webservice/2007/}ArrayOfString9" minOccurs="0"/>
 *         &lt;element name="HotelCodes" type="{http://www.juniper.es/webservice/2007/}ArrayOfString7" minOccurs="0"/>
 *         &lt;element name="Distributions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_WarningDistribution" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_WarningDetails", propOrder = {
    "dates",
    "destinationZones",
    "hotelCodes",
    "distributions"
})
public class JPWarningDetails {

    @XmlElement(name = "Dates")
    protected ArrayOfJPWarningDate dates;
    @XmlElement(name = "DestinationZones")
    protected ArrayOfString9 destinationZones;
    @XmlElement(name = "HotelCodes")
    protected ArrayOfString7 hotelCodes;
    @XmlElement(name = "Distributions")
    protected ArrayOfJPWarningDistribution distributions;

    /**
     * Gets the value of the dates property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPWarningDate }
     *     
     */
    public ArrayOfJPWarningDate getDates() {
        return dates;
    }

    /**
     * Sets the value of the dates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPWarningDate }
     *     
     */
    public void setDates(ArrayOfJPWarningDate value) {
        this.dates = value;
    }

    /**
     * Gets the value of the destinationZones property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString9 }
     *     
     */
    public ArrayOfString9 getDestinationZones() {
        return destinationZones;
    }

    /**
     * Sets the value of the destinationZones property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString9 }
     *     
     */
    public void setDestinationZones(ArrayOfString9 value) {
        this.destinationZones = value;
    }

    /**
     * Gets the value of the hotelCodes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString7 }
     *     
     */
    public ArrayOfString7 getHotelCodes() {
        return hotelCodes;
    }

    /**
     * Sets the value of the hotelCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString7 }
     *     
     */
    public void setHotelCodes(ArrayOfString7 value) {
        this.hotelCodes = value;
    }

    /**
     * Gets the value of the distributions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPWarningDistribution }
     *     
     */
    public ArrayOfJPWarningDistribution getDistributions() {
        return distributions;
    }

    /**
     * Sets the value of the distributions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPWarningDistribution }
     *     
     */
    public void setDistributions(ArrayOfJPWarningDistribution value) {
        this.distributions = value;
    }

}
