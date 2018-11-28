
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelDistanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HotelDistanceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hotelDistanceTypeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distances" type="{http://xml.sunhotels.net/15/}ArrayOfHotelDistance" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelDistanceType", propOrder = {
    "hotelDistanceTypeId",
    "description",
    "distances"
})
public class HotelDistanceType {

    protected int hotelDistanceTypeId;
    protected String description;
    protected ArrayOfHotelDistance distances;

    /**
     * Gets the value of the hotelDistanceTypeId property.
     * 
     */
    public int getHotelDistanceTypeId() {
        return hotelDistanceTypeId;
    }

    /**
     * Sets the value of the hotelDistanceTypeId property.
     * 
     */
    public void setHotelDistanceTypeId(int value) {
        this.hotelDistanceTypeId = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the distances property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHotelDistance }
     *     
     */
    public ArrayOfHotelDistance getDistances() {
        return distances;
    }

    /**
     * Sets the value of the distances property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHotelDistance }
     *     
     */
    public void setDistances(ArrayOfHotelDistance value) {
        this.distances = value;
    }

}
