
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FlightRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentsFlight" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentsFlight" minOccurs="0"/>
 *         &lt;element name="RelPaxesDist" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RelPaxDist" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FlightRequest", propOrder = {
    "searchSegmentsFlight",
    "relPaxesDist"
})
public class JPFlightRequest {

    @XmlElement(name = "SearchSegmentsFlight")
    protected JPSearchSegmentsFlight searchSegmentsFlight;
    @XmlElement(name = "RelPaxesDist")
    protected ArrayOfJPRelPaxDist relPaxesDist;

    /**
     * Gets the value of the searchSegmentsFlight property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentsFlight }
     *     
     */
    public JPSearchSegmentsFlight getSearchSegmentsFlight() {
        return searchSegmentsFlight;
    }

    /**
     * Sets the value of the searchSegmentsFlight property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentsFlight }
     *     
     */
    public void setSearchSegmentsFlight(JPSearchSegmentsFlight value) {
        this.searchSegmentsFlight = value;
    }

    /**
     * Gets the value of the relPaxesDist property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRelPaxDist }
     *     
     */
    public ArrayOfJPRelPaxDist getRelPaxesDist() {
        return relPaxesDist;
    }

    /**
     * Sets the value of the relPaxesDist property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRelPaxDist }
     *     
     */
    public void setRelPaxesDist(ArrayOfJPRelPaxDist value) {
        this.relPaxesDist = value;
    }

}
