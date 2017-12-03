
package DAOs.SunHotelsAPIDAOs;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelDistance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HotelDistance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="distanceInMeters" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="placeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coordinates" type="{http://xml.sunhotels.net/15/}CoordinatePair"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelDistance", propOrder = {
    "distanceInMeters",
    "placeName",
    "coordinates"
})
public class HotelDistance {

    @XmlElement(required = true)
    protected BigDecimal distanceInMeters;
    @XmlElement(required = true, nillable = true)
    protected String placeName;
    @XmlElement(required = true, nillable = true)
    protected CoordinatePair coordinates;

    /**
     * Gets the value of the distanceInMeters property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDistanceInMeters() {
        return distanceInMeters;
    }

    /**
     * Sets the value of the distanceInMeters property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDistanceInMeters(BigDecimal value) {
        this.distanceInMeters = value;
    }

    /**
     * Gets the value of the placeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceName() {
        return placeName;
    }

    /**
     * Sets the value of the placeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceName(String value) {
        this.placeName = value;
    }

    /**
     * Gets the value of the coordinates property.
     * 
     * @return
     *     possible object is
     *     {@link CoordinatePair }
     *     
     */
    public CoordinatePair getCoordinates() {
        return coordinates;
    }

    /**
     * Sets the value of the coordinates property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordinatePair }
     *     
     */
    public void setCoordinates(CoordinatePair value) {
        this.coordinates = value;
    }

}
