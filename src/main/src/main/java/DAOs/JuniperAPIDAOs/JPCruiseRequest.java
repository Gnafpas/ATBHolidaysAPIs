
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CruiseSearch" type="{http://www.juniper.es/webservice/2007/}JP_CruiseSearch" minOccurs="0"/>
 *         &lt;element name="SearchSegmentsCruise" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentsCruise" minOccurs="0"/>
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
@XmlType(name = "JP_CruiseRequest", propOrder = {
    "cruiseSearch",
    "searchSegmentsCruise",
    "relPaxesDist"
})
public class JPCruiseRequest {

    @XmlElement(name = "CruiseSearch")
    protected JPCruiseSearch cruiseSearch;
    @XmlElement(name = "SearchSegmentsCruise")
    protected JPSearchSegmentsCruise searchSegmentsCruise;
    @XmlElement(name = "RelPaxesDist")
    protected ArrayOfJPRelPaxDist relPaxesDist;

    /**
     * Gets the value of the cruiseSearch property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseSearch }
     *     
     */
    public JPCruiseSearch getCruiseSearch() {
        return cruiseSearch;
    }

    /**
     * Sets the value of the cruiseSearch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseSearch }
     *     
     */
    public void setCruiseSearch(JPCruiseSearch value) {
        this.cruiseSearch = value;
    }

    /**
     * Gets the value of the searchSegmentsCruise property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentsCruise }
     *     
     */
    public JPSearchSegmentsCruise getSearchSegmentsCruise() {
        return searchSegmentsCruise;
    }

    /**
     * Sets the value of the searchSegmentsCruise property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentsCruise }
     *     
     */
    public void setSearchSegmentsCruise(JPSearchSegmentsCruise value) {
        this.searchSegmentsCruise = value;
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
