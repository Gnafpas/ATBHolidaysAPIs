
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ServiceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ServiceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentsServices" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentsServices" minOccurs="0"/>
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
@XmlType(name = "JP_ServiceRequest", propOrder = {
    "searchSegmentsServices",
    "relPaxesDist"
})
public class JPServiceRequest {

    @XmlElement(name = "SearchSegmentsServices")
    protected JPSearchSegmentsServices searchSegmentsServices;
    @XmlElement(name = "RelPaxesDist")
    protected ArrayOfJPRelPaxDist relPaxesDist;

    /**
     * Gets the value of the searchSegmentsServices property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentsServices }
     *     
     */
    public JPSearchSegmentsServices getSearchSegmentsServices() {
        return searchSegmentsServices;
    }

    /**
     * Sets the value of the searchSegmentsServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentsServices }
     *     
     */
    public void setSearchSegmentsServices(JPSearchSegmentsServices value) {
        this.searchSegmentsServices = value;
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
