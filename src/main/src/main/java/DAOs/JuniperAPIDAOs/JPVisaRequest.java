
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_VisaRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_VisaRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentsVisa" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentsVisa" minOccurs="0"/>
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
@XmlType(name = "JP_VisaRequest", propOrder = {
    "searchSegmentsVisa",
    "relPaxesDist"
})
public class JPVisaRequest {

    @XmlElement(name = "SearchSegmentsVisa")
    protected JPSearchSegmentsVisa searchSegmentsVisa;
    @XmlElement(name = "RelPaxesDist")
    protected ArrayOfJPRelPaxDist relPaxesDist;

    /**
     * Gets the value of the searchSegmentsVisa property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentsVisa }
     *     
     */
    public JPSearchSegmentsVisa getSearchSegmentsVisa() {
        return searchSegmentsVisa;
    }

    /**
     * Sets the value of the searchSegmentsVisa property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentsVisa }
     *     
     */
    public void setSearchSegmentsVisa(JPSearchSegmentsVisa value) {
        this.searchSegmentsVisa = value;
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
