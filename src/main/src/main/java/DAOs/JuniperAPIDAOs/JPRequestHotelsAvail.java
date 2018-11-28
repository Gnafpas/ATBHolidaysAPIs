
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RequestHotelsAvail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RequestHotelsAvail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "JP_RequestHotelsAvail", propOrder = {
    "searchSegmentsHotels",
    "relPaxesDist"
})
public class JPRequestHotelsAvail {

    @XmlElement(name = "SearchSegmentsHotels")
    protected JPSearchSegmentsHotels searchSegmentsHotels;
    @XmlElement(name = "RelPaxesDist")
    protected ArrayOfJPHotelRelPaxDist relPaxesDist;

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
