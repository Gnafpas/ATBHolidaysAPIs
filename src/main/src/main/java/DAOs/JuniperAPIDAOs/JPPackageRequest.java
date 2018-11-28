
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PackageRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentsPackages" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentsPackages" minOccurs="0"/>
 *         &lt;element name="RelPaxesDist" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RelPaxDist" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageRequest", propOrder = {
    "searchSegmentsPackages",
    "relPaxesDist"
})
public class JPPackageRequest {

    @XmlElement(name = "SearchSegmentsPackages")
    protected JPSearchSegmentsPackages searchSegmentsPackages;
    @XmlElement(name = "RelPaxesDist")
    protected ArrayOfJPRelPaxDist relPaxesDist;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;

    /**
     * Gets the value of the searchSegmentsPackages property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentsPackages }
     *     
     */
    public JPSearchSegmentsPackages getSearchSegmentsPackages() {
        return searchSegmentsPackages;
    }

    /**
     * Sets the value of the searchSegmentsPackages property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentsPackages }
     *     
     */
    public void setSearchSegmentsPackages(JPSearchSegmentsPackages value) {
        this.searchSegmentsPackages = value;
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

    /**
     * Gets the value of the ratePlanCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRatePlanCode() {
        return ratePlanCode;
    }

    /**
     * Sets the value of the ratePlanCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatePlanCode(String value) {
        this.ratePlanCode = value;
    }

}
