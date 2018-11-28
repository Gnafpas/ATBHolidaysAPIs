
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelCheckAvailRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelCheckAvailRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelOption" type="{http://www.juniper.es/webservice/2007/}JP_HotelOptionRequest" minOccurs="0"/>
 *         &lt;element name="SearchSegmentsHotels" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentsHotels" minOccurs="0"/>
 *         &lt;element name="RelPaxesDist" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelRelPaxDist" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelCheckAvailRequest", propOrder = {
    "hotelOption",
    "searchSegmentsHotels",
    "relPaxesDist"
})
public class JPHotelCheckAvailRequest {

    @XmlElement(name = "HotelOption")
    protected JPHotelOptionRequest hotelOption;
    @XmlElement(name = "SearchSegmentsHotels")
    protected JPSearchSegmentsHotels searchSegmentsHotels;
    @XmlElement(name = "RelPaxesDist")
    protected ArrayOfJPHotelRelPaxDist relPaxesDist;

    /**
     * Gets the value of the hotelOption property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelOptionRequest }
     *     
     */
    public JPHotelOptionRequest getHotelOption() {
        return hotelOption;
    }

    /**
     * Sets the value of the hotelOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelOptionRequest }
     *     
     */
    public void setHotelOption(JPHotelOptionRequest value) {
        this.hotelOption = value;
    }

    /**
     * Gets the value of the searchSegmentsHotels property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentsHotels }
     *     
     */
    public JPSearchSegmentsHotels getSearchSegmentsHotels() {
        return searchSegmentsHotels;
    }

    /**
     * Sets the value of the searchSegmentsHotels property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentsHotels }
     *     
     */
    public void setSearchSegmentsHotels(JPSearchSegmentsHotels value) {
        this.searchSegmentsHotels = value;
    }

    /**
     * Gets the value of the relPaxesDist property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelRelPaxDist }
     *     
     */
    public ArrayOfJPHotelRelPaxDist getRelPaxesDist() {
        return relPaxesDist;
    }

    /**
     * Sets the value of the relPaxesDist property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelRelPaxDist }
     *     
     */
    public void setRelPaxesDist(ArrayOfJPHotelRelPaxDist value) {
        this.relPaxesDist = value;
    }

}
