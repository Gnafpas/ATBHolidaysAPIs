
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RequestInsurancesAvail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RequestInsurancesAvail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentsInsurance" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentsInsurance" minOccurs="0"/>
 *         &lt;element name="RelPaxesDist" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_InsuranceRelPaxDist" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RequestInsurancesAvail", propOrder = {
    "searchSegmentsInsurance",
    "relPaxesDist"
})
public class JPRequestInsurancesAvail {

    @XmlElement(name = "SearchSegmentsInsurance")
    protected JPSearchSegmentsInsurance searchSegmentsInsurance;
    @XmlElement(name = "RelPaxesDist")
    protected ArrayOfJPInsuranceRelPaxDist relPaxesDist;

    /**
     * Gets the value of the searchSegmentsInsurance property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentsInsurance }
     *     
     */
    public JPSearchSegmentsInsurance getSearchSegmentsInsurance() {
        return searchSegmentsInsurance;
    }

    /**
     * Sets the value of the searchSegmentsInsurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentsInsurance }
     *     
     */
    public void setSearchSegmentsInsurance(JPSearchSegmentsInsurance value) {
        this.searchSegmentsInsurance = value;
    }

    /**
     * Gets the value of the relPaxesDist property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPInsuranceRelPaxDist }
     *     
     */
    public ArrayOfJPInsuranceRelPaxDist getRelPaxesDist() {
        return relPaxesDist;
    }

    /**
     * Sets the value of the relPaxesDist property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPInsuranceRelPaxDist }
     *     
     */
    public void setRelPaxesDist(ArrayOfJPInsuranceRelPaxDist value) {
        this.relPaxesDist = value;
    }

}
